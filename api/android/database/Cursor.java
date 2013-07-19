package android.database;

// Droidsafe Imports
import android.content.ContentResolver;
import android.net.Uri;
import android.os.Bundle;

public interface Cursor {
    
    
    static final int FIELD_TYPE_NULL = 0;

    
    static final int FIELD_TYPE_INTEGER = 1;

    
    static final int FIELD_TYPE_FLOAT = 2;

    
    static final int FIELD_TYPE_STRING = 3;

    
    static final int FIELD_TYPE_BLOB = 4;

    
    int getCount();

    
    int getPosition();

    
    boolean move(int offset);

    
    boolean moveToPosition(int position);

    
    boolean moveToFirst();

    
    boolean moveToLast();

    
    boolean moveToNext();

    
    boolean moveToPrevious();

    
    boolean isFirst();

    
    boolean isLast();

    
    boolean isBeforeFirst();

    
    boolean isAfterLast();

    
    int getColumnIndex(String columnName);

    
    int getColumnIndexOrThrow(String columnName) throws IllegalArgumentException;

    
    String getColumnName(int columnIndex);

    
    String[] getColumnNames();

    
    int getColumnCount();
    
    
    byte[] getBlob(int columnIndex);

    
    String getString(int columnIndex);
    
    
    void copyStringToBuffer(int columnIndex, CharArrayBuffer buffer);
    
    
    short getShort(int columnIndex);

    
    int getInt(int columnIndex);

    
    long getLong(int columnIndex);

    
    float getFloat(int columnIndex);

    
    double getDouble(int columnIndex);

    
    int getType(int columnIndex);

    
    boolean isNull(int columnIndex);

    
    void deactivate();

    
    @Deprecated
    boolean requery();

    
    void close();

    
    boolean isClosed();
    
    
    void registerContentObserver(ContentObserver observer);

    
    void unregisterContentObserver(ContentObserver observer);
    
    
    void registerDataSetObserver(DataSetObserver observer);

    
    void unregisterDataSetObserver(DataSetObserver observer);

    
    void setNotificationUri(ContentResolver cr, Uri uri);

    
    boolean getWantsAllOnMoveCalls();

    
    Bundle getExtras();

    
    Bundle respond(Bundle extras);
}
