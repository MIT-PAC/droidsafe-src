package android.database.sqlite;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.417 -0400", hash_original_field = "2F577CFF36E03467323CF3302EA45D6C", hash_generated_field = "E7056D75F4E4E6EB0CBA6DCE1F4F880B")

    private boolean mInnerTransactionIsSuccessful;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.417 -0400", hash_original_field = "58201914BA1B4FF47E7AA07A0AC57171", hash_generated_field = "6128EACBB7FB1B535A59BE78E36968AA")

    private boolean mTransactionIsSuccessful;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.417 -0400", hash_original_field = "DE7B86B82681B1155E0009C050CFB43B", hash_generated_field = "793A3AAAFBEB0F437207EF8CF58BE261")

    private SQLiteTransactionListener mTransactionListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.417 -0400", hash_original_field = "04FD74AF5748E24AC35D8C0603418D5F", hash_generated_field = "2A25F85A83E5F358C0E921DE63F86FF2")

    private boolean mTransactionUsingExecSql;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.417 -0400", hash_original_field = "F4A7BA9A35E5B32B183DF50E4F1B2E28", hash_generated_field = "F912814B4E1DAAFDC17C50234EB3FC06")

    private final DatabaseReentrantLock mLock = new DatabaseReentrantLock(true);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.417 -0400", hash_original_field = "2B698D4C503D685ED004A6B4BAF0E658", hash_generated_field = "D440BCD52A102185E811EA93A644CB1C")

    private long mLockAcquiredWallTime = 0L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.417 -0400", hash_original_field = "05E26C9ECB3EBA196676EBEDA0B25BCF", hash_generated_field = "F25F6124FA463B622FD2DD5ABA3051C7")

    private long mLockAcquiredThreadTime = 0L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.417 -0400", hash_original_field = "0804BE3D194F1641DC0D1E5AE35F40C1", hash_generated_field = "5D29D9D368D28B86CEE0F5B707514CDA")

    private long mLastLockMessageTime = 0L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.417 -0400", hash_original_field = "536255EED7E3D46DD70E09FDE814B7C1", hash_generated_field = "E26D41E197237C24B0E74C0394AEDF83")

    private final Random mRandom = new Random();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.417 -0400", hash_original_field = "20ED2B28EBE0BAD29D7FEAFD9AF86FC5", hash_generated_field = "1CE2C34780F47FA064A655A949D3653C")

    private String mLastSqlStatement = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.417 -0400", hash_original_field = "E494CEFBB739C03E3C976C715E226811", hash_generated_field = "4ED7543F27609F494F3BFF9473206AD9")

    private long mTransStartTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.417 -0400", hash_original_field = "E86FCFA606742ADBAB1B20F7996FCC4A", hash_generated_field = "B37C03DF0BF1A86153C7C2FA952C3E00")

    volatile int mNativeHandle = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.417 -0400", hash_original_field = "FB4FCB3508FC66D4E3F113990AC335C6", hash_generated_field = "6FACC3B41470C8330B5F0BB43FA7FD9F")

    private String mPath;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.417 -0400", hash_original_field = "5CC96EA0C7233DAE6629EB63E2D17046", hash_generated_field = "0FAF2BD49EE9B945E5C01C36BBE76EC3")

    private String mPathForLogs = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.418 -0400", hash_original_field = "9C3CD7D37D3E1E66BE9B3B005FC98B3A", hash_generated_field = "43F71E9173849705E01112D0229448B4")

    private int mFlags;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.418 -0400", hash_original_field = "06389DE86ED19AB1571A41645A1AFADC", hash_generated_field = "3B314DD3362D9759017A383358149E45")

    private CursorFactory mFactory;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.418 -0400", hash_original_field = "712AB6C8C770AEF7CF757D19A4FD0E38", hash_generated_field = "7586811E7431EEE33AF976CF89950239")

    private WeakHashMap<SQLiteClosable, Object> mPrograms;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.418 -0400", hash_original_field = "60E07EDA42F3E1922C63D09AD9383086", hash_generated_field = "B49BE5C26AFC2BC39563929C5F16CB5B")

    private LruCache<String, SQLiteCompiledSql> mCompiledQueries;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.418 -0400", hash_original_field = "F6246ADED535BB5A06E89B98F4448AB0", hash_generated_field = "4E5EC633EDC17753869972551C767C68")

    private boolean mCacheFullWarning;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.418 -0400", hash_original_field = "9581B90EA40AE59A20069CB826265080", hash_generated_field = "7D1AA4359A52B133BFAD994AB60E8C14")

    private Throwable mStackTrace;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.418 -0400", hash_original_field = "8103C9EA0927CDF9D803AF1FFEC26BE1", hash_generated_field = "0D9B8E09B51F96D0F503825B2DDED11B")

    private final ArrayList<Integer> mClosedStatementIds = new ArrayList<Integer>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.418 -0400", hash_original_field = "17F47A6FF3D481E01A6A82252EB7B064", hash_generated_field = "76DD5A0A5A09A890A2237FBF965CCF6C")

    private DatabaseErrorHandler mErrorHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.418 -0400", hash_original_field = "7A6BE8614B7E2A423C6F53496DF6BA29", hash_generated_field = "C4D2A249F5C70FA118DDA6CA9913AA66")

    volatile DatabaseConnectionPool mConnectionPool = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.418 -0400", hash_original_field = "606D462EAF936BEF827280E106823795", hash_generated_field = "38AABF491E6B9AC2F1FDAC5FCB6A30E7")

    short mConnectionNum;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.418 -0400", hash_original_field = "2752BF6ACAFADFCCDA452687FCF2CED4", hash_generated_field = "4A262DC52D3676F75324E8DD3283FF83")

    SQLiteDatabase mParentConnObj = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.418 -0400", hash_original_field = "63C6D7999E4974E970EC9568F93B0B54", hash_generated_field = "760D925FEAB058AF61B1B94D2C774DE6")

    private volatile boolean mHasAttachedDbs = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.418 -0400", hash_original_field = "34BA12267248F06139E7DE34F0AE6051", hash_generated_field = "560D9A0D28C1D8056EAB428EF4EA40FE")

    private boolean mLockingEnabled = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.418 -0400", hash_original_field = "51484C5CAD4631F0A71FAFC0D9435C9A", hash_generated_field = "BCE91343C41461430195125FEC2F1572")

    private final ArrayList<Integer> mCustomFunctions = new ArrayList<Integer>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.419 -0400", hash_original_method = "ED994C20AB51232E6F0B83AA0494CFAA", hash_generated_method = "2C03E2B4020A8A58CEF1376DFFBB518E")
    private  SQLiteDatabase(String path, CursorFactory factory, int flags,
            DatabaseErrorHandler errorHandler, short connectionNum) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("path should not be null");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.420 -0400", hash_original_method = "C15F9F532AF7810AA7D3562C5DDE29F6", hash_generated_method = "A9D129BBD595A6E61B69715CF5886C26")
    synchronized String getLastSqlStatement() {
        String varB4EAC82CA7396A68D541C85D26508E83_1031843579 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1031843579 = mLastSqlStatement;
        varB4EAC82CA7396A68D541C85D26508E83_1031843579.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1031843579;
        // ---------- Original Method ----------
        //return mLastSqlStatement;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.420 -0400", hash_original_method = "3743AC991024775005FDBE1593E9891E", hash_generated_method = "77D67C706792A5CD082ECBF7B819ED3C")
    synchronized void setLastSqlStatement(String sql) {
        mLastSqlStatement = sql;
        // ---------- Original Method ----------
        //mLastSqlStatement = sql;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.421 -0400", hash_original_method = "FF36C1ABFEC0F5F1C3DFBA7FD0941B56", hash_generated_method = "1288D57E35431D08B50A3F823A743810")
    synchronized void addSQLiteClosable(SQLiteClosable closable) {
        mPrograms.put(closable, null);
        addTaint(closable.getTaint());
        // ---------- Original Method ----------
        //mPrograms.put(closable, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.421 -0400", hash_original_method = "030B4AA23DD4EAEE65D260C86C2A8B4C", hash_generated_method = "11BD89EF8E40C2431EAAE66635798713")
    synchronized void removeSQLiteClosable(SQLiteClosable closable) {
        mPrograms.remove(closable);
        addTaint(closable.getTaint());
        // ---------- Original Method ----------
        //mPrograms.remove(closable);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.422 -0400", hash_original_method = "29F441CF35047DF9CBB0BC7BF2B03F36", hash_generated_method = "1E8A310ED119CC7354FFD9DFD1B70EB4")
    @Override
    protected void onAllReferencesReleased() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean varF14FAC85BD81325B95F4F52AC5545E52_824420640 = (isOpen());
            {
                close();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (isOpen()) {
            //close();
        //}
    }

    
    static public int releaseMemory() {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.423 -0400", hash_original_method = "CD58BEDD0347A27F6CFE4EB9BEFDF2F6", hash_generated_method = "A1146177C8FA9BB90B6D94105F882124")
    public void setLockingEnabled(boolean lockingEnabled) {
        mLockingEnabled = lockingEnabled;
        // ---------- Original Method ----------
        //mLockingEnabled = lockingEnabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.423 -0400", hash_original_method = "6F1C3BA1763F74F7C0395D958A12A363", hash_generated_method = "3EE5C6657C638478CD9F042AD044BF04")
     void onCorruption() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        EventLog.writeEvent(EVENT_DB_CORRUPT, mPath);
        mErrorHandler.onCorruption(this);
        // ---------- Original Method ----------
        //EventLog.writeEvent(EVENT_DB_CORRUPT, mPath);
        //mErrorHandler.onCorruption(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.424 -0400", hash_original_method = "6F6099DC841EA0266005BC3A83B18A96", hash_generated_method = "36D78ABBBA0C51238C1DAFF2225079DD")
     void lock(String sql) {
        lock(sql, false);
        addTaint(sql.getTaint());
        // ---------- Original Method ----------
        //lock(sql, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.424 -0400", hash_original_method = "8D6DAA6963637C0BD50884518E0FF993", hash_generated_method = "31DA195A8CACA429F53CC674AB87F7FD")
     void lock() {
        lock(null, false);
        // ---------- Original Method ----------
        //lock(null, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.425 -0400", hash_original_method = "550218B4AE04D143508369398336F95D", hash_generated_method = "E38C23FF479889B7BF58ECAD74704AB1")
    private void lock(String sql, boolean forced) {
        {
            boolean var0236CB8C0F56FF35CDAF225C25DD9AAC_789800213 = (Thread.holdsLock(this));
        } //End collapsed parenthetic
        verifyDbIsOpen();
        boolean done = false;
        long timeStart = SystemClock.uptimeMillis();
        {
            try 
            {
                done = mLock.tryLock(LOCK_WAIT_PERIOD, TimeUnit.SECONDS);
            } //End block
            catch (InterruptedException e)
            { }
        } //End block
        {
            {
                boolean varFAE68FF2C6BC8FEF8EA9B7CE8CF77E28_2007810258 = (mLock.getHoldCount() == 1);
                {
                    mLockAcquiredWallTime = SystemClock.elapsedRealtime();
                    mLockAcquiredThreadTime = Debug.threadCpuTimeNanos();
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                logTimeStat(sql, timeStart, GET_LOCK_LOG_PREFIX);
            } //End block
        } //End block
        addTaint(sql.getTaint());
        addTaint(forced);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.425 -0400", hash_original_method = "5F1F87633E052520A24DBAD554D491B1", hash_generated_method = "993B0F3F2A36649E79B8CF2BDCBA15D6")
    private void lockForced() {
        lock(null, true);
        // ---------- Original Method ----------
        //lock(null, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.426 -0400", hash_original_method = "E1FDB470EFF9EA86A5AAC7A627D6955E", hash_generated_method = "E9057024B6CF0F4A0EFB9FF9C0D56385")
    private void lockForced(String sql) {
        lock(sql, true);
        addTaint(sql.getTaint());
        // ---------- Original Method ----------
        //lock(sql, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.426 -0400", hash_original_method = "CB05AAFAB101AFFDD598174816C61BF7", hash_generated_method = "78B4F425D61817C3963CEF6720E3476A")
     void unlock() {
        {
            {
                boolean varFAE68FF2C6BC8FEF8EA9B7CE8CF77E28_835298970 = (mLock.getHoldCount() == 1);
                {
                    checkLockHoldTime();
                } //End block
            } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.426 -0400", hash_original_method = "CA4E01B405088BC736DA3EA88D772AB0", hash_generated_method = "52067D4BFCF1C652DC601B1D79EFE467")
    private void unlockForced() {
        {
            {
                boolean varFAE68FF2C6BC8FEF8EA9B7CE8CF77E28_649330657 = (mLock.getHoldCount() == 1);
                {
                    checkLockHoldTime();
                } //End block
            } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.427 -0400", hash_original_method = "15FB67C6B55CF4F17EB9E05703E68C1A", hash_generated_method = "526E19121CC2B969BD784509F35C6EBB")
    private void checkLockHoldTime() {
        long elapsedTime = SystemClock.elapsedRealtime();
        long lockedTime = elapsedTime - mLockAcquiredWallTime;
        {
            boolean var1C0B53C7CF19FA5142D07A08F2710172_1628051486 = (lockedTime < LOCK_ACQUIRED_WARNING_TIME_IN_MS_ALWAYS_PRINT &&
                !Log.isLoggable(TAG, Log.VERBOSE) &&
                (elapsedTime - mLastLockMessageTime) < LOCK_WARNING_WINDOW_IN_MS);
        } //End collapsed parenthetic
        {
            int threadTime = (int)
                    ((Debug.threadCpuTimeNanos() - mLockAcquiredThreadTime) / 1000000);
            {
                mLastLockMessageTime = elapsedTime;
                String msg = "lock held on " + mPath + " for " + lockedTime + "ms. Thread time was "
                        + threadTime + "ms";
                {
                    Log.d(TAG, msg, new Exception());
                } //End block
                {
                    Log.d(TAG, msg);
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.427 -0400", hash_original_method = "36B8D50340D02900F098E44F066CFF12", hash_generated_method = "145909AA25037E1D599C021529CE7F8B")
    public void beginTransaction() {
        beginTransaction(null , true);
        // ---------- Original Method ----------
        //beginTransaction(null , true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.428 -0400", hash_original_method = "E00D9BE9F4C6FCF885F8A6933F83E5B2", hash_generated_method = "00651A551214FF436836A41E2DCE0672")
    public void beginTransactionNonExclusive() {
        beginTransaction(null , false);
        // ---------- Original Method ----------
        //beginTransaction(null , false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.428 -0400", hash_original_method = "5BD04E9A01CA28B4B773A517F832DDF2", hash_generated_method = "4C4A1422AB9FD108DBE0D908DB77F133")
    public void beginTransactionWithListener(SQLiteTransactionListener transactionListener) {
        beginTransaction(transactionListener, true);
        addTaint(transactionListener.getTaint());
        // ---------- Original Method ----------
        //beginTransaction(transactionListener, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.428 -0400", hash_original_method = "EB4000007896884F9C35346C5F5B9337", hash_generated_method = "79EFFDA38A1F222AA73AE054EC63DCC8")
    public void beginTransactionWithListenerNonExclusive(
            SQLiteTransactionListener transactionListener) {
        beginTransaction(transactionListener, false);
        addTaint(transactionListener.getTaint());
        // ---------- Original Method ----------
        //beginTransaction(transactionListener, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.429 -0400", hash_original_method = "65C15EF02A1263C4153105EBF58851D9", hash_generated_method = "A15A9CC40D1EC07B4DE56E677A148D5D")
    private void beginTransaction(SQLiteTransactionListener transactionListener,
            boolean exclusive) {
        verifyDbIsOpen();
        lockForced(BEGIN_SQL);
        boolean ok = false;
        try 
        {
            {
                boolean varAF914129F00129CFDB57A245D2027B2F_631016198 = (mLock.getHoldCount() > 1);
                {
                    {
                        String msg = "Cannot call beginTransaction between "
                            + "calling setTransactionSuccessful and endTransaction";
                        IllegalStateException e = new IllegalStateException(msg);
                        if (DroidSafeAndroidRuntime.control) throw e;
                    } //End block
                    ok = true;
                } //End block
            } //End collapsed parenthetic
            {
                execSQL("BEGIN EXCLUSIVE;");
            } //End block
            {
                execSQL("BEGIN IMMEDIATE;");
            } //End block
            mTransStartTime = SystemClock.uptimeMillis();
            mTransactionListener = transactionListener;
            mTransactionIsSuccessful = true;
            mInnerTransactionIsSuccessful = false;
            {
                try 
                {
                    transactionListener.onBegin();
                } //End block
                catch (RuntimeException e)
                {
                    execSQL("ROLLBACK;");
                    if (DroidSafeAndroidRuntime.control) throw e;
                } //End block
            } //End block
            ok = true;
        } //End block
        finally 
        {
            {
                unlockForced();
            } //End block
        } //End block
        addTaint(exclusive);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.430 -0400", hash_original_method = "94F2931FC5A304B6FE8748C95A17E4E3", hash_generated_method = "C3432AC657EB186263D45999ADC99C00")
    public void endTransaction() {
        verifyLockOwner();
        try 
        {
            {
                mInnerTransactionIsSuccessful = false;
            } //End block
            {
                mTransactionIsSuccessful = false;
            } //End block
            {
                boolean varBAE3CD5B00DE7A95D508FDA3C102ACA4_10111765 = (mLock.getHoldCount() != 1);
            } //End collapsed parenthetic
            RuntimeException savedException = null;
            {
                try 
                {
                    {
                        mTransactionListener.onCommit();
                    } //End block
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
            {
                execSQL(COMMIT_SQL);
                {
                    execSQL("PRAGMA wal_checkpoint;");
                } //End block
                {
                    logTimeStat(getLastSqlStatement(), mTransStartTime, COMMIT_SQL);
                } //End block
            } //End block
            {
                try 
                {
                    execSQL("ROLLBACK;");
                    {
                        if (DroidSafeAndroidRuntime.control) throw savedException;
                    } //End block
                } //End block
                catch (SQLException e)
                {
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
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.430 -0400", hash_original_method = "CAD10DEB5A167AB4D97D078F2E23C48E", hash_generated_method = "BFF432B0180F94ED5CC746722BC7C0E2")
    public void setTransactionSuccessful() {
        verifyDbIsOpen();
        {
            boolean varA9768C0684D8D9C3694FCFB8FF7505EA_689579895 = (!mLock.isHeldByCurrentThread());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("no transaction pending");
            } //End block
        } //End collapsed parenthetic
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(
                    "setTransactionSuccessful may only be called once per call to beginTransaction");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.430 -0400", hash_original_method = "6E9122EA7DDDF4A7FCE3C41AA714113C", hash_generated_method = "20FE88F1DAB0BDF9FEC4480DB89DA457")
    public boolean inTransaction() {
        boolean var4C9D249B5D0C4B9126D436C907678D95_1080880820 = (mLock.getHoldCount() > 0 || mTransactionUsingExecSql);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_782978583 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_782978583;
        // ---------- Original Method ----------
        //return mLock.getHoldCount() > 0 || mTransactionUsingExecSql;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.431 -0400", hash_original_method = "5CE93639419B30E518363E5F446309C9", hash_generated_method = "EC8B4970B7D4701DE452DCB48911DA26")
    synchronized void setTransactionUsingExecSqlFlag() {
        {
            boolean var7061DF8A5335B809C796044C2A062407_54894200 = (Log.isLoggable(TAG, Log.DEBUG));
        } //End collapsed parenthetic
        mTransactionUsingExecSql = true;
        // ---------- Original Method ----------
        //if (Log.isLoggable(TAG, Log.DEBUG)) {
            //Log.i(TAG, "found execSQL('begin transaction')");
        //}
        //mTransactionUsingExecSql = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.431 -0400", hash_original_method = "37864C1F3B8C10FDA9B20AB532C7EB78", hash_generated_method = "9E37474059C5CACFB0819BF05A6219AD")
    synchronized void resetTransactionUsingExecSqlFlag() {
        {
            boolean var7061DF8A5335B809C796044C2A062407_1273613689 = (Log.isLoggable(TAG, Log.DEBUG));
        } //End collapsed parenthetic
        mTransactionUsingExecSql = false;
        // ---------- Original Method ----------
        //if (Log.isLoggable(TAG, Log.DEBUG)) {
            //if (mTransactionUsingExecSql) {
                //Log.i(TAG, "found execSQL('commit or end or rollback')");
            //}
        //}
        //mTransactionUsingExecSql = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.432 -0400", hash_original_method = "18141E27A4A6F223116C15568E4B1710", hash_generated_method = "83A8DF90BCD023EF3E09A3A294199EC6")
    synchronized boolean amIInTransaction() {
        SQLiteDatabase db;
        boolean var81E049CAF652C4104E2A8460AB4F8005_405667219 = ((isPooledConnection()));
        db = mParentConnObj;
        db = this;
        boolean b;
        boolean var052869E209429152260CA7258506DF14_271271478 = ((!db.inTransaction()));
        b = false;
        b = db.mTransactionUsingExecSql || db.mLock.isHeldByCurrentThread();
        {
            boolean var7061DF8A5335B809C796044C2A062407_1389436330 = (Log.isLoggable(TAG, Log.DEBUG));
        } //End collapsed parenthetic
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1545214018 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1545214018;
        // ---------- Original Method ----------
        //SQLiteDatabase db = (isPooledConnection()) ? mParentConnObj : this;
        //boolean b = (!db.inTransaction()) ? false :
                //db.mTransactionUsingExecSql || db.mLock.isHeldByCurrentThread();
        //if (Log.isLoggable(TAG, Log.DEBUG)) {
            //Log.i(TAG, "amIinTransaction: " + b);
        //}
        //return b;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.432 -0400", hash_original_method = "810FBEC1135AAF9FE09D5ED72E2387AC", hash_generated_method = "E92F446C2196AAA5BABEDDD9EAC32F35")
    public boolean isDbLockedByCurrentThread() {
        boolean var652252C690B50A2DB779325937C5EC45_480492384 = (mLock.isHeldByCurrentThread());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1000836139 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1000836139;
        // ---------- Original Method ----------
        //return mLock.isHeldByCurrentThread();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.433 -0400", hash_original_method = "AFE51BB500BDF01026C5B1FB8FA31F68", hash_generated_method = "3DE3DF7C65BE0A8F93B77EEF2351A6B6")
    public boolean isDbLockedByOtherThreads() {
        boolean var8B5E8AE7202897DC44889938EB039DD8_1546369241 = (!mLock.isHeldByCurrentThread() && mLock.isLocked());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2056534261 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2056534261;
        // ---------- Original Method ----------
        //return !mLock.isHeldByCurrentThread() && mLock.isLocked();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.434 -0400", hash_original_method = "275C631F29B5F92F82765C72693E08C5", hash_generated_method = "329B7BB175298CA71631C965A187F977")
    @Deprecated
    public boolean yieldIfContended() {
        boolean var50D0DC9993A243282E70CF5F32C6948B_1141862892 = (yieldIfContendedHelper(false ,
                -1 ));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_529271632 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_529271632;
        // ---------- Original Method ----------
        //return yieldIfContendedHelper(false ,
                //-1 );
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.435 -0400", hash_original_method = "E4D6EC2B61BA0EB36CC3F2E9664FDE2E", hash_generated_method = "92B6CC401D8B585841CF7913F44FF5A6")
    public boolean yieldIfContendedSafely() {
        boolean var1B84B5B6D1C3C26E51A46F65AE31AC61_1505928975 = (yieldIfContendedHelper(true , -1 ));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1568457380 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1568457380;
        // ---------- Original Method ----------
        //return yieldIfContendedHelper(true , -1 );
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.435 -0400", hash_original_method = "EFD5966AFCC9629F634B854AE0830507", hash_generated_method = "3B3712A56AD5A9B3BEDE55317F0DC872")
    public boolean yieldIfContendedSafely(long sleepAfterYieldDelay) {
        boolean var7C02635E5B9B12611B1E13892F20EFA4_1444662579 = (yieldIfContendedHelper(true , sleepAfterYieldDelay));
        addTaint(sleepAfterYieldDelay);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1184703265 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1184703265;
        // ---------- Original Method ----------
        //return yieldIfContendedHelper(true , sleepAfterYieldDelay);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.436 -0400", hash_original_method = "82E88213585314141BE9DBE00F951B10", hash_generated_method = "BBF11FC3963019EF799F8A89779DEBA5")
    private boolean yieldIfContendedHelper(boolean checkFullyYielded, long sleepAfterYieldDelay) {
        {
            boolean var5B3E72ED3F61C626DE29DC9592245606_1976531400 = (mLock.getQueueLength() == 0);
            {
                mLockAcquiredWallTime = SystemClock.elapsedRealtime();
                mLockAcquiredThreadTime = Debug.threadCpuTimeNanos();
            } //End block
        } //End collapsed parenthetic
        setTransactionSuccessful();
        SQLiteTransactionListener transactionListener = mTransactionListener;
        endTransaction();
        {
            {
                boolean var42788A8E0393F9B1C6C2ADCA7B153774_2034840342 = (this.isDbLockedByCurrentThread());
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(
                        "Db locked more than once. yielfIfContended cannot yield");
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            long remainingDelay = sleepAfterYieldDelay;
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
                {
                    boolean var741E584956C4EDE940BCF4AF8237BB37_345231376 = (mLock.getQueueLength() == 0);
                } //End collapsed parenthetic
            } //End block
        } //End block
        beginTransactionWithListener(transactionListener);
        addTaint(checkFullyYielded);
        addTaint(sleepAfterYieldDelay);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_335660947 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_335660947;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.437 -0400", hash_original_method = "2BF74CD6834BBADBF27F65464DB83499", hash_generated_method = "BD845D605060F3F266DC3B15647C2634")
    @Deprecated
    public Map<String, String> getSyncedTables() {
        Map<String, String> varB4EAC82CA7396A68D541C85D26508E83_616415640 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_616415640 = new HashMap<String, String>(0);
        varB4EAC82CA7396A68D541C85D26508E83_616415640.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_616415640;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.438 -0400", hash_original_method = "4DBAD15B0F91A1B1A1A509E057CF6487", hash_generated_method = "01FD3BCC0C4E5FE7BF6BE1A8CE84C017")
    private void setJournalMode(final String dbPath, final String mode) {
        {
            boolean varC8B178D4C16CE00624EBB098975A6C60_382069766 = (dbPath.equalsIgnoreCase(MEMORY_DB_PATH) || isReadOnly());
        } //End collapsed parenthetic
        String s = DatabaseUtils.stringForQuery(this, "PRAGMA journal_mode=" + mode, null);
        {
            boolean varAE0C33F5A2193A82451F284839087E0B_1755177120 = (!s.equalsIgnoreCase(mode));
        } //End collapsed parenthetic
        addTaint(dbPath.getTaint());
        addTaint(mode.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.439 -0400", hash_original_method = "F057ECACA47F2E639159F91F6FF25AA8", hash_generated_method = "AA896668E6677679331122E7470837F4")
    public void close() {
        {
            boolean var3A7D61B68AE823F6A30349D498C59A5C_1575602087 = (!isOpen());
        } //End collapsed parenthetic
        {
            boolean var7061DF8A5335B809C796044C2A062407_670444238 = (Log.isLoggable(TAG, Log.DEBUG));
        } //End collapsed parenthetic
        lock();
        try 
        {
            {
                boolean varC984E2D68DED4A73C5D827F4E91A6961_17483451 = (!isOpen());
            } //End collapsed parenthetic
            closeClosable();
            closePendingStatements();
            releaseCustomFunctions();
            closeDatabase();
            {
                {
                    boolean var4202D0C449E97752DAE596DFB30FD8C9_252533473 = (Log.isLoggable(TAG, Log.DEBUG));
                } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.440 -0400", hash_original_method = "2CD800231F10038F3799DBDAB26BCEE1", hash_generated_method = "DE553B322D916EE2213959EF8A7E3C5E")
    private void closeClosable() {
        deallocCachedSqlStatements();
        Iterator<Map.Entry<SQLiteClosable, Object>> iter = mPrograms.entrySet().iterator();
        {
            boolean varADABAFEBBAB7E585DD903333BD7F20A8_1036071214 = (iter.hasNext());
            {
                Map.Entry<SQLiteClosable, Object> entry = iter.next();
                SQLiteClosable program = entry.getKey();
                {
                    program.onAllReferencesReleasedFromContainer();
                } //End block
            } //End block
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.440 -0400", hash_original_method = "9BCDA7BC5AA364A3676019422CD41F65", hash_generated_method = "4D70199D40B6779824DE5392D9C9B0E8")
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
            {
                boolean var8492AE2C695A56B730381A28B8BA3F6D_881068350 = (iter.hasNext());
                {
                    Map.Entry<SQLiteClosable, Object> entry = iter.next();
                    SQLiteClosable program = entry.getKey();
                    {
                        SQLiteCompiledSql compiledSql = ((SQLiteProgram)program).mCompiledSql;
                        {
                            msg = compiledSql.toString();
                            found = true;
                        } //End block
                    } //End block
                } //End block
            } //End collapsed parenthetic
            {
                {
                    boolean var264DD9E27C37EF07E76F2B3412A8E5A6_208967011 = (mClosedStatementIds.contains(stmtId));
                    {
                        closePendingStatements();
                        closeDatabase();
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                if (DroidSafeAndroidRuntime.control) throw new SQLiteUnfinalizedObjectsException(
                        "close() on database: " + getPath() +
                        " failed due to un-close()d SQL statements: " + msg);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.441 -0400", hash_original_method = "4C27B28311EC4401B9E72044B34DEE3C", hash_generated_method = "4E905500CC20EB86329796A43360CF14")
    private void dbclose() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.441 -0400", hash_original_method = "6AE38120A6AE17DCB302700D83D76664", hash_generated_method = "FFCE5A8FBF3CD194390FAE4FF00DF2B5")
    public void addCustomFunction(String name, int numArgs, CustomFunction function) {
        verifyDbIsOpen();
        {
            int ref = native_addCustomFunction(name, numArgs, function);
            {
                mCustomFunctions.add(new Integer(ref));
            } //End block
            {
                if (DroidSafeAndroidRuntime.control) throw new SQLiteException("failed to add custom function " + name);
            } //End block
        } //End block
        addTaint(name.getTaint());
        addTaint(numArgs);
        addTaint(function.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.441 -0400", hash_original_method = "9C15AE424A91890D11F6682C678B396E", hash_generated_method = "9F922AD3D0AB8BC65534209E768E3C68")
    private void releaseCustomFunctions() {
        {
            {
                int i = 0;
                boolean var36D8B34DC42E2CA6FF5F9433DF425473_1059133958 = (i < mCustomFunctions.size());
                {
                    Integer function = mCustomFunctions.get(i);
                    native_releaseCustomFunction(function.intValue());
                } //End block
            } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.442 -0400", hash_original_method = "545ECF4B8C2C387E458104596CE82C8C", hash_generated_method = "FE7280F11F88ABA517530D801DB41592")
    private int native_addCustomFunction(String name, int numArgs, CustomFunction function) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1437891442 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1437891442;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.442 -0400", hash_original_method = "D641D8CC9687EF2DFB0D6D88DDBFEE42", hash_generated_method = "B4A109E17A2F0A083453807534F34E44")
    private void native_releaseCustomFunction(int function) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.443 -0400", hash_original_method = "8BA60C4A4A322F100A535BB125C59B40", hash_generated_method = "407CB0A3FE79B9B3C326E4291D0166E2")
    public int getVersion() {
        int var5ED7B897E4829D15D8A8C1ABA4EB6C66_381042800 = (((Long) DatabaseUtils.longForQuery(this, "PRAGMA user_version;", null)).intValue());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1878161252 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1878161252;
        // ---------- Original Method ----------
        //return ((Long) DatabaseUtils.longForQuery(this, "PRAGMA user_version;", null)).intValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.444 -0400", hash_original_method = "4E3C0E9170C91236F101F38522569C45", hash_generated_method = "1FD62A2E7FFFDA885EFD4A985E2FD892")
    public void setVersion(int version) {
        execSQL("PRAGMA user_version = " + version);
        addTaint(version);
        // ---------- Original Method ----------
        //execSQL("PRAGMA user_version = " + version);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.444 -0400", hash_original_method = "01DC63CC6FF3C1462DC7069F3072C18D", hash_generated_method = "9FE05C50724C2D0C1C629224653B3076")
    public long getMaximumSize() {
        long pageCount = DatabaseUtils.longForQuery(this, "PRAGMA max_page_count;", null);
        long varCE811D607639101FC1388FCB35FFCD9C_865017527 = (pageCount * getPageSize());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_508633584 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_508633584;
        // ---------- Original Method ----------
        //long pageCount = DatabaseUtils.longForQuery(this, "PRAGMA max_page_count;", null);
        //return pageCount * getPageSize();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.445 -0400", hash_original_method = "B09E5ED21834BC66E218E9635E49257B", hash_generated_method = "F2569F7E15797755BA72D3185109F899")
    public long setMaximumSize(long numBytes) {
        long pageSize = getPageSize();
        long numPages = numBytes / pageSize;
        long newPageCount = DatabaseUtils.longForQuery(this, "PRAGMA max_page_count = " + numPages,
                null);
        addTaint(numBytes);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1323432186 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1323432186;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.446 -0400", hash_original_method = "677D214086B645E86B85D4E2A88CD9F6", hash_generated_method = "C0AE2DFEECCDC27FA7561AD57ED4A2F0")
    public long getPageSize() {
        long varA97F1A3236E9434F0519DFDCD56746B7_130932475 = (DatabaseUtils.longForQuery(this, "PRAGMA page_size;", null));
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1891005808 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1891005808;
        // ---------- Original Method ----------
        //return DatabaseUtils.longForQuery(this, "PRAGMA page_size;", null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.446 -0400", hash_original_method = "CE3FCE5D2F41E0E2EF73A0D49E90DE3F", hash_generated_method = "B6CA2C6D1C695C71DA0AF503C2179A42")
    public void setPageSize(long numBytes) {
        execSQL("PRAGMA page_size = " + numBytes);
        addTaint(numBytes);
        // ---------- Original Method ----------
        //execSQL("PRAGMA page_size = " + numBytes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.447 -0400", hash_original_method = "0ECCFA53F5E6749CB5B25917802B1822", hash_generated_method = "7D598CB24626081E26CD306B8D21D0A6")
    @Deprecated
    public void markTableSyncable(String table, String deletedTable) {
        addTaint(table.getTaint());
        addTaint(deletedTable.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.447 -0400", hash_original_method = "9A70316D056BE2F7590F6370A4F13111", hash_generated_method = "25B704753C25F22FBA3DC3440ACC87A1")
    @Deprecated
    public void markTableSyncable(String table, String foreignKey, String updateTable) {
        addTaint(table.getTaint());
        addTaint(foreignKey.getTaint());
        addTaint(updateTable.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.448 -0400", hash_original_method = "C05C583B39FD005C236783082CBB4E55", hash_generated_method = "2D32F213B646A65E483AE662C17F0873")
    public SQLiteStatement compileStatement(String sql) throws SQLException {
        SQLiteStatement varB4EAC82CA7396A68D541C85D26508E83_655213099 = null; //Variable for return #1
        verifyDbIsOpen();
        varB4EAC82CA7396A68D541C85D26508E83_655213099 = new SQLiteStatement(this, sql, null);
        addTaint(sql.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_655213099.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_655213099;
        // ---------- Original Method ----------
        //verifyDbIsOpen();
        //return new SQLiteStatement(this, sql, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.448 -0400", hash_original_method = "5E1B6C3D7A97420E0A4D0244321FA1D0", hash_generated_method = "D7D64CFD983F78749A65D618B74C0E5B")
    public Cursor query(boolean distinct, String table, String[] columns,
            String selection, String[] selectionArgs, String groupBy,
            String having, String orderBy, String limit) {
        Cursor varB4EAC82CA7396A68D541C85D26508E83_1613939391 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1613939391 = queryWithFactory(null, distinct, table, columns, selection, selectionArgs,
                groupBy, having, orderBy, limit);
        addTaint(distinct);
        addTaint(table.getTaint());
        addTaint(columns[0].getTaint());
        addTaint(selection.getTaint());
        addTaint(selectionArgs[0].getTaint());
        addTaint(groupBy.getTaint());
        addTaint(having.getTaint());
        addTaint(orderBy.getTaint());
        addTaint(limit.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1613939391.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1613939391;
        // ---------- Original Method ----------
        //return queryWithFactory(null, distinct, table, columns, selection, selectionArgs,
                //groupBy, having, orderBy, limit);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.449 -0400", hash_original_method = "2EC2F985341F70A15977A4E5B8D54ACE", hash_generated_method = "38905A0BE68097692FFD343DA7EA725F")
    public Cursor queryWithFactory(CursorFactory cursorFactory,
            boolean distinct, String table, String[] columns,
            String selection, String[] selectionArgs, String groupBy,
            String having, String orderBy, String limit) {
        Cursor varB4EAC82CA7396A68D541C85D26508E83_74806993 = null; //Variable for return #1
        verifyDbIsOpen();
        String sql = SQLiteQueryBuilder.buildQueryString(
                distinct, table, columns, selection, groupBy, having, orderBy, limit);
        varB4EAC82CA7396A68D541C85D26508E83_74806993 = rawQueryWithFactory(
                cursorFactory, sql, selectionArgs, findEditTable(table));
        addTaint(cursorFactory.getTaint());
        addTaint(distinct);
        addTaint(table.getTaint());
        addTaint(columns[0].getTaint());
        addTaint(selection.getTaint());
        addTaint(selectionArgs[0].getTaint());
        addTaint(groupBy.getTaint());
        addTaint(having.getTaint());
        addTaint(orderBy.getTaint());
        addTaint(limit.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_74806993.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_74806993;
        // ---------- Original Method ----------
        //verifyDbIsOpen();
        //String sql = SQLiteQueryBuilder.buildQueryString(
                //distinct, table, columns, selection, groupBy, having, orderBy, limit);
        //return rawQueryWithFactory(
                //cursorFactory, sql, selectionArgs, findEditTable(table));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.450 -0400", hash_original_method = "823CC97B8BCC24B1EEF8A14CAC46F9D2", hash_generated_method = "1DFAD257BC10312DAF0CA6591F359FE3")
    public Cursor query(String table, String[] columns, String selection,
            String[] selectionArgs, String groupBy, String having,
            String orderBy) {
        Cursor varB4EAC82CA7396A68D541C85D26508E83_1550050885 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1550050885 = query(false, table, columns, selection, selectionArgs, groupBy,
                having, orderBy, null );
        addTaint(table.getTaint());
        addTaint(columns[0].getTaint());
        addTaint(selection.getTaint());
        addTaint(selectionArgs[0].getTaint());
        addTaint(groupBy.getTaint());
        addTaint(having.getTaint());
        addTaint(orderBy.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1550050885.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1550050885;
        // ---------- Original Method ----------
        //return query(false, table, columns, selection, selectionArgs, groupBy,
                //having, orderBy, null );
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.450 -0400", hash_original_method = "C821013CE8C43126ED02ADCC7264C8CF", hash_generated_method = "9F1106C6DB2352DA41382FC6B6353624")
    public Cursor query(String table, String[] columns, String selection,
            String[] selectionArgs, String groupBy, String having,
            String orderBy, String limit) {
        Cursor varB4EAC82CA7396A68D541C85D26508E83_1139663765 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1139663765 = query(false, table, columns, selection, selectionArgs, groupBy,
                having, orderBy, limit);
        addTaint(table.getTaint());
        addTaint(columns[0].getTaint());
        addTaint(selection.getTaint());
        addTaint(selectionArgs[0].getTaint());
        addTaint(groupBy.getTaint());
        addTaint(having.getTaint());
        addTaint(orderBy.getTaint());
        addTaint(limit.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1139663765.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1139663765;
        // ---------- Original Method ----------
        //return query(false, table, columns, selection, selectionArgs, groupBy,
                //having, orderBy, limit);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.451 -0400", hash_original_method = "76B8F97A589187A4837E14E72F2396A8", hash_generated_method = "8E1158323D7ADD4E825EF0BF4BCE87E2")
    public Cursor rawQuery(String sql, String[] selectionArgs) {
        Cursor varB4EAC82CA7396A68D541C85D26508E83_1029608493 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1029608493 = rawQueryWithFactory(null, sql, selectionArgs, null);
        addTaint(sql.getTaint());
        addTaint(selectionArgs[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1029608493.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1029608493;
        // ---------- Original Method ----------
        //return rawQueryWithFactory(null, sql, selectionArgs, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.452 -0400", hash_original_method = "42A0891F7A1C512D8BE3F37EFD1DF118", hash_generated_method = "FCA8A13A0AD1DB2E43CDFDC050A89004")
    public Cursor rawQueryWithFactory(
            CursorFactory cursorFactory, String sql, String[] selectionArgs,
            String editTable) {
        Cursor varB4EAC82CA7396A68D541C85D26508E83_1983990588 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_1983990588 = cursor;
        addTaint(cursorFactory.getTaint());
        addTaint(sql.getTaint());
        addTaint(selectionArgs[0].getTaint());
        addTaint(editTable.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1983990588.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1983990588;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.453 -0400", hash_original_method = "7C0142B65481E16DCFB76B6C0BD0AF64", hash_generated_method = "12D5CB296FC8447455447247321A4264")
    public long insert(String table, String nullColumnHack, ContentValues values) {
        try 
        {
            long varF52CAAA7AE26F4FA45ED0B3A37BD4379_989002542 = (insertWithOnConflict(table, nullColumnHack, values, CONFLICT_NONE));
        } //End block
        catch (SQLException e)
        { }
        addTaint(table.getTaint());
        addTaint(nullColumnHack.getTaint());
        addTaint(values.getTaint());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1525357512 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1525357512;
        // ---------- Original Method ----------
        //try {
            //return insertWithOnConflict(table, nullColumnHack, values, CONFLICT_NONE);
        //} catch (SQLException e) {
            //Log.e(TAG, "Error inserting " + values, e);
            //return -1;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.454 -0400", hash_original_method = "2F31CF2160A369C3FFDDD251C32C2819", hash_generated_method = "B3D3C5AFE65EBE58D979873FBDF4F253")
    public long insertOrThrow(String table, String nullColumnHack, ContentValues values) throws SQLException {
        long var22A9FB7F2C81F3272F2370661FA4E896_517606039 = (insertWithOnConflict(table, nullColumnHack, values, CONFLICT_NONE));
        addTaint(table.getTaint());
        addTaint(nullColumnHack.getTaint());
        addTaint(values.getTaint());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1426110391 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1426110391;
        // ---------- Original Method ----------
        //return insertWithOnConflict(table, nullColumnHack, values, CONFLICT_NONE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.454 -0400", hash_original_method = "4277B606CBD58106C26DEC9C427B6DC5", hash_generated_method = "77A83CF08E33B18F39169A6661D5E4A5")
    public long replace(String table, String nullColumnHack, ContentValues initialValues) {
        try 
        {
            long var0B6B818F8EACB8B15016A791818A7376_1803503503 = (insertWithOnConflict(table, nullColumnHack, initialValues,
                    CONFLICT_REPLACE));
        } //End block
        catch (SQLException e)
        { }
        addTaint(table.getTaint());
        addTaint(nullColumnHack.getTaint());
        addTaint(initialValues.getTaint());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1681613675 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1681613675;
        // ---------- Original Method ----------
        //try {
            //return insertWithOnConflict(table, nullColumnHack, initialValues,
                    //CONFLICT_REPLACE);
        //} catch (SQLException e) {
            //Log.e(TAG, "Error inserting " + initialValues, e);
            //return -1;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.456 -0400", hash_original_method = "006F0DF267AA18E88B2010DFB3E66CC0", hash_generated_method = "8BC2F4268EC1549CECE68BF7B339C045")
    public long replaceOrThrow(String table, String nullColumnHack,
            ContentValues initialValues) throws SQLException {
        long varDB0C7A87625C42614968DA8DC2DF448A_443619653 = (insertWithOnConflict(table, nullColumnHack, initialValues,
                CONFLICT_REPLACE));
        addTaint(table.getTaint());
        addTaint(nullColumnHack.getTaint());
        addTaint(initialValues.getTaint());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1229950476 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1229950476;
        // ---------- Original Method ----------
        //return insertWithOnConflict(table, nullColumnHack, initialValues,
                //CONFLICT_REPLACE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.470 -0400", hash_original_method = "4E696CAC31E62C2450813F66BA0D3688", hash_generated_method = "68698D9A365DD75B6AD0C7FE75609C1F")
    public long insertWithOnConflict(String table, String nullColumnHack,
            ContentValues initialValues, int conflictAlgorithm) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT");
        sql.append(CONFLICT_VALUES[conflictAlgorithm]);
        sql.append(" INTO ");
        sql.append(table);
        sql.append('(');
        Object[] bindArgs = null;
        int size;
        boolean varC4E695B9AF881ABFE2BBBDD7E96404B3_404006865 = ((initialValues != null && initialValues.size() > 0));
        size = initialValues.size();
        size = 0;
        {
            bindArgs = new Object[size];
            int i = 0;
            {
                Iterator<String> var7BDF90D9B8E9B13A02DACE54E7C220FA_792167427 = (initialValues.keySet()).iterator();
                var7BDF90D9B8E9B13A02DACE54E7C220FA_792167427.hasNext();
                String colName = var7BDF90D9B8E9B13A02DACE54E7C220FA_792167427.next();
                {
                    sql.append((i > 0) ? "," : "");
                    sql.append(colName);
                    bindArgs[i++] = initialValues.get(colName);
                } //End block
            } //End collapsed parenthetic
            sql.append(')');
            sql.append(" VALUES (");
            {
                i = 0;
                {
                    sql.append((i > 0) ? ",?" : "?");
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            sql.append(nullColumnHack + ") VALUES (NULL");
        } //End block
        sql.append(')');
        SQLiteStatement statement = new SQLiteStatement(this, sql.toString(), bindArgs);
        try 
        {
            long varF67BA8A1C61A250EDBDBDA7E8358FE23_145123560 = (statement.executeInsert());
        } //End block
        catch (SQLiteDatabaseCorruptException e)
        {
            onCorruption();
            if (DroidSafeAndroidRuntime.control) throw e;
        } //End block
        finally 
        {
            statement.close();
        } //End block
        addTaint(table.getTaint());
        addTaint(nullColumnHack.getTaint());
        addTaint(initialValues.getTaint());
        addTaint(conflictAlgorithm);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1219767381 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1219767381;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.471 -0400", hash_original_method = "D469CE4575675C51277223F3405EF96C", hash_generated_method = "2F23299DF4AD3A199825DCE1517CC64D")
    public int delete(String table, String whereClause, String[] whereArgs) {
        SQLiteStatement statement = new SQLiteStatement(this, "DELETE FROM " + table +
                (!TextUtils.isEmpty(whereClause) ? " WHERE " + whereClause : ""), whereArgs);//DSFIXME:  CODE0008: Nested ternary operator in expression
        try 
        {
            int varA87545DC17687AF507150C89477E60CF_1217550549 = (statement.executeUpdateDelete());
        } //End block
        catch (SQLiteDatabaseCorruptException e)
        {
            onCorruption();
            if (DroidSafeAndroidRuntime.control) throw e;
        } //End block
        finally 
        {
            statement.close();
        } //End block
        addTaint(table.getTaint());
        addTaint(whereClause.getTaint());
        addTaint(whereArgs[0].getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1757025311 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1757025311;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.471 -0400", hash_original_method = "1314F51B10A849824DA60B76F1896857", hash_generated_method = "5216179ED48ABE0CDFD006122002347B")
    public int update(String table, ContentValues values, String whereClause, String[] whereArgs) {
        int varFBFAC28FFEFC923D6AC3F8D0EB28BD4D_1490014270 = (updateWithOnConflict(table, values, whereClause, whereArgs, CONFLICT_NONE));
        addTaint(table.getTaint());
        addTaint(values.getTaint());
        addTaint(whereClause.getTaint());
        addTaint(whereArgs[0].getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1450100953 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1450100953;
        // ---------- Original Method ----------
        //return updateWithOnConflict(table, values, whereClause, whereArgs, CONFLICT_NONE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.486 -0400", hash_original_method = "42C896B54A7E0C71455DEE45B9C2EA0D", hash_generated_method = "7B49C787A402DD0C34B8723C9CF8A95C")
    public int updateWithOnConflict(String table, ContentValues values,
            String whereClause, String[] whereArgs, int conflictAlgorithm) {
        {
            boolean var7F872E5B929E1733A7225AB743560CA0_340333575 = (values == null || values.size() == 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Empty values");
            } //End block
        } //End collapsed parenthetic
        StringBuilder sql = new StringBuilder(120);
        sql.append("UPDATE ");
        sql.append(CONFLICT_VALUES[conflictAlgorithm]);
        sql.append(table);
        sql.append(" SET ");
        int setValuesSize = values.size();
        int bindArgsSize;
        bindArgsSize = setValuesSize;
        bindArgsSize = (setValuesSize + whereArgs.length);
        Object[] bindArgs = new Object[bindArgsSize];
        int i = 0;
        {
            Iterator<String> varB154976CB623862478E6AF7F69897F5A_1505216168 = (values.keySet()).iterator();
            varB154976CB623862478E6AF7F69897F5A_1505216168.hasNext();
            String colName = varB154976CB623862478E6AF7F69897F5A_1505216168.next();
            {
                sql.append((i > 0) ? "," : "");
                sql.append(colName);
                bindArgs[i++] = values.get(colName);
                sql.append("=?");
            } //End block
        } //End collapsed parenthetic
        {
            {
                i = setValuesSize;
                {
                    bindArgs[i] = whereArgs[i - setValuesSize];
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            boolean varC582A3B0C0625E2C5B62147799474972_1877654624 = (!TextUtils.isEmpty(whereClause));
            {
                sql.append(" WHERE ");
                sql.append(whereClause);
            } //End block
        } //End collapsed parenthetic
        SQLiteStatement statement = new SQLiteStatement(this, sql.toString(), bindArgs);
        try 
        {
            int varA87545DC17687AF507150C89477E60CF_746977821 = (statement.executeUpdateDelete());
        } //End block
        catch (SQLiteDatabaseCorruptException e)
        {
            onCorruption();
            if (DroidSafeAndroidRuntime.control) throw e;
        } //End block
        finally 
        {
            statement.close();
        } //End block
        addTaint(table.getTaint());
        addTaint(values.getTaint());
        addTaint(whereClause.getTaint());
        addTaint(whereArgs[0].getTaint());
        addTaint(conflictAlgorithm);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1359759621 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1359759621;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.486 -0400", hash_original_method = "25D536EB53093A036E9DAE961A0D97E6", hash_generated_method = "9B586D41E45846A9A998D177CAFA6E40")
    public void execSQL(String sql) throws SQLException {
        executeSql(sql, null);
        addTaint(sql.getTaint());
        // ---------- Original Method ----------
        //executeSql(sql, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.487 -0400", hash_original_method = "C75317BDB75C741C750B94F218C97882", hash_generated_method = "315BD309AF63747588A71E916A84905E")
    public void execSQL(String sql, Object[] bindArgs) throws SQLException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Empty bindArgs");
        } //End block
        executeSql(sql, bindArgs);
        addTaint(sql.getTaint());
        addTaint(bindArgs[0].getTaint());
        // ---------- Original Method ----------
        //if (bindArgs == null) {
            //throw new IllegalArgumentException("Empty bindArgs");
        //}
        //executeSql(sql, bindArgs);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.487 -0400", hash_original_method = "9265893CFBC7535112C5207F5F702C1B", hash_generated_method = "B81AB539CF57021C72F82AC324A73BAF")
    private int executeSql(String sql, Object[] bindArgs) throws SQLException {
        {
            boolean varE0925AF52400942DD3DAF202DD99E6E6_398419444 = (DatabaseUtils.getSqlStatementType(sql) == DatabaseUtils.STATEMENT_ATTACH);
            {
                disableWriteAheadLogging();
                mHasAttachedDbs = true;
            } //End block
        } //End collapsed parenthetic
        SQLiteStatement statement = new SQLiteStatement(this, sql, bindArgs);
        try 
        {
            int varA87545DC17687AF507150C89477E60CF_488816431 = (statement.executeUpdateDelete());
        } //End block
        catch (SQLiteDatabaseCorruptException e)
        {
            onCorruption();
            if (DroidSafeAndroidRuntime.control) throw e;
        } //End block
        finally 
        {
            statement.close();
        } //End block
        addTaint(sql.getTaint());
        addTaint(bindArgs[0].getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1178729473 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1178729473;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.488 -0400", hash_original_method = "2C203F91898576B00C917F0CD42A518A", hash_generated_method = "62959DE11D358842000A88B02AA49A60")
    @Override
    protected void finalize() throws Throwable {
        try 
        {
            {
                boolean var5A39A3129B438981221C0F68BD29C416_248619450 = (isOpen());
                {
                    closeClosable();
                    onAllReferencesReleased();
                    releaseCustomFunctions();
                } //End block
            } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.488 -0400", hash_original_method = "B8251338AB8EB8352A863E35E41B939B", hash_generated_method = "98FF2DEB614D5EEAB289A2CE988A5B45")
    public boolean isReadOnly() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_742102308 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_742102308;
        // ---------- Original Method ----------
        //return (mFlags & OPEN_READ_MASK) == OPEN_READONLY;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.489 -0400", hash_original_method = "61E254D128D08D9B7DD7C5EEB86B883E", hash_generated_method = "071FD7A0343B5D49FD1585C423242707")
    public boolean isOpen() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_86209981 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_86209981;
        // ---------- Original Method ----------
        //return mNativeHandle != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.489 -0400", hash_original_method = "4C8276EC0F604B529F31103A74E610FF", hash_generated_method = "FE4178F64597E9EADC0F42ABE6DA595E")
    public boolean needUpgrade(int newVersion) {
        boolean var11347AA24D61D50D87B1A9EDCAB47EB3_747515865 = (newVersion > getVersion());
        addTaint(newVersion);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_75602211 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_75602211;
        // ---------- Original Method ----------
        //return newVersion > getVersion();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.490 -0400", hash_original_method = "F177C5B02553C0E0327F321BDDCEAFD5", hash_generated_method = "48A5EDD9A3F94E1C059B90C0B6C9ECCF")
    public final String getPath() {
        String varB4EAC82CA7396A68D541C85D26508E83_1670074815 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1670074815 = mPath;
        varB4EAC82CA7396A68D541C85D26508E83_1670074815.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1670074815;
        // ---------- Original Method ----------
        //return mPath;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.491 -0400", hash_original_method = "0D21C1E893B83D945127726B58A78BA2", hash_generated_method = "4B130485673C539EFAFBA63CBB5AD9C0")
     void logTimeStat(String sql, long beginMillis) {
        {
            logTimeStat(sql, beginMillis, null);
        } //End block
        addTaint(sql.getTaint());
        addTaint(beginMillis);
        // ---------- Original Method ----------
        //if (ENABLE_DB_SAMPLE) {
            //logTimeStat(sql, beginMillis, null);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.492 -0400", hash_original_method = "8ED8142AF940938322CF345006300B7D", hash_generated_method = "EF9F54CE7485A0D2615BB4E358F8DDB4")
    private void logTimeStat(String sql, long beginMillis, String prefix) {
        int samplePercent;
        long durationMillis = SystemClock.uptimeMillis() - beginMillis;
        {
            sQueryLogTimeInMillis = SystemProperties.getInt("db.db_operation.threshold_ms", 500);
        } //End block
        {
            samplePercent = 100;
        } //End block
        {
            samplePercent = (int) (100 * durationMillis / sQueryLogTimeInMillis) + 1;
            {
                boolean varFD197FF6228B8320A1307AF1741CB740_1247343459 = (mRandom.nextInt(100) >= samplePercent);
            } //End collapsed parenthetic
        } //End block
        {
            sql = prefix + sql;
        } //End block
        {
            boolean var15761F9B8A55BA7056472F2EB9923186_820303466 = (sql.length() > QUERY_LOG_SQL_LENGTH);
            sql = sql.substring(0, QUERY_LOG_SQL_LENGTH);
        } //End collapsed parenthetic
        String blockingPackage = AppGlobals.getInitialPackage();
        blockingPackage = "";
        EventLog.writeEvent(
            EVENT_DB_OPERATION,
            getPathForLogs(),
            sql,
            durationMillis,
            blockingPackage,
            samplePercent);
        addTaint(sql.getTaint());
        addTaint(beginMillis);
        addTaint(prefix.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.494 -0400", hash_original_method = "BAC313652C0D08E8CD159DBA09E31731", hash_generated_method = "AF5EA5A81909B259C128E26E1EBDE8A2")
    private String getPathForLogs() {
        String varB4EAC82CA7396A68D541C85D26508E83_1080462494 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1425312583 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_561510962 = null; //Variable for return #3
        {
            varB4EAC82CA7396A68D541C85D26508E83_1080462494 = mPathForLogs;
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1425312583 = null;
        } //End block
        {
            boolean var9CB372F979D264EF8BD68817AF56AFA9_528950229 = (mPath.indexOf('@') == -1);
            {
                mPathForLogs = mPath;
            } //End block
            {
                mPathForLogs = EMAIL_IN_DB_PATTERN.matcher(mPath).replaceAll("XX@YY");
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_561510962 = mPathForLogs;
        String varA7E53CE21691AB073D9660D615818899_473863878; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_473863878 = varB4EAC82CA7396A68D541C85D26508E83_1080462494;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_473863878 = varB4EAC82CA7396A68D541C85D26508E83_1425312583;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_473863878 = varB4EAC82CA7396A68D541C85D26508E83_561510962;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_473863878.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_473863878;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.494 -0400", hash_original_method = "3FAFCE8DADACDA6029D741D00EA768C4", hash_generated_method = "EF56BF84E45E0DEBE5B7ED4895187EFE")
    public void setLocale(Locale locale) {
        lock();
        try 
        {
            native_setLocale(locale.toString(), mFlags);
        } //End block
        finally 
        {
            unlock();
        } //End block
        addTaint(locale.getTaint());
        // ---------- Original Method ----------
        //lock();
        //try {
            //native_setLocale(locale.toString(), mFlags);
        //} finally {
            //unlock();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.495 -0400", hash_original_method = "82F89F6027C136BD18FB9173DDA585C3", hash_generated_method = "64E82B6E67EC99FAAD4CDA2B3B00E2B5")
     void verifyDbIsOpen() {
        {
            boolean var3A7D61B68AE823F6A30349D498C59A5C_1967050595 = (!isOpen());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("database " + getPath() + " (conn# " +
                    mConnectionNum + ") already closed");
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (!isOpen()) {
            //throw new IllegalStateException("database " + getPath() + " (conn# " +
                    //mConnectionNum + ") already closed");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.495 -0400", hash_original_method = "2ABE5777D3030A58042EA8C11F6A64FB", hash_generated_method = "3D0DA043C3F4E9AD92663BACBEF45735")
     void verifyLockOwner() {
        verifyDbIsOpen();
        {
            boolean var165EEFEEA133626155A410875EC632D2_1412227413 = (mLockingEnabled && !isDbLockedByCurrentThread());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Don't have database lock!");
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //verifyDbIsOpen();
        //if (mLockingEnabled && !isDbLockedByCurrentThread()) {
            //throw new IllegalStateException("Don't have database lock!");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.508 -0400", hash_original_method = "1F50605826534D1D8A189D3DC15DE94F", hash_generated_method = "6B2E2362BEC4E6BE351ABA8887883949")
    synchronized void addToCompiledQueries(
            String sql, SQLiteCompiledSql compiledStatement) {
        {
            boolean var44AC47AE1DA995B439F70F98684BE351_181320307 = (mCompiledQueries.get(sql) != null);
        } //End collapsed parenthetic
        int maxCacheSz;
        maxCacheSz = mCompiledQueries.maxSize();
        maxCacheSz = mParentConnObj.mCompiledQueries.maxSize();
        {
            boolean printWarning;
            printWarning = (!mCacheFullWarning && mCompiledQueries.size() == maxCacheSz);
            printWarning = (!mParentConnObj.mCacheFullWarning &&
                    mParentConnObj.mCompiledQueries.size() == maxCacheSz);
            {
                mCacheFullWarning = true;
                Log.d(TAG, "Here are the SQL statements in Cache of database: " + mPath);
                {
                    Iterator<String> var42DDB4F3462F514FC2F124A94345BBD5_741689516 = (mCompiledQueries.snapshot().keySet()).iterator();
                    var42DDB4F3462F514FC2F124A94345BBD5_741689516.hasNext();
                    String s = var42DDB4F3462F514FC2F124A94345BBD5_741689516.next();
                    {
                        Log.d(TAG, "Sql statement in Cache: " + s);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        mCompiledQueries.put(sql, compiledStatement);
        addTaint(sql.getTaint());
        addTaint(compiledStatement.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.515 -0400", hash_original_method = "CE0C87ACDC099813F3D6D588DE2B56CF", hash_generated_method = "ED36600B8634A237E090853873727ADC")
    synchronized void deallocCachedSqlStatements() {
        {
            Iterator<SQLiteCompiledSql> var84DFBFDB238B53D2223BB28209C480FC_1185104536 = (mCompiledQueries.snapshot().values()).iterator();
            var84DFBFDB238B53D2223BB28209C480FC_1185104536.hasNext();
            SQLiteCompiledSql compiledSql = var84DFBFDB238B53D2223BB28209C480FC_1185104536.next();
            {
                compiledSql.releaseSqlStatement();
            } //End block
        } //End collapsed parenthetic
        mCompiledQueries.evictAll();
        // ---------- Original Method ----------
        //for (SQLiteCompiledSql compiledSql : mCompiledQueries.snapshot().values()) {
            //compiledSql.releaseSqlStatement();
        //}
        //mCompiledQueries.evictAll();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.516 -0400", hash_original_method = "A3F9326C17119FEC2A90D0724FE482CF", hash_generated_method = "D86495735B86301D220E89A75E313AE6")
    synchronized SQLiteCompiledSql getCompiledStatementForSql(String sql) {
        SQLiteCompiledSql varB4EAC82CA7396A68D541C85D26508E83_198297740 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_198297740 = mCompiledQueries.get(sql);
        addTaint(sql.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_198297740.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_198297740;
        // ---------- Original Method ----------
        //return mCompiledQueries.get(sql);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.533 -0400", hash_original_method = "986DCF2E02788969CC84FF6D84C81E71", hash_generated_method = "87CE5E550EB72479FFB99C65C0225080")
    public void setMaxSqlCacheSize(int cacheSize) {
        {
            LruCache<String, SQLiteCompiledSql> oldCompiledQueries = mCompiledQueries;
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(
                        "expected value between 0 and " + MAX_SQL_CACHE_SIZE);
            } //End block
            {
                boolean var551279D6CBA810FBA7717E31CAA6F559_1880014619 = (oldCompiledQueries != null && cacheSize < oldCompiledQueries.maxSize());
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("cannot set cacheSize to a value less than the "
                        + "value set with previous setMaxSqlCacheSize() call.");
                } //End block
            } //End collapsed parenthetic
            mCompiledQueries = new LruCache<String, SQLiteCompiledSql>(cacheSize) {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.517 -0400", hash_original_method = "0287FECCFAEBE5DF6977A7998D9D230B", hash_generated_method = "5D0B8AAE039B3F73DB3A0243FDD1B3BF")
                @Override
                protected void entryRemoved(boolean evicted, String key, SQLiteCompiledSql oldValue,
                        SQLiteCompiledSql newValue) {
                    verifyLockOwner();
                    oldValue.releaseIfNotInUse();
                    addTaint(evicted);
                    addTaint(key.getTaint());
                    addTaint(oldValue.getTaint());
                    addTaint(newValue.getTaint());
                    // ---------- Original Method ----------
                    //verifyLockOwner();
                    //oldValue.releaseIfNotInUse();
                }
};
            {
                {
                    Iterator<Map.Entry<String, SQLiteCompiledSql>> varA959B61746A0B8CD10E93A362DE7BDD9_863600215 = (oldCompiledQueries.snapshot().entrySet()).iterator();
                    varA959B61746A0B8CD10E93A362DE7BDD9_863600215.hasNext();
                    Map.Entry<String, SQLiteCompiledSql> entry = varA959B61746A0B8CD10E93A362DE7BDD9_863600215.next();
                    {
                        mCompiledQueries.put(entry.getKey(), entry.getValue());
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.533 -0400", hash_original_method = "4517A8954B6715406427A020C27CB67E", hash_generated_method = "5DAC025A261F9D4AA0E0FD8B2DFFEFD4")
    synchronized boolean isInStatementCache(String sql) {
        boolean var7E2D49726EEA56C7F241D41A55356BE7_256203395 = (mCompiledQueries.get(sql) != null);
        addTaint(sql.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_237802569 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_237802569;
        // ---------- Original Method ----------
        //return mCompiledQueries.get(sql) != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.534 -0400", hash_original_method = "1314F31979BFAD21CD00C204B07606A6", hash_generated_method = "13663239F7EB4E76DAD6322B9EF69765")
    synchronized void releaseCompiledSqlObj(
            String sql, SQLiteCompiledSql compiledSql) {
        {
            boolean var8E99D7E5C4B5DCBB0D60FA02E8F69444_1765911137 = (mCompiledQueries.get(sql) == compiledSql);
            {
                compiledSql.release();
            } //End block
            {
                compiledSql.releaseSqlStatement();
            } //End block
        } //End collapsed parenthetic
        addTaint(sql.getTaint());
        addTaint(compiledSql.getTaint());
        // ---------- Original Method ----------
        //if (mCompiledQueries.get(sql) == compiledSql) {
            //compiledSql.release();
        //} else {
            //compiledSql.releaseSqlStatement();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.534 -0400", hash_original_method = "8B250436E1E22A5062E1C40EC7B14D91", hash_generated_method = "9C1EB3B63C5F5AD105C6C1BAB6A902B0")
    private synchronized int getCacheHitNum() {
        int var83B3BA20F9BFC7EB0E1E1591ACDA465E_94974629 = (mCompiledQueries.hitCount());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_889595903 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_889595903;
        // ---------- Original Method ----------
        //return mCompiledQueries.hitCount();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.535 -0400", hash_original_method = "043FFEAEE6F40014DEE09BB2B945E7E0", hash_generated_method = "3C5074D8FAF5CA47F3472D88A4079F42")
    private synchronized int getCacheMissNum() {
        int varC17CF02ACE8A376983C1F44782AFB555_252235728 = (mCompiledQueries.missCount());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1306605809 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1306605809;
        // ---------- Original Method ----------
        //return mCompiledQueries.missCount();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.535 -0400", hash_original_method = "BE154D77F9855AEAD67382AAA286976D", hash_generated_method = "6F5003B9FDF489AE0788C2E83A271E93")
    private synchronized int getCachesize() {
        int var748F027D3AA39F0931CAA3B5AACCC414_1653008832 = (mCompiledQueries.size());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_861721094 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_861721094;
        // ---------- Original Method ----------
        //return mCompiledQueries.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.536 -0400", hash_original_method = "5A385C2ADA8821372998CC92DEC1F051", hash_generated_method = "E19CABF57FF4C3495C34325781441160")
     void finalizeStatementLater(int id) {
        {
            boolean var3A7D61B68AE823F6A30349D498C59A5C_1977045744 = (!isOpen());
        } //End collapsed parenthetic
        {
            {
                boolean var6EF4CC3269BBE912A7980A125C3F1053_752935131 = (mClosedStatementIds.contains(id));
            } //End collapsed parenthetic
            mClosedStatementIds.add(id);
        } //End block
        addTaint(id);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.537 -0400", hash_original_method = "155C9044FA9A1FA1A4DC8EF486B34E28", hash_generated_method = "258B3A5DDBF151A0EB2812B454C3488E")
     boolean isInQueueOfStatementsToBeFinalized(int id) {
        {
            boolean var3A7D61B68AE823F6A30349D498C59A5C_185694268 = (!isOpen());
        } //End collapsed parenthetic
        {
            boolean var397B91F8D3CC72A0D7DEC2797A4D7920_655959119 = (mClosedStatementIds.contains(id));
        } //End block
        addTaint(id);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1314215363 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1314215363;
        // ---------- Original Method ----------
        //if (!isOpen()) {
            //return true;
        //}
        //synchronized(mClosedStatementIds) {
            //return mClosedStatementIds.contains(id);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.538 -0400", hash_original_method = "D5552224B16C0AA0A430699F6F165E27", hash_generated_method = "7D48DAB756FCF7A84D74AB8A7AB97D40")
     void closePendingStatements() {
        {
            boolean var3A7D61B68AE823F6A30349D498C59A5C_1073103599 = (!isOpen());
            {
                mClosedStatementIds.clear();
            } //End block
        } //End collapsed parenthetic
        verifyLockOwner();
        ArrayList<Integer> list = new ArrayList<Integer>(mClosedStatementIds.size());
        {
            list.addAll(mClosedStatementIds);
            mClosedStatementIds.clear();
        } //End block
        int size = list.size();
        {
            int i = 0;
            {
                native_finalize(list.get(i));
            } //End block
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.539 -0400", hash_original_method = "22B8BC0E5EAC4A96A93EF5FA02A6A3E4", hash_generated_method = "C3810FBECF4F441B94A95BFDED4753D4")
     ArrayList<Integer> getQueuedUpStmtList() {
        ArrayList<Integer> varB4EAC82CA7396A68D541C85D26508E83_1579811099 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1579811099 = mClosedStatementIds;
        varB4EAC82CA7396A68D541C85D26508E83_1579811099.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1579811099;
        // ---------- Original Method ----------
        //return mClosedStatementIds;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.539 -0400", hash_original_method = "D499CBE556FD537E95FAF5696995EFF8", hash_generated_method = "8B7378E0BC5D198649DF3C64261B6FB4")
    public boolean enableWriteAheadLogging() {
        {
            boolean varAC4B8D6BC6438967D655421106AB549D_92311710 = (isReadOnly());
        } //End collapsed parenthetic
        lock();
        try 
        {
            {
                boolean varABBFB9ECCBC8DDD21300FC28D5111825_1110605642 = (mPath.equalsIgnoreCase(MEMORY_DB_PATH));
            } //End collapsed parenthetic
            {
                {
                    boolean var4202D0C449E97752DAE596DFB30FD8C9_1840121489 = (Log.isLoggable(TAG, Log.DEBUG));
                    {
                        Log.d(TAG,
                            "this database: " + mPath + " has attached databases. can't  enable WAL.");
                    } //End block
                } //End collapsed parenthetic
            } //End block
            mConnectionPool = new DatabaseConnectionPool(this);
            setJournalMode(mPath, "WAL");
        } //End block
        finally 
        {
            unlock();
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1093474129 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1093474129;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.540 -0400", hash_original_method = "85CDE9F0FF49E9AFE9EC3200C3C50766", hash_generated_method = "70E63D6A2D912EF1266464B719F40617")
    public void disableWriteAheadLogging() {
        lock();
        try 
        {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.541 -0400", hash_original_method = "E2BFDDA904D316A8C889FACE46B854F6", hash_generated_method = "4175A8511419FAC845E6162F0B92F443")
     SQLiteDatabase getDatabaseHandle(String sql) {
        SQLiteDatabase varB4EAC82CA7396A68D541C85D26508E83_1699849064 = null; //Variable for return #1
        SQLiteDatabase varB4EAC82CA7396A68D541C85D26508E83_1066412736 = null; //Variable for return #2
        SQLiteDatabase varB4EAC82CA7396A68D541C85D26508E83_1417508175 = null; //Variable for return #3
        {
            boolean varFECD86923E904CB3E1FAA0A6D1F256B6_1571155938 = (isPooledConnection());
            {
                {
                    boolean var66D7314A9B0C021F5A00D49AE7D90291_1031293583 = (isOpen() && !amIInTransaction());
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1699849064 = this;
                    } //End block
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1066412736 = getParentDbConnObj().getDbConnection(sql);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_1417508175 = getDbConnection(sql);
            } //End block
        } //End collapsed parenthetic
        addTaint(sql.getTaint());
        SQLiteDatabase varA7E53CE21691AB073D9660D615818899_570053006; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_570053006 = varB4EAC82CA7396A68D541C85D26508E83_1699849064;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_570053006 = varB4EAC82CA7396A68D541C85D26508E83_1066412736;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_570053006 = varB4EAC82CA7396A68D541C85D26508E83_1417508175;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_570053006.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_570053006;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.542 -0400", hash_original_method = "3237D800F466D0C40C278AA082141CB7", hash_generated_method = "63AA6728B831F47CCB8E0722F568D540")
     SQLiteDatabase createPoolConnection(short connectionNum) {
        SQLiteDatabase varB4EAC82CA7396A68D541C85D26508E83_911562485 = null; //Variable for return #1
        SQLiteDatabase db = openDatabase(mPath, mFactory, mFlags, mErrorHandler, connectionNum);
        db.mParentConnObj = this;
        varB4EAC82CA7396A68D541C85D26508E83_911562485 = db;
        addTaint(connectionNum);
        varB4EAC82CA7396A68D541C85D26508E83_911562485.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_911562485;
        // ---------- Original Method ----------
        //SQLiteDatabase db = openDatabase(mPath, mFactory, mFlags, mErrorHandler, connectionNum);
        //db.mParentConnObj = this;
        //return db;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.542 -0400", hash_original_method = "205546EE310EB84028F43CE65A7EC94C", hash_generated_method = "CBF629AC348F0A296336C1451DCD2B5B")
    private synchronized SQLiteDatabase getParentDbConnObj() {
        SQLiteDatabase varB4EAC82CA7396A68D541C85D26508E83_2114075906 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2114075906 = mParentConnObj;
        varB4EAC82CA7396A68D541C85D26508E83_2114075906.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2114075906;
        // ---------- Original Method ----------
        //return mParentConnObj;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.543 -0400", hash_original_method = "D4EECEC449FC4C156499058FCB2B2B85", hash_generated_method = "DD2937130A5FEB786DEBF45F7413B16A")
    private boolean isPooledConnection() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_483071712 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_483071712;
        // ---------- Original Method ----------
        //return this.mConnectionNum > 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.544 -0400", hash_original_method = "B485A553653CD27E64DDB9F45483F96A", hash_generated_method = "9AB7AE44E93AAE3C805E3BFCB09CE4C2")
     SQLiteDatabase getDbConnection(String sql) {
        SQLiteDatabase varB4EAC82CA7396A68D541C85D26508E83_1148603026 = null; //Variable for return #1
        SQLiteDatabase varB4EAC82CA7396A68D541C85D26508E83_952791140 = null; //Variable for return #2
        SQLiteDatabase varB4EAC82CA7396A68D541C85D26508E83_1225157633 = null; //Variable for return #3
        verifyDbIsOpen();
        {
            boolean varFECD86923E904CB3E1FAA0A6D1F256B6_1743848173 = (isPooledConnection());
            {
                varB4EAC82CA7396A68D541C85D26508E83_1148603026 = this;
            } //End block
        } //End collapsed parenthetic
        {
            boolean var02B777F5DE6966D0CEC634290EE91DB0_1462435962 = (amIInTransaction() || mConnectionPool == null);
            {
                varB4EAC82CA7396A68D541C85D26508E83_952791140 = this;
            } //End block
            {
                {
                    boolean var4202D0C449E97752DAE596DFB30FD8C9_877853052 = (Log.isLoggable(TAG, Log.DEBUG));
                } //End collapsed parenthetic
                varB4EAC82CA7396A68D541C85D26508E83_1225157633 = mConnectionPool.get(sql);
            } //End block
        } //End collapsed parenthetic
        addTaint(sql.getTaint());
        SQLiteDatabase varA7E53CE21691AB073D9660D615818899_1579919393; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1579919393 = varB4EAC82CA7396A68D541C85D26508E83_1148603026;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1579919393 = varB4EAC82CA7396A68D541C85D26508E83_952791140;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1579919393 = varB4EAC82CA7396A68D541C85D26508E83_1225157633;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1579919393.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1579919393;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.544 -0400", hash_original_method = "2B099A526E7EBE8C0C20DFBE797D578C", hash_generated_method = "93FD8B99724300D97097010E9D039180")
    private void releaseDbConnection(SQLiteDatabase db) {
        {
            boolean var2C78F6FD17175C7FB817368E27CF14DF_1373559899 = (!isOpen() || !db.isPooledConnection() || (db == this));
        } //End collapsed parenthetic
        {
            boolean var7061DF8A5335B809C796044C2A062407_1126186424 = (Log.isLoggable(TAG, Log.DEBUG));
            {
                Log.d(TAG, "releaseDbConnection threadid = " + Thread.currentThread().getId() +
                    ", releasing # " + db.mConnectionNum + ", " + getPath());
            } //End block
        } //End collapsed parenthetic
        mConnectionPool.release(db);
        addTaint(db.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.546 -0400", hash_original_method = "40C4DE1C4808AAF54B97D30ED440E3DF", hash_generated_method = "F92DF1FF087BC8C4D1F0EDE9296AFDFB")
    public List<Pair<String, String>> getAttachedDbs() {
        List<Pair<String, String>> varB4EAC82CA7396A68D541C85D26508E83_1964783634 = null; //Variable for return #1
        List<Pair<String, String>> varB4EAC82CA7396A68D541C85D26508E83_761314639 = null; //Variable for return #2
        List<Pair<String, String>> varB4EAC82CA7396A68D541C85D26508E83_2093362758 = null; //Variable for return #3
        {
            boolean var3A7D61B68AE823F6A30349D498C59A5C_428733721 = (!isOpen());
            {
                varB4EAC82CA7396A68D541C85D26508E83_1964783634 = null;
            } //End block
        } //End collapsed parenthetic
        ArrayList<Pair<String, String>> attachedDbs = new ArrayList<Pair<String, String>>();
        {
            attachedDbs.add(new Pair<String, String>("main", mPath));
            varB4EAC82CA7396A68D541C85D26508E83_761314639 = attachedDbs;
        } //End block
        Cursor c = null;
        try 
        {
            c = rawQuery("pragma database_list;", null);
            {
                boolean var4D86B3BFFD03EEDEB3FCD4358BA0EB15_1108632338 = (c.moveToNext());
                {
                    attachedDbs.add(new Pair<String, String>(c.getString(1), c.getString(2)));
                } //End block
            } //End collapsed parenthetic
        } //End block
        finally 
        {
            {
                c.close();
            } //End block
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_2093362758 = attachedDbs;
        List<Pair<String, String>> varA7E53CE21691AB073D9660D615818899_1541953432; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1541953432 = varB4EAC82CA7396A68D541C85D26508E83_1964783634;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1541953432 = varB4EAC82CA7396A68D541C85D26508E83_761314639;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1541953432 = varB4EAC82CA7396A68D541C85D26508E83_2093362758;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1541953432.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1541953432;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.548 -0400", hash_original_method = "F327316761A478EA142E408A35654FE2", hash_generated_method = "B09B48AC1B7A66F75461CD70157ACCD5")
    public boolean isDatabaseIntegrityOk() {
        verifyDbIsOpen();
        List<Pair<String, String>> attachedDbs = null;
        try 
        {
            attachedDbs = getAttachedDbs();
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("databaselist for: " + getPath() + " couldn't " +
                        "be retrieved. probably because the database is closed");
            } //End block
        } //End block
        catch (SQLiteException e)
        {
            attachedDbs = new ArrayList<Pair<String, String>>();
            attachedDbs.add(new Pair<String, String>("main", this.mPath));
        } //End block
        {
            int i = 0;
            boolean var09C6965D75337EEF5127BC42D107026B_551979746 = (i < attachedDbs.size());
            {
                Pair<String, String> p = attachedDbs.get(i);
                SQLiteStatement prog = null;
                try 
                {
                    prog = compileStatement("PRAGMA " + p.first + ".integrity_check(1);");
                    String rslt = prog.simpleQueryForString();
                    {
                        boolean var00AD2367BACBE21804BEE535AC3728B3_1258485371 = (!rslt.equalsIgnoreCase("ok"));
                    } //End collapsed parenthetic
                } //End block
                finally 
                {
                    prog.close();
                } //End block
            } //End block
        } //End collapsed parenthetic
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_727591202 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_727591202;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.550 -0400", hash_original_method = "8D335FE0EDA9A8017E889380A7A722CF", hash_generated_method = "7DC2BD660B2CDC6483080370E51D7A42")
    private void dbopen(String path, int flags) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.551 -0400", hash_original_method = "70E20853624884484C3836EF6F149A55", hash_generated_method = "079E6181584D18FF7794E2CCCC7EC698")
    private void enableSqlTracing(String path, short connectionNum) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.551 -0400", hash_original_method = "C8A96013E7D0E582573D33F32AE9CEB2", hash_generated_method = "8E4CC6A847CB4D4A755E1D378C2FD667")
    private void enableSqlProfiling(String path, short connectionNum) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.552 -0400", hash_original_method = "D6178DAC9B84DE9466B1B633DF097ED8", hash_generated_method = "4E544159901989F8659751014F855197")
    private void native_setLocale(String loc, int flags) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.552 -0400", hash_original_method = "94C6AE32C9A996CB80A0C1FADFD7D1F2", hash_generated_method = "422B86C0137CE0C497477ABB7E2C6D35")
    private int native_getDbLookaside() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2097976935 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2097976935;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.553 -0400", hash_original_method = "C4F8F8FDF64373EAEBE82B2B8F80D5C0", hash_generated_method = "E6AC894F82F9E2B742C2DEB8A39D8080")
    private final void native_finalize(int statementId) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.553 -0400", hash_original_method = "324F9A57AA3484DEBE48152EFBF728CA", hash_generated_method = "0CEE753090AC8DD2CCDAA7F7430628D4")
    private void native_setSqliteSoftHeapLimit(int softHeapLimit) {
    }

    
    private static class DatabaseReentrantLock extends ReentrantLock {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.553 -0400", hash_original_method = "FF2E769A330F113FDEF775F7B9F0F4EF", hash_generated_method = "31CB5E32D763205F06BFE445BA191A42")
          DatabaseReentrantLock(boolean fair) {
            super(fair);
            addTaint(fair);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.554 -0400", hash_original_method = "1BB82FD0B3090B035906C5C5A5300D7F", hash_generated_method = "662E4EF28132CCA68D8E420D4967368E")
        @Override
        public Thread getOwner() {
            Thread varB4EAC82CA7396A68D541C85D26508E83_1645605875 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1645605875 = super.getOwner();
            varB4EAC82CA7396A68D541C85D26508E83_1645605875.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1645605875;
            // ---------- Original Method ----------
            //return super.getOwner();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.555 -0400", hash_original_method = "0A30C3A8A16B3E36E180D94391681301", hash_generated_method = "3047A6F7D8457F5B1DE9FCF27CFB251B")
        public String getOwnerDescription() {
            String varB4EAC82CA7396A68D541C85D26508E83_939158736 = null; //Variable for return #1
            Thread t = getOwner();
            varB4EAC82CA7396A68D541C85D26508E83_939158736 = (t== null) ? "none" : String.valueOf(t.getId());
            varB4EAC82CA7396A68D541C85D26508E83_939158736.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_939158736;
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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.555 -0400", hash_original_field = "D18B04353DB06786DFA19F38E1E3F9F8", hash_generated_field = "B031AA443BF0B15D9BA58FE3D3C788E6")

    private static final String TAG = "SQLiteDatabase";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.555 -0400", hash_original_field = "505A38A2470AB971646D45095C12E31F", hash_generated_field = "3548346B1EB3CE378E747DF13DAF2E94")

    private static final boolean ENABLE_DB_SAMPLE = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.555 -0400", hash_original_field = "4747FA61A14E68F397B403C3BF573138", hash_generated_field = "7C746BEBD1F52CCE281BC2AE78043C31")

    private static final int EVENT_DB_OPERATION = 52000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.555 -0400", hash_original_field = "FA2DCB40C8C2E6B3E9DC95D493219399", hash_generated_field = "9435052DF2978607705FE1A674B3B476")

    private static final int EVENT_DB_CORRUPT = 75004;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.555 -0400", hash_original_field = "790D60FA6E696D93692BA35CB0438294", hash_generated_field = "AB29804A115D818B6ACC16F36A2A6B4A")

    public static final int CONFLICT_ROLLBACK = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.555 -0400", hash_original_field = "8FF68E568D06942129BAB7786008CC27", hash_generated_field = "39B42E823E1997DA6D833E1BBD40FA58")

    public static final int CONFLICT_ABORT = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.555 -0400", hash_original_field = "117A84E9B3C20F8BD0A9D3FA05866829", hash_generated_field = "335E697F888616CE067B72F214C1BC32")

    public static final int CONFLICT_FAIL = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.555 -0400", hash_original_field = "3965F8F98E49E75266581A5EDCF28288", hash_generated_field = "46745826C06802839FCD46D51B439306")

    public static final int CONFLICT_IGNORE = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.555 -0400", hash_original_field = "63D7302A74CC755B81E5DA5FF2200F4B", hash_generated_field = "E863D6302F78EAED37A44DA0ED539003")

    public static final int CONFLICT_REPLACE = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.555 -0400", hash_original_field = "4A361B4F834FE1F0F6BB46551B141B34", hash_generated_field = "8969586D204DC9CDF495FFB0724623A9")

    public static final int CONFLICT_NONE = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.556 -0400", hash_original_field = "58CEAD30C6D151BCF416BDDB99D29495", hash_generated_field = "CEB6E56BB51D4EFBAE585B39DC049839")

    private static final String[] CONFLICT_VALUES = new String[]
            {"", " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE "};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.556 -0400", hash_original_field = "1E5817575F0E997F1243F638D5895D4E", hash_generated_field = "307B7E85D5D9B51588F8134872D28FA2")

    public static final int SQLITE_MAX_LIKE_PATTERN_LENGTH = 50000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.556 -0400", hash_original_field = "C6DEAE97C40012AF75B50C3B2999BB0A", hash_generated_field = "629E71001BC03CF7522CF9DF396F3CD0")

    public static final int OPEN_READWRITE = 0x00000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.556 -0400", hash_original_field = "902213259DEC7410D30EF3DFF53CABCB", hash_generated_field = "4E1D616F2DC9D0F7F19E42689377DE9D")

    public static final int OPEN_READONLY = 0x00000001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.556 -0400", hash_original_field = "3CE8162CF9656F8FCB8B5B90A59AD3ED", hash_generated_field = "5187312D154815C7B5E63606C7E8136A")

    private static final int OPEN_READ_MASK = 0x00000001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.556 -0400", hash_original_field = "09B9A0E2C049E747CB9560AF8560A1C4", hash_generated_field = "099AB38E222487A3F22F8D84E49C790B")

    public static final int NO_LOCALIZED_COLLATORS = 0x00000010;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.556 -0400", hash_original_field = "5D9E28D3CB398796FE04F7E00299B712", hash_generated_field = "51E7E16B8C63BFDCCFDDEE94FF22F7BB")

    public static final int CREATE_IF_NECESSARY = 0x10000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.556 -0400", hash_original_field = "963E0DAA128D9868E6CC8434473DB4B9", hash_generated_field = "2D7B5C77835222796D1E38850A1796FA")

    private static final int LOCK_WARNING_WINDOW_IN_MS = 20000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.556 -0400", hash_original_field = "E6AE6AEA20BF0D87AE52DA89192BC72A", hash_generated_field = "77D4EFADB5F65862A8907D645B6665E9")

    private static final int LOCK_ACQUIRED_WARNING_TIME_IN_MS = 300;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.556 -0400", hash_original_field = "95C6E5D7087CC2FC3A6DED5953679ECB", hash_generated_field = "A15D7DDE2E5CA3854E9FBBCADF643DF0")

    private static final int LOCK_ACQUIRED_WARNING_THREAD_TIME_IN_MS = 100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.556 -0400", hash_original_field = "7A6A59391B6242130CD71E5CD44E2D77", hash_generated_field = "C09CEC99CA0E20EA63872D1D54E55D2E")

    private static final int LOCK_ACQUIRED_WARNING_TIME_IN_MS_ALWAYS_PRINT = 2000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.556 -0400", hash_original_field = "CE309D87C3B10C71416ADF374777959F", hash_generated_field = "79E0F0AE9DE5E092336F50A45B4F8E1C")

    private static final int SLEEP_AFTER_YIELD_QUANTUM = 1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.556 -0400", hash_original_field = "5A389AB78BAF71DFE16B183F0C0E378C", hash_generated_field = "C84D9BD6B88C4ED7056C3B3F36774679")

    private static final Pattern EMAIL_IN_DB_PATTERN = Pattern.compile("[\\w\\.\\-]+@[\\w\\.\\-]+");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.556 -0400", hash_original_field = "54034B3C28E0BBADA285EC1AF26CD74C", hash_generated_field = "F4B529B387535F4368A600135D078A3F")

    private static int sQueryLogTimeInMillis = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.556 -0400", hash_original_field = "575EC464A3C910F3BE22BF3A40203271", hash_generated_field = "7148D851E918ABFB8558501AAF276067")

    private static final int QUERY_LOG_SQL_LENGTH = 64;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.556 -0400", hash_original_field = "68F17C8C6A1B7DDEBB7E0A50981231C4", hash_generated_field = "6E2686DCB15E3EED77BA00F0CDFF3560")

    private static final String COMMIT_SQL = "COMMIT;";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.556 -0400", hash_original_field = "9A60E40448B652CACF05359C701B5CC3", hash_generated_field = "6F4F9F4CA4122F0E0B63ADF311633E3F")

    private static final String BEGIN_SQL = "BEGIN;";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.556 -0400", hash_original_field = "F3551E46D929A290CE215BE1F66731CA", hash_generated_field = "B02DFFEED2F25BA54B1F54EB152A8058")

    static final String GET_LOCK_LOG_PREFIX = "GETLOCK:";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.557 -0400", hash_original_field = "5060FAACDAC84EA2DCCD0E197482A2DD", hash_generated_field = "51F4D205C63830AACD25F15FCA50EBDA")

    private static int sBlockSize = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.557 -0400", hash_original_field = "AB0CA8692820F6E5F155F4D312F65AF1", hash_generated_field = "3DC1596E29EDB016C413E70C0C6823BE")

    private static final int DEFAULT_SQL_CACHE_SIZE = 25;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.557 -0400", hash_original_field = "AD68061788347E0928ECF0DDBAB674B1", hash_generated_field = "FEBE70CE9042F617C4B8B12131A1C6AA")

    public static final int MAX_SQL_CACHE_SIZE = 100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.557 -0400", hash_original_field = "8F1610D46CA335F7A68476444639CCA5", hash_generated_field = "076429DC648CA31B53EA5479063A01DC")

    private static final String MEMORY_DB_PATH = ":memory:";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.557 -0400", hash_original_field = "B85ABB2B3844882B62C4390BDB646BAF", hash_generated_field = "6C1DD837716F02A5B85D056ED49553B5")

    private static ArrayList<WeakReference<SQLiteDatabase>> mActiveDatabases = new ArrayList<WeakReference<SQLiteDatabase>>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.557 -0400", hash_original_field = "4BCAA4A60DD2EB17A628C800025F88DA", hash_generated_field = "87A9BD3D7700EA6364DB461A232CAEB6")

    private static final long LOCK_WAIT_PERIOD = 30L;
}

