package model.system;

import java.util.HashSet;
import java.util.Set;

/**
 * AbstractTicket entity provides the base persistence definition of the Ticket
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractTicket implements java.io.Serializable {

	// Fields

	private Integer id;
	private Lanmu lanmu;
	private UserInfo userInfo;
	private String subjectcontent;
	private String words;
	private Set userwordses = new HashSet(0);
	private Set ticketWordses = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractTicket() {
	}

	/** full constructor */
	public AbstractTicket(Lanmu lanmu, UserInfo userInfo,
			String subjectcontent, String words, Set userwordses,
			Set ticketWordses) {
		this.lanmu = lanmu;
		this.userInfo = userInfo;
		this.subjectcontent = subjectcontent;
		this.words = words;
		this.userwordses = userwordses;
		this.ticketWordses = ticketWordses;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Lanmu getLanmu() {
		return this.lanmu;
	}

	public void setLanmu(Lanmu lanmu) {
		this.lanmu = lanmu;
	}

	public UserInfo getUserInfo() {
		return this.userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public String getSubjectcontent() {
		return this.subjectcontent;
	}

	public void setSubjectcontent(String subjectcontent) {
		this.subjectcontent = subjectcontent;
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

	public Set getTicketWordses() {
		return this.ticketWordses;
	}

	public void setTicketWordses(Set ticketWordses) {
		this.ticketWordses = ticketWordses;
	}

}