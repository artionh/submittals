package com.w2020.submittals.test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {

	private static int regexIndex = -1;

	public static void main(String[] args) {
		List<String> regexList = new ArrayList<String>();

		/*regexList.add("Submittal: \\s*([^\n\r]*)");
		regexList.add("Submittal - (\\s*[a-zA-Z0-9-]+)");
		regexList.add("submittal - (?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])");*/
		/* regexList.add("Submittal Submittal:\\s* [0-9-]*[a-z A-Z]"); */
	/*	regexList.add("Submittal ([0-9-]+)");*/
		/*regexList.add("Submittal: ([0-9,]+)");*/
		regexList.add("Submittal:*\\s*-*\\s*([0-9-a-zA-Z]+)");
		regexList.add("Description: \\s*[0-9-]*[a-z A-Z]*-*");
		regexList.add("Project:*\\s*([^\n]*) St|Street");

		String submittal = "Project: 122 E 23rd St. Submittal: 034500-032N Architectural Precast Concrete Description: This is for development purposeses Resubmittal: Calculations - North Tower Design Calcs (Submittal 034500-001N-1) Submitted By: CM & Associates";

		for (String i : regexList) {
			Pattern p = Pattern.compile(i);
			Matcher m = p.matcher(submittal);
			while (m.find()) {
				System.out.println("Found a " + m.group() + ".");
			}
		}

		// String sub = "Submittal - 034500-032 ";
		//
		// for(String i : regexList){
		// if(sub.matches(i)){
		// System.out.println(sub+" matches "+i);
		// regexIndex = regexList.indexOf(i);
		// System.out.println(regexIndex);
		// break;
		// }
		// }

		// switch(regexIndex){
		// case 0 :
		// submittal = submittal.replaceFirst("Submittal: ", "");
		// submittal = submittal.replaceFirst(" [a-zA-Z0-9 ]+", "");
		// System.out.println("Not allowed 0");
		// break;
		// case 1 :
		// submittal = submittal.replaceFirst("Submittal: ", "");
		// submittal = submittal.replaceFirst(" [a-zA-Z0-9 ]+", "");
		// System.out.println(submittal);
		// break;
		// case 2 :
		// System.out.println("Not allowed 2");
		// break;
		// case 3 :
		// System.out.println("Not allowed 3");
		// break;
		// case 4 :
		// System.out.println("Not allowed 4");
		// break;
		// default :
		// System.out.println("Not allowed");break;
		// }
	}
}