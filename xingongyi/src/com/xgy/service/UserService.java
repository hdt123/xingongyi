package com.xgy.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xgy.dao.UserDao;
import com.xgy.entity.User;

@Transactional
@Service("userService")
public class UserService {

	@Resource
	private UserDao userDao;
	
	public boolean saveUser(User user){
		userDao.saveUser(user);
		return false;
		
	}
}
