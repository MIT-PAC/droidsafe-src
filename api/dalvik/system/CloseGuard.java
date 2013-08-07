package dalvik.system;

// Droidsafe Imports
import droidsafe.annotations.*;





public final class CloseGuard {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.700 -0400", hash_original_field = "C78FE49CD0EFBD6FEE2F4A621355386F", hash_generated_field = "F1E524DCBDC62F863E8D6EE01D213C25")

    private Throwable allocationSite;
    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.700 -0400", hash_original_method = "7E89EAFA67D8405D89044A4D05C8D63F", hash_generated_method = "AA4636AB88E09C5D66362FE0FE9F4125")
    private  CloseGuard() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.BAN)
    public static CloseGuard get() {
        if (!ENABLED) {
            return NOOP;
        }
        return new CloseGuard();
    }

    
    @DSModeled(DSC.BAN)
    public static void setEnabled(boolean enabled) {
        ENABLED = enabled;
    }

    
    @DSModeled(DSC.BAN)
    public static void setReporter(Reporter reporter) {
        if (reporter == null) {
            throw new NullPointerException("reporter == null");
        }
        REPORTER = reporter;
    }

    
    @DSModeled(DSC.BAN)
    public static Reporter getReporter() {
        return REPORTER;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.701 -0400", hash_original_method = "CFE7FE2A946B79A92C3DD646F9FF1E18", hash_generated_method = "F2A93D6051FAEA52560A5920615D6C66")
    public void open(String closer) {
        addTaint(closer.getTaint());
        if(closer == null)        
        {
            NullPointerException var362168869D1211A712F7A548F30640CF_1918673413 = new NullPointerException("closer == null");
            var362168869D1211A712F7A548F30640CF_1918673413.addTaint(taint);
            throw var362168869D1211A712F7A548F30640CF_1918673413;
        } //End block
        if(this == NOOP || !ENABLED)        
        {
            return;
        } //End block
        String message = "Explicit termination method '" + closer + "' not called";
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

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.701 -0400", hash_original_method = "E7BB2570D728B9A5CD21AC75D54C0108", hash_generated_method = "81B1FE4E6BB63DD2B6DF9A82CBBAEB20")
    public void close() {
        allocationSite = null;
        // ---------- Original Method ----------
        //allocationSite = null;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.701 -0400", hash_original_method = "DF59B79C33BF4141D53B378215072C22", hash_generated_method = "DF945FDB3C65F8170638FDCAE1EA2D2E")
    public void warnIfOpen() {
        if(allocationSite == null || !ENABLED)        
        {
            return;
        } //End block
        String message = ("A resource was acquired at attached stack trace but never released. "
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
        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.702 -0400", hash_original_method = "5AA262E6EA3904FB58CC8171943AAF5F", hash_generated_method = "5AA262E6EA3904FB58CC8171943AAF5F")
        public DefaultReporter ()
        {
            //Synthesized constructor
        }


                @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.702 -0400", hash_original_method = "F3799B66B3E6BA78B84AD9198872DB1A", hash_generated_method = "03E00BBDC903B68C437106FB6D15882E")
        public void report(String message, Throwable allocationSite) {
            addTaint(allocationSite.getTaint());
            addTaint(message.getTaint());
            System.logW(message, allocationSite);
            // ---------- Original Method ----------
            //System.logW(message, allocationSite);
        }

        
    }


    
    public static interface Reporter {
        public void report (String message, Throwable allocationSite);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.702 -0400", hash_original_field = "34212F0A95B2050B7B2FB9D511E5D5E1", hash_generated_field = "C10943489F8B89CF7ADE14A12DF97BD7")

    private static final CloseGuard NOOP = new CloseGuard();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.702 -0400", hash_original_field = "2C9A81D70B6C9EE1379ED35BACB43A7F", hash_generated_field = "586D4118FF492C8CC206E71580A49A86")

    private static volatile boolean ENABLED = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.702 -0400", hash_original_field = "AA403BAC69E1ACBB072EA72BA55B86F3", hash_generated_field = "DF9696A06D1C0D651D2EB3F16557B6F9")

    private static volatile Reporter REPORTER = new DefaultReporter();
}

