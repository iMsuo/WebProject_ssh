package model.system;

import java.util.Set;

/**
 * UserInfo entity. @author MyEclipse Persistence Tools
 */
public class UserInfo extends AbstractUserInfo implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public UserInfo() {
	}

	/** full constructor */
	public UserInfo(String username, String password, String email,
			String headerpic, Set tickets, Set userwordses, Set ticketWordses) {
		super(username,password,email,
				headerpic,tickets,userwordses,ticketWordses);
	}

}
