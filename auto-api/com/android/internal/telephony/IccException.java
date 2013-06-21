package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class IccException extends Exception {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.300 -0400", hash_original_method = "689A2E1E1574DEF078CD10C2BDEC6D21", hash_generated_method = "EA32E671BE005D4FE327F22565483AE0")
    @DSModeled(DSC.SAFE)
    public IccException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.301 -0400", hash_original_method = "C5281D49FF40E844F0E7519DDA3715E7", hash_generated_method = "6C18DF40E827A5FAC0874973654BA715")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public IccException(String s) {
        super(s);
        dsTaint.addTaint(s);
        // ---------- Original Method ----------
    }

    
}

