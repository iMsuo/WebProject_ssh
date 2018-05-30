package model.system;

import java.util.HashSet;
import java.util.Set;

/**
 * AbstractLanmu entity provides the base persistence definition of the Lanmu
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractLanmu implements java.io.Serializable {

	// Fields

	private Integer lanMuid;
	private String lanmuname;
	private Set tickets = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractLanmu() {
	}

	/** minimal constructor */
	public AbstractLanmu(String lanmuname) {
		this.lanmuname = lanmuname;
	}

	/** full constructor */
	public AbstractLanmu(String lanmuname, Set tickets) {
		this.lanmuname = lanmuname;
		this.tickets = tickets;
	}

	// Property accessors

	public Integer getLanMuid() {
		return this.lanMuid;
	}

	public void setLanMuid(Integer lanMuid) {
		this.lanMuid = lanMuid;
	}

	public String getLanmuname() {
		return this.lanmuname;
	}

	public void setLanmuname(String lanmuname) {
		this.lanmuname = lanmuname;
	}

	public Set getTickets() {
		return this.tickets;
	}

	public void setTickets(Set tickets) {
		this.tickets = tickets;
	}

}