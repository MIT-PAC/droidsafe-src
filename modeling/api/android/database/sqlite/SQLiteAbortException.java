package android.database.sqlite;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class SQLiteAbortException extends SQLiteException {
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:39.899 -0500", hash_original_method = "BAF035094CD3ABB670CFC24D953673F5", hash_generated_method = "9DBC95A09F34DCADBC1BFDB35418F311")
    
public SQLiteAbortException() {}

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:39.902 -0500", hash_original_method = "40D4C78C8DD7426AF605F2E828ABFEAD", hash_generated_method = "D222AF1EF5E327601886E1DDB84F324D")
    
public SQLiteAbortException(String error) {
        super(error);
    }
    
}

