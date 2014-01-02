package gov.nist.javax.sip.stack;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.javax.sip.message.SIPRequest;

public interface ServerRequestInterface {

    
    public void processRequest(
        SIPRequest sipRequest,
        MessageChannel incomingChannel);


}
