package android.database.sqlite;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.database.CursorWindow;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;

public class SQLiteQuery extends SQLiteProgram {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.116 -0400", hash_original_field = "4A4AFE184AA8D6209A0E3DD0DCD593B5", hash_generated_field = "834FF8F7040C5E40B4484771C7969574")

    private int mOffsetIndex = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.116 -0400", hash_original_field = "D72871D5CE2EB17105099280224B0CCD", hash_generated_field = "0FB4858B613824FE6FDA94A379EBC4D0")

    private boolean mClosed = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.117 -0400", hash_original_method = "B04E51F22DB6FA67074D367FD62C2A3B", hash_generated_method = "18D8D2891ECFC4704610AF4707BD2E8D")
      SQLiteQuery(SQLiteDatabase db, String query, int offsetIndex, String[] bindArgs) {
        super(db, query);
        addTaint(bindArgs[0].getTaint());
        addTaint(query.getTaint());
        addTaint(db.getTaint());
        mOffsetIndex = offsetIndex;
        bindAllArgsAsStrings(bindArgs);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.118 -0400", hash_original_method = "ACE77F48482E9278318C8F93FF273D4F", hash_generated_method = "E346673D1C67FDBA52707DE4236A8647")
      SQLiteQuery(SQLiteDatabase db, SQLiteQuery query) {
        super(db, query.mSql);
        addTaint(db.getTaint());
        this.mBindArgs = query.mBindArgs;
        this.mOffsetIndex = query.mOffsetIndex;
        
        
        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.121 -0400", hash_original_method = "D55C6AB533D249202FC7A2AC29FF93BB", hash_generated_method = "3B578FBA0A780407E47672B078D54F53")
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
                    } 
                } 
                mDatabase.logTimeStat(mSql, timeStart);
                int var998EA97634C71C025EB15D1618C2A376_1949907513 = (numRows);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_450804565 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_450804565;
            } 
            catch (IllegalStateException e)
            {
                int varCFCD208495D565EF66E7DFF9F98764DA_1633642402 = (0);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_21307016 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_21307016;
            } 
            catch (SQLiteDatabaseCorruptException e)
            {
                mDatabase.onCorruption();
                e.addTaint(taint);
                throw e;
            } 
            catch (SQLiteException e)
            {
                e.addTaint(taint);
                throw e;
            } 
            finally 
            {
                window.releaseReference();
            } 
        } 
        finally 
        {
            releaseReference();
            mDatabase.unlock();
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.124 -0400", hash_original_method = "54618FF47D2C419F49442C51D0DA0774", hash_generated_method = "8AE09C5FDD49D947E0EE05A65951A6D5")
     int columnCountLocked() {
        acquireReference();
        try 
        {
            int var38E37CE3C8D0439303E00926E6741308_273887339 = (nativeColumnCount(nStatement));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2041550991 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2041550991;
        } 
        finally 
        {
            releaseReference();
        } 
        
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.125 -0400", hash_original_method = "B5AB077B4013E218660670FE95A73F4B", hash_generated_method = "8DB16C25668489823865D87B3881FA1D")
     String columnNameLocked(int columnIndex) {
        addTaint(columnIndex);
        acquireReference();
        try 
        {
String var96AFF3FBA6F9E943FBE0AF3FA990EC97_1567942472 =             nativeColumnName(nStatement, columnIndex);
            var96AFF3FBA6F9E943FBE0AF3FA990EC97_1567942472.addTaint(taint);
            return var96AFF3FBA6F9E943FBE0AF3FA990EC97_1567942472;
        } 
        finally 
        {
            releaseReference();
        } 
        
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.126 -0400", hash_original_method = "818F0EC4250B389213C92FDEA7A7A5CE", hash_generated_method = "29B05E8CF44394BA87D0B6AA904D16B2")
    @Override
    public String toString() {
String var3EFB8F4E9BBF4DC978F8DF4F177CC507_1873868056 =         "SQLiteQuery: " + mSql;
        var3EFB8F4E9BBF4DC978F8DF4F177CC507_1873868056.addTaint(taint);
        return var3EFB8F4E9BBF4DC978F8DF4F177CC507_1873868056;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.127 -0400", hash_original_method = "C1F8301470323E9B4CE9B1F32DF8E225", hash_generated_method = "6C73A8E1493172E7E20CAF1DBE3B5224")
    @Override
    public void close() {
        super.close();
        mClosed = true;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.127 -0400", hash_original_method = "10930ECAA546E890A142B67C44E349E2", hash_generated_method = "5F1D65D635204A219A4D8C4B7D67D4FE")
     void requery() {
    if(mClosed)        
        {
            IllegalStateException var6CAE77F670F1174A16CD140BED6B8FCA_1298339125 = new IllegalStateException("requerying a closed cursor");
            var6CAE77F670F1174A16CD140BED6B8FCA_1298339125.addTaint(taint);
            throw var6CAE77F670F1174A16CD140BED6B8FCA_1298339125;
        } 
        compileAndbindAllArgs();
        
        
            
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.128 -0400", hash_original_field = "B4D62BC7E132324EDD96845B1B8BA5B6", hash_generated_field = "33B4EC31717AE04F4951ABB455378F67")

    private static final String TAG = "SQLiteQuery";
}

