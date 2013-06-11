package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;


public class NullPointerException extends RuntimeException {
    private static final long serialVersionUID = 5162710183389028792L;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 16:38:46.373 -0400", hash_original_method = "4CD1558B74CC9F94FAFFAA64104ABAFD", hash_generated_method = "B58B36191417D874F6E7393C2A667810")
    @DSModeled(DSC.SAFE)
    public NullPointerException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 16:38:46.375 -0400", hash_original_method = "35797291F30B5B7A43FB2D60560B242A", hash_generated_method = "4FC957BF11B5FC98FFCF9CF0A1FF519B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NullPointerException(String detailMessage) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
}


