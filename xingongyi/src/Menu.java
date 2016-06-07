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
 * Menu entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "menu", catalog = "dinnersystem")
public class Menu implements java.io.Serializable {

	// Fields

	private Integer id;
	private Image image;
	private MenuType menuType;
	private String menuName;
	private String menuDesc;
	private Float menuPrice;
	private Timestamp createDate;
	private Timestamp lastModifyDate;
	private String createBy;
	private Set<StoreMenu> storeMenus = new HashSet<StoreMenu>(0);
	private Set<Snapshotmenu> snapshotmenus = new HashSet<Snapshotmenu>(0);
	private Set<OrderMenu> orderMenus = new HashSet<OrderMenu>(0);
	private Set<Image> images = new HashSet<Image>(0);

	// Constructors

	/** default constructor */
	public Menu() {
	}

	/** minimal constructor */
	public Menu(MenuType menuType, String menuName, String menuDesc) {
		this.menuType = menuType;
		this.menuName = menuName;
		this.menuDesc = menuDesc;
	}

	/** full constructor */
	public Menu(Image image, MenuType menuType, String menuName,
			String menuDesc, Float menuPrice, Timestamp createDate,
			Timestamp lastModifyDate, String createBy,
			Set<StoreMenu> storeMenus, Set<Snapshotmenu> snapshotmenus,
			Set<OrderMenu> orderMenus, Set<Image> images) {
		this.image = image;
		this.menuType = menuType;
		this.menuName = menuName;
		this.menuDesc = menuDesc;
		this.menuPrice = menuPrice;
		this.createDate = createDate;
		this.lastModifyDate = lastModifyDate;
		this.createBy = createBy;
		this.storeMenus = storeMenus;
		this.snapshotmenus = snapshotmenus;
		this.orderMenus = orderMenus;
		this.images = images;
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
	@JoinColumn(name = "privalImageId")
	public Image getImage() {
		return this.image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "typeId", nullable = false)
	public MenuType getMenuType() {
		return this.menuType;
	}

	public void setMenuType(MenuType menuType) {
		this.menuType = menuType;
	}

	@Column(name = "menuName", nullable = false, length = 128)
	public String getMenuName() {
		return this.menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	@Column(name = "menuDesc", nullable = false, length = 512)
	public String getMenuDesc() {
		return this.menuDesc;
	}

	public void setMenuDesc(String menuDesc) {
		this.menuDesc = menuDesc;
	}

	@Column(name = "menuPrice", precision = 12, scale = 0)
	public Float getMenuPrice() {
		return this.menuPrice;
	}

	public void setMenuPrice(Float menuPrice) {
		this.menuPrice = menuPrice;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "menu")
	public Set<StoreMenu> getStoreMenus() {
		return this.storeMenus;
	}

	public void setStoreMenus(Set<StoreMenu> storeMenus) {
		this.storeMenus = storeMenus;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "menu")
	public Set<Snapshotmenu> getSnapshotmenus() {
		return this.snapshotmenus;
	}

	public void setSnapshotmenus(Set<Snapshotmenu> snapshotmenus) {
		this.snapshotmenus = snapshotmenus;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "menu")
	public Set<OrderMenu> getOrderMenus() {
		return this.orderMenus;
	}

	public void setOrderMenus(Set<OrderMenu> orderMenus) {
		this.orderMenus = orderMenus;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "menu")
	public Set<Image> getImages() {
		return this.images;
	}

	public void setImages(Set<Image> images) {
		this.images = images;
	}

}