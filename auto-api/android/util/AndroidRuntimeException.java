package android.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public class AndroidRuntimeException extends RuntimeException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.565 -0400", hash_original_method = "8C5786A2A5252DB156BAEEC9B2143392", hash_generated_method = "4075C522C652535014B86D0F59B8A4D8")
    @DSModeled(DSC.SAFE)
    public AndroidRuntimeException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.565 -0400", hash_original_method = "8B3545FC9B2683E7AFCB1B7C9932589B", hash_generated_method = "7CB0CB327B27AADBEDEC7315DFA30071")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AndroidRuntimeException(String name) {
        super(name);
        dsTaint.addTaint(name);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.565 -0400", hash_original_method = "396EB52B778995BFC6A3E50EA6AAC7F8", hash_generated_method = "5E0B8D9328521E83DA0285CBCDE7B987")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AndroidRuntimeException(String name, Throwable cause) {
        super(name, cause);
        dsTaint.addTaint(cause.dsTaint);
        dsTaint.addTaint(name);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.566 -0400", hash_original_method = "ED4D86824E00309868D3D3E5627C1A8D", hash_generated_method = "473034B751332A16681E1F5479849E5D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AndroidRuntimeException(Exception cause) {
        super(cause);
        dsTaint.addTaint(cause.dsTaint);
        // ---------- Original Method ----------
    }

    
}


