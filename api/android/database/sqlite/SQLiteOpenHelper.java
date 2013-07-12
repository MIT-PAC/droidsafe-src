package android.database.sqlite;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.DefaultDatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.util.Log;

public abstract class SQLiteOpenHelper {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.028 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.028 -0400", hash_original_field = "311C2C8498DF6A626CBDB8AA4193499C", hash_generated_field = "886C24C67739C97CF77B8DD239E412F9")

    private String mName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.029 -0400", hash_original_field = "06389DE86ED19AB1571A41645A1AFADC", hash_generated_field = "3B314DD3362D9759017A383358149E45")

    private CursorFactory mFactory;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.029 -0400", hash_original_field = "8B87C38A8EA38B485FFD08DF439AE2B0", hash_generated_field = "E37741801665C28F1D0231A69288300D")

    private int mNewVersion;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.029 -0400", hash_original_field = "961E4258F7E74A9EAA9E39B39D6F0A80", hash_generated_field = "949BF9C4D224A2E5EB02E79597DEC6F1")

    private SQLiteDatabase mDatabase = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.029 -0400", hash_original_field = "A8B92F87BF2A02DD09F9992E38529E01", hash_generated_field = "F70ACE423FC74AA75F488787A63DC7D9")

    private boolean mIsInitializing = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.029 -0400", hash_original_field = "17F47A6FF3D481E01A6A82252EB7B064", hash_generated_field = "76DD5A0A5A09A890A2237FBF965CCF6C")

    private DatabaseErrorHandler mErrorHandler;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.030 -0400", hash_original_method = "FA08D03545E9DF881DE2A492BC7B90D5", hash_generated_method = "5E6F83AB57D3846D72B269C6A4631576")
    public  SQLiteOpenHelper(Context context, String name, CursorFactory factory, int version) {
        this(context, name, factory, version, new DefaultDatabaseErrorHandler());
        addTaint(version);
        addTaint(factory.getTaint());
        addTaint(name.getTaint());
        addTaint(context.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.031 -0400", hash_original_method = "31439111717724CD584CC4C37B277BA9", hash_generated_method = "0ECBBF786505DFB782B4972126C800A3")
    public  SQLiteOpenHelper(Context context, String name, CursorFactory factory, int version,
            DatabaseErrorHandler errorHandler) {
    if(version < 1)        
        {
        IllegalArgumentException var1DBA27FCE4D803648C04F31EBB168D24_228691923 = new IllegalArgumentException("Version must be >= 1, was " + version);
        var1DBA27FCE4D803648C04F31EBB168D24_228691923.addTaint(taint);
        throw var1DBA27FCE4D803648C04F31EBB168D24_228691923;
        }
    if(errorHandler == null)        
        {
            IllegalArgumentException varB774D6236B7D9EA6C1589D8682A4E28C_1054327532 = new IllegalArgumentException("DatabaseErrorHandler param value can't be null.");
            varB774D6236B7D9EA6C1589D8682A4E28C_1054327532.addTaint(taint);
            throw varB774D6236B7D9EA6C1589D8682A4E28C_1054327532;
        } 
        mContext = context;
        mName = name;
        mFactory = factory;
        mNewVersion = version;
        mErrorHandler = errorHandler;
        
        
        
            
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.031 -0400", hash_original_method = "68E7432F62212BC238811FF4144A34FC", hash_generated_method = "B172A09411344261D05E35DCE6DB109A")
    public String getDatabaseName() {
String varDBF15A5FB8102A5C28D5046A0E92E443_631282529 =         mName;
        varDBF15A5FB8102A5C28D5046A0E92E443_631282529.addTaint(taint);
        return varDBF15A5FB8102A5C28D5046A0E92E443_631282529;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.033 -0400", hash_original_method = "907737C2FD1DDBAF11A72FCBC6C42218", hash_generated_method = "23206674AEFF9233733925BBDC9DB679")
    public synchronized SQLiteDatabase getWritableDatabase() {
    if(mDatabase != null)        
        {
    if(!mDatabase.isOpen())            
            {
                mDatabase = null;
            } 
            else
    if(!mDatabase.isReadOnly())            
            {
SQLiteDatabase var8D37BF836D5C80F645159E6565338BF6_1364856472 =                 mDatabase;
                var8D37BF836D5C80F645159E6565338BF6_1364856472.addTaint(taint);
                return var8D37BF836D5C80F645159E6565338BF6_1364856472;
            } 
        } 
    if(mIsInitializing)        
        {
            IllegalStateException var5BDCB2F09A02E904389D36E0E970279A_828583276 = new IllegalStateException("getWritableDatabase called recursively");
            var5BDCB2F09A02E904389D36E0E970279A_828583276.addTaint(taint);
            throw var5BDCB2F09A02E904389D36E0E970279A_828583276;
        } 
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
            } 
            else
            {
                db = mContext.openOrCreateDatabase(mName, 0, mFactory, mErrorHandler);
            } 
            int version = db.getVersion();
    if(version != mNewVersion)            
            {
                db.beginTransaction();
                try 
                {
    if(version == 0)                    
                    {
                        onCreate(db);
                    } 
                    else
                    {
    if(version > mNewVersion)                        
                        {
                            onDowngrade(db, version, mNewVersion);
                        } 
                        else
                        {
                            onUpgrade(db, version, mNewVersion);
                        } 
                    } 
                    db.setVersion(mNewVersion);
                    db.setTransactionSuccessful();
                } 
                finally 
                {
                    db.endTransaction();
                } 
            } 
            onOpen(db);
            success = true;
SQLiteDatabase var2F732BA7E0C8A6B94C1D7B25B6A078BE_836722767 =             db;
            var2F732BA7E0C8A6B94C1D7B25B6A078BE_836722767.addTaint(taint);
            return var2F732BA7E0C8A6B94C1D7B25B6A078BE_836722767;
        } 
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
                    } 
                    catch (Exception e)
                    {
                    } 
                    mDatabase.unlock();
                } 
                mDatabase = db;
            } 
            else
            {
    if(mDatabase != null)                
                mDatabase.unlock();
    if(db != null)                
                db.close();
            } 
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.035 -0400", hash_original_method = "2895B1DC2B2D9F1953E668AA67DA7E81", hash_generated_method = "01BB95FD45DC1135E0D076CB6B97AD49")
    public synchronized SQLiteDatabase getReadableDatabase() {
    if(mDatabase != null)        
        {
    if(!mDatabase.isOpen())            
            {
                mDatabase = null;
            } 
            else
            {
SQLiteDatabase var8D37BF836D5C80F645159E6565338BF6_1256442190 =                 mDatabase;
                var8D37BF836D5C80F645159E6565338BF6_1256442190.addTaint(taint);
                return var8D37BF836D5C80F645159E6565338BF6_1256442190;
            } 
        } 
    if(mIsInitializing)        
        {
            IllegalStateException var81C383DC12357F6067B70D235C098465_769422358 = new IllegalStateException("getReadableDatabase called recursively");
            var81C383DC12357F6067B70D235C098465_769422358.addTaint(taint);
            throw var81C383DC12357F6067B70D235C098465_769422358;
        } 
        try 
        {
SQLiteDatabase var6D7AF3F8AFE93CFCBA25598C00DC4F29_1496805790 =             getWritableDatabase();
            var6D7AF3F8AFE93CFCBA25598C00DC4F29_1496805790.addTaint(taint);
            return var6D7AF3F8AFE93CFCBA25598C00DC4F29_1496805790;
        } 
        catch (SQLiteException e)
        {
    if(mName == null)            
            {
            e.addTaint(taint);
            throw e;
            }
        } 
        SQLiteDatabase db = null;
        try 
        {
            mIsInitializing = true;
            String path = mContext.getDatabasePath(mName).getPath();
            db = SQLiteDatabase.openDatabase(path, mFactory, SQLiteDatabase.OPEN_READONLY,
                    mErrorHandler);
    if(db.getVersion() != mNewVersion)            
            {
                SQLiteException varB54DB2FDCAA22EBF19303729E283DA36_1373405192 = new SQLiteException("Can't upgrade read-only database from version " +
                        db.getVersion() + " to " + mNewVersion + ": " + path);
                varB54DB2FDCAA22EBF19303729E283DA36_1373405192.addTaint(taint);
                throw varB54DB2FDCAA22EBF19303729E283DA36_1373405192;
            } 
            onOpen(db);
            mDatabase = db;
SQLiteDatabase var8D37BF836D5C80F645159E6565338BF6_901109843 =             mDatabase;
            var8D37BF836D5C80F645159E6565338BF6_901109843.addTaint(taint);
            return var8D37BF836D5C80F645159E6565338BF6_901109843;
        } 
        finally 
        {
            mIsInitializing = false;
    if(db != null && db != mDatabase)            
            db.close();
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.036 -0400", hash_original_method = "C09EB7B9D42A5A795555D7C9A56D8370", hash_generated_method = "5E2672B552517B25FB706EFA973683E4")
    public synchronized void close() {
    if(mIsInitializing)        
        {
        IllegalStateException var683FBF1FEDEE83227FD63841D9EFDC46_1073071447 = new IllegalStateException("Closed during initialization");
        var683FBF1FEDEE83227FD63841D9EFDC46_1073071447.addTaint(taint);
        throw var683FBF1FEDEE83227FD63841D9EFDC46_1073071447;
        }
    if(mDatabase != null && mDatabase.isOpen())        
        {
            mDatabase.close();
            mDatabase = null;
        } 
        
        
        
            
            
        
    }

    
    public abstract void onCreate(SQLiteDatabase db);

    
    public abstract void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.037 -0400", hash_original_method = "E809F845DA52B26B37A0B95640D58A46", hash_generated_method = "8B1633F267D7684087002AC537E81205")
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        
        addTaint(newVersion);
        addTaint(oldVersion);
        addTaint(db.getTaint());
        SQLiteException var71B9DCF5C39ED2A7C48292107EBCC0F0_2145392268 = new SQLiteException("Can't downgrade database from version " +
                oldVersion + " to " + newVersion);
        var71B9DCF5C39ED2A7C48292107EBCC0F0_2145392268.addTaint(taint);
        throw var71B9DCF5C39ED2A7C48292107EBCC0F0_2145392268;
        
        
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.038 -0400", hash_original_method = "4811C8ED58A3ECFEDC0621F514E7FFAC", hash_generated_method = "114D8028AAA729F2C8D5D48D03E2C088")
    public void onOpen(SQLiteDatabase db) {
        
        addTaint(db.getTaint());
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.038 -0400", hash_original_field = "238370C77E3E3E7DCA380B58BB0FF6CF", hash_generated_field = "073F4465324B7F9FFC720DD01EEA24AC")

    private static final String TAG = SQLiteOpenHelper.class.getSimpleName();
}

