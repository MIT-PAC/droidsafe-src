package gov.nist.core;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.javax.sip.message.SIPMessage;

import java.util.Properties;

import javax.sip.SipStack;

public interface ServerLogger extends LogLevels {
   
	 @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void closeLogFile();
	 
	 @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void logMessage(SIPMessage message, String from, String to, boolean sender, long time);
	 
	 @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void logMessage(SIPMessage message, String from, String to, String status,
	            boolean sender, long time);
	 
	 @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void logMessage(SIPMessage message, String from, String to, String status,
	            boolean sender);
	            	
	 @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void logException(Exception ex);
	 
	 @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public void setStackProperties(Properties stackProperties);
	 
	 @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public void setSipStack(SipStack sipStack);
	
}
