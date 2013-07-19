package libcore.io;

// Droidsafe Imports
import java.io.FileDescriptor;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public final class AsynchronousCloseMonitor {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:23.926 -0400", hash_original_method = "967A44D226EEDADBF9D94C0098E272B9", hash_generated_method = "A653A343D9AB2B4C88D8A3746291C673")
    private  AsynchronousCloseMonitor() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    public static void signalBlockedThreads(FileDescriptor fd) {
    }

    
}

