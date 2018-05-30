package model.system;

import java.util.Set;

/**
 * BookList entity. @author MyEclipse Persistence Tools
 */
public class BookList extends AbstractBookList implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public BookList() {
	}

	/** full constructor */
	public BookList(String booklistName, String booklistDiscrip,
			String booklistPicurl, Set showBookLists) {
		super(booklistName, booklistDiscrip, booklistPicurl, showBookLists);
	}

}
