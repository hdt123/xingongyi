package com.xgy.dao;

import java.util.List;

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
	
	public void update(User user){
		user = (User) sessionFactory.getCurrentSession().merge(user);
		sessionFactory.getCurrentSession().update(user);
	}
	
	public List<User> queryByHql(String hql){
		
		return sessionFactory.getCurrentSession().createQuery(hql).list();
	}
	
	public User queryByUserId(int userId){
		
		User user = (User) sessionFactory.getCurrentSession().get(User.class, userId);
		return user;
	}
}
