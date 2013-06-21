package java.util.concurrent;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class TimeoutException extends Exception {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.069 -0400", hash_original_method = "043D89A921444ACFFC25D3711EECF0CA", hash_generated_method = "2EED959198322EAFC7EA8AB16C41E080")
    @DSModeled(DSC.SAFE)
    public TimeoutException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.069 -0400", hash_original_method = "D54DDC72729A014BD7698825D7BF2D5A", hash_generated_method = "FA31C803BF3CEAF65C482BA02934788F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public TimeoutException(String message) {
        super(message);
        dsTaint.addTaint(message);
        // ---------- Original Method ----------
    }

    
    private static final long serialVersionUID = 1900926677490660714L;
}

