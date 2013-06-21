package android.accounts;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class AuthenticatorException extends AccountsException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.569 -0400", hash_original_method = "009F01E7B15DCE52B30E4E13B8632466", hash_generated_method = "1A7DAA5D19D8820B9379AC93220517C2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AuthenticatorException() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.571 -0400", hash_original_method = "46A5D5B214F277AEF0AE05BAEC539569", hash_generated_method = "8A3D97A7ABB95419D3C5ED32D8670849")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AuthenticatorException(String message) {
        super(message);
        dsTaint.addTaint(message);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.573 -0400", hash_original_method = "11AF1A71F6C16BA9750E55ACCBED5AED", hash_generated_method = "582A70E0E64A602D631E357C34687991")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AuthenticatorException(String message, Throwable cause) {
        super(message, cause);
        dsTaint.addTaint(message);
        dsTaint.addTaint(cause.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.573 -0400", hash_original_method = "649380462FDC9062DB3070254FE15E47", hash_generated_method = "7FD24984640635487EF58B2C5D1AAC2A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AuthenticatorException(Throwable cause) {
        super(cause);
        dsTaint.addTaint(cause.dsTaint);
        // ---------- Original Method ----------
    }

    
}

