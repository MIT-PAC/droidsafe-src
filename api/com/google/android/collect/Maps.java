package com.google.android.collect;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.util.HashMap;



public class Maps {
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.486 -0400", hash_original_method = "D14A46AD9A44F18F095D421F94A96F01", hash_generated_method = "D14A46AD9A44F18F095D421F94A96F01")
    public Maps ()
    {
        //Synthesized constructor
    }


    @DSModeled(DSC.SAFE)
    public static <K, V> HashMap<K, V> newHashMap() {
        return new HashMap<K, V>();
    }

    
}

