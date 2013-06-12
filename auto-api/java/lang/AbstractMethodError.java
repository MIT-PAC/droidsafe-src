package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class AbstractMethodError extends IncompatibleClassChangeError {
    private static long serialVersionUID = -1654391082989018462L;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:21:22.827 -0400", hash_original_method = "4F4F671C3B04BA3CBFE40382F9999EB7", hash_generated_method = "03A2C32DEE09DE2A39636CD5AAF29233")
    @DSModeled(DSC.SAFE)
    public AbstractMethodError() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:21:22.832 -0400", hash_original_method = "08FCF39731DB3AF551E2B6A840F345BE", hash_generated_method = "E7CD2104A54F1C506833C20ABFFBA39B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AbstractMethodError(String detailMessage) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
}


