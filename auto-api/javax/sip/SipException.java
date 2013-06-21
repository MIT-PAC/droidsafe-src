package javax.sip;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class SipException extends Exception {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.241 -0400", hash_original_method = "2844FA66AE6BF3430E2D663113A5D509", hash_generated_method = "55BA8DDE2D4649EC43875D789C2CA939")
    @DSModeled(DSC.SAFE)
    public SipException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.241 -0400", hash_original_method = "9795DB733321F498B81268F6E7181236", hash_generated_method = "FAEB59860C2CBE4FAD12DA4ACDE1F161")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SipException(String message) {
        super(message);
        dsTaint.addTaint(message);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.241 -0400", hash_original_method = "E62B603E3CD1BD72D065096C1422B8B0", hash_generated_method = "0E4A84ECD875B563438CBA494230D838")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SipException(String message, Throwable cause) {
        super(message, cause);
        dsTaint.addTaint(message);
        dsTaint.addTaint(cause.dsTaint);
        // ---------- Original Method ----------
    }

    
}

