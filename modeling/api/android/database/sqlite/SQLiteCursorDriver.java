package android.database.sqlite;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

public interface SQLiteCursorDriver {
    
    Cursor query(CursorFactory factory, String[] bindArgs);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void cursorDeactivated();
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void cursorRequeried(Cursor cursor);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void cursorClosed();
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public void setBindArguments(String[] bindArgs);
}
