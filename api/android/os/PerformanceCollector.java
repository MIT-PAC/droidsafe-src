package android.os;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.ArrayList;

public class PerformanceCollector {

    /*
     * Starts allocation counting. This triggers a gc and resets the counts.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:37.771 -0500", hash_original_method = "7FDB53D95055F8344C6717BAA41CDD62", hash_generated_method = "729609E68190913C71FE6831B61BC37F")
    
private static void startAllocCounting() {
        // Before we start trigger a GC and reset the debug counts. Run the
        // finalizers and another GC before starting and stopping the alloc
        // counts. This will free up any objects that were just sitting around
        // waiting for their finalizers to be run.
        Runtime.getRuntime().gc();
        Runtime.getRuntime().runFinalization();
        Runtime.getRuntime().gc();

        Debug.resetAllCounts();

        // start the counts
        Debug.startAllocCounting();
    }

    /*
     * Stops allocation counting.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:37.774 -0500", hash_original_method = "0DC5272531C251864B2A214C154F0F7A", hash_generated_method = "3A9D366252C742A066ADABECE4A40E47")
    
private static void stopAllocCounting() {
        Runtime.getRuntime().gc();
        Runtime.getRuntime().runFinalization();
        Runtime.getRuntime().gc();
        Debug.stopAllocCounting();
    }

    /*
     * Returns a bundle with the current results from the allocation counting.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:37.776 -0500", hash_original_method = "7570D27A875B3A44DAA62C272011DD54", hash_generated_method = "772B146FEA3E121C7837D1BD62F32365")
    
private static Bundle getAllocCounts() {
        Bundle results = new Bundle();
        results.putLong(METRIC_KEY_GLOBAL_ALLOC_COUNT, Debug.getGlobalAllocCount());
        results.putLong(METRIC_KEY_GLOBAL_ALLOC_SIZE, Debug.getGlobalAllocSize());
        results.putLong(METRIC_KEY_GLOBAL_FREED_COUNT, Debug.getGlobalFreedCount());
        results.putLong(METRIC_KEY_GLOBAL_FREED_SIZE, Debug.getGlobalFreedSize());
        results.putLong(METRIC_KEY_GC_INVOCATION_COUNT, Debug.getGlobalGcInvocationCount());
        return results;
    }

    /*
     * Returns a bundle with the counts for various binder counts for this
     * process. Currently the only two that are reported are the number of send
     * and the number of received transactions.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:37.778 -0500", hash_original_method = "B58C6F13B6A7E24472B49AF10049B588", hash_generated_method = "55C8C040B7BC6BDE1CDC0B9FEC74A1A8")
    
private static Bundle getBinderCounts() {
        Bundle results = new Bundle();
        results.putLong(METRIC_KEY_SENT_TRANSACTIONS, Debug.getBinderSentTransactions());
        results.putLong(METRIC_KEY_RECEIVED_TRANSACTIONS, Debug.getBinderReceivedTransactions());
        return results;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:37.657 -0500", hash_original_field = "C097002E51AE9DC8E10827EF167BF9F4", hash_generated_field = "1D7890C1BD5FA236C5D0FD55992B18CF")

    public static final String METRIC_KEY_ITERATIONS = "iterations";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:37.659 -0500", hash_original_field = "000CE28D7C58965F437C13A23805010D", hash_generated_field = "86E70D28A98D79A6D6F47C72F3222FE8")

    public static final String METRIC_KEY_LABEL = "label";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:37.662 -0500", hash_original_field = "2F9A6C3F27A40CA3918CD7711E9794D4", hash_generated_field = "77B6548FC4B73EB3ADF155FC60C0D532")

    public static final String METRIC_KEY_CPU_TIME = "cpu_time";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:37.664 -0500", hash_original_field = "42AC60E173310EEE4069C1779EA2F32E", hash_generated_field = "4C812288505951DC5D7BE4B66E572C74")

    public static final String METRIC_KEY_EXECUTION_TIME = "execution_time";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:37.667 -0500", hash_original_field = "0E23B62703B77D33166C042A08B7F39E", hash_generated_field = "F9C012B372C48271470C88B3ECB1971F")

    public static final String METRIC_KEY_PRE_RECEIVED_TRANSACTIONS = "pre_received_transactions";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:37.669 -0500", hash_original_field = "FF740868D2BD7E00F723391EF675B9F5", hash_generated_field = "5409646691D7EB77F28FB72511989A7B")

    public static final String METRIC_KEY_PRE_SENT_TRANSACTIONS = "pre_sent_transactions";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:37.672 -0500", hash_original_field = "3F3DAD68E357B14F06A1FD25C63C60AF", hash_generated_field = "DC558879723642FA47D1968D4255A1C3")

    public static final String METRIC_KEY_RECEIVED_TRANSACTIONS = "received_transactions";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:37.674 -0500", hash_original_field = "3BBB3EED121E2859E8C8FCFB934E9AB1", hash_generated_field = "BD6B8CEA268DF487B24116A56395CDD0")

    public static final String METRIC_KEY_SENT_TRANSACTIONS = "sent_transactions";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:37.676 -0500", hash_original_field = "0F7C02FF5882595DD544794F95572EA6", hash_generated_field = "A2AA92FFB88183B4F24057311349ED58")

    public static final String METRIC_KEY_GC_INVOCATION_COUNT = "gc_invocation_count";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:37.678 -0500", hash_original_field = "F353BDB0FDC42A8A6D4AD98A660C98D1", hash_generated_field = "3BE2D32F7E26E9BD224D27B30715DE91")

    public static final String METRIC_KEY_JAVA_ALLOCATED = "java_allocated";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:37.680 -0500", hash_original_field = "E28308E849AF2BDE4DDFDF960BEBA893", hash_generated_field = "5A283F60187263FA3CECC1DD5773CFBC")

    public static final String METRIC_KEY_JAVA_FREE = "java_free";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:37.683 -0500", hash_original_field = "2123BCB4A7B421D2A38D17656A47F66C", hash_generated_field = "1D289C5644FA9767C2E31DD49F0EDE9C")

    public static final String METRIC_KEY_JAVA_PRIVATE_DIRTY = "java_private_dirty";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:37.685 -0500", hash_original_field = "7C6DCD97F8E4D868FF31491E978F7415", hash_generated_field = "80ACA2CC85B0F985638C7AD424E753BD")

    public static final String METRIC_KEY_JAVA_PSS = "java_pss";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:37.688 -0500", hash_original_field = "2C738D5870D8B39C30C08BE2D18E1CEA", hash_generated_field = "771DB8E8D936FEF928A6689C9F56F28E")

    public static final String METRIC_KEY_JAVA_SHARED_DIRTY = "java_shared_dirty";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:37.690 -0500", hash_original_field = "0209F27D0B8C8A1C60E518EE73FDE59B", hash_generated_field = "A2B7475836759D50B19B1BAABC8470B0")

    public static final String METRIC_KEY_JAVA_SIZE = "java_size";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:37.693 -0500", hash_original_field = "203D133B9D0D199307D829123E10346B", hash_generated_field = "9FCCDC80F37FDA149843B665F88B02B4")

    public static final String METRIC_KEY_NATIVE_ALLOCATED = "native_allocated";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:37.695 -0500", hash_original_field = "A19BBAA1A5CCEF6DACBF354122665118", hash_generated_field = "672D9746FA921B21491CD569E29859DD")

    public static final String METRIC_KEY_NATIVE_FREE = "native_free";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:37.697 -0500", hash_original_field = "BF4D6545AFE87D7DF0A3778E2ADEF5CB", hash_generated_field = "DD95072F63E3D5208F19F7BFFCEB7AC0")

    public static final String METRIC_KEY_NATIVE_PRIVATE_DIRTY = "native_private_dirty";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:37.700 -0500", hash_original_field = "1B4539610A84916BD9519C24F4B6CAA6", hash_generated_field = "E42F6602BEA2FE75D3F5AEF606D6C08C")

    public static final String METRIC_KEY_NATIVE_PSS = "native_pss";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:37.703 -0500", hash_original_field = "9D1E1056006EB8E7E3FC90059EAE4224", hash_generated_field = "6CE2FD1E3E12963FEB9E78BA78A8A67B")

    public static final String METRIC_KEY_NATIVE_SHARED_DIRTY = "native_shared_dirty";
    
    public interface PerformanceResultsWriter {
        
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public void writeBeginSnapshot(String label);
        
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public void writeEndSnapshot(Bundle results);
        
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public void writeStartTiming(String label);
        
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public void writeStopTiming(Bundle results);
        
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public void writeMeasurement(String label, long value);
        
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public void writeMeasurement(String label, float value);
        
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public void writeMeasurement(String label, String value);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:37.705 -0500", hash_original_field = "9E3E985E10482824135654A526170E3B", hash_generated_field = "49E99AC048E613E8191A91BC78FAE993")

    public static final String METRIC_KEY_NATIVE_SIZE = "native_size";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:37.708 -0500", hash_original_field = "FB77398B03936668227213B4B937A5AB", hash_generated_field = "AE96E4BEBF83CC3706569C9EB8F76FF7")

    public static final String METRIC_KEY_GLOBAL_ALLOC_COUNT = "global_alloc_count";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:37.710 -0500", hash_original_field = "93A1522462C7A910A53C9FE4B7349F62", hash_generated_field = "4EE641C2D656B628ABAC8495CF18A8DD")

    public static final String METRIC_KEY_GLOBAL_ALLOC_SIZE = "global_alloc_size";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:37.713 -0500", hash_original_field = "096E7D2F9F032E70D219372738529744", hash_generated_field = "A58EBCA1F6AE94437D14AFAE9C39B726")

    public static final String METRIC_KEY_GLOBAL_FREED_COUNT = "global_freed_count";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:37.716 -0500", hash_original_field = "528873753E3A519889328F02CBBFD146", hash_generated_field = "0914CF9C312CD253CD765DCC71D122F9")

    public static final String METRIC_KEY_GLOBAL_FREED_SIZE = "global_freed_size";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:37.718 -0500", hash_original_field = "4BBB2508874EC4F64731B6DFC4BA77FF", hash_generated_field = "581412CDC2C6ECB9CE0B4F204B43C2DF")

    public static final String METRIC_KEY_OTHER_PRIVATE_DIRTY = "other_private_dirty";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:37.720 -0500", hash_original_field = "2AA718B05C0A5CD8B7033FA1F5B51FE4", hash_generated_field = "7C88A8007679EADC984537E1CAFCE6AD")

    public static final String METRIC_KEY_OTHER_PSS = "other_pss";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:37.723 -0500", hash_original_field = "2A4074CDF8E256ABF9D6AD9C39B281B1", hash_generated_field = "ED3F38BBCD9CD55DE2C91BBBF176A48C")

    public static final String METRIC_KEY_OTHER_SHARED_DIRTY = "other_shared_dirty";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:37.725 -0500", hash_original_field = "E336978E128E2D4BAC13ECE6FC28940B", hash_generated_field = "2E6B5EF6C826CFAA09973D53DE7A3FDC")

    private PerformanceResultsWriter mPerfWriter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:37.727 -0500", hash_original_field = "8F74EC1B4041FB5D1438D41143191AED", hash_generated_field = "C52DFF4EAE973D9A0B515C624EA1B572")

    private Bundle mPerfSnapshot;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:37.729 -0500", hash_original_field = "4E6F93DFBD61FBA96DB4A077D2DCE70F", hash_generated_field = "A49B1FB08B88F40C1B360A21064E1B7D")

    private Bundle mPerfMeasurement;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:37.731 -0500", hash_original_field = "F50E67148DB6C3F036FB3F3CFA00A62D", hash_generated_field = "BC16E2E92895711EBE19B0CBACC641DD")

    private long mSnapshotCpuTime;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:37.733 -0500", hash_original_field = "D1B0EB8C8162219F04E0A05257FD8621", hash_generated_field = "C5F0C15458BC4B393B0CAA896E7D06F7")

    private long mSnapshotExecTime;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:37.735 -0500", hash_original_field = "6E0B5027664579C4AE8EF7A61E5FA1F2", hash_generated_field = "79EEABA38A66B76B3AF5F1D6CF746428")

    private long mCpuTime;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:37.737 -0500", hash_original_field = "263A07172FF50705CD7EA231605434D5", hash_generated_field = "1D443F14238FC42E629544415CC62589")

    private long mExecTime;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:37.739 -0500", hash_original_method = "405D2609A0193176D2AFC5D34E96663C", hash_generated_method = "95048C1E06FA66DBDE41482B341D09BD")
    
public PerformanceCollector() {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:37.742 -0500", hash_original_method = "9149F2AAE94E2FF1A90DA44ADCB7F1A5", hash_generated_method = "6D3AF9108A02B1ECDD38B9337E899BA4")
    
public PerformanceCollector(PerformanceResultsWriter writer) {
        setPerformanceResultsWriter(writer);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:37.744 -0500", hash_original_method = "37F3C4CB00E2065177941F440A1EB96E", hash_generated_method = "208A4627DE12EEF6AF05DEF218E1C36B")
    
public void setPerformanceResultsWriter(PerformanceResultsWriter writer) {
        mPerfWriter = writer;
    }

    /**
     * Begin collection of memory usage information.
     *
     * @param label description of code block between beginSnapshot and
     *              endSnapshot, used to label output
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:37.747 -0500", hash_original_method = "29FF8CD15679E582F927741D3542D4F3", hash_generated_method = "5A15DF946630486D0C3259F1C44DC8DB")
    
public void beginSnapshot(String label) {
        if (mPerfWriter != null)
            mPerfWriter.writeBeginSnapshot(label);
        startPerformanceSnapshot();
    }

    /**
     * End collection of memory usage information. Returns collected data in a
     * Bundle object.
     *
     * @return Memory and runtime metrics stored as key/value pairs. Values are
     *         of type long, and keys include:
     *         <ul>
     *         <li>{@link #METRIC_KEY_CPU_TIME cpu_time}
     *         <li>{@link #METRIC_KEY_EXECUTION_TIME execution_time}
     *         <li>{@link #METRIC_KEY_PRE_RECEIVED_TRANSACTIONS
     *         pre_received_transactions}
     *         <li>{@link #METRIC_KEY_PRE_SENT_TRANSACTIONS
     *         pre_sent_transactions}
     *         <li>{@link #METRIC_KEY_RECEIVED_TRANSACTIONS
     *         received_transactions}
     *         <li>{@link #METRIC_KEY_SENT_TRANSACTIONS sent_transactions}
     *         <li>{@link #METRIC_KEY_GC_INVOCATION_COUNT gc_invocation_count}
     *         <li>{@link #METRIC_KEY_JAVA_ALLOCATED java_allocated}
     *         <li>{@link #METRIC_KEY_JAVA_FREE java_free}
     *         <li>{@link #METRIC_KEY_JAVA_PRIVATE_DIRTY java_private_dirty}
     *         <li>{@link #METRIC_KEY_JAVA_PSS java_pss}
     *         <li>{@link #METRIC_KEY_JAVA_SHARED_DIRTY java_shared_dirty}
     *         <li>{@link #METRIC_KEY_JAVA_SIZE java_size}
     *         <li>{@link #METRIC_KEY_NATIVE_ALLOCATED native_allocated}
     *         <li>{@link #METRIC_KEY_NATIVE_FREE native_free}
     *         <li>{@link #METRIC_KEY_NATIVE_PRIVATE_DIRTY native_private_dirty}
     *         <li>{@link #METRIC_KEY_NATIVE_PSS native_pss}
     *         <li>{@link #METRIC_KEY_NATIVE_SHARED_DIRTY native_shared_dirty}
     *         <li>{@link #METRIC_KEY_NATIVE_SIZE native_size}
     *         <li>{@link #METRIC_KEY_GLOBAL_ALLOC_COUNT global_alloc_count}
     *         <li>{@link #METRIC_KEY_GLOBAL_ALLOC_SIZE global_alloc_size}
     *         <li>{@link #METRIC_KEY_GLOBAL_FREED_COUNT global_freed_count}
     *         <li>{@link #METRIC_KEY_GLOBAL_FREED_SIZE global_freed_size}
     *         <li>{@link #METRIC_KEY_OTHER_PRIVATE_DIRTY other_private_dirty}
     *         <li>{@link #METRIC_KEY_OTHER_PSS other_pss}
     *         <li>{@link #METRIC_KEY_OTHER_SHARED_DIRTY other_shared_dirty}
     *         </ul>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:37.749 -0500", hash_original_method = "6B502666465A4C791D4C2AED784D2CB8", hash_generated_method = "A30A9F849889E9B046E57F6E26E22E04")
    
public Bundle endSnapshot() {
        endPerformanceSnapshot();
        if (mPerfWriter != null)
            mPerfWriter.writeEndSnapshot(mPerfSnapshot);
        return mPerfSnapshot;
    }

    /**
     * Start measurement of user and cpu time.
     *
     * @param label description of code block between startTiming and
     *        stopTiming, used to label output
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:37.751 -0500", hash_original_method = "15BE0BB59194B3FBDF2799231E5E71EE", hash_generated_method = "5839B4006D3C723B0CEB76C499D605D6")
    
public void startTiming(String label) {
        if (mPerfWriter != null)
            mPerfWriter.writeStartTiming(label);
        mPerfMeasurement = new Bundle();
        mPerfMeasurement.putParcelableArrayList(
                METRIC_KEY_ITERATIONS, new ArrayList<Parcelable>());
        mExecTime = SystemClock.uptimeMillis();
        mCpuTime = Process.getElapsedCpuTime();
    }

    /**
     * Add a measured segment, and start measuring the next segment. Returns
     * collected data in a Bundle object.
     *
     * @param label description of code block between startTiming and
     *              addIteration, and between two calls to addIteration, used
     *              to label output
     * @return Runtime metrics stored as key/value pairs. Values are of type
     *         long, and keys include:
     *         <ul>
     *         <li>{@link #METRIC_KEY_LABEL label}
     *         <li>{@link #METRIC_KEY_CPU_TIME cpu_time}
     *         <li>{@link #METRIC_KEY_EXECUTION_TIME execution_time}
     *         </ul>
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:37.753 -0500", hash_original_method = "9C0B776255C5FFA271DF9EC0789087D7", hash_generated_method = "6B1DFB93517298A1067B4D93DDD34BA3")
    
public Bundle addIteration(String label) {
        mCpuTime = Process.getElapsedCpuTime() - mCpuTime;
        mExecTime = SystemClock.uptimeMillis() - mExecTime;

        Bundle iteration = new Bundle();
        iteration.putString(METRIC_KEY_LABEL, label);
        iteration.putLong(METRIC_KEY_EXECUTION_TIME, mExecTime);
        iteration.putLong(METRIC_KEY_CPU_TIME, mCpuTime);
        mPerfMeasurement.getParcelableArrayList(METRIC_KEY_ITERATIONS).add(iteration);

        mExecTime = SystemClock.uptimeMillis();
        mCpuTime = Process.getElapsedCpuTime();
        return iteration;
    }

    /**
     * Stop measurement of user and cpu time.
     *
     * @param label description of code block between addIteration or
     *              startTiming and stopTiming, used to label output
     * @return Runtime metrics stored in a bundle, including all iterations
     *         between calls to startTiming and stopTiming. List of iterations
     *         is keyed by {@link #METRIC_KEY_ITERATIONS iterations}.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:37.756 -0500", hash_original_method = "CE19881A0670EADF6F440246450D4521", hash_generated_method = "11594D898B6C795D158A0E9BE6FE6F45")
    
public Bundle stopTiming(String label) {
        addIteration(label);
        if (mPerfWriter != null)
            mPerfWriter.writeStopTiming(mPerfMeasurement);
        return mPerfMeasurement;
    }

    /**
     * Add an integer type measurement to the collector.
     *
     * @param label short description of the metric that was measured
     * @param value long value of the measurement
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:37.758 -0500", hash_original_method = "F7662CC60D6C37C7D8E6A983FE816D6B", hash_generated_method = "FEC72B60E4F52C0543148543EACE8CCF")
    
public void addMeasurement(String label, long value) {
        if (mPerfWriter != null)
            mPerfWriter.writeMeasurement(label, value);
    }

    /**
     * Add a float type measurement to the collector.
     *
     * @param label short description of the metric that was measured
     * @param value float value of the measurement
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:37.761 -0500", hash_original_method = "D91873E003245DBC7EFC93D07019AB08", hash_generated_method = "5487CCC2C0E74BF9C4422144B86A42C8")
    
public void addMeasurement(String label, float value) {
        if (mPerfWriter != null)
            mPerfWriter.writeMeasurement(label, value);
    }

    /**
     * Add a string field to the collector.
     *
     * @param label short description of the metric that was measured
     * @param value string summary of the measurement
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:37.763 -0500", hash_original_method = "8B4722495479149E3D93BD2C6D69D7B4", hash_generated_method = "52DF5D26232D14D615CC8B587C87317E")
    
public void addMeasurement(String label, String value) {
        if (mPerfWriter != null)
            mPerfWriter.writeMeasurement(label, value);
    }

    /*
     * Starts tracking memory usage, binder transactions, and real & cpu timing.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:37.766 -0500", hash_original_method = "1B503104185A94AFFC2FCF84AFCEABAE", hash_generated_method = "864FFB42A8D46850B7A5307CDC05B092")
    
private void startPerformanceSnapshot() {
        // Create new snapshot
        mPerfSnapshot = new Bundle();

        // Add initial binder counts
        Bundle binderCounts = getBinderCounts();
        for (String key : binderCounts.keySet()) {
            mPerfSnapshot.putLong("pre_" + key, binderCounts.getLong(key));
        }

        // Force a GC and zero out the performance counters. Do this
        // before reading initial CPU/wall-clock times so we don't include
        // the cost of this setup in our final metrics.
        startAllocCounting();

        // Record CPU time up to this point, and start timing. Note: this
        // must happen at the end of this method, otherwise the timing will
        // include noise.
        mSnapshotExecTime = SystemClock.uptimeMillis();
        mSnapshotCpuTime = Process.getElapsedCpuTime();
    }

    /*
     * Stops tracking memory usage, binder transactions, and real & cpu timing.
     * Stores collected data as type long into Bundle object for reporting.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:37.769 -0500", hash_original_method = "41A01DA3C680B16D19143811CC413B1E", hash_generated_method = "10ECFB3AE4B6963E66C0DA8778C3E9BE")
    
private void endPerformanceSnapshot() {
        // Stop the timing. This must be done first before any other counting is
        // stopped.
        mSnapshotCpuTime = Process.getElapsedCpuTime() - mSnapshotCpuTime;
        mSnapshotExecTime = SystemClock.uptimeMillis() - mSnapshotExecTime;

        stopAllocCounting();

        long nativeMax = Debug.getNativeHeapSize() / 1024;
        long nativeAllocated = Debug.getNativeHeapAllocatedSize() / 1024;
        long nativeFree = Debug.getNativeHeapFreeSize() / 1024;

        Debug.MemoryInfo memInfo = new Debug.MemoryInfo();
        Debug.getMemoryInfo(memInfo);

        Runtime runtime = Runtime.getRuntime();

        long dalvikMax = runtime.totalMemory() / 1024;
        long dalvikFree = runtime.freeMemory() / 1024;
        long dalvikAllocated = dalvikMax - dalvikFree;

        // Add final binder counts
        Bundle binderCounts = getBinderCounts();
        for (String key : binderCounts.keySet()) {
            mPerfSnapshot.putLong(key, binderCounts.getLong(key));
        }

        // Add alloc counts
        Bundle allocCounts = getAllocCounts();
        for (String key : allocCounts.keySet()) {
            mPerfSnapshot.putLong(key, allocCounts.getLong(key));
        }

        mPerfSnapshot.putLong(METRIC_KEY_EXECUTION_TIME, mSnapshotExecTime);
        mPerfSnapshot.putLong(METRIC_KEY_CPU_TIME, mSnapshotCpuTime);

        mPerfSnapshot.putLong(METRIC_KEY_NATIVE_SIZE, nativeMax);
        mPerfSnapshot.putLong(METRIC_KEY_NATIVE_ALLOCATED, nativeAllocated);
        mPerfSnapshot.putLong(METRIC_KEY_NATIVE_FREE, nativeFree);
        mPerfSnapshot.putLong(METRIC_KEY_NATIVE_PSS, memInfo.nativePss);
        mPerfSnapshot.putLong(METRIC_KEY_NATIVE_PRIVATE_DIRTY, memInfo.nativePrivateDirty);
        mPerfSnapshot.putLong(METRIC_KEY_NATIVE_SHARED_DIRTY, memInfo.nativeSharedDirty);

        mPerfSnapshot.putLong(METRIC_KEY_JAVA_SIZE, dalvikMax);
        mPerfSnapshot.putLong(METRIC_KEY_JAVA_ALLOCATED, dalvikAllocated);
        mPerfSnapshot.putLong(METRIC_KEY_JAVA_FREE, dalvikFree);
        mPerfSnapshot.putLong(METRIC_KEY_JAVA_PSS, memInfo.dalvikPss);
        mPerfSnapshot.putLong(METRIC_KEY_JAVA_PRIVATE_DIRTY, memInfo.dalvikPrivateDirty);
        mPerfSnapshot.putLong(METRIC_KEY_JAVA_SHARED_DIRTY, memInfo.dalvikSharedDirty);

        mPerfSnapshot.putLong(METRIC_KEY_OTHER_PSS, memInfo.otherPss);
        mPerfSnapshot.putLong(METRIC_KEY_OTHER_PRIVATE_DIRTY, memInfo.otherPrivateDirty);
        mPerfSnapshot.putLong(METRIC_KEY_OTHER_SHARED_DIRTY, memInfo.otherSharedDirty);
    }
}

