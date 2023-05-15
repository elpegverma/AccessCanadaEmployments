package com.info.Access.Entity;

public class EmailDetails {
		private String name;
		private String recipient;
	    private String msgBody;
	    private String subject;
	    //private String attachment;
	    
	    
		public String getRecipient() {
			return recipient;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public void setRecipient(String recipient) {
			this.recipient = recipient;
		}
		public String getMsgBody() {
			return msgBody;
		}
		public void setMsgBody(String msgBody) {
			this.msgBody = msgBody;
		}
		public String getSubject() {
			return subject;
		}
		public void setSubject(String subject) {
			this.subject = subject;
		}
		
	    
	    
}
