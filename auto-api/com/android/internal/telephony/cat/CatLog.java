package com.android.internal.telephony.cat;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.util.Log;

public abstract class CatLog {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.175 -0400", hash_original_method = "FB8735822A90C92F7E615B03189A3F55", hash_generated_method = "FB8735822A90C92F7E615B03189A3F55")
    public CatLog ()
    {
        //Synthesized constructor
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.176 -0400", hash_original_field = "BC4FF4C62A62F66D6D2E0A35B84DD24A", hash_generated_field = "939E0B28F1664A3493BF4E7EE0A659BC")

    static final boolean DEBUG = true;
}

