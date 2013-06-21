package java.security;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class UnrecoverableEntryException extends GeneralSecurityException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.611 -0400", hash_original_method = "B211A6D1B8B83310D4292B140A3F159B", hash_generated_method = "2CFD6E9360722DF4615CD31ABBF0A51F")
    @DSModeled(DSC.SAFE)
    public UnrecoverableEntryException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.611 -0400", hash_original_method = "41796CE6161E063E42FAB82830727D9B", hash_generated_method = "E96FF15028A59A934BE5BDC6CC498F87")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public UnrecoverableEntryException(String msg) {
        super(msg);
        dsTaint.addTaint(msg);
        // ---------- Original Method ----------
    }

    
    private static final long serialVersionUID = -4527142945246286535L;
}

