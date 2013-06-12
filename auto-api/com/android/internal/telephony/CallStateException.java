package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public class CallStateException extends Exception {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.607 -0400", hash_original_method = "6881AB427E30C93EDDFD6D9CF770BA8D", hash_generated_method = "D24AEC591EE9260FABE67B9D3C1EB9CA")
    @DSModeled(DSC.SAFE)
    public CallStateException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.607 -0400", hash_original_method = "12255588CD7BB7711BD7E8DDB788E5D3", hash_generated_method = "EFD38E389D2E86208B57DA5698627CA3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CallStateException(String string) {
        super(string);
        dsTaint.addTaint(string);
        // ---------- Original Method ----------
    }

    
}


