package android.database.sqlite;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public class SQLiteAbortException extends SQLiteException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.697 -0400", hash_original_method = "BAF035094CD3ABB670CFC24D953673F5", hash_generated_method = "8A8781DEDD3AAE5416428E312CC88E4B")
    @DSModeled(DSC.SAFE)
    public SQLiteAbortException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.698 -0400", hash_original_method = "40D4C78C8DD7426AF605F2E828ABFEAD", hash_generated_method = "8A12288DEA20C5B753BD73F44ABC13AE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SQLiteAbortException(String error) {
        super(error);
        dsTaint.addTaint(error);
        // ---------- Original Method ----------
    }

    
}


