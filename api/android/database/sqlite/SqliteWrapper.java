package android.database.sqlite;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;





public final class SqliteWrapper {

    // FIXME: need to optimize this method.
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:43.609 -0500", hash_original_method = "43181FB3B6A2D4F44BBC07717E6979FA", hash_generated_method = "6BDA45268EEBD89D7BCE460495F34084")
    
private static boolean isLowMemory(SQLiteException e) {
        return e.getMessage().equals(SQLITE_EXCEPTION_DETAIL_MESSAGE);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:43.614 -0500", hash_original_method = "A7751795FABF0F0D80DE2A97C2A71921", hash_generated_method = "7226950EB0B506CD576B0C5B21BF9CCA")
    
public static void checkSQLiteException(Context context, SQLiteException e) {
        if (isLowMemory(e)) {
            Toast.makeText(context, com.android.internal.R.string.low_memory,
                    Toast.LENGTH_SHORT).show();
        } else {
            throw e;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:43.619 -0500", hash_original_method = "28F6C2098BB23ED205ECF1E1CF2C7EF8", hash_generated_method = "E2F664B6D5B16A5EDFE3AC20C704D6A0")
    
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:43.623 -0500", hash_original_method = "C45F0D9CC4B80DD777A085922C4B8442", hash_generated_method = "249695D9660CDF6D8A57F66996D05411")
    
public static boolean requery(Context context, Cursor cursor) {
        try {
            return cursor.requery();
        } catch (SQLiteException e) {
            Log.e(TAG, "Catch a SQLiteException when requery: ", e);
            checkSQLiteException(context, e);
            return false;
        }
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:43.627 -0500", hash_original_method = "58979A6FBAE8FF11396F6F3A839EB861", hash_generated_method = "F86DA21FA864E3CA74B65E37241380E1")
    
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:43.630 -0500", hash_original_method = "F4A5662AA8A0413E3E7EF8259F87513C", hash_generated_method = "CD8F1A12585947EB887BC6457AAD0182")
    
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:43.632 -0500", hash_original_method = "5C6932B23CF54246FCBC69F0B1787A10", hash_generated_method = "033BCF3796C657E5663BE2A203C22E9D")
    
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:43.595 -0500", hash_original_field = "C6ECD9FCEDB76ADA63C1BC714D087575", hash_generated_field = "604BBA6685F8956D6628D1BB68987870")

    private static final String TAG = "SqliteWrapper";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:43.600 -0500", hash_original_field = "92D317096DABE5820A5943D0FDDA4CB4", hash_generated_field = "A59C0AD386DF90AEC5C8953C1526585B")

    private static final String SQLITE_EXCEPTION_DETAIL_MESSAGE
                = "unable to open database file";

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:43.605 -0500", hash_original_method = "6012CC1B0BDCD376222B54176A59A0F5", hash_generated_method = "8CF65362502EEA702895B8F67B77C271")
    
private SqliteWrapper() {
        // Forbidden being instantiated.
    }
}

