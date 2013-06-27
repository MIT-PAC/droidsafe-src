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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.503 -0400", hash_original_field = "E67780D6797A95AA13F04D47887933FA", hash_generated_field = "2F51843A821BD5FB98E893CC1830882F")

    private SQLiteDatabase mOrigDb;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.508 -0400", hash_original_field = "48A902C1D749B47EBC75C77370D5A1F0", hash_generated_field = "19B55F2750B971E6310D64ADB9B2D0CF")

    private int mState;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.509 -0400", hash_original_method = "5DDFF8C2B7E2F1702052BA1709F992B7", hash_generated_method = "190858F4CED4191728895014C02D6DF1")
      SQLiteStatement(SQLiteDatabase db, String sql, Object[] bindArgs) {
        super(db, sql, bindArgs, false );
        addTaint(db.getTaint());
        addTaint(sql.getTaint());
        addTaint(bindArgs[0].getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.509 -0400", hash_original_method = "AF1FDD5D94DA5350C3682852D1772235", hash_generated_method = "9731E3368F2C01BE2CC3A6FD5F2FC446")
    public void execute() {
        executeUpdateDelete();
        // ---------- Original Method ----------
        //executeUpdateDelete();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.521 -0400", hash_original_method = "66D9912335771E2036ED62B64CF3BC86", hash_generated_method = "2DC174B20D70E0F11D2CA148F7F90C39")
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
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1259294218 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1259294218;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.531 -0400", hash_original_method = "78D2410201CEBD83C87275DB09AEC8B4", hash_generated_method = "B55EF0F8E381B6711027C068C3582688")
    public long executeInsert() {
        try 
        {
            saveSqlAsLastSqlStatement();
            acquireAndLock(WRITE);
            long var6BAFE9A3CDD3D607224AE3DAB50F7575_1852004370 = (native_executeInsert());
        } //End block
        finally 
        {
            releaseAndUnlock();
        } //End block
        long var0F5264038205EDFB1AC05FBB0E8C5E94_200394614 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_200394614;
        // ---------- Original Method ----------
        //try {
            //saveSqlAsLastSqlStatement();
            //acquireAndLock(WRITE);
            //return native_executeInsert();
        //} finally {
            //releaseAndUnlock();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.536 -0400", hash_original_method = "7424F80A42A729003FCB274AD124711E", hash_generated_method = "48903C4E449BC1F2AB6E6660E7AAF1CD")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.536 -0400", hash_original_method = "12DB780B550F95E5C10FD5998E83FEFD", hash_generated_method = "9CD3BBC3B6DA43815D91A3E3548042B6")
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
        long var0F5264038205EDFB1AC05FBB0E8C5E94_296402151 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_296402151;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.540 -0400", hash_original_method = "6D794A242164C6F60D732256A15CB380", hash_generated_method = "DC4567C232930C749B0115B1F4A8D5BA")
    public String simpleQueryForString() {
        String varB4EAC82CA7396A68D541C85D26508E83_601500094 = null; //Variable for return #1
        try 
        {
            long timeStart;
            timeStart = acquireAndLock(READ);
            String retValue;
            retValue = native_1x1_string();
            mDatabase.logTimeStat(mSql, timeStart);
            varB4EAC82CA7396A68D541C85D26508E83_601500094 = retValue;
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
        varB4EAC82CA7396A68D541C85D26508E83_601500094.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_601500094;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.559 -0400", hash_original_method = "6321C559FCE18D31DAAE4496BAD49A23", hash_generated_method = "E197CA2020CB88058AEB3F3CA2E2EDEF")
    public ParcelFileDescriptor simpleQueryForBlobFileDescriptor() {
        ParcelFileDescriptor varB4EAC82CA7396A68D541C85D26508E83_1903741469 = null; //Variable for return #1
        ParcelFileDescriptor varB4EAC82CA7396A68D541C85D26508E83_1162417755 = null; //Variable for return #2
        try 
        {
            long timeStart;
            timeStart = acquireAndLock(READ);
            ParcelFileDescriptor retValue;
            retValue = native_1x1_blob_ashmem();
            mDatabase.logTimeStat(mSql, timeStart);
            varB4EAC82CA7396A68D541C85D26508E83_1903741469 = retValue;
        } //End block
        catch (IOException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1162417755 = null;
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
        ParcelFileDescriptor varA7E53CE21691AB073D9660D615818899_1473321750; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1473321750 = varB4EAC82CA7396A68D541C85D26508E83_1903741469;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1473321750 = varB4EAC82CA7396A68D541C85D26508E83_1162417755;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1473321750.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1473321750;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.589 -0400", hash_original_method = "7802DA1EF14C1A6C860FAB64147EEA65", hash_generated_method = "8B9A8CF452E19309E350A3C1E0C5C22F")
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
                boolean var097D1FF015F3B6F2369065167A2F156B_1175667189 = (!mDatabase.isDbLockedByCurrentThread());
                {
                    mDatabase.setTransactionUsingExecSqlFlag();
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                boolean var37036F713C62CC107A333C2F5C92276E_1064457903 = (!mDatabase.inTransaction());
                {
                    mDatabase.beginTransactionNonExclusive();
                    mState = TRANS_STARTED;
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            boolean var13D935343B6F3D3934E3A49ACF169DA9_1196432496 = (!mDatabase.isDbLockedByCurrentThread());
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
        long var0F5264038205EDFB1AC05FBB0E8C5E94_543151561 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_543151561;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.592 -0400", hash_original_method = "3195EF2C5595E73848E74AA3B0A84A6E", hash_generated_method = "0B213DBB94FF0232F335C3289B944420")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.593 -0400", hash_original_method = "DA760EA6BB282F82E2B89FD24EBEEAD3", hash_generated_method = "FB6705AFAD89E2D50C4FFAF9B66ED5B9")
    private final int native_execute() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_966153265 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_966153265;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.610 -0400", hash_original_method = "8482A8304EDF98FD537E7B2A3BC31388", hash_generated_method = "D64DF6D9E3580007C22F24893DC2C91B")
    private final long native_executeInsert() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1801691484 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1801691484;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.611 -0400", hash_original_method = "FE0D02F573B183DE07F8BDF82793A3EA", hash_generated_method = "B07A4E97CA66DA97822FEB3D332F4EFB")
    private final long native_1x1_long() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_25632228 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_25632228;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.611 -0400", hash_original_method = "07DFC0F07DCBF43769548BE4FBA916EE", hash_generated_method = "28030A1C7DC39244AA70D827443E96B9")
    private final String native_1x1_string() {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.611 -0400", hash_original_method = "D5A94C086543C65F36827FC2C8B73314", hash_generated_method = "2FF5ECD0A356350F1F45EEEF9C01561B")
    private final ParcelFileDescriptor native_1x1_blob_ashmem() throws IOException {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.612 -0400", hash_original_method = "BD9AF961A0959F9D5CBC2D8FDDD3B169", hash_generated_method = "D10F7D0B2AF60F2190B0E6B997651F64")
    private final void native_executeSql(String sql) {
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.612 -0400", hash_original_field = "DD19317116B58B00292F949DD2B1E756", hash_generated_field = "7E076C09713F8062AEF23851659CDD8E")

    private static String TAG = "SQLiteStatement";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.612 -0400", hash_original_field = "05ADA3F1E165472D313D165DAB44A6CC", hash_generated_field = "0C54E03DE23DB2EF34B0F2C22F5DE1FE")

    private static boolean READ = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.612 -0400", hash_original_field = "53B6455C8E3B4984E225565A855CEA76", hash_generated_field = "24F95564C02D32C554F943A9A00CFB76")

    private static boolean WRITE = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.612 -0400", hash_original_field = "61939F59B722807810579AD50EC24088", hash_generated_field = "5E5CAB7E18BF9EC7647CDE36E0C83AA1")

    private static int TRANS_STARTED = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.612 -0400", hash_original_field = "A9DDAD52531AA66AF93FF12F9D89A659", hash_generated_field = "C655C54DA93F5071C5CAD973A0FD4DBB")

    private static int LOCK_ACQUIRED = 2;
}

