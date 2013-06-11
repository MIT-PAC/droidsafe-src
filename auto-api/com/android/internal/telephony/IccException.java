package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public class IccException extends Exception {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.094 -0400", hash_original_method = "689A2E1E1574DEF078CD10C2BDEC6D21", hash_generated_method = "225F1F4F24C78A149E944A7DA33B86EB")
    @DSModeled(DSC.SAFE)
    public IccException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.094 -0400", hash_original_method = "C5281D49FF40E844F0E7519DDA3715E7", hash_generated_method = "198FF8509840EEC8A47D3AD822993C01")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public IccException(String s) {
        super(s);
        dsTaint.addTaint(s);
        // ---------- Original Method ----------
    }

    
}


