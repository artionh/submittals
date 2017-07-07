package com.w2020.submittals.pojo;

/**
 * 
 * @author Besnik Palluqi
 * @version 1.0
 *
 */
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailEntity {

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
	private Regex regex;
	private List<File> atachments;
	private List<String> atachmentsFileName;

	public EmailEntity() {
		this.regex = new Regex();
		Map<String, String> regexList = new HashMap<String, String>();
		regexList.put("submittal1", "Submittal:*\\s*-*\\s*([0-9-a-zA-Z]+)");
		/*
		 * regexList.put("submittal2", "Submittal: \\s*([^\n\r]*)");
		 * regexList.put("submittal3", "Submittal - (\\s*[a-zA-Z0-9-]+)");
		 * regexList.put("submittal4",
		 * "submittal - (?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])");
		 * regexList.put("submittal5", "Submittal ([0-9-]+)");
		 * regexList.put("submittal6", "Submittal \\s*([^\n\r]*)");
		 * regexList.put("submittal7", "Submittal[a-z0-9A-Z-\\s:]+");
		 */
		regexList.put("description", "Description: \\s*[0-9-]*[a-z A-Z]*-*");
		regexList.put("project", "Project:*\\s*([^\n]*) St|Street");
		regexList.put("action", "Stage:*\\s*([^\n]*)");
		regex.setRegexList(regexList);
	}

	public void applyRegexValidation(String content) {
		String editedContent = content;
		this.setTransNo("XXX");
		this.setHcec("EC");

		for (String index : this.regex.getRegexList().keySet()) {

			if (index.contains("action")) {
				this.action = getValueFromRegexValidation(this.regex.getRegexList().get(index), editedContent);

				if (this.getAction().contains("Stage:")) {
					this.action = this.action.replace("Stage:", "");
				} else if (this.getAction().contains("\r")) {
					this.action = this.action.replace("\r", "");
				}
			}

			if (index.contains("submittal")) {
				this.submittalNo = getValueFromRegexValidation(this.regex.getRegexList().get(index), editedContent);

				if (this.getSubmittalNo().contains("Submittal:")) {
					this.submittalNo = this.submittalNo.replace("Submittal:", "");
				} else if (this.getSubmittalNo().contains("Submittal -")) {
					this.submittalNo = this.submittalNo.replace("Submittal -", "");
				} else if (this.getSubmittalNo().contains("Submittal")) {
					this.submittalNo = this.submittalNo.replace("Submittal", "");
				}
			} else if (index.equalsIgnoreCase("description")) {
				this.description = getValueFromRegexValidation(this.regex.getRegexList().get(index), editedContent);

				if (this.getDescription().contains("Description:")) {
					this.description = this.description.replace("Description:", "");
				}
			} else if (index.equalsIgnoreCase("project")) {
				this.jobName = getValueFromRegexValidation(this.regex.getRegexList().get(index), editedContent);

				if (this.getJobName().contains("Project:")) {
					this.jobName = this.jobName.replace("Project:", "");
				}
			}

		}
	}

	public String editEmailContent(String emailContent) {
		StringBuilder submittialStringBuilder = new StringBuilder(emailContent);

		int indexOfSection = emailContent.indexOf("Section");
		int indexOfDescription = emailContent.indexOf("Description");
		int indexOfResubmittal = emailContent.indexOf("Resubmittal");
		int indexOfSubmittedBy = emailContent.indexOf("Submitted By");

		if (indexOfSubmittedBy == -1) {
			indexOfSubmittedBy = emailContent.indexOf("SubmittedBy");
		}

		if (indexOfSection != -1) {
			submittialStringBuilder.insert(indexOfSection, "\n");
		}

		if (indexOfDescription != -1) {
			submittialStringBuilder.insert(indexOfDescription + 1, "\n");
		}
		if (indexOfResubmittal != -1) {
			submittialStringBuilder.insert(indexOfResubmittal + 2, "\n");
		}
		if (indexOfSubmittedBy != -1) {
			submittialStringBuilder.insert(indexOfSubmittedBy + 3, "\n");
		}

		return submittialStringBuilder.toString();
	}

	public String getValueFromRegexValidation(String regexPattern, String content) {

		Pattern p = Pattern.compile(regexPattern);
		Matcher m = p.matcher(content);
		while (m.find()) {
			return m.group();
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
