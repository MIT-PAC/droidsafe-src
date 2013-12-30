package java.lang;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;





public class AbstractMethodError extends IncompatibleClassChangeError {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:32.046 -0500", hash_original_field = "53FFA2BBE3888DE2B26FA079EBA7945C", hash_generated_field = "B59137EDC0BBD16080EB2D2BEDE487F9")


    private static final long serialVersionUID = -1654391082989018462L;

    /**
     * Constructs a new {@code AbstractMethodError} that includes the current
     * stack trace.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:32.048 -0500", hash_original_method = "4F4F671C3B04BA3CBFE40382F9999EB7", hash_generated_method = "54D9823C678D2700D9A36CFD9A3CDCB7")
    
public AbstractMethodError() {
    }

    /**
     * Constructs a new {@code AbstractMethodError} with the current stack trace
     * and the specified detail message.
     *
     * @param detailMessage
     *            the detail message for this error.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:32.051 -0500", hash_original_method = "08FCF39731DB3AF551E2B6A840F345BE", hash_generated_method = "5FDA95AEF3B43771FC19325230C94145")
    
public AbstractMethodError(String detailMessage) {
        super(detailMessage);
    }
}

