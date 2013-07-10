package com.android.internal.util;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.util.Arrays;

public class Objects {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.798 -0400", hash_original_method = "A2A31F0BD1F39D2A345E74134749A5E1", hash_generated_method = "A2A31F0BD1F39D2A345E74134749A5E1")
    public Objects ()
    {
        
    }


    @DSModeled(DSC.SAFE)
    public static boolean equal(Object a, Object b) {
        return a == b || (a != null && a.equals(b));
    }

    
    public static int hashCode(Object... objects) {
        return Arrays.hashCode(objects);
    }

    
}

