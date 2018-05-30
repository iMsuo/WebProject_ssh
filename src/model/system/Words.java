package model.system;

/**
 * Words entity. @author MyEclipse Persistence Tools
 */
public class Words extends AbstractWords implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Words() {
	}

	/** full constructor */
	public Words(String word, String gqs, String gqfc, String xzfc, String fs,
			String meaning, String lx) {
		super(word, gqs, gqfc, xzfc, fs, meaning, lx);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

}
