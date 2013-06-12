package org.xml.sax;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public class SAXNotRecognizedException extends SAXException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.165 -0400", hash_original_method = "2CF643FEC5E16E9FDCFBAF4C08D87D85", hash_generated_method = "7425CE39717BB717B156642BC579E6A7")
    @DSModeled(DSC.SAFE)
    public SAXNotRecognizedException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.165 -0400", hash_original_method = "84A25E65A73DED1248F34FD8C53BD2A1", hash_generated_method = "1CD4C6562872F0EED9511F3E5E69247A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SAXNotRecognizedException(String message) {
        super(message);
        dsTaint.addTaint(message);
        // ---------- Original Method ----------
    }

    
}


