package com.example.SimpleEmailsender.controller;

import com.example.SimpleEmailsender.model.MailDetails;
import com.example.SimpleEmailsender.service.EmailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Emailcontroller {

    @Autowired
    EmailServiceImpl emailService;
    @PostMapping("/sendMail")
    public String sendMail(@RequestBody MailDetails details)
    {
        String status
                = emailService.sendEmail(details);

        return status;
    }

}
