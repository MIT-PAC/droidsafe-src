package java.net;

// Droidsafe Imports
import java.io.IOException;

import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;

public class UnknownServiceException extends IOException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.167 -0400", hash_original_method = "ADBD30E20976E5F84799D2EDCA6E8AB1", hash_generated_method = "9EE874687BEB0AAD14D021865ADF7D88")
    public  UnknownServiceException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.168 -0400", hash_original_method = "7690A99261A8975258177F18AE9D9AC2", hash_generated_method = "CCAF363A9E074FCB6990A8E7358E2752")
    public  UnknownServiceException(String detailMessage) {
        super(detailMessage);
        addTaint(detailMessage.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.168 -0400", hash_original_method = "E3B2640B549BA587BAC4EC77E8C4280A", hash_generated_method = "6D22DDD94745C3A0AEEE9F635031563E")
    public  UnknownServiceException(String detailMessage, Throwable cause) {
        super(detailMessage, cause);
        addTaint(cause.getTaint());
        addTaint(detailMessage.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.168 -0400", hash_original_field = "E34C55132E2CB6628CEC6701ECDE45B6", hash_generated_field = "151AD2774CC9EA92C51B9CE157958424")

    private static final long serialVersionUID = -4169033248853639508L;
}

