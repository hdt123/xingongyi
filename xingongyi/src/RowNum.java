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
 * RowNum entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "row_num", catalog = "dinnersystem")
public class RowNum implements java.io.Serializable {

	// Fields

	private Integer id;
	private Store store;
	private MenuTable menuTable;
	private Integer status;
	private Integer freeTableNum;
	private Integer nowNum;
	private Integer totalNum;
	private Timestamp createDate;
	private Timestamp lastModifyDate;
	private String createBy;
	private Set<MemberRow> memberRows = new HashSet<MemberRow>(0);

	// Constructors

	/** default constructor */
	public RowNum() {
	}

	/** full constructor */
	public RowNum(Store store, MenuTable menuTable, Integer status,
			Integer freeTableNum, Integer nowNum, Integer totalNum,
			Timestamp createDate, Timestamp lastModifyDate, String createBy,
			Set<MemberRow> memberRows) {
		this.store = store;
		this.menuTable = menuTable;
		this.status = status;
		this.freeTableNum = freeTableNum;
		this.nowNum = nowNum;
		this.totalNum = totalNum;
		this.createDate = createDate;
		this.lastModifyDate = lastModifyDate;
		this.createBy = createBy;
		this.memberRows = memberRows;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tableId")
	public MenuTable getMenuTable() {
		return this.menuTable;
	}

	public void setMenuTable(MenuTable menuTable) {
		this.menuTable = menuTable;
	}

	@Column(name = "status")
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Column(name = "freeTableNum")
	public Integer getFreeTableNum() {
		return this.freeTableNum;
	}

	public void setFreeTableNum(Integer freeTableNum) {
		this.freeTableNum = freeTableNum;
	}

	@Column(name = "nowNum")
	public Integer getNowNum() {
		return this.nowNum;
	}

	public void setNowNum(Integer nowNum) {
		this.nowNum = nowNum;
	}

	@Column(name = "totalNum")
	public Integer getTotalNum() {
		return this.totalNum;
	}

	public void setTotalNum(Integer totalNum) {
		this.totalNum = totalNum;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "rowNum")
	public Set<MemberRow> getMemberRows() {
		return this.memberRows;
	}

	public void setMemberRows(Set<MemberRow> memberRows) {
		this.memberRows = memberRows;
	}

}