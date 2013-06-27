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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:12.066 -0400", hash_original_field = "E67780D6797A95AA13F04D47887933FA", hash_generated_field = "2F51843A821BD5FB98E893CC1830882F")

    private SQLiteDatabase mOrigDb;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:12.066 -0400", hash_original_field = "48A902C1D749B47EBC75C77370D5A1F0", hash_generated_field = "19B55F2750B971E6310D64ADB9B2D0CF")

    private int mState;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:12.076 -0400", hash_original_method = "5DDFF8C2B7E2F1702052BA1709F992B7", hash_generated_method = "190858F4CED4191728895014C02D6DF1")
      SQLiteStatement(SQLiteDatabase db, String sql, Object[] bindArgs) {
        super(db, sql, bindArgs, false );
        addTaint(db.getTaint());
        addTaint(sql.getTaint());
        addTaint(bindArgs[0].getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:12.076 -0400", hash_original_method = "AF1FDD5D94DA5350C3682852D1772235", hash_generated_method = "9731E3368F2C01BE2CC3A6FD5F2FC446")
    public void execute() {
        executeUpdateDelete();
        // ---------- Original Method ----------
        //executeUpdateDelete();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:12.083 -0400", hash_original_method = "66D9912335771E2036ED62B64CF3BC86", hash_generated_method = "1534FC4391B8360AC5DCEF287CF51157")
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
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_930102764 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_930102764;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:12.087 -0400", hash_original_method = "78D2410201CEBD83C87275DB09AEC8B4", hash_generated_method = "F3E5B90258F486034E0B6C571C6B07F8")
    public long executeInsert() {
        try 
        {
            saveSqlAsLastSqlStatement();
            acquireAndLock(WRITE);
            long var6BAFE9A3CDD3D607224AE3DAB50F7575_837130047 = (native_executeInsert());
        } //End block
        finally 
        {
            releaseAndUnlock();
        } //End block
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1166938159 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1166938159;
        // ---------- Original Method ----------
        //try {
            //saveSqlAsLastSqlStatement();
            //acquireAndLock(WRITE);
            //return native_executeInsert();
        //} finally {
            //releaseAndUnlock();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:12.119 -0400", hash_original_method = "7424F80A42A729003FCB274AD124711E", hash_generated_method = "48903C4E449BC1F2AB6E6660E7AAF1CD")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:12.120 -0400", hash_original_method = "12DB780B550F95E5C10FD5998E83FEFD", hash_generated_method = "165240EF3AA537B63C50963CE8FF8A4E")
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
        long var0F5264038205EDFB1AC05FBB0E8C5E94_923923376 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_923923376;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:12.126 -0400", hash_original_method = "6D794A242164C6F60D732256A15CB380", hash_generated_method = "954D73DC59505B0962FE5A07D0337644")
    public String simpleQueryForString() {
        String varB4EAC82CA7396A68D541C85D26508E83_232556767 = null; //Variable for return #1
        try 
        {
            long timeStart;
            timeStart = acquireAndLock(READ);
            String retValue;
            retValue = native_1x1_string();
            mDatabase.logTimeStat(mSql, timeStart);
            varB4EAC82CA7396A68D541C85D26508E83_232556767 = retValue;
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
        varB4EAC82CA7396A68D541C85D26508E83_232556767.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_232556767;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:12.142 -0400", hash_original_method = "6321C559FCE18D31DAAE4496BAD49A23", hash_generated_method = "D7A565D02570BC7EE5B1E15E2513074A")
    public ParcelFileDescriptor simpleQueryForBlobFileDescriptor() {
        ParcelFileDescriptor varB4EAC82CA7396A68D541C85D26508E83_1843229925 = null; //Variable for return #1
        ParcelFileDescriptor varB4EAC82CA7396A68D541C85D26508E83_1357861141 = null; //Variable for return #2
        try 
        {
            long timeStart;
            timeStart = acquireAndLock(READ);
            ParcelFileDescriptor retValue;
            retValue = native_1x1_blob_ashmem();
            mDatabase.logTimeStat(mSql, timeStart);
            varB4EAC82CA7396A68D541C85D26508E83_1843229925 = retValue;
        } //End block
        catch (IOException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1357861141 = null;
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
        ParcelFileDescriptor varA7E53CE21691AB073D9660D615818899_865317762; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_865317762 = varB4EAC82CA7396A68D541C85D26508E83_1843229925;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_865317762 = varB4EAC82CA7396A68D541C85D26508E83_1357861141;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_865317762.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_865317762;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:12.162 -0400", hash_original_method = "7802DA1EF14C1A6C860FAB64147EEA65", hash_generated_method = "28B8C0F35182A6568C19D1F4AB09B44E")
    private long acquireAndLock(boolean rwFlag) {
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
                boolean var097D1FF015F3B6F2369065167A2F156B_1285956749 = (!mDatabase.isDbLockedByCurrentThread());
                {
                    mDatabase.setTransactionUsingExecSqlFlag();
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                boolean var37036F713C62CC107A333C2F5C92276E_1505716428 = (!mDatabase.inTransaction());
                {
                    mDatabase.beginTransactionNonExclusive();
                    mState = TRANS_STARTED;
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            boolean var13D935343B6F3D3934E3A49ACF169DA9_175123801 = (!mDatabase.isDbLockedByCurrentThread());
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
        addTaint(rwFlag);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1643321660 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1643321660;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:12.182 -0400", hash_original_method = "3195EF2C5595E73848E74AA3B0A84A6E", hash_generated_method = "0B213DBB94FF0232F335C3289B944420")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:12.183 -0400", hash_original_method = "DA760EA6BB282F82E2B89FD24EBEEAD3", hash_generated_method = "99E66A240B2D09D23908284472142017")
    private final int native_execute() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_854513717 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_854513717;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:12.183 -0400", hash_original_method = "8482A8304EDF98FD537E7B2A3BC31388", hash_generated_method = "565793CF4C30FF483B94A75C248F10B4")
    private final long native_executeInsert() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1353908403 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1353908403;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:12.183 -0400", hash_original_method = "FE0D02F573B183DE07F8BDF82793A3EA", hash_generated_method = "3A0633CE19B9066817411C067897D27A")
    private final long native_1x1_long() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1357211795 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1357211795;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:12.193 -0400", hash_original_method = "07DFC0F07DCBF43769548BE4FBA916EE", hash_generated_method = "28030A1C7DC39244AA70D827443E96B9")
    private final String native_1x1_string() {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:12.193 -0400", hash_original_method = "D5A94C086543C65F36827FC2C8B73314", hash_generated_method = "2FF5ECD0A356350F1F45EEEF9C01561B")
    private final ParcelFileDescriptor native_1x1_blob_ashmem() throws IOException {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:12.193 -0400", hash_original_method = "BD9AF961A0959F9D5CBC2D8FDDD3B169", hash_generated_method = "D10F7D0B2AF60F2190B0E6B997651F64")
    private final void native_executeSql(String sql) {
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:12.193 -0400", hash_original_field = "DD19317116B58B00292F949DD2B1E756", hash_generated_field = "7E076C09713F8062AEF23851659CDD8E")

    private static String TAG = "SQLiteStatement";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:12.194 -0400", hash_original_field = "05ADA3F1E165472D313D165DAB44A6CC", hash_generated_field = "0C54E03DE23DB2EF34B0F2C22F5DE1FE")

    private static boolean READ = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:12.194 -0400", hash_original_field = "53B6455C8E3B4984E225565A855CEA76", hash_generated_field = "24F95564C02D32C554F943A9A00CFB76")

    private static boolean WRITE = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:12.194 -0400", hash_original_field = "61939F59B722807810579AD50EC24088", hash_generated_field = "5E5CAB7E18BF9EC7647CDE36E0C83AA1")

    private static int TRANS_STARTED = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:12.194 -0400", hash_original_field = "A9DDAD52531AA66AF93FF12F9D89A659", hash_generated_field = "C655C54DA93F5071C5CAD973A0FD4DBB")

    private static int LOCK_ACQUIRED = 2;
}

