package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.database.Cursor;

public interface FilterQueryProvider {
    
    Cursor runQuery(CharSequence constraint);
}
