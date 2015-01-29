package android.database;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.content.ContentResolver;
import android.net.Uri;
import android.os.Bundle;

public interface Cursor {
    
    static final int FIELD_TYPE_NULL = 0;
    
    static final int FIELD_TYPE_INTEGER = 1;
    
    static final int FIELD_TYPE_FLOAT = 2;
    
    static final int FIELD_TYPE_STRING = 3;
    
    static final int FIELD_TYPE_BLOB = 4;
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.DB_CURSOR)
    int getCount();
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.DB_CURSOR)
    int getPosition();
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.DB_CURSOR)
    boolean move(int offset);
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.DB_CURSOR)
    boolean moveToPosition(int position);
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.DB_CURSOR)
    boolean moveToFirst();
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.DB_CURSOR)
    boolean moveToLast();
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.DB_CURSOR)
    boolean moveToNext();
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    boolean moveToPrevious();
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    boolean isFirst();
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    boolean isLast();
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    boolean isBeforeFirst();
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.DB_CURSOR)
    boolean isAfterLast();
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.DB_CURSOR)
    int getColumnIndex(String columnName);
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.DB_CURSOR)
    int getColumnIndexOrThrow(String columnName) throws IllegalArgumentException;
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.DB_CURSOR)
    @DSSource({DSSourceKind.DATABASE_INFORMATION})
    String getColumnName(int columnIndex);
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.DB_CURSOR)
    @DSSource({DSSourceKind.DATABASE_INFORMATION})
    String[] getColumnNames();
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.DB_CURSOR)
    int getColumnCount();
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.DB_CURSOR)
    @DSSource({DSSourceKind.DATABASE_INFORMATION})
    byte[] getBlob(int columnIndex);
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.DB_CURSOR)
    @DSSource({DSSourceKind.DATABASE_INFORMATION})
    String getString(int columnIndex);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void copyStringToBuffer(int columnIndex, CharArrayBuffer buffer);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    short getShort(int columnIndex);
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.DB_CURSOR)
    
    @DSSource({DSSourceKind.DATABASE_INFORMATION})
    int getInt(int columnIndex);
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.DB_CURSOR)
    @DSSource({DSSourceKind.DATABASE_INFORMATION})
    long getLong(int columnIndex);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    float getFloat(int columnIndex);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    double getDouble(int columnIndex);
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.DB_CURSOR)
    @DSSource({DSSourceKind.DATABASE_INFORMATION})
    int getType(int columnIndex);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    boolean isNull(int columnIndex);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void deactivate();
    
    @Deprecated
    @DSComment("Abstract Method")
    @DSSpec(DSCat.DATABASE)
    boolean requery();
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.DB_CURSOR)
    void close();
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.DB_CURSOR)
    boolean isClosed();
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.DB_CURSOR)
    void registerContentObserver(ContentObserver observer);
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.DB_CURSOR)
    void unregisterContentObserver(ContentObserver observer);
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.DB_CURSOR)
    void registerDataSetObserver(DataSetObserver observer);
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.DB_CURSOR)
    void unregisterDataSetObserver(DataSetObserver observer);
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.DB_CURSOR)
    void setNotificationUri(ContentResolver cr, Uri uri);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    boolean getWantsAllOnMoveCalls();
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    Bundle getExtras();
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    Bundle respond(Bundle extras);
}
