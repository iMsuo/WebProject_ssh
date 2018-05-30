package model.system;

/**
 * AbstractListensub entity provides the base persistence definition of the
 * Listensub entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractListensub implements java.io.Serializable {

	// Fields

	private Integer id;
	private Mp3 mp3;
	private String listenoptionA;
	private String listenoptionB;
	private String listenoptionC;
	private String listenoptionD;
	private String trueAnswer;

	// Constructors

	/** default constructor */
	public AbstractListensub() {
	}

	/** full constructor */
	public AbstractListensub(Mp3 mp3, String listenoptionA,
			String listenoptionB, String listenoptionC, String listenoptionD,
			String trueAnswer) {
		this.mp3 = mp3;
		this.listenoptionA = listenoptionA;
		this.listenoptionB = listenoptionB;
		this.listenoptionC = listenoptionC;
		this.listenoptionD = listenoptionD;
		this.trueAnswer = trueAnswer;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Mp3 getMp3() {
		return this.mp3;
	}

	public void setMp3(Mp3 mp3) {
		this.mp3 = mp3;
	}

	public String getListenoptionA() {
		return this.listenoptionA;
	}

	public void setListenoptionA(String listenoptionA) {
		this.listenoptionA = listenoptionA;
	}

	public String getListenoptionB() {
		return this.listenoptionB;
	}

	public void setListenoptionB(String listenoptionB) {
		this.listenoptionB = listenoptionB;
	}

	public String getListenoptionC() {
		return this.listenoptionC;
	}

	public void setListenoptionC(String listenoptionC) {
		this.listenoptionC = listenoptionC;
	}

	public String getListenoptionD() {
		return this.listenoptionD;
	}

	public void setListenoptionD(String listenoptionD) {
		this.listenoptionD = listenoptionD;
	}

	public String getTrueAnswer() {
		return this.trueAnswer;
	}

	public void setTrueAnswer(String trueAnswer) {
		this.trueAnswer = trueAnswer;
	}

}