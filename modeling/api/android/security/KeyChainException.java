package android.security;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class KeyChainException extends Exception {

    /**
     * Constructs a new {@code KeyChainException} that includes the
     * current stack trace.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:57.267 -0500", hash_original_method = "07A073FF0F51A72901A8B28E6AC903AE", hash_generated_method = "02A24FEEB5AC65E638433C51E1C12BE4")
    
public KeyChainException() {
    }

    /**
     * Constructs a new {@code KeyChainException} with the current stack
     * trace and the specified detail message.
     *
     * @param detailMessage
     *            the detail message for this exception.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:57.270 -0500", hash_original_method = "0A58DB61FCFCEABE9058FC3092E58BF3", hash_generated_method = "87AF306655F017EA667BF87615F03EBC")
    
public KeyChainException(String detailMessage) {
        super(detailMessage);
    }

    /**
     * Constructs a new {@code KeyChainException} with the current stack
     * trace, the specified detail message and the specified cause.
     *
     * @param message
     *            the detail message for this exception.
     * @param cause
     *            the cause of this exception, may be {@code null}.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:57.273 -0500", hash_original_method = "3E8EDDC6FC8719784A3F6D961EFA0DBF", hash_generated_method = "0C9C6D90523277E25B3DFDE07B842BE4")
    
public KeyChainException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new {@code KeyChainException} with the current stack
     * trace and the specified cause.
     *
     * @param cause
     *            the cause of this exception, may be {@code null}.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:57.276 -0500", hash_original_method = "8CC23A5EEF616E11C5C7CDC0612B705F", hash_generated_method = "DE1CA4EB68D0FF20D9D270B4A5483195")
    
public KeyChainException(Throwable cause) {
        super((cause == null ? null : cause.toString()), cause);
    }
    
}

