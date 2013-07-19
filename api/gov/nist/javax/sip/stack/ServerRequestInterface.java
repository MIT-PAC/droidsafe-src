package gov.nist.javax.sip.stack;

// Droidsafe Imports
import gov.nist.javax.sip.message.SIPRequest;

public interface ServerRequestInterface {

    
    public void processRequest(
        SIPRequest sipRequest,
        MessageChannel incomingChannel);


}
