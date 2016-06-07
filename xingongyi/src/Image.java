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
 * Image entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "image", catalog = "dinnersystem")
public class Image implements java.io.Serializable {

	// Fields

	private Integer id;
	private Menu menu;
	private Store store;
	private String imageSrc;
	private Integer imageType;
	private Timestamp createDate;
	private Timestamp lastModifyDate;
	private String createBy;
	private Set<Menu> menus = new HashSet<Menu>(0);

	// Constructors

	/** default constructor */
	public Image() {
	}

	/** minimal constructor */
	public Image(String imageSrc) {
		this.imageSrc = imageSrc;
	}

	/** full constructor */
	public Image(Menu menu, Store store, String imageSrc, Integer imageType,
			Timestamp createDate, Timestamp lastModifyDate, String createBy,
			Set<Menu> menus) {
		this.menu = menu;
		this.store = store;
		this.imageSrc = imageSrc;
		this.imageType = imageType;
		this.createDate = createDate;
		this.lastModifyDate = lastModifyDate;
		this.createBy = createBy;
		this.menus = menus;
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
	@JoinColumn(name = "menuId")
	public Menu getMenu() {
		return this.menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "storeId")
	public Store getStore() {
		return this.store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	@Column(name = "imageSrc", nullable = false, length = 256)
	public String getImageSrc() {
		return this.imageSrc;
	}

	public void setImageSrc(String imageSrc) {
		this.imageSrc = imageSrc;
	}

	@Column(name = "imageType")
	public Integer getImageType() {
		return this.imageType;
	}

	public void setImageType(Integer imageType) {
		this.imageType = imageType;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "image")
	public Set<Menu> getMenus() {
		return this.menus;
	}

	public void setMenus(Set<Menu> menus) {
		this.menus = menus;
	}

}