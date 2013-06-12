package java.security.cert;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.security.GeneralSecurityException;

public class CertificateException extends GeneralSecurityException {
    private static final long serialVersionUID = 3192535253797119798L;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.595 -0400", hash_original_method = "B94F5C9247EB09D2A3B5F93CD6C3CCDF", hash_generated_method = "7A723E12E3D61E379D9A5C017E55C243")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CertificateException(String msg) {
        super(msg);
        dsTaint.addTaint(msg);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.595 -0400", hash_original_method = "FF458EF7F95F357456B3AFD0871B002E", hash_generated_method = "3F33EB50CF3FE6DE382CF7A7722FBEAA")
    @DSModeled(DSC.SAFE)
    public CertificateException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.595 -0400", hash_original_method = "3E71F41626D2D81134C9C58E70BA9CC7", hash_generated_method = "7509C94B00B03CADAEB07F80BDAFD0A3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CertificateException(String message, Throwable cause) {
        super(message, cause);
        dsTaint.addTaint(message);
        dsTaint.addTaint(cause.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.595 -0400", hash_original_method = "E2FE45CCAA1ECBB72042149ECF15B312", hash_generated_method = "F933931A4412A9DE81DC449A07C19E33")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CertificateException(Throwable cause) {
        super(cause);
        dsTaint.addTaint(cause.dsTaint);
        // ---------- Original Method ----------
    }

    
}


