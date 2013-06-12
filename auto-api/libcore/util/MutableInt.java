package libcore.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public final class MutableInt {
    public int value;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.539 -0400", hash_original_method = "03C0B08CFD4223793C8EE7C700E72B55", hash_generated_method = "25718B7801E0552CFD7F5C30E932A5D7")
    @DSModeled(DSC.SAFE)
    public MutableInt(int value) {
        dsTaint.addTaint(value);
        // ---------- Original Method ----------
        //this.value = value;
    }

    
}


