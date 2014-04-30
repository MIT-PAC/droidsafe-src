package java.io;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class NotActiveException extends ObjectStreamException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:41.303 -0500", hash_original_field = "429100C72BDDB505521A80AF3B26D70E", hash_generated_field = "59CE9C2AB058E4F2700142FBFEC5D993")

    private static final long serialVersionUID = -3893467273049808895L;

    /**
     * Constructs a new {@code NotActiveException} with its stack trace filled
     * in.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:41.306 -0500", hash_original_method = "04F1D3389F0C6F41AEA2935866CA7222", hash_generated_method = "481F09D10808C0266582E4084A39A7D9")
    
public NotActiveException() {
    }

    /**
     * Constructs a new {@code NotActiveException} with its stack trace and
     * detail message filled in.
     *
     * @param detailMessage
     *            the detail message for this exception.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:41.309 -0500", hash_original_method = "3214341FEC67E095A6821294CDC33C6B", hash_generated_method = "2A9BA8E30CD0FAF6D9BC6613B3288C1E")
    
public NotActiveException(String detailMessage) {
        super(detailMessage);
    }
}

