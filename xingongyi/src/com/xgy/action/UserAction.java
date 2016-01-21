package com.xgy.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.xgy.entity.Project;
import com.xgy.entity.User;
import com.xgy.entity.dto.TokenDtoUnionId;
import com.xgy.service.UserService;
import com.xgy.utils.DateUtils;
import com.xgy.utils.GenerateSignature;
import com.xgy.utils.JsonUtils;
import com.xgy.utils.UrlString;
import com.xgy.utils.UserUtils;

@Action(value="userAction",
		results={@Result(name="toIndex",location="/web/index.jsp"),
				 @Result(name="toIndex_error",type="redirect",location="/web/index.jsp"),
				 @Result(name="wechatGrant",type="redirect",location="https://open.weixin.qq.com/connect/oauth2/authorize?"
				 		+ "appid=wx97c624858e7a37d8&redirect_uri=http%3a%2f%2fdev.ydcycloud.net%2Fxingongyi%2FuserAction!toIndex.action&"
				 		+ "response_type=code&scope=snsapi_userinfo&state=STATE&connect_redirect=1#wechat_redirect"),
				 @Result(name="toPray",location="/web/desc.jsp")
				 })
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
		String url = "http://dev.ydcycloud.net/xingongyi/userAction!toIndex.action?code="+code+"&state=STATE";
		System.out.println("code:"+code);
		if(code==null)
			return "toIndex_error";
		
		User user = userService.getUserInfo(code);
		if(user==null)
			return "toIndex_error";
		String accessToken = getAccessToken();
		setSignatureToSession(url,"toIndex",accessToken);
		request.getSession().setAttribute("user", user);
		
		return "toIndex";
	}
	
	public String toPray(){
		String url = "http://dev.ydcycloud.net/xingongyi/userAction!toPray.action?userId="+model.getUserId()+"&&projectId="+projectId;
		if(model.getUserId()==null||request.getSession().getAttribute("user")==null){
			return "wechatGrant";
		}
		
		boolean state = userService.checkPray(model.getUserId(),projectId);
		
		String accessToken = getAccessToken();
		setSignatureToSession(url,"toPray",accessToken);
		request.setAttribute("projectId", projectId);
		request.setAttribute("state", state);
		return "toPray";
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
	
	/**
	 * 生成签名并放在session里
	 * 
	 * @param url
	 * @param state
	 * @param accessToken
	 */
	public void setSignatureToSession(String url,String state,String accessToken){
		
		System.out.println(url);
		String signature = (String) request.getSession().getAttribute("signature"+state);
		String timestamp = (String) request.getSession().getAttribute("timestamp"+state);
		String nonceStr = (String) request.getSession().getAttribute("nonceStr"+state);
		String ticket = (String) request.getSession().getAttribute("ticket"+state);
		
		if(ticket==null){
			System.out.println("ticket is null");
			ticket = UserUtils.getTicket(accessToken);
			if(ticket==null){
				servletContext.removeAttribute("expires_in");
				servletContext.removeAttribute("access_token");
				String access_token = getAccessToken();
				ticket = UserUtils.getTicket(access_token);
			}
			request.getSession().setAttribute("ticket"+state, ticket);
		}
	
		Map<String,Object> maps = GenerateSignature.getSignature(ticket, url);
		nonceStr = (String) maps.get("nonceStr");
		signature = (String) maps.get("signature");
		timestamp = (String)maps.get("timestamp");
		
		request.getSession().setAttribute("appId", UrlString.appId);
		request.getSession().setAttribute("timestamp"+state, timestamp);
		request.getSession().setAttribute("signature"+state, signature);
		request.getSession().setAttribute("nonceStr"+state, nonceStr);
		
	}
	
	/**
	 * 获取access_token
	 * @return
	 */
	public String getAccessToken(){
		TokenDtoUnionId dtoUnionId = null ;
		String access_token = (String) servletContext.getAttribute("access_token");
		Long createDate = (Long) servletContext.getAttribute("createDate");
		Integer expires_in = (Integer) servletContext.getAttribute("expires_in");
		
		if(createDate==null||expires_in==null||access_token==null){
			System.out.println("accessToken为空的！");
			dtoUnionId =   UserUtils.getAccessToken();
			servletContext.setAttribute("access_token", dtoUnionId.getAccess_token());
			servletContext.setAttribute("createDate", DateUtils.getTimeStamp());
			servletContext.setAttribute("expires_in", dtoUnionId.getExpires_in());
		}
		
		else{ 
			
			long nowStamp = DateUtils.getTimeStamp();
			long l = nowStamp - createDate;
			
			System.out.println("时间是："+l);
			if(l>(expires_in-1000)){
				System.out.println("accessToken已过期！");
				dtoUnionId =   UserUtils.getAccessToken();
				servletContext.setAttribute("access_token", dtoUnionId.getAccess_token());
				servletContext.setAttribute("createDate", DateUtils.getTimeStamp());
				servletContext.setAttribute("expires_in", dtoUnionId.getExpires_in());
			}
			
			
		}
		
		return dtoUnionId==null?access_token:dtoUnionId.getAccess_token();
	}
	
}
