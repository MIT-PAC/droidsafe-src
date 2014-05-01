package android.os;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.apache.harmony.dalvik.ddmc.Chunk;
import org.apache.harmony.dalvik.ddmc.ChunkHandler;
import org.apache.harmony.dalvik.ddmc.DdmServer;

import android.util.Log;

import com.android.internal.util.TypedProperties;

import dalvik.bytecode.OpcodeInfo;
import dalvik.system.VMDebug;

import droidsafe.helpers.DSUtils;

public final class Debug {

    /**
     * Wait until a debugger attaches.  As soon as the debugger attaches,
     * this returns, so you will need to place a breakpoint after the
     * waitForDebugger() call if you want to start tracing immediately.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.809 -0500", hash_original_method = "78474EB72C72DC1FE1085A7FD6047903", hash_generated_method = "1D13C6FC7CACB9F24DB34AA9BE641C64")
    
public static void waitForDebugger() {
        if (!VMDebug.isDebuggingEnabled()) {
            //System.out.println("debugging not enabled, not waiting");
            return;
        }
        if (isDebuggerConnected())
            return;

        // if DDMS is listening, inform them of our plight
        System.out.println("Sending WAIT chunk");
        byte[] data = new byte[] { 0 };     // 0 == "waiting for debugger"
        Chunk waitChunk = new Chunk(ChunkHandler.type("WAIT"), data, 0, 1);
        DdmServer.sendChunk(waitChunk);

        mWaiting = true;
        while (!isDebuggerConnected()) {
            try { Thread.sleep(SPIN_DELAY); }
            catch (InterruptedException ie) {}
        }
        mWaiting = false;

        System.out.println("Debugger has connected");

        /*
         * There is no "ready to go" signal from the debugger, and we're
         * not allowed to suspend ourselves -- the debugger expects us to
         * be running happily, and gets confused if we aren't.  We need to
         * allow the debugger a chance to set breakpoints before we start
         * running again.
         *
         * Sit and spin until the debugger has been idle for a short while.
         */
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

    /**
     * Returns "true" if one or more threads is waiting for a debugger
     * to attach.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.811 -0500", hash_original_method = "DD0B324AD7DDAC3BE4C7F5BE9E799132", hash_generated_method = "F9846DE7B677AFDC64B654EEA711F5FA")
    
public static boolean waitingForDebugger() {
        return mWaiting;
    }

    /**
     * Determine if a debugger is currently attached.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.813 -0500", hash_original_method = "A8F90F402197D3F14FFEE9F1D4CA2EC5", hash_generated_method = "5286AD478503CE0787F04CB528C9E162")
    
public static boolean isDebuggerConnected() {
        return VMDebug.isDebuggerConnected();
    }

    /**
     * Returns an array of strings that identify VM features.  This is
     * used by DDMS to determine what sorts of operations the VM can
     * perform.
     *
     * @hide
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.816 -0500", hash_original_method = "FFB4A2F605289FFD397797E4EBEF85C7", hash_generated_method = "6F8C6CA9D595FB40E367304EAD914129")
    
public static String[] getVmFeatureList() {
        return VMDebug.getVmFeatureList();
    }

    /**
     * Change the JDWP port.
     *
     * @deprecated no longer needed or useful
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.818 -0500", hash_original_method = "0163C8206FD905882DA3B7BB552BF2BC", hash_generated_method = "798A608BAA8D71866E08CC4387CC01D0")
    
@Deprecated
    public static void changeDebugPort(int port) {}

    /**
     * Enable qemu tracing. For this to work requires running everything inside
     * the qemu emulator; otherwise, this method will have no effect. The trace
     * file is specified on the command line when the emulator is started. For
     * example, the following command line <br />
     * <code>emulator -trace foo</code><br />
     * will start running the emulator and create a trace file named "foo". This
     * method simply enables writing the trace records to the trace file.
     *
     * <p>
     * The main differences between this and {@link #startMethodTracing()} are
     * that tracing in the qemu emulator traces every cpu instruction of every
     * process, including kernel code, so we have more complete information,
     * including all context switches. We can also get more detailed information
     * such as cache misses. The sequence of calls is determined by
     * post-processing the instruction trace. The qemu tracing is also done
     * without modifying the application or perturbing the timing of calls
     * because no instrumentation is added to the application being traced.
     * </p>
     *
     * <p>
     * One limitation of using this method compared to using
     * {@link #startMethodTracing()} on the real device is that the emulator
     * does not model all of the real hardware effects such as memory and
     * bus contention.  The emulator also has a simple cache model and cannot
     * capture all the complexities of a real cache.
     * </p>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.823 -0500", hash_original_method = "24AB94F1C6B3B96B435A2A213E586F57", hash_generated_method = "3354CAF0AF10113CE33160A35188B2E4")
    
public static void startNativeTracing() {
        // Open the sysfs file for writing and write "1" to it.
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

    /**
     * Stop qemu tracing.  See {@link #startNativeTracing()} to start tracing.
     *
     * <p>Tracing can be started and stopped as many times as desired.  When
     * the qemu emulator itself is stopped then the buffered trace records
     * are flushed and written to the trace file.  In fact, it is not necessary
     * to call this method at all; simply killing qemu is sufficient.  But
     * starting and stopping a trace is useful for examining a specific
     * region of code.</p>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.825 -0500", hash_original_method = "10B03DD18E21F28999697DBFB6441772", hash_generated_method = "407DF8369A08382F88E2A8E6399A39FC")
    
public static void stopNativeTracing() {
        VMDebug.stopEmulatorTracing();

        // Open the sysfs file for writing and write "0" to it.
        PrintWriter outStream = null;
        try {
            FileOutputStream fos = new FileOutputStream(SYSFS_QEMU_TRACE_STATE);
            outStream = new PrintWriter(new OutputStreamWriter(fos));
            outStream.println("0");
        } catch (Exception e) {
            // We could print an error message here but we probably want
            // to quietly ignore errors if we are not running in the emulator.
        } finally {
            if (outStream != null)
                outStream.close();
        }
    }

    /**
     * Enable "emulator traces", in which information about the current
     * method is made available to the "emulator -trace" feature.  There
     * is no corresponding "disable" call -- this is intended for use by
     * the framework when tracing should be turned on and left that way, so
     * that traces captured with F9/F10 will include the necessary data.
     *
     * This puts the VM into "profile" mode, which has performance
     * consequences.
     *
     * To temporarily enable tracing, use {@link #startNativeTracing()}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.827 -0500", hash_original_method = "5E3E9BCC18F4F81AFEDA2690110A43E7", hash_generated_method = "6C2249D8D6C6FBC9448402FB433D630E")
    
public static void enableEmulatorTraceOutput() {
        VMDebug.startEmulatorTracing();
    }

    /**
     * Start method tracing with default log name and buffer size. See <a
href="{@docRoot}guide/developing/tools/traceview.html">Traceview: A Graphical Log Viewer</a> for
     * information about reading these files. Call stopMethodTracing() to stop
     * tracing.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.830 -0500", hash_original_method = "B28A50E61370724E038679254004F3CB", hash_generated_method = "8AF3CF3F371E998FF7A9EF6A81B4C805")
    
public static void startMethodTracing() {
        VMDebug.startMethodTracing(DEFAULT_TRACE_FILE_PATH, 0, 0);
    }

    /**
     * Start method tracing, specifying the trace log file name.  The trace
     * file will be put under "/sdcard" unless an absolute path is given.
     * See <a
       href="{@docRoot}guide/developing/tools/traceview.html">Traceview: A Graphical Log Viewer</a> for
     * information about reading trace files.
     *
     * @param traceName Name for the trace log file to create.
     * If no name argument is given, this value defaults to "/sdcard/dmtrace.trace".
     * If the files already exist, they will be truncated.
     * If the trace file given does not end in ".trace", it will be appended for you.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.833 -0500", hash_original_method = "B71BD92AFF6466453E6F6F7742CF8DFD", hash_generated_method = "3817F949DCB7859EEA925CCB63F94A9F")
    
public static void startMethodTracing(String traceName) {
        startMethodTracing(traceName, 0, 0);
    }

    /**
     * Start method tracing, specifying the trace log file name and the
     * buffer size. The trace files will be put under "/sdcard" unless an
     * absolute path is given. See <a
       href="{@docRoot}guide/developing/tools/traceview.html">Traceview: A Graphical Log Viewer</a> for
     * information about reading trace files.
     * @param traceName    Name for the trace log file to create.
     * If no name argument is given, this value defaults to "/sdcard/dmtrace.trace".
     * If the files already exist, they will be truncated.
     * If the trace file given does not end in ".trace", it will be appended for you.
     *
     * @param bufferSize    The maximum amount of trace data we gather. If not given, it defaults to 8MB.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.835 -0500", hash_original_method = "B8949788B045FC637274E75B2BE33ECF", hash_generated_method = "E7B9E22D954505D5421576A4B6FD57A1")
    
public static void startMethodTracing(String traceName, int bufferSize) {
        startMethodTracing(traceName, bufferSize, 0);
    }

    /**
     * Start method tracing, specifying the trace log file name and the
     * buffer size. The trace files will be put under "/sdcard" unless an
     * absolute path is given. See <a
       href="{@docRoot}guide/developing/tools/traceview.html">Traceview: A Graphical Log Viewer</a> for
     * information about reading trace files.
     *
     * <p>
     * When method tracing is enabled, the VM will run more slowly than
     * usual, so the timings from the trace files should only be considered
     * in relative terms (e.g. was run #1 faster than run #2).  The times
     * for native methods will not change, so don't try to use this to
     * compare the performance of interpreted and native implementations of the
     * same method.  As an alternative, consider using "native" tracing
     * in the emulator via {@link #startNativeTracing()}.
     * </p>
     *
     * @param traceName    Name for the trace log file to create.
     * If no name argument is given, this value defaults to "/sdcard/dmtrace.trace".
     * If the files already exist, they will be truncated.
     * If the trace file given does not end in ".trace", it will be appended for you.
     * @param bufferSize    The maximum amount of trace data we gather. If not given, it defaults to 8MB.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.837 -0500", hash_original_method = "FC57B22C958BBBD2D110325861CED7E8", hash_generated_method = "84255BA3B22A8BBBBEA469B405075805")
    
public static void startMethodTracing(String traceName, int bufferSize,
        int flags) {

        String pathName = traceName;
        if (pathName.charAt(0) != '/')
            pathName = DEFAULT_TRACE_PATH_PREFIX + pathName;
        if (!pathName.endsWith(DEFAULT_TRACE_EXTENSION))
            pathName = pathName + DEFAULT_TRACE_EXTENSION;

        VMDebug.startMethodTracing(pathName, bufferSize, flags);
    }

    /**
     * Like startMethodTracing(String, int, int), but taking an already-opened
     * FileDescriptor in which the trace is written.  The file name is also
     * supplied simply for logging.  Makes a dup of the file descriptor.
     *
     * Not exposed in the SDK unless we are really comfortable with supporting
     * this and find it would be useful.
     * @hide
     */
    @DSSink({DSSinkKind.FILE})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.840 -0500", hash_original_method = "61BEE4455C71AA1B4B8E096BE0A9F80E", hash_generated_method = "A6AF3E598974F11A35885B279CDA83E0")
    
public static void startMethodTracing(String traceName, FileDescriptor fd,
        int bufferSize, int flags) {
        VMDebug.startMethodTracing(traceName, fd, bufferSize, flags);
    }

    /**
     * Starts method tracing without a backing file.  When stopMethodTracing
     * is called, the result is sent directly to DDMS.  (If DDMS is not
     * attached when tracing ends, the profiling data will be discarded.)
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.842 -0500", hash_original_method = "FFE2EA9F1B0C7B1D0B87CA6D7B155424", hash_generated_method = "947D709E89476DA64A342F257AD4FBE2")
    
public static void startMethodTracingDdms(int bufferSize, int flags) {
        VMDebug.startMethodTracingDdms(bufferSize, flags);
    }

    /**
     * Determine whether method tracing is currently active.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.844 -0500", hash_original_method = "DB744ED9820BBBCA493477D061843B3C", hash_generated_method = "41AD1FE5158B575E3C2B467EA63CC194")
    
public static boolean isMethodTracingActive() {
        return VMDebug.isMethodTracingActive();
    }

    /**
     * Stop method tracing.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.847 -0500", hash_original_method = "8C7DABCA9CC2734F7706D99DB6CDC33D", hash_generated_method = "C9D992D64EB4504B5FE85C2D793B4F9E")
    
public static void stopMethodTracing() {
        VMDebug.stopMethodTracing();
    }

    /**
     * Get an indication of thread CPU usage.  The value returned
     * indicates the amount of time that the current thread has spent
     * executing code or waiting for certain types of I/O.
     *
     * The time is expressed in nanoseconds, and is only meaningful
     * when compared to the result from an earlier call.  Note that
     * nanosecond resolution does not imply nanosecond accuracy.
     *
     * On system which don't support this operation, the call returns -1.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.849 -0500", hash_original_method = "969F39FFDE48B5771B1AAE0E71CBC46F", hash_generated_method = "8893FE5FF37E5D9C026AE7EDC4F52572")
    
public static long threadCpuTimeNanos() {
        return VMDebug.threadCpuTimeNanos();
    }

    /**
     * Start counting the number and aggregate size of memory allocations.
     *
     * <p>The {@link #startAllocCounting() start} function resets the counts and enables counting.
     * The {@link #stopAllocCounting() stop} function disables the counting so that the analysis
     * code doesn't cause additional allocations.  The various <code>get</code> functions return
     * the specified value. And the various <code>reset</code> functions reset the specified
     * count.</p>
     *
     * <p>Counts are kept for the system as a whole and for each thread.
     * The per-thread counts for threads other than the current thread
     * are not cleared by the "reset" or "start" calls.</p>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.852 -0500", hash_original_method = "67563E6CD6D31B7A9ED9D35FD2ACC78D", hash_generated_method = "61A1691919A8E92036956AAAA0018C5D")
    
public static void startAllocCounting() {
        VMDebug.startAllocCounting();
    }

    /**
     * Stop counting the number and aggregate size of memory allocations.
     *
     * @see #startAllocCounting()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.854 -0500", hash_original_method = "B2ABBABB9AAC473F130021E0A6601574", hash_generated_method = "8A1EC8716B33AA9A4D523DA9D47834CF")
    
public static void stopAllocCounting() {
        VMDebug.stopAllocCounting();
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.856 -0500", hash_original_method = "0CF7D3D48014743A078F7BFCBD6298DE", hash_generated_method = "D9F3A2CCF72B8A4BCA8453F6712D4DB1")
    
public static int getGlobalAllocCount() {
        return VMDebug.getAllocCount(VMDebug.KIND_GLOBAL_ALLOCATED_OBJECTS);
    }
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.858 -0500", hash_original_method = "AB2C9148E9F1B83B66C21E6CC3E51A13", hash_generated_method = "02D99DB7A9663636BFBE755FD4DD333F")
    
public static int getGlobalAllocSize() {
        return VMDebug.getAllocCount(VMDebug.KIND_GLOBAL_ALLOCATED_BYTES);
    }
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.861 -0500", hash_original_method = "695F0DB4ABA2FAA4C6B686848E90FF0F", hash_generated_method = "EAAAB54DD80923CFAE24C991C512E3E3")
    
public static int getGlobalFreedCount() {
        return VMDebug.getAllocCount(VMDebug.KIND_GLOBAL_FREED_OBJECTS);
    }
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.863 -0500", hash_original_method = "167D8B8030FE85DEE4E9128668E87890", hash_generated_method = "5458D4E3440616456AF582C1FCE5DEF0")
    
public static int getGlobalFreedSize() {
        return VMDebug.getAllocCount(VMDebug.KIND_GLOBAL_FREED_BYTES);
    }
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.865 -0500", hash_original_method = "A1554EC06EC5FA1CE0C2F7B8F7C86655", hash_generated_method = "05D39D78AC99F1261CA1B5219A33B6ED")
    
public static int getGlobalClassInitCount() {
        /* number of classes that have been successfully initialized */
        return VMDebug.getAllocCount(VMDebug.KIND_GLOBAL_CLASS_INIT_COUNT);
    }
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.867 -0500", hash_original_method = "D8F4BF635EDBD9713AC07FFF59B892D1", hash_generated_method = "3BBBCA76E92029714E7F6FF2A8142A75")
    
public static int getGlobalClassInitTime() {
        /* cumulative elapsed time for class initialization, in usec */
        return VMDebug.getAllocCount(VMDebug.KIND_GLOBAL_CLASS_INIT_TIME);
    }

    /**
     * Returns the global count of external allocation requests.  The
     * external allocation tracking feature was removed in Honeycomb.
     * This method exists for compatibility and always returns 0.
     *
     * @deprecated This method is now obsolete.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.869 -0500", hash_original_method = "F2D18F66BA7892EA39FFE9A4C7182C57", hash_generated_method = "8E41A67517EDC8B45C0604F7354C26F2")
    
@Deprecated
    public static int getGlobalExternalAllocCount() {
        return 0;
    }

    /**
     * Returns the global count of bytes externally allocated.  The
     * external allocation tracking feature was removed in Honeycomb.
     * This method exists for compatibility and always returns 0.
     *
     * @deprecated This method is now obsolete.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.872 -0500", hash_original_method = "BCF934C0F5752FA43CB9DC1202287FDA", hash_generated_method = "50DAC282E4E56543A7A53A9DF5F0DED4")
    
@Deprecated
    public static int getGlobalExternalAllocSize() {
        return 0;
    }

    /**
     * Returns the global count of freed external allocation requests.
     * The external allocation tracking feature was removed in
     * Honeycomb.  This method exists for compatibility and always
     * returns 0.
     *
     * @deprecated This method is now obsolete.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.874 -0500", hash_original_method = "4A5BBCA63642DD598E8706B0BEEF7F9E", hash_generated_method = "D985CDFBBC815D8F9E59300B6E25B4F4")
    
@Deprecated
    public static int getGlobalExternalFreedCount() {
        return 0;
    }

    /**
     * Returns the global count of freed bytes from external
     * allocation requests.  The external allocation tracking feature
     * was removed in Honeycomb.  This method exists for compatibility
     * and always returns 0.
     *
     * @deprecated This method is now obsolete.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.877 -0500", hash_original_method = "8A757D7E3E99170A3143AA9AAED5C840", hash_generated_method = "BD46BE82D7D19E9A1B6DE6548841198B")
    
@Deprecated
    public static int getGlobalExternalFreedSize() {
        return 0;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.880 -0500", hash_original_method = "E91AEF6C526C86D6DBB3BCEF7A1DA830", hash_generated_method = "EDC8CB4194150EB9B6EB04765C818221")
    
public static int getGlobalGcInvocationCount() {
        return VMDebug.getAllocCount(VMDebug.KIND_GLOBAL_GC_INVOCATIONS);
    }
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.882 -0500", hash_original_method = "CA10B26CEE93A2257F7F6779A0040536", hash_generated_method = "AB9E528145CB5E5CDAEF9E07883D1C56")
    
public static int getThreadAllocCount() {
        return VMDebug.getAllocCount(VMDebug.KIND_THREAD_ALLOCATED_OBJECTS);
    }
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.884 -0500", hash_original_method = "8264EDD15D9FAF32E2528125F01D0F6F", hash_generated_method = "88F8F3580516C2BB35ABA4341A3DC4CD")
    
public static int getThreadAllocSize() {
        return VMDebug.getAllocCount(VMDebug.KIND_THREAD_ALLOCATED_BYTES);
    }

    /**
     * Returns the count of external allocation requests made by the
     * current thread.  The external allocation tracking feature was
     * removed in Honeycomb.  This method exists for compatibility and
     * always returns 0.
     *
     * @deprecated This method is now obsolete.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.887 -0500", hash_original_method = "D21B5890D75CBE04EB2929052BCCDC27", hash_generated_method = "E31019E7ECCECD0065D4989A90D44190")
    
@Deprecated
    public static int getThreadExternalAllocCount() {
        return 0;
    }

    /**
     * Returns the global count of bytes externally allocated.  The
     * external allocation tracking feature was removed in Honeycomb.
     * This method exists for compatibility and always returns 0.
     *
     * @deprecated This method is now obsolete.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.889 -0500", hash_original_method = "744BA3A1F669786FA7A6C57459411C28", hash_generated_method = "301BACF451298F9C68DB241CC2598604")
    
@Deprecated
    public static int getThreadExternalAllocSize() {
        return 0;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.891 -0500", hash_original_method = "CD0D21FD4D9C27BDC3E490AC92DD3B6B", hash_generated_method = "773DE6E199405CDBC0A333A2582DC1BA")
    
public static int getThreadGcInvocationCount() {
        return VMDebug.getAllocCount(VMDebug.KIND_THREAD_GC_INVOCATIONS);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.893 -0500", hash_original_method = "2B1F74261543157B3707C987B951B12E", hash_generated_method = "0A63116D515D21BBFCEFB2C11E35444A")
    
public static void resetGlobalAllocCount() {
        VMDebug.resetAllocCount(VMDebug.KIND_GLOBAL_ALLOCATED_OBJECTS);
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.896 -0500", hash_original_method = "B03867F9D5DB45F6E797DAB2DE5BFFDC", hash_generated_method = "9A585C8FFB84061764423BB7A8A500A5")
    
public static void resetGlobalAllocSize() {
        VMDebug.resetAllocCount(VMDebug.KIND_GLOBAL_ALLOCATED_BYTES);
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.898 -0500", hash_original_method = "861CBDB6C0D63922A4F9D2A2335B14C7", hash_generated_method = "C88C8965E7A5C163F6485BAE359A5408")
    
public static void resetGlobalFreedCount() {
        VMDebug.resetAllocCount(VMDebug.KIND_GLOBAL_FREED_OBJECTS);
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.900 -0500", hash_original_method = "976216342F2B8476474119AE0E47E068", hash_generated_method = "2874C6FD0AA3B6D928C729397B5D77F9")
    
public static void resetGlobalFreedSize() {
        VMDebug.resetAllocCount(VMDebug.KIND_GLOBAL_FREED_BYTES);
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.903 -0500", hash_original_method = "35588E2F48C88BA8D43E9360F91D5DF6", hash_generated_method = "F1140AE4149AA504FF785F415F8BA01B")
    
public static void resetGlobalClassInitCount() {
        VMDebug.resetAllocCount(VMDebug.KIND_GLOBAL_CLASS_INIT_COUNT);
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.905 -0500", hash_original_method = "E50702C4EB93F3D728654938E4E53B26", hash_generated_method = "A2E28AEEB4660713FC899E1762327A60")
    
public static void resetGlobalClassInitTime() {
        VMDebug.resetAllocCount(VMDebug.KIND_GLOBAL_CLASS_INIT_TIME);
    }

    /**
     * Resets the global count of external allocation requests.  The
     * external allocation tracking feature was removed in Honeycomb.
     * This method exists for compatibility and has no effect.
     *
     * @deprecated This method is now obsolete.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.907 -0500", hash_original_method = "56094138813247401A1CB12DD1515681", hash_generated_method = "CADD5401E7B96B2C34F0800ED8CF8313")
    
@Deprecated
    public static void resetGlobalExternalAllocCount() {}

    /**
     * Resets the global count of bytes externally allocated.  The
     * external allocation tracking feature was removed in Honeycomb.
     * This method exists for compatibility and has no effect.
     *
     * @deprecated This method is now obsolete.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.910 -0500", hash_original_method = "D8E2AA39591AC4E6F843977CA2A212D3", hash_generated_method = "4A516893C37E65C18C2EBDBCC35493F6")
    
@Deprecated
    public static void resetGlobalExternalAllocSize() {}

    /**
     * Resets the global count of freed external allocations.  The
     * external allocation tracking feature was removed in Honeycomb.
     * This method exists for compatibility and has no effect.
     *
     * @deprecated This method is now obsolete.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.912 -0500", hash_original_method = "AA6367B478F9A852148448AFECAB6EF6", hash_generated_method = "5B76E0C94B2CE0EDF22378E833924B15")
    
@Deprecated
    public static void resetGlobalExternalFreedCount() {}

    /**
     * Resets the global count counter of freed bytes from external
     * allocations.  The external allocation tracking feature was
     * removed in Honeycomb.  This method exists for compatibility and
     * has no effect.
     *
     * @deprecated This method is now obsolete.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.914 -0500", hash_original_method = "33780DBE97BD7C670E5AFFC2C0A5985B", hash_generated_method = "F2612A86B7C06B647F6BF803B9490EB9")
    
@Deprecated
    public static void resetGlobalExternalFreedSize() {}

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.916 -0500", hash_original_method = "C9E395F15DF7BAB8FE944D7758B4944B", hash_generated_method = "D8C0B8225D1ACABB16E5A802658D5DDD")
    
public static void resetGlobalGcInvocationCount() {
        VMDebug.resetAllocCount(VMDebug.KIND_GLOBAL_GC_INVOCATIONS);
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.918 -0500", hash_original_method = "2F3B5F856A955845C50059A5F55509BA", hash_generated_method = "8E216B1745DA6722DDC180A34C27731C")
    
public static void resetThreadAllocCount() {
        VMDebug.resetAllocCount(VMDebug.KIND_THREAD_ALLOCATED_OBJECTS);
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.921 -0500", hash_original_method = "2546066B10A68B69B7502151C67ADF51", hash_generated_method = "19B8FB770D324AE1444F6823D49F5863")
    
public static void resetThreadAllocSize() {
        VMDebug.resetAllocCount(VMDebug.KIND_THREAD_ALLOCATED_BYTES);
    }

    /**
     * Resets the count of external allocation requests made by the
     * current thread.  The external allocation tracking feature was
     * removed in Honeycomb.  This method exists for compatibility and
     * has no effect.
     *
     * @deprecated This method is now obsolete.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.924 -0500", hash_original_method = "2199049C4F400DF72BDDC1A4839F8700", hash_generated_method = "567C319D1475F33F5A6EDE3DBA03579F")
    
@Deprecated
    public static void resetThreadExternalAllocCount() {}

    /**
     * Resets the count of bytes externally allocated by the current
     * thread.  The external allocation tracking feature was removed
     * in Honeycomb.  This method exists for compatibility and has no
     * effect.
     *
     * @deprecated This method is now obsolete.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.926 -0500", hash_original_method = "D0BF4925CA67C3B6C5155741DF336C8F", hash_generated_method = "F4B1985C5DC33FF2F80DDD5B8C80E043")
    
@Deprecated
    public static void resetThreadExternalAllocSize() {}

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.929 -0500", hash_original_method = "58ADA4529D0B6962755AE451B721BB1D", hash_generated_method = "C218BF59988EEBB2430922E090587A83")
    
public static void resetThreadGcInvocationCount() {
        VMDebug.resetAllocCount(VMDebug.KIND_THREAD_GC_INVOCATIONS);
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.931 -0500", hash_original_method = "53D80E15EF1FFE4637D8EF4D0ED35D89", hash_generated_method = "864434D3258598DC836DDC7019B199D2")
    
public static void resetAllCounts() {
        VMDebug.resetAllocCount(VMDebug.KIND_ALL_COUNTS);
    }
    
    public static long getNativeHeapSize() {
        return DSUtils.UNKNOWN_LONG;
    }
    
    public static long getNativeHeapAllocatedSize() {
        return DSUtils.UNKNOWN_LONG;
    }
    
    public static long getNativeHeapFreeSize() {
        return DSUtils.UNKNOWN_LONG;
    }
    
    public static void getMemoryInfo(MemoryInfo memoryInfo) {
    }
    
    public static void getMemoryInfo(int pid, MemoryInfo memoryInfo) {
    }
    
    public static long getPss() {
        return DSUtils.UNKNOWN_LONG;
    }
    
    public static long getPss(int pid) {
        return pid;
    }

    /**
     * Establish an object allocation limit in the current thread.
     * This feature was never enabled in release builds.  The
     * allocation limits feature was removed in Honeycomb.  This
     * method exists for compatibility and always returns -1 and has
     * no effect.
     *
     * @deprecated This method is now obsolete.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.959 -0500", hash_original_method = "F2D92EF76A0504EC51F795A2E7A55E9D", hash_generated_method = "F063C387E4EDD819F25EEF1A67F4ADDA")
    
@Deprecated
    public static int setAllocationLimit(int limit) {
        return -1;
    }

    /**
     * Establish a global object allocation limit.  This feature was
     * never enabled in release builds.  The allocation limits feature
     * was removed in Honeycomb.  This method exists for compatibility
     * and always returns -1 and has no effect.
     *
     * @deprecated This method is now obsolete.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.962 -0500", hash_original_method = "85E92A7E48E83667B7FCFEA41481A251", hash_generated_method = "F4543BDF3A8B7BCDADE595D4009E334A")
    
@Deprecated
    public static int setGlobalAllocationLimit(int limit) {
        return -1;
    }

    /**
     * Dump a list of all currently loaded class to the log file.
     *
     * @param flags See constants above.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.964 -0500", hash_original_method = "1125B7EE847DE2E2B1EF071157DFEBB7", hash_generated_method = "91FF2462936B2093B1C2376FD1913350")
    
public static void printLoadedClasses(int flags) {
        VMDebug.printLoadedClasses(flags);
    }

    /**
     * Get the number of loaded classes.
     * @return the number of loaded classes.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.967 -0500", hash_original_method = "3C278506FF5D85E033BC2B8A5DB9B449", hash_generated_method = "AB67D939E843289669569BEFABFB07D8")
    
public static int getLoadedClassCount() {
        return VMDebug.getLoadedClassCount();
    }

    /**
     * Dump "hprof" data to the specified file.  This may cause a GC.
     *
     * @param fileName Full pathname of output file (e.g. "/sdcard/dump.hprof").
     * @throws UnsupportedOperationException if the VM was built without
     *         HPROF support.
     * @throws IOException if an error occurs while opening or writing files.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.969 -0500", hash_original_method = "2A3BA8C930CC8D70EFDC06E422B5CE17", hash_generated_method = "A68900B8650C713DF8FE69E78EA5F319")
    
public static void dumpHprofData(String fileName) throws IOException {
        //VMDebug.dumpHprofData(fileName);
    }

    /**
     * Like dumpHprofData(String), but takes an already-opened
     * FileDescriptor to which the trace is written.  The file name is also
     * supplied simply for logging.  Makes a dup of the file descriptor.
     *
     * Primarily for use by the "am" shell command.
     *
     * @hide
     */
    @DSSink({DSSinkKind.FILE})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.971 -0500", hash_original_method = "E71A30A98691493542EA069FF7EF94B8", hash_generated_method = "54CCFDCF5F5F54D5B42CE9010DDF8BB2")
    
public static void dumpHprofData(String fileName, FileDescriptor fd)
            throws IOException {
        //VMDebug.dumpHprofData(fileName, fd);
    }

    /**
     * Collect "hprof" and send it to DDMS.  This may cause a GC.
     *
     * @throws UnsupportedOperationException if the VM was built without
     *         HPROF support.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.973 -0500", hash_original_method = "1F5F04F240A97C1BD6CC299225911198", hash_generated_method = "E5E8D44B72D0A011B16DAFF2C1C0710B")
    
public static void dumpHprofDataDdms() {
        VMDebug.dumpHprofDataDdms();
    }
    
    public static void dumpNativeHeap(FileDescriptor fd) {
    }

    /**
      * Returns a count of the extant instances of a class.
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.980 -0500", hash_original_method = "D878379E552A4E4CA3B2BC84B825D68D", hash_generated_method = "7CD0606BCDE9409948B14414AD145835")
    
public static long countInstancesOfClass(Class cls) {
        //return VMDebug.countInstancesOfClass(cls, true);
        return cls.getTaintLong();
    }
    
    public static int getBinderSentTransactions() {
        return DSUtils.UNKNOWN_INT;
    }
    
    public static int getBinderReceivedTransactions() {
        return DSUtils.UNKNOWN_INT;
    }
    
    public static final int getBinderLocalObjectCount() {
        return DSUtils.UNKNOWN_INT;
    }
    
    public static final int getBinderProxyObjectCount() {
        return DSUtils.UNKNOWN_INT;
    }
    
    public static final int getBinderDeathObjectCount() {
        return DSUtils.UNKNOWN_INT;
    }

    /**
     * Primes the register map cache.
     *
     * Only works for classes in the bootstrap class loader.  Does not
     * cause classes to be loaded if they're not already present.
     *
     * The classAndMethodDesc argument is a concatentation of the VM-internal
     * class descriptor, method name, and method descriptor.  Examples:
     *     Landroid/os/Looper;.loop:()V
     *     Landroid/app/ActivityThread;.main:([Ljava/lang/String;)V
     *
     * @param classAndMethodDesc the method to prepare
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:43.002 -0500", hash_original_method = "0CA55CC43FB3B8576CC7C0DBAF1F74C0", hash_generated_method = "E08171120887014347C0D1FF2B57D7A2")
    
public static final boolean cacheRegisterMap(String classAndMethodDesc) {
        //return VMDebug.cacheRegisterMap(classAndMethodDesc);
        return classAndMethodDesc.getTaintBoolean();
    }

    /**
     * Dumps the contents of VM reference tables (e.g. JNI locals and
     * globals) to the log file.
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:43.004 -0500", hash_original_method = "9646D8356AAE31876A9E9F3AB6644735", hash_generated_method = "A593400102316B2AAD640F9202795286")
    
public static final void dumpReferenceTables() {
        //VMDebug.dumpReferenceTables();
    }

    /**
     * Returns true if the type of the field matches the specified class.
     * Handles the case where the class is, e.g., java.lang.Boolean, but
     * the field is of the primitive "boolean" type.  Also handles all of
     * the java.lang.Number subclasses.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:43.030 -0500", hash_original_method = "C4FA78418D555E768FF5DBC8DE58360D", hash_generated_method = "499C7262D02543E41FA0371D6EC9668C")
    
private static boolean fieldTypeMatches(Field field, Class<?> cl) {
        Class<?> fieldClass = field.getType();
        if (fieldClass == cl) {
            return true;
        }
        Field primitiveTypeField;
        try {
            /* All of the classes we care about (Boolean, Integer, etc.)
             * have a Class field called "TYPE" that points to the corresponding
             * primitive class.
             */
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

    /**
     * Looks up the property that corresponds to the field, and sets the field's value
     * if the types match.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:43.033 -0500", hash_original_method = "ECD2E5721BC163A0054AA741832C3882", hash_generated_method = "14A5AF88A2506E99D7DB3789702FBF82")
    
private static void modifyFieldIfSet(final Field field, final TypedProperties properties,
                                         final String propertyName) {
        if (field.getType() == java.lang.String.class) {
            int stringInfo = properties.getStringInfo(propertyName);
            switch (stringInfo) {
                case TypedProperties.STRING_SET:
                    // Handle as usual below.
                    break;
                case TypedProperties.STRING_NULL:
                    try {
                        field.set(null, null);  // null object for static fields; null string
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
                field.set(null, value);  // null object for static fields
            } catch (IllegalAccessException ex) {
                throw new IllegalArgumentException(
                    "Cannot set field for " + propertyName, ex);
            }
        }
    }

    /**
     * Equivalent to <code>setFieldsOn(cl, false)</code>.
     *
     * @see #setFieldsOn(Class, boolean)
     *
     * @hide
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:43.035 -0500", hash_original_method = "F1F2F8FAD252031217CA0AAF2E24EE7D", hash_generated_method = "D95E678D58D2C8AD01DE9FD559DEE2D3")
    
public static void setFieldsOn(Class<?> cl) {
        setFieldsOn(cl, false);
    }

    /**
     * Reflectively sets static fields of a class based on internal debugging
     * properties.  This method is a no-op if false is
     * false.
     * <p>
     * <strong>NOTE TO APPLICATION DEVELOPERS</strong>: false will
     * always be false in release builds.  This API is typically only useful
     * for platform developers.
     * </p>
     * Class setup: define a class whose only fields are non-final, static
     * primitive types (except for "char") or Strings.  In a static block
     * after the field definitions/initializations, pass the class to
     * this method, Debug.setFieldsOn(). Example:
     * <pre>
     * package com.example;
     *
     * import android.os.Debug;
     *
     * public class MyDebugVars {
     *    public static String s = "a string";
     *    public static String s2 = "second string";
     *    public static String ns = null;
     *    public static boolean b = false;
     *    public static int i = 5;
     *    @Debug.DebugProperty
     *    public static float f = 0.1f;
     *    @@Debug.DebugProperty
     *    public static double d = 0.5d;
     *
     *    // This MUST appear AFTER all fields are defined and initialized!
     *    static {
     *        // Sets all the fields
     *        Debug.setFieldsOn(MyDebugVars.class);
     *
     *        // Sets only the fields annotated with @Debug.DebugProperty
     *        // Debug.setFieldsOn(MyDebugVars.class, true);
     *    }
     * }
     * </pre>
     * setFieldsOn() may override the value of any field in the class based
     * on internal properties that are fixed at boot time.
     * <p>
     * These properties are only set during platform debugging, and are not
     * meant to be used as a general-purpose properties store.
     *
     * {@hide}
     *
     * @param cl The class to (possibly) modify
     * @param partial If false, sets all static fields, otherwise, only set
     *        fields with the {@link android.os.Debug.DebugProperty}
     *        annotation
     * @throws IllegalArgumentException if any fields are final or non-static,
     *         or if the type of the field does not match the type of
     *         the internal debugging property value.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:43.038 -0500", hash_original_method = "67972367DFC302603F6E9ABB6D4B467F", hash_generated_method = "A2C83FAB62FF4200A6E94C84341A5E10")
    
public static void setFieldsOn(Class<?> cl, boolean partial) {
        if (false) {
            if (debugProperties != null) {
                /* Only look for fields declared directly by the class,
                 * so we don't mysteriously change static fields in superclasses.
                 */
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

    /**
     * Get a debugging dump of a system service by name.
     *
     * <p>Most services require the caller to hold android.permission.DUMP.
     *
     * @param name of the service to dump
     * @param fd to write dump output to (usually an output log file)
     * @param args to pass to the service's dump method, may be null
     * @return true if the service was dumped successfully, false if
     *     the service could not be found or had an error while dumping
     */
    @DSSink({DSSinkKind.FILE})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:43.043 -0500", hash_original_method = "B5D69574A1B80BC6A0DAF5C729E713CA", hash_generated_method = "25E6FF9A7AE135B20437E952A4A56138")
    
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.709 -0500", hash_original_field = "B1C7DEC106DECCED86A48969B6CC4DCD", hash_generated_field = "389377F3F689781EB2D3F49236B9D2AF")

    private static final String TAG = "Debug";
    
    public static class MemoryInfo implements Parcelable {

        /* @hide */
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.784 -0500", hash_original_method = "7725E7152BF27C491568D120E3EC44B3", hash_generated_method = "743B72EA0B657CDE2933D000A204229E")
        
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.763 -0500", hash_original_field = "72EBCAAA1DDC9FC55AF62DA285B6F80C", hash_generated_field = "BE882405B287754DCA85D85E2C8781E8")

        public static final int NUM_OTHER_STATS = 9;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.999 -0400", hash_original_field = "7B937244499DDD6DE8E8DD078A54CA42", hash_generated_field = "8D5A5BE61EBADDE649E9CD81EA9451BA")

        public static final Creator<MemoryInfo> CREATOR = new Creator<MemoryInfo>() {
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.795 -0500", hash_original_method = "83921F47BB880779DC0FD4AB57F3B1E1", hash_generated_method = "495A301237E8C89DBCB599934CDB78DC")
            
public MemoryInfo createFromParcel(Parcel source) {
                return new MemoryInfo(source);
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.798 -0500", hash_original_method = "15F51E1DA13C1BB1AA9F8A3C297A7987", hash_generated_method = "6BF372C605ED1E982EE449D3C3BB4350")
            
public MemoryInfo[] newArray(int size) {
                return new MemoryInfo[size];
            }
        };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.742 -0500", hash_original_field = "9F34623D5F63D66EBFCCC927CEBEC534", hash_generated_field = "E77238136A622AAF0ED6F3D37CC9FF1B")

        public int dalvikPss;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.744 -0500", hash_original_field = "E57158B3016ACBCDC844984B90FC795E", hash_generated_field = "33D4311D6A9BBFAAB58E541DF2012236")

        public int dalvikPrivateDirty;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.747 -0500", hash_original_field = "AD6E7EF4EE699A3821F1D146249F3A4A", hash_generated_field = "FDF5E4BB072D7AF9419CF36E0FA9A95B")

        public int dalvikSharedDirty;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.749 -0500", hash_original_field = "265450FA2B131D9EE19E252E529386B4", hash_generated_field = "2194949D909E3886F365A0CE92ABB11F")

        public int nativePss;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.751 -0500", hash_original_field = "6DB4094FFA4011D54C5B84D8FBB2A0B9", hash_generated_field = "4151FDAF6831E5A1C9C7BB75F9F0334B")

        public int nativePrivateDirty;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.753 -0500", hash_original_field = "39EAA167BE812CE5240BC15049F11437", hash_generated_field = "D69D6BF47BFFE8E073898562793D15D0")

        public int nativeSharedDirty;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.755 -0500", hash_original_field = "0B9B8C26260FB76C51D1BEE6D2261E41", hash_generated_field = "42B6A257B6E0D4C33EACAEEDCBD9EE83")

        public int otherPss;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.758 -0500", hash_original_field = "0728A42583D31C5A9D6C141C2941E58C", hash_generated_field = "1AC34AC5DA50ED2DC11E013FB382AEA4")

        public int otherPrivateDirty;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.760 -0500", hash_original_field = "32FEE4B40DFA4350FC92AA0B621B561A", hash_generated_field = "C380E10B138C6974D039AFFA2B3E8984")

        public int otherSharedDirty;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.766 -0500", hash_original_field = "F9A2B23646745458CFC666A2357AAEA5", hash_generated_field = "A5B0CBFEF61DBB07B6E8C5D2F1ECFDA9")

        private int[] otherStats = new int[NUM_OTHER_STATS*3];

        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.768 -0500", hash_original_method = "09AE2D253AD01F5533857164DB70587D", hash_generated_method = "1FF0633BAB808AAABE7DEEC0DAD3D78E")
        
public MemoryInfo() {
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.803 -0500", hash_original_method = "EAA33F4FBF3C878879D517CBC8FFA048", hash_generated_method = "8AE129BE4DE87B957565DCB16A2274BA")
        
private MemoryInfo(Parcel source) {
            readFromParcel(source);
        }

        /**
         * Return total PSS memory usage in kB.
         */
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.771 -0500", hash_original_method = "0F7876D4F39A60F2060DE34A3D4B321B", hash_generated_method = "E979F826C435A84C613AC04A1613046C")
        
public int getTotalPss() {
            return dalvikPss + nativePss + otherPss;
        }

        /**
         * Return total private dirty memory usage in kB.
         */
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.773 -0500", hash_original_method = "5F6AFDC3B733846B095E6E612D37EF25", hash_generated_method = "834F29CD5DF07BC34B95AA6055F5D491")
        
public int getTotalPrivateDirty() {
            return dalvikPrivateDirty + nativePrivateDirty + otherPrivateDirty;
        }

        /**
         * Return total shared dirty memory usage in kB.
         */
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.775 -0500", hash_original_method = "DD332BDFA0A32D6562D4D066F36B1807", hash_generated_method = "D96914902B24EF94F9FF6BAE4D374D80")
        
public int getTotalSharedDirty() {
            return dalvikSharedDirty + nativeSharedDirty + otherSharedDirty;
        }

        /* @hide */
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.777 -0500", hash_original_method = "8C545D479EA5CCAA2D5CE5956250CE73", hash_generated_method = "39A94549975A96885A2DB0293ADCC235")
        
public int getOtherPss(int which) {
            return otherStats[which*3];
        }

        /* @hide */
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.779 -0500", hash_original_method = "45A31C2AA910C3CDA42EF94E68B5E963", hash_generated_method = "ECA9BB976EEED7906E27CEC1CA539E47")
        
public int getOtherPrivateDirty(int which) {
            return otherStats[which*3 + 1];
        }

        /* @hide */
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.781 -0500", hash_original_method = "1FF35BC5D0D80C168B4EDFE5B23B6F0A", hash_generated_method = "6DA3E9FE6AD8CAF05434CC2032A56E23")
        
public int getOtherSharedDirty(int which) {
            return otherStats[which*3 + 2];
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.787 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
        
public int describeContents() {
            return 0;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.789 -0500", hash_original_method = "D2FBA6C4AE93947F6ACE85B65AE77863", hash_generated_method = "068C19713C9C2A2D225753E23AF16991")
        
public void writeToParcel(Parcel dest, int flags) {
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
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.792 -0500", hash_original_method = "3814E1A02C58284E12D5ED0E53DE29C9", hash_generated_method = "EF59CABE223048F563AF3C5DC9847B9B")
        
public void readFromParcel(Parcel source) {
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
        }
        // orphaned legacy method
        public MemoryInfo createFromParcel(Parcel source) {
                return new MemoryInfo(source);
            }
        
        // orphaned legacy method
        public MemoryInfo[] newArray(int size) {
                return new MemoryInfo[size];
            }
        
    }
    
    public static class InstructionCount {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:43.008 -0500", hash_original_field = "149D550550C2E222FA0A2D463AB29509", hash_generated_field = "7A22C579A39E22551B4E74531C1864CF")

        private static final int NUM_INSTR =
            OpcodeInfo.MAXIMUM_PACKED_VALUE + 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:43.010 -0500", hash_original_field = "8BF91F36E45CDC8E16970AC613A2D773", hash_generated_field = "49E4B6FD194C81A543C4A6FC8DB4D611")

        private int[] mCounts;

        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:43.012 -0500", hash_original_method = "409452CAAA99AF062D1B45C0A8D86C97", hash_generated_method = "6FBF8B81EACDD3BCFF0201D965E43623")
        
public InstructionCount() {
            mCounts = new int[NUM_INSTR];
        }

        /**
         * Reset counters and ensure counts are running.  Counts may
         * have already been running.
         *
         * @return true if counting was started
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:43.015 -0500", hash_original_method = "B55CA2C4A856CEE2241376D780EDBADA", hash_generated_method = "C086D21F3EF0B40AF956A73D35E8E28F")
        
public boolean resetAndStart() {
            try {
                VMDebug.startInstructionCounting();
                VMDebug.resetInstructionCount();
            } catch (UnsupportedOperationException uoe) {
                return false;
            }
            return true;
        }

        /**
         * Collect instruction counts.  May or may not stop the
         * counting process.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:43.017 -0500", hash_original_method = "5FCC8E6F7C9E5A23FBCB0A1615F5BC2D", hash_generated_method = "DFEE05ADF9E6215BBB23E3CCF38B1D3F")
        
public boolean collect() {
            try {
                VMDebug.stopInstructionCounting();
                VMDebug.getInstructionCount(mCounts);
            } catch (UnsupportedOperationException uoe) {
                return false;
            }
            return true;
        }

        /**
         * Return the total number of instructions executed globally (i.e. in
         * all threads).
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:43.020 -0500", hash_original_method = "51D086FA18F9CD076FA7BBB430E7197D", hash_generated_method = "852CD7224B40120AD7EF5834D0CD6E2D")
        
public int globalTotal() {
            int count = 0;

            for (int i = 0; i < NUM_INSTR; i++) {
                count += mCounts[i];
            }

            return count;
        }

        /**
         * Return the total number of method-invocation instructions
         * executed globally.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:43.023 -0500", hash_original_method = "6746067FD45AAE4025CD0901FF5AA3FC", hash_generated_method = "EC537F8DBBDB8C686D52ACAAF2D73265")
        
public int globalMethodInvocations() {
            int count = 0;

            for (int i = 0; i < NUM_INSTR; i++) {
                if (OpcodeInfo.isInvoke(i)) {
                    count += mCounts[i];
                }
            }

            return count;
        }
    }
    
    @Target({ ElementType.FIELD }) @Retention(RetentionPolicy.RUNTIME) public @interface DebugProperty {
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.712 -0500", hash_original_field = "D94FEB4B235C9CEDB2BD44A6A4BF6FED", hash_generated_field = "10D28A5A9C48BBAA5DC8C2CB09A08B6D")

    public static final int TRACE_COUNT_ALLOCS  = VMDebug.TRACE_COUNT_ALLOCS;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.714 -0500", hash_original_field = "9BC0646007B1A4F06B2CEE2A17998F36", hash_generated_field = "E63C1BEA9E5320C4CDD4B43587127B9C")

    public static final int SHOW_FULL_DETAIL    = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.717 -0500", hash_original_field = "68B7C053F95B4020BF4801CF55CD6DF9", hash_generated_field = "9415B3064505E8BD5A92127E1C805476")

    public static final int SHOW_CLASSLOADER    = (1 << 1);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.719 -0500", hash_original_field = "A2A9C74D46BFB6B0464BBC0FF2CBA111", hash_generated_field = "E4385EA72DE6689F6653D4026B310DF2")

    public static final int SHOW_INITIALIZED    = (1 << 2);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.721 -0500", hash_original_field = "2CA17DE967D830377715AEEA5AACCEDA", hash_generated_field = "64A21F9D05164630E7E61CDF96B7B8A7")

    private static volatile boolean mWaiting = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.727 -0500", hash_original_field = "520A398FA4C4E12ADD379869D282F423", hash_generated_field = "66B43CE3763349D2B54EA8982B2006D9")

    private static final int MIN_DEBUGGER_IDLE = 1300;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.730 -0500", hash_original_field = "D68D2F56E8C0A411BF8AFA44055885CE", hash_generated_field = "516CA5EC79C400FE6CEF4095D82B3B6E")

    /* how long to sleep when polling for activity */
    private static final int SPIN_DELAY = 200;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.732 -0500", hash_original_field = "B616B2E024183D9F4212464243987958", hash_generated_field = "8ACBCE355D8F2D7053823CC255609B69")

    /**
     * Default trace file path and file
     */
    private static final String DEFAULT_TRACE_PATH_PREFIX =
        Environment.getExternalStorageDirectory().getPath() + "/";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.734 -0500", hash_original_field = "A89671A2C0032C962BF2DD80513301CE", hash_generated_field = "30AB7EECF814DF81F2966E19E130C077")

    private static final String DEFAULT_TRACE_BODY = "dmtrace";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.736 -0500", hash_original_field = "4C8DD1BE4339589E47EF1280EE80DFD6", hash_generated_field = "ED4CA4EE9F56B6F19C6999554694B9A9")

    private static final String DEFAULT_TRACE_EXTENSION = ".trace";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.739 -0500", hash_original_field = "8103F37D22A7B17B6F86A2DE1B8BF880", hash_generated_field = "AB39124180A027611E9E95F06D056ADD")

    private static final String DEFAULT_TRACE_FILE_PATH =
        DEFAULT_TRACE_PATH_PREFIX + DEFAULT_TRACE_BODY
        + DEFAULT_TRACE_EXTENSION;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.821 -0500", hash_original_field = "073262F708A5E4B8B995B8CA7D840956", hash_generated_field = "C5F5DE18A5A9896FF8DDF8699243F549")

    private static final String SYSFS_QEMU_TRACE_STATE = "/sys/qemu_trace/state";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:43.027 -0500", hash_original_field = "A5E1AD84C801DE2CB73AEE636935CD48", hash_generated_field = "922B1BD051CFB951F0D00B5AB192FF0F")

    private static  TypedProperties debugProperties;

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:42.725 -0500", hash_original_method = "2057C70024BF253BE1820FDFE7216E44", hash_generated_method = "EDEB9D622E5FBF902147BB9B280ED1ED")
    
private Debug() {}
   /* static {
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
    */
}

