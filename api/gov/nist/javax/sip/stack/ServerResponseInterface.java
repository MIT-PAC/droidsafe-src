package gov.nist.javax.sip.stack;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.javax.sip.message.SIPResponse;

public interface ServerResponseInterface {
    
    public void processResponse(
        SIPResponse sipResponse,
        MessageChannel incomingChannel,
        SIPDialog sipDialog);




    
    public void processResponse(
            SIPResponse sipResponse,
            MessageChannel incomingChannel);



}
