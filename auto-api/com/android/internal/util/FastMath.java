package com.android.internal.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class FastMath {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.647 -0400", hash_original_method = "DA3FCE376434CC94A68DD936C1E827C5", hash_generated_method = "DA3FCE376434CC94A68DD936C1E827C5")
        public FastMath ()
    {
    }


        public static int round(float x) {
        long lx = (long)(x * (65536 * 256f));
        return (int)((lx + 0x800000) >> 24);
    }

    
}

