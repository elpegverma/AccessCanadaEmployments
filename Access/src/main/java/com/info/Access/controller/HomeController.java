package com.info.Access.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.info.Access.Service.SchedulerService;
import com.info.Access.Service.SchedulerServiceImpl;

@RestController
@Configuration
@PropertySource("classpath:email.properties")
public class HomeController {
	@Value("${spring.mail.username}") String sender;
    @Value("${spring.mail.password}") String password;
    @Value("${Scheduler.Emails}") String schEmails;
    @Value("${Scheduler.subject}") String subject;
    @Value("${spring.scheduler.trigger}") String trigger;
    @Value("${Scheduler.header}") String header;
    @Value("${Scheduler.body}") String body;
    @Value("${Scheduler.footer}") String footer;
    @Value("${spring.mail.host}") String host;
	@Value("${spring.mail.port}") String port;
	@Value("${spring.schedule.time}") String time;
	@Value("${spring.schedule.days}") String days;
	String timeKeys = "spring.schedule.time";
	String emailKeys = "Scheduler.Emails";
	
    @Autowired
    Environment env;
    
	public String getTime() {
		return time;
	}
	
	public String getDays() {
		return days;
	}
    
	@RequestMapping("/contact")
	public ModelAndView index () {
	    return new ModelAndView("contact");
	}
	
	@RequestMapping("/about")
	public ModelAndView aboutUs() {
	    return new ModelAndView("aboutus");
	}
	
	@RequestMapping("/service")
	public ModelAndView service() {
	    return new ModelAndView("services");
	}
	
	@RequestMapping("/home")
	public ModelAndView home() {
		return new ModelAndView("index");
	}
	
	public String getValues(String key)
	{
		return env.getProperty(key);
	}
	
	@RequestMapping("/StartScheduler")
	public @ResponseBody String message() {
		int numberofkeys = Integer.parseInt((getValues("noOfKeys")));
		String msg = header+body+footer;
		SchedulerService sc = new SchedulerServiceImpl();
		for(int i=1;i<=numberofkeys;i++) {
		sc.setEmails(getValues(emailKeys+i));
		sc.setTimes(getValues(timeKeys+i));
		}
		sc.startScheduler(trigger,sender,password,schEmails,subject,msg,host,port,time,days);
		return "Scheduler is started";
	}
	
	
}
