package java.nio.charset;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;





public class CoderMalfunctionError extends Error {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:01.129 -0500", hash_original_field = "7DFEDDA9E891EAD71DBA7C5C4438C252", hash_generated_field = "113DCE2BB9203B33E699C7CF2E28F6A0")

    private static final long serialVersionUID = -1151412348057794301L;

    /**
     * Constructs a new {@code CoderMalfunctionError}.
     *
     * @param ex
     *            the original exception thrown by the encoder/decoder.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:01.132 -0500", hash_original_method = "883FFC59265DE3B21E7C8AE56E57641B", hash_generated_method = "E4916F828F004F03CB8972C5E11408EA")
    
public CoderMalfunctionError(Exception ex) {
        super(ex);
    }
}

