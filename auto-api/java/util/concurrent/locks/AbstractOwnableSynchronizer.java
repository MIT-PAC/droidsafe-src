package java.util.concurrent.locks;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public abstract class AbstractOwnableSynchronizer implements java.io.Serializable {
    private transient Thread exclusiveOwnerThread;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.100 -0400", hash_original_method = "09FACEDDA2CFE0BD4863CBAC9CCC5DB1", hash_generated_method = "D297C3151434464F48AC3AE139C059A0")
    @DSModeled(DSC.SAFE)
    protected AbstractOwnableSynchronizer() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.100 -0400", hash_original_method = "54BE2CB7A2B251833C1274201519DC0B", hash_generated_method = "CB24C586E09E8E1662B4246965C0CB6E")
    @DSModeled(DSC.SAFE)
    protected final void setExclusiveOwnerThread(Thread t) {
        dsTaint.addTaint(t.dsTaint);
        // ---------- Original Method ----------
        //exclusiveOwnerThread = t;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.100 -0400", hash_original_method = "B27D03344136636BB9AA0892188CCAE3", hash_generated_method = "B28712E23E9A7104FD7E581050AE797D")
    @DSModeled(DSC.SAFE)
    protected final Thread getExclusiveOwnerThread() {
        return (Thread)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return exclusiveOwnerThread;
    }

    
    private static final long serialVersionUID = 3737899427754241961L;
}

