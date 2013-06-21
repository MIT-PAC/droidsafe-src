package android.database.sqlite;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public interface SQLiteTransactionListener {
    
    void onBegin();

    
    void onCommit();

    
    void onRollback();
}
