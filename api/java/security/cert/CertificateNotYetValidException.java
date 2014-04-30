package java.security.cert;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class CertificateNotYetValidException extends CertificateException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:59.919 -0500", hash_original_field = "186843F3AF86433234D4387E46C8FDCD", hash_generated_field = "7D443A271922D03240C70C2DDC0C4276")

    private static final long serialVersionUID = 4355919900041064702L;

    /**
     * Creates a new {@code CertificateNotYetValidException} with the specified
     * message.
     *
     * @param msg
     *            the detail message for the exception.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:59.922 -0500", hash_original_method = "0159E0DC6739291193C204EC49D53AEB", hash_generated_method = "A8B28F7B42E411ED3535272D4D76A2DF")
    
public CertificateNotYetValidException(String msg) {
        super(msg);
    }

    /**
     * Creates a new {@code CertificateNotYetValidException}.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:59.925 -0500", hash_original_method = "66B27F39E6038EA6D4A95D3CE6990BEE", hash_generated_method = "65B7F900F1A9D6173E490FEEF6D7A94C")
    
public CertificateNotYetValidException() {
    }
}

