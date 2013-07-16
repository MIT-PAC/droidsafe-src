package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class UnsupportedOperationException extends RuntimeException {
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.781 -0400", hash_original_method = "7F6DB5D5ED9D38F1F537736368EB0450", hash_generated_method = "A99A19AC28CD29E8B1E65D945AA0DFDA")
    public  UnsupportedOperationException() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.782 -0400", hash_original_method = "D8E5E0CB144C04E81C4A0C2F4745C381", hash_generated_method = "763DB76378F9B1914D41429CBE10CDC0")
    public  UnsupportedOperationException(String detailMessage) {
        super(detailMessage);
        addTaint(detailMessage.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.782 -0400", hash_original_method = "66AB41D7AD796BF9B33430AF2C434F38", hash_generated_method = "D4F07D219387038D4FE43AE7C33F44FE")
    public  UnsupportedOperationException(String message, Throwable cause) {
        super(message, cause);
        addTaint(cause.getTaint());
        addTaint(message.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.782 -0400", hash_original_method = "47724B2BD03E5789FE4A564680099229", hash_generated_method = "00EBFE15AC5DA49C3409311D184F22A5")
    public  UnsupportedOperationException(Throwable cause) {
        super((cause == null ? null : cause.toString()), cause);
        addTaint(cause.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.782 -0400", hash_original_field = "7271E450BBCF0C7A1F91C25441CECD7E", hash_generated_field = "98371D8BFFC25B03165EF5ECBBCB29E2")

    private static final long serialVersionUID = -1242599979055084673L;
}

