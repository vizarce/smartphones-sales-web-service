package com.vitaliy.zhakun.smartphones.service;

import com.vitaliy.zhakun.smartphones.model.EmailDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImplementation implements EmailService {


    private final JavaMailSender javaMailSender;
    //private final EmailDetails details;

    @Value("${spring.mail.username}")
    private String sender;

    @Autowired
    public EmailServiceImplementation(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }


    @Override
    public void sendSimpleMail(EmailDetails details) {
        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom(sender);
            mailMessage.setTo(details.getRecipient());
            mailMessage.setText(details.getMsgBody());
            mailMessage.setSubject(details.getSubject());

            javaMailSender.send(mailMessage);
            //return "Mail Sent Successfully...";
        } catch (Exception e) {
            //return "Error while Sending Mail";
            System.out.println("Error while Sending Mail");
        }
    }
}
