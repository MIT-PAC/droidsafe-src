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
    private boolean mInnerTransactionIsSuccessful;
    private boolean mTransactionIsSuccessful;
    private SQLiteTransactionListener mTransactionListener;
    private boolean mTransactionUsingExecSql;
    private DatabaseReentrantLock mLock = new DatabaseReentrantLock(true);
    private long mLockAcquiredWallTime = 0L;
    private long mLockAcquiredThreadTime = 0L;
    private long mLastLockMessageTime = 0L;
    private Random mRandom = new Random();
    private String mLastSqlStatement = null;
    private long mTransStartTime;
    volatile int mNativeHandle = 0;
    private String mPath;
    private String mPathForLogs = null;
    private int mFlags;
    private CursorFactory mFactory;
    private WeakHashMap<SQLiteClosable, Object> mPrograms;
    private LruCache<String, SQLiteCompiledSql> mCompiledQueries;
    private boolean mCacheFullWarning;
    private Throwable mStackTrace;
    private ArrayList<Integer> mClosedStatementIds = new ArrayList<Integer>();
    private DatabaseErrorHandler mErrorHandler;
    volatile DatabaseConnectionPool mConnectionPool = null;
    short mConnectionNum;
    SQLiteDatabase mParentConnObj = null;
    private volatile boolean mHasAttachedDbs = false;
    private boolean mLockingEnabled = true;
    private ArrayList<Integer> mCustomFunctions =
            new ArrayList<Integer>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.419 -0400", hash_original_method = "ED994C20AB51232E6F0B83AA0494CFAA", hash_generated_method = "DCED0E4D354AC3C721F2BD49E5C871DF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private SQLiteDatabase(String path, CursorFactory factory, int flags,
            DatabaseErrorHandler errorHandler, short connectionNum) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(connectionNum);
        dsTaint.addTaint(path);
        dsTaint.addTaint(errorHandler.dsTaint);
        dsTaint.addTaint(factory.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("path should not be null");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.419 -0400", hash_original_method = "C15F9F532AF7810AA7D3562C5DDE29F6", hash_generated_method = "DD5057E838927BFB967C7C0F6926A697")
    @DSModeled(DSC.SAFE)
    synchronized String getLastSqlStatement() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mLastSqlStatement;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.420 -0400", hash_original_method = "3743AC991024775005FDBE1593E9891E", hash_generated_method = "EC074D5833AF12D021705A5B6DF20796")
    @DSModeled(DSC.SAFE)
    synchronized void setLastSqlStatement(String sql) {
        dsTaint.addTaint(sql);
        // ---------- Original Method ----------
        //mLastSqlStatement = sql;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.420 -0400", hash_original_method = "FF36C1ABFEC0F5F1C3DFBA7FD0941B56", hash_generated_method = "22A370DDF5A77FE1B11E1770B71A6553")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    synchronized void addSQLiteClosable(SQLiteClosable closable) {
        dsTaint.addTaint(closable.dsTaint);
        mPrograms.put(closable, null);
        // ---------- Original Method ----------
        //mPrograms.put(closable, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.420 -0400", hash_original_method = "030B4AA23DD4EAEE65D260C86C2A8B4C", hash_generated_method = "6B4733074909585A7CDE5AD27B00B35B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    synchronized void removeSQLiteClosable(SQLiteClosable closable) {
        dsTaint.addTaint(closable.dsTaint);
        mPrograms.remove(closable);
        // ---------- Original Method ----------
        //mPrograms.remove(closable);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.421 -0400", hash_original_method = "29F441CF35047DF9CBB0BC7BF2B03F36", hash_generated_method = "98D8BC714E6E25A927ED60C63D6D7DC7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onAllReferencesReleased() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean varF14FAC85BD81325B95F4F52AC5545E52_2037041959 = (isOpen());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.421 -0400", hash_original_method = "CD58BEDD0347A27F6CFE4EB9BEFDF2F6", hash_generated_method = "3768BA200FD1BE77DA916736C89A191C")
    @DSModeled(DSC.SAFE)
    public void setLockingEnabled(boolean lockingEnabled) {
        dsTaint.addTaint(lockingEnabled);
        // ---------- Original Method ----------
        //mLockingEnabled = lockingEnabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.421 -0400", hash_original_method = "6F1C3BA1763F74F7C0395D958A12A363", hash_generated_method = "3EE5C6657C638478CD9F042AD044BF04")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void onCorruption() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        EventLog.writeEvent(EVENT_DB_CORRUPT, mPath);
        mErrorHandler.onCorruption(this);
        // ---------- Original Method ----------
        //EventLog.writeEvent(EVENT_DB_CORRUPT, mPath);
        //mErrorHandler.onCorruption(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.422 -0400", hash_original_method = "6F6099DC841EA0266005BC3A83B18A96", hash_generated_method = "A1BC2A5C1FDAFDA767A90B92161C79FB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void lock(String sql) {
        dsTaint.addTaint(sql);
        lock(sql, false);
        // ---------- Original Method ----------
        //lock(sql, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.422 -0400", hash_original_method = "8D6DAA6963637C0BD50884518E0FF993", hash_generated_method = "31DA195A8CACA429F53CC674AB87F7FD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void lock() {
        lock(null, false);
        // ---------- Original Method ----------
        //lock(null, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.422 -0400", hash_original_method = "550218B4AE04D143508369398336F95D", hash_generated_method = "2CDA6908953DD9E7C484FB06AC491BE8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void lock(String sql, boolean forced) {
        dsTaint.addTaint(sql);
        dsTaint.addTaint(forced);
        {
            boolean var0236CB8C0F56FF35CDAF225C25DD9AAC_148832048 = (Thread.holdsLock(this));
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
                boolean varFAE68FF2C6BC8FEF8EA9B7CE8CF77E28_1922804816 = (mLock.getHoldCount() == 1);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.423 -0400", hash_original_method = "5F1F87633E052520A24DBAD554D491B1", hash_generated_method = "993B0F3F2A36649E79B8CF2BDCBA15D6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void lockForced() {
        lock(null, true);
        // ---------- Original Method ----------
        //lock(null, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.423 -0400", hash_original_method = "E1FDB470EFF9EA86A5AAC7A627D6955E", hash_generated_method = "C146D2DA69C1AAE5E9E577EF8086F327")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void lockForced(String sql) {
        dsTaint.addTaint(sql);
        lock(sql, true);
        // ---------- Original Method ----------
        //lock(sql, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.423 -0400", hash_original_method = "CB05AAFAB101AFFDD598174816C61BF7", hash_generated_method = "BC528085740A908CB5D46B3BE994F344")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void unlock() {
        {
            {
                boolean varFAE68FF2C6BC8FEF8EA9B7CE8CF77E28_17103889 = (mLock.getHoldCount() == 1);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.423 -0400", hash_original_method = "CA4E01B405088BC736DA3EA88D772AB0", hash_generated_method = "259184267FF7341796E112265B0626DB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void unlockForced() {
        {
            {
                boolean varFAE68FF2C6BC8FEF8EA9B7CE8CF77E28_1004663041 = (mLock.getHoldCount() == 1);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.424 -0400", hash_original_method = "15FB67C6B55CF4F17EB9E05703E68C1A", hash_generated_method = "B9B3CBC5BA742C17B5A67ACE846D7BA2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void checkLockHoldTime() {
        long elapsedTime;
        elapsedTime = SystemClock.elapsedRealtime();
        long lockedTime;
        lockedTime = elapsedTime - mLockAcquiredWallTime;
        {
            boolean var1C0B53C7CF19FA5142D07A08F2710172_646596905 = (lockedTime < LOCK_ACQUIRED_WARNING_TIME_IN_MS_ALWAYS_PRINT &&
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.424 -0400", hash_original_method = "36B8D50340D02900F098E44F066CFF12", hash_generated_method = "145909AA25037E1D599C021529CE7F8B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void beginTransaction() {
        beginTransaction(null , true);
        // ---------- Original Method ----------
        //beginTransaction(null , true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.424 -0400", hash_original_method = "E00D9BE9F4C6FCF885F8A6933F83E5B2", hash_generated_method = "00651A551214FF436836A41E2DCE0672")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void beginTransactionNonExclusive() {
        beginTransaction(null , false);
        // ---------- Original Method ----------
        //beginTransaction(null , false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.425 -0400", hash_original_method = "5BD04E9A01CA28B4B773A517F832DDF2", hash_generated_method = "A493AEC1CDF5757D2CCEA3D7BF99E747")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void beginTransactionWithListener(SQLiteTransactionListener transactionListener) {
        dsTaint.addTaint(transactionListener.dsTaint);
        beginTransaction(transactionListener, true);
        // ---------- Original Method ----------
        //beginTransaction(transactionListener, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.425 -0400", hash_original_method = "EB4000007896884F9C35346C5F5B9337", hash_generated_method = "BB071E6F32B509C23DDA2FBEFF7E61EA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void beginTransactionWithListenerNonExclusive(
            SQLiteTransactionListener transactionListener) {
        dsTaint.addTaint(transactionListener.dsTaint);
        beginTransaction(transactionListener, false);
        // ---------- Original Method ----------
        //beginTransaction(transactionListener, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.426 -0400", hash_original_method = "65C15EF02A1263C4153105EBF58851D9", hash_generated_method = "D59B371AE801F89C3624DBD8618A1F72")
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
                boolean varAF914129F00129CFDB57A245D2027B2F_1886021056 = (mLock.getHoldCount() > 1);
                {
                    {
                        String msg;
                        msg = "Cannot call beginTransaction between "
                            + "calling setTransactionSuccessful and endTransaction";
                        IllegalStateException e;
                        e = new IllegalStateException(msg);
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.426 -0400", hash_original_method = "94F2931FC5A304B6FE8748C95A17E4E3", hash_generated_method = "D0F6421C188CE47DDA68F28725AC732C")
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
                boolean varBAE3CD5B00DE7A95D508FDA3C102ACA4_1434222158 = (mLock.getHoldCount() != 1);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.427 -0400", hash_original_method = "CAD10DEB5A167AB4D97D078F2E23C48E", hash_generated_method = "BE84D393D9D2CCD3DBC922266834C834")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setTransactionSuccessful() {
        verifyDbIsOpen();
        {
            boolean varA9768C0684D8D9C3694FCFB8FF7505EA_2119287726 = (!mLock.isHeldByCurrentThread());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.427 -0400", hash_original_method = "6E9122EA7DDDF4A7FCE3C41AA714113C", hash_generated_method = "CF73288851BBFD6813B4967CAB3695EF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean inTransaction() {
        boolean var4C9D249B5D0C4B9126D436C907678D95_1287636061 = (mLock.getHoldCount() > 0 || mTransactionUsingExecSql);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mLock.getHoldCount() > 0 || mTransactionUsingExecSql;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.427 -0400", hash_original_method = "5CE93639419B30E518363E5F446309C9", hash_generated_method = "D129B44A8BCDD397B8A010385D24FA2E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    synchronized void setTransactionUsingExecSqlFlag() {
        {
            boolean var7061DF8A5335B809C796044C2A062407_1317993666 = (Log.isLoggable(TAG, Log.DEBUG));
        } //End collapsed parenthetic
        mTransactionUsingExecSql = true;
        // ---------- Original Method ----------
        //if (Log.isLoggable(TAG, Log.DEBUG)) {
            //Log.i(TAG, "found execSQL('begin transaction')");
        //}
        //mTransactionUsingExecSql = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.427 -0400", hash_original_method = "37864C1F3B8C10FDA9B20AB532C7EB78", hash_generated_method = "74BEAB793FA1556908ABF1B95F32399C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    synchronized void resetTransactionUsingExecSqlFlag() {
        {
            boolean var7061DF8A5335B809C796044C2A062407_1070540481 = (Log.isLoggable(TAG, Log.DEBUG));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.428 -0400", hash_original_method = "18141E27A4A6F223116C15568E4B1710", hash_generated_method = "CF740552A3855774EFDCA3B08923002C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    synchronized boolean amIInTransaction() {
        SQLiteDatabase db;
        boolean var81E049CAF652C4104E2A8460AB4F8005_387306478 = ((isPooledConnection()));
        db = mParentConnObj;
        db = this;
        boolean b;
        boolean var052869E209429152260CA7258506DF14_1601654961 = ((!db.inTransaction()));
        b = false;
        b = db.mTransactionUsingExecSql || db.mLock.isHeldByCurrentThread();
        {
            boolean var7061DF8A5335B809C796044C2A062407_1861533083 = (Log.isLoggable(TAG, Log.DEBUG));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.428 -0400", hash_original_method = "810FBEC1135AAF9FE09D5ED72E2387AC", hash_generated_method = "C6625BE8503CBB67A9FF5A580C257FDA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isDbLockedByCurrentThread() {
        boolean var652252C690B50A2DB779325937C5EC45_1614704454 = (mLock.isHeldByCurrentThread());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mLock.isHeldByCurrentThread();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.429 -0400", hash_original_method = "AFE51BB500BDF01026C5B1FB8FA31F68", hash_generated_method = "A105844A8D3536CF3EA1ABEFE89B2ACA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isDbLockedByOtherThreads() {
        boolean var8B5E8AE7202897DC44889938EB039DD8_761115867 = (!mLock.isHeldByCurrentThread() && mLock.isLocked());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return !mLock.isHeldByCurrentThread() && mLock.isLocked();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.429 -0400", hash_original_method = "275C631F29B5F92F82765C72693E08C5", hash_generated_method = "99A39E2B0EB60F5CB7C54970C002BF1B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public boolean yieldIfContended() {
        boolean var50D0DC9993A243282E70CF5F32C6948B_73356445 = (yieldIfContendedHelper(false ,
                -1 ));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return yieldIfContendedHelper(false ,
                //-1 );
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.429 -0400", hash_original_method = "E4D6EC2B61BA0EB36CC3F2E9664FDE2E", hash_generated_method = "88FED6A3E61C4690BB0EE5F59AC93CE9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean yieldIfContendedSafely() {
        boolean var1B84B5B6D1C3C26E51A46F65AE31AC61_713906638 = (yieldIfContendedHelper(true , -1 ));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return yieldIfContendedHelper(true , -1 );
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.429 -0400", hash_original_method = "EFD5966AFCC9629F634B854AE0830507", hash_generated_method = "DC79B1E1AD8601BC172FF22A1643CEA8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean yieldIfContendedSafely(long sleepAfterYieldDelay) {
        dsTaint.addTaint(sleepAfterYieldDelay);
        boolean var7C02635E5B9B12611B1E13892F20EFA4_246795169 = (yieldIfContendedHelper(true , sleepAfterYieldDelay));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return yieldIfContendedHelper(true , sleepAfterYieldDelay);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.430 -0400", hash_original_method = "82E88213585314141BE9DBE00F951B10", hash_generated_method = "C0E995795F58CF49A67A0440DE9B7962")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean yieldIfContendedHelper(boolean checkFullyYielded, long sleepAfterYieldDelay) {
        dsTaint.addTaint(sleepAfterYieldDelay);
        dsTaint.addTaint(checkFullyYielded);
        {
            boolean var5B3E72ED3F61C626DE29DC9592245606_686867171 = (mLock.getQueueLength() == 0);
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
                boolean var42788A8E0393F9B1C6C2ADCA7B153774_1113120510 = (this.isDbLockedByCurrentThread());
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(
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
                    boolean var741E584956C4EDE940BCF4AF8237BB37_500641453 = (mLock.getQueueLength() == 0);
                } //End collapsed parenthetic
            } //End block
        } //End block
        beginTransactionWithListener(transactionListener);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.430 -0400", hash_original_method = "2BF74CD6834BBADBF27F65464DB83499", hash_generated_method = "8319EB40AF23FBCD93375E03E6E554FA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public Map<String, String> getSyncedTables() {
        Map<String, String> var4060FB244D581D65A120565B61887C18_298241346 = (new HashMap<String, String>(0));
        return (Map<String, String>)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.432 -0400", hash_original_method = "4DBAD15B0F91A1B1A1A509E057CF6487", hash_generated_method = "E5E3F3F52E73407BAA7EC38312C0C891")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setJournalMode(final String dbPath, final String mode) {
        dsTaint.addTaint(dbPath);
        dsTaint.addTaint(mode);
        {
            boolean varC8B178D4C16CE00624EBB098975A6C60_1035900212 = (dbPath.equalsIgnoreCase(MEMORY_DB_PATH) || isReadOnly());
        } //End collapsed parenthetic
        String s;
        s = DatabaseUtils.stringForQuery(this, "PRAGMA journal_mode=" + mode, null);
        {
            boolean varAE0C33F5A2193A82451F284839087E0B_579484945 = (!s.equalsIgnoreCase(mode));
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

    
        public static SQLiteDatabase create(CursorFactory factory) {
        return openDatabase(MEMORY_DB_PATH, factory, CREATE_IF_NECESSARY);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.432 -0400", hash_original_method = "F057ECACA47F2E639159F91F6FF25AA8", hash_generated_method = "71F8576AEE0E5AC8BBFB1D8AD441CB49")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void close() {
        {
            boolean var3A7D61B68AE823F6A30349D498C59A5C_1457523409 = (!isOpen());
        } //End collapsed parenthetic
        {
            boolean var7061DF8A5335B809C796044C2A062407_1565540884 = (Log.isLoggable(TAG, Log.DEBUG));
        } //End collapsed parenthetic
        lock();
        try 
        {
            {
                boolean varC984E2D68DED4A73C5D827F4E91A6961_723841722 = (!isOpen());
            } //End collapsed parenthetic
            closeClosable();
            closePendingStatements();
            releaseCustomFunctions();
            closeDatabase();
            {
                {
                    boolean var4202D0C449E97752DAE596DFB30FD8C9_896442281 = (Log.isLoggable(TAG, Log.DEBUG));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.433 -0400", hash_original_method = "2CD800231F10038F3799DBDAB26BCEE1", hash_generated_method = "7A2CE5394FB2A662A5A9B4731A6CFD0F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void closeClosable() {
        deallocCachedSqlStatements();
        Iterator<Map.Entry<SQLiteClosable, Object>> iter;
        iter = mPrograms.entrySet().iterator();
        {
            boolean varADABAFEBBAB7E585DD903333BD7F20A8_1848232359 = (iter.hasNext());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.433 -0400", hash_original_method = "9BCDA7BC5AA364A3676019422CD41F65", hash_generated_method = "8ABD0BF4556CC0E27597E563C355B0E1")
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
                boolean var8492AE2C695A56B730381A28B8BA3F6D_362676651 = (iter.hasNext());
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
                    boolean var264DD9E27C37EF07E76F2B3412A8E5A6_2137471034 = (mClosedStatementIds.contains(stmtId));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.434 -0400", hash_original_method = "4C27B28311EC4401B9E72044B34DEE3C", hash_generated_method = "4E905500CC20EB86329796A43360CF14")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void dbclose() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.434 -0400", hash_original_method = "6AE38120A6AE17DCB302700D83D76664", hash_generated_method = "1BB9450C5510A95776543E789C3727B4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
                if (DroidSafeAndroidRuntime.control) throw new SQLiteException("failed to add custom function " + name);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.434 -0400", hash_original_method = "9C15AE424A91890D11F6682C678B396E", hash_generated_method = "50161A2B5EEDF4E3FB63E914F11F3AA4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void releaseCustomFunctions() {
        {
            {
                int i;
                i = 0;
                boolean var36D8B34DC42E2CA6FF5F9433DF425473_240758750 = (i < mCustomFunctions.size());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.435 -0400", hash_original_method = "545ECF4B8C2C387E458104596CE82C8C", hash_generated_method = "5F058EF5EFB73B3141C8CB5AE6054474")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int native_addCustomFunction(String name, int numArgs, CustomFunction function) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(numArgs);
        dsTaint.addTaint(function.dsTaint);
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.435 -0400", hash_original_method = "D641D8CC9687EF2DFB0D6D88DDBFEE42", hash_generated_method = "CBC2FA46F60041F75820FDBBE9335D1B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void native_releaseCustomFunction(int function) {
        dsTaint.addTaint(function);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.435 -0400", hash_original_method = "8BA60C4A4A322F100A535BB125C59B40", hash_generated_method = "1D3A1382278A42BD9F6C9F4DA3F65523")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getVersion() {
        int var5ED7B897E4829D15D8A8C1ABA4EB6C66_1416302281 = (((Long) DatabaseUtils.longForQuery(this, "PRAGMA user_version;", null)).intValue());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return ((Long) DatabaseUtils.longForQuery(this, "PRAGMA user_version;", null)).intValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.435 -0400", hash_original_method = "4E3C0E9170C91236F101F38522569C45", hash_generated_method = "A42703B3062B667133B44D07629B5A9B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setVersion(int version) {
        dsTaint.addTaint(version);
        execSQL("PRAGMA user_version = " + version);
        // ---------- Original Method ----------
        //execSQL("PRAGMA user_version = " + version);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.436 -0400", hash_original_method = "01DC63CC6FF3C1462DC7069F3072C18D", hash_generated_method = "DDC08115CBA650BD1E463DAB6374A1FE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long getMaximumSize() {
        long pageCount;
        pageCount = DatabaseUtils.longForQuery(this, "PRAGMA max_page_count;", null);
        long varCE811D607639101FC1388FCB35FFCD9C_683058388 = (pageCount * getPageSize());
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //long pageCount = DatabaseUtils.longForQuery(this, "PRAGMA max_page_count;", null);
        //return pageCount * getPageSize();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.436 -0400", hash_original_method = "B09E5ED21834BC66E218E9635E49257B", hash_generated_method = "CE2E846CFFF08E9288EA7BE576A95017")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long setMaximumSize(long numBytes) {
        dsTaint.addTaint(numBytes);
        long pageSize;
        pageSize = getPageSize();
        long numPages;
        numPages = numBytes / pageSize;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.436 -0400", hash_original_method = "677D214086B645E86B85D4E2A88CD9F6", hash_generated_method = "A6A847B529C682DA06DFA90B0CA1ACDF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long getPageSize() {
        long varA97F1A3236E9434F0519DFDCD56746B7_229604305 = (DatabaseUtils.longForQuery(this, "PRAGMA page_size;", null));
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return DatabaseUtils.longForQuery(this, "PRAGMA page_size;", null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.436 -0400", hash_original_method = "CE3FCE5D2F41E0E2EF73A0D49E90DE3F", hash_generated_method = "8171951BC91C121272909CF84F9F5853")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setPageSize(long numBytes) {
        dsTaint.addTaint(numBytes);
        execSQL("PRAGMA page_size = " + numBytes);
        // ---------- Original Method ----------
        //execSQL("PRAGMA page_size = " + numBytes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.437 -0400", hash_original_method = "0ECCFA53F5E6749CB5B25917802B1822", hash_generated_method = "222866D1F23EA3D01A97FC11EB7E6203")
    @DSModeled(DSC.SAFE)
    @Deprecated
    public void markTableSyncable(String table, String deletedTable) {
        dsTaint.addTaint(table);
        dsTaint.addTaint(deletedTable);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.437 -0400", hash_original_method = "9A70316D056BE2F7590F6370A4F13111", hash_generated_method = "8E8D3CDF999FE9A1521050B04AB7F016")
    @DSModeled(DSC.SAFE)
    @Deprecated
    public void markTableSyncable(String table, String foreignKey, String updateTable) {
        dsTaint.addTaint(updateTable);
        dsTaint.addTaint(table);
        dsTaint.addTaint(foreignKey);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.437 -0400", hash_original_method = "C05C583B39FD005C236783082CBB4E55", hash_generated_method = "EE1B8B96BF3F707E5DD309F8F63DF36F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SQLiteStatement compileStatement(String sql) throws SQLException {
        dsTaint.addTaint(sql);
        verifyDbIsOpen();
        SQLiteStatement varFCD79AC5E4B43AA80FBB89D72D540D7C_1546951081 = (new SQLiteStatement(this, sql, null));
        return (SQLiteStatement)dsTaint.getTaint();
        // ---------- Original Method ----------
        //verifyDbIsOpen();
        //return new SQLiteStatement(this, sql, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.437 -0400", hash_original_method = "5E1B6C3D7A97420E0A4D0244321FA1D0", hash_generated_method = "ECEA33437853F505A09EBBC3BEAEF861")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Cursor query(boolean distinct, String table, String[] columns,
            String selection, String[] selectionArgs, String groupBy,
            String having, String orderBy, String limit) {
        dsTaint.addTaint(limit);
        dsTaint.addTaint(groupBy);
        dsTaint.addTaint(orderBy);
        dsTaint.addTaint(selectionArgs[0]);
        dsTaint.addTaint(columns[0]);
        dsTaint.addTaint(having);
        dsTaint.addTaint(table);
        dsTaint.addTaint(selection);
        dsTaint.addTaint(distinct);
        Cursor var7C414AEB20F5FB2360D6E5CB08187A58_1180633190 = (queryWithFactory(null, distinct, table, columns, selection, selectionArgs,
                groupBy, having, orderBy, limit));
        return (Cursor)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return queryWithFactory(null, distinct, table, columns, selection, selectionArgs,
                //groupBy, having, orderBy, limit);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.438 -0400", hash_original_method = "2EC2F985341F70A15977A4E5B8D54ACE", hash_generated_method = "82EBE7C0D0810777C3652FDA1505767D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Cursor queryWithFactory(CursorFactory cursorFactory,
            boolean distinct, String table, String[] columns,
            String selection, String[] selectionArgs, String groupBy,
            String having, String orderBy, String limit) {
        dsTaint.addTaint(limit);
        dsTaint.addTaint(groupBy);
        dsTaint.addTaint(orderBy);
        dsTaint.addTaint(selectionArgs[0]);
        dsTaint.addTaint(columns[0]);
        dsTaint.addTaint(having);
        dsTaint.addTaint(table);
        dsTaint.addTaint(cursorFactory.dsTaint);
        dsTaint.addTaint(selection);
        dsTaint.addTaint(distinct);
        verifyDbIsOpen();
        String sql;
        sql = SQLiteQueryBuilder.buildQueryString(
                distinct, table, columns, selection, groupBy, having, orderBy, limit);
        Cursor var6AB9B6B49A722F92B3A5A22EA8B9D717_1849335586 = (rawQueryWithFactory(
                cursorFactory, sql, selectionArgs, findEditTable(table)));
        return (Cursor)dsTaint.getTaint();
        // ---------- Original Method ----------
        //verifyDbIsOpen();
        //String sql = SQLiteQueryBuilder.buildQueryString(
                //distinct, table, columns, selection, groupBy, having, orderBy, limit);
        //return rawQueryWithFactory(
                //cursorFactory, sql, selectionArgs, findEditTable(table));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.438 -0400", hash_original_method = "823CC97B8BCC24B1EEF8A14CAC46F9D2", hash_generated_method = "4FEE629157F157C41326D3E9B6E44963")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Cursor query(String table, String[] columns, String selection,
            String[] selectionArgs, String groupBy, String having,
            String orderBy) {
        dsTaint.addTaint(groupBy);
        dsTaint.addTaint(orderBy);
        dsTaint.addTaint(selectionArgs[0]);
        dsTaint.addTaint(columns[0]);
        dsTaint.addTaint(having);
        dsTaint.addTaint(table);
        dsTaint.addTaint(selection);
        Cursor varA8C341C7A429E9C213E46E4C78AB940C_1712276580 = (query(false, table, columns, selection, selectionArgs, groupBy,
                having, orderBy, null ));
        return (Cursor)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return query(false, table, columns, selection, selectionArgs, groupBy,
                //having, orderBy, null );
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.438 -0400", hash_original_method = "C821013CE8C43126ED02ADCC7264C8CF", hash_generated_method = "EC4D7FE3E1008CA2751D37435D30262F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Cursor query(String table, String[] columns, String selection,
            String[] selectionArgs, String groupBy, String having,
            String orderBy, String limit) {
        dsTaint.addTaint(limit);
        dsTaint.addTaint(groupBy);
        dsTaint.addTaint(orderBy);
        dsTaint.addTaint(selectionArgs[0]);
        dsTaint.addTaint(columns[0]);
        dsTaint.addTaint(having);
        dsTaint.addTaint(table);
        dsTaint.addTaint(selection);
        Cursor varF34315A8B7B3D3CA39FF264BDB8D8F18_682507953 = (query(false, table, columns, selection, selectionArgs, groupBy,
                having, orderBy, limit));
        return (Cursor)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return query(false, table, columns, selection, selectionArgs, groupBy,
                //having, orderBy, limit);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.439 -0400", hash_original_method = "76B8F97A589187A4837E14E72F2396A8", hash_generated_method = "7893F99387FB4704F703E9A658D5C338")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Cursor rawQuery(String sql, String[] selectionArgs) {
        dsTaint.addTaint(sql);
        dsTaint.addTaint(selectionArgs[0]);
        Cursor var1110AB9FBFF6DA86B6E52347B34B12CC_2114714901 = (rawQueryWithFactory(null, sql, selectionArgs, null));
        return (Cursor)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return rawQueryWithFactory(null, sql, selectionArgs, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.439 -0400", hash_original_method = "42A0891F7A1C512D8BE3F37EFD1DF118", hash_generated_method = "3DC6FA9EA87911BA9AAD8A7607122166")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Cursor rawQueryWithFactory(
            CursorFactory cursorFactory, String sql, String[] selectionArgs,
            String editTable) {
        dsTaint.addTaint(sql);
        dsTaint.addTaint(selectionArgs[0]);
        dsTaint.addTaint(editTable);
        dsTaint.addTaint(cursorFactory.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.439 -0400", hash_original_method = "7C0142B65481E16DCFB76B6C0BD0AF64", hash_generated_method = "B52173D91A3AE9B1FEB66B5CA6409FBD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long insert(String table, String nullColumnHack, ContentValues values) {
        dsTaint.addTaint(values.dsTaint);
        dsTaint.addTaint(nullColumnHack);
        dsTaint.addTaint(table);
        try 
        {
            long varF52CAAA7AE26F4FA45ED0B3A37BD4379_1059547421 = (insertWithOnConflict(table, nullColumnHack, values, CONFLICT_NONE));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.439 -0400", hash_original_method = "2F31CF2160A369C3FFDDD251C32C2819", hash_generated_method = "8767C5EE8F75FD8444D66159414915A5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long insertOrThrow(String table, String nullColumnHack, ContentValues values) throws SQLException {
        dsTaint.addTaint(values.dsTaint);
        dsTaint.addTaint(nullColumnHack);
        dsTaint.addTaint(table);
        long var22A9FB7F2C81F3272F2370661FA4E896_1244037462 = (insertWithOnConflict(table, nullColumnHack, values, CONFLICT_NONE));
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return insertWithOnConflict(table, nullColumnHack, values, CONFLICT_NONE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.440 -0400", hash_original_method = "4277B606CBD58106C26DEC9C427B6DC5", hash_generated_method = "681FEB956E58CCD8EBE6654C5356848B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long replace(String table, String nullColumnHack, ContentValues initialValues) {
        dsTaint.addTaint(initialValues.dsTaint);
        dsTaint.addTaint(nullColumnHack);
        dsTaint.addTaint(table);
        try 
        {
            long var0B6B818F8EACB8B15016A791818A7376_1823375761 = (insertWithOnConflict(table, nullColumnHack, initialValues,
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.449 -0400", hash_original_method = "006F0DF267AA18E88B2010DFB3E66CC0", hash_generated_method = "FF5A1594DECA2DE9C036A42EEDDB1018")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long replaceOrThrow(String table, String nullColumnHack,
            ContentValues initialValues) throws SQLException {
        dsTaint.addTaint(initialValues.dsTaint);
        dsTaint.addTaint(nullColumnHack);
        dsTaint.addTaint(table);
        long varDB0C7A87625C42614968DA8DC2DF448A_268852596 = (insertWithOnConflict(table, nullColumnHack, initialValues,
                CONFLICT_REPLACE));
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return insertWithOnConflict(table, nullColumnHack, initialValues,
                //CONFLICT_REPLACE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.466 -0400", hash_original_method = "4E696CAC31E62C2450813F66BA0D3688", hash_generated_method = "E78A7A68549F70113C9CABC8E5D3ADF0")
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
        boolean varC4E695B9AF881ABFE2BBBDD7E96404B3_717654997 = ((initialValues != null && initialValues.size() > 0));
        size = initialValues.size();
        size = 0;
        {
            bindArgs = new Object[size];
            int i;
            i = 0;
            {
                Iterator<String> var7BDF90D9B8E9B13A02DACE54E7C220FA_1882915655 = (initialValues.keySet()).iterator();
                var7BDF90D9B8E9B13A02DACE54E7C220FA_1882915655.hasNext();
                String colName = var7BDF90D9B8E9B13A02DACE54E7C220FA_1882915655.next();
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
            long varF67BA8A1C61A250EDBDBDA7E8358FE23_1502404456 = (statement.executeInsert());
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
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.467 -0400", hash_original_method = "D469CE4575675C51277223F3405EF96C", hash_generated_method = "0231B138D2FEFF4376E4B2EFB86B85D2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int delete(String table, String whereClause, String[] whereArgs) {
        dsTaint.addTaint(whereClause);
        dsTaint.addTaint(whereArgs[0]);
        dsTaint.addTaint(table);
        SQLiteStatement statement;
        statement = new SQLiteStatement(this, "DELETE FROM " + table +
                (!TextUtils.isEmpty(whereClause) ? " WHERE " + whereClause : ""), whereArgs);//DSFIXME:  CODE0008: Nested ternary operator in expression
        try 
        {
            int varA87545DC17687AF507150C89477E60CF_2048078931 = (statement.executeUpdateDelete());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.467 -0400", hash_original_method = "1314F51B10A849824DA60B76F1896857", hash_generated_method = "31F07AD99300A215EEE0CE194F96563F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int update(String table, ContentValues values, String whereClause, String[] whereArgs) {
        dsTaint.addTaint(whereClause);
        dsTaint.addTaint(values.dsTaint);
        dsTaint.addTaint(whereArgs[0]);
        dsTaint.addTaint(table);
        int varFBFAC28FFEFC923D6AC3F8D0EB28BD4D_306571956 = (updateWithOnConflict(table, values, whereClause, whereArgs, CONFLICT_NONE));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return updateWithOnConflict(table, values, whereClause, whereArgs, CONFLICT_NONE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.489 -0400", hash_original_method = "42C896B54A7E0C71455DEE45B9C2EA0D", hash_generated_method = "40B298708F0A1CB97CDECE4CC7047838")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int updateWithOnConflict(String table, ContentValues values,
            String whereClause, String[] whereArgs, int conflictAlgorithm) {
        dsTaint.addTaint(conflictAlgorithm);
        dsTaint.addTaint(whereClause);
        dsTaint.addTaint(values.dsTaint);
        dsTaint.addTaint(whereArgs[0]);
        dsTaint.addTaint(table);
        {
            boolean var7F872E5B929E1733A7225AB743560CA0_1287115486 = (values == null || values.size() == 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Empty values");
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
            Iterator<String> varB154976CB623862478E6AF7F69897F5A_454711393 = (values.keySet()).iterator();
            varB154976CB623862478E6AF7F69897F5A_454711393.hasNext();
            String colName = varB154976CB623862478E6AF7F69897F5A_454711393.next();
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
            boolean varC582A3B0C0625E2C5B62147799474972_912528191 = (!TextUtils.isEmpty(whereClause));
            {
                sql.append(" WHERE ");
                sql.append(whereClause);
            } //End block
        } //End collapsed parenthetic
        SQLiteStatement statement;
        statement = new SQLiteStatement(this, sql.toString(), bindArgs);
        try 
        {
            int varA87545DC17687AF507150C89477E60CF_2042218257 = (statement.executeUpdateDelete());
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
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.489 -0400", hash_original_method = "25D536EB53093A036E9DAE961A0D97E6", hash_generated_method = "96B64BA18D4E08F456ED8092330EA90A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void execSQL(String sql) throws SQLException {
        dsTaint.addTaint(sql);
        executeSql(sql, null);
        // ---------- Original Method ----------
        //executeSql(sql, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.490 -0400", hash_original_method = "C75317BDB75C741C750B94F218C97882", hash_generated_method = "76CD76F58EE02FFA66418D31393F731A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void execSQL(String sql, Object[] bindArgs) throws SQLException {
        dsTaint.addTaint(bindArgs[0].dsTaint);
        dsTaint.addTaint(sql);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Empty bindArgs");
        } //End block
        executeSql(sql, bindArgs);
        // ---------- Original Method ----------
        //if (bindArgs == null) {
            //throw new IllegalArgumentException("Empty bindArgs");
        //}
        //executeSql(sql, bindArgs);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.490 -0400", hash_original_method = "9265893CFBC7535112C5207F5F702C1B", hash_generated_method = "5857C7B09E08947125425CA39E215A11")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int executeSql(String sql, Object[] bindArgs) throws SQLException {
        dsTaint.addTaint(bindArgs[0].dsTaint);
        dsTaint.addTaint(sql);
        {
            boolean varE0925AF52400942DD3DAF202DD99E6E6_1859507950 = (DatabaseUtils.getSqlStatementType(sql) == DatabaseUtils.STATEMENT_ATTACH);
            {
                disableWriteAheadLogging();
                mHasAttachedDbs = true;
            } //End block
        } //End collapsed parenthetic
        SQLiteStatement statement;
        statement = new SQLiteStatement(this, sql, bindArgs);
        try 
        {
            int varA87545DC17687AF507150C89477E60CF_1243810142 = (statement.executeUpdateDelete());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.491 -0400", hash_original_method = "2C203F91898576B00C917F0CD42A518A", hash_generated_method = "2CDDD9E480FDCD77D03DC39B5812871B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void finalize() throws Throwable {
        try 
        {
            {
                boolean var5A39A3129B438981221C0F68BD29C416_294734803 = (isOpen());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.491 -0400", hash_original_method = "B8251338AB8EB8352A863E35E41B939B", hash_generated_method = "D98CC13008AE01DB6858EE1C04B28D02")
    @DSModeled(DSC.SAFE)
    public boolean isReadOnly() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mFlags & OPEN_READ_MASK) == OPEN_READONLY;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.491 -0400", hash_original_method = "61E254D128D08D9B7DD7C5EEB86B883E", hash_generated_method = "3AFB15541FF3C139751B5ECCFED5D2AF")
    @DSModeled(DSC.SAFE)
    public boolean isOpen() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mNativeHandle != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.492 -0400", hash_original_method = "4C8276EC0F604B529F31103A74E610FF", hash_generated_method = "D05E49AE9A16ED943B9B60D8EB564104")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean needUpgrade(int newVersion) {
        dsTaint.addTaint(newVersion);
        boolean var11347AA24D61D50D87B1A9EDCAB47EB3_744952471 = (newVersion > getVersion());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return newVersion > getVersion();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.493 -0400", hash_original_method = "F177C5B02553C0E0327F321BDDCEAFD5", hash_generated_method = "861188383326855BD567EDA11AC30010")
    @DSModeled(DSC.SAFE)
    public final String getPath() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mPath;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.494 -0400", hash_original_method = "0D21C1E893B83D945127726B58A78BA2", hash_generated_method = "6E05F8294B93B0A9A093148BF055C56C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void logTimeStat(String sql, long beginMillis) {
        dsTaint.addTaint(beginMillis);
        dsTaint.addTaint(sql);
        {
            logTimeStat(sql, beginMillis, null);
        } //End block
        // ---------- Original Method ----------
        //if (ENABLE_DB_SAMPLE) {
            //logTimeStat(sql, beginMillis, null);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.495 -0400", hash_original_method = "8ED8142AF940938322CF345006300B7D", hash_generated_method = "91D78EEBD27923447154D6E44178BA1F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void logTimeStat(String sql, long beginMillis, String prefix) {
        dsTaint.addTaint(beginMillis);
        dsTaint.addTaint(sql);
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
                boolean varFD197FF6228B8320A1307AF1741CB740_769080608 = (mRandom.nextInt(100) >= samplePercent);
            } //End collapsed parenthetic
        } //End block
        {
            sql = prefix + sql;
        } //End block
        {
            boolean var15761F9B8A55BA7056472F2EB9923186_449002694 = (sql.length() > QUERY_LOG_SQL_LENGTH);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.496 -0400", hash_original_method = "BAC313652C0D08E8CD159DBA09E31731", hash_generated_method = "1F2C7F6C7031617ADB23C00CE77AAEC6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String getPathForLogs() {
        {
            boolean var9CB372F979D264EF8BD68817AF56AFA9_980532042 = (mPath.indexOf('@') == -1);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.496 -0400", hash_original_method = "3FAFCE8DADACDA6029D741D00EA768C4", hash_generated_method = "7113AC37E17CA0F8B3E4ABA3A0508DAB")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.497 -0400", hash_original_method = "82F89F6027C136BD18FB9173DDA585C3", hash_generated_method = "CEE5E6DDD51E91AFD0D1F2EE8B1B1CE0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void verifyDbIsOpen() {
        {
            boolean var3A7D61B68AE823F6A30349D498C59A5C_857055197 = (!isOpen());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.497 -0400", hash_original_method = "2ABE5777D3030A58042EA8C11F6A64FB", hash_generated_method = "A57FD1BF612E821D9A2E99B2EF180745")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void verifyLockOwner() {
        verifyDbIsOpen();
        {
            boolean var165EEFEEA133626155A410875EC632D2_2080902160 = (mLockingEnabled && !isDbLockedByCurrentThread());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.528 -0400", hash_original_method = "1F50605826534D1D8A189D3DC15DE94F", hash_generated_method = "396991185D7AA64DBCF7A710E879AE8D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    synchronized void addToCompiledQueries(
            String sql, SQLiteCompiledSql compiledStatement) {
        dsTaint.addTaint(sql);
        dsTaint.addTaint(compiledStatement.dsTaint);
        {
            boolean var44AC47AE1DA995B439F70F98684BE351_1248860883 = (mCompiledQueries.get(sql) != null);
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
                    Iterator<String> var42DDB4F3462F514FC2F124A94345BBD5_747087177 = (mCompiledQueries.snapshot().keySet()).iterator();
                    var42DDB4F3462F514FC2F124A94345BBD5_747087177.hasNext();
                    String s = var42DDB4F3462F514FC2F124A94345BBD5_747087177.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.550 -0400", hash_original_method = "CE0C87ACDC099813F3D6D588DE2B56CF", hash_generated_method = "BED0FEA9BC9E47EFA8CF6D32DAA6047C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    synchronized void deallocCachedSqlStatements() {
        {
            Iterator<SQLiteCompiledSql> var84DFBFDB238B53D2223BB28209C480FC_1316881824 = (mCompiledQueries.snapshot().values()).iterator();
            var84DFBFDB238B53D2223BB28209C480FC_1316881824.hasNext();
            SQLiteCompiledSql compiledSql = var84DFBFDB238B53D2223BB28209C480FC_1316881824.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.557 -0400", hash_original_method = "A3F9326C17119FEC2A90D0724FE482CF", hash_generated_method = "C13863B5563191245432BB19AF82F5A9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    synchronized SQLiteCompiledSql getCompiledStatementForSql(String sql) {
        dsTaint.addTaint(sql);
        SQLiteCompiledSql var68C1802207867E1F50B1B8E04371E33E_1540990395 = (mCompiledQueries.get(sql));
        return (SQLiteCompiledSql)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mCompiledQueries.get(sql);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.576 -0400", hash_original_method = "986DCF2E02788969CC84FF6D84C81E71", hash_generated_method = "7F5B1E2F9E4231F959E67F66357162FD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setMaxSqlCacheSize(int cacheSize) {
        dsTaint.addTaint(cacheSize);
        {
            LruCache<String, SQLiteCompiledSql> oldCompiledQueries;
            oldCompiledQueries = mCompiledQueries;
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(
                        "expected value between 0 and " + MAX_SQL_CACHE_SIZE);
            } //End block
            {
                boolean var551279D6CBA810FBA7717E31CAA6F559_1074605174 = (oldCompiledQueries != null && cacheSize < oldCompiledQueries.maxSize());
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("cannot set cacheSize to a value less than the "
                        + "value set with previous setMaxSqlCacheSize() call.");
                } //End block
            } //End collapsed parenthetic
            mCompiledQueries = new LruCache<String, SQLiteCompiledSql>(cacheSize) {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.558 -0400", hash_original_method = "0287FECCFAEBE5DF6977A7998D9D230B", hash_generated_method = "720A5FEBC2E7B061F63F808BB7A72404")
                //DSFIXME:  CODE0002: Requires DSC value to be set
                @Override
                protected void entryRemoved(boolean evicted, String key, SQLiteCompiledSql oldValue,
                        SQLiteCompiledSql newValue) {
                    dsTaint.addTaint(newValue.dsTaint);
                    dsTaint.addTaint(oldValue.dsTaint);
                    dsTaint.addTaint(evicted);
                    dsTaint.addTaint(key);
                    verifyLockOwner();
                    oldValue.releaseIfNotInUse();
                    // ---------- Original Method ----------
                    //verifyLockOwner();
                    //oldValue.releaseIfNotInUse();
                }
};
            {
                {
                    Iterator<Map.Entry<String, SQLiteCompiledSql>> varA959B61746A0B8CD10E93A362DE7BDD9_1996880214 = (oldCompiledQueries.snapshot().entrySet()).iterator();
                    varA959B61746A0B8CD10E93A362DE7BDD9_1996880214.hasNext();
                    Map.Entry<String, SQLiteCompiledSql> entry = varA959B61746A0B8CD10E93A362DE7BDD9_1996880214.next();
                    {
                        mCompiledQueries.put(entry.getKey(), entry.getValue());
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.576 -0400", hash_original_method = "4517A8954B6715406427A020C27CB67E", hash_generated_method = "A653D5E0594A499BCA2BFE860E6C12CA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    synchronized boolean isInStatementCache(String sql) {
        dsTaint.addTaint(sql);
        boolean var7E2D49726EEA56C7F241D41A55356BE7_1133658918 = (mCompiledQueries.get(sql) != null);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mCompiledQueries.get(sql) != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.577 -0400", hash_original_method = "1314F31979BFAD21CD00C204B07606A6", hash_generated_method = "C8C7F27F9B30E8D85A7C0A3049E465C2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    synchronized void releaseCompiledSqlObj(
            String sql, SQLiteCompiledSql compiledSql) {
        dsTaint.addTaint(sql);
        dsTaint.addTaint(compiledSql.dsTaint);
        {
            boolean var8E99D7E5C4B5DCBB0D60FA02E8F69444_853849045 = (mCompiledQueries.get(sql) == compiledSql);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.577 -0400", hash_original_method = "8B250436E1E22A5062E1C40EC7B14D91", hash_generated_method = "1471A917504BAD3105B23E7808478938")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private synchronized int getCacheHitNum() {
        int var83B3BA20F9BFC7EB0E1E1591ACDA465E_998728447 = (mCompiledQueries.hitCount());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mCompiledQueries.hitCount();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.577 -0400", hash_original_method = "043FFEAEE6F40014DEE09BB2B945E7E0", hash_generated_method = "DBB14395A43659A48838BDF32579630D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private synchronized int getCacheMissNum() {
        int varC17CF02ACE8A376983C1F44782AFB555_1499404912 = (mCompiledQueries.missCount());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mCompiledQueries.missCount();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.577 -0400", hash_original_method = "BE154D77F9855AEAD67382AAA286976D", hash_generated_method = "31585E48FB1D38828AF27F67D96EF9E7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private synchronized int getCachesize() {
        int var748F027D3AA39F0931CAA3B5AACCC414_2025811293 = (mCompiledQueries.size());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mCompiledQueries.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.578 -0400", hash_original_method = "5A385C2ADA8821372998CC92DEC1F051", hash_generated_method = "35815E95FA9DB68BD44C6A01EBDA1119")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void finalizeStatementLater(int id) {
        dsTaint.addTaint(id);
        {
            boolean var3A7D61B68AE823F6A30349D498C59A5C_883097544 = (!isOpen());
        } //End collapsed parenthetic
        {
            {
                boolean var6EF4CC3269BBE912A7980A125C3F1053_215890539 = (mClosedStatementIds.contains(id));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.578 -0400", hash_original_method = "155C9044FA9A1FA1A4DC8EF486B34E28", hash_generated_method = "7D9F383FFEB531609D6D3B15ED9A164C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean isInQueueOfStatementsToBeFinalized(int id) {
        dsTaint.addTaint(id);
        {
            boolean var3A7D61B68AE823F6A30349D498C59A5C_2068035148 = (!isOpen());
        } //End collapsed parenthetic
        {
            boolean var397B91F8D3CC72A0D7DEC2797A4D7920_27082688 = (mClosedStatementIds.contains(id));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.579 -0400", hash_original_method = "D5552224B16C0AA0A430699F6F165E27", hash_generated_method = "CAD9368B579A562DF1986455714A0F47")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void closePendingStatements() {
        {
            boolean var3A7D61B68AE823F6A30349D498C59A5C_1485641115 = (!isOpen());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.579 -0400", hash_original_method = "22B8BC0E5EAC4A96A93EF5FA02A6A3E4", hash_generated_method = "507D0E680C1746F08DF116E2B707D0D0")
    @DSModeled(DSC.SAFE)
     ArrayList<Integer> getQueuedUpStmtList() {
        return (ArrayList<Integer>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mClosedStatementIds;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.581 -0400", hash_original_method = "D499CBE556FD537E95FAF5696995EFF8", hash_generated_method = "DF94AB8351D9187E4DF3279838696ACC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean enableWriteAheadLogging() {
        {
            boolean varAC4B8D6BC6438967D655421106AB549D_1963156800 = (isReadOnly());
        } //End collapsed parenthetic
        lock();
        try 
        {
            {
                boolean varABBFB9ECCBC8DDD21300FC28D5111825_1845322241 = (mPath.equalsIgnoreCase(MEMORY_DB_PATH));
            } //End collapsed parenthetic
            {
                {
                    boolean var4202D0C449E97752DAE596DFB30FD8C9_2118245011 = (Log.isLoggable(TAG, Log.DEBUG));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.582 -0400", hash_original_method = "85CDE9F0FF49E9AFE9EC3200C3C50766", hash_generated_method = "70E63D6A2D912EF1266464B719F40617")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.583 -0400", hash_original_method = "E2BFDDA904D316A8C889FACE46B854F6", hash_generated_method = "48FAF5FBBB211FABEE74696A8D4CCE82")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     SQLiteDatabase getDatabaseHandle(String sql) {
        dsTaint.addTaint(sql);
        {
            boolean varFECD86923E904CB3E1FAA0A6D1F256B6_1612917831 = (isPooledConnection());
            {
                {
                    boolean var66D7314A9B0C021F5A00D49AE7D90291_1729467523 = (isOpen() && !amIInTransaction());
                    {
                        SQLiteDatabase varE2C9FCA410E7F7B61882B5CB7004CC56_188489861 = (getParentDbConnObj().getDbConnection(sql));
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                SQLiteDatabase var02ED237752EF8A438556946D15E03391_1599111463 = (getDbConnection(sql));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.583 -0400", hash_original_method = "3237D800F466D0C40C278AA082141CB7", hash_generated_method = "8BDA9E13ABE1663E5920DC69D4A354E3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.584 -0400", hash_original_method = "205546EE310EB84028F43CE65A7EC94C", hash_generated_method = "BA0E7CFF64024169865668896673CEE5")
    @DSModeled(DSC.SAFE)
    private synchronized SQLiteDatabase getParentDbConnObj() {
        return (SQLiteDatabase)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mParentConnObj;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.584 -0400", hash_original_method = "D4EECEC449FC4C156499058FCB2B2B85", hash_generated_method = "24BF0BD6D92954147A5A76BD4CCE942E")
    @DSModeled(DSC.SAFE)
    private boolean isPooledConnection() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return this.mConnectionNum > 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.584 -0400", hash_original_method = "B485A553653CD27E64DDB9F45483F96A", hash_generated_method = "464B8CA581F231C8AEECD3C6849899C7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     SQLiteDatabase getDbConnection(String sql) {
        dsTaint.addTaint(sql);
        verifyDbIsOpen();
        {
            boolean varFECD86923E904CB3E1FAA0A6D1F256B6_1867436127 = (isPooledConnection());
        } //End collapsed parenthetic
        {
            boolean var02B777F5DE6966D0CEC634290EE91DB0_2015724867 = (amIInTransaction() || mConnectionPool == null);
            {
                {
                    boolean var4202D0C449E97752DAE596DFB30FD8C9_1854414871 = (Log.isLoggable(TAG, Log.DEBUG));
                } //End collapsed parenthetic
                SQLiteDatabase varC55FD9D67637B674157D642330E21D66_1717041079 = (mConnectionPool.get(sql));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.585 -0400", hash_original_method = "2B099A526E7EBE8C0C20DFBE797D578C", hash_generated_method = "6401ABDA8284F3703A649A5DB5B6DAAD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void releaseDbConnection(SQLiteDatabase db) {
        dsTaint.addTaint(db.dsTaint);
        {
            boolean var2C78F6FD17175C7FB817368E27CF14DF_1373927420 = (!isOpen() || !db.isPooledConnection() || (db == this));
        } //End collapsed parenthetic
        {
            boolean var7061DF8A5335B809C796044C2A062407_190581848 = (Log.isLoggable(TAG, Log.DEBUG));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.586 -0400", hash_original_method = "40C4DE1C4808AAF54B97D30ED440E3DF", hash_generated_method = "1A3A177CC7D1766F6694E94A21309B08")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public List<Pair<String, String>> getAttachedDbs() {
        {
            boolean var3A7D61B68AE823F6A30349D498C59A5C_785308806 = (!isOpen());
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
                boolean var4D86B3BFFD03EEDEB3FCD4358BA0EB15_338121064 = (c.moveToNext());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.588 -0400", hash_original_method = "F327316761A478EA142E408A35654FE2", hash_generated_method = "C0DB72150D45BC08EFF2C6854A4211FD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isDatabaseIntegrityOk() {
        verifyDbIsOpen();
        List<Pair<String, String>> attachedDbs;
        attachedDbs = null;
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
            int i;
            i = 0;
            boolean var09C6965D75337EEF5127BC42D107026B_750663724 = (i < attachedDbs.size());
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
                        boolean var00AD2367BACBE21804BEE535AC3728B3_910388533 = (!rslt.equalsIgnoreCase("ok"));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.589 -0400", hash_original_method = "8D335FE0EDA9A8017E889380A7A722CF", hash_generated_method = "0D1A0EDE018AC040C536B92369EEF761")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void dbopen(String path, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(path);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.590 -0400", hash_original_method = "70E20853624884484C3836EF6F149A55", hash_generated_method = "6998D770585511E668D3EBE959CF7099")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void enableSqlTracing(String path, short connectionNum) {
        dsTaint.addTaint(connectionNum);
        dsTaint.addTaint(path);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.590 -0400", hash_original_method = "C8A96013E7D0E582573D33F32AE9CEB2", hash_generated_method = "8BE53F1946C91085E38F10102F7638BE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void enableSqlProfiling(String path, short connectionNum) {
        dsTaint.addTaint(connectionNum);
        dsTaint.addTaint(path);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.590 -0400", hash_original_method = "D6178DAC9B84DE9466B1B633DF097ED8", hash_generated_method = "59817F0B5D62D598C50731B85EC69252")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void native_setLocale(String loc, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(loc);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.590 -0400", hash_original_method = "94C6AE32C9A996CB80A0C1FADFD7D1F2", hash_generated_method = "B995AAA8D002762EC3D013CBD5DF4F92")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int native_getDbLookaside() {
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.591 -0400", hash_original_method = "C4F8F8FDF64373EAEBE82B2B8F80D5C0", hash_generated_method = "C12DFCEA16120169B465C32A953F3970")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private final void native_finalize(int statementId) {
        dsTaint.addTaint(statementId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.591 -0400", hash_original_method = "324F9A57AA3484DEBE48152EFBF728CA", hash_generated_method = "1244C762DCF3BA789652C0CFADE9B45B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void native_setSqliteSoftHeapLimit(int softHeapLimit) {
        dsTaint.addTaint(softHeapLimit);
    }

    
    private static class DatabaseReentrantLock extends ReentrantLock {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.591 -0400", hash_original_method = "FF2E769A330F113FDEF775F7B9F0F4EF", hash_generated_method = "788979AFF04C50B427D17216E568D150")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         DatabaseReentrantLock(boolean fair) {
            super(fair);
            dsTaint.addTaint(fair);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.592 -0400", hash_original_method = "1BB82FD0B3090B035906C5C5A5300D7F", hash_generated_method = "02E85768AD2BFF47D43B8EB89CFCA99F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Thread getOwner() {
            Thread varC9564549D41E11755517D5E96A8D27A5_1156923363 = (super.getOwner());
            return (Thread)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return super.getOwner();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.592 -0400", hash_original_method = "0A30C3A8A16B3E36E180D94391681301", hash_generated_method = "A702C2C902252ED09A22B5AFAD8D122D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String getOwnerDescription() {
            Thread t;
            t = getOwner();
            {
                Object var13434BF7790281FD8A3754148489CA21_888239245 = (String.valueOf(t.getId()));
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
    private static final int LOCK_WARNING_WINDOW_IN_MS = 20000;
    private static final int LOCK_ACQUIRED_WARNING_TIME_IN_MS = 300;
    private static final int LOCK_ACQUIRED_WARNING_THREAD_TIME_IN_MS = 100;
    private static final int LOCK_ACQUIRED_WARNING_TIME_IN_MS_ALWAYS_PRINT = 2000;
    private static final int SLEEP_AFTER_YIELD_QUANTUM = 1000;
    private static final Pattern EMAIL_IN_DB_PATTERN = Pattern.compile("[\\w\\.\\-]+@[\\w\\.\\-]+");
    private static int sQueryLogTimeInMillis = 0;
    private static final int QUERY_LOG_SQL_LENGTH = 64;
    private static final String COMMIT_SQL = "COMMIT;";
    private static final String BEGIN_SQL = "BEGIN;";
    static final String GET_LOCK_LOG_PREFIX = "GETLOCK:";
    private static int sBlockSize = 0;
    private static final int DEFAULT_SQL_CACHE_SIZE = 25;
    public static final int MAX_SQL_CACHE_SIZE = 100;
    private static final String MEMORY_DB_PATH = ":memory:";
    private static ArrayList<WeakReference<SQLiteDatabase>> mActiveDatabases =
            new ArrayList<WeakReference<SQLiteDatabase>>();
    private static final long LOCK_WAIT_PERIOD = 30L;
}

