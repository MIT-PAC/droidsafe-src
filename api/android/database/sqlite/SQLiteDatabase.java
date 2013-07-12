package android.database.sqlite;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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

public class SQLiteDatabase extends SQLiteClosable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.836 -0400", hash_original_field = "2F577CFF36E03467323CF3302EA45D6C", hash_generated_field = "E7056D75F4E4E6EB0CBA6DCE1F4F880B")

    private boolean mInnerTransactionIsSuccessful;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.836 -0400", hash_original_field = "58201914BA1B4FF47E7AA07A0AC57171", hash_generated_field = "6128EACBB7FB1B535A59BE78E36968AA")

    private boolean mTransactionIsSuccessful;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.836 -0400", hash_original_field = "DE7B86B82681B1155E0009C050CFB43B", hash_generated_field = "793A3AAAFBEB0F437207EF8CF58BE261")

    private SQLiteTransactionListener mTransactionListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.836 -0400", hash_original_field = "04FD74AF5748E24AC35D8C0603418D5F", hash_generated_field = "2A25F85A83E5F358C0E921DE63F86FF2")

    private boolean mTransactionUsingExecSql;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.836 -0400", hash_original_field = "F4A7BA9A35E5B32B183DF50E4F1B2E28", hash_generated_field = "F912814B4E1DAAFDC17C50234EB3FC06")

    private final DatabaseReentrantLock mLock = new DatabaseReentrantLock(true);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.836 -0400", hash_original_field = "2B698D4C503D685ED004A6B4BAF0E658", hash_generated_field = "D440BCD52A102185E811EA93A644CB1C")

    private long mLockAcquiredWallTime = 0L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.836 -0400", hash_original_field = "05E26C9ECB3EBA196676EBEDA0B25BCF", hash_generated_field = "F25F6124FA463B622FD2DD5ABA3051C7")

    private long mLockAcquiredThreadTime = 0L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.836 -0400", hash_original_field = "0804BE3D194F1641DC0D1E5AE35F40C1", hash_generated_field = "5D29D9D368D28B86CEE0F5B707514CDA")

    private long mLastLockMessageTime = 0L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.836 -0400", hash_original_field = "536255EED7E3D46DD70E09FDE814B7C1", hash_generated_field = "E26D41E197237C24B0E74C0394AEDF83")

    private final Random mRandom = new Random();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.837 -0400", hash_original_field = "20ED2B28EBE0BAD29D7FEAFD9AF86FC5", hash_generated_field = "1CE2C34780F47FA064A655A949D3653C")

    private String mLastSqlStatement = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.837 -0400", hash_original_field = "E494CEFBB739C03E3C976C715E226811", hash_generated_field = "4ED7543F27609F494F3BFF9473206AD9")

    private long mTransStartTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.837 -0400", hash_original_field = "E86FCFA606742ADBAB1B20F7996FCC4A", hash_generated_field = "B37C03DF0BF1A86153C7C2FA952C3E00")

    volatile int mNativeHandle = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.837 -0400", hash_original_field = "FB4FCB3508FC66D4E3F113990AC335C6", hash_generated_field = "6FACC3B41470C8330B5F0BB43FA7FD9F")

    private String mPath;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.837 -0400", hash_original_field = "5CC96EA0C7233DAE6629EB63E2D17046", hash_generated_field = "0FAF2BD49EE9B945E5C01C36BBE76EC3")

    private String mPathForLogs = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.837 -0400", hash_original_field = "9C3CD7D37D3E1E66BE9B3B005FC98B3A", hash_generated_field = "43F71E9173849705E01112D0229448B4")

    private int mFlags;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.837 -0400", hash_original_field = "06389DE86ED19AB1571A41645A1AFADC", hash_generated_field = "3B314DD3362D9759017A383358149E45")

    private CursorFactory mFactory;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.837 -0400", hash_original_field = "712AB6C8C770AEF7CF757D19A4FD0E38", hash_generated_field = "7586811E7431EEE33AF976CF89950239")

    private WeakHashMap<SQLiteClosable, Object> mPrograms;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.837 -0400", hash_original_field = "60E07EDA42F3E1922C63D09AD9383086", hash_generated_field = "B49BE5C26AFC2BC39563929C5F16CB5B")

    private LruCache<String, SQLiteCompiledSql> mCompiledQueries;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.837 -0400", hash_original_field = "F6246ADED535BB5A06E89B98F4448AB0", hash_generated_field = "4E5EC633EDC17753869972551C767C68")

    private boolean mCacheFullWarning;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.837 -0400", hash_original_field = "9581B90EA40AE59A20069CB826265080", hash_generated_field = "7D1AA4359A52B133BFAD994AB60E8C14")

    private Throwable mStackTrace;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.838 -0400", hash_original_field = "8103C9EA0927CDF9D803AF1FFEC26BE1", hash_generated_field = "0D9B8E09B51F96D0F503825B2DDED11B")

    private final ArrayList<Integer> mClosedStatementIds = new ArrayList<Integer>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.838 -0400", hash_original_field = "17F47A6FF3D481E01A6A82252EB7B064", hash_generated_field = "76DD5A0A5A09A890A2237FBF965CCF6C")

    private DatabaseErrorHandler mErrorHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.838 -0400", hash_original_field = "7A6BE8614B7E2A423C6F53496DF6BA29", hash_generated_field = "C4D2A249F5C70FA118DDA6CA9913AA66")

    volatile DatabaseConnectionPool mConnectionPool = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.838 -0400", hash_original_field = "606D462EAF936BEF827280E106823795", hash_generated_field = "38AABF491E6B9AC2F1FDAC5FCB6A30E7")

    short mConnectionNum;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.838 -0400", hash_original_field = "2752BF6ACAFADFCCDA452687FCF2CED4", hash_generated_field = "4A262DC52D3676F75324E8DD3283FF83")

    SQLiteDatabase mParentConnObj = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.838 -0400", hash_original_field = "63C6D7999E4974E970EC9568F93B0B54", hash_generated_field = "760D925FEAB058AF61B1B94D2C774DE6")

    private volatile boolean mHasAttachedDbs = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.838 -0400", hash_original_field = "34BA12267248F06139E7DE34F0AE6051", hash_generated_field = "560D9A0D28C1D8056EAB428EF4EA40FE")

    private boolean mLockingEnabled = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.838 -0400", hash_original_field = "51484C5CAD4631F0A71FAFC0D9435C9A", hash_generated_field = "BCE91343C41461430195125FEC2F1572")

    private final ArrayList<Integer> mCustomFunctions = new ArrayList<Integer>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.840 -0400", hash_original_method = "ED994C20AB51232E6F0B83AA0494CFAA", hash_generated_method = "ECB8AD3DD1FB1211DB573DC581D870EE")
    private  SQLiteDatabase(String path, CursorFactory factory, int flags,
            DatabaseErrorHandler errorHandler, short connectionNum) {
    if(path == null)        
        {
            IllegalArgumentException varE4C91A561B864CD4490A03B12C2E1BD5_830202829 = new IllegalArgumentException("path should not be null");
            varE4C91A561B864CD4490A03B12C2E1BD5_830202829.addTaint(taint);
            throw varE4C91A561B864CD4490A03B12C2E1BD5_830202829;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.840 -0400", hash_original_method = "C15F9F532AF7810AA7D3562C5DDE29F6", hash_generated_method = "A115356AAC309F23468B8A293E6F205E")
    synchronized String getLastSqlStatement() {
String varE4FE602774BCA440409AAE6EFE27003F_2062308900 =         mLastSqlStatement;
        varE4FE602774BCA440409AAE6EFE27003F_2062308900.addTaint(taint);
        return varE4FE602774BCA440409AAE6EFE27003F_2062308900;
        // ---------- Original Method ----------
        //return mLastSqlStatement;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.841 -0400", hash_original_method = "3743AC991024775005FDBE1593E9891E", hash_generated_method = "77D67C706792A5CD082ECBF7B819ED3C")
    synchronized void setLastSqlStatement(String sql) {
        mLastSqlStatement = sql;
        // ---------- Original Method ----------
        //mLastSqlStatement = sql;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.841 -0400", hash_original_method = "FF36C1ABFEC0F5F1C3DFBA7FD0941B56", hash_generated_method = "E173484620D1EBE1401A8327F3ED18B3")
    synchronized void addSQLiteClosable(SQLiteClosable closable) {
        addTaint(closable.getTaint());
        mPrograms.put(closable, null);
        // ---------- Original Method ----------
        //mPrograms.put(closable, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.842 -0400", hash_original_method = "030B4AA23DD4EAEE65D260C86C2A8B4C", hash_generated_method = "508DB4907A0E2C8460B8C68D5D97D7A3")
    synchronized void removeSQLiteClosable(SQLiteClosable closable) {
        addTaint(closable.getTaint());
        mPrograms.remove(closable);
        // ---------- Original Method ----------
        //mPrograms.remove(closable);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.842 -0400", hash_original_method = "29F441CF35047DF9CBB0BC7BF2B03F36", hash_generated_method = "35CD296C0522C997A69A33875E230D54")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.843 -0400", hash_original_method = "CD58BEDD0347A27F6CFE4EB9BEFDF2F6", hash_generated_method = "A1146177C8FA9BB90B6D94105F882124")
    public void setLockingEnabled(boolean lockingEnabled) {
        mLockingEnabled = lockingEnabled;
        // ---------- Original Method ----------
        //mLockingEnabled = lockingEnabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.843 -0400", hash_original_method = "6F1C3BA1763F74F7C0395D958A12A363", hash_generated_method = "3EE5C6657C638478CD9F042AD044BF04")
     void onCorruption() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        EventLog.writeEvent(EVENT_DB_CORRUPT, mPath);
        mErrorHandler.onCorruption(this);
        // ---------- Original Method ----------
        //EventLog.writeEvent(EVENT_DB_CORRUPT, mPath);
        //mErrorHandler.onCorruption(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.843 -0400", hash_original_method = "6F6099DC841EA0266005BC3A83B18A96", hash_generated_method = "2A987EE7CB3E0BFCE2CF75EBB4A3F7FF")
     void lock(String sql) {
        addTaint(sql.getTaint());
        lock(sql, false);
        // ---------- Original Method ----------
        //lock(sql, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.843 -0400", hash_original_method = "8D6DAA6963637C0BD50884518E0FF993", hash_generated_method = "31DA195A8CACA429F53CC674AB87F7FD")
     void lock() {
        lock(null, false);
        // ---------- Original Method ----------
        //lock(null, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.844 -0400", hash_original_method = "550218B4AE04D143508369398336F95D", hash_generated_method = "E2070B94C1CF03D4ABE3B501D68A397F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.845 -0400", hash_original_method = "5F1F87633E052520A24DBAD554D491B1", hash_generated_method = "993B0F3F2A36649E79B8CF2BDCBA15D6")
    private void lockForced() {
        lock(null, true);
        // ---------- Original Method ----------
        //lock(null, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.845 -0400", hash_original_method = "E1FDB470EFF9EA86A5AAC7A627D6955E", hash_generated_method = "ACD2EB13EBB76DCBE987B683DD561C5A")
    private void lockForced(String sql) {
        addTaint(sql.getTaint());
        lock(sql, true);
        // ---------- Original Method ----------
        //lock(sql, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.845 -0400", hash_original_method = "CB05AAFAB101AFFDD598174816C61BF7", hash_generated_method = "454B48A9532576C534C73BFE34BC80FF")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.846 -0400", hash_original_method = "CA4E01B405088BC736DA3EA88D772AB0", hash_generated_method = "769FD397AA376FB38817C9515F1DC456")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.846 -0400", hash_original_method = "15FB67C6B55CF4F17EB9E05703E68C1A", hash_generated_method = "5964F5AD026B7D783FE36D8E6F77CD03")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.847 -0400", hash_original_method = "36B8D50340D02900F098E44F066CFF12", hash_generated_method = "145909AA25037E1D599C021529CE7F8B")
    public void beginTransaction() {
        beginTransaction(null , true);
        // ---------- Original Method ----------
        //beginTransaction(null , true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.847 -0400", hash_original_method = "E00D9BE9F4C6FCF885F8A6933F83E5B2", hash_generated_method = "00651A551214FF436836A41E2DCE0672")
    public void beginTransactionNonExclusive() {
        beginTransaction(null , false);
        // ---------- Original Method ----------
        //beginTransaction(null , false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.847 -0400", hash_original_method = "5BD04E9A01CA28B4B773A517F832DDF2", hash_generated_method = "343BCBE92101E138E11B3797B0664CBA")
    public void beginTransactionWithListener(SQLiteTransactionListener transactionListener) {
        addTaint(transactionListener.getTaint());
        beginTransaction(transactionListener, true);
        // ---------- Original Method ----------
        //beginTransaction(transactionListener, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.848 -0400", hash_original_method = "EB4000007896884F9C35346C5F5B9337", hash_generated_method = "04B944DB3F1AF23170795845FA857B22")
    public void beginTransactionWithListenerNonExclusive(
            SQLiteTransactionListener transactionListener) {
        addTaint(transactionListener.getTaint());
        beginTransaction(transactionListener, false);
        // ---------- Original Method ----------
        //beginTransaction(transactionListener, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.849 -0400", hash_original_method = "65C15EF02A1263C4153105EBF58851D9", hash_generated_method = "5AE1A42D6C38D809C10759CABD7323C5")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.851 -0400", hash_original_method = "94F2931FC5A304B6FE8748C95A17E4E3", hash_generated_method = "18972CF8F2B78E5998666946BBD18F06")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.853 -0400", hash_original_method = "CAD10DEB5A167AB4D97D078F2E23C48E", hash_generated_method = "A66B896CA5C845AC1B0EF76CA2E7F357")
    public void setTransactionSuccessful() {
        verifyDbIsOpen();
    if(!mLock.isHeldByCurrentThread())        
        {
            IllegalStateException varE46C5B48DD007C615B76DBFC78D5641E_623894382 = new IllegalStateException("no transaction pending");
            varE46C5B48DD007C615B76DBFC78D5641E_623894382.addTaint(taint);
            throw varE46C5B48DD007C615B76DBFC78D5641E_623894382;
        } //End block
    if(mInnerTransactionIsSuccessful)        
        {
            IllegalStateException varCC899E58C48F9959C595A19F7CA51BE2_405876816 = new IllegalStateException(
                    "setTransactionSuccessful may only be called once per call to beginTransaction");
            varCC899E58C48F9959C595A19F7CA51BE2_405876816.addTaint(taint);
            throw varCC899E58C48F9959C595A19F7CA51BE2_405876816;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.854 -0400", hash_original_method = "6E9122EA7DDDF4A7FCE3C41AA714113C", hash_generated_method = "EF3377810C2FD6BE083A78D0778CB480")
    public boolean inTransaction() {
        boolean var39EB67E59CCF7ADD3C72720C6369AF85_6848647 = (mLock.getHoldCount() > 0 || mTransactionUsingExecSql);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1838040298 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1838040298;
        // ---------- Original Method ----------
        //return mLock.getHoldCount() > 0 || mTransactionUsingExecSql;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.854 -0400", hash_original_method = "5CE93639419B30E518363E5F446309C9", hash_generated_method = "142CD70EA8CD2C060BD2C144C95F1475")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.854 -0400", hash_original_method = "37864C1F3B8C10FDA9B20AB532C7EB78", hash_generated_method = "831ED6AAAD1F0CA95D2E29662630E5E8")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.855 -0400", hash_original_method = "18141E27A4A6F223116C15568E4B1710", hash_generated_method = "7046F632CBD279EA72E273DF38C078C4")
    synchronized boolean amIInTransaction() {
        SQLiteDatabase db = (isPooledConnection()) ? mParentConnObj : this;
        boolean b = (!db.inTransaction()) ? false :
                db.mTransactionUsingExecSql || db.mLock.isHeldByCurrentThread();
    if(Log.isLoggable(TAG, Log.DEBUG))        
        {
        } //End block
        boolean var92EB5FFEE6AE2FEC3AD71C777531578F_2137092573 = (b);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1114819516 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1114819516;
        // ---------- Original Method ----------
        //SQLiteDatabase db = (isPooledConnection()) ? mParentConnObj : this;
        //boolean b = (!db.inTransaction()) ? false :
                //db.mTransactionUsingExecSql || db.mLock.isHeldByCurrentThread();
        //if (Log.isLoggable(TAG, Log.DEBUG)) {
            //Log.i(TAG, "amIinTransaction: " + b);
        //}
        //return b;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.855 -0400", hash_original_method = "810FBEC1135AAF9FE09D5ED72E2387AC", hash_generated_method = "3C2C24BBD2094F2AF3F870C9CFC8F0CE")
    public boolean isDbLockedByCurrentThread() {
        boolean var475246050C807519D6778B4F472B2F34_355907714 = (mLock.isHeldByCurrentThread());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1018036349 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1018036349;
        // ---------- Original Method ----------
        //return mLock.isHeldByCurrentThread();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.856 -0400", hash_original_method = "AFE51BB500BDF01026C5B1FB8FA31F68", hash_generated_method = "FDB464FE88626B601E0A91892D45A7EF")
    public boolean isDbLockedByOtherThreads() {
        boolean var4D123C87AFCF66682F89F8439C71D1BC_79299976 = (!mLock.isHeldByCurrentThread() && mLock.isLocked());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1224390978 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1224390978;
        // ---------- Original Method ----------
        //return !mLock.isHeldByCurrentThread() && mLock.isLocked();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.856 -0400", hash_original_method = "275C631F29B5F92F82765C72693E08C5", hash_generated_method = "CDB15003E5A457FAB047F6F9B6023AFF")
    @Deprecated
    public boolean yieldIfContended() {
        boolean varC59DD9D9B2568308D7EF4D4313AB0544_1027495527 = (yieldIfContendedHelper(false ,
                -1 ));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1900746107 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1900746107;
        // ---------- Original Method ----------
        //return yieldIfContendedHelper(false ,
                //-1 );
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.856 -0400", hash_original_method = "E4D6EC2B61BA0EB36CC3F2E9664FDE2E", hash_generated_method = "480C2D1C26DBF6907FA2654EC06289BD")
    public boolean yieldIfContendedSafely() {
        boolean varF31E14BB72D4DE0DDAF7987B42E25895_366957072 = (yieldIfContendedHelper(true , -1 ));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_633553413 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_633553413;
        // ---------- Original Method ----------
        //return yieldIfContendedHelper(true , -1 );
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.857 -0400", hash_original_method = "EFD5966AFCC9629F634B854AE0830507", hash_generated_method = "623AA53301227DA7BAE0BBE75A95D403")
    public boolean yieldIfContendedSafely(long sleepAfterYieldDelay) {
        addTaint(sleepAfterYieldDelay);
        boolean varD2BB51D2AB41B886C8E740AFD97D050A_1583322737 = (yieldIfContendedHelper(true , sleepAfterYieldDelay));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2077371225 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2077371225;
        // ---------- Original Method ----------
        //return yieldIfContendedHelper(true , sleepAfterYieldDelay);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.858 -0400", hash_original_method = "82E88213585314141BE9DBE00F951B10", hash_generated_method = "9E4E3A9A2C9DA3CF8F0D3E12FF678048")
    private boolean yieldIfContendedHelper(boolean checkFullyYielded, long sleepAfterYieldDelay) {
        addTaint(sleepAfterYieldDelay);
        addTaint(checkFullyYielded);
    if(mLock.getQueueLength() == 0)        
        {
            mLockAcquiredWallTime = SystemClock.elapsedRealtime();
            mLockAcquiredThreadTime = Debug.threadCpuTimeNanos();
            boolean var68934A3E9455FA72420237EB05902327_998532395 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_71439072 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_71439072;
        } //End block
        setTransactionSuccessful();
        SQLiteTransactionListener transactionListener = mTransactionListener;
        endTransaction();
    if(checkFullyYielded)        
        {
    if(this.isDbLockedByCurrentThread())            
            {
                IllegalStateException varE7A76AD65CE0D1C774F26F1BB3E58DD7_1491472866 = new IllegalStateException(
                        "Db locked more than once. yielfIfContended cannot yield");
                varE7A76AD65CE0D1C774F26F1BB3E58DD7_1491472866.addTaint(taint);
                throw varE7A76AD65CE0D1C774F26F1BB3E58DD7_1491472866;
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
        boolean varB326B5062B2F0E69046810717534CB09_742456860 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1781928329 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1781928329;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.858 -0400", hash_original_method = "2BF74CD6834BBADBF27F65464DB83499", hash_generated_method = "04DC1C06E049F5B644C57BFCB914F425")
    @Deprecated
    public Map<String, String> getSyncedTables() {
Map<String, String> var2AF78D255D26C3C84C3DB61E3A8BCBD5_508088539 =         new HashMap<String, String>(0);
        var2AF78D255D26C3C84C3DB61E3A8BCBD5_508088539.addTaint(taint);
        return var2AF78D255D26C3C84C3DB61E3A8BCBD5_508088539;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.861 -0400", hash_original_method = "4DBAD15B0F91A1B1A1A509E057CF6487", hash_generated_method = "BE518D50FDA188705AEA47437C9E816A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.863 -0400", hash_original_method = "F057ECACA47F2E639159F91F6FF25AA8", hash_generated_method = "CA3F6288128C92EE799ECBCE19EA0E92")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.864 -0400", hash_original_method = "2CD800231F10038F3799DBDAB26BCEE1", hash_generated_method = "1CBDD8B04B5971582B08FAB9AE0C3A1C")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.865 -0400", hash_original_method = "9BCDA7BC5AA364A3676019422CD41F65", hash_generated_method = "6D50E81F67B0869C6C15040A3DD0032A")
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
                SQLiteUnfinalizedObjectsException var8F1DB10592830F1B72EDBB96E9F0E496_1894963215 = new SQLiteUnfinalizedObjectsException(
                        "close() on database: " + getPath() +
                        " failed due to un-close()d SQL statements: " + msg);
                var8F1DB10592830F1B72EDBB96E9F0E496_1894963215.addTaint(taint);
                throw var8F1DB10592830F1B72EDBB96E9F0E496_1894963215;
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.865 -0400", hash_original_method = "4C27B28311EC4401B9E72044B34DEE3C", hash_generated_method = "4E905500CC20EB86329796A43360CF14")
    private void dbclose() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.866 -0400", hash_original_method = "6AE38120A6AE17DCB302700D83D76664", hash_generated_method = "4E8BF2A45153E09E1910F7CB02C3C4EB")
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
                SQLiteException varAC9F9B5BCDE3D6EFACA476C4F7F6F6A0_1713639499 = new SQLiteException("failed to add custom function " + name);
                varAC9F9B5BCDE3D6EFACA476C4F7F6F6A0_1713639499.addTaint(taint);
                throw varAC9F9B5BCDE3D6EFACA476C4F7F6F6A0_1713639499;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.866 -0400", hash_original_method = "9C15AE424A91890D11F6682C678B396E", hash_generated_method = "565FF64D92B73E45A055F23101EA3778")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.867 -0400", hash_original_method = "545ECF4B8C2C387E458104596CE82C8C", hash_generated_method = "72A0C9A1D41D2E6E38CAF488779A0E65")
    private int native_addCustomFunction(String name, int numArgs, CustomFunction function) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1823335513 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1823335513;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.867 -0400", hash_original_method = "D641D8CC9687EF2DFB0D6D88DDBFEE42", hash_generated_method = "B4A109E17A2F0A083453807534F34E44")
    private void native_releaseCustomFunction(int function) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.868 -0400", hash_original_method = "8BA60C4A4A322F100A535BB125C59B40", hash_generated_method = "80FF8F6184DE4A35F61A9077AA7B8F21")
    public int getVersion() {
        int var3DFBB6B231A360BE2FC5468DEA3D3BA0_697123116 = (((Long) DatabaseUtils.longForQuery(this, "PRAGMA user_version;", null)).intValue());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_646013691 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_646013691;
        // ---------- Original Method ----------
        //return ((Long) DatabaseUtils.longForQuery(this, "PRAGMA user_version;", null)).intValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.868 -0400", hash_original_method = "4E3C0E9170C91236F101F38522569C45", hash_generated_method = "FFE3BD39E2B31D52938CD69211C26246")
    public void setVersion(int version) {
        addTaint(version);
        execSQL("PRAGMA user_version = " + version);
        // ---------- Original Method ----------
        //execSQL("PRAGMA user_version = " + version);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.868 -0400", hash_original_method = "01DC63CC6FF3C1462DC7069F3072C18D", hash_generated_method = "0EA0C85F2C6FCB7A9134DD9DA6254367")
    public long getMaximumSize() {
        long pageCount = DatabaseUtils.longForQuery(this, "PRAGMA max_page_count;", null);
        long varEF0C2206D4308EE3D65C3F1F8D450022_1606581233 = (pageCount * getPageSize());
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1716251439 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1716251439;
        // ---------- Original Method ----------
        //long pageCount = DatabaseUtils.longForQuery(this, "PRAGMA max_page_count;", null);
        //return pageCount * getPageSize();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.869 -0400", hash_original_method = "B09E5ED21834BC66E218E9635E49257B", hash_generated_method = "4DC9291A600CE3F11EC42E558E8A591D")
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
        long var367F6ECD97F29FC385A5760C6933481E_1202584460 = (newPageCount * pageSize);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_603126306 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_603126306;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.869 -0400", hash_original_method = "677D214086B645E86B85D4E2A88CD9F6", hash_generated_method = "0317364839F1C5708CA082A5999BABC6")
    public long getPageSize() {
        long var0FA2348E41AC4877AC4B10053CA2F627_391375342 = (DatabaseUtils.longForQuery(this, "PRAGMA page_size;", null));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_661749173 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_661749173;
        // ---------- Original Method ----------
        //return DatabaseUtils.longForQuery(this, "PRAGMA page_size;", null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.870 -0400", hash_original_method = "CE3FCE5D2F41E0E2EF73A0D49E90DE3F", hash_generated_method = "3E0D093D7A6AF89A4CC618622B339198")
    public void setPageSize(long numBytes) {
        addTaint(numBytes);
        execSQL("PRAGMA page_size = " + numBytes);
        // ---------- Original Method ----------
        //execSQL("PRAGMA page_size = " + numBytes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.871 -0400", hash_original_method = "0ECCFA53F5E6749CB5B25917802B1822", hash_generated_method = "7FC2F8850E8243813320359B6765022D")
    @Deprecated
    public void markTableSyncable(String table, String deletedTable) {
        addTaint(deletedTable.getTaint());
        addTaint(table.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.871 -0400", hash_original_method = "9A70316D056BE2F7590F6370A4F13111", hash_generated_method = "B4D0CB8673C3C5BAACF6ABB432E9760F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.872 -0400", hash_original_method = "C05C583B39FD005C236783082CBB4E55", hash_generated_method = "051FA929E084F408CA9F10717769C434")
    public SQLiteStatement compileStatement(String sql) throws SQLException {
        addTaint(sql.getTaint());
        verifyDbIsOpen();
SQLiteStatement varBEC5BDE83AF94CE50E6B86DAA2D5DF03_1415989694 =         new SQLiteStatement(this, sql, null);
        varBEC5BDE83AF94CE50E6B86DAA2D5DF03_1415989694.addTaint(taint);
        return varBEC5BDE83AF94CE50E6B86DAA2D5DF03_1415989694;
        // ---------- Original Method ----------
        //verifyDbIsOpen();
        //return new SQLiteStatement(this, sql, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.873 -0400", hash_original_method = "5E1B6C3D7A97420E0A4D0244321FA1D0", hash_generated_method = "A97D6D52A5C1AB090ABD3BF957485BA7")
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
Cursor var23D2C6BC128F8B1CE94B002C59BEE151_1422659680 =         queryWithFactory(null, distinct, table, columns, selection, selectionArgs,
                groupBy, having, orderBy, limit);
        var23D2C6BC128F8B1CE94B002C59BEE151_1422659680.addTaint(taint);
        return var23D2C6BC128F8B1CE94B002C59BEE151_1422659680;
        // ---------- Original Method ----------
        //return queryWithFactory(null, distinct, table, columns, selection, selectionArgs,
                //groupBy, having, orderBy, limit);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.875 -0400", hash_original_method = "2EC2F985341F70A15977A4E5B8D54ACE", hash_generated_method = "F6A85B5A3D4EA1DB38806725741C2630")
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
Cursor varA09DE70112197B49177C7CC96D9BFA01_103740739 =         rawQueryWithFactory(
                cursorFactory, sql, selectionArgs, findEditTable(table));
        varA09DE70112197B49177C7CC96D9BFA01_103740739.addTaint(taint);
        return varA09DE70112197B49177C7CC96D9BFA01_103740739;
        // ---------- Original Method ----------
        //verifyDbIsOpen();
        //String sql = SQLiteQueryBuilder.buildQueryString(
                //distinct, table, columns, selection, groupBy, having, orderBy, limit);
        //return rawQueryWithFactory(
                //cursorFactory, sql, selectionArgs, findEditTable(table));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.876 -0400", hash_original_method = "823CC97B8BCC24B1EEF8A14CAC46F9D2", hash_generated_method = "D72DBF2B49EB7F35FFBE4D5E342EB732")
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
Cursor varF6E8BC926FB3F70ACD0A2418D34560DE_1145925065 =         query(false, table, columns, selection, selectionArgs, groupBy,
                having, orderBy, null );
        varF6E8BC926FB3F70ACD0A2418D34560DE_1145925065.addTaint(taint);
        return varF6E8BC926FB3F70ACD0A2418D34560DE_1145925065;
        // ---------- Original Method ----------
        //return query(false, table, columns, selection, selectionArgs, groupBy,
                //having, orderBy, null );
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.876 -0400", hash_original_method = "C821013CE8C43126ED02ADCC7264C8CF", hash_generated_method = "265C26199217515F1D4936F0D13231AA")
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
Cursor var5D7022C24B55BCBF7DDD7A0CA420A4BF_349975864 =         query(false, table, columns, selection, selectionArgs, groupBy,
                having, orderBy, limit);
        var5D7022C24B55BCBF7DDD7A0CA420A4BF_349975864.addTaint(taint);
        return var5D7022C24B55BCBF7DDD7A0CA420A4BF_349975864;
        // ---------- Original Method ----------
        //return query(false, table, columns, selection, selectionArgs, groupBy,
                //having, orderBy, limit);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.877 -0400", hash_original_method = "76B8F97A589187A4837E14E72F2396A8", hash_generated_method = "742DEFB47726D9A5DB4724F2449180F7")
    public Cursor rawQuery(String sql, String[] selectionArgs) {
        addTaint(selectionArgs[0].getTaint());
        addTaint(sql.getTaint());
Cursor var6048EAF2651C061F158A6FFDC11D3630_1596608739 =         rawQueryWithFactory(null, sql, selectionArgs, null);
        var6048EAF2651C061F158A6FFDC11D3630_1596608739.addTaint(taint);
        return var6048EAF2651C061F158A6FFDC11D3630_1596608739;
        // ---------- Original Method ----------
        //return rawQueryWithFactory(null, sql, selectionArgs, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.877 -0400", hash_original_method = "42A0891F7A1C512D8BE3F37EFD1DF118", hash_generated_method = "34F08C03A5BBDA5D31EDDA090744B186")
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
Cursor varADA3C208DF1628BA935498FB38A6BBD3_1576485309 =         cursor;
        varADA3C208DF1628BA935498FB38A6BBD3_1576485309.addTaint(taint);
        return varADA3C208DF1628BA935498FB38A6BBD3_1576485309;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.878 -0400", hash_original_method = "7C0142B65481E16DCFB76B6C0BD0AF64", hash_generated_method = "81854F3B514A7FBA646D9D947B2FBEEF")
    public long insert(String table, String nullColumnHack, ContentValues values) {
        addTaint(values.getTaint());
        addTaint(nullColumnHack.getTaint());
        addTaint(table.getTaint());
        try 
        {
            long var1B2EAADA4551B4E46946D3C43A39056D_606804220 = (insertWithOnConflict(table, nullColumnHack, values, CONFLICT_NONE));
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1268086447 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1268086447;
        } //End block
        catch (SQLException e)
        {
            long var6BB61E3B7BCE0931DA574D19D1D82C88_1260949324 = (-1);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1051893153 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1051893153;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return insertWithOnConflict(table, nullColumnHack, values, CONFLICT_NONE);
        //} catch (SQLException e) {
            //Log.e(TAG, "Error inserting " + values, e);
            //return -1;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.878 -0400", hash_original_method = "2F31CF2160A369C3FFDDD251C32C2819", hash_generated_method = "15259BFB0C11EFCD9DB1E5A669DC10BA")
    public long insertOrThrow(String table, String nullColumnHack, ContentValues values) throws SQLException {
        addTaint(values.getTaint());
        addTaint(nullColumnHack.getTaint());
        addTaint(table.getTaint());
        long var1B2EAADA4551B4E46946D3C43A39056D_1117292860 = (insertWithOnConflict(table, nullColumnHack, values, CONFLICT_NONE));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1195291700 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1195291700;
        // ---------- Original Method ----------
        //return insertWithOnConflict(table, nullColumnHack, values, CONFLICT_NONE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.879 -0400", hash_original_method = "4277B606CBD58106C26DEC9C427B6DC5", hash_generated_method = "C00578680182746E9B75FFA84CFF571D")
    public long replace(String table, String nullColumnHack, ContentValues initialValues) {
        addTaint(initialValues.getTaint());
        addTaint(nullColumnHack.getTaint());
        addTaint(table.getTaint());
        try 
        {
            long varFA0DDB9BBD2D61D7EDFBFFA0DBE031A7_609577106 = (insertWithOnConflict(table, nullColumnHack, initialValues,
                    CONFLICT_REPLACE));
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_237998161 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_237998161;
        } //End block
        catch (SQLException e)
        {
            long var6BB61E3B7BCE0931DA574D19D1D82C88_494888334 = (-1);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_10556912 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_10556912;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.880 -0400", hash_original_method = "006F0DF267AA18E88B2010DFB3E66CC0", hash_generated_method = "459E2AFC8A3FAF6699A1B086207A4843")
    public long replaceOrThrow(String table, String nullColumnHack,
            ContentValues initialValues) throws SQLException {
        addTaint(initialValues.getTaint());
        addTaint(nullColumnHack.getTaint());
        addTaint(table.getTaint());
        long var2EA573E159D2EC588D472481DD4C8850_1260595448 = (insertWithOnConflict(table, nullColumnHack, initialValues,
                CONFLICT_REPLACE));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1952238681 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1952238681;
        // ---------- Original Method ----------
        //return insertWithOnConflict(table, nullColumnHack, initialValues,
                //CONFLICT_REPLACE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.881 -0400", hash_original_method = "4E696CAC31E62C2450813F66BA0D3688", hash_generated_method = "5BDD45E33FB873ABF3C399CD946C95BF")
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
            long var9242B7E5D7445BE96758B11AACAF5746_1230838549 = (statement.executeInsert());
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_579538064 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_579538064;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.882 -0400", hash_original_method = "D469CE4575675C51277223F3405EF96C", hash_generated_method = "0715CCB9A4763F7EA3566C67C6E6A4C1")
    public int delete(String table, String whereClause, String[] whereArgs) {
        addTaint(whereArgs[0].getTaint());
        addTaint(whereClause.getTaint());
        addTaint(table.getTaint());
        SQLiteStatement statement = new SQLiteStatement(this, "DELETE FROM " + table +
                (!TextUtils.isEmpty(whereClause) ? " WHERE " + whereClause : ""), whereArgs);
        try 
        {
            int var01DF87E30F36942B79889D5C280E42B9_1371999134 = (statement.executeUpdateDelete());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_911812458 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_911812458;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.882 -0400", hash_original_method = "1314F51B10A849824DA60B76F1896857", hash_generated_method = "F23D91C1C550D9B4D03EE27DB083834C")
    public int update(String table, ContentValues values, String whereClause, String[] whereArgs) {
        addTaint(whereArgs[0].getTaint());
        addTaint(whereClause.getTaint());
        addTaint(values.getTaint());
        addTaint(table.getTaint());
        int var5FCECBD5FEE1AB69AD61B2744294E4C3_1790917289 = (updateWithOnConflict(table, values, whereClause, whereArgs, CONFLICT_NONE));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_807679057 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_807679057;
        // ---------- Original Method ----------
        //return updateWithOnConflict(table, values, whereClause, whereArgs, CONFLICT_NONE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.884 -0400", hash_original_method = "42C896B54A7E0C71455DEE45B9C2EA0D", hash_generated_method = "F3CAD5F882C5FF79E62A99CA23FAE9CC")
    public int updateWithOnConflict(String table, ContentValues values,
            String whereClause, String[] whereArgs, int conflictAlgorithm) {
        addTaint(conflictAlgorithm);
        addTaint(whereArgs[0].getTaint());
        addTaint(whereClause.getTaint());
        addTaint(values.getTaint());
        addTaint(table.getTaint());
    if(values == null || values.size() == 0)        
        {
            IllegalArgumentException varEEE2AB986D839FC34B1428F77875E0E5_1319842120 = new IllegalArgumentException("Empty values");
            varEEE2AB986D839FC34B1428F77875E0E5_1319842120.addTaint(taint);
            throw varEEE2AB986D839FC34B1428F77875E0E5_1319842120;
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
            int var01DF87E30F36942B79889D5C280E42B9_1072409821 = (statement.executeUpdateDelete());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_215718794 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_215718794;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.885 -0400", hash_original_method = "25D536EB53093A036E9DAE961A0D97E6", hash_generated_method = "79A7D2318A34B8EB4F086EC6345B4E74")
    public void execSQL(String sql) throws SQLException {
        addTaint(sql.getTaint());
        executeSql(sql, null);
        // ---------- Original Method ----------
        //executeSql(sql, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.885 -0400", hash_original_method = "C75317BDB75C741C750B94F218C97882", hash_generated_method = "5040744EB8A1B05E49A3DDB3DBF02544")
    public void execSQL(String sql, Object[] bindArgs) throws SQLException {
        addTaint(bindArgs[0].getTaint());
        addTaint(sql.getTaint());
    if(bindArgs == null)        
        {
            IllegalArgumentException var20997C2B87ED082BF8AAB3BDBFF184B3_270172154 = new IllegalArgumentException("Empty bindArgs");
            var20997C2B87ED082BF8AAB3BDBFF184B3_270172154.addTaint(taint);
            throw var20997C2B87ED082BF8AAB3BDBFF184B3_270172154;
        } //End block
        executeSql(sql, bindArgs);
        // ---------- Original Method ----------
        //if (bindArgs == null) {
            //throw new IllegalArgumentException("Empty bindArgs");
        //}
        //executeSql(sql, bindArgs);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.886 -0400", hash_original_method = "9265893CFBC7535112C5207F5F702C1B", hash_generated_method = "AB21E9D4AD905F241EE79F319613E783")
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
            int var01DF87E30F36942B79889D5C280E42B9_977561949 = (statement.executeUpdateDelete());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_960391536 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_960391536;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.886 -0400", hash_original_method = "2C203F91898576B00C917F0CD42A518A", hash_generated_method = "A7607F76A5C0EDF2B8E22D02A10EA106")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.887 -0400", hash_original_method = "B8251338AB8EB8352A863E35E41B939B", hash_generated_method = "B3C90CA86038B108E449389D09ABE891")
    public boolean isReadOnly() {
        boolean var36294417069D577EEA9BD86FA01F52A4_984220283 = ((mFlags & OPEN_READ_MASK) == OPEN_READONLY);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_708428324 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_708428324;
        // ---------- Original Method ----------
        //return (mFlags & OPEN_READ_MASK) == OPEN_READONLY;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.887 -0400", hash_original_method = "61E254D128D08D9B7DD7C5EEB86B883E", hash_generated_method = "4D2AFC767D808E48B83BEB8A74615AE2")
    public boolean isOpen() {
        boolean var6952EFEAC49FB3C8A90BB7144BF655F1_1096384718 = (mNativeHandle != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1960675719 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1960675719;
        // ---------- Original Method ----------
        //return mNativeHandle != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.888 -0400", hash_original_method = "4C8276EC0F604B529F31103A74E610FF", hash_generated_method = "04BFB0CF309F3FEA5EC21D6B458613E8")
    public boolean needUpgrade(int newVersion) {
        addTaint(newVersion);
        boolean varFA8E2877429A28605B47275CD828EDC1_1361751957 = (newVersion > getVersion());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1143161051 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1143161051;
        // ---------- Original Method ----------
        //return newVersion > getVersion();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.888 -0400", hash_original_method = "F177C5B02553C0E0327F321BDDCEAFD5", hash_generated_method = "AB8D0F51D02957CC476A0385D19D5902")
    public final String getPath() {
String var6AF672BCA4D9DB76D759DE4D6BEB1D5F_307974677 =         mPath;
        var6AF672BCA4D9DB76D759DE4D6BEB1D5F_307974677.addTaint(taint);
        return var6AF672BCA4D9DB76D759DE4D6BEB1D5F_307974677;
        // ---------- Original Method ----------
        //return mPath;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.889 -0400", hash_original_method = "0D21C1E893B83D945127726B58A78BA2", hash_generated_method = "74FF10032F9E41D653AB1E7E336609D4")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.890 -0400", hash_original_method = "8ED8142AF940938322CF345006300B7D", hash_generated_method = "A0486B854F147CFE5B906A59E68EC276")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.891 -0400", hash_original_method = "BAC313652C0D08E8CD159DBA09E31731", hash_generated_method = "805EF3B0B67E2EB6F88CA37BD62B1D67")
    private String getPathForLogs() {
    if(mPathForLogs != null)        
        {
String varDF5C62998ABFC21110F9C271D7872BD4_1940116855 =             mPathForLogs;
            varDF5C62998ABFC21110F9C271D7872BD4_1940116855.addTaint(taint);
            return varDF5C62998ABFC21110F9C271D7872BD4_1940116855;
        } //End block
    if(mPath == null)        
        {
String var540C13E9E156B687226421B24F2DF178_1620136744 =             null;
            var540C13E9E156B687226421B24F2DF178_1620136744.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1620136744;
        } //End block
    if(mPath.indexOf('@') == -1)        
        {
            mPathForLogs = mPath;
        } //End block
        else
        {
            mPathForLogs = EMAIL_IN_DB_PATTERN.matcher(mPath).replaceAll("XX@YY");
        } //End block
String varDF5C62998ABFC21110F9C271D7872BD4_352274768 =         mPathForLogs;
        varDF5C62998ABFC21110F9C271D7872BD4_352274768.addTaint(taint);
        return varDF5C62998ABFC21110F9C271D7872BD4_352274768;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.892 -0400", hash_original_method = "3FAFCE8DADACDA6029D741D00EA768C4", hash_generated_method = "E81F955A2EB3DA7D7A0CAE0AF946254D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.892 -0400", hash_original_method = "82F89F6027C136BD18FB9173DDA585C3", hash_generated_method = "4D395F885C7463874377B7154B53BEF3")
     void verifyDbIsOpen() {
    if(!isOpen())        
        {
            IllegalStateException var0947A6FFE91188EE87D4F89FDD2C82CF_444918507 = new IllegalStateException("database " + getPath() + " (conn# " +
                    mConnectionNum + ") already closed");
            var0947A6FFE91188EE87D4F89FDD2C82CF_444918507.addTaint(taint);
            throw var0947A6FFE91188EE87D4F89FDD2C82CF_444918507;
        } //End block
        // ---------- Original Method ----------
        //if (!isOpen()) {
            //throw new IllegalStateException("database " + getPath() + " (conn# " +
                    //mConnectionNum + ") already closed");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.893 -0400", hash_original_method = "2ABE5777D3030A58042EA8C11F6A64FB", hash_generated_method = "B9588BEE87D93E259C653CB8C72E66DC")
     void verifyLockOwner() {
        verifyDbIsOpen();
    if(mLockingEnabled && !isDbLockedByCurrentThread())        
        {
            IllegalStateException var37883286389DD733C9EA5F7C92FC22F9_1580035838 = new IllegalStateException("Don't have database lock!");
            var37883286389DD733C9EA5F7C92FC22F9_1580035838.addTaint(taint);
            throw var37883286389DD733C9EA5F7C92FC22F9_1580035838;
        } //End block
        // ---------- Original Method ----------
        //verifyDbIsOpen();
        //if (mLockingEnabled && !isDbLockedByCurrentThread()) {
            //throw new IllegalStateException("Don't have database lock!");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.894 -0400", hash_original_method = "1F50605826534D1D8A189D3DC15DE94F", hash_generated_method = "BB0BF6277465F4CADAE2FD80E75A7A5B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.896 -0400", hash_original_method = "CE0C87ACDC099813F3D6D588DE2B56CF", hash_generated_method = "322CA9C4AF0AE19D7D465FD8146A853F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.897 -0400", hash_original_method = "A3F9326C17119FEC2A90D0724FE482CF", hash_generated_method = "F406A785E6E62C75EC669947ADB35726")
    synchronized SQLiteCompiledSql getCompiledStatementForSql(String sql) {
        addTaint(sql.getTaint());
SQLiteCompiledSql var9F0A7F1AF09C3A292F26C4AC047BC2E1_2146076412 =         mCompiledQueries.get(sql);
        var9F0A7F1AF09C3A292F26C4AC047BC2E1_2146076412.addTaint(taint);
        return var9F0A7F1AF09C3A292F26C4AC047BC2E1_2146076412;
        // ---------- Original Method ----------
        //return mCompiledQueries.get(sql);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.899 -0400", hash_original_method = "986DCF2E02788969CC84FF6D84C81E71", hash_generated_method = "C8E0395A03FF0672E212E0FD9B0C19A5")
    public void setMaxSqlCacheSize(int cacheSize) {
        synchronized
(this)        {
            LruCache<String, SQLiteCompiledSql> oldCompiledQueries = mCompiledQueries;
    if(cacheSize > MAX_SQL_CACHE_SIZE || cacheSize < 0)            
            {
                IllegalStateException var5012919EDBC0D151A6C270907E44577F_1838961428 = new IllegalStateException(
                        "expected value between 0 and " + MAX_SQL_CACHE_SIZE);
                var5012919EDBC0D151A6C270907E44577F_1838961428.addTaint(taint);
                throw var5012919EDBC0D151A6C270907E44577F_1838961428;
            } //End block
            else
    if(oldCompiledQueries != null && cacheSize < oldCompiledQueries.maxSize())            
            {
                IllegalStateException var325AC93AC3A8216D94109299E6891532_1180059596 = new IllegalStateException("cannot set cacheSize to a value less than the "
                        + "value set with previous setMaxSqlCacheSize() call.");
                var325AC93AC3A8216D94109299E6891532_1180059596.addTaint(taint);
                throw var325AC93AC3A8216D94109299E6891532_1180059596;
            } //End block
            mCompiledQueries = new LruCache<String, SQLiteCompiledSql>(cacheSize) {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.899 -0400", hash_original_method = "0287FECCFAEBE5DF6977A7998D9D230B", hash_generated_method = "E0BFEF4F5AFB0202C32411DDAE00BFA7")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.900 -0400", hash_original_method = "4517A8954B6715406427A020C27CB67E", hash_generated_method = "915156CFADB84268F60D9746CF7D9552")
    synchronized boolean isInStatementCache(String sql) {
        addTaint(sql.getTaint());
        boolean var8F89F5B66ECEDE91BE3991C339B7BF1C_1703554888 = (mCompiledQueries.get(sql) != null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1447801017 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1447801017;
        // ---------- Original Method ----------
        //return mCompiledQueries.get(sql) != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.900 -0400", hash_original_method = "1314F31979BFAD21CD00C204B07606A6", hash_generated_method = "F1D82EE1693BFA9AD1B21FAD87B6F4A1")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.901 -0400", hash_original_method = "8B250436E1E22A5062E1C40EC7B14D91", hash_generated_method = "A79FF567EF54D6625E555AD36C032139")
    private synchronized int getCacheHitNum() {
        int var322DA19D24A3D3B76726EFEB5EF14F24_2098045999 = (mCompiledQueries.hitCount());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1510974726 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1510974726;
        // ---------- Original Method ----------
        //return mCompiledQueries.hitCount();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.901 -0400", hash_original_method = "043FFEAEE6F40014DEE09BB2B945E7E0", hash_generated_method = "3B81A3E070DDC5090832CC386443F37C")
    private synchronized int getCacheMissNum() {
        int var03D1BBAF33262A3B8D40BC46A651DDEF_310356931 = (mCompiledQueries.missCount());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_164263714 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_164263714;
        // ---------- Original Method ----------
        //return mCompiledQueries.missCount();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.902 -0400", hash_original_method = "BE154D77F9855AEAD67382AAA286976D", hash_generated_method = "207C8AE6A73C5F88B497067E525F9715")
    private synchronized int getCachesize() {
        int var088CE0E5E9A42C2C8387687DBAD245B7_786791442 = (mCompiledQueries.size());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_903356079 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_903356079;
        // ---------- Original Method ----------
        //return mCompiledQueries.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.902 -0400", hash_original_method = "5A385C2ADA8821372998CC92DEC1F051", hash_generated_method = "BB41487B2AE018E798FC7C6B6426D377")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.903 -0400", hash_original_method = "155C9044FA9A1FA1A4DC8EF486B34E28", hash_generated_method = "462534B44439252CFDB5A0D2117B96FD")
     boolean isInQueueOfStatementsToBeFinalized(int id) {
        addTaint(id);
    if(!isOpen())        
        {
            boolean varB326B5062B2F0E69046810717534CB09_46256122 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1204815507 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1204815507;
        } //End block
        synchronized
(mClosedStatementIds)        {
            boolean var90B296B053310EE4D8AD831404FF5A2B_317996820 = (mClosedStatementIds.contains(id));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1976864441 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1976864441;
        } //End block
        // ---------- Original Method ----------
        //if (!isOpen()) {
            //return true;
        //}
        //synchronized(mClosedStatementIds) {
            //return mClosedStatementIds.contains(id);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.903 -0400", hash_original_method = "D5552224B16C0AA0A430699F6F165E27", hash_generated_method = "5AAE50B828CBDBA6C60C7D83960A96DC")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.904 -0400", hash_original_method = "22B8BC0E5EAC4A96A93EF5FA02A6A3E4", hash_generated_method = "EE8767A39E1BBF07D09FB7067ECB8864")
     ArrayList<Integer> getQueuedUpStmtList() {
ArrayList<Integer> var0084AC26CAA64BD68D68ADBD7C3F1253_25736910 =         mClosedStatementIds;
        var0084AC26CAA64BD68D68ADBD7C3F1253_25736910.addTaint(taint);
        return var0084AC26CAA64BD68D68ADBD7C3F1253_25736910;
        // ---------- Original Method ----------
        //return mClosedStatementIds;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.905 -0400", hash_original_method = "D499CBE556FD537E95FAF5696995EFF8", hash_generated_method = "E52B77F5CBB648EBA75F86DC3E458FBE")
    public boolean enableWriteAheadLogging() {
    if(isReadOnly())        
        {
            boolean var68934A3E9455FA72420237EB05902327_799687850 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_104430021 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_104430021;
        } //End block
        lock();
        try 
        {
    if(mConnectionPool != null)            
            {
                boolean varB326B5062B2F0E69046810717534CB09_1238537746 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_259134820 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_259134820;
            } //End block
    if(mPath.equalsIgnoreCase(MEMORY_DB_PATH))            
            {
                boolean var68934A3E9455FA72420237EB05902327_1318379172 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2074744040 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_2074744040;
            } //End block
    if(mHasAttachedDbs)            
            {
    if(Log.isLoggable(TAG, Log.DEBUG))                
                {
                    Log.d(TAG,
                            "this database: " + mPath + " has attached databases. can't  enable WAL.");
                } //End block
                boolean var68934A3E9455FA72420237EB05902327_726152346 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1274836653 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1274836653;
            } //End block
            mConnectionPool = new DatabaseConnectionPool(this);
            setJournalMode(mPath, "WAL");
            boolean varB326B5062B2F0E69046810717534CB09_250599062 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1062048253 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1062048253;
        } //End block
        finally 
        {
            unlock();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.906 -0400", hash_original_method = "85CDE9F0FF49E9AFE9EC3200C3C50766", hash_generated_method = "7496B37A773F3911D5630BF901EF06F2")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.906 -0400", hash_original_method = "E2BFDDA904D316A8C889FACE46B854F6", hash_generated_method = "314A6CE9E005E0EC47598AF1E24EFF37")
     SQLiteDatabase getDatabaseHandle(String sql) {
        addTaint(sql.getTaint());
    if(isPooledConnection())        
        {
    if(isOpen() && !amIInTransaction())            
            {
SQLiteDatabase var72A74007B2BE62B849F475C7BDA4658B_1915920561 =                 this;
                var72A74007B2BE62B849F475C7BDA4658B_1915920561.addTaint(taint);
                return var72A74007B2BE62B849F475C7BDA4658B_1915920561;
            } //End block
            else
            {
SQLiteDatabase varA73916C386A0B8C0CAC74B735D8DF48A_359140855 =                 getParentDbConnObj().getDbConnection(sql);
                varA73916C386A0B8C0CAC74B735D8DF48A_359140855.addTaint(taint);
                return varA73916C386A0B8C0CAC74B735D8DF48A_359140855;
            } //End block
        } //End block
        else
        {
SQLiteDatabase varF5ECA5E9F57D4CDF60641E2D4F4776CB_1130363243 =             getDbConnection(sql);
            varF5ECA5E9F57D4CDF60641E2D4F4776CB_1130363243.addTaint(taint);
            return varF5ECA5E9F57D4CDF60641E2D4F4776CB_1130363243;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.907 -0400", hash_original_method = "3237D800F466D0C40C278AA082141CB7", hash_generated_method = "F6955B18D77C68E5C2BEA24EB8D99E90")
     SQLiteDatabase createPoolConnection(short connectionNum) {
        addTaint(connectionNum);
        SQLiteDatabase db = openDatabase(mPath, mFactory, mFlags, mErrorHandler, connectionNum);
        db.mParentConnObj = this;
SQLiteDatabase var2F732BA7E0C8A6B94C1D7B25B6A078BE_4644789 =         db;
        var2F732BA7E0C8A6B94C1D7B25B6A078BE_4644789.addTaint(taint);
        return var2F732BA7E0C8A6B94C1D7B25B6A078BE_4644789;
        // ---------- Original Method ----------
        //SQLiteDatabase db = openDatabase(mPath, mFactory, mFlags, mErrorHandler, connectionNum);
        //db.mParentConnObj = this;
        //return db;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.907 -0400", hash_original_method = "205546EE310EB84028F43CE65A7EC94C", hash_generated_method = "B720E53039976BA96767C54CD975A8C5")
    private synchronized SQLiteDatabase getParentDbConnObj() {
SQLiteDatabase varB5ACC923BED14DF553E5EF2A3C356F24_93687407 =         mParentConnObj;
        varB5ACC923BED14DF553E5EF2A3C356F24_93687407.addTaint(taint);
        return varB5ACC923BED14DF553E5EF2A3C356F24_93687407;
        // ---------- Original Method ----------
        //return mParentConnObj;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.908 -0400", hash_original_method = "D4EECEC449FC4C156499058FCB2B2B85", hash_generated_method = "10CA6D4602FC9DF970DEE85D0D08A522")
    private boolean isPooledConnection() {
        boolean var5F6655DBD097E3B95DC488F99A92A4B4_1966130419 = (this.mConnectionNum > 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2094001012 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2094001012;
        // ---------- Original Method ----------
        //return this.mConnectionNum > 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.908 -0400", hash_original_method = "B485A553653CD27E64DDB9F45483F96A", hash_generated_method = "4E83EA44C29D654117D46612AC271485")
     SQLiteDatabase getDbConnection(String sql) {
        addTaint(sql.getTaint());
        verifyDbIsOpen();
    if(isPooledConnection())        
        {
SQLiteDatabase var72A74007B2BE62B849F475C7BDA4658B_338289838 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_338289838.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_338289838;
        } //End block
    if(amIInTransaction() || mConnectionPool == null)        
        {
SQLiteDatabase var72A74007B2BE62B849F475C7BDA4658B_822627962 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_822627962.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_822627962;
        } //End block
        else
        {
    if(Log.isLoggable(TAG, Log.DEBUG))            
            {
            } //End block
SQLiteDatabase varD09C8971185D99DED04CBB5CF2D67767_204713712 =             mConnectionPool.get(sql);
            varD09C8971185D99DED04CBB5CF2D67767_204713712.addTaint(taint);
            return varD09C8971185D99DED04CBB5CF2D67767_204713712;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.909 -0400", hash_original_method = "2B099A526E7EBE8C0C20DFBE797D578C", hash_generated_method = "4FD4EB1660C36020081514CF342BB0C3")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.910 -0400", hash_original_method = "40C4DE1C4808AAF54B97D30ED440E3DF", hash_generated_method = "3564524830BEC5B197FF0E0C21481FF5")
    public List<Pair<String, String>> getAttachedDbs() {
    if(!isOpen())        
        {
List<Pair<String, String>> var540C13E9E156B687226421B24F2DF178_1705153530 =             null;
            var540C13E9E156B687226421B24F2DF178_1705153530.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1705153530;
        } //End block
        ArrayList<Pair<String, String>> attachedDbs = new ArrayList<Pair<String, String>>();
    if(!mHasAttachedDbs)        
        {
            attachedDbs.add(new Pair<String, String>("main", mPath));
List<Pair<String, String>> var9593CDD5CA41EF2474A02A0F9B86D41E_1534894934 =             attachedDbs;
            var9593CDD5CA41EF2474A02A0F9B86D41E_1534894934.addTaint(taint);
            return var9593CDD5CA41EF2474A02A0F9B86D41E_1534894934;
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
List<Pair<String, String>> var9593CDD5CA41EF2474A02A0F9B86D41E_408830232 =         attachedDbs;
        var9593CDD5CA41EF2474A02A0F9B86D41E_408830232.addTaint(taint);
        return var9593CDD5CA41EF2474A02A0F9B86D41E_408830232;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.912 -0400", hash_original_method = "F327316761A478EA142E408A35654FE2", hash_generated_method = "27A9ED5770FD12DF4058C416537E4CA0")
    public boolean isDatabaseIntegrityOk() {
        verifyDbIsOpen();
        List<Pair<String, String>> attachedDbs = null;
        try 
        {
            attachedDbs = getAttachedDbs();
    if(attachedDbs == null)            
            {
                IllegalStateException var749D452026CFB6F3ABFC79893B86F4EB_1358155945 = new IllegalStateException("databaselist for: " + getPath() + " couldn't " +
                        "be retrieved. probably because the database is closed");
                var749D452026CFB6F3ABFC79893B86F4EB_1358155945.addTaint(taint);
                throw var749D452026CFB6F3ABFC79893B86F4EB_1358155945;
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
                    boolean var68934A3E9455FA72420237EB05902327_944318949 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2098411195 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_2098411195;
                } //End block
            } //End block
            finally 
            {
    if(prog != null)                
                prog.close();
            } //End block
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_902663909 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_745598997 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_745598997;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.914 -0400", hash_original_method = "8D335FE0EDA9A8017E889380A7A722CF", hash_generated_method = "7DC2BD660B2CDC6483080370E51D7A42")
    private void dbopen(String path, int flags) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.914 -0400", hash_original_method = "70E20853624884484C3836EF6F149A55", hash_generated_method = "079E6181584D18FF7794E2CCCC7EC698")
    private void enableSqlTracing(String path, short connectionNum) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.915 -0400", hash_original_method = "C8A96013E7D0E582573D33F32AE9CEB2", hash_generated_method = "8E4CC6A847CB4D4A755E1D378C2FD667")
    private void enableSqlProfiling(String path, short connectionNum) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.915 -0400", hash_original_method = "D6178DAC9B84DE9466B1B633DF097ED8", hash_generated_method = "4E544159901989F8659751014F855197")
    private void native_setLocale(String loc, int flags) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.916 -0400", hash_original_method = "94C6AE32C9A996CB80A0C1FADFD7D1F2", hash_generated_method = "7EBBFEA771DC414FFD9D6454ABE0F807")
    private int native_getDbLookaside() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_512351435 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_512351435;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.916 -0400", hash_original_method = "C4F8F8FDF64373EAEBE82B2B8F80D5C0", hash_generated_method = "E6AC894F82F9E2B742C2DEB8A39D8080")
    private final void native_finalize(int statementId) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.916 -0400", hash_original_method = "324F9A57AA3484DEBE48152EFBF728CA", hash_generated_method = "0CEE753090AC8DD2CCDAA7F7430628D4")
    private void native_setSqliteSoftHeapLimit(int softHeapLimit) {
    }

    
    private static class DatabaseReentrantLock extends ReentrantLock {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.917 -0400", hash_original_method = "FF2E769A330F113FDEF775F7B9F0F4EF", hash_generated_method = "31CB5E32D763205F06BFE445BA191A42")
          DatabaseReentrantLock(boolean fair) {
            super(fair);
            addTaint(fair);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.917 -0400", hash_original_method = "1BB82FD0B3090B035906C5C5A5300D7F", hash_generated_method = "E320A35382030B0AF8FCADEB2ED61AFD")
        @Override
        public Thread getOwner() {
Thread var9339B408D15ACEBD23DAAE73BA89B0F6_493284986 =             super.getOwner();
            var9339B408D15ACEBD23DAAE73BA89B0F6_493284986.addTaint(taint);
            return var9339B408D15ACEBD23DAAE73BA89B0F6_493284986;
            // ---------- Original Method ----------
            //return super.getOwner();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.917 -0400", hash_original_method = "0A30C3A8A16B3E36E180D94391681301", hash_generated_method = "E01209517D82EAF57E15B5D8C91942D4")
        public String getOwnerDescription() {
            Thread t = getOwner();
String var19DD9E73F4087CD137294D2178EAC43F_506975744 =             (t== null) ? "none" : String.valueOf(t.getId());
            var19DD9E73F4087CD137294D2178EAC43F_506975744.addTaint(taint);
            return var19DD9E73F4087CD137294D2178EAC43F_506975744;
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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.918 -0400", hash_original_field = "D18B04353DB06786DFA19F38E1E3F9F8", hash_generated_field = "B031AA443BF0B15D9BA58FE3D3C788E6")

    private static final String TAG = "SQLiteDatabase";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.918 -0400", hash_original_field = "505A38A2470AB971646D45095C12E31F", hash_generated_field = "3548346B1EB3CE378E747DF13DAF2E94")

    private static final boolean ENABLE_DB_SAMPLE = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.918 -0400", hash_original_field = "4747FA61A14E68F397B403C3BF573138", hash_generated_field = "7C746BEBD1F52CCE281BC2AE78043C31")

    private static final int EVENT_DB_OPERATION = 52000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.918 -0400", hash_original_field = "FA2DCB40C8C2E6B3E9DC95D493219399", hash_generated_field = "9435052DF2978607705FE1A674B3B476")

    private static final int EVENT_DB_CORRUPT = 75004;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.918 -0400", hash_original_field = "790D60FA6E696D93692BA35CB0438294", hash_generated_field = "AB29804A115D818B6ACC16F36A2A6B4A")

    public static final int CONFLICT_ROLLBACK = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.918 -0400", hash_original_field = "8FF68E568D06942129BAB7786008CC27", hash_generated_field = "39B42E823E1997DA6D833E1BBD40FA58")

    public static final int CONFLICT_ABORT = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.918 -0400", hash_original_field = "117A84E9B3C20F8BD0A9D3FA05866829", hash_generated_field = "335E697F888616CE067B72F214C1BC32")

    public static final int CONFLICT_FAIL = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.918 -0400", hash_original_field = "3965F8F98E49E75266581A5EDCF28288", hash_generated_field = "46745826C06802839FCD46D51B439306")

    public static final int CONFLICT_IGNORE = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.919 -0400", hash_original_field = "63D7302A74CC755B81E5DA5FF2200F4B", hash_generated_field = "E863D6302F78EAED37A44DA0ED539003")

    public static final int CONFLICT_REPLACE = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.919 -0400", hash_original_field = "4A361B4F834FE1F0F6BB46551B141B34", hash_generated_field = "8969586D204DC9CDF495FFB0724623A9")

    public static final int CONFLICT_NONE = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.919 -0400", hash_original_field = "58CEAD30C6D151BCF416BDDB99D29495", hash_generated_field = "CEB6E56BB51D4EFBAE585B39DC049839")

    private static final String[] CONFLICT_VALUES = new String[]
            {"", " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE "};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.919 -0400", hash_original_field = "1E5817575F0E997F1243F638D5895D4E", hash_generated_field = "307B7E85D5D9B51588F8134872D28FA2")

    public static final int SQLITE_MAX_LIKE_PATTERN_LENGTH = 50000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.919 -0400", hash_original_field = "C6DEAE97C40012AF75B50C3B2999BB0A", hash_generated_field = "629E71001BC03CF7522CF9DF396F3CD0")

    public static final int OPEN_READWRITE = 0x00000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.919 -0400", hash_original_field = "902213259DEC7410D30EF3DFF53CABCB", hash_generated_field = "4E1D616F2DC9D0F7F19E42689377DE9D")

    public static final int OPEN_READONLY = 0x00000001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.920 -0400", hash_original_field = "3CE8162CF9656F8FCB8B5B90A59AD3ED", hash_generated_field = "5187312D154815C7B5E63606C7E8136A")

    private static final int OPEN_READ_MASK = 0x00000001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.920 -0400", hash_original_field = "09B9A0E2C049E747CB9560AF8560A1C4", hash_generated_field = "099AB38E222487A3F22F8D84E49C790B")

    public static final int NO_LOCALIZED_COLLATORS = 0x00000010;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.920 -0400", hash_original_field = "5D9E28D3CB398796FE04F7E00299B712", hash_generated_field = "51E7E16B8C63BFDCCFDDEE94FF22F7BB")

    public static final int CREATE_IF_NECESSARY = 0x10000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.920 -0400", hash_original_field = "963E0DAA128D9868E6CC8434473DB4B9", hash_generated_field = "2D7B5C77835222796D1E38850A1796FA")

    private static final int LOCK_WARNING_WINDOW_IN_MS = 20000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.920 -0400", hash_original_field = "E6AE6AEA20BF0D87AE52DA89192BC72A", hash_generated_field = "77D4EFADB5F65862A8907D645B6665E9")

    private static final int LOCK_ACQUIRED_WARNING_TIME_IN_MS = 300;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.920 -0400", hash_original_field = "95C6E5D7087CC2FC3A6DED5953679ECB", hash_generated_field = "A15D7DDE2E5CA3854E9FBBCADF643DF0")

    private static final int LOCK_ACQUIRED_WARNING_THREAD_TIME_IN_MS = 100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.920 -0400", hash_original_field = "7A6A59391B6242130CD71E5CD44E2D77", hash_generated_field = "C09CEC99CA0E20EA63872D1D54E55D2E")

    private static final int LOCK_ACQUIRED_WARNING_TIME_IN_MS_ALWAYS_PRINT = 2000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.921 -0400", hash_original_field = "CE309D87C3B10C71416ADF374777959F", hash_generated_field = "79E0F0AE9DE5E092336F50A45B4F8E1C")

    private static final int SLEEP_AFTER_YIELD_QUANTUM = 1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.921 -0400", hash_original_field = "5A389AB78BAF71DFE16B183F0C0E378C", hash_generated_field = "C84D9BD6B88C4ED7056C3B3F36774679")

    private static final Pattern EMAIL_IN_DB_PATTERN = Pattern.compile("[\\w\\.\\-]+@[\\w\\.\\-]+");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.921 -0400", hash_original_field = "54034B3C28E0BBADA285EC1AF26CD74C", hash_generated_field = "F4B529B387535F4368A600135D078A3F")

    private static int sQueryLogTimeInMillis = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.921 -0400", hash_original_field = "575EC464A3C910F3BE22BF3A40203271", hash_generated_field = "7148D851E918ABFB8558501AAF276067")

    private static final int QUERY_LOG_SQL_LENGTH = 64;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.921 -0400", hash_original_field = "68F17C8C6A1B7DDEBB7E0A50981231C4", hash_generated_field = "6E2686DCB15E3EED77BA00F0CDFF3560")

    private static final String COMMIT_SQL = "COMMIT;";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.921 -0400", hash_original_field = "9A60E40448B652CACF05359C701B5CC3", hash_generated_field = "6F4F9F4CA4122F0E0B63ADF311633E3F")

    private static final String BEGIN_SQL = "BEGIN;";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.922 -0400", hash_original_field = "F3551E46D929A290CE215BE1F66731CA", hash_generated_field = "B02DFFEED2F25BA54B1F54EB152A8058")

    static final String GET_LOCK_LOG_PREFIX = "GETLOCK:";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.922 -0400", hash_original_field = "5060FAACDAC84EA2DCCD0E197482A2DD", hash_generated_field = "51F4D205C63830AACD25F15FCA50EBDA")

    private static int sBlockSize = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.922 -0400", hash_original_field = "AB0CA8692820F6E5F155F4D312F65AF1", hash_generated_field = "3DC1596E29EDB016C413E70C0C6823BE")

    private static final int DEFAULT_SQL_CACHE_SIZE = 25;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.922 -0400", hash_original_field = "AD68061788347E0928ECF0DDBAB674B1", hash_generated_field = "FEBE70CE9042F617C4B8B12131A1C6AA")

    public static final int MAX_SQL_CACHE_SIZE = 100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.922 -0400", hash_original_field = "8F1610D46CA335F7A68476444639CCA5", hash_generated_field = "076429DC648CA31B53EA5479063A01DC")

    private static final String MEMORY_DB_PATH = ":memory:";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.922 -0400", hash_original_field = "B85ABB2B3844882B62C4390BDB646BAF", hash_generated_field = "6C1DD837716F02A5B85D056ED49553B5")

    private static ArrayList<WeakReference<SQLiteDatabase>> mActiveDatabases = new ArrayList<WeakReference<SQLiteDatabase>>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.922 -0400", hash_original_field = "4BCAA4A60DD2EB17A628C800025F88DA", hash_generated_field = "87A9BD3D7700EA6364DB461A232CAEB6")

    private static final long LOCK_WAIT_PERIOD = 30L;
}

