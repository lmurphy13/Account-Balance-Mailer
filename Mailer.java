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

        Parse p = new Parse();
        p.parse();

        ArrayList<Account> accounts = p.getAccounts();

        String sender = "sender";
        String host = "smtp.gmail.com";

        Properties properties  = System.getProperties();
        //properties.setProperty("mail.smtp.host", host);

        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        //Session session = Session.getDefaultInstance(properties);


        for (Account recipient : accounts) {

            if (recipient.getBalance() == 0.0)
                continue;

            Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("", "");
                }
            });
    
            session.setDebug(true);

            try {
                MimeMessage message = new MimeMessage(session);
                message.setFrom(new InternetAddress(sender));
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient.getEmail())); 
                
                message.setSubject(String.format("%s's Weekly Canteen Balance", recipient.getName()));
                String acct = recipient.toString();
                String msg = "Hello! Here is your canteen summary as of today:\n\n";
                msg = msg + acct;
                msg = msg + "\n\n-Liam";

                message.setText(msg);
    
                Transport.send(message); 
                System.out.println("Mail successfully sent"); 
            }
            catch (MessagingException mex) {
                mex.printStackTrace();
            }

        }

        
    }
}