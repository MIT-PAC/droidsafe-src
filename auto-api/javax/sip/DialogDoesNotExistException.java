package javax.sip;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class DialogDoesNotExistException extends SipException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.229 -0400", hash_original_method = "9202A0FE59991A3B0A837B4E7082EB36", hash_generated_method = "1B44DD3DAF591CD5FC0BE6F2586414D3")
    @DSModeled(DSC.SAFE)
    public DialogDoesNotExistException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.229 -0400", hash_original_method = "92D6A3CD46517681F25A7E8C2DA97A21", hash_generated_method = "7036721DA9C9D4DD767B9CDF9D87D751")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public DialogDoesNotExistException(String message) {
        super(message);
        dsTaint.addTaint(message);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.229 -0400", hash_original_method = "3EDA84A1781F815A2C18879AE2F847E8", hash_generated_method = "A85895E15FECF22FF08AACDDC118E369")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public DialogDoesNotExistException(String message, Throwable cause) {
        super(message, cause);
        dsTaint.addTaint(message);
        dsTaint.addTaint(cause.dsTaint);
        // ---------- Original Method ----------
    }

    
}

