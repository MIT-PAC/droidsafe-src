package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public final class IccVmFixedException extends IccException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.184 -0400", hash_original_method = "5A9335C92C5628670C0B43009ECBC345", hash_generated_method = "275700584173B2710352F12835C7C29D")
    @DSModeled(DSC.SAFE)
     IccVmFixedException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.184 -0400", hash_original_method = "765EFB197D88CEFF63C1DCD793F9D41E", hash_generated_method = "600D3E80DDB11654F32CE6AF5E6DD94E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public IccVmFixedException(String s) {
        super(s);
        dsTaint.addTaint(s);
        // ---------- Original Method ----------
    }

    
}


