package android.database.sqlite;

// Droidsafe Imports
import droidsafe.annotations.*;

public interface SQLiteTransactionListener {
    
    void onBegin();

    
    void onCommit();

    
    void onRollback();
}
