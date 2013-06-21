package javax.sip;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class ProviderDoesNotExistException extends SipException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.237 -0400", hash_original_method = "EB91B1D62AAE7F3701C2A2F893EEC27E", hash_generated_method = "D61E8ACB3BD9A2FFBF8DFCCE5147FF4B")
    @DSModeled(DSC.SAFE)
    public ProviderDoesNotExistException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.237 -0400", hash_original_method = "1B998FAE6F4B1663E51EF9B76543EA0A", hash_generated_method = "02981B1355DECC307069E163C2C0D75C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ProviderDoesNotExistException(String message) {
        super(message);
        dsTaint.addTaint(message);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.237 -0400", hash_original_method = "FCC82D2910C9FD9AF64C6B2313D46743", hash_generated_method = "0D6E2F2A9ED88E86E05618D6CC90C0A4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ProviderDoesNotExistException(String message, Throwable cause) {
        super(message, cause);
        dsTaint.addTaint(message);
        dsTaint.addTaint(cause.dsTaint);
        // ---------- Original Method ----------
    }

    
}

