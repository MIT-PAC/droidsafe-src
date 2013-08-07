package com.android.internal.os;

// Droidsafe Imports
import droidsafe.annotations.*;




class ZygoteSecurityException extends RuntimeException {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.899 -0400", hash_original_method = "990020DEEB29D2A4D723F2E6C3895C07", hash_generated_method = "65810DDCE0AA47DDF6499F8FDFA0DA1E")
      ZygoteSecurityException(String message) {
        super(message);
        addTaint(message.getTaint());
        // ---------- Original Method ----------
    }

    
}

