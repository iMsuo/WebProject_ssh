package model.system;

/**
 * Grades entity. @author MyEclipse Persistence Tools
 */
public class Grades extends AbstractGrades implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Grades() {
	}

	/** full constructor */
	public Grades(UserInfo userInfo, Integer exampart, String grades,String datetime) {
		super(userInfo, exampart, grades,datetime);
	}

}
