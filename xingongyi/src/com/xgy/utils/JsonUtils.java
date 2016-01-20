package com.xgy.utils;

import java.util.Map;


import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class JsonUtils {
	
	private static Gson gson = new Gson();
	
	public static<T> T json2Obj(String json, Class<T> cls){
		System.out.println(json);
		T t = null;
	    try {
			Gson gson = new Gson();
			t = gson.fromJson(json, cls);
		} catch (JsonSyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		return t;
	}
	
	public static String map2Json(Map<String,Object> map){
		
		Gson gson = new Gson();
		return gson.toJson(map);
	}
	
	public static void main(String[] args) {
		
		String str = "{'openid':'o31m-s8yDAjrBS6RVxr1hJSqMrMk','nickname':'中国','sex':1,'language':'zh_CN','city':'','province':'','country':'这是','headimgurl':'http://wx.qlogo.cn/mmopen/UU8dERVsFtaib5sutMz9TAgVVvibPnf6B1UEwRFufcBYeHYRCVj2sqkc2fSMJibZnwJqMab198nWOQCYWoHCxFFmcX0JulF0K6w/0','privilege':[]}";

/*		
		String s = "'{'access_token':'ACCESS_TOKEN','
				+ ''expires_in':7200,'
				+ ' 'refresh_token':'REFRESH_TOKEN','
				+ ''openid':'OPENID','
				+ ''scope':'SCOPE','
				+ ''unionid': 'o6_bmasdasdsad6_2sgVt7hMZOPfL'}'";
*/	
		
	/*	System.out.println(tokenDto.getCountry());*/
		
		
	}

}
