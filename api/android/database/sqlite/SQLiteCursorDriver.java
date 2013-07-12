package android.database.sqlite;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

public interface SQLiteCursorDriver {
    
    Cursor query(CursorFactory factory, String[] bindArgs);

    
    void cursorDeactivated();

    
    void cursorRequeried(Cursor cursor);

    
    void cursorClosed();

    
    public void setBindArguments(String[] bindArgs);
}
