package com.xgy.dao;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.xgy.entity.User;

@Repository("userDao")
public class UserDao {

	@Resource
	private SessionFactory sessionFactory;
	
	public void saveUser(User user){
		sessionFactory.getCurrentSession().save(user);
	}
}
