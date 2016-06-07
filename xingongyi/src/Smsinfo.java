// default package

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Smsinfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "smsinfo", catalog = "dinnersystem")
public class Smsinfo implements java.io.Serializable {

	// Fields

	private Integer id;
	private String smsContent;
	private Timestamp sendDate;
	private Integer messageType;
	private String phoneNum;
	private String returnInfo;
	private Timestamp createDate;
	private Timestamp lastModifyDate;
	private String createBy;

	// Constructors

	/** default constructor */
	public Smsinfo() {
	}

	/** full constructor */
	public Smsinfo(String smsContent, Timestamp sendDate, Integer messageType,
			String phoneNum, String returnInfo, Timestamp createDate,
			Timestamp lastModifyDate, String createBy) {
		this.smsContent = smsContent;
		this.sendDate = sendDate;
		this.messageType = messageType;
		this.phoneNum = phoneNum;
		this.returnInfo = returnInfo;
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

	@Column(name = "smsContent", length = 128)
	public String getSmsContent() {
		return this.smsContent;
	}

	public void setSmsContent(String smsContent) {
		this.smsContent = smsContent;
	}

	@Column(name = "sendDate", length = 19)
	public Timestamp getSendDate() {
		return this.sendDate;
	}

	public void setSendDate(Timestamp sendDate) {
		this.sendDate = sendDate;
	}

	@Column(name = "messageType")
	public Integer getMessageType() {
		return this.messageType;
	}

	public void setMessageType(Integer messageType) {
		this.messageType = messageType;
	}

	@Column(name = "phoneNum", length = 32)
	public String getPhoneNum() {
		return this.phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	@Column(name = "returnInfo", length = 128)
	public String getReturnInfo() {
		return this.returnInfo;
	}

	public void setReturnInfo(String returnInfo) {
		this.returnInfo = returnInfo;
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