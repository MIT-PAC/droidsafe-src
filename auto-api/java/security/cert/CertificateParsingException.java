package java.security.cert;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class CertificateParsingException extends CertificateException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.647 -0400", hash_original_method = "52C1CA38DD038BC33FD4ADF2F8CE17BE", hash_generated_method = "88C95C840E0A23A3217C3384B3ACA72B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CertificateParsingException(String msg) {
        super(msg);
        dsTaint.addTaint(msg);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.647 -0400", hash_original_method = "8DA8B534EA167A5C50442E9F25486020", hash_generated_method = "B20A17E5EA8D79E40D983186BAEA27C7")
    @DSModeled(DSC.SAFE)
    public CertificateParsingException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.647 -0400", hash_original_method = "7DFD64EF17D16B3CA905ED3004EA7773", hash_generated_method = "48590C7772CA9F32777F6F6B57BBA75C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CertificateParsingException(String message, Throwable cause) {
        super(message, cause);
        dsTaint.addTaint(message);
        dsTaint.addTaint(cause.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.647 -0400", hash_original_method = "655AB0A50E551680E7DF5C232C5D908E", hash_generated_method = "0B84534E64F4D8D7AC3D61B2807FA5A2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CertificateParsingException(Throwable cause) {
        super(cause);
        dsTaint.addTaint(cause.dsTaint);
        // ---------- Original Method ----------
    }

    
    private static final long serialVersionUID = -7989222416793322029L;
}

