package javax.net.ssl;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;

public class SSLException extends IOException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.643 -0400", hash_original_method = "767432C29D53FDFEE031F1BE821865F4", hash_generated_method = "BE42D32C1B6DBB96F7457377099FD7BE")
    public  SSLException(String reason) {
        super(reason);
        addTaint(reason.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.643 -0400", hash_original_method = "5FF36E085E786A28DDEEC1EBE169EDD3", hash_generated_method = "0CE8E414E6A51A3C1EEE8FFC083B4177")
    public  SSLException(String message, Throwable cause) {
        super(message);
        super.initCause(cause);
        addTaint(message.getTaint());
        addTaint(cause.getTaint());
        // ---------- Original Method ----------
        //super.initCause(cause);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.643 -0400", hash_original_method = "1E7679A49A32A86556807238CABB4D3B", hash_generated_method = "D2FD23F30F841D3DB81E61EF7C55AA0F")
    public  SSLException(Throwable cause) {
        super(cause == null ? null : cause.toString());
        super.initCause(cause);
        addTaint(cause.getTaint());
        // ---------- Original Method ----------
        //super.initCause(cause);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.643 -0400", hash_original_field = "47B1F27E3208411F6420B784F4A68144", hash_generated_field = "E1A5658E80377BA2C7164C30C5149FA7")

    private static final long serialVersionUID = 4511006460650708967L;
}

