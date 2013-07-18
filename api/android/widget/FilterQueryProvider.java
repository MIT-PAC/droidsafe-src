package android.widget;

// Droidsafe Imports
import android.database.Cursor;

public interface FilterQueryProvider {
    
    Cursor runQuery(CharSequence constraint);
}
