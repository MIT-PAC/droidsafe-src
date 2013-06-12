package java.security.cert;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public class CertificateNotYetValidException extends CertificateException {
    private static final long serialVersionUID = 4355919900041064702L;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.599 -0400", hash_original_method = "0159E0DC6739291193C204EC49D53AEB", hash_generated_method = "F3AAABAD865D8F56B5D2C8ACE76E4241")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CertificateNotYetValidException(String msg) {
        super(msg);
        dsTaint.addTaint(msg);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.599 -0400", hash_original_method = "66B27F39E6038EA6D4A95D3CE6990BEE", hash_generated_method = "DD9A856779D3B71994A0CDA251BDB58A")
    @DSModeled(DSC.SAFE)
    public CertificateNotYetValidException() {
        // ---------- Original Method ----------
    }

    
}


