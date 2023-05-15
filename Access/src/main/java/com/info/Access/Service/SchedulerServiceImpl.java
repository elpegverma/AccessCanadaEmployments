package com.info.Access.Service;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.info.Access.controller.HomeController;

@Service
public class SchedulerServiceImpl implements SchedulerService{

	String time="";
	boolean trig=false;
	Calendar cal = Calendar.getInstance();
	
	String emails="";
	String times="";
	
	public void setEmails(String emails) {
		if(!emails.equals("")) {
		 this.emails = this.emails+"#"+emails;
		}
	}
	
	public void setTimes(String times) {
		if(!times.equals("")) {
		 this.times=this.times+"#"+times;
		}
	}
	
	public String getTime() {
     String localtime = String.valueOf(java.time.LocalTime.now());
     return localtime;
    }
	
	
	public synchronized void startScheduler(String trigger,String sender,String password,String schEmails,String subject,String msg, String host, String port, String time, String days) {
		trig = trigger.equals("true")?true:false;
		while(trig)
		  {
			try {
				defaultSetupForEmails(sender,password,schEmails,subject,msg,host,port,time,days);	
				//sendConfigurableEmails(sender,password,subject,msg,host,port,days);
			} catch (Exception e) {
				System.out.println("Exception message: "+e);
			}
		  }	
	   }
	
	private void defaultSetupForEmails(String sender, String password, String schEmails, String subject,String msg, String host,String port,String time, String days) throws Exception {
	   //System.out.println("Job is going to start, time "+time+" Day "+cal.get(Calendar.DAY_OF_WEEK)+" Current time "+getTime());
		if(getTime().startsWith(time) && days.contains(String.valueOf(cal.get(Calendar.DAY_OF_WEEK)))) {	
			setTest();
			System.out.println("\n Job is running, time "+time+" Day "+cal.get(Calendar.DAY_OF_WEEK)+ " Current time "+getTime());
			sendEmails(sender,password,schEmails,subject,msg,host,port);
			Thread.sleep(1000 * 60 * 60 * 24);
	     }   
	   else {
		System.out.println("\n Job is running out of time, time "+time+" Day "+cal.get(Calendar.DAY_OF_WEEK)+ " Current time "+getTime());
		//Thread.sleep(1000 * 60 * 30 * 1);
	  }
	}
	
	private void sendConfigurableEmails(String sender, String password, String subject,String msg, String host,String port,String days) throws Exception {
		// TODO Auto-generated method stub
		String timeArray[] = times.split("#");
		String emailArray[] = emails.split("#");
	    int lastElementValue = emailArray.length-1;
	   
		for (int i=1;i<=lastElementValue;i++)
		{	
		 /// System.out.println("\n\r Second Job is sending emails, Time key is "+timeArray[i]+" Email "+emailArray[i]);
		  if(getTime().startsWith(timeArray[i]) && days.contains(String.valueOf(cal.get(Calendar.DAY_OF_WEEK))))
	      {
			  setTest();
			  System.out.println("\n\r Second Job is running, Time key: "+i+" Emails: "+timeArray[i]+" "+emailArray[i]+" is running out of time");
			  sendEmails(sender,password,emailArray[i],subject,msg,host,port);
			  Thread.sleep(1000 * 60 * 60 * 1); 
	      }
		  else
		  {
			  System.out.println("\n\r Second Job is running out of time, Time key: "+i+" Emails: "+timeArray[i]+" "+emailArray[i]+" is running out of time");
			  Thread.sleep(1000 * 60 * 30 * 1);
		  }
		  
		}   
	}
	
	public void setTest()
	{
		try {
			System.out.println("\n Yes, I am here "+getTime()+":"+Calendar.DAY_OF_WEEK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
	}
	
	
	public void sendEmails(String sender,String password, String schEmails,String subject,String msg,String host, String port)throws Exception {
	           String emails[] = schEmails.split(",");
	           System.out.println("\n Number of recipients: "+emails.length);
	           for(int i=0;i<emails.length;i++)
	           Utils.composeAndSendMessage(sender,password,emails[i],subject,msg,host,port);
	}
}
