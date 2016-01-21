package com.xgy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "token", catalog = "xgy")
public class Token {

	private int id;
	
	private String accessToken;
	
	private String createDate;

	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	@Column(name = "accessToken", nullable = false)
	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	
	@Column(name = "createDate", nullable = false)
	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	
	
}
