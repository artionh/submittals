package com.w2020.submittals.test;

import java.util.ArrayList;
import java.util.List;

public class RegexTest {

	private static int regexIndex = -1;
	
	public static void main(String[] args){
		List<String> regexList = new ArrayList<String>();
		regexList.add("Submittal: ([0-9,]+)");
		regexList.add("Submittal: \\s*([^\n\r]*)");
		regexList.add("Submittal - (\\s*[a-zA-Z0-9-]+)");
		regexList.add("submittal - (?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])");
		regexList.add("Submittal ([0-9-]+)");
		regexList.add("Submittal \\s*([^\n\r]*)");
		regexList.add("Submittal[a-z0-9A-Z-\\s:]+");
//		regexList.add("Description: \\s*([^\n\r]*)");
//		regexList.add("Project: \\s*([^\n\r]*)");
		
		String submittal = "Project: 122 E 23rd St.Section: Submittal - 034500-032 Architectural Precast ConcreteDescription: This is for development purposesesResubmittal: Calculations - North Tower Design Calcs (Submittal 034500-001N-1)SubmittedBy: CM & Associates";
		StringBuilder submittialStringBuilder = new StringBuilder(submittal);
		int indexOfSection = submittal.indexOf("Section");
		System.out.println(indexOfSection);
		int indexOfDescription = submittal.indexOf("Description");
		System.out.println(indexOfDescription);
		int indexOfResubmittal = submittal.indexOf("Resubmittal");
		System.out.println(indexOfResubmittal);
		int a = submittal.indexOf("Submitted By");
		
		if(a == -1){
			a = submittal.indexOf("SubmittedBy");
		}

		
		submittialStringBuilder.insert(indexOfSection, "\n");
		submittialStringBuilder.insert(indexOfDescription+1, "\n");
		submittialStringBuilder.insert(indexOfResubmittal+2, "\n");
		submittialStringBuilder.insert(a+3, "\n");
		
		//added
		String[] project = submittialStringBuilder.toString().split("\n");
		String submittalModified = "";
		String content = "";
		
		for(String i : project){
			if(i.contains("Project")){
				submittalModified += i.replaceFirst("Project:", "");
			}
			else if(i.contains("Section")){
				content = i.split("Section([\\s:-]*)")[1];
				submittalModified += i.replace("Section:", "\n");
			}
			else if(i.contains("Description")){
				submittalModified += i.replace("Description:", "\n");
			}
			else if(i.contains("Resubmittal")){
				submittalModified += i.replace("Resubmittal:", "\n");
			}
			else {
				submittalModified += i.replace("Submitted By:", "\n");
			}
		}
		
		System.out.println(content);
		
		for(String i :regexList){
			if(content.matches(i)){
				System.out.println("Matches "+regexList.indexOf(i));
			}
		}
		
		System.out.println(submittalModified);
		
//		String sub = "Submittal - 034500-032 ";
//		
//		for(String i : regexList){
//			if(sub.matches(i)){
//				System.out.println(sub+" matches "+i);
//				regexIndex = regexList.indexOf(i);
//				System.out.println(regexIndex);
//				break;
//			}
//		}
		
//		switch(regexIndex){
//		case 0 :
//			submittal = submittal.replaceFirst("Submittal: ", "");
//			submittal = submittal.replaceFirst(" [a-zA-Z0-9 ]+", "");
//			System.out.println("Not allowed 0");
//			break;
//		case 1 :
//			submittal = submittal.replaceFirst("Submittal: ", "");
//			submittal = submittal.replaceFirst(" [a-zA-Z0-9 ]+", "");
//			System.out.println(submittal);
//			break;
//		case 2 :
//			System.out.println("Not allowed 2");
//			break;
//		case 3 :
//			System.out.println("Not allowed 3");
//			break;
//		case 4 :
//			System.out.println("Not allowed 4");
//			break;
//		default :
//			System.out.println("Not allowed");break;
//		}
	}
}