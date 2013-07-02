package org.apache.harmony.xml;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

class ExpatException extends Exception {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.619 -0400", hash_original_method = "0929E937B15E2591C534268B5A2E4F52", hash_generated_method = "3609C3E0FD35A2DFB58D6A962D5E10BB")
    public  ExpatException(String message) {
        super(message);
        addTaint(message.getTaint());
        
    }

    
}

