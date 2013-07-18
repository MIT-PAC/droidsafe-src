package android.database.sqlite;

// Droidsafe Imports
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class SQLiteConstraintException extends SQLiteException {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.240 -0400", hash_original_method = "54E210BA0478409278B66FC02B0AED97", hash_generated_method = "C012C4A362A74E2CB18A66561EDA8AD6")
    public  SQLiteConstraintException() {
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.241 -0400", hash_original_method = "89F6431428B1D3B90E4A41F02ECB258C", hash_generated_method = "574C715742EA196600030FBB507B2ED3")
    public  SQLiteConstraintException(String error) {
        super(error);
        addTaint(error.getTaint());
        // ---------- Original Method ----------
    }

    
}

