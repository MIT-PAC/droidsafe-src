package android.content;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public class ActivityNotFoundException extends RuntimeException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.199 -0400", hash_original_method = "56CBB1B0D6656A7AA127BFCDE1D30401", hash_generated_method = "1E2CEB87015240A95BF1F7FD1DF047C2")
    @DSModeled(DSC.SAFE)
    public ActivityNotFoundException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.200 -0400", hash_original_method = "8587D789BC6C40698A73B5C613EDE1A6", hash_generated_method = "AFDBDD1BAB9F6A34615F7B1269A2C908")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ActivityNotFoundException(String name) {
        super(name);
        dsTaint.addTaint(name);
        // ---------- Original Method ----------
    }

    
}


