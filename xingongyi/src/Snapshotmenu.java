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
 * Snapshotmenu entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "snapshotmenu", catalog = "dinnersystem")
public class Snapshotmenu implements java.io.Serializable {

	// Fields

	private Integer id;
	private Menu menu;
	private MemberOrder memberOrder;
	private Float menuPrice;
	private Integer num;
	private Timestamp createDate;
	private Timestamp lastModifyDate;
	private String createBy;

	// Constructors

	/** default constructor */
	public Snapshotmenu() {
	}

	/** minimal constructor */
	public Snapshotmenu(Menu menu, MemberOrder memberOrder, Float menuPrice,
			Integer num) {
		this.menu = menu;
		this.memberOrder = memberOrder;
		this.menuPrice = menuPrice;
		this.num = num;
	}

	/** full constructor */
	public Snapshotmenu(Menu menu, MemberOrder memberOrder, Float menuPrice,
			Integer num, Timestamp createDate, Timestamp lastModifyDate,
			String createBy) {
		this.menu = menu;
		this.memberOrder = memberOrder;
		this.menuPrice = menuPrice;
		this.num = num;
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
	@JoinColumn(name = "menuId", nullable = false)
	public Menu getMenu() {
		return this.menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "orderId", nullable = false)
	public MemberOrder getMemberOrder() {
		return this.memberOrder;
	}

	public void setMemberOrder(MemberOrder memberOrder) {
		this.memberOrder = memberOrder;
	}

	@Column(name = "menuPrice", nullable = false, precision = 12, scale = 0)
	public Float getMenuPrice() {
		return this.menuPrice;
	}

	public void setMenuPrice(Float menuPrice) {
		this.menuPrice = menuPrice;
	}

	@Column(name = "num", nullable = false)
	public Integer getNum() {
		return this.num;
	}

	public void setNum(Integer num) {
		this.num = num;
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