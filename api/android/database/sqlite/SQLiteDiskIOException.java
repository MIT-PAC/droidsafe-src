package android.database.sqlite;

// Droidsafe Imports
import droidsafe.annotations.*;


public class SQLiteDiskIOException extends SQLiteException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.760 -0400", hash_original_method = "79812D0F211F1884E30281CBD1527413", hash_generated_method = "84710FAAC729F217AE0CC0FA3CC6C246")
    public  SQLiteDiskIOException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.761 -0400", hash_original_method = "AEB9A3DB63CF2E99DCD9A5A0555BEBB3", hash_generated_method = "DE6D3A33DB6FB472E6A8C2008FA0E02A")
    public  SQLiteDiskIOException(String error) {
        super(error);
        addTaint(error.getTaint());
        // ---------- Original Method ----------
    }

    
}

