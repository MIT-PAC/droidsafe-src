package javax.sip;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class TimeoutEvent extends TransactionTerminatedEvent {
    private Timeout mTimeout;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.257 -0400", hash_original_method = "B54F2DD7A2EA500C648BF1D67EA727CB", hash_generated_method = "3610833FB43E4C8FDE9BF6C2AA3BA6E1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public TimeoutEvent(Object source, ServerTransaction serverTransaction,
            Timeout timeout) {
        super(source, serverTransaction);
        dsTaint.addTaint(source.dsTaint);
        dsTaint.addTaint(serverTransaction.dsTaint);
        dsTaint.addTaint(timeout.dsTaint);
        // ---------- Original Method ----------
        //mTimeout = timeout;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.258 -0400", hash_original_method = "E3A1CE6AED4C8EB398A7A856D4DC19D6", hash_generated_method = "6EE3C9E4BB890122DA19601BE7C8A277")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public TimeoutEvent(Object source, ClientTransaction clientTransaction,
            Timeout timeout) {
        super(source, clientTransaction);
        dsTaint.addTaint(source.dsTaint);
        dsTaint.addTaint(clientTransaction.dsTaint);
        dsTaint.addTaint(timeout.dsTaint);
        // ---------- Original Method ----------
        //mTimeout = timeout;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.258 -0400", hash_original_method = "83172AE614FED36EC49043A629BB9E54", hash_generated_method = "7B2429DC0B14AC937734478472942C2A")
    @DSModeled(DSC.SAFE)
    public Timeout getTimeout() {
        return (Timeout)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mTimeout;
    }

    
}

