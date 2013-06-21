package android.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.net.LocalSocketAddress;
import android.net.LocalSocket;
import android.util.Log;
import dalvik.system.Zygote;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

class ZygoteStartFailedEx extends Exception {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.113 -0400", hash_original_method = "ED275066D7155C9928305EEFEFCB430D", hash_generated_method = "A0C03F4A220FDB5103694A2C296AF519")
    @DSModeled(DSC.SAFE)
     ZygoteStartFailedEx() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.113 -0400", hash_original_method = "7E7EBE30F413F048DFD1A8075A4667DF", hash_generated_method = "7D00F7231C66E5E4E78091801B7FB061")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     ZygoteStartFailedEx(String s) {
        super(s);
        dsTaint.addTaint(s);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.113 -0400", hash_original_method = "52F849A7EB3457C94980CDA061114152", hash_generated_method = "B0852E69B4DE08E541123520593E5CE3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     ZygoteStartFailedEx(Throwable cause) {
        super(cause);
        dsTaint.addTaint(cause.dsTaint);
        // ---------- Original Method ----------
    }

    
}

public class Process {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.113 -0400", hash_original_method = "86A1594DC3DA916C52311729E4DF63F1", hash_generated_method = "86A1594DC3DA916C52311729E4DF63F1")
        public Process ()
    {
    }


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

    
        private static void openZygoteSocketIfNeeded() throws ZygoteStartFailedEx {
        int retryCount;
        if (sPreviousZygoteOpenFailed) {
            retryCount = 0;
        } else {
            retryCount = 10;            
        }
        for (int retry = 0
                ; (sZygoteSocket == null) && (retry < (retryCount + 1))
                ; retry++ ) {
            if (retry > 0) {
                try {
                    Log.i("Zygote", "Zygote not up yet, sleeping...");
                    Thread.sleep(ZYGOTE_RETRY_MILLIS);
                } catch (InterruptedException ex) {
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

    
        private static ProcessStartResult zygoteSendArgsAndGetResult(ArrayList<String> args) throws ZygoteStartFailedEx {
        openZygoteSocketIfNeeded();
        try {
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
                Log.e(LOG_TAG,"I/O exception on routine close", ex2);
            }
            sZygoteSocket = null;
            throw new ZygoteStartFailedEx(ex);
        }
    }

    
        private static ProcessStartResult startViaZygote(final String processClass,
                                  final String niceName,
                                  final int uid, final int gid,
                                  final int[] gids,
                                  int debugFlags, int targetSdkVersion,
                                  String[] extraArgs) throws ZygoteStartFailedEx {
        synchronized(Process.class) {
            ArrayList<String> argsForZygote = new ArrayList<String>();
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

    
        public static final long getElapsedCpuTime() {
        return DSUtils.UNKNOWN_LONG;
    }

    
        public static final int myPid() {
        return DSUtils.UNKNOWN_INT;
    }

    
        public static final int myTid() {
        return DSUtils.UNKNOWN_INT;
    }

    
        public static final int myUid() {
        return DSUtils.UNKNOWN_INT;
    }

    
        public static final int getUidForName(String name) {
        return DSUtils.UNKNOWN_INT;
    }

    
        public static final int getGidForName(String name) {
        return DSUtils.UNKNOWN_INT;
    }

    
        public static final int getUidForPid(int pid) {
        String[] procStatusLabels = { "Uid:" };
        long[] procStatusValues = new long[1];
        procStatusValues[0] = -1;
        Process.readProcLines("/proc/" + pid + "/status", procStatusLabels, procStatusValues);
        return (int) procStatusValues[0];
    }

    
        public static final int getParentPid(int pid) {
        String[] procStatusLabels = { "PPid:" };
        long[] procStatusValues = new long[1];
        procStatusValues[0] = -1;
        Process.readProcLines("/proc/" + pid + "/status", procStatusLabels, procStatusValues);
        return (int) procStatusValues[0];
    }

    
        public static final void setThreadPriority(int tid, int priority) throws IllegalArgumentException, SecurityException {
    }

    
        public static final void setCanSelfBackground(boolean backgroundOk) {
    }

    
        public static final void setThreadGroup(int tid, int group) throws IllegalArgumentException, SecurityException {
    }

    
        public static final void setProcessGroup(int pid, int group) throws IllegalArgumentException, SecurityException {
    }

    
        public static final void setThreadPriority(int priority) throws IllegalArgumentException, SecurityException {
    }

    
        public static final int getThreadPriority(int tid) throws IllegalArgumentException {
        return DSUtils.UNKNOWN_INT;
    }

    
        @Deprecated
    public static final boolean supportsProcesses() {
        return true;
    }

    
        public static final boolean setOomAdj(int pid, int amt) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        public static final void setArgV0(String text) {
    }

    
        public static final void killProcess(int pid) {
        sendSignal(pid, SIGNAL_KILL);
    }

    
        public static final int setUid(int uid) {
        return DSUtils.UNKNOWN_INT;
    }

    
        public static final int setGid(int uid) {
        return DSUtils.UNKNOWN_INT;
    }

    
        public static final void sendSignal(int pid, int signal) {
    }

    
        public static final void killProcessQuiet(int pid) {
        sendSignalQuiet(pid, SIGNAL_KILL);
    }

    
        public static final void sendSignalQuiet(int pid, int signal) {
    }

    
        public static final long getFreeMemory() {
        return DSUtils.UNKNOWN_LONG;
    }

    
        public static final void readProcLines(String path,
            String[] reqFields, long[] outSizes) {
    }

    
        public static final int[] getPids(String path, int[] lastArray) {
        int[] retVal = {DSUtils.UNKNOWN_INT};
        return retVal;
    }

    
        public static final boolean readProcFile(String file, int[] format,
            String[] outStrings, long[] outLongs, float[] outFloats) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        public static final boolean parseProcLine(byte[] buffer, int startIndex, 
            int endIndex, int[] format, String[] outStrings, long[] outLongs, float[] outFloats) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        public static final long getPss(int pid) {
        return DSUtils.UNKNOWN_LONG;
    }

    
    public static final class ProcessStartResult {
        public int pid;
        public boolean usingWrapper;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.125 -0400", hash_original_method = "CFD3980519C69B7F2D326782DDBF4AA9", hash_generated_method = "CFD3980519C69B7F2D326782DDBF4AA9")
                public ProcessStartResult ()
        {
        }


    }


    
    private static final String LOG_TAG = "Process";
    private static final String ZYGOTE_SOCKET = "zygote";
    public static final String ANDROID_SHARED_MEDIA = "com.android.process.media";
    public static final String GOOGLE_SHARED_APP_CONTENT = "com.google.process.content";
    public static final int SYSTEM_UID = 1000;
    public static final int PHONE_UID = 1001;
    public static final int SHELL_UID = 2000;
    public static final int LOG_UID = 1007;
    public static final int WIFI_UID = 1010;
    public static final int MEDIA_UID = 1013;
    public static final int SDCARD_RW_GID = 1015;
    public static final int NFC_UID = 1027;
    public static final int MEDIA_RW_GID = 1023;
    public static final int FIRST_APPLICATION_UID = 10000;
    public static final int LAST_APPLICATION_UID = 99999;
    public static final int BLUETOOTH_GID = 2000;
    public static final int THREAD_PRIORITY_DEFAULT = 0;
    public static final int THREAD_PRIORITY_LOWEST = 19;
    public static final int THREAD_PRIORITY_BACKGROUND = 10;
    public static final int THREAD_PRIORITY_FOREGROUND = -2;
    public static final int THREAD_PRIORITY_DISPLAY = -4;
    public static final int THREAD_PRIORITY_URGENT_DISPLAY = -8;
    public static final int THREAD_PRIORITY_AUDIO = -16;
    public static final int THREAD_PRIORITY_URGENT_AUDIO = -19;
    public static final int THREAD_PRIORITY_MORE_FAVORABLE = -1;
    public static final int THREAD_PRIORITY_LESS_FAVORABLE = +1;
    public static final int THREAD_GROUP_DEFAULT = 0;
    public static final int THREAD_GROUP_BG_NONINTERACTIVE = 1;
    public static final int THREAD_GROUP_FG_BOOST = 2;
    public static final int SIGNAL_QUIT = 3;
    public static final int SIGNAL_KILL = 9;
    public static final int SIGNAL_USR1 = 10;
    static LocalSocket sZygoteSocket;
    static DataInputStream sZygoteInputStream;
    static BufferedWriter sZygoteWriter;
    static boolean sPreviousZygoteOpenFailed;
    static final int ZYGOTE_RETRY_MILLIS = 500;
    public static final int PROC_TERM_MASK = 0xff;
    public static final int PROC_ZERO_TERM = 0;
    public static final int PROC_SPACE_TERM = (int)' ';
    public static final int PROC_TAB_TERM = (int)'\t';
    public static final int PROC_COMBINE = 0x100;
    public static final int PROC_PARENS = 0x200;
    public static final int PROC_OUT_STRING = 0x1000;
    public static final int PROC_OUT_LONG = 0x2000;
    public static final int PROC_OUT_FLOAT = 0x4000;
}

