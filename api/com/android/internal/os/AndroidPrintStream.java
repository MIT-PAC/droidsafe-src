package com.android.internal.os;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.util.Log;





class AndroidPrintStream extends LoggingPrintStream {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:42.832 -0500", hash_original_field = "4AD9F2E37B35E313CD211FBAFDADA238", hash_generated_field = "8E016BF5ECF2BB6A2B257594975987F0")


    private  int priority;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:42.833 -0500", hash_original_field = "FFCA994A2F44B678330E924D8C87385D", hash_generated_field = "21B5B848D650825609ACDCB16F135AD3")

    private  String tag;

    /**
     * Constructs a new logging print stream.
     *
     * @param priority from {@link android.util.Log}
     * @param tag to log
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:42.834 -0500", hash_original_method = "9AD980F40A2045042AAB302D5FCF2B5F", hash_generated_method = "30BC18EB056406780EC8E5E51FC6F0CF")
    public AndroidPrintStream(int priority, String tag) {
        if (tag == null) {
            throw new NullPointerException("tag");
        }

        this.priority = priority;
        this.tag = tag;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:42.835 -0500", hash_original_method = "0F469F25708F7CED7810AA1C6F552E30", hash_generated_method = "093B57ECFD6CD656AF0FC491F2F55077")
    protected void log(String line) {
        Log.println(priority, tag, line);
    }

    
}

