package com.w2020.submittals.pojo;

/**
 * 
 * @author Besnik Palluqi
 * @version 1.0
 *
 */
import java.util.Map;

public class Regex {

	private Map<String, String> regexList;

	public Map<String, String> getRegexList() {
		return regexList;
	}

	public void setRegexList(Map<String, String> regexList) {
		this.regexList = regexList;
	}

	@Override
	public String toString() {
		return "Regex [regexList=" + regexList + "]";
	}

}
