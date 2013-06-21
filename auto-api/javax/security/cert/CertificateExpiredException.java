package javax.security.cert;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class CertificateExpiredException extends CertificateException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.219 -0400", hash_original_method = "695ACDE1E8C2F900ABF7FF7E73A29503", hash_generated_method = "A2DAA35835C805B330634CBE4C9B2D3C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CertificateExpiredException(String msg) {
        super(msg);
        dsTaint.addTaint(msg);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.219 -0400", hash_original_method = "308175145F4FC5BAB795337D4AA9A477", hash_generated_method = "A30B860C6CB55FC6EAE15A8B4C39A0E5")
    @DSModeled(DSC.SAFE)
    public CertificateExpiredException() {
        // ---------- Original Method ----------
    }

    
    private static final long serialVersionUID = 5091601212177261883L;
}

