package org.apache.http.auth;

// Droidsafe Imports
import droidsafe.annotations.*;
import org.apache.http.ProtocolException;




public class MalformedChallengeException extends ProtocolException {
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.332 -0400", hash_original_method = "67DFA658E3AD1AB9DCC34A02D12F48C7", hash_generated_method = "DD7135A6F0879132601ED482F5246AAD")
    public  MalformedChallengeException() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.332 -0400", hash_original_method = "E77F68EE2D3DB39201883D122D0ED2C1", hash_generated_method = "2D5079BD2A0C5F31137F37D6E8E74ECD")
    public  MalformedChallengeException(String message) {
        super(message);
        addTaint(message.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.333 -0400", hash_original_method = "58A10F22323B4B8503459506A12E3479", hash_generated_method = "1BCCC639E67339D6F613B4C0E1D2F663")
    public  MalformedChallengeException(String message, Throwable cause) {
        super(message, cause);
        addTaint(cause.getTaint());
        addTaint(message.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.333 -0400", hash_original_field = "F7BCBA2FAD23B2DE65F9F7E2B97E7694", hash_generated_field = "AFA1C979014CF4804525DA715B9B4C42")

    private static final long serialVersionUID = 814586927989932284L;
}

