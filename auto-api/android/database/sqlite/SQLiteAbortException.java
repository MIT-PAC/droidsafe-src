package android.database.sqlite;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class SQLiteAbortException extends SQLiteException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.759 -0400", hash_original_method = "BAF035094CD3ABB670CFC24D953673F5", hash_generated_method = "29329A52ABBAF1DEB572166D2C022263")
    public  SQLiteAbortException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.760 -0400", hash_original_method = "40D4C78C8DD7426AF605F2E828ABFEAD", hash_generated_method = "1E307874BECBCE18B11DB8155B851A97")
    public  SQLiteAbortException(String error) {
        super(error);
        addTaint(error.getTaint());
        // ---------- Original Method ----------
    }

    
}

