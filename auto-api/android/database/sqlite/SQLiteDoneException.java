package android.database.sqlite;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class SQLiteDoneException extends SQLiteException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.674 -0400", hash_original_method = "087A947C5BE50A0F3752ED574446980B", hash_generated_method = "A74388AF4CC6CB7C05BC0DE595911247")
    @DSModeled(DSC.SAFE)
    public SQLiteDoneException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.674 -0400", hash_original_method = "EE57819E67D990C0D8E763C3CA986E14", hash_generated_method = "49636F5A2DE4C353E32C846D193831E8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SQLiteDoneException(String error) {
        super(error);
        dsTaint.addTaint(error);
        // ---------- Original Method ----------
    }

    
}

