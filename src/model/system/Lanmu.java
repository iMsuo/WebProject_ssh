package model.system;

import java.util.Set;

/**
 * Lanmu entity. @author MyEclipse Persistence Tools
 */
public class Lanmu extends AbstractLanmu implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Lanmu() {
	}

	/** minimal constructor */
	public Lanmu(String lanmuname) {
		super(lanmuname);
	}

	/** full constructor */
	public Lanmu(String lanmuname, Set tickets) {
		super(lanmuname, tickets);
	}

}
