package com.info.Access.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.info.Access.Entity.EmailDetails;
import com.info.Access.Service.EmailService;

@RestController
public class EmailController {
	
	@Autowired(required=true)
	EmailService emailService;
	 
    // Sending a simple Email
	@PostMapping(path = "/sendMail")
			//consumes = "application/x-www-form-urlencoded",produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ModelAndView sendMail(@ModelAttribute("details") EmailDetails emailDetails)
    {
    	System.out.println("I get the call"+emailDetails.getName());				
        String status = emailService.sendSimpleMail(emailDetails);
        return new ModelAndView("index");
    }
    // Sending email with attachment
 /*   @PostMapping("/sendMailWithAttachment")
    public String sendMailWithAttachment(
        @RequestBody EmailDetails details)
    {
        String status
            = emailService.sendMailWithAttachment(details);
 
        return status;
    }
    */
}
