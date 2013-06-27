package java.security.cert;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class CertificateExpiredException extends CertificateException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.474 -0400", hash_original_method = "695ACDE1E8C2F900ABF7FF7E73A29503", hash_generated_method = "3E035F91FD1EAB99F6CA5B96A6EC5AFC")
    public  CertificateExpiredException(String msg) {
        super(msg);
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.475 -0400", hash_original_method = "308175145F4FC5BAB795337D4AA9A477", hash_generated_method = "A30B860C6CB55FC6EAE15A8B4C39A0E5")
    public  CertificateExpiredException() {
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.475 -0400", hash_original_field = "C881639043E4788F90EB763CD807A287", hash_generated_field = "C1DFD010E6BCB7148AC6F5704B496653")

    private static long serialVersionUID = 9071001339691533771L;
}

