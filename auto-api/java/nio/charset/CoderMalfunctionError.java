package java.nio.charset;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class CoderMalfunctionError extends Error {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.242 -0400", hash_original_method = "883FFC59265DE3B21E7C8AE56E57641B", hash_generated_method = "4F09CD4CE2DB1C461D54691CCAF5538B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CoderMalfunctionError(Exception ex) {
        super(ex);
        dsTaint.addTaint(ex.dsTaint);
        // ---------- Original Method ----------
    }

    
    private static final long serialVersionUID = -1151412348057794301L;
}

