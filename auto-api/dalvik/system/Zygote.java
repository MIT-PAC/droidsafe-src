package dalvik.system;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.File;

public class Zygote {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.303 -0400", hash_original_method = "571209F1E0BFAC649B933D0F6DC3BC96", hash_generated_method = "73F0DE5FDE691A3192BDD297AB8647BC")
    @DSModeled(DSC.SAFE)
    private Zygote() {
        // ---------- Original Method ----------
    }

    
        private static void preFork() {
        Daemons.stop();
        waitUntilAllThreadsStopped();
    }

    
        private static void waitUntilAllThreadsStopped() {
        File tasks = new File("/proc/self/task");
        while (tasks.list().length > 1) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException ignored) {
            }
        }
    }

    
        private static void postFork() {
        Daemons.start();
    }

    
        public static int fork() {
        preFork();
        int pid = nativeFork();
        postFork();
        return pid;
    }

    
        public static int nativeFork() {
        return DSUtils.UNKNOWN_INT;
    }

    
        public static int forkAndSpecialize(int uid, int gid, int[] gids,
            int debugFlags, int[][] rlimits) {
        preFork();
        int pid = nativeForkAndSpecialize(uid, gid, gids, debugFlags, rlimits);
        postFork();
        return pid;
    }

    
        public static int nativeForkAndSpecialize(int uid, int gid,
            int[] gids, int debugFlags, int[][] rlimits) {
        return DSUtils.UNKNOWN_INT;
    }

    
        @Deprecated
    public static int forkAndSpecialize(int uid, int gid, int[] gids,
            boolean enableDebugger, int[][] rlimits) {
        int debugFlags = enableDebugger ? DEBUG_ENABLE_DEBUGGER : 0;
        return forkAndSpecialize(uid, gid, gids, debugFlags, rlimits);
    }

    
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

    
        @Deprecated
    public static int forkSystemServer(int uid, int gid, int[] gids,
            boolean enableDebugger, int[][] rlimits) {
        int debugFlags = enableDebugger ? DEBUG_ENABLE_DEBUGGER : 0;
        return forkAndSpecialize(uid, gid, gids, debugFlags, rlimits);
    }

    
        public static int nativeForkSystemServer(int uid, int gid,
            int[] gids, int debugFlags, int[][] rlimits,
            long permittedCapabilities, long effectiveCapabilities) {
        return DSUtils.UNKNOWN_INT;
    }

    
        public static void execShell(String command) {
        nativeExecShell(command);
    }

    
        public static void appendQuotedShellArgs(StringBuilder command, String[] args) {
        for (String arg : args) {
            command.append(" '").append(arg.replace("'", "'\\''")).append("'");
        }
    }

    
        private static void nativeExecShell(String command) {
    }

    
    public static final int DEBUG_ENABLE_DEBUGGER   = 1;
    public static final int DEBUG_ENABLE_CHECKJNI   = 1 << 1;
    public static final int DEBUG_ENABLE_ASSERT     = 1 << 2;
    public static final int DEBUG_ENABLE_SAFEMODE   = 1 << 3;
    public static final int DEBUG_ENABLE_JNI_LOGGING = 1 << 4;
    public static boolean systemInSafeMode = false;
}

