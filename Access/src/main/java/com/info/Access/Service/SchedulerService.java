package com.info.Access.Service;

import org.springframework.stereotype.Service;

import com.info.Access.Entity.EmailDetails;

@Service
public interface SchedulerService {

	   void startScheduler(String trigger,String sender,String password,String schEmails,String subject,String msg, String host, String port, String time, String days);    
       void setEmails(String emails);
       void setTimes(String times);
}
