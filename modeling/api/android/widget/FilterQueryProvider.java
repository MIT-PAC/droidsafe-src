package android.widget;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.database.Cursor;

public interface FilterQueryProvider {
   
    @DSVerified
    @DSComment("Abstract Method")
    @DSSpec(DSCat.DATABASE)
    
    @DSSource({DSSourceKind.DATABASE_INFORMATION})
    Cursor runQuery(CharSequence constraint);
}
