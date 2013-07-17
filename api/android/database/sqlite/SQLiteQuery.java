package android.database.sqlite;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.database.CursorWindow;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;

public class SQLiteQuery extends SQLiteProgram {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.932 -0400", hash_original_field = "4A4AFE184AA8D6209A0E3DD0DCD593B5", hash_generated_field = "834FF8F7040C5E40B4484771C7969574")

    private int mOffsetIndex = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.932 -0400", hash_original_field = "D72871D5CE2EB17105099280224B0CCD", hash_generated_field = "0FB4858B613824FE6FDA94A379EBC4D0")

    private boolean mClosed = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.933 -0400", hash_original_method = "B04E51F22DB6FA67074D367FD62C2A3B", hash_generated_method = "18D8D2891ECFC4704610AF4707BD2E8D")
      SQLiteQuery(SQLiteDatabase db, String query, int offsetIndex, String[] bindArgs) {
        super(db, query);
        addTaint(bindArgs[0].getTaint());
        addTaint(query.getTaint());
        addTaint(db.getTaint());
        mOffsetIndex = offsetIndex;
        bindAllArgsAsStrings(bindArgs);
        // ---------- Original Method ----------
        //mOffsetIndex = offsetIndex;
        //bindAllArgsAsStrings(bindArgs);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.934 -0400", hash_original_method = "ACE77F48482E9278318C8F93FF273D4F", hash_generated_method = "E346673D1C67FDBA52707DE4236A8647")
      SQLiteQuery(SQLiteDatabase db, SQLiteQuery query) {
        super(db, query.mSql);
        addTaint(db.getTaint());
        this.mBindArgs = query.mBindArgs;
        this.mOffsetIndex = query.mOffsetIndex;
        // ---------- Original Method ----------
        //this.mBindArgs = query.mBindArgs;
        //this.mOffsetIndex = query.mOffsetIndex;
    }

    
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.937 -0400", hash_original_method = "D55C6AB533D249202FC7A2AC29FF93BB", hash_generated_method = "9C9626814FFF627F30FA2F59798ABB1B")
     int fillWindow(CursorWindow window) {
        addTaint(window.getTaint());
        mDatabase.lock(mSql);
        long timeStart = SystemClock.uptimeMillis();
        try 
        {
            acquireReference();
            try 
            {
                window.acquireReference();
                int startPos = window.getStartPosition();
                int numRows = nativeFillWindow(nHandle, nStatement, window.mWindowPtr,
                        startPos, mOffsetIndex);
                if(SQLiteDebug.DEBUG_LOG_SLOW_QUERIES)                
                {
                    long elapsed = SystemClock.uptimeMillis() - timeStart;
                    if(SQLiteDebug.shouldLogSlowQuery(elapsed))                    
                    {
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
                    } //End block
                } //End block
                mDatabase.logTimeStat(mSql, timeStart);
                int var998EA97634C71C025EB15D1618C2A376_1830740468 = (numRows);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_111263212 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_111263212;
            } //End block
            catch (IllegalStateException e)
            {
                int varCFCD208495D565EF66E7DFF9F98764DA_1807909439 = (0);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_388501231 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_388501231;
            } //End block
            catch (SQLiteDatabaseCorruptException e)
            {
                mDatabase.onCorruption();
                e.addTaint(taint);
                throw e;
            } //End block
            catch (SQLiteException e)
            {
                e.addTaint(taint);
                throw e;
            } //End block
            finally 
            {
                window.releaseReference();
            } //End block
        } //End block
        finally 
        {
            releaseReference();
            mDatabase.unlock();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.938 -0400", hash_original_method = "54618FF47D2C419F49442C51D0DA0774", hash_generated_method = "CD867919B72D3220A28CDE0271AB8B8B")
     int columnCountLocked() {
        acquireReference();
        try 
        {
            int var38E37CE3C8D0439303E00926E6741308_573988934 = (nativeColumnCount(nStatement));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_430027756 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_430027756;
        } //End block
        finally 
        {
            releaseReference();
        } //End block
        // ---------- Original Method ----------
        //acquireReference();
        //try {
            //return nativeColumnCount(nStatement);
        //} finally {
            //releaseReference();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.939 -0400", hash_original_method = "B5AB077B4013E218660670FE95A73F4B", hash_generated_method = "CE491A9FC4641E26B335D99C7F8EA688")
     String columnNameLocked(int columnIndex) {
        addTaint(columnIndex);
        acquireReference();
        try 
        {
String var96AFF3FBA6F9E943FBE0AF3FA990EC97_945492448 =             nativeColumnName(nStatement, columnIndex);
            var96AFF3FBA6F9E943FBE0AF3FA990EC97_945492448.addTaint(taint);
            return var96AFF3FBA6F9E943FBE0AF3FA990EC97_945492448;
        } //End block
        finally 
        {
            releaseReference();
        } //End block
        // ---------- Original Method ----------
        //acquireReference();
        //try {
            //return nativeColumnName(nStatement, columnIndex);
        //} finally {
            //releaseReference();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.939 -0400", hash_original_method = "818F0EC4250B389213C92FDEA7A7A5CE", hash_generated_method = "6D208CD010ABE2AA8A4EB381EBCD3B42")
    @Override
    public String toString() {
String var3EFB8F4E9BBF4DC978F8DF4F177CC507_1487590186 =         "SQLiteQuery: " + mSql;
        var3EFB8F4E9BBF4DC978F8DF4F177CC507_1487590186.addTaint(taint);
        return var3EFB8F4E9BBF4DC978F8DF4F177CC507_1487590186;
        // ---------- Original Method ----------
        //return "SQLiteQuery: " + mSql;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.940 -0400", hash_original_method = "C1F8301470323E9B4CE9B1F32DF8E225", hash_generated_method = "6C73A8E1493172E7E20CAF1DBE3B5224")
    @Override
    public void close() {
        super.close();
        mClosed = true;
        // ---------- Original Method ----------
        //super.close();
        //mClosed = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.940 -0400", hash_original_method = "10930ECAA546E890A142B67C44E349E2", hash_generated_method = "A1859D28EBF954E76B11AC2B3A708A1D")
     void requery() {
        if(mClosed)        
        {
            IllegalStateException var6CAE77F670F1174A16CD140BED6B8FCA_1884334409 = new IllegalStateException("requerying a closed cursor");
            var6CAE77F670F1174A16CD140BED6B8FCA_1884334409.addTaint(taint);
            throw var6CAE77F670F1174A16CD140BED6B8FCA_1884334409;
        } //End block
        compileAndbindAllArgs();
        // ---------- Original Method ----------
        //if (mClosed) {
            //throw new IllegalStateException("requerying a closed cursor");
        //}
        //compileAndbindAllArgs();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.941 -0400", hash_original_field = "B4D62BC7E132324EDD96845B1B8BA5B6", hash_generated_field = "33B4EC31717AE04F4951ABB455378F67")

    private static final String TAG = "SQLiteQuery";
}

