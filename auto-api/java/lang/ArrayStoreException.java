package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;


public class ArrayStoreException extends RuntimeException {
    private static final long serialVersionUID = -4522193890499838241L;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 16:38:45.012 -0400", hash_original_method = "B57005FA913ED8B5B6C3BCF68E82D1FE", hash_generated_method = "656A92AE522D2A8764A312BA4A4861BD")
    @DSModeled(DSC.SAFE)
    public ArrayStoreException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 16:38:45.024 -0400", hash_original_method = "01E4D930DB2533CF6B50973E0AD2DC7C", hash_generated_method = "BF7653F84DA980F48AA3E4F3A5E05F5E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ArrayStoreException(String detailMessage) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
}


