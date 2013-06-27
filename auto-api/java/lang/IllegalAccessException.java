package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class IllegalAccessException extends Exception {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.701 -0400", hash_original_method = "0B7C013169E666B387C14287F3C47F99", hash_generated_method = "F02D2F9CCE5BB8803E0299C53F9F5E10")
    public  IllegalAccessException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.701 -0400", hash_original_method = "97CF3633BB9BA7D56994697113856304", hash_generated_method = "6BAD9DD09405693C2553E9914074530B")
    public  IllegalAccessException(String detailMessage) {
        super(detailMessage);
        addTaint(detailMessage.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.701 -0400", hash_original_field = "5F54957DA1654EB57301B3756EA55BC9", hash_generated_field = "32C9F5D2397EEA37BD60DA9B85D6B06B")

    private static long serialVersionUID = 6616958222490762034L;
}

