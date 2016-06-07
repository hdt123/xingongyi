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
 * Member entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "member", catalog = "dinnersystem")
public class Member implements java.io.Serializable {

	// Fields

	private Integer id;
	private Token token;
	private String memberName;
	private String phoneNum;
	private String password;
	private Integer gender;
	private Float totalPrice;
	private Float points;
	private Timestamp lastModifyDate;
	private String createBy;
	private Timestamp createDate;
	private String lastLoginIp;
	private Timestamp lastLoginDate;
	private String lastLoginAddr;
	private String registerAddr;
	private String lastOperateAddr;
	private String nickName;
	private String birthday;
	private String city;
	private String email;
	private String postCode;
	private String address;
	private String imageStr;
	private String personnelBrief;
	private String memberDesc;
	private String openId;
	private String weixinNickName;
	private Set<MemberOrder> memberOrders = new HashSet<MemberOrder>(0);
	private Set<MemberRow> memberRows = new HashSet<MemberRow>(0);

	// Constructors

	/** default constructor */
	public Member() {
	}

	/** minimal constructor */
	public Member(String memberName, String phoneNum, String password) {
		this.memberName = memberName;
		this.phoneNum = phoneNum;
		this.password = password;
	}

	/** full constructor */
	public Member(Token token, String memberName, String phoneNum,
			String password, Integer gender, Float totalPrice, Float points,
			Timestamp lastModifyDate, String createBy, Timestamp createDate,
			String lastLoginIp, Timestamp lastLoginDate, String lastLoginAddr,
			String registerAddr, String lastOperateAddr, String nickName,
			String birthday, String city, String email, String postCode,
			String address, String imageStr, String personnelBrief,
			String memberDesc, String openId, String weixinNickName,
			Set<MemberOrder> memberOrders, Set<MemberRow> memberRows) {
		this.token = token;
		this.memberName = memberName;
		this.phoneNum = phoneNum;
		this.password = password;
		this.gender = gender;
		this.totalPrice = totalPrice;
		this.points = points;
		this.lastModifyDate = lastModifyDate;
		this.createBy = createBy;
		this.createDate = createDate;
		this.lastLoginIp = lastLoginIp;
		this.lastLoginDate = lastLoginDate;
		this.lastLoginAddr = lastLoginAddr;
		this.registerAddr = registerAddr;
		this.lastOperateAddr = lastOperateAddr;
		this.nickName = nickName;
		this.birthday = birthday;
		this.city = city;
		this.email = email;
		this.postCode = postCode;
		this.address = address;
		this.imageStr = imageStr;
		this.personnelBrief = personnelBrief;
		this.memberDesc = memberDesc;
		this.openId = openId;
		this.weixinNickName = weixinNickName;
		this.memberOrders = memberOrders;
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
	@JoinColumn(name = "tokenId")
	public Token getToken() {
		return this.token;
	}

	public void setToken(Token token) {
		this.token = token;
	}

	@Column(name = "memberName", nullable = false, length = 64)
	public String getMemberName() {
		return this.memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	@Column(name = "phoneNum", nullable = false, length = 128)
	public String getPhoneNum() {
		return this.phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	@Column(name = "password", nullable = false, length = 64)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "gender")
	public Integer getGender() {
		return this.gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	@Column(name = "totalPrice", precision = 12, scale = 0)
	public Float getTotalPrice() {
		return this.totalPrice;
	}

	public void setTotalPrice(Float totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Column(name = "points", precision = 12, scale = 0)
	public Float getPoints() {
		return this.points;
	}

	public void setPoints(Float points) {
		this.points = points;
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

	@Column(name = "createDate", length = 19)
	public Timestamp getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	@Column(name = "lastLoginIp", length = 64)
	public String getLastLoginIp() {
		return this.lastLoginIp;
	}

	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}

	@Column(name = "lastLoginDate", length = 19)
	public Timestamp getLastLoginDate() {
		return this.lastLoginDate;
	}

	public void setLastLoginDate(Timestamp lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	@Column(name = "lastLoginAddr", length = 128)
	public String getLastLoginAddr() {
		return this.lastLoginAddr;
	}

	public void setLastLoginAddr(String lastLoginAddr) {
		this.lastLoginAddr = lastLoginAddr;
	}

	@Column(name = "registerAddr")
	public String getRegisterAddr() {
		return this.registerAddr;
	}

	public void setRegisterAddr(String registerAddr) {
		this.registerAddr = registerAddr;
	}

	@Column(name = "lastOperateAddr")
	public String getLastOperateAddr() {
		return this.lastOperateAddr;
	}

	public void setLastOperateAddr(String lastOperateAddr) {
		this.lastOperateAddr = lastOperateAddr;
	}

	@Column(name = "nickName", length = 64)
	public String getNickName() {
		return this.nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	@Column(name = "birthday", length = 64)
	public String getBirthday() {
		return this.birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	@Column(name = "city", length = 128)
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "email", length = 128)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "postCode", length = 64)
	public String getPostCode() {
		return this.postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	@Column(name = "address", length = 256)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "imageStr")
	public String getImageStr() {
		return this.imageStr;
	}

	public void setImageStr(String imageStr) {
		this.imageStr = imageStr;
	}

	@Column(name = "personnelBrief")
	public String getPersonnelBrief() {
		return this.personnelBrief;
	}

	public void setPersonnelBrief(String personnelBrief) {
		this.personnelBrief = personnelBrief;
	}

	@Column(name = "memberDesc")
	public String getMemberDesc() {
		return this.memberDesc;
	}

	public void setMemberDesc(String memberDesc) {
		this.memberDesc = memberDesc;
	}

	@Column(name = "openId")
	public String getOpenId() {
		return this.openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	@Column(name = "weixinNickName")
	public String getWeixinNickName() {
		return this.weixinNickName;
	}

	public void setWeixinNickName(String weixinNickName) {
		this.weixinNickName = weixinNickName;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "member")
	public Set<MemberOrder> getMemberOrders() {
		return this.memberOrders;
	}

	public void setMemberOrders(Set<MemberOrder> memberOrders) {
		this.memberOrders = memberOrders;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "member")
	public Set<MemberRow> getMemberRows() {
		return this.memberRows;
	}

	public void setMemberRows(Set<MemberRow> memberRows) {
		this.memberRows = memberRows;
	}

}