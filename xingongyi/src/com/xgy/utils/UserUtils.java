package com.xgy.utils;

import com.xgy.entity.dto.TokenDto;
import com.xgy.entity.dto.UserDto;

public class UserUtils {

	public  static TokenDto getToken(String code){
		
		String json = "";
		String get_access_token_url = UrlString.get_access_token_url.replace("CODE", code); //构建获取access_token的url
		json = HttpUtils.getUrl(get_access_token_url);       //发送请求，返回json数据
		System.out.println("获取access_token，json:"+json);
		TokenDto tokenDto = JsonUtils.json2Obj(json, TokenDto.class);   //解析json对象获取openId,access_token
		return tokenDto;
	}
	
	public static UserDto getUserInfo(TokenDto tokenDto){

		String url = UrlString.get_userinfo.replace("ACCESS_TOKEN", tokenDto.getAccess_token());     //构建获取用户信息的Url
		url = url.replace("OPENID", tokenDto.getOpenid());
		System.out.println("get_USERINFOURL==="+url);
		String json = HttpUtils.getSend(url); 			   //发送请求，返回json数据
		System.out.println("获取用户信息，json:"+json);
		UserDto userDto = JsonUtils.json2Obj(json, UserDto.class);      //解析Json获取用户信息
		return userDto;
	}
}
