package android.database.sqlite;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class SQLiteConstraintException extends SQLiteException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.153 -0400", hash_original_method = "54E210BA0478409278B66FC02B0AED97", hash_generated_method = "C012C4A362A74E2CB18A66561EDA8AD6")
    public  SQLiteConstraintException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.153 -0400", hash_original_method = "89F6431428B1D3B90E4A41F02ECB258C", hash_generated_method = "574C715742EA196600030FBB507B2ED3")
    public  SQLiteConstraintException(String error) {
        super(error);
        addTaint(error.getTaint());
        // ---------- Original Method ----------
    }

    
}

