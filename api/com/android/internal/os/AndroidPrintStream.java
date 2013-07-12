package com.android.internal.os;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.util.Log;

class AndroidPrintStream extends LoggingPrintStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:18.868 -0400", hash_original_field = "B988295C268025B49DFB3DF26171DDC3", hash_generated_field = "8E016BF5ECF2BB6A2B257594975987F0")

    private int priority;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:18.868 -0400", hash_original_field = "E4D23E841D8E8804190027BCE3180FA5", hash_generated_field = "21B5B848D650825609ACDCB16F135AD3")

    private String tag;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:18.870 -0400", hash_original_method = "9AD980F40A2045042AAB302D5FCF2B5F", hash_generated_method = "A6FBFF0BE3C0EF7527236C834E308110")
    public  AndroidPrintStream(int priority, String tag) {
    if(tag == null)        
        {
            NullPointerException var2114B990560383A0F782B34B8530F1E4_1324974950 = new NullPointerException("tag");
            var2114B990560383A0F782B34B8530F1E4_1324974950.addTaint(taint);
            throw var2114B990560383A0F782B34B8530F1E4_1324974950;
        } 
        this.priority = priority;
        this.tag = tag;
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:18.870 -0400", hash_original_method = "0F469F25708F7CED7810AA1C6F552E30", hash_generated_method = "542144C3C4C9B13C75081C517A6B2D20")
    protected void log(String line) {
        addTaint(line.getTaint());
        Log.println(priority, tag, line);
        
        
    }

    
}

