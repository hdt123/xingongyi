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
 * MemberRow entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "member_row", catalog = "dinnersystem")
public class MemberRow implements java.io.Serializable {

	// Fields

	private Integer memberRowId;
	private Member member;
	private RowNum rowNum;
	private Store store;
	private Integer tableType;
	private Integer peopleNum;
	private Integer status;
	private Integer nowNum;
	private String phoneNum;
	private String memberRowDesc;
	private String orderName;
	private Timestamp createDate;
	private Timestamp lastModifyDate;
	private String createBy;

	// Constructors

	/** default constructor */
	public MemberRow() {
	}

	/** minimal constructor */
	public MemberRow(Member member, Store store, Integer tableType) {
		this.member = member;
		this.store = store;
		this.tableType = tableType;
	}

	/** full constructor */
	public MemberRow(Member member, RowNum rowNum, Store store,
			Integer tableType, Integer peopleNum, Integer status,
			Integer nowNum, String phoneNum, String memberRowDesc,
			String orderName, Timestamp createDate, Timestamp lastModifyDate,
			String createBy) {
		this.member = member;
		this.rowNum = rowNum;
		this.store = store;
		this.tableType = tableType;
		this.peopleNum = peopleNum;
		this.status = status;
		this.nowNum = nowNum;
		this.phoneNum = phoneNum;
		this.memberRowDesc = memberRowDesc;
		this.orderName = orderName;
		this.createDate = createDate;
		this.lastModifyDate = lastModifyDate;
		this.createBy = createBy;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "memberRowId", unique = true, nullable = false)
	public Integer getMemberRowId() {
		return this.memberRowId;
	}

	public void setMemberRowId(Integer memberRowId) {
		this.memberRowId = memberRowId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "memberId", nullable = false)
	public Member getMember() {
		return this.member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "rowNumId")
	public RowNum getRowNum() {
		return this.rowNum;
	}

	public void setRowNum(RowNum rowNum) {
		this.rowNum = rowNum;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "storeId", nullable = false)
	public Store getStore() {
		return this.store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	@Column(name = "tableType", nullable = false)
	public Integer getTableType() {
		return this.tableType;
	}

	public void setTableType(Integer tableType) {
		this.tableType = tableType;
	}

	@Column(name = "peopleNum")
	public Integer getPeopleNum() {
		return this.peopleNum;
	}

	public void setPeopleNum(Integer peopleNum) {
		this.peopleNum = peopleNum;
	}

	@Column(name = "status")
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Column(name = "nowNum")
	public Integer getNowNum() {
		return this.nowNum;
	}

	public void setNowNum(Integer nowNum) {
		this.nowNum = nowNum;
	}

	@Column(name = "phoneNum", length = 64)
	public String getPhoneNum() {
		return this.phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	@Column(name = "memberRowDesc")
	public String getMemberRowDesc() {
		return this.memberRowDesc;
	}

	public void setMemberRowDesc(String memberRowDesc) {
		this.memberRowDesc = memberRowDesc;
	}

	@Column(name = "orderName", length = 64)
	public String getOrderName() {
		return this.orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
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