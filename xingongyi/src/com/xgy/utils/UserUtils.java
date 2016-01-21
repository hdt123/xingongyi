package com.xgy.utils;


import java.util.Date;



import com.xgy.entity.dto.TicketDto;
import com.xgy.entity.dto.TokenDto;
import com.xgy.entity.dto.TokenDtoUnionId;
import com.xgy.entity.dto.UserDto;

public class UserUtils {

	public  static TokenDto getToken(String code){
		
		String json = "";
		String get_access_token_url = UrlString.get_access_token_url.replace("CODE", code); //构建获取access_token的url
		json = HttpUtils.getUrl(get_access_token_url);       //发送请求，返回json数据
		TokenDto tokenDto = JsonUtils.json2Obj(json, TokenDto.class);   //解析json对象获取openId,access_token
		return tokenDto;
	}
	
	public static UserDto getUserInfo(TokenDto tokenDto){

		String url = UrlString.get_userinfo.replace("ACCESS_TOKEN", tokenDto.getAccess_token());     //构建获取用户信息的Url
		url = url.replace("OPENID", tokenDto.getOpenid());
		String json = HttpUtils.getSend(url); 			   //发送请求，返回json数据
		UserDto userDto = JsonUtils.json2Obj(json, UserDto.class);      //解析Json获取用户信息
		return userDto;
	}
	
	/**
	 * 获取accessToken
	 * @return
	 */
	public static TokenDtoUnionId getAccessToken(){
		System.out.println("获取新的AccessToken");
		String json = HttpUtils.getSend(UrlString.get_token);
		System.out.println("accessJson:"+json);
		TokenDtoUnionId dtoUnionId = JsonUtils.json2Obj(json, TokenDtoUnionId.class);
		
		return dtoUnionId;
		
	}

	/**
	 * 获取签名
	 * @return
	 */
	public static String getTicket(String access_token){
		
		if(access_token!=null){
			
			String url = UrlString.get_ticket.replace("ACCESS_TOKEN", access_token);
			
			String json = HttpUtils.getSend(url);
			
			TicketDto ticketDto = JsonUtils.json2Obj(json, TicketDto.class);
			System.out.println("accessToken:"+access_token);
			System.out.println("getTicketJson:"+json);
			if(ticketDto!=null&&ticketDto.getTicket()!=null)
				return ticketDto.getTicket();
		}
		
		return null;
	}
	
	

}
