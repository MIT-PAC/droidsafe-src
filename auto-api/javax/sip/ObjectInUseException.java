package javax.sip;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class ObjectInUseException extends SipException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.234 -0400", hash_original_method = "1506D26AE793C20A85DE50298F844249", hash_generated_method = "8E06DD88D90B8E6C242DDAF66DBF9939")
    @DSModeled(DSC.SAFE)
    public ObjectInUseException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.235 -0400", hash_original_method = "DD9CAB8B2E3E5148E8AE5B5B0A2DE7DC", hash_generated_method = "847593AF73B4EB6350C08C5C701E54B3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ObjectInUseException(String message) {
        super(message);
        dsTaint.addTaint(message);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.235 -0400", hash_original_method = "A64ABB3B61ED7345FBF78ED9BA9ABC4F", hash_generated_method = "6C64931525E5CBF26826B66C824B4E4C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ObjectInUseException(String message, Throwable cause) {
        super(message, cause);
        dsTaint.addTaint(message);
        dsTaint.addTaint(cause.dsTaint);
        // ---------- Original Method ----------
    }

    
}

