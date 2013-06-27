package android.database.sqlite;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class DatabaseObjectNotClosedException extends RuntimeException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.261 -0400", hash_original_method = "94780EE97E0D3B24B7301C55822424F4", hash_generated_method = "2D2E511949251DC58070A74B02AFBEEF")
    public  DatabaseObjectNotClosedException() {
        super(s);
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.261 -0400", hash_original_field = "ADE3DB9CDC65C9BD692E1F48CA2870B7", hash_generated_field = "8AA1E9430F573639531A55DBDDCA9FBE")

    private static String s = "Application did not close the cursor or database object " +
            "that was opened here";
}

