package org.apache.commons.codec;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public class EncoderException extends Exception {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.554 -0400", hash_original_method = "A6C38593A48889676EEA5C494089AF0E", hash_generated_method = "945AB252B1817539A46C7936084D4AD2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public EncoderException(String pMessage) {
        super(pMessage);
        dsTaint.addTaint(pMessage);
        // ---------- Original Method ----------
    }

    
}


