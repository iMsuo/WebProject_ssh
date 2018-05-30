package model.system;

/**
 * ShowBookList entity. @author MyEclipse Persistence Tools
 */
public class ShowBookList extends AbstractShowBookList implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public ShowBookList() {
	}

	/** full constructor */
	public ShowBookList(Books books, BookList bookList) {
		super(books, bookList);
	}

}
