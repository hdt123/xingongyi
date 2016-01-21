package com.xgy.utils;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xgy.action.UserAction;
import com.xgy.dao.UserDao;
import com.xgy.entity.User;
import com.xgy.entity.dto.TokenDto;
import com.xgy.entity.dto.UserDto;
import com.xgy.service.UserService;

public class Test {

	public static void main(String[] args) {
		/*TokenDto tokenDto = JsonUtils.json2Obj('{'access_token':'OezXcEiiBSKSxW0eoylIeNG8gEricf4EvArNtDCNMYYId7MdQioP_6_D0SqYUP60I0US7soSvCkRjrWwIfl4VQ212sYyF19gAZBIQFD-PLYpZkAc3pmT6P2LqMbRcyRxf1T70LVZkgy4vQ3sp00U1w','expires_in':7200,'refresh_token':'OezXcEiiBSKSxW0eoylIeNG8gEricf4EvArNtDCNMYYId7MdQioP_6_D0SqYUP60sib4xXz2KShdpq3BYBGX8qB9sz77TLX7zZyaJ10uokVT55ANfCL7-qsAI7Vb7HEB38mb7yACUEu1fQU5XYvzIg','openid':'oRMV0t-p1PJPXCgQMERSw_FS8m3c','scope':'snsapi_base'}',TokenDto.class);
		System.out.println(tokenDto.getAccess_token());
		UserUtils.getUserInfo(tokenDto);*/
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		UserService userService = (UserService) ac.getBean("userService");
		
		System.out.println(userService.checkPray(1, 1));
		
		/*UserDao userDao = (UserDao)ac.getBean("userDao");
		SessionFactory sessionFactory = (SessionFactory) ac.getBean("sessionFactory");
		Session session = sessionFactory.openSession();
		String json = "{'openid':'oRMV0t-p1PJPXCgQMERSw_FS8m3c','nickname':'腾','sex':1,'language':'zh_CN','city':'','province':'','country':'中国','headimgurl':'http:wx.qlogo.cn.mmopen.UIsKXicKRWylBGWbGHfj5icxmyUFH3OIYYjKQc7sh4icF6KiaAJFWv3hmnYK2HklxFTd4Ax6icLib8ICJUvIEZeiaavE4SXOtvm6Oib5.0','privilege':[]}";
		UserDto userDto = JsonUtils.json2Obj(json, UserDto.class);
		
		String hql = "from User u where u.openId='"+userDto.getOpenid()+"'";
		session.beginTransaction();
		List<User> list_user  = session.createQuery(hql).list();
		session.getTransaction().commit();
		session.close();
		list_user = userDao.queryByHql(hql);
		User user = new User(EmojiFilter.filterEmoji(userDto.getNickname()),userDto.getOpenid(),
				(short)userDto.getSex(), userDto.getCountry(), userDto.getHeadimgurl(),0, 0, null);
		userDao.saveUser(user);*/
		/*UserAction userAction = (UserAction) ac.getBean('userAction');
		userAction.save();*/
		
		System.out.println(getTimeStamp()-7200);
	}
	
	/**
	 * 获取当前时间戳
	 * @return
	 */
	public static long getTimeStamp(){
		
		Date dates = new Date();
        
        long s=dates.getTime();
		
		return s/1000;
	}
}
