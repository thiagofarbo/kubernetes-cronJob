package com.scheduler.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;

@Slf4j
@Service
@RequiredArgsConstructor
public class SenderService {

    private final JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String sender;

    @Value("${report.send.email.toList}")
    private String listEmails;

    public String sendDailyReports(byte[] reportContent) throws MessagingException, IOException {

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        helper.setFrom(sender);
        helper.setTo(listEmails.split(","));
        helper.setSubject("Daily product list report - " + new Date().getTime());
        helper.setText(" Please find attached the product list report.\n Regards, \n Scheduler Team.");

        ByteArrayResource content = new ByteArrayResource(reportContent);
        helper.addAttachment(new Date().getTime()+"_userTransaction.xlsx", content);

        javaMailSender.send(mimeMessage);
        return "Mail sent successfully with attachment ";
    }


}
