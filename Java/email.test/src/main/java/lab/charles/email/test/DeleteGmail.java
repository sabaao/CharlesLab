package lab.charles.email.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;

public class DeleteGmail {

	public static void main(String[] args) {
		DeleteGmail gmail = new DeleteGmail();
		gmail.delete();
	}

	public void delete() {
		Properties props = new Properties();
		try {
			props.setProperty("mail.smtp.host", "smtp.gmail.com");
			props.setProperty("mail.smtp.socketFactory.port", "465");
			props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			props.setProperty("mail.smtp.auth", "true");
			props.setProperty("mail.smtp.port", "465");
			
			Session session = Session.getDefaultInstance(props, null);

			Store store = session.getStore("p");
			store.connect("smtp.gmail.com", "sabaao35@gmail.com",
					"wf46rewf46re");

			Folder inbox = store.getFolder("inbox");
			inbox.open(Folder.READ_WRITE);
			BufferedReader reader = new BufferedReader(new InputStreamReader(
		            System.in));
		         // retrieve the messages from the folder in an array and print it
		         Message[] messages = inbox.getMessages();
		         System.out.println("messages.length---" + messages.length);
		         for (int i = 0; i < messages.length; i++) {
		            Message message = messages[i];
		            System.out.println("---------------------------------");
		            System.out.println("Email Number " + (i + 1));
		            System.out.println("Subject: " + message.getSubject());
		            System.out.println("From: " + message.getFrom()[0]);

		            String subject = message.getSubject();
		            System.out.print("Do you want to delete this message [y/n] ? ");
		            String ans = reader.readLine();
		            if ("Y".equals(ans) || "y".equals(ans)) {
			       // set the DELETE flag to true
			       message.setFlag(Flags.Flag.DELETED, true);
			       System.out.println("Marked DELETE for message: " + subject);
		            } else if ("n".equals(ans)) {
			       break;
		            }
		         }
		         // expunges the folder to remove messages which are marked deleted
		         inbox.close(true);
		         store.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
