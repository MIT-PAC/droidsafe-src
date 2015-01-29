package java.lang;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class UnsatisfiedLinkError extends LinkageError {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:25.200 -0500", hash_original_field = "9901688AB81D71B19E8DCB16E41A2859", hash_generated_field = "F642A49CE4CD3CAFBAC50AE6F6260B5A")

    private static final long serialVersionUID = -4019343241616879428L;

    /**
     * Constructs a new {@code UnsatisfiedLinkError} that includes the current
     * stack trace.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:25.203 -0500", hash_original_method = "4F1AAD53B033EB263910F7523EBBB434", hash_generated_method = "37D1B9756B1C8A207222B6CD56A3FD2C")
    
public UnsatisfiedLinkError() {
    }

    /**
     * Constructs a new {@code UnsatisfiedLinkError} with the current stack
     * trace and the specified detail message.
     *
     * @param detailMessage
     *            the detail message for this exception.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:25.206 -0500", hash_original_method = "B54BA137AD45C0554FF2013805B3936E", hash_generated_method = "CE22571EAA90B3CAD9CC4E1FB6C60559")
    
public UnsatisfiedLinkError(String detailMessage) {
        super(detailMessage);
    }
}

