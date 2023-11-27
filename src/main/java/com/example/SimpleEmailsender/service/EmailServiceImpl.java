package com.example.SimpleEmailsender.service;
import com.example.SimpleEmailsender.model.MailDetails;
import com.example.SimpleEmailsender.repositoty.EmailService;
import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
@Service
public class EmailServiceImpl implements EmailService {
    @Autowired
    private JavaMailSender javaMailSender;

    private String sender;
    @Override
    public String sendEmail(MailDetails mailDetails) {
        try {

            // Creating a simple mail message
            SimpleMailMessage mailMessage
                    = new SimpleMailMessage();

            // Setting up necessary details
            mailMessage.setFrom(sender);
            mailMessage.setTo(mailDetails.getRecipient());
            mailMessage.setText(mailDetails.getMsgBody());
            mailMessage.setSubject(mailDetails.getSubject());

            // Sending the mail
            javaMailSender.send(mailMessage);
            return "Mail Sent Successfully...";
        }

        // Catch block to handle the exceptions
        catch (Exception e) {
            return "Error while Sending Mail";
        }
    }
}
