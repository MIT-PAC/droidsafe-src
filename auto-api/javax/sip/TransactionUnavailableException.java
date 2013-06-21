package javax.sip;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class TransactionUnavailableException extends SipException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.263 -0400", hash_original_method = "E1225E9A0C179C24A6F556EFDF84E711", hash_generated_method = "43E10BCACF034EAE177943DB519A76E0")
    @DSModeled(DSC.SAFE)
    public TransactionUnavailableException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.263 -0400", hash_original_method = "037265DD61866BF76BF55F595E642E2B", hash_generated_method = "C6DA9ACFB02E29D1EB3E47016B792910")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public TransactionUnavailableException(String message) {
        super(message);
        dsTaint.addTaint(message);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.264 -0400", hash_original_method = "9A237A264B439534488FA55C4A599BD6", hash_generated_method = "333F868EDBAE73C2CC88029EA67C1821")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public TransactionUnavailableException(String message, Throwable cause) {
        super(message, cause);
        dsTaint.addTaint(message);
        dsTaint.addTaint(cause.dsTaint);
        // ---------- Original Method ----------
    }

    
}

