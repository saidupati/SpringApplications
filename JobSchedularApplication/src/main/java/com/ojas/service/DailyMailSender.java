package com.ojas.service;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Service;

@Service
public class DailyMailSender {

	@Autowired
    private JavaMailSender javaMailSender;
 
    public void sendDailyMail(String[] recipients, String attachmentPath) {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
 
        try {
            helper.setTo(recipients);
            helper.setSubject("Daily Mail");
            helper.setText("Please find attached daily report.");
            FileSystemResource file = new FileSystemResource(new File(attachmentPath));
            helper.addAttachment("daily_report.xlsx", file);
 
            javaMailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }




	
}
