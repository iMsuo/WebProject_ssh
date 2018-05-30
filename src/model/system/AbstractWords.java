package model.system;

/**
 * AbstractWords entity provides the base persistence definition of the Words
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractWords implements java.io.Serializable {

	// Fields

	@Override
	public String toString() {
		return "AbstractWords [id=" + id + ", word=" + word + ", gqs=" + gqs
				+ ", gqfc=" + gqfc + ", xzfc=" + xzfc + ", fs=" + fs
				+ ", meaning=" + meaning + ", lx=" + lx + "]";
	}

	private Integer id;
	private String word;
	private String gqs;
	private String gqfc;
	private String xzfc;
	private String fs;
	private String meaning;
	private String lx;

	// Constructors

	/** default constructor */
	public AbstractWords() {
	}

	/** full constructor */
	public AbstractWords(String word, String gqs, String gqfc, String xzfc,
			String fs, String meaning, String lx) {
		this.word = word;
		this.gqs = gqs;
		this.gqfc = gqfc;
		this.xzfc = xzfc;
		this.fs = fs;
		this.meaning = meaning;
		this.lx = lx;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getWord() {
		return this.word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getGqs() {
		return this.gqs;
	}

	public void setGqs(String gqs) {
		this.gqs = gqs;
	}

	public String getGqfc() {
		return this.gqfc;
	}

	public void setGqfc(String gqfc) {
		this.gqfc = gqfc;
	}

	public String getXzfc() {
		return this.xzfc;
	}

	public void setXzfc(String xzfc) {
		this.xzfc = xzfc;
	}

	public String getFs() {
		return this.fs;
	}

	public void setFs(String fs) {
		this.fs = fs;
	}

	public String getMeaning() {
		return this.meaning;
	}

	public void setMeaning(String meaning) {
		this.meaning = meaning;
	}

	public String getLx() {
		return this.lx;
	}

	public void setLx(String lx) {
		this.lx = lx;
	}

}