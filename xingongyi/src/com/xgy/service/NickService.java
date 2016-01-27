package com.xgy.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.xgy.dao.NickDao;
import com.xgy.entity.Nick;

@Transactional
@Service("nickService")
public class NickService {
	@Resource
	private NickDao nickDao;
	
	public void saveNick(Nick nick){
		nickDao.saveNick(nick);
	}
	/**
	 * 未处理益客申请记录
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public List<Nick> findAll(int page,int pageSize,String flag){
		int first = (page-1)*pageSize;
		return nickDao.findAll(first, pageSize, flag);
	}
	/**
	 * 总条数
	 * @param flag
	 * @return
	 */
	public int findTotal(String flag){
		return nickDao.findToal(flag);
	}
	/**
	 * 更改为同意申请
	 * @param nickId
	 */
	public void update(int nickId){
		Nick nick = nickDao.findNickById(nickId);
		nick.setFlag("T");
		nickDao.edit(nick);
	}
}
