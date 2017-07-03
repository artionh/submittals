package com.w2020.submittals.pojo;

import javax.mail.Address;

public class Email {
	
	private String Subject;
	private Address From;
	private String Text;

	public String getSubject() {
		return Subject;
	}

	public void setSubject(String subject) {
		Subject = subject;
	}

	public Address getFrom() {
		return From;
	}

	public void setFrom(Address address) {
		From = address;
	}

	public String getText() {
		return Text;
	}

	public void setText(String text) {
		Text = text;
	}

	@Override
	public String toString() {
		return "Email [Subject=" + Subject + ", From=" + From + ", Text=" + Text + "]";
	}

}
