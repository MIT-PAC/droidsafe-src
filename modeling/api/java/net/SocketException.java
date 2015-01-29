package java.net;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;

public class SocketException extends IOException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:13.809 -0500", hash_original_field = "855717F9062098CD469F4F82FA53B598", hash_generated_field = "BE1537516AB0F006A5D38D1DF948ECB9")

    private static final long serialVersionUID = -5935874303556886934L;

    /**
     * Constructs a new instance.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:13.812 -0500", hash_original_method = "6370438F3E8FDAC390DBF5D95BB547E6", hash_generated_method = "3D9488BFB49AA137790079F85DF9EED2")
    
public SocketException() {
    }

    /**
     * Constructs a new instance with the given detail message.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:13.815 -0500", hash_original_method = "1136B1CF147D460660A0A79DDF1D5C0A", hash_generated_method = "B0E4478B405C323C1B7DC6641F683178")
    
public SocketException(String detailMessage) {
        super(detailMessage);
    }
    /**
     * Constructs a new instance with the given cause.
     * @hide internal use only
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:13.817 -0500", hash_original_method = "001E874571014D08FBFC41C7A23D02C6", hash_generated_method = "DAEE70F3FEC579967FE1F19DA12BDA14")
    
public SocketException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructs a new instance with given detail message and cause.
     * @hide internal use only
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:13.821 -0500", hash_original_method = "1ACC59770DF5E02FD5C6C8AE56F288AE", hash_generated_method = "DBA07A4DEC2C4DC6FACF2097EEDC69DA")
    
public SocketException(String detailMessage, Throwable cause) {
        super(detailMessage, cause);
    }
}

