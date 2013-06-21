package android.database.sqlite;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

public class SQLiteDirectCursorDriver implements SQLiteCursorDriver {
    private String mEditTable;
    private SQLiteDatabase mDatabase;
    private Cursor mCursor;
    private String mSql;
    private SQLiteQuery mQuery;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.654 -0400", hash_original_method = "37FE0EEF62C7A37B1EC0250FE6C12A4F", hash_generated_method = "90DF585760705E72FB2748A436429535")
    @DSModeled(DSC.SAFE)
    public SQLiteDirectCursorDriver(SQLiteDatabase db, String sql, String editTable) {
        dsTaint.addTaint(db.dsTaint);
        dsTaint.addTaint(sql);
        dsTaint.addTaint(editTable);
        // ---------- Original Method ----------
        //mDatabase = db;
        //mEditTable = editTable;
        //mSql = sql;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.655 -0400", hash_original_method = "5238CB269CBA2AF26585CD6CA48FDD07", hash_generated_method = "3CF83CFF4BD43A049CA52714A97B5870")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Cursor query(CursorFactory factory, String[] selectionArgs) {
        dsTaint.addTaint(selectionArgs[0]);
        dsTaint.addTaint(factory.dsTaint);
        SQLiteQuery query;
        query = null;
        try 
        {
            mDatabase.lock(mSql);
            mDatabase.closePendingStatements();
            query = new SQLiteQuery(mDatabase, mSql, 0, selectionArgs);
            {
                mCursor = new SQLiteCursor(this, mEditTable, query);
            } //End block
            {
                mCursor = factory.newCursor(mDatabase, this, mEditTable, query);
            } //End block
            mQuery = query;
            query = null;
        } //End block
        finally 
        {
            query.close();
            mDatabase.unlock();
        } //End block
        return (Cursor)dsTaint.getTaint();
        // ---------- Original Method ----------
        //SQLiteQuery query = null;
        //try {
            //mDatabase.lock(mSql);
            //mDatabase.closePendingStatements();
            //query = new SQLiteQuery(mDatabase, mSql, 0, selectionArgs);
            //if (factory == null) {
                //mCursor = new SQLiteCursor(this, mEditTable, query);
            //} else {
                //mCursor = factory.newCursor(mDatabase, this, mEditTable, query);
            //}
            //mQuery = query;
            //query = null;
            //return mCursor;
        //} finally {
            //if (query != null) query.close();
            //mDatabase.unlock();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.665 -0400", hash_original_method = "67DCFB7C009E95C4CA139AFBDECCF9F8", hash_generated_method = "A1AA2B64527670EF10F61F806A35135D")
    @DSModeled(DSC.SAFE)
    public void cursorClosed() {
        mCursor = null;
        // ---------- Original Method ----------
        //mCursor = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.666 -0400", hash_original_method = "68EB12D8E06A2397F473CCCC0FA3CBC1", hash_generated_method = "D6EF6EF4131A9ABCFA5E54B539690239")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setBindArguments(String[] bindArgs) {
        dsTaint.addTaint(bindArgs[0]);
        mQuery.bindAllArgsAsStrings(bindArgs);
        // ---------- Original Method ----------
        //mQuery.bindAllArgsAsStrings(bindArgs);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.666 -0400", hash_original_method = "C0D6246B55C05B36F128E1AEE4043F0F", hash_generated_method = "E84BDFE4FD59019EC4205EE197615B17")
    @DSModeled(DSC.SAFE)
    public void cursorDeactivated() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.668 -0400", hash_original_method = "64CFA7C751D35BBE7676514D93F7ECE6", hash_generated_method = "64D20CDDA4098E462C75E611B109CA16")
    @DSModeled(DSC.SAFE)
    public void cursorRequeried(Cursor cursor) {
        dsTaint.addTaint(cursor.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.668 -0400", hash_original_method = "174FEA46244B347E10EF94A484A1C873", hash_generated_method = "0A76BEC6775B3F372C0916D98979D32B")
    @DSModeled(DSC.SAFE)
    @Override
    public String toString() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "SQLiteDirectCursorDriver: " + mSql;
    }

    
}

