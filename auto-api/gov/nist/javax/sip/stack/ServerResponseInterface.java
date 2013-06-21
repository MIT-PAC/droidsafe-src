package gov.nist.javax.sip.stack;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.javax.sip.message.*;

public interface ServerResponseInterface {
    
    public void processResponse(
        SIPResponse sipResponse,
        MessageChannel incomingChannel,
        SIPDialog sipDialog);




    
    public void processResponse(
            SIPResponse sipResponse,
            MessageChannel incomingChannel);



}
