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
 * Store entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "store", catalog = "dinnersystem")
public class Store implements java.io.Serializable {

	// Fields

	private Integer id;
	private City city;
	private String storeName;
	private String storeAddr;
	private Float longitude;
	private Float latitude;
	private Integer area;
	private String phoneNum;
	private Integer status;
	private String weChatPayNum;
	private String payKey;
	private Timestamp createDate;
	private Timestamp lastModifyDate;
	private String hiUrl;
	private String createBy;
	private Set<MemberOrder> memberOrders = new HashSet<MemberOrder>(0);
	private Set<MemberRow> memberRows = new HashSet<MemberRow>(0);
	private Set<RowNum> rowNums = new HashSet<RowNum>(0);
	private Set<Image> images = new HashSet<Image>(0);
	private Set<StoreMenu> storeMenus = new HashSet<StoreMenu>(0);
	private Set<Manager> managers = new HashSet<Manager>(0);

	// Constructors

	/** default constructor */
	public Store() {
	}

	/** full constructor */
	public Store(City city, String storeName, String storeAddr,
			Float longitude, Float latitude, Integer area, String phoneNum,
			Integer status, String weChatPayNum, String payKey,
			Timestamp createDate, Timestamp lastModifyDate, String hiUrl,
			String createBy, Set<MemberOrder> memberOrders,
			Set<MemberRow> memberRows, Set<RowNum> rowNums, Set<Image> images,
			Set<StoreMenu> storeMenus, Set<Manager> managers) {
		this.city = city;
		this.storeName = storeName;
		this.storeAddr = storeAddr;
		this.longitude = longitude;
		this.latitude = latitude;
		this.area = area;
		this.phoneNum = phoneNum;
		this.status = status;
		this.weChatPayNum = weChatPayNum;
		this.payKey = payKey;
		this.createDate = createDate;
		this.lastModifyDate = lastModifyDate;
		this.hiUrl = hiUrl;
		this.createBy = createBy;
		this.memberOrders = memberOrders;
		this.memberRows = memberRows;
		this.rowNums = rowNums;
		this.images = images;
		this.storeMenus = storeMenus;
		this.managers = managers;
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
	@JoinColumn(name = "cityId")
	public City getCity() {
		return this.city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	@Column(name = "storeName", length = 64)
	public String getStoreName() {
		return this.storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	@Column(name = "storeAddr", length = 128)
	public String getStoreAddr() {
		return this.storeAddr;
	}

	public void setStoreAddr(String storeAddr) {
		this.storeAddr = storeAddr;
	}

	@Column(name = "longitude", precision = 12, scale = 0)
	public Float getLongitude() {
		return this.longitude;
	}

	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}

	@Column(name = "latitude", precision = 12, scale = 0)
	public Float getLatitude() {
		return this.latitude;
	}

	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}

	@Column(name = "area")
	public Integer getArea() {
		return this.area;
	}

	public void setArea(Integer area) {
		this.area = area;
	}

	@Column(name = "phoneNum", length = 64)
	public String getPhoneNum() {
		return this.phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	@Column(name = "status")
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Column(name = "weChatPayNum", length = 64)
	public String getWeChatPayNum() {
		return this.weChatPayNum;
	}

	public void setWeChatPayNum(String weChatPayNum) {
		this.weChatPayNum = weChatPayNum;
	}

	@Column(name = "payKey", length = 128)
	public String getPayKey() {
		return this.payKey;
	}

	public void setPayKey(String payKey) {
		this.payKey = payKey;
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

	@Column(name = "hiUrl", length = 128)
	public String getHiUrl() {
		return this.hiUrl;
	}

	public void setHiUrl(String hiUrl) {
		this.hiUrl = hiUrl;
	}

	@Column(name = "createBy", length = 64)
	public String getCreateBy() {
		return this.createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "store")
	public Set<MemberOrder> getMemberOrders() {
		return this.memberOrders;
	}

	public void setMemberOrders(Set<MemberOrder> memberOrders) {
		this.memberOrders = memberOrders;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "store")
	public Set<MemberRow> getMemberRows() {
		return this.memberRows;
	}

	public void setMemberRows(Set<MemberRow> memberRows) {
		this.memberRows = memberRows;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "store")
	public Set<RowNum> getRowNums() {
		return this.rowNums;
	}

	public void setRowNums(Set<RowNum> rowNums) {
		this.rowNums = rowNums;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "store")
	public Set<Image> getImages() {
		return this.images;
	}

	public void setImages(Set<Image> images) {
		this.images = images;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "store")
	public Set<StoreMenu> getStoreMenus() {
		return this.storeMenus;
	}

	public void setStoreMenus(Set<StoreMenu> storeMenus) {
		this.storeMenus = storeMenus;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "store")
	public Set<Manager> getManagers() {
		return this.managers;
	}

	public void setManagers(Set<Manager> managers) {
		this.managers = managers;
	}

}