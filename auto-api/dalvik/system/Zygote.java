package dalvik.system;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.io.File;

public class Zygote {
    public static final int DEBUG_ENABLE_DEBUGGER   = 1;
    public static final int DEBUG_ENABLE_CHECKJNI   = 1 << 1;
    public static final int DEBUG_ENABLE_ASSERT     = 1 << 2;
    public static final int DEBUG_ENABLE_SAFEMODE   = 1 << 3;
    public static final int DEBUG_ENABLE_JNI_LOGGING = 1 << 4;
    public static boolean systemInSafeMode = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.349 -0400", hash_original_method = "571209F1E0BFAC649B933D0F6DC3BC96", hash_generated_method = "CFA8A7068EFBF4129F4ACD9AEE9CE2DC")
    @DSModeled(DSC.SAFE)
    private Zygote() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.349 -0400", hash_original_method = "48FA3E87F3B01C5B7451B6F18816C44C", hash_generated_method = "ADA12113D5D8110B14919D9438E16B6D")
    private static void preFork() {
        Daemons.stop();
        waitUntilAllThreadsStopped();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.349 -0400", hash_original_method = "E907105D6B58D9053A1938DE7DF89ED1", hash_generated_method = "8721E11351683F385194F3FC1A718EE5")
    private static void waitUntilAllThreadsStopped() {
        File tasks = new File("/proc/self/task");
        while (tasks.list().length > 1) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException ignored) {
            }
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.349 -0400", hash_original_method = "A79881836E3F6AC14C6223324389064A", hash_generated_method = "2A8FB1CE86DFF5A8312306EAA5D4DFAF")
    private static void postFork() {
        Daemons.start();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.349 -0400", hash_original_method = "5F71AEAFC7DD0E06D31189B8E9285CCC", hash_generated_method = "8CCB824803E59AD7B5D63B6370F27795")
    public static int fork() {
        preFork();
        int pid = nativeFork();
        postFork();
        return pid;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.349 -0400", hash_original_method = "C7DF03CFFDB10FE267BE25279988DC30", hash_generated_method = "3A3A1A4B5F5A8C766CA3A71CD7C94F90")
    public static int nativeFork() {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    	return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.349 -0400", hash_original_method = "167631196A2C66990E7F61BE07899D2B", hash_generated_method = "C6783A608B0F532475DDA84D780EA823")
    public static int forkAndSpecialize(int uid, int gid, int[] gids,
            int debugFlags, int[][] rlimits) {
        preFork();
        int pid = nativeForkAndSpecialize(uid, gid, gids, debugFlags, rlimits);
        postFork();
        return pid;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.349 -0400", hash_original_method = "AE4F218B4B5314E01514A2DB6533F016", hash_generated_method = "91CD60096429DF919218F615B42CA076")
    public static int nativeForkAndSpecialize(int uid, int gid,
            int[] gids, int debugFlags, int[][] rlimits) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    	return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.349 -0400", hash_original_method = "911AB9C595BBE3DEF39975B1C146C2FC", hash_generated_method = "070660DD5CE59C01FA4AEB53FF32B37A")
    @Deprecated
    public static int forkAndSpecialize(int uid, int gid, int[] gids,
            boolean enableDebugger, int[][] rlimits) {
        int debugFlags = enableDebugger ? DEBUG_ENABLE_DEBUGGER : 0;
        return forkAndSpecialize(uid, gid, gids, debugFlags, rlimits);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.349 -0400", hash_original_method = "11B9FD6CF8A852954DB9868CF618C4FB", hash_generated_method = "5637AF34F74A18AB5F4962975C9CF687")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.349 -0400", hash_original_method = "824CBDF635DB37660DCC074284E4485A", hash_generated_method = "222C6F00DD65DEEC71A0E0FB0975E7EE")
    @Deprecated
    public static int forkSystemServer(int uid, int gid, int[] gids,
            boolean enableDebugger, int[][] rlimits) {
        int debugFlags = enableDebugger ? DEBUG_ENABLE_DEBUGGER : 0;
        return forkAndSpecialize(uid, gid, gids, debugFlags, rlimits);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.349 -0400", hash_original_method = "09C4D08B116ACCA5968243AF075C6785", hash_generated_method = "DBEBFF6AD159D96F0B10384559CA5383")
    public static int nativeForkSystemServer(int uid, int gid,
            int[] gids, int debugFlags, int[][] rlimits,
            long permittedCapabilities, long effectiveCapabilities) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    	return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.349 -0400", hash_original_method = "4E298BD73CB3CE4838A0E376A85EE2C2", hash_generated_method = "9F8B92C222B5ED89131795F1C9479C84")
    public static void execShell(String command) {
        nativeExecShell(command);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.349 -0400", hash_original_method = "1725E87F4919C96ACB03BE0E2182C74B", hash_generated_method = "90C5B29A4950490C67CE08A54E835D64")
    public static void appendQuotedShellArgs(StringBuilder command, String[] args) {
        for (String arg : args) {
            command.append(" '").append(arg.replace("'", "'\\''")).append("'");
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.349 -0400", hash_original_method = "24E536CD0DFFDACA2D523CDBD82C6A30", hash_generated_method = "23A4D6B8CFD7CB16950984A989D01379")
    private static void nativeExecShell(String command) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
}


