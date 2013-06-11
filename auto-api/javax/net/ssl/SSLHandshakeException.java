package javax.net.ssl;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public class SSLHandshakeException extends SSLException {
    private static final long serialVersionUID = -5045881315018326890L;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.451 -0400", hash_original_method = "82B36E212F934FE090A9654C18E5A390", hash_generated_method = "DFF196D2E981EA018B6A7C9FF4443B0C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SSLHandshakeException(String reason) {
        super(reason);
        dsTaint.addTaint(reason);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.451 -0400", hash_original_method = "6E4EDFE9C902AE43BD6AF73325E7CB73", hash_generated_method = "E7C11C2DB87A0332CA7D43A854CC6D6A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SSLHandshakeException(Throwable cause) {
        super(cause);
        dsTaint.addTaint(cause.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.451 -0400", hash_original_method = "7F0A583E3C5916ED2C2C7E0A6DE82F31", hash_generated_method = "C7152D832EA47BC36E6EE469EAA7D403")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SSLHandshakeException(String reason, Throwable cause) {
        super(reason, cause);
        dsTaint.addTaint(cause.dsTaint);
        dsTaint.addTaint(reason);
        // ---------- Original Method ----------
    }

    
}


