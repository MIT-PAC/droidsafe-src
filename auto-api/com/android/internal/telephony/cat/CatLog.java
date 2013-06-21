package com.android.internal.telephony.cat;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.util.Log;

public abstract class CatLog {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.644 -0400", hash_original_method = "E908EB780EE5769F1F4960A4CC03E886", hash_generated_method = "E908EB780EE5769F1F4960A4CC03E886")
        public CatLog ()
    {
    }


        public static void d(Object caller, String msg) {
        if (!DEBUG) {
            return;
        }
        String className = caller.getClass().getName();
        Log.d("CAT", className.substring(className.lastIndexOf('.') + 1) + ": "
                + msg);
    }

    
        public static void d(String caller, String msg) {
        if (!DEBUG) {
            return;
        }
        Log.d("CAT", caller + ": " + msg);
    }

    
    static final boolean DEBUG = true;
}

