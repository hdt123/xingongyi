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
 * MemberOrder entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "member_order", catalog = "dinnersystem")
public class MemberOrder implements java.io.Serializable {

	// Fields

	private Integer id;
	private Member member;
	private Store store;
	private MenuTable menuTable;
	private String orderNum;
	private Float orderPrice;
	private Integer orderStatus;
	private String orderName;
	private String phoneNum;
	private String orderDesc;
	private Timestamp destineTime;
	private Timestamp createTime;
	private Timestamp payTime;
	private Timestamp lastModifyDate;
	private String createBy;
	private Set<Snapshotmenu> snapshotmenus = new HashSet<Snapshotmenu>(0);
	private Set<OrderMenu> orderMenus = new HashSet<OrderMenu>(0);

	// Constructors

	/** default constructor */
	public MemberOrder() {
	}

	/** minimal constructor */
	public MemberOrder(String orderNum, Integer orderStatus, String phoneNum) {
		this.orderNum = orderNum;
		this.orderStatus = orderStatus;
		this.phoneNum = phoneNum;
	}

	/** full constructor */
	public MemberOrder(Member member, Store store, MenuTable menuTable,
			String orderNum, Float orderPrice, Integer orderStatus,
			String orderName, String phoneNum, String orderDesc,
			Timestamp destineTime, Timestamp createTime, Timestamp payTime,
			Timestamp lastModifyDate, String createBy,
			Set<Snapshotmenu> snapshotmenus, Set<OrderMenu> orderMenus) {
		this.member = member;
		this.store = store;
		this.menuTable = menuTable;
		this.orderNum = orderNum;
		this.orderPrice = orderPrice;
		this.orderStatus = orderStatus;
		this.orderName = orderName;
		this.phoneNum = phoneNum;
		this.orderDesc = orderDesc;
		this.destineTime = destineTime;
		this.createTime = createTime;
		this.payTime = payTime;
		this.lastModifyDate = lastModifyDate;
		this.createBy = createBy;
		this.snapshotmenus = snapshotmenus;
		this.orderMenus = orderMenus;
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
	@JoinColumn(name = "memberId")
	public Member getMember() {
		return this.member;
	}

	public void setMember(Member member) {
		this.member = member;
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

	@Column(name = "orderNum", nullable = false, length = 64)
	public String getOrderNum() {
		return this.orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	@Column(name = "orderPrice", precision = 12, scale = 0)
	public Float getOrderPrice() {
		return this.orderPrice;
	}

	public void setOrderPrice(Float orderPrice) {
		this.orderPrice = orderPrice;
	}

	@Column(name = "orderStatus", nullable = false)
	public Integer getOrderStatus() {
		return this.orderStatus;
	}

	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}

	@Column(name = "orderName", length = 128)
	public String getOrderName() {
		return this.orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	@Column(name = "phoneNum", nullable = false, length = 64)
	public String getPhoneNum() {
		return this.phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	@Column(name = "orderDesc")
	public String getOrderDesc() {
		return this.orderDesc;
	}

	public void setOrderDesc(String orderDesc) {
		this.orderDesc = orderDesc;
	}

	@Column(name = "destineTime", length = 19)
	public Timestamp getDestineTime() {
		return this.destineTime;
	}

	public void setDestineTime(Timestamp destineTime) {
		this.destineTime = destineTime;
	}

	@Column(name = "createTime", length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@Column(name = "payTime", length = 19)
	public Timestamp getPayTime() {
		return this.payTime;
	}

	public void setPayTime(Timestamp payTime) {
		this.payTime = payTime;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "memberOrder")
	public Set<Snapshotmenu> getSnapshotmenus() {
		return this.snapshotmenus;
	}

	public void setSnapshotmenus(Set<Snapshotmenu> snapshotmenus) {
		this.snapshotmenus = snapshotmenus;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "memberOrder")
	public Set<OrderMenu> getOrderMenus() {
		return this.orderMenus;
	}

	public void setOrderMenus(Set<OrderMenu> orderMenus) {
		this.orderMenus = orderMenus;
	}

}