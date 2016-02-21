package lab.charles.email.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Flags.Flag;
import javax.mail.search.FlagTerm;
public class DeleteMailSample {
    Properties properties = null;
    private Session session = null;
    private Store store = null;
    private Folder inbox = null;
    private Message messages[];
    private String userName = "********@gmail.com";// provide user name
    private String password = "password";// provide password
    public DeleteMailSample() {
    }

    public void getMails() throws MessagingException {
        getConnection();
        readMails();
        if (null != messages && messages.length > 0) {
            System.out.println("trying to delete  first mail...");
            System.out.println("subject:" + messages[0].getSubject());
            deleteMessage(messages[0]);
            closeSession();
        }
    }

   public void getConnection() {
        properties = new Properties();
        properties.setProperty("mail.host", "imap.gmail.com");
        properties.setProperty("mail.port", "995");
        properties.setProperty("mail.transport.protocol", "imaps");
        session = Session.getInstance(properties,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(userName, password);
                    }
                });
        try {
            store = session.getStore("imaps");
            store.connect();
            inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_WRITE);
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

     public void readMails() {
        try {
            if (null != inbox) {
//                messages = inbox.search(new FlagTerm(new Flags(Flag.SEEN),false));
            	messages = inbox.getMessages();
                System.out.println("Number of mails = " + messages.length);
//                for (int i = 0; i < messages.length; i++) {
//                    Message message = messages[i];
//                    Address[] from = message.getFrom();
//                    System.out.println("-------------------------------");
//                    System.out.println("Date : " + message.getSentDate());
//                    System.out.println("From : " + from[0]);
//                    System.out.println("Subject: " + message.getSubject());
//                    System.out.println("Content :");
//                    processMessageBody(message);
//                    System.out.println("--------------------------------");
//                }
            }
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public void closeSession() {
        if (null != inbox && null != store) {
            try {
                inbox.close(true);
                store.close();
            } catch (MessagingException e) {
                e.printStackTrace();
            }
        }
    }
    public void deleteMessage(Message message) {
        try {
            message.setFlag(Flags.Flag.DELETED, true);
            System.out.println("deleted mail");
        } catch (MessagingException e) {
           e.printStackTrace();
        }
    }
    public void processMessageBody(Message message) {
        try {
            Object content = message.getContent();
           // check for string
            // then check for multipart
            if (content instanceof String) {
                System.out.println(content);
            } else if (content instanceof Multipart) {
                Multipart multiPart = (Multipart) content;
                procesMultiPart(multiPart);
            } else if (content instanceof InputStream) {
                InputStream inStream = (InputStream) content;
                int ch;
                while ((ch = inStream.read()) != -1) {
                    System.out.write(ch);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public void procesMultiPart(Multipart content) {
        try {
            int multiPartCount = content.getCount();
            for (int i = 0; i < multiPartCount; i++) {
                BodyPart bodyPart = content.getBodyPart(i);
                Object o;
                o = bodyPart.getContent();
                if (o instanceof String) {
                    System.out.println(o);
                } else if (o instanceof Multipart) {
                    procesMultiPart((Multipart) o);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws MessagingException {
        DeleteMailSample sample = new DeleteMailSample();
        sample.getMails();
    }
}