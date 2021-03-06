package com.xgy.entity.dto;

import java.util.List;

import com.xgy.entity.User;


public class UserDto {

	private int userId;
	
	private String openid;//用户的唯一标识 
	
	private String nickname ;// 用户昵称 
	
	private int sex;  // 用户的性别，值为1时是男性，值为2时是女性，值为0时是未知 

	private String province;//用户个人资料填写的省份 
	
	private String country ;//国家，如中国为CN 
	
	private String headimgurl ; 	//用户头像，最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像），
									//用户没有头像时该项为空。若用户更换头像，原有头像URL将失效。 
	
	private List<String> privilege ; // 	用户特权信息，json 数组，如微信沃卡用户为（chinaunicom） 
	
	private String unionid ;// 	只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段。详见：获取用户个人信息（UnionID机制）

	private Float points;
	
	public UserDto(){}
	
	public UserDto(User user){
		this.country = user.getCountry();
		this.headimgurl = user.getHeadImageUrl();
		this.nickname = user.getNickName();
		this.openid = user.getOpenId();
		this.sex = user.getGender();
		this.userId = user.getUserId();
	}
	
	
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}


	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getHeadimgurl() {
		return headimgurl;
	}

	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
	}

	public List<String> getPrivilege() {
		return privilege;
	}

	public void setPrivilege(List<String> privilege) {
		this.privilege = privilege;
	}

	public String getUnionid() {
		return unionid;
	}

	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}

	public Float getPoints() {
		return points;
	}

	public void setPoints(Float points) {
		this.points = points;
	}
	
	
}
