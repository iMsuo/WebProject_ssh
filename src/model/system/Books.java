package model.system;

import java.util.Set;

/**
 * Books entity. @author MyEclipse Persistence Tools
 */
public class Books extends AbstractBooks implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Books() {
	}

	/** minimal constructor */
	public Books(Integer counts) {
		super(counts);
	}

	/** full constructor */
	public Books(String bookname, String bookPicurl, String simplediscrip,
			Integer counts, String author, Set showBookLists) {
		super(bookname, bookPicurl, simplediscrip, counts, author,
				showBookLists);
	}

}
