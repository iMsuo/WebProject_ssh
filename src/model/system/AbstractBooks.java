package model.system;

import java.util.HashSet;
import java.util.Set;

/**
 * AbstractBooks entity provides the base persistence definition of the Books
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractBooks implements java.io.Serializable {

	// Fields

	private Integer id;
	private String bookname;
	private String bookPicurl;
	private String simplediscrip;
	private Integer counts;
	private String author;
	private Set showBookLists = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractBooks() {
	}

	/** minimal constructor */
	public AbstractBooks(Integer counts) {
		this.counts = counts;
	}

	/** full constructor */
	public AbstractBooks(String bookname, String bookPicurl,
			String simplediscrip, Integer counts, String author,
			Set showBookLists) {
		this.bookname = bookname;
		this.bookPicurl = bookPicurl;
		this.simplediscrip = simplediscrip;
		this.counts = counts;
		this.author = author;
		this.showBookLists = showBookLists;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBookname() {
		return this.bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getBookPicurl() {
		return this.bookPicurl;
	}

	public void setBookPicurl(String bookPicurl) {
		this.bookPicurl = bookPicurl;
	}

	public String getSimplediscrip() {
		return this.simplediscrip;
	}

	public void setSimplediscrip(String simplediscrip) {
		this.simplediscrip = simplediscrip;
	}

	public Integer getCounts() {
		return this.counts;
	}

	public void setCounts(Integer counts) {
		this.counts = counts;
	}

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Set getShowBookLists() {
		return this.showBookLists;
	}

	public void setShowBookLists(Set showBookLists) {
		this.showBookLists = showBookLists;
	}

}