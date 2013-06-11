package javax.sip;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public class InvalidArgumentException extends SipException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.515 -0400", hash_original_method = "058727A85A3561BD87B89BB684E2068E", hash_generated_method = "7202E58CD641CB47BF81C768483FE5F2")
    @DSModeled(DSC.SAFE)
    public InvalidArgumentException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.515 -0400", hash_original_method = "6CFB0BD92581CA0A67925F5045802025", hash_generated_method = "4F30E4ACC046270A0EBB6C43D1E2F648")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public InvalidArgumentException(String message) {
        super(message);
        dsTaint.addTaint(message);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.515 -0400", hash_original_method = "36D7705F557972E94094B17807C973B6", hash_generated_method = "3FF63DAFF44A0667EC267EC23C246AE9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public InvalidArgumentException(String message, Throwable cause) {
        super(message, cause);
        dsTaint.addTaint(message);
        dsTaint.addTaint(cause.dsTaint);
        // ---------- Original Method ----------
    }

    
}


