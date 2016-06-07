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
 * MenuType entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "menu_type", catalog = "dinnersystem")
public class MenuType implements java.io.Serializable {

	// Fields

	private Integer typeId;
	private String typeName;
	private String typeDesc;
	private Set<Menu> menus = new HashSet<Menu>(0);

	// Constructors

	/** default constructor */
	public MenuType() {
	}

	/** minimal constructor */
	public MenuType(String typeName) {
		this.typeName = typeName;
	}

	/** full constructor */
	public MenuType(String typeName, String typeDesc, Set<Menu> menus) {
		this.typeName = typeName;
		this.typeDesc = typeDesc;
		this.menus = menus;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "typeId", unique = true, nullable = false)
	public Integer getTypeId() {
		return this.typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	@Column(name = "typeName", nullable = false, length = 128)
	public String getTypeName() {
		return this.typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	@Column(name = "typeDesc", length = 256)
	public String getTypeDesc() {
		return this.typeDesc;
	}

	public void setTypeDesc(String typeDesc) {
		this.typeDesc = typeDesc;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "menuType")
	public Set<Menu> getMenus() {
		return this.menus;
	}

	public void setMenus(Set<Menu> menus) {
		this.menus = menus;
	}

}