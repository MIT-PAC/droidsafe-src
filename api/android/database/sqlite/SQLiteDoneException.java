package android.database.sqlite;

// Droidsafe Imports
import droidsafe.annotations.DSGenerator;

public class SQLiteDoneException extends SQLiteException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.769 -0400", hash_original_method = "087A947C5BE50A0F3752ED574446980B", hash_generated_method = "A74388AF4CC6CB7C05BC0DE595911247")
    public  SQLiteDoneException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.770 -0400", hash_original_method = "EE57819E67D990C0D8E763C3CA986E14", hash_generated_method = "13D4EF13D2C244E1CD7242F8E67DB475")
    public  SQLiteDoneException(String error) {
        super(error);
        addTaint(error.getTaint());
        // ---------- Original Method ----------
    }

    
}

