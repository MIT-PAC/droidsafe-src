package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class IllegalArgumentException extends RuntimeException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.718 -0400", hash_original_method = "BA7A8F41F569FABF17AACC9F2A0F75BC", hash_generated_method = "34523DED6BE79748F7A3DCC271CA5F6C")
    public  IllegalArgumentException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.718 -0400", hash_original_method = "D7D337F40643B35AC799AE8640B0B8F6", hash_generated_method = "91D50E5F87A394B25394C70A91AC4BAE")
    public  IllegalArgumentException(String detailMessage) {
        super(detailMessage);
        addTaint(detailMessage.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.718 -0400", hash_original_method = "7E098EA3EF50B45CC4772F0CD835FBB7", hash_generated_method = "20D51F3D4E31DE1124FDBE600F70ACEA")
    public  IllegalArgumentException(String message, Throwable cause) {
        super(message, cause);
        addTaint(message.getTaint());
        addTaint(cause.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.718 -0400", hash_original_method = "F1590E7EC4D7642CCEBCDC7875206A8D", hash_generated_method = "370C034F5755F06A996337DF80A60F50")
    public  IllegalArgumentException(Throwable cause) {
        super((cause == null ? null : cause.toString()), cause);
        addTaint(cause.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.726 -0400", hash_original_field = "8FAAC593927CDE780AEEF9ED89530EC8", hash_generated_field = "C7A363CB5F6ECCA77E87E5D098E98F55")

    private static long serialVersionUID = -5365630128856068164L;
}

