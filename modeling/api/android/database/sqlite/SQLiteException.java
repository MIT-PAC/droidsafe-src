package android.database.sqlite;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.database.SQLException;

public class SQLiteException extends SQLException {
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:39.038 -0500", hash_original_method = "C0EDC6814EAFE55CC8FBE8FC40236BE6", hash_generated_method = "9D0D1E2FAFCD8738DC6FB569EF0DD883")
    
public SQLiteException() {}

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:39.041 -0500", hash_original_method = "0C0BEBB87E389634BC41A00A87165715", hash_generated_method = "13B8EEB845262E78F773C8F3DDF644D4")
    
public SQLiteException(String error) {
        super(error);
    }
    
}

