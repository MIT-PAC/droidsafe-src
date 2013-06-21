package javax.net.ssl;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class SSLPeerUnverifiedException extends SSLException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.093 -0400", hash_original_method = "198A20ABB6370047567C4951E56F9C8C", hash_generated_method = "1A1FFFE6A72170018F9B2CB40378B467")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SSLPeerUnverifiedException(String reason) {
        super(reason);
        dsTaint.addTaint(reason);
        // ---------- Original Method ----------
    }

    
    private static final long serialVersionUID = -8919512675000600547L;
}

