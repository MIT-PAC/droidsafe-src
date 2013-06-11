package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;


public class IndexOutOfBoundsException extends RuntimeException {
    private static final long serialVersionUID = 234122996006267687L;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 16:38:46.225 -0400", hash_original_method = "D4CD8ADEE84F45A3C2932250B7EFAD5E", hash_generated_method = "F12BA9D4F71F47168D765202C0B78599")
    @DSModeled(DSC.SAFE)
    public IndexOutOfBoundsException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 16:38:46.230 -0400", hash_original_method = "43F047B4ECB1C9194E62BC668739E967", hash_generated_method = "D2CC305FEB7536DB4180B6A8D08CB2D4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public IndexOutOfBoundsException(String detailMessage) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
}


