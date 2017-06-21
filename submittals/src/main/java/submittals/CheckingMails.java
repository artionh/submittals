package submittals;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;

public class CheckingMails {

	public static void check() {

		Properties properties = new Properties();
		Properties emailProperties = new Properties();
		InputStream input = null;
		String host = emailProperties.getProperty("host");
		String storeType = emailProperties.getProperty("mailStoreType");
		String user = emailProperties.getProperty("username");
		String password = emailProperties.getProperty("password");

		try {

			input = new FileInputStream("src/main/resources/properties/email.properties");
			emailProperties.load(input);
			properties.put(emailProperties.getProperty("mailHost"), host);
			properties.put(emailProperties.getProperty("mailport"), emailProperties.getProperty("port"));
			properties.put("mail.pop3.starttls.enable", "true");
			Session emailSession = Session.getDefaultInstance(properties);

			// create the POP3 store object and connect with the pop server
			Store store = emailSession.getStore(emailProperties.getProperty("store"));

			store.connect(host, user, password);

			// create the folder object and open it
			Folder emailFolder = store.getFolder("INBOX");
			emailFolder.open(Folder.READ_ONLY);

			// retrieve the messages from the folder in an array and print it
			Message[] messages = emailFolder.getMessages();
			System.out.println("messages.length---" + messages.length);

			/*
			 * for (int i = 0, n = messages.length; i < n; i++) { Message
			 * message = messages[i];
			 * System.out.println("---------------------------------");
			 * System.out.println("Email Number " + (i + 1));
			 * System.out.println("Subject: " + message.getSubject());
			 * System.out.println("From: " + message.getFrom()[0]);
			 * System.out.println("Text: " + message.getContent().toString());
			 * 
			 * }
			 */

			// close the store and folder objects
			emailFolder.close(false);
			store.close();

		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		long startTime = System.currentTimeMillis();
		check();
		long endTime = System.currentTimeMillis();
		long executeTime = endTime - startTime;
		System.out.println("Time: " + executeTime);
	}

}