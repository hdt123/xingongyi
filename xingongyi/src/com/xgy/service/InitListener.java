package com.xgy.service;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.web.context.ServletContextAware;

import com.xgy.dao.ProjectDao;
import com.xgy.entity.Project;

@Service
public class InitListener implements  InitializingBean, ServletContextAware{
	
	
	@Override
	public void setServletContext(ServletContext servletContext) {
		int sum = 0;
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		ProjectDao projectDao = (ProjectDao) ac.getBean("projectDao");
				
				
		List<Project> list_project = projectDao.listAllInit();
		for (int i = 0; i < list_project.size(); i++) {
			Project p = list_project.get(i);
			sum = p.getPariseNum()+sum;
			servletContext.setAttribute("project"+(i+1), p);
		}
		servletContext.setAttribute("sum", sum);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		
	}

}
