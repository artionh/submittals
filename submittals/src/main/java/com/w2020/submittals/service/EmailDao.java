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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import javax.mail.internet.InternetAddress;
import javax.mail.Flags.Flag;
import javax.mail.search.FlagTerm;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.w2020.submittals.pojo.Email;
import com.w2020.submittals.pojo.EmailEntity;
import com.w2020.submittals.utils.converters.EmailConverter;

@Component
public class EmailDao {

	private static final EmailConverter EMAIL_CONVERTER = new EmailConverter();

	public List<Email> getEmails() {
		List<Email> emaiResponselList = new ArrayList<Email>();

		Properties properties = System.getProperties();
		properties.setProperty("mail.store.protocol", "imaps");

		try {
			Session session = Session.getDefaultInstance(properties, null);

			Store store = session.getStore("imaps");
			store.connect("imap.gmail.com", "w2020dev@gmail.com", "wdtvkpovupkujfhk");
			Folder emailFolder = store.getFolder("INBOX");
			emailFolder.open(Folder.READ_WRITE);

			Message[] messages = emailFolder.search(new FlagTerm(new Flags(Flag.SEEN), false));
			System.out.println("messages.length---" + messages.length);

			List<EmailEntity> emailList = new ArrayList<EmailEntity>();
			for (int i = 0, n = messages.length; i < n; i++) {

				EmailEntity email = getEmailEnvelope(messages[i]);
				emailList.add(email);
			}

			emailFolder.close(false);
			store.close();

			for (EmailEntity index : emailList) {
				emaiResponselList.add(EMAIL_CONVERTER.reverse().convert(index));
			}

			return emaiResponselList;

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
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM_dd_yyyy");
		SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		Message message = (Message) part;
		EmailEntity email = new EmailEntity();
		List<File> attachments = new ArrayList<File>();
		List<String> atachmentsPath = new ArrayList<String>();

		if (part.isMimeType("multipart/*")) {
			Multipart multipart = (Multipart) message.getContent();
			for (int i = 0; i < multipart.getCount(); i++) {
				BodyPart bodyPart = multipart.getBodyPart(i);

				if (!Part.ATTACHMENT.equalsIgnoreCase(bodyPart.getDisposition())
						&& !StringUtils.isNotBlank(bodyPart.getFileName())) {
					continue;
				}

				InputStream inputStream = bodyPart.getInputStream();
				File file = new File("/tmp/documents/" + dateFormat.format(date) + bodyPart.getFileName());
				FileOutputStream outputStream = new FileOutputStream(file);
				byte[] buffer = new byte[4096];
				int bytesRead;
				while ((bytesRead = inputStream.read(buffer)) != -1) {
					outputStream.write(buffer, 0, bytesRead);
				}
				outputStream.close();
				attachments.add(file);
				atachmentsPath.add(dateFormat.format(date) + bodyPart.getFileName());
			}

		}

		if (message.getRecipients(Message.RecipientType.TO) != null) {
			email.setSendTo((message.getRecipients(Message.RecipientType.TO)[0]).toString());
		}

		email.setDateRec(dateFormat1.format(message.getReceivedDate()).toString());
		email.setDateSend(null);
		String sentFrom = InternetAddress.toString(message.getFrom());
		sentFrom = sentFrom.substring(sentFrom.indexOf('@') + 1, sentFrom.length());
		sentFrom = sentFrom.substring(0, sentFrom.indexOf('.'));
		email.setVia(sentFrom);

		if (message.getSubject() != null) {
			email.setSubject(message.getSubject());
		}

		if (part.getContent() != null) {
			if (part.getContent() instanceof String) {
				email.applyRegexValidation(part.getContent().toString());
			} else if (part.getContent() instanceof Multipart) {
				Multipart multipart = (Multipart) part.getContent();
				BodyPart part1 = multipart.getBodyPart(0);
				part1.toString();
				email.applyRegexValidation(part1.getContent().toString());
			}
		}

		email.setAtachments(attachments);
		email.setAtachmentsFileName(atachmentsPath);

		return email;

	}

}