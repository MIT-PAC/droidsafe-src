package dalvik.system;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public final class CloseGuard {
    private static final CloseGuard NOOP = new CloseGuard();
    private static volatile boolean ENABLED = true;
    private static volatile Reporter REPORTER = new DefaultReporter();
    private Throwable allocationSite;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.322 -0400", hash_original_method = "7E89EAFA67D8405D89044A4D05C8D63F", hash_generated_method = "701DC1E0E4AA50C857F64D2D748054FF")
    @DSModeled(DSC.SAFE)
    private CloseGuard() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.322 -0400", hash_original_method = "60AA5991C5D5BFE19992192180646E81", hash_generated_method = "D63DC4D9AAA49649EDA1206BE665E8CE")
    public static CloseGuard get() {
        if (!ENABLED) {
            return NOOP;
        }
        return new CloseGuard();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.322 -0400", hash_original_method = "53F9E7719DDD6D5480287D0F89E86DFF", hash_generated_method = "55BD6F93933C40B16BA3F98E6D2A56A0")
    public static void setEnabled(boolean enabled) {
        ENABLED = enabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.322 -0400", hash_original_method = "150DC033BA91B5EF524041581C913795", hash_generated_method = "06CBF192CC52CAE3BB1B81869648BB50")
    public static void setReporter(Reporter reporter) {
        if (reporter == null) {
            throw new NullPointerException("reporter == null");
        }
        REPORTER = reporter;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.322 -0400", hash_original_method = "8AA20116AD29534DA3D86FA9B0344405", hash_generated_method = "F5F2AE543AA2DF6E031E1B38EA90EB2B")
    public static Reporter getReporter() {
        return REPORTER;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.322 -0400", hash_original_method = "CFE7FE2A946B79A92C3DD646F9FF1E18", hash_generated_method = "1718AC63F42006A62D52BE261FE37DF2")
    @DSModeled(DSC.SAFE)
    public void open(String closer) {
        dsTaint.addTaint(closer);
        {
            throw new NullPointerException("closer == null");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.322 -0400", hash_original_method = "E7BB2570D728B9A5CD21AC75D54C0108", hash_generated_method = "1DC1657707A184ADDF4C83C4312AC290")
    @DSModeled(DSC.SAFE)
    public void close() {
        allocationSite = null;
        // ---------- Original Method ----------
        //allocationSite = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.322 -0400", hash_original_method = "DF59B79C33BF4141D53B378215072C22", hash_generated_method = "CB8B87973F9FE329B551C493B3834510")
    @DSModeled(DSC.SAFE)
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.322 -0400", hash_original_method = "F3799B66B3E6BA78B84AD9198872DB1A", hash_generated_method = "28750E5FE65F42A0C5F3C5B7654A7C39")
        @DSModeled(DSC.SAFE)
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
    
}


