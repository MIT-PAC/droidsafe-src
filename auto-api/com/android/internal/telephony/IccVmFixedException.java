package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public final class IccVmFixedException extends IccException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.478 -0400", hash_original_method = "5A9335C92C5628670C0B43009ECBC345", hash_generated_method = "CAF80BBE6686F73F890C87DA35EAA7C2")
    @DSModeled(DSC.SAFE)
     IccVmFixedException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.478 -0400", hash_original_method = "765EFB197D88CEFF63C1DCD793F9D41E", hash_generated_method = "536AD984CCB2B842F89C00FF2CDEB8C4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public IccVmFixedException(String s) {
        super(s);
        dsTaint.addTaint(s);
        // ---------- Original Method ----------
    }

    
}

