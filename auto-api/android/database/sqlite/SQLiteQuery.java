package android.database.sqlite;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.database.CursorWindow;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;

public class SQLiteQuery extends SQLiteProgram {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.807 -0400", hash_original_field = "4A4AFE184AA8D6209A0E3DD0DCD593B5", hash_generated_field = "834FF8F7040C5E40B4484771C7969574")

    private int mOffsetIndex = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.807 -0400", hash_original_field = "D72871D5CE2EB17105099280224B0CCD", hash_generated_field = "0FB4858B613824FE6FDA94A379EBC4D0")

    private boolean mClosed = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.808 -0400", hash_original_method = "B04E51F22DB6FA67074D367FD62C2A3B", hash_generated_method = "8914B1AB11B0D4C21E3DA2EFBAD7968B")
      SQLiteQuery(SQLiteDatabase db, String query, int offsetIndex, String[] bindArgs) {
        super(db, query);
        mOffsetIndex = offsetIndex;
        bindAllArgsAsStrings(bindArgs);
        addTaint(db.getTaint());
        addTaint(query.getTaint());
        addTaint(bindArgs[0].getTaint());
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.809 -0400", hash_original_method = "ACE77F48482E9278318C8F93FF273D4F", hash_generated_method = "7B621664D0D3B1034B549C18CA917F36")
      SQLiteQuery(SQLiteDatabase db, SQLiteQuery query) {
        super(db, query.mSql);
        this.mBindArgs = query.mBindArgs;
        this.mOffsetIndex = query.mOffsetIndex;
        addTaint(db.getTaint());
        
        
        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.812 -0400", hash_original_method = "D55C6AB533D249202FC7A2AC29FF93BB", hash_generated_method = "97435A91B2624AC19E509155F44CA7A2")
     int fillWindow(CursorWindow window) {
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
                {
                    long elapsed = SystemClock.uptimeMillis() - timeStart;
                    {
                        boolean var988A9DFF582FC3584A942C7F256FAFD2_1188680730 = (SQLiteDebug.shouldLogSlowQuery(elapsed));
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
                } 
                mDatabase.logTimeStat(mSql, timeStart);
            } 
            catch (IllegalStateException e)
            { }
            catch (SQLiteDatabaseCorruptException e)
            {
                mDatabase.onCorruption();
                if (DroidSafeAndroidRuntime.control) throw e;
            } 
            catch (SQLiteException e)
            {
                if (DroidSafeAndroidRuntime.control) throw e;
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
        addTaint(window.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_794893076 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_794893076;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.813 -0400", hash_original_method = "54618FF47D2C419F49442C51D0DA0774", hash_generated_method = "C2D13CBDBF037B68622C21A898D24E35")
     int columnCountLocked() {
        acquireReference();
        try 
        {
            int var4CE791ADD9DE7633E946332B2B15C816_1843245498 = (nativeColumnCount(nStatement));
        } 
        finally 
        {
            releaseReference();
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2067284946 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2067284946;
        
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.814 -0400", hash_original_method = "B5AB077B4013E218660670FE95A73F4B", hash_generated_method = "C2227A014F70DCB932C3004573DB9567")
     String columnNameLocked(int columnIndex) {
        String varB4EAC82CA7396A68D541C85D26508E83_485933085 = null; 
        acquireReference();
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_485933085 = nativeColumnName(nStatement, columnIndex);
        } 
        finally 
        {
            releaseReference();
        } 
        addTaint(columnIndex);
        varB4EAC82CA7396A68D541C85D26508E83_485933085.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_485933085;
        
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.815 -0400", hash_original_method = "818F0EC4250B389213C92FDEA7A7A5CE", hash_generated_method = "C6E0A84D09B490BB663985B158C21716")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_669638678 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_669638678 = "SQLiteQuery: " + mSql;
        varB4EAC82CA7396A68D541C85D26508E83_669638678.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_669638678;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.815 -0400", hash_original_method = "C1F8301470323E9B4CE9B1F32DF8E225", hash_generated_method = "6C73A8E1493172E7E20CAF1DBE3B5224")
    @Override
    public void close() {
        super.close();
        mClosed = true;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.816 -0400", hash_original_method = "10930ECAA546E890A142B67C44E349E2", hash_generated_method = "54FBEE154273A70AA944D1037CC0878E")
     void requery() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("requerying a closed cursor");
        } 
        compileAndbindAllArgs();
        
        
            
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.816 -0400", hash_original_field = "B4D62BC7E132324EDD96845B1B8BA5B6", hash_generated_field = "33B4EC31717AE04F4951ABB455378F67")

    private static final String TAG = "SQLiteQuery";
}

