package java.security;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class KeyException extends GeneralSecurityException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:00.853 -0500", hash_original_field = "C937C64E73891B31C1FEFD695BFF9F25", hash_generated_field = "BC3993799412C0E44E7504AF1A370A7B")

    private static final long serialVersionUID = -7483676942812432108L;

    /**
     * Constructs a new instance of {@code KeyException} with the given message.
     *
     * @param msg
     *            the detail message for this exception.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:00.856 -0500", hash_original_method = "DF716A570A039E910D1B39CE7ED06D52", hash_generated_method = "F0C56B98387EA0EA0377521A75D4D1F2")
    
public KeyException(String msg) {
        super(msg);
    }

    /**
     * Constructs a new instance of {@code KeyException}.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:00.858 -0500", hash_original_method = "FF58C5A0C82C3954DB19F7723F0C2CA4", hash_generated_method = "19D31E853C8E0B65B265D25B8034EF1F")
    
public KeyException() {
    }

    /**
     * Constructs a new instance of {@code KeyException} with the given message
     * and the cause.
     *
     * @param message
     *            the detail message for this exception.
     * @param cause
     *            the exception which is the cause for this exception.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:00.862 -0500", hash_original_method = "93F87888548BE89CB4AA687EEDB8405D", hash_generated_method = "80A13290867BA77AE005480AF9C80425")
    
public KeyException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new instance of {@code KeyException} with the cause.
     *
     * @param cause
     *            the exception which is the cause for this exception.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:00.864 -0500", hash_original_method = "ED6FE96D5D1CB668863944D14AFF3EBE", hash_generated_method = "26146C1FD19C2E2B1D6CC1EEC3B43E08")
    
public KeyException(Throwable cause) {
        super(cause);
    }
}

