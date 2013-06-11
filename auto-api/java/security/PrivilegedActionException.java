package java.security;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public class PrivilegedActionException extends Exception {
    private static final long serialVersionUID = 4724086851538908602l;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.614 -0400", hash_original_method = "EDD6A4125897553733853A01EFA0A0B7", hash_generated_method = "1E02A14EE78A6A7F65194C5E354F651B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PrivilegedActionException(Exception ex) {
        super(ex);
        dsTaint.addTaint(ex.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.614 -0400", hash_original_method = "96C5131DB95D0ADB8B79CD396371D505", hash_generated_method = "59F2D80D1A02F1153E42233EF472E9E7")
    @DSModeled(DSC.SAFE)
    public Exception getException() {
        return (Exception)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
}


