package com.w2020.submittals.pojo;

/**
 * 
 * @author Besnik Palluqi
 * @version 1.0
 *
 */

import java.util.Date;

public class Rfi {

	private String askedBy;
	
	private Date date;
	
	private String question;
	
	private String location;

	public String getAskedBy() {
		return askedBy;
	}

	public void setAskedBy(String askedBy) {
		this.askedBy = askedBy;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}
