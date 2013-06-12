package android.net.sip;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public class SipException extends Exception {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.331 -0400", hash_original_method = "2844FA66AE6BF3430E2D663113A5D509", hash_generated_method = "FC54DBBD74F131B00D802D27AA2E8BD7")
    @DSModeled(DSC.SAFE)
    public SipException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.331 -0400", hash_original_method = "9795DB733321F498B81268F6E7181236", hash_generated_method = "26B3FA4AAD577A83C6CB736B23D51A60")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SipException(String message) {
        super(message);
        dsTaint.addTaint(message);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.332 -0400", hash_original_method = "0929D315124628FA3E72B5EC08F3DEFE", hash_generated_method = "DA7CDB3E7CAB4922A1EFA853ACC4AF5E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SipException(String message, Throwable cause) {
        super(message, ((cause instanceof javax.sip.SipException)
                && (cause.getCause() != null))
                ? cause.getCause()
                : cause);
        dsTaint.addTaint(message);
        dsTaint.addTaint(cause.dsTaint);
        // ---------- Original Method ----------
    }

    
}


