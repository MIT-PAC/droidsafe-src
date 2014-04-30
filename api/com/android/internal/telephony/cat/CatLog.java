package com.android.internal.telephony.cat;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.util.Log;

public abstract class CatLog {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:03.577 -0500", hash_original_method = "AF350D0856318B413CE9EEACFA77CF8E", hash_generated_method = "029FE6B8655ACF581A2DFE991C4656E2")
    
public static void d(Object caller, String msg) {
        if (!DEBUG) {
            return;
        }

        String className = caller.getClass().getName();
        Log.d("CAT", className.substring(className.lastIndexOf('.') + 1) + ": "
                + msg);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:03.580 -0500", hash_original_method = "EF61DFF55192F14F2B39D7D419495EA8", hash_generated_method = "0E50881ECE468F58BC4AE07A516EBD75")
    
public static void d(String caller, String msg) {
        if (!DEBUG) {
            return;
        }

        Log.d("CAT", caller + ": " + msg);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:03.575 -0500", hash_original_field = "9C97D618612CFF386E7AF19655372855", hash_generated_field = "939E0B28F1664A3493BF4E7EE0A659BC")

    static final boolean DEBUG = true;
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:19.721 -0400", hash_original_method = "FB8735822A90C92F7E615B03189A3F55", hash_generated_method = "FB8735822A90C92F7E615B03189A3F55")
    public CatLog ()
    {
        //Synthesized constructor
    }
}

