package java.security;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class SignatureException extends GeneralSecurityException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:01.657 -0500", hash_original_field = "2FB8486D897250C0EE64DC1703B99376", hash_generated_field = "8852B99AF1FA24D08606C87FCCB86602")

    private static final long serialVersionUID = 7509989324975124438L;

    /**
     * Constructs a new instance of {@code SignatureException} with the
     * given message.
     *
     * @param msg
     *            the detail message for this exception.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:01.660 -0500", hash_original_method = "1A64E23BD4BC60E25E0621B283BA1364", hash_generated_method = "67F29DCBDF719F95E48DFA66266AE34F")
    
public SignatureException(String msg) {
        super(msg);
    }

    /**
     * Constructs a new instance of {@code SignatureException}.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:01.663 -0500", hash_original_method = "FC81C3C47A9C38543897BA92BDE9ED63", hash_generated_method = "49B60DB86F158BF9320D2F281B28E8D7")
    
public SignatureException() {
    }

    /**
     * Constructs a new instance of {@code SignatureException} with the
     * given message and the cause.
     *
     * @param message
     *            the detail message for this exception
     * @param cause
     *            the exception which is the cause for this exception
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:01.665 -0500", hash_original_method = "016680A93C61AAA9E83AF67D8C91F93A", hash_generated_method = "7432C396A65E8E9151B297B73F71B47B")
    
public SignatureException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new instance of {@code SignatureException} with the
     * cause.
     *
     * @param cause
     *            the exception which is the cause for this exception
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:01.668 -0500", hash_original_method = "3352DA5C6676595EED2C0C966A19B61C", hash_generated_method = "9B9347E567A8560F6A66D3575766792A")
    
public SignatureException(Throwable cause) {
        super(cause);
    }
}

