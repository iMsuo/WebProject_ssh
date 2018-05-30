package model.system;

/**
 * AbstractShowBookList entity provides the base persistence definition of the
 * ShowBookList entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractShowBookList implements java.io.Serializable {

	// Fields

	private Integer id;
	private Books books;
	private BookList bookList;

	// Constructors

	/** default constructor */
	public AbstractShowBookList() {
	}

	/** full constructor */
	public AbstractShowBookList(Books books, BookList bookList) {
		this.books = books;
		this.bookList = bookList;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Books getBooks() {
		return this.books;
	}

	public void setBooks(Books books) {
		this.books = books;
	}

	public BookList getBookList() {
		return this.bookList;
	}

	public void setBookList(BookList bookList) {
		this.bookList = bookList;
	}

}