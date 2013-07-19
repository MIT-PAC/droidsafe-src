package android.database.sqlite;

// Droidsafe Imports
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public final class SqliteWrapper {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.100 -0400", hash_original_method = "6012CC1B0BDCD376222B54176A59A0F5", hash_generated_method = "4029D590C043C28C47B92BA3BA0590EB")
    private  SqliteWrapper() {
        // ---------- Original Method ----------
    }

    
    private static boolean isLowMemory(SQLiteException e) {
        return e.getMessage().equals(SQLITE_EXCEPTION_DETAIL_MESSAGE);
    }

    
    public static void checkSQLiteException(Context context, SQLiteException e) {
        if (isLowMemory(e)) {
            Toast.makeText(context, com.android.internal.R.string.low_memory,
                    Toast.LENGTH_SHORT).show();
        } else {
            throw e;
        }
    }

    
    @DSModeled(DSC.SPEC)
    public static Cursor query(Context context, ContentResolver resolver, Uri uri,
            String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        try {
            return resolver.query(uri, projection, selection, selectionArgs, sortOrder);
        } catch (SQLiteException e) {
            Log.e(TAG, "Catch a SQLiteException when query: ", e);
            checkSQLiteException(context, e);
            return null;
        }
    }

    
    public static boolean requery(Context context, Cursor cursor) {
        try {
            return cursor.requery();
        } catch (SQLiteException e) {
            Log.e(TAG, "Catch a SQLiteException when requery: ", e);
            checkSQLiteException(context, e);
            return false;
        }
    }

    
    @DSModeled(DSC.SPEC)
    public static int update(Context context, ContentResolver resolver, Uri uri,
            ContentValues values, String where, String[] selectionArgs) {
        try {
            return resolver.update(uri, values, where, selectionArgs);
        } catch (SQLiteException e) {
            Log.e(TAG, "Catch a SQLiteException when update: ", e);
            checkSQLiteException(context, e);
            return -1;
        }
    }

    
    @DSModeled(DSC.SPEC)
    public static int delete(Context context, ContentResolver resolver, Uri uri,
            String where, String[] selectionArgs) {
        try {
            return resolver.delete(uri, where, selectionArgs);
        } catch (SQLiteException e) {
            Log.e(TAG, "Catch a SQLiteException when delete: ", e);
            checkSQLiteException(context, e);
            return -1;
        }
    }

    
    @DSModeled(DSC.SPEC)
    public static Uri insert(Context context, ContentResolver resolver,
            Uri uri, ContentValues values) {
        try {
            return resolver.insert(uri, values);
        } catch (SQLiteException e) {
            Log.e(TAG, "Catch a SQLiteException when insert: ", e);
            checkSQLiteException(context, e);
            return null;
        }
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.105 -0400", hash_original_field = "47AC6CB6E6C4A29C7002300C2F3B787C", hash_generated_field = "604BBA6685F8956D6628D1BB68987870")

    private static final String TAG = "SqliteWrapper";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.106 -0400", hash_original_field = "0D25A3B6C1D453049B793E6B5CF5ECC9", hash_generated_field = "A59C0AD386DF90AEC5C8953C1526585B")

    private static final String SQLITE_EXCEPTION_DETAIL_MESSAGE = "unable to open database file";
}

