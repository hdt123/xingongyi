package com.xgy.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.xgy.entity.Nick;

@Repository("nickDao")
public class NickDao {
	@Resource
	private SessionFactory sessionFactory;
	/**
	 * 保存益客到数据库
	 * @param nick
	 */
	public void saveNick(Nick nick){
		sessionFactory.getCurrentSession().save(nick);
	}
	/**
	 * 分页查找所有
	 * @param first
	 * @param max
	 * @return
	 */
	public List<Nick> findAll(int first,int max,String flag){
		List<Nick> list = new ArrayList<Nick>();
		Query query = sessionFactory.getCurrentSession().createQuery("from Nick where flag='"+flag+"'");
		query.setFirstResult(first);
		query.setMaxResults(max);
		list = query.list();
		return list;
	}
	/**
	 *所有记录总数
	 * @return
	 */
	public int findToal(String flag){
		Query query =sessionFactory.getCurrentSession().createQuery("from Nick where flag='"+flag+"'");
		return query.list().size();
	}
	public void edit(Nick nick){
		sessionFactory.getCurrentSession().update(nick);
	}
	public Nick findNickById(int nickId){
		Nick nick = (Nick)sessionFactory.getCurrentSession().get(Nick.class,nickId);
		return nick;
	}
}
