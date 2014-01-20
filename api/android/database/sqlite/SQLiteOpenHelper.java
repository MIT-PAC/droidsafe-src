package android.database.sqlite;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.DefaultDatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

public abstract class SQLiteOpenHelper {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:43.757 -0500", hash_original_field = "A23D65E3143183D79448273A64B01CB0", hash_generated_field = "073F4465324B7F9FFC720DD01EEA24AC")

    private static final String TAG = SQLiteOpenHelper.class.getSimpleName();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:43.760 -0500", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private  Context mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:43.762 -0500", hash_original_field = "ED29A5CAC2A4A14894CD28BA3B1CE29C", hash_generated_field = "886C24C67739C97CF77B8DD239E412F9")

    private  String mName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:43.766 -0500", hash_original_field = "CB2C39E26381B388838E75D78A20E5A3", hash_generated_field = "3B314DD3362D9759017A383358149E45")

    private  CursorFactory mFactory;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:43.768 -0500", hash_original_field = "DFB46BFB455BC2DB80FA7B3ECF0B7992", hash_generated_field = "E37741801665C28F1D0231A69288300D")

    private  int mNewVersion;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:43.770 -0500", hash_original_field = "44FFBD8FF4418C357393646DA7699518", hash_generated_field = "949BF9C4D224A2E5EB02E79597DEC6F1")

    private SQLiteDatabase mDatabase = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:43.773 -0500", hash_original_field = "50E4E5297F01E9A67F4220A4CE962C4D", hash_generated_field = "F70ACE423FC74AA75F488787A63DC7D9")

    private boolean mIsInitializing = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:43.775 -0500", hash_original_field = "B090B5D442E2B469797805886BA499C9", hash_generated_field = "76DD5A0A5A09A890A2237FBF965CCF6C")

    private  DatabaseErrorHandler mErrorHandler;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.823 -0400", hash_original_method = "FA08D03545E9DF881DE2A492BC7B90D5", hash_generated_method = "5E6F83AB57D3846D72B269C6A4631576")
    public  SQLiteOpenHelper(Context context, String name, CursorFactory factory, int version) {
        this(context, name, factory, version, new DefaultDatabaseErrorHandler());
        addTaint(version);
        addTaint(factory.getTaint());
        addTaint(name.getTaint());
        addTaint(context.getTaint());

        // This method will call various entry points when necessary.
        // We enable all of them here
        onCreate (null);
        onDowngrade (null, 0, 1);
        onOpen (null);
        onUpgrade (null, 0, 1);

        // ---------- Original Method ----------
    }

    /**
     * Create a helper object to create, open, and/or manage a database.
     * The database is not actually created or opened until one of
     * {@link #getWritableDatabase} or {@link #getReadableDatabase} is called.
     *
     * <p>Accepts input param: a concrete instance of {@link DatabaseErrorHandler} to be
     * used to handle corruption when sqlite reports database corruption.</p>
     *
     * @param context to use to open or create the database
     * @param name of the database file, or null for an in-memory database
     * @param factory to use for creating cursor objects, or null for the default
     * @param version number of the database (starting at 1); if the database is older,
     *     {@link #onUpgrade} will be used to upgrade the database
     * @param errorHandler the {@link DatabaseErrorHandler} to be used when sqlite reports database
     * corruption.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:43.782 -0500", hash_original_method = "31439111717724CD584CC4C37B277BA9", hash_generated_method = "1E87DEE6C831B0E790943148296DFDC0")
    
public SQLiteOpenHelper(Context context, String name, CursorFactory factory, int version,
            DatabaseErrorHandler errorHandler) {
        if (version < 1) throw new IllegalArgumentException("Version must be >= 1, was " + version);
        if (errorHandler == null) {
            throw new IllegalArgumentException("DatabaseErrorHandler param value can't be null.");
        }

        mContext = context;
        mName = name;
        mFactory = factory;
        mNewVersion = version;
        mErrorHandler = errorHandler;
    }

    /**
     * Return the name of the SQLite database being opened, as given tp
     * the constructor.
     */
    @DSSource({DSSourceKind.DATABASE_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:43.784 -0500", hash_original_method = "68E7432F62212BC238811FF4144A34FC", hash_generated_method = "5602C287A4D1DDD5C592942E7AB5ECC4")
    
public String getDatabaseName() {
        return mName;
    }

    /**
     * Create and/or open a database that will be used for reading and writing.
     * The first time this is called, the database will be opened and
     * {@link #onCreate}, {@link #onUpgrade} and/or {@link #onOpen} will be
     * called.
     *
     * <p>Once opened successfully, the database is cached, so you can
     * call this method every time you need to write to the database.
     * (Make sure to call {@link #close} when you no longer need the database.)
     * Errors such as bad permissions or a full disk may cause this method
     * to fail, but future attempts may succeed if the problem is fixed.</p>
     *
     * <p class="caution">Database upgrade may take a long time, you
     * should not call this method from the application main thread, including
     * from {@link android.content.ContentProvider#onCreate ContentProvider.onCreate()}.
     *
     * @throws SQLiteException if the database cannot be opened for writing
     * @return a read/write database object valid until {@link #close} is called
     */
    @DSComment("returned DB object")
    @DSSpec(DSCat.DATABASE)
    @DSSource({DSSourceKind.DATABASE_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:43.787 -0500", hash_original_method = "907737C2FD1DDBAF11A72FCBC6C42218", hash_generated_method = "2232AC9EE8B6E44F14C198E6D8B3DC50")
    
public synchronized SQLiteDatabase getWritableDatabase() {
        if (mDatabase != null) {
            if (!mDatabase.isOpen()) {
                // darn! the user closed the database by calling mDatabase.close()
                mDatabase = null;
            } else if (!mDatabase.isReadOnly()) {
                return mDatabase;  // The database is already open for business
            }
        }

        if (mIsInitializing) {
            throw new IllegalStateException("getWritableDatabase called recursively");
        }

        // If we have a read-only database open, someone could be using it
        // (though they shouldn't), which would cause a lock to be held on
        // the file, and our attempts to open the database read-write would
        // fail waiting for the file lock.  To prevent that, we acquire the
        // lock on the read-only database, which shuts out other users.

        boolean success = false;
        SQLiteDatabase db = null;
        if (mDatabase != null) mDatabase.lock();
        try {
            mIsInitializing = true;
            if (mName == null) {
                db = SQLiteDatabase.create(null);
            } else {
                db = mContext.openOrCreateDatabase(mName, 0, mFactory, mErrorHandler);
            }

            int version = db.getVersion();
            if (version != mNewVersion) {
                db.beginTransaction();
                try {
                    if (version == 0) {
                        onCreate(db);
                    } else {
                        if (version > mNewVersion) {
                            onDowngrade(db, version, mNewVersion);
                        } else {
                            onUpgrade(db, version, mNewVersion);
                        }
                    }
                    db.setVersion(mNewVersion);
                    db.setTransactionSuccessful();
                } finally {
                    db.endTransaction();
                }
            }

            onOpen(db);
            success = true;
            return db;
        } finally {
            mIsInitializing = false;
            if (success) {
                if (mDatabase != null) {
                    try { mDatabase.close(); } catch (Exception e) { }
                    mDatabase.unlock();
                }
                mDatabase = db;
            } else {
                if (mDatabase != null) mDatabase.unlock();
                if (db != null) db.close();
            }
        }
    }

    /**
     * Create and/or open a database.  This will be the same object returned by
     * {@link #getWritableDatabase} unless some problem, such as a full disk,
     * requires the database to be opened read-only.  In that case, a read-only
     * database object will be returned.  If the problem is fixed, a future call
     * to {@link #getWritableDatabase} may succeed, in which case the read-only
     * database object will be closed and the read/write object will be returned
     * in the future.
     *
     * <p class="caution">Like {@link #getWritableDatabase}, this method may
     * take a long time to return, so you should not call it from the
     * application main thread, including from
     * {@link android.content.ContentProvider#onCreate ContentProvider.onCreate()}.
     *
     * @throws SQLiteException if the database cannot be opened
     * @return a database object valid until {@link #getWritableDatabase}
     *     or {@link #close} is called.
     */
    @DSComment("returned DB object")
    @DSSpec(DSCat.DATABASE)
    @DSSource({DSSourceKind.DATABASE_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:43.791 -0500", hash_original_method = "2895B1DC2B2D9F1953E668AA67DA7E81", hash_generated_method = "CCD91013A9F1A17C4DECD1F769D86C56")
    
public synchronized SQLiteDatabase getReadableDatabase() {
        if (mDatabase != null) {
            if (!mDatabase.isOpen()) {
                // darn! the user closed the database by calling mDatabase.close()
                mDatabase = null;
            } else {
                return mDatabase;  // The database is already open for business
            }
        }

        if (mIsInitializing) {
            throw new IllegalStateException("getReadableDatabase called recursively");
        }

        try {
            return getWritableDatabase();
        } catch (SQLiteException e) {
            if (mName == null) throw e;  // Can't open a temp database read-only!
            Log.e(TAG, "Couldn't open " + mName + " for writing (will try read-only):", e);
        }

        SQLiteDatabase db = null;
        try {
            mIsInitializing = true;
            String path = mContext.getDatabasePath(mName).getPath();
            db = SQLiteDatabase.openDatabase(path, mFactory, SQLiteDatabase.OPEN_READONLY,
                    mErrorHandler);
            if (db.getVersion() != mNewVersion) {
                throw new SQLiteException("Can't upgrade read-only database from version " +
                        db.getVersion() + " to " + mNewVersion + ": " + path);
            }

            onOpen(db);
            Log.w(TAG, "Opened " + mName + " in read-only mode");
            mDatabase = db;
            return mDatabase;
        } finally {
            mIsInitializing = false;
            if (db != null && db != mDatabase) db.close();
        }
    }

    /**
     * Close any open database object.
     */
    @DSComment("no security concern")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:43.793 -0500", hash_original_method = "C09EB7B9D42A5A795555D7C9A56D8370", hash_generated_method = "7DAFEB4AF1658D891E4799A36032CC30")
    
public synchronized void close() {
        if (mIsInitializing) throw new IllegalStateException("Closed during initialization");

        if (mDatabase != null && mDatabase.isOpen()) {
            mDatabase.close();
            mDatabase = null;
        }
    }

    /**
     * Called when the database is created for the first time. This is where the
     * creation of tables and the initial population of the tables should happen.
     *
     * @param db The database.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:43.796 -0500", hash_original_method = "2FBC79C6C2BA05FEAB84BE21BD7C0DCC", hash_generated_method = "4120612F73499708628B23C714A029ED")
    
public abstract void onCreate(SQLiteDatabase db);

    /**
     * Called when the database needs to be upgraded. The implementation
     * should use this method to drop tables, add tables, or do anything else it
     * needs to upgrade to the new schema version.
     *
     * <p>The SQLite ALTER TABLE documentation can be found
     * <a href="http://sqlite.org/lang_altertable.html">here</a>. If you add new columns
     * you can use ALTER TABLE to insert them into a live table. If you rename or remove columns
     * you can use ALTER TABLE to rename the old table, then create the new table and then
     * populate the new table with the contents of the old table.
     *
     * @param db The database.
     * @param oldVersion The old database version.
     * @param newVersion The new database version.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:43.799 -0500", hash_original_method = "AD445B0156B85B8B4173B4EAC2D086F3", hash_generated_method = "E507DA669B386B03FA7730201B26B476")
    
public abstract void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion);

    /**
     * Called when the database needs to be downgraded. This is stricly similar to
     * onUpgrade() method, but is called whenever current version is newer than requested one.
     * However, this method is not abstract, so it is not mandatory for a customer to
     * implement it. If not overridden, default implementation will reject downgrade and
     * throws SQLiteException
     *
     * @param db The database.
     * @param oldVersion The old database version.
     * @param newVersion The new database version.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:43.801 -0500", hash_original_method = "E809F845DA52B26B37A0B95640D58A46", hash_generated_method = "0BC539B90B921B9865428E46B9B72836")
    
public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        throw new SQLiteException("Can't downgrade database from version " +
                oldVersion + " to " + newVersion);
    }

    /**
     * Called when the database has been opened.  The implementation
     * should check {@link SQLiteDatabase#isReadOnly} before updating the
     * database.
     *
     * @param db The database.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:43.803 -0500", hash_original_method = "4811C8ED58A3ECFEDC0621F514E7FFAC", hash_generated_method = "FC73B503B4F27A0AAE320B027E4A24EC")
    
public void onOpen(SQLiteDatabase db) {}
}

