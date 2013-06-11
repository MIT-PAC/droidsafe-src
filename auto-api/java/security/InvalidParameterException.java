package java.security;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public class InvalidParameterException extends IllegalArgumentException {
    private static final long serialVersionUID = -857968536935667808L;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.606 -0400", hash_original_method = "A4FEFBD78FD62EF00C6F1D79EDBD5401", hash_generated_method = "C611F5836A2F98544D6956E3BEA377BE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public InvalidParameterException(String msg) {
        super(msg);
        dsTaint.addTaint(msg);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.606 -0400", hash_original_method = "9CA8CE9AC39DC45F96DE6473AB9F71B5", hash_generated_method = "C6340F3E5FD40A3F4407E132AB824C25")
    @DSModeled(DSC.SAFE)
    public InvalidParameterException() {
        // ---------- Original Method ----------
    }

    
}


