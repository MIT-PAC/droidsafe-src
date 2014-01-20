package android.database;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.text.Collator;
import java.util.HashMap;
import java.util.Map;

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

public class DatabaseUtils {

    /**
     * Special function for writing an exception result at the header of
     * a parcel, to be used when returning an exception from a transaction.
     * exception will be re-thrown by the function in another process
     * @param reply Parcel to write to
     * @param e The Exception to be written.
     * @see Parcel#writeNoException
     * @see Parcel#writeException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:38.264 -0500", hash_original_method = "664E69D53BABC0BD392ABB3CB5A666E2", hash_generated_method = "F4D1F0DC18534DC85E2667018E84D6C0")
    
public static final void writeExceptionToParcel(Parcel reply, Exception e) {
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

    /**
     * Special function for reading an exception result from the header of
     * a parcel, to be used after receiving the result of a transaction.  This
     * will throw the exception for you if it had been written to the Parcel,
     * otherwise return and let you read the normal result data from the Parcel.
     * @param reply Parcel to read from
     * @see Parcel#writeNoException
     * @see Parcel#readException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:38.266 -0500", hash_original_method = "99279A6650B0C93FCFD173D39A34CB97", hash_generated_method = "BDA53A6D76765E123EF8FE96139CAA8D")
    
public static final void readExceptionFromParcel(Parcel reply) {
        int code = reply.readExceptionCode();
        if (code == 0) return;
        String msg = reply.readString();
        DatabaseUtils.readExceptionFromParcel(reply, msg, code);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:38.269 -0500", hash_original_method = "3CD1B88164A3210A879F7432B20509CE", hash_generated_method = "548BF6F317BD985E216EA6512CA8EC62")
    
public static void readExceptionWithFileNotFoundExceptionFromParcel(
            Parcel reply) throws FileNotFoundException {
        int code = reply.readExceptionCode();
        if (code == 0) return;
        String msg = reply.readString();
        if (code == 1) {
            throw new FileNotFoundException(msg);
        } else {
            DatabaseUtils.readExceptionFromParcel(reply, msg, code);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:38.272 -0500", hash_original_method = "2492E7AEC13D0FFFB95F298C13FF8172", hash_generated_method = "7D74DE0A7BAB80D9D5E2D83D96A256AC")
    
public static void readExceptionWithOperationApplicationExceptionFromParcel(
            Parcel reply) throws OperationApplicationException {
        int code = reply.readExceptionCode();
        if (code == 0) return;
        String msg = reply.readString();
        if (code == 10) {
            throw new OperationApplicationException(msg);
        } else {
            DatabaseUtils.readExceptionFromParcel(reply, msg, code);
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:38.275 -0500", hash_original_method = "7C5917B72662210A19A77F7241EE9613", hash_generated_method = "F38ED1D49B1B724ADD3CC2D9E4EA4904")
    
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

    /**
     * Binds the given Object to the given SQLiteProgram using the proper
     * typing. For example, bind numbers as longs/doubles, and everything else
     * as a string by call toString() on it.
     *
     * @param prog the program to bind the object to
     * @param index the 1-based index to bind at
     * @param value the value to bind
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:38.278 -0500", hash_original_method = "336103AA7A2D233179336448C933A29F", hash_generated_method = "21FE3D0EE05FB1E77838C07BDFA9BA55")
    
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

    /**
     * Returns data type of the given object's value.
     *<p>
     * Returned values are
     * <ul>
     *   <li>{@link Cursor#FIELD_TYPE_NULL}</li>
     *   <li>{@link Cursor#FIELD_TYPE_INTEGER}</li>
     *   <li>{@link Cursor#FIELD_TYPE_FLOAT}</li>
     *   <li>{@link Cursor#FIELD_TYPE_STRING}</li>
     *   <li>{@link Cursor#FIELD_TYPE_BLOB}</li>
     *</ul>
     *</p>
     *
     * @param obj the object whose value type is to be returned
     * @return object value type
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:38.280 -0500", hash_original_method = "4F212FF7EF5441857670A3D4278A69D1", hash_generated_method = "806E2AB1FCF1B6B9FFFEC177C4F4A9EE")
    
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

    /**
     * Fills the specified cursor window by iterating over the contents of the cursor.
     * The window is filled until the cursor is exhausted or the window runs out
     * of space.
     *
     * The original position of the cursor is left unchanged by this operation.
     *
     * @param cursor The cursor that contains the data to put in the window.
     * @param position The start position for filling the window.
     * @param window The window to fill.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:38.284 -0500", hash_original_method = "528BFFCDF2670C473C5EA8B806C4B8BC", hash_generated_method = "C00E472BAE58224EBBCCC1ED36C0A685")
    
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

                            default: // assume value is convertible to String
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
            // simply ignore it
        } finally {
            window.releaseReference();
        }
    }

    /**
     * Appends an SQL string to the given StringBuilder, including the opening
     * and closing single quotes. Any single quotes internal to sqlString will
     * be escaped.
     *
     * This method is deprecated because we want to encourage everyone
     * to use the "?" binding form.  However, when implementing a
     * ContentProvider, one may want to add WHERE clauses that were
     * not provided by the caller.  Since "?" is a positional form,
     * using it in this case could break the caller because the
     * indexes would be shifted to accomodate the ContentProvider's
     * internal bindings.  In that case, it may be necessary to
     * construct a WHERE clause manually.  This method is useful for
     * those cases.
     *
     * @param sb the StringBuilder that the SQL string will be appended to
     * @param sqlString the raw string to be appended, which may contain single
     *                  quotes
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:38.287 -0500", hash_original_method = "80FE207FA2FD7B3EC5D1B03F798F20EC", hash_generated_method = "1C849907C54C6142A002D3424F672FE5")
    
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

    /**
     * SQL-escape a string.
     */
    @DSComment("Utility function")
    @DSSafe(DSCat.UTIL_FUNCTION)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:38.290 -0500", hash_original_method = "7552DB2CB2D2F1A34A98DAA2372BF735", hash_generated_method = "AF0FA82A7D6CD7394EBC331BCBC5D65F")
    
public static String sqlEscapeString(String value) {
        StringBuilder escaper = new StringBuilder();

        DatabaseUtils.appendEscapedSQLString(escaper, value);

        return escaper.toString();
    }

    /**
     * Appends an Object to an SQL string with the proper escaping, etc.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:38.292 -0500", hash_original_method = "CC26B336023F985FDD8C05D7EFF5A607", hash_generated_method = "586BF1DA188E33E34D10874FF1ED58A4")
    
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

    /**
     * Concatenates two SQL WHERE clauses, handling empty or null values.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:38.296 -0500", hash_original_method = "456400F7FD34BEA9F412D24A9889C2FB", hash_generated_method = "F28E65C77F981D5409FFCCEB8ED4757B")
    
public static String concatenateWhere(String a, String b) {
        if (TextUtils.isEmpty(a)) {
            return b;
        }
        if (TextUtils.isEmpty(b)) {
            return a;
        }

        return "(" + a + ") AND (" + b + ")";
    }

    /**
     * return the collation key
     * @param name
     * @return the collation key
     */
    @DSSource({DSSourceKind.DATABASE_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:38.298 -0500", hash_original_method = "2277D1FB24406F696FA05FFD0730F1E8", hash_generated_method = "ADC942F1075E4624D53E8C7FC47A2431")
    
public static String getCollationKey(String name) {
        byte [] arr = getCollationKeyInBytes(name);
        try {
            return new String(arr, 0, getKeyLen(arr), "ISO8859_1");
        } catch (Exception ex) {
            return "";
        }
    }

    /**
     * return the collation key in hex format
     * @param name
     * @return the collation key in hex format
     */
    @DSSource({DSSourceKind.DATABASE_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:38.301 -0500", hash_original_method = "3EFAF0E286C0E5ABBA5F444CC372591A", hash_generated_method = "95EF173F526EFF87C03956708A63348D")
    
public static String getHexCollationKey(String name) {
        byte [] arr = getCollationKeyInBytes(name);
        char[] keys = Hex.encodeHex(arr);
        return new String(keys, 0, getKeyLen(arr) * 2);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:38.303 -0500", hash_original_method = "E001715DE6DB9ED11A90575B61782D8F", hash_generated_method = "07862CFEE74330FBA1F29FDFF781FE97")
    
private static int getKeyLen(byte[] arr) {
        if (arr[arr.length - 1] != 0) {
            return arr.length;
        } else {
            // remove zero "termination"
            return arr.length-1;
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:38.306 -0500", hash_original_method = "2BC34B911946491978F698EBA40659C2", hash_generated_method = "423078A74724516E937E06DC31D1854C")
    
private static byte[] getCollationKeyInBytes(String name) {
        if (mColl == null) {
            mColl = Collator.getInstance();
            mColl.setStrength(Collator.PRIMARY);
        }
        return mColl.getCollationKey(name).toByteArray();
    }
    /**
     * Prints the contents of a Cursor to System.out. The position is restored
     * after printing.
     *
     * @param cursor the cursor to print
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:38.310 -0500", hash_original_method = "A430190530104247A836CC3C4CF00C2B", hash_generated_method = "3168EBC3DC3D190D018250C829F5256A")
    
public static void dumpCursor(Cursor cursor) {
        dumpCursor(cursor, System.out);
    }

    /**
     * Prints the contents of a Cursor to a PrintSteam. The position is restored
     * after printing.
     *
     * @param cursor the cursor to print
     * @param stream the stream to print to
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:38.313 -0500", hash_original_method = "01F1FC91F82BFD6DF4E4443B37052042", hash_generated_method = "168BE30C6BAF90C59363528B60B8C592")
    
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

    /**
     * Prints the contents of a Cursor to a StringBuilder. The position
     * is restored after printing.
     *
     * @param cursor the cursor to print
     * @param sb the StringBuilder to print to
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:38.316 -0500", hash_original_method = "744CF515CE666C072F4911092C5B89B3", hash_generated_method = "C6D78A0A40069B7F3CB3B55D859F95B0")
    
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

    /**
     * Prints the contents of a Cursor to a String. The position is restored
     * after printing.
     *
     * @param cursor the cursor to print
     * @return a String that contains the dumped cursor
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:38.319 -0500", hash_original_method = "1F4DCB5CD8846A0745009D1673525F1B", hash_generated_method = "C6B834E5E9ECD1C45D294C7A6620C669")
    
public static String dumpCursorToString(Cursor cursor) {
        StringBuilder sb = new StringBuilder();
        dumpCursor(cursor, sb);
        return sb.toString();
    }

    /**
     * Prints the contents of a Cursor's current row to System.out.
     *
     * @param cursor the cursor to print from
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:38.321 -0500", hash_original_method = "B7C67E2F179AF8C301D4B2ED36DBCCCA", hash_generated_method = "DD966B6BB8C95D0083472B88ABFFF454")
    
public static void dumpCurrentRow(Cursor cursor) {
        dumpCurrentRow(cursor, System.out);
    }

    /**
     * Prints the contents of a Cursor's current row to a PrintSteam.
     *
     * @param cursor the cursor to print
     * @param stream the stream to print to
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:38.324 -0500", hash_original_method = "D0996D4DFB9F5585E3927B19545BE3E4", hash_generated_method = "BA24E7C3A8B18A175AD4E4B71A2B86FC")
    
public static void dumpCurrentRow(Cursor cursor, PrintStream stream) {
        String[] cols = cursor.getColumnNames();
        stream.println("" + cursor.getPosition() + " {");
        int length = cols.length;
        for (int i = 0; i< length; i++) {
            String value;
            try {
                value = cursor.getString(i);
            } catch (SQLiteException e) {
                // assume that if the getString threw this exception then the column is not
                // representable by a string, e.g. it is a BLOB.
                value = "<unprintable>";
            }
            stream.println("   " + cols[i] + '=' + value);
        }
        stream.println("}");
    }

    /**
     * Prints the contents of a Cursor's current row to a StringBuilder.
     *
     * @param cursor the cursor to print
     * @param sb the StringBuilder to print to
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:38.327 -0500", hash_original_method = "BBC7B52EA680791B1ED24327B6650764", hash_generated_method = "2090B7A89F94B4327FE79244B9EB4BB6")
    
public static void dumpCurrentRow(Cursor cursor, StringBuilder sb) {
        String[] cols = cursor.getColumnNames();
        sb.append("" + cursor.getPosition() + " {\n");
        int length = cols.length;
        for (int i = 0; i < length; i++) {
            String value;
            try {
                value = cursor.getString(i);
            } catch (SQLiteException e) {
                // assume that if the getString threw this exception then the column is not
                // representable by a string, e.g. it is a BLOB.
                value = "<unprintable>";
            }
            sb.append("   " + cols[i] + '=' + value + "\n");
        }
        sb.append("}\n");
    }

    /**
     * Dump the contents of a Cursor's current row to a String.
     *
     * @param cursor the cursor to print
     * @return a String that contains the dumped cursor row
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:38.329 -0500", hash_original_method = "6CF6D9D2DF58623C9FADAD3A1D1AF7CA", hash_generated_method = "7DDCB78FFD6A496EB6AB9A2913FA3D32")
    
public static String dumpCurrentRowToString(Cursor cursor) {
        StringBuilder sb = new StringBuilder();
        dumpCurrentRow(cursor, sb);
        return sb.toString();
    }

    /**
     * Reads a String out of a field in a Cursor and writes it to a Map.
     *
     * @param cursor The cursor to read from
     * @param field The TEXT field to read
     * @param values The {@link ContentValues} to put the value into, with the field as the key
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:38.332 -0500", hash_original_method = "5576E8CFBC652E677E2E7A2A7B8415A7", hash_generated_method = "8FA831EA5EA31CC4BA7DA39826A1D483")
    
public static void cursorStringToContentValues(Cursor cursor, String field,
            ContentValues values) {
        cursorStringToContentValues(cursor, field, values, field);
    }

    /**
     * Reads a String out of a field in a Cursor and writes it to an InsertHelper.
     *
     * @param cursor The cursor to read from
     * @param field The TEXT field to read
     * @param inserter The InsertHelper to bind into
     * @param index the index of the bind entry in the InsertHelper
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:38.334 -0500", hash_original_method = "C2854E9815730958E1E62BF3BEF2BE82", hash_generated_method = "4F1E1CBAC3FB5DB4FC16487167CA2CDC")
    
public static void cursorStringToInsertHelper(Cursor cursor, String field,
            InsertHelper inserter, int index) {
        inserter.bind(index, cursor.getString(cursor.getColumnIndexOrThrow(field)));
    }

    /**
     * Reads a String out of a field in a Cursor and writes it to a Map.
     *
     * @param cursor The cursor to read from
     * @param field The TEXT field to read
     * @param values The {@link ContentValues} to put the value into, with the field as the key
     * @param key The key to store the value with in the map
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:38.337 -0500", hash_original_method = "C45BF775ACB085D4AB34759EE5B8F1A2", hash_generated_method = "62C206B2D6FE9173EE75BB173DDBCBFA")
    
public static void cursorStringToContentValues(Cursor cursor, String field,
            ContentValues values, String key) {
        values.put(key, cursor.getString(cursor.getColumnIndexOrThrow(field)));
    }

    /**
     * Reads an Integer out of a field in a Cursor and writes it to a Map.
     *
     * @param cursor The cursor to read from
     * @param field The INTEGER field to read
     * @param values The {@link ContentValues} to put the value into, with the field as the key
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:38.339 -0500", hash_original_method = "7E775FC9F6A4D9C80906C236555098C0", hash_generated_method = "BD7058BF2ECD242BC1E243CF5F2162F9")
    
public static void cursorIntToContentValues(Cursor cursor, String field, ContentValues values) {
        cursorIntToContentValues(cursor, field, values, field);
    }

    /**
     * Reads a Integer out of a field in a Cursor and writes it to a Map.
     *
     * @param cursor The cursor to read from
     * @param field The INTEGER field to read
     * @param values The {@link ContentValues} to put the value into, with the field as the key
     * @param key The key to store the value with in the map
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:38.342 -0500", hash_original_method = "D26DF74C9E797B538D6D01C69F8C39EB", hash_generated_method = "9F23384B40E9CEBA3B49A12206B6C84E")
    
public static void cursorIntToContentValues(Cursor cursor, String field, ContentValues values,
            String key) {
        int colIndex = cursor.getColumnIndex(field);
        if (!cursor.isNull(colIndex)) {
            values.put(key, cursor.getInt(colIndex));
        } else {
            values.put(key, (Integer) null);
        }
    }

    /**
     * Reads a Long out of a field in a Cursor and writes it to a Map.
     *
     * @param cursor The cursor to read from
     * @param field The INTEGER field to read
     * @param values The {@link ContentValues} to put the value into, with the field as the key
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:38.345 -0500", hash_original_method = "ADCC890B33FED57666957B09D938712A", hash_generated_method = "067860CEF2731268BF82E79DD06A1655")
    
public static void cursorLongToContentValues(Cursor cursor, String field, ContentValues values)
    {
        cursorLongToContentValues(cursor, field, values, field);
    }

    /**
     * Reads a Long out of a field in a Cursor and writes it to a Map.
     *
     * @param cursor The cursor to read from
     * @param field The INTEGER field to read
     * @param values The {@link ContentValues} to put the value into
     * @param key The key to store the value with in the map
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:38.347 -0500", hash_original_method = "0E5EFEE954A1F8E1BF28B3DC3574519C", hash_generated_method = "350A6E6B222DD9E41B1BE938B448060F")
    
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

    /**
     * Reads a Double out of a field in a Cursor and writes it to a Map.
     *
     * @param cursor The cursor to read from
     * @param field The REAL field to read
     * @param values The {@link ContentValues} to put the value into
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:38.350 -0500", hash_original_method = "923751B615B712D23E3EDA9B1C0C5364", hash_generated_method = "361E83401346E716FFE65F2C9B0886CD")
    
public static void cursorDoubleToCursorValues(Cursor cursor, String field, ContentValues values)
    {
        cursorDoubleToContentValues(cursor, field, values, field);
    }

    /**
     * Reads a Double out of a field in a Cursor and writes it to a Map.
     *
     * @param cursor The cursor to read from
     * @param field The REAL field to read
     * @param values The {@link ContentValues} to put the value into
     * @param key The key to store the value with in the map
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:38.354 -0500", hash_original_method = "C3A5E8A0EB9514669B9D33BF4F941F8F", hash_generated_method = "26B8BE5F6403E0CBE1CB70D001532533")
    
public static void cursorDoubleToContentValues(Cursor cursor, String field,
            ContentValues values, String key) {
        int colIndex = cursor.getColumnIndex(field);
        if (!cursor.isNull(colIndex)) {
            values.put(key, cursor.getDouble(colIndex));
        } else {
            values.put(key, (Double) null);
        }
    }

    /**
     * Read the entire contents of a cursor row and store them in a ContentValues.
     *
     * @param cursor the cursor to read from.
     * @param values the {@link ContentValues} to put the row into.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:38.356 -0500", hash_original_method = "F572ACA797E9B5093DE86C276E160FEC", hash_generated_method = "4948083AE7295EE51565758E9569E48A")
    
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

    /**
     * Query the table for the number of rows in the table.
     * @param db the database the table is in
     * @param table the name of the table to query
     * @return the number of rows in the table
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:38.359 -0500", hash_original_method = "929DBC7A90DC227FF2B26E4E72D12B70", hash_generated_method = "8CC78C93660BD02E2DF389D10B4F12B7")
    
public static long queryNumEntries(SQLiteDatabase db, String table) {
        return queryNumEntries(db, table, null, null);
    }

    /**
     * Query the table for the number of rows in the table.
     * @param db the database the table is in
     * @param table the name of the table to query
     * @param selection A filter declaring which rows to return,
     *              formatted as an SQL WHERE clause (excluding the WHERE itself).
     *              Passing null will count all rows for the given table
     * @return the number of rows in the table filtered by the selection
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:38.363 -0500", hash_original_method = "14DB54E29D400149A38978E82860E0D6", hash_generated_method = "87854038149496693F499F6CC5631C59")
    
public static long queryNumEntries(SQLiteDatabase db, String table, String selection) {
        return queryNumEntries(db, table, selection, null);
    }

    /**
     * Query the table for the number of rows in the table.
     * @param db the database the table is in
     * @param table the name of the table to query
     * @param selection A filter declaring which rows to return,
     *              formatted as an SQL WHERE clause (excluding the WHERE itself).
     *              Passing null will count all rows for the given table
     * @param selectionArgs You may include ?s in selection,
     *              which will be replaced by the values from selectionArgs,
     *              in order that they appear in the selection.
     *              The values will be bound as Strings.
     * @return the number of rows in the table filtered by the selection
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:38.365 -0500", hash_original_method = "B4D6325E78B6FA18E9BDD75F37F7F7A7", hash_generated_method = "BC0B7A6C7758DC73C629DDD9DF9A80E6")
    
public static long queryNumEntries(SQLiteDatabase db, String table, String selection,
            String[] selectionArgs) {
        String s = (!TextUtils.isEmpty(selection)) ? " where " + selection : "";
        return longForQuery(db, "select count(*) from " + table + s,
                    selectionArgs);
    }

    /**
     * Utility method to run the query on the db and return the value in the
     * first column of the first row.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:38.367 -0500", hash_original_method = "1138F251ECE80366C448CEE3E6C39D34", hash_generated_method = "879FB01B5B511D9EAD2D3BA54F086F68")
    
public static long longForQuery(SQLiteDatabase db, String query, String[] selectionArgs) {
        SQLiteStatement prog = db.compileStatement(query);
        try {
            return longForQuery(prog, selectionArgs);
        } finally {
            prog.close();
        }
    }

    /**
     * Utility method to run the pre-compiled query and return the value in the
     * first column of the first row.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:38.370 -0500", hash_original_method = "FD2C3250D9E68CC4AB6807C768E508FC", hash_generated_method = "2E5050873F38E2B1C5B23668BF8B665D")
    
public static long longForQuery(SQLiteStatement prog, String[] selectionArgs) {
        prog.bindAllArgsAsStrings(selectionArgs);
        return prog.simpleQueryForLong();
    }

    /**
     * Utility method to run the query on the db and return the value in the
     * first column of the first row.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:38.372 -0500", hash_original_method = "DB160943F37161615396A718C828E921", hash_generated_method = "641D680EFB949033DE6F2B2B75BBE8E1")
    
public static String stringForQuery(SQLiteDatabase db, String query, String[] selectionArgs) {
        SQLiteStatement prog = db.compileStatement(query);
        try {
            return stringForQuery(prog, selectionArgs);
        } finally {
            prog.close();
        }
    }

    /**
     * Utility method to run the pre-compiled query and return the value in the
     * first column of the first row.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:38.376 -0500", hash_original_method = "F5C8CCF0AB5FDE49DF63CF243C328D9F", hash_generated_method = "2CE099AC4E18C8F8257DDF5B3D90A566")
    
public static String stringForQuery(SQLiteStatement prog, String[] selectionArgs) {
        prog.bindAllArgsAsStrings(selectionArgs);
        return prog.simpleQueryForString();
    }

    /**
     * Utility method to run the query on the db and return the blob value in the
     * first column of the first row.
     *
     * @return A read-only file descriptor for a copy of the blob value.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:38.378 -0500", hash_original_method = "540FA090BA73BF75B1FC7EFF0B0F30DC", hash_generated_method = "D9F8EA265EE06DE480D47EA486025147")
    
public static ParcelFileDescriptor blobFileDescriptorForQuery(SQLiteDatabase db,
            String query, String[] selectionArgs) {
        SQLiteStatement prog = db.compileStatement(query);
        try {
            return blobFileDescriptorForQuery(prog, selectionArgs);
        } finally {
            prog.close();
        }
    }

    /**
     * Utility method to run the pre-compiled query and return the blob value in the
     * first column of the first row.
     *
     * @return A read-only file descriptor for a copy of the blob value.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:38.381 -0500", hash_original_method = "198371BAE7EE824416E49767A8F3C5A9", hash_generated_method = "1AB70714505EA6375498FD84B14C7444")
    
public static ParcelFileDescriptor blobFileDescriptorForQuery(SQLiteStatement prog,
            String[] selectionArgs) {
        prog.bindAllArgsAsStrings(selectionArgs);
        return prog.simpleQueryForBlobFileDescriptor();
    }

    /**
     * Reads a String out of a column in a Cursor and writes it to a ContentValues.
     * Adds nothing to the ContentValues if the column isn't present or if its value is null.
     *
     * @param cursor The cursor to read from
     * @param column The column to read
     * @param values The {@link ContentValues} to put the value into
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:38.384 -0500", hash_original_method = "E4819D88C72BF817469C24E1569426A4", hash_generated_method = "A135DD36A4708ECA00C9664FCC332131")
    
public static void cursorStringToContentValuesIfPresent(Cursor cursor, ContentValues values,
            String column) {
        final int index = cursor.getColumnIndex(column);
        if (index != -1 && !cursor.isNull(index)) {
            values.put(column, cursor.getString(index));
        }
    }

    /**
     * Reads a Long out of a column in a Cursor and writes it to a ContentValues.
     * Adds nothing to the ContentValues if the column isn't present or if its value is null.
     *
     * @param cursor The cursor to read from
     * @param column The column to read
     * @param values The {@link ContentValues} to put the value into
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:38.386 -0500", hash_original_method = "360B190BBB89421C9CB5EC1082F87452", hash_generated_method = "5175FC265C12B410D802C28516887E7F")
    
public static void cursorLongToContentValuesIfPresent(Cursor cursor, ContentValues values,
            String column) {
        final int index = cursor.getColumnIndex(column);
        if (index != -1 && !cursor.isNull(index)) {
            values.put(column, cursor.getLong(index));
        }
    }

    /**
     * Reads a Short out of a column in a Cursor and writes it to a ContentValues.
     * Adds nothing to the ContentValues if the column isn't present or if its value is null.
     *
     * @param cursor The cursor to read from
     * @param column The column to read
     * @param values The {@link ContentValues} to put the value into
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:38.389 -0500", hash_original_method = "E3916159B459B4D862132868895E3375", hash_generated_method = "59C3AF75A47101C071B91073FA092953")
    
public static void cursorShortToContentValuesIfPresent(Cursor cursor, ContentValues values,
            String column) {
        final int index = cursor.getColumnIndex(column);
        if (index != -1 && !cursor.isNull(index)) {
            values.put(column, cursor.getShort(index));
        }
    }

    /**
     * Reads a Integer out of a column in a Cursor and writes it to a ContentValues.
     * Adds nothing to the ContentValues if the column isn't present or if its value is null.
     *
     * @param cursor The cursor to read from
     * @param column The column to read
     * @param values The {@link ContentValues} to put the value into
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:38.393 -0500", hash_original_method = "9220AC3EDC51213CD50D1AE5DD6068EA", hash_generated_method = "B2C3788E779EF96C95BB7720C0B4E432")
    
public static void cursorIntToContentValuesIfPresent(Cursor cursor, ContentValues values,
            String column) {
        final int index = cursor.getColumnIndex(column);
        if (index != -1 && !cursor.isNull(index)) {
            values.put(column, cursor.getInt(index));
        }
    }

    /**
     * Reads a Float out of a column in a Cursor and writes it to a ContentValues.
     * Adds nothing to the ContentValues if the column isn't present or if its value is null.
     *
     * @param cursor The cursor to read from
     * @param column The column to read
     * @param values The {@link ContentValues} to put the value into
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:38.395 -0500", hash_original_method = "AC6018F42404EC47E77B301174745A45", hash_generated_method = "BB8D8D43C66405027B782098B2A65121")
    
public static void cursorFloatToContentValuesIfPresent(Cursor cursor, ContentValues values,
            String column) {
        final int index = cursor.getColumnIndex(column);
        if (index != -1 && !cursor.isNull(index)) {
            values.put(column, cursor.getFloat(index));
        }
    }

    /**
     * Reads a Double out of a column in a Cursor and writes it to a ContentValues.
     * Adds nothing to the ContentValues if the column isn't present or if its value is null.
     *
     * @param cursor The cursor to read from
     * @param column The column to read
     * @param values The {@link ContentValues} to put the value into
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:38.397 -0500", hash_original_method = "5A46FFBB11F835A1D00E2D177236CED3", hash_generated_method = "E02F64B417EC6DD2CB66DF18177B431F")
    
public static void cursorDoubleToContentValuesIfPresent(Cursor cursor, ContentValues values,
            String column) {
        final int index = cursor.getColumnIndex(column);
        if (index != -1 && !cursor.isNull(index)) {
            values.put(column, cursor.getDouble(index));
        }
    }

    /**
     * Creates a db and populates it with the sql statements in sqlStatements.
     *
     * @param context the context to use to create the db
     * @param dbName the name of the db to create
     * @param dbVersion the version to set on the db
     * @param sqlStatements the statements to use to populate the db. This should be a single string
     *   of the form returned by sqlite3's <tt>.dump</tt> command (statements separated by
     *   semicolons)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:38.480 -0500", hash_original_method = "BF59FB26E066BD2B7E2B2FCD96B9B9F3", hash_generated_method = "982BE1730A7A2D298BBB05287D16F5B6")
    
static public void createDbFromSqlStatements(
            Context context, String dbName, int dbVersion, String sqlStatements) {
        SQLiteDatabase db = context.openOrCreateDatabase(dbName, 0, null);
        // TODO: this is not quite safe since it assumes that all semicolons at the end of a line
        // terminate statements. It is possible that a text field contains ;\n. We will have to fix
        // this if that turns out to be a problem.
        String[] statements = TextUtils.split(sqlStatements, ";\n");
        for (String statement : statements) {
            if (TextUtils.isEmpty(statement)) continue;
            db.execSQL(statement);
        }
        db.setVersion(dbVersion);
        db.close();
    }

    /**
     * Returns one of the following which represent the type of the given SQL statement.
     * <ol>
     *   <li>{@link #STATEMENT_SELECT}</li>
     *   <li>{@link #STATEMENT_UPDATE}</li>
     *   <li>{@link #STATEMENT_ATTACH}</li>
     *   <li>{@link #STATEMENT_BEGIN}</li>
     *   <li>{@link #STATEMENT_COMMIT}</li>
     *   <li>{@link #STATEMENT_ABORT}</li>
     *   <li>{@link #STATEMENT_OTHER}</li>
     * </ol>
     * @param sql the SQL statement whose type is returned by this method
     * @return one of the values listed above
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:38.483 -0500", hash_original_method = "9A85F93995D1DF0410A040FACCE7AB6C", hash_generated_method = "E846D354E5324A8741E8DFC00E3B273B")
    
public static int getSqlStatementType(String sql) {
        sql = sql.trim();
        if (sql.length() < 3) {
            return STATEMENT_OTHER;
        }
        String prefixSql = sql.substring(0, 3).toUpperCase();
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

    /**
     * Appends one set of selection args to another. This is useful when adding a selection
     * argument to a user provided set.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:38.485 -0500", hash_original_method = "0E268DF7E77D68AC976AB928986A09DD", hash_generated_method = "2BECFD958CA5727B8248577B0B44C684")
    
public static String[] appendSelectionArgs(String[] originalValues, String[] newValues) {
        if (originalValues == null || originalValues.length == 0) {
            return newValues;
        }
        String[] result = new String[originalValues.length + newValues.length ];
        System.arraycopy(originalValues, 0, result, 0, originalValues.length);
        System.arraycopy(newValues, 0, result, originalValues.length, newValues.length);
        return result;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:38.227 -0500", hash_original_field = "AC243BB121DEEDBC2ED7D027B8D07447", hash_generated_field = "1FE3C375C216F1A5BEF4D0C706AC2FD3")

    private static final String TAG = "DatabaseUtils";
    
    public static class InsertHelper {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:38.419 -0500", hash_original_field = "BFE8FED17723302566445D7C51E513E3", hash_generated_field = "65A2F50AB6F61733B444F32A68BCAC15")

        public static final int TABLE_INFO_PRAGMA_COLUMNNAME_INDEX = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:38.422 -0500", hash_original_field = "3B7B95FAC283376853F3CD76E448CDFF", hash_generated_field = "E75F8B45A4A09AC1C6BBD56421B4EB2A")

        public static final int TABLE_INFO_PRAGMA_DEFAULT_INDEX = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:38.400 -0500", hash_original_field = "F34517A3CF2A339F68B081C837324DA1", hash_generated_field = "92D26B03BAC08A535924894FFC21F4C1")

        private  SQLiteDatabase mDb;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:38.403 -0500", hash_original_field = "A3641A59D25DF1C754B32221EB159084", hash_generated_field = "92B06808D569C2D663D953BC8B279336")

        private  String mTableName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:38.406 -0500", hash_original_field = "E32B697CE1D8597823633036CE4E7CA2", hash_generated_field = "5AFDB64706963E9A447E7450FF8702D2")

        private HashMap<String, Integer> mColumns;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:38.409 -0500", hash_original_field = "B120FE9F65296E8324FFD29D76DC0550", hash_generated_field = "09FBB1AE74AFBED9E0ABEDDB238A177E")

        private String mInsertSQL = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:38.412 -0500", hash_original_field = "5BF14E1BB0E063898EC0DDB0092386BE", hash_generated_field = "AAD873AB78403BAA5279E14A19451412")

        private SQLiteStatement mInsertStatement = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:38.414 -0500", hash_original_field = "0E83806F77015B3F862A0E1AB5E53DC9", hash_generated_field = "62935F14EC8B4C3549EF440E40AC46A5")

        private SQLiteStatement mReplaceStatement = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:38.417 -0500", hash_original_field = "69FE0755F972174C65D9CAE9E47C5C39", hash_generated_field = "90581E4B6149E61FC27485A9D17C51E2")

        private SQLiteStatement mPreparedStatement = null;

        /**
         * @param db the SQLiteDatabase to insert into
         * @param tableName the name of the table to insert into
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:38.425 -0500", hash_original_method = "24A3E628A21DF3387C7E8AFA040BF2F9", hash_generated_method = "5279D8FEEDD13B0C62914870C5D603D2")
        
public InsertHelper(SQLiteDatabase db, String tableName) {
            mDb = db;
            mTableName = tableName;
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:38.428 -0500", hash_original_method = "C9A601B53671BC96A8E157301601DE92", hash_generated_method = "E5EA1E12A1537CF74E7BFAF3D2FE6D1E")
        
private void buildSQL() throws SQLException {
            StringBuilder sb = new StringBuilder(128);
            sb.append("INSERT INTO ");
            sb.append(mTableName);
            sb.append(" (");

            StringBuilder sbv = new StringBuilder(128);
            sbv.append("VALUES (");

            int i = 1;
            Cursor cur = null;
            try {
                cur = mDb.rawQuery("PRAGMA table_info(" + mTableName + ")", null);
                mColumns = new HashMap<String, Integer>(cur.getCount());
                while (cur.moveToNext()) {
                    String columnName = cur.getString(TABLE_INFO_PRAGMA_COLUMNNAME_INDEX);
                    String defaultValue = cur.getString(TABLE_INFO_PRAGMA_DEFAULT_INDEX);

                    mColumns.put(columnName, i);
                    sb.append("'");
                    sb.append(columnName);
                    sb.append("'");

                    if (defaultValue == null) {
                        sbv.append("?");
                    } else {
                        sbv.append("COALESCE(?, ");
                        sbv.append(defaultValue);
                        sbv.append(")");
                    }

                    sb.append(i == cur.getCount() ? ") " : ", ");
                    sbv.append(i == cur.getCount() ? ");" : ", ");
                    ++i;
                }
            } finally {
                if (cur != null) cur.close();
            }

            sb.append(sbv);

            mInsertSQL = sb.toString();
            if (LOCAL_LOGV) Log.v(TAG, "insert statement is " + mInsertSQL);
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:38.431 -0500", hash_original_method = "102F3921944A0F32C4E4BE81F61A753B", hash_generated_method = "2042BE993FAEE612AB01109525A826F1")
        
private SQLiteStatement getStatement(boolean allowReplace) throws SQLException {
            if (allowReplace) {
                if (mReplaceStatement == null) {
                    if (mInsertSQL == null) buildSQL();
                    // chop "INSERT" off the front and prepend "INSERT OR REPLACE" instead.
                    String replaceSQL = "INSERT OR REPLACE" + mInsertSQL.substring(6);
                    mReplaceStatement = mDb.compileStatement(replaceSQL);
                }
                return mReplaceStatement;
            } else {
                if (mInsertStatement == null) {
                    if (mInsertSQL == null) buildSQL();
                    mInsertStatement = mDb.compileStatement(mInsertSQL);
                }
                return mInsertStatement;
            }
        }

        /**
         * Performs an insert, adding a new row with the given values.
         *
         * @param values the set of values with which  to populate the
         * new row
         * @param allowReplace if true, the statement does "INSERT OR
         *   REPLACE" instead of "INSERT", silently deleting any
         *   previously existing rows that would cause a conflict
         *
         * @return the row ID of the newly inserted row, or -1 if an
         * error occurred
         */
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:38.434 -0500", hash_original_method = "13ED4597857164B01AAF7D1C6E2C9384", hash_generated_method = "CCBE22CE3839C3F0D1FFDCDB80A9C33B")
        
private synchronized long insertInternal(ContentValues values, boolean allowReplace) {
            try {
                SQLiteStatement stmt = getStatement(allowReplace);
                stmt.clearBindings();
                if (LOCAL_LOGV) Log.v(TAG, "--- inserting in table " + mTableName);
                for (Map.Entry<String, Object> e: values.valueSet()) {
                    final String key = e.getKey();
                    int i = getColumnIndex(key);
                    DatabaseUtils.bindObjectToProgram(stmt, i, e.getValue());
                    if (LOCAL_LOGV) {
                        Log.v(TAG, "binding " + e.getValue() + " to column " +
                              i + " (" + key + ")");
                    }
                }
                return stmt.executeInsert();
            } catch (SQLException e) {
                Log.e(TAG, "Error inserting " + values + " into table  " + mTableName, e);
                return -1;
            }
        }

        /**
         * Returns the index of the specified column. This is index is suitagble for use
         * in calls to bind().
         * @param key the column name
         * @return the index of the column
         */
        @DSSource({DSSourceKind.DATABASE_INFORMATION})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:38.437 -0500", hash_original_method = "2FE6EA3004F5838FAFB27DD4EF6900C7", hash_generated_method = "F083CAABF23AF09216F669BFCD72D367")
        
public int getColumnIndex(String key) {
            getStatement(false);
            final Integer index = mColumns.get(key);
            if (index == null) {
                throw new IllegalArgumentException("column '" + key + "' is invalid");
            }
            return index;
        }

        /**
         * Bind the value to an index. A prepareForInsert() or prepareForReplace()
         * without a matching execute() must have already have been called.
         * @param index the index of the slot to which to bind
         * @param value the value to bind
         */
        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:38.440 -0500", hash_original_method = "898F1EFFAEB546E6A9657A001F4AE1E8", hash_generated_method = "F9C40C81C68344DF4C359DF8BF2FBEE9")
        
public void bind(int index, double value) {
            mPreparedStatement.bindDouble(index, value);
        }

        /**
         * Bind the value to an index. A prepareForInsert() or prepareForReplace()
         * without a matching execute() must have already have been called.
         * @param index the index of the slot to which to bind
         * @param value the value to bind
         */
        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:38.442 -0500", hash_original_method = "85D356AA3C69D35869973C25B38955EB", hash_generated_method = "51159D6A6BCA645A9FECFE7044BCE2E6")
        
public void bind(int index, float value) {
            mPreparedStatement.bindDouble(index, value);
        }

        /**
         * Bind the value to an index. A prepareForInsert() or prepareForReplace()
         * without a matching execute() must have already have been called.
         * @param index the index of the slot to which to bind
         * @param value the value to bind
         */
        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:38.444 -0500", hash_original_method = "76F2FAC154909632438A49671F5D33A8", hash_generated_method = "9398ED4569F070ECF144AEEF7742700F")
        
public void bind(int index, long value) {
            mPreparedStatement.bindLong(index, value);
        }

        /**
         * Bind the value to an index. A prepareForInsert() or prepareForReplace()
         * without a matching execute() must have already have been called.
         * @param index the index of the slot to which to bind
         * @param value the value to bind
         */
        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:38.446 -0500", hash_original_method = "A73EABD891E538A0A03C5C4A49C29503", hash_generated_method = "1A141A934B3EFEF0FC0BE64726DE55FA")
        
public void bind(int index, int value) {
            mPreparedStatement.bindLong(index, value);
        }

        /**
         * Bind the value to an index. A prepareForInsert() or prepareForReplace()
         * without a matching execute() must have already have been called.
         * @param index the index of the slot to which to bind
         * @param value the value to bind
         */
        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:38.449 -0500", hash_original_method = "D4E75DDD13795169D0FEAC83726F0F45", hash_generated_method = "C7371512E5E8EE49D9DEB2147152339E")
        
public void bind(int index, boolean value) {
            mPreparedStatement.bindLong(index, value ? 1 : 0);
        }

        /**
         * Bind null to an index. A prepareForInsert() or prepareForReplace()
         * without a matching execute() must have already have been called.
         * @param index the index of the slot to which to bind
         */
        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:38.452 -0500", hash_original_method = "27990C90801E0788D0DEC119EA5D904E", hash_generated_method = "D44D088758A5484E469199565F51B0BB")
        
public void bindNull(int index) {
            mPreparedStatement.bindNull(index);
        }

        /**
         * Bind the value to an index. A prepareForInsert() or prepareForReplace()
         * without a matching execute() must have already have been called.
         * @param index the index of the slot to which to bind
         * @param value the value to bind
         */
        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:38.454 -0500", hash_original_method = "B7B8BDC3019EC6DD4050CE3C3C2D0B33", hash_generated_method = "F7A9BFB62194C0AAA6AC372A893B199F")
        
public void bind(int index, byte[] value) {
            if (value == null) {
                mPreparedStatement.bindNull(index);
            } else {
                mPreparedStatement.bindBlob(index, value);
            }
        }

        /**
         * Bind the value to an index. A prepareForInsert() or prepareForReplace()
         * without a matching execute() must have already have been called.
         * @param index the index of the slot to which to bind
         * @param value the value to bind
         */
        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:38.457 -0500", hash_original_method = "70AF33973781662CA48B1120B9D51D5F", hash_generated_method = "3AA8A3379FD3EF5E8F74AFA39939EA2C")
        
public void bind(int index, String value) {
            if (value == null) {
                mPreparedStatement.bindNull(index);
            } else {
                mPreparedStatement.bindString(index, value);
            }
        }

        /**
         * Performs an insert, adding a new row with the given values.
         * If the table contains conflicting rows, an error is
         * returned.
         *
         * @param values the set of values with which to populate the
         * new row
         *
         * @return the row ID of the newly inserted row, or -1 if an
         * error occurred
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:38.459 -0500", hash_original_method = "9556B578266975E5A98CFEB0C2204667", hash_generated_method = "B0F6AB4EB61F7A86F4C78599925651CF")
        
public long insert(ContentValues values) {
            return insertInternal(values, false);
        }

        /**
         * Execute the previously prepared insert or replace using the bound values
         * since the last call to prepareForInsert or prepareForReplace.
         *
         * <p>Note that calling bind() and then execute() is not thread-safe. The only thread-safe
         * way to use this class is to call insert() or replace().
         *
         * @return the row ID of the newly inserted row, or -1 if an
         * error occurred
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:38.462 -0500", hash_original_method = "C80CA050416DA84901D4F7B0B2F41300", hash_generated_method = "DD7ECBBE06923C0BEC652FE851DDA82B")
        
public long execute() {
            if (mPreparedStatement == null) {
                throw new IllegalStateException("you must prepare this inserter before calling "
                        + "execute");
            }
            try {
                if (LOCAL_LOGV) Log.v(TAG, "--- doing insert or replace in table " + mTableName);
                return mPreparedStatement.executeInsert();
            } catch (SQLException e) {
                Log.e(TAG, "Error executing InsertHelper with table " + mTableName, e);
                return -1;
            } finally {
                // you can only call this once per prepare
                mPreparedStatement = null;
            }
        }

        /**
         * Prepare the InsertHelper for an insert. The pattern for this is:
         * <ul>
         * <li>prepareForInsert()
         * <li>bind(index, value);
         * <li>bind(index, value);
         * <li>...
         * <li>bind(index, value);
         * <li>execute();
         * </ul>
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:38.464 -0500", hash_original_method = "BEDC7093698B9136E99447F456E9608C", hash_generated_method = "CDE373DF2B92F0C86FB3B28296D008D6")
        
public void prepareForInsert() {
            mPreparedStatement = getStatement(false);
            mPreparedStatement.clearBindings();
        }

        /**
         * Prepare the InsertHelper for a replace. The pattern for this is:
         * <ul>
         * <li>prepareForReplace()
         * <li>bind(index, value);
         * <li>bind(index, value);
         * <li>...
         * <li>bind(index, value);
         * <li>execute();
         * </ul>
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:38.468 -0500", hash_original_method = "2DC72BFF923FF55EA48E8D651F79AFBE", hash_generated_method = "C104F51FC01594EFD5D80ED444738FFE")
        
public void prepareForReplace() {
            mPreparedStatement = getStatement(true);
            mPreparedStatement.clearBindings();
        }

        /**
         * Performs an insert, adding a new row with the given values.
         * If the table contains conflicting rows, they are deleted
         * and replaced with the new row.
         *
         * @param values the set of values with which to populate the
         * new row
         *
         * @return the row ID of the newly inserted row, or -1 if an
         * error occurred
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:38.470 -0500", hash_original_method = "C177E80799F9F51057A5F361D4C5571B", hash_generated_method = "BA62DAC4F150FFE24970E26679C6A589")
        
public long replace(ContentValues values) {
            return insertInternal(values, true);
        }

        /**
         * Close this object and release any resources associated with
         * it.  The behavior of calling <code>insert()</code> after
         * calling this method is undefined.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:38.473 -0500", hash_original_method = "21909697F743246FF7034BA444D2FBF0", hash_generated_method = "174EA5B3EE24112A639E97FE39E5B1D6")
        
public void close() {
            if (mInsertStatement != null) {
                mInsertStatement.close();
                mInsertStatement = null;
            }
            if (mReplaceStatement != null) {
                mReplaceStatement.close();
                mReplaceStatement = null;
            }
            mInsertSQL = null;
            mColumns = null;
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:38.229 -0500", hash_original_field = "81DD852ECBE07BA98A61C8F3D0C85F01", hash_generated_field = "58EDF43BA541A4D47EECFEC3901C7AED")

    private static final boolean DEBUG = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:38.232 -0500", hash_original_field = "745FE27F6621B49CB7F0165D799C0855", hash_generated_field = "626038DAE6BB26944A3CF12B5D6F74EE")

    private static final boolean LOCAL_LOGV = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:38.234 -0500", hash_original_field = "060FF946F44F82F24E670763EBDB7BBF", hash_generated_field = "A9BB21413E0B9FDB529AF62765E841A5")

    private static final String[] countProjection = new String[]{"count(*)"};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:38.237 -0500", hash_original_field = "6ABE43256BEF3B310419381B16620618", hash_generated_field = "4648C235C26E35A03693F2CCB0369012")

    public static final int STATEMENT_SELECT = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:38.240 -0500", hash_original_field = "AEB3A38F380069FFC2A5CB55942E59DD", hash_generated_field = "6B2A4824744946252E51300EBC79E592")

    public static final int STATEMENT_UPDATE = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:38.242 -0500", hash_original_field = "A1C7BF2806CD8885FE947DD85FE52756", hash_generated_field = "2ACC3D548878CC219AA49F7804828063")

    public static final int STATEMENT_ATTACH = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:38.245 -0500", hash_original_field = "CF60954E1C8FE84B67F701F8D38B6C37", hash_generated_field = "02A421ACB07995DB47634279A2479B60")

    public static final int STATEMENT_BEGIN = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:38.247 -0500", hash_original_field = "56E00AEB39B07E6243594B7020E4D3A3", hash_generated_field = "A6C603A158EA8E9046E04946D4516AA3")

    public static final int STATEMENT_COMMIT = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:38.250 -0500", hash_original_field = "DA79C3684466C0CDEBCAEFAB7A85556C", hash_generated_field = "8F86283F91FE4F97606CB017F6364760")

    public static final int STATEMENT_ABORT = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:38.252 -0500", hash_original_field = "8F0AF4CB9BF30EBFB3C94DDBC65ACD15", hash_generated_field = "C15D3B7768DE951957CC8DFC9D19405B")

    public static final int STATEMENT_PRAGMA = 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:38.256 -0500", hash_original_field = "DA2710D140E368D151D362881924C233", hash_generated_field = "8DC2B7B4CA8DB7D59D8A5F9177912461")

    public static final int STATEMENT_DDL = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:38.258 -0500", hash_original_field = "C71E98C72EF4342FD939F1D674BE2130", hash_generated_field = "52E7CCF3D2536FB7A3368B1F5E5546C4")

    public static final int STATEMENT_UNPREPARED = 9;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:38.261 -0500", hash_original_field = "9F4E9F2BE74050E9E88F6D994BFCF990", hash_generated_field = "5F2F4749E3B45E10482F4E32EAB579F5")

    public static final int STATEMENT_OTHER = 99;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:38.308 -0500", hash_original_field = "30509007D4B85CC0C448607239B0E0D3", hash_generated_field = "64EC00AB4BE1B864318AEBC676ADD327")

    private static Collator mColl = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.928 -0400", hash_original_method = "333D4DF31C6A57BA4790D091F2223BA8", hash_generated_method = "333D4DF31C6A57BA4790D091F2223BA8")
    public DatabaseUtils ()
    {
        //Synthesized constructor
    }
}

