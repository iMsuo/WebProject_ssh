package model.system;

/**
 * AbstractUserwords entity provides the base persistence definition of the
 * Userwords entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractUserwords implements java.io.Serializable {

	// Fields

	private Integer id;
	private TicketWords ticketWords;
	private UserInfo userInfo;
	private Ticket ticket;
	private String words;

	// Constructors

	/** default constructor */
	public AbstractUserwords() {
	}

	/** full constructor */
	public AbstractUserwords(TicketWords ticketWords, UserInfo userInfo,
			Ticket ticket, String words) {
		this.ticketWords = ticketWords;
		this.userInfo = userInfo;
		this.ticket = ticket;
		this.words = words;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TicketWords getTicketWords() {
		return this.ticketWords;
	}

	public void setTicketWords(TicketWords ticketWords) {
		this.ticketWords = ticketWords;
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

}