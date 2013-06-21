package android.os.storage;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public abstract class OnObbStateChangeListener {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.503 -0400", hash_original_method = "C4CA97EB384FD17BF173C6310A3F784A", hash_generated_method = "C4CA97EB384FD17BF173C6310A3F784A")
        public OnObbStateChangeListener ()
    {
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.503 -0400", hash_original_method = "8D4DBCB92EE624B36C1D9B80653BEEEA", hash_generated_method = "AB65DA0943069C783BA2A003849B56B3")
    @DSModeled(DSC.SAFE)
    public void onObbStateChange(String path, int state) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(state);
        dsTaint.addTaint(path);
        // ---------- Original Method ----------
    }

    
    public static final int MOUNTED = 1;
    public static final int UNMOUNTED = 2;
    public static final int ERROR_INTERNAL = 20;
    public static final int ERROR_COULD_NOT_MOUNT = 21;
    public static final int ERROR_COULD_NOT_UNMOUNT = 22;
    public static final int ERROR_NOT_MOUNTED = 23;
    public static final int ERROR_ALREADY_MOUNTED = 24;
    public static final int ERROR_PERMISSION_DENIED = 25;
}

