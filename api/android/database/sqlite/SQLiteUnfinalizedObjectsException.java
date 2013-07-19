package android.database.sqlite;

// Droidsafe Imports
import droidsafe.annotations.DSGenerator;

public class SQLiteUnfinalizedObjectsException extends SQLiteException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.086 -0400", hash_original_method = "0168ADBC27E80A037CCB3D02847CE356", hash_generated_method = "BE9ED7898925C6F334EC78DCE051C648")
    public  SQLiteUnfinalizedObjectsException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.087 -0400", hash_original_method = "51C8CDA960D8B159014F6AB9B1E70273", hash_generated_method = "62F661C5FDC6515E9F6630A9021975E3")
    public  SQLiteUnfinalizedObjectsException(String error) {
        super(error);
        addTaint(error.getTaint());
        // ---------- Original Method ----------
    }

    
}

