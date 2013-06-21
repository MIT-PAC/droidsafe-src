package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class CallStateException extends Exception {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.767 -0400", hash_original_method = "6881AB427E30C93EDDFD6D9CF770BA8D", hash_generated_method = "53AD66AD2E76F0C0559F3B6DAD025E3F")
    @DSModeled(DSC.SAFE)
    public CallStateException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.767 -0400", hash_original_method = "12255588CD7BB7711BD7E8DDB788E5D3", hash_generated_method = "C50C6765129A84E117A231659478DD49")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CallStateException(String string) {
        super(string);
        dsTaint.addTaint(string);
        // ---------- Original Method ----------
    }

    
}

