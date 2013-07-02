package android.database.sqlite;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public interface SQLiteTransactionListener {
    
    void onBegin();

    
    void onCommit();

    
    void onRollback();
}
