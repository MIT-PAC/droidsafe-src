package java.io;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class EOFException extends IOException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:47.662 -0500", hash_original_field = "87459FACD7DA01F3C383DBDA9D3F9605", hash_generated_field = "22BD3585BCD2E328E0B1FBA88D70C08F")

    private static final long serialVersionUID = 6433858223774886977L;

    /**
     * Constructs a new {@code EOFException} with its stack trace filled in.
     */
    @DSComment("exception message, is only a data structure")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:47.665 -0500", hash_original_method = "1CCCAA76135EE86F6894FC590C0C686A", hash_generated_method = "86817270206315FBD2E3F7F33A786C76")
    
public EOFException() {
    }

    /**
     * Constructs a new {@code EOFException} with its stack trace and detail
     * message filled in.
     *
     * @param detailMessage
     *            the detail message for this exception.
     */
    @DSComment("exception message, is only a data structure")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:47.668 -0500", hash_original_method = "1DF3A1A90A52071351DFC31CC87C4540", hash_generated_method = "617F507042775ED6B9320B8612D9BB66")
    
public EOFException(String detailMessage) {
        super(detailMessage);
    }
}

