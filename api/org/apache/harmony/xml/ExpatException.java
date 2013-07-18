package org.apache.harmony.xml;

// Droidsafe Imports
import droidsafe.annotations.DSGenerator;

class ExpatException extends Exception {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.013 -0400", hash_original_method = "0929E937B15E2591C534268B5A2E4F52", hash_generated_method = "3609C3E0FD35A2DFB58D6A962D5E10BB")
    public  ExpatException(String message) {
        super(message);
        addTaint(message.getTaint());
        // ---------- Original Method ----------
    }

    
}

