package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.javax.sip.message.*;

public interface SIPMessageListener extends ParseExceptionListener {
    
    public void processMessage(SIPMessage msg) throws Exception;
}
