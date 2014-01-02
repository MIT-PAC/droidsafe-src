package java.security;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;



public class ProviderException extends RuntimeException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:00.527 -0500", hash_original_field = "6E25386BD252D6C891D04F11C860A646", hash_generated_field = "824A5F3D6F682455BB2A1994F230FF51")


    private static final long serialVersionUID = 5256023526693665674L;

    /**
     * Constructs a new instance of {@code ProviderException} with the given
     * message.
     *
     * @param msg
     *            the detail message for this exception.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:00.529 -0500", hash_original_method = "4F6DF0DF8572865516F19A786749BA2D", hash_generated_method = "8D2DBFEE39A91F52752FE961F075ED33")
    
public ProviderException(String msg) {
        super(msg);
    }

    /**
     * Constructs a new instance of {@code ProviderException}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:00.532 -0500", hash_original_method = "C6FD128032A25223FCE8DF59B6440EFD", hash_generated_method = "A7CAD064E0C0DFEA01146D642750AE5E")
    
public ProviderException() {
    }

    /**
     * Constructs a new instance of {@code ProviderException} with the given
     * message and the cause.
     *
     * @param message
     *            the detail message for this exception.
     * @param cause
     *            the exception which is the cause for this exception.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:00.535 -0500", hash_original_method = "9D8D611DA847D087295A6CFF5F4EEF0C", hash_generated_method = "F40891BAAD3E5966A39EF052DD6559BF")
    
public ProviderException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new instance of {@code ProviderException} with the cause.
     *
     * @param cause
     *            the exception which is the cause for this exception.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:00.537 -0500", hash_original_method = "39103B62643A614FF10A8AB7735F1560", hash_generated_method = "CB6BEB26BB8D901CB7FD49F11A2E9FB4")
    
public ProviderException(Throwable cause) {
        super(cause);
    }
}

