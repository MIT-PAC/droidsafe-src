package android.database.sqlite;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class SQLiteDatabaseCorruptException extends SQLiteException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.609 -0400", hash_original_method = "A79997B6896DE275F44B380F910129E6", hash_generated_method = "B6640DB837766F702DB3455CFC478B7C")
    @DSModeled(DSC.SAFE)
    public SQLiteDatabaseCorruptException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.610 -0400", hash_original_method = "7FA66AC92092139221825F97D9C0ECE6", hash_generated_method = "DB9E878F128C6E87157B4D90C0352949")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SQLiteDatabaseCorruptException(String error) {
        super(error);
        dsTaint.addTaint(error);
        // ---------- Original Method ----------
    }

    
}

