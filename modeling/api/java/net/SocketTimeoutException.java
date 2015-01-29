package java.net;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.InterruptedIOException;

public class SocketTimeoutException extends InterruptedIOException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:12.050 -0500", hash_original_field = "D93F9799DEBA44686D0657CA13AF8ABA", hash_generated_field = "8C635471367BCD967F4DCF81C8430878")

    private static final long serialVersionUID = -8846654841826352300L;

    /**
     * Constructs a new instance.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:12.053 -0500", hash_original_method = "4A11638BF238EC4AAC97B2692C051A84", hash_generated_method = "8903FA48DC3DA7ABC8ACEDC2841258A0")
    
public SocketTimeoutException() {
    }

    /**
     * Constructs a new instance with the given detail message.
     */
    @DSComment("no suspicious activity, just sets class variable")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:12.055 -0500", hash_original_method = "09713AE8E462C0BAD085649F546AAF7D", hash_generated_method = "55E366EE8A7AA79983A756D644DF43C1")
    
public SocketTimeoutException(String detailMessage) {
        super(detailMessage);
    }

    /**
     * Constructs a new instance with given cause.
     * @hide internal use only
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:12.058 -0500", hash_original_method = "154D3A6011E860B522250E3541FB283D", hash_generated_method = "ECA46341136F35A0D143427AC23AAAC1")
    
public SocketTimeoutException(Throwable cause) {
        super(null, cause);
    }

    /**
     * Constructs a new instance with given detail message and cause.
     * @hide internal use only
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:12.061 -0500", hash_original_method = "A2F64A06EC646B0B6CC4F19E5E317D3C", hash_generated_method = "B65CC9595F8C152168EA0D7A0AF56977")
    
public SocketTimeoutException(String detailMessage, Throwable cause) {
        super(detailMessage, cause);
    }
}

