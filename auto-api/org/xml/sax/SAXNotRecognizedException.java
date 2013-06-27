package org.xml.sax;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class SAXNotRecognizedException extends SAXException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.019 -0400", hash_original_method = "2CF643FEC5E16E9FDCFBAF4C08D87D85", hash_generated_method = "7B2511D4DE3DEDABDA61F3774AE399B1")
    public  SAXNotRecognizedException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.020 -0400", hash_original_method = "84A25E65A73DED1248F34FD8C53BD2A1", hash_generated_method = "E734C444195CF7F783432DCA837236CB")
    public  SAXNotRecognizedException(String message) {
        super(message);
        addTaint(message.getTaint());
        // ---------- Original Method ----------
    }

    
}

