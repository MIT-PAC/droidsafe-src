package android.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class AndroidRuntimeException extends RuntimeException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.088 -0400", hash_original_method = "8C5786A2A5252DB156BAEEC9B2143392", hash_generated_method = "41A0B8709066AE39095C72A04CE366E3")
    @DSModeled(DSC.SAFE)
    public AndroidRuntimeException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.089 -0400", hash_original_method = "8B3545FC9B2683E7AFCB1B7C9932589B", hash_generated_method = "B0DFF8ABCE8F8EE568881AF33F417488")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AndroidRuntimeException(String name) {
        super(name);
        dsTaint.addTaint(name);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.089 -0400", hash_original_method = "396EB52B778995BFC6A3E50EA6AAC7F8", hash_generated_method = "60256A526C1E3566199A39929A0C3764")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AndroidRuntimeException(String name, Throwable cause) {
        super(name, cause);
        dsTaint.addTaint(cause.dsTaint);
        dsTaint.addTaint(name);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.089 -0400", hash_original_method = "ED4D86824E00309868D3D3E5627C1A8D", hash_generated_method = "6F070878131570E594D478B463B30F5A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AndroidRuntimeException(Exception cause) {
        super(cause);
        dsTaint.addTaint(cause.dsTaint);
        // ---------- Original Method ----------
    }

    
}

