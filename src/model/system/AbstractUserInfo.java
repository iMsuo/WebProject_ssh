package model.system;

import java.util.HashSet;
import java.util.Set;

/**
 * AbstractUserInfo entity provides the base persistence definition of the
 * UserInfo entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractUserInfo implements java.io.Serializable {

	// Fields

	private Integer id;
	private String username;
	private String password;
	private String email;
	private String headerpic;
	private Set tickets = new HashSet(0);
	private Set userwordses = new HashSet(0);
	private Set ticketWordses = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractUserInfo() {
	}

	/** minimal constructor */
	public AbstractUserInfo(String username, String password) {
		this.username = username;
		this.password = password;
	}

	/** full constructor */
	public AbstractUserInfo(String username, String password, String email,
			String headerpic, Set tickets, Set userwordses, Set ticketWordses) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.headerpic = headerpic;
		this.tickets = tickets;
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

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHeaderpic() {
		return this.headerpic;
	}

	public void setHeaderpic(String headerpic) {
		this.headerpic = headerpic;
	}

	public Set getTickets() {
		return this.tickets;
	}

	public void setTickets(Set tickets) {
		this.tickets = tickets;
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