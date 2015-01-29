package java.lang;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class NoSuchMethodError extends IncompatibleClassChangeError {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.034 -0500", hash_original_field = "81A4755C531FE5ED98A75CBE713FDD1C", hash_generated_field = "635C9A9BFCFFDA068A7F59FA9CD17FE1")

    private static final long serialVersionUID = -3765521442372831335L;

    /**
     * Constructs a new {@code NoSuchMethodError} that includes the current
     * stack trace.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.036 -0500", hash_original_method = "80EBD198F916FEE348D274437586B5BC", hash_generated_method = "EC63043FE8F0B7C4581CFB28CF8CFFDF")
    
public NoSuchMethodError() {
    }

    /**
     * Constructs a new {@code NoSuchMethodError} with the current stack trace
     * and the specified detail message.
     *
     * @param detailMessage
     *            the detail message for this exception.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.039 -0500", hash_original_method = "4CC31AAD9CD08413E75D886E5A5CF2D3", hash_generated_method = "5852B1E75AD6B6BC2CB675208087B9ED")
    
public NoSuchMethodError(String detailMessage) {
        super(detailMessage);
    }
}

