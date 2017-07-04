package com.w2020.submittals.pojo;

import java.util.List;

import javax.mail.Address;

public class Email {

	private String Subject;
	private List<Address> From;
	private List<Address> To;
	private String Text;
	private List<String> atachments;

	public String getSubject() {
		return Subject;
	}

	public void setSubject(String subject) {
		Subject = subject;
	}

	public String getText() {
		return Text;
	}

	public void setText(String text) {
		Text = text;
	}

	public List<Address> getFrom() {
		return From;
	}

	public void setFrom(List<Address> from) {
		From = from;
	}

	public List<Address> getTo() {
		return To;
	}

	public void setTo(List<Address> to) {
		To = to;
	}

	public List<String> getAtachments() {
		return atachments;
	}

	public void setAtachments(List<String> atachments) {
		this.atachments = atachments;
	}

	@Override
	public String toString() {
		return "Email [Subject=" + Subject + ", From=" + From + ", To=" + To + ", Text=" + Text + ", atachments="
				+ atachments + "]";
	}

	
}
