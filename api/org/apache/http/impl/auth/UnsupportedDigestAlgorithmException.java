package org.apache.http.impl.auth;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class UnsupportedDigestAlgorithmException extends RuntimeException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.480 -0400", hash_original_method = "4D7AFBD3BCBFF7BF63D8A1B788355A01", hash_generated_method = "99C8C4898B8E414037049A3393B2F06C")
    public  UnsupportedDigestAlgorithmException() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.480 -0400", hash_original_method = "53A11CFB931BDAEE1F32CE61EF0BEDA2", hash_generated_method = "D56D91058196CD98BC4B8FC72E37D24E")
    public  UnsupportedDigestAlgorithmException(String message) {
        super(message);
        addTaint(message.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.481 -0400", hash_original_method = "2D686768D3996E22528B81DECB6C8570", hash_generated_method = "0EC0A2DD8529A417576C4C254B909094")
    public  UnsupportedDigestAlgorithmException(String message, Throwable cause) {
        super(message, cause);
        addTaint(cause.getTaint());
        addTaint(message.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.481 -0400", hash_original_field = "B6875049C22AE30FF1860F662C9EFB04", hash_generated_field = "61CED41D2DA90D7495CCD2197DC1362E")

    private static final long serialVersionUID = 319558534317118022L;
}

