package java.lang;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class ClassCastException extends RuntimeException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:17.935 -0500", hash_original_field = "E81581A885B933853F40ADD88006E901", hash_generated_field = "297C35E5EE8236AE1CC5C3D234A50221")

    private static final long serialVersionUID = -9223365651070458532L;

    /**
     * Constructs a new {@code ClassCastException} that includes the current
     * stack trace.
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:17.938 -0500", hash_original_method = "54A88184B9052FBFDEDAE165A6A4F85C", hash_generated_method = "66E27C53425CF8FB8F6F501F68D1D2E9")
    
public ClassCastException() {
    }

    /**
     * Constructs a new {@code ClassCastException} with the current stack trace
     * and the specified detail message.
     *
     * @param detailMessage
     *            the detail message for this exception.
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:17.940 -0500", hash_original_method = "9AC0043646A15326C62DB46FBF4E3D5F", hash_generated_method = "CEFB8C14AB3EA5DED5EEAA9EAB01AB58")
    
public ClassCastException(String detailMessage) {
        super(detailMessage);
    }
}

