package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public final class IccVmNotSupportedException extends IccException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.479 -0400", hash_original_method = "0DA609D1A800BAC68D629EBC1C71BABF", hash_generated_method = "F1E2078F5B9AA92FE4573BDAF4BBC2A5")
    @DSModeled(DSC.SAFE)
     IccVmNotSupportedException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.479 -0400", hash_original_method = "BF0F5F61FF78864DF45F6E5D7B53B506", hash_generated_method = "44E1D45533B92D0C96CF4C3668304251")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public IccVmNotSupportedException(String s) {
        super(s);
        dsTaint.addTaint(s);
        // ---------- Original Method ----------
    }

    
}

