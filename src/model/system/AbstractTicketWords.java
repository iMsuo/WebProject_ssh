package model.system;

import java.util.HashSet;
import java.util.Set;

/**
 * AbstractTicketWords entity provides the base persistence definition of the
 * TicketWords entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractTicketWords implements java.io.Serializable {

	// Fields

	private Integer id;
	private UserInfo userInfo;
	private Ticket ticket;
	private String words;
	private Set userwordses = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractTicketWords() {
	}

	/** full constructor */
	public AbstractTicketWords(UserInfo userInfo, Ticket ticket, String words,
			Set userwordses) {
		this.userInfo = userInfo;
		this.ticket = ticket;
		this.words = words;
		this.userwordses = userwordses;
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

	public Ticket getTicket() {
		return this.ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public String getWords() {
		return this.words;
	}

	public void setWords(String words) {
		this.words = words;
	}

	public Set getUserwordses() {
		return this.userwordses;
	}

	public void setUserwordses(Set userwordses) {
		this.userwordses = userwordses;
	}

}