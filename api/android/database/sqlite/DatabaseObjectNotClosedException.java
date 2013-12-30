package android.database.sqlite;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;



public class DatabaseObjectNotClosedException extends RuntimeException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:39.010 -0500", hash_original_field = "C2FC2449D789701D4472507B725134CA", hash_generated_field = "C279E742976D4EC8782AF6C65437682D")

    private static final String s = "Application did not close the cursor or database object " +
            "that was opened here";

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:39.013 -0500", hash_original_method = "94780EE97E0D3B24B7301C55822424F4", hash_generated_method = "3FAE4582FC2DF78B7635977D745A81ED")
    
public DatabaseObjectNotClosedException() {
        super(s);
    }
}

