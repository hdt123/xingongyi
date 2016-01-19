package com.xgy.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xgy.action.UserAction;
import com.xgy.entity.User;
import com.xgy.service.UserService;

public class Test {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		/*UserService userService = (UserService)ac.getBean("userService");
		userService.saveUser(new User("123", "456", (short)0, "123", "456", null, null, null));*/
		
		UserAction userAction = (UserAction) ac.getBean("userAction");
		userAction.save();
	}
}
