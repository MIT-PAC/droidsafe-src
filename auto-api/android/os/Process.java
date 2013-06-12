package android.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.852 -0400", hash_original_method = "ED275066D7155C9928305EEFEFCB430D", hash_generated_method = "14C72D4D6EB570119D7626B68331B8C8")
    @DSModeled(DSC.SAFE)
     ZygoteStartFailedEx() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.852 -0400", hash_original_method = "7E7EBE30F413F048DFD1A8075A4667DF", hash_generated_method = "B0DC61FD472C6D0DBEC9FD83A130642B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     ZygoteStartFailedEx(String s) {
        super(s);
        dsTaint.addTaint(s);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.852 -0400", hash_original_method = "52F849A7EB3457C94980CDA061114152", hash_generated_method = "AAE4E9D71D4A8035C90658DFF2927A53")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     ZygoteStartFailedEx(Throwable cause) {
        super(cause);
        dsTaint.addTaint(cause.dsTaint);
        // ---------- Original Method ----------
    }

    
}

public class Process {
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.853 -0400", hash_original_method = "4AA3C7EB26254985E3ECDF70CE6C2F3C", hash_generated_method = "4E77B69C06025364E8D4D70AEF0F602C")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.853 -0400", hash_original_method = "E2E38A09C125F42D0156C70D28A0D14A", hash_generated_method = "0C01BC69D14CD49657A02B17114F54F0")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.853 -0400", hash_original_method = "7515F8CCC6CE3690666F2F3E64F5CA86", hash_generated_method = "EB8EED19EEC7BE3C81AF3ED6FDF90E88")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.853 -0400", hash_original_method = "2D9469DC3FABBA58CBEDE2838A0DC7C6", hash_generated_method = "7DBF3C93175D67D62ED89487832BABFD")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.854 -0400", hash_original_method = "CEE6071D68056F0B725E484D5FE99172", hash_generated_method = "4AE59F3AE4F81DF8F9780741622513B0")
    public static final long getElapsedCpuTime() {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.854 -0400", hash_original_method = "AD455CCE7F88D6AA50D2B9DAD59460C9", hash_generated_method = "AA005B45128EAC3316FC8C8D00F6ACB0")
    public static final int myPid() {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.854 -0400", hash_original_method = "0BFDB88347ED9BF0DF8DF2432B4A6FE5", hash_generated_method = "BAC2AECBDD06CFE8A6F8677876C62DFB")
    public static final int myTid() {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.854 -0400", hash_original_method = "00BAC2627DB531B17A916DEFD657BA95", hash_generated_method = "DDF1701FA41D48EF2051CC00891F4AE9")
    public static final int myUid() {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.854 -0400", hash_original_method = "A406B5D4ABF380F858D4C46E75712D9C", hash_generated_method = "4D944E1A9F06AB6F53356493EC92C74F")
    public static final int getUidForName(String name) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.854 -0400", hash_original_method = "13B7164A3C39A07B433F66626FCA8AE8", hash_generated_method = "B4263982879B788C3AC4A2727A9AC352")
    public static final int getGidForName(String name) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.854 -0400", hash_original_method = "A691006F88AEA4507774968437E01D65", hash_generated_method = "1D834948E50C6304A9F5297E1BD004B1")
    public static final int getUidForPid(int pid) {
        String[] procStatusLabels = { "Uid:" };
        long[] procStatusValues = new long[1];
        procStatusValues[0] = -1;
        Process.readProcLines("/proc/" + pid + "/status", procStatusLabels, procStatusValues);
        return (int) procStatusValues[0];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.854 -0400", hash_original_method = "5F41D5D14D69DA24FB08A8EDFD9D9070", hash_generated_method = "17E923CA92E6DA398C7A912F8C6534F1")
    public static final int getParentPid(int pid) {
        String[] procStatusLabels = { "PPid:" };
        long[] procStatusValues = new long[1];
        procStatusValues[0] = -1;
        Process.readProcLines("/proc/" + pid + "/status", procStatusLabels, procStatusValues);
        return (int) procStatusValues[0];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.854 -0400", hash_original_method = "1895E211602934D8A363F5A4DF9C4D3F", hash_generated_method = "D93FEF75E32216B37F2FD5CC7B828681")
    public static final void setThreadPriority(int tid, int priority) throws IllegalArgumentException, SecurityException {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.854 -0400", hash_original_method = "2DB3EE4E750E16B75134E7AEBD52539A", hash_generated_method = "9B8DCDC522427096F46E6894E07A97AD")
    public static final void setCanSelfBackground(boolean backgroundOk) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.854 -0400", hash_original_method = "E5AD1B668CF304D6EFDC726144E0D53B", hash_generated_method = "F79D1343FB212DC987F313917FCE06BA")
    public static final void setThreadGroup(int tid, int group) throws IllegalArgumentException, SecurityException {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.855 -0400", hash_original_method = "AB114759114670C26D7B5041D2B949AC", hash_generated_method = "D5133655FC61070C8C4AF8EC72B07518")
    public static final void setProcessGroup(int pid, int group) throws IllegalArgumentException, SecurityException {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.855 -0400", hash_original_method = "2645E62A800DACE527BD8232ED66BE07", hash_generated_method = "F1C67F9F99D09CE250298B851305129C")
    public static final void setThreadPriority(int priority) throws IllegalArgumentException, SecurityException {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.855 -0400", hash_original_method = "EA144F391BD0376EBDCF9DB6A389210D", hash_generated_method = "753FBCF141B6447D8E24159682886C6C")
    public static final int getThreadPriority(int tid) throws IllegalArgumentException {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.855 -0400", hash_original_method = "29DE357DDC3ECBFCF076FFF8D1A02781", hash_generated_method = "117666C7E7CB9254CE697D62B49826BD")
    @Deprecated
    public static final boolean supportsProcesses() {
        return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.855 -0400", hash_original_method = "CCA372824D08007C1E8D9E302949111F", hash_generated_method = "62751626E38B7A0E771297F46725E121")
    public static final boolean setOomAdj(int pid, int amt) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.855 -0400", hash_original_method = "79096B15C92FB59ED87F205A484291C8", hash_generated_method = "0268FFFB562854757B19130E87D221CF")
    public static final void setArgV0(String text) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.855 -0400", hash_original_method = "342A9AA3E93050AFFE91B915061407DC", hash_generated_method = "945BFEB670E29B1B951461073CC2753C")
    public static final void killProcess(int pid) {
        sendSignal(pid, SIGNAL_KILL);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.855 -0400", hash_original_method = "30DB710E31AC7C3BD3B60CE5060C0C92", hash_generated_method = "5D2D0E5B1D26E771D084215C5A120AC5")
    public static final int setUid(int uid) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.855 -0400", hash_original_method = "BB2438A196D337FDD35C5AE61BEBBF2C", hash_generated_method = "CB0BA1E733E795A47960F73F6098BC3A")
    public static final int setGid(int uid) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.855 -0400", hash_original_method = "4846135012451C6C9499BC5E93E6A64E", hash_generated_method = "74D1039202670A1668A2B72F05FCAAE4")
    public static final void sendSignal(int pid, int signal) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.856 -0400", hash_original_method = "736E8355B86175AB789790CB4398D59E", hash_generated_method = "18D3AF43ADF859931F8FD0C39DAD9326")
    public static final void killProcessQuiet(int pid) {
        sendSignalQuiet(pid, SIGNAL_KILL);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.856 -0400", hash_original_method = "391F2BE949F2707277746CC0002BBECD", hash_generated_method = "3C491CDDA80CCCAA7598FAF845C511FE")
    public static final void sendSignalQuiet(int pid, int signal) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.856 -0400", hash_original_method = "EF3F53B96DC56DF449BB487CD0B668D9", hash_generated_method = "89FB652DCE85A8771C3BE8A8EDEDBCFC")
    public static final long getFreeMemory() {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.856 -0400", hash_original_method = "152C7E9C59466430E1A3586CF992A482", hash_generated_method = "59BAE5C3C63D9EA355DF716E7FF38672")
    public static final void readProcLines(String path,
            String[] reqFields, long[] outSizes) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.856 -0400", hash_original_method = "D32AC2A05BD186E5574DAD7A1C921BAE", hash_generated_method = "1721A3F09B53B1B3D70DC69339A90CD8")
    public static final int[] getPids(String path, int[] lastArray) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.856 -0400", hash_original_method = "72B6D15697BE6A390DB19667A7983DAA", hash_generated_method = "86762A94D17C4DEAEE6F29C4A96B1C74")
    public static final boolean readProcFile(String file, int[] format,
            String[] outStrings, long[] outLongs, float[] outFloats) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.856 -0400", hash_original_method = "DFBE21D3048FB3704E751B6190459FD5", hash_generated_method = "C24CF3F6C23A618CE4FE274AB8D9549E")
    public static final boolean parseProcLine(byte[] buffer, int startIndex, 
            int endIndex, int[] format, String[] outStrings, long[] outLongs, float[] outFloats) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.856 -0400", hash_original_method = "5A818DFA3CA28F77EA60F22C62046F1B", hash_generated_method = "7A609847DD8228A5FC6E553920F7BE09")
    public static final long getPss(int pid) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    public static final class ProcessStartResult {
        public int pid;
        public boolean usingWrapper;
        
    }


    
}


