package android.database.sqlite;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.HashMap;
import java.util.Map;

import android.database.AbstractWindowedCursor;
import android.database.CursorWindow;
import android.os.StrictMode;
import android.util.Log;

public class SQLiteCursor extends AbstractWindowedCursor {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:43.001 -0500", hash_original_field = "3A0C7CEFD5D785775A84ED015B93C1D0", hash_generated_field = "BF7B5B2F2106B38369133C49B98E70AF")

    static final String TAG = "SQLiteCursor";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:43.003 -0500", hash_original_field = "343EA6F84C5A6A6F0C2045C9104CE080", hash_generated_field = "B3506D48E898548A190C450C174C3FFA")

    static final int NO_COUNT = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:43.006 -0500", hash_original_field = "B57E8E3291FA3DC45C2E06A85E7B1ACA", hash_generated_field = "973CDCF4620458EDC8DC04989EC9D73D")

    private  String mEditTable;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:43.008 -0500", hash_original_field = "05C6FA34740ED8752F22266873F75802", hash_generated_field = "53DC72E56AF72859CCB6315DB649FC3E")

    private  String[] mColumns;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:43.011 -0500", hash_original_field = "0AF317C884F552319B2A62F3629B6C63", hash_generated_field = "8A548C5C667EE7DF7972E25F8E1FD3F8")

    private SQLiteQuery mQuery;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:43.013 -0500", hash_original_field = "912477F9991436C37E64D1DC0503BDB5", hash_generated_field = "DF56BAF171B937E9CC6E593202E96226")

    private  SQLiteCursorDriver mDriver;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:43.016 -0500", hash_original_field = "B1A592693C359E46E2516C780EF3A2BC", hash_generated_field = "F4532CB59B1200B34E9685596B8185FB")

    private volatile int mCount = NO_COUNT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:43.018 -0500", hash_original_field = "D053C755F9E28C7FB469063520D94169", hash_generated_field = "5E829DFAED9C527F2433E5889E542D7A")

    private Map<String, Integer> mColumnNameMap;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:43.021 -0500", hash_original_field = "05D6976C836A3613529DB18CD3C40A23", hash_generated_field = "7D1AA4359A52B133BFAD994AB60E8C14")

    private  Throwable mStackTrace;

    /**
     * Execute a query and provide access to its result set through a Cursor
     * interface. For a query such as: {@code SELECT name, birth, phone FROM
     * myTable WHERE ... LIMIT 1,20 ORDER BY...} the column names (name, birth,
     * phone) would be in the projection argument and everything from
     * {@code FROM} onward would be in the params argument. This constructor
     * has package scope.
     *
     * @param db a reference to a Database object that is already constructed
     *     and opened. This param is not used any longer
     * @param editTable the name of the table used for this query
     * @param query the rest of the query terms
     *     cursor is finalized
     * @deprecated use {@link #SQLiteCursor(SQLiteCursorDriver, String, SQLiteQuery)} instead
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:43.025 -0500", hash_original_method = "7DD8316FC8BAC42467B622126F8A148B", hash_generated_method = "94EAE0B75459AC2C224DE9FEDAA0DB73")
    
@Deprecated
    public SQLiteCursor(SQLiteDatabase db, SQLiteCursorDriver driver,
            String editTable, SQLiteQuery query) {
        this(driver, editTable, query);
    }

    /**
     * Execute a query and provide access to its result set through a Cursor
     * interface. For a query such as: {@code SELECT name, birth, phone FROM
     * myTable WHERE ... LIMIT 1,20 ORDER BY...} the column names (name, birth,
     * phone) would be in the projection argument and everything from
     * {@code FROM} onward would be in the params argument. This constructor
     * has package scope.
     *
     * @param editTable the name of the table used for this query
     * @param query the {@link SQLiteQuery} object associated with this cursor object.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:43.028 -0500", hash_original_method = "73EECE67D75C79AF0ED0AD77F55FFB21", hash_generated_method = "72423489C230028CC06368861C7991E3")
    
public SQLiteCursor(SQLiteCursorDriver driver, String editTable, SQLiteQuery query) {
        if (query == null) {
            throw new IllegalArgumentException("query object cannot be null");
        }
        if (query.mDatabase == null) {
            throw new IllegalArgumentException("query.mDatabase cannot be null");
        }
        if (StrictMode.vmSqliteObjectLeaksEnabled()) {
            mStackTrace = new DatabaseObjectNotClosedException().fillInStackTrace();
        } else {
            mStackTrace = null;
        }
        mDriver = driver;
        mEditTable = editTable;
        mColumnNameMap = null;
        mQuery = query;

        query.mDatabase.lock(query.mSql);
        try {
            // Setup the list of columns
            int columnCount = mQuery.columnCountLocked();
            mColumns = new String[columnCount];

            // Read in all column names
            for (int i = 0; i < columnCount; i++) {
                String columnName = mQuery.columnNameLocked(i);
                mColumns[i] = columnName;
                if (false) {
                    Log.v("DatabaseWindow", "mColumns[" + i + "] is "
                            + mColumns[i]);
                }
    
                // Make note of the row ID column index for quick access to it
                if ("_id".equals(columnName)) {
                    mRowIdColumnIndex = i;
                }
            }
        } finally {
            query.mDatabase.unlock();
        }
    }

    /**
     * @return the SQLiteDatabase that this cursor is associated with.
     */
    @DSSource({DSSourceKind.DATABASE_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:43.031 -0500", hash_original_method = "AF759727D3C973E194D48B5E653874F6", hash_generated_method = "D01FE6FFC520D1360670F278B0363796")
    
public SQLiteDatabase getDatabase() {
        synchronized (this) {
            return mQuery.mDatabase;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:43.034 -0500", hash_original_method = "B4A0D7606429FC274C47739DBFA1C1E0", hash_generated_method = "D1018E474338EAFE394D4DA8E38472F7")
    
@Override
    public boolean onMove(int oldPosition, int newPosition) {
        // Make sure the row at newPosition is present in the window
        if (mWindow == null || newPosition < mWindow.getStartPosition() ||
                newPosition >= (mWindow.getStartPosition() + mWindow.getNumRows())) {
            fillWindow(newPosition);
        }

        return true;
    }

    @DSSource({DSSourceKind.DATABASE_INFORMATION})
    @DSSafe(DSCat.DB_CURSOR)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:43.036 -0500", hash_original_method = "D7810D185EEBB48990AE6D5077F6CEAD", hash_generated_method = "E2C9ABE586EE9B6644157D6DF551AE43")
    
@Override
    public int getCount() {
        if (mCount == NO_COUNT) {
            fillWindow(0);
        }
        return mCount;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:43.039 -0500", hash_original_method = "1027AA1FD2FF7DB5721417BC40818677", hash_generated_method = "F4A5210804513905D8EA8143D88462AC")
    
private void fillWindow(int startPos) {
        clearOrCreateWindow(getDatabase().getPath());
        mWindow.setStartPosition(startPos);
        int count = getQuery().fillWindow(mWindow);
        if (startPos == 0) { // fillWindow returns count(*) only for startPos = 0
            if (Log.isLoggable(TAG, Log.DEBUG)) {
                Log.d(TAG, "received count(*) from native_fill_window: " + count);
            }
            mCount = count;
        } else if (mCount <= 0) {
            throw new IllegalStateException("Row count should never be zero or negative "
                    + "when the start position is non-zero");
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:43.042 -0500", hash_original_method = "976132A7E3467B4AD1CD095C1F4D25D0", hash_generated_method = "F32C0F18A6FED89DC24223725C282815")
    
private synchronized SQLiteQuery getQuery() {
        return mQuery;
    }

    @DSSafe(DSCat.DB_CURSOR)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:43.045 -0500", hash_original_method = "96C3F6AE90641303728CA2622AC00A1C", hash_generated_method = "B8802CA6B8E38FE4EB87568ADFC00A2E")
    
@Override
    public int getColumnIndex(String columnName) {
        // Create mColumnNameMap on demand
        if (mColumnNameMap == null) {
            String[] columns = mColumns;
            int columnCount = columns.length;
            HashMap<String, Integer> map = new HashMap<String, Integer>(columnCount, 1);
            for (int i = 0; i < columnCount; i++) {
                map.put(columns[i], i);
            }
            mColumnNameMap = map;
        }

        // Hack according to bug 903852
        final int periodIndex = columnName.lastIndexOf('.');
        if (periodIndex != -1) {
            Exception e = new Exception();
            Log.e(TAG, "requesting column name with table name -- " + columnName, e);
            columnName = columnName.substring(periodIndex + 1);
        }

        Integer i = mColumnNameMap.get(columnName);
        if (i != null) {
            return i.intValue();
        } else {
            return -1;
        }
    }

    @DSSafe(DSCat.DB_CURSOR)
    @DSSource({DSSourceKind.DATABASE_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:43.047 -0500", hash_original_method = "6996FDAE7F544E3AE18BC0C5BC1EECAC", hash_generated_method = "ED979C997B8D7B0EAFCF8DA1443034CC")
    
@Override
    public String[] getColumnNames() {
        return mColumns;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:43.049 -0500", hash_original_method = "9A966315BEEEC4FF7AE600084283702B", hash_generated_method = "95B12EF67DF03B47DDE9C6045CB01331")
    
@Override
    public void deactivate() {
        super.deactivate();
        mDriver.cursorDeactivated();
    }

    @DSSafe(DSCat.DB_CURSOR)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:43.051 -0500", hash_original_method = "448CAED0D85C68E057975FF7C64F6766", hash_generated_method = "EE97D2B2A772EBB6F567523A6BBE1E86")
    
@Override
    public void close() {
        super.close();
        synchronized (this) {
            mQuery.close();
            mDriver.cursorClosed();
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:43.056 -0500", hash_original_method = "EB44A3C249AFFC8E58A7028D8F44463C", hash_generated_method = "ADF553E4CFBF16ADF294ED6961EB539C")
    
@Override
    public boolean requery() {
        if (isClosed()) {
            return false;
        }
        long timeStart = 0;
        if (false) {
            timeStart = System.currentTimeMillis();
        }

        synchronized (this) {
            if (mWindow != null) {
                mWindow.clear();
            }
            mPos = -1;
            SQLiteDatabase db = null;
            try {
                db = mQuery.mDatabase.getDatabaseHandle(mQuery.mSql);
            } catch (IllegalStateException e) {
                // for backwards compatibility, just return false
                Log.w(TAG, "requery() failed " + e.getMessage(), e);
                return false;
            }
            if (!db.equals(mQuery.mDatabase)) {
                // since we need to use a different database connection handle,
                // re-compile the query
                try {
                    db.lock(mQuery.mSql);
                } catch (IllegalStateException e) {
                    // for backwards compatibility, just return false
                    Log.w(TAG, "requery() failed " + e.getMessage(), e);
                    return false;
                }
                try {
                    // close the old mQuery object and open a new one
                    mQuery.close();
                    mQuery = new SQLiteQuery(db, mQuery);
                } catch (IllegalStateException e) {
                    // for backwards compatibility, just return false
                    Log.w(TAG, "requery() failed " + e.getMessage(), e);
                    return false;
                } finally {
                    db.unlock();
                }
            }
            // This one will recreate the temp table, and get its count
            mDriver.cursorRequeried(this);
            mCount = NO_COUNT;
            try {
                mQuery.requery();
            } catch (IllegalStateException e) {
                // for backwards compatibility, just return false
                Log.w(TAG, "requery() failed " + e.getMessage(), e);
                return false;
            }
        }

        if (false) {
            Log.v("DatabaseWindow", "closing window in requery()");
            Log.v(TAG, "--- Requery()ed cursor " + this + ": " + mQuery);
        }

        boolean result = false;
        try {
            result = super.requery();
        } catch (IllegalStateException e) {
            // for backwards compatibility, just return false
            Log.w(TAG, "requery() failed " + e.getMessage(), e);
        }
        if (false) {
            long timeEnd = System.currentTimeMillis();
            Log.v(TAG, "requery (" + (timeEnd - timeStart) + " ms): " + mDriver.toString());
        }
        return result;
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:43.059 -0500", hash_original_method = "5E8FFACADD72707A480415823E5A0DF8", hash_generated_method = "0FEFDF0AF3FD942ADF49C6291434BC82")
    
@Override
    public void setWindow(CursorWindow window) {
        super.setWindow(window);
        mCount = NO_COUNT;
    }

    /**
     * Changes the selection arguments. The new values take effect after a call to requery().
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:43.061 -0500", hash_original_method = "F2A62A4628FC6852210F2ED0EED8C7EA", hash_generated_method = "0FA948D4E0ED78418E3872CE76C7197D")
    
public void setSelectionArguments(String[] selectionArgs) {
        mDriver.setBindArguments(selectionArgs);
    }

    /**
     * Release the native resources, if they haven't been released yet.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:43.064 -0500", hash_original_method = "3B748B9308D21E215FBA6A9497941AC3", hash_generated_method = "25EC51EE2C87AF7A5ECF7D193BCE282F")
    
@Override
    protected void finalize() {
        try {
            // if the cursor hasn't been closed yet, close it first
            if (mWindow != null) {
                if (mStackTrace != null) {
                    int len = mQuery.mSql.length();
                    StrictMode.onSqliteObjectLeaked(
                        "Finalizing a Cursor that has not been deactivated or closed. " +
                        "database = " + mQuery.mDatabase.getPath() + ", table = " + mEditTable +
                        ", query = " + mQuery.mSql.substring(0, (len > 1000) ? 1000 : len),
                        mStackTrace);
                }
                close();
                SQLiteDebug.notifyActiveCursorFinalized();
            } else {
                if (false) {
                    Log.v(TAG, "Finalizing cursor on database = " + mQuery.mDatabase.getPath() +
                            ", table = " + mEditTable + ", query = " + mQuery.mSql);
                }
            }
        } finally {
            super.finalize();
        }
    }
}

