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
 * ServerForm entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "server_form", catalog = "pengxing")
public class ServerForm implements java.io.Serializable {

	// Fields

	private Integer id;
	private User user;
	private String createBy;
	private Timestamp createTime;
	private Timestamp lastUpdateTime;
	private Timestamp serverDate;
	private String serverContent;
	private String serverCount;

	// Constructors

	/** default constructor */
	public ServerForm() {
	}

	/** minimal constructor */
	public ServerForm(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public ServerForm(Integer id, User user, String createBy,
			Timestamp createTime, Timestamp lastUpdateTime,
			Timestamp serverDate, String serverContent, String serverCount) {
		this.id = id;
		this.user = user;
		this.createBy = createBy;
		this.createTime = createTime;
		this.lastUpdateTime = lastUpdateTime;
		this.serverDate = serverDate;
		this.serverContent = serverContent;
		this.serverCount = serverCount;
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
	@JoinColumn(name = "user_id")
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "create_by", length = 64)
	public String getCreateBy() {
		return this.createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	@Column(name = "create_time", length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@Column(name = "last_update_time", length = 19)
	public Timestamp getLastUpdateTime() {
		return this.lastUpdateTime;
	}

	public void setLastUpdateTime(Timestamp lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	@Column(name = "server_date", length = 19)
	public Timestamp getServerDate() {
		return this.serverDate;
	}

	public void setServerDate(Timestamp serverDate) {
		this.serverDate = serverDate;
	}

	@Column(name = "server_content", length = 256)
	public String getServerContent() {
		return this.serverContent;
	}

	public void setServerContent(String serverContent) {
		this.serverContent = serverContent;
	}

	@Column(name = "server_count", length = 64)
	public String getServerCount() {
		return this.serverCount;
	}

	public void setServerCount(String serverCount) {
		this.serverCount = serverCount;
	}

}