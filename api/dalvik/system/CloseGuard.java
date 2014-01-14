package dalvik.system;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public final class CloseGuard {

    /**
     * Returns a CloseGuard instance. If CloseGuard is enabled, {@code
     * #open(String)} can be used to set up the instance to warn on
     * failure to close. If CloseGuard is disabled, a non-null no-op
     * instance is returned.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:38.908 -0500", hash_original_method = "60AA5991C5D5BFE19992192180646E81", hash_generated_method = "D63DC4D9AAA49649EDA1206BE665E8CE")
    
public static CloseGuard get() {
        if (!ENABLED) {
            return NOOP;
        }
        return new CloseGuard();
    }

    /**
     * Used to enable or disable CloseGuard. Note that CloseGuard only
     * warns if it is enabled for both allocation and finalization.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:38.911 -0500", hash_original_method = "53F9E7719DDD6D5480287D0F89E86DFF", hash_generated_method = "55BD6F93933C40B16BA3F98E6D2A56A0")
    
public static void setEnabled(boolean enabled) {
        ENABLED = enabled;
    }

    /**
     * Used to replace default Reporter used to warn of CloseGuard
     * violations. Must be non-null.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:38.913 -0500", hash_original_method = "150DC033BA91B5EF524041581C913795", hash_generated_method = "06CBF192CC52CAE3BB1B81869648BB50")
    
public static void setReporter(Reporter reporter) {
        if (reporter == null) {
            throw new NullPointerException("reporter == null");
        }
        REPORTER = reporter;
    }

    /**
     * Returns non-null CloseGuard.Reporter.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:38.915 -0500", hash_original_method = "8AA20116AD29534DA3D86FA9B0344405", hash_generated_method = "F5F2AE543AA2DF6E031E1B38EA90EB2B")
    
public static Reporter getReporter() {
        return REPORTER;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:38.901 -0500", hash_original_field = "13E1C221CB9CAE7988489B9BF0D832C9", hash_generated_field = "C10943489F8B89CF7ADE14A12DF97BD7")

    private static final CloseGuard NOOP = new CloseGuard();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:38.903 -0500", hash_original_field = "8D40AC6199E06407B424D2258997A5D0", hash_generated_field = "586D4118FF492C8CC206E71580A49A86")

    private static volatile boolean ENABLED = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:38.906 -0500", hash_original_field = "A8B57BFBC1D8F9E08FC87F76A03D9D8E", hash_generated_field = "DF9696A06D1C0D651D2EB3F16557B6F9")

    private static volatile Reporter REPORTER = new DefaultReporter();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:38.923 -0500", hash_original_field = "D9BBD2AF83C2C4CB7F78F512A96041CB", hash_generated_field = "F1E524DCBDC62F863E8D6EE01D213C25")

    private Throwable allocationSite;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:38.918 -0500", hash_original_method = "7E89EAFA67D8405D89044A4D05C8D63F", hash_generated_method = "B3D29D5542BF9E328A13CFD209136F2F")
    
private CloseGuard() {}
    
    private static final class DefaultReporter implements Reporter {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.702 -0400", hash_original_method = "5AA262E6EA3904FB58CC8171943AAF5F", hash_generated_method = "5AA262E6EA3904FB58CC8171943AAF5F")
        public DefaultReporter ()
        {
            //Synthesized constructor
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:38.934 -0500", hash_original_method = "F3799B66B3E6BA78B84AD9198872DB1A", hash_generated_method = "83E6EAF1A40141F0503D87D854C4B112")
        
public void report (String message, Throwable allocationSite) {
            System.logW(message, allocationSite);
        }
        
    }
    
    public static interface Reporter {
        public void report (String message, Throwable allocationSite);
    }

    /**
     * If CloseGuard is enabled, {@code open} initializes the instance
     * with a warning that the caller should have explicitly called the
     * {@code closer} method instead of relying on finalization.
     *
     * @param closer non-null name of explicit termination method
     * @throws NullPointerException if closer is null, regardless of
     * whether or not CloseGuard is enabled
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:38.920 -0500", hash_original_method = "CFE7FE2A946B79A92C3DD646F9FF1E18", hash_generated_method = "ED10F0023C4A0D461BD6AD404EF66411")
    
public void open(String closer) {
        // always perform the check for valid API usage...
        if (closer == null) {
            throw new NullPointerException("closer == null");
        }
        // ...but avoid allocating an allocationSite if disabled
        if (this == NOOP || !ENABLED) {
            return;
        }
        String message = "Explicit termination method '" + closer + "' not called";
        allocationSite = new Throwable(message);
    }

    /**
     * Marks this CloseGuard instance as closed to avoid warnings on
     * finalization.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:38.925 -0500", hash_original_method = "E7BB2570D728B9A5CD21AC75D54C0108", hash_generated_method = "CE202FCAD5E6E9A2CA81ACFFDEF02262")
    
public void close() {
        allocationSite = null;
    }

    /**
     * If CloseGuard is enabled, logs a warning if the caller did not
     * properly cleanup by calling an explicit close method
     * before finalization. If CloseGuard is disable, no action is
     * performed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:38.928 -0500", hash_original_method = "DF59B79C33BF4141D53B378215072C22", hash_generated_method = "3380A596825E0603F4B005C3B9BA3BF5")
    
public void warnIfOpen() {
        if (allocationSite == null || !ENABLED) {
            return;
        }

        String message =
                ("A resource was acquired at attached stack trace but never released. "
                 + "See java.io.Closeable for information on avoiding resource leaks.");

        REPORTER.report(message, allocationSite);
    }
}

