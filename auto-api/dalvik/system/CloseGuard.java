package dalvik.system;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public final class CloseGuard {
    private Throwable allocationSite;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.211 -0400", hash_original_method = "7E89EAFA67D8405D89044A4D05C8D63F", hash_generated_method = "AA4636AB88E09C5D66362FE0FE9F4125")
    @DSModeled(DSC.SAFE)
    private CloseGuard() {
        // ---------- Original Method ----------
    }

    
        public static CloseGuard get() {
        if (!ENABLED) {
            return NOOP;
        }
        return new CloseGuard();
    }

    
        public static void setEnabled(boolean enabled) {
        ENABLED = enabled;
    }

    
        public static void setReporter(Reporter reporter) {
        if (reporter == null) {
            throw new NullPointerException("reporter == null");
        }
        REPORTER = reporter;
    }

    
        public static Reporter getReporter() {
        return REPORTER;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.212 -0400", hash_original_method = "CFE7FE2A946B79A92C3DD646F9FF1E18", hash_generated_method = "F6B42D828BA92BD65F3D9D4F5DD32229")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void open(String closer) {
        dsTaint.addTaint(closer);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("closer == null");
        } //End block
        String message;
        message = "Explicit termination method '" + closer + "' not called";
        allocationSite = new Throwable(message);
        // ---------- Original Method ----------
        //if (closer == null) {
            //throw new NullPointerException("closer == null");
        //}
        //if (this == NOOP || !ENABLED) {
            //return;
        //}
        //String message = "Explicit termination method '" + closer + "' not called";
        //allocationSite = new Throwable(message);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.212 -0400", hash_original_method = "E7BB2570D728B9A5CD21AC75D54C0108", hash_generated_method = "81B1FE4E6BB63DD2B6DF9A82CBBAEB20")
    @DSModeled(DSC.SAFE)
    public void close() {
        allocationSite = null;
        // ---------- Original Method ----------
        //allocationSite = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.212 -0400", hash_original_method = "DF59B79C33BF4141D53B378215072C22", hash_generated_method = "ABD59B8E0639EFA73E2B8A199BF8154D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void warnIfOpen() {
        String message;
        message = ("A resource was acquired at attached stack trace but never released. "
                 + "See java.io.Closeable for information on avoiding resource leaks.");
        REPORTER.report(message, allocationSite);
        // ---------- Original Method ----------
        //if (allocationSite == null || !ENABLED) {
            //return;
        //}
        //String message =
                //("A resource was acquired at attached stack trace but never released. "
                 //+ "See java.io.Closeable for information on avoiding resource leaks.");
        //REPORTER.report(message, allocationSite);
    }

    
    private static final class DefaultReporter implements Reporter {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.212 -0400", hash_original_method = "D8BDEF67D7972649723D6EDD5745A4EF", hash_generated_method = "D8BDEF67D7972649723D6EDD5745A4EF")
                public DefaultReporter ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.212 -0400", hash_original_method = "F3799B66B3E6BA78B84AD9198872DB1A", hash_generated_method = "81D9A3DB088D2F699EFCBDAA7564F774")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void report(String message, Throwable allocationSite) {
            dsTaint.addTaint(message);
            dsTaint.addTaint(allocationSite.dsTaint);
            System.logW(message, allocationSite);
            // ---------- Original Method ----------
            //System.logW(message, allocationSite);
        }

        
    }


    
    public static interface Reporter {
        public void report (String message, Throwable allocationSite);
    }
    
    private static final CloseGuard NOOP = new CloseGuard();
    private static volatile boolean ENABLED = true;
    private static volatile Reporter REPORTER = new DefaultReporter();
}

