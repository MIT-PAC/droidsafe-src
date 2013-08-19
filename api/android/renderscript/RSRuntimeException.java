package android.renderscript;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
public class RSRuntimeException extends java.lang.RuntimeException {
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-19 12:47:21.941 -0400", hash_original_method = "AAC03E0583EBE74CD67A73B383BF3A8F", hash_generated_method = "C3D465C848262260AAFA8CB169E901A9")
    public  RSRuntimeException(String string) {
        super(string);
        addTaint(string.getTaint());
        // ---------- Original Method ----------
    }

    
}

