package org.apache.commons.codec;

// Droidsafe Imports
import droidsafe.annotations.*;


public class EncoderException extends Exception {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.596 -0400", hash_original_method = "A6C38593A48889676EEA5C494089AF0E", hash_generated_method = "01E43A6A382467AF4B4E5EACA830A16C")
    public  EncoderException(String pMessage) {
        super(pMessage);
        addTaint(pMessage.getTaint());
        // ---------- Original Method ----------
    }

    
}

