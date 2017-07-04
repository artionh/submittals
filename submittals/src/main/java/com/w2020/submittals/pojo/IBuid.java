package com.w2020.submittals.pojo;

import java.util.ArrayList;

/**
 * 
 * @author Besnik Palluqi
 * @version 1.0
 *
 */

public class IBuid {

	private String subject;
	private String from;
	private String to;
	private ArrayList<String> recipients;
	private String mailNotification;
	private String submittal;
	private ArrayList<String> attachments;
	private String primarySubmittalReviewers;
	private String consultantReviewers;
	private String itemDetails;
	private String activity;
	private String description;
	private String createdBy;
	private String actionBy;
	private String stage;
	private String project;
	private String applicationPath;
	private Regex regex;

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public ArrayList<String> getRecipients() {
		return recipients;
	}

	public void setRecipients(ArrayList<String> recipients) {
		this.recipients = recipients;
	}

	public String getMailNotification() {
		return mailNotification;
	}

	public void setMailNotification(String mailNotification) {
		this.mailNotification = mailNotification;
	}

	public String getSubmittal() {
		return submittal;
	}

	public void setSubmittal(String submittal) {
		this.submittal = submittal;
	}

	public ArrayList<String> getAttachments() {
		return attachments;
	}

	public void setAttachments(ArrayList<String> attachments) {
		this.attachments = attachments;
	}

	public String getPrimarySubmittalReviewers() {
		return primarySubmittalReviewers;
	}

	public void setPrimarySubmittalReviewers(String primarySubmittalReviewers) {
		this.primarySubmittalReviewers = primarySubmittalReviewers;
	}

	public String getConsultantReviewers() {
		return consultantReviewers;
	}

	public void setConsultantReviewers(String consultantReviewers) {
		this.consultantReviewers = consultantReviewers;
	}

	public String getItemDetails() {
		return itemDetails;
	}

	public void setItemDetails(String itemDetails) {
		this.itemDetails = itemDetails;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getActionBy() {
		return actionBy;
	}

	public void setActionBy(String actionBy) {
		this.actionBy = actionBy;
	}

	public String getStage() {
		return stage;
	}

	public void setStage(String stage) {
		this.stage = stage;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public String getApplicationPath() {
		return applicationPath;
	}

	public void setApplicationPath(String applicationPath) {
		this.applicationPath = applicationPath;
	}

	public Regex getRegex() {
		return regex;
	}

	public void setRegex(Regex regex) {
		this.regex = regex;
	}

	@Override
	public String toString() {
		return "IBuid [subject=" + subject + ", from=" + from + ", to=" + to + ", recipients=" + recipients
				+ ", mailNotification=" + mailNotification + ", submittal=" + submittal + ", attachments=" + attachments
				+ ", primarySubmittalReviewers=" + primarySubmittalReviewers + ", consultantReviewers="
				+ consultantReviewers + ", itemDetails=" + itemDetails + ", activity=" + activity + ", description="
				+ description + ", createdBy=" + createdBy + ", actionBy=" + actionBy + ", stage=" + stage
				+ ", project=" + project + ", applicationPath=" + applicationPath + ", regex=" + regex + "]";
	}
	
}
