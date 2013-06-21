package android.database.sqlite;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class SQLiteFullException extends SQLiteException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.684 -0400", hash_original_method = "AB54696EF7023A7C1C714A7730C547A0", hash_generated_method = "080B439DBF740C75A77C63660AAD0B4A")
    @DSModeled(DSC.SAFE)
    public SQLiteFullException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.684 -0400", hash_original_method = "A0C1533F8F26DBEFAEF69363EE9D1839", hash_generated_method = "B197A41F514138F5F238AC329DEC053B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SQLiteFullException(String error) {
        super(error);
        dsTaint.addTaint(error);
        // ---------- Original Method ----------
    }

    
}

