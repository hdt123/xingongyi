package com.xgy.service;

import java.util.List;
import java.util.Timer;

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
	
	private static int servletContextTimer = 60*1000;
	private static int dataBaseTimer = 12*60*60*1000	;
	
	@Override
	public void setServletContext(ServletContext servletContext) {
		int sum = 0;
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		ProjectDao projectDao = (ProjectDao) ac.getBean("projectDao");
//		ProjectDao1 projectDao1 = (ProjectDao1) ac.getBean("projectDao1");
		
		
//		projectDao1.t();
		List<Project> list_project = projectDao.listAllInit();
		for (int i = 0; i < list_project.size(); i++) {
			Project p = list_project.get(i);
			sum = p.getPariseNum()+sum+p.getShareNum();
			servletContext.setAttribute("project"+(i+1), p);
		}
		servletContext.setAttribute("sum", sum);
		ServletTimerService timerTask = new ServletTimerService();
		DataTimerService dataTimerService = new  DataTimerService();
		
//		Timer timer = new Timer();
//		timerTask.setServletContext(servletContext);
//		timerTask.setProjectNum(list_project.size());
//		timer.schedule(timerTask, 1000,1000);
		
		Timer t = new Timer();
		dataTimerService.setProjectDao(projectDao);
		dataTimerService.setProjectNum(list_project.size());
		dataTimerService.setServletContext(servletContext);
//		t.schedule(dataTimerService, 1000,10000);
		
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		
	}

}
