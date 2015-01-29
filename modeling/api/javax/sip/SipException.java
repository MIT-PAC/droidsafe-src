package javax.sip;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class SipException extends Exception {
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:02.975 -0500", hash_original_method = "2844FA66AE6BF3430E2D663113A5D509", hash_generated_method = "6F6C619A08A8DE33121F360284778EAB")
    
public SipException() {
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:02.978 -0500", hash_original_method = "9795DB733321F498B81268F6E7181236", hash_generated_method = "36D681D10FA36A881C96F3A0C818B9C4")
    
public SipException(String message) {
        super(message);
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:02.981 -0500", hash_original_method = "E62B603E3CD1BD72D065096C1422B8B0", hash_generated_method = "71E4F1E9AD07E541850168BEC63A99AE")
    
public SipException(String message, Throwable cause) {
        super(message, cause);
    }
    
}

