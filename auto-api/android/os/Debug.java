package android.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import com.android.internal.util.TypedProperties;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.apache.harmony.dalvik.ddmc.Chunk;
import org.apache.harmony.dalvik.ddmc.ChunkHandler;
import org.apache.harmony.dalvik.ddmc.DdmServer;
import dalvik.bytecode.OpcodeInfo;
import dalvik.bytecode.Opcodes;
import dalvik.system.VMDebug;

public final class Debug {
    private static String TAG = "Debug";
    public static int TRACE_COUNT_ALLOCS  = VMDebug.TRACE_COUNT_ALLOCS;
    public static int SHOW_FULL_DETAIL    = 1;
    public static int SHOW_CLASSLOADER    = (1 << 1);
    public static int SHOW_INITIALIZED    = (1 << 2);
    private static volatile boolean mWaiting = false;
    private static int MIN_DEBUGGER_IDLE = 1300;
    private static int SPIN_DELAY = 200;
    private static String DEFAULT_TRACE_PATH_PREFIX =
        Environment.getExternalStorageDirectory().getPath() + "/";
    private static String DEFAULT_TRACE_BODY = "dmtrace";
    private static String DEFAULT_TRACE_EXTENSION = ".trace";
    private static String DEFAULT_TRACE_FILE_PATH =
        DEFAULT_TRACE_PATH_PREFIX + DEFAULT_TRACE_BODY
        + DEFAULT_TRACE_EXTENSION;
    private static String SYSFS_QEMU_TRACE_STATE = "/sys/qemu_trace/state";
    private static TypedProperties debugProperties;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.642 -0400", hash_original_method = "2057C70024BF253BE1820FDFE7216E44", hash_generated_method = "EB95695F27EBCA2753D06FBF666D5DDB")
    @DSModeled(DSC.SAFE)
    private Debug() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.643 -0400", hash_original_method = "78474EB72C72DC1FE1085A7FD6047903", hash_generated_method = "49E83FA818A49C7F2854EDD7312EA855")
    public static void waitForDebugger() {
        if (!VMDebug.isDebuggingEnabled()) {
            return;
        }
        if (isDebuggerConnected())
            return;
        System.out.println("Sending WAIT chunk");
        byte[] data = new byte[] { 0 };
        Chunk waitChunk = new Chunk(ChunkHandler.type("WAIT"), data, 0, 1);
        DdmServer.sendChunk(waitChunk);
        mWaiting = true;
        while (!isDebuggerConnected()) {
            try { Thread.sleep(SPIN_DELAY); }
            catch (InterruptedException ie) {}
        }
        mWaiting = false;
        System.out.println("Debugger has connected");
        while (true) {
            long delta = VMDebug.lastDebuggerActivity();
            if (delta < 0) {
                System.out.println("debugger detached?");
                break;
            }
            if (delta < MIN_DEBUGGER_IDLE) {
                System.out.println("waiting for debugger to settle...");
                try { Thread.sleep(SPIN_DELAY); }
                catch (InterruptedException ie) {}
            } else {
                System.out.println("debugger has settled (" + delta + ")");
                break;
            }
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.643 -0400", hash_original_method = "DD0B324AD7DDAC3BE4C7F5BE9E799132", hash_generated_method = "F9846DE7B677AFDC64B654EEA711F5FA")
    public static boolean waitingForDebugger() {
        return mWaiting;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.643 -0400", hash_original_method = "A8F90F402197D3F14FFEE9F1D4CA2EC5", hash_generated_method = "5286AD478503CE0787F04CB528C9E162")
    public static boolean isDebuggerConnected() {
        return VMDebug.isDebuggerConnected();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.644 -0400", hash_original_method = "FFB4A2F605289FFD397797E4EBEF85C7", hash_generated_method = "6F8C6CA9D595FB40E367304EAD914129")
    public static String[] getVmFeatureList() {
        return VMDebug.getVmFeatureList();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.644 -0400", hash_original_method = "0163C8206FD905882DA3B7BB552BF2BC", hash_generated_method = "798A608BAA8D71866E08CC4387CC01D0")
    @Deprecated
    public static void changeDebugPort(int port) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.644 -0400", hash_original_method = "24AB94F1C6B3B96B435A2A213E586F57", hash_generated_method = "A6A669C9147A6BC6B7D22FF4BDBB5196")
    public static void startNativeTracing() {
        PrintWriter outStream = null;
        try {
            FileOutputStream fos = new FileOutputStream(SYSFS_QEMU_TRACE_STATE);
            outStream = new PrintWriter(new OutputStreamWriter(fos));
            outStream.println("1");
        } catch (Exception e) {
        } finally {
            if (outStream != null)
                outStream.close();
        }
        VMDebug.startEmulatorTracing();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.644 -0400", hash_original_method = "10B03DD18E21F28999697DBFB6441772", hash_generated_method = "DED48A43C6664BED25618E8159655433")
    public static void stopNativeTracing() {
        VMDebug.stopEmulatorTracing();
        PrintWriter outStream = null;
        try {
            FileOutputStream fos = new FileOutputStream(SYSFS_QEMU_TRACE_STATE);
            outStream = new PrintWriter(new OutputStreamWriter(fos));
            outStream.println("0");
        } catch (Exception e) {
        } finally {
            if (outStream != null)
                outStream.close();
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.645 -0400", hash_original_method = "5E3E9BCC18F4F81AFEDA2690110A43E7", hash_generated_method = "6C2249D8D6C6FBC9448402FB433D630E")
    public static void enableEmulatorTraceOutput() {
        VMDebug.startEmulatorTracing();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.645 -0400", hash_original_method = "B28A50E61370724E038679254004F3CB", hash_generated_method = "8AF3CF3F371E998FF7A9EF6A81B4C805")
    public static void startMethodTracing() {
        VMDebug.startMethodTracing(DEFAULT_TRACE_FILE_PATH, 0, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.645 -0400", hash_original_method = "B71BD92AFF6466453E6F6F7742CF8DFD", hash_generated_method = "3817F949DCB7859EEA925CCB63F94A9F")
    public static void startMethodTracing(String traceName) {
        startMethodTracing(traceName, 0, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.645 -0400", hash_original_method = "B8949788B045FC637274E75B2BE33ECF", hash_generated_method = "E7B9E22D954505D5421576A4B6FD57A1")
    public static void startMethodTracing(String traceName, int bufferSize) {
        startMethodTracing(traceName, bufferSize, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.646 -0400", hash_original_method = "FC57B22C958BBBD2D110325861CED7E8", hash_generated_method = "84255BA3B22A8BBBBEA469B405075805")
    public static void startMethodTracing(String traceName, int bufferSize,
        int flags) {
        String pathName = traceName;
        if (pathName.charAt(0) != '/')
            pathName = DEFAULT_TRACE_PATH_PREFIX + pathName;
        if (!pathName.endsWith(DEFAULT_TRACE_EXTENSION))
            pathName = pathName + DEFAULT_TRACE_EXTENSION;
        VMDebug.startMethodTracing(pathName, bufferSize, flags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.646 -0400", hash_original_method = "61BEE4455C71AA1B4B8E096BE0A9F80E", hash_generated_method = "A6AF3E598974F11A35885B279CDA83E0")
    public static void startMethodTracing(String traceName, FileDescriptor fd,
        int bufferSize, int flags) {
        VMDebug.startMethodTracing(traceName, fd, bufferSize, flags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.646 -0400", hash_original_method = "FFE2EA9F1B0C7B1D0B87CA6D7B155424", hash_generated_method = "947D709E89476DA64A342F257AD4FBE2")
    public static void startMethodTracingDdms(int bufferSize, int flags) {
        VMDebug.startMethodTracingDdms(bufferSize, flags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.646 -0400", hash_original_method = "DB744ED9820BBBCA493477D061843B3C", hash_generated_method = "41AD1FE5158B575E3C2B467EA63CC194")
    public static boolean isMethodTracingActive() {
        return VMDebug.isMethodTracingActive();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.646 -0400", hash_original_method = "8C7DABCA9CC2734F7706D99DB6CDC33D", hash_generated_method = "C9D992D64EB4504B5FE85C2D793B4F9E")
    public static void stopMethodTracing() {
        VMDebug.stopMethodTracing();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.647 -0400", hash_original_method = "969F39FFDE48B5771B1AAE0E71CBC46F", hash_generated_method = "8893FE5FF37E5D9C026AE7EDC4F52572")
    public static long threadCpuTimeNanos() {
        return VMDebug.threadCpuTimeNanos();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.647 -0400", hash_original_method = "67563E6CD6D31B7A9ED9D35FD2ACC78D", hash_generated_method = "61A1691919A8E92036956AAAA0018C5D")
    public static void startAllocCounting() {
        VMDebug.startAllocCounting();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.647 -0400", hash_original_method = "B2ABBABB9AAC473F130021E0A6601574", hash_generated_method = "8A1EC8716B33AA9A4D523DA9D47834CF")
    public static void stopAllocCounting() {
        VMDebug.stopAllocCounting();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.647 -0400", hash_original_method = "0CF7D3D48014743A078F7BFCBD6298DE", hash_generated_method = "D9F3A2CCF72B8A4BCA8453F6712D4DB1")
    public static int getGlobalAllocCount() {
        return VMDebug.getAllocCount(VMDebug.KIND_GLOBAL_ALLOCATED_OBJECTS);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.647 -0400", hash_original_method = "AB2C9148E9F1B83B66C21E6CC3E51A13", hash_generated_method = "02D99DB7A9663636BFBE755FD4DD333F")
    public static int getGlobalAllocSize() {
        return VMDebug.getAllocCount(VMDebug.KIND_GLOBAL_ALLOCATED_BYTES);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.647 -0400", hash_original_method = "695F0DB4ABA2FAA4C6B686848E90FF0F", hash_generated_method = "EAAAB54DD80923CFAE24C991C512E3E3")
    public static int getGlobalFreedCount() {
        return VMDebug.getAllocCount(VMDebug.KIND_GLOBAL_FREED_OBJECTS);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.647 -0400", hash_original_method = "167D8B8030FE85DEE4E9128668E87890", hash_generated_method = "5458D4E3440616456AF582C1FCE5DEF0")
    public static int getGlobalFreedSize() {
        return VMDebug.getAllocCount(VMDebug.KIND_GLOBAL_FREED_BYTES);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.647 -0400", hash_original_method = "A1554EC06EC5FA1CE0C2F7B8F7C86655", hash_generated_method = "8F4837B0BFAA80FB38BD71E36FA15086")
    public static int getGlobalClassInitCount() {
        return VMDebug.getAllocCount(VMDebug.KIND_GLOBAL_CLASS_INIT_COUNT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.647 -0400", hash_original_method = "D8F4BF635EDBD9713AC07FFF59B892D1", hash_generated_method = "B9F53E032A8720AF4FF50CDA3AA1D08F")
    public static int getGlobalClassInitTime() {
        return VMDebug.getAllocCount(VMDebug.KIND_GLOBAL_CLASS_INIT_TIME);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.647 -0400", hash_original_method = "F2D18F66BA7892EA39FFE9A4C7182C57", hash_generated_method = "8E41A67517EDC8B45C0604F7354C26F2")
    @Deprecated
    public static int getGlobalExternalAllocCount() {
        return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.648 -0400", hash_original_method = "BCF934C0F5752FA43CB9DC1202287FDA", hash_generated_method = "50DAC282E4E56543A7A53A9DF5F0DED4")
    @Deprecated
    public static int getGlobalExternalAllocSize() {
        return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.648 -0400", hash_original_method = "4A5BBCA63642DD598E8706B0BEEF7F9E", hash_generated_method = "D985CDFBBC815D8F9E59300B6E25B4F4")
    @Deprecated
    public static int getGlobalExternalFreedCount() {
        return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.648 -0400", hash_original_method = "8A757D7E3E99170A3143AA9AAED5C840", hash_generated_method = "BD46BE82D7D19E9A1B6DE6548841198B")
    @Deprecated
    public static int getGlobalExternalFreedSize() {
        return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.648 -0400", hash_original_method = "E91AEF6C526C86D6DBB3BCEF7A1DA830", hash_generated_method = "908FDF5B35EB5F70883725C428F8544A")
    public static int getGlobalGcInvocationCount() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        return VMDebug.getAllocCount(VMDebug.KIND_GLOBAL_GC_INVOCATIONS);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.648 -0400", hash_original_method = "CA10B26CEE93A2257F7F6779A0040536", hash_generated_method = "AB9E528145CB5E5CDAEF9E07883D1C56")
    public static int getThreadAllocCount() {
        return VMDebug.getAllocCount(VMDebug.KIND_THREAD_ALLOCATED_OBJECTS);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.648 -0400", hash_original_method = "8264EDD15D9FAF32E2528125F01D0F6F", hash_generated_method = "88F8F3580516C2BB35ABA4341A3DC4CD")
    public static int getThreadAllocSize() {
        return VMDebug.getAllocCount(VMDebug.KIND_THREAD_ALLOCATED_BYTES);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.648 -0400", hash_original_method = "D21B5890D75CBE04EB2929052BCCDC27", hash_generated_method = "E31019E7ECCECD0065D4989A90D44190")
    @Deprecated
    public static int getThreadExternalAllocCount() {
        return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.648 -0400", hash_original_method = "744BA3A1F669786FA7A6C57459411C28", hash_generated_method = "301BACF451298F9C68DB241CC2598604")
    @Deprecated
    public static int getThreadExternalAllocSize() {
        return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.648 -0400", hash_original_method = "CD0D21FD4D9C27BDC3E490AC92DD3B6B", hash_generated_method = "64E88D5A2CE95DA0BE376675FE795A36")
    public static int getThreadGcInvocationCount() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        return VMDebug.getAllocCount(VMDebug.KIND_THREAD_GC_INVOCATIONS);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.649 -0400", hash_original_method = "2B1F74261543157B3707C987B951B12E", hash_generated_method = "0A63116D515D21BBFCEFB2C11E35444A")
    public static void resetGlobalAllocCount() {
        VMDebug.resetAllocCount(VMDebug.KIND_GLOBAL_ALLOCATED_OBJECTS);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.649 -0400", hash_original_method = "B03867F9D5DB45F6E797DAB2DE5BFFDC", hash_generated_method = "9A585C8FFB84061764423BB7A8A500A5")
    public static void resetGlobalAllocSize() {
        VMDebug.resetAllocCount(VMDebug.KIND_GLOBAL_ALLOCATED_BYTES);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.649 -0400", hash_original_method = "861CBDB6C0D63922A4F9D2A2335B14C7", hash_generated_method = "C88C8965E7A5C163F6485BAE359A5408")
    public static void resetGlobalFreedCount() {
        VMDebug.resetAllocCount(VMDebug.KIND_GLOBAL_FREED_OBJECTS);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.649 -0400", hash_original_method = "976216342F2B8476474119AE0E47E068", hash_generated_method = "2874C6FD0AA3B6D928C729397B5D77F9")
    public static void resetGlobalFreedSize() {
        VMDebug.resetAllocCount(VMDebug.KIND_GLOBAL_FREED_BYTES);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.649 -0400", hash_original_method = "35588E2F48C88BA8D43E9360F91D5DF6", hash_generated_method = "F1140AE4149AA504FF785F415F8BA01B")
    public static void resetGlobalClassInitCount() {
        VMDebug.resetAllocCount(VMDebug.KIND_GLOBAL_CLASS_INIT_COUNT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.649 -0400", hash_original_method = "E50702C4EB93F3D728654938E4E53B26", hash_generated_method = "A2E28AEEB4660713FC899E1762327A60")
    public static void resetGlobalClassInitTime() {
        VMDebug.resetAllocCount(VMDebug.KIND_GLOBAL_CLASS_INIT_TIME);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.649 -0400", hash_original_method = "56094138813247401A1CB12DD1515681", hash_generated_method = "CADD5401E7B96B2C34F0800ED8CF8313")
    @Deprecated
    public static void resetGlobalExternalAllocCount() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.649 -0400", hash_original_method = "D8E2AA39591AC4E6F843977CA2A212D3", hash_generated_method = "4A516893C37E65C18C2EBDBCC35493F6")
    @Deprecated
    public static void resetGlobalExternalAllocSize() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.649 -0400", hash_original_method = "AA6367B478F9A852148448AFECAB6EF6", hash_generated_method = "5B76E0C94B2CE0EDF22378E833924B15")
    @Deprecated
    public static void resetGlobalExternalFreedCount() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.649 -0400", hash_original_method = "33780DBE97BD7C670E5AFFC2C0A5985B", hash_generated_method = "F2612A86B7C06B647F6BF803B9490EB9")
    @Deprecated
    public static void resetGlobalExternalFreedSize() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.650 -0400", hash_original_method = "C9E395F15DF7BAB8FE944D7758B4944B", hash_generated_method = "889B7ED8B5B955A67BFD604A059330BF")
    public static void resetGlobalGcInvocationCount() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        VMDebug.resetAllocCount(VMDebug.KIND_GLOBAL_GC_INVOCATIONS);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.650 -0400", hash_original_method = "2F3B5F856A955845C50059A5F55509BA", hash_generated_method = "8E216B1745DA6722DDC180A34C27731C")
    public static void resetThreadAllocCount() {
        VMDebug.resetAllocCount(VMDebug.KIND_THREAD_ALLOCATED_OBJECTS);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.650 -0400", hash_original_method = "2546066B10A68B69B7502151C67ADF51", hash_generated_method = "19B8FB770D324AE1444F6823D49F5863")
    public static void resetThreadAllocSize() {
        VMDebug.resetAllocCount(VMDebug.KIND_THREAD_ALLOCATED_BYTES);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.650 -0400", hash_original_method = "2199049C4F400DF72BDDC1A4839F8700", hash_generated_method = "567C319D1475F33F5A6EDE3DBA03579F")
    @Deprecated
    public static void resetThreadExternalAllocCount() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.650 -0400", hash_original_method = "D0BF4925CA67C3B6C5155741DF336C8F", hash_generated_method = "F4B1985C5DC33FF2F80DDD5B8C80E043")
    @Deprecated
    public static void resetThreadExternalAllocSize() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.650 -0400", hash_original_method = "58ADA4529D0B6962755AE451B721BB1D", hash_generated_method = "4B9D5511B0F39BB6C2EAB839D450C02F")
    public static void resetThreadGcInvocationCount() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        VMDebug.resetAllocCount(VMDebug.KIND_THREAD_GC_INVOCATIONS);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.650 -0400", hash_original_method = "53D80E15EF1FFE4637D8EF4D0ED35D89", hash_generated_method = "864434D3258598DC836DDC7019B199D2")
    public static void resetAllCounts() {
        VMDebug.resetAllocCount(VMDebug.KIND_ALL_COUNTS);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.650 -0400", hash_original_method = "9F60EFBF980647F0B643E37FAE874FCC", hash_generated_method = "6676D4DACDD62A3E45201D90B9894733")
    public static long getNativeHeapSize() {
        return DSUtils.UNKNOWN_LONG;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.650 -0400", hash_original_method = "7011321ACF0332D0D57405C5EE7715AC", hash_generated_method = "4F58C4968D00CF41E55CE06816AF3F70")
    public static long getNativeHeapAllocatedSize() {
        return DSUtils.UNKNOWN_LONG;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.652 -0400", hash_original_method = "1D9C5CE42D565512095D850CC3AE6E03", hash_generated_method = "45EA802869C2D91F698BA39744E84628")
    public static long getNativeHeapFreeSize() {
        return DSUtils.UNKNOWN_LONG;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.652 -0400", hash_original_method = "97C90A5F68AA7A20B9DE5CEC4F9820AE", hash_generated_method = "B52A6ED416AB733A6411F78E3A531E76")
    public static void getMemoryInfo(MemoryInfo memoryInfo) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.652 -0400", hash_original_method = "D7CAB37D86C981F4B4A387D6F512B4FC", hash_generated_method = "BD33970BD06B44567FE3AA0AD967C22F")
    public static void getMemoryInfo(int pid, MemoryInfo memoryInfo) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.652 -0400", hash_original_method = "60B5759A5A1C8FCABA34373144A29AE0", hash_generated_method = "79EBDD963EEC2B179B0D12279D9966E5")
    public static long getPss() {
        return DSUtils.UNKNOWN_LONG;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.653 -0400", hash_original_method = "5A818DFA3CA28F77EA60F22C62046F1B", hash_generated_method = "CA48B4A1968FEBAC1E3280DAD14D97E5")
    public static long getPss(int pid) {
        return DSUtils.UNKNOWN_LONG;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.653 -0400", hash_original_method = "F2D92EF76A0504EC51F795A2E7A55E9D", hash_generated_method = "11B92CAAC6AD3292FB5A01F1FFC7B1C0")
    @Deprecated
    public static int setAllocationLimit(int limit) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.653 -0400", hash_original_method = "85E92A7E48E83667B7FCFEA41481A251", hash_generated_method = "1156C7294C267BE11D8A3B083E061CDB")
    @Deprecated
    public static int setGlobalAllocationLimit(int limit) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.653 -0400", hash_original_method = "1125B7EE847DE2E2B1EF071157DFEBB7", hash_generated_method = "91FF2462936B2093B1C2376FD1913350")
    public static void printLoadedClasses(int flags) {
        VMDebug.printLoadedClasses(flags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.653 -0400", hash_original_method = "3C278506FF5D85E033BC2B8A5DB9B449", hash_generated_method = "AB67D939E843289669569BEFABFB07D8")
    public static int getLoadedClassCount() {
        return VMDebug.getLoadedClassCount();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.653 -0400", hash_original_method = "2A3BA8C930CC8D70EFDC06E422B5CE17", hash_generated_method = "A68900B8650C713DF8FE69E78EA5F319")
    public static void dumpHprofData(String fileName) throws IOException {
        VMDebug.dumpHprofData(fileName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.653 -0400", hash_original_method = "E71A30A98691493542EA069FF7EF94B8", hash_generated_method = "54CCFDCF5F5F54D5B42CE9010DDF8BB2")
    public static void dumpHprofData(String fileName, FileDescriptor fd) throws IOException {
        VMDebug.dumpHprofData(fileName, fd);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.653 -0400", hash_original_method = "1F5F04F240A97C1BD6CC299225911198", hash_generated_method = "E5E8D44B72D0A011B16DAFF2C1C0710B")
    public static void dumpHprofDataDdms() {
        VMDebug.dumpHprofDataDdms();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.653 -0400", hash_original_method = "2673881AB4662F6FA5EFBE0BA9A56679", hash_generated_method = "9D411E293F90F950B3BABAA637CD4F3B")
    public static void dumpNativeHeap(FileDescriptor fd) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.654 -0400", hash_original_method = "D878379E552A4E4CA3B2BC84B825D68D", hash_generated_method = "7CD0606BCDE9409948B14414AD145835")
    public static long countInstancesOfClass(Class cls) {
        return VMDebug.countInstancesOfClass(cls, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.654 -0400", hash_original_method = "E7A2DFDE928CF7821F0ECE510B701BA0", hash_generated_method = "CFE0F7103B8D033E7A72581EBA25311D")
    public static int getBinderSentTransactions() {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.654 -0400", hash_original_method = "B30DF19845E301C1936C995EDBC546A9", hash_generated_method = "7EBBA91E3CF47E06BB00FFEABB52CB81")
    public static int getBinderReceivedTransactions() {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.654 -0400", hash_original_method = "86471EFFF92836901965A10690AE5689", hash_generated_method = "8893AB05461BF2AD315204CF2A35474C")
    public static final int getBinderLocalObjectCount() {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.654 -0400", hash_original_method = "35C41847F12E08F0E4EBC1966E820A3A", hash_generated_method = "D3AF7A1A16A6901AEC1065998315D99A")
    public static final int getBinderProxyObjectCount() {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.667 -0400", hash_original_method = "4A32424B70BBE6E066E2895D2C298DDA", hash_generated_method = "D297F5A05E5E29420465027355D861BE")
    public static final int getBinderDeathObjectCount() {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.667 -0400", hash_original_method = "0CA55CC43FB3B8576CC7C0DBAF1F74C0", hash_generated_method = "E08171120887014347C0D1FF2B57D7A2")
    public static final boolean cacheRegisterMap(String classAndMethodDesc) {
        return VMDebug.cacheRegisterMap(classAndMethodDesc);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.668 -0400", hash_original_method = "9646D8356AAE31876A9E9F3AB6644735", hash_generated_method = "A593400102316B2AAD640F9202795286")
    public static final void dumpReferenceTables() {
        VMDebug.dumpReferenceTables();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.668 -0400", hash_original_method = "C4FA78418D555E768FF5DBC8DE58360D", hash_generated_method = "31351ED8F6629BF9EC8F80310FC6C539")
    private static boolean fieldTypeMatches(Field field, Class<?> cl) {
        Class<?> fieldClass = field.getType();
        if (fieldClass == cl) {
            return true;
        }
        Field primitiveTypeField;
        try {
            primitiveTypeField = cl.getField("TYPE");
        } catch (NoSuchFieldException ex) {
            return false;
        }
        try {
            return fieldClass == (Class<?>) primitiveTypeField.get(null);
        } catch (IllegalAccessException ex) {
            return false;
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.669 -0400", hash_original_method = "ECD2E5721BC163A0054AA741832C3882", hash_generated_method = "96A2A0C6A77B627EB37773D850D5E227")
    private static void modifyFieldIfSet(final Field field, final TypedProperties properties,
                                         final String propertyName) {
        if (field.getType() == java.lang.String.class) {
            int stringInfo = properties.getStringInfo(propertyName);
            switch (stringInfo) {
                case TypedProperties.STRING_SET:
                    break;
                case TypedProperties.STRING_NULL:
                    try {
                        field.set(null, null);  
                    } catch (IllegalAccessException ex) {
                        throw new IllegalArgumentException(
                            "Cannot set field for " + propertyName, ex);
                    }
                    return;
                case TypedProperties.STRING_NOT_SET:
                    return;
                case TypedProperties.STRING_TYPE_MISMATCH:
                    throw new IllegalArgumentException(
                        "Type of " + propertyName + " " +
                        " does not match field type (" + field.getType() + ")");
                default:
                    throw new IllegalStateException(
                        "Unexpected getStringInfo(" + propertyName + ") return value " +
                        stringInfo);
            }
        }
        Object value = properties.get(propertyName);
        if (value != null) {
            if (!fieldTypeMatches(field, value.getClass())) {
                throw new IllegalArgumentException(
                    "Type of " + propertyName + " (" + value.getClass() + ") " +
                    " does not match field type (" + field.getType() + ")");
            }
            try {
                field.set(null, value);  
            } catch (IllegalAccessException ex) {
                throw new IllegalArgumentException(
                    "Cannot set field for " + propertyName, ex);
            }
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.669 -0400", hash_original_method = "F1F2F8FAD252031217CA0AAF2E24EE7D", hash_generated_method = "D95E678D58D2C8AD01DE9FD559DEE2D3")
    public static void setFieldsOn(Class<?> cl) {
        setFieldsOn(cl, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.669 -0400", hash_original_method = "67972367DFC302603F6E9ABB6D4B467F", hash_generated_method = "A315B7523ABC0C8DC2E9631527207A5D")
    public static void setFieldsOn(Class<?> cl, boolean partial) {
        if (false) {
            if (debugProperties != null) {
                for (Field field : cl.getDeclaredFields()) {
                    if (!partial || field.getAnnotation(DebugProperty.class) != null) {
                        final String propertyName = cl.getName() + "." + field.getName();
                        boolean isStatic = Modifier.isStatic(field.getModifiers());
                        boolean isFinal = Modifier.isFinal(field.getModifiers());
                        if (!isStatic || isFinal) {
                            throw new IllegalArgumentException(propertyName +
                                " must be static and non-final");
                        }
                        modifyFieldIfSet(field, debugProperties, propertyName);
                    }
                }
            }
        } else {
            Log.wtf(TAG,
                  "setFieldsOn(" + (cl == null ? "null" : cl.getName()) +
                  ") called in non-DEBUG build");
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.669 -0400", hash_original_method = "B5D69574A1B80BC6A0DAF5C729E713CA", hash_generated_method = "25E6FF9A7AE135B20437E952A4A56138")
    public static boolean dumpService(String name, FileDescriptor fd, String[] args) {
        IBinder service = ServiceManager.getService(name);
        if (service == null) {
            Log.e(TAG, "Can't find service to dump: " + name);
            return false;
        }
        try {
            service.dump(fd, args);
            return true;
        } catch (RemoteException e) {
            Log.e(TAG, "Can't dump service: " + name, e);
            return false;
        }
    }

    
    public static class MemoryInfo implements Parcelable {
        public int dalvikPss;
        public int dalvikPrivateDirty;
        public int dalvikSharedDirty;
        public int nativePss;
        public int nativePrivateDirty;
        public int nativeSharedDirty;
        public int otherPss;
        public int otherPrivateDirty;
        public int otherSharedDirty;
        public static int NUM_OTHER_STATS = 9;
        private int[] otherStats = new int[NUM_OTHER_STATS*3];
        public static final Creator<MemoryInfo> CREATOR = new Creator<MemoryInfo>() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.670 -0400", hash_original_method = "83921F47BB880779DC0FD4AB57F3B1E1", hash_generated_method = "B611F41F62E50BA3B46021808792C460")
            @DSModeled(DSC.SAFE)
            public MemoryInfo createFromParcel(Parcel source) {
                dsTaint.addTaint(source.dsTaint);
                return (MemoryInfo)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return new MemoryInfo(source);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.670 -0400", hash_original_method = "15F51E1DA13C1BB1AA9F8A3C297A7987", hash_generated_method = "10FBEB26B0431A1763072A515665C82C")
            @DSModeled(DSC.SAFE)
            public MemoryInfo[] newArray(int size) {
                dsTaint.addTaint(size);
                return (MemoryInfo[])dsTaint.getTaint();
                // ---------- Original Method ----------
                //return new MemoryInfo[size];
            }

            
}; //Transformed anonymous class
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.670 -0400", hash_original_method = "09AE2D253AD01F5533857164DB70587D", hash_generated_method = "1B8A9DB070B9C5EE97692E3C2182BBFA")
        @DSModeled(DSC.SAFE)
        public MemoryInfo() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.670 -0400", hash_original_method = "EAA33F4FBF3C878879D517CBC8FFA048", hash_generated_method = "45707563C7C263D0E9F46A063A1DEF08")
        @DSModeled(DSC.SAFE)
        private MemoryInfo(Parcel source) {
            dsTaint.addTaint(source.dsTaint);
            readFromParcel(source);
            // ---------- Original Method ----------
            //readFromParcel(source);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.670 -0400", hash_original_method = "0F7876D4F39A60F2060DE34A3D4B321B", hash_generated_method = "0C55462604CA4C81672C6EF8E0E10CA9")
        @DSModeled(DSC.SAFE)
        public int getTotalPss() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return dalvikPss + nativePss + otherPss;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.670 -0400", hash_original_method = "5F6AFDC3B733846B095E6E612D37EF25", hash_generated_method = "D762DF047B578C6B2F47FCA3AEF57401")
        @DSModeled(DSC.SAFE)
        public int getTotalPrivateDirty() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return dalvikPrivateDirty + nativePrivateDirty + otherPrivateDirty;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.671 -0400", hash_original_method = "DD332BDFA0A32D6562D4D066F36B1807", hash_generated_method = "FFAA14F007BE777DA45A764B5B33CDC6")
        @DSModeled(DSC.SAFE)
        public int getTotalSharedDirty() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return dalvikSharedDirty + nativeSharedDirty + otherSharedDirty;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.690 -0400", hash_original_method = "8C545D479EA5CCAA2D5CE5956250CE73", hash_generated_method = "0D7C8F1CE6C8046FC5AD05446B53F409")
        @DSModeled(DSC.SAFE)
        public int getOtherPss(int which) {
            dsTaint.addTaint(which);
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return otherStats[which*3];
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.690 -0400", hash_original_method = "45A31C2AA910C3CDA42EF94E68B5E963", hash_generated_method = "E494696AB5951C5721907F534F391D85")
        @DSModeled(DSC.SAFE)
        public int getOtherPrivateDirty(int which) {
            dsTaint.addTaint(which);
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return otherStats[which*3 + 1];
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.690 -0400", hash_original_method = "1FF35BC5D0D80C168B4EDFE5B23B6F0A", hash_generated_method = "A98477BAAADBE38FE3901DE8252782E0")
        @DSModeled(DSC.SAFE)
        public int getOtherSharedDirty(int which) {
            dsTaint.addTaint(which);
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return otherStats[which*3 + 2];
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.691 -0400", hash_original_method = "7725E7152BF27C491568D120E3EC44B3", hash_generated_method = "743B72EA0B657CDE2933D000A204229E")
        public static String getOtherLabel(int which) {
            switch (which) {
                case 0: return "Cursor";
                case 1: return "Ashmem";
                case 2: return "Other dev";
                case 3: return ".so mmap";
                case 4: return ".jar mmap";
                case 5: return ".apk mmap";
                case 6: return ".ttf mmap";
                case 7: return ".dex mmap";
                case 8: return "Other mmap";
                default: return "????";
            }
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.691 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "7491C6FB42F78871A3F8EA322AF6B2FC")
        @DSModeled(DSC.SAFE)
        public int describeContents() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.691 -0400", hash_original_method = "D2FBA6C4AE93947F6ACE85B65AE77863", hash_generated_method = "13F536BDE17541344A7C37E802B98B4C")
        @DSModeled(DSC.SAFE)
        public void writeToParcel(Parcel dest, int flags) {
            dsTaint.addTaint(dest.dsTaint);
            dsTaint.addTaint(flags);
            dest.writeInt(dalvikPss);
            dest.writeInt(dalvikPrivateDirty);
            dest.writeInt(dalvikSharedDirty);
            dest.writeInt(nativePss);
            dest.writeInt(nativePrivateDirty);
            dest.writeInt(nativeSharedDirty);
            dest.writeInt(otherPss);
            dest.writeInt(otherPrivateDirty);
            dest.writeInt(otherSharedDirty);
            dest.writeIntArray(otherStats);
            // ---------- Original Method ----------
            //dest.writeInt(dalvikPss);
            //dest.writeInt(dalvikPrivateDirty);
            //dest.writeInt(dalvikSharedDirty);
            //dest.writeInt(nativePss);
            //dest.writeInt(nativePrivateDirty);
            //dest.writeInt(nativeSharedDirty);
            //dest.writeInt(otherPss);
            //dest.writeInt(otherPrivateDirty);
            //dest.writeInt(otherSharedDirty);
            //dest.writeIntArray(otherStats);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.691 -0400", hash_original_method = "3814E1A02C58284E12D5ED0E53DE29C9", hash_generated_method = "6A31973706B60CF2CA0E21A81956ED10")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void readFromParcel(Parcel source) {
            dsTaint.addTaint(source.dsTaint);
            dalvikPss = source.readInt();
            dalvikPrivateDirty = source.readInt();
            dalvikSharedDirty = source.readInt();
            nativePss = source.readInt();
            nativePrivateDirty = source.readInt();
            nativeSharedDirty = source.readInt();
            otherPss = source.readInt();
            otherPrivateDirty = source.readInt();
            otherSharedDirty = source.readInt();
            otherStats = source.createIntArray();
            // ---------- Original Method ----------
            //dalvikPss = source.readInt();
            //dalvikPrivateDirty = source.readInt();
            //dalvikSharedDirty = source.readInt();
            //nativePss = source.readInt();
            //nativePrivateDirty = source.readInt();
            //nativeSharedDirty = source.readInt();
            //otherPss = source.readInt();
            //otherPrivateDirty = source.readInt();
            //otherSharedDirty = source.readInt();
            //otherStats = source.createIntArray();
        }

        
    }


    
    public static class InstructionCount {
        private static int NUM_INSTR =
            OpcodeInfo.MAXIMUM_PACKED_VALUE + 1;
        private int[] mCounts;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.692 -0400", hash_original_method = "409452CAAA99AF062D1B45C0A8D86C97", hash_generated_method = "CAD01F4AF0E6FB5E7E583547A926C076")
        @DSModeled(DSC.SAFE)
        public InstructionCount() {
            mCounts = new int[NUM_INSTR];
            // ---------- Original Method ----------
            //mCounts = new int[NUM_INSTR];
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.692 -0400", hash_original_method = "B55CA2C4A856CEE2241376D780EDBADA", hash_generated_method = "BB77D23FB9B7E586C3687AD649375853")
        @DSModeled(DSC.SAFE)
        public boolean resetAndStart() {
            try 
            {
                VMDebug.startInstructionCounting();
                VMDebug.resetInstructionCount();
            } //End block
            catch (UnsupportedOperationException uoe)
            { }
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //try {
                //VMDebug.startInstructionCounting();
                //VMDebug.resetInstructionCount();
            //} catch (UnsupportedOperationException uoe) {
                //return false;
            //}
            //return true;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.692 -0400", hash_original_method = "5FCC8E6F7C9E5A23FBCB0A1615F5BC2D", hash_generated_method = "C4DF970417F59C124A44D55C2E9C0E73")
        @DSModeled(DSC.SAFE)
        public boolean collect() {
            try 
            {
                VMDebug.stopInstructionCounting();
                VMDebug.getInstructionCount(mCounts);
            } //End block
            catch (UnsupportedOperationException uoe)
            { }
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //try {
                //VMDebug.stopInstructionCounting();
                //VMDebug.getInstructionCount(mCounts);
            //} catch (UnsupportedOperationException uoe) {
                //return false;
            //}
            //return true;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.692 -0400", hash_original_method = "51D086FA18F9CD076FA7BBB430E7197D", hash_generated_method = "A92853C023E6B92876F85F7EE49B7EBC")
        @DSModeled(DSC.SAFE)
        public int globalTotal() {
            int count;
            count = 0;
            {
                int i;
                i = 0;
                {
                    count += mCounts[i];
                } //End block
            } //End collapsed parenthetic
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //int count = 0;
            //for (int i = 0; i < NUM_INSTR; i++) {
                //count += mCounts[i];
            //}
            //return count;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.692 -0400", hash_original_method = "6746067FD45AAE4025CD0901FF5AA3FC", hash_generated_method = "91613E01444E52BBDAF8A5038AEBA76B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public int globalMethodInvocations() {
            int count;
            count = 0;
            {
                int i;
                i = 0;
                {
                    {
                        boolean varFAC684486A37EF13CBC51E3B4F00C0A2_1705265526 = (OpcodeInfo.isInvoke(i));
                        {
                            count += mCounts[i];
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //int count = 0;
            //for (int i = 0; i < NUM_INSTR; i++) {
                //if (OpcodeInfo.isInvoke(i)) {
                    //count += mCounts[i];
                //}
            //}
            //return count;
        }

        
    }


    
    @Target({ ElementType.FIELD }) @Retention(RetentionPolicy.RUNTIME) public @interface DebugProperty {
    }
    
    static {
        if (false) {
            final String TAG = "DebugProperties";
            final String[] files = { "/system/debug.prop", "/debug.prop", "/data/debug.prop" };
            final TypedProperties tp = new TypedProperties();
            for (String file : files) {
                Reader r;
                try {
                    r = new FileReader(file);
                } catch (FileNotFoundException ex) {
                    continue;
                }
                try {
                    tp.load(r);
                } catch (Exception ex) {
                    throw new RuntimeException("Problem loading " + file, ex);
                } finally {
                    try {
                        r.close();
                    } catch (IOException ex) {
                    }
                }
            }
            debugProperties = tp.isEmpty() ? null : tp;
        } else {
            debugProperties = null;
        }
    }
    
}


