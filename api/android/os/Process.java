package android.os;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import android.net.LocalSocket;
import android.net.LocalSocketAddress;
import android.util.Log;
import dalvik.system.Zygote;




import droidsafe.helpers.DSUtils;

class ZygoteStartFailedEx extends Exception {
    /**
     * Something prevented the zygote process startup from happening normally
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:36.930 -0500", hash_original_method = "ED275066D7155C9928305EEFEFCB430D", hash_generated_method = "ED275066D7155C9928305EEFEFCB430D")
    ZygoteStartFailedEx() {}
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:36.931 -0500", hash_original_method = "7E7EBE30F413F048DFD1A8075A4667DF", hash_generated_method = "7E7EBE30F413F048DFD1A8075A4667DF")
    ZygoteStartFailedEx(String s) {super(s);}
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:36.932 -0500", hash_original_method = "52F849A7EB3457C94980CDA061114152", hash_generated_method = "52F849A7EB3457C94980CDA061114152")
    ZygoteStartFailedEx(Throwable cause) {super(cause);}

    
}

public class Process {

    /**
     * Start a new process.
     * 
     * <p>If processes are enabled, a new process is created and the
     * static main() function of a <var>processClass</var> is executed there.
     * The process will continue running after this function returns.
     * 
     * <p>If processes are not enabled, a new thread in the caller's
     * process is created and main() of <var>processClass</var> called there.
     * 
     * <p>The niceName parameter, if not an empty string, is a custom name to
     * give to the process instead of using processClass.  This allows you to
     * make easily identifyable processes even if you are using the same base
     * <var>processClass</var> to start them.
     * 
     * @param processClass The class to use as the process's main entry
     *                     point.
     * @param niceName A more readable name to use for the process.
     * @param uid The user-id under which the process will run.
     * @param gid The group-id under which the process will run.
     * @param gids Additional group-ids associated with the process.
     * @param debugFlags Additional flags.
     * @param targetSdkVersion The target SDK version for the app.
     * @param zygoteArgs Additional arguments to supply to the zygote process.
     * 
     * @return An object that describes the result of the attempt to start the process.
     * @throws RuntimeException on fatal start failure
     * 
     * {@hide}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:36.964 -0500", hash_original_method = "4AA3C7EB26254985E3ECDF70CE6C2F3C", hash_generated_method = "4E77B69C06025364E8D4D70AEF0F602C")
    public static final ProcessStartResult start(final String processClass,
                                  final String niceName,
                                  int uid, int gid, int[] gids,
                                  int debugFlags, int targetSdkVersion,
                                  String[] zygoteArgs) {
        try {
            return startViaZygote(processClass, niceName, uid, gid, gids,
                    debugFlags, targetSdkVersion, zygoteArgs);
        } catch (ZygoteStartFailedEx ex) {
            Log.e(LOG_TAG,
                    "Starting VM process through Zygote failed");
            throw new RuntimeException(
                    "Starting VM process through Zygote failed", ex);
        }
    }

    /**
     * Tries to open socket to Zygote process if not already open. If
     * already open, does nothing.  May block and retry.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:36.966 -0500", hash_original_method = "E2E38A09C125F42D0156C70D28A0D14A", hash_generated_method = "2B73A6BB9617147F2ACA4FA0B0C80426")
    private static void openZygoteSocketIfNeeded() 
            throws ZygoteStartFailedEx {

        int retryCount;

        if (sPreviousZygoteOpenFailed) {
            /*
             * If we've failed before, expect that we'll fail again and
             * don't pause for retries.
             */
            retryCount = 0;
        } else {
            retryCount = 10;            
        }

        /*
         * See bug #811181: Sometimes runtime can make it up before zygote.
         * Really, we'd like to do something better to avoid this condition,
         * but for now just wait a bit...
         */
        for (int retry = 0
                ; (sZygoteSocket == null) && (retry < (retryCount + 1))
                ; retry++ ) {

            if (retry > 0) {
                try {
                    Log.i("Zygote", "Zygote not up yet, sleeping...");
                    Thread.sleep(ZYGOTE_RETRY_MILLIS);
                } catch (InterruptedException ex) {
                    // should never happen
                }
            }

            try {
                sZygoteSocket = new LocalSocket();

                sZygoteSocket.connect(new LocalSocketAddress(ZYGOTE_SOCKET, 
                        LocalSocketAddress.Namespace.RESERVED));

                sZygoteInputStream
                        = new DataInputStream(sZygoteSocket.getInputStream());

                sZygoteWriter =
                    new BufferedWriter(
                            new OutputStreamWriter(
                                    sZygoteSocket.getOutputStream()),
                            256);

                Log.i("Zygote", "Process: zygote socket opened");

                sPreviousZygoteOpenFailed = false;
                break;
            } catch (IOException ex) {
                if (sZygoteSocket != null) {
                    try {
                        sZygoteSocket.close();
                    } catch (IOException ex2) {
                        Log.e(LOG_TAG,"I/O exception on close after exception",
                                ex2);
                    }
                }

                sZygoteSocket = null;
            }
        }

        if (sZygoteSocket == null) {
            sPreviousZygoteOpenFailed = true;
            throw new ZygoteStartFailedEx("connect failed");                 
        }
    }

    /**
     * Sends an argument list to the zygote process, which starts a new child
     * and returns the child's pid. Please note: the present implementation
     * replaces newlines in the argument list with spaces.
     * @param args argument list
     * @return An object that describes the result of the attempt to start the process.
     * @throws ZygoteStartFailedEx if process start failed for any reason
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:36.967 -0500", hash_original_method = "7515F8CCC6CE3690666F2F3E64F5CA86", hash_generated_method = "78C00479EB39A17F314FBD5CDA52E669")
    private static ProcessStartResult zygoteSendArgsAndGetResult(ArrayList<String> args)
            throws ZygoteStartFailedEx {
        openZygoteSocketIfNeeded();

        try {
            /**
             * See com.android.internal.os.ZygoteInit.readArgumentList()
             * Presently the wire format to the zygote process is:
             * a) a count of arguments (argc, in essence)
             * b) a number of newline-separated argument strings equal to count
             *
             * After the zygote process reads these it will write the pid of
             * the child or -1 on failure, followed by boolean to
             * indicate whether a wrapper process was used.
             */

            sZygoteWriter.write(Integer.toString(args.size()));
            sZygoteWriter.newLine();

            int sz = args.size();
            for (int i = 0; i < sz; i++) {
                String arg = args.get(i);
                if (arg.indexOf('\n') >= 0) {
                    throw new ZygoteStartFailedEx(
                            "embedded newlines not allowed");
                }
                sZygoteWriter.write(arg);
                sZygoteWriter.newLine();
            }

            sZygoteWriter.flush();

            // Should there be a timeout on this?
            ProcessStartResult result = new ProcessStartResult();
            result.pid = sZygoteInputStream.readInt();
            if (result.pid < 0) {
                throw new ZygoteStartFailedEx("fork() failed");
            }
            result.usingWrapper = sZygoteInputStream.readBoolean();
            return result;
        } catch (IOException ex) {
            try {
                if (sZygoteSocket != null) {
                    sZygoteSocket.close();
                }
            } catch (IOException ex2) {
                // we're going to fail anyway
                Log.e(LOG_TAG,"I/O exception on routine close", ex2);
            }

            sZygoteSocket = null;

            throw new ZygoteStartFailedEx(ex);
        }
    }

    /**
     * Starts a new process via the zygote mechanism.
     *
     * @param processClass Class name whose static main() to run
     * @param niceName 'nice' process name to appear in ps
     * @param uid a POSIX uid that the new process should setuid() to
     * @param gid a POSIX gid that the new process shuold setgid() to
     * @param gids null-ok; a list of supplementary group IDs that the
     * new process should setgroup() to.
     * @param debugFlags Additional flags.
     * @param targetSdkVersion The target SDK version for the app.
     * @param extraArgs Additional arguments to supply to the zygote process.
     * @return An object that describes the result of the attempt to start the process.
     * @throws ZygoteStartFailedEx if process start failed for any reason
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:36.968 -0500", hash_original_method = "2D9469DC3FABBA58CBEDE2838A0DC7C6", hash_generated_method = "86AA4E4B0A1D91ED4405B82C5DCEBB5E")
    private static ProcessStartResult startViaZygote(final String processClass,
                                  final String niceName,
                                  final int uid, final int gid,
                                  final int[] gids,
                                  int debugFlags, int targetSdkVersion,
                                  String[] extraArgs)
                                  throws ZygoteStartFailedEx {
        synchronized(Process.class) {
            ArrayList<String> argsForZygote = new ArrayList<String>();

            // --runtime-init, --setuid=, --setgid=,
            // and --setgroups= must go first
            argsForZygote.add("--runtime-init");
            argsForZygote.add("--setuid=" + uid);
            argsForZygote.add("--setgid=" + gid);
            if ((debugFlags & Zygote.DEBUG_ENABLE_JNI_LOGGING) != 0) {
                argsForZygote.add("--enable-jni-logging");
            }
            if ((debugFlags & Zygote.DEBUG_ENABLE_SAFEMODE) != 0) {
                argsForZygote.add("--enable-safemode");
            }
            if ((debugFlags & Zygote.DEBUG_ENABLE_DEBUGGER) != 0) {
                argsForZygote.add("--enable-debugger");
            }
            if ((debugFlags & Zygote.DEBUG_ENABLE_CHECKJNI) != 0) {
                argsForZygote.add("--enable-checkjni");
            }
            if ((debugFlags & Zygote.DEBUG_ENABLE_ASSERT) != 0) {
                argsForZygote.add("--enable-assert");
            }
            argsForZygote.add("--target-sdk-version=" + targetSdkVersion);

            //TODO optionally enable debuger
            //argsForZygote.add("--enable-debugger");

            // --setgroups is a comma-separated list
            if (gids != null && gids.length > 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("--setgroups=");

                int sz = gids.length;
                for (int i = 0; i < sz; i++) {
                    if (i != 0) {
                        sb.append(',');
                    }
                    sb.append(gids[i]);
                }

                argsForZygote.add(sb.toString());
            }

            if (niceName != null) {
                argsForZygote.add("--nice-name=" + niceName);
            }

            argsForZygote.add(processClass);

            if (extraArgs != null) {
                for (String arg : extraArgs) {
                    argsForZygote.add(arg);
                }
            }

            return zygoteSendArgsAndGetResult(argsForZygote);
        }
    }

    
    @DSModeled(DSC.SAFE)
    public static final long getElapsedCpuTime() {
        return DSUtils.UNKNOWN_LONG;
    }

    
    @DSModeled(DSC.SAFE)
    public static final int myPid() {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    public static final int myTid() {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    public static final int myUid() {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    public static final int getUidForName(String name) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    public static final int getGidForName(String name) {
        return DSUtils.UNKNOWN_INT;
    }

    /**
     * Returns a uid for a currently running process.
     * @param pid the process id
     * @return the uid of the process, or -1 if the process is not running.
     * @hide pending API council review
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:36.978 -0500", hash_original_method = "A691006F88AEA4507774968437E01D65", hash_generated_method = "1D834948E50C6304A9F5297E1BD004B1")
    public static final int getUidForPid(int pid) {
        String[] procStatusLabels = { "Uid:" };
        long[] procStatusValues = new long[1];
        procStatusValues[0] = -1;
        Process.readProcLines("/proc/" + pid + "/status", procStatusLabels, procStatusValues);
        return (int) procStatusValues[0];
    }

    /**
     * Returns the parent process id for a currently running process.
     * @param pid the process id
     * @return the parent process id of the process, or -1 if the process is not running.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:36.979 -0500", hash_original_method = "5F41D5D14D69DA24FB08A8EDFD9D9070", hash_generated_method = "17E923CA92E6DA398C7A912F8C6534F1")
    public static final int getParentPid(int pid) {
        String[] procStatusLabels = { "PPid:" };
        long[] procStatusValues = new long[1];
        procStatusValues[0] = -1;
        Process.readProcLines("/proc/" + pid + "/status", procStatusLabels, procStatusValues);
        return (int) procStatusValues[0];
    }

    
    @DSModeled(DSC.SAFE)
    public static final void setThreadPriority(int tid, int priority) throws IllegalArgumentException, SecurityException {
    }

    
    @DSModeled(DSC.SAFE)
    public static final void setCanSelfBackground(boolean backgroundOk) {
    }

    
    @DSModeled(DSC.SAFE)
    public static final void setThreadGroup(int tid, int group) throws IllegalArgumentException, SecurityException {
    }

    
    @DSModeled(DSC.SAFE)
    public static final void setProcessGroup(int pid, int group) throws IllegalArgumentException, SecurityException {
    }

    
    @DSModeled(DSC.SAFE)
    public static final void setThreadPriority(int priority) throws IllegalArgumentException, SecurityException {
    }

    
    @DSModeled(DSC.SAFE)
    public static final int getThreadPriority(int tid) throws IllegalArgumentException {
        return DSUtils.UNKNOWN_INT;
    }
    
    /**
     * Determine whether the current environment supports multiple processes.
     * 
     * @return Returns true if the system can run in multiple processes, else
     * false if everything is running in a single process.
     *
     * @deprecated This method always returns true.  Do not use.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:36.988 -0500", hash_original_method = "29DE357DDC3ECBFCF076FFF8D1A02781", hash_generated_method = "117666C7E7CB9254CE697D62B49826BD")
    @Deprecated
public static final boolean supportsProcesses() {
        return true;
    }

    
    @DSModeled(DSC.SAFE)
    public static final boolean setOomAdj(int pid, int amt) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSModeled(DSC.SAFE)
    public static final void setArgV0(String text) {
    }

    /**
     * Kill the process with the given PID.
     * Note that, though this API allows us to request to
     * kill any process based on its PID, the kernel will
     * still impose standard restrictions on which PIDs you
     * are actually able to kill.  Typically this means only
     * the process running the caller's packages/application
     * and any additional processes created by that app; packages
     * sharing a common UID will also be able to kill each
     * other's processes.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:36.992 -0500", hash_original_method = "342A9AA3E93050AFFE91B915061407DC", hash_generated_method = "945BFEB670E29B1B951461073CC2753C")
    public static final void killProcess(int pid) {
        sendSignal(pid, SIGNAL_KILL);
    }

    
    @DSModeled(DSC.SAFE)
    public static final int setUid(int uid) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    public static final int setGid(int uid) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    public static final void sendSignal(int pid, int signal) {
    }
    
    /**
     * @hide
     * Private impl for avoiding a log message...  DO NOT USE without doing
     * your own log, or the Android Illuminati will find you some night and
     * beat you up.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:36.997 -0500", hash_original_method = "736E8355B86175AB789790CB4398D59E", hash_generated_method = "18D3AF43ADF859931F8FD0C39DAD9326")
    public static final void killProcessQuiet(int pid) {
        sendSignalQuiet(pid, SIGNAL_KILL);
    }

    
    @DSModeled(DSC.SAFE)
    public static final void sendSignalQuiet(int pid, int signal) {
    }

    
    @DSModeled(DSC.SAFE)
    public static final long getFreeMemory() {
        return DSUtils.UNKNOWN_LONG;
    }

    
    @DSModeled(DSC.SAFE)
    public static final void readProcLines(String path,
            String[] reqFields, long[] outSizes) {
    }

    
    @DSModeled(DSC.SAFE)
    public static final int[] getPids(String path, int[] lastArray) {
        int[] ret = {DSUtils.UNKNOWN_INT};
        return ret;
    }

    
    @DSModeled(DSC.SAFE)
    public static final boolean readProcFile(String file, int[] format,
            String[] outStrings, long[] outLongs, float[] outFloats) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSModeled(DSC.SAFE)
    public static final boolean parseProcLine(byte[] buffer, int startIndex, 
            int endIndex, int[] format, String[] outStrings, long[] outLongs, float[] outFloats) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSModeled(DSC.SAFE)
    public static final long getPss(int pid) {
        return DSUtils.UNKNOWN_LONG;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:36.933 -0500", hash_original_field = "BC44B407F4C10F9EDAD581BF2B8CACF3", hash_generated_field = "5F9C7257A217587A990699F8AF46B2EF")

    private static final String LOG_TAG = "Process";

    
    public static final class ProcessStartResult {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:37.016 -0500", hash_original_field = "3D9A6B8E69012AA56F160CA7CCE3CF4F", hash_generated_field = "E33048D7FE0F6F6881E45039884DFF61")

        public int pid;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:37.017 -0500", hash_original_field = "E3AA526A2E6558A63C2E3B43DFFFBB52", hash_generated_field = "EE1C8A7FF5625676AED3193FF6839503")

        public boolean usingWrapper;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.394 -0400", hash_original_method = "50DF3C9BB6E8E9D5935D1DE367FC9E29", hash_generated_method = "50DF3C9BB6E8E9D5935D1DE367FC9E29")
        public ProcessStartResult ()
        {
            //Synthesized constructor
        }


    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:36.934 -0500", hash_original_field = "5F49BC332E084FB1C9E2AFC7AC214330", hash_generated_field = "CE66396F822D4FD2A7CF04726540D0D0")


    private static final String ZYGOTE_SOCKET = "zygote";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:36.935 -0500", hash_original_field = "89EBEBA9E79690E123389B59799D9B82", hash_generated_field = "210CABEAA190359A5716CF54A12A257E")

    public static final String ANDROID_SHARED_MEDIA = "com.android.process.media";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:36.935 -0500", hash_original_field = "8DA2519C752281A3AA1A7FC19C08A1F6", hash_generated_field = "8D0D450C8C0A1F4E60785466D6DDBCBB")

    public static final String GOOGLE_SHARED_APP_CONTENT = "com.google.process.content";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:36.936 -0500", hash_original_field = "C55763CC301960C405CD4BF23397DB76", hash_generated_field = "0BCB8FE40333A7C242C7068C2568D579")

    public static final int SYSTEM_UID = 1000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:36.937 -0500", hash_original_field = "D37993D793863024DC8CCAB025002BE9", hash_generated_field = "C2000A2AFA10AAC108E1D1EF47ECDD26")

    public static final int PHONE_UID = 1001;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:36.938 -0500", hash_original_field = "617EA9A404C2B8F9938076AF31DCC4DF", hash_generated_field = "9192E4F4C20E33B6ED29234E63C13F4C")

    public static final int SHELL_UID = 2000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:36.938 -0500", hash_original_field = "29E5906454EBA4052B41952DF912F205", hash_generated_field = "F98931DCB1108EB04B262D18551F68C8")

    public static final int LOG_UID = 1007;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:36.939 -0500", hash_original_field = "43317953BA72CEBDEAA31AF0AA61F336", hash_generated_field = "DB075A2C639C6595FBD1FC20C66F6EAB")

    public static final int WIFI_UID = 1010;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:36.941 -0500", hash_original_field = "AB118676EEF2F2B128843A699576C4D7", hash_generated_field = "F86B52F26B46A59652C46610F53ED347")

    public static final int MEDIA_UID = 1013;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:36.942 -0500", hash_original_field = "093220BDF6EFA48E0B44C9FACDF18740", hash_generated_field = "0E98BA96A205E251AC4475971B65641A")

    public static final int SDCARD_RW_GID = 1015;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:36.942 -0500", hash_original_field = "D930799EBC1E5C56615340E5050C739B", hash_generated_field = "36C7B566C6E2D6A4D713FE87F62825E7")

    public static final int NFC_UID = 1027;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:36.943 -0500", hash_original_field = "4799620E8E4515BFE09BAA16C1833232", hash_generated_field = "E63C4CDFBA0C801CD9F9A4645CEEDD70")

    public static final int MEDIA_RW_GID = 1023;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:36.944 -0500", hash_original_field = "D64C75D6E81DFF513D42EAB523A5A793", hash_generated_field = "F06CCFBE61AACA54692276AE45CEA5E8")

    public static final int FIRST_APPLICATION_UID = 10000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:36.945 -0500", hash_original_field = "2C4EFA98535690BEAC937D8590346F00", hash_generated_field = "D1FC8232B3FFF3799DF7D10667FD9453")

    public static final int LAST_APPLICATION_UID = 99999;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:36.946 -0500", hash_original_field = "C671E2442EF02F3D2561603A3A9A01C7", hash_generated_field = "FC56DFC804542B9109B470F8FF22F9C1")

    public static final int BLUETOOTH_GID = 2000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:36.947 -0500", hash_original_field = "4686CD1F32AE548DD86BE37123DC3D6B", hash_generated_field = "AE4B5F2A8A5ED425A6C52A8C766010A1")

    public static final int THREAD_PRIORITY_DEFAULT = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:35:15.306 -0500", hash_original_field = "4005FF6AD38E5EC97FF1B3CFCA590565", hash_generated_field = "A91B5DD2EC5D00C8F89F68C86374E239")

    
    /**
     * Lowest available thread priority.  Only for those who really, really
     * don't want to run if anything else is happening.
     * Use with {@link #setThreadPriority(int)} and
     * {@link #setThreadPriority(int, int)}, <b>not</b> with the normal
     * {@link java.lang.Thread} class.
     */
    public static final int THREAD_PRIORITY_LOWEST = 19;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:36.949 -0500", hash_original_field = "3A3ABEAABD8F13D4CAA780FFDEB00B80", hash_generated_field = "F1ED7F30B7D6251CB4F228142B06D619")

    public static final int THREAD_PRIORITY_BACKGROUND = 10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:36.950 -0500", hash_original_field = "CEFAD405C7F56CB33550E6D0E2ED9AEC", hash_generated_field = "7A8F7281CDE895782EB372443B768CA8")

    public static final int THREAD_PRIORITY_FOREGROUND = -2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:36.950 -0500", hash_original_field = "8B02E9DA5830686C4ED5D25053798D22", hash_generated_field = "845F3DD626F8F3A805BC6FFDBB9773ED")

    public static final int THREAD_PRIORITY_DISPLAY = -4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:36.951 -0500", hash_original_field = "7119B93FB6643CB1DA33E810DEEF00E3", hash_generated_field = "B11C63A888B235FFDF0027C6F6A38672")

    public static final int THREAD_PRIORITY_URGENT_DISPLAY = -8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:36.952 -0500", hash_original_field = "8401575186C4702763C84916D040C7C9", hash_generated_field = "4AFC5BAE868230B6E8A0F1E7658A13BE")

    public static final int THREAD_PRIORITY_AUDIO = -16;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:36.953 -0500", hash_original_field = "6249C434D39D1DCE84246C4AE5C7E253", hash_generated_field = "14CEF371E6C4282FE7FC6DF24C7986D6")

    public static final int THREAD_PRIORITY_URGENT_AUDIO = -19;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:36.954 -0500", hash_original_field = "E5C9AD2C6425B546E2D5F0DD3B531B8E", hash_generated_field = "22EE7FDE47E7D81DD2E0432FB17651D9")

    public static final int THREAD_PRIORITY_MORE_FAVORABLE = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:36.955 -0500", hash_original_field = "25CED66A1C4218FEDD0D4E3B43B4702F", hash_generated_field = "9D3F3F2F7653743AB57FBE0B26F7153E")

    public static final int THREAD_PRIORITY_LESS_FAVORABLE = +1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:36.956 -0500", hash_original_field = "D7747E1341A7027D3FAE4D7058D6236A", hash_generated_field = "33622E234EAC1BD96D864C62D819B159")

    public static final int THREAD_GROUP_DEFAULT = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:36.956 -0500", hash_original_field = "04FD26C23A9AC6FAA44212916848ACD4", hash_generated_field = "4A55E7CF5526E19A6F996AFFABE5398D")

    public static final int THREAD_GROUP_BG_NONINTERACTIVE = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:36.957 -0500", hash_original_field = "0D4633E06855012FAF5E84154D7FA529", hash_generated_field = "DA2F4ED72328A288FA84E9D7302844A4")

    public static final int THREAD_GROUP_FG_BOOST = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:36.958 -0500", hash_original_field = "22B0CAC921B7721A47ADE107E57354A7", hash_generated_field = "C51440743E6DDF10403B243D1ACF601D")


    public static final int SIGNAL_QUIT = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:36.959 -0500", hash_original_field = "4A182571ED67D09251F8928C4AF15F77", hash_generated_field = "741221352869D91C1AB404E572F62911")

    public static final int SIGNAL_KILL = 9;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:36.960 -0500", hash_original_field = "8DF484BFA31DEE56E5A8791FFF172656", hash_generated_field = "1F12064DDA8A7BA2066AB77DA2BA681F")

    public static final int SIGNAL_USR1 = 10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:36.960 -0500", hash_original_field = "E448F9D9CB2F80C6A426EAD760A86568", hash_generated_field = "AB09C6CAD8D12BE44F83E1BDDA5C3263")


    static LocalSocket sZygoteSocket;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:36.961 -0500", hash_original_field = "CB38541FAC4726A6F5ECE041FE2A9E24", hash_generated_field = "AB34448A875466B78D25B22E95B7A947")

    static DataInputStream sZygoteInputStream;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:36.962 -0500", hash_original_field = "673C19D4AB445A1A8092963B80AE52C4", hash_generated_field = "3011F241066D99A77515F1AC02D1DD21")

    static BufferedWriter sZygoteWriter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:36.963 -0500", hash_original_field = "4DCFF0CFEC8867DEAC4303FA1AA2162E", hash_generated_field = "58755555CE47A0A58677BD406C65FEED")

    static boolean sPreviousZygoteOpenFailed;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:36.965 -0500", hash_original_field = "4C3C49D75BEBEA2BFA9FFAD49D2AD0BA", hash_generated_field = "8FD8DC667743CF169343FB0338D63FA1")

    static final int ZYGOTE_RETRY_MILLIS = 500;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:37.003 -0500", hash_original_field = "C897C89330D691DBAFC29B4B4D5D2695", hash_generated_field = "2DDEB888EA80442A9CBEED6D8C91DFDD")

    public static final int PROC_TERM_MASK = 0xff;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:37.004 -0500", hash_original_field = "9420553A73B66DE703984C61285A6361", hash_generated_field = "7FED250C9597550A03B8923C3804D13E")

    public static final int PROC_ZERO_TERM = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:37.005 -0500", hash_original_field = "282CEF6581A3D02E40874A15A399D6E0", hash_generated_field = "1E9CD5BFAAFF25C0971667E387CEAA0E")

    public static final int PROC_SPACE_TERM = (int)' ';
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:37.006 -0500", hash_original_field = "A5346ECBCD1842EF0D981C8A4DF0347F", hash_generated_field = "A68201FE65C82A9394E9F4AAB232D7F0")

    public static final int PROC_TAB_TERM = (int)'\t';
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:37.007 -0500", hash_original_field = "F7608B0961A36ACFCD494E5FF932910A", hash_generated_field = "872619D17A3479C6CF559B3C12046C69")

    public static final int PROC_COMBINE = 0x100;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:37.008 -0500", hash_original_field = "0F750D8BED7BF0C4CCFA0FEFC2D04118", hash_generated_field = "1FE65E5D52898E3A8718DAFE2BDCBB0F")

    public static final int PROC_PARENS = 0x200;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:37.008 -0500", hash_original_field = "5BC38FE2F25A30719AB55C1CD3A523C8", hash_generated_field = "57C38802CF50DF0F0A350F41EEFF3215")

    public static final int PROC_OUT_STRING = 0x1000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:37.009 -0500", hash_original_field = "88DFE6634E5C227121F36ABF86A24D58", hash_generated_field = "509793E3AAFDE88C2657670890815C2D")

    public static final int PROC_OUT_LONG = 0x2000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:37.010 -0500", hash_original_field = "982ABA40C6B0C2E3B85D8E51CDF33734", hash_generated_field = "CD46C23BC8D66AD59D64F861EAD2FEBA")

    public static final int PROC_OUT_FLOAT = 0x4000;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.388 -0400", hash_original_method = "F1A8A517686D0631650544C6E6120854", hash_generated_method = "F1A8A517686D0631650544C6E6120854")
    public Process ()
    {
        //Synthesized constructor
    }
}

