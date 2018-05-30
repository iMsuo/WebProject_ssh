package model.system;

/**
 * Userwords entity. @author MyEclipse Persistence Tools
 */
public class Userwords extends AbstractUserwords implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public Userwords() {
	}

	/** full constructor */
	public Userwords(TicketWords ticketWords, UserInfo userInfo, Ticket ticket,
			String words) {
		super(ticketWords, userInfo, ticket, words);
	}

}
