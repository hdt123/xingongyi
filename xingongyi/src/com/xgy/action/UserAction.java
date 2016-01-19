package com.xgy.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.xgy.entity.User;
import com.xgy.service.UserService;

@Action(value="userAction",results={@Result(name="test",location="/index.jsp")})
public class UserAction extends BaseAction<User>{
	
	@Autowired
	private UserService userService;
	
	@Action(value="test")
	public String test(){
		
		return "test";
	}

	@Action(value="save")
	public String save(){
		
		System.out.println(model.getNickName());
		userService.saveUser(model);
		return "test";
	}
}
