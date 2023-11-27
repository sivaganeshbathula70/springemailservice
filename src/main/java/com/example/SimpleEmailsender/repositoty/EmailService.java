package com.example.SimpleEmailsender.repositoty;

import com.example.SimpleEmailsender.model.MailDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailService {

    String sendEmail(MailDetails mailDetails);
}
