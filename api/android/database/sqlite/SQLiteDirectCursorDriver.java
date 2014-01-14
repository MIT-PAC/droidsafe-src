package android.database.sqlite;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

public class SQLiteDirectCursorDriver implements SQLiteCursorDriver {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:42.442 -0500", hash_original_field = "B57E8E3291FA3DC45C2E06A85E7B1ACA", hash_generated_field = "973CDCF4620458EDC8DC04989EC9D73D")

    private String mEditTable;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:42.444 -0500", hash_original_field = "AC0A81ABC82A618858F7E54D51784ED6", hash_generated_field = "D64A21845CDFCE8626EB490FA7FAD44D")
 
    private SQLiteDatabase mDatabase;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:42.446 -0500", hash_original_field = "4A85E902ED72E65A9AF8F6ED265E4F89", hash_generated_field = "6E649D5858461199DBD67FE0A0D43789")

    private Cursor mCursor;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:42.448 -0500", hash_original_field = "4999D4179E22F9283AE45DB93648A65D", hash_generated_field = "B78C1C5FEEE1F4ABA93425EF8E6C212A")

    private String mSql;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:42.450 -0500", hash_original_field = "0AF317C884F552319B2A62F3629B6C63", hash_generated_field = "8A548C5C667EE7DF7972E25F8E1FD3F8")

    private SQLiteQuery mQuery;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:42.453 -0500", hash_original_method = "37FE0EEF62C7A37B1EC0250FE6C12A4F", hash_generated_method = "DDD0E1C83D60A2F8AE638815086F82BA")
    
public SQLiteDirectCursorDriver(SQLiteDatabase db, String sql, String editTable) {
        mDatabase = db;
        mEditTable = editTable;
        mSql = sql;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:42.456 -0500", hash_original_method = "5238CB269CBA2AF26585CD6CA48FDD07", hash_generated_method = "4B7FDB713327F27AC93FC3C2DB95988B")
    
public Cursor query(CursorFactory factory, String[] selectionArgs) {
        // Compile the query
        SQLiteQuery query = null;

        try {
            mDatabase.lock(mSql);
            mDatabase.closePendingStatements();
            query = new SQLiteQuery(mDatabase, mSql, 0, selectionArgs);

            // Create the cursor
            if (factory == null) {
                mCursor = new SQLiteCursor(this, mEditTable, query);
            } else {
                mCursor = factory.newCursor(mDatabase, this, mEditTable, query);
            }

            mQuery = query;
            query = null;
            return mCursor;
        } finally {
            // Make sure this object is cleaned up if something happens
            if (query != null) query.close();
            mDatabase.unlock();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:42.458 -0500", hash_original_method = "67DCFB7C009E95C4CA139AFBDECCF9F8", hash_generated_method = "D61B65B740B1BE7C17D7745B76E77F48")
    
public void cursorClosed() {
        mCursor = null;
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:42.461 -0500", hash_original_method = "68EB12D8E06A2397F473CCCC0FA3CBC1", hash_generated_method = "B153325C800447267AAA96AB737A3B1C")
    
public void setBindArguments(String[] bindArgs) {
        mQuery.bindAllArgsAsStrings(bindArgs);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:42.463 -0500", hash_original_method = "C0D6246B55C05B36F128E1AEE4043F0F", hash_generated_method = "FBE86F5AD597E0C8767621DD7DED8299")
    
public void cursorDeactivated() {
        // Do nothing
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:42.465 -0500", hash_original_method = "64CFA7C751D35BBE7676514D93F7ECE6", hash_generated_method = "48528C9FA8E3DCA8347B0C3F1244A8BD")
    
public void cursorRequeried(Cursor cursor) {
        // Do nothing
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:42.468 -0500", hash_original_method = "174FEA46244B347E10EF94A484A1C873", hash_generated_method = "A87150336A6BB337665113B4A2D7B81E")
    
@Override
    public String toString() {
        return "SQLiteDirectCursorDriver: " + mSql;
    }
    
}

