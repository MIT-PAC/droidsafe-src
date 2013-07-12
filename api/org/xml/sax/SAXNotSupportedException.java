package org.xml.sax;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class SAXNotSupportedException extends SAXException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.258 -0400", hash_original_method = "8145A6EACBA97C57F61472FF031DA600", hash_generated_method = "11202C211CE2C664DE0C9CBEED1CA1E9")
    public  SAXNotSupportedException() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.258 -0400", hash_original_method = "388A9CB995B8D4BAD9F29D89DBB3CE91", hash_generated_method = "B17E41F3178F5EDC71086B064EC367B5")
    public  SAXNotSupportedException(String message) {
        super(message);
        addTaint(message.getTaint());
        
    }

    
}

