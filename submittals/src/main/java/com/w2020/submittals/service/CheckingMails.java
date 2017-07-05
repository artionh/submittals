package com.w2020.submittals.service;

/**
 * 
 * @author Besnik Palluqi
 * @version 1.0
 *
 */

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.mail.BodyPart;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Flags.Flag;
import javax.mail.search.FlagTerm;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import com.w2020.submittals.pojo.EmailEntity;

@Component
public class CheckingMails {

	public static List<EmailEntity> getEmails() {

		Properties properties = System.getProperties();
		properties.setProperty("mail.store.protocol", "imaps");

		try {
			Session session = Session.getDefaultInstance(properties, null);

			Store store = session.getStore("imaps");
			store.connect("pop.gmail.com", "besnik.palluqi@gmail.com", "Darkmoon35");
			Folder emailFolder = store.getFolder("INBOX");
			emailFolder.open(Folder.READ_ONLY);

			Message[] messages = emailFolder.search(new FlagTerm(new Flags(Flag.SEEN), false));
			System.out.println("messages.length---" + messages.length);

			List<EmailEntity> emailList = new ArrayList<EmailEntity>();
			for (int i = 0, n = messages.length; i < n; i++) {

				EmailEntity email = getEmailEnvelope(messages[i]);
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

	public static EmailEntity getEmailEnvelope(Part part) throws Exception {
		Message message = (Message) part;
		EmailEntity email = new EmailEntity();
		List<File> attachments = new ArrayList<File>();

		if (part.isMimeType("multipart/*")) {
			Multipart multipart = (Multipart) message.getContent();
			for (int i = 0; i < multipart.getCount(); i++) {
				BodyPart bodyPart = multipart.getBodyPart(i);

				if (!Part.ATTACHMENT.equalsIgnoreCase(bodyPart.getDisposition())
						&& !StringUtils.isNotBlank(bodyPart.getFileName())) {
					continue;
				}

				InputStream inputStream = bodyPart.getInputStream();
				File file = new File("/tmp/" + bodyPart.getFileName());
				FileOutputStream outputStream = new FileOutputStream(file);
				byte[] buffer = new byte[4096];
				int bytesRead;
				while ((bytesRead = inputStream.read(buffer)) != -1) {
					outputStream.write(buffer, 0, bytesRead);
				}
				outputStream.close();
				attachments.add(file);
			}

		}

		if (message.getRecipients(Message.RecipientType.TO) != null) {
			email.setSendTo((message.getRecipients(Message.RecipientType.TO)[0]).toString());
		}

		if (message.getSubject() != null) {
			email.setSubject(message.getSubject());
		}

		if (part.getContent() != null) {
			email.applyRegexValidation(part.getContent().toString());
		}

		email.setAtachments(attachments);

		return email;

	}

	public static void main(String[] args) {

		long startTime = System.currentTimeMillis();
		long endTime = System.currentTimeMillis();

		for (EmailEntity email : getEmails()) {
			System.out.println(email.toString());
		}
		long executeTime = endTime - startTime;
		System.out.println("Time: " + executeTime);
	}

}