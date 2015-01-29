package android.database.sqlite;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class SQLiteDiskIOException extends SQLiteException {
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:43.941 -0500", hash_original_method = "79812D0F211F1884E30281CBD1527413", hash_generated_method = "6F94AD302FE86F9D6E2C034415614CDE")
    
public SQLiteDiskIOException() {}

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:43.946 -0500", hash_original_method = "AEB9A3DB63CF2E99DCD9A5A0555BEBB3", hash_generated_method = "89FDA7E6973D6F329C6B435E46D4C94D")
    
public SQLiteDiskIOException(String error) {
        super(error);
    }
    
}

