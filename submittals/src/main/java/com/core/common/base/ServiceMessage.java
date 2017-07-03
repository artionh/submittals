package com.core.common.base;

import com.fasterxml.jackson.annotation.JsonIgnore;


public class ServiceMessage {

	private String code;
	private String description;
	private ProblemSeverity severity;

	public ServiceMessage() {
		code = "";
		description = "";
		severity = ProblemSeverity.INFO;
	}

	public ServiceMessage(String code, String description, ProblemSeverity severity) {
		this.code = code;
		this.description = description;
		this.severity = severity;
	}

	public String getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}

	public ProblemSeverity getSeverity() {
		return severity;
	}
	
	@JsonIgnore
	public String getResponseAsString() {
		StringBuilder responseAsString = new StringBuilder();
		responseAsString.append(severity).append("  ").append(code).append("  ").append(description);
		
		return responseAsString.toString();
		
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setSeverity(ProblemSeverity severity) {
		this.severity = severity;
	}

	
	@Override
	public String toString() {
		return "ServiceMessage [code=" + code + ", description=" + description + ", severity=" + severity + "]";
	}
	
	
	
}

