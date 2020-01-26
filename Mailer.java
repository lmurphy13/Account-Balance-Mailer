/**
 * Mailer.java
 * 
 * This class contains the main logic for creating and sending weekly canteen updates to each account
 * 
 * @author Liam M. Murphy
 * @version January 2020
 */

import java.util.*; 
import javax.mail.*; 
import javax.mail.internet.*; 
import javax.activation.*; 
import javax.mail.Session; 
import javax.mail.Transport;

public class Mailer {
    public static void main(String[] args) {

        // TODO: Modify recipients to use access email fields from Account objects
        // TODO: Modify sender to pull from text file for more portability

        String sender = "sender";
        String host = "smtp.gmail.com";

        Properties properties  = System.getProperties();
        //properties.setProperty("mail.smtp.host", host);

        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        //Session session = Session.getDefaultInstance(properties);

        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("email", "password");
            }
        });

        session.setDebug(true);

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(sender));

            for (String recipient : recipients) {
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient)); 
            }

            
            message.setSubject("Weekly Canteen Balance");
            message.setText("Hello!\nThis is a test of the mailing program. \n\n-Liam"); 

            Transport.send(message); 
            System.out.println("Mail successfully sent"); 
        }
        catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}