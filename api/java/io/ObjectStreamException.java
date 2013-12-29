package java.io;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;



public abstract class ObjectStreamException extends IOException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:32.541 -0500", hash_original_field = "B82F7B935EE9C289FD7B9370C17C0EDC", hash_generated_field = "E83FDCD08EA6AEFA8BBCB688FE0FD93F")


    private static final long serialVersionUID = 7260898174833392607L;

    /**
     * Constructs a new {@code ObjectStreamException} with its stack trace
     * filled in.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:32.542 -0500", hash_original_method = "7277EDCE895E14A1718765213C9E754B", hash_generated_method = "E6AB3CB4F1B24578CD540E4B71B73927")
    protected ObjectStreamException() {
    }

    /**
     * Constructs a new {@code ObjectStreamException} with its stack trace and
     * detail message filled in.
     *
     * @param detailMessage
     *            the detail message for this exception.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:32.543 -0500", hash_original_method = "B5966321481D67D0B2EAAF8863CF68D1", hash_generated_method = "BEBBC277D084FC14AA3C6C5A744BD228")
    protected ObjectStreamException(String detailMessage) {
        super(detailMessage);
    }
}

