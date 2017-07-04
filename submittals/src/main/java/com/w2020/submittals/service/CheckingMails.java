package com.w2020.submittals.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.Store;
import org.springframework.stereotype.Component;
import com.w2020.submittals.pojo.Email;

@Component
public class CheckingMails {

	public static List<Email> getEmails() {

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
			properties.put("mail.store.protocol", "pop3");
			properties.put("mail.pop3.host", "pop.gmail.com");
			properties.put("mail.pop3.port", "995");
			properties.put("mail.pop3.starttls.enable", "true");
			Session emailSession = Session.getDefaultInstance(properties);

			Store store = emailSession.getStore("pop3s");
			store.connect("pop.gmail.com", "besnik.palluqi@gmail.com", "Darkmoon35");
			Folder emailFolder = store.getFolder("INBOX");
			emailFolder.open(Folder.READ_ONLY);

			Message[] messages = emailFolder.getMessages();
			System.out.println("messages.length---" + messages.length);

			List<Email> emailList = new ArrayList<Email>();
			for (int i = 0, n = messages.length; i < n; i++) {

				Email email = getEnvelope(messages[i]);
				emailList.add(email);
			}

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

	public static Email getEnvelope(Part part) throws Exception {
		Message message = (Message) part;
		List<Address> from = new ArrayList<Address>();
		List<Address> to = new ArrayList<Address>();
		Email email = new Email();

		if (part.isMimeType("multipart/*")) {
			Multipart mp = (Multipart) part.getContent();
			for (int i = 0; i < mp.getCount(); i++) {

			}
			// get Atachments
		}

		if (message.getFrom() != null)

		{
			for (int j = 0; j < message.getFrom().length; j++)
				from.add(message.getFrom()[j]);
		}

		if (message.getRecipients(Message.RecipientType.TO) != null) {
			for (int j = 0; j < message.getRecipients(Message.RecipientType.TO).length; j++)
				to.add(message.getRecipients(Message.RecipientType.TO)[j]);
		}

		if (message.getSubject() != null) {
			email.setSubject(message.getSubject());
		}

		if (part.getContent() != null) {
			email.setText(part.getContent().toString());
		}
		
	/*	List<File> attachments = new ArrayList<File>();
		for (Message message : temp) {
		    Multipart multipart = (Multipart) message.getContent();
		    // System.out.println(multipart.getCount());

		    for (int i = 0; i < multipart.getCount(); i++) {
		        BodyPart bodyPart = multipart.getBodyPart(i);
		        if(!Part.ATTACHMENT.equalsIgnoreCase(bodyPart.getDisposition()) &&
		               !StringUtils.isNotBlank(bodyPart.getFileName())) {
		            continue; // dealing with attachments only
		        } 
		        InputStream is = bodyPart.getInputStream();
		        File f = new File("/tmp/" + bodyPart.getFileName());
		        FileOutputStream fos = new FileOutputStream(f);
		        byte[] buf = new byte[4096];
		        int bytesRead;
		        while((bytesRead = is.read(buf))!=-1) {
		            fos.write(buf, 0, bytesRead);
		        }
		        fos.close();
		        attachments.add(f);
		    }*/

		email.setFrom(from);
		email.setTo(to);

		return email;

	}

	public static void main(String[] args) {

		long startTime = System.currentTimeMillis();
		long endTime = System.currentTimeMillis();

		for (Email email : getEmails()) {
			System.out.println(email.toString());
		}
		long executeTime = endTime - startTime;
		System.out.println("Time: " + executeTime);
	}

}