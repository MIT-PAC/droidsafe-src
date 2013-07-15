package com.android.internal.util;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public class Preconditions {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.802 -0400", hash_original_method = "1249D16E1F2DBD1F6589B9E494B4B7C0", hash_generated_method = "1249D16E1F2DBD1F6589B9E494B4B7C0")
    public Preconditions ()
    {
        
    }


    @DSModeled(DSC.SAFE)
    public static <T> T checkNotNull(T reference) {
        if (reference == null) {
            throw new NullPointerException();
        }
        return reference;
    }

    
    @DSModeled(DSC.SAFE)
    public static <T> T checkNotNull(T reference, Object errorMessage) {
        if (reference == null) {
            throw new NullPointerException(String.valueOf(errorMessage));
        }
        return reference;
    }

    
}

