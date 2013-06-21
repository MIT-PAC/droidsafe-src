package android.database;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class SQLException extends RuntimeException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.213 -0400", hash_original_method = "556E5C618BFB2928AAC4F47E36A85E30", hash_generated_method = "CE8DBAD1AAD3061916D28F23A768DE2E")
    @DSModeled(DSC.SAFE)
    public SQLException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.213 -0400", hash_original_method = "DC2A21E6520D20A30A0F3CD7D71F8640", hash_generated_method = "C106E1BE8BF0CE80235E5D595FDC0783")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SQLException(String error) {
        super(error);
        dsTaint.addTaint(error);
        // ---------- Original Method ----------
    }

    
}

