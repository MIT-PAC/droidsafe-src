package android.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.ServiceManager;
import java.io.IOException;
public class Power {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:39.687 -0400", hash_original_method = "5BE60834AE300DE523C7A57D7E78082D", hash_generated_method = "35A2606708DDB5B1DD60265774F84FAE")
    private  Power() {
        // ---------- Original Method ----------
    }

    
    public static void acquireWakeLock(int lock, String id) {
    }

    
    public static void releaseWakeLock(String id) {
    }

    
    public static int setScreenState(boolean on) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_854004221 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_854004221;
    }

    
    public static int setLastUserActivityTimeout(long ms) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_944322496 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_944322496;
    }

    
    @Deprecated
    public static void shutdown() {
    }

    
    public static void reboot(String reason) throws IOException {
        rebootNative(reason);
    }

    
    private static void rebootNative(String reason) throws IOException {
    }

    

