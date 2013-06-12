package android.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public final class SystemClock {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:01.319 -0400", hash_original_method = "447AF20F3E8B0F9406C259A46D1AF12B", hash_generated_method = "665879737290B67C9E6D406C54DDD95D")
    @DSModeled(DSC.SAFE)
    private SystemClock() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:01.319 -0400", hash_original_method = "D4BA21E42781D683EDE66760B12EFE55", hash_generated_method = "DE4BA6B634488A3C37FD7715CD63B750")
    public static void sleep(long ms) {
        long start = uptimeMillis();
        long duration = ms;
        boolean interrupted = false;
        do {
            try {
                Thread.sleep(duration);
            }
            catch (InterruptedException e) {
                interrupted = true;
            }
            duration = start + ms - uptimeMillis();
        } while (duration > 0);
        if (interrupted) {
            Thread.currentThread().interrupt();
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:01.320 -0400", hash_original_method = "405B72920785EA4B71566482F44A8ED1", hash_generated_method = "E7DF2B475DE3F5CF20145110C33F5E99")
    public static boolean setCurrentTimeMillis(long millis) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:01.320 -0400", hash_original_method = "FB8381F5E163A4124CF8801B2F64353D", hash_generated_method = "42411A005A904DC27FD8C87571081208")
    public static long uptimeMillis() {
        return DSUtils.UNKNOWN_LONG;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:01.320 -0400", hash_original_method = "954354B0733FEADBB61A372DD11790C7", hash_generated_method = "27C20168B69DFC6181884AFF23A7B8EA")
    public static long elapsedRealtime() {
        return DSUtils.UNKNOWN_LONG;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:01.321 -0400", hash_original_method = "4F045728C29325B3E14EE1F7B3FC508D", hash_generated_method = "6B682E8302C277E16CAAFACCA12F71DA")
    public static long currentThreadTimeMillis() {
        return DSUtils.UNKNOWN_LONG;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:01.321 -0400", hash_original_method = "EC25C3FD47BF2BEE8108817F50A0803D", hash_generated_method = "1FE94519CB0B0CAB2306D233009267E5")
    public static long currentThreadTimeMicro() {
        return DSUtils.UNKNOWN_LONG;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:01.323 -0400", hash_original_method = "28F0E2E96FB400E57C15E55EB25924E6", hash_generated_method = "96F8E4EF4861E78DFF4B47A6B20C26BC")
    public static long currentTimeMicro() {
        return DSUtils.UNKNOWN_LONG;
    }

    
}


