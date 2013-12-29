package android.database.sqlite;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.database.CursorWindow;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;




import droidsafe.helpers.DSUtils;

public class SQLiteQuery extends SQLiteProgram {

    
    @DSModeled(DSC.SAFE)
    private static int nativeFillWindow(int databasePtr, int statementPtr, int windowPtr,
            int startPos, int offsetParam) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    private static int nativeColumnCount(int statementPtr) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    private static String nativeColumnName(int statementPtr, int columnIndex) {
        	return new String();
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:01.751 -0500", hash_original_field = "60D09076627E73BCAEEB6F563954C30A", hash_generated_field = "33B4EC31717AE04F4951ABB455378F67")

    private static final String TAG = "SQLiteQuery";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:01.756 -0500", hash_original_field = "635E86039A5B1D292EA8131FF2D5D0BF", hash_generated_field = "834FF8F7040C5E40B4484771C7969574")

    private int mOffsetIndex = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:01.757 -0500", hash_original_field = "68E7C3569E191B98218FD7A043574AEA", hash_generated_field = "0FB4858B613824FE6FDA94A379EBC4D0")


    private boolean mClosed = false;

    /**
     * Create a persistent query object.
     *
     * @param db The database that this query object is associated with
     * @param query The SQL string for this query. 
     * @param offsetIndex The 1-based index to the OFFSET parameter, 
     */
    /* package */ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:01.758 -0500", hash_original_method = "B04E51F22DB6FA67074D367FD62C2A3B", hash_generated_method = "B04E51F22DB6FA67074D367FD62C2A3B")
    SQLiteQuery(SQLiteDatabase db, String query, int offsetIndex, String[] bindArgs) {
        super(db, query);
        mOffsetIndex = offsetIndex;
        bindAllArgsAsStrings(bindArgs);
    }

    /**
     * Constructor used to create new instance to replace a given instance of this class.
     * This constructor is used when the current Query object is now associated with a different
     * {@link SQLiteDatabase} object.
     *
     * @param db The database that this query object is associated with
     * @param query the instance of {@link SQLiteQuery} to be replaced
     */
    /* package */ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:01.759 -0500", hash_original_method = "ACE77F48482E9278318C8F93FF273D4F", hash_generated_method = "ACE77F48482E9278318C8F93FF273D4F")
    SQLiteQuery(SQLiteDatabase db, SQLiteQuery query) {
        super(db, query.mSql);
        this.mBindArgs = query.mBindArgs;
        this.mOffsetIndex = query.mOffsetIndex;
    }

    /**
     * Reads rows into a buffer. This method acquires the database lock.
     *
     * @param window The window to fill into
     * @return number of total rows in the query
     */
    /* package */ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:01.760 -0500", hash_original_method = "D55C6AB533D249202FC7A2AC29FF93BB", hash_generated_method = "2020EB7A90BA7B22232FE2964D5A4746")
    int fillWindow(CursorWindow window) {
        mDatabase.lock(mSql);
        long timeStart = SystemClock.uptimeMillis();
        try {
            acquireReference();
            try {
                window.acquireReference();
                int startPos = window.getStartPosition();
                int numRows = nativeFillWindow(nHandle, nStatement, window.mWindowPtr,
                        startPos, mOffsetIndex);
                if (SQLiteDebug.DEBUG_LOG_SLOW_QUERIES) {
                    long elapsed = SystemClock.uptimeMillis() - timeStart;
                    if (SQLiteDebug.shouldLogSlowQuery(elapsed)) {
                        Log.d(TAG, "fillWindow took " + elapsed
                                + " ms: window=\"" + window
                                + "\", startPos=" + startPos
                                + ", offset=" + mOffsetIndex
                                + ", filledRows=" + window.getNumRows()
                                + ", countedRows=" + numRows
                                + ", query=\"" + mSql + "\""
                                + ", args=[" + (mBindArgs != null ?
                                        TextUtils.join(", ", mBindArgs.values()) : "")
                                + "]");
                    }
                }
                mDatabase.logTimeStat(mSql, timeStart);
                return numRows;
            } catch (IllegalStateException e){
                // simply ignore it
                return 0;
            } catch (SQLiteDatabaseCorruptException e) {
                mDatabase.onCorruption();
                throw e;
            } catch (SQLiteException e) {
                Log.e(TAG, "exception: " + e.getMessage() + "; query: " + mSql);
                throw e;
            } finally {
                window.releaseReference();
            }
        } finally {
            releaseReference();
            mDatabase.unlock();
        }
    }

    /**
     * Get the column count for the statement. Only valid on query based
     * statements. The database must be locked
     * when calling this method.
     * 
     * @return The number of column in the statement's result set.
     */
    /* package */ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:01.761 -0500", hash_original_method = "54618FF47D2C419F49442C51D0DA0774", hash_generated_method = "54618FF47D2C419F49442C51D0DA0774")
    int columnCountLocked() {
        acquireReference();
        try {
            return nativeColumnCount(nStatement);
        } finally {
            releaseReference();
        }
    }

    /**
     * Retrieves the column name for the given column index. The database must be locked
     * when calling this method.
     * 
     * @param columnIndex the index of the column to get the name for
     * @return The requested column's name
     */
    /* package */ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:01.762 -0500", hash_original_method = "B5AB077B4013E218660670FE95A73F4B", hash_generated_method = "B5AB077B4013E218660670FE95A73F4B")
    String columnNameLocked(int columnIndex) {
        acquireReference();
        try {
            return nativeColumnName(nStatement, columnIndex);
        } finally {
            releaseReference();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:01.762 -0500", hash_original_method = "818F0EC4250B389213C92FDEA7A7A5CE", hash_generated_method = "E3988E23A202244D7F0D4727DC92B445")
    @Override
public String toString() {
        return "SQLiteQuery: " + mSql;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:01.763 -0500", hash_original_method = "C1F8301470323E9B4CE9B1F32DF8E225", hash_generated_method = "E59CB6D70209DADFB4D42037D59EB518")
    @Override
public void close() {
        super.close();
        mClosed = true;
    }

    /**
     * Called by SQLiteCursor when it is requeried.
     */
    /* package */ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:01.764 -0500", hash_original_method = "10930ECAA546E890A142B67C44E349E2", hash_generated_method = "10930ECAA546E890A142B67C44E349E2")
    void requery() {
        if (mClosed) {
            throw new IllegalStateException("requerying a closed cursor");
        }
        compileAndbindAllArgs();
    }
}

