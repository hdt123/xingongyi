package com.xgy.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.xgy.entity.Project;

@Repository("projectDao")
public class ProjectDao {

	@Resource
	private SessionFactory sessionFactory;
	
	public List<Project> ListAllProject(){
		
		return sessionFactory.getCurrentSession().createQuery("from Project").list();
	}
	
	/**
	 * 程序启动的时候启动
	 * @return
	 */
	public List<Project> listAllInit(){
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		SessionFactory sf = (SessionFactory) ac.getBean("sessionFactory");
		Session session = sf.openSession();
		List<Project> list_project = session.createQuery("from Project").list();
		
		session.flush();
		session.close();
		
		return list_project;
	}
	
	public Project queryByProjectId(int projectId){
		
		Project project = (Project) sessionFactory.getCurrentSession().get(Project.class, projectId);
		return project;
		
	}
	
	public void updateProject(Project project){
		project = (Project) sessionFactory.getCurrentSession().merge(project);
		sessionFactory.getCurrentSession().update(project);
	}
}
