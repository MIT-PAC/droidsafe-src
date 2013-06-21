package javax.security.cert;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class CertificateNotYetValidException extends CertificateException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.220 -0400", hash_original_method = "0159E0DC6739291193C204EC49D53AEB", hash_generated_method = "AC6F096C219D9368E6A5D13E0E924517")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CertificateNotYetValidException(String msg) {
        super(msg);
        dsTaint.addTaint(msg);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.220 -0400", hash_original_method = "66B27F39E6038EA6D4A95D3CE6990BEE", hash_generated_method = "8186B72CEA8C0FBC7D2AEF04F5039821")
    @DSModeled(DSC.SAFE)
    public CertificateNotYetValidException() {
        // ---------- Original Method ----------
    }

    
    private static final long serialVersionUID = -8976172474266822818L;
}

