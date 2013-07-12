package android.database.sqlite;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.239 -0400", hash_original_field = "E67780D6797A95AA13F04D47887933FA", hash_generated_field = "2F51843A821BD5FB98E893CC1830882F")

    private SQLiteDatabase mOrigDb;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.239 -0400", hash_original_field = "48A902C1D749B47EBC75C77370D5A1F0", hash_generated_field = "19B55F2750B971E6310D64ADB9B2D0CF")

    private int mState;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.239 -0400", hash_original_method = "5DDFF8C2B7E2F1702052BA1709F992B7", hash_generated_method = "B26B6AE60396DF897D74969D9DC6B77E")
      SQLiteStatement(SQLiteDatabase db, String sql, Object[] bindArgs) {
        super(db, sql, bindArgs, false );
        addTaint(bindArgs[0].getTaint());
        addTaint(sql.getTaint());
        addTaint(db.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.240 -0400", hash_original_method = "AF1FDD5D94DA5350C3682852D1772235", hash_generated_method = "9731E3368F2C01BE2CC3A6FD5F2FC446")
    public void execute() {
        executeUpdateDelete();
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.241 -0400", hash_original_method = "66D9912335771E2036ED62B64CF3BC86", hash_generated_method = "FF8D53B71052E5076CCC89926A321CCF")
    public int executeUpdateDelete() {
        try 
        {
            saveSqlAsLastSqlStatement();
            acquireAndLock(WRITE);
            int numChanges = 0;
    if((mStatementType & STATEMENT_DONT_PREPARE) > 0)            
            {
                native_executeSql(mSql);
            } 
            else
            {
                numChanges = native_execute();
            } 
            int var0BA6E2D376AB963636F864563F7B8E93_2083825140 = (numChanges);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1587212710 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1587212710;
        } 
        finally 
        {
            releaseAndUnlock();
        } 
        
        
            
            
            
            
                
            
                
            
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.241 -0400", hash_original_method = "78D2410201CEBD83C87275DB09AEC8B4", hash_generated_method = "8DB64C0294FE7589E417DFF7916156B9")
    public long executeInsert() {
        try 
        {
            saveSqlAsLastSqlStatement();
            acquireAndLock(WRITE);
            long varFEF277E4A81284CFE5A5AC17F6A57582_221831457 = (native_executeInsert());
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_578627662 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_578627662;
        } 
        finally 
        {
            releaseAndUnlock();
        } 
        
        
            
            
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.242 -0400", hash_original_method = "7424F80A42A729003FCB274AD124711E", hash_generated_method = "7BBF6CA8F3FC8F268D1BE88F824B3398")
    private void saveSqlAsLastSqlStatement() {
    if(((mStatementType & SQLiteProgram.STATEMENT_TYPE_MASK) ==
                DatabaseUtils.STATEMENT_UPDATE) ||
                (mStatementType & SQLiteProgram.STATEMENT_TYPE_MASK) ==
                DatabaseUtils.STATEMENT_BEGIN)        
        {
            mDatabase.setLastSqlStatement(mSql);
        } 
        
        
                
                
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.242 -0400", hash_original_method = "12DB780B550F95E5C10FD5998E83FEFD", hash_generated_method = "7F71825C619E4C5F28C34658EC059942")
    public long simpleQueryForLong() {
        try 
        {
            long timeStart = acquireAndLock(READ);
            long retValue = native_1x1_long();
            mDatabase.logTimeStat(mSql, timeStart);
            long var9C7BD17E8EB1C3D0F843684A79A18570_1237878853 = (retValue);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_214823101 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_214823101;
        } 
        catch (SQLiteDoneException e)
        {
            SQLiteDoneException var509C73A4243220CC3BCDEFBCB7C17A34_1179224729 = new SQLiteDoneException(
                    "expected 1 row from this query but query returned no data. check the query: " +
                    mSql);
            var509C73A4243220CC3BCDEFBCB7C17A34_1179224729.addTaint(taint);
            throw var509C73A4243220CC3BCDEFBCB7C17A34_1179224729;
        } 
        finally 
        {
            releaseAndUnlock();
        } 
        
        
            
            
            
            
        
            
                    
                    
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.243 -0400", hash_original_method = "6D794A242164C6F60D732256A15CB380", hash_generated_method = "36404021573A4A3149DD19CFFB6E42A2")
    public String simpleQueryForString() {
        try 
        {
            long timeStart = acquireAndLock(READ);
            String retValue = native_1x1_string();
            mDatabase.logTimeStat(mSql, timeStart);
String var8A3AE42CF4D96FEAF203C6E7E2606E2D_895846895 =             retValue;
            var8A3AE42CF4D96FEAF203C6E7E2606E2D_895846895.addTaint(taint);
            return var8A3AE42CF4D96FEAF203C6E7E2606E2D_895846895;
        } 
        catch (SQLiteDoneException e)
        {
            SQLiteDoneException var509C73A4243220CC3BCDEFBCB7C17A34_1021023761 = new SQLiteDoneException(
                    "expected 1 row from this query but query returned no data. check the query: " +
                    mSql);
            var509C73A4243220CC3BCDEFBCB7C17A34_1021023761.addTaint(taint);
            throw var509C73A4243220CC3BCDEFBCB7C17A34_1021023761;
        } 
        finally 
        {
            releaseAndUnlock();
        } 
        
        
            
            
            
            
        
            
                    
                    
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.244 -0400", hash_original_method = "6321C559FCE18D31DAAE4496BAD49A23", hash_generated_method = "8A0B666AB9DC48E5B332BA53468D187E")
    public ParcelFileDescriptor simpleQueryForBlobFileDescriptor() {
        try 
        {
            long timeStart = acquireAndLock(READ);
            ParcelFileDescriptor retValue = native_1x1_blob_ashmem();
            mDatabase.logTimeStat(mSql, timeStart);
ParcelFileDescriptor var8A3AE42CF4D96FEAF203C6E7E2606E2D_244972297 =             retValue;
            var8A3AE42CF4D96FEAF203C6E7E2606E2D_244972297.addTaint(taint);
            return var8A3AE42CF4D96FEAF203C6E7E2606E2D_244972297;
        } 
        catch (IOException ex)
        {
ParcelFileDescriptor var540C13E9E156B687226421B24F2DF178_1582818766 =             null;
            var540C13E9E156B687226421B24F2DF178_1582818766.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1582818766;
        } 
        catch (SQLiteDoneException e)
        {
            SQLiteDoneException var509C73A4243220CC3BCDEFBCB7C17A34_1203541278 = new SQLiteDoneException(
                    "expected 1 row from this query but query returned no data. check the query: " +
                    mSql);
            var509C73A4243220CC3BCDEFBCB7C17A34_1203541278.addTaint(taint);
            throw var509C73A4243220CC3BCDEFBCB7C17A34_1203541278;
        } 
        finally 
        {
            releaseAndUnlock();
        } 
        
        
            
            
            
            
        
            
            
        
            
                    
                    
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.248 -0400", hash_original_method = "7802DA1EF14C1A6C860FAB64147EEA65", hash_generated_method = "71B62A23A7A20266C9476A7BEA158EDB")
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
        } 
        else
        {
            BlockGuard.getThreadPolicy().onReadFromDisk();
        } 
    if((mStatementType & SQLiteProgram.STATEMENT_TYPE_MASK) == DatabaseUtils.STATEMENT_BEGIN)        
        {
    if(!mDatabase.isDbLockedByCurrentThread())            
            {
                mDatabase.setTransactionUsingExecSqlFlag();
            } 
        } 
        else
    if((mStatementType & SQLiteProgram.STATEMENT_TYPE_MASK) ==
                DatabaseUtils.STATEMENT_UPDATE)        
        {
    if(!mDatabase.inTransaction())            
            {
                mDatabase.beginTransactionNonExclusive();
                mState = TRANS_STARTED;
            } 
        } 
    if(!mDatabase.isDbLockedByCurrentThread())        
        {
            mDatabase.lock(mSql);
            mState = LOCK_ACQUIRED;
        } 
        acquireReference();
        long startTime = SystemClock.uptimeMillis();
        mDatabase.closePendingStatements();
        compileAndbindAllArgs();
        long var5B2A579F62087D17D79CE59F3DE5F6D1_86309918 = (startTime);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_142701683 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_142701683;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.250 -0400", hash_original_method = "3195EF2C5595E73848E74AA3B0A84A6E", hash_generated_method = "C21D6BAFEEFA8F70ABEAE73AF2467CE1")
    private void releaseAndUnlock() {
        releaseReference();
    if(mState == TRANS_STARTED)        
        {
            try 
            {
                mDatabase.setTransactionSuccessful();
            } 
            finally 
            {
                mDatabase.endTransaction();
            } 
        } 
        else
    if(mState == LOCK_ACQUIRED)        
        {
            mDatabase.unlock();
        } 
    if((mStatementType & SQLiteProgram.STATEMENT_TYPE_MASK) ==
                DatabaseUtils.STATEMENT_COMMIT ||
                (mStatementType & SQLiteProgram.STATEMENT_TYPE_MASK) ==
                DatabaseUtils.STATEMENT_ABORT)        
        {
            mDatabase.resetTransactionUsingExecSqlFlag();
        } 
        clearBindings();
        release();
        mDatabase = mOrigDb;
        setNativeHandle(mDatabase.mNativeHandle);
        
        
        
            
                
            
                
            
        
            
        
        
                
                
                
            
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.251 -0400", hash_original_method = "DA760EA6BB282F82E2B89FD24EBEEAD3", hash_generated_method = "D22467535DBD54E02073230CED389C48")
    private final int native_execute() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1534976588 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1534976588;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.252 -0400", hash_original_method = "8482A8304EDF98FD537E7B2A3BC31388", hash_generated_method = "1F198912B1A556E048011800BAEBBB54")
    private final long native_executeInsert() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_266496733 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_266496733;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.252 -0400", hash_original_method = "FE0D02F573B183DE07F8BDF82793A3EA", hash_generated_method = "E82C83E06D4C70DE856423F7C9573882")
    private final long native_1x1_long() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_236074923 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_236074923;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.900 -0400", hash_original_method = "07DFC0F07DCBF43769548BE4FBA916EE", hash_generated_method = "28030A1C7DC39244AA70D827443E96B9")
    private final String native_1x1_string() {
    	String foo = new String();
    	return foo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.900 -0400", hash_original_method = "D5A94C086543C65F36827FC2C8B73314", hash_generated_method = "2FF5ECD0A356350F1F45EEEF9C01561B")
    private final ParcelFileDescriptor native_1x1_blob_ashmem() throws IOException {
    	return new ParcelFileDescriptor();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.254 -0400", hash_original_method = "BD9AF961A0959F9D5CBC2D8FDDD3B169", hash_generated_method = "D10F7D0B2AF60F2190B0E6B997651F64")
    private final void native_executeSql(String sql) {
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.254 -0400", hash_original_field = "DD19317116B58B00292F949DD2B1E756", hash_generated_field = "B25F6A4CB29F6325E49F04F66EE5886C")

    private static final String TAG = "SQLiteStatement";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.254 -0400", hash_original_field = "05ADA3F1E165472D313D165DAB44A6CC", hash_generated_field = "DF1BFFA8AE77C9EB2467DB4A53480D19")

    private static final boolean READ = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.254 -0400", hash_original_field = "53B6455C8E3B4984E225565A855CEA76", hash_generated_field = "4E20ADB74C14AC29719A4662B74CC6FA")

    private static final boolean WRITE = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.255 -0400", hash_original_field = "61939F59B722807810579AD50EC24088", hash_generated_field = "51E8612B8DBE387C00FDA982510BC3C4")

    private static final int TRANS_STARTED = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.255 -0400", hash_original_field = "A9DDAD52531AA66AF93FF12F9D89A659", hash_generated_field = "8F182F697D081190134825A0E369736C")

    private static final int LOCK_ACQUIRED = 2;
}

