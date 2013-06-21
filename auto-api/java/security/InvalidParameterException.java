package java.security;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class InvalidParameterException extends IllegalArgumentException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.323 -0400", hash_original_method = "A4FEFBD78FD62EF00C6F1D79EDBD5401", hash_generated_method = "BE01BA4359166DF37CC076B225DB57ED")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public InvalidParameterException(String msg) {
        super(msg);
        dsTaint.addTaint(msg);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.324 -0400", hash_original_method = "9CA8CE9AC39DC45F96DE6473AB9F71B5", hash_generated_method = "A364D8E4484CEE6C11C8D78768D38217")
    @DSModeled(DSC.SAFE)
    public InvalidParameterException() {
        // ---------- Original Method ----------
    }

    
    private static final long serialVersionUID = -857968536935667808L;
}

