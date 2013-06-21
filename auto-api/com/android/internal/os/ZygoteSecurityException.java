package com.android.internal.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

class ZygoteSecurityException extends RuntimeException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.406 -0400", hash_original_method = "990020DEEB29D2A4D723F2E6C3895C07", hash_generated_method = "5A173923A18FDDE1627B74AEFCAFEA71")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     ZygoteSecurityException(String message) {
        super(message);
        dsTaint.addTaint(message);
        // ---------- Original Method ----------
    }

    
}

