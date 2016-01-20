package com.xgy.utils;

public class UrlString {

	private static String url = "http://dev.ydcycloud.net/dice/diceAction_diceGame.action?code=CODE&state=STATE";
	
	public static final String appId = "wx97c624858e7a37d8";
	
	public static final String appSecret = "edbc4b29dd8e31d4d84facd278d4cce3";
	
	public static String get_token = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="
			+ appId+"&secret="+appSecret;
	
	public static String get_user_union = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
	
	public static String get_access_token_url = "https://api.weixin.qq.com/sns/oauth2/access_token?"
			+ "appid="+appId
			+ "&secret="+appSecret+"&code=CODE&grant_type=authorization_code";
	
	public static String get_userinfo = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";

	public static String refresh_access_token = "https://api.weixin.qq.com/sns/oauth2/refresh_token?appid=APPID&grant_type=refresh_token&refresh_token=REFRESH_TOKEN";

	public static String check_access_token = "https://api.weixin.qq.com/sns/auth?access_token=ACCESS_TOKEN&openid=OPENID";
	
	public static String get_ticket = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=ACCESS_TOKEN&type=jsapi";
}
