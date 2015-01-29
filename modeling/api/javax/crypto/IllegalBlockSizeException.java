package javax.crypto;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.security.GeneralSecurityException;

public class IllegalBlockSizeException extends GeneralSecurityException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:56.575 -0500", hash_original_field = "F621DD0EF430A1A06F94704A7E4F308D", hash_generated_field = "B7ACA666642CD2E0C3A0051BC82DF96F")

    private static final long serialVersionUID = -1965144811953540392L;

    /**
     * Creates a new {@code IllegalBlockSizeException} with the specified
     * message.
     *
     * @param msg
     *            the message
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:56.578 -0500", hash_original_method = "861F6F81DB957F4D77B1EC6AAE4C23A3", hash_generated_method = "DC18BA6107CB5FEDD9B64D28FE462943")
    
public IllegalBlockSizeException(String msg) {
        super(msg);
    }

    /**
     * Creates a new {@code IllegalBlockSizeException}.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:56.581 -0500", hash_original_method = "1121F9F47707C37345E2BF72D04B622E", hash_generated_method = "CD1A4DC21B88476A339348D30E58E9F0")
    
public IllegalBlockSizeException() {
    }
}

