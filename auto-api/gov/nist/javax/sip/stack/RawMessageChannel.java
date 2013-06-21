package gov.nist.javax.sip.stack;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.javax.sip.message.SIPMessage;

public interface RawMessageChannel {

    public abstract void processMessage(SIPMessage sipMessage) throws Exception ;

}
