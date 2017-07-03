package com.w2020.submittals.service;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;

import org.springframework.stereotype.Component;

import com.w2020.submittals.pojo.Email;

@Component
public class CheckingMails {

	public  List<Email> getEmails() {

		Properties properties = new Properties();
		/*
		 * Properties emailProperties = new Properties(); InputStream input =
		 * null;
		 */
		/*
		 * String host = emailProperties.getProperty("host"); String storeType =
		 * emailProperties.getProperty("mailStoreType"); String user =
		 * emailProperties.getProperty("username"); String password =
		 * emailProperties.getProperty("password");
		 */

		try {
			properties.put("mail.pop3.host", "pop.gmail.com");
			properties.put("mail.pop3.port", 995);
			properties.put("mail.pop3.starttls.enable", "true");
			Session emailSession = Session.getDefaultInstance(properties);

			// create the POP3 store object and connect with the pop server
			Store store = emailSession.getStore("pop3s");

			store.connect("pop.gmail.com", "besnik.palluqi@gmail.com", "Darkmoon35");

			// create the folder object and open it
			Folder emailFolder = store.getFolder("INBOX");
			emailFolder.open(Folder.READ_ONLY);

			// retrieve the messages from the folder in an array and print it
			Message[] messages = emailFolder.getMessages();
			System.out.println("messages.length---" + messages.length);

			List<Email> emailList = new ArrayList<Email>();

			for (int i = 0, n = messages.length; i < n; i++) {
				if(i==50){
					break;
				}
				Email emails = new Email();
				emails.setFrom(messages[i].getFrom()[0]);
				emails.setSubject(messages[i].getSubject());
				emails.setText(messages[i].getContent().toString());
				emailList.add(emails);
			}

			// close the store and folder objects
			emailFolder.close(false);
			store.close();
			return emailList;

		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

/*	public static void main(String[] args) {
		getEmails();
		long startTime = System.currentTimeMillis();
		long endTime = System.currentTimeMillis();
		long executeTime = endTime - startTime;
		System.out.println("Time: " + executeTime);
		for (Email email : getEmails()) {
			System.out.println(email.toString());
		}
	}*/

}