package com.w2020.submittals.pojo;

import java.util.Date;
import java.util.List;

public class Email {

	private String subject;
	private String jobName;
	private String submittalNo;
	private String transNo;
	private String detailer;
	private String description;
	private String hcec;
	private String dateRec;
	private String dateSend;
	private String action;
	private String sendTo;
	private String via;
	private List<String> atachments;

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getSubmittalNo() {
		return submittalNo;
	}

	public void setSubmittalNo(String submittalNo) {
		this.submittalNo = submittalNo;
	}

	public String getTransNo() {
		return transNo;
	}

	public void setTransNo(String transNo) {
		this.transNo = transNo;
	}

	public String getDetailer() {
		return detailer;
	}

	public void setDetailer(String detailer) {
		this.detailer = detailer;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getHcec() {
		return hcec;
	}

	public void setHcec(String hcec) {
		this.hcec = hcec;
	}

	public String getDateRec() {
		return dateRec;
	}

	public void setDateRec(String dateRec) {
		this.dateRec = dateRec;
	}

	public String getDateSend() {
		return dateSend;
	}

	public void setDateSend(String dateSend) {
		this.dateSend = dateSend;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getSendTo() {
		return sendTo;
	}

	public void setSendTo(String sendTo) {
		this.sendTo = sendTo;
	}

	public String getVia() {
		return via;
	}

	public void setVia(String via) {
		this.via = via;
	}

	public List<String> getAtachments() {
		return atachments;
	}

	public void setAtachments(List<String> atachments) {
		this.atachments = atachments;
	}

	@Override
	public String toString() {
		return "Email [subject=" + subject + ", jobName=" + jobName + ", submittalNo=" + submittalNo + ", transNo="
				+ transNo + ", detailer=" + detailer + ", description=" + description + ", hcec=" + hcec + ", dateRec="
				+ dateRec + ", dateSend=" + dateSend + ", action=" + action + ", sendTo=" + sendTo + ", via=" + via
				+ ", atachments=" + atachments + "]";
	}

}
