package javax.net.ssl;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public class SSLProtocolException extends SSLException {
    private static final long serialVersionUID = 5445067063799134928L;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.451 -0400", hash_original_method = "980B3B5BE05602C62F726F0E6039DCA2", hash_generated_method = "0791D3BE41515FDB39DB7E47F7D7B28E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SSLProtocolException(String reason) {
        super(reason);
        dsTaint.addTaint(reason);
        // ---------- Original Method ----------
    }

    
}


