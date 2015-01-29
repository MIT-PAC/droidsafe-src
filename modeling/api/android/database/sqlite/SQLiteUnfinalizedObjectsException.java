package android.database.sqlite;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class SQLiteUnfinalizedObjectsException extends SQLiteException {
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:42.407 -0500", hash_original_method = "0168ADBC27E80A037CCB3D02847CE356", hash_generated_method = "6F89BAE3268F66B22D03F4B61D5C5329")
    
public SQLiteUnfinalizedObjectsException() {}

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:42.409 -0500", hash_original_method = "51C8CDA960D8B159014F6AB9B1E70273", hash_generated_method = "82876987921847D3A6023D3EE28F4142")
    
public SQLiteUnfinalizedObjectsException(String error) {
        super(error);
    }
    
}

