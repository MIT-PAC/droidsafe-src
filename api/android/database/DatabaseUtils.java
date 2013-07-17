package android.database;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
import java.util.Map;

public class DatabaseUtils {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.928 -0400", hash_original_method = "333D4DF31C6A57BA4790D091F2223BA8", hash_generated_method = "333D4DF31C6A57BA4790D091F2223BA8")
    public DatabaseUtils ()
    {
        //Synthesized constructor
    }


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

    
    public static final void readExceptionFromParcel(Parcel reply) {
        int code = reply.readExceptionCode();
        if (code == 0) return;
        String msg = reply.readString();
        DatabaseUtils.readExceptionFromParcel(reply, msg, code);
    }

    
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

    
    @DSModeled(DSC.SAFE)
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

    
    public static String sqlEscapeString(String value) {
        StringBuilder escaper = new StringBuilder();
        DatabaseUtils.appendEscapedSQLString(escaper, value);
        return escaper.toString();
    }

    
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

    
    public static String concatenateWhere(String a, String b) {
        if (TextUtils.isEmpty(a)) {
            return b;
        }
        if (TextUtils.isEmpty(b)) {
            return a;
        }
        return "(" + a + ") AND (" + b + ")";
    }

    
    public static String getCollationKey(String name) {
        byte [] arr = getCollationKeyInBytes(name);
        try {
            return new String(arr, 0, getKeyLen(arr), "ISO8859_1");
        } catch (Exception ex) {
            return "";
        }
    }

    
    public static String getHexCollationKey(String name) {
        byte [] arr = getCollationKeyInBytes(name);
        char[] keys = Hex.encodeHex(arr);
        return new String(keys, 0, getKeyLen(arr) * 2);
    }

    
    @DSModeled(DSC.SAFE)
    private static int getKeyLen(byte[] arr) {
        if (arr[arr.length - 1] != 0) {
            return arr.length;
        } else {
            return arr.length-1;
        }
    }

    
    private static byte[] getCollationKeyInBytes(String name) {
        if (mColl == null) {
            mColl = Collator.getInstance();
            mColl.setStrength(Collator.PRIMARY);
        }
        return mColl.getCollationKey(name).toByteArray();
    }

    
    public static void dumpCursor(Cursor cursor) {
        dumpCursor(cursor, System.out);
    }

    
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

    
    public static String dumpCursorToString(Cursor cursor) {
        StringBuilder sb = new StringBuilder();
        dumpCursor(cursor, sb);
        return sb.toString();
    }

    
    public static void dumpCurrentRow(Cursor cursor) {
        dumpCurrentRow(cursor, System.out);
    }

    
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

    
    public static String dumpCurrentRowToString(Cursor cursor) {
        StringBuilder sb = new StringBuilder();
        dumpCurrentRow(cursor, sb);
        return sb.toString();
    }

    
    public static void cursorStringToContentValues(Cursor cursor, String field,
            ContentValues values) {
        cursorStringToContentValues(cursor, field, values, field);
    }

    
    public static void cursorStringToInsertHelper(Cursor cursor, String field,
            InsertHelper inserter, int index) {
        inserter.bind(index, cursor.getString(cursor.getColumnIndexOrThrow(field)));
    }

    
    public static void cursorStringToContentValues(Cursor cursor, String field,
            ContentValues values, String key) {
        values.put(key, cursor.getString(cursor.getColumnIndexOrThrow(field)));
    }

    
    public static void cursorIntToContentValues(Cursor cursor, String field, ContentValues values) {
        cursorIntToContentValues(cursor, field, values, field);
    }

    
    public static void cursorIntToContentValues(Cursor cursor, String field, ContentValues values,
            String key) {
        int colIndex = cursor.getColumnIndex(field);
        if (!cursor.isNull(colIndex)) {
            values.put(key, cursor.getInt(colIndex));
        } else {
            values.put(key, (Integer) null);
        }
    }

    
    public static void cursorLongToContentValues(Cursor cursor, String field, ContentValues values) {
        cursorLongToContentValues(cursor, field, values, field);
    }

    
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

    
    public static void cursorDoubleToCursorValues(Cursor cursor, String field, ContentValues values) {
        cursorDoubleToContentValues(cursor, field, values, field);
    }

    
    public static void cursorDoubleToContentValues(Cursor cursor, String field,
            ContentValues values, String key) {
        int colIndex = cursor.getColumnIndex(field);
        if (!cursor.isNull(colIndex)) {
            values.put(key, cursor.getDouble(colIndex));
        } else {
            values.put(key, (Double) null);
        }
    }

    
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

    
    public static long queryNumEntries(SQLiteDatabase db, String table) {
        return queryNumEntries(db, table, null, null);
    }

    
    @DSModeled(DSC.SPEC)
    public static long queryNumEntries(SQLiteDatabase db, String table, String selection) {
        return queryNumEntries(db, table, selection, null);
    }

    
    @DSModeled(DSC.SPEC)
    public static long queryNumEntries(SQLiteDatabase db, String table, String selection,
            String[] selectionArgs) {
        String s = (!TextUtils.isEmpty(selection)) ? " where " + selection : "";
        return longForQuery(db, "select count(*) from " + table + s,
                    selectionArgs);
    }

    
    public static long longForQuery(SQLiteDatabase db, String query, String[] selectionArgs) {
        SQLiteStatement prog = db.compileStatement(query);
        try {
            return longForQuery(prog, selectionArgs);
        } finally {
            prog.close();
        }
    }

    
    public static long longForQuery(SQLiteStatement prog, String[] selectionArgs) {
        prog.bindAllArgsAsStrings(selectionArgs);
        return prog.simpleQueryForLong();
    }

    
    public static String stringForQuery(SQLiteDatabase db, String query, String[] selectionArgs) {
        SQLiteStatement prog = db.compileStatement(query);
        try {
            return stringForQuery(prog, selectionArgs);
        } finally {
            prog.close();
        }
    }

    
    public static String stringForQuery(SQLiteStatement prog, String[] selectionArgs) {
        prog.bindAllArgsAsStrings(selectionArgs);
        return prog.simpleQueryForString();
    }

    
    public static ParcelFileDescriptor blobFileDescriptorForQuery(SQLiteDatabase db,
            String query, String[] selectionArgs) {
        SQLiteStatement prog = db.compileStatement(query);
        try {
            return blobFileDescriptorForQuery(prog, selectionArgs);
        } finally {
            prog.close();
        }
    }

    
    public static ParcelFileDescriptor blobFileDescriptorForQuery(SQLiteStatement prog,
            String[] selectionArgs) {
        prog.bindAllArgsAsStrings(selectionArgs);
        return prog.simpleQueryForBlobFileDescriptor();
    }

    
    public static void cursorStringToContentValuesIfPresent(Cursor cursor, ContentValues values,
            String column) {
        final int index = cursor.getColumnIndex(column);
        if (index != -1 && !cursor.isNull(index)) {
            values.put(column, cursor.getString(index));
        }
    }

    
    public static void cursorLongToContentValuesIfPresent(Cursor cursor, ContentValues values,
            String column) {
        final int index = cursor.getColumnIndex(column);
        if (index != -1 && !cursor.isNull(index)) {
            values.put(column, cursor.getLong(index));
        }
    }

    
    public static void cursorShortToContentValuesIfPresent(Cursor cursor, ContentValues values,
            String column) {
        final int index = cursor.getColumnIndex(column);
        if (index != -1 && !cursor.isNull(index)) {
            values.put(column, cursor.getShort(index));
        }
    }

    
    public static void cursorIntToContentValuesIfPresent(Cursor cursor, ContentValues values,
            String column) {
        final int index = cursor.getColumnIndex(column);
        if (index != -1 && !cursor.isNull(index)) {
            values.put(column, cursor.getInt(index));
        }
    }

    
    public static void cursorFloatToContentValuesIfPresent(Cursor cursor, ContentValues values,
            String column) {
        final int index = cursor.getColumnIndex(column);
        if (index != -1 && !cursor.isNull(index)) {
            values.put(column, cursor.getFloat(index));
        }
    }

    
    public static void cursorDoubleToContentValuesIfPresent(Cursor cursor, ContentValues values,
            String column) {
        final int index = cursor.getColumnIndex(column);
        if (index != -1 && !cursor.isNull(index)) {
            values.put(column, cursor.getDouble(index));
        }
    }

    
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

    
    public static String[] appendSelectionArgs(String[] originalValues, String[] newValues) {
        if (originalValues == null || originalValues.length == 0) {
            return newValues;
        }
        String[] result = new String[originalValues.length + newValues.length ];
        System.arraycopy(originalValues, 0, result, 0, originalValues.length);
        System.arraycopy(newValues, 0, result, originalValues.length, newValues.length);
        return result;
    }

    
    public static class InsertHelper {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.937 -0400", hash_original_field = "2C1EEFAAB431F1A18FBAAB2A87866E85", hash_generated_field = "92D26B03BAC08A535924894FFC21F4C1")

        private SQLiteDatabase mDb;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.937 -0400", hash_original_field = "B71DEA0DF5DA23E0FBC017945459C34D", hash_generated_field = "92B06808D569C2D663D953BC8B279336")

        private String mTableName;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.937 -0400", hash_original_field = "11C985F30142FD30ACDDFE7CD3BD4A9B", hash_generated_field = "5AFDB64706963E9A447E7450FF8702D2")

        private HashMap<String, Integer> mColumns;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.937 -0400", hash_original_field = "1476A390C50866E58B8AF0E4D2CA1527", hash_generated_field = "09FBB1AE74AFBED9E0ABEDDB238A177E")

        private String mInsertSQL = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.937 -0400", hash_original_field = "0D20AC5F6BC35270667DEA7EE7143B72", hash_generated_field = "AAD873AB78403BAA5279E14A19451412")

        private SQLiteStatement mInsertStatement = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.937 -0400", hash_original_field = "17EC76BAB05004E63F8F765E8D3DC260", hash_generated_field = "62935F14EC8B4C3549EF440E40AC46A5")

        private SQLiteStatement mReplaceStatement = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.937 -0400", hash_original_field = "7B288F8220663431EEB2CA0F873AA44F", hash_generated_field = "90581E4B6149E61FC27485A9D17C51E2")

        private SQLiteStatement mPreparedStatement = null;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.938 -0400", hash_original_method = "24A3E628A21DF3387C7E8AFA040BF2F9", hash_generated_method = "9304EA159E4A3B2A8E923B7EF28AE928")
        public  InsertHelper(SQLiteDatabase db, String tableName) {
            mDb = db;
            mTableName = tableName;
            // ---------- Original Method ----------
            //mDb = db;
            //mTableName = tableName;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.938 -0400", hash_original_method = "C9A601B53671BC96A8E157301601DE92", hash_generated_method = "AC5690D02BA66ABBAABD03801E28CA4E")
        private void buildSQL() throws SQLException {
            StringBuilder sb = new StringBuilder(128);
            sb.append("INSERT INTO ");
            sb.append(mTableName);
            sb.append(" (");
            StringBuilder sbv = new StringBuilder(128);
            sbv.append("VALUES (");
            int i = 1;
            Cursor cur = null;
            try 
            {
                cur = mDb.rawQuery("PRAGMA table_info(" + mTableName + ")", null);
                mColumns = new HashMap<String, Integer>(cur.getCount());
                while
(cur.moveToNext())                
                {
                    String columnName = cur.getString(TABLE_INFO_PRAGMA_COLUMNNAME_INDEX);
                    String defaultValue = cur.getString(TABLE_INFO_PRAGMA_DEFAULT_INDEX);
                    mColumns.put(columnName, i);
                    sb.append("'");
                    sb.append(columnName);
                    sb.append("'");
                    if(defaultValue == null)                    
                    {
                        sbv.append("?");
                    } //End block
                    else
                    {
                        sbv.append("COALESCE(?, ");
                        sbv.append(defaultValue);
                        sbv.append(")");
                    } //End block
                    sb.append(i == cur.getCount() ? ") " : ", ");
                    sbv.append(i == cur.getCount() ? ");" : ", ");
                    ++i;
                } //End block
            } //End block
            finally 
            {
                if(cur != null)                
                cur.close();
            } //End block
            sb.append(sbv);
            mInsertSQL = sb.toString();
            if(LOCAL_LOGV){ }
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.939 -0400", hash_original_method = "102F3921944A0F32C4E4BE81F61A753B", hash_generated_method = "426753298BB544ADC0BA480E8630BB1D")
        private SQLiteStatement getStatement(boolean allowReplace) throws SQLException {
            addTaint(allowReplace);
            if(allowReplace)            
            {
                if(mReplaceStatement == null)                
                {
                    if(mInsertSQL == null)                    
                    buildSQL();
                    String replaceSQL = "INSERT OR REPLACE" + mInsertSQL.substring(6);
                    mReplaceStatement = mDb.compileStatement(replaceSQL);
                } //End block
SQLiteStatement varEE68A500C86ADC6CC4A62D1FA299D51B_956576153 =                 mReplaceStatement;
                varEE68A500C86ADC6CC4A62D1FA299D51B_956576153.addTaint(taint);
                return varEE68A500C86ADC6CC4A62D1FA299D51B_956576153;
            } //End block
            else
            {
                if(mInsertStatement == null)                
                {
                    if(mInsertSQL == null)                    
                    buildSQL();
                    mInsertStatement = mDb.compileStatement(mInsertSQL);
                } //End block
SQLiteStatement varAD5A42E88853B75996FA8F712CDDA6AE_1084171090 =                 mInsertStatement;
                varAD5A42E88853B75996FA8F712CDDA6AE_1084171090.addTaint(taint);
                return varAD5A42E88853B75996FA8F712CDDA6AE_1084171090;
            } //End block
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.939 -0400", hash_original_method = "13ED4597857164B01AAF7D1C6E2C9384", hash_generated_method = "65A6DB51C5E8144C8E822D8B4BF6A289")
        private synchronized long insertInternal(ContentValues values, boolean allowReplace) {
            addTaint(allowReplace);
            addTaint(values.getTaint());
            try 
            {
                SQLiteStatement stmt = getStatement(allowReplace);
                stmt.clearBindings();
                if(LOCAL_LOGV){ }for(Map.Entry<String, Object> e : values.valueSet())
                {
                    final String key = e.getKey();
                    int i = getColumnIndex(key);
                    DatabaseUtils.bindObjectToProgram(stmt, i, e.getValue());
                    if(LOCAL_LOGV)                    
                    {
                    } //End block
                } //End block
                long var1127914C5B9108749821AB7395969133_1775880873 = (stmt.executeInsert());
                                long var0F5264038205EDFB1AC05FBB0E8C5E94_1283030960 = getTaintLong();
                return var0F5264038205EDFB1AC05FBB0E8C5E94_1283030960;
            } //End block
            catch (SQLException e)
            {
                long var6BB61E3B7BCE0931DA574D19D1D82C88_470989112 = (-1);
                                long var0F5264038205EDFB1AC05FBB0E8C5E94_1968143151 = getTaintLong();
                return var0F5264038205EDFB1AC05FBB0E8C5E94_1968143151;
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.939 -0400", hash_original_method = "2FE6EA3004F5838FAFB27DD4EF6900C7", hash_generated_method = "AB99BE11BE6005309C70527F94038115")
        public int getColumnIndex(String key) {
            addTaint(key.getTaint());
            getStatement(false);
            final Integer index = mColumns.get(key);
            if(index == null)            
            {
                IllegalArgumentException varB4DF23F40945651B092E0DBDB0C453DD_597786392 = new IllegalArgumentException("column '" + key + "' is invalid");
                varB4DF23F40945651B092E0DBDB0C453DD_597786392.addTaint(taint);
                throw varB4DF23F40945651B092E0DBDB0C453DD_597786392;
            } //End block
            int var6A992D5529F459A44FEE58C733255E86_208738143 = (index);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1669422933 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1669422933;
            // ---------- Original Method ----------
            //getStatement(false);
            //final Integer index = mColumns.get(key);
            //if (index == null) {
                //throw new IllegalArgumentException("column '" + key + "' is invalid");
            //}
            //return index;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.939 -0400", hash_original_method = "898F1EFFAEB546E6A9657A001F4AE1E8", hash_generated_method = "2D5384212FA39CCA93F1F5D596B800CE")
        public void bind(int index, double value) {
            addTaint(value);
            addTaint(index);
            mPreparedStatement.bindDouble(index, value);
            // ---------- Original Method ----------
            //mPreparedStatement.bindDouble(index, value);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.940 -0400", hash_original_method = "85D356AA3C69D35869973C25B38955EB", hash_generated_method = "4EC0EF26E3CD2307376537B7BB1FABBD")
        public void bind(int index, float value) {
            addTaint(value);
            addTaint(index);
            mPreparedStatement.bindDouble(index, value);
            // ---------- Original Method ----------
            //mPreparedStatement.bindDouble(index, value);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.940 -0400", hash_original_method = "76F2FAC154909632438A49671F5D33A8", hash_generated_method = "D794620D13434335C62B0235B4C71680")
        public void bind(int index, long value) {
            addTaint(value);
            addTaint(index);
            mPreparedStatement.bindLong(index, value);
            // ---------- Original Method ----------
            //mPreparedStatement.bindLong(index, value);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.940 -0400", hash_original_method = "A73EABD891E538A0A03C5C4A49C29503", hash_generated_method = "CBEBF59695B1CAC3EE1F22DA3B73B641")
        public void bind(int index, int value) {
            addTaint(value);
            addTaint(index);
            mPreparedStatement.bindLong(index, value);
            // ---------- Original Method ----------
            //mPreparedStatement.bindLong(index, value);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.940 -0400", hash_original_method = "D4E75DDD13795169D0FEAC83726F0F45", hash_generated_method = "224BE41DDA4184BB8CD8D0025AA3B5AA")
        public void bind(int index, boolean value) {
            addTaint(value);
            addTaint(index);
            mPreparedStatement.bindLong(index, value ? 1 : 0);
            // ---------- Original Method ----------
            //mPreparedStatement.bindLong(index, value ? 1 : 0);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.940 -0400", hash_original_method = "27990C90801E0788D0DEC119EA5D904E", hash_generated_method = "A145DF7D2CE70136226FD0B2C508A3E2")
        public void bindNull(int index) {
            addTaint(index);
            mPreparedStatement.bindNull(index);
            // ---------- Original Method ----------
            //mPreparedStatement.bindNull(index);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.941 -0400", hash_original_method = "B7B8BDC3019EC6DD4050CE3C3C2D0B33", hash_generated_method = "2148B5D144CEF616DB98F051DDFB80FA")
        public void bind(int index, byte[] value) {
            addTaint(value[0]);
            addTaint(index);
            if(value == null)            
            {
                mPreparedStatement.bindNull(index);
            } //End block
            else
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.941 -0400", hash_original_method = "70AF33973781662CA48B1120B9D51D5F", hash_generated_method = "46B6F55BF2344AE0EAF4C95C015AF160")
        public void bind(int index, String value) {
            addTaint(value.getTaint());
            addTaint(index);
            if(value == null)            
            {
                mPreparedStatement.bindNull(index);
            } //End block
            else
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.941 -0400", hash_original_method = "9556B578266975E5A98CFEB0C2204667", hash_generated_method = "859DB4C5D61E861EB3EF12FD8A011A7F")
        public long insert(ContentValues values) {
            addTaint(values.getTaint());
            long varE6B1E23565A47916B8E419B3A64ACE91_1444931597 = (insertInternal(values, false));
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_222530444 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_222530444;
            // ---------- Original Method ----------
            //return insertInternal(values, false);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.942 -0400", hash_original_method = "C80CA050416DA84901D4F7B0B2F41300", hash_generated_method = "721108E85737F617D424F77A49E45F2F")
        public long execute() {
            if(mPreparedStatement == null)            
            {
                IllegalStateException varE371913FBCF66F87E5BC36955C500ACA_831849664 = new IllegalStateException("you must prepare this inserter before calling "
                        + "execute");
                varE371913FBCF66F87E5BC36955C500ACA_831849664.addTaint(taint);
                throw varE371913FBCF66F87E5BC36955C500ACA_831849664;
            } //End block
            try 
            {
                if(LOCAL_LOGV){ }                long varC99CD6101FE1736C00BB7015BBB65ADE_1307482413 = (mPreparedStatement.executeInsert());
                                long var0F5264038205EDFB1AC05FBB0E8C5E94_125220367 = getTaintLong();
                return var0F5264038205EDFB1AC05FBB0E8C5E94_125220367;
            } //End block
            catch (SQLException e)
            {
                long var6BB61E3B7BCE0931DA574D19D1D82C88_1268033591 = (-1);
                                long var0F5264038205EDFB1AC05FBB0E8C5E94_966766715 = getTaintLong();
                return var0F5264038205EDFB1AC05FBB0E8C5E94_966766715;
            } //End block
            finally 
            {
                mPreparedStatement = null;
            } //End block
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.942 -0400", hash_original_method = "BEDC7093698B9136E99447F456E9608C", hash_generated_method = "96E69F517E1DC08CC6DD30D24AD915BE")
        public void prepareForInsert() {
            mPreparedStatement = getStatement(false);
            mPreparedStatement.clearBindings();
            // ---------- Original Method ----------
            //mPreparedStatement = getStatement(false);
            //mPreparedStatement.clearBindings();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.942 -0400", hash_original_method = "2DC72BFF923FF55EA48E8D651F79AFBE", hash_generated_method = "13626EAC2DF5D5A370098152654DFF39")
        public void prepareForReplace() {
            mPreparedStatement = getStatement(true);
            mPreparedStatement.clearBindings();
            // ---------- Original Method ----------
            //mPreparedStatement = getStatement(true);
            //mPreparedStatement.clearBindings();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.942 -0400", hash_original_method = "C177E80799F9F51057A5F361D4C5571B", hash_generated_method = "74E433646E38E856889613D987166043")
        public long replace(ContentValues values) {
            addTaint(values.getTaint());
            long varBBEABD15D98AE63C73B4F078004080C6_1229591269 = (insertInternal(values, true));
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1216626927 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1216626927;
            // ---------- Original Method ----------
            //return insertInternal(values, true);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.943 -0400", hash_original_method = "21909697F743246FF7034BA444D2FBF0", hash_generated_method = "5A4B28782066EB3160C4EC1AA5A636B4")
        public void close() {
            if(mInsertStatement != null)            
            {
                mInsertStatement.close();
                mInsertStatement = null;
            } //End block
            if(mReplaceStatement != null)            
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.943 -0400", hash_original_field = "DE03D98EDC4D3D1EA9F2F4A4B7D844EB", hash_generated_field = "65A2F50AB6F61733B444F32A68BCAC15")

        public static final int TABLE_INFO_PRAGMA_COLUMNNAME_INDEX = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.943 -0400", hash_original_field = "0A6ACB3BBE4C15D840F48898D650CE3B", hash_generated_field = "E75F8B45A4A09AC1C6BBD56421B4EB2A")

        public static final int TABLE_INFO_PRAGMA_DEFAULT_INDEX = 4;
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.943 -0400", hash_original_field = "3016A0AB70A04654637C985E816CEAB9", hash_generated_field = "1FE3C375C216F1A5BEF4D0C706AC2FD3")

    private static final String TAG = "DatabaseUtils";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.943 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "58EDF43BA541A4D47EECFEC3901C7AED")

    private static final boolean DEBUG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.943 -0400", hash_original_field = "AAFDAF871858750A211AC8DBE6D1B76E", hash_generated_field = "626038DAE6BB26944A3CF12B5D6F74EE")

    private static final boolean LOCAL_LOGV = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.943 -0400", hash_original_field = "F088C9624B9C6FBF7B572D7FCA46710A", hash_generated_field = "A9BB21413E0B9FDB529AF62765E841A5")

    private static final String[] countProjection = new String[]{"count(*)"};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.943 -0400", hash_original_field = "03444EF4262BE1A020FCA4CED5EDF40F", hash_generated_field = "4648C235C26E35A03693F2CCB0369012")

    public static final int STATEMENT_SELECT = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.943 -0400", hash_original_field = "61BA11F945235A57A950B66AA6A3536B", hash_generated_field = "6B2A4824744946252E51300EBC79E592")

    public static final int STATEMENT_UPDATE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.943 -0400", hash_original_field = "BD7F0CF10C54FBBBF390BF98C5D8E3CD", hash_generated_field = "2ACC3D548878CC219AA49F7804828063")

    public static final int STATEMENT_ATTACH = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.943 -0400", hash_original_field = "C431D567433A23710E28CD81C3F4E9F9", hash_generated_field = "02A421ACB07995DB47634279A2479B60")

    public static final int STATEMENT_BEGIN = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.944 -0400", hash_original_field = "653D3CB341CEF13E7AC4EBA5B5988361", hash_generated_field = "A6C603A158EA8E9046E04946D4516AA3")

    public static final int STATEMENT_COMMIT = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.944 -0400", hash_original_field = "8B0367281124B52E9B7950CF34ACC2B8", hash_generated_field = "8F86283F91FE4F97606CB017F6364760")

    public static final int STATEMENT_ABORT = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.944 -0400", hash_original_field = "6F0BBAF18B35D27CD91106CAB6767601", hash_generated_field = "C15D3B7768DE951957CC8DFC9D19405B")

    public static final int STATEMENT_PRAGMA = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.944 -0400", hash_original_field = "B3CC0EC5C5166FFD6DD380256B9576F0", hash_generated_field = "8DC2B7B4CA8DB7D59D8A5F9177912461")

    public static final int STATEMENT_DDL = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.944 -0400", hash_original_field = "3020B3E1E6CA4903D7BEEF0DCDAED6B2", hash_generated_field = "52E7CCF3D2536FB7A3368B1F5E5546C4")

    public static final int STATEMENT_UNPREPARED = 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.944 -0400", hash_original_field = "C3786F39D3AE7D6B449AC57E4D726BC2", hash_generated_field = "5F2F4749E3B45E10482F4E32EAB579F5")

    public static final int STATEMENT_OTHER = 99;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.944 -0400", hash_original_field = "BFEC89007BE9644677E9D37B3E58753D", hash_generated_field = "64EC00AB4BE1B864318AEBC676ADD327")

    private static Collator mColl = null;
}

