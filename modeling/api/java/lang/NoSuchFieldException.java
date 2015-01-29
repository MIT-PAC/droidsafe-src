package java.lang;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class NoSuchFieldException extends Exception {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:33.946 -0500", hash_original_field = "3D390B9E87B6356E45B7C85796F330F4", hash_generated_field = "38D134522B41064051A8CAF0009ED61C")

    private static final long serialVersionUID = -6143714805279938260L;

    /**
     * Constructs a new {@code NoSuchFieldException} that includes the current
     * stack trace.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:33.949 -0500", hash_original_method = "C9B6E52CB5F5184DC84559DF357B6964", hash_generated_method = "E909C162BEE3F4F21C2F7144BE7EDB38")
    
public NoSuchFieldException() {
    }

    /**
     * Constructs a new {@code NoSuchFieldException} with the current stack
     * trace and the specified detail message.
     *
     * @param detailMessage
     *            the detail message for this exception.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:33.952 -0500", hash_original_method = "3003F78B5EA782042D23C70E768D6CA2", hash_generated_method = "FDDD2F438FBF5AA979CAE3F365DFD4B3")
    
public NoSuchFieldException(String detailMessage) {
        super(detailMessage);
    }
}

