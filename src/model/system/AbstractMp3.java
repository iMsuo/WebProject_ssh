package model.system;

import java.util.HashSet;
import java.util.Set;

/**
 * AbstractMp3 entity provides the base persistence definition of the Mp3
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractMp3 implements java.io.Serializable {

	// Fields

	private Integer id;
	private String mp3Url;
	private Set listensubs = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractMp3() {
	}

	/** full constructor */
	public AbstractMp3(String mp3Url, Set listensubs) {
		this.mp3Url = mp3Url;
		this.listensubs = listensubs;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMp3Url() {
		return this.mp3Url;
	}

	public void setMp3Url(String mp3Url) {
		this.mp3Url = mp3Url;
	}

	public Set getListensubs() {
		return this.listensubs;
	}

	public void setListensubs(Set listensubs) {
		this.listensubs = listensubs;
	}

}