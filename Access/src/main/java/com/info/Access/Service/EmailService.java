package com.info.Access.Service;

import org.springframework.stereotype.Service;

import com.info.Access.Entity.EmailDetails;

@Service
public interface EmailService {

	// Method
    // To send a simple email
    String sendSimpleMail(EmailDetails details);
 
    // Method
    // To send an email with attachment
    String sendMailWithAttachment(EmailDetails details);
    
}
