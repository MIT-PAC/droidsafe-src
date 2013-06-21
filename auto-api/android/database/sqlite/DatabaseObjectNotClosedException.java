package android.database.sqlite;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class DatabaseObjectNotClosedException extends RuntimeException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.267 -0400", hash_original_method = "94780EE97E0D3B24B7301C55822424F4", hash_generated_method = "2D2E511949251DC58070A74B02AFBEEF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public DatabaseObjectNotClosedException() {
        super(s);
        // ---------- Original Method ----------
    }

    
    private static final String s = "Application did not close the cursor or database object " +
            "that was opened here";
}

