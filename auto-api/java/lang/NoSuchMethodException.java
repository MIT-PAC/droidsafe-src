package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class NoSuchMethodException extends Exception {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.896 -0400", hash_original_method = "60C13DDE4E49448CC01A624FC168F601", hash_generated_method = "9D9F27795E3EA552118260D151BF3326")
    @DSModeled(DSC.SAFE)
    public NoSuchMethodException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.896 -0400", hash_original_method = "C31CF201699BCB0031463CB0C33C59AC", hash_generated_method = "2887D29839506C256800F93BB9B218F7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NoSuchMethodException(String detailMessage) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
    private static final long serialVersionUID = 5034388446362600923L;
}

