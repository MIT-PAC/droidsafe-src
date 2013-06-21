package android.database;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class CursorWindowAllocationException extends RuntimeException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.095 -0400", hash_original_method = "643AF47320B69D20A3CAAFE0EBF7408E", hash_generated_method = "A4C3994F27B3B688C67A016696EBC6F4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CursorWindowAllocationException(String description) {
        super(description);
        dsTaint.addTaint(description);
        // ---------- Original Method ----------
    }

    
}

