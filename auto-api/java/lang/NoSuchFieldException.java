package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class NoSuchFieldException extends Exception {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.894 -0400", hash_original_method = "C9B6E52CB5F5184DC84559DF357B6964", hash_generated_method = "0AA9C44117E303F6AB30495E8744B93B")
    @DSModeled(DSC.SAFE)
    public NoSuchFieldException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.894 -0400", hash_original_method = "3003F78B5EA782042D23C70E768D6CA2", hash_generated_method = "3A7DA5D52A6FE0278B550A3BF7DD56BD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NoSuchFieldException(String detailMessage) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
    private static final long serialVersionUID = -6143714805279938260L;
}

