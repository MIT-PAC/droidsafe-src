package javax.sip;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public class PeerUnavailableException extends SipException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.517 -0400", hash_original_method = "4D3350AD44AB8F981C91A400EAA4427E", hash_generated_method = "FAC237361EF20CC03FED83D3DEA6D564")
    @DSModeled(DSC.SAFE)
    public PeerUnavailableException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.517 -0400", hash_original_method = "66401C22E3DAC6E7A91EB96EDEE6E4D8", hash_generated_method = "AED7E5A54CEC435E629E55110DE10783")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PeerUnavailableException(String message) {
        super(message);
        dsTaint.addTaint(message);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.517 -0400", hash_original_method = "41F06EC1DF16A2C31AA3137EDABFA9B1", hash_generated_method = "92863834E4571E693E50A3BF214690DE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PeerUnavailableException(String message, Throwable cause) {
        super(message, cause);
        dsTaint.addTaint(message);
        dsTaint.addTaint(cause.dsTaint);
        // ---------- Original Method ----------
    }

    
}


