package com.android.internal.os;

// Droidsafe Imports
import android.util.Log;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

class AndroidPrintStream extends LoggingPrintStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.432 -0400", hash_original_field = "B988295C268025B49DFB3DF26171DDC3", hash_generated_field = "8E016BF5ECF2BB6A2B257594975987F0")

    private int priority;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.432 -0400", hash_original_field = "E4D23E841D8E8804190027BCE3180FA5", hash_generated_field = "21B5B848D650825609ACDCB16F135AD3")

    private String tag;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.432 -0400", hash_original_method = "9AD980F40A2045042AAB302D5FCF2B5F", hash_generated_method = "5451DB99C376A01E1C25C6BC6F23CCD7")
    public  AndroidPrintStream(int priority, String tag) {
        if(tag == null)        
        {
            NullPointerException var2114B990560383A0F782B34B8530F1E4_351659847 = new NullPointerException("tag");
            var2114B990560383A0F782B34B8530F1E4_351659847.addTaint(taint);
            throw var2114B990560383A0F782B34B8530F1E4_351659847;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.433 -0400", hash_original_method = "0F469F25708F7CED7810AA1C6F552E30", hash_generated_method = "542144C3C4C9B13C75081C517A6B2D20")
    protected void log(String line) {
        addTaint(line.getTaint());
        Log.println(priority, tag, line);
        // ---------- Original Method ----------
        //Log.println(priority, tag, line);
    }

    
}

