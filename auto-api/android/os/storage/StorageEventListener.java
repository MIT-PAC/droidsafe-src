package android.os.storage;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public abstract class StorageEventListener {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.504 -0400", hash_original_method = "2FAB41105271AEDD4EFBB5FD79131490", hash_generated_method = "2FAB41105271AEDD4EFBB5FD79131490")
        public StorageEventListener ()
    {
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.504 -0400", hash_original_method = "08B6588D85EC619CC2E0611C0812F3DA", hash_generated_method = "71F14F34ED2048531D3E9C16601C4EC9")
    @DSModeled(DSC.SAFE)
    public void onUsbMassStorageConnectionChanged(boolean connected) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(connected);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.504 -0400", hash_original_method = "B80645FD27258B59A3B650E166B00E17", hash_generated_method = "D648BEECAF3836AF4B84889771BB071D")
    @DSModeled(DSC.SAFE)
    public void onStorageStateChanged(String path, String oldState, String newState) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(oldState);
        dsTaint.addTaint(path);
        dsTaint.addTaint(newState);
        // ---------- Original Method ----------
    }

    
}

