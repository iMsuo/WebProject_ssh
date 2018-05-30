package model.system;

import java.util.Set;

/**
 * Ticket entity. @author MyEclipse Persistence Tools
 */
public class Ticket extends AbstractTicket implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Ticket() {
	}

	/** full constructor */
	public Ticket(Lanmu lanmu, UserInfo userInfo, String subjectcontent,
			String words, Set userwordses, Set ticketWordses) {
		super(lanmu, userInfo, subjectcontent, words, userwordses,
				ticketWordses);
	}

}
