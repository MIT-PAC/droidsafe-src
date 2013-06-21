package javax.sip;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class PeerUnavailableException extends SipException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.236 -0400", hash_original_method = "4D3350AD44AB8F981C91A400EAA4427E", hash_generated_method = "44BD24A818123A78793FB64A05D90F67")
    @DSModeled(DSC.SAFE)
    public PeerUnavailableException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.236 -0400", hash_original_method = "66401C22E3DAC6E7A91EB96EDEE6E4D8", hash_generated_method = "1FCE65ABB2D0B08AAEB8990C2EA7DBF1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PeerUnavailableException(String message) {
        super(message);
        dsTaint.addTaint(message);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.236 -0400", hash_original_method = "41F06EC1DF16A2C31AA3137EDABFA9B1", hash_generated_method = "D4E0A6DA6979CC3DD71A62D054C6DCDF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PeerUnavailableException(String message, Throwable cause) {
        super(message, cause);
        dsTaint.addTaint(message);
        dsTaint.addTaint(cause.dsTaint);
        // ---------- Original Method ----------
    }

    
}

