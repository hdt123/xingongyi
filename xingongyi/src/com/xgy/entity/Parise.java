package com.xgy.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;


import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *  点赞实体类
 * @author 胡铎腾
 *
 */
@Entity
@Table(name = "parise", catalog = "xgy")
public class Parise implements Serializable {


	private static final long serialVersionUID = 1L;
	private Integer praiseId;
	private Project project;
	private User user;
	private String praiseDate;   //点赞日期


	public Parise() {
	}

	public Parise(Project project, User user) {
		this.project = project;
		this.user = user;
	}

	public Parise(Project project, User user, String praiseDate) {
		this.project = project;
		this.user = user;
		this.praiseDate = praiseDate;
	}

	@Id
	@GeneratedValue
	@Column(name = "praiseId", unique = true, nullable = false)
	public Integer getPraiseId() {
		return this.praiseId;
	}

	public void setPraiseId(Integer praiseId) {
		this.praiseId = praiseId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "projectId", nullable = false)
	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userId", nullable = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "praiseDate")
	public String getPraiseDate() {
		return this.praiseDate;
	}

	public void setPraiseDate(String praiseDate) {
		this.praiseDate = praiseDate;
	}

}