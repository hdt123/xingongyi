// default package

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * MenuTable entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "menu_table", catalog = "dinnersystem")
public class MenuTable implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer tableType;
	private Integer storeId;
	private String peopleNum;
	private Integer tableNum;
	private String tableDesc;
	private Set<MemberOrder> memberOrders = new HashSet<MemberOrder>(0);
	private Set<RowNum> rowNums = new HashSet<RowNum>(0);

	// Constructors

	/** default constructor */
	public MenuTable() {
	}

	/** minimal constructor */
	public MenuTable(Integer tableType) {
		this.tableType = tableType;
	}

	/** full constructor */
	public MenuTable(Integer tableType, Integer storeId, String peopleNum,
			Integer tableNum, String tableDesc, Set<MemberOrder> memberOrders,
			Set<RowNum> rowNums) {
		this.tableType = tableType;
		this.storeId = storeId;
		this.peopleNum = peopleNum;
		this.tableNum = tableNum;
		this.tableDesc = tableDesc;
		this.memberOrders = memberOrders;
		this.rowNums = rowNums;
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

	@Column(name = "tableType", nullable = false)
	public Integer getTableType() {
		return this.tableType;
	}

	public void setTableType(Integer tableType) {
		this.tableType = tableType;
	}

	@Column(name = "storeId")
	public Integer getStoreId() {
		return this.storeId;
	}

	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}

	@Column(name = "peopleNum", length = 64)
	public String getPeopleNum() {
		return this.peopleNum;
	}

	public void setPeopleNum(String peopleNum) {
		this.peopleNum = peopleNum;
	}

	@Column(name = "tableNum")
	public Integer getTableNum() {
		return this.tableNum;
	}

	public void setTableNum(Integer tableNum) {
		this.tableNum = tableNum;
	}

	@Column(name = "tableDesc", length = 256)
	public String getTableDesc() {
		return this.tableDesc;
	}

	public void setTableDesc(String tableDesc) {
		this.tableDesc = tableDesc;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "menuTable")
	public Set<MemberOrder> getMemberOrders() {
		return this.memberOrders;
	}

	public void setMemberOrders(Set<MemberOrder> memberOrders) {
		this.memberOrders = memberOrders;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "menuTable")
	public Set<RowNum> getRowNums() {
		return this.rowNums;
	}

	public void setRowNums(Set<RowNum> rowNums) {
		this.rowNums = rowNums;
	}

}