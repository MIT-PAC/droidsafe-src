package android.database.sqlite;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.database.DatabaseUtils;
import android.os.ParcelFileDescriptor;
import android.os.SystemClock;
import android.util.Log;
import java.io.IOException;
import dalvik.system.BlockGuard;

public class SQLiteStatement extends SQLiteProgram {
    private SQLiteDatabase mOrigDb;
    private int mState;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.911 -0400", hash_original_method = "5DDFF8C2B7E2F1702052BA1709F992B7", hash_generated_method = "9A90FEEAF58B61CA03A11CF4DEC60C09")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     SQLiteStatement(SQLiteDatabase db, String sql, Object[] bindArgs) {
        super(db, sql, bindArgs, false );
        dsTaint.addTaint(db.dsTaint);
        dsTaint.addTaint(bindArgs[0].dsTaint);
        dsTaint.addTaint(sql);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.911 -0400", hash_original_method = "AF1FDD5D94DA5350C3682852D1772235", hash_generated_method = "9731E3368F2C01BE2CC3A6FD5F2FC446")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void execute() {
        executeUpdateDelete();
        // ---------- Original Method ----------
        //executeUpdateDelete();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.911 -0400", hash_original_method = "66D9912335771E2036ED62B64CF3BC86", hash_generated_method = "6D68A3BFB148BF17A341645B40267E6F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.911 -0400", hash_original_method = "78D2410201CEBD83C87275DB09AEC8B4", hash_generated_method = "9EFC9F628F5D0F38DE116C60EE1303C0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long executeInsert() {
        try 
        {
            saveSqlAsLastSqlStatement();
            acquireAndLock(WRITE);
            long var6BAFE9A3CDD3D607224AE3DAB50F7575_2143644789 = (native_executeInsert());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.912 -0400", hash_original_method = "7424F80A42A729003FCB274AD124711E", hash_generated_method = "48903C4E449BC1F2AB6E6660E7AAF1CD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.912 -0400", hash_original_method = "12DB780B550F95E5C10FD5998E83FEFD", hash_generated_method = "3D7C6601820535CB02443C8EEF7463A4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
            if (DroidSafeAndroidRuntime.control) throw new SQLiteDoneException(
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.912 -0400", hash_original_method = "6D794A242164C6F60D732256A15CB380", hash_generated_method = "7E02695E37727CD52E64D36BCA9C78CA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
            if (DroidSafeAndroidRuntime.control) throw new SQLiteDoneException(
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.913 -0400", hash_original_method = "6321C559FCE18D31DAAE4496BAD49A23", hash_generated_method = "DE8B3B703FFB0E1E748B663691313D37")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
            if (DroidSafeAndroidRuntime.control) throw new SQLiteDoneException(
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.914 -0400", hash_original_method = "7802DA1EF14C1A6C860FAB64147EEA65", hash_generated_method = "D771D2352B3CC4A9A3671A3FDDC1AF2B")
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
                boolean var097D1FF015F3B6F2369065167A2F156B_1890811399 = (!mDatabase.isDbLockedByCurrentThread());
                {
                    mDatabase.setTransactionUsingExecSqlFlag();
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                boolean var37036F713C62CC107A333C2F5C92276E_665173093 = (!mDatabase.inTransaction());
                {
                    mDatabase.beginTransactionNonExclusive();
                    mState = TRANS_STARTED;
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            boolean var13D935343B6F3D3934E3A49ACF169DA9_1739655550 = (!mDatabase.isDbLockedByCurrentThread());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.915 -0400", hash_original_method = "3195EF2C5595E73848E74AA3B0A84A6E", hash_generated_method = "0B213DBB94FF0232F335C3289B944420")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.915 -0400", hash_original_method = "DA760EA6BB282F82E2B89FD24EBEEAD3", hash_generated_method = "D6690B19A627B942A02B6AA2FDA756CD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private final int native_execute() {
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.915 -0400", hash_original_method = "8482A8304EDF98FD537E7B2A3BC31388", hash_generated_method = "3538807199A919D0D15A9172C5E5BEAF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private final long native_executeInsert() {
        return dsTaint.getTaintLong();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.915 -0400", hash_original_method = "FE0D02F573B183DE07F8BDF82793A3EA", hash_generated_method = "45DB1B980624578A6B4AE397EE60F77E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private final long native_1x1_long() {
        return dsTaint.getTaintLong();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.916 -0400", hash_original_method = "07DFC0F07DCBF43769548BE4FBA916EE", hash_generated_method = "FAC93A8DAF234AA2D269C3AAE40DFB47")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private final String native_1x1_string() {
        return dsTaint.getTaintString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.916 -0400", hash_original_method = "D5A94C086543C65F36827FC2C8B73314", hash_generated_method = "45A99CDB4F55FD3E77A7D6FDBF22F6D9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private final ParcelFileDescriptor native_1x1_blob_ashmem() throws IOException {
        return (ParcelFileDescriptor)dsTaint.getTaint();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.916 -0400", hash_original_method = "BD9AF961A0959F9D5CBC2D8FDDD3B169", hash_generated_method = "594F01764FB7EB607461C62AFB952E3A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private final void native_executeSql(String sql) {
        dsTaint.addTaint(sql);
    }

    
    private static final String TAG = "SQLiteStatement";
    private static final boolean READ = true;
    private static final boolean WRITE = false;
    private static final int TRANS_STARTED = 1;
    private static final int LOCK_ACQUIRED = 2;
}

