package com.w2020.submittals.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.mail.Address;
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
import com.w2020.submittals.pojo.Email;

@Component
public class CheckingMails {

	public static List<Email> getEmails() {

		Properties props = System.getProperties();
		props.setProperty("mail.store.protocol", "imaps");
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
			Session session = Session.getDefaultInstance(props, null);

			Store store = session.getStore("imaps");
			store.connect("pop.gmail.com", "besnik.palluqi@gmail.com", "Darkmoon35");
			Folder emailFolder = store.getFolder("INBOX");
			emailFolder.open(Folder.READ_ONLY);

			Message[] messages = emailFolder.search(new FlagTerm(new Flags(Flag.SEEN), false));
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
		List<File> attachments = new ArrayList<File>();

		if (part.isMimeType("multipart/*")) {
			Multipart multipart = (Multipart) message.getContent();
			for (int i = 0; i < multipart.getCount(); i++) {
				BodyPart bodyPart = multipart.getBodyPart(i);
				if (!Part.ATTACHMENT.equalsIgnoreCase(bodyPart.getDisposition())
						&& !StringUtils.isNotBlank(bodyPart.getFileName())) {
					continue;
				}
				InputStream is = bodyPart.getInputStream();
				File f = new File("/tmp/" + bodyPart.getFileName());
				FileOutputStream fos = new FileOutputStream(f);
				byte[] buf = new byte[4096];
				int bytesRead;
				while ((bytesRead = is.read(buf)) != -1) {
					fos.write(buf, 0, bytesRead);
				}
				fos.close();
				attachments.add(f);
			}

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

		email.setFrom(from);
		email.setTo(to);
		email.setAtachments(attachments);

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