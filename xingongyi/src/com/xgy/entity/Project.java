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
 *  项目实体类
 * @author 胡铎腾
 *
 */
@Entity
@Table(name = "project", catalog = "xgy")
public class Project implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer projectId;
	private String projectName;
	private String projectDesc;
	private Integer pariseNum;		//点赞数量
	private Integer projectNum;		//项目编号
	private Integer needNum;		//项目需要赞的数量
	private Integer shareNum;       //传播人数
	private Set<Parise> parises = new HashSet<Parise>(0);      //点赞集合


	public Project() {
	}

	public Project(Integer projectNum) {
		this.projectNum = projectNum;
	}

	public Project(String projectName, String projectDesc, Integer pariseNum,
			Integer projectNum, Set<Parise> parises,int needNum,int shareNum) {
		this.projectName = projectName;
		this.projectDesc = projectDesc;
		this.pariseNum = pariseNum;
		this.projectNum = projectNum;
		this.parises = parises;
		this.needNum = needNum;
		this.shareNum = shareNum;
	}

	@Id
	@GeneratedValue
	@Column(name = "projectId", unique = true, nullable = false)
	public Integer getProjectId() {
		return this.projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	@Column(name = "projectName")
	public String getProjectName() {
		return this.projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	@Column(name = "projectDesc")
	public String getProjectDesc() {
		return this.projectDesc;
	}

	public void setProjectDesc(String projectDesc) {
		this.projectDesc = projectDesc;
	}

	@Column(name = "pariseNum")
	public Integer getPariseNum() {
		return this.pariseNum;
	}

	public void setPariseNum(Integer pariseNum) {
		this.pariseNum = pariseNum;
	}

	@Column(name = "projectNum", nullable = false)
	public Integer getProjectNum() {
		return this.projectNum;
	}

	public void setProjectNum(Integer projectNum) {
		this.projectNum = projectNum;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "project")
	public Set<Parise> getParises() {
		return this.parises;
	}

	public void setParises(Set<Parise> parises) {
		this.parises = parises;
	}

	@Column(name = "needNum")
	public Integer getNeedNum() {
		return needNum;
	}

	public void setNeedNum(Integer needNum) {
		this.needNum = needNum;
	}

	@Column(name = "shareNum")
	public Integer getShareNum() {
		return shareNum;
	}

	public void setShareNum(Integer shareNum) {
		this.shareNum = shareNum;
	}
	
	
	

}