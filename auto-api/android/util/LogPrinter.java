package android.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public class LogPrinter implements Printer {
    private final int mPriority;
    private final String mTag;
    private final int mBuffer;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.615 -0400", hash_original_method = "9629B9543A981CEE7F299D04A8C61034", hash_generated_method = "C4FBC343A5290D858A471BEE7D14BA8C")
    @DSModeled(DSC.SAFE)
    public LogPrinter(int priority, String tag) {
        dsTaint.addTaint(priority);
        dsTaint.addTaint(tag);
        mBuffer = Log.LOG_ID_MAIN;
        // ---------- Original Method ----------
        //mPriority = priority;
        //mTag = tag;
        //mBuffer = Log.LOG_ID_MAIN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.615 -0400", hash_original_method = "16324E260A0A478911A34F83B608756D", hash_generated_method = "7D0D5CA12BC83720012FE43F3BD8FE58")
    @DSModeled(DSC.SAFE)
    public LogPrinter(int priority, String tag, int buffer) {
        dsTaint.addTaint(buffer);
        dsTaint.addTaint(priority);
        dsTaint.addTaint(tag);
        // ---------- Original Method ----------
        //mPriority = priority;
        //mTag = tag;
        //mBuffer = buffer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.615 -0400", hash_original_method = "D2615ADE20FCF4A4E82798B55EB09FFC", hash_generated_method = "502BB2B0570C3663212BA88DC52F84C9")
    @DSModeled(DSC.SAFE)
    public void println(String x) {
        dsTaint.addTaint(x);
        Log.println_native(mBuffer, mPriority, mTag, x);
        // ---------- Original Method ----------
        //Log.println_native(mBuffer, mPriority, mTag, x);
    }

    
}


