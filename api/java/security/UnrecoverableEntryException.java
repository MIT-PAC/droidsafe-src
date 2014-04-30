package java.security;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class UnrecoverableEntryException extends GeneralSecurityException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:53.866 -0500", hash_original_field = "A2E9D36C79ED7198A9848610F04FD128", hash_generated_field = "E52F3B815AA00A4F940616D4AF17B9B4")

    private static final long serialVersionUID = -4527142945246286535L;

    /**
     * Constructs a new instance of {@code UnrecoverableEntryException}.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:53.869 -0500", hash_original_method = "B211A6D1B8B83310D4292B140A3F159B", hash_generated_method = "A96A45D97F206921E09CEDDC7A45EBCC")
    
public UnrecoverableEntryException() {
    }

    /**
     * Constructs a new instance of {@code UnrecoverableEntryException} with the
     * given message.
     *
     * @param msg
     *            the detail message for this exception.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:53.871 -0500", hash_original_method = "41796CE6161E063E42FAB82830727D9B", hash_generated_method = "886B09C7A16BE4AE08BDD7DF6D0AD0E3")
    
public UnrecoverableEntryException(String msg) {
        super(msg);
    }
}

