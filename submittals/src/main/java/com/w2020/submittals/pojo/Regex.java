package com.w2020.submittals.pojo;
/**
 * 
 * @author Besnik Palluqi
 * @version 1.0
 *
 */
import java.util.List;

public class Regex {

	private List<String> regexList;

	public List<String> getRegexList() {
		return regexList;
	}

	public void setRegexList(List<String> regexList) {
		this.regexList = regexList;
	}

	@Override
	public String toString() {
		return "Regex [regexList=" + regexList + "]";
	}

}
