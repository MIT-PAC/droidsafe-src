package android.database;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.runtime.DroidSafeAndroidRuntime;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import org.apache.commons.codec.binary.Hex;
import android.content.ContentValues;
import android.content.Context;
import android.content.OperationApplicationException;
import android.database.sqlite.SQLiteAbortException;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteDiskIOException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.database.sqlite.SQLiteProgram;
import android.database.sqlite.SQLiteStatement;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.util.Log;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.text.Collator;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class DatabaseUtils {
    private static final String TAG = "DatabaseUtils";
    private static final boolean DEBUG = false;
    private static final boolean LOCAL_LOGV = false;
    private static final String[] countProjection = new String[]{"count(*)"};
    public static final int STATEMENT_SELECT = 1;
    public static final int STATEMENT_UPDATE = 2;
    public static final int STATEMENT_ATTACH = 3;
    public static final int STATEMENT_BEGIN = 4;
    public static final int STATEMENT_COMMIT = 5;
    public static final int STATEMENT_ABORT = 6;
    public static final int STATEMENT_PRAGMA = 7;
    public static final int STATEMENT_DDL = 8;
    public static final int STATEMENT_UNPREPARED = 9;
    public static final int STATEMENT_OTHER = 99;
    private static Collator mColl = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.665 -0400", hash_original_method = "664E69D53BABC0BD392ABB3CB5A666E2", hash_generated_method = "C60B3995A03D789E2D24A318F2E3BDC4")
    public static final void writeExceptionToParcel(Parcel reply, Exception e) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        int code = 0;
        boolean logException = true;
        if (e instanceof FileNotFoundException) {
            code = 1;
            logException = false;
        } else if (e instanceof IllegalArgumentException) {
            code = 2;
        } else if (e instanceof UnsupportedOperationException) {
            code = 3;
        } else if (e instanceof SQLiteAbortException) {
            code = 4;
        } else if (e instanceof SQLiteConstraintException) {
            code = 5;
        } else if (e instanceof SQLiteDatabaseCorruptException) {
            code = 6;
        } else if (e instanceof SQLiteFullException) {
            code = 7;
        } else if (e instanceof SQLiteDiskIOException) {
            code = 8;
        } else if (e instanceof SQLiteException) {
            code = 9;
        } else if (e instanceof OperationApplicationException) {
            code = 10;
        } else {
            reply.writeException(e);
            Log.e(TAG, "Writing exception to parcel", e);
            return;
        }
        reply.writeInt(code);
        reply.writeString(e.getMessage());
        if (logException) {
            Log.e(TAG, "Writing exception to parcel", e);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.665 -0400", hash_original_method = "99279A6650B0C93FCFD173D39A34CB97", hash_generated_method = "5ED637AD403F449370C6484081B59886")
    public static final void readExceptionFromParcel(Parcel reply) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        int code = reply.readExceptionCode();
        if (code == 0) return;
        String msg = reply.readString();
        DatabaseUtils.readExceptionFromParcel(reply, msg, code);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.665 -0400", hash_original_method = "3CD1B88164A3210A879F7432B20509CE", hash_generated_method = "8961CBABBF41CBD35B833909FD66F978")
    public static void readExceptionWithFileNotFoundExceptionFromParcel(
            Parcel reply) throws FileNotFoundException {
        //DSFIXME:  CODE0009: Possible callback target function detected
        int code = reply.readExceptionCode();
        if (code == 0) return;
        String msg = reply.readString();
        if (code == 1) {
            throw new FileNotFoundException(msg);
        } else {
            DatabaseUtils.readExceptionFromParcel(reply, msg, code);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.665 -0400", hash_original_method = "2492E7AEC13D0FFFB95F298C13FF8172", hash_generated_method = "7ACD3C7B0D662BDD2AFB92F0E5F5E325")
    public static void readExceptionWithOperationApplicationExceptionFromParcel(
            Parcel reply) throws OperationApplicationException {
        //DSFIXME:  CODE0009: Possible callback target function detected
        int code = reply.readExceptionCode();
        if (code == 0) return;
        String msg = reply.readString();
        if (code == 10) {
            throw new OperationApplicationException(msg);
        } else {
            DatabaseUtils.readExceptionFromParcel(reply, msg, code);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.665 -0400", hash_original_method = "7C5917B72662210A19A77F7241EE9613", hash_generated_method = "F38ED1D49B1B724ADD3CC2D9E4EA4904")
    private static final void readExceptionFromParcel(Parcel reply, String msg, int code) {
        switch (code) {
            case 2:
                throw new IllegalArgumentException(msg);
            case 3:
                throw new UnsupportedOperationException(msg);
            case 4:
                throw new SQLiteAbortException(msg);
            case 5:
                throw new SQLiteConstraintException(msg);
            case 6:
                throw new SQLiteDatabaseCorruptException(msg);
            case 7:
                throw new SQLiteFullException(msg);
            case 8:
                throw new SQLiteDiskIOException(msg);
            case 9:
                throw new SQLiteException(msg);
            default:
                reply.readException(code, msg);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.666 -0400", hash_original_method = "336103AA7A2D233179336448C933A29F", hash_generated_method = "21FE3D0EE05FB1E77838C07BDFA9BA55")
    public static void bindObjectToProgram(SQLiteProgram prog, int index,
            Object value) {
        if (value == null) {
            prog.bindNull(index);
        } else if (value instanceof Double || value instanceof Float) {
            prog.bindDouble(index, ((Number)value).doubleValue());
        } else if (value instanceof Number) {
            prog.bindLong(index, ((Number)value).longValue());
        } else if (value instanceof Boolean) {
            Boolean bool = (Boolean)value;
            if (bool) {
                prog.bindLong(index, 1);
            } else {
                prog.bindLong(index, 0);
            }
        } else if (value instanceof byte[]){
            prog.bindBlob(index, (byte[]) value);
        } else {
            prog.bindString(index, value.toString());
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.666 -0400", hash_original_method = "4F212FF7EF5441857670A3D4278A69D1", hash_generated_method = "806E2AB1FCF1B6B9FFFEC177C4F4A9EE")
    public static int getTypeOfObject(Object obj) {
        if (obj == null) {
            return Cursor.FIELD_TYPE_NULL;
        } else if (obj instanceof byte[]) {
            return Cursor.FIELD_TYPE_BLOB;
        } else if (obj instanceof Float || obj instanceof Double) {
            return Cursor.FIELD_TYPE_FLOAT;
        } else if (obj instanceof Long || obj instanceof Integer
                || obj instanceof Short || obj instanceof Byte) {
            return Cursor.FIELD_TYPE_INTEGER;
        } else {
            return Cursor.FIELD_TYPE_STRING;
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.666 -0400", hash_original_method = "528BFFCDF2670C473C5EA8B806C4B8BC", hash_generated_method = "D5821C733E8526AA2161D25DD7CE54F1")
    public static void cursorFillWindow(final Cursor cursor,
            int position, final CursorWindow window) {
        if (position < 0 || position >= cursor.getCount()) {
            return;
        }
        window.acquireReference();
        try {
            final int oldPos = cursor.getPosition();
            final int numColumns = cursor.getColumnCount();
            window.clear();
            window.setStartPosition(position);
            window.setNumColumns(numColumns);
            if (cursor.moveToPosition(position)) {
                do {
                    if (!window.allocRow()) {
                        break;
                    }
                    for (int i = 0; i < numColumns; i++) {
                        final int type = cursor.getType(i);
                        final boolean success;
                        switch (type) {
                            case Cursor.FIELD_TYPE_NULL:
                                success = window.putNull(position, i);
                                break;
                            case Cursor.FIELD_TYPE_INTEGER:
                                success = window.putLong(cursor.getLong(i), position, i);
                                break;
                            case Cursor.FIELD_TYPE_FLOAT:
                                success = window.putDouble(cursor.getDouble(i), position, i);
                                break;
                            case Cursor.FIELD_TYPE_BLOB: {
                                final byte[] value = cursor.getBlob(i);
                                success = value != null ? window.putBlob(value, position, i)
                                        : window.putNull(position, i);
                                break;
                            }
                            default: 
                            case Cursor.FIELD_TYPE_STRING: {
                                final String value = cursor.getString(i);
                                success = value != null ? window.putString(value, position, i)
                                        : window.putNull(position, i);
                                break;
                            }
                        }
                        if (!success) {
                            window.freeLastRow();
                            break;
                        }
                    }
                    position += 1;
                } while (cursor.moveToNext());
            }
            cursor.moveToPosition(oldPos);
        } catch (IllegalStateException e){
        } finally {
            window.releaseReference();
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.666 -0400", hash_original_method = "80FE207FA2FD7B3EC5D1B03F798F20EC", hash_generated_method = "1C849907C54C6142A002D3424F672FE5")
    public static void appendEscapedSQLString(StringBuilder sb, String sqlString) {
        sb.append('\'');
        if (sqlString.indexOf('\'') != -1) {
            int length = sqlString.length();
            for (int i = 0; i < length; i++) {
                char c = sqlString.charAt(i);
                if (c == '\'') {
                    sb.append('\'');
                }
                sb.append(c);
            }
        } else
            sb.append(sqlString);
        sb.append('\'');
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.666 -0400", hash_original_method = "7552DB2CB2D2F1A34A98DAA2372BF735", hash_generated_method = "AF0FA82A7D6CD7394EBC331BCBC5D65F")
    public static String sqlEscapeString(String value) {
        StringBuilder escaper = new StringBuilder();
        DatabaseUtils.appendEscapedSQLString(escaper, value);
        return escaper.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.667 -0400", hash_original_method = "CC26B336023F985FDD8C05D7EFF5A607", hash_generated_method = "586BF1DA188E33E34D10874FF1ED58A4")
    public static final void appendValueToSql(StringBuilder sql, Object value) {
        if (value == null) {
            sql.append("NULL");
        } else if (value instanceof Boolean) {
            Boolean bool = (Boolean)value;
            if (bool) {
                sql.append('1');
            } else {
                sql.append('0');
            }
        } else {
            appendEscapedSQLString(sql, value.toString());
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.667 -0400", hash_original_method = "456400F7FD34BEA9F412D24A9889C2FB", hash_generated_method = "F28E65C77F981D5409FFCCEB8ED4757B")
    public static String concatenateWhere(String a, String b) {
        if (TextUtils.isEmpty(a)) {
            return b;
        }
        if (TextUtils.isEmpty(b)) {
            return a;
        }
        return "(" + a + ") AND (" + b + ")";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.667 -0400", hash_original_method = "2277D1FB24406F696FA05FFD0730F1E8", hash_generated_method = "CE255E3B1B917E95F5D437A43844A75C")
    public static String getCollationKey(String name) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        byte [] arr = getCollationKeyInBytes(name);
        try {
            return new String(arr, 0, getKeyLen(arr), "ISO8859_1");
        } catch (Exception ex) {
            return "";
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.667 -0400", hash_original_method = "3EFAF0E286C0E5ABBA5F444CC372591A", hash_generated_method = "5F9DB85A7B0D20E629D3B768C72900ED")
    public static String getHexCollationKey(String name) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        byte [] arr = getCollationKeyInBytes(name);
        char[] keys = Hex.encodeHex(arr);
        return new String(keys, 0, getKeyLen(arr) * 2);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.667 -0400", hash_original_method = "E001715DE6DB9ED11A90575B61782D8F", hash_generated_method = "2A32FB4BC7ED1B39267E38DBF1574247")
    private static int getKeyLen(byte[] arr) {
        if (arr[arr.length - 1] != 0) {
            return arr.length;
        } else {
            return arr.length-1;
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.667 -0400", hash_original_method = "2BC34B911946491978F698EBA40659C2", hash_generated_method = "423078A74724516E937E06DC31D1854C")
    private static byte[] getCollationKeyInBytes(String name) {
        if (mColl == null) {
            mColl = Collator.getInstance();
            mColl.setStrength(Collator.PRIMARY);
        }
        return mColl.getCollationKey(name).toByteArray();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.668 -0400", hash_original_method = "A430190530104247A836CC3C4CF00C2B", hash_generated_method = "3168EBC3DC3D190D018250C829F5256A")
    public static void dumpCursor(Cursor cursor) {
        dumpCursor(cursor, System.out);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.668 -0400", hash_original_method = "01F1FC91F82BFD6DF4E4443B37052042", hash_generated_method = "168BE30C6BAF90C59363528B60B8C592")
    public static void dumpCursor(Cursor cursor, PrintStream stream) {
        stream.println(">>>>> Dumping cursor " + cursor);
        if (cursor != null) {
            int startPos = cursor.getPosition();
            cursor.moveToPosition(-1);
            while (cursor.moveToNext()) {
                dumpCurrentRow(cursor, stream);
            }
            cursor.moveToPosition(startPos);
        }
        stream.println("<<<<<");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.668 -0400", hash_original_method = "744CF515CE666C072F4911092C5B89B3", hash_generated_method = "C6D78A0A40069B7F3CB3B55D859F95B0")
    public static void dumpCursor(Cursor cursor, StringBuilder sb) {
        sb.append(">>>>> Dumping cursor " + cursor + "\n");
        if (cursor != null) {
            int startPos = cursor.getPosition();
            cursor.moveToPosition(-1);
            while (cursor.moveToNext()) {
                dumpCurrentRow(cursor, sb);
            }
            cursor.moveToPosition(startPos);
        }
        sb.append("<<<<<\n");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.668 -0400", hash_original_method = "1F4DCB5CD8846A0745009D1673525F1B", hash_generated_method = "C6B834E5E9ECD1C45D294C7A6620C669")
    public static String dumpCursorToString(Cursor cursor) {
        StringBuilder sb = new StringBuilder();
        dumpCursor(cursor, sb);
        return sb.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.668 -0400", hash_original_method = "B7C67E2F179AF8C301D4B2ED36DBCCCA", hash_generated_method = "DD966B6BB8C95D0083472B88ABFFF454")
    public static void dumpCurrentRow(Cursor cursor) {
        dumpCurrentRow(cursor, System.out);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.668 -0400", hash_original_method = "D0996D4DFB9F5585E3927B19545BE3E4", hash_generated_method = "853F6613112BF82E0E158AF1E4E8BD20")
    public static void dumpCurrentRow(Cursor cursor, PrintStream stream) {
        String[] cols = cursor.getColumnNames();
        stream.println("" + cursor.getPosition() + " {");
        int length = cols.length;
        for (int i = 0; i< length; i++) {
            String value;
            try {
                value = cursor.getString(i);
            } catch (SQLiteException e) {
                value = "<unprintable>";
            }
            stream.println("   " + cols[i] + '=' + value);
        }
        stream.println("}");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.669 -0400", hash_original_method = "BBC7B52EA680791B1ED24327B6650764", hash_generated_method = "6BD07FE4F444AB6646A478EAE1576C10")
    public static void dumpCurrentRow(Cursor cursor, StringBuilder sb) {
        String[] cols = cursor.getColumnNames();
        sb.append("" + cursor.getPosition() + " {\n");
        int length = cols.length;
        for (int i = 0; i < length; i++) {
            String value;
            try {
                value = cursor.getString(i);
            } catch (SQLiteException e) {
                value = "<unprintable>";
            }
            sb.append("   " + cols[i] + '=' + value + "\n");
        }
        sb.append("}\n");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.669 -0400", hash_original_method = "6CF6D9D2DF58623C9FADAD3A1D1AF7CA", hash_generated_method = "7DDCB78FFD6A496EB6AB9A2913FA3D32")
    public static String dumpCurrentRowToString(Cursor cursor) {
        StringBuilder sb = new StringBuilder();
        dumpCurrentRow(cursor, sb);
        return sb.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.669 -0400", hash_original_method = "5576E8CFBC652E677E2E7A2A7B8415A7", hash_generated_method = "8FA831EA5EA31CC4BA7DA39826A1D483")
    public static void cursorStringToContentValues(Cursor cursor, String field,
            ContentValues values) {
        cursorStringToContentValues(cursor, field, values, field);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.669 -0400", hash_original_method = "C2854E9815730958E1E62BF3BEF2BE82", hash_generated_method = "4F1E1CBAC3FB5DB4FC16487167CA2CDC")
    public static void cursorStringToInsertHelper(Cursor cursor, String field,
            InsertHelper inserter, int index) {
        inserter.bind(index, cursor.getString(cursor.getColumnIndexOrThrow(field)));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.669 -0400", hash_original_method = "C45BF775ACB085D4AB34759EE5B8F1A2", hash_generated_method = "62C206B2D6FE9173EE75BB173DDBCBFA")
    public static void cursorStringToContentValues(Cursor cursor, String field,
            ContentValues values, String key) {
        values.put(key, cursor.getString(cursor.getColumnIndexOrThrow(field)));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.669 -0400", hash_original_method = "7E775FC9F6A4D9C80906C236555098C0", hash_generated_method = "BD7058BF2ECD242BC1E243CF5F2162F9")
    public static void cursorIntToContentValues(Cursor cursor, String field, ContentValues values) {
        cursorIntToContentValues(cursor, field, values, field);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.670 -0400", hash_original_method = "D26DF74C9E797B538D6D01C69F8C39EB", hash_generated_method = "9F23384B40E9CEBA3B49A12206B6C84E")
    public static void cursorIntToContentValues(Cursor cursor, String field, ContentValues values,
            String key) {
        int colIndex = cursor.getColumnIndex(field);
        if (!cursor.isNull(colIndex)) {
            values.put(key, cursor.getInt(colIndex));
        } else {
            values.put(key, (Integer) null);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.670 -0400", hash_original_method = "ADCC890B33FED57666957B09D938712A", hash_generated_method = "067860CEF2731268BF82E79DD06A1655")
    public static void cursorLongToContentValues(Cursor cursor, String field, ContentValues values) {
        cursorLongToContentValues(cursor, field, values, field);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.670 -0400", hash_original_method = "0E5EFEE954A1F8E1BF28B3DC3574519C", hash_generated_method = "350A6E6B222DD9E41B1BE938B448060F")
    public static void cursorLongToContentValues(Cursor cursor, String field, ContentValues values,
            String key) {
        int colIndex = cursor.getColumnIndex(field);
        if (!cursor.isNull(colIndex)) {
            Long value = Long.valueOf(cursor.getLong(colIndex));
            values.put(key, value);
        } else {
            values.put(key, (Long) null);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.670 -0400", hash_original_method = "923751B615B712D23E3EDA9B1C0C5364", hash_generated_method = "361E83401346E716FFE65F2C9B0886CD")
    public static void cursorDoubleToCursorValues(Cursor cursor, String field, ContentValues values) {
        cursorDoubleToContentValues(cursor, field, values, field);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.670 -0400", hash_original_method = "C3A5E8A0EB9514669B9D33BF4F941F8F", hash_generated_method = "26B8BE5F6403E0CBE1CB70D001532533")
    public static void cursorDoubleToContentValues(Cursor cursor, String field,
            ContentValues values, String key) {
        int colIndex = cursor.getColumnIndex(field);
        if (!cursor.isNull(colIndex)) {
            values.put(key, cursor.getDouble(colIndex));
        } else {
            values.put(key, (Double) null);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.670 -0400", hash_original_method = "F572ACA797E9B5093DE86C276E160FEC", hash_generated_method = "4948083AE7295EE51565758E9569E48A")
    public static void cursorRowToContentValues(Cursor cursor, ContentValues values) {
        AbstractWindowedCursor awc =
                (cursor instanceof AbstractWindowedCursor) ? (AbstractWindowedCursor) cursor : null;
        String[] columns = cursor.getColumnNames();
        int length = columns.length;
        for (int i = 0; i < length; i++) {
            if (awc != null && awc.isBlob(i)) {
                values.put(columns[i], cursor.getBlob(i));
            } else {
                values.put(columns[i], cursor.getString(i));
            }
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.670 -0400", hash_original_method = "929DBC7A90DC227FF2B26E4E72D12B70", hash_generated_method = "8CC78C93660BD02E2DF389D10B4F12B7")
    public static long queryNumEntries(SQLiteDatabase db, String table) {
        return queryNumEntries(db, table, null, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.671 -0400", hash_original_method = "14DB54E29D400149A38978E82860E0D6", hash_generated_method = "87854038149496693F499F6CC5631C59")
    public static long queryNumEntries(SQLiteDatabase db, String table, String selection) {
        return queryNumEntries(db, table, selection, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.671 -0400", hash_original_method = "B4D6325E78B6FA18E9BDD75F37F7F7A7", hash_generated_method = "BC0B7A6C7758DC73C629DDD9DF9A80E6")
    public static long queryNumEntries(SQLiteDatabase db, String table, String selection,
            String[] selectionArgs) {
        String s = (!TextUtils.isEmpty(selection)) ? " where " + selection : "";
        return longForQuery(db, "select count(*) from " + table + s,
                    selectionArgs);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.671 -0400", hash_original_method = "1138F251ECE80366C448CEE3E6C39D34", hash_generated_method = "879FB01B5B511D9EAD2D3BA54F086F68")
    public static long longForQuery(SQLiteDatabase db, String query, String[] selectionArgs) {
        SQLiteStatement prog = db.compileStatement(query);
        try {
            return longForQuery(prog, selectionArgs);
        } finally {
            prog.close();
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.671 -0400", hash_original_method = "FD2C3250D9E68CC4AB6807C768E508FC", hash_generated_method = "2E5050873F38E2B1C5B23668BF8B665D")
    public static long longForQuery(SQLiteStatement prog, String[] selectionArgs) {
        prog.bindAllArgsAsStrings(selectionArgs);
        return prog.simpleQueryForLong();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.671 -0400", hash_original_method = "DB160943F37161615396A718C828E921", hash_generated_method = "641D680EFB949033DE6F2B2B75BBE8E1")
    public static String stringForQuery(SQLiteDatabase db, String query, String[] selectionArgs) {
        SQLiteStatement prog = db.compileStatement(query);
        try {
            return stringForQuery(prog, selectionArgs);
        } finally {
            prog.close();
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.671 -0400", hash_original_method = "F5C8CCF0AB5FDE49DF63CF243C328D9F", hash_generated_method = "2CE099AC4E18C8F8257DDF5B3D90A566")
    public static String stringForQuery(SQLiteStatement prog, String[] selectionArgs) {
        prog.bindAllArgsAsStrings(selectionArgs);
        return prog.simpleQueryForString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.672 -0400", hash_original_method = "540FA090BA73BF75B1FC7EFF0B0F30DC", hash_generated_method = "D9F8EA265EE06DE480D47EA486025147")
    public static ParcelFileDescriptor blobFileDescriptorForQuery(SQLiteDatabase db,
            String query, String[] selectionArgs) {
        SQLiteStatement prog = db.compileStatement(query);
        try {
            return blobFileDescriptorForQuery(prog, selectionArgs);
        } finally {
            prog.close();
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.672 -0400", hash_original_method = "198371BAE7EE824416E49767A8F3C5A9", hash_generated_method = "1AB70714505EA6375498FD84B14C7444")
    public static ParcelFileDescriptor blobFileDescriptorForQuery(SQLiteStatement prog,
            String[] selectionArgs) {
        prog.bindAllArgsAsStrings(selectionArgs);
        return prog.simpleQueryForBlobFileDescriptor();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.672 -0400", hash_original_method = "E4819D88C72BF817469C24E1569426A4", hash_generated_method = "A135DD36A4708ECA00C9664FCC332131")
    public static void cursorStringToContentValuesIfPresent(Cursor cursor, ContentValues values,
            String column) {
        final int index = cursor.getColumnIndex(column);
        if (index != -1 && !cursor.isNull(index)) {
            values.put(column, cursor.getString(index));
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.672 -0400", hash_original_method = "360B190BBB89421C9CB5EC1082F87452", hash_generated_method = "5175FC265C12B410D802C28516887E7F")
    public static void cursorLongToContentValuesIfPresent(Cursor cursor, ContentValues values,
            String column) {
        final int index = cursor.getColumnIndex(column);
        if (index != -1 && !cursor.isNull(index)) {
            values.put(column, cursor.getLong(index));
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.672 -0400", hash_original_method = "E3916159B459B4D862132868895E3375", hash_generated_method = "59C3AF75A47101C071B91073FA092953")
    public static void cursorShortToContentValuesIfPresent(Cursor cursor, ContentValues values,
            String column) {
        final int index = cursor.getColumnIndex(column);
        if (index != -1 && !cursor.isNull(index)) {
            values.put(column, cursor.getShort(index));
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.673 -0400", hash_original_method = "9220AC3EDC51213CD50D1AE5DD6068EA", hash_generated_method = "B2C3788E779EF96C95BB7720C0B4E432")
    public static void cursorIntToContentValuesIfPresent(Cursor cursor, ContentValues values,
            String column) {
        final int index = cursor.getColumnIndex(column);
        if (index != -1 && !cursor.isNull(index)) {
            values.put(column, cursor.getInt(index));
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.673 -0400", hash_original_method = "AC6018F42404EC47E77B301174745A45", hash_generated_method = "BB8D8D43C66405027B782098B2A65121")
    public static void cursorFloatToContentValuesIfPresent(Cursor cursor, ContentValues values,
            String column) {
        final int index = cursor.getColumnIndex(column);
        if (index != -1 && !cursor.isNull(index)) {
            values.put(column, cursor.getFloat(index));
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.673 -0400", hash_original_method = "5A46FFBB11F835A1D00E2D177236CED3", hash_generated_method = "E02F64B417EC6DD2CB66DF18177B431F")
    public static void cursorDoubleToContentValuesIfPresent(Cursor cursor, ContentValues values,
            String column) {
        final int index = cursor.getColumnIndex(column);
        if (index != -1 && !cursor.isNull(index)) {
            values.put(column, cursor.getDouble(index));
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.673 -0400", hash_original_method = "BF59FB26E066BD2B7E2B2FCD96B9B9F3", hash_generated_method = "F64BFB3B6D78A421BA157AA2615F53AE")
    static public void createDbFromSqlStatements(
            Context context, String dbName, int dbVersion, String sqlStatements) {
        SQLiteDatabase db = context.openOrCreateDatabase(dbName, 0, null);
        String[] statements = TextUtils.split(sqlStatements, ";\n");
        for (String statement : statements) {
            if (TextUtils.isEmpty(statement)) continue;
            db.execSQL(statement);
        }
        db.setVersion(dbVersion);
        db.close();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.673 -0400", hash_original_method = "BA96BBA6C0D1DC9B0A9C404D0DA56C72", hash_generated_method = "F6D52DD1CECFD1BE321FDE44B0C19617")
    public static int getSqlStatementType(String sql) {
        sql = sql.trim();
        if (sql.length() < 3) {
            return STATEMENT_OTHER;
        }
        String prefixSql = sql.substring(0, 3).toUpperCase(Locale.US);
        if (prefixSql.equals("SEL")) {
            return STATEMENT_SELECT;
        } else if (prefixSql.equals("INS") ||
                prefixSql.equals("UPD") ||
                prefixSql.equals("REP") ||
                prefixSql.equals("DEL")) {
            return STATEMENT_UPDATE;
        } else if (prefixSql.equals("ATT")) {
            return STATEMENT_ATTACH;
        } else if (prefixSql.equals("COM")) {
            return STATEMENT_COMMIT;
        } else if (prefixSql.equals("END")) {
            return STATEMENT_COMMIT;
        } else if (prefixSql.equals("ROL")) {
            return STATEMENT_ABORT;
        } else if (prefixSql.equals("BEG")) {
            return STATEMENT_BEGIN;
        } else if (prefixSql.equals("PRA")) {
            return STATEMENT_PRAGMA;
        } else if (prefixSql.equals("CRE") || prefixSql.equals("DRO") ||
                prefixSql.equals("ALT")) {
            return STATEMENT_DDL;
        } else if (prefixSql.equals("ANA") || prefixSql.equals("DET")) {
            return STATEMENT_UNPREPARED;
        }
        return STATEMENT_OTHER;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.673 -0400", hash_original_method = "0E268DF7E77D68AC976AB928986A09DD", hash_generated_method = "860A88CC30075D9D911CC887B86A6034")
    public static String[] appendSelectionArgs(String[] originalValues, String[] newValues) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        if (originalValues == null || originalValues.length == 0) {
            return newValues;
        }
        String[] result = new String[originalValues.length + newValues.length ];
        System.arraycopy(originalValues, 0, result, 0, originalValues.length);
        System.arraycopy(newValues, 0, result, originalValues.length, newValues.length);
        return result;
    }

    
    public static class InsertHelper {
        private /* final */ SQLiteDatabase mDb;
        private /* final */ String mTableName;
        private HashMap<String, Integer> mColumns;
        private String mInsertSQL = null;
        private SQLiteStatement mInsertStatement = null;
        private SQLiteStatement mReplaceStatement = null;
        private SQLiteStatement mPreparedStatement = null;
        public static final int TABLE_INFO_PRAGMA_COLUMNNAME_INDEX = 1;
        public static final int TABLE_INFO_PRAGMA_DEFAULT_INDEX = 4;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.674 -0400", hash_original_method = "24A3E628A21DF3387C7E8AFA040BF2F9", hash_generated_method = "AC014EB45C7164FBEED398073907DB36")
        @DSModeled(DSC.SAFE)
        public InsertHelper(SQLiteDatabase db, String tableName) {
            dsTaint.addTaint(db.dsTaint);
            dsTaint.addTaint(tableName);
            // ---------- Original Method ----------
            //mDb = db;
            //mTableName = tableName;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.674 -0400", hash_original_method = "C9A601B53671BC96A8E157301601DE92", hash_generated_method = "B127B172B16101CAC891B59AE2BD4848")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void buildSQL() throws SQLException {
            StringBuilder sb;
            sb = new StringBuilder(128);
            sb.append("INSERT INTO ");
            sb.append(mTableName);
            sb.append(" (");
            StringBuilder sbv;
            sbv = new StringBuilder(128);
            sbv.append("VALUES (");
            int i;
            i = 1;
            Cursor cur;
            cur = null;
            try 
            {
                cur = mDb.rawQuery("PRAGMA table_info(" + mTableName + ")", null);
                mColumns = new HashMap<String, Integer>(cur.getCount());
                {
                    boolean varDD393CFA89BAE4D1CBFDDF232382228F_713419622 = (cur.moveToNext());
                    {
                        String columnName;
                        columnName = cur.getString(TABLE_INFO_PRAGMA_COLUMNNAME_INDEX);
                        String defaultValue;
                        defaultValue = cur.getString(TABLE_INFO_PRAGMA_DEFAULT_INDEX);
                        mColumns.put(columnName, i);
                        sb.append("'");
                        sb.append(columnName);
                        sb.append("'");
                        {
                            sbv.append("?");
                        } //End block
                        {
                            sbv.append("COALESCE(?, ");
                            sbv.append(defaultValue);
                            sbv.append(")");
                        } //End block
                        sb.append(i == cur.getCount() ? ") " : ", ");
                        sbv.append(i == cur.getCount() ? ");" : ", ");
                        ++i;
                    } //End block
                } //End collapsed parenthetic
            } //End block
            finally 
            {
                cur.close();
            } //End block
            sb.append(sbv);
            mInsertSQL = sb.toString();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.675 -0400", hash_original_method = "102F3921944A0F32C4E4BE81F61A753B", hash_generated_method = "E9C4C5F53BE308855B4A6B07E6F58A83")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private SQLiteStatement getStatement(boolean allowReplace) throws SQLException {
            dsTaint.addTaint(allowReplace);
            {
                {
                    buildSQL();
                    String replaceSQL;
                    replaceSQL = "INSERT OR REPLACE" + mInsertSQL.substring(6);
                    mReplaceStatement = mDb.compileStatement(replaceSQL);
                } //End block
            } //End block
            {
                {
                    buildSQL();
                    mInsertStatement = mDb.compileStatement(mInsertSQL);
                } //End block
            } //End block
            return (SQLiteStatement)dsTaint.getTaint();
            // ---------- Original Method ----------
            //if (allowReplace) {
                //if (mReplaceStatement == null) {
                    //if (mInsertSQL == null) buildSQL();
                    //String replaceSQL = "INSERT OR REPLACE" + mInsertSQL.substring(6);
                    //mReplaceStatement = mDb.compileStatement(replaceSQL);
                //}
                //return mReplaceStatement;
            //} else {
                //if (mInsertStatement == null) {
                    //if (mInsertSQL == null) buildSQL();
                    //mInsertStatement = mDb.compileStatement(mInsertSQL);
                //}
                //return mInsertStatement;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.675 -0400", hash_original_method = "13ED4597857164B01AAF7D1C6E2C9384", hash_generated_method = "377DB6CA47F55D66ECC3EC2E8CAD062C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private synchronized long insertInternal(ContentValues values, boolean allowReplace) {
            dsTaint.addTaint(allowReplace);
            dsTaint.addTaint(values.dsTaint);
            try 
            {
                SQLiteStatement stmt;
                stmt = getStatement(allowReplace);
                stmt.clearBindings();
                {
                    Iterator<Map.Entry<String, Object>> seatecAstronomy42 = values.valueSet().iterator();
                    seatecAstronomy42.hasNext();
                    Map.Entry<String, Object> e = seatecAstronomy42.next();
                    {
                        final String key;
                        key = e.getKey();
                        int i;
                        i = getColumnIndex(key);
                        DatabaseUtils.bindObjectToProgram(stmt, i, e.getValue());
                    } //End block
                } //End collapsed parenthetic
                long var023E52F16507A143FBACD2DB06F1711B_1564206370 = (stmt.executeInsert());
            } //End block
            catch (SQLException e)
            { }
            return dsTaint.getTaintLong();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.675 -0400", hash_original_method = "2FE6EA3004F5838FAFB27DD4EF6900C7", hash_generated_method = "61331B1801001DD88F2C7E4E7CE22EEB")
        @DSModeled(DSC.SAFE)
        public int getColumnIndex(String key) {
            dsTaint.addTaint(key);
            getStatement(false);
            final Integer index;
            index = mColumns.get(key);
            if (DroidSafeAndroidRuntime.control)
            {
                throw new IllegalArgumentException("column '" + key + "' is invalid");
            } //End block
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //getStatement(false);
            //final Integer index = mColumns.get(key);
            //if (index == null) {
                //throw new IllegalArgumentException("column '" + key + "' is invalid");
            //}
            //return index;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.675 -0400", hash_original_method = "898F1EFFAEB546E6A9657A001F4AE1E8", hash_generated_method = "8F362BBCE55E1D5CAA16C536C0F79250")
        @DSModeled(DSC.SAFE)
        public void bind(int index, double value) {
            dsTaint.addTaint(index);
            dsTaint.addTaint(value);
            mPreparedStatement.bindDouble(index, value);
            // ---------- Original Method ----------
            //mPreparedStatement.bindDouble(index, value);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.676 -0400", hash_original_method = "85D356AA3C69D35869973C25B38955EB", hash_generated_method = "9D25DEE5DAF6C007BEAA5E2EF6EFD304")
        @DSModeled(DSC.SAFE)
        public void bind(int index, float value) {
            dsTaint.addTaint(index);
            dsTaint.addTaint(value);
            mPreparedStatement.bindDouble(index, value);
            // ---------- Original Method ----------
            //mPreparedStatement.bindDouble(index, value);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.676 -0400", hash_original_method = "76F2FAC154909632438A49671F5D33A8", hash_generated_method = "B8337E69137C2070E1180F8F5BCC57C9")
        @DSModeled(DSC.SAFE)
        public void bind(int index, long value) {
            dsTaint.addTaint(index);
            dsTaint.addTaint(value);
            mPreparedStatement.bindLong(index, value);
            // ---------- Original Method ----------
            //mPreparedStatement.bindLong(index, value);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.676 -0400", hash_original_method = "A73EABD891E538A0A03C5C4A49C29503", hash_generated_method = "6B1D13E8B0E1FF7A8331D8658D258848")
        @DSModeled(DSC.SAFE)
        public void bind(int index, int value) {
            dsTaint.addTaint(index);
            dsTaint.addTaint(value);
            mPreparedStatement.bindLong(index, value);
            // ---------- Original Method ----------
            //mPreparedStatement.bindLong(index, value);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.676 -0400", hash_original_method = "D4E75DDD13795169D0FEAC83726F0F45", hash_generated_method = "48C8AAF5308E562D3BFB04F32D9156C0")
        @DSModeled(DSC.SAFE)
        public void bind(int index, boolean value) {
            dsTaint.addTaint(index);
            dsTaint.addTaint(value);
            mPreparedStatement.bindLong(index, value ? 1 : 0);
            // ---------- Original Method ----------
            //mPreparedStatement.bindLong(index, value ? 1 : 0);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.676 -0400", hash_original_method = "27990C90801E0788D0DEC119EA5D904E", hash_generated_method = "64B5FF5FE535DBF9881172138C8456AC")
        @DSModeled(DSC.SAFE)
        public void bindNull(int index) {
            dsTaint.addTaint(index);
            mPreparedStatement.bindNull(index);
            // ---------- Original Method ----------
            //mPreparedStatement.bindNull(index);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.676 -0400", hash_original_method = "B7B8BDC3019EC6DD4050CE3C3C2D0B33", hash_generated_method = "9C278BE4CE546CAB4D1C37EE907FCDC2")
        @DSModeled(DSC.SAFE)
        public void bind(int index, byte[] value) {
            dsTaint.addTaint(index);
            dsTaint.addTaint(value);
            {
                mPreparedStatement.bindNull(index);
            } //End block
            {
                mPreparedStatement.bindBlob(index, value);
            } //End block
            // ---------- Original Method ----------
            //if (value == null) {
                //mPreparedStatement.bindNull(index);
            //} else {
                //mPreparedStatement.bindBlob(index, value);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.677 -0400", hash_original_method = "70AF33973781662CA48B1120B9D51D5F", hash_generated_method = "4D998397F89A32A3EF13FB0DDC69D638")
        @DSModeled(DSC.SAFE)
        public void bind(int index, String value) {
            dsTaint.addTaint(index);
            dsTaint.addTaint(value);
            {
                mPreparedStatement.bindNull(index);
            } //End block
            {
                mPreparedStatement.bindString(index, value);
            } //End block
            // ---------- Original Method ----------
            //if (value == null) {
                //mPreparedStatement.bindNull(index);
            //} else {
                //mPreparedStatement.bindString(index, value);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.677 -0400", hash_original_method = "9556B578266975E5A98CFEB0C2204667", hash_generated_method = "86B1021609F476223CAB7C5C5A696EE9")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public long insert(ContentValues values) {
            dsTaint.addTaint(values.dsTaint);
            long var7272FAC0398C10C383FD0AB1A343FC95_1937822756 = (insertInternal(values, false));
            return dsTaint.getTaintLong();
            // ---------- Original Method ----------
            //return insertInternal(values, false);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.677 -0400", hash_original_method = "C80CA050416DA84901D4F7B0B2F41300", hash_generated_method = "7ED8497879C6F3A9E42A98D034B28EAC")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public long execute() {
            if (DroidSafeAndroidRuntime.control)
            {
                throw new IllegalStateException("you must prepare this inserter before calling "
                        + "execute");
            } //End block
            try 
            {
                long varB1E8ED66178D6CA6EC479BE8B17F02EA_1644126900 = (mPreparedStatement.executeInsert());
            } //End block
            catch (SQLException e)
            { }
            finally 
            {
                mPreparedStatement = null;
            } //End block
            return dsTaint.getTaintLong();
            // ---------- Original Method ----------
            //if (mPreparedStatement == null) {
                //throw new IllegalStateException("you must prepare this inserter before calling "
                        //+ "execute");
            //}
            //try {
                //if (LOCAL_LOGV) Log.v(TAG, "--- doing insert or replace in table " + mTableName);
                //return mPreparedStatement.executeInsert();
            //} catch (SQLException e) {
                //Log.e(TAG, "Error executing InsertHelper with table " + mTableName, e);
                //return -1;
            //} finally {
                //mPreparedStatement = null;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.677 -0400", hash_original_method = "BEDC7093698B9136E99447F456E9608C", hash_generated_method = "F48816A83E7E4523B9A316DAED2CF31C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void prepareForInsert() {
            mPreparedStatement = getStatement(false);
            mPreparedStatement.clearBindings();
            // ---------- Original Method ----------
            //mPreparedStatement = getStatement(false);
            //mPreparedStatement.clearBindings();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.678 -0400", hash_original_method = "2DC72BFF923FF55EA48E8D651F79AFBE", hash_generated_method = "A7641980CADFAF33A4AF5DC6063C1819")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void prepareForReplace() {
            mPreparedStatement = getStatement(true);
            mPreparedStatement.clearBindings();
            // ---------- Original Method ----------
            //mPreparedStatement = getStatement(true);
            //mPreparedStatement.clearBindings();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.678 -0400", hash_original_method = "C177E80799F9F51057A5F361D4C5571B", hash_generated_method = "DEEEE74012DD9AEC18A42448F7E479EC")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public long replace(ContentValues values) {
            dsTaint.addTaint(values.dsTaint);
            long var638A5CC2C9218D39B65A71C2E9E180A7_86641289 = (insertInternal(values, true));
            return dsTaint.getTaintLong();
            // ---------- Original Method ----------
            //return insertInternal(values, true);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.678 -0400", hash_original_method = "21909697F743246FF7034BA444D2FBF0", hash_generated_method = "913D632B22E7F75C304F77438A5CAAD7")
        @DSModeled(DSC.SAFE)
        public void close() {
            {
                mInsertStatement.close();
                mInsertStatement = null;
            } //End block
            {
                mReplaceStatement.close();
                mReplaceStatement = null;
            } //End block
            mInsertSQL = null;
            mColumns = null;
            // ---------- Original Method ----------
            //if (mInsertStatement != null) {
                //mInsertStatement.close();
                //mInsertStatement = null;
            //}
            //if (mReplaceStatement != null) {
                //mReplaceStatement.close();
                //mReplaceStatement = null;
            //}
            //mInsertSQL = null;
            //mColumns = null;
        }

        
    }


    
}


