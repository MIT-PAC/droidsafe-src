package javax.net.ssl;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class SSLProtocolException extends SSLException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.095 -0400", hash_original_method = "980B3B5BE05602C62F726F0E6039DCA2", hash_generated_method = "742A886B66C094BFBF978881F39AED01")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SSLProtocolException(String reason) {
        super(reason);
        dsTaint.addTaint(reason);
        // ---------- Original Method ----------
    }

    
    private static final long serialVersionUID = 5445067063799134928L;
}

