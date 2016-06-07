// default package

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * NoticeManager entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "notice_manager", catalog = "dinnersystem")
public class NoticeManager implements java.io.Serializable {

	// Fields

	private Integer id;
	private Notice notice;
	private Manager manager;
	private Timestamp createDate;
	private Timestamp lastModifyDate;
	private String createBy;
	private Integer status;

	// Constructors

	/** default constructor */
	public NoticeManager() {
	}

	/** minimal constructor */
	public NoticeManager(Integer id, Notice notice, Manager manager) {
		this.id = id;
		this.notice = notice;
		this.manager = manager;
	}

	/** full constructor */
	public NoticeManager(Integer id, Notice notice, Manager manager,
			Timestamp createDate, Timestamp lastModifyDate, String createBy,
			Integer status) {
		this.id = id;
		this.notice = notice;
		this.manager = manager;
		this.createDate = createDate;
		this.lastModifyDate = lastModifyDate;
		this.createBy = createBy;
		this.status = status;
	}

	// Property accessors
	@Id
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "noticeId", nullable = false)
	public Notice getNotice() {
		return this.notice;
	}

	public void setNotice(Notice notice) {
		this.notice = notice;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "managerId", nullable = false)
	public Manager getManager() {
		return this.manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	@Column(name = "createDate", length = 19)
	public Timestamp getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	@Column(name = "lastModifyDate", length = 19)
	public Timestamp getLastModifyDate() {
		return this.lastModifyDate;
	}

	public void setLastModifyDate(Timestamp lastModifyDate) {
		this.lastModifyDate = lastModifyDate;
	}

	@Column(name = "createBy", length = 64)
	public String getCreateBy() {
		return this.createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	@Column(name = "status")
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}