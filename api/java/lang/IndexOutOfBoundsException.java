package java.lang;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;





public class IndexOutOfBoundsException extends RuntimeException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:25.982 -0500", hash_original_field = "1E5D574AF27EDA872DA72D227CBABE9E", hash_generated_field = "E52D317BB649E52FD827F60043ED4186")


    private static final long serialVersionUID = 234122996006267687L;

    /**
     * Constructs a new {@code IndexOutOfBoundsException} that includes the
     * current stack trace.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:25.983 -0500", hash_original_method = "D4CD8ADEE84F45A3C2932250B7EFAD5E", hash_generated_method = "23002068444B289C379D769C448C26ED")
    public IndexOutOfBoundsException() {
    }

    /**
     * Constructs a new {@code IndexOutOfBoundsException} with the current stack
     * trace and the specified detail message.
     *
     * @param detailMessage
     *            the detail message for this exception.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:25.984 -0500", hash_original_method = "43F047B4ECB1C9194E62BC668739E967", hash_generated_method = "C5B5BAD31536FF032B10B6AA7198497E")
    public IndexOutOfBoundsException(String detailMessage) {
        super(detailMessage);
    }
}

