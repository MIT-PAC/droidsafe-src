package android.database.sqlite;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
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
import droidsafe.runtime.DroidSafeAndroidRuntime;

public class SQLiteDatabase extends SQLiteClosable {
    
    static public int releaseMemory() {
        return DSUtils.UNKNOWN_INT;
    }

    /**
     * Open the database according to the flags {@link #OPEN_READWRITE}
     * {@link #OPEN_READONLY} {@link #CREATE_IF_NECESSARY} and/or {@link #NO_LOCALIZED_COLLATORS}.
     *
     * <p>Sets the locale of the database to the  the system's current locale.
     * Call {@link #setLocale} if you would like something else.</p>
     *
     * @param path to database file to open and/or create
     * @param factory an optional factory class that is called to instantiate a
     *            cursor when query is called, or null for default
     * @param flags to control database access mode
     * @return the newly opened database
     * @throws SQLiteException if the database cannot be opened
     */
    @DSSource({DSSourceKind.DATABASE_INFORMATION})
    @DSSpec(DSCat.DATABASE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.138 -0500", hash_original_method = "561EAEA4DA554DB918DDA9176F70DC13", hash_generated_method = "4942BCB41767BFD0488622F1AB1E7C65")
    
public static SQLiteDatabase openDatabase(String path, CursorFactory factory, int flags) {
        return openDatabase(path, factory, flags, new DefaultDatabaseErrorHandler());
    }

    /**
     * Open the database according to the flags {@link #OPEN_READWRITE}
     * {@link #OPEN_READONLY} {@link #CREATE_IF_NECESSARY} and/or {@link #NO_LOCALIZED_COLLATORS}.
     *
     * <p>Sets the locale of the database to the  the system's current locale.
     * Call {@link #setLocale} if you would like something else.</p>
     *
     * <p>Accepts input param: a concrete instance of {@link DatabaseErrorHandler} to be
     * used to handle corruption when sqlite reports database corruption.</p>
     *
     * @param path to database file to open and/or create
     * @param factory an optional factory class that is called to instantiate a
     *            cursor when query is called, or null for default
     * @param flags to control database access mode
     * @param errorHandler the {@link DatabaseErrorHandler} obj to be used to handle corruption
     * when sqlite reports database corruption
     * @return the newly opened database
     * @throws SQLiteException if the database cannot be opened
     */
    @DSSource({DSSourceKind.DATABASE_INFORMATION})
    @DSSpec(DSCat.DATABASE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.141 -0500", hash_original_method = "528BDC0ADA7690DDC947E526A8FE7C65", hash_generated_method = "A09B47EAA0844CC09CC8C7D4BD955518")
    
public static SQLiteDatabase openDatabase(String path, CursorFactory factory, int flags,
            DatabaseErrorHandler errorHandler) {
        SQLiteDatabase sqliteDatabase = openDatabase(path, factory, flags, errorHandler,
                (short) 0 /* the main connection handle */);

        // set sqlite pagesize to mBlockSize
        if (sBlockSize == 0) {
            // TODO: "/data" should be a static final String constant somewhere. it is hardcoded
            // in several places right now.
            sBlockSize = new StatFs("/data").getBlockSize();
        }
        sqliteDatabase.setPageSize(sBlockSize);
        sqliteDatabase.setJournalMode(path, "TRUNCATE");

        // add this database to the list of databases opened in this process
        synchronized(mActiveDatabases) {
            mActiveDatabases.add(new WeakReference<SQLiteDatabase>(sqliteDatabase));
        }
        return sqliteDatabase;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.144 -0500", hash_original_method = "320878150F5912B8D3148CDF6639FAEA", hash_generated_method = "7A60C4CE5D61D8E31F425BBC36F9236C")
    @DSVerified
    @DSSpec(DSCat.DATABASE)
private static SQLiteDatabase openDatabase(String path, CursorFactory factory, int flags,
            DatabaseErrorHandler errorHandler, short connectionNum) {
        SQLiteDatabase db = new SQLiteDatabase(path, factory, flags, errorHandler, connectionNum);
        try {
            if (Log.isLoggable(TAG, Log.DEBUG)) {
                Log.i(TAG, "opening the db : " + path);
            }
            // Open the database.
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

    /**
     * Equivalent to openDatabase(file.getPath(), factory, CREATE_IF_NECESSARY).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.146 -0500", hash_original_method = "18158E65D0AEC4A5DB9A049F4B71DBBA", hash_generated_method = "54E9E3271F913909401DE9AF04EFF66C")
    
public static SQLiteDatabase openOrCreateDatabase(File file, CursorFactory factory) {
        return openOrCreateDatabase(file.getPath(), factory);
    }

    /**
     * Equivalent to openDatabase(path, factory, CREATE_IF_NECESSARY).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.148 -0500", hash_original_method = "8E5844484F4010F8E8AD05E1ADE2036F", hash_generated_method = "9A64F576CDEAEC3C965553C2321EC500")
    
public static SQLiteDatabase openOrCreateDatabase(String path, CursorFactory factory) {
        return openDatabase(path, factory, CREATE_IF_NECESSARY);
    }

    /**
     * Equivalent to openDatabase(path, factory, CREATE_IF_NECESSARY, errorHandler).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.151 -0500", hash_original_method = "0BAAB26A173C80C4AB32C48250BFAADD", hash_generated_method = "28D90A01EDCDC7248932D45C65058399")
    
public static SQLiteDatabase openOrCreateDatabase(String path, CursorFactory factory,
            DatabaseErrorHandler errorHandler) {
        return openDatabase(path, factory, CREATE_IF_NECESSARY, errorHandler);
    }

    /**
     * Create a memory backed SQLite database.  Its contents will be destroyed
     * when the database is closed.
     *
     * <p>Sets the locale of the database to the  the system's current locale.
     * Call {@link #setLocale} if you would like something else.</p>
     *
     * @param factory an optional factory class that is called to instantiate a
     *            cursor when query is called
     * @return a SQLiteDatabase object, or null if the database can't be created
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.157 -0500", hash_original_method = "2152343F8E4566351BAC450E2FDC2439", hash_generated_method = "DA737C37C93FB8D29E98C7A36A44D339")
    
public static SQLiteDatabase create(CursorFactory factory) {
        // This is a magic string with special meaning for SQLite.
        return openDatabase(MEMORY_DB_PATH, factory, CREATE_IF_NECESSARY);
    }

    /**
     * Finds the name of the first table, which is editable.
     *
     * @param tables a list of tables
     * @return the first table listed
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.209 -0500", hash_original_method = "EBECA09284F826B6433735F733F3B876", hash_generated_method = "A694CEC14543A8469D0018C61A57F36E")
    
public static String findEditTable(String tables) {
        if (!TextUtils.isEmpty(tables)) {
            // find the first word terminated by either a space or a comma
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

    /**
     * this method is used to collect data about ALL open databases in the current process.
     * bugreport is a user of this data.
     */
    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.DATABASE_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.347 -0500", hash_original_method = "3A113450ED12D158C4D0FCF20D70CF45", hash_generated_method = "0B529B82E97155F413BEA91A60BA3599")
    
static ArrayList<DbStats> getDbStats() {
        ArrayList<DbStats> dbStatsList = new ArrayList<DbStats>();
        // make a local copy of mActiveDatabases - so that this method is not competing
        // for synchronization lock on mActiveDatabases
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
                // get SQLITE_DBSTATUS_LOOKASIDE_USED for the db
                int lookasideUsed = db.native_getDbLookaside();

                // get the lastnode of the dbname
                String path = db.getPath();
                int indx = path.lastIndexOf("/");
                String lastnode = path.substring((indx != -1) ? ++indx : 0);

                // get list of attached dbs and for each db, get its size and pagesize
                List<Pair<String, String>> attachedDbs = db.getAttachedDbs();
                if (attachedDbs == null) {
                    continue;
                }
                for (int i = 0; i < attachedDbs.size(); i++) {
                    Pair<String, String> p = attachedDbs.get(i);
                    long pageCount = DatabaseUtils.longForQuery(db, "PRAGMA " + p.first
                            + ".page_count;", null);

                    // first entry in the attached db list is always the main database
                    // don't worry about prefixing the dbname with "main"
                    String dbName;
                    if (i == 0) {
                        dbName = lastnode;
                    } else {
                        // lookaside is only relevant for the main db
                        lookasideUsed = 0;
                        dbName = "  (attached) " + p.first;
                        // if the attached db has a path, attach the lastnode from the path to above
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
                // if there are pooled connections, return the cache stats for them also.
                // while we are trying to query the pooled connections for stats, some other thread
                // could be disabling conneciton pool. so, grab a reference to the connection pool.
                DatabaseConnectionPool connPool = db.mConnectionPool;
                if (connPool != null) {
                    for (SQLiteDatabase pDb : connPool.getConnectionList()) {
                        dbStatsList.add(new DbStats("(pooled # " + pDb.mConnectionNum + ") "
                                + lastnode, 0, 0, 0, pDb.getCacheHitNum(),
                                pDb.getCacheMissNum(), pDb.getCachesize()));
                    }
                }
            } catch (SQLiteException e) {
                // ignore. we don't care about exceptions when we are taking adb
                // bugreport!
            }
        }
        return dbStatsList;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:40.885 -0500", hash_original_field = "7D7A6B75C84CD231DBD8FB8809DF1E53", hash_generated_field = "B031AA443BF0B15D9BA58FE3D3C788E6")

    private static final String TAG = "SQLiteDatabase";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:40.888 -0500", hash_original_field = "82CF004C853E1B06728168E7E982369E", hash_generated_field = "3548346B1EB3CE378E747DF13DAF2E94")

    private static final boolean ENABLE_DB_SAMPLE = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:40.891 -0500", hash_original_field = "9A71799CAFFC1325F05B9F52D1BD7027", hash_generated_field = "7C746BEBD1F52CCE281BC2AE78043C31")

    private static final int EVENT_DB_OPERATION = 52000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:40.893 -0500", hash_original_field = "488011DDC2EB1E18D16EBBB2DE3C6585", hash_generated_field = "9435052DF2978607705FE1A674B3B476")

    private static final int EVENT_DB_CORRUPT = 75004;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:40.897 -0500", hash_original_field = "8A6966684E41D9B14F15F122B2A3702A", hash_generated_field = "6ACE960014CD61A451D7EE7739783E1D")

    /**
     *  When a constraint violation occurs, an immediate ROLLBACK occurs,
     * thus ending the current transaction, and the command aborts with a
     * return code of SQLITE_CONSTRAINT. If no transaction is active
     * (other than the implied transaction that is created on every command)
     *  then this algorithm works the same as ABORT.
     */
    public static final int CONFLICT_ROLLBACK = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:40.899 -0500", hash_original_field = "079FC57F688DBB1016E903422F56CA67", hash_generated_field = "39B42E823E1997DA6D833E1BBD40FA58")

    public static final int CONFLICT_ABORT = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:40.902 -0500", hash_original_field = "0B269D30E2DD5AF943934202532F0F28", hash_generated_field = "335E697F888616CE067B72F214C1BC32")

    public static final int CONFLICT_FAIL = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:40.904 -0500", hash_original_field = "EB6FD4E2CE0598FAF6B2496A24B7D478", hash_generated_field = "46745826C06802839FCD46D51B439306")

    public static final int CONFLICT_IGNORE = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:40.907 -0500", hash_original_field = "6F6A5295C125B7C161987D45AF3E3EE9", hash_generated_field = "E863D6302F78EAED37A44DA0ED539003")

    public static final int CONFLICT_REPLACE = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:40.909 -0500", hash_original_field = "E7F81AA8DB5F7794517B473D5CF87810", hash_generated_field = "8969586D204DC9CDF495FFB0724623A9")

    public static final int CONFLICT_NONE = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:40.912 -0500", hash_original_field = "F56E439B7E650E2BDBEF5E71E425D1C9", hash_generated_field = "CEB6E56BB51D4EFBAE585B39DC049839")

    private static final String[] CONFLICT_VALUES = new String[]
            {"", " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE "};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:40.914 -0500", hash_original_field = "B4603B5EBC47F4C7776E69B8EB9AE151", hash_generated_field = "307B7E85D5D9B51588F8134872D28FA2")

    public static final int SQLITE_MAX_LIKE_PATTERN_LENGTH = 50000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:40.917 -0500", hash_original_field = "3E09FB28BE61818286A0031B19EA7A0B", hash_generated_field = "629E71001BC03CF7522CF9DF396F3CD0")

    public static final int OPEN_READWRITE = 0x00000000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:40.919 -0500", hash_original_field = "55B679F5ECB0D2A083EEBD37E64CB9A3", hash_generated_field = "75EEEADC871103D7830A534A5FACE796")

    /**
     * Flag for {@link #openDatabase} to open the database for reading only.
     * This is the only reliable way to open a database if the disk may be full.
     */
    public static final int OPEN_READONLY = 0x00000001;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:40.921 -0500", hash_original_field = "00DCBB85B99CC171B018CB945E812C6A", hash_generated_field = "5187312D154815C7B5E63606C7E8136A")

    private static final int OPEN_READ_MASK = 0x00000001;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:40.924 -0500", hash_original_field = "95BDAB4DF408D93129E82F2EEC8E7E6D", hash_generated_field = "E33E7E96994BCE5516EBFCA9D3B1A5DF")

    /**
     * Flag for {@link #openDatabase} to open the database without support for localized collators.
     *
     * {@more} This causes the collator <code>LOCALIZED</code> not to be created.
     * You must be consistent when using this flag to use the setting the database was
     * created with.  If this is set, {@link #setLocale} will do nothing.
     */
    public static final int NO_LOCALIZED_COLLATORS = 0x00000010;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:40.927 -0500", hash_original_field = "E75EEA6940B8B09047C2FCCC7D9CAD57", hash_generated_field = "D42DBE66645440568FCBF1D69EEB23FB")

    /**
     * Flag for {@link #openDatabase} to create the database file if it does not already exist.
     */
    public static final int CREATE_IF_NECESSARY = 0x10000000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:40.946 -0500", hash_original_field = "BDEE5513A75B584147A20DD5ABFB6268", hash_generated_field = "5F3EBF0D99CF8D45153C5E5D0DC48DCC")

    // unless run command adb shell setprop log.tag.Database VERBOSE
    private static final int LOCK_WARNING_WINDOW_IN_MS = 20000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:40.949 -0500", hash_original_field = "C0AFE85F46C3B3AE14D27C1D9EBE1D4A", hash_generated_field = "77D4EFADB5F65862A8907D645B6665E9")

    private static final int LOCK_ACQUIRED_WARNING_TIME_IN_MS = 300;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:40.951 -0500", hash_original_field = "02B58FFB5634C7D5796FBF4FEBEDC6E3", hash_generated_field = "A15D7DDE2E5CA3854E9FBBCADF643DF0")

    private static final int LOCK_ACQUIRED_WARNING_THREAD_TIME_IN_MS = 100;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:40.954 -0500", hash_original_field = "D151D864731810CB2DBC5CDF408B5465", hash_generated_field = "C09CEC99CA0E20EA63872D1D54E55D2E")

    private static final int LOCK_ACQUIRED_WARNING_TIME_IN_MS_ALWAYS_PRINT = 2000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:40.957 -0500", hash_original_field = "DEA622746E1885322628E03F1AB30D90", hash_generated_field = "79E0F0AE9DE5E092336F50A45B4F8E1C")

    private static final int SLEEP_AFTER_YIELD_QUANTUM = 1000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:40.959 -0500", hash_original_field = "2311837FF4B5C5BC4F80F3C8471AF0CD", hash_generated_field = "7B563E7D4C8E3D4A4FE8D0B6A60C2D47")

    // potentially logging them.
    private static final Pattern EMAIL_IN_DB_PATTERN = Pattern.compile("[\\w\\.\\-]+@[\\w\\.\\-]+");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:40.964 -0500", hash_original_field = "6A2FE6D618E0E2DD0165A2EDE2F66C62", hash_generated_field = "3A871894D2566BB38BEC6FC405BE24B4")

    // slow/frequent queries during development.  Always log queries
    // which take (by default) 500ms+; shorter queries are sampled
    // accordingly.  Commit statements, which are typically slow, are
    // logged together with the most recently executed SQL statement,
    // for disambiguation.  The 500ms value is configurable via a
    // SystemProperty, but developers actively debugging database I/O
    // should probably use the regular log tunable,
    // LOG_SLOW_QUERIES_PROPERTY, defined below.
    private static int sQueryLogTimeInMillis = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:40.966 -0500", hash_original_field = "EE01B17BDB1F64685AA134211A6DAFF5", hash_generated_field = "7148D851E918ABFB8558501AAF276067")

    private static final int QUERY_LOG_SQL_LENGTH = 64;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:40.968 -0500", hash_original_field = "3C555CA159C39DB8E64C945CB85E6E4B", hash_generated_field = "6E2686DCB15E3EED77BA00F0CDFF3560")

    private static final String COMMIT_SQL = "COMMIT;";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:40.971 -0500", hash_original_field = "BC61EFD7B66F2A13C205569FABFEB20B", hash_generated_field = "6F4F9F4CA4122F0E0B63ADF311633E3F")

    private static final String BEGIN_SQL = "BEGIN;";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:40.986 -0500", hash_original_field = "D33C60B45AA669435C35A340E454F1B3", hash_generated_field = "9C64A8F802B61D5649BBF316CBBA8E61")

    // lock acquistions of the database.
    /* package */ static final String GET_LOCK_LOG_PREFIX = "GETLOCK:";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:40.991 -0500", hash_original_field = "1C9F42A7DB62374677B0E89ED0BFBA41", hash_generated_field = "51F4D205C63830AACD25F15FCA50EBDA")

    private static int sBlockSize = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.007 -0500", hash_original_field = "6B673F9AC6997BDABC2612407B8EEC42", hash_generated_field = "3DC1596E29EDB016C413E70C0C6823BE")

    private static final int DEFAULT_SQL_CACHE_SIZE = 25;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.011 -0500", hash_original_field = "2D75794BBC010F21DD652682554893B5", hash_generated_field = "FEBE70CE9042F617C4B8B12131A1C6AA")

    public static final int MAX_SQL_CACHE_SIZE = 100;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.031 -0500", hash_original_field = "F3906B41B56AD36295813E8DFCBC7EC9", hash_generated_field = "076429DC648CA31B53EA5479063A01DC")

    private static final String MEMORY_DB_PATH = ":memory:";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.037 -0500", hash_original_field = "E47E46817091B1502466FCBC77893180", hash_generated_field = "6C1DD837716F02A5B85D056ED49553B5")

    private static ArrayList<WeakReference<SQLiteDatabase>> mActiveDatabases =
            new ArrayList<WeakReference<SQLiteDatabase>>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.061 -0500", hash_original_field = "AD46826DDDF5F12579BDBC5F911CEA2A", hash_generated_field = "87A9BD3D7700EA6364DB461A232CAEB6")

    private static final long LOCK_WAIT_PERIOD = 30L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:40.929 -0500", hash_original_field = "DF1A619F0F2680C3049F44256871A763", hash_generated_field = "E6F3C271A629BAC41CCEDAC12FDB1F26")

    /**
     * Indicates whether the most-recently started transaction has been marked as successful.
     */
    private boolean mInnerTransactionIsSuccessful;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:40.932 -0500", hash_original_field = "14A5FADBC891F24D621AD8E86052D06D", hash_generated_field = "6128EACBB7FB1B535A59BE78E36968AA")

    private boolean mTransactionIsSuccessful;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:40.934 -0500", hash_original_field = "816292A8206345CD571FD2D27703AD02", hash_generated_field = "793A3AAAFBEB0F437207EF8CF58BE261")

    private SQLiteTransactionListener mTransactionListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:40.936 -0500", hash_original_field = "9517BA9355B79AB29733920D332A1E94", hash_generated_field = "2A25F85A83E5F358C0E921DE63F86FF2")

    private boolean mTransactionUsingExecSql;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:40.939 -0500", hash_original_field = "6C09D4B8F05940F8C6BDB92D473C1F87", hash_generated_field = "F912814B4E1DAAFDC17C50234EB3FC06")

    private final DatabaseReentrantLock mLock = new DatabaseReentrantLock(true);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:40.941 -0500", hash_original_field = "957848C8AE718E636FD1494C840F908F", hash_generated_field = "D440BCD52A102185E811EA93A644CB1C")

    private long mLockAcquiredWallTime = 0L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:40.944 -0500", hash_original_field = "E227F7F685B0CB810D0791096ACBEC13", hash_generated_field = "F25F6124FA463B622FD2DD5ABA3051C7")

    private long mLockAcquiredThreadTime = 0L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:40.961 -0500", hash_original_field = "7EDBAB32C5F4C15F9585DE4F0DA6AAAF", hash_generated_field = "5D29D9D368D28B86CEE0F5B707514CDA")

    private long mLastLockMessageTime = 0L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:40.974 -0500", hash_original_field = "AAF1AFBF965F32CB2933765EF7007549", hash_generated_field = "E26D41E197237C24B0E74C0394AEDF83")

    private final Random mRandom = new Random();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:40.976 -0500", hash_original_field = "5A039DCC6FD839BAEDD65D4DAB612236", hash_generated_field = "C6809692BC142070D05CBBAB805DBFC8")

    // guarded by 'this'
    private String mLastSqlStatement = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:40.984 -0500", hash_original_field = "DD8B83C55D3FB7275A2964209F9789FB", hash_generated_field = "4ED7543F27609F494F3BFF9473206AD9")

    private long mTransStartTime;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:40.988 -0500", hash_original_field = "2AA54E9A7290F40B8488C9624575004E", hash_generated_field = "6EF98DFD8F50B7AF8896098469B6C400")

    /* package */ volatile int mNativeHandle = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:40.994 -0500", hash_original_field = "1D4D0FAE668EECF10ED75DDC284FFC16", hash_generated_field = "6FACC3B41470C8330B5F0BB43FA7FD9F")

    private  String mPath;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:40.997 -0500", hash_original_field = "D324D10640D72C9B916775DBD1047D9D", hash_generated_field = "0FAF2BD49EE9B945E5C01C36BBE76EC3")

    private String mPathForLogs = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:40.999 -0500", hash_original_field = "4E5A87EA4636A8ACF68875B877F3A7B8", hash_generated_field = "1184DBF1E724C83F346E312B99E29A9C")

    /** The flags passed to open/create */
    private  int mFlags;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.002 -0500", hash_original_field = "CB2C39E26381B388838E75D78A20E5A3", hash_generated_field = "3B314DD3362D9759017A383358149E45")

    private  CursorFactory mFactory;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.004 -0500", hash_original_field = "2B318BE88D0BB5A9C78D181DE71F9269", hash_generated_field = "7586811E7431EEE33AF976CF89950239")

    private  WeakHashMap<SQLiteClosable, Object> mPrograms;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.009 -0500", hash_original_field = "B48D56E1B9230A6B5EE20E58A265331B", hash_generated_field = "9F46D35ABB6FCAE6EF9EC78CE5F97893")

    // guarded by this
    private LruCache<String, SQLiteCompiledSql> mCompiledQueries;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.013 -0500", hash_original_field = "07D9AF655A5CAFC24D09369463586F3B", hash_generated_field = "4E5EC633EDC17753869972551C767C68")

    private boolean mCacheFullWarning;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.016 -0500", hash_original_field = "05D6976C836A3613529DB18CD3C40A23", hash_generated_field = "7D1AA4359A52B133BFAD994AB60E8C14")

    private  Throwable mStackTrace;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.019 -0500", hash_original_field = "4C7574B58C654A6D760EEB8A3EC2176C", hash_generated_field = "0D9B8E09B51F96D0F503825B2DDED11B")

    private final ArrayList<Integer> mClosedStatementIds = new ArrayList<Integer>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.021 -0500", hash_original_field = "B090B5D442E2B469797805886BA499C9", hash_generated_field = "76DD5A0A5A09A890A2237FBF965CCF6C")

    private  DatabaseErrorHandler mErrorHandler;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.023 -0500", hash_original_field = "0661C573F90A5C08BF3864EEA2C9BB29", hash_generated_field = "9A00EFEB99A428B35165868DF8B67260")

    /* package */ volatile DatabaseConnectionPool mConnectionPool = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.026 -0500", hash_original_field = "38AABF491E6B9AC2F1FDAC5FCB6A30E7", hash_generated_field = "F1272633F2DD66AA4F42813312B7B25A")

    /* package */  short mConnectionNum;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.028 -0500", hash_original_field = "4A262DC52D3676F75324E8DD3283FF83", hash_generated_field = "5150A99CD04AA7784FB09A3A0E8D0E53")

    /* package */ SQLiteDatabase mParentConnObj = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.033 -0500", hash_original_field = "CB61034276C83DCCC0264E91B2BD0920", hash_generated_field = "760D925FEAB058AF61B1B94D2C774DE6")

    private volatile boolean mHasAttachedDbs = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.052 -0500", hash_original_field = "E5FCE04043D10764A1F9D8C51AD02114", hash_generated_field = "560D9A0D28C1D8056EAB428EF4EA40FE")

    private boolean mLockingEnabled = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.179 -0500", hash_original_field = "28E58E963A8CE1C24C867B9EE3895345", hash_generated_field = "BCE91343C41461430195125FEC2F1572")

    private final ArrayList<Integer> mCustomFunctions =
            new ArrayList<Integer>();
    @DSVerified
    @DSSpec(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.536 -0400", hash_original_method = "ED994C20AB51232E6F0B83AA0494CFAA", hash_generated_method = "379F4686F5BBA9E0C91C6A2E8EA0C809")
    private  SQLiteDatabase(String path, CursorFactory factory, int flags,
            DatabaseErrorHandler errorHandler, short connectionNum) {
        if(path == null)        
        {
            IllegalArgumentException varE4C91A561B864CD4490A03B12C2E1BD5_1723494487 = new IllegalArgumentException("path should not be null");
            varE4C91A561B864CD4490A03B12C2E1BD5_1723494487.addTaint(taint);
            throw varE4C91A561B864CD4490A03B12C2E1BD5_1723494487;
        } //End block
        
        addTaint(path.getTaint());
        addTaint(factory.getTaint());
        addTaint(connectionNum);

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

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:40.978 -0500", hash_original_method = "C15F9F532AF7810AA7D3562C5DDE29F6", hash_generated_method = "F9E1C10AE1E049888F131D016BE846FB")
    
synchronized String getLastSqlStatement() {
        return mLastSqlStatement;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:40.981 -0500", hash_original_method = "3743AC991024775005FDBE1593E9891E", hash_generated_method = "7606EA5EE2EFF905B29A556992E360B7")
    
synchronized void setLastSqlStatement(String sql) {
        mLastSqlStatement = sql;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.039 -0500", hash_original_method = "FF36C1ABFEC0F5F1C3DFBA7FD0941B56", hash_generated_method = "62780415AA97D3D7D705234C56977E24")
    
synchronized void addSQLiteClosable(SQLiteClosable closable) {
        // mPrograms is per instance of SQLiteDatabase and it doesn't actually touch the database
        // itself. so, there is no need to lock().
        mPrograms.put(closable, null);
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.041 -0500", hash_original_method = "030B4AA23DD4EAEE65D260C86C2A8B4C", hash_generated_method = "5BB0AFD3B7FFBA60C87405A5E7C46291")
    
synchronized void removeSQLiteClosable(SQLiteClosable closable) {
        mPrograms.remove(closable);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.044 -0500", hash_original_method = "29F441CF35047DF9CBB0BC7BF2B03F36", hash_generated_method = "4EDA247B875257B5EF7B791FD3B9ABE9")
    
@Override
    protected void onAllReferencesReleased() {
        if (isOpen()) {
            // close the database which will close all pending statements to be finalized also
            close();
        }
    }

    /**
     * Control whether or not the SQLiteDatabase is made thread-safe by using locks
     * around critical sections. This is pretty expensive, so if you know that your
     * DB will only be used by a single thread then you should set this to false.
     * The default is true.
     * @param lockingEnabled set to true to enable locks, false otherwise
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.050 -0500", hash_original_method = "CD58BEDD0347A27F6CFE4EB9BEFDF2F6", hash_generated_method = "1E11F61ACE379337CDEFBC1875F90EBD")
    
public void setLockingEnabled(boolean lockingEnabled) {
        mLockingEnabled = lockingEnabled;
    }

    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.054 -0500", hash_original_method = "6F1C3BA1763F74F7C0395D958A12A363", hash_generated_method = "6F1C3BA1763F74F7C0395D958A12A363")
    
void onCorruption() {
        EventLog.writeEvent(EVENT_DB_CORRUPT, mPath);
        mErrorHandler.onCorruption(this);
    }

    /**
     * Locks the database for exclusive access. The database lock must be held when
     * touch the native sqlite3* object since it is single threaded and uses
     * a polling lock contention algorithm. The lock is recursive, and may be acquired
     * multiple times by the same thread. This is a no-op if mLockingEnabled is false.
     *
     * @see #unlock()
     */
    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.056 -0500", hash_original_method = "6F6099DC841EA0266005BC3A83B18A96", hash_generated_method = "6F6099DC841EA0266005BC3A83B18A96")
    
void lock(String sql) {
        lock(sql, false);
    }

    /* pachage */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.058 -0500", hash_original_method = "8D6DAA6963637C0BD50884518E0FF993", hash_generated_method = "8D6DAA6963637C0BD50884518E0FF993")
    
void lock() {
        lock(null, false);
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.544 -0400", hash_original_method = "550218B4AE04D143508369398336F95D", hash_generated_method = "E2070B94C1CF03D4ABE3B501D68A397F")
    private void lock(String sql, boolean forced) {
        addTaint(forced);

        if (sql != null)
            addTaint(sql.getTaint());
/*
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
*/
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    /**
     * Locks the database for exclusive access. The database lock must be held when
     * touch the native sqlite3* object since it is single threaded and uses
     * a polling lock contention algorithm. The lock is recursive, and may be acquired
     * multiple times by the same thread.
     *
     * @see #unlockForced()
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.077 -0500", hash_original_method = "5F1F87633E052520A24DBAD554D491B1", hash_generated_method = "2AFB9F70EF753CA331B814BAFF28507A")
    
private void lockForced() {
        lock(null, true);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.079 -0500", hash_original_method = "E1FDB470EFF9EA86A5AAC7A627D6955E", hash_generated_method = "E3E9EE2742E98E3E18E2EC2976FBE0A8")
    
private void lockForced(String sql) {
        lock(sql, true);
    }
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.547 -0400", hash_original_method = "CB05AAFAB101AFFDD598174816C61BF7", hash_generated_method = "454B48A9532576C534C73BFE34BC80FF")
     void unlock() {
        /*
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
        */
        // ---------- Original Method ----------
        //if (!mLockingEnabled) return;
        //if (SQLiteDebug.DEBUG_LOCK_TIME_TRACKING) {
            //if (mLock.getHoldCount() == 1) {
                //checkLockHoldTime();
            //}
        //}
        //mLock.unlock();
    }

    /**
     * Releases the database lock.
     *
     * @see #unlockForced()
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.084 -0500", hash_original_method = "CA4E01B405088BC736DA3EA88D772AB0", hash_generated_method = "A22A8FFD82CCB7772B028FDC8A617ED4")
    
private void unlockForced() {
        if (SQLiteDebug.DEBUG_LOCK_TIME_TRACKING) {
            if (mLock.getHoldCount() == 1) {
                checkLockHoldTime();
            }
        }
        mLock.unlock();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.086 -0500", hash_original_method = "15FB67C6B55CF4F17EB9E05703E68C1A", hash_generated_method = "A4B12CB7104DF914AFA7505D24C26571")
    
private void checkLockHoldTime() {
        // Use elapsed real-time since the CPU may sleep when waiting for IO
        long elapsedTime = SystemClock.elapsedRealtime();
        long lockedTime = elapsedTime - mLockAcquiredWallTime;
        if (lockedTime < LOCK_ACQUIRED_WARNING_TIME_IN_MS_ALWAYS_PRINT &&
                !Log.isLoggable(TAG, Log.VERBOSE) &&
                (elapsedTime - mLastLockMessageTime) < LOCK_WARNING_WINDOW_IN_MS) {
            return;
        }
        if (lockedTime > LOCK_ACQUIRED_WARNING_TIME_IN_MS) {
            int threadTime = (int)
                    ((Debug.threadCpuTimeNanos() - mLockAcquiredThreadTime) / 1000000);
            if (threadTime > LOCK_ACQUIRED_WARNING_THREAD_TIME_IN_MS ||
                    lockedTime > LOCK_ACQUIRED_WARNING_TIME_IN_MS_ALWAYS_PRINT) {
                mLastLockMessageTime = elapsedTime;
                String msg = "lock held on " + mPath + " for " + lockedTime + "ms. Thread time was "
                        + threadTime + "ms";
                if (SQLiteDebug.DEBUG_LOCK_TIME_TRACKING_STACK_TRACE) {
                    Log.d(TAG, msg, new Exception());
                } else {
                    Log.d(TAG, msg);
                }
            }
        }
    }

    /**
     * Begins a transaction in EXCLUSIVE mode.
     * <p>
     * Transactions can be nested.
     * When the outer transaction is ended all of
     * the work done in that transaction and all of the nested transactions will be committed or
     * rolled back. The changes will be rolled back if any transaction is ended without being
     * marked as clean (by calling setTransactionSuccessful). Otherwise they will be committed.
     * </p>
     * <p>Here is the standard idiom for transactions:
     *
     * <pre>
     *   db.beginTransaction();
     *   try {
     *     ...
     *     db.setTransactionSuccessful();
     *   } finally {
     *     db.endTransaction();
     *   }
     * </pre>
     */
    @DSComment("Database access")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.089 -0500", hash_original_method = "36B8D50340D02900F098E44F066CFF12", hash_generated_method = "A6184A05F618D1808B44159CDC4ECD60")
    
public void beginTransaction() {
        beginTransaction(null /* transactionStatusCallback */, true);
    }

    /**
     * Begins a transaction in IMMEDIATE mode. Transactions can be nested. When
     * the outer transaction is ended all of the work done in that transaction
     * and all of the nested transactions will be committed or rolled back. The
     * changes will be rolled back if any transaction is ended without being
     * marked as clean (by calling setTransactionSuccessful). Otherwise they
     * will be committed.
     * <p>
     * Here is the standard idiom for transactions:
     *
     * <pre>
     *   db.beginTransactionNonExclusive();
     *   try {
     *     ...
     *     db.setTransactionSuccessful();
     *   } finally {
     *     db.endTransaction();
     *   }
     * </pre>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.092 -0500", hash_original_method = "E00D9BE9F4C6FCF885F8A6933F83E5B2", hash_generated_method = "9B5A0E2BD093CC974650FD7F869C1441")
    
public void beginTransactionNonExclusive() {
        beginTransaction(null /* transactionStatusCallback */, false);
    }

    /**
     * Begins a transaction in EXCLUSIVE mode.
     * <p>
     * Transactions can be nested.
     * When the outer transaction is ended all of
     * the work done in that transaction and all of the nested transactions will be committed or
     * rolled back. The changes will be rolled back if any transaction is ended without being
     * marked as clean (by calling setTransactionSuccessful). Otherwise they will be committed.
     * </p>
     * <p>Here is the standard idiom for transactions:
     *
     * <pre>
     *   db.beginTransactionWithListener(listener);
     *   try {
     *     ...
     *     db.setTransactionSuccessful();
     *   } finally {
     *     db.endTransaction();
     *   }
     * </pre>
     *
     * @param transactionListener listener that should be notified when the transaction begins,
     * commits, or is rolled back, either explicitly or by a call to
     * {@link #yieldIfContendedSafely}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.094 -0500", hash_original_method = "5BD04E9A01CA28B4B773A517F832DDF2", hash_generated_method = "91EE9B645CB7E6D2CEA3973F903982A7")
    
public void beginTransactionWithListener(SQLiteTransactionListener transactionListener) {
        beginTransaction(transactionListener, true);
    }

    /**
     * Begins a transaction in IMMEDIATE mode. Transactions can be nested. When
     * the outer transaction is ended all of the work done in that transaction
     * and all of the nested transactions will be committed or rolled back. The
     * changes will be rolled back if any transaction is ended without being
     * marked as clean (by calling setTransactionSuccessful). Otherwise they
     * will be committed.
     * <p>
     * Here is the standard idiom for transactions:
     *
     * <pre>
     *   db.beginTransactionWithListenerNonExclusive(listener);
     *   try {
     *     ...
     *     db.setTransactionSuccessful();
     *   } finally {
     *     db.endTransaction();
     *   }
     * </pre>
     *
     * @param transactionListener listener that should be notified when the
     *            transaction begins, commits, or is rolled back, either
     *            explicitly or by a call to {@link #yieldIfContendedSafely}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.097 -0500", hash_original_method = "EB4000007896884F9C35346C5F5B9337", hash_generated_method = "A7F082A40AE5A650B3BF04371527A008")
    
public void beginTransactionWithListenerNonExclusive(
            SQLiteTransactionListener transactionListener) {
        beginTransaction(transactionListener, false);
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.556 -0400", hash_original_method = "65C15EF02A1263C4153105EBF58851D9", hash_generated_method = "5AE1A42D6C38D809C10759CABD7323C5")
    private void beginTransaction(SQLiteTransactionListener transactionListener,
            boolean exclusive) {
        addTaint(exclusive);
        if (transactionListener != null)
            addTaint(transactionListener.getTaint());
        /*
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
        
        */
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    /**
     * End a transaction. See beginTransaction for notes about how to use this and when transactions
     * are committed and rolled back.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.103 -0500", hash_original_method = "94F2931FC5A304B6FE8748C95A17E4E3", hash_generated_method = "64FA759270A3DC58F469CF8706A639DD")
    
public void endTransaction() {
        verifyLockOwner();
        try {
            if (mInnerTransactionIsSuccessful) {
                mInnerTransactionIsSuccessful = false;
            } else {
                mTransactionIsSuccessful = false;
            }
            if (mLock.getHoldCount() != 1) {
                return;
            }
            RuntimeException savedException = null;
            if (mTransactionListener != null) {
                try {
                    if (mTransactionIsSuccessful) {
                        mTransactionListener.onCommit();
                    } else {
                        mTransactionListener.onRollback();
                    }
                } catch (RuntimeException e) {
                    savedException = e;
                    mTransactionIsSuccessful = false;
                }
            }
            if (mTransactionIsSuccessful) {
                execSQL(COMMIT_SQL);
                // if write-ahead logging is used, we have to take care of checkpoint.
                // TODO: should applications be given the flexibility of choosing when to
                // trigger checkpoint?
                // for now, do checkpoint after every COMMIT because that is the fastest
                // way to guarantee that readers will see latest data.
                // but this is the slowest way to run sqlite with in write-ahead logging mode.
                if (this.mConnectionPool != null) {
                    execSQL("PRAGMA wal_checkpoint;");
                    if (SQLiteDebug.DEBUG_SQL_STATEMENTS) {
                        Log.i(TAG, "PRAGMA wal_Checkpoint done");
                    }
                }
                // log the transaction time to the Eventlog.
                if (ENABLE_DB_SAMPLE) {
                    logTimeStat(getLastSqlStatement(), mTransStartTime, COMMIT_SQL);
                }
            } else {
                try {
                    execSQL("ROLLBACK;");
                    if (savedException != null) {
                        throw savedException;
                    }
                } catch (SQLException e) {
                    if (false) {
                        Log.d(TAG, "exception during rollback, maybe the DB previously "
                                + "performed an auto-rollback");
                    }
                }
            }
        } finally {
            mTransactionListener = null;
            unlockForced();
            if (false) {
                Log.v(TAG, "unlocked " + Thread.currentThread()
                        + ", holdCount is " + mLock.getHoldCount());
            }
        }
    }

    /**
     * Marks the current transaction as successful. Do not do any more database work between
     * calling this and calling endTransaction. Do as little non-database work as possible in that
     * situation too. If any errors are encountered between this and endTransaction the transaction
     * will still be committed.
     *
     * @throws IllegalStateException if the current thread is not in a transaction or the
     * transaction is already marked as successful.
     */
    @DSComment("Database access")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.106 -0500", hash_original_method = "CAD10DEB5A167AB4D97D078F2E23C48E", hash_generated_method = "11423CA2AB953135C722FCDBA12D61D5")
    
public void setTransactionSuccessful() {
        verifyDbIsOpen();
        if (!mLock.isHeldByCurrentThread()) {
            throw new IllegalStateException("no transaction pending");
        }
        if (mInnerTransactionIsSuccessful) {
            throw new IllegalStateException(
                    "setTransactionSuccessful may only be called once per call to beginTransaction");
        }
        mInnerTransactionIsSuccessful = true;
    }

    /**
     * return true if there is a transaction pending
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.108 -0500", hash_original_method = "6E9122EA7DDDF4A7FCE3C41AA714113C", hash_generated_method = "16CBF7F783BDC7B78DB3833DD187A118")
    
public boolean inTransaction() {
        return mLock.getHoldCount() > 0 || mTransactionUsingExecSql;
    }

    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.110 -0500", hash_original_method = "5CE93639419B30E518363E5F446309C9", hash_generated_method = "4B23945D96F809241E8E8F83B6C1D1BC")
    
synchronized void setTransactionUsingExecSqlFlag() {
        if (Log.isLoggable(TAG, Log.DEBUG)) {
            Log.i(TAG, "found execSQL('begin transaction')");
        }
        mTransactionUsingExecSql = true;
    }

    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.113 -0500", hash_original_method = "37864C1F3B8C10FDA9B20AB532C7EB78", hash_generated_method = "D742A3131EC23084A622ABDB237FACFA")
    
synchronized void resetTransactionUsingExecSqlFlag() {
        if (Log.isLoggable(TAG, Log.DEBUG)) {
            if (mTransactionUsingExecSql) {
                Log.i(TAG, "found execSQL('commit or end or rollback')");
            }
        }
        mTransactionUsingExecSql = false;
    }

    /**
     * Returns true if the caller is considered part of the current transaction, if any.
     * <p>
     * Caller is part of the current transaction if either of the following is true
     * <ol>
     *   <li>If transaction is started by calling beginTransaction() methods AND if the caller is
     *   in the same thread as the thread that started the transaction.
     *   </li>
     *   <li>If the transaction is started by calling {@link #execSQL(String)} like this:
     *   execSQL("BEGIN transaction"). In this case, every thread in the process is considered
     *   part of the current transaction.</li>
     * </ol>
     *
     * @return true if the caller is considered part of the current transaction, if any.
     */
    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.115 -0500", hash_original_method = "18141E27A4A6F223116C15568E4B1710", hash_generated_method = "3FB8C97BA058B654C653E935EAB8E250")
    
synchronized boolean amIInTransaction() {
        // always do this test on the main database connection - NOT on pooled database connection
        // since transactions always occur on the main database connections only.
        SQLiteDatabase db = (isPooledConnection()) ? mParentConnObj : this;
        boolean b = (!db.inTransaction()) ? false :
                db.mTransactionUsingExecSql || db.mLock.isHeldByCurrentThread();
        if (Log.isLoggable(TAG, Log.DEBUG)) {
            Log.i(TAG, "amIinTransaction: " + b);
        }
        return b;
    }

    /**
     * Checks if the database lock is held by this thread.
     *
     * @return true, if this thread is holding the database lock.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.118 -0500", hash_original_method = "810FBEC1135AAF9FE09D5ED72E2387AC", hash_generated_method = "08B473064B2FC912C12B0B46ED1C5323")
    
public boolean isDbLockedByCurrentThread() {
        return mLock.isHeldByCurrentThread();
    }

    /**
     * Checks if the database is locked by another thread. This is
     * just an estimate, since this status can change at any time,
     * including after the call is made but before the result has
     * been acted upon.
     *
     * @return true, if the database is locked by another thread
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.120 -0500", hash_original_method = "AFE51BB500BDF01026C5B1FB8FA31F68", hash_generated_method = "4054B63E9ED382DA240D3016406C159E")
    
public boolean isDbLockedByOtherThreads() {
        return !mLock.isHeldByCurrentThread() && mLock.isLocked();
    }

    /**
     * Temporarily end the transaction to let other threads run. The transaction is assumed to be
     * successful so far. Do not call setTransactionSuccessful before calling this. When this
     * returns a new transaction will have been created but not marked as successful.
     * @return true if the transaction was yielded
     * @deprecated if the db is locked more than once (becuase of nested transactions) then the lock
     *   will not be yielded. Use yieldIfContendedSafely instead.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.122 -0500", hash_original_method = "275C631F29B5F92F82765C72693E08C5", hash_generated_method = "A0803972848756ED819E2891D849D8EC")
    
@Deprecated
    public boolean yieldIfContended() {
        return yieldIfContendedHelper(false /* do not check yielding */,
                -1 /* sleepAfterYieldDelay */);
    }

    /**
     * Temporarily end the transaction to let other threads run. The transaction is assumed to be
     * successful so far. Do not call setTransactionSuccessful before calling this. When this
     * returns a new transaction will have been created but not marked as successful. This assumes
     * that there are no nested transactions (beginTransaction has only been called once) and will
     * throw an exception if that is not the case.
     * @return true if the transaction was yielded
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.125 -0500", hash_original_method = "E4D6EC2B61BA0EB36CC3F2E9664FDE2E", hash_generated_method = "74A7AD5F4B37A435B6179CC48D70B827")
    
public boolean yieldIfContendedSafely() {
        return yieldIfContendedHelper(true /* check yielding */, -1 /* sleepAfterYieldDelay*/);
    }

    /**
     * Temporarily end the transaction to let other threads run. The transaction is assumed to be
     * successful so far. Do not call setTransactionSuccessful before calling this. When this
     * returns a new transaction will have been created but not marked as successful. This assumes
     * that there are no nested transactions (beginTransaction has only been called once) and will
     * throw an exception if that is not the case.
     * @param sleepAfterYieldDelay if > 0, sleep this long before starting a new transaction if
     *   the lock was actually yielded. This will allow other background threads to make some
     *   more progress than they would if we started the transaction immediately.
     * @return true if the transaction was yielded
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.127 -0500", hash_original_method = "EFD5966AFCC9629F634B854AE0830507", hash_generated_method = "9CFA2EC4689E56E8EAE489CFBD17C341")
    
public boolean yieldIfContendedSafely(long sleepAfterYieldDelay) {
        return yieldIfContendedHelper(true /* check yielding */, sleepAfterYieldDelay);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.131 -0500", hash_original_method = "82E88213585314141BE9DBE00F951B10", hash_generated_method = "B3B09AD9C117B4760E8C683AFC29FD4C")
    
private boolean yieldIfContendedHelper(boolean checkFullyYielded, long sleepAfterYieldDelay) {
        if (mLock.getQueueLength() == 0) {
            // Reset the lock acquire time since we know that the thread was willing to yield
            // the lock at this time.
            mLockAcquiredWallTime = SystemClock.elapsedRealtime();
            mLockAcquiredThreadTime = Debug.threadCpuTimeNanos();
            return false;
        }
        setTransactionSuccessful();
        SQLiteTransactionListener transactionListener = mTransactionListener;
        endTransaction();
        if (checkFullyYielded) {
            if (this.isDbLockedByCurrentThread()) {
                throw new IllegalStateException(
                        "Db locked more than once. yielfIfContended cannot yield");
            }
        }
        if (sleepAfterYieldDelay > 0) {
            // Sleep for up to sleepAfterYieldDelay milliseconds, waking up periodically to
            // check if anyone is using the database.  If the database is not contended,
            // retake the lock and return.
            long remainingDelay = sleepAfterYieldDelay;
            while (remainingDelay > 0) {
                try {
                    Thread.sleep(remainingDelay < SLEEP_AFTER_YIELD_QUANTUM ?
                            remainingDelay : SLEEP_AFTER_YIELD_QUANTUM);
                } catch (InterruptedException e) {
                    Thread.interrupted();
                }
                remainingDelay -= SLEEP_AFTER_YIELD_QUANTUM;
                if (mLock.getQueueLength() == 0) {
                    break;
                }
            }
        }
        beginTransactionWithListener(transactionListener);
        return true;
    }

    /**
     * @deprecated This method no longer serves any useful purpose and has been deprecated.
     */
    @DSSource({DSSourceKind.DATABASE_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.133 -0500", hash_original_method = "2BF74CD6834BBADBF27F65464DB83499", hash_generated_method = "EDAA1ED8B82EF6EA1775DE16E5368175")
    
@Deprecated
    public Map<String, String> getSyncedTables() {
        return new HashMap<String, String>(0);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.154 -0500", hash_original_method = "4DBAD15B0F91A1B1A1A509E057CF6487", hash_generated_method = "5AC820211B92632B8DEC0C3F9E9A00ED")
    
private void setJournalMode(final String dbPath, final String mode) {
        // journal mode can be set only for non-memory databases
        // AND can't be set for readonly databases
        if (dbPath.equalsIgnoreCase(MEMORY_DB_PATH) || isReadOnly()) {
            return;
        }
        String s = DatabaseUtils.stringForQuery(this, "PRAGMA journal_mode=" + mode, null);
        if (!s.equalsIgnoreCase(mode)) {
            Log.e(TAG, "setting journal_mode to " + mode + " failed for db: " + dbPath +
                    " (on pragma set journal_mode, sqlite returned:" + s);
        }
    }

    /**
     * Close the database.
     */
    @DSComment("Database access")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.160 -0500", hash_original_method = "F057ECACA47F2E639159F91F6FF25AA8", hash_generated_method = "BC9E75A207746F095F3747302163154C")
    
public void close() {
        if (!isOpen()) {
            return;
        }
        if (Log.isLoggable(TAG, Log.DEBUG)) {
            Log.i(TAG, "closing db: " + mPath + " (connection # " + mConnectionNum);
        }
        lock();
        try {
            // some other thread could have closed this database while I was waiting for lock.
            // check the database state
            if (!isOpen()) {
                return;
            }
            closeClosable();
            // finalize ALL statements queued up so far
            closePendingStatements();
            releaseCustomFunctions();
            // close this database instance - regardless of its reference count value
            closeDatabase();
            if (mConnectionPool != null) {
                if (Log.isLoggable(TAG, Log.DEBUG)) {
                    assert mConnectionPool != null;
                    Log.i(TAG, mConnectionPool.toString());
                }
                mConnectionPool.close();
            }
        } finally {
            unlock();
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.163 -0500", hash_original_method = "2CD800231F10038F3799DBDAB26BCEE1", hash_generated_method = "E4453449A39B10CAA9B36A0CAA9CF041")
    
private void closeClosable() {
        /* deallocate all compiled SQL statement objects from mCompiledQueries cache.
         * this should be done before de-referencing all {@link SQLiteClosable} objects
         * from this database object because calling
         * {@link SQLiteClosable#onAllReferencesReleasedFromContainer()} could cause the database
         * to be closed. sqlite doesn't let a database close if there are
         * any unfinalized statements - such as the compiled-sql objects in mCompiledQueries.
         */
        deallocCachedSqlStatements();

        Iterator<Map.Entry<SQLiteClosable, Object>> iter = mPrograms.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<SQLiteClosable, Object> entry = iter.next();
            SQLiteClosable program = entry.getKey();
            if (program != null) {
                program.onAllReferencesReleasedFromContainer();
            }
        }
    }

    /**
     * package level access for testing purposes
     */
    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.166 -0500", hash_original_method = "9BCDA7BC5AA364A3676019422CD41F65", hash_generated_method = "782C69C3B1A5899C5F6A3F073346DFE1")
    
void closeDatabase() throws SQLiteException {
        try {
            dbclose();
        } catch (SQLiteUnfinalizedObjectsException e)  {
            String msg = e.getMessage();
            String[] tokens = msg.split(",", 2);
            int stmtId = Integer.parseInt(tokens[0]);
            // get extra info about this statement, if it is still to be released by closeClosable()
            Iterator<Map.Entry<SQLiteClosable, Object>> iter = mPrograms.entrySet().iterator();
            boolean found = false;
            while (iter.hasNext()) {
                Map.Entry<SQLiteClosable, Object> entry = iter.next();
                SQLiteClosable program = entry.getKey();
                if (program != null && program instanceof SQLiteProgram) {
                    SQLiteCompiledSql compiledSql = ((SQLiteProgram)program).mCompiledSql;
                    if (compiledSql.nStatement == stmtId) {
                        msg = compiledSql.toString();
                        found = true;
                    }
                }
            }
            if (!found) {
                // the statement is already released by closeClosable(). is it waiting to be
                // finalized?
                if (mClosedStatementIds.contains(stmtId)) {
                    Log.w(TAG, "this shouldn't happen. finalizing the statement now: ");
                    closePendingStatements();
                    // try to close the database again
                    closeDatabase();
                }
            } else {
                // the statement is not yet closed. most probably programming error in the app.
                throw new SQLiteUnfinalizedObjectsException(
                        "close() on database: " + getPath() +
                        " failed due to un-close()d SQL statements: " + msg);
            }
        }
    }

    /**
     * Native call to close the database.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.169 -0500", hash_original_method = "4C27B28311EC4401B9E72044B34DEE3C", hash_generated_method = "334CFA16BCC023A5D6E32608E2151FC9")
    
    private void dbclose(){
    	//Formerly a native method
    }

    /**
     * Registers a CustomFunction callback as a function that can be called from
     * sqlite3 database triggers.
     * @param name the name of the sqlite3 function
     * @param numArgs the number of arguments for the function
     * @param function callback to call when the function is executed
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.174 -0500", hash_original_method = "6AE38120A6AE17DCB302700D83D76664", hash_generated_method = "0DBBB7C6ED57D0AF2052F4EB896A1EFA")
    
public void addCustomFunction(String name, int numArgs, CustomFunction function) {
        verifyDbIsOpen();
        synchronized (mCustomFunctions) {
            int ref = native_addCustomFunction(name, numArgs, function);
            if (ref != 0) {
                // save a reference to the function for cleanup later
                mCustomFunctions.add(new Integer(ref));
            } else {
                throw new SQLiteException("failed to add custom function " + name);
            }
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.177 -0500", hash_original_method = "9C15AE424A91890D11F6682C678B396E", hash_generated_method = "50595DB27F926289612423789ED68E75")
    
private void releaseCustomFunctions() {
        synchronized (mCustomFunctions) {
            for (int i = 0; i < mCustomFunctions.size(); i++) {
                Integer function = mCustomFunctions.get(i);
                native_releaseCustomFunction(function.intValue());
            }
            mCustomFunctions.clear();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.183 -0500", hash_original_method = "545ECF4B8C2C387E458104596CE82C8C", hash_generated_method = "6D690750B12AA3B0B1B860DE2FBB25C0")
    
    private int native_addCustomFunction(String name, int numArgs, CustomFunction function){
    	//Formerly a native method
    	addTaint(name.getTaint());
    	addTaint(numArgs);
    	addTaint(function.getTaint());
    	return getTaintInt();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.186 -0500", hash_original_method = "D641D8CC9687EF2DFB0D6D88DDBFEE42", hash_generated_method = "43D69553EFF1E3A0B115BACDD81801A2")
    
    private void native_releaseCustomFunction(int function){
    	//Formerly a native method
    	addTaint(function);
    }

    /**
     * Gets the database version.
     *
     * @return the database version
     */
    @DSSource({DSSourceKind.DATABASE_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.189 -0500", hash_original_method = "8BA60C4A4A322F100A535BB125C59B40", hash_generated_method = "FD87B3D9476E471A679FC3178AB42567")
    
public int getVersion() {
        return ((Long) DatabaseUtils.longForQuery(this, "PRAGMA user_version;", null)).intValue();
    }

    /**
     * Sets the database version.
     *
     * @param version the new database version
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.192 -0500", hash_original_method = "4E3C0E9170C91236F101F38522569C45", hash_generated_method = "1F86CD58F49B5E87CD5D4492232C16C1")
    
public void setVersion(int version) {
        execSQL("PRAGMA user_version = " + version);
    }

    /**
     * Returns the maximum size the database may grow to.
     *
     * @return the new maximum database size
     */
    @DSSource({DSSourceKind.DATABASE_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.194 -0500", hash_original_method = "01DC63CC6FF3C1462DC7069F3072C18D", hash_generated_method = "DBE61E60C36C6E1676AA9BD36B643859")
    
public long getMaximumSize() {
        long pageCount = DatabaseUtils.longForQuery(this, "PRAGMA max_page_count;", null);
        return pageCount * getPageSize();
    }

    /**
     * Sets the maximum size the database will grow to. The maximum size cannot
     * be set below the current size.
     *
     * @param numBytes the maximum database size, in bytes
     * @return the new maximum database size
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.197 -0500", hash_original_method = "B09E5ED21834BC66E218E9635E49257B", hash_generated_method = "23EC9BEBD9E1A15E84DBB22515227D7D")
    
public long setMaximumSize(long numBytes) {
        long pageSize = getPageSize();
        long numPages = numBytes / pageSize;
        // If numBytes isn't a multiple of pageSize, bump up a page
        if ((numBytes % pageSize) != 0) {
            numPages++;
        }
        long newPageCount = DatabaseUtils.longForQuery(this, "PRAGMA max_page_count = " + numPages,
                null);
        return newPageCount * pageSize;
    }

    /**
     * Returns the current database page size, in bytes.
     *
     * @return the database page size, in bytes
     */
    @DSSource({DSSourceKind.DATABASE_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.199 -0500", hash_original_method = "677D214086B645E86B85D4E2A88CD9F6", hash_generated_method = "FC8EC710D99A626FB83F1A44578212FE")
    
public long getPageSize() {
        return DatabaseUtils.longForQuery(this, "PRAGMA page_size;", null);
    }

    /**
     * Sets the database page size. The page size must be a power of two. This
     * method does not work if any data has been written to the database file,
     * and must be called right after the database has been created.
     *
     * @param numBytes the database page size, in bytes
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.202 -0500", hash_original_method = "CE3FCE5D2F41E0E2EF73A0D49E90DE3F", hash_generated_method = "97991E74AEA1E91126AA981BE2B86738")
    
public void setPageSize(long numBytes) {
        execSQL("PRAGMA page_size = " + numBytes);
    }

    /**
     * Mark this table as syncable. When an update occurs in this table the
     * _sync_dirty field will be set to ensure proper syncing operation.
     *
     * @param table the table to mark as syncable
     * @param deletedTable The deleted table that corresponds to the
     *          syncable table
     * @deprecated This method no longer serves any useful purpose and has been deprecated.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.204 -0500", hash_original_method = "0ECCFA53F5E6749CB5B25917802B1822", hash_generated_method = "F47BD77401541C92FD82F448BDAC86FF")
    
@Deprecated
    public void markTableSyncable(String table, String deletedTable) {
    }

    /**
     * Mark this table as syncable, with the _sync_dirty residing in another
     * table. When an update occurs in this table the _sync_dirty field of the
     * row in updateTable with the _id in foreignKey will be set to
     * ensure proper syncing operation.
     *
     * @param table an update on this table will trigger a sync time removal
     * @param foreignKey this is the column in table whose value is an _id in
     *          updateTable
     * @param updateTable this is the table that will have its _sync_dirty
     * @deprecated This method no longer serves any useful purpose and has been deprecated.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.206 -0500", hash_original_method = "9A70316D056BE2F7590F6370A4F13111", hash_generated_method = "D4D77ECABDF5AA5EEB146E0D53FE87A4")
    
@Deprecated
    public void markTableSyncable(String table, String foreignKey, String updateTable) {
    }

    /**
     * Compiles an SQL statement into a reusable pre-compiled statement object.
     * The parameters are identical to {@link #execSQL(String)}. You may put ?s in the
     * statement and fill in those values with {@link SQLiteProgram#bindString}
     * and {@link SQLiteProgram#bindLong} each time you want to run the
     * statement. Statements may not return result sets larger than 1x1.
     *<p>
     * No two threads should be using the same {@link SQLiteStatement} at the same time.
     *
     * @param sql The raw SQL statement, may contain ? for unknown values to be
     *            bound later.
     * @return A pre-compiled {@link SQLiteStatement} object. Note that
     * {@link SQLiteStatement}s are not synchronized, see the documentation for more details.
     */
    @DSComment("returned DB object")
    @DSSpec(DSCat.DATABASE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.211 -0500", hash_original_method = "C05C583B39FD005C236783082CBB4E55", hash_generated_method = "A1E3106D38FC0C0A02CB8FBC096B7941")
    
public SQLiteStatement compileStatement(String sql) throws SQLException {
        verifyDbIsOpen();
        return new SQLiteStatement(this, sql, null);
    }

    /**
     * Query the given URL, returning a {@link Cursor} over the result set.
     *
     * @param distinct true if you want each row to be unique, false otherwise.
     * @param table The table name to compile the query against.
     * @param columns A list of which columns to return. Passing null will
     *            return all columns, which is discouraged to prevent reading
     *            data from storage that isn't going to be used.
     * @param selection A filter declaring which rows to return, formatted as an
     *            SQL WHERE clause (excluding the WHERE itself). Passing null
     *            will return all rows for the given table.
     * @param selectionArgs You may include ?s in selection, which will be
     *         replaced by the values from selectionArgs, in order that they
     *         appear in the selection. The values will be bound as Strings.
     * @param groupBy A filter declaring how to group rows, formatted as an SQL
     *            GROUP BY clause (excluding the GROUP BY itself). Passing null
     *            will cause the rows to not be grouped.
     * @param having A filter declare which row groups to include in the cursor,
     *            if row grouping is being used, formatted as an SQL HAVING
     *            clause (excluding the HAVING itself). Passing null will cause
     *            all row groups to be included, and is required when row
     *            grouping is not being used.
     * @param orderBy How to order the rows, formatted as an SQL ORDER BY clause
     *            (excluding the ORDER BY itself). Passing null will use the
     *            default sort order, which may be unordered.
     * @param limit Limits the number of rows returned by the query,
     *            formatted as LIMIT clause. Passing null denotes no LIMIT clause.
     * @return A {@link Cursor} object, which is positioned before the first entry. Note that
     * {@link Cursor}s are not synchronized, see the documentation for more details.
     * @see Cursor
     */
    @DSComment("Database access")
    @DSSpec(DSCat.DATABASE)
    @DSSource({DSSourceKind.DATABASE_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.214 -0500", hash_original_method = "5E1B6C3D7A97420E0A4D0244321FA1D0", hash_generated_method = "929CBBED5277B13A2B69F28022B581F4")
    
public Cursor query(boolean distinct, String table, String[] columns,
            String selection, String[] selectionArgs, String groupBy,
            String having, String orderBy, String limit) {
        return queryWithFactory(null, distinct, table, columns, selection, selectionArgs,
                groupBy, having, orderBy, limit);
    }

    /**
     * Query the given URL, returning a {@link Cursor} over the result set.
     *
     * @param cursorFactory the cursor factory to use, or null for the default factory
     * @param distinct true if you want each row to be unique, false otherwise.
     * @param table The table name to compile the query against.
     * @param columns A list of which columns to return. Passing null will
     *            return all columns, which is discouraged to prevent reading
     *            data from storage that isn't going to be used.
     * @param selection A filter declaring which rows to return, formatted as an
     *            SQL WHERE clause (excluding the WHERE itself). Passing null
     *            will return all rows for the given table.
     * @param selectionArgs You may include ?s in selection, which will be
     *         replaced by the values from selectionArgs, in order that they
     *         appear in the selection. The values will be bound as Strings.
     * @param groupBy A filter declaring how to group rows, formatted as an SQL
     *            GROUP BY clause (excluding the GROUP BY itself). Passing null
     *            will cause the rows to not be grouped.
     * @param having A filter declare which row groups to include in the cursor,
     *            if row grouping is being used, formatted as an SQL HAVING
     *            clause (excluding the HAVING itself). Passing null will cause
     *            all row groups to be included, and is required when row
     *            grouping is not being used.
     * @param orderBy How to order the rows, formatted as an SQL ORDER BY clause
     *            (excluding the ORDER BY itself). Passing null will use the
     *            default sort order, which may be unordered.
     * @param limit Limits the number of rows returned by the query,
     *            formatted as LIMIT clause. Passing null denotes no LIMIT clause.
     * @return A {@link Cursor} object, which is positioned before the first entry. Note that
     * {@link Cursor}s are not synchronized, see the documentation for more details.
     * @see Cursor
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.217 -0500", hash_original_method = "2EC2F985341F70A15977A4E5B8D54ACE", hash_generated_method = "52A9510AE84984289017F62A47E45BD0")
    
public Cursor queryWithFactory(CursorFactory cursorFactory,
            boolean distinct, String table, String[] columns,
            String selection, String[] selectionArgs, String groupBy,
            String having, String orderBy, String limit) {
        verifyDbIsOpen();
        String sql = SQLiteQueryBuilder.buildQueryString(
                distinct, table, columns, selection, groupBy, having, orderBy, limit);

        return rawQueryWithFactory(
                cursorFactory, sql, selectionArgs, findEditTable(table));
    }

    /**
     * Query the given table, returning a {@link Cursor} over the result set.
     *
     * @param table The table name to compile the query against.
     * @param columns A list of which columns to return. Passing null will
     *            return all columns, which is discouraged to prevent reading
     *            data from storage that isn't going to be used.
     * @param selection A filter declaring which rows to return, formatted as an
     *            SQL WHERE clause (excluding the WHERE itself). Passing null
     *            will return all rows for the given table.
     * @param selectionArgs You may include ?s in selection, which will be
     *         replaced by the values from selectionArgs, in order that they
     *         appear in the selection. The values will be bound as Strings.
     * @param groupBy A filter declaring how to group rows, formatted as an SQL
     *            GROUP BY clause (excluding the GROUP BY itself). Passing null
     *            will cause the rows to not be grouped.
     * @param having A filter declare which row groups to include in the cursor,
     *            if row grouping is being used, formatted as an SQL HAVING
     *            clause (excluding the HAVING itself). Passing null will cause
     *            all row groups to be included, and is required when row
     *            grouping is not being used.
     * @param orderBy How to order the rows, formatted as an SQL ORDER BY clause
     *            (excluding the ORDER BY itself). Passing null will use the
     *            default sort order, which may be unordered.
     * @return A {@link Cursor} object, which is positioned before the first entry. Note that
     * {@link Cursor}s are not synchronized, see the documentation for more details.
     * @see Cursor
     */
    @DSComment("Database access")
    @DSSpec(DSCat.DATABASE)
    @DSSource({DSSourceKind.DATABASE_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.219 -0500", hash_original_method = "823CC97B8BCC24B1EEF8A14CAC46F9D2", hash_generated_method = "33B19BE5321EBE883516789006AFBE2B")
    
public Cursor query(String table, String[] columns, String selection,
            String[] selectionArgs, String groupBy, String having,
            String orderBy) {

        return query(false, table, columns, selection, selectionArgs, groupBy,
                having, orderBy, null /* limit */);
    }

    /**
     * Query the given table, returning a {@link Cursor} over the result set.
     *
     * @param table The table name to compile the query against.
     * @param columns A list of which columns to return. Passing null will
     *            return all columns, which is discouraged to prevent reading
     *            data from storage that isn't going to be used.
     * @param selection A filter declaring which rows to return, formatted as an
     *            SQL WHERE clause (excluding the WHERE itself). Passing null
     *            will return all rows for the given table.
     * @param selectionArgs You may include ?s in selection, which will be
     *         replaced by the values from selectionArgs, in order that they
     *         appear in the selection. The values will be bound as Strings.
     * @param groupBy A filter declaring how to group rows, formatted as an SQL
     *            GROUP BY clause (excluding the GROUP BY itself). Passing null
     *            will cause the rows to not be grouped.
     * @param having A filter declare which row groups to include in the cursor,
     *            if row grouping is being used, formatted as an SQL HAVING
     *            clause (excluding the HAVING itself). Passing null will cause
     *            all row groups to be included, and is required when row
     *            grouping is not being used.
     * @param orderBy How to order the rows, formatted as an SQL ORDER BY clause
     *            (excluding the ORDER BY itself). Passing null will use the
     *            default sort order, which may be unordered.
     * @param limit Limits the number of rows returned by the query,
     *            formatted as LIMIT clause. Passing null denotes no LIMIT clause.
     * @return A {@link Cursor} object, which is positioned before the first entry. Note that
     * {@link Cursor}s are not synchronized, see the documentation for more details.
     * @see Cursor
     */
    @DSComment("Database access")
    @DSSpec(DSCat.DATABASE)
    @DSSource({DSSourceKind.DATABASE_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.221 -0500", hash_original_method = "C821013CE8C43126ED02ADCC7264C8CF", hash_generated_method = "AED839395EA89BCFAD47AF44D0DAF931")
    
public Cursor query(String table, String[] columns, String selection,
            String[] selectionArgs, String groupBy, String having,
            String orderBy, String limit) {

        return query(false, table, columns, selection, selectionArgs, groupBy,
                having, orderBy, limit);
    }

    /**
     * Runs the provided SQL and returns a {@link Cursor} over the result set.
     *
     * @param sql the SQL query. The SQL string must not be ; terminated
     * @param selectionArgs You may include ?s in where clause in the query,
     *     which will be replaced by the values from selectionArgs. The
     *     values will be bound as Strings.
     * @return A {@link Cursor} object, which is positioned before the first entry. Note that
     * {@link Cursor}s are not synchronized, see the documentation for more details.
     */
    @DSComment("Database access")
    @DSSpec(DSCat.DATABASE)
    @DSSource({DSSourceKind.DATABASE_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.224 -0500", hash_original_method = "76B8F97A589187A4837E14E72F2396A8", hash_generated_method = "65A12FD6153DC4A6ABBCE28A6BA06DA3")
    
public Cursor rawQuery(String sql, String[] selectionArgs) {
        return rawQueryWithFactory(null, sql, selectionArgs, null);
    }

    /**
     * Runs the provided SQL and returns a cursor over the result set.
     *
     * @param cursorFactory the cursor factory to use, or null for the default factory
     * @param sql the SQL query. The SQL string must not be ; terminated
     * @param selectionArgs You may include ?s in where clause in the query,
     *     which will be replaced by the values from selectionArgs. The
     *     values will be bound as Strings.
     * @param editTable the name of the first table, which is editable
     * @return A {@link Cursor} object, which is positioned before the first entry. Note that
     * {@link Cursor}s are not synchronized, see the documentation for more details.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.227 -0500", hash_original_method = "42A0891F7A1C512D8BE3F37EFD1DF118", hash_generated_method = "6CEEF99B8B3C8B9F1C38E7352FEC8B58")
    
public Cursor rawQueryWithFactory(
            CursorFactory cursorFactory, String sql, String[] selectionArgs,
            String editTable) {
        verifyDbIsOpen();
        BlockGuard.getThreadPolicy().onReadFromDisk();

        SQLiteDatabase db = getDbConnection(sql);
        SQLiteCursorDriver driver = new SQLiteDirectCursorDriver(db, sql, editTable);

        Cursor cursor = null;
        try {
            cursor = driver.query(
                    cursorFactory != null ? cursorFactory : mFactory,
                    selectionArgs);
        } finally {
            releaseDbConnection(db);
        }
        return cursor;
    }

    /**
     * Convenience method for inserting a row into the database.
     *
     * @param table the table to insert the row into
     * @param nullColumnHack optional; may be <code>null</code>.
     *            SQL doesn't allow inserting a completely empty row without
     *            naming at least one column name.  If your provided <code>values</code> is
     *            empty, no column names are known and an empty row can't be inserted.
     *            If not set to null, the <code>nullColumnHack</code> parameter
     *            provides the name of nullable column name to explicitly insert a NULL into
     *            in the case where your <code>values</code> is empty.
     * @param values this map contains the initial column values for the
     *            row. The keys should be the column names and the values the
     *            column values
     * @return the row ID of the newly inserted row, or -1 if an error occurred
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSComment("Database access")
    @DSSpec(DSCat.DATABASE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.229 -0500", hash_original_method = "7C0142B65481E16DCFB76B6C0BD0AF64", hash_generated_method = "B95E58E579B5A6D9594C3B5AF493AAD3")
    
public long insert(String table, String nullColumnHack, ContentValues values) {
        try {
            return insertWithOnConflict(table, nullColumnHack, values, CONFLICT_NONE);
        } catch (SQLException e) {
            Log.e(TAG, "Error inserting " + values, e);
            return -1;
        }
    }

    /**
     * Convenience method for inserting a row into the database.
     *
     * @param table the table to insert the row into
     * @param nullColumnHack optional; may be <code>null</code>.
     *            SQL doesn't allow inserting a completely empty row without
     *            naming at least one column name.  If your provided <code>values</code> is
     *            empty, no column names are known and an empty row can't be inserted.
     *            If not set to null, the <code>nullColumnHack</code> parameter
     *            provides the name of nullable column name to explicitly insert a NULL into
     *            in the case where your <code>values</code> is empty.
     * @param values this map contains the initial column values for the
     *            row. The keys should be the column names and the values the
     *            column values
     * @throws SQLException
     * @return the row ID of the newly inserted row, or -1 if an error occurred
     */
    @DSComment("Database access")
    @DSSpec(DSCat.DATABASE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.231 -0500", hash_original_method = "2F31CF2160A369C3FFDDD251C32C2819", hash_generated_method = "F605A67F6DEF3B004B61DFD6347CBF40")
    
public long insertOrThrow(String table, String nullColumnHack, ContentValues values)
            throws SQLException {
        return insertWithOnConflict(table, nullColumnHack, values, CONFLICT_NONE);
    }

    /**
     * Convenience method for replacing a row in the database.
     *
     * @param table the table in which to replace the row
     * @param nullColumnHack optional; may be <code>null</code>.
     *            SQL doesn't allow inserting a completely empty row without
     *            naming at least one column name.  If your provided <code>initialValues</code> is
     *            empty, no column names are known and an empty row can't be inserted.
     *            If not set to null, the <code>nullColumnHack</code> parameter
     *            provides the name of nullable column name to explicitly insert a NULL into
     *            in the case where your <code>initialValues</code> is empty.
     * @param initialValues this map contains the initial column values for
     *   the row.
     * @return the row ID of the newly inserted row, or -1 if an error occurred
     */
    @DSComment("Database access")
    @DSSpec(DSCat.DATABASE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.233 -0500", hash_original_method = "4277B606CBD58106C26DEC9C427B6DC5", hash_generated_method = "D93C3A5FF6004870E4D48B8BE0C8E3BD")
    
public long replace(String table, String nullColumnHack, ContentValues initialValues) {
        try {
            return insertWithOnConflict(table, nullColumnHack, initialValues,
                    CONFLICT_REPLACE);
        } catch (SQLException e) {
            Log.e(TAG, "Error inserting " + initialValues, e);
            return -1;
        }
    }

    /**
     * Convenience method for replacing a row in the database.
     *
     * @param table the table in which to replace the row
     * @param nullColumnHack optional; may be <code>null</code>.
     *            SQL doesn't allow inserting a completely empty row without
     *            naming at least one column name.  If your provided <code>initialValues</code> is
     *            empty, no column names are known and an empty row can't be inserted.
     *            If not set to null, the <code>nullColumnHack</code> parameter
     *            provides the name of nullable column name to explicitly insert a NULL into
     *            in the case where your <code>initialValues</code> is empty.
     * @param initialValues this map contains the initial column values for
     *   the row. The key
     * @throws SQLException
     * @return the row ID of the newly inserted row, or -1 if an error occurred
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.236 -0500", hash_original_method = "006F0DF267AA18E88B2010DFB3E66CC0", hash_generated_method = "11C8A74451055ED538AB13D475985014")
    
public long replaceOrThrow(String table, String nullColumnHack,
            ContentValues initialValues) throws SQLException {
        return insertWithOnConflict(table, nullColumnHack, initialValues,
                CONFLICT_REPLACE);
    }

    /**
     * General method for inserting a row into the database.
     *
     * @param table the table to insert the row into
     * @param nullColumnHack optional; may be <code>null</code>.
     *            SQL doesn't allow inserting a completely empty row without
     *            naming at least one column name.  If your provided <code>initialValues</code> is
     *            empty, no column names are known and an empty row can't be inserted.
     *            If not set to null, the <code>nullColumnHack</code> parameter
     *            provides the name of nullable column name to explicitly insert a NULL into
     *            in the case where your <code>initialValues</code> is empty.
     * @param initialValues this map contains the initial column values for the
     *            row. The keys should be the column names and the values the
     *            column values
     * @param conflictAlgorithm for insert conflict resolver
     * @return the row ID of the newly inserted row
     * OR the primary key of the existing row if the input param 'conflictAlgorithm' =
     * {@link #CONFLICT_IGNORE}
     * OR -1 if any error
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSComment("Database access")
    @DSSpec(DSCat.DATABASE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.239 -0500", hash_original_method = "4E696CAC31E62C2450813F66BA0D3688", hash_generated_method = "D3FFFFD73FA936FAF47289C5F6C32E7E")
    
public long insertWithOnConflict(String table, String nullColumnHack,
            ContentValues initialValues, int conflictAlgorithm) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT");
        sql.append(CONFLICT_VALUES[conflictAlgorithm]);
        sql.append(" INTO ");
        sql.append(table);
        sql.append('(');

        Object[] bindArgs = null;
        int size = (initialValues != null && initialValues.size() > 0) ? initialValues.size() : 0;
        if (size > 0) {
            bindArgs = new Object[size];
            int i = 0;
            for (String colName : initialValues.keySet()) {
                sql.append((i > 0) ? "," : "");
                sql.append(colName);
                bindArgs[i++] = initialValues.get(colName);
            }
            sql.append(')');
            sql.append(" VALUES (");
            for (i = 0; i < size; i++) {
                sql.append((i > 0) ? ",?" : "?");
            }
        } else {
            sql.append(nullColumnHack + ") VALUES (NULL");
        }
        sql.append(')');

        SQLiteStatement statement = new SQLiteStatement(this, sql.toString(), bindArgs);
        try {
            return statement.executeInsert();
        } catch (SQLiteDatabaseCorruptException e) {
            onCorruption();
            throw e;
        } finally {
            statement.close();
        }
    }

    /**
     * Convenience method for deleting rows in the database.
     *
     * @param table the table to delete from
     * @param whereClause the optional WHERE clause to apply when deleting.
     *            Passing null will delete all rows.
     * @return the number of rows affected if a whereClause is passed in, 0
     *         otherwise. To remove all rows and get a count pass "1" as the
     *         whereClause.
     */
    @DSComment("Database access")
    @DSSpec(DSCat.DATABASE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.243 -0500", hash_original_method = "D469CE4575675C51277223F3405EF96C", hash_generated_method = "D0BCB9EE048794547343EB781D55E762")
    
public int delete(String table, String whereClause, String[] whereArgs) {
        SQLiteStatement statement =  new SQLiteStatement(this, "DELETE FROM " + table +
                (!TextUtils.isEmpty(whereClause) ? " WHERE " + whereClause : ""), whereArgs);
        try {
            return statement.executeUpdateDelete();
        } catch (SQLiteDatabaseCorruptException e) {
            onCorruption();
            throw e;
        } finally {
            statement.close();
        }
    }

    /**
     * Convenience method for updating rows in the database.
     *
     * @param table the table to update in
     * @param values a map from column names to new column values. null is a
     *            valid value that will be translated to NULL.
     * @param whereClause the optional WHERE clause to apply when updating.
     *            Passing null will update all rows.
     * @return the number of rows affected
     */
    @DSComment("Database access")
    @DSSpec(DSCat.DATABASE)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.245 -0500", hash_original_method = "1314F51B10A849824DA60B76F1896857", hash_generated_method = "46D3DA0A1268F6E19F89D81DC65B48FD")
    
public int update(String table, ContentValues values, String whereClause, String[] whereArgs) {
        return updateWithOnConflict(table, values, whereClause, whereArgs, CONFLICT_NONE);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.615 -0400", hash_original_method = "42C896B54A7E0C71455DEE45B9C2EA0D", hash_generated_method = "05916159E86884CA282FAFB3BC886F41")
    public int updateWithOnConflict(String table, ContentValues values,
            String whereClause, String[] whereArgs, int conflictAlgorithm) {
        addTaint(conflictAlgorithm);
        addTaint(whereArgs.getTaintShort());
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

    /**
     * Execute a single SQL statement that is NOT a SELECT
     * or any other SQL statement that returns data.
     * <p>
     * It has no means to return any data (such as the number of affected rows).
     * Instead, you're encouraged to use {@link #insert(String, String, ContentValues)},
     * {@link #update(String, ContentValues, String, String[])}, et al, when possible.
     * </p>
     * <p>
     * When using {@link #enableWriteAheadLogging()}, journal_mode is
     * automatically managed by this class. So, do not set journal_mode
     * using "PRAGMA journal_mode'<value>" statement if your app is using
     * {@link #enableWriteAheadLogging()}
     * </p>
     *
     * @param sql the SQL statement to be executed. Multiple statements separated by semicolons are
     * not supported.
     * @throws SQLException if the SQL string is invalid
     */
    @DSComment("Database access")
    @DSSpec(DSCat.DATABASE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.250 -0500", hash_original_method = "25D536EB53093A036E9DAE961A0D97E6", hash_generated_method = "D29CB13B2063DDA1D0AA901FD0386254")
    
public void execSQL(String sql) throws SQLException {
        executeSql(sql, null);
    }

    /**
     * Execute a single SQL statement that is NOT a SELECT/INSERT/UPDATE/DELETE.
     * <p>
     * For INSERT statements, use any of the following instead.
     * <ul>
     *   <li>{@link #insert(String, String, ContentValues)}</li>
     *   <li>{@link #insertOrThrow(String, String, ContentValues)}</li>
     *   <li>{@link #insertWithOnConflict(String, String, ContentValues, int)}</li>
     * </ul>
     * <p>
     * For UPDATE statements, use any of the following instead.
     * <ul>
     *   <li>{@link #update(String, ContentValues, String, String[])}</li>
     *   <li>{@link #updateWithOnConflict(String, ContentValues, String, String[], int)}</li>
     * </ul>
     * <p>
     * For DELETE statements, use any of the following instead.
     * <ul>
     *   <li>{@link #delete(String, String, String[])}</li>
     * </ul>
     * <p>
     * For example, the following are good candidates for using this method:
     * <ul>
     *   <li>ALTER TABLE</li>
     *   <li>CREATE or DROP table / trigger / view / index / virtual table</li>
     *   <li>REINDEX</li>
     *   <li>RELEASE</li>
     *   <li>SAVEPOINT</li>
     *   <li>PRAGMA that returns no data</li>
     * </ul>
     * </p>
     * <p>
     * When using {@link #enableWriteAheadLogging()}, journal_mode is
     * automatically managed by this class. So, do not set journal_mode
     * using "PRAGMA journal_mode'<value>" statement if your app is using
     * {@link #enableWriteAheadLogging()}
     * </p>
     *
     * @param sql the SQL statement to be executed. Multiple statements separated by semicolons are
     * not supported.
     * @param bindArgs only byte[], String, Long and Double are supported in bindArgs.
     * @throws SQLException if the SQL string is invalid
     */
    @DSComment("Database access")
    @DSSpec(DSCat.DATABASE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.253 -0500", hash_original_method = "C75317BDB75C741C750B94F218C97882", hash_generated_method = "EBB1B2E9ABAA2FAB66A09DC8431DF450")
    
public void execSQL(String sql, Object[] bindArgs) throws SQLException {
        if (bindArgs == null) {
            throw new IllegalArgumentException("Empty bindArgs");
        }
        executeSql(sql, bindArgs);
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.620 -0400", hash_original_method = "9265893CFBC7535112C5207F5F702C1B", hash_generated_method = "FEFC15DD41C5156C7B0EB0359642A6A0")
    private int executeSql(String sql, Object[] bindArgs) throws SQLException {
        addTaint(bindArgs[0].getTaint());
        addTaint(sql.getTaint());
        
        if (DroidSafeAndroidRuntime.control) {
            SQLiteDatabaseCorruptException e = new SQLiteDatabaseCorruptException();
            e.addTaint(getTaint());
            onCorruption();
            throw e;
        }
        
        return getTaintInt();
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.258 -0500", hash_original_method = "2C203F91898576B00C917F0CD42A518A", hash_generated_method = "EB41B0B43B63A7C91338368112E979A1")
    
@Override
    protected void finalize() throws Throwable {
        try {
            if (isOpen()) {
                Log.e(TAG, "close() was never explicitly called on database '" +
                        mPath + "' ", mStackTrace);
                closeClosable();
                onAllReferencesReleased();
                releaseCustomFunctions();
            }
        } finally {
            super.finalize();
        }
    }

    /**
     * return whether the DB is opened as read only.
     * @return true if DB is opened as read only
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.263 -0500", hash_original_method = "B8251338AB8EB8352A863E35E41B939B", hash_generated_method = "ECE4AC413AF33B7DFA339587851A633B")
    
public boolean isReadOnly() {
        return (mFlags & OPEN_READ_MASK) == OPEN_READONLY;
    }

    /**
     * @return true if the DB is currently open (has not been closed)
     */
    @DSComment("Database access")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.266 -0500", hash_original_method = "61E254D128D08D9B7DD7C5EEB86B883E", hash_generated_method = "A1637FC4A8E8E14962FA82A2C62D9651")
    
public boolean isOpen() {
        return mNativeHandle != 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.269 -0500", hash_original_method = "4C8276EC0F604B529F31103A74E610FF", hash_generated_method = "4EA51A5D93D5EF17E015E1AF712B1538")
    
public boolean needUpgrade(int newVersion) {
        return newVersion > getVersion();
    }

    /**
     * Getter for the path to the database file.
     *
     * @return the path to our database file.
     */
    @DSSource({DSSourceKind.DATABASE_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.271 -0500", hash_original_method = "F177C5B02553C0E0327F321BDDCEAFD5", hash_generated_method = "571136F21505319981CAF88E560329CE")
    
public final String getPath() {
        return mPath;
    }

    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.273 -0500", hash_original_method = "0D21C1E893B83D945127726B58A78BA2", hash_generated_method = "0D21C1E893B83D945127726B58A78BA2")
    
void logTimeStat(String sql, long beginMillis) {
        if (ENABLE_DB_SAMPLE) {
            logTimeStat(sql, beginMillis, null);
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.276 -0500", hash_original_method = "8ED8142AF940938322CF345006300B7D", hash_generated_method = "881251ECDBAE81DEFD8671A1435A382F")
    
private void logTimeStat(String sql, long beginMillis, String prefix) {
        // Sample fast queries in proportion to the time taken.
        // Quantize the % first, so the logged sampling probability
        // exactly equals the actual sampling rate for this query.

        int samplePercent;
        long durationMillis = SystemClock.uptimeMillis() - beginMillis;
        if (durationMillis == 0 && prefix == GET_LOCK_LOG_PREFIX) {
            // The common case is locks being uncontended.  Don't log those,
            // even at 1%, which is our default below.
            return;
        }
        if (sQueryLogTimeInMillis == 0) {
            sQueryLogTimeInMillis = SystemProperties.getInt("db.db_operation.threshold_ms", 500);
        }
        if (durationMillis >= sQueryLogTimeInMillis) {
            samplePercent = 100;
        } else {
            samplePercent = (int) (100 * durationMillis / sQueryLogTimeInMillis) + 1;
            if (mRandom.nextInt(100) >= samplePercent) return;
        }

        // Note: the prefix will be "COMMIT;" or "GETLOCK:" when non-null.  We wait to do
        // it here so we avoid allocating in the common case.
        if (prefix != null) {
            sql = prefix + sql;
        }
        if (sql.length() > QUERY_LOG_SQL_LENGTH) sql = sql.substring(0, QUERY_LOG_SQL_LENGTH);

        // ActivityThread.currentPackageName() only returns non-null if the
        // current thread is an application main thread.  This parameter tells
        // us whether an event loop is blocked, and if so, which app it is.
        //
        // Sadly, there's no fast way to determine app name if this is *not* a
        // main thread, or when we are invoked via Binder (e.g. ContentProvider).
        // Hopefully the full path to the database will be informative enough.

        String blockingPackage = AppGlobals.getInitialPackage();
        if (blockingPackage == null) blockingPackage = "";

        EventLog.writeEvent(
            EVENT_DB_OPERATION,
            getPathForLogs(),
            sql,
            durationMillis,
            blockingPackage,
            samplePercent);
    }
    
    private static class DatabaseReentrantLock extends ReentrantLock {
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.068 -0500", hash_original_method = "FF2E769A330F113FDEF775F7B9F0F4EF", hash_generated_method = "FF2E769A330F113FDEF775F7B9F0F4EF")
        
DatabaseReentrantLock(boolean fair) {
            super(fair);
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.070 -0500", hash_original_method = "1BB82FD0B3090B035906C5C5A5300D7F", hash_generated_method = "B75ECEA12CAFFB08E48F0207AEFC9585")
        
@Override
        public Thread getOwner() {
            return super.getOwner();
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.073 -0500", hash_original_method = "0A30C3A8A16B3E36E180D94391681301", hash_generated_method = "6555B22944DD49B45A9A917AE1950050")
        
public String getOwnerDescription() {
            Thread t = getOwner();
            return (t== null) ? "none" : String.valueOf(t.getId());
        }
        
    }
    
    public interface CursorFactory {
        
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public Cursor newCursor(SQLiteDatabase db,
                SQLiteCursorDriver masterQuery, String editTable,
                SQLiteQuery query);
    }
    
    public interface CustomFunction {
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public void callback(String[] args);
    }

    /**
     * Removes email addresses from database filenames before they're
     * logged to the EventLog where otherwise apps could potentially
     * read them.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.279 -0500", hash_original_method = "BAC313652C0D08E8CD159DBA09E31731", hash_generated_method = "DBEE78C82366946621B7C3407723BF77")
    
private String getPathForLogs() {
        if (mPathForLogs != null) {
            return mPathForLogs;
        }
        if (mPath == null) {
            return null;
        }
        if (mPath.indexOf('@') == -1) {
            mPathForLogs = mPath;
        } else {
            mPathForLogs = EMAIL_IN_DB_PATTERN.matcher(mPath).replaceAll("XX@YY");
        }
        return mPathForLogs;
    }

    /**
     * Sets the locale for this database.  Does nothing if this database has
     * the NO_LOCALIZED_COLLATORS flag set or was opened read only.
     * @throws SQLException if the locale could not be set.  The most common reason
     * for this is that there is no collator available for the locale you requested.
     * In this case the database remains unchanged.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.281 -0500", hash_original_method = "3FAFCE8DADACDA6029D741D00EA768C4", hash_generated_method = "53715CAF993CFA765A957076367A909A")
    
public void setLocale(Locale locale) {
        lock();
        try {
            native_setLocale(locale.toString(), mFlags);
        } finally {
            unlock();
        }
    }

    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.283 -0500", hash_original_method = "82F89F6027C136BD18FB9173DDA585C3", hash_generated_method = "82F89F6027C136BD18FB9173DDA585C3")
    
void verifyDbIsOpen() {
        if (!isOpen()) {
            throw new IllegalStateException("database " + getPath() + " (conn# " +
                    mConnectionNum + ") already closed");
        }
    }

    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.286 -0500", hash_original_method = "2ABE5777D3030A58042EA8C11F6A64FB", hash_generated_method = "2ABE5777D3030A58042EA8C11F6A64FB")
    
void verifyLockOwner() {
        verifyDbIsOpen();
        if (mLockingEnabled && !isDbLockedByCurrentThread()) {
            throw new IllegalStateException("Don't have database lock!");
        }
    }

    /**
     * Adds the given SQL and its compiled-statement-id-returned-by-sqlite to the
     * cache of compiledQueries attached to 'this'.
     * <p>
     * If there is already a {@link SQLiteCompiledSql} in compiledQueries for the given SQL,
     * the new {@link SQLiteCompiledSql} object is NOT inserted into the cache (i.e.,the current
     * mapping is NOT replaced with the new mapping).
     */
    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.289 -0500", hash_original_method = "1F50605826534D1D8A189D3DC15DE94F", hash_generated_method = "B6F3815E56151667D2B21DB7189B0952")
    
synchronized void addToCompiledQueries(
            String sql, SQLiteCompiledSql compiledStatement) {
        // don't insert the new mapping if a mapping already exists
        if (mCompiledQueries.get(sql) != null) {
            return;
        }

        int maxCacheSz = (mConnectionNum == 0) ? mCompiledQueries.maxSize() :
                mParentConnObj.mCompiledQueries.maxSize();

        if (SQLiteDebug.DEBUG_SQL_CACHE) {
            boolean printWarning = (mConnectionNum == 0)
                    ? (!mCacheFullWarning && mCompiledQueries.size() == maxCacheSz)
                    : (!mParentConnObj.mCacheFullWarning &&
                    mParentConnObj.mCompiledQueries.size() == maxCacheSz);
            if (printWarning) {
                /*
                 * cache size is not enough for this app. log a warning.
                 * chances are it is NOT using ? for bindargs - or cachesize is too small.
                 */
                Log.w(TAG, "Reached MAX size for compiled-sql statement cache for database " +
                        getPath() + ". Use setMaxSqlCacheSize() to increase cachesize. ");
                mCacheFullWarning = true;
                Log.d(TAG, "Here are the SQL statements in Cache of database: " + mPath);
                for (String s : mCompiledQueries.snapshot().keySet()) {
                    Log.d(TAG, "Sql statement in Cache: " + s);
                }
            }
        }
        /* add the given SQLiteCompiledSql compiledStatement to cache.
         * no need to worry about the cache size - because {@link #mCompiledQueries}
         * self-limits its size.
         */
        mCompiledQueries.put(sql, compiledStatement);
    }

    /** package-level access for testing purposes */
    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.291 -0500", hash_original_method = "CE0C87ACDC099813F3D6D588DE2B56CF", hash_generated_method = "A17E5BB9E259E8C6FD0FC5AFBC8C4A6F")
    
synchronized void deallocCachedSqlStatements() {
        for (SQLiteCompiledSql compiledSql : mCompiledQueries.snapshot().values()) {
            compiledSql.releaseSqlStatement();
        }
        mCompiledQueries.evictAll();
    }

    /**
     * From the compiledQueries cache, returns the compiled-statement-id for the given SQL.
     * Returns null, if not found in the cache.
     */
    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.294 -0500", hash_original_method = "A3F9326C17119FEC2A90D0724FE482CF", hash_generated_method = "1F60C19DC736623A7DFD734984615D21")
    
synchronized SQLiteCompiledSql getCompiledStatementForSql(String sql) {
        return mCompiledQueries.get(sql);
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
                @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.297 -0500", hash_original_method = "0287FECCFAEBE5DF6977A7998D9D230B", hash_generated_method = "12E461B3332D193881C8CC39C9CF97E2")
                
@Override
                protected void entryRemoved(boolean evicted, String key, SQLiteCompiledSql oldValue,
                        SQLiteCompiledSql newValue) {
                    verifyLockOwner();
                    oldValue.releaseIfNotInUse();
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

    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.302 -0500", hash_original_method = "4517A8954B6715406427A020C27CB67E", hash_generated_method = "0A058386F278BAA2DCDA23C68B17E851")
    
synchronized boolean isInStatementCache(String sql) {
        return mCompiledQueries.get(sql) != null;
    }

    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.305 -0500", hash_original_method = "1314F31979BFAD21CD00C204B07606A6", hash_generated_method = "1B7CA8623D6F1D0CA3E89F505EF5B4A9")
    
synchronized void releaseCompiledSqlObj(
            String sql, SQLiteCompiledSql compiledSql) {
        if (mCompiledQueries.get(sql) == compiledSql) {
            // it is in cache - reset its inUse flag
            compiledSql.release();
        } else {
            // it is NOT in cache. finalize it.
            compiledSql.releaseSqlStatement();
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.307 -0500", hash_original_method = "8B250436E1E22A5062E1C40EC7B14D91", hash_generated_method = "D18E6BE8BD2146B3214245F1F8A09EAB")
    
private synchronized int getCacheHitNum() {
        return mCompiledQueries.hitCount();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.310 -0500", hash_original_method = "043FFEAEE6F40014DEE09BB2B945E7E0", hash_generated_method = "C48AC6B4F5F11517E48D2CFB3236A167")
    
private synchronized int getCacheMissNum() {
        return mCompiledQueries.missCount();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.313 -0500", hash_original_method = "BE154D77F9855AEAD67382AAA286976D", hash_generated_method = "2ACB48377BBA490FF2269153A1AC59FB")
    
private synchronized int getCachesize() {
        return mCompiledQueries.size();
    }

    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.316 -0500", hash_original_method = "5A385C2ADA8821372998CC92DEC1F051", hash_generated_method = "71A47ECD288DCF145FB711B57E50528A")
    
void finalizeStatementLater(int id) {
        if (!isOpen()) {
            // database already closed. this statement will already have been finalized.
            return;
        }
        synchronized(mClosedStatementIds) {
            if (mClosedStatementIds.contains(id)) {
                // this statement id is already queued up for finalization.
                return;
            }
            mClosedStatementIds.add(id);
        }
    }

    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.318 -0500", hash_original_method = "155C9044FA9A1FA1A4DC8EF486B34E28", hash_generated_method = "4267EAA722012E4C0DBDF5CBC74623CE")
    
boolean isInQueueOfStatementsToBeFinalized(int id) {
        if (!isOpen()) {
            // database already closed. this statement will already have been finalized.
            // return true so that the caller doesn't have to worry about finalizing this statement.
            return true;
        }
        synchronized(mClosedStatementIds) {
            return mClosedStatementIds.contains(id);
        }
    }

    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.320 -0500", hash_original_method = "D5552224B16C0AA0A430699F6F165E27", hash_generated_method = "C9D388CE20D65825FDFD803BCC856E69")
    
void closePendingStatements() {
        if (!isOpen()) {
            // since this database is already closed, no need to finalize anything.
            mClosedStatementIds.clear();
            return;
        }
        verifyLockOwner();
        /* to minimize synchronization on mClosedStatementIds, make a copy of the list */
        ArrayList<Integer> list = new ArrayList<Integer>(mClosedStatementIds.size());
        synchronized(mClosedStatementIds) {
            list.addAll(mClosedStatementIds);
            mClosedStatementIds.clear();
        }
        // finalize all the statements from the copied list
        int size = list.size();
        for (int i = 0; i < size; i++) {
            native_finalize(list.get(i));
        }
    }

    /**
     * for testing only
     */
    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.322 -0500", hash_original_method = "22B8BC0E5EAC4A96A93EF5FA02A6A3E4", hash_generated_method = "22B8BC0E5EAC4A96A93EF5FA02A6A3E4")
    
ArrayList<Integer> getQueuedUpStmtList() {
        return mClosedStatementIds;
    }

    /**
     * This method enables parallel execution of queries from multiple threads on the same database.
     * It does this by opening multiple handles to the database and using a different
     * database handle for each query.
     * <p>
     * If a transaction is in progress on one connection handle and say, a table is updated in the
     * transaction, then query on the same table on another connection handle will block for the
     * transaction to complete. But this method enables such queries to execute by having them
     * return old version of the data from the table. Most often it is the data that existed in the
     * table prior to the above transaction updates on that table.
     * <p>
     * Maximum number of simultaneous handles used to execute queries in parallel is
     * dependent upon the device memory and possibly other properties.
     * <p>
     * After calling this method, execution of queries in parallel is enabled as long as this
     * database handle is open. To disable execution of queries in parallel, database should
     * be closed and reopened.
     * <p>
     * If a query is part of a transaction, then it is executed on the same database handle the
     * transaction was begun.
     * <p>
     * If the database has any attached databases, then execution of queries in paralel is NOT
     * possible. In such cases, a message is printed to logcat and false is returned.
     * <p>
     * This feature is not available for :memory: databases. In such cases,
     * a message is printed to logcat and false is returned.
     * <p>
     * A typical way to use this method is the following:
     * <pre>
     *     SQLiteDatabase db = SQLiteDatabase.openDatabase("db_filename", cursorFactory,
     *             CREATE_IF_NECESSARY, myDatabaseErrorHandler);
     *     db.enableWriteAheadLogging();
     * </pre>
     * <p>
     * Writers should use {@link #beginTransactionNonExclusive()} or
     * {@link #beginTransactionWithListenerNonExclusive(SQLiteTransactionListener)}
     * to start a trsnsaction.
     * Non-exclusive mode allows database file to be in readable by threads executing queries.
     * </p>
     *
     * @return true if write-ahead-logging is set. false otherwise
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.325 -0500", hash_original_method = "D499CBE556FD537E95FAF5696995EFF8", hash_generated_method = "EC204BE156BA1E24C1063F3F9B5583C7")
    
public boolean enableWriteAheadLogging() {
        // make sure the database is not READONLY. WAL doesn't make sense for readonly-databases.
        if (isReadOnly()) {
            return false;
        }
        // acquire lock - no that no other thread is enabling WAL at the same time
        lock();
        try {
            if (mConnectionPool != null) {
                // already enabled
                return true;
            }
            if (mPath.equalsIgnoreCase(MEMORY_DB_PATH)) {
                Log.i(TAG, "can't enable WAL for memory databases.");
                return false;
            }

            // make sure this database has NO attached databases because sqlite's write-ahead-logging
            // doesn't work for databases with attached databases
            if (mHasAttachedDbs) {
                if (Log.isLoggable(TAG, Log.DEBUG)) {
                    Log.d(TAG,
                            "this database: " + mPath + " has attached databases. can't  enable WAL.");
                }
                return false;
            }
            mConnectionPool = new DatabaseConnectionPool(this);
            setJournalMode(mPath, "WAL");
            return true;
        } finally {
            unlock();
        }
    }

    /**
     * This method disables the features enabled by {@link #enableWriteAheadLogging()}.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.327 -0500", hash_original_method = "85CDE9F0FF49E9AFE9EC3200C3C50766", hash_generated_method = "0C5C589C9AE7BD9B9E5DBA3589421225")
    
public void disableWriteAheadLogging() {
        // grab database lock so that writeAheadLogging is not disabled from 2 different threads
        // at the same time
        lock();
        try {
            if (mConnectionPool == null) {
                return; // already disabled
            }
            mConnectionPool.close();
            setJournalMode(mPath, "TRUNCATE");
            mConnectionPool = null;
        } finally {
            unlock();
        }
    }

    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.330 -0500", hash_original_method = "E2BFDDA904D316A8C889FACE46B854F6", hash_generated_method = "FA8330D851FBBA1CBEE1E41A66778E5A")
    
SQLiteDatabase getDatabaseHandle(String sql) {
        if (isPooledConnection()) {
            // this is a pooled database connection
            // use it if it is open AND if I am not currently part of a transaction
            if (isOpen() && !amIInTransaction()) {
                // TODO: use another connection from the pool
                // if this connection is currently in use by some other thread
                // AND if there are free connections in the pool
                return this;
            } else {
                // the pooled connection is not open! could have been closed either due
                // to corruption on this or some other connection to the database
                // OR, maybe the connection pool is disabled after this connection has been
                // allocated to me. try to get some other pooled or main database connection
                return getParentDbConnObj().getDbConnection(sql);
            }
        } else {
            // this is NOT a pooled connection. can we get one?
            return getDbConnection(sql);
        }
    }

    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.332 -0500", hash_original_method = "3237D800F466D0C40C278AA082141CB7", hash_generated_method = "3237D800F466D0C40C278AA082141CB7")
    
SQLiteDatabase createPoolConnection(short connectionNum) {
        SQLiteDatabase db = openDatabase(mPath, mFactory, mFlags, mErrorHandler, connectionNum);
        db.mParentConnObj = this;
        return db;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.335 -0500", hash_original_method = "205546EE310EB84028F43CE65A7EC94C", hash_generated_method = "30CB2F54754DCBD150C9D4301578E3E3")
    
private synchronized SQLiteDatabase getParentDbConnObj() {
        return mParentConnObj;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.337 -0500", hash_original_method = "D4EECEC449FC4C156499058FCB2B2B85", hash_generated_method = "29541D645EA91C1D35EAA40FFF0D5229")
    
private boolean isPooledConnection() {
        return this.mConnectionNum > 0;
    }

    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.339 -0500", hash_original_method = "B485A553653CD27E64DDB9F45483F96A", hash_generated_method = "726647AF3429155534F88651BAF49492")
    
SQLiteDatabase getDbConnection(String sql) {
        verifyDbIsOpen();
        // this method should always be called with main database connection handle.
        // the only time when it is called with pooled database connection handle is
        // corruption occurs while trying to open a pooled database connection handle.
        // in that case, simply return 'this' handle
        if (isPooledConnection()) {
            return this;
        }

        // use the current connection handle if
        // 1. if the caller is part of the ongoing transaction, if any
        // 2. OR, if there is NO connection handle pool setup
        if (amIInTransaction() || mConnectionPool == null) {
            return this;
        } else {
            // get a connection handle from the pool
            if (Log.isLoggable(TAG, Log.DEBUG)) {
                assert mConnectionPool != null;
                Log.i(TAG, mConnectionPool.toString());
            }
            return mConnectionPool.get(sql);
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.343 -0500", hash_original_method = "2B099A526E7EBE8C0C20DFBE797D578C", hash_generated_method = "57B13E0F734DDAAF416B847798AA6D73")
    
private void releaseDbConnection(SQLiteDatabase db) {
        // ignore this release call if
        // 1. the database is closed
        // 2. OR, if db is NOT a pooled connection handle
        // 3. OR, if the database being released is same as 'this' (this condition means
        //     that we should always be releasing a pooled connection handle by calling this method
        //     from the 'main' connection handle
        if (!isOpen() || !db.isPooledConnection() || (db == this)) {
            return;
        }
        if (Log.isLoggable(TAG, Log.DEBUG)) {
            assert isPooledConnection();
            assert mConnectionPool != null;
            Log.d(TAG, "releaseDbConnection threadid = " + Thread.currentThread().getId() +
                    ", releasing # " + db.mConnectionNum + ", " + getPath());
        }
        mConnectionPool.release(db);
    }

    /**
     * Returns list of full pathnames of all attached databases including the main database
     * by executing 'pragma database_list' on the database.
     *
     * @return ArrayList of pairs of (database name, database file path) or null if the database
     * is not open.
     */
    @DSSource({DSSourceKind.DATABASE_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.356 -0500", hash_original_method = "40C4DE1C4808AAF54B97D30ED440E3DF", hash_generated_method = "19BC31D447084B5C7128C3C8CECEEB5C")
    
public List<Pair<String, String>> getAttachedDbs() {
        if (!isOpen()) {
            return null;
        }
        ArrayList<Pair<String, String>> attachedDbs = new ArrayList<Pair<String, String>>();
        if (!mHasAttachedDbs) {
            // No attached databases.
            // There is a small window where attached databases exist but this flag is not set yet.
            // This can occur when this thread is in a race condition with another thread
            // that is executing the SQL statement: "attach database <blah> as <foo>"
            // If this thread is NOT ok with such a race condition (and thus possibly not receive
            // the entire list of attached databases), then the caller should ensure that no thread
            // is executing any SQL statements while a thread is calling this method.
            // Typically, this method is called when 'adb bugreport' is done or the caller wants to
            // collect stats on the database and all its attached databases.
            attachedDbs.add(new Pair<String, String>("main", mPath));
            return attachedDbs;
        }
        // has attached databases. query sqlite to get the list of attached databases.
        Cursor c = null;
        try {
            c = rawQuery("pragma database_list;", null);
            while (c.moveToNext()) {
                // sqlite returns a row for each database in the returned list of databases.
                //   in each row,
                //       1st column is the database name such as main, or the database
                //                              name specified on the "ATTACH" command
                //       2nd column is the database file path.
                attachedDbs.add(new Pair<String, String>(c.getString(1), c.getString(2)));
            }
        } finally {
            if (c != null) {
                c.close();
            }
        }
        return attachedDbs;
    }

    /**
     * Runs 'pragma integrity_check' on the given database (and all the attached databases)
     * and returns true if the given database (and all its attached databases) pass integrity_check,
     * false otherwise.
     *<p>
     * If the result is false, then this method logs the errors reported by the integrity_check
     * command execution.
     *<p>
     * Note that 'pragma integrity_check' on a database can take a long time.
     *
     * @return true if the given database (and all its attached databases) pass integrity_check,
     * false otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.360 -0500", hash_original_method = "F327316761A478EA142E408A35654FE2", hash_generated_method = "C05DC208CA1460CB759B3456086FF920")
    
public boolean isDatabaseIntegrityOk() {
        verifyDbIsOpen();
        List<Pair<String, String>> attachedDbs = null;
        try {
            attachedDbs = getAttachedDbs();
            if (attachedDbs == null) {
                throw new IllegalStateException("databaselist for: " + getPath() + " couldn't " +
                        "be retrieved. probably because the database is closed");
            }
        } catch (SQLiteException e) {
            // can't get attachedDb list. do integrity check on the main database
            attachedDbs = new ArrayList<Pair<String, String>>();
            attachedDbs.add(new Pair<String, String>("main", this.mPath));
        }
        for (int i = 0; i < attachedDbs.size(); i++) {
            Pair<String, String> p = attachedDbs.get(i);
            SQLiteStatement prog = null;
            try {
                prog = compileStatement("PRAGMA " + p.first + ".integrity_check(1);");
                String rslt = prog.simpleQueryForString();
                if (!rslt.equalsIgnoreCase("ok")) {
                    // integrity_checker failed on main or attached databases
                    Log.e(TAG, "PRAGMA integrity_check on " + p.second + " returned: " + rslt);
                    return false;
                }
            } finally {
                if (prog != null) prog.close();
            }
        }
        return true;
    }
        
@DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.654 -0400", hash_original_method = "8D335FE0EDA9A8017E889380A7A722CF", hash_generated_method = "7DC2BD660B2CDC6483080370E51D7A42")
    private void dbopen(String path, int flags) {
            addTaint(path.getTaint());
            addTaint(flags);
    }

    /**
     * Native call to setup tracing of all SQL statements
     *
     * @param path the full path to the database
     * @param connectionNum connection number: 0 - N, where the main database
     *            connection handle is numbered 0 and the connection handles in the connection
     *            pool are numbered 1..N.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.367 -0500", hash_original_method = "70E20853624884484C3836EF6F149A55", hash_generated_method = "98C88477A31C62F98408AC089F8D1E58")
    
    private void enableSqlTracing(String path, short connectionNum){
    	//Formerly a native method
    	addTaint(path.getTaint());
    	addTaint(connectionNum);
    }

    /**
     * Native call to setup profiling of all SQL statements.
     * currently, sqlite's profiling = printing of execution-time
     * (wall-clock time) of each of the SQL statements, as they
     * are executed.
     *
     * @param path the full path to the database
     * @param connectionNum connection number: 0 - N, where the main database
     *            connection handle is numbered 0 and the connection handles in the connection
     *            pool are numbered 1..N.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.372 -0500", hash_original_method = "C8A96013E7D0E582573D33F32AE9CEB2", hash_generated_method = "252A51404F3DDEE3881CB74B463B0F05")
    
    private void enableSqlProfiling(String path, short connectionNum){
    	//Formerly a native method
    	addTaint(path.getTaint());
    	addTaint(connectionNum);
    }

    /**
     * Native call to set the locale.  {@link #lock} must be held when calling
     * this method.
     * @throws SQLException
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.376 -0500", hash_original_method = "D6178DAC9B84DE9466B1B633DF097ED8", hash_generated_method = "6AAE1F5F85576B58FBB4C30EC472B9C3")
    
    private void native_setLocale(String loc, int flags){
    	//Formerly a native method
    	addTaint(loc.getTaint());
    	addTaint(flags);
    }

    /**
     * return the SQLITE_DBSTATUS_LOOKASIDE_USED documented here
     * http://www.sqlite.org/c3ref/c_dbstatus_lookaside_used.html
     * @return int value of SQLITE_DBSTATUS_LOOKASIDE_USED
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.380 -0500", hash_original_method = "94C6AE32C9A996CB80A0C1FADFD7D1F2", hash_generated_method = "304297C30014C2EEDBA3DCD250AEFF02")
    
    private int native_getDbLookaside(){
    	//Formerly a native method
    	return getTaintInt();
    }

    /**
     * finalizes the given statement id.
     *
     * @param statementId statement to be finzlied by sqlite
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.384 -0500", hash_original_method = "C4F8F8FDF64373EAEBE82B2B8F80D5C0", hash_generated_method = "0E4D22C6E8944521E5322CD40194AF4B")
    
    private final void native_finalize(int statementId){
    	//Formerly a native method
    	addTaint(statementId);
    }

    /**
     * set sqlite soft heap limit
     * http://www.sqlite.org/c3ref/soft_heap_limit64.html
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:41.388 -0500", hash_original_method = "324F9A57AA3484DEBE48152EFBF728CA", hash_generated_method = "C0EFE1658671D81CD1808302D6053BE3")
    
    private void native_setSqliteSoftHeapLimit(int softHeapLimit){
    	//Formerly a native method
    	addTaint(softHeapLimit);
    }

}

