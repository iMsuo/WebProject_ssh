package model.system;

import java.util.HashSet;
import java.util.Set;

/**
 * AbstractBookList entity provides the base persistence definition of the
 * BookList entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractBookList implements java.io.Serializable {

	// Fields

	private Integer id;
	private String booklistName;
	private String booklistDiscrip;
	private String booklistPicurl;
	private Set showBookLists = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractBookList() {
	}

	/** full constructor */
	public AbstractBookList(String booklistName, String booklistDiscrip,
			String booklistPicurl, Set showBookLists) {
		this.booklistName = booklistName;
		this.booklistDiscrip = booklistDiscrip;
		this.booklistPicurl = booklistPicurl;
		this.showBookLists = showBookLists;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBooklistName() {
		return this.booklistName;
	}

	public void setBooklistName(String booklistName) {
		this.booklistName = booklistName;
	}

	public String getBooklistDiscrip() {
		return this.booklistDiscrip;
	}

	public void setBooklistDiscrip(String booklistDiscrip) {
		this.booklistDiscrip = booklistDiscrip;
	}

	public String getBooklistPicurl() {
		return this.booklistPicurl;
	}

	public void setBooklistPicurl(String booklistPicurl) {
		this.booklistPicurl = booklistPicurl;
	}

	public Set getShowBookLists() {
		return this.showBookLists;
	}

	public void setShowBookLists(Set showBookLists) {
		this.showBookLists = showBookLists;
	}

}