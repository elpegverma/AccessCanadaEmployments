package com.info.Access.Service;

import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.info.Access.Entity.EmailDetails;

@Service
public class EmailServiceImpl implements EmailService {
	@Autowired private JavaMailSender javaMailSender;
    @Value("${spring.mail.username}") private String sender;
    @Value("${spring.mail.password}") private String password;
    @Value("${spring.mail.host}") private String host;
	@Value("${spring.mail.port}") private String port;
 
    // Method 1
    // To send a simple email
    public String sendSimpleMail(EmailDetails details)
    {
        try {   
    	//compose message 
    	   String msg=EmailServiceImpl.composeMessage(details);
    	   sendToOwner(details);
		   Utils.composeAndSendMessage(sender,password, details.getRecipient(),details.getSubject() ,msg,host,port);
        }catch(Exception e)
        {
        	System.out.println(e);
        }
    	   return "Mail sent Successfully";
        }

    public static String composeMessage(EmailDetails details) throws Exception {
    	//compose message 
   	 String msg="<html><body><div><p>Dear "+details.getName()+",</p>"
        		+ "<br/>Message:"+details.getMsgBody()
        		+ "<br/><p>Your enquiry is submitted, we will contact shortly.</p>"
        		+ "<br/>thanks and regards"
        		+ "<br/>Access Canada Employments"
        		+ "<br/>+1 519 616 0850"
        		+ "<br/><a href='https:accessemployments.com/'><img src='https://accessemployments.com/img/logo.jpeg' height='100px' width='150px'></img></a>"
    			+"</div></body></html>";
   	 return msg;
    }
    
    public static String getMsgForOwner(EmailDetails details)
    {
    	String  msg="<html><body><div><p>Hi Access Employments,</p>"
				+"<br/>Enquiry from "+details.getName()
           		+"<br/>Message :"+ details.getMsgBody()
           		+ "<br/><br/>thanks and regards"
           		+ "<br/>Access Canada Employments"
           		+ "<br/>+1 519 616 0850" 
           		+ "<br/><a href='https:accessemployments.com/'><img src='https://accessemployments.com/img/logo.jpeg' height='100px' width='150px'></img></a>"
        		+ "</div></body></html>";
    	return msg;
    }
    
    public void sendToOwner(EmailDetails details) throws Exception
    {
    	
    	Utils.composeAndSendMessage(sender, password, sender+",s4satishverma@gmail.com,sandhu8676@gmail.com",details.getSubject(),EmailServiceImpl.getMsgForOwner(details),host,port);
    }
	@Override
	public String sendMailWithAttachment(EmailDetails details) {
		// TODO Auto-generated method stub
		return null;
	}
 
    // Method 2
    // To send an email with attachment
  /*  public String
    sendMailWithAttachment(EmailDetails details)
    {
        // Creating a mime message
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper;
 
        try {
 
            // Setting multipart as true for attachments to
            // be send
            mimeMessageHelper
                = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom(sender);
            mimeMessageHelper.setTo(details.getRecipient());
            mimeMessageHelper.setText(details.getMsgBody());
            mimeMessageHelper.setSubject(
                details.getSubject());
 
            // Adding the attachment
            FileSystemResource file
                = new FileSystemResource(
                    new File(details.getAttachment()));
 
            mimeMessageHelper.addAttachment(
                file.getFilename(), file);
 
            // Sending the mail
            javaMailSender.send(mimeMessage);
            return "Mail sent Successfully";
        }
 
        // Catch block to handle MessagingException
        catch (MessagingException e) {
 
            // Display message when exception occurred
            return "Error while sending mail!!!";
        }
    }*/
}
