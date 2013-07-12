package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public final class IccVmFixedException extends IccException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.820 -0400", hash_original_method = "5A9335C92C5628670C0B43009ECBC345", hash_generated_method = "CAF80BBE6686F73F890C87DA35EAA7C2")
      IccVmFixedException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.820 -0400", hash_original_method = "765EFB197D88CEFF63C1DCD793F9D41E", hash_generated_method = "E57B3F8402E2B7DC0CE15BB33C38695F")
    public  IccVmFixedException(String s) {
        super(s);
        addTaint(s.getTaint());
        // ---------- Original Method ----------
    }

    
}

