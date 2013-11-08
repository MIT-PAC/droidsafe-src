package android.database.sqlite;

// Droidsafe Imports
import droidsafe.annotations.*;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.DefaultDatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase.CursorFactory;





public abstract class SQLiteOpenHelper {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.822 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.822 -0400", hash_original_field = "311C2C8498DF6A626CBDB8AA4193499C", hash_generated_field = "886C24C67739C97CF77B8DD239E412F9")

    private String mName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.822 -0400", hash_original_field = "06389DE86ED19AB1571A41645A1AFADC", hash_generated_field = "3B314DD3362D9759017A383358149E45")

    private CursorFactory mFactory;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.822 -0400", hash_original_field = "8B87C38A8EA38B485FFD08DF439AE2B0", hash_generated_field = "E37741801665C28F1D0231A69288300D")

    private int mNewVersion;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.822 -0400", hash_original_field = "961E4258F7E74A9EAA9E39B39D6F0A80", hash_generated_field = "949BF9C4D224A2E5EB02E79597DEC6F1")

    private SQLiteDatabase mDatabase = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.822 -0400", hash_original_field = "A8B92F87BF2A02DD09F9992E38529E01", hash_generated_field = "F70ACE423FC74AA75F488787A63DC7D9")

    private boolean mIsInitializing = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.822 -0400", hash_original_field = "17F47A6FF3D481E01A6A82252EB7B064", hash_generated_field = "76DD5A0A5A09A890A2237FBF965CCF6C")

    private DatabaseErrorHandler mErrorHandler;
    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.826 -0400", hash_original_method = "31439111717724CD584CC4C37B277BA9", hash_generated_method = "91FCD08F7F9386FBF6B0E377EC191F7E")
    public  SQLiteOpenHelper(Context context, String name, CursorFactory factory, int version,
            DatabaseErrorHandler errorHandler) {
        if(version < 1)        
        {
        IllegalArgumentException var1DBA27FCE4D803648C04F31EBB168D24_1837139295 = new IllegalArgumentException("Version must be >= 1, was " + version);
        var1DBA27FCE4D803648C04F31EBB168D24_1837139295.addTaint(taint);
        throw var1DBA27FCE4D803648C04F31EBB168D24_1837139295;
        }
        if(errorHandler == null)        
        {
            IllegalArgumentException varB774D6236B7D9EA6C1589D8682A4E28C_722699966 = new IllegalArgumentException("DatabaseErrorHandler param value can't be null.");
            varB774D6236B7D9EA6C1589D8682A4E28C_722699966.addTaint(taint);
            throw varB774D6236B7D9EA6C1589D8682A4E28C_722699966;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.827 -0400", hash_original_method = "68E7432F62212BC238811FF4144A34FC", hash_generated_method = "75958720DE425E9E4FECE76E64DE8F75")
    public String getDatabaseName() {
String varDBF15A5FB8102A5C28D5046A0E92E443_265564831 =         mName;
        varDBF15A5FB8102A5C28D5046A0E92E443_265564831.addTaint(taint);
        return varDBF15A5FB8102A5C28D5046A0E92E443_265564831;
        // ---------- Original Method ----------
        //return mName;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.829 -0400", hash_original_method = "907737C2FD1DDBAF11A72FCBC6C42218", hash_generated_method = "D8F6AAE64EE48739E4F01EDF1BEB1A8D")
    public synchronized SQLiteDatabase getWritableDatabase() {
        if(mDatabase != null)        
        {
            if(!mDatabase.isOpen())            
            {
                mDatabase = null;
            } //End block
            else
            if(!mDatabase.isReadOnly())            
            {
SQLiteDatabase var8D37BF836D5C80F645159E6565338BF6_1615040254 =                 mDatabase;
                var8D37BF836D5C80F645159E6565338BF6_1615040254.addTaint(taint);
                return var8D37BF836D5C80F645159E6565338BF6_1615040254;
            } //End block
        } //End block
        if(mIsInitializing)        
        {
            IllegalStateException var5BDCB2F09A02E904389D36E0E970279A_2057850778 = new IllegalStateException("getWritableDatabase called recursively");
            var5BDCB2F09A02E904389D36E0E970279A_2057850778.addTaint(taint);
            throw var5BDCB2F09A02E904389D36E0E970279A_2057850778;
        } //End block
        boolean success = false;
        SQLiteDatabase db = null;
        if(mDatabase != null)        
        mDatabase.lock();
        try 
        {
            mIsInitializing = true;
            if(mName == null)            
            {
                db = SQLiteDatabase.create(null);
            } //End block
            else
            {
                db = mContext.openOrCreateDatabase(mName, 0, mFactory, mErrorHandler);
            } //End block
            int version = db.getVersion();
            if(version != mNewVersion)            
            {
                db.beginTransaction();
                try 
                {
                    if(version == 0)                    
                    {
                        onCreate(db);
                    } //End block
                    else
                    {
                        if(version > mNewVersion)                        
                        {
                            onDowngrade(db, version, mNewVersion);
                        } //End block
                        else
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
SQLiteDatabase var2F732BA7E0C8A6B94C1D7B25B6A078BE_628360158 =             db;
            var2F732BA7E0C8A6B94C1D7B25B6A078BE_628360158.addTaint(taint);
            return var2F732BA7E0C8A6B94C1D7B25B6A078BE_628360158;
        } //End block
        finally 
        {
            mIsInitializing = false;
            if(success)            
            {
                if(mDatabase != null)                
                {
                    try 
                    {
                        mDatabase.close();
                    } //End block
                    catch (Exception e)
                    {
                    } //End block
                    mDatabase.unlock();
                } //End block
                mDatabase = db;
            } //End block
            else
            {
                if(mDatabase != null)                
                mDatabase.unlock();
                if(db != null)                
                db.close();
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.832 -0400", hash_original_method = "2895B1DC2B2D9F1953E668AA67DA7E81", hash_generated_method = "DE97B086C04556014B56785CE97776A4")
    public synchronized SQLiteDatabase getReadableDatabase() {
        if(mDatabase != null)        
        {
            if(!mDatabase.isOpen())            
            {
                mDatabase = null;
            } //End block
            else
            {
SQLiteDatabase var8D37BF836D5C80F645159E6565338BF6_2064953756 =                 mDatabase;
                var8D37BF836D5C80F645159E6565338BF6_2064953756.addTaint(taint);
                return var8D37BF836D5C80F645159E6565338BF6_2064953756;
            } //End block
        } //End block
        if(mIsInitializing)        
        {
            IllegalStateException var81C383DC12357F6067B70D235C098465_881188848 = new IllegalStateException("getReadableDatabase called recursively");
            var81C383DC12357F6067B70D235C098465_881188848.addTaint(taint);
            throw var81C383DC12357F6067B70D235C098465_881188848;
        } //End block
        try 
        {
SQLiteDatabase var6D7AF3F8AFE93CFCBA25598C00DC4F29_453437407 =             getWritableDatabase();
            var6D7AF3F8AFE93CFCBA25598C00DC4F29_453437407.addTaint(taint);
            return var6D7AF3F8AFE93CFCBA25598C00DC4F29_453437407;
        } //End block
        catch (SQLiteException e)
        {
            if(mName == null)            
            {
            e.addTaint(taint);
            throw e;
            }
        } //End block
        SQLiteDatabase db = null;
        try 
        {
            mIsInitializing = true;
            String path = mContext.getDatabasePath(mName).getPath();
            db = SQLiteDatabase.openDatabase(path, mFactory, SQLiteDatabase.OPEN_READONLY,
                    mErrorHandler);
            if(db.getVersion() != mNewVersion)            
            {
                SQLiteException varB54DB2FDCAA22EBF19303729E283DA36_356026125 = new SQLiteException("Can't upgrade read-only database from version " +
                        db.getVersion() + " to " + mNewVersion + ": " + path);
                varB54DB2FDCAA22EBF19303729E283DA36_356026125.addTaint(taint);
                throw varB54DB2FDCAA22EBF19303729E283DA36_356026125;
            } //End block
            onOpen(db);
            mDatabase = db;
SQLiteDatabase var8D37BF836D5C80F645159E6565338BF6_779912361 =             mDatabase;
            var8D37BF836D5C80F645159E6565338BF6_779912361.addTaint(taint);
            return var8D37BF836D5C80F645159E6565338BF6_779912361;
        } //End block
        finally 
        {
            mIsInitializing = false;
            if(db != null && db != mDatabase)            
            db.close();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.833 -0400", hash_original_method = "C09EB7B9D42A5A795555D7C9A56D8370", hash_generated_method = "8C122B00FF700110C4D2C65D103E2325")
    public synchronized void close() {
        if(mIsInitializing)        
        {
        IllegalStateException var683FBF1FEDEE83227FD63841D9EFDC46_1261208070 = new IllegalStateException("Closed during initialization");
        var683FBF1FEDEE83227FD63841D9EFDC46_1261208070.addTaint(taint);
        throw var683FBF1FEDEE83227FD63841D9EFDC46_1261208070;
        }
        if(mDatabase != null && mDatabase.isOpen())        
        {
            mDatabase.close();
            mDatabase = null;
        } //End block
        // ---------- Original Method ----------
        //if (mIsInitializing) throw new IllegalStateException("Closed during initialization");
        //if (mDatabase != null && mDatabase.isOpen()) {
            //mDatabase.close();
            //mDatabase = null;
        //}
    }

    
    @DSModeled(DSC.SAFE)
    public abstract void onCreate(SQLiteDatabase db);

    
    @DSModeled(DSC.SAFE)
    public abstract void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion);

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.835 -0400", hash_original_method = "E809F845DA52B26B37A0B95640D58A46", hash_generated_method = "5B8D18B99C8B9F27F6E0861A2FFB02A3")
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(newVersion);
        addTaint(oldVersion);
        addTaint(db.getTaint());
        SQLiteException var71B9DCF5C39ED2A7C48292107EBCC0F0_247256588 = new SQLiteException("Can't downgrade database from version " +
                oldVersion + " to " + newVersion);
        var71B9DCF5C39ED2A7C48292107EBCC0F0_247256588.addTaint(taint);
        throw var71B9DCF5C39ED2A7C48292107EBCC0F0_247256588;
        // ---------- Original Method ----------
        //throw new SQLiteException("Can't downgrade database from version " +
                //oldVersion + " to " + newVersion);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.835 -0400", hash_original_method = "4811C8ED58A3ECFEDC0621F514E7FFAC", hash_generated_method = "114D8028AAA729F2C8D5D48D03E2C088")
    public void onOpen(SQLiteDatabase db) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(db.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.835 -0400", hash_original_field = "238370C77E3E3E7DCA380B58BB0FF6CF", hash_generated_field = "073F4465324B7F9FFC720DD01EEA24AC")

    private static final String TAG = SQLiteOpenHelper.class.getSimpleName();
}

