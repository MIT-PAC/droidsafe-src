package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class InstantiationException extends Exception {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.753 -0400", hash_original_method = "4FE52ED96718E49A2C12E29EB6D41BB1", hash_generated_method = "41A9F8C5A9604CBE4AC2140585ED8858")
    @DSModeled(DSC.SAFE)
    public InstantiationException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.755 -0400", hash_original_method = "5F54417A31BE783961475C78B79DF3BE", hash_generated_method = "177721EA42FA4999245A8ABD4867394F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public InstantiationException(String detailMessage) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.755 -0400", hash_original_method = "6F408C13CB22C61379FA2022EB73B671", hash_generated_method = "9617A9DC1AF3BFD8356A0E624638D177")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     InstantiationException(Class<?> clazz) {
        super(clazz.getName());
        dsTaint.addTaint(clazz.dsTaint);
        // ---------- Original Method ----------
    }

    
    private static final long serialVersionUID = -8441929162975509110L;
}

