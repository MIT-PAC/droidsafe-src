package javax.sip;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class InvalidArgumentException extends SipException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.233 -0400", hash_original_method = "058727A85A3561BD87B89BB684E2068E", hash_generated_method = "4A6154754A702AA8F9C7A1F4710C43C1")
    @DSModeled(DSC.SAFE)
    public InvalidArgumentException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.233 -0400", hash_original_method = "6CFB0BD92581CA0A67925F5045802025", hash_generated_method = "63A628534DECAB0958C947FACA77C57C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public InvalidArgumentException(String message) {
        super(message);
        dsTaint.addTaint(message);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.233 -0400", hash_original_method = "36D7705F557972E94094B17807C973B6", hash_generated_method = "173E5F85FB1BA187E147455DE07A5E19")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public InvalidArgumentException(String message, Throwable cause) {
        super(message, cause);
        dsTaint.addTaint(message);
        dsTaint.addTaint(cause.dsTaint);
        // ---------- Original Method ----------
    }

    
}

