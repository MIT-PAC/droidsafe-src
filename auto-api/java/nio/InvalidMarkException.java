package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;


public class InvalidMarkException extends IllegalStateException {
    private static final long serialVersionUID = 1698329710438510774L;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:36:14.273 -0400", hash_original_method = "B1EE027FE89EEC127536AB7DEF53C391", hash_generated_method = "EA0FC36E27220A16036BDCC6F864B120")
    @DSModeled(DSC.SAFE)
    public InvalidMarkException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:36:14.287 -0400", hash_original_method = "29531E800CAD0F117D34A6102B8A5CF9", hash_generated_method = "381186AB743B8FA12CE299882920A1E7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public InvalidMarkException(String detailMessage) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
}


