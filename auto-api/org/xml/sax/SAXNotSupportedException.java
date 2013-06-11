package org.xml.sax;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public class SAXNotSupportedException extends SAXException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.166 -0400", hash_original_method = "8145A6EACBA97C57F61472FF031DA600", hash_generated_method = "8DBD37C59B893CC7C475E24A067636B6")
    @DSModeled(DSC.SAFE)
    public SAXNotSupportedException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.166 -0400", hash_original_method = "388A9CB995B8D4BAD9F29D89DBB3CE91", hash_generated_method = "08D68CC110063FA61F729868B5F15BC0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SAXNotSupportedException(String message) {
        super(message);
        dsTaint.addTaint(message);
        // ---------- Original Method ----------
    }

    
}


