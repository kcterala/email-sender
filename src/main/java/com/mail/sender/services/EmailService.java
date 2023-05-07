package com.mail.sender.services;


import com.mail.sender.Exceptions.InvalidContentException;
import com.mail.sender.Exceptions.PartnerAPIException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender javaMailSender;

    @Autowired
    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendEmail(String to, String subject, String body) throws InvalidContentException, PartnerAPIException {

        if (to == null || subject == null || body == null) {
            throw new InvalidContentException("To, subject and body fields must have a value");
        }

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        try {
            javaMailSender.send(message);
        } catch (Exception e) {
            throw new PartnerAPIException("ALERT : unable to send the mail, please validate the email address");
        }


    }
}
