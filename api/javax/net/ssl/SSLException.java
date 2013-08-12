package javax.net.ssl;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.IOException;




public class SSLException extends IOException {
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.718 -0400", hash_original_method = "767432C29D53FDFEE031F1BE821865F4", hash_generated_method = "BE42D32C1B6DBB96F7457377099FD7BE")
    public  SSLException(String reason) {
        super(reason);
        addTaint(reason.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.718 -0400", hash_original_method = "5FF36E085E786A28DDEEC1EBE169EDD3", hash_generated_method = "69F646BD9CF9C8650FC1C6FF1BAEB9C4")
    public  SSLException(String message, Throwable cause) {
        super(message);
        addTaint(cause.getTaint());
        addTaint(message.getTaint());
        super.initCause(cause);
        // ---------- Original Method ----------
        //super.initCause(cause);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.718 -0400", hash_original_method = "1E7679A49A32A86556807238CABB4D3B", hash_generated_method = "97073F2375FD3040FCE8D76B58FF2939")
    public  SSLException(Throwable cause) {
        super(cause == null ? null : cause.toString());
        addTaint(cause.getTaint());
        super.initCause(cause);
        // ---------- Original Method ----------
        //super.initCause(cause);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.719 -0400", hash_original_field = "47B1F27E3208411F6420B784F4A68144", hash_generated_field = "E1A5658E80377BA2C7164C30C5149FA7")

    private static final long serialVersionUID = 4511006460650708967L;
}

