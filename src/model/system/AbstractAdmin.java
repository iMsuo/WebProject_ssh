package model.system;

/**
 * AbstractAdmin entity provides the base persistence definition of the Admin
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractAdmin implements java.io.Serializable {

	// Fields

	private Integer adminid;
	private String adminname;
	private String adminpassword;

	// Constructors

	/** default constructor */
	public AbstractAdmin() {
	}

	/** full constructor */
	public AbstractAdmin(String adminname, String adminpassword) {
		this.adminname = adminname;
		this.adminpassword = adminpassword;
	}

	// Property accessors

	public Integer getAdminid() {
		return this.adminid;
	}

	public void setAdminid(Integer adminid) {
		this.adminid = adminid;
	}

	public String getAdminname() {
		return this.adminname;
	}

	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}

	public String getAdminpassword() {
		return this.adminpassword;
	}

	public void setAdminpassword(String adminpassword) {
		this.adminpassword = adminpassword;
	}

}