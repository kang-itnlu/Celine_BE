package celine_amireux.com.vn.CelineBE.tools;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {
    private final static String username="ndkhang.itnlu@gmail.com";
    private final static String password="DuYKhanG33919";
    public static boolean sendMail(String to, String subject, String text) {
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS

      Authenticator auth = new Authenticator() {
          protected  PasswordAuthentication getPasswordAuthentication(){
              return new PasswordAuthentication(username, password);}
      };
    Session session = Session.getInstance(prop,auth);
        try {
            Message message = new MimeMessage(session);
            message.setHeader("Content-Type", "text/plain; charset=UTF-8");
            message.addHeader("format","flowed");
            message.addHeader("Content-Transfer-Encoding", "8bit");
            message.setFrom(new InternetAddress(username,"Celine"));
            message.setSubject(subject);
            message.setText(text);
            message.setSentDate(new Date());
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to,false));

            Transport.send(message);
        } catch (MessagingException | UnsupportedEncodingException e) {
            return false;
        }
        return true;
    }

}

