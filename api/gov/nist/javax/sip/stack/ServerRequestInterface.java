package gov.nist.javax.sip.stack;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import gov.nist.javax.sip.message.*;

public interface ServerRequestInterface {

    
    public void processRequest(
        SIPRequest sipRequest,
        MessageChannel incomingChannel);


}
