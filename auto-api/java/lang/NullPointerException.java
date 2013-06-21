package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class NullPointerException extends RuntimeException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.897 -0400", hash_original_method = "4CD1558B74CC9F94FAFFAA64104ABAFD", hash_generated_method = "019AF9545A44CED52FDE464DC17E038C")
    @DSModeled(DSC.SAFE)
    public NullPointerException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.897 -0400", hash_original_method = "35797291F30B5B7A43FB2D60560B242A", hash_generated_method = "9F0B33B6D6B8EAB82ED1C67C118B7362")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NullPointerException(String detailMessage) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
    private static final long serialVersionUID = 5162710183389028792L;
}

