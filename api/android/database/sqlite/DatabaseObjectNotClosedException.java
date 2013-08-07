package android.database.sqlite;

// Droidsafe Imports
import droidsafe.annotations.*;



public class DatabaseObjectNotClosedException extends RuntimeException {
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.155 -0400", hash_original_method = "94780EE97E0D3B24B7301C55822424F4", hash_generated_method = "2D2E511949251DC58070A74B02AFBEEF")
    public  DatabaseObjectNotClosedException() {
        super(s);
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.155 -0400", hash_original_field = "ADE3DB9CDC65C9BD692E1F48CA2870B7", hash_generated_field = "C279E742976D4EC8782AF6C65437682D")

    private static final String s = "Application did not close the cursor or database object " +
            "that was opened here";
}

