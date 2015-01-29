package java.security.spec;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.security.GeneralSecurityException;

public class InvalidKeySpecException extends GeneralSecurityException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:57.743 -0500", hash_original_field = "D10DD266BED1F65632E35B339736B40D", hash_generated_field = "6D03A6CA7C55F9BE4515461FA68F5D3F")

    private static final long serialVersionUID = 3546139293998810778L;

    /**
     * Creates a new {@code InvalidKeySpecException} with the specified message.
     *
     * @param msg
     *            the detail message of this exception.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:57.746 -0500", hash_original_method = "DB6EC4555D24FA0B7F53C3D0CF9817D1", hash_generated_method = "9844F12B8D48A3614195EB71FC4321CC")
    
public InvalidKeySpecException(String msg) {
        super(msg);
    }

    /**
     * Creates a new {@code InvalidKeySpecException}.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:57.749 -0500", hash_original_method = "62E7948E21963822758AD86C4EE61479", hash_generated_method = "289791F291E22122005330909940434E")
    
public InvalidKeySpecException() {
    }

    /**
     * Creates a new {@code InvalidKeySpecException} with the specified message
     * and cause.
     *
     * @param message
     *            the detail message of this exception.
     * @param cause
     *            the cause of this exception.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:57.752 -0500", hash_original_method = "164335802BFF46F4D28D2A0D3E3265D8", hash_generated_method = "99C047DD964F6FEF601C2C0B8FCF29EB")
    
public InvalidKeySpecException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Creates a new {@code InvalidKeySpecException} with the specified cause.
     *
     * @param cause
     *            the cause of this exception.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:57.754 -0500", hash_original_method = "64F8C7884589B108D58D14C2DB6A45FC", hash_generated_method = "1DA7F5ED7792E666257CF6102B4069F1")
    
public InvalidKeySpecException(Throwable cause) {
        super(cause);
    }
}

