package android.database.sqlite;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.database.SQLException;

public class SQLiteException extends SQLException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.676 -0400", hash_original_method = "C0EDC6814EAFE55CC8FBE8FC40236BE6", hash_generated_method = "C8AAD5FA2174518FBC9F4F247BAD5FBE")
    @DSModeled(DSC.SAFE)
    public SQLiteException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.682 -0400", hash_original_method = "0C0BEBB87E389634BC41A00A87165715", hash_generated_method = "AA68D6A215630295F4F02D6357076A6B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SQLiteException(String error) {
        super(error);
        dsTaint.addTaint(error);
        // ---------- Original Method ----------
    }

    
}

