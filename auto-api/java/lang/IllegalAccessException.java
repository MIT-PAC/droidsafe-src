package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;


public class IllegalAccessException extends Exception {
    private static final long serialVersionUID = 6616958222490762034L;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 16:38:45.873 -0400", hash_original_method = "0B7C013169E666B387C14287F3C47F99", hash_generated_method = "74FAD46072E7E3C860E4408DFF337C7C")
    @DSModeled(DSC.SAFE)
    public IllegalAccessException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 16:38:45.879 -0400", hash_original_method = "97CF3633BB9BA7D56994697113856304", hash_generated_method = "D9BA93911A9622BB17E3D0885A8FE87B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public IllegalAccessException(String detailMessage) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
}


