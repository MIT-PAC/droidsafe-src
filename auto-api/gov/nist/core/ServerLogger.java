package gov.nist.core;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.Properties;
import javax.sip.SipStack;
import gov.nist.javax.sip.message.SIPMessage;

public interface ServerLogger extends LogLevels {
	
   
	 void closeLogFile();
	 
	 void logMessage(SIPMessage message, String from, String to, boolean sender, long time);
	 
	 void logMessage(SIPMessage message, String from, String to, String status,
	            boolean sender, long time);
	 
	 void logMessage(SIPMessage message, String from, String to, String status,
	            boolean sender);
	            	
	 void logException(Exception ex);
	 
	 public void setStackProperties(Properties stackProperties);
	 
	 public void setSipStack(SipStack sipStack);
	 
	
}
