package gov.nist.javax.sip.stack;

// Droidsafe Imports
import gov.nist.javax.sip.message.SIPRequest;
import gov.nist.javax.sip.message.SIPResponse;

public interface StackMessageFactory {
    
    public ServerRequestInterface newSIPServerRequest(
        SIPRequest sipRequest,
        MessageChannel msgChan);

    
    public ServerResponseInterface newSIPServerResponse(
        SIPResponse sipResponse,
        MessageChannel msgChan);
}
