package dalvik.system;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.FileDescriptor;
import java.io.IOException;

public final class VMDebug {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.274 -0400", hash_original_method = "90647D9537BEB374A6D0146E2B562497", hash_generated_method = "B9ED968C8D502362A08FEAB9C12CBFD2")
    @DSModeled(DSC.SAFE)
    private VMDebug() {
        // ---------- Original Method ----------
    }

    
        public static long lastDebuggerActivity() {
        return DSUtils.UNKNOWN_LONG;
    }

    
        public static boolean isDebuggingEnabled() {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        public static boolean isDebuggerConnected() {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        public static String[] getVmFeatureList() {
        String[] retVal = {DSUtils.UNKNOWN_STRING};
        return retVal;
    }

    
        @Deprecated
    public static void startMethodTracing() {
        startMethodTracing(DEFAULT_METHOD_TRACE_FILE_NAME, 0, 0);
    }

    
        public static void startMethodTracing(String traceFileName,
        int bufferSize, int flags) {
        if (traceFileName == null) {
            throw new NullPointerException();
        }
        startMethodTracingNative(traceFileName, null, bufferSize, flags);
    }

    
        public static void startMethodTracing(String traceFileName,
        FileDescriptor fd, int bufferSize, int flags) {
        if (traceFileName == null || fd == null) {
            throw new NullPointerException();
        }
        startMethodTracingNative(traceFileName, fd, bufferSize, flags);
    }

    
        public static void startMethodTracingDdms(int bufferSize, int flags) {
        startMethodTracingNative(null, null, bufferSize, flags);
    }

    
        private static void startMethodTracingNative(String traceFileName,
        FileDescriptor fd, int bufferSize, int flags) {
    }

    
        public static boolean isMethodTracingActive() {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        public static void stopMethodTracing() {
    }

    
        public static void startEmulatorTracing() {
    }

    
        public static void stopEmulatorTracing() {
    }

    
        public static long threadCpuTimeNanos() {
        return DSUtils.UNKNOWN_LONG;
    }

    
        public static void startAllocCounting() {
    }

    
        public static void stopAllocCounting() {
    }

    
        public static int getAllocCount(int kind) {
        return DSUtils.UNKNOWN_INT;
    }

    
        public static void resetAllocCount(int kinds) {
    }

    
        @Deprecated
    public static int setAllocationLimit(int limit) {
        return -1;
    }

    
        @Deprecated
    public static int setGlobalAllocationLimit(int limit) {
        return -1;
    }

    
        public static void startInstructionCounting() {
    }

    
        public static void stopInstructionCounting() {
    }

    
        public static void getInstructionCount(int[] counts) {
    }

    
        public static void resetInstructionCount() {
    }

    
        public static void printLoadedClasses(int flags) {
    }

    
        public static int getLoadedClassCount() {
        return DSUtils.UNKNOWN_INT;
    }

    
        public static void dumpHprofData(String fileName) throws IOException {
        if (fileName == null)
            throw new NullPointerException();
        dumpHprofData(fileName, null);
    }

    
        public static void dumpHprofDataDdms() {
    }

    
        public static void dumpHprofData(String fileName, FileDescriptor fd) throws IOException {
    }

    
        public static boolean cacheRegisterMap(String classAndMethodDesc) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        public static void dumpReferenceTables() {
    }

    
        public static void crash() {
    }

    
        public static void infopoint(int id) {
    }

    
        private static void startGC() {
    }

    
        private static void startClassPrep() {
    }

    
        public static long countInstancesOfClass(Class klass, boolean assignable) {
        return DSUtils.UNKNOWN_LONG;
    }

    
    @Deprecated static public final String DEFAULT_METHOD_TRACE_FILE_NAME = "/sdcard/dmtrace.trace";
    public static final int TRACE_COUNT_ALLOCS = 1;
    private static final int KIND_ALLOCATED_OBJECTS     = 1<<0;
    private static final int KIND_ALLOCATED_BYTES       = 1<<1;
    private static final int KIND_FREED_OBJECTS         = 1<<2;
    private static final int KIND_FREED_BYTES           = 1<<3;
    private static final int KIND_GC_INVOCATIONS        = 1<<4;
    private static final int KIND_CLASS_INIT_COUNT      = 1<<5;
    private static final int KIND_CLASS_INIT_TIME       = 1<<6;
    private static final int KIND_EXT_ALLOCATED_OBJECTS = 1<<12;
    private static final int KIND_EXT_ALLOCATED_BYTES   = 1<<13;
    private static final int KIND_EXT_FREED_OBJECTS     = 1<<14;
    private static final int KIND_EXT_FREED_BYTES       = 1<<15;
    public static final int KIND_GLOBAL_ALLOCATED_OBJECTS =
        KIND_ALLOCATED_OBJECTS;
    public static final int KIND_GLOBAL_ALLOCATED_BYTES =
        KIND_ALLOCATED_BYTES;
    public static final int KIND_GLOBAL_FREED_OBJECTS =
        KIND_FREED_OBJECTS;
    public static final int KIND_GLOBAL_FREED_BYTES =
        KIND_FREED_BYTES;
    public static final int KIND_GLOBAL_GC_INVOCATIONS =
        KIND_GC_INVOCATIONS;
    public static final int KIND_GLOBAL_CLASS_INIT_COUNT =
        KIND_CLASS_INIT_COUNT;
    public static final int KIND_GLOBAL_CLASS_INIT_TIME =
        KIND_CLASS_INIT_TIME;
    public static final int KIND_GLOBAL_EXT_ALLOCATED_OBJECTS =
        KIND_EXT_ALLOCATED_OBJECTS;
    public static final int KIND_GLOBAL_EXT_ALLOCATED_BYTES =
        KIND_EXT_ALLOCATED_BYTES;
    public static final int KIND_GLOBAL_EXT_FREED_OBJECTS =
        KIND_EXT_FREED_OBJECTS;
    public static final int KIND_GLOBAL_EXT_FREED_BYTES =
        KIND_EXT_FREED_BYTES;
    public static final int KIND_THREAD_ALLOCATED_OBJECTS =
        KIND_ALLOCATED_OBJECTS << 16;
    public static final int KIND_THREAD_ALLOCATED_BYTES =
        KIND_ALLOCATED_BYTES << 16;
    public static final int KIND_THREAD_FREED_OBJECTS =
        KIND_FREED_OBJECTS << 16;
    public static final int KIND_THREAD_FREED_BYTES =
        KIND_FREED_BYTES << 16;
    public static final int KIND_THREAD_GC_INVOCATIONS =
        KIND_GC_INVOCATIONS << 16;
    public static final int KIND_THREAD_CLASS_INIT_COUNT =
        KIND_CLASS_INIT_COUNT << 16;
    public static final int KIND_THREAD_CLASS_INIT_TIME =
        KIND_CLASS_INIT_TIME << 16;
    public static final int KIND_THREAD_EXT_ALLOCATED_OBJECTS =
        KIND_EXT_ALLOCATED_OBJECTS << 16;
    public static final int KIND_THREAD_EXT_ALLOCATED_BYTES =
        KIND_EXT_ALLOCATED_BYTES << 16;
    public static final int KIND_THREAD_EXT_FREED_OBJECTS =
        KIND_EXT_FREED_OBJECTS << 16;
    public static final int KIND_THREAD_EXT_FREED_BYTES =
        KIND_EXT_FREED_BYTES << 16;
    public static final int KIND_ALL_COUNTS = 0xffffffff;
}

