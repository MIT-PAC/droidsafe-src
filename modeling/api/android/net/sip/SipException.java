package android.net.sip;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class SipException extends Exception {
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:24.997 -0500", hash_original_method = "2844FA66AE6BF3430E2D663113A5D509", hash_generated_method = "6F6C619A08A8DE33121F360284778EAB")
    
public SipException() {
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:24.999 -0500", hash_original_method = "9795DB733321F498B81268F6E7181236", hash_generated_method = "36D681D10FA36A881C96F3A0C818B9C4")
    
public SipException(String message) {
        super(message);
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:25.002 -0500", hash_original_method = "0929D315124628FA3E72B5EC08F3DEFE", hash_generated_method = "C5EDEFDFC58A420113B5D33DD58158D3")
    
public SipException(String message, Throwable cause) {
        // we want to eliminate the dependency on javax.sip.SipException
        super(message, ((cause instanceof javax.sip.SipException)
                && (cause.getCause() != null))
                ? cause.getCause()
                : cause);
    }
    
}

