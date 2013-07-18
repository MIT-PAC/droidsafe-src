package org.xml.sax;

// Droidsafe Imports
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class SAXNotRecognizedException extends SAXException {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.227 -0400", hash_original_method = "2CF643FEC5E16E9FDCFBAF4C08D87D85", hash_generated_method = "7B2511D4DE3DEDABDA61F3774AE399B1")
    public  SAXNotRecognizedException() {
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.227 -0400", hash_original_method = "84A25E65A73DED1248F34FD8C53BD2A1", hash_generated_method = "E734C444195CF7F783432DCA837236CB")
    public  SAXNotRecognizedException(String message) {
        super(message);
        addTaint(message.getTaint());
        // ---------- Original Method ----------
    }

    
}

