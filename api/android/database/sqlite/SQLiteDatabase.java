package android.database.sqlite;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Pattern;

import android.app.AppGlobals;
import android.content.ContentValues;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.DatabaseUtils;
import android.database.DefaultDatabaseErrorHandler;
import android.database.SQLException;
import android.database.sqlite.SQLiteDebug.DbStats;
import android.os.Debug;
import android.os.StatFs;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.text.TextUtils;
import android.util.EventLog;
import android.util.Log;
import android.util.LruCache;
import android.util.Pair;
import dalvik.system.BlockGuard;




import droidsafe.helpers.DSUtils;

public class SQLiteDatabase extends SQLiteClosable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.531 -0400", hash_original_field = "2F577CFF36E03467323CF3302EA45D6C", hash_generated_field = "E7056D75F4E4E6EB0CBA6DCE1F4F880B")

    private boolean mInnerTransactionIsSuccessful;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.531 -0400", hash_original_field = "58201914BA1B4FF47E7AA07A0AC57171", hash_generated_field = "6128EACBB7FB1B535A59BE78E36968AA")

    private boolean mTransactionIsSuccessful;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.531 -0400", hash_original_field = "DE7B86B82681B1155E0009C050CFB43B", hash_generated_field = "793A3AAAFBEB0F437207EF8CF58BE261")

    private SQLiteTransactionListener mTransactionListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.531 -0400", hash_original_field = "04FD74AF5748E24AC35D8C0603418D5F", hash_generated_field = "2A25F85A83E5F358C0E921DE63F86FF2")

    private boolean mTransactionUsingExecSql;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.531 -0400", hash_original_field = "F4A7BA9A35E5B32B183DF50E4F1B2E28", hash_generated_field = "F912814B4E1DAAFDC17C50234EB3FC06")

    private final DatabaseReentrantLock mLock = new DatabaseReentrantLock(true);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.531 -0400", hash_original_field = "2B698D4C503D685ED004A6B4BAF0E658", hash_generated_field = "D440BCD52A102185E811EA93A644CB1C")

    private long mLockAcquiredWallTime = 0L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.532 -0400", hash_original_field = "05E26C9ECB3EBA196676EBEDA0B25BCF", hash_generated_field = "F25F6124FA463B622FD2DD5ABA3051C7")

    private long mLockAcquiredThreadTime = 0L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.532 -0400", hash_original_field = "0804BE3D194F1641DC0D1E5AE35F40C1", hash_generated_field = "5D29D9D368D28B86CEE0F5B707514CDA")

    private long mLastLockMessageTime = 0L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.532 -0400", hash_original_field = "536255EED7E3D46DD70E09FDE814B7C1", hash_generated_field = "E26D41E197237C24B0E74C0394AEDF83")

    private final Random mRandom = new Random();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.532 -0400", hash_original_field = "20ED2B28EBE0BAD29D7FEAFD9AF86FC5", hash_generated_field = "1CE2C34780F47FA064A655A949D3653C")

    private String mLastSqlStatement = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.532 -0400", hash_original_field = "E494CEFBB739C03E3C976C715E226811", hash_generated_field = "4ED7543F27609F494F3BFF9473206AD9")

    private long mTransStartTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.532 -0400", hash_original_field = "E86FCFA606742ADBAB1B20F7996FCC4A", hash_generated_field = "B37C03DF0BF1A86153C7C2FA952C3E00")

    volatile int mNativeHandle = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.532 -0400", hash_original_field = "FB4FCB3508FC66D4E3F113990AC335C6", hash_generated_field = "6FACC3B41470C8330B5F0BB43FA7FD9F")

    private String mPath;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.532 -0400", hash_original_field = "5CC96EA0C7233DAE6629EB63E2D17046", hash_generated_field = "0FAF2BD49EE9B945E5C01C36BBE76EC3")

    private String mPathForLogs = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.532 -0400", hash_original_field = "9C3CD7D37D3E1E66BE9B3B005FC98B3A", hash_generated_field = "43F71E9173849705E01112D0229448B4")

    private int mFlags;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.532 -0400", hash_original_field = "06389DE86ED19AB1571A41645A1AFADC", hash_generated_field = "3B314DD3362D9759017A383358149E45")

    private CursorFactory mFactory;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.532 -0400", hash_original_field = "712AB6C8C770AEF7CF757D19A4FD0E38", hash_generated_field = "7586811E7431EEE33AF976CF89950239")

    private WeakHashMap<SQLiteClosable, Object> mPrograms;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.533 -0400", hash_original_field = "60E07EDA42F3E1922C63D09AD9383086", hash_generated_field = "B49BE5C26AFC2BC39563929C5F16CB5B")

    private LruCache<String, SQLiteCompiledSql> mCompiledQueries;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.533 -0400", hash_original_field = "F6246ADED535BB5A06E89B98F4448AB0", hash_generated_field = "4E5EC633EDC17753869972551C767C68")

    private boolean mCacheFullWarning;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.533 -0400", hash_original_field = "9581B90EA40AE59A20069CB826265080", hash_generated_field = "7D1AA4359A52B133BFAD994AB60E8C14")

    private Throwable mStackTrace;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.533 -0400", hash_original_field = "8103C9EA0927CDF9D803AF1FFEC26BE1", hash_generated_field = "0D9B8E09B51F96D0F503825B2DDED11B")

    private final ArrayList<Integer> mClosedStatementIds = new ArrayList<Integer>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.533 -0400", hash_original_field = "17F47A6FF3D481E01A6A82252EB7B064", hash_generated_field = "76DD5A0A5A09A890A2237FBF965CCF6C")

    private DatabaseErrorHandler mErrorHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.533 -0400", hash_original_field = "7A6BE8614B7E2A423C6F53496DF6BA29", hash_generated_field = "C4D2A249F5C70FA118DDA6CA9913AA66")

    volatile DatabaseConnectionPool mConnectionPool = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.533 -0400", hash_original_field = "606D462EAF936BEF827280E106823795", hash_generated_field = "38AABF491E6B9AC2F1FDAC5FCB6A30E7")

    short mConnectionNum;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.533 -0400", hash_original_field = "2752BF6ACAFADFCCDA452687FCF2CED4", hash_generated_field = "4A262DC52D3676F75324E8DD3283FF83")

    SQLiteDatabase mParentConnObj = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.533 -0400", hash_original_field = "63C6D7999E4974E970EC9568F93B0B54", hash_generated_field = "760D925FEAB058AF61B1B94D2C774DE6")

    private volatile boolean mHasAttachedDbs = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.533 -0400", hash_original_field = "34BA12267248F06139E7DE34F0AE6051", hash_generated_field = "560D9A0D28C1D8056EAB428EF4EA40FE")

    private boolean mLockingEnabled = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.534 -0400", hash_original_field = "51484C5CAD4631F0A71FAFC0D9435C9A", hash_generated_field = "BCE91343C41461430195125FEC2F1572")

    private final ArrayList<Integer> mCustomFunctions = new ArrayList<Integer>();
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.536 -0400", hash_original_method = "ED994C20AB51232E6F0B83AA0494CFAA", hash_generated_method = "379F4686F5BBA9E0C91C6A2E8EA0C809")
    private  SQLiteDatabase(String path, CursorFactory factory, int flags,
            DatabaseErrorHandler errorHandler, short connectionNum) {
        if(path == null)        
        {
            IllegalArgumentException varE4C91A561B864CD4490A03B12C2E1BD5_1723494487 = new IllegalArgumentException("path should not be null");
            varE4C91A561B864CD4490A03B12C2E1BD5_1723494487.addTaint(taint);
            throw varE4C91A561B864CD4490A03B12C2E1BD5_1723494487;
        } //End block
        setMaxSqlCacheSize(DEFAULT_SQL_CACHE_SIZE);
        mFlags = flags;
        mPath = path;
        mStackTrace = new DatabaseObjectNotClosedException().fillInStackTrace();
        mFactory = factory;
        mPrograms = new WeakHashMap<SQLiteClosable,Object>();
        mErrorHandler = (errorHandler == null) ? new DefaultDatabaseErrorHandler() : errorHandler;
        mConnectionNum = connectionNum;
        int limit = Resources.getSystem().getInteger(
                com.android.internal.R.integer.config_cursorWindowSize) * 1024 * 4;
        native_setSqliteSoftHeapLimit(limit);
        // ---------- Original Method ----------
        //if (path == null) {
            //throw new IllegalArgumentException("path should not be null");
        //}
        //setMaxSqlCacheSize(DEFAULT_SQL_CACHE_SIZE);
        //mFlags = flags;
        //mPath = path;
        //mStackTrace = new DatabaseObjectNotClosedException().fillInStackTrace();
        //mFactory = factory;
        //mPrograms = new WeakHashMap<SQLiteClosable,Object>();
        //mErrorHandler = (errorHandler == null) ? new DefaultDatabaseErrorHandler() : errorHandler;
        //mConnectionNum = connectionNum;
        //int limit = Resources.getSystem().getInteger(
                //com.android.internal.R.integer.config_cursorWindowSize) * 1024 * 4;
        //native_setSqliteSoftHeapLimit(limit);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.538 -0400", hash_original_method = "C15F9F532AF7810AA7D3562C5DDE29F6", hash_generated_method = "AACCC54FA825017EE5E8B55F72D7DCDE")
    synchronized String getLastSqlStatement() {
String varE4FE602774BCA440409AAE6EFE27003F_1972529260 =         mLastSqlStatement;
        varE4FE602774BCA440409AAE6EFE27003F_1972529260.addTaint(taint);
        return varE4FE602774BCA440409AAE6EFE27003F_1972529260;
        // ---------- Original Method ----------
        //return mLastSqlStatement;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.538 -0400", hash_original_method = "3743AC991024775005FDBE1593E9891E", hash_generated_method = "77D67C706792A5CD082ECBF7B819ED3C")
    synchronized void setLastSqlStatement(String sql) {
        mLastSqlStatement = sql;
        // ---------- Original Method ----------
        //mLastSqlStatement = sql;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.539 -0400", hash_original_method = "FF36C1ABFEC0F5F1C3DFBA7FD0941B56", hash_generated_method = "E173484620D1EBE1401A8327F3ED18B3")
    synchronized void addSQLiteClosable(SQLiteClosable closable) {
        addTaint(closable.getTaint());
        mPrograms.put(closable, null);
        // ---------- Original Method ----------
        //mPrograms.put(closable, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.539 -0400", hash_original_method = "030B4AA23DD4EAEE65D260C86C2A8B4C", hash_generated_method = "508DB4907A0E2C8460B8C68D5D97D7A3")
    synchronized void removeSQLiteClosable(SQLiteClosable closable) {
        addTaint(closable.getTaint());
        mPrograms.remove(closable);
        // ---------- Original Method ----------
        //mPrograms.remove(closable);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.541 -0400", hash_original_method = "29F441CF35047DF9CBB0BC7BF2B03F36", hash_generated_method = "35CD296C0522C997A69A33875E230D54")
    @Override
    protected void onAllReferencesReleased() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        if(isOpen())        
        {
            close();
        } //End block
        // ---------- Original Method ----------
        //if (isOpen()) {
            //close();
        //}
    }

    
    @DSModeled(DSC.SAFE)
    static public int releaseMemory() {
        return DSUtils.UNKNOWN_INT;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.541 -0400", hash_original_method = "CD58BEDD0347A27F6CFE4EB9BEFDF2F6", hash_generated_method = "A1146177C8FA9BB90B6D94105F882124")
    public void setLockingEnabled(boolean lockingEnabled) {
        mLockingEnabled = lockingEnabled;
        // ---------- Original Method ----------
        //mLockingEnabled = lockingEnabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.542 -0400", hash_original_method = "6F1C3BA1763F74F7C0395D958A12A363", hash_generated_method = "3EE5C6657C638478CD9F042AD044BF04")
     void onCorruption() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        EventLog.writeEvent(EVENT_DB_CORRUPT, mPath);
        mErrorHandler.onCorruption(this);
        // ---------- Original Method ----------
        //EventLog.writeEvent(EVENT_DB_CORRUPT, mPath);
        //mErrorHandler.onCorruption(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.543 -0400", hash_original_method = "6F6099DC841EA0266005BC3A83B18A96", hash_generated_method = "2A987EE7CB3E0BFCE2CF75EBB4A3F7FF")
     void lock(String sql) {
        addTaint(sql.getTaint());
        lock(sql, false);
        // ---------- Original Method ----------
        //lock(sql, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.543 -0400", hash_original_method = "8D6DAA6963637C0BD50884518E0FF993", hash_generated_method = "31DA195A8CACA429F53CC674AB87F7FD")
     void lock() {
        lock(null, false);
        // ---------- Original Method ----------
        //lock(null, false);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.544 -0400", hash_original_method = "550218B4AE04D143508369398336F95D", hash_generated_method = "E2070B94C1CF03D4ABE3B501D68A397F")
    private void lock(String sql, boolean forced) {
        addTaint(forced);
        addTaint(sql.getTaint());
        if(Thread.holdsLock(this))        
        {
        } //End block
        verifyDbIsOpen();
        if(!forced && !mLockingEnabled)        
        return;
        boolean done = false;
        long timeStart = SystemClock.uptimeMillis();
        while
(!done)        
        {
            try 
            {
                done = mLock.tryLock(LOCK_WAIT_PERIOD, TimeUnit.SECONDS);
                if(!done)                
                {
                } //End block
            } //End block
            catch (InterruptedException e)
            {
            } //End block
        } //End block
        if(SQLiteDebug.DEBUG_LOCK_TIME_TRACKING)        
        {
            if(mLock.getHoldCount() == 1)            
            {
                mLockAcquiredWallTime = SystemClock.elapsedRealtime();
                mLockAcquiredThreadTime = Debug.threadCpuTimeNanos();
            } //End block
        } //End block
        if(sql != null)        
        {
            if(ENABLE_DB_SAMPLE)            
            {
                logTimeStat(sql, timeStart, GET_LOCK_LOG_PREFIX);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.546 -0400", hash_original_method = "5F1F87633E052520A24DBAD554D491B1", hash_generated_method = "993B0F3F2A36649E79B8CF2BDCBA15D6")
    private void lockForced() {
        lock(null, true);
        // ---------- Original Method ----------
        //lock(null, true);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.547 -0400", hash_original_method = "E1FDB470EFF9EA86A5AAC7A627D6955E", hash_generated_method = "ACD2EB13EBB76DCBE987B683DD561C5A")
    private void lockForced(String sql) {
        addTaint(sql.getTaint());
        lock(sql, true);
        // ---------- Original Method ----------
        //lock(sql, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.547 -0400", hash_original_method = "CB05AAFAB101AFFDD598174816C61BF7", hash_generated_method = "454B48A9532576C534C73BFE34BC80FF")
     void unlock() {
        if(!mLockingEnabled)        
        return;
        if(SQLiteDebug.DEBUG_LOCK_TIME_TRACKING)        
        {
            if(mLock.getHoldCount() == 1)            
            {
                checkLockHoldTime();
            } //End block
        } //End block
        mLock.unlock();
        // ---------- Original Method ----------
        //if (!mLockingEnabled) return;
        //if (SQLiteDebug.DEBUG_LOCK_TIME_TRACKING) {
            //if (mLock.getHoldCount() == 1) {
                //checkLockHoldTime();
            //}
        //}
        //mLock.unlock();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.548 -0400", hash_original_method = "CA4E01B405088BC736DA3EA88D772AB0", hash_generated_method = "769FD397AA376FB38817C9515F1DC456")
    private void unlockForced() {
        if(SQLiteDebug.DEBUG_LOCK_TIME_TRACKING)        
        {
            if(mLock.getHoldCount() == 1)            
            {
                checkLockHoldTime();
            } //End block
        } //End block
        mLock.unlock();
        // ---------- Original Method ----------
        //if (SQLiteDebug.DEBUG_LOCK_TIME_TRACKING) {
            //if (mLock.getHoldCount() == 1) {
                //checkLockHoldTime();
            //}
        //}
        //mLock.unlock();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.550 -0400", hash_original_method = "15FB67C6B55CF4F17EB9E05703E68C1A", hash_generated_method = "5964F5AD026B7D783FE36D8E6F77CD03")
    private void checkLockHoldTime() {
        long elapsedTime = SystemClock.elapsedRealtime();
        long lockedTime = elapsedTime - mLockAcquiredWallTime;
        if(lockedTime < LOCK_ACQUIRED_WARNING_TIME_IN_MS_ALWAYS_PRINT &&
                !Log.isLoggable(TAG, Log.VERBOSE) &&
                (elapsedTime - mLastLockMessageTime) < LOCK_WARNING_WINDOW_IN_MS)        
        {
            return;
        } //End block
        if(lockedTime > LOCK_ACQUIRED_WARNING_TIME_IN_MS)        
        {
            int threadTime = (int)
                    ((Debug.threadCpuTimeNanos() - mLockAcquiredThreadTime) / 1000000);
            if(threadTime > LOCK_ACQUIRED_WARNING_THREAD_TIME_IN_MS ||
                    lockedTime > LOCK_ACQUIRED_WARNING_TIME_IN_MS_ALWAYS_PRINT)            
            {
                mLastLockMessageTime = elapsedTime;
                String msg = "lock held on " + mPath + " for " + lockedTime + "ms. Thread time was "
                        + threadTime + "ms";
                if(SQLiteDebug.DEBUG_LOCK_TIME_TRACKING_STACK_TRACE)                
                {
                    Log.d(TAG, msg, new Exception());
                } //End block
                else
                {
                    Log.d(TAG, msg);
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.552 -0400", hash_original_method = "36B8D50340D02900F098E44F066CFF12", hash_generated_method = "145909AA25037E1D599C021529CE7F8B")
    public void beginTransaction() {
        beginTransaction(null , true);
        // ---------- Original Method ----------
        //beginTransaction(null , true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.553 -0400", hash_original_method = "E00D9BE9F4C6FCF885F8A6933F83E5B2", hash_generated_method = "00651A551214FF436836A41E2DCE0672")
    public void beginTransactionNonExclusive() {
        beginTransaction(null , false);
        // ---------- Original Method ----------
        //beginTransaction(null , false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.553 -0400", hash_original_method = "5BD04E9A01CA28B4B773A517F832DDF2", hash_generated_method = "343BCBE92101E138E11B3797B0664CBA")
    public void beginTransactionWithListener(SQLiteTransactionListener transactionListener) {
        addTaint(transactionListener.getTaint());
        beginTransaction(transactionListener, true);
        // ---------- Original Method ----------
        //beginTransaction(transactionListener, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.554 -0400", hash_original_method = "EB4000007896884F9C35346C5F5B9337", hash_generated_method = "04B944DB3F1AF23170795845FA857B22")
    public void beginTransactionWithListenerNonExclusive(
            SQLiteTransactionListener transactionListener) {
        addTaint(transactionListener.getTaint());
        beginTransaction(transactionListener, false);
        // ---------- Original Method ----------
        //beginTransaction(transactionListener, false);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.556 -0400", hash_original_method = "65C15EF02A1263C4153105EBF58851D9", hash_generated_method = "5AE1A42D6C38D809C10759CABD7323C5")
    private void beginTransaction(SQLiteTransactionListener transactionListener,
            boolean exclusive) {
        addTaint(exclusive);
        verifyDbIsOpen();
        lockForced(BEGIN_SQL);
        boolean ok = false;
        try 
        {
            if(mLock.getHoldCount() > 1)            
            {
                if(mInnerTransactionIsSuccessful)                
                {
                    String msg = "Cannot call beginTransaction between "
                            + "calling setTransactionSuccessful and endTransaction";
                    IllegalStateException e = new IllegalStateException(msg);
                    e.addTaint(taint);
                    throw e;
                } //End block
                ok = true;
                return;
            } //End block
            if(exclusive && mConnectionPool == null)            
            {
                execSQL("BEGIN EXCLUSIVE;");
            } //End block
            else
            {
                execSQL("BEGIN IMMEDIATE;");
            } //End block
            mTransStartTime = SystemClock.uptimeMillis();
            mTransactionListener = transactionListener;
            mTransactionIsSuccessful = true;
            mInnerTransactionIsSuccessful = false;
            if(transactionListener != null)            
            {
                try 
                {
                    transactionListener.onBegin();
                } //End block
                catch (RuntimeException e)
                {
                    execSQL("ROLLBACK;");
                    e.addTaint(taint);
                    throw e;
                } //End block
            } //End block
            ok = true;
        } //End block
        finally 
        {
            if(!ok)            
            {
                unlockForced();
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.560 -0400", hash_original_method = "94F2931FC5A304B6FE8748C95A17E4E3", hash_generated_method = "18972CF8F2B78E5998666946BBD18F06")
    public void endTransaction() {
        verifyLockOwner();
        try 
        {
            if(mInnerTransactionIsSuccessful)            
            {
                mInnerTransactionIsSuccessful = false;
            } //End block
            else
            {
                mTransactionIsSuccessful = false;
            } //End block
            if(mLock.getHoldCount() != 1)            
            {
                return;
            } //End block
            RuntimeException savedException = null;
            if(mTransactionListener != null)            
            {
                try 
                {
                    if(mTransactionIsSuccessful)                    
                    {
                        mTransactionListener.onCommit();
                    } //End block
                    else
                    {
                        mTransactionListener.onRollback();
                    } //End block
                } //End block
                catch (RuntimeException e)
                {
                    savedException = e;
                    mTransactionIsSuccessful = false;
                } //End block
            } //End block
            if(mTransactionIsSuccessful)            
            {
                execSQL(COMMIT_SQL);
                if(this.mConnectionPool != null)                
                {
                    execSQL("PRAGMA wal_checkpoint;");
                    if(SQLiteDebug.DEBUG_SQL_STATEMENTS)                    
                    {
                    } //End block
                } //End block
                if(ENABLE_DB_SAMPLE)                
                {
                    logTimeStat(getLastSqlStatement(), mTransStartTime, COMMIT_SQL);
                } //End block
            } //End block
            else
            {
                try 
                {
                    execSQL("ROLLBACK;");
                    if(savedException != null)                    
                    {
                        savedException.addTaint(taint);
                        throw savedException;
                    } //End block
                } //End block
                catch (SQLException e)
                {
                    if(false)                    
                    {
                        Log.d(TAG, "exception during rollback, maybe the DB previously "
                                + "performed an auto-rollback");
                    } //End block
                } //End block
            } //End block
        } //End block
        finally 
        {
            mTransactionListener = null;
            unlockForced();
            if(false)            
            {
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.564 -0400", hash_original_method = "CAD10DEB5A167AB4D97D078F2E23C48E", hash_generated_method = "C9073E7A79DEC8EE0B76B8FC860886EE")
    public void setTransactionSuccessful() {
        verifyDbIsOpen();
        if(!mLock.isHeldByCurrentThread())        
        {
            IllegalStateException varE46C5B48DD007C615B76DBFC78D5641E_1537636520 = new IllegalStateException("no transaction pending");
            varE46C5B48DD007C615B76DBFC78D5641E_1537636520.addTaint(taint);
            throw varE46C5B48DD007C615B76DBFC78D5641E_1537636520;
        } //End block
        if(mInnerTransactionIsSuccessful)        
        {
            IllegalStateException varCC899E58C48F9959C595A19F7CA51BE2_1062749942 = new IllegalStateException(
                    "setTransactionSuccessful may only be called once per call to beginTransaction");
            varCC899E58C48F9959C595A19F7CA51BE2_1062749942.addTaint(taint);
            throw varCC899E58C48F9959C595A19F7CA51BE2_1062749942;
        } //End block
        mInnerTransactionIsSuccessful = true;
        // ---------- Original Method ----------
        //verifyDbIsOpen();
        //if (!mLock.isHeldByCurrentThread()) {
            //throw new IllegalStateException("no transaction pending");
        //}
        //if (mInnerTransactionIsSuccessful) {
            //throw new IllegalStateException(
                    //"setTransactionSuccessful may only be called once per call to beginTransaction");
        //}
        //mInnerTransactionIsSuccessful = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.565 -0400", hash_original_method = "6E9122EA7DDDF4A7FCE3C41AA714113C", hash_generated_method = "D23388077EB91F0F229B8D2D6FAFE551")
    public boolean inTransaction() {
        boolean var39EB67E59CCF7ADD3C72720C6369AF85_1634167672 = (mLock.getHoldCount() > 0 || mTransactionUsingExecSql);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1417941773 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1417941773;
        // ---------- Original Method ----------
        //return mLock.getHoldCount() > 0 || mTransactionUsingExecSql;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.566 -0400", hash_original_method = "5CE93639419B30E518363E5F446309C9", hash_generated_method = "142CD70EA8CD2C060BD2C144C95F1475")
    synchronized void setTransactionUsingExecSqlFlag() {
        if(Log.isLoggable(TAG, Log.DEBUG))        
        {
        } //End block
        mTransactionUsingExecSql = true;
        // ---------- Original Method ----------
        //if (Log.isLoggable(TAG, Log.DEBUG)) {
            //Log.i(TAG, "found execSQL('begin transaction')");
        //}
        //mTransactionUsingExecSql = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.567 -0400", hash_original_method = "37864C1F3B8C10FDA9B20AB532C7EB78", hash_generated_method = "831ED6AAAD1F0CA95D2E29662630E5E8")
    synchronized void resetTransactionUsingExecSqlFlag() {
        if(Log.isLoggable(TAG, Log.DEBUG))        
        {
            if(mTransactionUsingExecSql)            
            {
            } //End block
        } //End block
        mTransactionUsingExecSql = false;
        // ---------- Original Method ----------
        //if (Log.isLoggable(TAG, Log.DEBUG)) {
            //if (mTransactionUsingExecSql) {
                //Log.i(TAG, "found execSQL('commit or end or rollback')");
            //}
        //}
        //mTransactionUsingExecSql = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.568 -0400", hash_original_method = "18141E27A4A6F223116C15568E4B1710", hash_generated_method = "CA87E4139187F536ABF5A827EDB7F0FA")
    synchronized boolean amIInTransaction() {
        SQLiteDatabase db = (isPooledConnection()) ? mParentConnObj : this;
        boolean b = (!db.inTransaction()) ? false :
                db.mTransactionUsingExecSql || db.mLock.isHeldByCurrentThread();
        if(Log.isLoggable(TAG, Log.DEBUG))        
        {
        } //End block
        boolean var92EB5FFEE6AE2FEC3AD71C777531578F_1060777785 = (b);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_156074782 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_156074782;
        // ---------- Original Method ----------
        //SQLiteDatabase db = (isPooledConnection()) ? mParentConnObj : this;
        //boolean b = (!db.inTransaction()) ? false :
                //db.mTransactionUsingExecSql || db.mLock.isHeldByCurrentThread();
        //if (Log.isLoggable(TAG, Log.DEBUG)) {
            //Log.i(TAG, "amIinTransaction: " + b);
        //}
        //return b;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.569 -0400", hash_original_method = "810FBEC1135AAF9FE09D5ED72E2387AC", hash_generated_method = "9BAC8EEC175D82D47AAF1F9DEAEAB3F9")
    public boolean isDbLockedByCurrentThread() {
        boolean var475246050C807519D6778B4F472B2F34_43355598 = (mLock.isHeldByCurrentThread());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_723387693 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_723387693;
        // ---------- Original Method ----------
        //return mLock.isHeldByCurrentThread();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.569 -0400", hash_original_method = "AFE51BB500BDF01026C5B1FB8FA31F68", hash_generated_method = "2A15818E0F5EA5EA2F3CC5E08F194BAA")
    public boolean isDbLockedByOtherThreads() {
        boolean var4D123C87AFCF66682F89F8439C71D1BC_1740042818 = (!mLock.isHeldByCurrentThread() && mLock.isLocked());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_287391679 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_287391679;
        // ---------- Original Method ----------
        //return !mLock.isHeldByCurrentThread() && mLock.isLocked();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.570 -0400", hash_original_method = "275C631F29B5F92F82765C72693E08C5", hash_generated_method = "4D693A35425236FECA1B7F1752AF13EB")
    @Deprecated
    public boolean yieldIfContended() {
        boolean varC59DD9D9B2568308D7EF4D4313AB0544_120399200 = (yieldIfContendedHelper(false ,
                -1 ));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1432021605 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1432021605;
        // ---------- Original Method ----------
        //return yieldIfContendedHelper(false ,
                //-1 );
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.570 -0400", hash_original_method = "E4D6EC2B61BA0EB36CC3F2E9664FDE2E", hash_generated_method = "B8A8186823E1E8FE24B8C1F0EB13C367")
    public boolean yieldIfContendedSafely() {
        boolean varF31E14BB72D4DE0DDAF7987B42E25895_1146214016 = (yieldIfContendedHelper(true , -1 ));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_519193364 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_519193364;
        // ---------- Original Method ----------
        //return yieldIfContendedHelper(true , -1 );
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.570 -0400", hash_original_method = "EFD5966AFCC9629F634B854AE0830507", hash_generated_method = "F9C6D054E5E9162B8ADBFF987227F812")
    public boolean yieldIfContendedSafely(long sleepAfterYieldDelay) {
        addTaint(sleepAfterYieldDelay);
        boolean varD2BB51D2AB41B886C8E740AFD97D050A_136585811 = (yieldIfContendedHelper(true , sleepAfterYieldDelay));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_553273582 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_553273582;
        // ---------- Original Method ----------
        //return yieldIfContendedHelper(true , sleepAfterYieldDelay);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.573 -0400", hash_original_method = "82E88213585314141BE9DBE00F951B10", hash_generated_method = "978BA028E332B157BD0E4AA50602EDB8")
    private boolean yieldIfContendedHelper(boolean checkFullyYielded, long sleepAfterYieldDelay) {
        addTaint(sleepAfterYieldDelay);
        addTaint(checkFullyYielded);
        if(mLock.getQueueLength() == 0)        
        {
            mLockAcquiredWallTime = SystemClock.elapsedRealtime();
            mLockAcquiredThreadTime = Debug.threadCpuTimeNanos();
            boolean var68934A3E9455FA72420237EB05902327_700047103 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1345091655 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1345091655;
        } //End block
        setTransactionSuccessful();
        SQLiteTransactionListener transactionListener = mTransactionListener;
        endTransaction();
        if(checkFullyYielded)        
        {
            if(this.isDbLockedByCurrentThread())            
            {
                IllegalStateException varE7A76AD65CE0D1C774F26F1BB3E58DD7_1726339766 = new IllegalStateException(
                        "Db locked more than once. yielfIfContended cannot yield");
                varE7A76AD65CE0D1C774F26F1BB3E58DD7_1726339766.addTaint(taint);
                throw varE7A76AD65CE0D1C774F26F1BB3E58DD7_1726339766;
            } //End block
        } //End block
        if(sleepAfterYieldDelay > 0)        
        {
            long remainingDelay = sleepAfterYieldDelay;
            while
(remainingDelay > 0)            
            {
                try 
                {
                    Thread.sleep(remainingDelay < SLEEP_AFTER_YIELD_QUANTUM ?
                            remainingDelay : SLEEP_AFTER_YIELD_QUANTUM);
                } //End block
                catch (InterruptedException e)
                {
                    Thread.interrupted();
                } //End block
                remainingDelay -= SLEEP_AFTER_YIELD_QUANTUM;
                if(mLock.getQueueLength() == 0)                
                {
                    break;
                } //End block
            } //End block
        } //End block
        beginTransactionWithListener(transactionListener);
        boolean varB326B5062B2F0E69046810717534CB09_1751425329 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_258949461 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_258949461;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.575 -0400", hash_original_method = "2BF74CD6834BBADBF27F65464DB83499", hash_generated_method = "CE425E4C6DF5F609B1314826DD07DB4C")
    @Deprecated
    public Map<String, String> getSyncedTables() {
Map<String, String> var2AF78D255D26C3C84C3DB61E3A8BCBD5_1445404204 =         new HashMap<String, String>(0);
        var2AF78D255D26C3C84C3DB61E3A8BCBD5_1445404204.addTaint(taint);
        return var2AF78D255D26C3C84C3DB61E3A8BCBD5_1445404204;
        // ---------- Original Method ----------
        //return new HashMap<String, String>(0);
    }

    
    public static SQLiteDatabase openDatabase(String path, CursorFactory factory, int flags) {
        return openDatabase(path, factory, flags, new DefaultDatabaseErrorHandler());
    }

    
    public static SQLiteDatabase openDatabase(String path, CursorFactory factory, int flags,
            DatabaseErrorHandler errorHandler) {
        SQLiteDatabase sqliteDatabase = openDatabase(path, factory, flags, errorHandler,
                (short) 0 );
        if (sBlockSize == 0) {
            sBlockSize = new StatFs("/data").getBlockSize();
        }
        sqliteDatabase.setPageSize(sBlockSize);
        sqliteDatabase.setJournalMode(path, "TRUNCATE");
        synchronized(mActiveDatabases) {
            mActiveDatabases.add(new WeakReference<SQLiteDatabase>(sqliteDatabase));
        }
        return sqliteDatabase;
    }

    
    @DSModeled(DSC.BAN)
    private static SQLiteDatabase openDatabase(String path, CursorFactory factory, int flags,
            DatabaseErrorHandler errorHandler, short connectionNum) {
        SQLiteDatabase db = new SQLiteDatabase(path, factory, flags, errorHandler, connectionNum);
        try {
            if (Log.isLoggable(TAG, Log.DEBUG)) {
                Log.i(TAG, "opening the db : " + path);
            }
            db.dbopen(path, flags);
            db.setLocale(Locale.getDefault());
            if (SQLiteDebug.DEBUG_SQL_STATEMENTS) {
                db.enableSqlTracing(path, connectionNum);
            }
            if (SQLiteDebug.DEBUG_SQL_TIME) {
                db.enableSqlProfiling(path, connectionNum);
            }
            return db;
        } catch (SQLiteDatabaseCorruptException e) {
            db.mErrorHandler.onCorruption(db);
            return SQLiteDatabase.openDatabase(path, factory, flags, errorHandler);
        } catch (SQLiteException e) {
            Log.e(TAG, "Failed to open the database. closing it.", e);
            db.close();
            throw e;
        }
    }

    
    public static SQLiteDatabase openOrCreateDatabase(File file, CursorFactory factory) {
        return openOrCreateDatabase(file.getPath(), factory);
    }

    
    public static SQLiteDatabase openOrCreateDatabase(String path, CursorFactory factory) {
        return openDatabase(path, factory, CREATE_IF_NECESSARY);
    }

    
    public static SQLiteDatabase openOrCreateDatabase(String path, CursorFactory factory,
            DatabaseErrorHandler errorHandler) {
        return openDatabase(path, factory, CREATE_IF_NECESSARY, errorHandler);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.580 -0400", hash_original_method = "4DBAD15B0F91A1B1A1A509E057CF6487", hash_generated_method = "BE518D50FDA188705AEA47437C9E816A")
    private void setJournalMode(final String dbPath, final String mode) {
        addTaint(mode.getTaint());
        addTaint(dbPath.getTaint());
        if(dbPath.equalsIgnoreCase(MEMORY_DB_PATH) || isReadOnly())        
        {
            return;
        } //End block
        String s = DatabaseUtils.stringForQuery(this, "PRAGMA journal_mode=" + mode, null);
        if(!s.equalsIgnoreCase(mode))        
        {
        } //End block
        // ---------- Original Method ----------
        //if (dbPath.equalsIgnoreCase(MEMORY_DB_PATH) || isReadOnly()) {
            //return;
        //}
        //String s = DatabaseUtils.stringForQuery(this, "PRAGMA journal_mode=" + mode, null);
        //if (!s.equalsIgnoreCase(mode)) {
            //Log.e(TAG, "setting journal_mode to " + mode + " failed for db: " + dbPath +
                    //" (on pragma set journal_mode, sqlite returned:" + s);
        //}
    }

    
    public static SQLiteDatabase create(CursorFactory factory) {
        return openDatabase(MEMORY_DB_PATH, factory, CREATE_IF_NECESSARY);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.582 -0400", hash_original_method = "F057ECACA47F2E639159F91F6FF25AA8", hash_generated_method = "CA3F6288128C92EE799ECBCE19EA0E92")
    public void close() {
        if(!isOpen())        
        {
            return;
        } //End block
        if(Log.isLoggable(TAG, Log.DEBUG))        
        {
        } //End block
        lock();
        try 
        {
            if(!isOpen())            
            {
                return;
            } //End block
            closeClosable();
            closePendingStatements();
            releaseCustomFunctions();
            closeDatabase();
            if(mConnectionPool != null)            
            {
                if(Log.isLoggable(TAG, Log.DEBUG))                
                {
                } //End block
                mConnectionPool.close();
            } //End block
        } //End block
        finally 
        {
            unlock();
        } //End block
        // ---------- Original Method ----------
        //if (!isOpen()) {
            //return;
        //}
        //if (Log.isLoggable(TAG, Log.DEBUG)) {
            //Log.i(TAG, "closing db: " + mPath + " (connection # " + mConnectionNum);
        //}
        //lock();
        //try {
            //if (!isOpen()) {
                //return;
            //}
            //closeClosable();
            //closePendingStatements();
            //releaseCustomFunctions();
            //closeDatabase();
            //if (mConnectionPool != null) {
                //if (Log.isLoggable(TAG, Log.DEBUG)) {
                    //assert mConnectionPool != null;
                    //Log.i(TAG, mConnectionPool.toString());
                //}
                //mConnectionPool.close();
            //}
        //} finally {
            //unlock();
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.583 -0400", hash_original_method = "2CD800231F10038F3799DBDAB26BCEE1", hash_generated_method = "1CBDD8B04B5971582B08FAB9AE0C3A1C")
    private void closeClosable() {
        deallocCachedSqlStatements();
        Iterator<Map.Entry<SQLiteClosable, Object>> iter = mPrograms.entrySet().iterator();
        while
(iter.hasNext())        
        {
            Map.Entry<SQLiteClosable, Object> entry = iter.next();
            SQLiteClosable program = entry.getKey();
            if(program != null)            
            {
                program.onAllReferencesReleasedFromContainer();
            } //End block
        } //End block
        // ---------- Original Method ----------
        //deallocCachedSqlStatements();
        //Iterator<Map.Entry<SQLiteClosable, Object>> iter = mPrograms.entrySet().iterator();
        //while (iter.hasNext()) {
            //Map.Entry<SQLiteClosable, Object> entry = iter.next();
            //SQLiteClosable program = entry.getKey();
            //if (program != null) {
                //program.onAllReferencesReleasedFromContainer();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.585 -0400", hash_original_method = "9BCDA7BC5AA364A3676019422CD41F65", hash_generated_method = "928DE5B1613228E84EFB03E566CF26CC")
     void closeDatabase() throws SQLiteException {
        try 
        {
            dbclose();
        } //End block
        catch (SQLiteUnfinalizedObjectsException e)
        {
            String msg = e.getMessage();
            String[] tokens = msg.split(",", 2);
            int stmtId = Integer.parseInt(tokens[0]);
            Iterator<Map.Entry<SQLiteClosable, Object>> iter = mPrograms.entrySet().iterator();
            boolean found = false;
            while
(iter.hasNext())            
            {
                Map.Entry<SQLiteClosable, Object> entry = iter.next();
                SQLiteClosable program = entry.getKey();
                if(program != null && program instanceof SQLiteProgram)                
                {
                    SQLiteCompiledSql compiledSql = ((SQLiteProgram)program).mCompiledSql;
                    if(compiledSql.nStatement == stmtId)                    
                    {
                        msg = compiledSql.toString();
                        found = true;
                    } //End block
                } //End block
            } //End block
            if(!found)            
            {
                if(mClosedStatementIds.contains(stmtId))                
                {
                    closePendingStatements();
                    closeDatabase();
                } //End block
            } //End block
            else
            {
                SQLiteUnfinalizedObjectsException var8F1DB10592830F1B72EDBB96E9F0E496_1203929719 = new SQLiteUnfinalizedObjectsException(
                        "close() on database: " + getPath() +
                        " failed due to un-close()d SQL statements: " + msg);
                var8F1DB10592830F1B72EDBB96E9F0E496_1203929719.addTaint(taint);
                throw var8F1DB10592830F1B72EDBB96E9F0E496_1203929719;
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.587 -0400", hash_original_method = "4C27B28311EC4401B9E72044B34DEE3C", hash_generated_method = "4E905500CC20EB86329796A43360CF14")
    private void dbclose() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.588 -0400", hash_original_method = "6AE38120A6AE17DCB302700D83D76664", hash_generated_method = "07F866BBB4098C2DED60C6731DA22EAD")
    public void addCustomFunction(String name, int numArgs, CustomFunction function) {
        addTaint(function.getTaint());
        addTaint(numArgs);
        addTaint(name.getTaint());
        verifyDbIsOpen();
        synchronized
(mCustomFunctions)        {
            int ref = native_addCustomFunction(name, numArgs, function);
            if(ref != 0)            
            {
                mCustomFunctions.add(new Integer(ref));
            } //End block
            else
            {
                SQLiteException varAC9F9B5BCDE3D6EFACA476C4F7F6F6A0_1658197085 = new SQLiteException("failed to add custom function " + name);
                varAC9F9B5BCDE3D6EFACA476C4F7F6F6A0_1658197085.addTaint(taint);
                throw varAC9F9B5BCDE3D6EFACA476C4F7F6F6A0_1658197085;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //verifyDbIsOpen();
        //synchronized (mCustomFunctions) {
            //int ref = native_addCustomFunction(name, numArgs, function);
            //if (ref != 0) {
                //mCustomFunctions.add(new Integer(ref));
            //} else {
                //throw new SQLiteException("failed to add custom function " + name);
            //}
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.589 -0400", hash_original_method = "9C15AE424A91890D11F6682C678B396E", hash_generated_method = "565FF64D92B73E45A055F23101EA3778")
    private void releaseCustomFunctions() {
        synchronized
(mCustomFunctions)        {
for(int i = 0;i < mCustomFunctions.size();i++)
            {
                Integer function = mCustomFunctions.get(i);
                native_releaseCustomFunction(function.intValue());
            } //End block
            mCustomFunctions.clear();
        } //End block
        // ---------- Original Method ----------
        //synchronized (mCustomFunctions) {
            //for (int i = 0; i < mCustomFunctions.size(); i++) {
                //Integer function = mCustomFunctions.get(i);
                //native_releaseCustomFunction(function.intValue());
            //}
            //mCustomFunctions.clear();
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.590 -0400", hash_original_method = "545ECF4B8C2C387E458104596CE82C8C", hash_generated_method = "1CC60377BE5B135C2E5DE6AB6C31C32A")
    private int native_addCustomFunction(String name, int numArgs, CustomFunction function) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2143437385 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2143437385;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.591 -0400", hash_original_method = "D641D8CC9687EF2DFB0D6D88DDBFEE42", hash_generated_method = "B4A109E17A2F0A083453807534F34E44")
    private void native_releaseCustomFunction(int function) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.591 -0400", hash_original_method = "8BA60C4A4A322F100A535BB125C59B40", hash_generated_method = "8A2EF7A60DB95C418207B9E62A3A6DCC")
    public int getVersion() {
        int var3DFBB6B231A360BE2FC5468DEA3D3BA0_284121603 = (((Long) DatabaseUtils.longForQuery(this, "PRAGMA user_version;", null)).intValue());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1448444629 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1448444629;
        // ---------- Original Method ----------
        //return ((Long) DatabaseUtils.longForQuery(this, "PRAGMA user_version;", null)).intValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.592 -0400", hash_original_method = "4E3C0E9170C91236F101F38522569C45", hash_generated_method = "FFE3BD39E2B31D52938CD69211C26246")
    public void setVersion(int version) {
        addTaint(version);
        execSQL("PRAGMA user_version = " + version);
        // ---------- Original Method ----------
        //execSQL("PRAGMA user_version = " + version);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.593 -0400", hash_original_method = "01DC63CC6FF3C1462DC7069F3072C18D", hash_generated_method = "41994AB8D7F522FA7FD217E1DF00EBED")
    public long getMaximumSize() {
        long pageCount = DatabaseUtils.longForQuery(this, "PRAGMA max_page_count;", null);
        long varEF0C2206D4308EE3D65C3F1F8D450022_1928001509 = (pageCount * getPageSize());
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1468756710 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1468756710;
        // ---------- Original Method ----------
        //long pageCount = DatabaseUtils.longForQuery(this, "PRAGMA max_page_count;", null);
        //return pageCount * getPageSize();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.594 -0400", hash_original_method = "B09E5ED21834BC66E218E9635E49257B", hash_generated_method = "37DBA31FFC06DBEC1E2E8FB0C2448AC0")
    public long setMaximumSize(long numBytes) {
        addTaint(numBytes);
        long pageSize = getPageSize();
        long numPages = numBytes / pageSize;
        if((numBytes % pageSize) != 0)        
        {
            numPages++;
        } //End block
        long newPageCount = DatabaseUtils.longForQuery(this, "PRAGMA max_page_count = " + numPages,
                null);
        long var367F6ECD97F29FC385A5760C6933481E_1864017998 = (newPageCount * pageSize);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1261017517 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1261017517;
        // ---------- Original Method ----------
        //long pageSize = getPageSize();
        //long numPages = numBytes / pageSize;
        //if ((numBytes % pageSize) != 0) {
            //numPages++;
        //}
        //long newPageCount = DatabaseUtils.longForQuery(this, "PRAGMA max_page_count = " + numPages,
                //null);
        //return newPageCount * pageSize;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.595 -0400", hash_original_method = "677D214086B645E86B85D4E2A88CD9F6", hash_generated_method = "A85A049DAE266D330E4BB8C5D13E88B1")
    public long getPageSize() {
        long var0FA2348E41AC4877AC4B10053CA2F627_479250842 = (DatabaseUtils.longForQuery(this, "PRAGMA page_size;", null));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1062784350 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1062784350;
        // ---------- Original Method ----------
        //return DatabaseUtils.longForQuery(this, "PRAGMA page_size;", null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.595 -0400", hash_original_method = "CE3FCE5D2F41E0E2EF73A0D49E90DE3F", hash_generated_method = "3E0D093D7A6AF89A4CC618622B339198")
    public void setPageSize(long numBytes) {
        addTaint(numBytes);
        execSQL("PRAGMA page_size = " + numBytes);
        // ---------- Original Method ----------
        //execSQL("PRAGMA page_size = " + numBytes);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.596 -0400", hash_original_method = "0ECCFA53F5E6749CB5B25917802B1822", hash_generated_method = "7FC2F8850E8243813320359B6765022D")
    @Deprecated
    public void markTableSyncable(String table, String deletedTable) {
        addTaint(deletedTable.getTaint());
        addTaint(table.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.597 -0400", hash_original_method = "9A70316D056BE2F7590F6370A4F13111", hash_generated_method = "B4D0CB8673C3C5BAACF6ABB432E9760F")
    @Deprecated
    public void markTableSyncable(String table, String foreignKey, String updateTable) {
        addTaint(updateTable.getTaint());
        addTaint(foreignKey.getTaint());
        addTaint(table.getTaint());
        // ---------- Original Method ----------
    }

    
    public static String findEditTable(String tables) {
        if (!TextUtils.isEmpty(tables)) {
            int spacepos = tables.indexOf(' ');
            int commapos = tables.indexOf(',');
            if (spacepos > 0 && (spacepos < commapos || commapos < 0)) {
                return tables.substring(0, spacepos);
            } else if (commapos > 0 && (commapos < spacepos || spacepos < 0) ) {
                return tables.substring(0, commapos);
            }
            return tables;
        } else {
            throw new IllegalStateException("Invalid tables");
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.598 -0400", hash_original_method = "C05C583B39FD005C236783082CBB4E55", hash_generated_method = "DB8DB3907DFB17AB7A3E09DD3D5D9259")
    public SQLiteStatement compileStatement(String sql) throws SQLException {
        addTaint(sql.getTaint());
        verifyDbIsOpen();
SQLiteStatement varBEC5BDE83AF94CE50E6B86DAA2D5DF03_203572392 =         new SQLiteStatement(this, sql, null);
        varBEC5BDE83AF94CE50E6B86DAA2D5DF03_203572392.addTaint(taint);
        return varBEC5BDE83AF94CE50E6B86DAA2D5DF03_203572392;
        // ---------- Original Method ----------
        //verifyDbIsOpen();
        //return new SQLiteStatement(this, sql, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.598 -0400", hash_original_method = "5E1B6C3D7A97420E0A4D0244321FA1D0", hash_generated_method = "64C848080B9A48E4BC33898F990F6918")
    public Cursor query(boolean distinct, String table, String[] columns,
            String selection, String[] selectionArgs, String groupBy,
            String having, String orderBy, String limit) {
        addTaint(limit.getTaint());
        addTaint(orderBy.getTaint());
        addTaint(having.getTaint());
        addTaint(groupBy.getTaint());
        addTaint(selectionArgs[0].getTaint());
        addTaint(selection.getTaint());
        addTaint(columns[0].getTaint());
        addTaint(table.getTaint());
        addTaint(distinct);
Cursor var23D2C6BC128F8B1CE94B002C59BEE151_571242186 =         queryWithFactory(null, distinct, table, columns, selection, selectionArgs,
                groupBy, having, orderBy, limit);
        var23D2C6BC128F8B1CE94B002C59BEE151_571242186.addTaint(taint);
        return var23D2C6BC128F8B1CE94B002C59BEE151_571242186;
        // ---------- Original Method ----------
        //return queryWithFactory(null, distinct, table, columns, selection, selectionArgs,
                //groupBy, having, orderBy, limit);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.599 -0400", hash_original_method = "2EC2F985341F70A15977A4E5B8D54ACE", hash_generated_method = "8BF1A904BA2D3C8D96811E00F69B0C64")
    public Cursor queryWithFactory(CursorFactory cursorFactory,
            boolean distinct, String table, String[] columns,
            String selection, String[] selectionArgs, String groupBy,
            String having, String orderBy, String limit) {
        addTaint(limit.getTaint());
        addTaint(orderBy.getTaint());
        addTaint(having.getTaint());
        addTaint(groupBy.getTaint());
        addTaint(selectionArgs[0].getTaint());
        addTaint(selection.getTaint());
        addTaint(columns[0].getTaint());
        addTaint(table.getTaint());
        addTaint(distinct);
        addTaint(cursorFactory.getTaint());
        verifyDbIsOpen();
        String sql = SQLiteQueryBuilder.buildQueryString(
                distinct, table, columns, selection, groupBy, having, orderBy, limit);
Cursor varA09DE70112197B49177C7CC96D9BFA01_1601766288 =         rawQueryWithFactory(
                cursorFactory, sql, selectionArgs, findEditTable(table));
        varA09DE70112197B49177C7CC96D9BFA01_1601766288.addTaint(taint);
        return varA09DE70112197B49177C7CC96D9BFA01_1601766288;
        // ---------- Original Method ----------
        //verifyDbIsOpen();
        //String sql = SQLiteQueryBuilder.buildQueryString(
                //distinct, table, columns, selection, groupBy, having, orderBy, limit);
        //return rawQueryWithFactory(
                //cursorFactory, sql, selectionArgs, findEditTable(table));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.600 -0400", hash_original_method = "823CC97B8BCC24B1EEF8A14CAC46F9D2", hash_generated_method = "1AAD8897223E6CDA44A3313A288BDF97")
    public Cursor query(String table, String[] columns, String selection,
            String[] selectionArgs, String groupBy, String having,
            String orderBy) {
        addTaint(orderBy.getTaint());
        addTaint(having.getTaint());
        addTaint(groupBy.getTaint());
        addTaint(selectionArgs[0].getTaint());
        addTaint(selection.getTaint());
        addTaint(columns[0].getTaint());
        addTaint(table.getTaint());
Cursor varF6E8BC926FB3F70ACD0A2418D34560DE_457017393 =         query(false, table, columns, selection, selectionArgs, groupBy,
                having, orderBy, null );
        varF6E8BC926FB3F70ACD0A2418D34560DE_457017393.addTaint(taint);
        return varF6E8BC926FB3F70ACD0A2418D34560DE_457017393;
        // ---------- Original Method ----------
        //return query(false, table, columns, selection, selectionArgs, groupBy,
                //having, orderBy, null );
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.601 -0400", hash_original_method = "C821013CE8C43126ED02ADCC7264C8CF", hash_generated_method = "7C0D72E6B185107489F31B4F3DCE72AA")
    public Cursor query(String table, String[] columns, String selection,
            String[] selectionArgs, String groupBy, String having,
            String orderBy, String limit) {
        addTaint(limit.getTaint());
        addTaint(orderBy.getTaint());
        addTaint(having.getTaint());
        addTaint(groupBy.getTaint());
        addTaint(selectionArgs[0].getTaint());
        addTaint(selection.getTaint());
        addTaint(columns[0].getTaint());
        addTaint(table.getTaint());
Cursor var5D7022C24B55BCBF7DDD7A0CA420A4BF_1281759162 =         query(false, table, columns, selection, selectionArgs, groupBy,
                having, orderBy, limit);
        var5D7022C24B55BCBF7DDD7A0CA420A4BF_1281759162.addTaint(taint);
        return var5D7022C24B55BCBF7DDD7A0CA420A4BF_1281759162;
        // ---------- Original Method ----------
        //return query(false, table, columns, selection, selectionArgs, groupBy,
                //having, orderBy, limit);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.602 -0400", hash_original_method = "76B8F97A589187A4837E14E72F2396A8", hash_generated_method = "F923F47389E0065E17B3C80E224CC7F5")
    public Cursor rawQuery(String sql, String[] selectionArgs) {
        addTaint(selectionArgs[0].getTaint());
        addTaint(sql.getTaint());
Cursor var6048EAF2651C061F158A6FFDC11D3630_1868142425 =         rawQueryWithFactory(null, sql, selectionArgs, null);
        var6048EAF2651C061F158A6FFDC11D3630_1868142425.addTaint(taint);
        return var6048EAF2651C061F158A6FFDC11D3630_1868142425;
        // ---------- Original Method ----------
        //return rawQueryWithFactory(null, sql, selectionArgs, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.603 -0400", hash_original_method = "42A0891F7A1C512D8BE3F37EFD1DF118", hash_generated_method = "B795F4F2D22B660DFDDE292DF4B16CD0")
    public Cursor rawQueryWithFactory(
            CursorFactory cursorFactory, String sql, String[] selectionArgs,
            String editTable) {
        addTaint(editTable.getTaint());
        addTaint(selectionArgs[0].getTaint());
        addTaint(sql.getTaint());
        addTaint(cursorFactory.getTaint());
        verifyDbIsOpen();
        BlockGuard.getThreadPolicy().onReadFromDisk();
        SQLiteDatabase db = getDbConnection(sql);
        SQLiteCursorDriver driver = new SQLiteDirectCursorDriver(db, sql, editTable);
        Cursor cursor = null;
        try 
        {
            cursor = driver.query(
                    cursorFactory != null ? cursorFactory : mFactory,
                    selectionArgs);
        } //End block
        finally 
        {
            releaseDbConnection(db);
        } //End block
Cursor varADA3C208DF1628BA935498FB38A6BBD3_1089553047 =         cursor;
        varADA3C208DF1628BA935498FB38A6BBD3_1089553047.addTaint(taint);
        return varADA3C208DF1628BA935498FB38A6BBD3_1089553047;
        // ---------- Original Method ----------
        //verifyDbIsOpen();
        //BlockGuard.getThreadPolicy().onReadFromDisk();
        //SQLiteDatabase db = getDbConnection(sql);
        //SQLiteCursorDriver driver = new SQLiteDirectCursorDriver(db, sql, editTable);
        //Cursor cursor = null;
        //try {
            //cursor = driver.query(
                    //cursorFactory != null ? cursorFactory : mFactory,
                    //selectionArgs);
        //} finally {
            //releaseDbConnection(db);
        //}
        //return cursor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.604 -0400", hash_original_method = "7C0142B65481E16DCFB76B6C0BD0AF64", hash_generated_method = "D9771FCFA9EF67639645F566603F4576")
    public long insert(String table, String nullColumnHack, ContentValues values) {
        addTaint(values.getTaint());
        addTaint(nullColumnHack.getTaint());
        addTaint(table.getTaint());
        try 
        {
            long var1B2EAADA4551B4E46946D3C43A39056D_241860762 = (insertWithOnConflict(table, nullColumnHack, values, CONFLICT_NONE));
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1703718446 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1703718446;
        } //End block
        catch (SQLException e)
        {
            long var6BB61E3B7BCE0931DA574D19D1D82C88_1078217113 = (-1);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_285465935 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_285465935;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return insertWithOnConflict(table, nullColumnHack, values, CONFLICT_NONE);
        //} catch (SQLException e) {
            //Log.e(TAG, "Error inserting " + values, e);
            //return -1;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.605 -0400", hash_original_method = "2F31CF2160A369C3FFDDD251C32C2819", hash_generated_method = "B1EAD13D2ED4D05AFFB2016F12486382")
    public long insertOrThrow(String table, String nullColumnHack, ContentValues values) throws SQLException {
        addTaint(values.getTaint());
        addTaint(nullColumnHack.getTaint());
        addTaint(table.getTaint());
        long var1B2EAADA4551B4E46946D3C43A39056D_226597664 = (insertWithOnConflict(table, nullColumnHack, values, CONFLICT_NONE));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1802749673 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1802749673;
        // ---------- Original Method ----------
        //return insertWithOnConflict(table, nullColumnHack, values, CONFLICT_NONE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.605 -0400", hash_original_method = "4277B606CBD58106C26DEC9C427B6DC5", hash_generated_method = "5370B65E239C353AE9A977253135CF36")
    public long replace(String table, String nullColumnHack, ContentValues initialValues) {
        addTaint(initialValues.getTaint());
        addTaint(nullColumnHack.getTaint());
        addTaint(table.getTaint());
        try 
        {
            long varFA0DDB9BBD2D61D7EDFBFFA0DBE031A7_192958997 = (insertWithOnConflict(table, nullColumnHack, initialValues,
                    CONFLICT_REPLACE));
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_490977018 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_490977018;
        } //End block
        catch (SQLException e)
        {
            long var6BB61E3B7BCE0931DA574D19D1D82C88_1442689003 = (-1);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1558506612 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1558506612;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return insertWithOnConflict(table, nullColumnHack, initialValues,
                    //CONFLICT_REPLACE);
        //} catch (SQLException e) {
            //Log.e(TAG, "Error inserting " + initialValues, e);
            //return -1;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.606 -0400", hash_original_method = "006F0DF267AA18E88B2010DFB3E66CC0", hash_generated_method = "4251AF43168338E974D2121C42954980")
    public long replaceOrThrow(String table, String nullColumnHack,
            ContentValues initialValues) throws SQLException {
        addTaint(initialValues.getTaint());
        addTaint(nullColumnHack.getTaint());
        addTaint(table.getTaint());
        long var2EA573E159D2EC588D472481DD4C8850_1854361607 = (insertWithOnConflict(table, nullColumnHack, initialValues,
                CONFLICT_REPLACE));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_778956842 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_778956842;
        // ---------- Original Method ----------
        //return insertWithOnConflict(table, nullColumnHack, initialValues,
                //CONFLICT_REPLACE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.608 -0400", hash_original_method = "4E696CAC31E62C2450813F66BA0D3688", hash_generated_method = "BFB64044895AC6729E97310C53CCE135")
    public long insertWithOnConflict(String table, String nullColumnHack,
            ContentValues initialValues, int conflictAlgorithm) {
        addTaint(conflictAlgorithm);
        addTaint(initialValues.getTaint());
        addTaint(nullColumnHack.getTaint());
        addTaint(table.getTaint());
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT");
        sql.append(CONFLICT_VALUES[conflictAlgorithm]);
        sql.append(" INTO ");
        sql.append(table);
        sql.append('(');
        Object[] bindArgs = null;
        int size = (initialValues != null && initialValues.size() > 0) ? initialValues.size() : 0;
        if(size > 0)        
        {
            bindArgs = new Object[size];
            int i = 0;
for(String colName : initialValues.keySet())
            {
                sql.append((i > 0) ? "," : "");
                sql.append(colName);
                bindArgs[i++] = initialValues.get(colName);
            } //End block
            sql.append(')');
            sql.append(" VALUES (");
for(i = 0;i < size;i++)
            {
                sql.append((i > 0) ? ",?" : "?");
            } //End block
        } //End block
        else
        {
            sql.append(nullColumnHack + ") VALUES (NULL");
        } //End block
        sql.append(')');
        SQLiteStatement statement = new SQLiteStatement(this, sql.toString(), bindArgs);
        try 
        {
            long var9242B7E5D7445BE96758B11AACAF5746_233420263 = (statement.executeInsert());
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_159894331 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_159894331;
        } //End block
        catch (SQLiteDatabaseCorruptException e)
        {
            onCorruption();
            e.addTaint(taint);
            throw e;
        } //End block
        finally 
        {
            statement.close();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.610 -0400", hash_original_method = "D469CE4575675C51277223F3405EF96C", hash_generated_method = "7E1B361FB12566B70660D2D824224333")
    public int delete(String table, String whereClause, String[] whereArgs) {
        addTaint(whereArgs[0].getTaint());
        addTaint(whereClause.getTaint());
        addTaint(table.getTaint());
        SQLiteStatement statement = new SQLiteStatement(this, "DELETE FROM " + table +
                (!TextUtils.isEmpty(whereClause) ? " WHERE " + whereClause : ""), whereArgs);
        try 
        {
            int var01DF87E30F36942B79889D5C280E42B9_513573058 = (statement.executeUpdateDelete());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1169941330 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1169941330;
        } //End block
        catch (SQLiteDatabaseCorruptException e)
        {
            onCorruption();
            e.addTaint(taint);
            throw e;
        } //End block
        finally 
        {
            statement.close();
        } //End block
        // ---------- Original Method ----------
        //SQLiteStatement statement =  new SQLiteStatement(this, "DELETE FROM " + table +
                //(!TextUtils.isEmpty(whereClause) ? " WHERE " + whereClause : ""), whereArgs);
        //try {
            //return statement.executeUpdateDelete();
        //} catch (SQLiteDatabaseCorruptException e) {
            //onCorruption();
            //throw e;
        //} finally {
            //statement.close();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.612 -0400", hash_original_method = "1314F51B10A849824DA60B76F1896857", hash_generated_method = "48A2079E8A57B00EB309F7B090A72032")
    public int update(String table, ContentValues values, String whereClause, String[] whereArgs) {
        addTaint(whereArgs[0].getTaint());
        addTaint(whereClause.getTaint());
        addTaint(values.getTaint());
        addTaint(table.getTaint());
        int var5FCECBD5FEE1AB69AD61B2744294E4C3_1721664211 = (updateWithOnConflict(table, values, whereClause, whereArgs, CONFLICT_NONE));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1628114049 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1628114049;
        // ---------- Original Method ----------
        //return updateWithOnConflict(table, values, whereClause, whereArgs, CONFLICT_NONE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.615 -0400", hash_original_method = "42C896B54A7E0C71455DEE45B9C2EA0D", hash_generated_method = "05916159E86884CA282FAFB3BC886F41")
    public int updateWithOnConflict(String table, ContentValues values,
            String whereClause, String[] whereArgs, int conflictAlgorithm) {
        addTaint(conflictAlgorithm);
        addTaint(whereArgs[0].getTaint());
        addTaint(whereClause.getTaint());
        addTaint(values.getTaint());
        addTaint(table.getTaint());
        if(values == null || values.size() == 0)        
        {
            IllegalArgumentException varEEE2AB986D839FC34B1428F77875E0E5_795302489 = new IllegalArgumentException("Empty values");
            varEEE2AB986D839FC34B1428F77875E0E5_795302489.addTaint(taint);
            throw varEEE2AB986D839FC34B1428F77875E0E5_795302489;
        } //End block
        StringBuilder sql = new StringBuilder(120);
        sql.append("UPDATE ");
        sql.append(CONFLICT_VALUES[conflictAlgorithm]);
        sql.append(table);
        sql.append(" SET ");
        int setValuesSize = values.size();
        int bindArgsSize = (whereArgs == null) ? setValuesSize : (setValuesSize + whereArgs.length);
        Object[] bindArgs = new Object[bindArgsSize];
        int i = 0;
for(String colName : values.keySet())
        {
            sql.append((i > 0) ? "," : "");
            sql.append(colName);
            bindArgs[i++] = values.get(colName);
            sql.append("=?");
        } //End block
        if(whereArgs != null)        
        {
for(i = setValuesSize;i < bindArgsSize;i++)
            {
                bindArgs[i] = whereArgs[i - setValuesSize];
            } //End block
        } //End block
        if(!TextUtils.isEmpty(whereClause))        
        {
            sql.append(" WHERE ");
            sql.append(whereClause);
        } //End block
        SQLiteStatement statement = new SQLiteStatement(this, sql.toString(), bindArgs);
        try 
        {
            int var01DF87E30F36942B79889D5C280E42B9_229558880 = (statement.executeUpdateDelete());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1246506535 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1246506535;
        } //End block
        catch (SQLiteDatabaseCorruptException e)
        {
            onCorruption();
            e.addTaint(taint);
            throw e;
        } //End block
        finally 
        {
            statement.close();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.618 -0400", hash_original_method = "25D536EB53093A036E9DAE961A0D97E6", hash_generated_method = "79A7D2318A34B8EB4F086EC6345B4E74")
    public void execSQL(String sql) throws SQLException {
        addTaint(sql.getTaint());
        executeSql(sql, null);
        // ---------- Original Method ----------
        //executeSql(sql, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.619 -0400", hash_original_method = "C75317BDB75C741C750B94F218C97882", hash_generated_method = "00CF1FC4795B9D0745F7FF4C48206AAB")
    public void execSQL(String sql, Object[] bindArgs) throws SQLException {
        addTaint(bindArgs[0].getTaint());
        addTaint(sql.getTaint());
        if(bindArgs == null)        
        {
            IllegalArgumentException var20997C2B87ED082BF8AAB3BDBFF184B3_124467867 = new IllegalArgumentException("Empty bindArgs");
            var20997C2B87ED082BF8AAB3BDBFF184B3_124467867.addTaint(taint);
            throw var20997C2B87ED082BF8AAB3BDBFF184B3_124467867;
        } //End block
        executeSql(sql, bindArgs);
        // ---------- Original Method ----------
        //if (bindArgs == null) {
            //throw new IllegalArgumentException("Empty bindArgs");
        //}
        //executeSql(sql, bindArgs);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.620 -0400", hash_original_method = "9265893CFBC7535112C5207F5F702C1B", hash_generated_method = "FEFC15DD41C5156C7B0EB0359642A6A0")
    private int executeSql(String sql, Object[] bindArgs) throws SQLException {
        addTaint(bindArgs[0].getTaint());
        addTaint(sql.getTaint());
        if(DatabaseUtils.getSqlStatementType(sql) == DatabaseUtils.STATEMENT_ATTACH)        
        {
            disableWriteAheadLogging();
            mHasAttachedDbs = true;
        } //End block
        SQLiteStatement statement = new SQLiteStatement(this, sql, bindArgs);
        try 
        {
            int var01DF87E30F36942B79889D5C280E42B9_1533965845 = (statement.executeUpdateDelete());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1430819270 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1430819270;
        } //End block
        catch (SQLiteDatabaseCorruptException e)
        {
            onCorruption();
            e.addTaint(taint);
            throw e;
        } //End block
        finally 
        {
            statement.close();
        } //End block
        // ---------- Original Method ----------
        //if (DatabaseUtils.getSqlStatementType(sql) == DatabaseUtils.STATEMENT_ATTACH) {
            //disableWriteAheadLogging();
            //mHasAttachedDbs = true;
        //}
        //SQLiteStatement statement = new SQLiteStatement(this, sql, bindArgs);
        //try {
            //return statement.executeUpdateDelete();
        //} catch (SQLiteDatabaseCorruptException e) {
            //onCorruption();
            //throw e;
        //} finally {
            //statement.close();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.621 -0400", hash_original_method = "2C203F91898576B00C917F0CD42A518A", hash_generated_method = "A7607F76A5C0EDF2B8E22D02A10EA106")
    @Override
    protected void finalize() throws Throwable {
        try 
        {
            if(isOpen())            
            {
                closeClosable();
                onAllReferencesReleased();
                releaseCustomFunctions();
            } //End block
        } //End block
        finally 
        {
            super.finalize();
        } //End block
        // ---------- Original Method ----------
        //try {
            //if (isOpen()) {
                //Log.e(TAG, "close() was never explicitly called on database '" +
                        //mPath + "' ", mStackTrace);
                //closeClosable();
                //onAllReferencesReleased();
                //releaseCustomFunctions();
            //}
        //} finally {
            //super.finalize();
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.621 -0400", hash_original_method = "B8251338AB8EB8352A863E35E41B939B", hash_generated_method = "384F0EB83B6D095C602249859DDA26BF")
    public boolean isReadOnly() {
        boolean var36294417069D577EEA9BD86FA01F52A4_599846895 = ((mFlags & OPEN_READ_MASK) == OPEN_READONLY);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2048621634 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2048621634;
        // ---------- Original Method ----------
        //return (mFlags & OPEN_READ_MASK) == OPEN_READONLY;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.621 -0400", hash_original_method = "61E254D128D08D9B7DD7C5EEB86B883E", hash_generated_method = "66E9BDBFAE260371A90920CC1A5D5C83")
    public boolean isOpen() {
        boolean var6952EFEAC49FB3C8A90BB7144BF655F1_399863642 = (mNativeHandle != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1370021147 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1370021147;
        // ---------- Original Method ----------
        //return mNativeHandle != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.622 -0400", hash_original_method = "4C8276EC0F604B529F31103A74E610FF", hash_generated_method = "D13BBAAC421143E4C8314E29E5D77CF4")
    public boolean needUpgrade(int newVersion) {
        addTaint(newVersion);
        boolean varFA8E2877429A28605B47275CD828EDC1_1482711501 = (newVersion > getVersion());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_181129762 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_181129762;
        // ---------- Original Method ----------
        //return newVersion > getVersion();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.622 -0400", hash_original_method = "F177C5B02553C0E0327F321BDDCEAFD5", hash_generated_method = "02101306BB823E5D186FE4FD88AB93BA")
    public final String getPath() {
String var6AF672BCA4D9DB76D759DE4D6BEB1D5F_1537492390 =         mPath;
        var6AF672BCA4D9DB76D759DE4D6BEB1D5F_1537492390.addTaint(taint);
        return var6AF672BCA4D9DB76D759DE4D6BEB1D5F_1537492390;
        // ---------- Original Method ----------
        //return mPath;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.622 -0400", hash_original_method = "0D21C1E893B83D945127726B58A78BA2", hash_generated_method = "74FF10032F9E41D653AB1E7E336609D4")
     void logTimeStat(String sql, long beginMillis) {
        addTaint(beginMillis);
        addTaint(sql.getTaint());
        if(ENABLE_DB_SAMPLE)        
        {
            logTimeStat(sql, beginMillis, null);
        } //End block
        // ---------- Original Method ----------
        //if (ENABLE_DB_SAMPLE) {
            //logTimeStat(sql, beginMillis, null);
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.624 -0400", hash_original_method = "8ED8142AF940938322CF345006300B7D", hash_generated_method = "A0486B854F147CFE5B906A59E68EC276")
    private void logTimeStat(String sql, long beginMillis, String prefix) {
        addTaint(prefix.getTaint());
        addTaint(beginMillis);
        addTaint(sql.getTaint());
        int samplePercent;
        long durationMillis = SystemClock.uptimeMillis() - beginMillis;
        if(durationMillis == 0 && prefix == GET_LOCK_LOG_PREFIX)        
        {
            return;
        } //End block
        if(sQueryLogTimeInMillis == 0)        
        {
            sQueryLogTimeInMillis = SystemProperties.getInt("db.db_operation.threshold_ms", 500);
        } //End block
        if(durationMillis >= sQueryLogTimeInMillis)        
        {
            samplePercent = 100;
        } //End block
        else
        {
            samplePercent = (int) (100 * durationMillis / sQueryLogTimeInMillis) + 1;
            if(mRandom.nextInt(100) >= samplePercent)            
            return;
        } //End block
        if(prefix != null)        
        {
            sql = prefix + sql;
        } //End block
        if(sql.length() > QUERY_LOG_SQL_LENGTH)        
        sql = sql.substring(0, QUERY_LOG_SQL_LENGTH);
        String blockingPackage = AppGlobals.getInitialPackage();
        if(blockingPackage == null)        
        blockingPackage = "";
        EventLog.writeEvent(
            EVENT_DB_OPERATION,
            getPathForLogs(),
            sql,
            durationMillis,
            blockingPackage,
            samplePercent);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.625 -0400", hash_original_method = "BAC313652C0D08E8CD159DBA09E31731", hash_generated_method = "485FBA1CD425B62042F84160751B2818")
    private String getPathForLogs() {
        if(mPathForLogs != null)        
        {
String varDF5C62998ABFC21110F9C271D7872BD4_256429590 =             mPathForLogs;
            varDF5C62998ABFC21110F9C271D7872BD4_256429590.addTaint(taint);
            return varDF5C62998ABFC21110F9C271D7872BD4_256429590;
        } //End block
        if(mPath == null)        
        {
String var540C13E9E156B687226421B24F2DF178_1029129088 =             null;
            var540C13E9E156B687226421B24F2DF178_1029129088.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1029129088;
        } //End block
        if(mPath.indexOf('@') == -1)        
        {
            mPathForLogs = mPath;
        } //End block
        else
        {
            mPathForLogs = EMAIL_IN_DB_PATTERN.matcher(mPath).replaceAll("XX@YY");
        } //End block
String varDF5C62998ABFC21110F9C271D7872BD4_688368384 =         mPathForLogs;
        varDF5C62998ABFC21110F9C271D7872BD4_688368384.addTaint(taint);
        return varDF5C62998ABFC21110F9C271D7872BD4_688368384;
        // ---------- Original Method ----------
        //if (mPathForLogs != null) {
            //return mPathForLogs;
        //}
        //if (mPath == null) {
            //return null;
        //}
        //if (mPath.indexOf('@') == -1) {
            //mPathForLogs = mPath;
        //} else {
            //mPathForLogs = EMAIL_IN_DB_PATTERN.matcher(mPath).replaceAll("XX@YY");
        //}
        //return mPathForLogs;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.626 -0400", hash_original_method = "3FAFCE8DADACDA6029D741D00EA768C4", hash_generated_method = "E81F955A2EB3DA7D7A0CAE0AF946254D")
    public void setLocale(Locale locale) {
        addTaint(locale.getTaint());
        lock();
        try 
        {
            native_setLocale(locale.toString(), mFlags);
        } //End block
        finally 
        {
            unlock();
        } //End block
        // ---------- Original Method ----------
        //lock();
        //try {
            //native_setLocale(locale.toString(), mFlags);
        //} finally {
            //unlock();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.626 -0400", hash_original_method = "82F89F6027C136BD18FB9173DDA585C3", hash_generated_method = "D142F177BAD5D8F3F5EB9099B33739BA")
     void verifyDbIsOpen() {
        if(!isOpen())        
        {
            IllegalStateException var0947A6FFE91188EE87D4F89FDD2C82CF_493764350 = new IllegalStateException("database " + getPath() + " (conn# " +
                    mConnectionNum + ") already closed");
            var0947A6FFE91188EE87D4F89FDD2C82CF_493764350.addTaint(taint);
            throw var0947A6FFE91188EE87D4F89FDD2C82CF_493764350;
        } //End block
        // ---------- Original Method ----------
        //if (!isOpen()) {
            //throw new IllegalStateException("database " + getPath() + " (conn# " +
                    //mConnectionNum + ") already closed");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.627 -0400", hash_original_method = "2ABE5777D3030A58042EA8C11F6A64FB", hash_generated_method = "E09D067BEF75F7A320F691374E69EBA4")
     void verifyLockOwner() {
        verifyDbIsOpen();
        if(mLockingEnabled && !isDbLockedByCurrentThread())        
        {
            IllegalStateException var37883286389DD733C9EA5F7C92FC22F9_153003187 = new IllegalStateException("Don't have database lock!");
            var37883286389DD733C9EA5F7C92FC22F9_153003187.addTaint(taint);
            throw var37883286389DD733C9EA5F7C92FC22F9_153003187;
        } //End block
        // ---------- Original Method ----------
        //verifyDbIsOpen();
        //if (mLockingEnabled && !isDbLockedByCurrentThread()) {
            //throw new IllegalStateException("Don't have database lock!");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.628 -0400", hash_original_method = "1F50605826534D1D8A189D3DC15DE94F", hash_generated_method = "BB0BF6277465F4CADAE2FD80E75A7A5B")
    synchronized void addToCompiledQueries(
            String sql, SQLiteCompiledSql compiledStatement) {
        addTaint(compiledStatement.getTaint());
        addTaint(sql.getTaint());
        if(mCompiledQueries.get(sql) != null)        
        {
            return;
        } //End block
        int maxCacheSz = (mConnectionNum == 0) ? mCompiledQueries.maxSize() :
                mParentConnObj.mCompiledQueries.maxSize();
        if(SQLiteDebug.DEBUG_SQL_CACHE)        
        {
            boolean printWarning = (mConnectionNum == 0)
                    ? (!mCacheFullWarning && mCompiledQueries.size() == maxCacheSz)
                    : (!mParentConnObj.mCacheFullWarning &&
                    mParentConnObj.mCompiledQueries.size() == maxCacheSz);
            if(printWarning)            
            {
                mCacheFullWarning = true;
                Log.d(TAG, "Here are the SQL statements in Cache of database: " + mPath);
for(String s : mCompiledQueries.snapshot().keySet())
                {
                    Log.d(TAG, "Sql statement in Cache: " + s);
                } //End block
            } //End block
        } //End block
        mCompiledQueries.put(sql, compiledStatement);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.629 -0400", hash_original_method = "CE0C87ACDC099813F3D6D588DE2B56CF", hash_generated_method = "322CA9C4AF0AE19D7D465FD8146A853F")
    synchronized void deallocCachedSqlStatements() {
for(SQLiteCompiledSql compiledSql : mCompiledQueries.snapshot().values())
        {
            compiledSql.releaseSqlStatement();
        } //End block
        mCompiledQueries.evictAll();
        // ---------- Original Method ----------
        //for (SQLiteCompiledSql compiledSql : mCompiledQueries.snapshot().values()) {
            //compiledSql.releaseSqlStatement();
        //}
        //mCompiledQueries.evictAll();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.629 -0400", hash_original_method = "A3F9326C17119FEC2A90D0724FE482CF", hash_generated_method = "A900C8891D88D65992923CE45FCCA18B")
    synchronized SQLiteCompiledSql getCompiledStatementForSql(String sql) {
        addTaint(sql.getTaint());
SQLiteCompiledSql var9F0A7F1AF09C3A292F26C4AC047BC2E1_1021660215 =         mCompiledQueries.get(sql);
        var9F0A7F1AF09C3A292F26C4AC047BC2E1_1021660215.addTaint(taint);
        return var9F0A7F1AF09C3A292F26C4AC047BC2E1_1021660215;
        // ---------- Original Method ----------
        //return mCompiledQueries.get(sql);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.631 -0400", hash_original_method = "986DCF2E02788969CC84FF6D84C81E71", hash_generated_method = "B75FCCB59A1A0AAED9582EF0AA2568EB")
    public void setMaxSqlCacheSize(int cacheSize) {
        synchronized
(this)        {
            LruCache<String, SQLiteCompiledSql> oldCompiledQueries = mCompiledQueries;
            if(cacheSize > MAX_SQL_CACHE_SIZE || cacheSize < 0)            
            {
                IllegalStateException var5012919EDBC0D151A6C270907E44577F_1033219340 = new IllegalStateException(
                        "expected value between 0 and " + MAX_SQL_CACHE_SIZE);
                var5012919EDBC0D151A6C270907E44577F_1033219340.addTaint(taint);
                throw var5012919EDBC0D151A6C270907E44577F_1033219340;
            } //End block
            else
            if(oldCompiledQueries != null && cacheSize < oldCompiledQueries.maxSize())            
            {
                IllegalStateException var325AC93AC3A8216D94109299E6891532_1769476857 = new IllegalStateException("cannot set cacheSize to a value less than the "
                        + "value set with previous setMaxSqlCacheSize() call.");
                var325AC93AC3A8216D94109299E6891532_1769476857.addTaint(taint);
                throw var325AC93AC3A8216D94109299E6891532_1769476857;
            } //End block
            mCompiledQueries = new LruCache<String, SQLiteCompiledSql>(cacheSize) {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.630 -0400", hash_original_method = "0287FECCFAEBE5DF6977A7998D9D230B", hash_generated_method = "E0BFEF4F5AFB0202C32411DDAE00BFA7")
        @Override
        protected void entryRemoved(boolean evicted, String key, SQLiteCompiledSql oldValue,
                        SQLiteCompiledSql newValue) {
            addTaint(newValue.getTaint());
            addTaint(oldValue.getTaint());
            addTaint(key.getTaint());
            addTaint(evicted);
            verifyLockOwner();
            oldValue.releaseIfNotInUse();
            // ---------- Original Method ----------
            //verifyLockOwner();
            //oldValue.releaseIfNotInUse();
        }
};
            if(oldCompiledQueries != null)            
            {
for(Map.Entry<String, SQLiteCompiledSql> entry : oldCompiledQueries.snapshot().entrySet())
                {
                    mCompiledQueries.put(entry.getKey(), entry.getValue());
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.631 -0400", hash_original_method = "4517A8954B6715406427A020C27CB67E", hash_generated_method = "5CE98343A55FF4651A677F611A07A408")
    synchronized boolean isInStatementCache(String sql) {
        addTaint(sql.getTaint());
        boolean var8F89F5B66ECEDE91BE3991C339B7BF1C_1469849132 = (mCompiledQueries.get(sql) != null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_266771839 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_266771839;
        // ---------- Original Method ----------
        //return mCompiledQueries.get(sql) != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.631 -0400", hash_original_method = "1314F31979BFAD21CD00C204B07606A6", hash_generated_method = "F1D82EE1693BFA9AD1B21FAD87B6F4A1")
    synchronized void releaseCompiledSqlObj(
            String sql, SQLiteCompiledSql compiledSql) {
        addTaint(compiledSql.getTaint());
        addTaint(sql.getTaint());
        if(mCompiledQueries.get(sql) == compiledSql)        
        {
            compiledSql.release();
        } //End block
        else
        {
            compiledSql.releaseSqlStatement();
        } //End block
        // ---------- Original Method ----------
        //if (mCompiledQueries.get(sql) == compiledSql) {
            //compiledSql.release();
        //} else {
            //compiledSql.releaseSqlStatement();
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.632 -0400", hash_original_method = "8B250436E1E22A5062E1C40EC7B14D91", hash_generated_method = "44D38DA294DEF28AEA340AA84E698277")
    private synchronized int getCacheHitNum() {
        int var322DA19D24A3D3B76726EFEB5EF14F24_1333157654 = (mCompiledQueries.hitCount());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1745211236 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1745211236;
        // ---------- Original Method ----------
        //return mCompiledQueries.hitCount();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.632 -0400", hash_original_method = "043FFEAEE6F40014DEE09BB2B945E7E0", hash_generated_method = "C7B8AD4DB53362C090C8134FB04597DF")
    private synchronized int getCacheMissNum() {
        int var03D1BBAF33262A3B8D40BC46A651DDEF_1307467619 = (mCompiledQueries.missCount());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1838318762 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1838318762;
        // ---------- Original Method ----------
        //return mCompiledQueries.missCount();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.633 -0400", hash_original_method = "BE154D77F9855AEAD67382AAA286976D", hash_generated_method = "702972B58B257D90070B0CC5250E1C9A")
    private synchronized int getCachesize() {
        int var088CE0E5E9A42C2C8387687DBAD245B7_2013564203 = (mCompiledQueries.size());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_512605305 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_512605305;
        // ---------- Original Method ----------
        //return mCompiledQueries.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.633 -0400", hash_original_method = "5A385C2ADA8821372998CC92DEC1F051", hash_generated_method = "BB41487B2AE018E798FC7C6B6426D377")
     void finalizeStatementLater(int id) {
        addTaint(id);
        if(!isOpen())        
        {
            return;
        } //End block
        synchronized
(mClosedStatementIds)        {
            if(mClosedStatementIds.contains(id))            
            {
                return;
            } //End block
            mClosedStatementIds.add(id);
        } //End block
        // ---------- Original Method ----------
        //if (!isOpen()) {
            //return;
        //}
        //synchronized(mClosedStatementIds) {
            //if (mClosedStatementIds.contains(id)) {
                //return;
            //}
            //mClosedStatementIds.add(id);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.634 -0400", hash_original_method = "155C9044FA9A1FA1A4DC8EF486B34E28", hash_generated_method = "E52042A9A05E2896FF8D4091E259F8AA")
     boolean isInQueueOfStatementsToBeFinalized(int id) {
        addTaint(id);
        if(!isOpen())        
        {
            boolean varB326B5062B2F0E69046810717534CB09_976080271 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_438340160 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_438340160;
        } //End block
        synchronized
(mClosedStatementIds)        {
            boolean var90B296B053310EE4D8AD831404FF5A2B_981044621 = (mClosedStatementIds.contains(id));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1950822320 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1950822320;
        } //End block
        // ---------- Original Method ----------
        //if (!isOpen()) {
            //return true;
        //}
        //synchronized(mClosedStatementIds) {
            //return mClosedStatementIds.contains(id);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.636 -0400", hash_original_method = "D5552224B16C0AA0A430699F6F165E27", hash_generated_method = "5AAE50B828CBDBA6C60C7D83960A96DC")
     void closePendingStatements() {
        if(!isOpen())        
        {
            mClosedStatementIds.clear();
            return;
        } //End block
        verifyLockOwner();
        ArrayList<Integer> list = new ArrayList<Integer>(mClosedStatementIds.size());
        synchronized
(mClosedStatementIds)        {
            list.addAll(mClosedStatementIds);
            mClosedStatementIds.clear();
        } //End block
        int size = list.size();
for(int i = 0;i < size;i++)
        {
            native_finalize(list.get(i));
        } //End block
        // ---------- Original Method ----------
        //if (!isOpen()) {
            //mClosedStatementIds.clear();
            //return;
        //}
        //verifyLockOwner();
        //ArrayList<Integer> list = new ArrayList<Integer>(mClosedStatementIds.size());
        //synchronized(mClosedStatementIds) {
            //list.addAll(mClosedStatementIds);
            //mClosedStatementIds.clear();
        //}
        //int size = list.size();
        //for (int i = 0; i < size; i++) {
            //native_finalize(list.get(i));
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.637 -0400", hash_original_method = "22B8BC0E5EAC4A96A93EF5FA02A6A3E4", hash_generated_method = "C456D4D3B48810B224EEE2BEDD0E4D3E")
     ArrayList<Integer> getQueuedUpStmtList() {
ArrayList<Integer> var0084AC26CAA64BD68D68ADBD7C3F1253_1573057631 =         mClosedStatementIds;
        var0084AC26CAA64BD68D68ADBD7C3F1253_1573057631.addTaint(taint);
        return var0084AC26CAA64BD68D68ADBD7C3F1253_1573057631;
        // ---------- Original Method ----------
        //return mClosedStatementIds;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.638 -0400", hash_original_method = "D499CBE556FD537E95FAF5696995EFF8", hash_generated_method = "3C14C6C2699A0F2B8E7FB274AFBC03BF")
    public boolean enableWriteAheadLogging() {
        if(isReadOnly())        
        {
            boolean var68934A3E9455FA72420237EB05902327_1621465685 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_57631223 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_57631223;
        } //End block
        lock();
        try 
        {
            if(mConnectionPool != null)            
            {
                boolean varB326B5062B2F0E69046810717534CB09_1915905428 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1174619705 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1174619705;
            } //End block
            if(mPath.equalsIgnoreCase(MEMORY_DB_PATH))            
            {
                boolean var68934A3E9455FA72420237EB05902327_1565829156 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_809864910 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_809864910;
            } //End block
            if(mHasAttachedDbs)            
            {
                if(Log.isLoggable(TAG, Log.DEBUG))                
                {
                    Log.d(TAG,
                            "this database: " + mPath + " has attached databases. can't  enable WAL.");
                } //End block
                boolean var68934A3E9455FA72420237EB05902327_131061382 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_706261707 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_706261707;
            } //End block
            mConnectionPool = new DatabaseConnectionPool(this);
            setJournalMode(mPath, "WAL");
            boolean varB326B5062B2F0E69046810717534CB09_1218169404 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1084930921 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1084930921;
        } //End block
        finally 
        {
            unlock();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.639 -0400", hash_original_method = "85CDE9F0FF49E9AFE9EC3200C3C50766", hash_generated_method = "7496B37A773F3911D5630BF901EF06F2")
    public void disableWriteAheadLogging() {
        lock();
        try 
        {
            if(mConnectionPool == null)            
            {
                return;
            } //End block
            mConnectionPool.close();
            setJournalMode(mPath, "TRUNCATE");
            mConnectionPool = null;
        } //End block
        finally 
        {
            unlock();
        } //End block
        // ---------- Original Method ----------
        //lock();
        //try {
            //if (mConnectionPool == null) {
                //return; 
            //}
            //mConnectionPool.close();
            //setJournalMode(mPath, "TRUNCATE");
            //mConnectionPool = null;
        //} finally {
            //unlock();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.640 -0400", hash_original_method = "E2BFDDA904D316A8C889FACE46B854F6", hash_generated_method = "7EA0C67048A9D77B8A599D969B6107A1")
     SQLiteDatabase getDatabaseHandle(String sql) {
        addTaint(sql.getTaint());
        if(isPooledConnection())        
        {
            if(isOpen() && !amIInTransaction())            
            {
SQLiteDatabase var72A74007B2BE62B849F475C7BDA4658B_45511919 =                 this;
                var72A74007B2BE62B849F475C7BDA4658B_45511919.addTaint(taint);
                return var72A74007B2BE62B849F475C7BDA4658B_45511919;
            } //End block
            else
            {
SQLiteDatabase varA73916C386A0B8C0CAC74B735D8DF48A_301938989 =                 getParentDbConnObj().getDbConnection(sql);
                varA73916C386A0B8C0CAC74B735D8DF48A_301938989.addTaint(taint);
                return varA73916C386A0B8C0CAC74B735D8DF48A_301938989;
            } //End block
        } //End block
        else
        {
SQLiteDatabase varF5ECA5E9F57D4CDF60641E2D4F4776CB_250969032 =             getDbConnection(sql);
            varF5ECA5E9F57D4CDF60641E2D4F4776CB_250969032.addTaint(taint);
            return varF5ECA5E9F57D4CDF60641E2D4F4776CB_250969032;
        } //End block
        // ---------- Original Method ----------
        //if (isPooledConnection()) {
            //if (isOpen() && !amIInTransaction()) {
                //return this;
            //} else {
                //return getParentDbConnObj().getDbConnection(sql);
            //}
        //} else {
            //return getDbConnection(sql);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.640 -0400", hash_original_method = "3237D800F466D0C40C278AA082141CB7", hash_generated_method = "0F4874534DBE814F742BACD923C46963")
     SQLiteDatabase createPoolConnection(short connectionNum) {
        addTaint(connectionNum);
        SQLiteDatabase db = openDatabase(mPath, mFactory, mFlags, mErrorHandler, connectionNum);
        db.mParentConnObj = this;
SQLiteDatabase var2F732BA7E0C8A6B94C1D7B25B6A078BE_530253729 =         db;
        var2F732BA7E0C8A6B94C1D7B25B6A078BE_530253729.addTaint(taint);
        return var2F732BA7E0C8A6B94C1D7B25B6A078BE_530253729;
        // ---------- Original Method ----------
        //SQLiteDatabase db = openDatabase(mPath, mFactory, mFlags, mErrorHandler, connectionNum);
        //db.mParentConnObj = this;
        //return db;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.641 -0400", hash_original_method = "205546EE310EB84028F43CE65A7EC94C", hash_generated_method = "2DBD5AC06C0817DB1212CDB83D0E879B")
    private synchronized SQLiteDatabase getParentDbConnObj() {
SQLiteDatabase varB5ACC923BED14DF553E5EF2A3C356F24_590120208 =         mParentConnObj;
        varB5ACC923BED14DF553E5EF2A3C356F24_590120208.addTaint(taint);
        return varB5ACC923BED14DF553E5EF2A3C356F24_590120208;
        // ---------- Original Method ----------
        //return mParentConnObj;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.641 -0400", hash_original_method = "D4EECEC449FC4C156499058FCB2B2B85", hash_generated_method = "AFD42E13868176A9647ECC804F35C665")
    private boolean isPooledConnection() {
        boolean var5F6655DBD097E3B95DC488F99A92A4B4_716086879 = (this.mConnectionNum > 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1974854021 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1974854021;
        // ---------- Original Method ----------
        //return this.mConnectionNum > 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.642 -0400", hash_original_method = "B485A553653CD27E64DDB9F45483F96A", hash_generated_method = "6A5B6F6475EE80EBC4F86AEAE52A1C51")
     SQLiteDatabase getDbConnection(String sql) {
        addTaint(sql.getTaint());
        verifyDbIsOpen();
        if(isPooledConnection())        
        {
SQLiteDatabase var72A74007B2BE62B849F475C7BDA4658B_732570254 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_732570254.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_732570254;
        } //End block
        if(amIInTransaction() || mConnectionPool == null)        
        {
SQLiteDatabase var72A74007B2BE62B849F475C7BDA4658B_15251745 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_15251745.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_15251745;
        } //End block
        else
        {
            if(Log.isLoggable(TAG, Log.DEBUG))            
            {
            } //End block
SQLiteDatabase varD09C8971185D99DED04CBB5CF2D67767_1666186808 =             mConnectionPool.get(sql);
            varD09C8971185D99DED04CBB5CF2D67767_1666186808.addTaint(taint);
            return varD09C8971185D99DED04CBB5CF2D67767_1666186808;
        } //End block
        // ---------- Original Method ----------
        //verifyDbIsOpen();
        //if (isPooledConnection()) {
            //return this;
        //}
        //if (amIInTransaction() || mConnectionPool == null) {
            //return this;
        //} else {
            //if (Log.isLoggable(TAG, Log.DEBUG)) {
                //assert mConnectionPool != null;
                //Log.i(TAG, mConnectionPool.toString());
            //}
            //return mConnectionPool.get(sql);
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.643 -0400", hash_original_method = "2B099A526E7EBE8C0C20DFBE797D578C", hash_generated_method = "4FD4EB1660C36020081514CF342BB0C3")
    private void releaseDbConnection(SQLiteDatabase db) {
        addTaint(db.getTaint());
        if(!isOpen() || !db.isPooledConnection() || (db == this))        
        {
            return;
        } //End block
        if(Log.isLoggable(TAG, Log.DEBUG))        
        {
            Log.d(TAG, "releaseDbConnection threadid = " + Thread.currentThread().getId() +
                    ", releasing # " + db.mConnectionNum + ", " + getPath());
        } //End block
        mConnectionPool.release(db);
        // ---------- Original Method ----------
        //if (!isOpen() || !db.isPooledConnection() || (db == this)) {
            //return;
        //}
        //if (Log.isLoggable(TAG, Log.DEBUG)) {
            //assert isPooledConnection();
            //assert mConnectionPool != null;
            //Log.d(TAG, "releaseDbConnection threadid = " + Thread.currentThread().getId() +
                    //", releasing # " + db.mConnectionNum + ", " + getPath());
        //}
        //mConnectionPool.release(db);
    }

    
    static ArrayList<DbStats> getDbStats() {
        ArrayList<DbStats> dbStatsList = new ArrayList<DbStats>();
        ArrayList<WeakReference<SQLiteDatabase>> tempList;
        synchronized(mActiveDatabases) {
            tempList = (ArrayList<WeakReference<SQLiteDatabase>>)mActiveDatabases.clone();
        }
        for (WeakReference<SQLiteDatabase> w : tempList) {
            SQLiteDatabase db = w.get();
            if (db == null || !db.isOpen()) {
                continue;
            }
            try {
                int lookasideUsed = db.native_getDbLookaside();
                String path = db.getPath();
                int indx = path.lastIndexOf("/");
                String lastnode = path.substring((indx != -1) ? ++indx : 0);
                List<Pair<String, String>> attachedDbs = db.getAttachedDbs();
                if (attachedDbs == null) {
                    continue;
                }
                for (int i = 0; i < attachedDbs.size(); i++) {
                    Pair<String, String> p = attachedDbs.get(i);
                    long pageCount = DatabaseUtils.longForQuery(db, "PRAGMA " + p.first
                            + ".page_count;", null);
                    String dbName;
                    if (i == 0) {
                        dbName = lastnode;
                    } else {
                        lookasideUsed = 0;
                        dbName = "  (attached) " + p.first;
                        if (p.second.trim().length() > 0) {
                            int idx = p.second.lastIndexOf("/");
                            dbName += " : " + p.second.substring((idx != -1) ? ++idx : 0);
                        }
                    }
                    if (pageCount > 0) {
                        dbStatsList.add(new DbStats(dbName, pageCount, db.getPageSize(),
                                lookasideUsed, db.getCacheHitNum(), db.getCacheMissNum(),
                                db.getCachesize()));
                    }
                }
                DatabaseConnectionPool connPool = db.mConnectionPool;
                if (connPool != null) {
                    for (SQLiteDatabase pDb : connPool.getConnectionList()) {
                        dbStatsList.add(new DbStats("(pooled # " + pDb.mConnectionNum + ") "
                                + lastnode, 0, 0, 0, pDb.getCacheHitNum(),
                                pDb.getCacheMissNum(), pDb.getCachesize()));
                    }
                }
            } catch (SQLiteException e) {
            }
        }
        return dbStatsList;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.644 -0400", hash_original_method = "40C4DE1C4808AAF54B97D30ED440E3DF", hash_generated_method = "EB81B498D1054686D8E6B13EB3017C47")
    public List<Pair<String, String>> getAttachedDbs() {
        if(!isOpen())        
        {
List<Pair<String, String>> var540C13E9E156B687226421B24F2DF178_549444788 =             null;
            var540C13E9E156B687226421B24F2DF178_549444788.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_549444788;
        } //End block
        ArrayList<Pair<String, String>> attachedDbs = new ArrayList<Pair<String, String>>();
        if(!mHasAttachedDbs)        
        {
            attachedDbs.add(new Pair<String, String>("main", mPath));
List<Pair<String, String>> var9593CDD5CA41EF2474A02A0F9B86D41E_1457371309 =             attachedDbs;
            var9593CDD5CA41EF2474A02A0F9B86D41E_1457371309.addTaint(taint);
            return var9593CDD5CA41EF2474A02A0F9B86D41E_1457371309;
        } //End block
        Cursor c = null;
        try 
        {
            c = rawQuery("pragma database_list;", null);
            while
(c.moveToNext())            
            {
                attachedDbs.add(new Pair<String, String>(c.getString(1), c.getString(2)));
            } //End block
        } //End block
        finally 
        {
            if(c != null)            
            {
                c.close();
            } //End block
        } //End block
List<Pair<String, String>> var9593CDD5CA41EF2474A02A0F9B86D41E_872983090 =         attachedDbs;
        var9593CDD5CA41EF2474A02A0F9B86D41E_872983090.addTaint(taint);
        return var9593CDD5CA41EF2474A02A0F9B86D41E_872983090;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.645 -0400", hash_original_method = "F327316761A478EA142E408A35654FE2", hash_generated_method = "4C38871560484E0E327184A9E3836441")
    public boolean isDatabaseIntegrityOk() {
        verifyDbIsOpen();
        List<Pair<String, String>> attachedDbs = null;
        try 
        {
            attachedDbs = getAttachedDbs();
            if(attachedDbs == null)            
            {
                IllegalStateException var749D452026CFB6F3ABFC79893B86F4EB_246894394 = new IllegalStateException("databaselist for: " + getPath() + " couldn't " +
                        "be retrieved. probably because the database is closed");
                var749D452026CFB6F3ABFC79893B86F4EB_246894394.addTaint(taint);
                throw var749D452026CFB6F3ABFC79893B86F4EB_246894394;
            } //End block
        } //End block
        catch (SQLiteException e)
        {
            attachedDbs = new ArrayList<Pair<String, String>>();
            attachedDbs.add(new Pair<String, String>("main", this.mPath));
        } //End block
for(int i = 0;i < attachedDbs.size();i++)
        {
            Pair<String, String> p = attachedDbs.get(i);
            SQLiteStatement prog = null;
            try 
            {
                prog = compileStatement("PRAGMA " + p.first + ".integrity_check(1);");
                String rslt = prog.simpleQueryForString();
                if(!rslt.equalsIgnoreCase("ok"))                
                {
                    boolean var68934A3E9455FA72420237EB05902327_396783559 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1922645118 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1922645118;
                } //End block
            } //End block
            finally 
            {
                if(prog != null)                
                prog.close();
            } //End block
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_130240530 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1545595581 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1545595581;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.654 -0400", hash_original_method = "8D335FE0EDA9A8017E889380A7A722CF", hash_generated_method = "7DC2BD660B2CDC6483080370E51D7A42")
    private void dbopen(String path, int flags) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.655 -0400", hash_original_method = "70E20853624884484C3836EF6F149A55", hash_generated_method = "079E6181584D18FF7794E2CCCC7EC698")
    private void enableSqlTracing(String path, short connectionNum) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.656 -0400", hash_original_method = "C8A96013E7D0E582573D33F32AE9CEB2", hash_generated_method = "8E4CC6A847CB4D4A755E1D378C2FD667")
    private void enableSqlProfiling(String path, short connectionNum) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.656 -0400", hash_original_method = "D6178DAC9B84DE9466B1B633DF097ED8", hash_generated_method = "4E544159901989F8659751014F855197")
    private void native_setLocale(String loc, int flags) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.656 -0400", hash_original_method = "94C6AE32C9A996CB80A0C1FADFD7D1F2", hash_generated_method = "E99A49606965DBBCFC193334532DADB3")
    private int native_getDbLookaside() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1117067900 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1117067900;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.656 -0400", hash_original_method = "C4F8F8FDF64373EAEBE82B2B8F80D5C0", hash_generated_method = "E6AC894F82F9E2B742C2DEB8A39D8080")
    private final void native_finalize(int statementId) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.660 -0400", hash_original_method = "324F9A57AA3484DEBE48152EFBF728CA", hash_generated_method = "0CEE753090AC8DD2CCDAA7F7430628D4")
    private void native_setSqliteSoftHeapLimit(int softHeapLimit) {
    }

    
    private static class DatabaseReentrantLock extends ReentrantLock {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.668 -0400", hash_original_method = "FF2E769A330F113FDEF775F7B9F0F4EF", hash_generated_method = "31CB5E32D763205F06BFE445BA191A42")
          DatabaseReentrantLock(boolean fair) {
            super(fair);
            addTaint(fair);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.673 -0400", hash_original_method = "1BB82FD0B3090B035906C5C5A5300D7F", hash_generated_method = "38CF20FD65780FF8A18C4A44765BA3A1")
        @Override
        public Thread getOwner() {
Thread var9339B408D15ACEBD23DAAE73BA89B0F6_1849379444 =             super.getOwner();
            var9339B408D15ACEBD23DAAE73BA89B0F6_1849379444.addTaint(taint);
            return var9339B408D15ACEBD23DAAE73BA89B0F6_1849379444;
            // ---------- Original Method ----------
            //return super.getOwner();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.676 -0400", hash_original_method = "0A30C3A8A16B3E36E180D94391681301", hash_generated_method = "44851D7461BF6DDB0A50B37382C40917")
        public String getOwnerDescription() {
            Thread t = getOwner();
String var19DD9E73F4087CD137294D2178EAC43F_1438865547 =             (t== null) ? "none" : String.valueOf(t.getId());
            var19DD9E73F4087CD137294D2178EAC43F_1438865547.addTaint(taint);
            return var19DD9E73F4087CD137294D2178EAC43F_1438865547;
            // ---------- Original Method ----------
            //Thread t = getOwner();
            //return (t== null) ? "none" : String.valueOf(t.getId());
        }

        
    }


    
    public interface CursorFactory {
        
        public Cursor newCursor(SQLiteDatabase db,
                SQLiteCursorDriver masterQuery, String editTable,
                SQLiteQuery query);
    }
    
    public interface CustomFunction {
        public void callback(String[] args);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.677 -0400", hash_original_field = "D18B04353DB06786DFA19F38E1E3F9F8", hash_generated_field = "B031AA443BF0B15D9BA58FE3D3C788E6")

    private static final String TAG = "SQLiteDatabase";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.677 -0400", hash_original_field = "505A38A2470AB971646D45095C12E31F", hash_generated_field = "3548346B1EB3CE378E747DF13DAF2E94")

    private static final boolean ENABLE_DB_SAMPLE = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.677 -0400", hash_original_field = "4747FA61A14E68F397B403C3BF573138", hash_generated_field = "7C746BEBD1F52CCE281BC2AE78043C31")

    private static final int EVENT_DB_OPERATION = 52000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.678 -0400", hash_original_field = "FA2DCB40C8C2E6B3E9DC95D493219399", hash_generated_field = "9435052DF2978607705FE1A674B3B476")

    private static final int EVENT_DB_CORRUPT = 75004;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.678 -0400", hash_original_field = "790D60FA6E696D93692BA35CB0438294", hash_generated_field = "AB29804A115D818B6ACC16F36A2A6B4A")

    public static final int CONFLICT_ROLLBACK = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.678 -0400", hash_original_field = "8FF68E568D06942129BAB7786008CC27", hash_generated_field = "39B42E823E1997DA6D833E1BBD40FA58")

    public static final int CONFLICT_ABORT = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.678 -0400", hash_original_field = "117A84E9B3C20F8BD0A9D3FA05866829", hash_generated_field = "335E697F888616CE067B72F214C1BC32")

    public static final int CONFLICT_FAIL = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.678 -0400", hash_original_field = "3965F8F98E49E75266581A5EDCF28288", hash_generated_field = "46745826C06802839FCD46D51B439306")

    public static final int CONFLICT_IGNORE = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.678 -0400", hash_original_field = "63D7302A74CC755B81E5DA5FF2200F4B", hash_generated_field = "E863D6302F78EAED37A44DA0ED539003")

    public static final int CONFLICT_REPLACE = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.679 -0400", hash_original_field = "4A361B4F834FE1F0F6BB46551B141B34", hash_generated_field = "8969586D204DC9CDF495FFB0724623A9")

    public static final int CONFLICT_NONE = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.679 -0400", hash_original_field = "58CEAD30C6D151BCF416BDDB99D29495", hash_generated_field = "CEB6E56BB51D4EFBAE585B39DC049839")

    private static final String[] CONFLICT_VALUES = new String[]
            {"", " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE "};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.679 -0400", hash_original_field = "1E5817575F0E997F1243F638D5895D4E", hash_generated_field = "307B7E85D5D9B51588F8134872D28FA2")

    public static final int SQLITE_MAX_LIKE_PATTERN_LENGTH = 50000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.679 -0400", hash_original_field = "C6DEAE97C40012AF75B50C3B2999BB0A", hash_generated_field = "629E71001BC03CF7522CF9DF396F3CD0")

    public static final int OPEN_READWRITE = 0x00000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.679 -0400", hash_original_field = "902213259DEC7410D30EF3DFF53CABCB", hash_generated_field = "4E1D616F2DC9D0F7F19E42689377DE9D")

    public static final int OPEN_READONLY = 0x00000001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.680 -0400", hash_original_field = "3CE8162CF9656F8FCB8B5B90A59AD3ED", hash_generated_field = "5187312D154815C7B5E63606C7E8136A")

    private static final int OPEN_READ_MASK = 0x00000001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.680 -0400", hash_original_field = "09B9A0E2C049E747CB9560AF8560A1C4", hash_generated_field = "099AB38E222487A3F22F8D84E49C790B")

    public static final int NO_LOCALIZED_COLLATORS = 0x00000010;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.680 -0400", hash_original_field = "5D9E28D3CB398796FE04F7E00299B712", hash_generated_field = "51E7E16B8C63BFDCCFDDEE94FF22F7BB")

    public static final int CREATE_IF_NECESSARY = 0x10000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.680 -0400", hash_original_field = "963E0DAA128D9868E6CC8434473DB4B9", hash_generated_field = "2D7B5C77835222796D1E38850A1796FA")

    private static final int LOCK_WARNING_WINDOW_IN_MS = 20000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.680 -0400", hash_original_field = "E6AE6AEA20BF0D87AE52DA89192BC72A", hash_generated_field = "77D4EFADB5F65862A8907D645B6665E9")

    private static final int LOCK_ACQUIRED_WARNING_TIME_IN_MS = 300;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.680 -0400", hash_original_field = "95C6E5D7087CC2FC3A6DED5953679ECB", hash_generated_field = "A15D7DDE2E5CA3854E9FBBCADF643DF0")

    private static final int LOCK_ACQUIRED_WARNING_THREAD_TIME_IN_MS = 100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.681 -0400", hash_original_field = "7A6A59391B6242130CD71E5CD44E2D77", hash_generated_field = "C09CEC99CA0E20EA63872D1D54E55D2E")

    private static final int LOCK_ACQUIRED_WARNING_TIME_IN_MS_ALWAYS_PRINT = 2000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.681 -0400", hash_original_field = "CE309D87C3B10C71416ADF374777959F", hash_generated_field = "79E0F0AE9DE5E092336F50A45B4F8E1C")

    private static final int SLEEP_AFTER_YIELD_QUANTUM = 1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.681 -0400", hash_original_field = "5A389AB78BAF71DFE16B183F0C0E378C", hash_generated_field = "C84D9BD6B88C4ED7056C3B3F36774679")

    private static final Pattern EMAIL_IN_DB_PATTERN = Pattern.compile("[\\w\\.\\-]+@[\\w\\.\\-]+");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.681 -0400", hash_original_field = "54034B3C28E0BBADA285EC1AF26CD74C", hash_generated_field = "F4B529B387535F4368A600135D078A3F")

    private static int sQueryLogTimeInMillis = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.681 -0400", hash_original_field = "575EC464A3C910F3BE22BF3A40203271", hash_generated_field = "7148D851E918ABFB8558501AAF276067")

    private static final int QUERY_LOG_SQL_LENGTH = 64;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.681 -0400", hash_original_field = "68F17C8C6A1B7DDEBB7E0A50981231C4", hash_generated_field = "6E2686DCB15E3EED77BA00F0CDFF3560")

    private static final String COMMIT_SQL = "COMMIT;";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.681 -0400", hash_original_field = "9A60E40448B652CACF05359C701B5CC3", hash_generated_field = "6F4F9F4CA4122F0E0B63ADF311633E3F")

    private static final String BEGIN_SQL = "BEGIN;";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.682 -0400", hash_original_field = "F3551E46D929A290CE215BE1F66731CA", hash_generated_field = "B02DFFEED2F25BA54B1F54EB152A8058")

    static final String GET_LOCK_LOG_PREFIX = "GETLOCK:";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.682 -0400", hash_original_field = "5060FAACDAC84EA2DCCD0E197482A2DD", hash_generated_field = "51F4D205C63830AACD25F15FCA50EBDA")

    private static int sBlockSize = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.682 -0400", hash_original_field = "AB0CA8692820F6E5F155F4D312F65AF1", hash_generated_field = "3DC1596E29EDB016C413E70C0C6823BE")

    private static final int DEFAULT_SQL_CACHE_SIZE = 25;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.682 -0400", hash_original_field = "AD68061788347E0928ECF0DDBAB674B1", hash_generated_field = "FEBE70CE9042F617C4B8B12131A1C6AA")

    public static final int MAX_SQL_CACHE_SIZE = 100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.682 -0400", hash_original_field = "8F1610D46CA335F7A68476444639CCA5", hash_generated_field = "076429DC648CA31B53EA5479063A01DC")

    private static final String MEMORY_DB_PATH = ":memory:";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.682 -0400", hash_original_field = "B85ABB2B3844882B62C4390BDB646BAF", hash_generated_field = "6C1DD837716F02A5B85D056ED49553B5")

    private static ArrayList<WeakReference<SQLiteDatabase>> mActiveDatabases = new ArrayList<WeakReference<SQLiteDatabase>>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.683 -0400", hash_original_field = "4BCAA4A60DD2EB17A628C800025F88DA", hash_generated_field = "87A9BD3D7700EA6364DB461A232CAEB6")

    private static final long LOCK_WAIT_PERIOD = 30L;
}

