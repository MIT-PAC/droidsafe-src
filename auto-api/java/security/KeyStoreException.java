package java.security;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class KeyStoreException extends GeneralSecurityException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.365 -0400", hash_original_method = "7369A8C363020ACD6ED9F21AE7042369", hash_generated_method = "F2221BF0312D8A7D73DCC705CD3A361E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public KeyStoreException(String msg) {
        super(msg);
        dsTaint.addTaint(msg);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.365 -0400", hash_original_method = "A81CEEB8E106BDB258202C5859E57972", hash_generated_method = "B0CFCB7D37C93DFA922912D5B07DB53B")
    @DSModeled(DSC.SAFE)
    public KeyStoreException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.365 -0400", hash_original_method = "B8FD54DFEAD6E5AF89E6549D49EE9467", hash_generated_method = "DBE65EE485F2CA3B2D10E503F6997BBF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public KeyStoreException(String message, Throwable cause) {
        super(message, cause);
        dsTaint.addTaint(message);
        dsTaint.addTaint(cause.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.365 -0400", hash_original_method = "4819C5194870119A368744981D172EEA", hash_generated_method = "C50BFD2C032E3C5A094A3EF3901B3445")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public KeyStoreException(Throwable cause) {
        super(cause);
        dsTaint.addTaint(cause.dsTaint);
        // ---------- Original Method ----------
    }

    
    private static final long serialVersionUID = -1119353179322377262L;
}

