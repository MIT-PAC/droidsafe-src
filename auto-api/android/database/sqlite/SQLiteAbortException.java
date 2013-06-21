package android.database.sqlite;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class SQLiteAbortException extends SQLiteException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.268 -0400", hash_original_method = "BAF035094CD3ABB670CFC24D953673F5", hash_generated_method = "29329A52ABBAF1DEB572166D2C022263")
    @DSModeled(DSC.SAFE)
    public SQLiteAbortException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.268 -0400", hash_original_method = "40D4C78C8DD7426AF605F2E828ABFEAD", hash_generated_method = "5AD74D9A0A1906661834982AE2A06EB3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SQLiteAbortException(String error) {
        super(error);
        dsTaint.addTaint(error);
        // ---------- Original Method ----------
    }

    
}

