package gov.nist.javax.sip.stack;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.javax.sip.message.*;

public interface ServerRequestInterface {

    
    public void processRequest(
        SIPRequest sipRequest,
        MessageChannel incomingChannel);


}
