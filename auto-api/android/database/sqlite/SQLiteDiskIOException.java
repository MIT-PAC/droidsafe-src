package android.database.sqlite;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class SQLiteDiskIOException extends SQLiteException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.670 -0400", hash_original_method = "79812D0F211F1884E30281CBD1527413", hash_generated_method = "84710FAAC729F217AE0CC0FA3CC6C246")
    @DSModeled(DSC.SAFE)
    public SQLiteDiskIOException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.671 -0400", hash_original_method = "AEB9A3DB63CF2E99DCD9A5A0555BEBB3", hash_generated_method = "8F9D1FBFF5AFAFA8BF2088DD92504017")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SQLiteDiskIOException(String error) {
        super(error);
        dsTaint.addTaint(error);
        // ---------- Original Method ----------
    }

    
}

