package dalvik.system;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.File;

public class Zygote {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.850 -0400", hash_original_method = "571209F1E0BFAC649B933D0F6DC3BC96", hash_generated_method = "73F0DE5FDE691A3192BDD297AB8647BC")
    private  Zygote() {
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.BAN)
    private static void preFork() {
        Daemons.stop();
        waitUntilAllThreadsStopped();
    }

    
        @DSModeled(DSC.BAN)
    private static void waitUntilAllThreadsStopped() {
        File tasks = new File("/proc/self/task");
        while (tasks.list().length > 1) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException ignored) {
            }
        }
    }

    
        @DSModeled(DSC.BAN)
    private static void postFork() {
        Daemons.start();
    }

    
        @DSModeled(DSC.BAN)
    public static int fork() {
        preFork();
        int pid = nativeFork();
        postFork();
        return pid;
    }

    
    @DSModeled(DSC.BAN)
    public static int nativeFork() {
        return DSUtils.UNKNOWN_INT;
    }

    
        @DSModeled(DSC.BAN)
    public static int forkAndSpecialize(int uid, int gid, int[] gids,
            int debugFlags, int[][] rlimits) {
        preFork();
        int pid = nativeForkAndSpecialize(uid, gid, gids, debugFlags, rlimits);
        postFork();
        return pid;
    }

    
    @DSModeled(DSC.BAN)
    public static int nativeForkAndSpecialize(int uid, int gid,
            int[] gids, int debugFlags, int[][] rlimits) {
        return DSUtils.UNKNOWN_INT;
    }

    
        @DSModeled(DSC.BAN)
    @Deprecated
    public static int forkAndSpecialize(int uid, int gid, int[] gids,
            boolean enableDebugger, int[][] rlimits) {
        int debugFlags = enableDebugger ? DEBUG_ENABLE_DEBUGGER : 0;
        return forkAndSpecialize(uid, gid, gids, debugFlags, rlimits);
    }

    
        @DSModeled(DSC.BAN)
    public static int forkSystemServer(int uid, int gid, int[] gids,
            int debugFlags, int[][] rlimits,
            long permittedCapabilities, long effectiveCapabilities) {
        preFork();
        int pid = nativeForkSystemServer(uid, gid, gids, debugFlags, rlimits,
                                         permittedCapabilities,
                                         effectiveCapabilities);
        postFork();
        return pid;
    }

    
        @DSModeled(DSC.BAN)
    @Deprecated
    public static int forkSystemServer(int uid, int gid, int[] gids,
            boolean enableDebugger, int[][] rlimits) {
        int debugFlags = enableDebugger ? DEBUG_ENABLE_DEBUGGER : 0;
        return forkAndSpecialize(uid, gid, gids, debugFlags, rlimits);
    }

    
    @DSModeled(DSC.BAN)
    public static int nativeForkSystemServer(int uid, int gid,
            int[] gids, int debugFlags, int[][] rlimits,
            long permittedCapabilities, long effectiveCapabilities) {
        return DSUtils.UNKNOWN_INT;
    }

    
        @DSModeled(DSC.BAN)
    public static void execShell(String command) {
        nativeExecShell(command);
    }

    
        @DSModeled(DSC.BAN)
    public static void appendQuotedShellArgs(StringBuilder command, String[] args) {
        for (String arg : args) {
            command.append(" '").append(arg.replace("'", "'\\''")).append("'");
        }
    }

    
    @DSModeled(DSC.BAN)
    private static void nativeExecShell(String command) {
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.852 -0400", hash_original_field = "E90FC9DFD9A473D3F14236DA03121D71", hash_generated_field = "F2226761F63E2A41BA58ECFE304684AA")

    public static final int DEBUG_ENABLE_DEBUGGER   = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.852 -0400", hash_original_field = "C7A5F64F505F3A200882CB1785E8EFBA", hash_generated_field = "EEAFD51BAD32654E04639ACFF5839374")

    public static final int DEBUG_ENABLE_CHECKJNI   = 1 << 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.852 -0400", hash_original_field = "98599173E8E08D38FB7284AD8D81311C", hash_generated_field = "0ACA4785FA848463023739816DE1A5F6")

    public static final int DEBUG_ENABLE_ASSERT     = 1 << 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.852 -0400", hash_original_field = "668E20FB5BD3FC05FCEFDF6FF02DD7A1", hash_generated_field = "8594DF714AE9156F640CE5A4596EF5BA")

    public static final int DEBUG_ENABLE_SAFEMODE   = 1 << 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.852 -0400", hash_original_field = "A5BC50B62B91DEAAA57059A5C86DA51E", hash_generated_field = "DE5D45FDEDBAB0F663B24A18EC2B810F")

    public static final int DEBUG_ENABLE_JNI_LOGGING = 1 << 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.852 -0400", hash_original_field = "C58747C134C975BCE88CF57F94953C64", hash_generated_field = "570F80464594D1C85487F9B8B7117AD9")

    public static boolean systemInSafeMode = false;
}

