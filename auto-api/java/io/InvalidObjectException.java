package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public class InvalidObjectException extends ObjectStreamException {
    private static final long serialVersionUID = 3233174318281839583L;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.481 -0400", hash_original_method = "4AF46063AE9909D1F5A16DD867276801", hash_generated_method = "E6F58C4D0E1C346DF00A4DE543C8204E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public InvalidObjectException(String detailMessage) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
}


