package gov.nist.javax.sip;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import  gov.nist.javax.sip.stack.*;
import  java.util.*;

class EventWrapper {
    protected EventObject sipEvent;
    protected SIPTransaction transaction;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.135 -0400", hash_original_method = "90A52EB1D7464A6D23F549B5DAB9B818", hash_generated_method = "A3CC49E28DDA98FDB692B4F47B927656")
    @DSModeled(DSC.SAFE)
     EventWrapper(EventObject sipEvent, SIPTransaction transaction) {
        dsTaint.addTaint(transaction.dsTaint);
        dsTaint.addTaint(sipEvent.dsTaint);
        // ---------- Original Method ----------
        //this.sipEvent = sipEvent;
        //this.transaction = transaction;
    }

    
}

