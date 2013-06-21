package org.xml.sax;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class SAXNotSupportedException extends SAXException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.425 -0400", hash_original_method = "8145A6EACBA97C57F61472FF031DA600", hash_generated_method = "11202C211CE2C664DE0C9CBEED1CA1E9")
    @DSModeled(DSC.SAFE)
    public SAXNotSupportedException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.425 -0400", hash_original_method = "388A9CB995B8D4BAD9F29D89DBB3CE91", hash_generated_method = "3AFB763A1670A3F5C2C687F98F02F73C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SAXNotSupportedException(String message) {
        super(message);
        dsTaint.addTaint(message);
        // ---------- Original Method ----------
    }

    
}

