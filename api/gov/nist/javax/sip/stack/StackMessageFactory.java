package gov.nist.javax.sip.stack;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import gov.nist.javax.sip.message.*;

public interface StackMessageFactory {
    
    public ServerRequestInterface newSIPServerRequest(
        SIPRequest sipRequest,
        MessageChannel msgChan);

    
    public ServerResponseInterface newSIPServerResponse(
        SIPResponse sipResponse,
        MessageChannel msgChan);
}
