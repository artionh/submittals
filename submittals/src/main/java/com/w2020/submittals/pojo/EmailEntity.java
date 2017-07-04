package com.w2020.submittals.pojo;

import java.util.Date;

public class EmailEntity {

	private String jobName;
	private String submittalNo;
	private String transNo;
	private String detailer;
	private String description;
	private String hcec;
	private Date dateRec;
	private Date dateSend;
	private String action;
	private String sendTo;
	private String via;
	private Regex regex;

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

	public Date getDateRec() {
		return dateRec;
	}

	public void setDateRec(Date dateRec) {
		this.dateRec = dateRec;
	}

	public Date getDateSend() {
		return dateSend;
	}

	public void setDateSend(Date dateSend) {
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

	public Regex getRegex() {
		return regex;
	}

	public void setRegex(Regex regex) {
		this.regex = regex;
	}

	@Override
	public String toString() {
		return "EmailEntity [jobName=" + jobName + ", submittalNo=" + submittalNo + ", transNo=" + transNo
				+ ", detailer=" + detailer + ", description=" + description + ", hcec=" + hcec + ", dateRec=" + dateRec
				+ ", dateSend=" + dateSend + ", action=" + action + ", sendTo=" + sendTo + ", via=" + via + ", regex="
				+ regex + "]";
	}

}
