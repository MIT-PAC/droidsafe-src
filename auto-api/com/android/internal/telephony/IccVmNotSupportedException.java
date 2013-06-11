package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public final class IccVmNotSupportedException extends IccException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.185 -0400", hash_original_method = "0DA609D1A800BAC68D629EBC1C71BABF", hash_generated_method = "D77A6407186951636F2469E38183C8CF")
    @DSModeled(DSC.SAFE)
     IccVmNotSupportedException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.185 -0400", hash_original_method = "BF0F5F61FF78864DF45F6E5D7B53B506", hash_generated_method = "A15C22330416530464B70835631778E7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public IccVmNotSupportedException(String s) {
        super(s);
        dsTaint.addTaint(s);
        // ---------- Original Method ----------
    }

    
}


