package java.net;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;



public class PortUnreachableException extends SocketException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:05.652 -0500", hash_original_field = "41D437D9DE05E71A1330C5AA4854FB1A", hash_generated_field = "A4906FF1C1D822B7B0B02A02F86BC3CB")


    private static final long serialVersionUID = 8462541992376507323L;

    /**
     * Constructs a new instance.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:05.652 -0500", hash_original_method = "A9512F39350C94C0C69735359EF3AADA", hash_generated_method = "3B672CC1EE5CF4720FA4708FF79B3CB8")
    public PortUnreachableException() {
    }

    /**
     * Constructs a new instance with the given detail message.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:05.653 -0500", hash_original_method = "5D984FCFBC4DFCA56D23D59535D24C8C", hash_generated_method = "E2FA9012281FF4E6A4AF0779576B517D")
    public PortUnreachableException(String detailMessage) {
        super(detailMessage);
    }

    /**
     * Constructs a new instance with given detail message and cause.
     * @hide internal use only
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:05.654 -0500", hash_original_method = "3045F383C8CE75FC18DF1FE38D9A0FBC", hash_generated_method = "CCAADDDE493FD233E0D76984D43DE6D1")
    public PortUnreachableException(String detailMessage, Throwable cause) {
        super(detailMessage, cause);
    }
}

