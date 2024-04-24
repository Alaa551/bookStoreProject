package com.example.bookStore.service;

import com.example.bookStore.model.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

//@Service
//public class EmailService {
//
//    @Autowired
//    private JavaMailSender emailSender;
//
//    public void sendSimpleMessage(Email email) {
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setTo(email.getTo());
//        message.setSubject(email.getSubject());
//        message.setText(email.getText());
//        emailSender.send(message);
//    }
//}


@Service
public class EmailService {
    @Autowired
    private JavaMailSender emailSender;

    public void sendEmail(Email email){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("alaaosna23@gmail.com.com");
        message.setTo(email.getTo());
        message.setSubject(email.getSubject());
        message.setText(email.getText());

        emailSender.send(message);

        System.out.println("Message sent successfully");
    }
}

