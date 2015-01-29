package java.lang;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class IllegalAccessError extends IncompatibleClassChangeError {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:28.564 -0500", hash_original_field = "7EAADCA0B8AC3D1C657936FE8947478C", hash_generated_field = "7BC1F56550DFF30D84857A19A2ACAA0A")

    private static final long serialVersionUID = -8988904074992417891L;

    /**
     * Constructs a new {@code IllegalAccessError} that includes the current
     * stack trace.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:28.566 -0500", hash_original_method = "AF78E0BEB545D91D9B237CD89EEDE6D8", hash_generated_method = "39BFDAA5822942092752EB6A728C6105")
    
public IllegalAccessError() {
    }

    /**
     * Constructs a new {@code IllegalAccessError} with the current stack trace
     * and the specified detail message.
     *
     * @param detailMessage
     *            the detail message for this error.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:28.569 -0500", hash_original_method = "82FD6CF28C2427CE5A3234413711027B", hash_generated_method = "4AB376EBAA6F6CB0D5F9E82C4F8BBCAC")
    
public IllegalAccessError(String detailMessage) {
        super(detailMessage);
    }
}

