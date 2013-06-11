package java.security.cert;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public class CertificateExpiredException extends CertificateException {
    private static final long serialVersionUID = 9071001339691533771L;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.596 -0400", hash_original_method = "695ACDE1E8C2F900ABF7FF7E73A29503", hash_generated_method = "B3ABBE4FBA3A0380DADC7DF54ACBD7A3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CertificateExpiredException(String msg) {
        super(msg);
        dsTaint.addTaint(msg);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.596 -0400", hash_original_method = "308175145F4FC5BAB795337D4AA9A477", hash_generated_method = "56064864F49432D46A49EFA23AC48F93")
    @DSModeled(DSC.SAFE)
    public CertificateExpiredException() {
        // ---------- Original Method ----------
    }

    
}


