package java.lang.reflect;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;





public class InvocationTargetException extends Exception {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:12.222 -0500", hash_original_field = "3FB1F19F5ECFA9B61FF3BEB74A0E3882", hash_generated_field = "8B92C691B9FF42AF75BC4B807D727C71")


    private static final long serialVersionUID = 4085088731926701167L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:12.225 -0500", hash_original_field = "BAE956BCC966588A9550DF065F923336", hash_generated_field = "5298B1A2336EAF80BB6B016828DD3384")


    private Throwable target;

    /**
     * Constructs a new {@code InvocationTargetException} instance with a
     * {@code null} cause / target exception.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:12.228 -0500", hash_original_method = "5EBB00A3899F4B7F5118F6E64DAF6A94", hash_generated_method = "F002C28ED5B431C1069BCA418FDA04D5")
    
protected InvocationTargetException() {
        super((Throwable) null);
    }

    /**
     * Constructs a new {@code InvocationTargetException} instance with its
     * cause / target exception filled in.
     *
     * @param exception
     *            the exception which occurred while running the Method or
     *            Constructor
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:12.231 -0500", hash_original_method = "D75C8652A4FC35D535700D06AA8AC5D8", hash_generated_method = "2FDFDD6B083187F65DFBB9D56DD19A0F")
    
public InvocationTargetException(Throwable exception) {
        super(null, exception);
        target = exception;
    }

    /**
     * Constructs a new {@code InvocationTargetException} instance with its
     * cause / target exception and message filled in.
     *
     * @param detailMessage
     *            the detail message for the exception
     * @param exception
     *            the exception which occurred while running the Method or
     *            Constructor
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:12.234 -0500", hash_original_method = "24D12D510338B7A1CDB30B859EF6A619", hash_generated_method = "572E6A8818653EA40EA5A1C6240471C2")
    
public InvocationTargetException(Throwable exception, String detailMessage) {
        super(detailMessage, exception);
        target = exception;
    }

    /**
     * Returns the target exception, which may be {@code null}.
     *
     * @return the target exception
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:12.236 -0500", hash_original_method = "F1F2316177C546F546EA483459CFF30B", hash_generated_method = "2207DC53F6302AF64B36ABA7BEE1FE70")
    
public Throwable getTargetException() {
        return target;
    }

    /**
     * Returns the cause of this exception, which may be {@code null}.
     *
     * @return the cause of this exception
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:12.239 -0500", hash_original_method = "D8C22D14C73496EF517FF8FC6C6B2CD8", hash_generated_method = "99CD47B0697B3B8C9C0B34299EA01FAB")
    
@Override
    public Throwable getCause() {
        return target;
    }
}

