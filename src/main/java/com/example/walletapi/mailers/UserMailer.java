package com.example.walletapi.mailers;

import jakarta.mail.*;
import jakarta.mail.internet.*;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

@Service
public class UserMailer {

    @Bean
    public void sendMail() {
         // throws AddressException, MessagingException, IOException
        try {
            Properties prop = new Properties();
            prop.put("mail.smtp.auth", "true");
            prop.put("mail.smtp.starttls.enable", "true");
            prop.put("mail.smtp.host", "smtp.gmail.com");
            prop.put("mail.smtp.port", "587");

            Session session = Session.getInstance(prop, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("ainunjariya365@gmail.com", "22per7phi");
                }
            });

            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress("ainunjariya365@gmail.com", false));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("aj.biner@gmail.com"));
            msg.setSubject("WalletAPI - test mail");
            msg.setContent("WalletAPI - test mail", "text/html");
            msg.setSentDate(new Date());

            MimeBodyPart mbp = new MimeBodyPart();
            mbp.setContent("WalletAPI - test mail", "text/html");

            // //       ATTACH A FILE
            //        Multipart m = new MimeMultipart();
            //        m.addBodyPart(mbp);
            //        MimeBodyPart attachPart = new MimeBodyPart();
            //        attachPart.attachFile("/filepath.png");
            //        m.addBodyPart(attachPart);
            //        msg.setContent(m);

            Transport.send(msg);
        } catch(AddressException e) {
            System.out.println(e.getMessage());
        } catch(MessagingException e) {
            System.out.println(e.getMessage());
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

    }


}
