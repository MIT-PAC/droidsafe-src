package dalvik.system;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.io.FileDescriptor;
import java.io.IOException;

public final class VMDebug {
    @Deprecated
    static public final String DEFAULT_METHOD_TRACE_FILE_NAME = "/sdcard/dmtrace.trace";
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.344 -0400", hash_original_method = "90647D9537BEB374A6D0146E2B562497", hash_generated_method = "72B42182A4F583684610C5730243DBD9")
    @DSModeled(DSC.SAFE)
    private VMDebug() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.344 -0400", hash_original_method = "A0A636875F8F9C14B7532C1AE4265EC8", hash_generated_method = "A640E78E5311BAAC7BE8C67A586CD7CB")
    public static long lastDebuggerActivity() {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    	return DSUtils.UNKNOWN_LONG;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.344 -0400", hash_original_method = "8F030E70A7ED81854F5A92537743C0FE", hash_generated_method = "052E98CFE4E73B5C491BD2BA5C2E7956")
    public static boolean isDebuggingEnabled() {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    	return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.344 -0400", hash_original_method = "DD92145E8BCB4FBBCA7FB334C79A41A1", hash_generated_method = "0D0E20CD411EBC29B144714AB2BF8370")
    public static boolean isDebuggerConnected() {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    	return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.344 -0400", hash_original_method = "F980312347BD785B72D418DC3AF234F8", hash_generated_method = "303FB201ED824B114ED2C60ABEDE3EFD")
    public static String[] getVmFeatureList() {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    	return new String[] { DSUtils.UNKNOWN_STRING };
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.344 -0400", hash_original_method = "840870BB0412797A5F6A599B61D1A09E", hash_generated_method = "392B5DDB1E404545881718EFE88BA53A")
    @Deprecated
    public static void startMethodTracing() {
        startMethodTracing(DEFAULT_METHOD_TRACE_FILE_NAME, 0, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.344 -0400", hash_original_method = "FCB90ED5C4F694A91B5F73A6370D7475", hash_generated_method = "D9E3D381FDB97F35571E3CB3F0A7D758")
    public static void startMethodTracing(String traceFileName,
        int bufferSize, int flags) {
        if (traceFileName == null) {
            throw new NullPointerException();
        }
        startMethodTracingNative(traceFileName, null, bufferSize, flags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.344 -0400", hash_original_method = "97B591DF3562D946C70A1ECBD633B498", hash_generated_method = "D7F2004FFCF007261665F99CF411A189")
    public static void startMethodTracing(String traceFileName,
        FileDescriptor fd, int bufferSize, int flags) {
        if (traceFileName == null || fd == null) {
            throw new NullPointerException();
        }
        startMethodTracingNative(traceFileName, fd, bufferSize, flags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.344 -0400", hash_original_method = "5F549E6AF9CCE63195F783E8262D413B", hash_generated_method = "E2A829C575CE61DD8A74E19EBF149E4F")
    public static void startMethodTracingDdms(int bufferSize, int flags) {
        startMethodTracingNative(null, null, bufferSize, flags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.344 -0400", hash_original_method = "3A126EB84AAF50F1E348D615E83D9A33", hash_generated_method = "9F3D2A32FFE849D6A488028773413B8A")
    private static void startMethodTracingNative(String traceFileName,
        FileDescriptor fd, int bufferSize, int flags) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    	
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.344 -0400", hash_original_method = "F9AB6ED3E984CE3E5A14DA52E250B0ED", hash_generated_method = "7FD4E26B238188C3A8A2452DB888A8DE")
    public static boolean isMethodTracingActive() {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    	return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.344 -0400", hash_original_method = "666E5856CA07FBD3583DB08DB353F482", hash_generated_method = "B1AF259E5C797EA8F343E0075B85DE6A")
    public static void stopMethodTracing() {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.344 -0400", hash_original_method = "21CE311C475711D384113E73F5913DFF", hash_generated_method = "001792AEB6BD7E41E2C1A263B3F8224A")
    public static void startEmulatorTracing() {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.344 -0400", hash_original_method = "6AEFED73E6C0D537C189F79EED538E6B", hash_generated_method = "35E282016BDC728FF163EDB680960869")
    public static void stopEmulatorTracing() {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.344 -0400", hash_original_method = "F13732F854623BCCC6C92D5990E58B39", hash_generated_method = "C9CF9857EAB5773AD600A523BD3EFC43")
    public static long threadCpuTimeNanos() {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    	return DSUtils.UNKNOWN_LONG;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.344 -0400", hash_original_method = "4DD18FE123FDA7C4ADB176B13994362C", hash_generated_method = "B26DF143DC785DDAFF6994FBDD9C2D1A")
    public static void startAllocCounting() {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.344 -0400", hash_original_method = "076D8D05559D173F43A2A39048232058", hash_generated_method = "FE3D53598B4E4963CEF743C34721759B")
    public static void stopAllocCounting() {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.344 -0400", hash_original_method = "FE33D49612E987E1080D32A47A59FF29", hash_generated_method = "CE587EE2CAEBCC1B2DE5A527205D5425")
    public static int getAllocCount(int kind) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    	return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.344 -0400", hash_original_method = "51660D6B42878121717638219721CA4D", hash_generated_method = "5744E2454DFA80739DACBF4F8FCF3629")
    public static void resetAllocCount(int kinds) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.345 -0400", hash_original_method = "F2D92EF76A0504EC51F795A2E7A55E9D", hash_generated_method = "11B92CAAC6AD3292FB5A01F1FFC7B1C0")
    @Deprecated
    public static int setAllocationLimit(int limit) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.345 -0400", hash_original_method = "85E92A7E48E83667B7FCFEA41481A251", hash_generated_method = "1156C7294C267BE11D8A3B083E061CDB")
    @Deprecated
    public static int setGlobalAllocationLimit(int limit) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.345 -0400", hash_original_method = "29D89E00FC58F26FD5A4D9907F13D127", hash_generated_method = "1BAEB62E8BA291683B1AAE85A612C8EB")
    public static void startInstructionCounting() {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
        //DSFIXME:  CODE0009: Possible callback target function detected
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.345 -0400", hash_original_method = "F3E34E5AF8ABAE0BEE74BC21EBE33940", hash_generated_method = "5FEA4CF21476C21C5D48C0BC5EA9322D")
    public static void stopInstructionCounting() {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
        //DSFIXME:  CODE0009: Possible callback target function detected
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.345 -0400", hash_original_method = "8D3FCCA3862E408EFA63047AEA19D29D", hash_generated_method = "6422ED07BC1DFDBF2B90B29342D7D2D7")
    public static void getInstructionCount(int[] counts) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
        //DSFIXME:  CODE0009: Possible callback target function detected
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.345 -0400", hash_original_method = "3D91B66CC84BDD7BBE732CDC2C4C7DC7", hash_generated_method = "94B2FAC4A2474A5C16895DF7546FE6AD")
    public static void resetInstructionCount() {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
        //DSFIXME:  CODE0009: Possible callback target function detected
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.345 -0400", hash_original_method = "75E256C2137377E2CC49F19AD8B9D7FF", hash_generated_method = "9A8B2884A795AC28822362EE272398A4")
    public static void printLoadedClasses(int flags) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.345 -0400", hash_original_method = "601BF9E9C45E53313091ADD24DE1F2A8", hash_generated_method = "075A45AFF329CB6CE289DDAC0823A189")
    public static int getLoadedClassCount() {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    	return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.345 -0400", hash_original_method = "D9BC0395AD15FA7E073090B68C8CD68C", hash_generated_method = "A1470DF6E91C2DDFFED0E9A70B2A0C17")
    public static void dumpHprofData(String fileName) throws IOException {
        if (fileName == null)
            throw new NullPointerException();
        dumpHprofData(fileName, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.345 -0400", hash_original_method = "0689B98EDD89794B24A63CD7DFADFF4B", hash_generated_method = "BEC16ED8D51EB90D2619FEE8DA28208E")
    public static void dumpHprofDataDdms() {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.345 -0400", hash_original_method = "C0FC29E49CE5A975A34F62AE8C2C9F3C", hash_generated_method = "7273537347E8D3B36A672CCA4ACE5C14")
    public static void dumpHprofData(String fileName, FileDescriptor fd) throws IOException {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.345 -0400", hash_original_method = "CC6AE43258DA62A9352F384259F65A85", hash_generated_method = "3C78F46F7D66E12382F0BB2497346726")
    public static boolean cacheRegisterMap(String classAndMethodDesc) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    	return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.345 -0400", hash_original_method = "8E3D99852584622A004990FFC9F481F7", hash_generated_method = "191920EA181AD72EC7F02588D3BDD49F")
    public static void dumpReferenceTables() {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    	
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.345 -0400", hash_original_method = "5038EB1D62C1F309D3E111EFF4B1C99D", hash_generated_method = "935DCE37FD5B39E734F39183725D9547")
    public static void crash() {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.345 -0400", hash_original_method = "B7B23701D279D81D1B4E67AFE35C6F43", hash_generated_method = "76B581E6D29B6A2C6653AD4A718A5BDB")
    public static void infopoint(int id) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.345 -0400", hash_original_method = "0FFE1B94F846E01BB31691717104A15E", hash_generated_method = "0DC425E9BF88C99ABA0565551A773C86")
    private static void startGC() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.345 -0400", hash_original_method = "3D3C946F00763A2C63D10BF2042F540D", hash_generated_method = "6853C859C696ECCC5EC2C4AAF7CF7134")
    private static void startClassPrep() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.345 -0400", hash_original_method = "B87EE2421E4C5667B9EB94DE362B6C4E", hash_generated_method = "7FCB6C96B544035286B6DE7236468B5C")
    public static long countInstancesOfClass(Class klass, boolean assignable) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    	return DSUtils.UNKNOWN_LONG;
    }

    
}


