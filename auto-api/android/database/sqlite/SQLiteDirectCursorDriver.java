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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.690 -0400", hash_original_field = "03938FDF3029AF609FD8FCBAEE02B61F", hash_generated_field = "973CDCF4620458EDC8DC04989EC9D73D")

    private String mEditTable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.690 -0400", hash_original_field = "8C0B67E1F99496AB4CD09433C231BEB3", hash_generated_field = "D64A21845CDFCE8626EB490FA7FAD44D")

    private SQLiteDatabase mDatabase;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.690 -0400", hash_original_field = "F54BB255BEA99BFE91A331B490610EDF", hash_generated_field = "6E649D5858461199DBD67FE0A0D43789")

    private Cursor mCursor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.690 -0400", hash_original_field = "ABF275D728AAD5B5017275F72010DE2D", hash_generated_field = "B78C1C5FEEE1F4ABA93425EF8E6C212A")

    private String mSql;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.690 -0400", hash_original_field = "5B134E4A2754549415570918F1EB845F", hash_generated_field = "8A548C5C667EE7DF7972E25F8E1FD3F8")

    private SQLiteQuery mQuery;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.691 -0400", hash_original_method = "37FE0EEF62C7A37B1EC0250FE6C12A4F", hash_generated_method = "AC88B3DC4D137B18E67694CAC81C1BC6")
    public  SQLiteDirectCursorDriver(SQLiteDatabase db, String sql, String editTable) {
        mDatabase = db;
        mEditTable = editTable;
        mSql = sql;
        // ---------- Original Method ----------
        //mDatabase = db;
        //mEditTable = editTable;
        //mSql = sql;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.692 -0400", hash_original_method = "5238CB269CBA2AF26585CD6CA48FDD07", hash_generated_method = "F168E24F83B39AD97B6A32F43EB3409F")
    public Cursor query(CursorFactory factory, String[] selectionArgs) {
        Cursor varB4EAC82CA7396A68D541C85D26508E83_25906478 = null; //Variable for return #1
        SQLiteQuery query = null;
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
            varB4EAC82CA7396A68D541C85D26508E83_25906478 = mCursor;
        } //End block
        finally 
        {
            query.close();
            mDatabase.unlock();
        } //End block
        addTaint(selectionArgs[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_25906478.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_25906478;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.693 -0400", hash_original_method = "67DCFB7C009E95C4CA139AFBDECCF9F8", hash_generated_method = "A1AA2B64527670EF10F61F806A35135D")
    public void cursorClosed() {
        mCursor = null;
        // ---------- Original Method ----------
        //mCursor = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.693 -0400", hash_original_method = "68EB12D8E06A2397F473CCCC0FA3CBC1", hash_generated_method = "F1A5C4A1DF6C30EFDEAB8440EC5AAB1A")
    public void setBindArguments(String[] bindArgs) {
        mQuery.bindAllArgsAsStrings(bindArgs);
        addTaint(bindArgs[0].getTaint());
        // ---------- Original Method ----------
        //mQuery.bindAllArgsAsStrings(bindArgs);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.694 -0400", hash_original_method = "C0D6246B55C05B36F128E1AEE4043F0F", hash_generated_method = "E84BDFE4FD59019EC4205EE197615B17")
    public void cursorDeactivated() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.694 -0400", hash_original_method = "64CFA7C751D35BBE7676514D93F7ECE6", hash_generated_method = "B0873AF2C7C5639BDF0E5508CCA466C2")
    public void cursorRequeried(Cursor cursor) {
        addTaint(cursor.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.696 -0400", hash_original_method = "174FEA46244B347E10EF94A484A1C873", hash_generated_method = "CBF37CF95E6C726FC82C978E46D291A5")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_415795485 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_415795485 = "SQLiteDirectCursorDriver: " + mSql;
        varB4EAC82CA7396A68D541C85D26508E83_415795485.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_415795485;
        // ---------- Original Method ----------
        //return "SQLiteDirectCursorDriver: " + mSql;
    }

    
}

