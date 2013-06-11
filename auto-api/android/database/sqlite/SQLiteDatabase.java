package android.database.sqlite;

// Droidsafe Imports
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
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
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;
import droidsafe.helpers.DSUtils;
import droidsafe.runtime.DroidSafeAndroidRuntime;
// import Iterator to deal with enhanced for loop translation

public class SQLiteDatabase extends SQLiteClosable {
    private static final String TAG = "SQLiteDatabase";
    private static final boolean ENABLE_DB_SAMPLE = false;
    private static final int EVENT_DB_OPERATION = 52000;
    private static final int EVENT_DB_CORRUPT = 75004;
    public static final int CONFLICT_ROLLBACK = 1;
    public static final int CONFLICT_ABORT = 2;
    public static final int CONFLICT_FAIL = 3;
    public static final int CONFLICT_IGNORE = 4;
    public static final int CONFLICT_REPLACE = 5;
    public static final int CONFLICT_NONE = 0;
    private static final String[] CONFLICT_VALUES = new String[]
            {"", " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE "};
    public static final int SQLITE_MAX_LIKE_PATTERN_LENGTH = 50000;
    public static final int OPEN_READWRITE = 0x00000000;
    public static final int OPEN_READONLY = 0x00000001;
    private static final int OPEN_READ_MASK = 0x00000001;
    public static final int NO_LOCALIZED_COLLATORS = 0x00000010;
    public static final int CREATE_IF_NECESSARY = 0x10000000;
    private boolean mInnerTransactionIsSuccessful;
    private boolean mTransactionIsSuccessful;
    private SQLiteTransactionListener mTransactionListener;
    private boolean mTransactionUsingExecSql;
    private final DatabaseReentrantLock mLock = new DatabaseReentrantLock(true);
    private long mLockAcquiredWallTime = 0L;
    private long mLockAcquiredThreadTime = 0L;
    private static final int LOCK_WARNING_WINDOW_IN_MS = 20000;
    private static final int LOCK_ACQUIRED_WARNING_TIME_IN_MS = 300;
    private static final int LOCK_ACQUIRED_WARNING_THREAD_TIME_IN_MS = 100;
    private static final int LOCK_ACQUIRED_WARNING_TIME_IN_MS_ALWAYS_PRINT = 2000;
    private static final int SLEEP_AFTER_YIELD_QUANTUM = 1000;
    private static final Pattern EMAIL_IN_DB_PATTERN = Pattern.compile("[\\w\\.\\-]+@[\\w\\.\\-]+");
    private long mLastLockMessageTime = 0L;
    private static int sQueryLogTimeInMillis = 0;
    private static final int QUERY_LOG_SQL_LENGTH = 64;
    private static final String COMMIT_SQL = "COMMIT;";
    private static final String BEGIN_SQL = "BEGIN;";
    private final Random mRandom = new Random();
    private String mLastSqlStatement = null;
    private long mTransStartTime;
    static final String GET_LOCK_LOG_PREFIX = "GETLOCK:";
    volatile int mNativeHandle = 0;
    private static int sBlockSize = 0;
    private /* final */ String mPath;
    private String mPathForLogs = null;
    private /* final  */int mFlags;
    private /* final  */CursorFactory mFactory;
    private /* final  */WeakHashMap<SQLiteClosable, Object> mPrograms;
    private static final int DEFAULT_SQL_CACHE_SIZE = 25;
    private LruCache<String, SQLiteCompiledSql> mCompiledQueries;
    public static final int MAX_SQL_CACHE_SIZE = 100;
    private boolean mCacheFullWarning;
    private /* final */ Throwable mStackTrace;
    private /* final  */ArrayList<Integer> mClosedStatementIds = new ArrayList<Integer>();
    private /* final  */DatabaseErrorHandler mErrorHandler;
    volatile DatabaseConnectionPool mConnectionPool = null;
    /* final  */short mConnectionNum;
    SQLiteDatabase mParentConnObj = null;
    private static final String MEMORY_DB_PATH = ":memory:";
    private volatile boolean mHasAttachedDbs = false;
    private static ArrayList<WeakReference<SQLiteDatabase>> mActiveDatabases =
            new ArrayList<WeakReference<SQLiteDatabase>>();
    private boolean mLockingEnabled = true;
    private static final long LOCK_WAIT_PERIOD = 30L;
    private final ArrayList<Integer> mCustomFunctions =
            new ArrayList<Integer>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.779 -0400", hash_original_method = "ED994C20AB51232E6F0B83AA0494CFAA", hash_generated_method = "98EAFBA7740B050FFDDD50564EA95D05")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private SQLiteDatabase(String path, CursorFactory factory, int flags,
            DatabaseErrorHandler errorHandler, short connectionNum) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(path);
        dsTaint.addTaint(connectionNum);
        dsTaint.addTaint(errorHandler.dsTaint);
        dsTaint.addTaint(factory.dsTaint);
        if (DroidSafeAndroidRuntime.control)
        {
            throw new IllegalArgumentException("path should not be null");
        } //End block
        setMaxSqlCacheSize(DEFAULT_SQL_CACHE_SIZE);
        mStackTrace = new DatabaseObjectNotClosedException().fillInStackTrace();
        mPrograms = new WeakHashMap<SQLiteClosable,Object>();
        mErrorHandler = (errorHandler == null) ? new DefaultDatabaseErrorHandler() : errorHandler;
        int limit;
        limit = Resources.getSystem().getInteger(
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.779 -0400", hash_original_method = "C15F9F532AF7810AA7D3562C5DDE29F6", hash_generated_method = "4F82A67F5FC39C06165AF1CF52186BBB")
    @DSModeled(DSC.SAFE)
    synchronized String getLastSqlStatement() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mLastSqlStatement;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.779 -0400", hash_original_method = "3743AC991024775005FDBE1593E9891E", hash_generated_method = "0EB3CBA08808EF49C200F66CDB1632E1")
    @DSModeled(DSC.SAFE)
    synchronized void setLastSqlStatement(String sql) {
        dsTaint.addTaint(sql);
        // ---------- Original Method ----------
        //mLastSqlStatement = sql;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.779 -0400", hash_original_method = "FF36C1ABFEC0F5F1C3DFBA7FD0941B56", hash_generated_method = "7A2DF06E4376E6A765EB54874DAE3EC6")
    @DSModeled(DSC.SAFE)
    synchronized void addSQLiteClosable(SQLiteClosable closable) {
        dsTaint.addTaint(closable.dsTaint);
        mPrograms.put(closable, null);
        // ---------- Original Method ----------
        //mPrograms.put(closable, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.779 -0400", hash_original_method = "030B4AA23DD4EAEE65D260C86C2A8B4C", hash_generated_method = "4961F4602AF45EE0F535904A096608E8")
    @DSModeled(DSC.SAFE)
    synchronized void removeSQLiteClosable(SQLiteClosable closable) {
        dsTaint.addTaint(closable.dsTaint);
        mPrograms.remove(closable);
        // ---------- Original Method ----------
        //mPrograms.remove(closable);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.780 -0400", hash_original_method = "29F441CF35047DF9CBB0BC7BF2B03F36", hash_generated_method = "F378413099AA2902E7475BBB4A9D2393")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onAllReferencesReleased() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean varF14FAC85BD81325B95F4F52AC5545E52_1635101765 = (isOpen());
            {
                close();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (isOpen()) {
            //close();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.780 -0400", hash_original_method = "392852D60CF1BF42580AE337B7836254", hash_generated_method = "161DB10C14B7F867E6934D31E3CBCF66")
    static public int releaseMemory() {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    	return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.780 -0400", hash_original_method = "CD58BEDD0347A27F6CFE4EB9BEFDF2F6", hash_generated_method = "7464F1C29521DADEBB23461F865FAC86")
    @DSModeled(DSC.SAFE)
    public void setLockingEnabled(boolean lockingEnabled) {
        dsTaint.addTaint(lockingEnabled);
        // ---------- Original Method ----------
        //mLockingEnabled = lockingEnabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.780 -0400", hash_original_method = "6F1C3BA1763F74F7C0395D958A12A363", hash_generated_method = "1BE1FFA4BD4B6B2212613186D79A5D2C")
    @DSModeled(DSC.SAFE)
     void onCorruption() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        EventLog.writeEvent(EVENT_DB_CORRUPT, mPath);
        mErrorHandler.onCorruption(this);
        // ---------- Original Method ----------
        //EventLog.writeEvent(EVENT_DB_CORRUPT, mPath);
        //mErrorHandler.onCorruption(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.780 -0400", hash_original_method = "6F6099DC841EA0266005BC3A83B18A96", hash_generated_method = "B60C52FF78733CC47B0BBCD3FCBB00D2")
    @DSModeled(DSC.SAFE)
     void lock(String sql) {
        dsTaint.addTaint(sql);
        lock(sql, false);
        // ---------- Original Method ----------
        //lock(sql, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.780 -0400", hash_original_method = "8D6DAA6963637C0BD50884518E0FF993", hash_generated_method = "758A3E811FDE755C72AEA12CBF28B76F")
    @DSModeled(DSC.SAFE)
     void lock() {
        lock(null, false);
        // ---------- Original Method ----------
        //lock(null, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.781 -0400", hash_original_method = "550218B4AE04D143508369398336F95D", hash_generated_method = "60659CA4AC78EF601AB5799D6C06A87B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void lock(String sql, boolean forced) {
        dsTaint.addTaint(sql);
        dsTaint.addTaint(forced);
        {
            boolean var0236CB8C0F56FF35CDAF225C25DD9AAC_1843740746 = (Thread.holdsLock(this));
        } //End collapsed parenthetic
        verifyDbIsOpen();
        boolean done;
        done = false;
        long timeStart;
        timeStart = SystemClock.uptimeMillis();
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
                boolean varFAE68FF2C6BC8FEF8EA9B7CE8CF77E28_14673076 = (mLock.getHoldCount() == 1);
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.781 -0400", hash_original_method = "5F1F87633E052520A24DBAD554D491B1", hash_generated_method = "AA35A3924AD12B15809267E06B7F6261")
    @DSModeled(DSC.SAFE)
    private void lockForced() {
        lock(null, true);
        // ---------- Original Method ----------
        //lock(null, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.781 -0400", hash_original_method = "E1FDB470EFF9EA86A5AAC7A627D6955E", hash_generated_method = "B2DE212856B497490A67DF8CD21D6F77")
    @DSModeled(DSC.SAFE)
    private void lockForced(String sql) {
        dsTaint.addTaint(sql);
        lock(sql, true);
        // ---------- Original Method ----------
        //lock(sql, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.781 -0400", hash_original_method = "CB05AAFAB101AFFDD598174816C61BF7", hash_generated_method = "8B0388BFFFB80276BF99FD7D97823FC0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void unlock() {
        {
            {
                boolean varFAE68FF2C6BC8FEF8EA9B7CE8CF77E28_1101840701 = (mLock.getHoldCount() == 1);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.782 -0400", hash_original_method = "CA4E01B405088BC736DA3EA88D772AB0", hash_generated_method = "5BFCAA264EA4D978BD152DFFC6458E50")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void unlockForced() {
        {
            {
                boolean varFAE68FF2C6BC8FEF8EA9B7CE8CF77E28_1679606420 = (mLock.getHoldCount() == 1);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.782 -0400", hash_original_method = "15FB67C6B55CF4F17EB9E05703E68C1A", hash_generated_method = "5D04198A6E72A98847678B9C80BB3892")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void checkLockHoldTime() {
        long elapsedTime;
        elapsedTime = SystemClock.elapsedRealtime();
        long lockedTime;
        lockedTime = elapsedTime - mLockAcquiredWallTime;
        {
            boolean var1C0B53C7CF19FA5142D07A08F2710172_467363829 = (lockedTime < LOCK_ACQUIRED_WARNING_TIME_IN_MS_ALWAYS_PRINT &&
                !Log.isLoggable(TAG, Log.VERBOSE) &&
                (elapsedTime - mLastLockMessageTime) < LOCK_WARNING_WINDOW_IN_MS);
        } //End collapsed parenthetic
        {
            int threadTime;
            threadTime = (int)
                    ((Debug.threadCpuTimeNanos() - mLockAcquiredThreadTime) / 1000000);
            {
                mLastLockMessageTime = elapsedTime;
                String msg;
                msg = "lock held on " + mPath + " for " + lockedTime + "ms. Thread time was "
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.782 -0400", hash_original_method = "36B8D50340D02900F098E44F066CFF12", hash_generated_method = "81FC6001B4176D51D6A5E23984E6283E")
    @DSModeled(DSC.SAFE)
    public void beginTransaction() {
        beginTransaction(null , true);
        // ---------- Original Method ----------
        //beginTransaction(null , true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.782 -0400", hash_original_method = "E00D9BE9F4C6FCF885F8A6933F83E5B2", hash_generated_method = "D444870B2F061B299E1B989C982CBA42")
    @DSModeled(DSC.SAFE)
    public void beginTransactionNonExclusive() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        beginTransaction(null , false);
        // ---------- Original Method ----------
        //beginTransaction(null , false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.782 -0400", hash_original_method = "5BD04E9A01CA28B4B773A517F832DDF2", hash_generated_method = "5DE77983324E54317983E2FF84D28A50")
    @DSModeled(DSC.SAFE)
    public void beginTransactionWithListener(SQLiteTransactionListener transactionListener) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(transactionListener.dsTaint);
        beginTransaction(transactionListener, true);
        // ---------- Original Method ----------
        //beginTransaction(transactionListener, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.783 -0400", hash_original_method = "EB4000007896884F9C35346C5F5B9337", hash_generated_method = "36B5AD659EB813800CB535FF20EC627B")
    @DSModeled(DSC.SAFE)
    public void beginTransactionWithListenerNonExclusive(
            SQLiteTransactionListener transactionListener) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(transactionListener.dsTaint);
        beginTransaction(transactionListener, false);
        // ---------- Original Method ----------
        //beginTransaction(transactionListener, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.783 -0400", hash_original_method = "65C15EF02A1263C4153105EBF58851D9", hash_generated_method = "14B404FD1C01142D05952F71BF266476")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void beginTransaction(SQLiteTransactionListener transactionListener,
            boolean exclusive) {
        dsTaint.addTaint(exclusive);
        dsTaint.addTaint(transactionListener.dsTaint);
        verifyDbIsOpen();
        lockForced(BEGIN_SQL);
        boolean ok;
        ok = false;
        try 
        {
            {
                boolean varAF914129F00129CFDB57A245D2027B2F_1975542235 = (mLock.getHoldCount() > 1);
                {
                	if (DroidSafeAndroidRuntime.control)
                    {
                        String msg;
                        msg = "Cannot call beginTransaction between "
                            + "calling setTransactionSuccessful and endTransaction";
                        IllegalStateException e;
                        e = new IllegalStateException(msg);
                        throw e;
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
                    throw e;
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.783 -0400", hash_original_method = "94F2931FC5A304B6FE8748C95A17E4E3", hash_generated_method = "5C8BA1523F713FE4A3229B42096E86BF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
                boolean varBAE3CD5B00DE7A95D508FDA3C102ACA4_1604895118 = (mLock.getHoldCount() != 1);
            } //End collapsed parenthetic
            RuntimeException savedException;
            savedException = null;
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
                        throw savedException;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.784 -0400", hash_original_method = "CAD10DEB5A167AB4D97D078F2E23C48E", hash_generated_method = "95FE752D2DEFCD7116A035641817F36F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setTransactionSuccessful() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        verifyDbIsOpen();
        {
            boolean varA9768C0684D8D9C3694FCFB8FF7505EA_1716786350 = (!mLock.isHeldByCurrentThread());
	        if (DroidSafeAndroidRuntime.control)
            {
                throw new IllegalStateException("no transaction pending");
            } //End block
        } //End collapsed parenthetic
        if (DroidSafeAndroidRuntime.control)
        {
            throw new IllegalStateException(
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.784 -0400", hash_original_method = "6E9122EA7DDDF4A7FCE3C41AA714113C", hash_generated_method = "38422DA1140C75BF6A2D18FDF7A13FB3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean inTransaction() {
        boolean var4C9D249B5D0C4B9126D436C907678D95_1000373836 = (mLock.getHoldCount() > 0 || mTransactionUsingExecSql);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mLock.getHoldCount() > 0 || mTransactionUsingExecSql;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.784 -0400", hash_original_method = "5CE93639419B30E518363E5F446309C9", hash_generated_method = "DE6A1EF0E1202E6823094653507FFE5E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    synchronized void setTransactionUsingExecSqlFlag() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean var7061DF8A5335B809C796044C2A062407_1805834315 = (Log.isLoggable(TAG, Log.DEBUG));
        } //End collapsed parenthetic
        mTransactionUsingExecSql = true;
        // ---------- Original Method ----------
        //if (Log.isLoggable(TAG, Log.DEBUG)) {
            //Log.i(TAG, "found execSQL('begin transaction')");
        //}
        //mTransactionUsingExecSql = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.784 -0400", hash_original_method = "37864C1F3B8C10FDA9B20AB532C7EB78", hash_generated_method = "906135F96C5F95ABD503E4DB0775E032")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    synchronized void resetTransactionUsingExecSqlFlag() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean var7061DF8A5335B809C796044C2A062407_490545053 = (Log.isLoggable(TAG, Log.DEBUG));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.785 -0400", hash_original_method = "18141E27A4A6F223116C15568E4B1710", hash_generated_method = "EB17AB53660728B9A6E059AA0EF225F0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    synchronized boolean amIInTransaction() {
        SQLiteDatabase db;
        boolean var81E049CAF652C4104E2A8460AB4F8005_1420148209 = ((isPooledConnection()));
        db = mParentConnObj;
        db = this;
        boolean b;
        boolean var052869E209429152260CA7258506DF14_647795285 = ((!db.inTransaction()));
        b = false;
        b = db.mTransactionUsingExecSql || db.mLock.isHeldByCurrentThread();
        {
            boolean var7061DF8A5335B809C796044C2A062407_517861155 = (Log.isLoggable(TAG, Log.DEBUG));
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //SQLiteDatabase db = (isPooledConnection()) ? mParentConnObj : this;
        //boolean b = (!db.inTransaction()) ? false :
                //db.mTransactionUsingExecSql || db.mLock.isHeldByCurrentThread();
        //if (Log.isLoggable(TAG, Log.DEBUG)) {
            //Log.i(TAG, "amIinTransaction: " + b);
        //}
        //return b;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.785 -0400", hash_original_method = "810FBEC1135AAF9FE09D5ED72E2387AC", hash_generated_method = "23CAC29F773A74DB413E5ADF91F47A83")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isDbLockedByCurrentThread() {
        boolean var652252C690B50A2DB779325937C5EC45_1571211840 = (mLock.isHeldByCurrentThread());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mLock.isHeldByCurrentThread();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.785 -0400", hash_original_method = "AFE51BB500BDF01026C5B1FB8FA31F68", hash_generated_method = "0928137C712BB4C24EDEB6E37E9D5CA4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isDbLockedByOtherThreads() {
        boolean var8B5E8AE7202897DC44889938EB039DD8_686339539 = (!mLock.isHeldByCurrentThread() && mLock.isLocked());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return !mLock.isHeldByCurrentThread() && mLock.isLocked();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.785 -0400", hash_original_method = "275C631F29B5F92F82765C72693E08C5", hash_generated_method = "C00AACA47B4B626136304D69D806F379")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public boolean yieldIfContended() {
        boolean var50D0DC9993A243282E70CF5F32C6948B_1802882083 = (yieldIfContendedHelper(false ,
                -1 ));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return yieldIfContendedHelper(false ,
                //-1 );
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.785 -0400", hash_original_method = "E4D6EC2B61BA0EB36CC3F2E9664FDE2E", hash_generated_method = "998BCA597A09874487F2FF96070FAE4C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean yieldIfContendedSafely() {
        boolean var1B84B5B6D1C3C26E51A46F65AE31AC61_810382326 = (yieldIfContendedHelper(true , -1 ));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return yieldIfContendedHelper(true , -1 );
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.786 -0400", hash_original_method = "EFD5966AFCC9629F634B854AE0830507", hash_generated_method = "2A407BDCF8B537C6E5FA1EE7508B7AD8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean yieldIfContendedSafely(long sleepAfterYieldDelay) {
        dsTaint.addTaint(sleepAfterYieldDelay);
        boolean var7C02635E5B9B12611B1E13892F20EFA4_1624093322 = (yieldIfContendedHelper(true , sleepAfterYieldDelay));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return yieldIfContendedHelper(true , sleepAfterYieldDelay);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.786 -0400", hash_original_method = "82E88213585314141BE9DBE00F951B10", hash_generated_method = "D89ABC4D84F2FB08F047954FDBDC02C0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean yieldIfContendedHelper(boolean checkFullyYielded, long sleepAfterYieldDelay) {
        dsTaint.addTaint(sleepAfterYieldDelay);
        dsTaint.addTaint(checkFullyYielded);
        {
            boolean var5B3E72ED3F61C626DE29DC9592245606_1257851360 = (mLock.getQueueLength() == 0);
            {
                mLockAcquiredWallTime = SystemClock.elapsedRealtime();
                mLockAcquiredThreadTime = Debug.threadCpuTimeNanos();
            } //End block
        } //End collapsed parenthetic
        setTransactionSuccessful();
        SQLiteTransactionListener transactionListener;
        transactionListener = mTransactionListener;
        endTransaction();
        {
            {
                boolean var42788A8E0393F9B1C6C2ADCA7B153774_915665770 = (this.isDbLockedByCurrentThread());
		        if (DroidSafeAndroidRuntime.control)
                {
                    throw new IllegalStateException(
                        "Db locked more than once. yielfIfContended cannot yield");
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            long remainingDelay;
            remainingDelay = sleepAfterYieldDelay;
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
                    boolean var741E584956C4EDE940BCF4AF8237BB37_1351755506 = (mLock.getQueueLength() == 0);
                } //End collapsed parenthetic
            } //End block
        } //End block
        beginTransactionWithListener(transactionListener);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.786 -0400", hash_original_method = "2BF74CD6834BBADBF27F65464DB83499", hash_generated_method = "ED9C57750BA2B41A032819D6064A2409")
    @DSModeled(DSC.SAFE)
    @Deprecated
    public Map<String, String> getSyncedTables() {
        return (Map<String, String>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new HashMap<String, String>(0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.786 -0400", hash_original_method = "561EAEA4DA554DB918DDA9176F70DC13", hash_generated_method = "4942BCB41767BFD0488622F1AB1E7C65")
    public static SQLiteDatabase openDatabase(String path, CursorFactory factory, int flags) {
        return openDatabase(path, factory, flags, new DefaultDatabaseErrorHandler());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.787 -0400", hash_original_method = "528BDC0ADA7690DDC947E526A8FE7C65", hash_generated_method = "EC6C9C59C3A6E0324758CA4EC3D385B6")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.787 -0400", hash_original_method = "320878150F5912B8D3148CDF6639FAEA", hash_generated_method = "19A094D50780C7266C6BDC64C83F763A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.787 -0400", hash_original_method = "18158E65D0AEC4A5DB9A049F4B71DBBA", hash_generated_method = "54E9E3271F913909401DE9AF04EFF66C")
    public static SQLiteDatabase openOrCreateDatabase(File file, CursorFactory factory) {
        return openOrCreateDatabase(file.getPath(), factory);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.787 -0400", hash_original_method = "8E5844484F4010F8E8AD05E1ADE2036F", hash_generated_method = "9A64F576CDEAEC3C965553C2321EC500")
    public static SQLiteDatabase openOrCreateDatabase(String path, CursorFactory factory) {
        return openDatabase(path, factory, CREATE_IF_NECESSARY);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.787 -0400", hash_original_method = "0BAAB26A173C80C4AB32C48250BFAADD", hash_generated_method = "28D90A01EDCDC7248932D45C65058399")
    public static SQLiteDatabase openOrCreateDatabase(String path, CursorFactory factory,
            DatabaseErrorHandler errorHandler) {
        return openDatabase(path, factory, CREATE_IF_NECESSARY, errorHandler);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.788 -0400", hash_original_method = "4DBAD15B0F91A1B1A1A509E057CF6487", hash_generated_method = "E5B851655F88EBFA1BCF1AABE407ED19")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setJournalMode(final String dbPath, final String mode) {
        dsTaint.addTaint(dbPath);
        dsTaint.addTaint(mode);
        {
            boolean varC8B178D4C16CE00624EBB098975A6C60_1520884201 = (dbPath.equalsIgnoreCase(MEMORY_DB_PATH) || isReadOnly());
        } //End collapsed parenthetic
        String s;
        s = DatabaseUtils.stringForQuery(this, "PRAGMA journal_mode=" + mode, null);
        {
            boolean varAE0C33F5A2193A82451F284839087E0B_888966957 = (!s.equalsIgnoreCase(mode));
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.788 -0400", hash_original_method = "2152343F8E4566351BAC450E2FDC2439", hash_generated_method = "3CC9038E7CEE062DE7E2055D6BFAF492")
    public static SQLiteDatabase create(CursorFactory factory) {
        return openDatabase(MEMORY_DB_PATH, factory, CREATE_IF_NECESSARY);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.788 -0400", hash_original_method = "F057ECACA47F2E639159F91F6FF25AA8", hash_generated_method = "F1A2E2A4E0C26EC80A3795B88E3D1F52")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void close() {
        {
            boolean var3A7D61B68AE823F6A30349D498C59A5C_1638335786 = (!isOpen());
        } //End collapsed parenthetic
        {
            boolean var7061DF8A5335B809C796044C2A062407_251558616 = (Log.isLoggable(TAG, Log.DEBUG));
        } //End collapsed parenthetic
        lock();
        try 
        {
            {
                boolean varC984E2D68DED4A73C5D827F4E91A6961_1422108159 = (!isOpen());
            } //End collapsed parenthetic
            closeClosable();
            closePendingStatements();
            releaseCustomFunctions();
            closeDatabase();
            {
                {
                    boolean var4202D0C449E97752DAE596DFB30FD8C9_1775594837 = (Log.isLoggable(TAG, Log.DEBUG));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.788 -0400", hash_original_method = "2CD800231F10038F3799DBDAB26BCEE1", hash_generated_method = "2B36CBC02E50142ED6D052D6241AD5CD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void closeClosable() {
        deallocCachedSqlStatements();
        Iterator<Map.Entry<SQLiteClosable, Object>> iter;
        iter = mPrograms.entrySet().iterator();
        {
            boolean varADABAFEBBAB7E585DD903333BD7F20A8_803146365 = (iter.hasNext());
            {
                Map.Entry<SQLiteClosable, Object> entry;
                entry = iter.next();
                SQLiteClosable program;
                program = entry.getKey();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.789 -0400", hash_original_method = "9BCDA7BC5AA364A3676019422CD41F65", hash_generated_method = "32DD62EB681721780F56F923A889C9EE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void closeDatabase() throws SQLiteException {
        try 
        {
            dbclose();
        } //End block
        catch (SQLiteUnfinalizedObjectsException e)
        {
            String msg;
            msg = e.getMessage();
            String[] tokens;
            tokens = msg.split(",", 2);
            int stmtId;
            stmtId = Integer.parseInt(tokens[0]);
            Iterator<Map.Entry<SQLiteClosable, Object>> iter;
            iter = mPrograms.entrySet().iterator();
            boolean found;
            found = false;
            {
                boolean var8492AE2C695A56B730381A28B8BA3F6D_1687762108 = (iter.hasNext());
                {
                    Map.Entry<SQLiteClosable, Object> entry;
                    entry = iter.next();
                    SQLiteClosable program;
                    program = entry.getKey();
                    {
                        SQLiteCompiledSql compiledSql;
                        compiledSql = ((SQLiteProgram)program).mCompiledSql;
                        {
                            msg = compiledSql.toString();
                            found = true;
                        } //End block
                    } //End block
                } //End block
            } //End collapsed parenthetic
            {
                {
                    boolean var264DD9E27C37EF07E76F2B3412A8E5A6_113579584 = (mClosedStatementIds.contains(stmtId));
                    {
                        closePendingStatements();
                        closeDatabase();
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                throw new SQLiteUnfinalizedObjectsException(
                        "close() on database: " + getPath() +
                        " failed due to un-close()d SQL statements: " + msg);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.789 -0400", hash_original_method = "4C27B28311EC4401B9E72044B34DEE3C", hash_generated_method = "136FD5560951F9B00385918E6ED0146E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void dbclose() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.789 -0400", hash_original_method = "6AE38120A6AE17DCB302700D83D76664", hash_generated_method = "193F92A2591FD50E1E75CD67EC4F96D4")
    @DSModeled(DSC.SAFE)
    public void addCustomFunction(String name, int numArgs, CustomFunction function) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(numArgs);
        dsTaint.addTaint(function.dsTaint);
        verifyDbIsOpen();
        {
            int ref;
            ref = native_addCustomFunction(name, numArgs, function);
            {
                mCustomFunctions.add(new Integer(ref));
            } //End block
            {
                throw new SQLiteException("failed to add custom function " + name);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.790 -0400", hash_original_method = "9C15AE424A91890D11F6682C678B396E", hash_generated_method = "6141A6BE68328966AF74C5A2723E8106")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void releaseCustomFunctions() {
        {
            {
                int i;
                i = 0;
                boolean var36D8B34DC42E2CA6FF5F9433DF425473_742787128 = (i < mCustomFunctions.size());
                {
                    Integer function;
                    function = mCustomFunctions.get(i);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.790 -0400", hash_original_method = "545ECF4B8C2C387E458104596CE82C8C", hash_generated_method = "306F3469A315E0895DB28AC924719732")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int native_addCustomFunction(String name, int numArgs, CustomFunction function) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(numArgs);
        dsTaint.addTaint(function.dsTaint);
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.790 -0400", hash_original_method = "D641D8CC9687EF2DFB0D6D88DDBFEE42", hash_generated_method = "2F620F3F9EDBBC6CC18464A0CA074504")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void native_releaseCustomFunction(int function) {
        dsTaint.addTaint(function);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.790 -0400", hash_original_method = "8BA60C4A4A322F100A535BB125C59B40", hash_generated_method = "760C8E8ADA545BC96E0ED893E357F469")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getVersion() {
        int var5ED7B897E4829D15D8A8C1ABA4EB6C66_1718589791 = (((Long) DatabaseUtils.longForQuery(this, "PRAGMA user_version;", null)).intValue());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return ((Long) DatabaseUtils.longForQuery(this, "PRAGMA user_version;", null)).intValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.790 -0400", hash_original_method = "4E3C0E9170C91236F101F38522569C45", hash_generated_method = "44ADF08075D09AE64A3BDF5F58460E8F")
    @DSModeled(DSC.SAFE)
    public void setVersion(int version) {
        dsTaint.addTaint(version);
        execSQL("PRAGMA user_version = " + version);
        // ---------- Original Method ----------
        //execSQL("PRAGMA user_version = " + version);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.791 -0400", hash_original_method = "01DC63CC6FF3C1462DC7069F3072C18D", hash_generated_method = "A1D64F62345458AD1E0D089050A14377")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long getMaximumSize() {
        long pageCount;
        pageCount = DatabaseUtils.longForQuery(this, "PRAGMA max_page_count;", null);
        long varCE811D607639101FC1388FCB35FFCD9C_434501158 = (pageCount * getPageSize());
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //long pageCount = DatabaseUtils.longForQuery(this, "PRAGMA max_page_count;", null);
        //return pageCount * getPageSize();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.791 -0400", hash_original_method = "B09E5ED21834BC66E218E9635E49257B", hash_generated_method = "AB89FE0A1EA2666E46B86F68986C53EA")
    @DSModeled(DSC.SAFE)
    public long setMaximumSize(long numBytes) {
        dsTaint.addTaint(numBytes);
        long pageSize;
        pageSize = getPageSize();
        long numPages;
        numPages = numBytes / pageSize;
        {
            numPages++;
        } //End block
        long newPageCount;
        newPageCount = DatabaseUtils.longForQuery(this, "PRAGMA max_page_count = " + numPages,
                null);
        return dsTaint.getTaintLong();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.791 -0400", hash_original_method = "677D214086B645E86B85D4E2A88CD9F6", hash_generated_method = "543A6F5E9ED4D13E3C54EB504209E8EC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long getPageSize() {
        long varA97F1A3236E9434F0519DFDCD56746B7_1313392816 = (DatabaseUtils.longForQuery(this, "PRAGMA page_size;", null));
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return DatabaseUtils.longForQuery(this, "PRAGMA page_size;", null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.791 -0400", hash_original_method = "CE3FCE5D2F41E0E2EF73A0D49E90DE3F", hash_generated_method = "87BDBE6B2448402D7605BF05711A5531")
    @DSModeled(DSC.SAFE)
    public void setPageSize(long numBytes) {
        dsTaint.addTaint(numBytes);
        execSQL("PRAGMA page_size = " + numBytes);
        // ---------- Original Method ----------
        //execSQL("PRAGMA page_size = " + numBytes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.791 -0400", hash_original_method = "0ECCFA53F5E6749CB5B25917802B1822", hash_generated_method = "7EC64A1FD6D3475BC9DA9603F7E32A65")
    @DSModeled(DSC.SAFE)
    @Deprecated
    public void markTableSyncable(String table, String deletedTable) {
        dsTaint.addTaint(table);
        dsTaint.addTaint(deletedTable);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.791 -0400", hash_original_method = "9A70316D056BE2F7590F6370A4F13111", hash_generated_method = "D459F491E929A376FAD20BC3BABAA644")
    @DSModeled(DSC.SAFE)
    @Deprecated
    public void markTableSyncable(String table, String foreignKey, String updateTable) {
        dsTaint.addTaint(updateTable);
        dsTaint.addTaint(table);
        dsTaint.addTaint(foreignKey);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.792 -0400", hash_original_method = "EBECA09284F826B6433735F733F3B876", hash_generated_method = "0E355701222AEBC610C529EAD9317380")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.792 -0400", hash_original_method = "C05C583B39FD005C236783082CBB4E55", hash_generated_method = "75AF16EBA55695E9E6E507EB610A2931")
    @DSModeled(DSC.SAFE)
    public SQLiteStatement compileStatement(String sql) throws SQLException {
        dsTaint.addTaint(sql);
        verifyDbIsOpen();
        return (SQLiteStatement)dsTaint.getTaint();
        // ---------- Original Method ----------
        //verifyDbIsOpen();
        //return new SQLiteStatement(this, sql, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.792 -0400", hash_original_method = "5E1B6C3D7A97420E0A4D0244321FA1D0", hash_generated_method = "A0118C76E063AB5765DDB365863D3C3E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Cursor query(boolean distinct, String table, String[] columns,
            String selection, String[] selectionArgs, String groupBy,
            String having, String orderBy, String limit) {
        dsTaint.addTaint(groupBy);
        dsTaint.addTaint(limit);
        dsTaint.addTaint(selectionArgs);
        dsTaint.addTaint(orderBy);
        dsTaint.addTaint(columns);
        dsTaint.addTaint(having);
        dsTaint.addTaint(table);
        dsTaint.addTaint(selection);
        dsTaint.addTaint(distinct);
        Cursor var7C414AEB20F5FB2360D6E5CB08187A58_1346756929 = (queryWithFactory(null, distinct, table, columns, selection, selectionArgs,
                groupBy, having, orderBy, limit));
        return (Cursor)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return queryWithFactory(null, distinct, table, columns, selection, selectionArgs,
                //groupBy, having, orderBy, limit);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.792 -0400", hash_original_method = "2EC2F985341F70A15977A4E5B8D54ACE", hash_generated_method = "125C460993D0C18ACA2AEF8B265A98A4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Cursor queryWithFactory(CursorFactory cursorFactory,
            boolean distinct, String table, String[] columns,
            String selection, String[] selectionArgs, String groupBy,
            String having, String orderBy, String limit) {
        dsTaint.addTaint(groupBy);
        dsTaint.addTaint(limit);
        dsTaint.addTaint(selectionArgs);
        dsTaint.addTaint(orderBy);
        dsTaint.addTaint(columns);
        dsTaint.addTaint(having);
        dsTaint.addTaint(cursorFactory.dsTaint);
        dsTaint.addTaint(table);
        dsTaint.addTaint(selection);
        dsTaint.addTaint(distinct);
        verifyDbIsOpen();
        String sql;
        sql = SQLiteQueryBuilder.buildQueryString(
                distinct, table, columns, selection, groupBy, having, orderBy, limit);
        Cursor var6AB9B6B49A722F92B3A5A22EA8B9D717_1332414736 = (rawQueryWithFactory(
                cursorFactory, sql, selectionArgs, findEditTable(table)));
        return (Cursor)dsTaint.getTaint();
        // ---------- Original Method ----------
        //verifyDbIsOpen();
        //String sql = SQLiteQueryBuilder.buildQueryString(
                //distinct, table, columns, selection, groupBy, having, orderBy, limit);
        //return rawQueryWithFactory(
                //cursorFactory, sql, selectionArgs, findEditTable(table));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.793 -0400", hash_original_method = "823CC97B8BCC24B1EEF8A14CAC46F9D2", hash_generated_method = "DD593285B7748752DC6E022991AD41A7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Cursor query(String table, String[] columns, String selection,
            String[] selectionArgs, String groupBy, String having,
            String orderBy) {
        dsTaint.addTaint(groupBy);
        dsTaint.addTaint(selectionArgs);
        dsTaint.addTaint(orderBy);
        dsTaint.addTaint(columns);
        dsTaint.addTaint(having);
        dsTaint.addTaint(table);
        dsTaint.addTaint(selection);
        Cursor varA8C341C7A429E9C213E46E4C78AB940C_1611408630 = (query(false, table, columns, selection, selectionArgs, groupBy,
                having, orderBy, null ));
        return (Cursor)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return query(false, table, columns, selection, selectionArgs, groupBy,
                //having, orderBy, null );
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.793 -0400", hash_original_method = "C821013CE8C43126ED02ADCC7264C8CF", hash_generated_method = "DF57EE75DC37A72D4DE50F8F70CFCA56")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Cursor query(String table, String[] columns, String selection,
            String[] selectionArgs, String groupBy, String having,
            String orderBy, String limit) {
        dsTaint.addTaint(groupBy);
        dsTaint.addTaint(limit);
        dsTaint.addTaint(selectionArgs);
        dsTaint.addTaint(orderBy);
        dsTaint.addTaint(columns);
        dsTaint.addTaint(having);
        dsTaint.addTaint(table);
        dsTaint.addTaint(selection);
        Cursor varF34315A8B7B3D3CA39FF264BDB8D8F18_952299545 = (query(false, table, columns, selection, selectionArgs, groupBy,
                having, orderBy, limit));
        return (Cursor)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return query(false, table, columns, selection, selectionArgs, groupBy,
                //having, orderBy, limit);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.793 -0400", hash_original_method = "76B8F97A589187A4837E14E72F2396A8", hash_generated_method = "A76EDF364C0E719B624E2E7F1849AA90")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Cursor rawQuery(String sql, String[] selectionArgs) {
        dsTaint.addTaint(sql);
        dsTaint.addTaint(selectionArgs);
        Cursor var1110AB9FBFF6DA86B6E52347B34B12CC_1476501128 = (rawQueryWithFactory(null, sql, selectionArgs, null));
        return (Cursor)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return rawQueryWithFactory(null, sql, selectionArgs, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.793 -0400", hash_original_method = "42A0891F7A1C512D8BE3F37EFD1DF118", hash_generated_method = "C46E74A6EF9F76FE9A6BDAF07E99AB34")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Cursor rawQueryWithFactory(
            CursorFactory cursorFactory, String sql, String[] selectionArgs,
            String editTable) {
        dsTaint.addTaint(sql);
        dsTaint.addTaint(selectionArgs);
        dsTaint.addTaint(cursorFactory.dsTaint);
        dsTaint.addTaint(editTable);
        verifyDbIsOpen();
        BlockGuard.getThreadPolicy().onReadFromDisk();
        SQLiteDatabase db;
        db = getDbConnection(sql);
        SQLiteCursorDriver driver;
        driver = new SQLiteDirectCursorDriver(db, sql, editTable);
        Cursor cursor;
        cursor = null;
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
        return (Cursor)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.793 -0400", hash_original_method = "7C0142B65481E16DCFB76B6C0BD0AF64", hash_generated_method = "BEED8DB84CC3F914063F81F0C3C4EBFF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long insert(String table, String nullColumnHack, ContentValues values) {
        dsTaint.addTaint(values.dsTaint);
        dsTaint.addTaint(nullColumnHack);
        dsTaint.addTaint(table);
        try 
        {
            long varF52CAAA7AE26F4FA45ED0B3A37BD4379_1885897181 = (insertWithOnConflict(table, nullColumnHack, values, CONFLICT_NONE));
        } //End block
        catch (SQLException e)
        { }
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //try {
            //return insertWithOnConflict(table, nullColumnHack, values, CONFLICT_NONE);
        //} catch (SQLException e) {
            //Log.e(TAG, "Error inserting " + values, e);
            //return -1;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.794 -0400", hash_original_method = "2F31CF2160A369C3FFDDD251C32C2819", hash_generated_method = "DFCA5F95E835ECD91B3FD039696EE660")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long insertOrThrow(String table, String nullColumnHack, ContentValues values) throws SQLException {
        dsTaint.addTaint(values.dsTaint);
        dsTaint.addTaint(nullColumnHack);
        dsTaint.addTaint(table);
        long var22A9FB7F2C81F3272F2370661FA4E896_271424592 = (insertWithOnConflict(table, nullColumnHack, values, CONFLICT_NONE));
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return insertWithOnConflict(table, nullColumnHack, values, CONFLICT_NONE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.794 -0400", hash_original_method = "4277B606CBD58106C26DEC9C427B6DC5", hash_generated_method = "0E3DAD41DACC62E696E16069068EC1E8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long replace(String table, String nullColumnHack, ContentValues initialValues) {
        dsTaint.addTaint(initialValues.dsTaint);
        dsTaint.addTaint(nullColumnHack);
        dsTaint.addTaint(table);
        try 
        {
            long var0B6B818F8EACB8B15016A791818A7376_82445487 = (insertWithOnConflict(table, nullColumnHack, initialValues,
                    CONFLICT_REPLACE));
        } //End block
        catch (SQLException e)
        { }
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //try {
            //return insertWithOnConflict(table, nullColumnHack, initialValues,
                    //CONFLICT_REPLACE);
        //} catch (SQLException e) {
            //Log.e(TAG, "Error inserting " + initialValues, e);
            //return -1;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.794 -0400", hash_original_method = "006F0DF267AA18E88B2010DFB3E66CC0", hash_generated_method = "434366353CB8F54B40AF7F51E7207B42")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long replaceOrThrow(String table, String nullColumnHack,
            ContentValues initialValues) throws SQLException {
        dsTaint.addTaint(initialValues.dsTaint);
        dsTaint.addTaint(nullColumnHack);
        dsTaint.addTaint(table);
        long varDB0C7A87625C42614968DA8DC2DF448A_144105502 = (insertWithOnConflict(table, nullColumnHack, initialValues,
                CONFLICT_REPLACE));
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return insertWithOnConflict(table, nullColumnHack, initialValues,
                //CONFLICT_REPLACE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.795 -0400", hash_original_method = "4E696CAC31E62C2450813F66BA0D3688", hash_generated_method = "2C33B71B8598C035B23B8E320BAF382E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long insertWithOnConflict(String table, String nullColumnHack,
            ContentValues initialValues, int conflictAlgorithm) {
        dsTaint.addTaint(conflictAlgorithm);
        dsTaint.addTaint(initialValues.dsTaint);
        dsTaint.addTaint(nullColumnHack);
        dsTaint.addTaint(table);
        StringBuilder sql;
        sql = new StringBuilder();
        sql.append("INSERT");
        sql.append(CONFLICT_VALUES[conflictAlgorithm]);
        sql.append(" INTO ");
        sql.append(table);
        sql.append('(');
        Object[] bindArgs;
        bindArgs = null;
        int size;
        boolean varC4E695B9AF881ABFE2BBBDD7E96404B3_1136931611 = ((initialValues != null && initialValues.size() > 0));
        size = initialValues.size();
        size = 0;
        {
            bindArgs = new Object[size];
            int i;
            i = 0;
            {
                Iterator<String> seatecAstronomy42 = initialValues.keySet().iterator();
                seatecAstronomy42.hasNext();
                String colName = seatecAstronomy42.next();
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
        SQLiteStatement statement;
        statement = new SQLiteStatement(this, sql.toString(), bindArgs);
        try 
        {
            long varF67BA8A1C61A250EDBDBDA7E8358FE23_2064588552 = (statement.executeInsert());
        } //End block
        catch (SQLiteDatabaseCorruptException e)
        {
            onCorruption();
            throw e;
        } //End block
        finally 
        {
            statement.close();
        } //End block
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.795 -0400", hash_original_method = "D469CE4575675C51277223F3405EF96C", hash_generated_method = "2EDA64B05BAA3D939D9417FD312A7AE4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int delete(String table, String whereClause, String[] whereArgs) {
        dsTaint.addTaint(whereClause);
        dsTaint.addTaint(whereArgs);
        dsTaint.addTaint(table);
        SQLiteStatement statement;
        statement = new SQLiteStatement(this, "DELETE FROM " + table +
                (!TextUtils.isEmpty(whereClause) ? " WHERE " + whereClause : ""), whereArgs);//DSFIXME:  CODE0008: Nested ternary operator in expression
        try 
        {
            int varA87545DC17687AF507150C89477E60CF_1419580699 = (statement.executeUpdateDelete());
        } //End block
        catch (SQLiteDatabaseCorruptException e)
        {
            onCorruption();
            throw e;
        } //End block
        finally 
        {
            statement.close();
        } //End block
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.795 -0400", hash_original_method = "1314F51B10A849824DA60B76F1896857", hash_generated_method = "7107807CECBED8C5C5769C3392F9F1E2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int update(String table, ContentValues values, String whereClause, String[] whereArgs) {
        dsTaint.addTaint(whereClause);
        dsTaint.addTaint(values.dsTaint);
        dsTaint.addTaint(whereArgs);
        dsTaint.addTaint(table);
        int varFBFAC28FFEFC923D6AC3F8D0EB28BD4D_343373430 = (updateWithOnConflict(table, values, whereClause, whereArgs, CONFLICT_NONE));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return updateWithOnConflict(table, values, whereClause, whereArgs, CONFLICT_NONE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.796 -0400", hash_original_method = "42C896B54A7E0C71455DEE45B9C2EA0D", hash_generated_method = "AB158FC53ECDE67539E2FE0C5F8A9D41")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int updateWithOnConflict(String table, ContentValues values,
            String whereClause, String[] whereArgs, int conflictAlgorithm) {
        dsTaint.addTaint(conflictAlgorithm);
        dsTaint.addTaint(whereClause);
        dsTaint.addTaint(values.dsTaint);
        dsTaint.addTaint(whereArgs);
        dsTaint.addTaint(table);
        {
            boolean var7F872E5B929E1733A7225AB743560CA0_58522392 = (values == null || values.size() == 0);
	        if (DroidSafeAndroidRuntime.control)
            {
                throw new IllegalArgumentException("Empty values");
            } //End block
        } //End collapsed parenthetic
        StringBuilder sql;
        sql = new StringBuilder(120);
        sql.append("UPDATE ");
        sql.append(CONFLICT_VALUES[conflictAlgorithm]);
        sql.append(table);
        sql.append(" SET ");
        int setValuesSize;
        setValuesSize = values.size();
        int bindArgsSize;
        bindArgsSize = setValuesSize;
        bindArgsSize = (setValuesSize + whereArgs.length);
        Object[] bindArgs;
        bindArgs = new Object[bindArgsSize];
        int i;
        i = 0;
        {
            Iterator<String> seatecAstronomy42 = values.keySet().iterator();
            seatecAstronomy42.hasNext();
            String colName = seatecAstronomy42.next();
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
            boolean varC582A3B0C0625E2C5B62147799474972_2034250432 = (!TextUtils.isEmpty(whereClause));
            {
                sql.append(" WHERE ");
                sql.append(whereClause);
            } //End block
        } //End collapsed parenthetic
        SQLiteStatement statement;
        statement = new SQLiteStatement(this, sql.toString(), bindArgs);
        try 
        {
            int varA87545DC17687AF507150C89477E60CF_476564651 = (statement.executeUpdateDelete());
        } //End block
        catch (SQLiteDatabaseCorruptException e)
        {
            onCorruption();
            throw e;
        } //End block
        finally 
        {
            statement.close();
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.796 -0400", hash_original_method = "25D536EB53093A036E9DAE961A0D97E6", hash_generated_method = "9D1FE035735EABA815C7FB41CBF635EF")
    @DSModeled(DSC.SAFE)
    public void execSQL(String sql) throws SQLException {
        dsTaint.addTaint(sql);
        executeSql(sql, null);
        // ---------- Original Method ----------
        //executeSql(sql, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.796 -0400", hash_original_method = "C75317BDB75C741C750B94F218C97882", hash_generated_method = "E6C793C0AC91DF94089C79CE421B1A20")
    @DSModeled(DSC.SAFE)
    public void execSQL(String sql, Object[] bindArgs) throws SQLException {
        dsTaint.addTaint(sql);
        dsTaint.addTaint(bindArgs[0].dsTaint);
        if (DroidSafeAndroidRuntime.control)
        {
            throw new IllegalArgumentException("Empty bindArgs");
        } //End block
        executeSql(sql, bindArgs);
        // ---------- Original Method ----------
        //if (bindArgs == null) {
            //throw new IllegalArgumentException("Empty bindArgs");
        //}
        //executeSql(sql, bindArgs);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.797 -0400", hash_original_method = "9265893CFBC7535112C5207F5F702C1B", hash_generated_method = "E6418D876E8E030B969F14A3B3B1F41A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int executeSql(String sql, Object[] bindArgs) throws SQLException {
        dsTaint.addTaint(sql);
        dsTaint.addTaint(bindArgs[0].dsTaint);
        {
            boolean varE0925AF52400942DD3DAF202DD99E6E6_442214635 = (DatabaseUtils.getSqlStatementType(sql) == DatabaseUtils.STATEMENT_ATTACH);
            {
                disableWriteAheadLogging();
                mHasAttachedDbs = true;
            } //End block
        } //End collapsed parenthetic
        SQLiteStatement statement;
        statement = new SQLiteStatement(this, sql, bindArgs);
        try 
        {
            int varA87545DC17687AF507150C89477E60CF_571222611 = (statement.executeUpdateDelete());
        } //End block
        catch (SQLiteDatabaseCorruptException e)
        {
            onCorruption();
            throw e;
        } //End block
        finally 
        {
            statement.close();
        } //End block
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.797 -0400", hash_original_method = "2C203F91898576B00C917F0CD42A518A", hash_generated_method = "158E40225EE64D8276AC83528945B7DA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void finalize() throws Throwable {
        try 
        {
            {
                boolean var5A39A3129B438981221C0F68BD29C416_148222222 = (isOpen());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.797 -0400", hash_original_method = "B8251338AB8EB8352A863E35E41B939B", hash_generated_method = "27288B8FAF0D10F6E7C59262B3FC1491")
    @DSModeled(DSC.SAFE)
    public boolean isReadOnly() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mFlags & OPEN_READ_MASK) == OPEN_READONLY;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.797 -0400", hash_original_method = "61E254D128D08D9B7DD7C5EEB86B883E", hash_generated_method = "CFCCC238827E6667EA89E28638FEAB85")
    @DSModeled(DSC.SAFE)
    public boolean isOpen() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mNativeHandle != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.797 -0400", hash_original_method = "4C8276EC0F604B529F31103A74E610FF", hash_generated_method = "4EB099E1B21E8B25953CB52C2787008D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean needUpgrade(int newVersion) {
        dsTaint.addTaint(newVersion);
        boolean var11347AA24D61D50D87B1A9EDCAB47EB3_1129982930 = (newVersion > getVersion());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return newVersion > getVersion();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.797 -0400", hash_original_method = "F177C5B02553C0E0327F321BDDCEAFD5", hash_generated_method = "EA4A19A6A31D64ADFB7933F14140DAC3")
    @DSModeled(DSC.SAFE)
    public final String getPath() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mPath;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.798 -0400", hash_original_method = "0D21C1E893B83D945127726B58A78BA2", hash_generated_method = "BC15C09BFF5666EE2B115B5DDDEDADD4")
    @DSModeled(DSC.SAFE)
     void logTimeStat(String sql, long beginMillis) {
        dsTaint.addTaint(sql);
        dsTaint.addTaint(beginMillis);
        {
            logTimeStat(sql, beginMillis, null);
        } //End block
        // ---------- Original Method ----------
        //if (ENABLE_DB_SAMPLE) {
            //logTimeStat(sql, beginMillis, null);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.798 -0400", hash_original_method = "8ED8142AF940938322CF345006300B7D", hash_generated_method = "B8DE0407982976B6F7CDEC0D3AE723D7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void logTimeStat(String sql, long beginMillis, String prefix) {
        dsTaint.addTaint(sql);
        dsTaint.addTaint(beginMillis);
        dsTaint.addTaint(prefix);
        int samplePercent;
        long durationMillis;
        durationMillis = SystemClock.uptimeMillis() - beginMillis;
        {
            sQueryLogTimeInMillis = SystemProperties.getInt("db.db_operation.threshold_ms", 500);
        } //End block
        {
            samplePercent = 100;
        } //End block
        {
            samplePercent = (int) (100 * durationMillis / sQueryLogTimeInMillis) + 1;
            {
                boolean varFD197FF6228B8320A1307AF1741CB740_1508308736 = (mRandom.nextInt(100) >= samplePercent);
            } //End collapsed parenthetic
        } //End block
        {
            sql = prefix + sql;
        } //End block
        {
            boolean var15761F9B8A55BA7056472F2EB9923186_965749411 = (sql.length() > QUERY_LOG_SQL_LENGTH);
            sql = sql.substring(0, QUERY_LOG_SQL_LENGTH);
        } //End collapsed parenthetic
        String blockingPackage;
        blockingPackage = AppGlobals.getInitialPackage();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.798 -0400", hash_original_method = "BAC313652C0D08E8CD159DBA09E31731", hash_generated_method = "1E4167C2913159AA88586C9EE87BD453")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String getPathForLogs() {
        {
            boolean var9CB372F979D264EF8BD68817AF56AFA9_580668323 = (mPath.indexOf('@') == -1);
            {
                mPathForLogs = mPath;
            } //End block
            {
                mPathForLogs = EMAIL_IN_DB_PATTERN.matcher(mPath).replaceAll("XX@YY");
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.799 -0400", hash_original_method = "3FAFCE8DADACDA6029D741D00EA768C4", hash_generated_method = "C67A5E65EE20A3FACCC842BA7E88D203")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setLocale(Locale locale) {
        dsTaint.addTaint(locale.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.799 -0400", hash_original_method = "82F89F6027C136BD18FB9173DDA585C3", hash_generated_method = "1E62C114F3DCD0D8CA64F818A3C33224")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void verifyDbIsOpen() {
        {
            boolean var3A7D61B68AE823F6A30349D498C59A5C_2075106734 = (!isOpen());
            {
                throw new IllegalStateException("database " + getPath() + " (conn# " +
                    mConnectionNum + ") already closed");
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (!isOpen()) {
            //throw new IllegalStateException("database " + getPath() + " (conn# " +
                    //mConnectionNum + ") already closed");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.799 -0400", hash_original_method = "2ABE5777D3030A58042EA8C11F6A64FB", hash_generated_method = "22F237CA0EF796AA320E979CD66329C1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void verifyLockOwner() {
        verifyDbIsOpen();
        {
            boolean var165EEFEEA133626155A410875EC632D2_595262971 = (mLockingEnabled && !isDbLockedByCurrentThread());
            {
                throw new IllegalStateException("Don't have database lock!");
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //verifyDbIsOpen();
        //if (mLockingEnabled && !isDbLockedByCurrentThread()) {
            //throw new IllegalStateException("Don't have database lock!");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.799 -0400", hash_original_method = "1F50605826534D1D8A189D3DC15DE94F", hash_generated_method = "ACB9AE8142D580A82C79157AEF61C58C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    synchronized void addToCompiledQueries(
            String sql, SQLiteCompiledSql compiledStatement) {
        dsTaint.addTaint(sql);
        dsTaint.addTaint(compiledStatement.dsTaint);
        {
            boolean var44AC47AE1DA995B439F70F98684BE351_1595466904 = (mCompiledQueries.get(sql) != null);
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
                    Iterator<String> seatecAstronomy42 = mCompiledQueries.snapshot().keySet().iterator();
                    seatecAstronomy42.hasNext();
                    String s = seatecAstronomy42.next();
                    {
                        Log.d(TAG, "Sql statement in Cache: " + s);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        mCompiledQueries.put(sql, compiledStatement);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.800 -0400", hash_original_method = "CE0C87ACDC099813F3D6D588DE2B56CF", hash_generated_method = "6173776D51E5C110D6AD712EFDB5EB92")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    synchronized void deallocCachedSqlStatements() {
        {
            Iterator<SQLiteCompiledSql> seatecAstronomy42 = mCompiledQueries.snapshot().values().iterator();
            seatecAstronomy42.hasNext();
            SQLiteCompiledSql compiledSql = seatecAstronomy42.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.800 -0400", hash_original_method = "A3F9326C17119FEC2A90D0724FE482CF", hash_generated_method = "522BDA6C0912D4EF3B794E4887D0D0C7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    synchronized SQLiteCompiledSql getCompiledStatementForSql(String sql) {
        dsTaint.addTaint(sql);
        SQLiteCompiledSql var68C1802207867E1F50B1B8E04371E33E_1135120759 = (mCompiledQueries.get(sql));
        return (SQLiteCompiledSql)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mCompiledQueries.get(sql);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.800 -0400", hash_original_method = "986DCF2E02788969CC84FF6D84C81E71", hash_generated_method = "7BD073033ED4117BC9E050A8E69019CF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setMaxSqlCacheSize(int cacheSize) {
        dsTaint.addTaint(cacheSize);
        {
            LruCache<String, SQLiteCompiledSql> oldCompiledQueries;
            oldCompiledQueries = mCompiledQueries;
	        if (DroidSafeAndroidRuntime.control)
            {
                throw new IllegalStateException(
                        "expected value between 0 and " + MAX_SQL_CACHE_SIZE);
            } //End block
            {
                boolean var551279D6CBA810FBA7717E31CAA6F559_1616418018 = (oldCompiledQueries != null && cacheSize < oldCompiledQueries.maxSize());
		        if (DroidSafeAndroidRuntime.control)
                {
                    throw new IllegalStateException("cannot set cacheSize to a value less than the "
                        + "value set with previous setMaxSqlCacheSize() call.");
                } //End block
            } //End collapsed parenthetic
            mCompiledQueries = new LruCache<String, SQLiteCompiledSql>(cacheSize) {
                @Override
                protected void entryRemoved(boolean evicted, String key, SQLiteCompiledSql oldValue,
                        SQLiteCompiledSql newValue) {
                    verifyLockOwner();
                    oldValue.releaseIfNotInUse();
                }
            };
            {
                {
                    Iterator<Map.Entry<String, SQLiteCompiledSql>> seatecAstronomy42 = oldCompiledQueries.snapshot().entrySet().iterator();
                    seatecAstronomy42.hasNext();
                    Map.Entry<String, SQLiteCompiledSql> entry = seatecAstronomy42.next();
                    {
                        mCompiledQueries.put(entry.getKey(), entry.getValue());
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.800 -0400", hash_original_method = "4517A8954B6715406427A020C27CB67E", hash_generated_method = "1C9E1E0FE38C7E37FC6E403A484003D1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    synchronized boolean isInStatementCache(String sql) {
        dsTaint.addTaint(sql);
        boolean var7E2D49726EEA56C7F241D41A55356BE7_1440586321 = (mCompiledQueries.get(sql) != null);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mCompiledQueries.get(sql) != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.801 -0400", hash_original_method = "1314F31979BFAD21CD00C204B07606A6", hash_generated_method = "F32F408215606CCA602A12FB3A04A5BB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    synchronized void releaseCompiledSqlObj(
            String sql, SQLiteCompiledSql compiledSql) {
        dsTaint.addTaint(sql);
        dsTaint.addTaint(compiledSql.dsTaint);
        {
            boolean var8E99D7E5C4B5DCBB0D60FA02E8F69444_1665334514 = (mCompiledQueries.get(sql) == compiledSql);
            {
                compiledSql.release();
            } //End block
            {
                compiledSql.releaseSqlStatement();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (mCompiledQueries.get(sql) == compiledSql) {
            //compiledSql.release();
        //} else {
            //compiledSql.releaseSqlStatement();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.801 -0400", hash_original_method = "8B250436E1E22A5062E1C40EC7B14D91", hash_generated_method = "BE30F23BDAEF1C31F58C2CAFE1841DBA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private synchronized int getCacheHitNum() {
        int var83B3BA20F9BFC7EB0E1E1591ACDA465E_1560330326 = (mCompiledQueries.hitCount());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mCompiledQueries.hitCount();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.801 -0400", hash_original_method = "043FFEAEE6F40014DEE09BB2B945E7E0", hash_generated_method = "950C5259E9B5D714B5BD7B7AF55735BE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private synchronized int getCacheMissNum() {
        int varC17CF02ACE8A376983C1F44782AFB555_679250563 = (mCompiledQueries.missCount());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mCompiledQueries.missCount();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.801 -0400", hash_original_method = "BE154D77F9855AEAD67382AAA286976D", hash_generated_method = "E6FC4272B80F04DCC1090F8297241ED6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private synchronized int getCachesize() {
        int var748F027D3AA39F0931CAA3B5AACCC414_1329083344 = (mCompiledQueries.size());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mCompiledQueries.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.801 -0400", hash_original_method = "5A385C2ADA8821372998CC92DEC1F051", hash_generated_method = "2CD44832D30E7717FFBB701CD0EE048E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void finalizeStatementLater(int id) {
        dsTaint.addTaint(id);
        {
            boolean var3A7D61B68AE823F6A30349D498C59A5C_1006334220 = (!isOpen());
        } //End collapsed parenthetic
        {
            {
                boolean var6EF4CC3269BBE912A7980A125C3F1053_2132176042 = (mClosedStatementIds.contains(id));
            } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.802 -0400", hash_original_method = "155C9044FA9A1FA1A4DC8EF486B34E28", hash_generated_method = "19761CF9999429AA0475E9E0039A66AD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean isInQueueOfStatementsToBeFinalized(int id) {
        dsTaint.addTaint(id);
        {
            boolean var3A7D61B68AE823F6A30349D498C59A5C_1952942090 = (!isOpen());
        } //End collapsed parenthetic
        {
            boolean var397B91F8D3CC72A0D7DEC2797A4D7920_920658062 = (mClosedStatementIds.contains(id));
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (!isOpen()) {
            //return true;
        //}
        //synchronized(mClosedStatementIds) {
            //return mClosedStatementIds.contains(id);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.802 -0400", hash_original_method = "D5552224B16C0AA0A430699F6F165E27", hash_generated_method = "1020BCF9F4A590F7380DC126DAB21592")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void closePendingStatements() {
        {
            boolean var3A7D61B68AE823F6A30349D498C59A5C_466792767 = (!isOpen());
            {
                mClosedStatementIds.clear();
            } //End block
        } //End collapsed parenthetic
        verifyLockOwner();
        ArrayList<Integer> list;
        list = new ArrayList<Integer>(mClosedStatementIds.size());
        {
            list.addAll(mClosedStatementIds);
            mClosedStatementIds.clear();
        } //End block
        int size;
        size = list.size();
        {
            int i;
            i = 0;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.802 -0400", hash_original_method = "22B8BC0E5EAC4A96A93EF5FA02A6A3E4", hash_generated_method = "3D594CCFD8E7ADD46230D7E187F0107B")
    @DSModeled(DSC.SAFE)
     ArrayList<Integer> getQueuedUpStmtList() {
        return (ArrayList<Integer>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mClosedStatementIds;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.802 -0400", hash_original_method = "D499CBE556FD537E95FAF5696995EFF8", hash_generated_method = "4BA24D08D7A3B9AF80D1DAB0BE23FDBC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean enableWriteAheadLogging() {
        {
            boolean varAC4B8D6BC6438967D655421106AB549D_1399799977 = (isReadOnly());
        } //End collapsed parenthetic
        lock();
        try 
        {
            {
                boolean varABBFB9ECCBC8DDD21300FC28D5111825_1925427014 = (mPath.equalsIgnoreCase(MEMORY_DB_PATH));
            } //End collapsed parenthetic
            {
                {
                    boolean var4202D0C449E97752DAE596DFB30FD8C9_185939307 = (Log.isLoggable(TAG, Log.DEBUG));
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
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.803 -0400", hash_original_method = "85CDE9F0FF49E9AFE9EC3200C3C50766", hash_generated_method = "59C1D7E3291A194997CDD317FA6320FB")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.803 -0400", hash_original_method = "E2BFDDA904D316A8C889FACE46B854F6", hash_generated_method = "99AA14455920A005CEBA58CBE44F8F77")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     SQLiteDatabase getDatabaseHandle(String sql) {
        dsTaint.addTaint(sql);
        {
            boolean varFECD86923E904CB3E1FAA0A6D1F256B6_1155210340 = (isPooledConnection());
            {
                {
                    boolean var66D7314A9B0C021F5A00D49AE7D90291_1026068634 = (isOpen() && !amIInTransaction());
                    {
                        SQLiteDatabase varE2C9FCA410E7F7B61882B5CB7004CC56_68440985 = (getParentDbConnObj().getDbConnection(sql));
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                SQLiteDatabase var02ED237752EF8A438556946D15E03391_177144907 = (getDbConnection(sql));
            } //End block
        } //End collapsed parenthetic
        return (SQLiteDatabase)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.803 -0400", hash_original_method = "3237D800F466D0C40C278AA082141CB7", hash_generated_method = "A97AAB6CC8EAB037695F6D9C4FF52BBF")
    @DSModeled(DSC.SAFE)
     SQLiteDatabase createPoolConnection(short connectionNum) {
        dsTaint.addTaint(connectionNum);
        SQLiteDatabase db;
        db = openDatabase(mPath, mFactory, mFlags, mErrorHandler, connectionNum);
        db.mParentConnObj = this;
        return (SQLiteDatabase)dsTaint.getTaint();
        // ---------- Original Method ----------
        //SQLiteDatabase db = openDatabase(mPath, mFactory, mFlags, mErrorHandler, connectionNum);
        //db.mParentConnObj = this;
        //return db;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.803 -0400", hash_original_method = "205546EE310EB84028F43CE65A7EC94C", hash_generated_method = "181A621A99192233CB9A1171B4BED252")
    @DSModeled(DSC.SAFE)
    private synchronized SQLiteDatabase getParentDbConnObj() {
        return (SQLiteDatabase)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mParentConnObj;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.804 -0400", hash_original_method = "D4EECEC449FC4C156499058FCB2B2B85", hash_generated_method = "A3D9C82DEED53332E42D8A74133791BC")
    @DSModeled(DSC.SAFE)
    private boolean isPooledConnection() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return this.mConnectionNum > 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.804 -0400", hash_original_method = "B485A553653CD27E64DDB9F45483F96A", hash_generated_method = "F511FE1D76BA6DB413D85D00182C3C3F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     SQLiteDatabase getDbConnection(String sql) {
        dsTaint.addTaint(sql);
        verifyDbIsOpen();
        {
            boolean varFECD86923E904CB3E1FAA0A6D1F256B6_1717889800 = (isPooledConnection());
        } //End collapsed parenthetic
        {
            boolean var02B777F5DE6966D0CEC634290EE91DB0_2125411105 = (amIInTransaction() || mConnectionPool == null);
            {
                {
                    boolean var4202D0C449E97752DAE596DFB30FD8C9_138368413 = (Log.isLoggable(TAG, Log.DEBUG));
                } //End collapsed parenthetic
                SQLiteDatabase varC55FD9D67637B674157D642330E21D66_981485661 = (mConnectionPool.get(sql));
            } //End block
        } //End collapsed parenthetic
        return (SQLiteDatabase)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.804 -0400", hash_original_method = "2B099A526E7EBE8C0C20DFBE797D578C", hash_generated_method = "AEF9100DF9D78E1B4D23761CC9589099")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void releaseDbConnection(SQLiteDatabase db) {
        dsTaint.addTaint(db.dsTaint);
        {
            boolean var2C78F6FD17175C7FB817368E27CF14DF_1517258159 = (!isOpen() || !db.isPooledConnection() || (db == this));
        } //End collapsed parenthetic
        {
            boolean var7061DF8A5335B809C796044C2A062407_1967723080 = (Log.isLoggable(TAG, Log.DEBUG));
            {
                Log.d(TAG, "releaseDbConnection threadid = " + Thread.currentThread().getId() +
                    ", releasing # " + db.mConnectionNum + ", " + getPath());
            } //End block
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.805 -0400", hash_original_method = "3A113450ED12D158C4D0FCF20D70CF45", hash_generated_method = "BD0BB09B262EE000379676CBCA903F1B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.805 -0400", hash_original_method = "40C4DE1C4808AAF54B97D30ED440E3DF", hash_generated_method = "BC57D84999571CB698138C40105D5DED")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public List<Pair<String, String>> getAttachedDbs() {
        {
            boolean var3A7D61B68AE823F6A30349D498C59A5C_1624235777 = (!isOpen());
        } //End collapsed parenthetic
        ArrayList<Pair<String, String>> attachedDbs;
        attachedDbs = new ArrayList<Pair<String, String>>();
        {
            attachedDbs.add(new Pair<String, String>("main", mPath));
        } //End block
        Cursor c;
        c = null;
        try 
        {
            c = rawQuery("pragma database_list;", null);
            {
                boolean var4D86B3BFFD03EEDEB3FCD4358BA0EB15_545072122 = (c.moveToNext());
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
        return (List<Pair<String, String>>)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.806 -0400", hash_original_method = "F327316761A478EA142E408A35654FE2", hash_generated_method = "B8C51D16B5D7ADFD5AC8416D16ABA74C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isDatabaseIntegrityOk() {
        verifyDbIsOpen();
        List<Pair<String, String>> attachedDbs;
        attachedDbs = null;
        try 
        {
            attachedDbs = getAttachedDbs();
            {
                throw new IllegalStateException("databaselist for: " + getPath() + " couldn't " +
                        "be retrieved. probably because the database is closed");
            } //End block
        } //End block
        catch (SQLiteException e)
        {
            attachedDbs = new ArrayList<Pair<String, String>>();
            attachedDbs.add(new Pair<String, String>("main", this.mPath));
        } //End block
        {
            int i;
            i = 0;
            boolean var09C6965D75337EEF5127BC42D107026B_1521355277 = (i < attachedDbs.size());
            {
                Pair<String, String> p;
                p = attachedDbs.get(i);
                SQLiteStatement prog;
                prog = null;
                try 
                {
                    prog = compileStatement("PRAGMA " + p.first + ".integrity_check(1);");
                    String rslt;
                    rslt = prog.simpleQueryForString();
                    {
                        boolean var00AD2367BACBE21804BEE535AC3728B3_471548241 = (!rslt.equalsIgnoreCase("ok"));
                    } //End collapsed parenthetic
                } //End block
                finally 
                {
                    prog.close();
                } //End block
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.806 -0400", hash_original_method = "8D335FE0EDA9A8017E889380A7A722CF", hash_generated_method = "465394614581A8C1B67CF928063C2A30")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void dbopen(String path, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(path);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.806 -0400", hash_original_method = "70E20853624884484C3836EF6F149A55", hash_generated_method = "AEF41D89590A3DB994D44B979DFFE2B3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void enableSqlTracing(String path, short connectionNum) {
        dsTaint.addTaint(path);
        dsTaint.addTaint(connectionNum);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.806 -0400", hash_original_method = "C8A96013E7D0E582573D33F32AE9CEB2", hash_generated_method = "888E7E34164CFAAFCA085753E32FD391")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void enableSqlProfiling(String path, short connectionNum) {
        dsTaint.addTaint(path);
        dsTaint.addTaint(connectionNum);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.806 -0400", hash_original_method = "D6178DAC9B84DE9466B1B633DF097ED8", hash_generated_method = "C5FDA87185BF1E268757E5691F250EAB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void native_setLocale(String loc, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(loc);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.806 -0400", hash_original_method = "94C6AE32C9A996CB80A0C1FADFD7D1F2", hash_generated_method = "DD511AC2E7C8E767FF8CE10815FC686A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int native_getDbLookaside() {
    	return DSUtils.UNKNOWN_INT; 
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.806 -0400", hash_original_method = "C4F8F8FDF64373EAEBE82B2B8F80D5C0", hash_generated_method = "E41EC564FB1F1FE64C7A6661197A5202")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private final void native_finalize(int statementId) {
        dsTaint.addTaint(statementId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.807 -0400", hash_original_method = "324F9A57AA3484DEBE48152EFBF728CA", hash_generated_method = "B653DB2F5256A4EDD68AAAA011F30982")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void native_setSqliteSoftHeapLimit(int softHeapLimit) {
        dsTaint.addTaint(softHeapLimit);
    }

    
    private static class DatabaseReentrantLock extends ReentrantLock {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.807 -0400", hash_original_method = "FF2E769A330F113FDEF775F7B9F0F4EF", hash_generated_method = "2A48ACEB1BF74D0EA02D069DE7F427DE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         DatabaseReentrantLock(boolean fair) {
            super(fair);
            dsTaint.addTaint(fair);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.807 -0400", hash_original_method = "1BB82FD0B3090B035906C5C5A5300D7F", hash_generated_method = "B5CB41C6AEAEA6D14B59620E7FF7EA3F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Thread getOwner() {
            Thread varC9564549D41E11755517D5E96A8D27A5_1778084690 = (super.getOwner());
            return (Thread)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return super.getOwner();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.807 -0400", hash_original_method = "0A30C3A8A16B3E36E180D94391681301", hash_generated_method = "B9E35285F80E63F4F2DA1D1070CA4852")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String getOwnerDescription() {
            Thread t;
            t = getOwner();
            {
                Object var13434BF7790281FD8A3754148489CA21_357195519 = (String.valueOf(t.getId()));
            } //End flattened ternary
            return dsTaint.getTaintString();
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
    
}


