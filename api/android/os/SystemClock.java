package android.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public final class SystemClock {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:33.784 -0400", hash_original_method = "447AF20F3E8B0F9406C259A46D1AF12B", hash_generated_method = "7A8216692042821899DFD22170D9FC77")
    private  SystemClock() {
        // ---------- Original Method ----------
    }

    
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

    
    @DSModeled(DSC.SAFE)
    public static boolean setCurrentTimeMillis(long millis) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSModeled(DSC.SAFE)
    public static long uptimeMillis() {
        return DSUtils.UNKNOWN_LONG;
    }

    
    @DSModeled(DSC.SAFE)
    public static long elapsedRealtime() {
        return DSUtils.UNKNOWN_LONG;
    }

    
    @DSModeled(DSC.SAFE)
    public static long currentThreadTimeMillis() {
        return DSUtils.UNKNOWN_LONG;
    }

    
    @DSModeled(DSC.SAFE)
    public static long currentThreadTimeMicro() {
        return DSUtils.UNKNOWN_LONG;
    }

    
    @DSModeled(DSC.SAFE)
    public static long currentTimeMicro() {
        return DSUtils.UNKNOWN_LONG;
    }

    
}

