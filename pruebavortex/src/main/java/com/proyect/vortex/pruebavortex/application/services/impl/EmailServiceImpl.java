package com.proyect.vortex.pruebavortex.application.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.proyect.vortex.pruebavortex.application.services.IEmailService;

@Service
public class EmailServiceImpl implements IEmailService {

    private final Logger logger = LoggerFactory.getLogger(getClass());
    private final JavaMailSender mailSender;
    @Value("${spring.mail.username}")
    private final String EMAIL_FROM = "";

    public EmailServiceImpl(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Async
    @Override
    public void sendEmail(String to, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setFrom(EMAIL_FROM);
        message.setSubject(subject);
        message.setText(body);
        mailSender.send(message);
    }

}
