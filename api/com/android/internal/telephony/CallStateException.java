package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class CallStateException extends Exception {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.008 -0400", hash_original_method = "6881AB427E30C93EDDFD6D9CF770BA8D", hash_generated_method = "53AD66AD2E76F0C0559F3B6DAD025E3F")
    public  CallStateException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.008 -0400", hash_original_method = "12255588CD7BB7711BD7E8DDB788E5D3", hash_generated_method = "D2009D4F92808C7B3A9785F36B399288")
    public  CallStateException(String string) {
        super(string);
        addTaint(string.getTaint());
        // ---------- Original Method ----------
    }

    
}

