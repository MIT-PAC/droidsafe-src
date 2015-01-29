package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class IccException extends Exception {
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:34.461 -0500", hash_original_method = "689A2E1E1574DEF078CD10C2BDEC6D21", hash_generated_method = "9024D78A63E617EEA16331DE1406E7FE")
    
public IccException() {

    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:34.464 -0500", hash_original_method = "C5281D49FF40E844F0E7519DDA3715E7", hash_generated_method = "60ADD2BACEE9053C089E04D7E21503EE")
    
public IccException(String s) {
        super(s);
    }
    
}

