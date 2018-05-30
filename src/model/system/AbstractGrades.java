package model.system;

/**
 * AbstractGrades entity provides the base persistence definition of the Grades
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractGrades implements java.io.Serializable {

	// Fields

	private Integer id;
	private UserInfo userInfo;
	private Integer exampart;
	private String grades;
	private String datetime;

	// Constructors

	/** default constructor */
	public AbstractGrades() {
	}

	/** full constructor */
	public AbstractGrades(UserInfo userInfo, Integer exampart, String grades,
			String datetime) {
		this.userInfo = userInfo;
		this.exampart = exampart;
		this.grades = grades;
		this.datetime = datetime;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public UserInfo getUserInfo() {
		return this.userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public Integer getExampart() {
		return this.exampart;
	}

	public void setExampart(Integer exampart) {
		this.exampart = exampart;
	}

	public String getGrades() {
		return this.grades;
	}

	public void setGrades(String grades) {
		this.grades = grades;
	}

	public String getDatetime() {
		return this.datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

}