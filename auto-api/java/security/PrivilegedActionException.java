package java.security;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class PrivilegedActionException extends Exception {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.404 -0400", hash_original_method = "EDD6A4125897553733853A01EFA0A0B7", hash_generated_method = "EFAF9BA4062EA00F3BAA39D8BCB75E51")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PrivilegedActionException(Exception ex) {
        super(ex);
        dsTaint.addTaint(ex.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.405 -0400", hash_original_method = "96C5131DB95D0ADB8B79CD396371D505", hash_generated_method = "76EA32B4063341F9C4A2C36DCD3E5D1A")
    @DSModeled(DSC.SAFE)
    public Exception getException() {
        return (Exception)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
    private static final long serialVersionUID = 4724086851538908602l;
}

