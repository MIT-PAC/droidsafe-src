package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class ArrayStoreException extends RuntimeException {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.148 -0400", hash_original_method = "B57005FA913ED8B5B6C3BCF68E82D1FE", hash_generated_method = "C1E2F4C0361A9FF254ED68AA3FADAD3A")
    public  ArrayStoreException() {
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.148 -0400", hash_original_method = "01E4D930DB2533CF6B50973E0AD2DC7C", hash_generated_method = "D69DBA031258924B98C0608EB7744631")
    public  ArrayStoreException(String detailMessage) {
        super(detailMessage);
        addTaint(detailMessage.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.149 -0400", hash_original_field = "4649CBCF4B660C8A30E057B6477AAAE3", hash_generated_field = "541B0E757EDEF4F903329FA72199AC22")

    private static final long serialVersionUID = -4522193890499838241L;
}

