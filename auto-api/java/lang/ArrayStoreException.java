package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class ArrayStoreException extends RuntimeException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.421 -0400", hash_original_method = "B57005FA913ED8B5B6C3BCF68E82D1FE", hash_generated_method = "C1E2F4C0361A9FF254ED68AA3FADAD3A")
    @DSModeled(DSC.SAFE)
    public ArrayStoreException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.421 -0400", hash_original_method = "01E4D930DB2533CF6B50973E0AD2DC7C", hash_generated_method = "0FBA57343F49DE90385F8A7932BF8667")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ArrayStoreException(String detailMessage) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
    private static final long serialVersionUID = -4522193890499838241L;
}

