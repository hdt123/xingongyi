package com.xgy.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Nick implements Serializable{
	
	/**
	 * 益客
	 */
	private static final long serialVersionUID = 1L;
	private int nickId;
	private String realName;//姓名
	private String idcard;//身份证
	private String cellphone;//手机号码
	private Timestamp registerTime;//注册时间
	private String flag;
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public Timestamp getRegisterTime() {
		return registerTime;
	}
	public void setRegisterTime(Timestamp registerTime) {
		this.registerTime = registerTime;
	}
	@Id
	@GeneratedValue
	public int getNickId() {
		return nickId;
	}
	public void setNickId(int nickId) {
		this.nickId = nickId;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public String getCellphone() {
		return cellphone;
	}
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

}
