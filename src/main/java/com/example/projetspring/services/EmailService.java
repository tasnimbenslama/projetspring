package com.example.projetspring.services;

import javax.mail.MessagingException;
import java.util.List;

public interface EmailService {
    void sendEmail(String to, String subject, String message);
    public void sendEmailWithAttachment(String toEmail,
                                        String body,
                                        String subject,
                                        String attachment) throws MessagingException;
}
