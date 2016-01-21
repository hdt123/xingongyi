package com.xgy.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *	用户实体类
 * @author 胡铎腾
 *
 */
@Entity
@Table(name = "user", catalog = "xgy")
public class User implements Serializable {

	
	private static final long serialVersionUID = 1L;

	private Integer userId;
	private String nickName;		//昵称
	private String openId;			//openId
	private Short gender;			
	private String country;			
	private String headImageUrl;   //用户头像地址
	private Integer goodNum;		//点赞数量
	private Integer shareNum;		//分享次数
	private Set<Parise> parises = new HashSet<Parise>(0);      //用户点赞集合


	public User() {
	}

	public User(String nickName, String openId) {
		this.nickName = nickName;
		this.openId = openId;
	}

	public User(String nickName, String openId, Short gender, String country,
			String headImageUrl, Integer goodNum, Integer shareNum,
			Set<Parise> parises) {
		this.nickName = nickName;
		this.openId = openId;
		this.gender = gender;
		this.country = country;
		this.headImageUrl = headImageUrl;
		this.goodNum = goodNum;
		this.shareNum = shareNum;
		this.parises = parises;
	}

	@Id
	@GeneratedValue
	@Column(name = "userId", unique = true, nullable = false)
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "nickName")
	public String getNickName() {
		return this.nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	@Column(name = "openId", nullable = false)
	public String getOpenId() {
		return this.openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	@Column(name = "gender")
	public Short getGender() {
		return this.gender;
	}

	public void setGender(Short gender) {
		this.gender = gender;
	}

	@Column(name = "country")
	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Column(name = "headImageUrl")
	public String getHeadImageUrl() {
		return this.headImageUrl;
	}

	public void setHeadImageUrl(String headImageUrl) {
		this.headImageUrl = headImageUrl;
	}

	@Column(name = "goodNum")
	public Integer getGoodNum() {
		return this.goodNum;
	}

	public void setGoodNum(Integer goodNum) {
		this.goodNum = goodNum;
	}

	@Column(name = "shareNum")
	public Integer getShareNum() {
		return this.shareNum;
	}

	public void setShareNum(Integer shareNum) {
		this.shareNum = shareNum;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Parise> getParises() {
		return this.parises;
	}

	public void setParises(Set<Parise> parises) {
		this.parises = parises;
	}

}