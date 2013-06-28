package com.android.internal.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.util.Log;

class AndroidPrintStream extends LoggingPrintStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:19.444 -0400", hash_original_field = "B988295C268025B49DFB3DF26171DDC3", hash_generated_field = "8E016BF5ECF2BB6A2B257594975987F0")

    private int priority;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:19.444 -0400", hash_original_field = "E4D23E841D8E8804190027BCE3180FA5", hash_generated_field = "21B5B848D650825609ACDCB16F135AD3")

    private String tag;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:19.444 -0400", hash_original_method = "9AD980F40A2045042AAB302D5FCF2B5F", hash_generated_method = "C1C3579455A9830BBFFD20276765708F")
    public  AndroidPrintStream(int priority, String tag) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("tag");
        } //End block
        this.priority = priority;
        this.tag = tag;
        // ---------- Original Method ----------
        //if (tag == null) {
            //throw new NullPointerException("tag");
        //}
        //this.priority = priority;
        //this.tag = tag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:19.444 -0400", hash_original_method = "0F469F25708F7CED7810AA1C6F552E30", hash_generated_method = "7641560E6172C3871AD4D96D6AC702EB")
    protected void log(String line) {
        Log.println(priority, tag, line);
        addTaint(line.getTaint());
        // ---------- Original Method ----------
        //Log.println(priority, tag, line);
    }

    
}

