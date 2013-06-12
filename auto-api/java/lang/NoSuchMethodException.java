package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;


public class NoSuchMethodException extends Exception {
    private static final long serialVersionUID = 5034388446362600923L;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 16:38:46.334 -0400", hash_original_method = "60C13DDE4E49448CC01A624FC168F601", hash_generated_method = "DE8E110BB09FAF30E23ED01292D0987D")
    @DSModeled(DSC.SAFE)
    public NoSuchMethodException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 16:38:46.336 -0400", hash_original_method = "C31CF201699BCB0031463CB0C33C59AC", hash_generated_method = "978DCFD70275E041E3E31A8A0E85F91E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NoSuchMethodException(String detailMessage) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
}


