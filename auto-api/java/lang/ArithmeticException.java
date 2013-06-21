package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class ArithmeticException extends RuntimeException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.414 -0400", hash_original_method = "24115F2AC5B4BFA51305F479377E801A", hash_generated_method = "C79B2E7C2BBB39468FF7E68D70189892")
    @DSModeled(DSC.SAFE)
    public ArithmeticException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.414 -0400", hash_original_method = "FAC340A34D2F62BBB9E823C2AE5CBB24", hash_generated_method = "E1BDB31A7CE3E0C27B6F9D1B445B02E9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ArithmeticException(String detailMessage) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
    private static final long serialVersionUID = 2256477558314496007L;
}

