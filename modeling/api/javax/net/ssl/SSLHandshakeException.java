package javax.net.ssl;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class SSLHandshakeException extends SSLException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:01.095 -0500", hash_original_field = "51214881B0A2DCB238A474A3C7290C4D", hash_generated_field = "A8328B260CA8E9F9663D0F191BA4048E")

    private static final long serialVersionUID = -5045881315018326890L;

    /**
     * Constructs a new instance with the given detail message.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:01.097 -0500", hash_original_method = "82B36E212F934FE090A9654C18E5A390", hash_generated_method = "F816459420EA4035B4330442762F9FDE")
    
public SSLHandshakeException(String reason) {
        super(reason);
    }

    /**
     * Constructs a new instance with given cause.
     * @hide internal use only
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:01.100 -0500", hash_original_method = "6E4EDFE9C902AE43BD6AF73325E7CB73", hash_generated_method = "84C86B608EEF884BB85F344A18F69C9A")
    
public SSLHandshakeException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructs a new instance with given detail message and cause.
     * @hide internal use only
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:01.103 -0500", hash_original_method = "7F0A583E3C5916ED2C2C7E0A6DE82F31", hash_generated_method = "A167546E1F58D4F871FD96EDD2BE2220")
    
public SSLHandshakeException(String reason, Throwable cause) {
        super(reason, cause);
    }
}

