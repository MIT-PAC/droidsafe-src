package java.util.concurrent;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public class CancellationException extends IllegalStateException {
    private static final long serialVersionUID = -9202173006928992231L;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.833 -0400", hash_original_method = "C0676E9FE520D18F322700EE730819D6", hash_generated_method = "2F9E93FB41BCDB3E505C0005E9B75B74")
    @DSModeled(DSC.SAFE)
    public CancellationException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.833 -0400", hash_original_method = "6CF19E73C026523F689130FF9C39751C", hash_generated_method = "E9DDEF972C23D94BBE780FCB6ABBBD5D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CancellationException(String message) {
        super(message);
        dsTaint.addTaint(message);
        // ---------- Original Method ----------
    }

    
}


