package com.xgy.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xgy.dao.PraiseDao;
import com.xgy.dao.ProjectDao;
import com.xgy.dao.UserDao;
import com.xgy.entity.Parise;
import com.xgy.entity.Project;
import com.xgy.entity.User;
import com.xgy.entity.dto.TokenDto;
import com.xgy.entity.dto.UserDto;
import com.xgy.utils.DateUtils;
import com.xgy.utils.EmojiFilter;
import com.xgy.utils.UserUtils;

@Transactional
@Service("userService")
public class UserService {

	private String hql = "";
	@Resource
	private UserDao userDao;
	
	@Resource
	private ProjectDao projectDao;
	
	@Resource
	private PraiseDao praiseDao;
	
	public boolean saveUser(User user){
		userDao.saveUser(user);
		return false;
		
	}
	
	/**
	 *  根据code获取用户信息
	 *  1.根据code获取access_token和用户openId
	 *  2.根据access_token 和openId获取用户信息
	 *  3.将用户信息存到数据库
	 * @param code
	 */
	public User getUserInfo(String code){
		
		TokenDto tokenDto = UserUtils.getToken(code);
		
		if(tokenDto==null || tokenDto.getAccess_token()==null)
			return null;
		UserDto userDto = UserUtils.getUserInfo(tokenDto);
		if(userDto==null||userDto.getOpenid()==null)
			return null;
		
		hql = "from User u where u.openId='"+userDto.getOpenid()+"'";
		
		List<User> list_user = userDao.queryByHql(hql);
		if(list_user!=null&&list_user.size()!=0){
			User u = list_user.get(0);
			u.setNickName(EmojiFilter.filterEmoji(userDto.getNickname()));
			u.setCountry(userDto.getCountry());
			u.setGender((short)userDto.getSex());
			u.setHeadImageUrl(userDto.getHeadimgurl());
			userDao.update(u);
			return u;
		}else{
			User user = new User(EmojiFilter.filterEmoji(userDto.getNickname()),userDto.getOpenid(),
					(short)userDto.getSex(), userDto.getCountry(), userDto.getHeadimgurl(),0, 0, null);
			userDao.saveUser(user);
			return user;
		}
	}
	
	/**
	 * 用户祈福
	 * @param userId
	 * @param projectId
	 * @return
	 */
	public Project userPray(int userId,int projectId){
		
		try {
			User user = userDao.queryByUserId(userId);
			Project project = projectDao.queryByProjectId(projectId);
			project.setPariseNum(project.getPariseNum()+1);
			Parise parise = new Parise(project, user, DateUtils.date2String(new Date()));
			user.setGoodNum(user.getGoodNum()+1);
			userDao.update(user);
			praiseDao.savePraise(parise);
			projectDao.updateProject(project);
			return project;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		
	}
	
	public Project shareProject(int userId,int projectId){
		
		try {
			User user = userDao.queryByUserId(userId);
			Project project = projectDao.queryByProjectId(projectId);
			user.setShareNum(user.getShareNum()+1);
			project.setShareNum(project.getShareNum()+1);
			
			projectDao.updateProject(project);
			userDao.update(user);
			return project;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return null;
		}
		
		
	}

	/**
	 * 判断userId用户是否对projectId项目祈福过
	 * @param userId
	 * @param projectId
	 * @return
	 */
	public boolean checkPray(Integer userId, int projectId) {
		String hql = "from User as u left join fetch u.parises where u.userId="+userId;
		List<User> listUser = userDao.queryByHql(hql);
		if(listUser!=null&&listUser.get(0)!=null){
			User u = listUser.get(0);
			if(u.getParises()!=null){
				List<Parise> listParise = new ArrayList<Parise>(u.getParises());
				for(int i = 0; i < listParise.size();i++){
					if(listParise.get(i).getProject().getProjectId() == projectId)
						return false;
				}
			}
			else{
				return true;
			}
		}
		
		return true;
	}
	
}
