package java.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;

public class UnknownServiceException extends IOException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.706 -0400", hash_original_method = "ADBD30E20976E5F84799D2EDCA6E8AB1", hash_generated_method = "9EE874687BEB0AAD14D021865ADF7D88")
    public  UnknownServiceException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.707 -0400", hash_original_method = "7690A99261A8975258177F18AE9D9AC2", hash_generated_method = "CCAF363A9E074FCB6990A8E7358E2752")
    public  UnknownServiceException(String detailMessage) {
        super(detailMessage);
        addTaint(detailMessage.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.718 -0400", hash_original_method = "E3B2640B549BA587BAC4EC77E8C4280A", hash_generated_method = "56BBB9CA853909C07EB97A32564C5090")
    public  UnknownServiceException(String detailMessage, Throwable cause) {
        super(detailMessage, cause);
        addTaint(detailMessage.getTaint());
        addTaint(cause.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.718 -0400", hash_original_field = "E34C55132E2CB6628CEC6701ECDE45B6", hash_generated_field = "68B3695F6E82683228BDCD14EECB0DEC")

    private static long serialVersionUID = -4169033248853639508L;
}

