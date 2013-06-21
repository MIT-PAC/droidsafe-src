package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class IllegalAccessException extends Exception {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.737 -0400", hash_original_method = "0B7C013169E666B387C14287F3C47F99", hash_generated_method = "F02D2F9CCE5BB8803E0299C53F9F5E10")
    @DSModeled(DSC.SAFE)
    public IllegalAccessException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.737 -0400", hash_original_method = "97CF3633BB9BA7D56994697113856304", hash_generated_method = "2F0101DDA3B038191A5DCF6B1772EEA8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public IllegalAccessException(String detailMessage) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
    private static final long serialVersionUID = 6616958222490762034L;
}

