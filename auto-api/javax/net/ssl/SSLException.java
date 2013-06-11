package javax.net.ssl;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.io.IOException;

public class SSLException extends IOException {
    private static final long serialVersionUID = 4511006460650708967L;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.450 -0400", hash_original_method = "767432C29D53FDFEE031F1BE821865F4", hash_generated_method = "4B8AD0A0AD9A45818B61FB66107B035C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SSLException(String reason) {
        super(reason);
        dsTaint.addTaint(reason);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.450 -0400", hash_original_method = "5FF36E085E786A28DDEEC1EBE169EDD3", hash_generated_method = "592C8CC7B218F1441E6D24C6C0F89541")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SSLException(String message, Throwable cause) {
        super(message);
        dsTaint.addTaint(message);
        dsTaint.addTaint(cause.dsTaint);
        super.initCause(cause);
        // ---------- Original Method ----------
        //super.initCause(cause);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.450 -0400", hash_original_method = "1E7679A49A32A86556807238CABB4D3B", hash_generated_method = "6A3FA42FA4B6E45C7B6DE0D126CAB7E6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SSLException(Throwable cause) {
        super(cause == null ? null : cause.toString());
        dsTaint.addTaint(cause.dsTaint);
        super.initCause(cause);
        // ---------- Original Method ----------
        //super.initCause(cause);
    }

    
}


