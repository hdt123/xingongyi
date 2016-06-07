// default package

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Notice entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "notice", catalog = "dinnersystem")
public class Notice implements java.io.Serializable {

	// Fields

	private Integer id;
	private String noticeContent;
	private String title;
	private Timestamp createDate;
	private Timestamp lastModifyDate;
	private String createBy;
	private Integer type;
	private Set<NoticeManager> noticeManagers = new HashSet<NoticeManager>(0);

	// Constructors

	/** default constructor */
	public Notice() {
	}

	/** minimal constructor */
	public Notice(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Notice(Integer id, String noticeContent, String title,
			Timestamp createDate, Timestamp lastModifyDate, String createBy,
			Integer type, Set<NoticeManager> noticeManagers) {
		this.id = id;
		this.noticeContent = noticeContent;
		this.title = title;
		this.createDate = createDate;
		this.lastModifyDate = lastModifyDate;
		this.createBy = createBy;
		this.type = type;
		this.noticeManagers = noticeManagers;
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

	@Column(name = "noticeContent", length = 512)
	public String getNoticeContent() {
		return this.noticeContent;
	}

	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}

	@Column(name = "title")
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	@Column(name = "type")
	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "notice")
	public Set<NoticeManager> getNoticeManagers() {
		return this.noticeManagers;
	}

	public void setNoticeManagers(Set<NoticeManager> noticeManagers) {
		this.noticeManagers = noticeManagers;
	}

}