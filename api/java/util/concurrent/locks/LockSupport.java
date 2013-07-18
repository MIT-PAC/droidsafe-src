package java.util.concurrent.locks;

// Droidsafe Imports
import sun.misc.Unsafe;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class LockSupport {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.446 -0400", hash_original_method = "1CF344A2CC5D467FE100F1B8497D1A42", hash_generated_method = "97F54F0429C724F0C1E459A848015358")
    private  LockSupport() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    private static void setBlocker(Thread t, Object arg) {
        unsafe.putObject(t, parkBlockerOffset, arg);
    }

    
    @DSModeled(DSC.SAFE)
    public static void unpark(Thread thread) {
        if (thread != null)
            unsafe.unpark(thread);
    }

    
    @DSModeled(DSC.SAFE)
    public static void park(Object blocker) {
        Thread t = Thread.currentThread();
        setBlocker(t, blocker);
        unsafe.park(false, 0L);
        setBlocker(t, null);
    }

    
    @DSModeled(DSC.SAFE)
    public static void parkNanos(Object blocker, long nanos) {
        if (nanos > 0) {
            Thread t = Thread.currentThread();
            setBlocker(t, blocker);
            unsafe.park(false, nanos);
            setBlocker(t, null);
        }
    }

    
    @DSModeled(DSC.SAFE)
    public static void parkUntil(Object blocker, long deadline) {
        Thread t = Thread.currentThread();
        setBlocker(t, blocker);
        unsafe.park(true, deadline);
        setBlocker(t, null);
    }

    
    @DSModeled(DSC.SAFE)
    public static Object getBlocker(Thread t) {
        return unsafe.getObjectVolatile(t, parkBlockerOffset);
    }

    
    @DSModeled(DSC.SAFE)
    public static void park() {
        unsafe.park(false, 0L);
    }

    
    @DSModeled(DSC.SAFE)
    public static void parkNanos(long nanos) {
        if (nanos > 0)
            unsafe.park(false, nanos);
    }

    
    @DSModeled(DSC.SAFE)
    public static void parkUntil(long deadline) {
        unsafe.park(true, deadline);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.449 -0400", hash_original_field = "4B38931B7448D73BB4E1EC1A0BEC037D", hash_generated_field = "E7D465D52C267C4626E00B16AF4442B8")

    private static final Unsafe unsafe = UnsafeAccess.THE_ONE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.449 -0400", hash_original_field = "A8A4344C6808D78974FFD554CCEA0F0B", hash_generated_field = "A3FC8849D30CDF7DB6C0BEA0BD7A4D99")

    private static long parkBlockerOffset;
    static {
        try {
            parkBlockerOffset = unsafe.objectFieldOffset
                (java.lang.Thread.class.getDeclaredField("parkBlocker"));
        } catch (Exception ex) { throw new Error(ex); }
    }
    
}

