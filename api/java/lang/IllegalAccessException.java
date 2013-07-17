package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class IllegalAccessException extends Exception {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.018 -0400", hash_original_method = "0B7C013169E666B387C14287F3C47F99", hash_generated_method = "F02D2F9CCE5BB8803E0299C53F9F5E10")
    public  IllegalAccessException() {
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.019 -0400", hash_original_method = "97CF3633BB9BA7D56994697113856304", hash_generated_method = "6BAD9DD09405693C2553E9914074530B")
    public  IllegalAccessException(String detailMessage) {
        super(detailMessage);
        addTaint(detailMessage.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.019 -0400", hash_original_field = "5F54957DA1654EB57301B3756EA55BC9", hash_generated_field = "3D22B2C60D6666289158370990E2679F")

    private static final long serialVersionUID = 6616958222490762034L;
}

