package android.database.sqlite;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class SQLiteConstraintException extends SQLiteException {
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:43.201 -0500", hash_original_method = "54E210BA0478409278B66FC02B0AED97", hash_generated_method = "B767F6FF1223E59872B5285AF97324E1")
    
public SQLiteConstraintException() {}

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:43.204 -0500", hash_original_method = "89F6431428B1D3B90E4A41F02ECB258C", hash_generated_method = "1B9088AC708DB04252BB3F046849205E")
    
public SQLiteConstraintException(String error) {
        super(error);
    }
    
}

