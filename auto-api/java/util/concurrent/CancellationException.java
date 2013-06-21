package java.util.concurrent;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class CancellationException extends IllegalStateException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.306 -0400", hash_original_method = "C0676E9FE520D18F322700EE730819D6", hash_generated_method = "916A68EDA76ED1B1D1A06764902B741C")
    @DSModeled(DSC.SAFE)
    public CancellationException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.306 -0400", hash_original_method = "6CF19E73C026523F689130FF9C39751C", hash_generated_method = "CE2BAAEC7354E72019728844567DAAFA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CancellationException(String message) {
        super(message);
        dsTaint.addTaint(message);
        // ---------- Original Method ----------
    }

    
    private static final long serialVersionUID = -9202173006928992231L;
}

