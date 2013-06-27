package com.android.internal.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

class ZygoteSecurityException extends RuntimeException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:14.134 -0400", hash_original_method = "990020DEEB29D2A4D723F2E6C3895C07", hash_generated_method = "65810DDCE0AA47DDF6499F8FDFA0DA1E")
      ZygoteSecurityException(String message) {
        super(message);
        addTaint(message.getTaint());
        // ---------- Original Method ----------
    }

    
}

