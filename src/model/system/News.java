package model.system;

import java.util.Date;

/**
 * News entity. @author MyEclipse Persistence Tools
 */
public class News extends AbstractNews implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public News() {
	}

	/** minimal constructor */
	public News(Integer counts) {
		super(counts);
	}

	/** full constructor */
	public News(String subject, String contents, Date time, Integer part,
			String picurl, Integer counts) {
		super(subject, contents, time, part, picurl, counts);
	}

}
