package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class NegativeArraySizeException extends RuntimeException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.891 -0400", hash_original_method = "D33CED1C2CC51E1A27A91F713183A870", hash_generated_method = "AAB9A11ADDB53662AAA6D6FF71C8894C")
    @DSModeled(DSC.SAFE)
    public NegativeArraySizeException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.891 -0400", hash_original_method = "8AAF2E9F34B5796377EDFC62134DFEB6", hash_generated_method = "101A0357C79B5AD238400AABA0514E86")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NegativeArraySizeException(String detailMessage) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
    private static final long serialVersionUID = -8960118058596991861L;
}

