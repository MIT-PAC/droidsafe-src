package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class OutOfMemoryError extends VirtualMachineError {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.906 -0400", hash_original_method = "ADBA576B8D149CC9A483364A3C8F9DE7", hash_generated_method = "DBAA38D82B9B26FA356A341B9B00F5D0")
    @DSModeled(DSC.SAFE)
    public OutOfMemoryError() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.906 -0400", hash_original_method = "C0FA448A5BDB254B40480B36A6B3D86E", hash_generated_method = "20B25CD0BF5D92F7CED3315750CE58A6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public OutOfMemoryError(String detailMessage) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
    private static final long serialVersionUID = 8228564086184010517L;
}

