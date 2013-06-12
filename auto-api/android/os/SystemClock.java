package android.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public final class SystemClock {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.029 -0400", hash_original_method = "447AF20F3E8B0F9406C259A46D1AF12B", hash_generated_method = "665879737290B67C9E6D406C54DDD95D")
    @DSModeled(DSC.SAFE)
    private SystemClock() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.029 -0400", hash_original_method = "D4BA21E42781D683EDE66760B12EFE55", hash_generated_method = "DE4BA6B634488A3C37FD7715CD63B750")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.029 -0400", hash_original_method = "405B72920785EA4B71566482F44A8ED1", hash_generated_method = "EAC4EB9A521D7BD6726543282C293CB6")
    public static boolean setCurrentTimeMillis(long millis) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.030 -0400", hash_original_method = "FB8381F5E163A4124CF8801B2F64353D", hash_generated_method = "DE57BDF1959F5EDC705E28B11BDD647E")
    public static long uptimeMillis() {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.030 -0400", hash_original_method = "954354B0733FEADBB61A372DD11790C7", hash_generated_method = "5076E7071F1B3C8CB74386E47B3DCA57")
    public static long elapsedRealtime() {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.030 -0400", hash_original_method = "4F045728C29325B3E14EE1F7B3FC508D", hash_generated_method = "15D84A698E9B928725EDD8A3DFB2755F")
    public static long currentThreadTimeMillis() {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.030 -0400", hash_original_method = "EC25C3FD47BF2BEE8108817F50A0803D", hash_generated_method = "115AC336FFDEC91B7BFDD5603E88C13E")
    public static long currentThreadTimeMicro() {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.030 -0400", hash_original_method = "28F0E2E96FB400E57C15E55EB25924E6", hash_generated_method = "76FC2F30FC2BFC831075B13354A006F3")
    public static long currentTimeMicro() {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
}


