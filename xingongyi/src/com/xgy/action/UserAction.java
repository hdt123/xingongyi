package com.xgy.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.xgy.entity.Project;
import com.xgy.entity.User;
import com.xgy.service.UserService;
import com.xgy.utils.JsonUtils;

@Action(value="userAction",
		results={@Result(name="toIndex",location="/web/index.jsp"),
				 @Result(name="toIndex_error",location="/web/index.jsp")})
public class UserAction extends BaseAction<User>{
	
	private String code;
	
	private int projectId;
	
	private Map<String,Object> map;
	
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

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
	
	@Action(value="toIndex")
	public String toIndex(){
		
		System.out.println("code:"+code);
		if(code==null)
			return "toIndex_error";
		else{
			User user = userService.getUserInfo(code);
			if(user==null){
				return "toIndex_error";
			}
			request.setAttribute("user", user);
		}
		return "toIndex";
	}
	
	@Action(value="pray")
	public String pray(){
		
		System.out.println(model.getUserId()+"===="+projectId);
		map = new HashMap<String,Object>();
		
		Project p = userService.userPray(model.getUserId(),projectId );
		if(p!=null){
			servletContext.setAttribute("project"+projectId, p);
			int sum = (Integer)servletContext.getAttribute("sum");
			servletContext.setAttribute("sum", sum+1);
			map.put("status", 0);
		}else{
			map.put("status", -1);
		}
		outJsonString(JsonUtils.map2Json(map));
		
		return null;
	}
	
	/**
	 * 分享给朋友后的回调
	 * @return
	 */
	@Action(value="share")
	public String share(){
		
		System.out.println(model.getUserId()+"==="+projectId);
		Project p = userService.shareProject(model.getUserId(), projectId);
		if(p!=null){
			servletContext.setAttribute("project"+projectId, p);
			map.put("status", 0);
		}else{
			map.put("status", -1);
		}
		return null;
	}
	
}
