package javax.security.cert;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class CertificateException extends Exception {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.218 -0400", hash_original_method = "B94F5C9247EB09D2A3B5F93CD6C3CCDF", hash_generated_method = "82CF5C7FDC012409FFA3149251FD2221")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CertificateException(String msg) {
        super(msg);
        dsTaint.addTaint(msg);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.218 -0400", hash_original_method = "FF458EF7F95F357456B3AFD0871B002E", hash_generated_method = "A2AF1A669908D746BA2B02B73E8AC2C3")
    @DSModeled(DSC.SAFE)
    public CertificateException() {
        // ---------- Original Method ----------
    }

    
    private static final long serialVersionUID = -5757213374030785290L;
}

