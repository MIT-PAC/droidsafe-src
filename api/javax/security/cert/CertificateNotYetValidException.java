package javax.security.cert;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class CertificateNotYetValidException extends CertificateException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:10.249 -0400", hash_original_method = "0159E0DC6739291193C204EC49D53AEB", hash_generated_method = "F79BE1E35B5E0BA4D62C0421534D9CBF")
    public  CertificateNotYetValidException(String msg) {
        super(msg);
        addTaint(msg.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:10.250 -0400", hash_original_method = "66B27F39E6038EA6D4A95D3CE6990BEE", hash_generated_method = "8186B72CEA8C0FBC7D2AEF04F5039821")
    public  CertificateNotYetValidException() {
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:10.250 -0400", hash_original_field = "4D48A8B121C3F9FB7BDFDEBAC2200000", hash_generated_field = "03DE77BA378D4546478F73AECB559735")

    private static final long serialVersionUID = -8976172474266822818L;
}

