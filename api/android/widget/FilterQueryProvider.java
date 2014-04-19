package android.widget;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.database.Cursor;

public interface FilterQueryProvider {
   
    @DSVerified
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    
    @DSSource({DSSourceKind.DATABASE})
    Cursor runQuery(CharSequence constraint);
}
