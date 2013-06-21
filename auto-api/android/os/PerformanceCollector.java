package android.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.ArrayList;

public class PerformanceCollector {
    private PerformanceResultsWriter mPerfWriter;
    private Bundle mPerfSnapshot;
    private Bundle mPerfMeasurement;
    private long mSnapshotCpuTime;
    private long mSnapshotExecTime;
    private long mCpuTime;
    private long mExecTime;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.059 -0400", hash_original_method = "405D2609A0193176D2AFC5D34E96663C", hash_generated_method = "3B2002EB63933A95B11D5472AF645642")
    @DSModeled(DSC.SAFE)
    public PerformanceCollector() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.059 -0400", hash_original_method = "9149F2AAE94E2FF1A90DA44ADCB7F1A5", hash_generated_method = "B83168C3CBD81E7040DFD2B868E49317")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PerformanceCollector(PerformanceResultsWriter writer) {
        dsTaint.addTaint(writer.dsTaint);
        setPerformanceResultsWriter(writer);
        // ---------- Original Method ----------
        //setPerformanceResultsWriter(writer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.060 -0400", hash_original_method = "37F3C4CB00E2065177941F440A1EB96E", hash_generated_method = "CF3EBBD364FE3AED255003C9A00F3914")
    @DSModeled(DSC.SAFE)
    public void setPerformanceResultsWriter(PerformanceResultsWriter writer) {
        dsTaint.addTaint(writer.dsTaint);
        // ---------- Original Method ----------
        //mPerfWriter = writer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.061 -0400", hash_original_method = "29FF8CD15679E582F927741D3542D4F3", hash_generated_method = "E435B3D3B929225006DCB3AB4D57DFA4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void beginSnapshot(String label) {
        dsTaint.addTaint(label);
        mPerfWriter.writeBeginSnapshot(label);
        startPerformanceSnapshot();
        // ---------- Original Method ----------
        //if (mPerfWriter != null)
            //mPerfWriter.writeBeginSnapshot(label);
        //startPerformanceSnapshot();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.061 -0400", hash_original_method = "6B502666465A4C791D4C2AED784D2CB8", hash_generated_method = "93F0EB1F4D45797D6EE55CD8A4DBB410")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Bundle endSnapshot() {
        endPerformanceSnapshot();
        mPerfWriter.writeEndSnapshot(mPerfSnapshot);
        return (Bundle)dsTaint.getTaint();
        // ---------- Original Method ----------
        //endPerformanceSnapshot();
        //if (mPerfWriter != null)
            //mPerfWriter.writeEndSnapshot(mPerfSnapshot);
        //return mPerfSnapshot;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.062 -0400", hash_original_method = "15BE0BB59194B3FBDF2799231E5E71EE", hash_generated_method = "CEE193789DD5B87BBA1E19D36E658EBA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void startTiming(String label) {
        dsTaint.addTaint(label);
        mPerfWriter.writeStartTiming(label);
        mPerfMeasurement = new Bundle();
        mPerfMeasurement.putParcelableArrayList(
                METRIC_KEY_ITERATIONS, new ArrayList<Parcelable>());
        mExecTime = SystemClock.uptimeMillis();
        mCpuTime = Process.getElapsedCpuTime();
        // ---------- Original Method ----------
        //if (mPerfWriter != null)
            //mPerfWriter.writeStartTiming(label);
        //mPerfMeasurement = new Bundle();
        //mPerfMeasurement.putParcelableArrayList(
                //METRIC_KEY_ITERATIONS, new ArrayList<Parcelable>());
        //mExecTime = SystemClock.uptimeMillis();
        //mCpuTime = Process.getElapsedCpuTime();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.062 -0400", hash_original_method = "9C0B776255C5FFA271DF9EC0789087D7", hash_generated_method = "CFCB588CC99D1D3B754D7332EC97510F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Bundle addIteration(String label) {
        dsTaint.addTaint(label);
        mCpuTime = Process.getElapsedCpuTime() - mCpuTime;
        mExecTime = SystemClock.uptimeMillis() - mExecTime;
        Bundle iteration;
        iteration = new Bundle();
        iteration.putString(METRIC_KEY_LABEL, label);
        iteration.putLong(METRIC_KEY_EXECUTION_TIME, mExecTime);
        iteration.putLong(METRIC_KEY_CPU_TIME, mCpuTime);
        mPerfMeasurement.getParcelableArrayList(METRIC_KEY_ITERATIONS).add(iteration);
        mExecTime = SystemClock.uptimeMillis();
        mCpuTime = Process.getElapsedCpuTime();
        return (Bundle)dsTaint.getTaint();
        // ---------- Original Method ----------
        //mCpuTime = Process.getElapsedCpuTime() - mCpuTime;
        //mExecTime = SystemClock.uptimeMillis() - mExecTime;
        //Bundle iteration = new Bundle();
        //iteration.putString(METRIC_KEY_LABEL, label);
        //iteration.putLong(METRIC_KEY_EXECUTION_TIME, mExecTime);
        //iteration.putLong(METRIC_KEY_CPU_TIME, mCpuTime);
        //mPerfMeasurement.getParcelableArrayList(METRIC_KEY_ITERATIONS).add(iteration);
        //mExecTime = SystemClock.uptimeMillis();
        //mCpuTime = Process.getElapsedCpuTime();
        //return iteration;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.062 -0400", hash_original_method = "CE19881A0670EADF6F440246450D4521", hash_generated_method = "43E9F484003FE11E1BCDC6F0015DB4A9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Bundle stopTiming(String label) {
        dsTaint.addTaint(label);
        addIteration(label);
        mPerfWriter.writeStopTiming(mPerfMeasurement);
        return (Bundle)dsTaint.getTaint();
        // ---------- Original Method ----------
        //addIteration(label);
        //if (mPerfWriter != null)
            //mPerfWriter.writeStopTiming(mPerfMeasurement);
        //return mPerfMeasurement;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.063 -0400", hash_original_method = "F7662CC60D6C37C7D8E6A983FE816D6B", hash_generated_method = "7FC74AB3235F0085B24714A164C6115B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void addMeasurement(String label, long value) {
        dsTaint.addTaint(value);
        dsTaint.addTaint(label);
        mPerfWriter.writeMeasurement(label, value);
        // ---------- Original Method ----------
        //if (mPerfWriter != null)
            //mPerfWriter.writeMeasurement(label, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.063 -0400", hash_original_method = "D91873E003245DBC7EFC93D07019AB08", hash_generated_method = "0C8DFF658D163371B9A8F8A84C758AB2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void addMeasurement(String label, float value) {
        dsTaint.addTaint(value);
        dsTaint.addTaint(label);
        mPerfWriter.writeMeasurement(label, value);
        // ---------- Original Method ----------
        //if (mPerfWriter != null)
            //mPerfWriter.writeMeasurement(label, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.063 -0400", hash_original_method = "8B4722495479149E3D93BD2C6D69D7B4", hash_generated_method = "54CA3E5924691E3A4C9B711779B53795")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void addMeasurement(String label, String value) {
        dsTaint.addTaint(value);
        dsTaint.addTaint(label);
        mPerfWriter.writeMeasurement(label, value);
        // ---------- Original Method ----------
        //if (mPerfWriter != null)
            //mPerfWriter.writeMeasurement(label, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.067 -0400", hash_original_method = "1B503104185A94AFFC2FCF84AFCEABAE", hash_generated_method = "67BA398055F0CD3638D08976DED5AC9B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void startPerformanceSnapshot() {
        mPerfSnapshot = new Bundle();
        Bundle binderCounts;
        binderCounts = getBinderCounts();
        {
            Iterator<String> varC1F757575F721DB498F3C05BE0B52083_715298218 = (binderCounts.keySet()).iterator();
            varC1F757575F721DB498F3C05BE0B52083_715298218.hasNext();
            String key = varC1F757575F721DB498F3C05BE0B52083_715298218.next();
            {
                mPerfSnapshot.putLong("pre_" + key, binderCounts.getLong(key));
            } //End block
        } //End collapsed parenthetic
        startAllocCounting();
        mSnapshotExecTime = SystemClock.uptimeMillis();
        mSnapshotCpuTime = Process.getElapsedCpuTime();
        // ---------- Original Method ----------
        //mPerfSnapshot = new Bundle();
        //Bundle binderCounts = getBinderCounts();
        //for (String key : binderCounts.keySet()) {
            //mPerfSnapshot.putLong("pre_" + key, binderCounts.getLong(key));
        //}
        //startAllocCounting();
        //mSnapshotExecTime = SystemClock.uptimeMillis();
        //mSnapshotCpuTime = Process.getElapsedCpuTime();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.080 -0400", hash_original_method = "41A01DA3C680B16D19143811CC413B1E", hash_generated_method = "EAE47F6A1AEFFCE6421D449E376D0F6C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void endPerformanceSnapshot() {
        mSnapshotCpuTime = Process.getElapsedCpuTime() - mSnapshotCpuTime;
        mSnapshotExecTime = SystemClock.uptimeMillis() - mSnapshotExecTime;
        stopAllocCounting();
        long nativeMax;
        nativeMax = Debug.getNativeHeapSize() / 1024;
        long nativeAllocated;
        nativeAllocated = Debug.getNativeHeapAllocatedSize() / 1024;
        long nativeFree;
        nativeFree = Debug.getNativeHeapFreeSize() / 1024;
        Debug.MemoryInfo memInfo;
        memInfo = new Debug.MemoryInfo();
        Debug.getMemoryInfo(memInfo);
        Runtime runtime;
        runtime = Runtime.getRuntime();
        long dalvikMax;
        dalvikMax = runtime.totalMemory() / 1024;
        long dalvikFree;
        dalvikFree = runtime.freeMemory() / 1024;
        long dalvikAllocated;
        dalvikAllocated = dalvikMax - dalvikFree;
        Bundle binderCounts;
        binderCounts = getBinderCounts();
        {
            Iterator<String> varC1F757575F721DB498F3C05BE0B52083_2103284054 = (binderCounts.keySet()).iterator();
            varC1F757575F721DB498F3C05BE0B52083_2103284054.hasNext();
            String key = varC1F757575F721DB498F3C05BE0B52083_2103284054.next();
            {
                mPerfSnapshot.putLong(key, binderCounts.getLong(key));
            } //End block
        } //End collapsed parenthetic
        Bundle allocCounts;
        allocCounts = getAllocCounts();
        {
            Iterator<String> var2BBFB4C3EA5780E4017714F0682556AF_24460710 = (allocCounts.keySet()).iterator();
            var2BBFB4C3EA5780E4017714F0682556AF_24460710.hasNext();
            String key = var2BBFB4C3EA5780E4017714F0682556AF_24460710.next();
            {
                mPerfSnapshot.putLong(key, allocCounts.getLong(key));
            } //End block
        } //End collapsed parenthetic
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        private static void startAllocCounting() {
        Runtime.getRuntime().gc();
        Runtime.getRuntime().runFinalization();
        Runtime.getRuntime().gc();
        Debug.resetAllCounts();
        Debug.startAllocCounting();
    }

    
        private static void stopAllocCounting() {
        Runtime.getRuntime().gc();
        Runtime.getRuntime().runFinalization();
        Runtime.getRuntime().gc();
        Debug.stopAllocCounting();
    }

    
        private static Bundle getAllocCounts() {
        Bundle results = new Bundle();
        results.putLong(METRIC_KEY_GLOBAL_ALLOC_COUNT, Debug.getGlobalAllocCount());
        results.putLong(METRIC_KEY_GLOBAL_ALLOC_SIZE, Debug.getGlobalAllocSize());
        results.putLong(METRIC_KEY_GLOBAL_FREED_COUNT, Debug.getGlobalFreedCount());
        results.putLong(METRIC_KEY_GLOBAL_FREED_SIZE, Debug.getGlobalFreedSize());
        results.putLong(METRIC_KEY_GC_INVOCATION_COUNT, Debug.getGlobalGcInvocationCount());
        return results;
    }

    
        private static Bundle getBinderCounts() {
        Bundle results = new Bundle();
        results.putLong(METRIC_KEY_SENT_TRANSACTIONS, Debug.getBinderSentTransactions());
        results.putLong(METRIC_KEY_RECEIVED_TRANSACTIONS, Debug.getBinderReceivedTransactions());
        return results;
    }

    
    public interface PerformanceResultsWriter {

        
        public void writeBeginSnapshot(String label);

        
        public void writeEndSnapshot(Bundle results);

        
        public void writeStartTiming(String label);

        
        public void writeStopTiming(Bundle results);

        
        public void writeMeasurement(String label, long value);

        
        public void writeMeasurement(String label, float value);

        
        public void writeMeasurement(String label, String value);
    }
    
    public static final String METRIC_KEY_ITERATIONS = "iterations";
    public static final String METRIC_KEY_LABEL = "label";
    public static final String METRIC_KEY_CPU_TIME = "cpu_time";
    public static final String METRIC_KEY_EXECUTION_TIME = "execution_time";
    public static final String METRIC_KEY_PRE_RECEIVED_TRANSACTIONS = "pre_received_transactions";
    public static final String METRIC_KEY_PRE_SENT_TRANSACTIONS = "pre_sent_transactions";
    public static final String METRIC_KEY_RECEIVED_TRANSACTIONS = "received_transactions";
    public static final String METRIC_KEY_SENT_TRANSACTIONS = "sent_transactions";
    public static final String METRIC_KEY_GC_INVOCATION_COUNT = "gc_invocation_count";
    public static final String METRIC_KEY_JAVA_ALLOCATED = "java_allocated";
    public static final String METRIC_KEY_JAVA_FREE = "java_free";
    public static final String METRIC_KEY_JAVA_PRIVATE_DIRTY = "java_private_dirty";
    public static final String METRIC_KEY_JAVA_PSS = "java_pss";
    public static final String METRIC_KEY_JAVA_SHARED_DIRTY = "java_shared_dirty";
    public static final String METRIC_KEY_JAVA_SIZE = "java_size";
    public static final String METRIC_KEY_NATIVE_ALLOCATED = "native_allocated";
    public static final String METRIC_KEY_NATIVE_FREE = "native_free";
    public static final String METRIC_KEY_NATIVE_PRIVATE_DIRTY = "native_private_dirty";
    public static final String METRIC_KEY_NATIVE_PSS = "native_pss";
    public static final String METRIC_KEY_NATIVE_SHARED_DIRTY = "native_shared_dirty";
    public static final String METRIC_KEY_NATIVE_SIZE = "native_size";
    public static final String METRIC_KEY_GLOBAL_ALLOC_COUNT = "global_alloc_count";
    public static final String METRIC_KEY_GLOBAL_ALLOC_SIZE = "global_alloc_size";
    public static final String METRIC_KEY_GLOBAL_FREED_COUNT = "global_freed_count";
    public static final String METRIC_KEY_GLOBAL_FREED_SIZE = "global_freed_size";
    public static final String METRIC_KEY_OTHER_PRIVATE_DIRTY = "other_private_dirty";
    public static final String METRIC_KEY_OTHER_PSS = "other_pss";
    public static final String METRIC_KEY_OTHER_SHARED_DIRTY = "other_shared_dirty";
}

