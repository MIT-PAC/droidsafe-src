package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class InvalidObjectException extends ObjectStreamException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.835 -0400", hash_original_method = "4AF46063AE9909D1F5A16DD867276801", hash_generated_method = "859BCD91F61908E051B9713DADAA3948")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public InvalidObjectException(String detailMessage) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
    private static final long serialVersionUID = 3233174318281839583L;
}

