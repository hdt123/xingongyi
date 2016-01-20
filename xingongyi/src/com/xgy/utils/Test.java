package com.xgy.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xgy.action.UserAction;
import com.xgy.entity.User;
import com.xgy.entity.dto.TokenDto;
import com.xgy.service.UserService;

public class Test {

	public static void main(String[] args) {
		/*TokenDto tokenDto = JsonUtils.json2Obj("{'access_token':'OezXcEiiBSKSxW0eoylIeNG8gEricf4EvArNtDCNMYYId7MdQioP_6_D0SqYUP60I0US7soSvCkRjrWwIfl4VQ212sYyF19gAZBIQFD-PLYpZkAc3pmT6P2LqMbRcyRxf1T70LVZkgy4vQ3sp00U1w','expires_in':7200,'refresh_token':'OezXcEiiBSKSxW0eoylIeNG8gEricf4EvArNtDCNMYYId7MdQioP_6_D0SqYUP60sib4xXz2KShdpq3BYBGX8qB9sz77TLX7zZyaJ10uokVT55ANfCL7-qsAI7Vb7HEB38mb7yACUEu1fQU5XYvzIg','openid':'oRMV0t-p1PJPXCgQMERSw_FS8m3c','scope':'snsapi_base'}",TokenDto.class);
		System.out.println(tokenDto.getAccess_token());
		UserUtils.getUserInfo(tokenDto);*/
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService userService = (UserService)ac.getBean("userService");
		userService.getUserInfo("0014a716bd1607e484073229efcbc15O");
		
		/*UserAction userAction = (UserAction) ac.getBean("userAction");
		userAction.save();*/
	}
}
