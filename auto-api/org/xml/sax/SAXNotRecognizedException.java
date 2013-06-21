package org.xml.sax;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class SAXNotRecognizedException extends SAXException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.422 -0400", hash_original_method = "2CF643FEC5E16E9FDCFBAF4C08D87D85", hash_generated_method = "7B2511D4DE3DEDABDA61F3774AE399B1")
    @DSModeled(DSC.SAFE)
    public SAXNotRecognizedException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.422 -0400", hash_original_method = "84A25E65A73DED1248F34FD8C53BD2A1", hash_generated_method = "9DF065DDB81CC5F2D0A87A27BF9F236D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SAXNotRecognizedException(String message) {
        super(message);
        dsTaint.addTaint(message);
        // ---------- Original Method ----------
    }

    
}

