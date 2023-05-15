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

import org.springframework.beans.factory.annotation.Value;

import com.info.Access.Entity.EmailDetails;

public class Utils {
	 @Value("${spring.mail.username}") private String sender;
	 @Value("${spring.mail.password}") private String password;
	 @Value("${spring.mail.host}") private String host;
	 @Value("${spring.mail.port}") private String port;

  

	public static Properties getMailHostProps(String host, String port)throws Exception {
		Properties props = new Properties(); 
		props.put("mail.smtp.host", host); 
		props.put("mail.smtp.socketFactory.port", port); 
		props.put("mail.smtp.auth", "true"); 
		props.put("mail.smtp.port", port); 
		return props;
	}
	
	public static Session getSession(String sender,String password,String host,String port) throws Exception{

 		Session session = Session.getDefaultInstance(Utils.getMailHostProps(host,port),new javax.mail.Authenticator() { 
		protected PasswordAuthentication getPasswordAuthentication() { 
		return new PasswordAuthentication(sender,password); 
		} 
		}); 
      return session;
	}
	
	 public static void composeAndSendMessage(String From, String Password,String To,String Subject,String msg,String host,String port) throws Exception{
	    	
		   	try { 
					MimeMessage message = new MimeMessage(Utils.getSession(From,Password,host,port));
					message.setFrom(new InternetAddress(From)); 
				  	message.setRecipients(Message.RecipientType.TO, InternetAddress.parseHeader(To,false));
				  	message.setSubject(Subject); 
				     MimeMultipart multipart = new MimeMultipart("related");
			         BodyPart messageBodyPart = new MimeBodyPart();
			         messageBodyPart.setContent(msg, "text/html");
			         multipart.addBodyPart(messageBodyPart);
			         message.setContent(multipart);
				     Transport.send(message);
				     System.out.println("mail sent successfully to the user: "+To); 
				    
				} catch (MessagingException e) {System.out.println(e);}	
		    }
}
