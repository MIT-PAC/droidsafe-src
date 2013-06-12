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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.711 -0400", hash_original_method = "ED275066D7155C9928305EEFEFCB430D", hash_generated_method = "14C72D4D6EB570119D7626B68331B8C8")
    @DSModeled(DSC.SAFE)
     ZygoteStartFailedEx() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.711 -0400", hash_original_method = "7E7EBE30F413F048DFD1A8075A4667DF", hash_generated_method = "B0DC61FD472C6D0DBEC9FD83A130642B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     ZygoteStartFailedEx(String s) {
        super(s);
        dsTaint.addTaint(s);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.711 -0400", hash_original_method = "52F849A7EB3457C94980CDA061114152", hash_generated_method = "AAE4E9D71D4A8035C90658DFF2927A53")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     ZygoteStartFailedEx(Throwable cause) {
        super(cause);
        dsTaint.addTaint(cause.dsTaint);
        // ---------- Original Method ----------
    }

    
}

public class Process {
    private static String LOG_TAG = "Process";
    private static String ZYGOTE_SOCKET = "zygote";
    public static String ANDROID_SHARED_MEDIA = "com.android.process.media";
    public static String GOOGLE_SHARED_APP_CONTENT = "com.google.process.content";
    public static int SYSTEM_UID = 1000;
    public static int PHONE_UID = 1001;
    public static int SHELL_UID = 2000;
    public static int LOG_UID = 1007;
    public static int WIFI_UID = 1010;
    public static int MEDIA_UID = 1013;
    public static int SDCARD_RW_GID = 1015;
    public static int NFC_UID = 1027;
    public static int MEDIA_RW_GID = 1023;
    public static int FIRST_APPLICATION_UID = 10000;
    public static int LAST_APPLICATION_UID = 99999;
    public static int BLUETOOTH_GID = 2000;
    public static int THREAD_PRIORITY_DEFAULT = 0;
    public static int THREAD_PRIORITY_LOWEST = 19;
    public static int THREAD_PRIORITY_BACKGROUND = 10;
    public static int THREAD_PRIORITY_FOREGROUND = -2;
    public static int THREAD_PRIORITY_DISPLAY = -4;
    public static int THREAD_PRIORITY_URGENT_DISPLAY = -8;
    public static int THREAD_PRIORITY_AUDIO = -16;
    public static int THREAD_PRIORITY_URGENT_AUDIO = -19;
    public static int THREAD_PRIORITY_MORE_FAVORABLE = -1;
    public static int THREAD_PRIORITY_LESS_FAVORABLE = +1;
    public static int THREAD_GROUP_DEFAULT = 0;
    public static int THREAD_GROUP_BG_NONINTERACTIVE = 1;
    public static int THREAD_GROUP_FG_BOOST = 2;
    public static int SIGNAL_QUIT = 3;
    public static int SIGNAL_KILL = 9;
    public static int SIGNAL_USR1 = 10;
    static LocalSocket sZygoteSocket;
    static DataInputStream sZygoteInputStream;
    static BufferedWriter sZygoteWriter;
    static boolean sPreviousZygoteOpenFailed;
    static int ZYGOTE_RETRY_MILLIS = 500;
    public static int PROC_TERM_MASK = 0xff;
    public static int PROC_ZERO_TERM = 0;
    public static int PROC_SPACE_TERM = (int)' ';
    public static int PROC_TAB_TERM = (int)'\t';
    public static int PROC_COMBINE = 0x100;
    public static int PROC_PARENS = 0x200;
    public static int PROC_OUT_STRING = 0x1000;
    public static int PROC_OUT_LONG = 0x2000;
    public static int PROC_OUT_FLOAT = 0x4000;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.711 -0400", hash_original_method = "4AA3C7EB26254985E3ECDF70CE6C2F3C", hash_generated_method = "4E77B69C06025364E8D4D70AEF0F602C")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.711 -0400", hash_original_method = "E2E38A09C125F42D0156C70D28A0D14A", hash_generated_method = "0C01BC69D14CD49657A02B17114F54F0")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.712 -0400", hash_original_method = "7515F8CCC6CE3690666F2F3E64F5CA86", hash_generated_method = "EB8EED19EEC7BE3C81AF3ED6FDF90E88")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.712 -0400", hash_original_method = "2D9469DC3FABBA58CBEDE2838A0DC7C6", hash_generated_method = "7DBF3C93175D67D62ED89487832BABFD")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.714 -0400", hash_original_method = "CEE6071D68056F0B725E484D5FE99172", hash_generated_method = "17C7DA2C3621B17DB842605A43A180CC")
    public static final long getElapsedCpuTime() {
        return DSUtils.UNKNOWN_LONG;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.714 -0400", hash_original_method = "AD455CCE7F88D6AA50D2B9DAD59460C9", hash_generated_method = "31FA1D7798DECC6704BFD54A1527CB28")
    public static final int myPid() {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.714 -0400", hash_original_method = "0BFDB88347ED9BF0DF8DF2432B4A6FE5", hash_generated_method = "295D62A3B07B6BD4B4ED9170913CF074")
    public static final int myTid() {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.714 -0400", hash_original_method = "00BAC2627DB531B17A916DEFD657BA95", hash_generated_method = "DBF34DBB3F522D0814FBF8A312634747")
    public static final int myUid() {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.714 -0400", hash_original_method = "A406B5D4ABF380F858D4C46E75712D9C", hash_generated_method = "AF29363A2BD5B2C5A7E22694F84E5DBA")
    public static final int getUidForName(String name) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.714 -0400", hash_original_method = "13B7164A3C39A07B433F66626FCA8AE8", hash_generated_method = "EE586CACEAFF674C2467B5384559E81D")
    public static final int getGidForName(String name) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.714 -0400", hash_original_method = "A691006F88AEA4507774968437E01D65", hash_generated_method = "1D834948E50C6304A9F5297E1BD004B1")
    public static final int getUidForPid(int pid) {
        String[] procStatusLabels = { "Uid:" };
        long[] procStatusValues = new long[1];
        procStatusValues[0] = -1;
        Process.readProcLines("/proc/" + pid + "/status", procStatusLabels, procStatusValues);
        return (int) procStatusValues[0];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.714 -0400", hash_original_method = "5F41D5D14D69DA24FB08A8EDFD9D9070", hash_generated_method = "17E923CA92E6DA398C7A912F8C6534F1")
    public static final int getParentPid(int pid) {
        String[] procStatusLabels = { "PPid:" };
        long[] procStatusValues = new long[1];
        procStatusValues[0] = -1;
        Process.readProcLines("/proc/" + pid + "/status", procStatusLabels, procStatusValues);
        return (int) procStatusValues[0];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.714 -0400", hash_original_method = "1895E211602934D8A363F5A4DF9C4D3F", hash_generated_method = "B97D6EFF382B49AA09570D00EC02BF0F")
    public static final void setThreadPriority(int tid, int priority) throws IllegalArgumentException, SecurityException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.714 -0400", hash_original_method = "2DB3EE4E750E16B75134E7AEBD52539A", hash_generated_method = "4E17DFBC7EA39C9384B3F247D3600A49")
    public static final void setCanSelfBackground(boolean backgroundOk) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.720 -0400", hash_original_method = "E5AD1B668CF304D6EFDC726144E0D53B", hash_generated_method = "472296C054920538DB70054FC1C8597E")
    public static final void setThreadGroup(int tid, int group) throws IllegalArgumentException, SecurityException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.720 -0400", hash_original_method = "AB114759114670C26D7B5041D2B949AC", hash_generated_method = "7FA774E935D757366D840C2F9E738B7C")
    public static final void setProcessGroup(int pid, int group) throws IllegalArgumentException, SecurityException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.720 -0400", hash_original_method = "2645E62A800DACE527BD8232ED66BE07", hash_generated_method = "DD6EA584738D62C5AFAAC75E11B83337")
    public static final void setThreadPriority(int priority) throws IllegalArgumentException, SecurityException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.721 -0400", hash_original_method = "EA144F391BD0376EBDCF9DB6A389210D", hash_generated_method = "8AD3346CAE9613BFA00C63CDE4602256")
    public static final int getThreadPriority(int tid) throws IllegalArgumentException {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.722 -0400", hash_original_method = "29DE357DDC3ECBFCF076FFF8D1A02781", hash_generated_method = "117666C7E7CB9254CE697D62B49826BD")
    @Deprecated
    public static final boolean supportsProcesses() {
        return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.722 -0400", hash_original_method = "CCA372824D08007C1E8D9E302949111F", hash_generated_method = "535F9BE5807DF5C511FF6DE658263320")
    public static final boolean setOomAdj(int pid, int amt) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.722 -0400", hash_original_method = "79096B15C92FB59ED87F205A484291C8", hash_generated_method = "51D35B6359BFD2987ABD76C24458F5A9")
    public static final void setArgV0(String text) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.723 -0400", hash_original_method = "342A9AA3E93050AFFE91B915061407DC", hash_generated_method = "945BFEB670E29B1B951461073CC2753C")
    public static final void killProcess(int pid) {
        sendSignal(pid, SIGNAL_KILL);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.723 -0400", hash_original_method = "30DB710E31AC7C3BD3B60CE5060C0C92", hash_generated_method = "563FB6F5A30A496CFA1F782B15ADA35F")
    public static final int setUid(int uid) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.723 -0400", hash_original_method = "BB2438A196D337FDD35C5AE61BEBBF2C", hash_generated_method = "41626B0793BEF1E44B8D3D86DBF4302A")
    public static final int setGid(int uid) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.723 -0400", hash_original_method = "4846135012451C6C9499BC5E93E6A64E", hash_generated_method = "D1A4EBE0AAD896E71BB77876289D6A74")
    public static final void sendSignal(int pid, int signal) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.723 -0400", hash_original_method = "736E8355B86175AB789790CB4398D59E", hash_generated_method = "18D3AF43ADF859931F8FD0C39DAD9326")
    public static final void killProcessQuiet(int pid) {
        sendSignalQuiet(pid, SIGNAL_KILL);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.723 -0400", hash_original_method = "391F2BE949F2707277746CC0002BBECD", hash_generated_method = "D9743A5DDB85050851A8442339B09D0E")
    public static final void sendSignalQuiet(int pid, int signal) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.724 -0400", hash_original_method = "EF3F53B96DC56DF449BB487CD0B668D9", hash_generated_method = "66CA411112F9A8F94626BCF6D1500B0B")
    public static final long getFreeMemory() {
        return DSUtils.UNKNOWN_LONG;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.724 -0400", hash_original_method = "152C7E9C59466430E1A3586CF992A482", hash_generated_method = "C4EE4F2F2156E46ECE48909BC80467F0")
    public static final void readProcLines(String path,
            String[] reqFields, long[] outSizes) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.724 -0400", hash_original_method = "D32AC2A05BD186E5574DAD7A1C921BAE", hash_generated_method = "BD7AB97E988BF5B9034E5D11B51E1A44")
    public static final int[] getPids(String path, int[] lastArray) {
        int[] retVal = {DSUtils.UNKNOWN_INT};
        return retVal;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.724 -0400", hash_original_method = "72B6D15697BE6A390DB19667A7983DAA", hash_generated_method = "B0DFFD427EA81499105646EA94F1B189")
    public static final boolean readProcFile(String file, int[] format,
            String[] outStrings, long[] outLongs, float[] outFloats) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.724 -0400", hash_original_method = "DFBE21D3048FB3704E751B6190459FD5", hash_generated_method = "8BF565B05967C1DE72AF2100C675CCC6")
    public static final boolean parseProcLine(byte[] buffer, int startIndex, 
            int endIndex, int[] format, String[] outStrings, long[] outLongs, float[] outFloats) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.724 -0400", hash_original_method = "5A818DFA3CA28F77EA60F22C62046F1B", hash_generated_method = "3703E5E891DC6CF40E11CF1314DF50FD")
    public static final long getPss(int pid) {
        return DSUtils.UNKNOWN_LONG;
    }

    
    public static final class ProcessStartResult {
        public int pid;
        public boolean usingWrapper;
        
    }


    
}


