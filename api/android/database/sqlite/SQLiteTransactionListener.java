package android.database.sqlite;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public interface SQLiteTransactionListener {
    
    void onBegin();

    
    void onCommit();

    
    void onRollback();
}
