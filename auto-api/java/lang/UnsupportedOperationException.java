package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;


public class UnsupportedOperationException extends RuntimeException {
    private static final long serialVersionUID = -1242599979055084673L;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 16:38:46.639 -0400", hash_original_method = "7F6DB5D5ED9D38F1F537736368EB0450", hash_generated_method = "92D2B4CE9A2E8B8BF4ACE33607D02AED")
    @DSModeled(DSC.SAFE)
    public UnsupportedOperationException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 16:38:46.645 -0400", hash_original_method = "D8E5E0CB144C04E81C4A0C2F4745C381", hash_generated_method = "A121121A8E73E87060693A393F942461")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public UnsupportedOperationException(String detailMessage) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 16:38:46.652 -0400", hash_original_method = "66AB41D7AD796BF9B33430AF2C434F38", hash_generated_method = "7ED757A8DB90F47B9FDC2B869E714F00")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public UnsupportedOperationException(String message, Throwable cause) {
        super(message, cause);
        dsTaint.addTaint(message);
        dsTaint.addTaint(cause.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 16:38:46.659 -0400", hash_original_method = "47724B2BD03E5789FE4A564680099229", hash_generated_method = "0E90D259084BBD34A41FB0126020FC27")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public UnsupportedOperationException(Throwable cause) {
        super((cause == null ? null : cause.toString()), cause);
        dsTaint.addTaint(cause.dsTaint);
        // ---------- Original Method ----------
    }

    
}


