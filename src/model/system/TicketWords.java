package model.system;

import java.util.Set;

/**
 * TicketWords entity. @author MyEclipse Persistence Tools
 */
public class TicketWords extends AbstractTicketWords implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public TicketWords() {
	}

	/** full constructor */
	public TicketWords(UserInfo userInfo, Ticket ticket, String words,
			Set userwordses) {
		super(userInfo, ticket, words, userwordses);
	}

}
