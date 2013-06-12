package java.util.concurrent.locks;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public abstract class AbstractOwnableSynchronizer implements java.io.Serializable {
    private static long serialVersionUID = 3737899427754241961L;
    private transient Thread exclusiveOwnerThread;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:12:58.659 -0400", hash_original_method = "09FACEDDA2CFE0BD4863CBAC9CCC5DB1", hash_generated_method = "8A67A35F8FD2DB2314B2F700D2D658A0")
    @DSModeled(DSC.SAFE)
    protected AbstractOwnableSynchronizer() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:12:58.668 -0400", hash_original_method = "54BE2CB7A2B251833C1274201519DC0B", hash_generated_method = "4D9234555C823EBD7C387B2C5BED6543")
    @DSModeled(DSC.SAFE)
    protected final void setExclusiveOwnerThread(Thread t) {
        dsTaint.addTaint(t.dsTaint);
        // ---------- Original Method ----------
        //exclusiveOwnerThread = t;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:12:58.679 -0400", hash_original_method = "B27D03344136636BB9AA0892188CCAE3", hash_generated_method = "FA9DE5FDB8D0CBBC3DB47318EFB74959")
    @DSModeled(DSC.SAFE)
    protected final Thread getExclusiveOwnerThread() {
        return (Thread)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return exclusiveOwnerThread;
    }

    
}


