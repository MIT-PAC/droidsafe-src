package java.security.cert;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.security.GeneralSecurityException;

public class CRLException extends GeneralSecurityException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.614 -0400", hash_original_method = "60672CA36668A1D34242C570333ABE8C", hash_generated_method = "8BBC7A8FB036CAE777E3F0E7181278F1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CRLException(String msg) {
        super(msg);
        dsTaint.addTaint(msg);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.614 -0400", hash_original_method = "5E03B595357100C7FE02CA0C3CD0CBF1", hash_generated_method = "07FD205AE337C0D605903EA8F88E0A30")
    @DSModeled(DSC.SAFE)
    public CRLException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.614 -0400", hash_original_method = "529EF340AA7D68AE4AFE9D9F624919F8", hash_generated_method = "AF6450609F717C33964B83AA42015FDF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CRLException(String message, Throwable cause) {
        super(message, cause);
        dsTaint.addTaint(message);
        dsTaint.addTaint(cause.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.614 -0400", hash_original_method = "DFA7CB52116B1FBFC93D3E254D1E3FDD", hash_generated_method = "988AB1FBF80D7712C0E88CFFB1E146C2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CRLException(Throwable cause) {
        super(cause);
        dsTaint.addTaint(cause.dsTaint);
        // ---------- Original Method ----------
    }

    
    private static final long serialVersionUID = -6694728944094197147L;
}

