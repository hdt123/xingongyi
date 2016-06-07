// default package

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Manager entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "manager", catalog = "dinnersystem")
public class Manager implements java.io.Serializable {

	// Fields

	private Integer id;
	private Store store;
	private String managerName;
	private String password;
	private Integer userType;
	private String lastLoginDate;
	private Timestamp createDate;
	private Timestamp lastModifyDate;
	private String createBy;
	private String lastLoginIp;
	private Timestamp loginDate;
	private String loginIp;
	private Integer loginCount;
	private Set<NoticeManager> noticeManagers = new HashSet<NoticeManager>(0);
	private Set<Log> logs = new HashSet<Log>(0);

	// Constructors

	/** default constructor */
	public Manager() {
	}

	/** minimal constructor */
	public Manager(String managerName, String password, Integer userType) {
		this.managerName = managerName;
		this.password = password;
		this.userType = userType;
	}

	/** full constructor */
	public Manager(Store store, String managerName, String password,
			Integer userType, String lastLoginDate, Timestamp createDate,
			Timestamp lastModifyDate, String createBy, String lastLoginIp,
			Timestamp loginDate, String loginIp, Integer loginCount,
			Set<NoticeManager> noticeManagers, Set<Log> logs) {
		this.store = store;
		this.managerName = managerName;
		this.password = password;
		this.userType = userType;
		this.lastLoginDate = lastLoginDate;
		this.createDate = createDate;
		this.lastModifyDate = lastModifyDate;
		this.createBy = createBy;
		this.lastLoginIp = lastLoginIp;
		this.loginDate = loginDate;
		this.loginIp = loginIp;
		this.loginCount = loginCount;
		this.noticeManagers = noticeManagers;
		this.logs = logs;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "storeId")
	public Store getStore() {
		return this.store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	@Column(name = "managerName", nullable = false, length = 32)
	public String getManagerName() {
		return this.managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	@Column(name = "password", nullable = false, length = 32)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "userType", nullable = false)
	public Integer getUserType() {
		return this.userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	@Column(name = "lastLoginDate", length = 0)
	public String getLastLoginDate() {
		return this.lastLoginDate;
	}

	public void setLastLoginDate(String lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
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

	@Column(name = "lastLoginIp", length = 64)
	public String getLastLoginIp() {
		return this.lastLoginIp;
	}

	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}

	@Column(name = "loginDate", length = 19)
	public Timestamp getLoginDate() {
		return this.loginDate;
	}

	public void setLoginDate(Timestamp loginDate) {
		this.loginDate = loginDate;
	}

	@Column(name = "loginIp", length = 64)
	public String getLoginIp() {
		return this.loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	@Column(name = "loginCount")
	public Integer getLoginCount() {
		return this.loginCount;
	}

	public void setLoginCount(Integer loginCount) {
		this.loginCount = loginCount;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "manager")
	public Set<NoticeManager> getNoticeManagers() {
		return this.noticeManagers;
	}

	public void setNoticeManagers(Set<NoticeManager> noticeManagers) {
		this.noticeManagers = noticeManagers;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "manager")
	public Set<Log> getLogs() {
		return this.logs;
	}

	public void setLogs(Set<Log> logs) {
		this.logs = logs;
	}

}