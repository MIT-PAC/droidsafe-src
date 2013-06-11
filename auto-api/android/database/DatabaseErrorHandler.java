package android.database;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.database.sqlite.SQLiteDatabase;

public interface DatabaseErrorHandler {

    
    void onCorruption(SQLiteDatabase dbObj);
}

