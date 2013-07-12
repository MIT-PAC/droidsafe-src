package org.apache.commons.codec;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class DecoderException extends Exception {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:27.791 -0400", hash_original_method = "1664CD3D04475564F4589D104C82DEBA", hash_generated_method = "70D9B7375E850108A0737A02BFA5D579")
    public  DecoderException(String pMessage) {
        super(pMessage);
        addTaint(pMessage.getTaint());
        
    }

    
}

