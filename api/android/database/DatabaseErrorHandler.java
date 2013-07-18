package android.database;

// Droidsafe Imports
import android.database.sqlite.SQLiteDatabase;

public interface DatabaseErrorHandler {

    
    void onCorruption(SQLiteDatabase dbObj);
}
