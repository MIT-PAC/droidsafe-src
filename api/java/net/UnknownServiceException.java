package java.net;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;

public class UnknownServiceException extends IOException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:12.206 -0500", hash_original_field = "FC3FB75718350C4DA9C0B9642ABFE075", hash_generated_field = "151AD2774CC9EA92C51B9CE157958424")

    private static final long serialVersionUID = -4169033248853639508L;

    /**
     * Constructs a new instance.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:12.208 -0500", hash_original_method = "ADBD30E20976E5F84799D2EDCA6E8AB1", hash_generated_method = "1AFF1F6B4A9BC5B821DD335B04F8E0E9")
    
public UnknownServiceException() {
    }

    /**
     * Constructs a new instance with the given detail message.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:12.211 -0500", hash_original_method = "7690A99261A8975258177F18AE9D9AC2", hash_generated_method = "504645D7D0A5E34D407422596D5F7DD4")
    
public UnknownServiceException(String detailMessage) {
        super(detailMessage);
    }

    /**
     * Constructs a new instance with given detail message and cause.
     * @hide internal use only
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:12.213 -0500", hash_original_method = "E3B2640B549BA587BAC4EC77E8C4280A", hash_generated_method = "574B053F9775BC88563ABB29BAC6D05A")
    
public UnknownServiceException(String detailMessage, Throwable cause) {
        super(detailMessage, cause);
    }
}

