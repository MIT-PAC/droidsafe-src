package org.apache.http.impl.auth;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class UnsupportedDigestAlgorithmException extends RuntimeException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.088 -0400", hash_original_method = "4D7AFBD3BCBFF7BF63D8A1B788355A01", hash_generated_method = "99C8C4898B8E414037049A3393B2F06C")
    public  UnsupportedDigestAlgorithmException() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.098 -0400", hash_original_method = "53A11CFB931BDAEE1F32CE61EF0BEDA2", hash_generated_method = "D56D91058196CD98BC4B8FC72E37D24E")
    public  UnsupportedDigestAlgorithmException(String message) {
        super(message);
        addTaint(message.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.099 -0400", hash_original_method = "2D686768D3996E22528B81DECB6C8570", hash_generated_method = "6516DCEE9761746D590148F3E999A5C5")
    public  UnsupportedDigestAlgorithmException(String message, Throwable cause) {
        super(message, cause);
        addTaint(message.getTaint());
        addTaint(cause.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.099 -0400", hash_original_field = "B6875049C22AE30FF1860F662C9EFB04", hash_generated_field = "BBBE410B4557E08B7410F6EB97C85560")

    private static long serialVersionUID = 319558534317118022L;
}

