package android.database.sqlite;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.database.DatabaseUtils;
import android.os.ParcelFileDescriptor;
import android.os.SystemClock;
import android.util.Log;
import java.io.IOException;
import dalvik.system.BlockGuard;

public class SQLiteStatement extends SQLiteProgram {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.056 -0400", hash_original_field = "E67780D6797A95AA13F04D47887933FA", hash_generated_field = "2F51843A821BD5FB98E893CC1830882F")

    private SQLiteDatabase mOrigDb;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.056 -0400", hash_original_field = "48A902C1D749B47EBC75C77370D5A1F0", hash_generated_field = "19B55F2750B971E6310D64ADB9B2D0CF")

    private int mState;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.057 -0400", hash_original_method = "5DDFF8C2B7E2F1702052BA1709F992B7", hash_generated_method = "B26B6AE60396DF897D74969D9DC6B77E")
      SQLiteStatement(SQLiteDatabase db, String sql, Object[] bindArgs) {
        super(db, sql, bindArgs, false );
        addTaint(bindArgs[0].getTaint());
        addTaint(sql.getTaint());
        addTaint(db.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.058 -0400", hash_original_method = "AF1FDD5D94DA5350C3682852D1772235", hash_generated_method = "9731E3368F2C01BE2CC3A6FD5F2FC446")
    public void execute() {
        executeUpdateDelete();
        // ---------- Original Method ----------
        //executeUpdateDelete();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.058 -0400", hash_original_method = "66D9912335771E2036ED62B64CF3BC86", hash_generated_method = "062D012ACC0658844CBF23041E31F4BA")
    public int executeUpdateDelete() {
        try 
        {
            saveSqlAsLastSqlStatement();
            acquireAndLock(WRITE);
            int numChanges = 0;
            if((mStatementType & STATEMENT_DONT_PREPARE) > 0)            
            {
                native_executeSql(mSql);
            } //End block
            else
            {
                numChanges = native_execute();
            } //End block
            int var0BA6E2D376AB963636F864563F7B8E93_1113489873 = (numChanges);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1159401672 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1159401672;
        } //End block
        finally 
        {
            releaseAndUnlock();
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.060 -0400", hash_original_method = "78D2410201CEBD83C87275DB09AEC8B4", hash_generated_method = "B7441A4097BC0C1F105A001ED2B8EBAB")
    public long executeInsert() {
        try 
        {
            saveSqlAsLastSqlStatement();
            acquireAndLock(WRITE);
            long varFEF277E4A81284CFE5A5AC17F6A57582_276094477 = (native_executeInsert());
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_250605982 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_250605982;
        } //End block
        finally 
        {
            releaseAndUnlock();
        } //End block
        // ---------- Original Method ----------
        //try {
            //saveSqlAsLastSqlStatement();
            //acquireAndLock(WRITE);
            //return native_executeInsert();
        //} finally {
            //releaseAndUnlock();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.060 -0400", hash_original_method = "7424F80A42A729003FCB274AD124711E", hash_generated_method = "7BBF6CA8F3FC8F268D1BE88F824B3398")
    private void saveSqlAsLastSqlStatement() {
        if(((mStatementType & SQLiteProgram.STATEMENT_TYPE_MASK) ==
                DatabaseUtils.STATEMENT_UPDATE) ||
                (mStatementType & SQLiteProgram.STATEMENT_TYPE_MASK) ==
                DatabaseUtils.STATEMENT_BEGIN)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.061 -0400", hash_original_method = "12DB780B550F95E5C10FD5998E83FEFD", hash_generated_method = "266E560CEDC9D2BD7A8D2B849209BF31")
    public long simpleQueryForLong() {
        try 
        {
            long timeStart = acquireAndLock(READ);
            long retValue = native_1x1_long();
            mDatabase.logTimeStat(mSql, timeStart);
            long var9C7BD17E8EB1C3D0F843684A79A18570_1773176118 = (retValue);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_568445161 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_568445161;
        } //End block
        catch (SQLiteDoneException e)
        {
            SQLiteDoneException var509C73A4243220CC3BCDEFBCB7C17A34_1788818809 = new SQLiteDoneException(
                    "expected 1 row from this query but query returned no data. check the query: " +
                    mSql);
            var509C73A4243220CC3BCDEFBCB7C17A34_1788818809.addTaint(taint);
            throw var509C73A4243220CC3BCDEFBCB7C17A34_1788818809;
        } //End block
        finally 
        {
            releaseAndUnlock();
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.062 -0400", hash_original_method = "6D794A242164C6F60D732256A15CB380", hash_generated_method = "7D1682DD79401AD2EAF263F26FD5C2CB")
    public String simpleQueryForString() {
        try 
        {
            long timeStart = acquireAndLock(READ);
            String retValue = native_1x1_string();
            mDatabase.logTimeStat(mSql, timeStart);
String var8A3AE42CF4D96FEAF203C6E7E2606E2D_1479796672 =             retValue;
            var8A3AE42CF4D96FEAF203C6E7E2606E2D_1479796672.addTaint(taint);
            return var8A3AE42CF4D96FEAF203C6E7E2606E2D_1479796672;
        } //End block
        catch (SQLiteDoneException e)
        {
            SQLiteDoneException var509C73A4243220CC3BCDEFBCB7C17A34_1130786527 = new SQLiteDoneException(
                    "expected 1 row from this query but query returned no data. check the query: " +
                    mSql);
            var509C73A4243220CC3BCDEFBCB7C17A34_1130786527.addTaint(taint);
            throw var509C73A4243220CC3BCDEFBCB7C17A34_1130786527;
        } //End block
        finally 
        {
            releaseAndUnlock();
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.064 -0400", hash_original_method = "6321C559FCE18D31DAAE4496BAD49A23", hash_generated_method = "DBEA05961CF0EE43D2C14D36199643E1")
    public ParcelFileDescriptor simpleQueryForBlobFileDescriptor() {
        try 
        {
            long timeStart = acquireAndLock(READ);
            ParcelFileDescriptor retValue = native_1x1_blob_ashmem();
            mDatabase.logTimeStat(mSql, timeStart);
ParcelFileDescriptor var8A3AE42CF4D96FEAF203C6E7E2606E2D_985029802 =             retValue;
            var8A3AE42CF4D96FEAF203C6E7E2606E2D_985029802.addTaint(taint);
            return var8A3AE42CF4D96FEAF203C6E7E2606E2D_985029802;
        } //End block
        catch (IOException ex)
        {
ParcelFileDescriptor var540C13E9E156B687226421B24F2DF178_1916400177 =             null;
            var540C13E9E156B687226421B24F2DF178_1916400177.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1916400177;
        } //End block
        catch (SQLiteDoneException e)
        {
            SQLiteDoneException var509C73A4243220CC3BCDEFBCB7C17A34_1680121773 = new SQLiteDoneException(
                    "expected 1 row from this query but query returned no data. check the query: " +
                    mSql);
            var509C73A4243220CC3BCDEFBCB7C17A34_1680121773.addTaint(taint);
            throw var509C73A4243220CC3BCDEFBCB7C17A34_1680121773;
        } //End block
        finally 
        {
            releaseAndUnlock();
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.068 -0400", hash_original_method = "7802DA1EF14C1A6C860FAB64147EEA65", hash_generated_method = "8AABFB05BAD41294769D01113CF324B3")
    private long acquireAndLock(boolean rwFlag) {
        addTaint(rwFlag);
        mState = 0;
        mDatabase.verifyDbIsOpen();
        SQLiteDatabase db = ((mStatementType & SQLiteProgram.STATEMENT_USE_POOLED_CONN) > 0)
                ? mDatabase.getDbConnection(mSql) : mDatabase;
        mOrigDb = mDatabase;
        mDatabase = db;
        setNativeHandle(mDatabase.mNativeHandle);
        if(rwFlag == WRITE)        
        {
            BlockGuard.getThreadPolicy().onWriteToDisk();
        } //End block
        else
        {
            BlockGuard.getThreadPolicy().onReadFromDisk();
        } //End block
        if((mStatementType & SQLiteProgram.STATEMENT_TYPE_MASK) == DatabaseUtils.STATEMENT_BEGIN)        
        {
            if(!mDatabase.isDbLockedByCurrentThread())            
            {
                mDatabase.setTransactionUsingExecSqlFlag();
            } //End block
        } //End block
        else
        if((mStatementType & SQLiteProgram.STATEMENT_TYPE_MASK) ==
                DatabaseUtils.STATEMENT_UPDATE)        
        {
            if(!mDatabase.inTransaction())            
            {
                mDatabase.beginTransactionNonExclusive();
                mState = TRANS_STARTED;
            } //End block
        } //End block
        if(!mDatabase.isDbLockedByCurrentThread())        
        {
            mDatabase.lock(mSql);
            mState = LOCK_ACQUIRED;
        } //End block
        acquireReference();
        long startTime = SystemClock.uptimeMillis();
        mDatabase.closePendingStatements();
        compileAndbindAllArgs();
        long var5B2A579F62087D17D79CE59F3DE5F6D1_1777135871 = (startTime);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_621305209 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_621305209;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.070 -0400", hash_original_method = "3195EF2C5595E73848E74AA3B0A84A6E", hash_generated_method = "C21D6BAFEEFA8F70ABEAE73AF2467CE1")
    private void releaseAndUnlock() {
        releaseReference();
        if(mState == TRANS_STARTED)        
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
        else
        if(mState == LOCK_ACQUIRED)        
        {
            mDatabase.unlock();
        } //End block
        if((mStatementType & SQLiteProgram.STATEMENT_TYPE_MASK) ==
                DatabaseUtils.STATEMENT_COMMIT ||
                (mStatementType & SQLiteProgram.STATEMENT_TYPE_MASK) ==
                DatabaseUtils.STATEMENT_ABORT)        
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.072 -0400", hash_original_method = "DA760EA6BB282F82E2B89FD24EBEEAD3", hash_generated_method = "210CF0241252D4DBF0D13B58900D7D94")
    private final int native_execute() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_942614187 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_942614187;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.073 -0400", hash_original_method = "8482A8304EDF98FD537E7B2A3BC31388", hash_generated_method = "5E9544292D1FA84AD57EFA34C64A44A3")
    private final long native_executeInsert() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_303666488 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_303666488;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.073 -0400", hash_original_method = "FE0D02F573B183DE07F8BDF82793A3EA", hash_generated_method = "77FDB863DBDFDAD6CFB3311E05C24E12")
    private final long native_1x1_long() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1607236002 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1607236002;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.900 -0400", hash_original_method = "07DFC0F07DCBF43769548BE4FBA916EE", hash_generated_method = "28030A1C7DC39244AA70D827443E96B9")
    private final String native_1x1_string() {
    	String foo = new String();
    	return foo;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.900 -0400", hash_original_method = "D5A94C086543C65F36827FC2C8B73314", hash_generated_method = "2FF5ECD0A356350F1F45EEEF9C01561B")
    private final ParcelFileDescriptor native_1x1_blob_ashmem() throws IOException {
    	return new ParcelFileDescriptor();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.076 -0400", hash_original_method = "BD9AF961A0959F9D5CBC2D8FDDD3B169", hash_generated_method = "D10F7D0B2AF60F2190B0E6B997651F64")
    private final void native_executeSql(String sql) {
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.077 -0400", hash_original_field = "DD19317116B58B00292F949DD2B1E756", hash_generated_field = "B25F6A4CB29F6325E49F04F66EE5886C")

    private static final String TAG = "SQLiteStatement";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.077 -0400", hash_original_field = "05ADA3F1E165472D313D165DAB44A6CC", hash_generated_field = "DF1BFFA8AE77C9EB2467DB4A53480D19")

    private static final boolean READ = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.077 -0400", hash_original_field = "53B6455C8E3B4984E225565A855CEA76", hash_generated_field = "4E20ADB74C14AC29719A4662B74CC6FA")

    private static final boolean WRITE = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.077 -0400", hash_original_field = "61939F59B722807810579AD50EC24088", hash_generated_field = "51E8612B8DBE387C00FDA982510BC3C4")

    private static final int TRANS_STARTED = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.077 -0400", hash_original_field = "A9DDAD52531AA66AF93FF12F9D89A659", hash_generated_field = "8F182F697D081190134825A0E369736C")

    private static final int LOCK_ACQUIRED = 2;
}

