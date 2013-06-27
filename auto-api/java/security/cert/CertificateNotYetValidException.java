package java.security.cert;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class CertificateNotYetValidException extends CertificateException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.494 -0400", hash_original_method = "0159E0DC6739291193C204EC49D53AEB", hash_generated_method = "F79BE1E35B5E0BA4D62C0421534D9CBF")
    public  CertificateNotYetValidException(String msg) {
        super(msg);
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.495 -0400", hash_original_method = "66B27F39E6038EA6D4A95D3CE6990BEE", hash_generated_method = "8186B72CEA8C0FBC7D2AEF04F5039821")
    public  CertificateNotYetValidException() {
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.495 -0400", hash_original_field = "B9D639E2BF9364EC0EF344451ED8BF03", hash_generated_field = "06BCB433878C3E72054CE9107A8DBB3F")

    private static long serialVersionUID = 4355919900041064702L;
}

