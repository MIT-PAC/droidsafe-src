package android.database.sqlite;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public class SQLiteFullException extends SQLiteException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.820 -0400", hash_original_method = "AB54696EF7023A7C1C714A7730C547A0", hash_generated_method = "C868D22AB62DDE9DF0797E62BE36A32C")
    @DSModeled(DSC.SAFE)
    public SQLiteFullException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.820 -0400", hash_original_method = "A0C1533F8F26DBEFAEF69363EE9D1839", hash_generated_method = "4C03BF425955EFF2EB2FFC015C828109")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SQLiteFullException(String error) {
        super(error);
        dsTaint.addTaint(error);
        // ---------- Original Method ----------
    }

    
}


