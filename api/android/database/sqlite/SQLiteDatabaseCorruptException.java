package android.database.sqlite;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class SQLiteDatabaseCorruptException extends SQLiteException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.932 -0400", hash_original_method = "A79997B6896DE275F44B380F910129E6", hash_generated_method = "B6640DB837766F702DB3455CFC478B7C")
    public  SQLiteDatabaseCorruptException() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.933 -0400", hash_original_method = "7FA66AC92092139221825F97D9C0ECE6", hash_generated_method = "76EC191A9D1B69B01BAB46920D4F9641")
    public  SQLiteDatabaseCorruptException(String error) {
        super(error);
        addTaint(error.getTaint());
        
    }

    
}

