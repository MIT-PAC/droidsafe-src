package android.database.sqlite;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public class SQLiteDatabaseCorruptException extends SQLiteException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.812 -0400", hash_original_method = "A79997B6896DE275F44B380F910129E6", hash_generated_method = "3C69D7845E992C6C5CD8DB6CD739D48F")
    @DSModeled(DSC.SAFE)
    public SQLiteDatabaseCorruptException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.812 -0400", hash_original_method = "7FA66AC92092139221825F97D9C0ECE6", hash_generated_method = "01EC5869395235FE26DEBFE4EA943200")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SQLiteDatabaseCorruptException(String error) {
        super(error);
        dsTaint.addTaint(error);
        // ---------- Original Method ----------
    }

    
}


