package android.database.sqlite;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public class SQLiteConstraintException extends SQLiteException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.701 -0400", hash_original_method = "54E210BA0478409278B66FC02B0AED97", hash_generated_method = "7CC7B484C6F2EB2653B1A98A1321ACD5")
    @DSModeled(DSC.SAFE)
    public SQLiteConstraintException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.701 -0400", hash_original_method = "89F6431428B1D3B90E4A41F02ECB258C", hash_generated_method = "D452198BFC52C44D3E76510057608086")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SQLiteConstraintException(String error) {
        super(error);
        dsTaint.addTaint(error);
        // ---------- Original Method ----------
    }

    
}


