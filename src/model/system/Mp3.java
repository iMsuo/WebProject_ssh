package model.system;

import java.util.Set;

/**
 * Mp3 entity. @author MyEclipse Persistence Tools
 */
public class Mp3 extends AbstractMp3 implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Mp3() {
	}

	/** full constructor */
	public Mp3(String mp3Url, Set listensubs) {
		super(mp3Url, listensubs);
	}

}
