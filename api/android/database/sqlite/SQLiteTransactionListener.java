package android.database.sqlite;

// Droidsafe Imports

public interface SQLiteTransactionListener {
    
    void onBegin();

    
    void onCommit();

    
    void onRollback();
}
