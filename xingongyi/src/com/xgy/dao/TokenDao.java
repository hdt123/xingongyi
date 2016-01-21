package com.xgy.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.xgy.entity.Token;

@Repository
public class TokenDao {

	@Resource
	private SessionFactory sessionFactory;
	
	
	public List<Token> getTokenByHql(String hql){
		
		return sessionFactory.getCurrentSession().createQuery(hql).list();
	}
	
	public void updateToken(Token token){
		
		sessionFactory.getCurrentSession().update(token);
	}
	
	public void save(){
		
		
	}
}
