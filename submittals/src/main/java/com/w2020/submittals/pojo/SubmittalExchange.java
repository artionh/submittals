package com.w2020.submittals.pojo;

/**
 * 
 * @author Besnik Palluqi
 * @version 1.0
 *
 */

import java.util.Date;

public class SubmittalExchange {
	
	private String project;
	
	private String section;
	
	private String description;
	
	private String submitedBy;
	
	private String priority;
	
	private Date responseRequestBy;

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSubmitedBy() {
		return submitedBy;
	}

	public void setSubmitedBy(String submitedBy) {
		this.submitedBy = submitedBy;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public Date getResponseRequestBy() {
		return responseRequestBy;
	}

	public void setResponseRequestBy(Date responseRequestBy) {
		this.responseRequestBy = responseRequestBy;
	}
	
}
