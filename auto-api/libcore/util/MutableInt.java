package libcore.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public final class MutableInt {
    public int value;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.685 -0400", hash_original_method = "03C0B08CFD4223793C8EE7C700E72B55", hash_generated_method = "FA1EAFA5D58D239B44150EDE8FD27B3B")
    @DSModeled(DSC.SAFE)
    public MutableInt(int value) {
        dsTaint.addTaint(value);
        // ---------- Original Method ----------
        //this.value = value;
    }

    
}

