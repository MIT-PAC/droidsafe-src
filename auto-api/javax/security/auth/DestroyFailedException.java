package javax.security.auth;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class DestroyFailedException extends Exception {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.124 -0400", hash_original_method = "22F1E573FCB9B888944769B0D578ECFF", hash_generated_method = "625155947AD09CAB3856E8CDF9BE43F0")
    @DSModeled(DSC.SAFE)
    public DestroyFailedException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.124 -0400", hash_original_method = "49DB9D74B82421E273A368ED4AD8049A", hash_generated_method = "154C834A4E1E8D69D6FFF00830D691B5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public DestroyFailedException(String message) {
        super(message);
        dsTaint.addTaint(message);
        // ---------- Original Method ----------
    }

    
    private static final long serialVersionUID = -7790152857282749162L;
}

