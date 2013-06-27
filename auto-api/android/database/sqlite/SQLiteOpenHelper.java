package android.database.sqlite;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.DefaultDatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.util.Log;

public abstract class SQLiteOpenHelper {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.301 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.301 -0400", hash_original_field = "311C2C8498DF6A626CBDB8AA4193499C", hash_generated_field = "886C24C67739C97CF77B8DD239E412F9")

    private String mName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.301 -0400", hash_original_field = "06389DE86ED19AB1571A41645A1AFADC", hash_generated_field = "3B314DD3362D9759017A383358149E45")

    private CursorFactory mFactory;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.301 -0400", hash_original_field = "8B87C38A8EA38B485FFD08DF439AE2B0", hash_generated_field = "E37741801665C28F1D0231A69288300D")

    private int mNewVersion;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.301 -0400", hash_original_field = "961E4258F7E74A9EAA9E39B39D6F0A80", hash_generated_field = "949BF9C4D224A2E5EB02E79597DEC6F1")

    private SQLiteDatabase mDatabase = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.302 -0400", hash_original_field = "A8B92F87BF2A02DD09F9992E38529E01", hash_generated_field = "F70ACE423FC74AA75F488787A63DC7D9")

    private boolean mIsInitializing = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.302 -0400", hash_original_field = "17F47A6FF3D481E01A6A82252EB7B064", hash_generated_field = "76DD5A0A5A09A890A2237FBF965CCF6C")

    private DatabaseErrorHandler mErrorHandler;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.302 -0400", hash_original_method = "FA08D03545E9DF881DE2A492BC7B90D5", hash_generated_method = "4D6E71BB8C5F6FA87C46FD59523ADA27")
    public  SQLiteOpenHelper(Context context, String name, CursorFactory factory, int version) {
        this(context, name, factory, version, new DefaultDatabaseErrorHandler());
        addTaint(context.getTaint());
        addTaint(name.getTaint());
        addTaint(factory.getTaint());
        addTaint(version);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.309 -0400", hash_original_method = "31439111717724CD584CC4C37B277BA9", hash_generated_method = "BF852381B615E75C2DCD7DAB35B59E83")
    public  SQLiteOpenHelper(Context context, String name, CursorFactory factory, int version,
            DatabaseErrorHandler errorHandler) {
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Version must be >= 1, was " + version);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("DatabaseErrorHandler param value can't be null.");
        } //End block
        mContext = context;
        mName = name;
        mFactory = factory;
        mNewVersion = version;
        mErrorHandler = errorHandler;
        // ---------- Original Method ----------
        //if (version < 1) throw new IllegalArgumentException("Version must be >= 1, was " + version);
        //if (errorHandler == null) {
            //throw new IllegalArgumentException("DatabaseErrorHandler param value can't be null.");
        //}
        //mContext = context;
        //mName = name;
        //mFactory = factory;
        //mNewVersion = version;
        //mErrorHandler = errorHandler;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.329 -0400", hash_original_method = "68E7432F62212BC238811FF4144A34FC", hash_generated_method = "79B6C667E1EC6BA42B50CEAED32E53DF")
    public String getDatabaseName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1268128758 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1268128758 = mName;
        varB4EAC82CA7396A68D541C85D26508E83_1268128758.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1268128758;
        // ---------- Original Method ----------
        //return mName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.342 -0400", hash_original_method = "907737C2FD1DDBAF11A72FCBC6C42218", hash_generated_method = "CE770A5F9DF823BF6A650737F71E511B")
    public synchronized SQLiteDatabase getWritableDatabase() {
        SQLiteDatabase varB4EAC82CA7396A68D541C85D26508E83_1636906312 = null; //Variable for return #1
        SQLiteDatabase varB4EAC82CA7396A68D541C85D26508E83_677501747 = null; //Variable for return #2
        {
            {
                boolean var7569BD827A079103D7665EC50E19706D_655716659 = (!mDatabase.isOpen());
                {
                    mDatabase = null;
                } //End block
                {
                    boolean var5F8D535220438AC9802CC821F137F2C6_301310719 = (!mDatabase.isReadOnly());
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1636906312 = mDatabase;
                    } //End block
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("getWritableDatabase called recursively");
        } //End block
        boolean success;
        success = false;
        SQLiteDatabase db;
        db = null;
        mDatabase.lock();
        try 
        {
            mIsInitializing = true;
            {
                db = SQLiteDatabase.create(null);
            } //End block
            {
                db = mContext.openOrCreateDatabase(mName, 0, mFactory, mErrorHandler);
            } //End block
            int version;
            version = db.getVersion();
            {
                db.beginTransaction();
                try 
                {
                    {
                        onCreate(db);
                    } //End block
                    {
                        {
                            onDowngrade(db, version, mNewVersion);
                        } //End block
                        {
                            onUpgrade(db, version, mNewVersion);
                        } //End block
                    } //End block
                    db.setVersion(mNewVersion);
                    db.setTransactionSuccessful();
                } //End block
                finally 
                {
                    db.endTransaction();
                } //End block
            } //End block
            onOpen(db);
            success = true;
            varB4EAC82CA7396A68D541C85D26508E83_677501747 = db;
        } //End block
        finally 
        {
            mIsInitializing = false;
            {
                {
                    try 
                    {
                        mDatabase.close();
                    } //End block
                    catch (Exception e)
                    { }
                    mDatabase.unlock();
                } //End block
                mDatabase = db;
            } //End block
            {
                mDatabase.unlock();
                db.close();
            } //End block
        } //End block
        SQLiteDatabase varA7E53CE21691AB073D9660D615818899_865832132; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_865832132 = varB4EAC82CA7396A68D541C85D26508E83_1636906312;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_865832132 = varB4EAC82CA7396A68D541C85D26508E83_677501747;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_865832132.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_865832132;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.369 -0400", hash_original_method = "2895B1DC2B2D9F1953E668AA67DA7E81", hash_generated_method = "169BB6EA15BB6982E07D5C85572BBE43")
    public synchronized SQLiteDatabase getReadableDatabase() {
        SQLiteDatabase varB4EAC82CA7396A68D541C85D26508E83_919806982 = null; //Variable for return #1
        SQLiteDatabase varB4EAC82CA7396A68D541C85D26508E83_677246301 = null; //Variable for return #2
        SQLiteDatabase varB4EAC82CA7396A68D541C85D26508E83_1331611537 = null; //Variable for return #3
        {
            {
                boolean var7569BD827A079103D7665EC50E19706D_236876513 = (!mDatabase.isOpen());
                {
                    mDatabase = null;
                } //End block
                {
                    varB4EAC82CA7396A68D541C85D26508E83_919806982 = mDatabase;
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("getReadableDatabase called recursively");
        } //End block
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_677246301 = getWritableDatabase();
        } //End block
        catch (SQLiteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw e;
        } //End block
        SQLiteDatabase db;
        db = null;
        try 
        {
            mIsInitializing = true;
            String path;
            path = mContext.getDatabasePath(mName).getPath();
            db = SQLiteDatabase.openDatabase(path, mFactory, SQLiteDatabase.OPEN_READONLY,
                    mErrorHandler);
            {
                boolean var65DE63E4DC58A554ED5CEE2376BDDFDC_2132730731 = (db.getVersion() != mNewVersion);
                {
                    if (DroidSafeAndroidRuntime.control) throw new SQLiteException("Can't upgrade read-only database from version " +
                        db.getVersion() + " to " + mNewVersion + ": " + path);
                } //End block
            } //End collapsed parenthetic
            onOpen(db);
            mDatabase = db;
            varB4EAC82CA7396A68D541C85D26508E83_1331611537 = mDatabase;
        } //End block
        finally 
        {
            mIsInitializing = false;
            db.close();
        } //End block
        SQLiteDatabase varA7E53CE21691AB073D9660D615818899_1188478264; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1188478264 = varB4EAC82CA7396A68D541C85D26508E83_919806982;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1188478264 = varB4EAC82CA7396A68D541C85D26508E83_677246301;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1188478264 = varB4EAC82CA7396A68D541C85D26508E83_1331611537;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1188478264.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1188478264;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.374 -0400", hash_original_method = "C09EB7B9D42A5A795555D7C9A56D8370", hash_generated_method = "F50999BC0978CE24F5C89D3671CB7F27")
    public synchronized void close() {
        if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Closed during initialization");
        {
            boolean varCBBF24DAE768B3306F58D1F814F85B3C_1395201278 = (mDatabase != null && mDatabase.isOpen());
            {
                mDatabase.close();
                mDatabase = null;
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (mIsInitializing) throw new IllegalStateException("Closed during initialization");
        //if (mDatabase != null && mDatabase.isOpen()) {
            //mDatabase.close();
            //mDatabase = null;
        //}
    }

    
    public abstract void onCreate(SQLiteDatabase db);

    
    public abstract void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.385 -0400", hash_original_method = "E809F845DA52B26B37A0B95640D58A46", hash_generated_method = "543C85F44FA36F9854BA366EC29124EB")
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        if (DroidSafeAndroidRuntime.control) throw new SQLiteException("Can't downgrade database from version " +
                oldVersion + " to " + newVersion);
        addTaint(db.getTaint());
        addTaint(oldVersion);
        addTaint(newVersion);
        // ---------- Original Method ----------
        //throw new SQLiteException("Can't downgrade database from version " +
                //oldVersion + " to " + newVersion);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.386 -0400", hash_original_method = "4811C8ED58A3ECFEDC0621F514E7FFAC", hash_generated_method = "114D8028AAA729F2C8D5D48D03E2C088")
    public void onOpen(SQLiteDatabase db) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(db.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:10.400 -0400", hash_original_field = "238370C77E3E3E7DCA380B58BB0FF6CF", hash_generated_field = "572326AD718A3B1A33DA2897B3C99E48")

    private static String TAG = SQLiteOpenHelper.class.getSimpleName();
}

