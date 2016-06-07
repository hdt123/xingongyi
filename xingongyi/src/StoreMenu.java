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
 * StoreMenu entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "store_menu", catalog = "dinnersystem")
public class StoreMenu implements java.io.Serializable {

	// Fields

	private Integer id;
	private Menu menu;
	private Store store;
	private Float price;
	private Integer status;
	private Timestamp createDate;
	private Timestamp lastModifyDate;
	private String createBy;

	// Constructors

	/** default constructor */
	public StoreMenu() {
	}

	/** minimal constructor */
	public StoreMenu(Menu menu, Store store) {
		this.menu = menu;
		this.store = store;
	}

	/** full constructor */
	public StoreMenu(Menu menu, Store store, Float price, Integer status,
			Timestamp createDate, Timestamp lastModifyDate, String createBy) {
		this.menu = menu;
		this.store = store;
		this.price = price;
		this.status = status;
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
	@JoinColumn(name = "storeId", nullable = false)
	public Store getStore() {
		return this.store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	@Column(name = "price", precision = 12, scale = 0)
	public Float getPrice() {
		return this.price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	@Column(name = "status")
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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

	@Column(name = "createBy")
	public String getCreateBy() {
		return this.createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

}