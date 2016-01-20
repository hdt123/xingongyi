package com.xgy.dao;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import com.xgy.entity.Parise;

@Service
public class PraiseDao {

	@Resource
	private SessionFactory sessionFactory;
	
	public void savePraise(Parise p){
		
		sessionFactory.getCurrentSession().save(p);
		
	}
}
