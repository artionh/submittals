package com.w2020.submittals.pojo;

/**
 * 
 * @author Besnik Palluqi
 * @version 1.0
 *
 */
import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmailEntity {

	private String subject;
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
	private List<File> atachments;
	private List<String> atachmentsFileName;

	public EmailEntity() {
		this.regex = new Regex();
		Map<String, String> regexList = new HashMap<String, String>();
		regexList.put("submittal1", "Submittal: ([0-9,]+)");
		regexList.put("submittal2", "Submittal: \\s*([^\n\r]*)");
		regexList.put("submittal3", "Submittal - ([0-9-]+)");
		regexList.put("submittal4", "Submittal ([0-9-]+)");
		regexList.put("submittal5", "Submittal \\s*([^\n\r]*)");
		regexList.put("description", "Description: \\s*([^\n\r]*)");
		regexList.put("project", "Project: \\s*([^\n\r]*)");
		regex.setRegexList(regexList);
	}

	public void applyRegexValidation(String content) {
		for (String index : this.regex.getRegexList().keySet()) {

			if (index.contains("submittal")) {
				this.submittalNo = getValueFromRegexValidation(this.regex.getRegexList().get(index), content);
			} else if (index.equalsIgnoreCase("description")) {
				this.description = getValueFromRegexValidation(this.regex.getRegexList().get(index), content);
			} else if (index.equalsIgnoreCase("project")) {
				this.jobName = getValueFromRegexValidation(this.regex.getRegexList().get(index), content);
			}
		}
	}

	public String getValueFromRegexValidation(String regexPattern, String content) {

		if (content.matches(regexPattern)) {
			String filteredValue = content.split(regexPattern)[0];
			return filteredValue;
		}
		return "";
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

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public List<File> getAtachments() {
		return atachments;
	}

	public void setAtachments(List<File> atachments) {
		this.atachments = atachments;
	}

	public List<String> getAtachmentsFileName() {
		return atachmentsFileName;
	}

	public void setAtachmentsFileName(List<String> atachmentsFileName) {
		this.atachmentsFileName = atachmentsFileName;
	}

	@Override
	public String toString() {
		return "EmailEntity [subject=" + subject + ", jobName=" + jobName + ", submittalNo=" + submittalNo
				+ ", transNo=" + transNo + ", detailer=" + detailer + ", description=" + description + ", hcec=" + hcec
				+ ", dateRec=" + dateRec + ", dateSend=" + dateSend + ", action=" + action + ", sendTo=" + sendTo
				+ ", via=" + via + ", regex=" + regex + ", atachments=" + atachments + ", atachmentsFileName="
				+ atachmentsFileName + "]";
	}

}
