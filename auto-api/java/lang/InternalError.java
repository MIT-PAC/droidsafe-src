package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class InternalError extends VirtualMachineError {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.821 -0400", hash_original_method = "18A11DFE954AAC7F3401D9A18E98EAA5", hash_generated_method = "6CB2AD680A92FD012F933015174E0A46")
    @DSModeled(DSC.SAFE)
    public InternalError() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.822 -0400", hash_original_method = "11A7F61F65B1BF556316C3B357308A87", hash_generated_method = "0B0A89DC00C322E185832A50B391462B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public InternalError(String detailMessage) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
    private static final long serialVersionUID = -9062593416125562365L;
}

