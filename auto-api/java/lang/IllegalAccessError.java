package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class IllegalAccessError extends IncompatibleClassChangeError {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.736 -0400", hash_original_method = "AF78E0BEB545D91D9B237CD89EEDE6D8", hash_generated_method = "FF9C4607F2B6BD8F47118D2DD02021E5")
    @DSModeled(DSC.SAFE)
    public IllegalAccessError() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.736 -0400", hash_original_method = "82FD6CF28C2427CE5A3234413711027B", hash_generated_method = "598F0D1CA5E16370D141FCDDD1039B27")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public IllegalAccessError(String detailMessage) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
    private static final long serialVersionUID = -8988904074992417891L;
}

