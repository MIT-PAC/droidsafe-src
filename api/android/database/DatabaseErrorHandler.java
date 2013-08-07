package android.database;

// Droidsafe Imports
import droidsafe.annotations.*;
import android.database.sqlite.SQLiteDatabase;

public interface DatabaseErrorHandler {

    
    void onCorruption(SQLiteDatabase dbObj);
}
