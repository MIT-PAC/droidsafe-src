package java.io;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class WriteAbortedException extends ObjectStreamException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:41.852 -0500", hash_original_field = "5DDCFCD1AC2D4E490B220A176BB0311B", hash_generated_field = "AA38F28709E0DCA1A936B26B13871FE3")

    private static final long serialVersionUID = -3326426625597282442L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:41.855 -0500", hash_original_field = "95762DE81C5FD7F68C9AFC34598F9FCB", hash_generated_field = "C3243AD40E57E22F6ED814DD71D64096")

    public Exception detail;

    /**
     * Constructs a new {@code WriteAbortedException} with its stack trace,
     * detail message and the exception which caused the underlying problem when
     * serializing the object filled in.
     *
     * @param detailMessage
     *            the detail message for this exception.
     * @param rootCause
     *            the exception that was thrown when serializing the object.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:41.857 -0500", hash_original_method = "DA6C07DB36CBC207B190B4B4ECB6B2B2", hash_generated_method = "457B192167E039B961CCBF6C255CAF6C")
    
public WriteAbortedException(String detailMessage, Exception rootCause) {
        super(detailMessage);
        detail = rootCause;
        initCause(rootCause);
    }

    /**
     * Gets the extra information message which was provided when this exception
     * was created. Returns {@code null} if no message was provided at creation
     * time.
     *
     * @return the exception message.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:41.860 -0500", hash_original_method = "F8C8FA3813C752D5C72108208FEF04C6", hash_generated_method = "7934F03FD51A9A133A34E4E968483B9C")
    
@Override
    public String getMessage() {
        String msg = super.getMessage();
        if (detail != null) {
            msg = msg + "; " + detail.toString();
        }
        return msg;
    }

    /**
     * Gets the cause of this exception or {@code null} if there is no cause.
     *
     * @return the exception cause.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:41.862 -0500", hash_original_method = "CA6C7AF43E4792C258E5E6922F45606C", hash_generated_method = "DC461A0F2F5995A95FCF9140AE6365B6")
    
@Override
    public Throwable getCause() {
        return detail;
    }
}

