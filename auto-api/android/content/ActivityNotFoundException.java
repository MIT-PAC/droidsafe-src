package android.content;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class ActivityNotFoundException extends RuntimeException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.979 -0400", hash_original_method = "56CBB1B0D6656A7AA127BFCDE1D30401", hash_generated_method = "4E0E0AF74E2E85C69CA75532FB0A998B")
    @DSModeled(DSC.SAFE)
    public ActivityNotFoundException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.980 -0400", hash_original_method = "8587D789BC6C40698A73B5C613EDE1A6", hash_generated_method = "6B457C8573B0BD6381C8B002B26D563E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ActivityNotFoundException(String name) {
        super(name);
        dsTaint.addTaint(name);
        // ---------- Original Method ----------
    }

    
}

