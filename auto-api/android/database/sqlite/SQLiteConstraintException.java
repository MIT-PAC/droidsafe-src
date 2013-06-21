package android.database.sqlite;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class SQLiteConstraintException extends SQLiteException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.282 -0400", hash_original_method = "54E210BA0478409278B66FC02B0AED97", hash_generated_method = "C012C4A362A74E2CB18A66561EDA8AD6")
    @DSModeled(DSC.SAFE)
    public SQLiteConstraintException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.282 -0400", hash_original_method = "89F6431428B1D3B90E4A41F02ECB258C", hash_generated_method = "53AE8EC051A929197FA3C300C3843C92")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SQLiteConstraintException(String error) {
        super(error);
        dsTaint.addTaint(error);
        // ---------- Original Method ----------
    }

    
}

