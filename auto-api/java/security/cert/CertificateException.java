package java.security.cert;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.security.GeneralSecurityException;

public class CertificateException extends GeneralSecurityException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.634 -0400", hash_original_method = "B94F5C9247EB09D2A3B5F93CD6C3CCDF", hash_generated_method = "82CF5C7FDC012409FFA3149251FD2221")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CertificateException(String msg) {
        super(msg);
        dsTaint.addTaint(msg);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.634 -0400", hash_original_method = "FF458EF7F95F357456B3AFD0871B002E", hash_generated_method = "A2AF1A669908D746BA2B02B73E8AC2C3")
    @DSModeled(DSC.SAFE)
    public CertificateException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.634 -0400", hash_original_method = "3E71F41626D2D81134C9C58E70BA9CC7", hash_generated_method = "E463C5C752E9524B8804D1895FB3B963")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CertificateException(String message, Throwable cause) {
        super(message, cause);
        dsTaint.addTaint(message);
        dsTaint.addTaint(cause.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.634 -0400", hash_original_method = "E2FE45CCAA1ECBB72042149ECF15B312", hash_generated_method = "4B35449577E10152D62EE4AFB0D81610")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CertificateException(Throwable cause) {
        super(cause);
        dsTaint.addTaint(cause.dsTaint);
        // ---------- Original Method ----------
    }

    
    private static final long serialVersionUID = 3192535253797119798L;
}

