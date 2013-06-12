package android.database.sqlite;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.database.DatabaseUtils;
import android.os.ParcelFileDescriptor;
import android.os.SystemClock;
import android.util.Log;
import java.io.IOException;
import dalvik.system.BlockGuard;

public class SQLiteStatement extends SQLiteProgram {
    private static final String TAG = "SQLiteStatement";
    private static final boolean READ = true;
    private static final boolean WRITE = false;
    private SQLiteDatabase mOrigDb;
    private int mState;
    private static final int TRANS_STARTED = 1;
    private static final int LOCK_ACQUIRED = 2;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.841 -0400", hash_original_method = "5DDFF8C2B7E2F1702052BA1709F992B7", hash_generated_method = "E2D4B047B742FAE9C7204EBB01A58296")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     SQLiteStatement(SQLiteDatabase db, String sql, Object[] bindArgs) {
        super(db, sql, bindArgs, false );
        dsTaint.addTaint(db.dsTaint);
        dsTaint.addTaint(sql);
        dsTaint.addTaint(bindArgs.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.841 -0400", hash_original_method = "AF1FDD5D94DA5350C3682852D1772235", hash_generated_method = "43204DB938F3485A5365F0FCA3150679")
    @DSModeled(DSC.SAFE)
    public void execute() {
        executeUpdateDelete();
        // ---------- Original Method ----------
        //executeUpdateDelete();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.842 -0400", hash_original_method = "66D9912335771E2036ED62B64CF3BC86", hash_generated_method = "4087CE766C6BF1EF16F111A45C396E94")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int executeUpdateDelete() {
        try 
        {
            saveSqlAsLastSqlStatement();
            acquireAndLock(WRITE);
            int numChanges;
            numChanges = 0;
            {
                native_executeSql(mSql);
            } //End block
            {
                numChanges = native_execute();
            } //End block
        } //End block
        finally 
        {
            releaseAndUnlock();
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //try {
            //saveSqlAsLastSqlStatement();
            //acquireAndLock(WRITE);
            //int numChanges = 0;
            //if ((mStatementType & STATEMENT_DONT_PREPARE) > 0) {
                //native_executeSql(mSql);
            //} else {
                //numChanges = native_execute();
            //}
            //return numChanges;
        //} finally {
            //releaseAndUnlock();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.842 -0400", hash_original_method = "78D2410201CEBD83C87275DB09AEC8B4", hash_generated_method = "BD04C0143B7CE09ABEE9ECBC83AC5BB2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long executeInsert() {
        try 
        {
            saveSqlAsLastSqlStatement();
            acquireAndLock(WRITE);
            long var6BAFE9A3CDD3D607224AE3DAB50F7575_1012918982 = (native_executeInsert());
        } //End block
        finally 
        {
            releaseAndUnlock();
        } //End block
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //try {
            //saveSqlAsLastSqlStatement();
            //acquireAndLock(WRITE);
            //return native_executeInsert();
        //} finally {
            //releaseAndUnlock();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.842 -0400", hash_original_method = "7424F80A42A729003FCB274AD124711E", hash_generated_method = "15885610272921B00C14393EC21A0088")
    @DSModeled(DSC.SAFE)
    private void saveSqlAsLastSqlStatement() {
        {
            mDatabase.setLastSqlStatement(mSql);
        } //End block
        // ---------- Original Method ----------
        //if (((mStatementType & SQLiteProgram.STATEMENT_TYPE_MASK) ==
                //DatabaseUtils.STATEMENT_UPDATE) ||
                //(mStatementType & SQLiteProgram.STATEMENT_TYPE_MASK) ==
                //DatabaseUtils.STATEMENT_BEGIN) {
            //mDatabase.setLastSqlStatement(mSql);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.842 -0400", hash_original_method = "12DB780B550F95E5C10FD5998E83FEFD", hash_generated_method = "2B8DA87F9EEE08DC58E775A1642DBF1E")
    @DSModeled(DSC.SAFE)
    public long simpleQueryForLong() {
        try 
        {
            long timeStart;
            timeStart = acquireAndLock(READ);
            long retValue;
            retValue = native_1x1_long();
            mDatabase.logTimeStat(mSql, timeStart);
        } //End block
        catch (SQLiteDoneException e)
        {
            throw new SQLiteDoneException(
                    "expected 1 row from this query but query returned no data. check the query: " +
                    mSql);
        } //End block
        finally 
        {
            releaseAndUnlock();
        } //End block
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //try {
            //long timeStart = acquireAndLock(READ);
            //long retValue = native_1x1_long();
            //mDatabase.logTimeStat(mSql, timeStart);
            //return retValue;
        //} catch (SQLiteDoneException e) {
            //throw new SQLiteDoneException(
                    //"expected 1 row from this query but query returned no data. check the query: " +
                    //mSql);
        //} finally {
            //releaseAndUnlock();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.842 -0400", hash_original_method = "6D794A242164C6F60D732256A15CB380", hash_generated_method = "1FA7638EDA5B2A73AB7ADC3011852ACA")
    @DSModeled(DSC.SAFE)
    public String simpleQueryForString() {
        try 
        {
            long timeStart;
            timeStart = acquireAndLock(READ);
            String retValue;
            retValue = native_1x1_string();
            mDatabase.logTimeStat(mSql, timeStart);
        } //End block
        catch (SQLiteDoneException e)
        {
            throw new SQLiteDoneException(
                    "expected 1 row from this query but query returned no data. check the query: " +
                    mSql);
        } //End block
        finally 
        {
            releaseAndUnlock();
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //try {
            //long timeStart = acquireAndLock(READ);
            //String retValue = native_1x1_string();
            //mDatabase.logTimeStat(mSql, timeStart);
            //return retValue;
        //} catch (SQLiteDoneException e) {
            //throw new SQLiteDoneException(
                    //"expected 1 row from this query but query returned no data. check the query: " +
                    //mSql);
        //} finally {
            //releaseAndUnlock();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.843 -0400", hash_original_method = "6321C559FCE18D31DAAE4496BAD49A23", hash_generated_method = "E6BFEC70DF94B8ED4308C6392B56B7AD")
    @DSModeled(DSC.SAFE)
    public ParcelFileDescriptor simpleQueryForBlobFileDescriptor() {
        try 
        {
            long timeStart;
            timeStart = acquireAndLock(READ);
            ParcelFileDescriptor retValue;
            retValue = native_1x1_blob_ashmem();
            mDatabase.logTimeStat(mSql, timeStart);
        } //End block
        catch (IOException ex)
        { }
        catch (SQLiteDoneException e)
        {
            throw new SQLiteDoneException(
                    "expected 1 row from this query but query returned no data. check the query: " +
                    mSql);
        } //End block
        finally 
        {
            releaseAndUnlock();
        } //End block
        return (ParcelFileDescriptor)dsTaint.getTaint();
        // ---------- Original Method ----------
        //try {
            //long timeStart = acquireAndLock(READ);
            //ParcelFileDescriptor retValue = native_1x1_blob_ashmem();
            //mDatabase.logTimeStat(mSql, timeStart);
            //return retValue;
        //} catch (IOException ex) {
            //Log.e(TAG, "simpleQueryForBlobFileDescriptor() failed", ex);
            //return null;
        //} catch (SQLiteDoneException e) {
            //throw new SQLiteDoneException(
                    //"expected 1 row from this query but query returned no data. check the query: " +
                    //mSql);
        //} finally {
            //releaseAndUnlock();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.843 -0400", hash_original_method = "7802DA1EF14C1A6C860FAB64147EEA65", hash_generated_method = "A61301138381F0BEE030BF6EB5BB9FE1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private long acquireAndLock(boolean rwFlag) {
        dsTaint.addTaint(rwFlag);
        mState = 0;
        mDatabase.verifyDbIsOpen();
        SQLiteDatabase db;
        db = mDatabase.getDbConnection(mSql);
        db = mDatabase;
        mOrigDb = mDatabase;
        mDatabase = db;
        setNativeHandle(mDatabase.mNativeHandle);
        {
            BlockGuard.getThreadPolicy().onWriteToDisk();
        } //End block
        {
            BlockGuard.getThreadPolicy().onReadFromDisk();
        } //End block
        {
            {
                boolean var097D1FF015F3B6F2369065167A2F156B_1698468952 = (!mDatabase.isDbLockedByCurrentThread());
                {
                    mDatabase.setTransactionUsingExecSqlFlag();
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                boolean var37036F713C62CC107A333C2F5C92276E_627577715 = (!mDatabase.inTransaction());
                {
                    mDatabase.beginTransactionNonExclusive();
                    mState = TRANS_STARTED;
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            boolean var13D935343B6F3D3934E3A49ACF169DA9_1393693156 = (!mDatabase.isDbLockedByCurrentThread());
            {
                mDatabase.lock(mSql);
                mState = LOCK_ACQUIRED;
            } //End block
        } //End collapsed parenthetic
        acquireReference();
        long startTime;
        startTime = SystemClock.uptimeMillis();
        mDatabase.closePendingStatements();
        compileAndbindAllArgs();
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.844 -0400", hash_original_method = "3195EF2C5595E73848E74AA3B0A84A6E", hash_generated_method = "15684C006C43955EA77A0BC07B45DBE6")
    @DSModeled(DSC.SAFE)
    private void releaseAndUnlock() {
        releaseReference();
        {
            try 
            {
                mDatabase.setTransactionSuccessful();
            } //End block
            finally 
            {
                mDatabase.endTransaction();
            } //End block
        } //End block
        {
            mDatabase.unlock();
        } //End block
        {
            mDatabase.resetTransactionUsingExecSqlFlag();
        } //End block
        clearBindings();
        release();
        mDatabase = mOrigDb;
        setNativeHandle(mDatabase.mNativeHandle);
        // ---------- Original Method ----------
        //releaseReference();
        //if (mState == TRANS_STARTED) {
            //try {
                //mDatabase.setTransactionSuccessful();
            //} finally {
                //mDatabase.endTransaction();
            //}
        //} else if (mState == LOCK_ACQUIRED) {
            //mDatabase.unlock();
        //}
        //if ((mStatementType & SQLiteProgram.STATEMENT_TYPE_MASK) ==
                //DatabaseUtils.STATEMENT_COMMIT ||
                //(mStatementType & SQLiteProgram.STATEMENT_TYPE_MASK) ==
                //DatabaseUtils.STATEMENT_ABORT) {
            //mDatabase.resetTransactionUsingExecSqlFlag();
        //}
        //clearBindings();
        //release();
        //mDatabase = mOrigDb;
        //setNativeHandle(mDatabase.mNativeHandle);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.844 -0400", hash_original_method = "DA760EA6BB282F82E2B89FD24EBEEAD3", hash_generated_method = "06D248149525BF39B3F010370BC1F179")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private final int native_execute() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.844 -0400", hash_original_method = "8482A8304EDF98FD537E7B2A3BC31388", hash_generated_method = "0F7E49B9B72642D74481D506A2362EE4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private final long native_executeInsert() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.844 -0400", hash_original_method = "FE0D02F573B183DE07F8BDF82793A3EA", hash_generated_method = "5CEC13B525B37FF6C06A2411CC7D98C2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private final long native_1x1_long() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.844 -0400", hash_original_method = "07DFC0F07DCBF43769548BE4FBA916EE", hash_generated_method = "25FE27787799634AF47985BD3C7E0A29")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private final String native_1x1_string() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.844 -0400", hash_original_method = "D5A94C086543C65F36827FC2C8B73314", hash_generated_method = "BB7EDC55B6BAB2FB10970B4F7F65DF56")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private final ParcelFileDescriptor native_1x1_blob_ashmem() throws IOException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.844 -0400", hash_original_method = "BD9AF961A0959F9D5CBC2D8FDDD3B169", hash_generated_method = "A10B1D028CA00D6DA5AB95DD151AECD7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private final void native_executeSql(String sql) {
        dsTaint.addTaint(sql);
    }

    
}


