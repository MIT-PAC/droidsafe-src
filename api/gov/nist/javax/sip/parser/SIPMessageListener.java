package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.annotations.*;
import gov.nist.javax.sip.message.SIPMessage;

public interface SIPMessageListener extends ParseExceptionListener {
    
    public void processMessage(SIPMessage msg) throws Exception;
}
