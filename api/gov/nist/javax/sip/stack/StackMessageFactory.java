package gov.nist.javax.sip.stack;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import gov.nist.javax.sip.message.*;

public interface StackMessageFactory {
    
    public ServerRequestInterface newSIPServerRequest(
        SIPRequest sipRequest,
        MessageChannel msgChan);

    
    public ServerResponseInterface newSIPServerResponse(
        SIPResponse sipResponse,
        MessageChannel msgChan);
}
