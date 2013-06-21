package com.android.internal.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.util.Log;

class AndroidPrintStream extends LoggingPrintStream {
    private int priority;
    private String tag;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.187 -0400", hash_original_method = "9AD980F40A2045042AAB302D5FCF2B5F", hash_generated_method = "317D5C1EDACEEAF6FE8B48C192003B74")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AndroidPrintStream(int priority, String tag) {
        dsTaint.addTaint(tag);
        dsTaint.addTaint(priority);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("tag");
        } //End block
        // ---------- Original Method ----------
        //if (tag == null) {
            //throw new NullPointerException("tag");
        //}
        //this.priority = priority;
        //this.tag = tag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.188 -0400", hash_original_method = "0F469F25708F7CED7810AA1C6F552E30", hash_generated_method = "CEDD2253F380AB08CF099D0FAAEB3440")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void log(String line) {
        dsTaint.addTaint(line);
        Log.println(priority, tag, line);
        // ---------- Original Method ----------
        //Log.println(priority, tag, line);
    }

    
}

