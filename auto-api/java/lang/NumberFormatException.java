package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class NumberFormatException extends IllegalArgumentException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.901 -0400", hash_original_method = "5EB9584C9C40374DC4817FFEDC3C2AF2", hash_generated_method = "CD0AD29B716E5461A290DCEA6E30AEFB")
    @DSModeled(DSC.SAFE)
    public NumberFormatException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.902 -0400", hash_original_method = "E8CAE1FBBA27FF2762363375A55E9E2D", hash_generated_method = "24DD8058BF00CD2383E7D4CEC8B87B78")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NumberFormatException(String detailMessage) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
    private static final long serialVersionUID = -2848938806368998894L;
}

