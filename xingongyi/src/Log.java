// default package

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Log entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "log", catalog = "dinnersystem")
public class Log implements java.io.Serializable {

	// Fields

	private Integer id;
	private Manager manager;
	private String oerateDesc;
	private Timestamp createDate;
	private Timestamp lastModifyDate;
	private String createBy;

	// Constructors

	/** default constructor */
	public Log() {
	}

	/** full constructor */
	public Log(Manager manager, String oerateDesc, Timestamp createDate,
			Timestamp lastModifyDate, String createBy) {
		this.manager = manager;
		this.oerateDesc = oerateDesc;
		this.createDate = createDate;
		this.lastModifyDate = lastModifyDate;
		this.createBy = createBy;
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
	@JoinColumn(name = "managerId")
	public Manager getManager() {
		return this.manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	@Column(name = "oerateDesc", length = 256)
	public String getOerateDesc() {
		return this.oerateDesc;
	}

	public void setOerateDesc(String oerateDesc) {
		this.oerateDesc = oerateDesc;
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

}