package gov.nist.javax.sip.parser;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import gov.nist.javax.sip.message.*;

public interface SIPMessageListener extends ParseExceptionListener {
    
    public void processMessage(SIPMessage msg) throws Exception;
}
