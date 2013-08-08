package android.os;

// Droidsafe Imports
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.386 -0400", hash_original_method = "ED275066D7155C9928305EEFEFCB430D", hash_generated_method = "A0C03F4A220FDB5103694A2C296AF519")
      ZygoteStartFailedEx() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.386 -0400", hash_original_method = "7E7EBE30F413F048DFD1A8075A4667DF", hash_generated_method = "D2E075FAB1441950FAF06CFA4C0B4BCA")
      ZygoteStartFailedEx(String s) {
        super(s);
        addTaint(s.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.386 -0400", hash_original_method = "52F849A7EB3457C94980CDA061114152", hash_generated_method = "D4E057DC25CF18ECE15AA57626B5BC22")
      ZygoteStartFailedEx(Throwable cause) {
        super(cause);
        addTaint(cause.getTaint());
        // ---------- Original Method ----------
    }

    
}

public class Process {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.388 -0400", hash_original_method = "F1A8A517686D0631650544C6E6120854", hash_generated_method = "F1A8A517686D0631650544C6E6120854")
    public Process ()
    {
        //Synthesized constructor
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

    
    @DSModeled(DSC.BAN)
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

    
    @DSModeled(DSC.BAN)
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

    
    @DSModeled(DSC.BAN)
    public static final int getUidForPid(int pid) {
        String[] procStatusLabels = { "Uid:" };
        long[] procStatusValues = new long[1];
        procStatusValues[0] = -1;
        Process.readProcLines("/proc/" + pid + "/status", procStatusLabels, procStatusValues);
        return (int) procStatusValues[0];
    }

    
    @DSModeled(DSC.BAN)
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SPEC)
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

    
    @DSModeled(DSC.BAN)
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

    
    public static final class ProcessStartResult {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.393 -0400", hash_original_field = "0DB3209E1ADC6D67BE435A81BAF9A66E", hash_generated_field = "E33048D7FE0F6F6881E45039884DFF61")

        public int pid;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.394 -0400", hash_original_field = "7787C03B286270AAB1DF7A0F9B8D7E25", hash_generated_field = "EE1C8A7FF5625676AED3193FF6839503")

        public boolean usingWrapper;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.394 -0400", hash_original_method = "50DF3C9BB6E8E9D5935D1DE367FC9E29", hash_generated_method = "50DF3C9BB6E8E9D5935D1DE367FC9E29")
        public ProcessStartResult ()
        {
            //Synthesized constructor
        }


    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.394 -0400", hash_original_field = "7BA6DE7783A56ED82942C634D0A98179", hash_generated_field = "5F9C7257A217587A990699F8AF46B2EF")

    private static final String LOG_TAG = "Process";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.394 -0400", hash_original_field = "0804BB672B2C8C06B322AEE7C199BE03", hash_generated_field = "CE66396F822D4FD2A7CF04726540D0D0")

    private static final String ZYGOTE_SOCKET = "zygote";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.394 -0400", hash_original_field = "C633615AE04B4E41351F08ED43886ACA", hash_generated_field = "210CABEAA190359A5716CF54A12A257E")

    public static final String ANDROID_SHARED_MEDIA = "com.android.process.media";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.394 -0400", hash_original_field = "3CE6748BB15518F71AEE59105AD0D137", hash_generated_field = "8D0D450C8C0A1F4E60785466D6DDBCBB")

    public static final String GOOGLE_SHARED_APP_CONTENT = "com.google.process.content";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.394 -0400", hash_original_field = "17E468E11E78C439413E2E76B0203D7F", hash_generated_field = "0BCB8FE40333A7C242C7068C2568D579")

    public static final int SYSTEM_UID = 1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.394 -0400", hash_original_field = "F7F5315AFB54C00A62D6E8C7A44E97B7", hash_generated_field = "C2000A2AFA10AAC108E1D1EF47ECDD26")

    public static final int PHONE_UID = 1001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.394 -0400", hash_original_field = "893107F80B509DD23B76302B06416903", hash_generated_field = "9192E4F4C20E33B6ED29234E63C13F4C")

    public static final int SHELL_UID = 2000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.394 -0400", hash_original_field = "AF527D877A7D843FA6AD125F02F4B1F8", hash_generated_field = "F98931DCB1108EB04B262D18551F68C8")

    public static final int LOG_UID = 1007;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.394 -0400", hash_original_field = "15C153F53091081280F014A29F867892", hash_generated_field = "DB075A2C639C6595FBD1FC20C66F6EAB")

    public static final int WIFI_UID = 1010;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.394 -0400", hash_original_field = "DBE29F9AD01572B1853F547D298A5F6E", hash_generated_field = "F86B52F26B46A59652C46610F53ED347")

    public static final int MEDIA_UID = 1013;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.394 -0400", hash_original_field = "0B9508D55E352FF946AEA2AAA83CE477", hash_generated_field = "0E98BA96A205E251AC4475971B65641A")

    public static final int SDCARD_RW_GID = 1015;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.394 -0400", hash_original_field = "6EF2153CC277CF89F64C4842FCB249F8", hash_generated_field = "36C7B566C6E2D6A4D713FE87F62825E7")

    public static final int NFC_UID = 1027;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.394 -0400", hash_original_field = "90C7B8DE66E3667D204164F279012821", hash_generated_field = "E63C4CDFBA0C801CD9F9A4645CEEDD70")

    public static final int MEDIA_RW_GID = 1023;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.394 -0400", hash_original_field = "EBE1C4B88A68710CDABD56427ECD9149", hash_generated_field = "F06CCFBE61AACA54692276AE45CEA5E8")

    public static final int FIRST_APPLICATION_UID = 10000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.394 -0400", hash_original_field = "1BDC226379051155E3CCD594B66110A0", hash_generated_field = "D1FC8232B3FFF3799DF7D10667FD9453")

    public static final int LAST_APPLICATION_UID = 99999;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.394 -0400", hash_original_field = "F929231D4C930E59E73E23E3CCAB1ABB", hash_generated_field = "FC56DFC804542B9109B470F8FF22F9C1")

    public static final int BLUETOOTH_GID = 2000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.394 -0400", hash_original_field = "F3A68B8123F78345BB681CC873EAA3B2", hash_generated_field = "AE4B5F2A8A5ED425A6C52A8C766010A1")

    public static final int THREAD_PRIORITY_DEFAULT = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.394 -0400", hash_original_field = "4DF902E152A205809EB5A7E64E5BDE33", hash_generated_field = "DF49804F8F4384435F626E9B961E7E04")

    public static final int THREAD_PRIORITY_LOWEST = 19;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.394 -0400", hash_original_field = "C7E9A0F79A74C8558C5BD4E73DF1A406", hash_generated_field = "F1ED7F30B7D6251CB4F228142B06D619")

    public static final int THREAD_PRIORITY_BACKGROUND = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.394 -0400", hash_original_field = "80D770C8870D3CE6D83E55A890E5D751", hash_generated_field = "7A8F7281CDE895782EB372443B768CA8")

    public static final int THREAD_PRIORITY_FOREGROUND = -2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.394 -0400", hash_original_field = "75F6E516E469959AAD015EFBB47D3560", hash_generated_field = "845F3DD626F8F3A805BC6FFDBB9773ED")

    public static final int THREAD_PRIORITY_DISPLAY = -4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.394 -0400", hash_original_field = "872AE3A99A7B36DACDAF3711A20FDFBB", hash_generated_field = "B11C63A888B235FFDF0027C6F6A38672")

    public static final int THREAD_PRIORITY_URGENT_DISPLAY = -8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.394 -0400", hash_original_field = "81EA0CABAC6A0B98860F55B22E122E8C", hash_generated_field = "4AFC5BAE868230B6E8A0F1E7658A13BE")

    public static final int THREAD_PRIORITY_AUDIO = -16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.394 -0400", hash_original_field = "93699AD0AE8BDD72C32E8A1295C15955", hash_generated_field = "14CEF371E6C4282FE7FC6DF24C7986D6")

    public static final int THREAD_PRIORITY_URGENT_AUDIO = -19;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.394 -0400", hash_original_field = "BCE039F5B3A9BB7C2215DF24B45C0E4D", hash_generated_field = "22EE7FDE47E7D81DD2E0432FB17651D9")

    public static final int THREAD_PRIORITY_MORE_FAVORABLE = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.394 -0400", hash_original_field = "6B6B98290EFF28D61F4EECF48A845C63", hash_generated_field = "9D3F3F2F7653743AB57FBE0B26F7153E")

    public static final int THREAD_PRIORITY_LESS_FAVORABLE = +1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.394 -0400", hash_original_field = "778899C9500D46E94203AF1CFA582D50", hash_generated_field = "33622E234EAC1BD96D864C62D819B159")

    public static final int THREAD_GROUP_DEFAULT = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.394 -0400", hash_original_field = "89FFFAAED7841ABFFCEB65F6160A9AE3", hash_generated_field = "4A55E7CF5526E19A6F996AFFABE5398D")

    public static final int THREAD_GROUP_BG_NONINTERACTIVE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.395 -0400", hash_original_field = "EAC76F22793578D3C387DA167C655300", hash_generated_field = "DA2F4ED72328A288FA84E9D7302844A4")

    public static final int THREAD_GROUP_FG_BOOST = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.395 -0400", hash_original_field = "0EEE92B7FA67EB9F979289AD609560F9", hash_generated_field = "C51440743E6DDF10403B243D1ACF601D")

    public static final int SIGNAL_QUIT = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.395 -0400", hash_original_field = "46654B8319D048B0662DB67C91C4ABDD", hash_generated_field = "741221352869D91C1AB404E572F62911")

    public static final int SIGNAL_KILL = 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.395 -0400", hash_original_field = "3EA338F8AE00B3E89BA238F4F887DBD6", hash_generated_field = "1F12064DDA8A7BA2066AB77DA2BA681F")

    public static final int SIGNAL_USR1 = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.395 -0400", hash_original_field = "4A83F67D245E6B82060E8947312BF557", hash_generated_field = "AB09C6CAD8D12BE44F83E1BDDA5C3263")

    static LocalSocket sZygoteSocket;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.395 -0400", hash_original_field = "391519A98BB915881507ED5011A065BB", hash_generated_field = "AB34448A875466B78D25B22E95B7A947")

    static DataInputStream sZygoteInputStream;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.395 -0400", hash_original_field = "175699F87AA9CF023401BC0B7F78EC44", hash_generated_field = "3011F241066D99A77515F1AC02D1DD21")

    static BufferedWriter sZygoteWriter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.395 -0400", hash_original_field = "611BE8599933C5086D064F2E17F4580C", hash_generated_field = "58755555CE47A0A58677BD406C65FEED")

    static boolean sPreviousZygoteOpenFailed;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.395 -0400", hash_original_field = "6E08CD5035B79DDF007C6E2F215F9AC8", hash_generated_field = "8FD8DC667743CF169343FB0338D63FA1")

    static final int ZYGOTE_RETRY_MILLIS = 500;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.395 -0400", hash_original_field = "097EBA622A20A0E27F3404BF1A4C61F0", hash_generated_field = "2DDEB888EA80442A9CBEED6D8C91DFDD")

    public static final int PROC_TERM_MASK = 0xff;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.395 -0400", hash_original_field = "BC12B4FDA8B9158A848D30621AF40F52", hash_generated_field = "7FED250C9597550A03B8923C3804D13E")

    public static final int PROC_ZERO_TERM = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.395 -0400", hash_original_field = "FC8326837ECAB42FA5B628D1864A2040", hash_generated_field = "1E9CD5BFAAFF25C0971667E387CEAA0E")

    public static final int PROC_SPACE_TERM = (int)' ';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.395 -0400", hash_original_field = "90C3003D5E3328AE86A4B9BF0E840D1E", hash_generated_field = "A68201FE65C82A9394E9F4AAB232D7F0")

    public static final int PROC_TAB_TERM = (int)'\t';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.395 -0400", hash_original_field = "E55D67B4252C603B31BB5CB462960153", hash_generated_field = "872619D17A3479C6CF559B3C12046C69")

    public static final int PROC_COMBINE = 0x100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.395 -0400", hash_original_field = "3EC1284892A976F200706C03E749DBF6", hash_generated_field = "1FE65E5D52898E3A8718DAFE2BDCBB0F")

    public static final int PROC_PARENS = 0x200;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.395 -0400", hash_original_field = "771DDD479FBB55BD82E22F87735D1DCF", hash_generated_field = "57C38802CF50DF0F0A350F41EEFF3215")

    public static final int PROC_OUT_STRING = 0x1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.395 -0400", hash_original_field = "4CD912479B8B0F1E717DA37EF635D0A8", hash_generated_field = "509793E3AAFDE88C2657670890815C2D")

    public static final int PROC_OUT_LONG = 0x2000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.395 -0400", hash_original_field = "76678CFB1870E05BB6DBF7F1822ED7EF", hash_generated_field = "CD46C23BC8D66AD59D64F861EAD2FEBA")

    public static final int PROC_OUT_FLOAT = 0x4000;
}

