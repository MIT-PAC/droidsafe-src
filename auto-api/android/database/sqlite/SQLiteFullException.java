package android.database.sqlite;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class SQLiteFullException extends SQLiteException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.711 -0400", hash_original_method = "AB54696EF7023A7C1C714A7730C547A0", hash_generated_method = "080B439DBF740C75A77C63660AAD0B4A")
    public  SQLiteFullException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.711 -0400", hash_original_method = "A0C1533F8F26DBEFAEF69363EE9D1839", hash_generated_method = "D9F6DE54F2291552934F10DA35BAB8E0")
    public  SQLiteFullException(String error) {
        super(error);
        addTaint(error.getTaint());
        // ---------- Original Method ----------
    }

    
}

