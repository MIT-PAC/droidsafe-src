package org.apache.commons.codec;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public class DecoderException extends Exception {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.553 -0400", hash_original_method = "1664CD3D04475564F4589D104C82DEBA", hash_generated_method = "4E2F03537FDABBD9F1C77E8CEE78AEE3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public DecoderException(String pMessage) {
        super(pMessage);
        dsTaint.addTaint(pMessage);
        // ---------- Original Method ----------
    }

    
}


