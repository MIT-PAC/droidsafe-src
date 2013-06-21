package android.database.sqlite;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class SQLiteUnfinalizedObjectsException extends SQLiteException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.918 -0400", hash_original_method = "0168ADBC27E80A037CCB3D02847CE356", hash_generated_method = "BE9ED7898925C6F334EC78DCE051C648")
    @DSModeled(DSC.SAFE)
    public SQLiteUnfinalizedObjectsException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.918 -0400", hash_original_method = "51C8CDA960D8B159014F6AB9B1E70273", hash_generated_method = "DFC709886970603C1794E728DC9094E3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SQLiteUnfinalizedObjectsException(String error) {
        super(error);
        dsTaint.addTaint(error);
        // ---------- Original Method ----------
    }

    
}

