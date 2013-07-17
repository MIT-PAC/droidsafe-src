package dalvik.system;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.FileDescriptor;
import java.io.IOException;

public final class VMDebug {
    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.834 -0400", hash_original_method = "90647D9537BEB374A6D0146E2B562497", hash_generated_method = "B9ED968C8D502362A08FEAB9C12CBFD2")
    private  VMDebug() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.BAN)
    public static long lastDebuggerActivity() {
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1326805405 = DSUtils.UNKNOWN_LONG;
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1326805405;
    }

    
    @DSModeled(DSC.BAN)
    public static boolean isDebuggingEnabled() {
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_936903779 = DSUtils.UNKNOWN_BOOLEAN;
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_936903779;
    }

    
    @DSModeled(DSC.BAN)
    public static boolean isDebuggerConnected() {
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1362108739 = DSUtils.UNKNOWN_BOOLEAN;
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1362108739;
    }

    
    @DSModeled(DSC.BAN)
    public static String[] getVmFeatureList() {
    	String[] ret = new String[0];
    	return ret;
    }

    
    @DSModeled(DSC.BAN)
    @Deprecated
    public static void startMethodTracing() {
        startMethodTracing(DEFAULT_METHOD_TRACE_FILE_NAME, 0, 0);
    }

    
    @DSModeled(DSC.BAN)
    public static void startMethodTracing(String traceFileName,
        int bufferSize, int flags) {
        if (traceFileName == null) {
            throw new NullPointerException();
        }
        startMethodTracingNative(traceFileName, null, bufferSize, flags);
    }

    
    @DSModeled(DSC.BAN)
    public static void startMethodTracing(String traceFileName,
        FileDescriptor fd, int bufferSize, int flags) {
        if (traceFileName == null || fd == null) {
            throw new NullPointerException();
        }
        startMethodTracingNative(traceFileName, fd, bufferSize, flags);
    }

    
    @DSModeled(DSC.BAN)
    public static void startMethodTracingDdms(int bufferSize, int flags) {
        startMethodTracingNative(null, null, bufferSize, flags);
    }

    
    @DSModeled(DSC.BAN)
    private static void startMethodTracingNative(String traceFileName,
        FileDescriptor fd, int bufferSize, int flags) {
    }

    
    @DSModeled(DSC.BAN)
    public static boolean isMethodTracingActive() {
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1236083031 = DSUtils.UNKNOWN_BOOLEAN;
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1236083031;
    }

    
    @DSModeled(DSC.BAN)
    public static void stopMethodTracing() {
    }

    
    @DSModeled(DSC.BAN)
    public static void startEmulatorTracing() {
    }

    
    @DSModeled(DSC.BAN)
    public static void stopEmulatorTracing() {
    }

    
    @DSModeled(DSC.BAN)
    public static long threadCpuTimeNanos() {
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1349091814 = DSUtils.UNKNOWN_LONG;
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1349091814;
    }

    
    @DSModeled(DSC.BAN)
    public static void startAllocCounting() {
    }

    
    @DSModeled(DSC.BAN)
    public static void stopAllocCounting() {
    }

    
    @DSModeled(DSC.BAN)
    public static int getAllocCount(int kind) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1006668567 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1006668567;
    }

    
    @DSModeled(DSC.BAN)
    public static void resetAllocCount(int kinds) {
    }

    
    @DSModeled(DSC.BAN)
    @Deprecated
    public static int setAllocationLimit(int limit) {
        return -1;
    }

    
    @DSModeled(DSC.BAN)
    @Deprecated
    public static int setGlobalAllocationLimit(int limit) {
        return -1;
    }

    
    @DSModeled(DSC.BAN)
    public static void startInstructionCounting() {
    }

    
    @DSModeled(DSC.BAN)
    public static void stopInstructionCounting() {
    }

    
    @DSModeled(DSC.BAN)
    public static void getInstructionCount(int[] counts) {
    }

    
    @DSModeled(DSC.BAN)
    public static void resetInstructionCount() {
    }

    
    @DSModeled(DSC.BAN)
    public static void printLoadedClasses(int flags) {
    }

    
    @DSModeled(DSC.BAN)
    public static int getLoadedClassCount() {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_368515312 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_368515312;
    }

    
    @DSModeled(DSC.BAN)
    public static void dumpHprofData(String fileName) throws IOException {
        if (fileName == null)
            throw new NullPointerException();
        dumpHprofData(fileName, null);
    }

    
    @DSModeled(DSC.BAN)
    public static void dumpHprofDataDdms() {
    }

    
    @DSModeled(DSC.BAN)
    public static void dumpHprofData(String fileName, FileDescriptor fd) throws IOException {
    }

    
    @DSModeled(DSC.BAN)
    public static boolean cacheRegisterMap(String classAndMethodDesc) {
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1021648724 = DSUtils.UNKNOWN_BOOLEAN;
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1021648724;
    }

    
    @DSModeled(DSC.BAN)
    public static void dumpReferenceTables() {
    }

    
    @DSModeled(DSC.BAN)
    public static void crash() {
    }

    
    @DSModeled(DSC.BAN)
    public static void infopoint(int id) {
    }

    
    @DSModeled(DSC.BAN)
    private static void startGC() {
    }

    
    @DSModeled(DSC.BAN)
    private static void startClassPrep() {
    }

    
    @DSModeled(DSC.BAN)
    public static long countInstancesOfClass(Class klass, boolean assignable) {
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1477598897 = DSUtils.UNKNOWN_LONG;
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1477598897;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.843 -0400", hash_original_field = "B2701440D5E45E7392E957B42D8A2A00", hash_generated_field = "0A342A62DC379FC9FAD1F478C502DC74")

    @Deprecated
    static public final String DEFAULT_METHOD_TRACE_FILE_NAME = "/sdcard/dmtrace.trace";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.843 -0400", hash_original_field = "FA370AC59B9AD4821F59F4C43D229D0E", hash_generated_field = "99037F5ED2CF2B022DAC983B822A6D8E")

    public static final int TRACE_COUNT_ALLOCS = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.843 -0400", hash_original_field = "D5656AB5517D79C5086D7005B5E7334F", hash_generated_field = "86FED411FE88F9EFB8800AB4B85C0266")

    private static final int KIND_ALLOCATED_OBJECTS = 1<<0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.843 -0400", hash_original_field = "DE5D929E6BF13B5CD61906AF14716586", hash_generated_field = "AE798AFDC7624027F8AC3A9393058CD6")

    private static final int KIND_ALLOCATED_BYTES = 1<<1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.844 -0400", hash_original_field = "53EEE6F69495AAD74D76C6AEFED06A5F", hash_generated_field = "239F31017FDCDE5F27734B27DBAE2F8F")

    private static final int KIND_FREED_OBJECTS = 1<<2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.844 -0400", hash_original_field = "245E61FFE552170B12D535CEEF12B42E", hash_generated_field = "029D367FADD799EA31FDCA861D46BECB")

    private static final int KIND_FREED_BYTES = 1<<3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.844 -0400", hash_original_field = "726D977C9614454C094441367F5DE414", hash_generated_field = "11B26BFA05C3F0FCC28297096831CE60")

    private static final int KIND_GC_INVOCATIONS = 1<<4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.844 -0400", hash_original_field = "800E46B1159F3C2874E3D41C708EB322", hash_generated_field = "3011931253F4527CF82FA30A5BE4110D")

    private static final int KIND_CLASS_INIT_COUNT = 1<<5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.844 -0400", hash_original_field = "58F2F0878F6CCDB67080F1711C46FDEE", hash_generated_field = "A1034C52B93B9926471C2230F02D8C6A")

    private static final int KIND_CLASS_INIT_TIME = 1<<6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.844 -0400", hash_original_field = "827CC1057D99EE7EBDB943294C3EA842", hash_generated_field = "61741F67E4C62824BFFE0BB58D7D43A6")

    private static final int KIND_EXT_ALLOCATED_OBJECTS = 1<<12;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.844 -0400", hash_original_field = "FC34C080A7BF2194146D0DEA66083F63", hash_generated_field = "9E651C88405C67AB0367F5CA90BFD7D0")

    private static final int KIND_EXT_ALLOCATED_BYTES = 1<<13;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.844 -0400", hash_original_field = "60DFB4FDEE8D5F91E3227FF1EDA7C430", hash_generated_field = "8F0D266204B0236E4AAE6E20DAD3A2FA")

    private static final int KIND_EXT_FREED_OBJECTS = 1<<14;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.844 -0400", hash_original_field = "AAAE842DD3C415EF320D01BCB2F1A6DB", hash_generated_field = "56ECC8DE5F83F50D7DD9F4B3327B65B2")

    private static final int KIND_EXT_FREED_BYTES = 1<<15;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.844 -0400", hash_original_field = "155AE3F81F59CC983B7EE7C65329C029", hash_generated_field = "01DD6A64304611F641DBC73979499342")

    public static final int KIND_GLOBAL_ALLOCATED_OBJECTS =
        KIND_ALLOCATED_OBJECTS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.844 -0400", hash_original_field = "9F3CDDB9C5DEEF6115F1D5F133ED43F0", hash_generated_field = "B0538E2EC9C30F44158DF7E8197388A7")

    public static final int KIND_GLOBAL_ALLOCATED_BYTES =
        KIND_ALLOCATED_BYTES;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.844 -0400", hash_original_field = "BFDBF704074CF96375FC22B693AC3E6F", hash_generated_field = "B02FFC580FE36900E1D1B9824BB07A0E")

    public static final int KIND_GLOBAL_FREED_OBJECTS =
        KIND_FREED_OBJECTS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.844 -0400", hash_original_field = "DD6344F1A485281C5E1998B6441102F1", hash_generated_field = "4EBB8ED5D0CE2E0F85DE44C6135E3118")

    public static final int KIND_GLOBAL_FREED_BYTES =
        KIND_FREED_BYTES;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.844 -0400", hash_original_field = "4D9156FD69BFA698D506992FECDF542D", hash_generated_field = "A34E5D6246239D7F63CAE56A26E8737C")

    public static final int KIND_GLOBAL_GC_INVOCATIONS =
        KIND_GC_INVOCATIONS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.844 -0400", hash_original_field = "806D3CABC6222BA0517221CDF0D22A3A", hash_generated_field = "0D34800C2E7B2E8F0A0FCBAC2CFA5AC4")

    public static final int KIND_GLOBAL_CLASS_INIT_COUNT =
        KIND_CLASS_INIT_COUNT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.844 -0400", hash_original_field = "97777A4A6B09795D5BD513AA8DE385A5", hash_generated_field = "1223568735910A5EDE25EF8A1EC8AA8B")

    public static final int KIND_GLOBAL_CLASS_INIT_TIME =
        KIND_CLASS_INIT_TIME;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.844 -0400", hash_original_field = "2E4432F12E809CF555CC995F96FB3A71", hash_generated_field = "310468A4FAFD75111A7864C21D5A8531")

    public static final int KIND_GLOBAL_EXT_ALLOCATED_OBJECTS =
        KIND_EXT_ALLOCATED_OBJECTS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.844 -0400", hash_original_field = "FF1CB79430061B8CEEFE5DB9C053AB08", hash_generated_field = "F328EEF0A70CB365B7CAC8525F5C4588")

    public static final int KIND_GLOBAL_EXT_ALLOCATED_BYTES =
        KIND_EXT_ALLOCATED_BYTES;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.845 -0400", hash_original_field = "9958D02F7BA871B0C95B35EAB06668FA", hash_generated_field = "1E73062203F6160EFD53D951E919A380")

    public static final int KIND_GLOBAL_EXT_FREED_OBJECTS =
        KIND_EXT_FREED_OBJECTS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.845 -0400", hash_original_field = "23663806C87F1F8CAC08FBD22E378A8D", hash_generated_field = "13AE72B64FAC31FCDD3E1C6E3F3367F7")

    public static final int KIND_GLOBAL_EXT_FREED_BYTES =
        KIND_EXT_FREED_BYTES;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.845 -0400", hash_original_field = "898035B8B6214AF27C7B0FD7CFEFACE7", hash_generated_field = "424759D05E77D84C2A794371AE6B6879")

    public static final int KIND_THREAD_ALLOCATED_OBJECTS =
        KIND_ALLOCATED_OBJECTS << 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.845 -0400", hash_original_field = "03E368D9DB3182387A5901A564FE9561", hash_generated_field = "748DF77E77AF56B519099249BCFD5482")

    public static final int KIND_THREAD_ALLOCATED_BYTES =
        KIND_ALLOCATED_BYTES << 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.845 -0400", hash_original_field = "6B6BD998E4B82C3C43985D88D61DD465", hash_generated_field = "79E2812444D05F0DF0A1E5198A434E06")

    public static final int KIND_THREAD_FREED_OBJECTS =
        KIND_FREED_OBJECTS << 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.845 -0400", hash_original_field = "93AD8049218CD5E5F10F21114BBAEC1E", hash_generated_field = "EDF82A7E59EA6F4749F87FAEFCC136C3")

    public static final int KIND_THREAD_FREED_BYTES =
        KIND_FREED_BYTES << 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.845 -0400", hash_original_field = "44FEDD7E3E28D6953249DD5BC9CB6A8B", hash_generated_field = "7797EC1BBB51BB191D5BC64768D9B618")

    public static final int KIND_THREAD_GC_INVOCATIONS =
        KIND_GC_INVOCATIONS << 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.845 -0400", hash_original_field = "748EDF73D99FF8C7721C1DA37B1B102F", hash_generated_field = "0B3220B3B62972A9BF33BD88FA50FA26")

    public static final int KIND_THREAD_CLASS_INIT_COUNT =
        KIND_CLASS_INIT_COUNT << 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.845 -0400", hash_original_field = "47491301455E1750CCE9AD753524D2B0", hash_generated_field = "4E28D64EB868F9DC4031CFD336DE5ED3")

    public static final int KIND_THREAD_CLASS_INIT_TIME =
        KIND_CLASS_INIT_TIME << 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.845 -0400", hash_original_field = "CE35466EEB8A12F4F1F88E17B665D50B", hash_generated_field = "AE1724098F85F60AB8C2BC32951E695C")

    public static final int KIND_THREAD_EXT_ALLOCATED_OBJECTS =
        KIND_EXT_ALLOCATED_OBJECTS << 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.845 -0400", hash_original_field = "FD0BDB8376899D7E5FE3E7AAEB227E1F", hash_generated_field = "4BD820B68DD1142C6DF3898A24958EC8")

    public static final int KIND_THREAD_EXT_ALLOCATED_BYTES =
        KIND_EXT_ALLOCATED_BYTES << 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.845 -0400", hash_original_field = "50B64490FF392701896BC393EF539E93", hash_generated_field = "241413982F565E99692AD980FCDC7878")

    public static final int KIND_THREAD_EXT_FREED_OBJECTS =
        KIND_EXT_FREED_OBJECTS << 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.845 -0400", hash_original_field = "8FA7C224A52081E1E1A0502B22703CE7", hash_generated_field = "146A7ED952720730F0474D575DC662DD")

    public static final int KIND_THREAD_EXT_FREED_BYTES =
        KIND_EXT_FREED_BYTES << 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.845 -0400", hash_original_field = "57BF8C2A2A75004D093F25239F896311", hash_generated_field = "D19857A092C4D22B54BA0D5CF6245D5A")

    public static final int KIND_ALL_COUNTS = 0xffffffff;
}

