package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class IOError extends Error {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.803 -0400", hash_original_method = "96BEEC8FF3377FBD2EA8C52D4E2435B2", hash_generated_method = "AF399ECAE0167864CB7C3697A3773645")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public IOError(Throwable cause) {
        super(cause);
        dsTaint.addTaint(cause.dsTaint);
        // ---------- Original Method ----------
    }

    
    private static final long serialVersionUID = 67100927991680413L;
}

