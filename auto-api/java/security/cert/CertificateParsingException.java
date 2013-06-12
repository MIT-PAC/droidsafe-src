package java.security.cert;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public class CertificateParsingException extends CertificateException {
    private static final long serialVersionUID = -7989222416793322029L;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.600 -0400", hash_original_method = "52C1CA38DD038BC33FD4ADF2F8CE17BE", hash_generated_method = "346DE501C268CDE42E9ACA5C37569982")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CertificateParsingException(String msg) {
        super(msg);
        dsTaint.addTaint(msg);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.600 -0400", hash_original_method = "8DA8B534EA167A5C50442E9F25486020", hash_generated_method = "6EDF4B8332FB1899171717B63AE96BD0")
    @DSModeled(DSC.SAFE)
    public CertificateParsingException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.600 -0400", hash_original_method = "7DFD64EF17D16B3CA905ED3004EA7773", hash_generated_method = "49E0EB71FBD7111889B4FEC11D236494")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CertificateParsingException(String message, Throwable cause) {
        super(message, cause);
        dsTaint.addTaint(message);
        dsTaint.addTaint(cause.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.600 -0400", hash_original_method = "655AB0A50E551680E7DF5C232C5D908E", hash_generated_method = "DB799C0EE89F912C7D7A6A6497C07456")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CertificateParsingException(Throwable cause) {
        super(cause);
        dsTaint.addTaint(cause.dsTaint);
        // ---------- Original Method ----------
    }

    
}


