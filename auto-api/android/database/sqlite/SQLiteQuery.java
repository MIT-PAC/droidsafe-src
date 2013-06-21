package android.database.sqlite;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.database.CursorWindow;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;

public class SQLiteQuery extends SQLiteProgram {
    private int mOffsetIndex = 0;
    private boolean mClosed = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.807 -0400", hash_original_method = "B04E51F22DB6FA67074D367FD62C2A3B", hash_generated_method = "C78B1C7BF110C1EB7AFEB5E5B2CC6C39")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     SQLiteQuery(SQLiteDatabase db, String query, int offsetIndex, String[] bindArgs) {
        super(db, query);
        dsTaint.addTaint(db.dsTaint);
        dsTaint.addTaint(bindArgs[0]);
        dsTaint.addTaint(query);
        dsTaint.addTaint(offsetIndex);
        bindAllArgsAsStrings(bindArgs);
        // ---------- Original Method ----------
        //mOffsetIndex = offsetIndex;
        //bindAllArgsAsStrings(bindArgs);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.808 -0400", hash_original_method = "ACE77F48482E9278318C8F93FF273D4F", hash_generated_method = "0FAC175B2DEB0E847EC3ED9E6C458994")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     SQLiteQuery(SQLiteDatabase db, SQLiteQuery query) {
        super(db, query.mSql);
        dsTaint.addTaint(db.dsTaint);
        dsTaint.addTaint(query.dsTaint);
        this.mBindArgs = query.mBindArgs;
        this.mOffsetIndex = query.mOffsetIndex;
        // ---------- Original Method ----------
        //this.mBindArgs = query.mBindArgs;
        //this.mOffsetIndex = query.mOffsetIndex;
    }

    
        private static int nativeFillWindow(int databasePtr, int statementPtr, int windowPtr,
            int startPos, int offsetParam) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static int nativeColumnCount(int statementPtr) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static String nativeColumnName(int statementPtr, int columnIndex) {
        return DSUtils.UNKNOWN_STRING;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.820 -0400", hash_original_method = "D55C6AB533D249202FC7A2AC29FF93BB", hash_generated_method = "72D629B958AEED25222DB17658113079")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     int fillWindow(CursorWindow window) {
        dsTaint.addTaint(window.dsTaint);
        mDatabase.lock(mSql);
        long timeStart;
        timeStart = SystemClock.uptimeMillis();
        try 
        {
            acquireReference();
            try 
            {
                window.acquireReference();
                int startPos;
                startPos = window.getStartPosition();
                int numRows;
                numRows = nativeFillWindow(nHandle, nStatement, window.mWindowPtr,
                        startPos, mOffsetIndex);
                {
                    long elapsed;
                    elapsed = SystemClock.uptimeMillis() - timeStart;
                    {
                        boolean var988A9DFF582FC3584A942C7F256FAFD2_1437943264 = (SQLiteDebug.shouldLogSlowQuery(elapsed));
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
                    } //End collapsed parenthetic
                } //End block
                mDatabase.logTimeStat(mSql, timeStart);
            } //End block
            catch (IllegalStateException e)
            { }
            catch (SQLiteDatabaseCorruptException e)
            {
                mDatabase.onCorruption();
                if (DroidSafeAndroidRuntime.control) throw e;
            } //End block
            catch (SQLiteException e)
            {
                if (DroidSafeAndroidRuntime.control) throw e;
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
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.822 -0400", hash_original_method = "54618FF47D2C419F49442C51D0DA0774", hash_generated_method = "F74E15B2DF5B2B61833700672B77C1FB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     int columnCountLocked() {
        acquireReference();
        try 
        {
            int var4CE791ADD9DE7633E946332B2B15C816_1472913948 = (nativeColumnCount(nStatement));
        } //End block
        finally 
        {
            releaseReference();
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //acquireReference();
        //try {
            //return nativeColumnCount(nStatement);
        //} finally {
            //releaseReference();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.823 -0400", hash_original_method = "B5AB077B4013E218660670FE95A73F4B", hash_generated_method = "5346BD60089E36C185CFCFBBA339C35B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     String columnNameLocked(int columnIndex) {
        dsTaint.addTaint(columnIndex);
        acquireReference();
        try 
        {
            String var5D2C25EF01B7B3781368937337475B59_1154922541 = (nativeColumnName(nStatement, columnIndex));
        } //End block
        finally 
        {
            releaseReference();
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //acquireReference();
        //try {
            //return nativeColumnName(nStatement, columnIndex);
        //} finally {
            //releaseReference();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.826 -0400", hash_original_method = "818F0EC4250B389213C92FDEA7A7A5CE", hash_generated_method = "E340556E734E7E265B52EB2604B15A26")
    @DSModeled(DSC.SAFE)
    @Override
    public String toString() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "SQLiteQuery: " + mSql;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.826 -0400", hash_original_method = "C1F8301470323E9B4CE9B1F32DF8E225", hash_generated_method = "6C73A8E1493172E7E20CAF1DBE3B5224")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void close() {
        super.close();
        mClosed = true;
        // ---------- Original Method ----------
        //super.close();
        //mClosed = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.827 -0400", hash_original_method = "10930ECAA546E890A142B67C44E349E2", hash_generated_method = "54FBEE154273A70AA944D1037CC0878E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void requery() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("requerying a closed cursor");
        } //End block
        compileAndbindAllArgs();
        // ---------- Original Method ----------
        //if (mClosed) {
            //throw new IllegalStateException("requerying a closed cursor");
        //}
        //compileAndbindAllArgs();
    }

    
    private static final String TAG = "SQLiteQuery";
}

