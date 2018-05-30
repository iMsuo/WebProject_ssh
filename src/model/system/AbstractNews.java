package model.system;

import java.util.Date;

/**
 * AbstractNews entity provides the base persistence definition of the News
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractNews implements java.io.Serializable {

	// Fields

	private Integer id;
	private String subject;
	private String contents;
	private Date time;
	private Integer part;
	private String picurl;
	private Integer counts;

	// Constructors

	/** default constructor */
	public AbstractNews() {
	}

	/** minimal constructor */
	public AbstractNews(Integer counts) {
		this.counts = counts;
	}

	/** full constructor */
	public AbstractNews(String subject, String contents, Date time,
			Integer part, String picurl, Integer counts) {
		this.subject = subject;
		this.contents = contents;
		this.time = time;
		this.part = part;
		this.picurl = picurl;
		this.counts = counts;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContents() {
		return this.contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public Date getTime() {
		return this.time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Integer getPart() {
		return this.part;
	}

	public void setPart(Integer part) {
		this.part = part;
	}

	public String getPicurl() {
		return this.picurl;
	}

	public void setPicurl(String picurl) {
		this.picurl = picurl;
	}

	public Integer getCounts() {
		return this.counts;
	}

	public void setCounts(Integer counts) {
		this.counts = counts;
	}

}