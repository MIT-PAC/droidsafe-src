package java.io;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class IOError extends Error {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:51.287 -0500", hash_original_field = "43FA510DEC29E81C902981339AFC101E", hash_generated_field = "B0E0B3279A8FF05BF846141BCB1703ED")

    private static final long serialVersionUID = 67100927991680413L;

    /**
     * Constructs a new instance with its cause filled in.
     *
     * @param cause
     *            The detail cause for the error.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:51.291 -0500", hash_original_method = "96BEEC8FF3377FBD2EA8C52D4E2435B2", hash_generated_method = "4B08AE1FE38C0BA5AFDB4FFFD2225CB6")
    
public IOError(Throwable cause) {
        super(cause);
    }
}

