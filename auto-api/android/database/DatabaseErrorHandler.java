package android.database;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.database.sqlite.SQLiteDatabase;

public interface DatabaseErrorHandler {

    
    void onCorruption(SQLiteDatabase dbObj);
}
