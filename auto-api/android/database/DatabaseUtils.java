package android.database;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.161 -0400", hash_original_method = "93F12AF889782015B364972CD69FB962", hash_generated_method = "93F12AF889782015B364972CD69FB962")
        public DatabaseUtils ()
    {
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

    
        public static long queryNumEntries(SQLiteDatabase db, String table, String selection) {
        return queryNumEntries(db, table, selection, null);
    }

    
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
        private SQLiteDatabase mDb;
        private String mTableName;
        private HashMap<String, Integer> mColumns;
        private String mInsertSQL = null;
        private SQLiteStatement mInsertStatement = null;
        private SQLiteStatement mReplaceStatement = null;
        private SQLiteStatement mPreparedStatement = null;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.171 -0400", hash_original_method = "24A3E628A21DF3387C7E8AFA040BF2F9", hash_generated_method = "C293D447409BD6AE2FB30E59E61DB2B1")
        @DSModeled(DSC.SAFE)
        public InsertHelper(SQLiteDatabase db, String tableName) {
            dsTaint.addTaint(db.dsTaint);
            dsTaint.addTaint(tableName);
            // ---------- Original Method ----------
            //mDb = db;
            //mTableName = tableName;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.172 -0400", hash_original_method = "C9A601B53671BC96A8E157301601DE92", hash_generated_method = "95182B1E472994D37EE42777AA4C580C")
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
                    boolean varDD393CFA89BAE4D1CBFDDF232382228F_1303964735 = (cur.moveToNext());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.172 -0400", hash_original_method = "102F3921944A0F32C4E4BE81F61A753B", hash_generated_method = "ED25A5538124D8F66E46BDBF31E35AAA")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.180 -0400", hash_original_method = "13ED4597857164B01AAF7D1C6E2C9384", hash_generated_method = "93D5B7DF2E7D5BD7497AF529DB530648")
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
                    Map.Entry<String, Object> e = values.valueSet()[0];
                    {
                        String key;
                        key = e.getKey();
                        int i;
                        i = getColumnIndex(key);
                        DatabaseUtils.bindObjectToProgram(stmt, i, e.getValue());
                    } //End block
                } //End collapsed parenthetic
                long var023E52F16507A143FBACD2DB06F1711B_46295657 = (stmt.executeInsert());
            } //End block
            catch (SQLException e)
            { }
            return dsTaint.getTaintLong();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.181 -0400", hash_original_method = "2FE6EA3004F5838FAFB27DD4EF6900C7", hash_generated_method = "5EA95F4121D2AB17CF6EAC6047FD46AC")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public int getColumnIndex(String key) {
            dsTaint.addTaint(key);
            getStatement(false);
            Integer index;
            index = mColumns.get(key);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("column '" + key + "' is invalid");
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.182 -0400", hash_original_method = "898F1EFFAEB546E6A9657A001F4AE1E8", hash_generated_method = "86868EFEE54FC8BB82DF658BF2A21667")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void bind(int index, double value) {
            dsTaint.addTaint(index);
            dsTaint.addTaint(value);
            mPreparedStatement.bindDouble(index, value);
            // ---------- Original Method ----------
            //mPreparedStatement.bindDouble(index, value);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.182 -0400", hash_original_method = "85D356AA3C69D35869973C25B38955EB", hash_generated_method = "51129397ABDE327B330048C49B36B549")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void bind(int index, float value) {
            dsTaint.addTaint(index);
            dsTaint.addTaint(value);
            mPreparedStatement.bindDouble(index, value);
            // ---------- Original Method ----------
            //mPreparedStatement.bindDouble(index, value);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.182 -0400", hash_original_method = "76F2FAC154909632438A49671F5D33A8", hash_generated_method = "820F13391B129C3C490D1E972A4A24EB")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void bind(int index, long value) {
            dsTaint.addTaint(index);
            dsTaint.addTaint(value);
            mPreparedStatement.bindLong(index, value);
            // ---------- Original Method ----------
            //mPreparedStatement.bindLong(index, value);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.183 -0400", hash_original_method = "A73EABD891E538A0A03C5C4A49C29503", hash_generated_method = "34DC51E5FB3B4A1C6E5C10098A7B1B7D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void bind(int index, int value) {
            dsTaint.addTaint(index);
            dsTaint.addTaint(value);
            mPreparedStatement.bindLong(index, value);
            // ---------- Original Method ----------
            //mPreparedStatement.bindLong(index, value);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.183 -0400", hash_original_method = "D4E75DDD13795169D0FEAC83726F0F45", hash_generated_method = "494B242DAAB811C0BE33B1287946D057")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void bind(int index, boolean value) {
            dsTaint.addTaint(index);
            dsTaint.addTaint(value);
            mPreparedStatement.bindLong(index, value ? 1 : 0);
            // ---------- Original Method ----------
            //mPreparedStatement.bindLong(index, value ? 1 : 0);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.183 -0400", hash_original_method = "27990C90801E0788D0DEC119EA5D904E", hash_generated_method = "59D9F58871539B1DFDF5D9CCC2DB4F1E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void bindNull(int index) {
            dsTaint.addTaint(index);
            mPreparedStatement.bindNull(index);
            // ---------- Original Method ----------
            //mPreparedStatement.bindNull(index);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.183 -0400", hash_original_method = "B7B8BDC3019EC6DD4050CE3C3C2D0B33", hash_generated_method = "94CD3D038258A004E36628F8387518A2")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void bind(int index, byte[] value) {
            dsTaint.addTaint(index);
            dsTaint.addTaint(value[0]);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.184 -0400", hash_original_method = "70AF33973781662CA48B1120B9D51D5F", hash_generated_method = "1443C4A4F0D90D07749D9849F7CAC7B7")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.184 -0400", hash_original_method = "9556B578266975E5A98CFEB0C2204667", hash_generated_method = "1BD98C577E90E3F690B9D6ECF457CE23")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public long insert(ContentValues values) {
            dsTaint.addTaint(values.dsTaint);
            long var7272FAC0398C10C383FD0AB1A343FC95_47335707 = (insertInternal(values, false));
            return dsTaint.getTaintLong();
            // ---------- Original Method ----------
            //return insertInternal(values, false);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.184 -0400", hash_original_method = "C80CA050416DA84901D4F7B0B2F41300", hash_generated_method = "43E5E2DAFAC3AA1975D2E86CC1336097")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public long execute() {
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("you must prepare this inserter before calling "
                        + "execute");
            } //End block
            try 
            {
                long varB1E8ED66178D6CA6EC479BE8B17F02EA_723010023 = (mPreparedStatement.executeInsert());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.184 -0400", hash_original_method = "BEDC7093698B9136E99447F456E9608C", hash_generated_method = "96E69F517E1DC08CC6DD30D24AD915BE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void prepareForInsert() {
            mPreparedStatement = getStatement(false);
            mPreparedStatement.clearBindings();
            // ---------- Original Method ----------
            //mPreparedStatement = getStatement(false);
            //mPreparedStatement.clearBindings();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.185 -0400", hash_original_method = "2DC72BFF923FF55EA48E8D651F79AFBE", hash_generated_method = "13626EAC2DF5D5A370098152654DFF39")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void prepareForReplace() {
            mPreparedStatement = getStatement(true);
            mPreparedStatement.clearBindings();
            // ---------- Original Method ----------
            //mPreparedStatement = getStatement(true);
            //mPreparedStatement.clearBindings();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.186 -0400", hash_original_method = "C177E80799F9F51057A5F361D4C5571B", hash_generated_method = "C5E6FBEB333DFEDCAACC103235F0A030")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public long replace(ContentValues values) {
            dsTaint.addTaint(values.dsTaint);
            long var638A5CC2C9218D39B65A71C2E9E180A7_636488880 = (insertInternal(values, true));
            return dsTaint.getTaintLong();
            // ---------- Original Method ----------
            //return insertInternal(values, true);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.187 -0400", hash_original_method = "21909697F743246FF7034BA444D2FBF0", hash_generated_method = "9699AAD9BACB2FE127ED86F2E236015E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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

        
        public static final int TABLE_INFO_PRAGMA_COLUMNNAME_INDEX = 1;
        public static final int TABLE_INFO_PRAGMA_DEFAULT_INDEX = 4;
    }


    
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
}

