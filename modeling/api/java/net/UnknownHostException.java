package java.net;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;

public class UnknownHostException extends IOException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:11.761 -0500", hash_original_field = "3A5A4414DE521CEF787C9F32F3C5CAB7", hash_generated_field = "7AF0A545F0EA5A7251A4BA7E43BD3851")

    private static final long serialVersionUID = -4639126076052875403L;

    /**
     * Constructs a new {@code UnknownHostException} instance with no detail message.
     * Callers should usually supply a detail message.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:11.763 -0500", hash_original_method = "63F4AB968FFD132B70B6AA5D00C05B79", hash_generated_method = "5FF137D137D5E682F84C0B9BF54FE3BE")
    
public UnknownHostException() {
    }

    /**
     * Constructs a new {@code UnknownHostException} instance with the given detail message.
     * The detail message should generally contain the hostname and a reason for the failure,
     * if known.
     *
     * @param detailMessage
     *            the detail message for this exception.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:11.766 -0500", hash_original_method = "F0919D76ED897260C338F2959B098923", hash_generated_method = "CC29B6D56811D58E18682FA75F132E26")
    
public UnknownHostException(String detailMessage) {
        super(detailMessage);
    }
}

