package android.webkit;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;
import android.webkit.CacheManager.CacheResult;
import android.webkit.CookieManager.Cookie;





public class WebViewDatabase {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.485 -0400", hash_original_field = "867BB3294E9C68C99FCD8CAE06CC4189", hash_generated_field = "93D9ABAC661FEA809DA54BD9E7E9D9D3")

    private final Object mCookieLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.485 -0400", hash_original_field = "8002E7A58D1BE5163381E484BA29B73A", hash_generated_field = "B9AA262C50068E49E8D4989E6CB68357")

    private final Object mPasswordLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.485 -0400", hash_original_field = "1F62250EEFC8639157DBB68AD5BDC8F7", hash_generated_field = "FFB3B56DC6131C4C61A59C58082777D9")

    private final Object mFormLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.486 -0400", hash_original_field = "4540D6026C066EC4C652DDF2BCB91F3D", hash_generated_field = "5C47FB4E53C3D9C9795AB924F63FC85D")

    private final Object mHttpAuthLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.486 -0400", hash_original_field = "82073B9F728953BFC0E99AB45C8BBB4A", hash_generated_field = "E5CA3845DA8FE08BE201D5EDF15F54DD")

    private boolean mInitialized = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.486 -0400", hash_original_method = "EFB05B9D3FCAB305323B10379F1EC778", hash_generated_method = "0851865C68ABC1653EF41F96E16ADD4F")
    private  WebViewDatabase(final Context context) {
        addTaint(context.getTaint());
        new Thread() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.486 -0400", hash_original_method = "016F23FCFDABFB49215E1C5AD86A4960", hash_generated_method = "857237709B575C3CEAE7C4725FBD2553")
        @Override
        public void run() {
            init(context);
            // ---------- Original Method ----------
            //init(context);
        }
}.start();
        // ---------- Original Method ----------
        //new Thread() {
            //@Override
            //public void run() {
                //init(context);
            //}
        //}.start();
    }

    
    public static synchronized WebViewDatabase getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new WebViewDatabase(context);
        }
        return mInstance;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.487 -0400", hash_original_method = "AC87AD0E19559694D58F1943BD15C1D5", hash_generated_method = "0D1BDC6D908C33603AEFD0D02BD4C1B6")
    private synchronized void init(Context context) {
        addTaint(context.getTaint());
        if(mInitialized)        
        {
            return;
        } //End block
        initDatabase(context);
        if(JniUtil.useChromiumHttpStack())        
        {
            context.deleteDatabase(CACHE_DATABASE_FILE);
        } //End block
        else
        {
            initCacheDatabase(context);
        } //End block
        mInitialized = true;
        notify();
        // ---------- Original Method ----------
        //if (mInitialized) {
            //return;
        //}
        //initDatabase(context);
        //if (JniUtil.useChromiumHttpStack()) {
            //context.deleteDatabase(CACHE_DATABASE_FILE);
        //} else {
            //initCacheDatabase(context);
        //}
        //mInitialized = true;
        //notify();
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.487 -0400", hash_original_method = "CE06D258DB88B89F42DED68141C198E0", hash_generated_method = "8ED787C8A111B97FFF6227F82334906C")
    private void initDatabase(Context context) {
        addTaint(context.getTaint());
        try 
        {
            mDatabase = context.openOrCreateDatabase(DATABASE_FILE, 0, null);
        } //End block
        catch (SQLiteException e)
        {
            if(context.deleteDatabase(DATABASE_FILE))            
            {
                mDatabase = context.openOrCreateDatabase(DATABASE_FILE, 0,
                        null);
            } //End block
        } //End block
        mDatabase.enableWriteAheadLogging();
        if(mDatabase == null)        
        {
            mInitialized = true;
            notify();
            return;
        } //End block
        if(mDatabase.getVersion() != DATABASE_VERSION)        
        {
            mDatabase.beginTransactionNonExclusive();
            try 
            {
                upgradeDatabase();
                mDatabase.setTransactionSuccessful();
            } //End block
            finally 
            {
                mDatabase.endTransaction();
            } //End block
        } //End block
        mDatabase.setLockingEnabled(false);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.490 -0400", hash_original_method = "C7A89DE182CA76C10CB3961C893695C2", hash_generated_method = "B7B953F9F84E18EEB6FF32F047B97209")
    private void initCacheDatabase(Context context) {
        addTaint(context.getTaint());
        try 
        {
            mCacheDatabase = context.openOrCreateDatabase(
                    CACHE_DATABASE_FILE, 0, null);
        } //End block
        catch (SQLiteException e)
        {
            if(context.deleteDatabase(CACHE_DATABASE_FILE))            
            {
                mCacheDatabase = context.openOrCreateDatabase(
                        CACHE_DATABASE_FILE, 0, null);
            } //End block
        } //End block
        mCacheDatabase.enableWriteAheadLogging();
        if(mCacheDatabase == null)        
        {
            mInitialized = true;
            notify();
            return;
        } //End block
        if(mCacheDatabase.getVersion() != CACHE_DATABASE_VERSION)        
        {
            mCacheDatabase.beginTransactionNonExclusive();
            try 
            {
                upgradeCacheDatabase();
                bootstrapCacheDatabase();
                mCacheDatabase.setTransactionSuccessful();
            } //End block
            finally 
            {
                mCacheDatabase.endTransaction();
            } //End block
            CacheManager.removeAllCacheFiles();
        } //End block
        mCacheDatabase.execSQL("PRAGMA read_uncommitted = true;");
        mCacheDatabase.setLockingEnabled(false);
        mCacheInserter =
                new DatabaseUtils.InsertHelper(mCacheDatabase,
                        "cache");
        mCacheUrlColIndex = mCacheInserter
                            .getColumnIndex(CACHE_URL_COL);
        mCacheFilePathColIndex = mCacheInserter
                .getColumnIndex(CACHE_FILE_PATH_COL);
        mCacheLastModifyColIndex = mCacheInserter
                .getColumnIndex(CACHE_LAST_MODIFY_COL);
        mCacheETagColIndex = mCacheInserter
                .getColumnIndex(CACHE_ETAG_COL);
        mCacheExpiresColIndex = mCacheInserter
                .getColumnIndex(CACHE_EXPIRES_COL);
        mCacheExpiresStringColIndex = mCacheInserter
                .getColumnIndex(CACHE_EXPIRES_STRING_COL);
        mCacheMimeTypeColIndex = mCacheInserter
                .getColumnIndex(CACHE_MIMETYPE_COL);
        mCacheEncodingColIndex = mCacheInserter
                .getColumnIndex(CACHE_ENCODING_COL);
        mCacheHttpStatusColIndex = mCacheInserter
                .getColumnIndex(CACHE_HTTP_STATUS_COL);
        mCacheLocationColIndex = mCacheInserter
                .getColumnIndex(CACHE_LOCATION_COL);
        mCacheContentLengthColIndex = mCacheInserter
                .getColumnIndex(CACHE_CONTENTLENGTH_COL);
        mCacheContentDispositionColIndex = mCacheInserter
                .getColumnIndex(CACHE_CONTENTDISPOSITION_COL);
        mCacheCrossDomainColIndex = mCacheInserter
                .getColumnIndex(CACHE_CROSSDOMAIN_COL);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    private static void upgradeDatabase() {
        upgradeDatabaseToV10();
        upgradeDatabaseFromV10ToV11();
        mDatabase.setVersion(DATABASE_VERSION);
    }

    
    @DSModeled(DSC.BAN)
    private static void upgradeDatabaseFromV10ToV11() {
        int oldVersion = mDatabase.getVersion();
        if (oldVersion >= 11) {
            return;
        }
        if (JniUtil.useChromiumHttpStack()) {
            mDatabase.execSQL("DROP TABLE IF EXISTS " + mTableNames[TABLE_COOKIES_ID]);
            mDatabase.execSQL("DROP TABLE IF EXISTS cache");
        }
        Cursor c = mDatabase.query(mTableNames[TABLE_FORMURL_ID], null, null,
                null, null, null, null);
        while (c.moveToNext()) {
            String urlId = Long.toString(c.getLong(c.getColumnIndex(ID_COL)));
            String url = c.getString(c.getColumnIndex(FORMURL_URL_COL));
            ContentValues cv = new ContentValues(1);
            cv.put(FORMURL_URL_COL, WebTextView.urlForAutoCompleteData(url));
            mDatabase.update(mTableNames[TABLE_FORMURL_ID], cv, ID_COL + "=?",
                    new String[] { urlId });
        }
        c.close();
    }

    
    @DSModeled(DSC.BAN)
    private static void upgradeDatabaseToV10() {
        int oldVersion = mDatabase.getVersion();
        if (oldVersion >= 10) {
            return;
        }
        if (oldVersion != 0) {
            Log.i(LOGTAG, "Upgrading database from version "
                    + oldVersion + " to "
                    + DATABASE_VERSION + ", which will destroy old data");
        }
        if (9 == oldVersion) {
            mDatabase.execSQL("DROP TABLE IF EXISTS "
                    + mTableNames[TABLE_HTTPAUTH_ID]);
            mDatabase.execSQL("CREATE TABLE " + mTableNames[TABLE_HTTPAUTH_ID]
                    + " (" + ID_COL + " INTEGER PRIMARY KEY, "
                    + HTTPAUTH_HOST_COL + " TEXT, " + HTTPAUTH_REALM_COL
                    + " TEXT, " + HTTPAUTH_USERNAME_COL + " TEXT, "
                    + HTTPAUTH_PASSWORD_COL + " TEXT," + " UNIQUE ("
                    + HTTPAUTH_HOST_COL + ", " + HTTPAUTH_REALM_COL
                    + ") ON CONFLICT REPLACE);");
            return;
        }
        mDatabase.execSQL("DROP TABLE IF EXISTS "
                + mTableNames[TABLE_COOKIES_ID]);
        mDatabase.execSQL("DROP TABLE IF EXISTS cache");
        mDatabase.execSQL("DROP TABLE IF EXISTS "
                + mTableNames[TABLE_FORMURL_ID]);
        mDatabase.execSQL("DROP TABLE IF EXISTS "
                + mTableNames[TABLE_FORMDATA_ID]);
        mDatabase.execSQL("DROP TABLE IF EXISTS "
                + mTableNames[TABLE_HTTPAUTH_ID]);
        mDatabase.execSQL("DROP TABLE IF EXISTS "
                + mTableNames[TABLE_PASSWORD_ID]);
        mDatabase.execSQL("CREATE TABLE " + mTableNames[TABLE_COOKIES_ID]
                + " (" + ID_COL + " INTEGER PRIMARY KEY, "
                + COOKIES_NAME_COL + " TEXT, " + COOKIES_VALUE_COL
                + " TEXT, " + COOKIES_DOMAIN_COL + " TEXT, "
                + COOKIES_PATH_COL + " TEXT, " + COOKIES_EXPIRES_COL
                + " INTEGER, " + COOKIES_SECURE_COL + " INTEGER" + ");");
        mDatabase.execSQL("CREATE INDEX cookiesIndex ON "
                + mTableNames[TABLE_COOKIES_ID] + " (path)");
        mDatabase.execSQL("CREATE TABLE " + mTableNames[TABLE_FORMURL_ID]
                + " (" + ID_COL + " INTEGER PRIMARY KEY, " + FORMURL_URL_COL
                + " TEXT" + ");");
        mDatabase.execSQL("CREATE TABLE " + mTableNames[TABLE_FORMDATA_ID]
                + " (" + ID_COL + " INTEGER PRIMARY KEY, "
                + FORMDATA_URLID_COL + " INTEGER, " + FORMDATA_NAME_COL
                + " TEXT, " + FORMDATA_VALUE_COL + " TEXT," + " UNIQUE ("
                + FORMDATA_URLID_COL + ", " + FORMDATA_NAME_COL + ", "
                + FORMDATA_VALUE_COL + ") ON CONFLICT IGNORE);");
        mDatabase.execSQL("CREATE TABLE " + mTableNames[TABLE_HTTPAUTH_ID]
                + " (" + ID_COL + " INTEGER PRIMARY KEY, "
                + HTTPAUTH_HOST_COL + " TEXT, " + HTTPAUTH_REALM_COL
                + " TEXT, " + HTTPAUTH_USERNAME_COL + " TEXT, "
                + HTTPAUTH_PASSWORD_COL + " TEXT," + " UNIQUE ("
                + HTTPAUTH_HOST_COL + ", " + HTTPAUTH_REALM_COL
                + ") ON CONFLICT REPLACE);");
        mDatabase.execSQL("CREATE TABLE " + mTableNames[TABLE_PASSWORD_ID]
                + " (" + ID_COL + " INTEGER PRIMARY KEY, "
                + PASSWORD_HOST_COL + " TEXT, " + PASSWORD_USERNAME_COL
                + " TEXT, " + PASSWORD_PASSWORD_COL + " TEXT," + " UNIQUE ("
                + PASSWORD_HOST_COL + ", " + PASSWORD_USERNAME_COL
                + ") ON CONFLICT REPLACE);");
    }

    
    @DSModeled(DSC.BAN)
    private static void upgradeCacheDatabase() {
        int oldVersion = mCacheDatabase.getVersion();
        if (oldVersion != 0) {
            Log.i(LOGTAG, "Upgrading cache database from version "
                    + oldVersion + " to "
                    + CACHE_DATABASE_VERSION + ", which will destroy all old data");
        }
        mCacheDatabase.execSQL("DROP TABLE IF EXISTS cache");
        mCacheDatabase.setVersion(CACHE_DATABASE_VERSION);
    }

    
    @DSModeled(DSC.BAN)
    private static void bootstrapCacheDatabase() {
        if (mCacheDatabase != null) {
            mCacheDatabase.execSQL("CREATE TABLE cache"
                    + " (" + ID_COL + " INTEGER PRIMARY KEY, " + CACHE_URL_COL
                    + " TEXT, " + CACHE_FILE_PATH_COL + " TEXT, "
                    + CACHE_LAST_MODIFY_COL + " TEXT, " + CACHE_ETAG_COL
                    + " TEXT, " + CACHE_EXPIRES_COL + " INTEGER, "
                    + CACHE_EXPIRES_STRING_COL + " TEXT, "
                    + CACHE_MIMETYPE_COL + " TEXT, " + CACHE_ENCODING_COL
                    + " TEXT," + CACHE_HTTP_STATUS_COL + " INTEGER, "
                    + CACHE_LOCATION_COL + " TEXT, " + CACHE_CONTENTLENGTH_COL
                    + " INTEGER, " + CACHE_CONTENTDISPOSITION_COL + " TEXT, "
                    + CACHE_CROSSDOMAIN_COL + " TEXT,"
                    + " UNIQUE (" + CACHE_URL_COL + ") ON CONFLICT REPLACE);");
            mCacheDatabase.execSQL("CREATE INDEX cacheUrlIndex ON cache ("
                    + CACHE_URL_COL + ")");
        }
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.492 -0400", hash_original_method = "B19C14CCA683C2C1072DDA1B7A6274D5", hash_generated_method = "A92C21C8D2E361CBF6588F4AE3AC0B4E")
    private boolean checkInitialized() {
        synchronized
(this)        {
            while
(!mInitialized)            
            {
                try 
                {
                    wait();
                } //End block
                catch (InterruptedException e)
                {
                } //End block
            } //End block
        } //End block
        boolean varE1196345D361F8ECF9424BF755C2F21D_481635932 = (mDatabase != null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2119618956 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2119618956;
        // ---------- Original Method ----------
        //synchronized (this) {
            //while (!mInitialized) {
                //try {
                    //wait();
                //} catch (InterruptedException e) {
                    //Log.e(LOGTAG, "Caught exception while checking " +
                                  //"initialization");
                    //Log.e(LOGTAG, Log.getStackTraceString(e));
                //}
            //}
        //}
        //return mDatabase != null;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.492 -0400", hash_original_method = "CBFCA06012BEB8B609A8EBC6EEC6D1A4", hash_generated_method = "D75CD6B40F7D5B19D08D7484FBDD5116")
    private boolean hasEntries(int tableId) {
        addTaint(tableId);
        if(!checkInitialized())        
        {
            boolean var68934A3E9455FA72420237EB05902327_1632830250 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1292942518 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1292942518;
        } //End block
        Cursor cursor = null;
        boolean ret = false;
        try 
        {
            cursor = mDatabase.query(mTableNames[tableId], ID_PROJECTION,
                    null, null, null, null, null);
            ret = cursor.moveToFirst() == true;
        } //End block
        catch (IllegalStateException e)
        {
        } //End block
        finally 
        {
            if(cursor != null)            
            cursor.close();
        } //End block
        boolean var2CB9DF9898E55FD0AD829DC202DDBD1C_501876037 = (ret);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1118763769 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1118763769;
        // ---------- Original Method ----------
        //if (!checkInitialized()) {
            //return false;
        //}
        //Cursor cursor = null;
        //boolean ret = false;
        //try {
            //cursor = mDatabase.query(mTableNames[tableId], ID_PROJECTION,
                    //null, null, null, null, null);
            //ret = cursor.moveToFirst() == true;
        //} catch (IllegalStateException e) {
            //Log.e(LOGTAG, "hasEntries", e);
        //} finally {
            //if (cursor != null) cursor.close();
        //}
        //return ret;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.494 -0400", hash_original_method = "4D94521780B9AD3D8F70E78E8CBCD3E0", hash_generated_method = "819EBCB88D11F7D22B3DEB8F964D59C0")
     ArrayList<Cookie> getCookiesForDomain(String domain) {
        addTaint(domain.getTaint());
        ArrayList<Cookie> list = new ArrayList<Cookie>();
        if(domain == null || !checkInitialized())        
        {
ArrayList<Cookie> varED12C351C2E8CA4F85F097DDC7E77B4D_1482456512 =             list;
            varED12C351C2E8CA4F85F097DDC7E77B4D_1482456512.addTaint(taint);
            return varED12C351C2E8CA4F85F097DDC7E77B4D_1482456512;
        } //End block
        synchronized
(mCookieLock)        {
            final String[] columns = new String[] {
                    ID_COL, COOKIES_DOMAIN_COL, COOKIES_PATH_COL,
                    COOKIES_NAME_COL, COOKIES_VALUE_COL, COOKIES_EXPIRES_COL,
                    COOKIES_SECURE_COL
            };
            final String selection = "(" + COOKIES_DOMAIN_COL
                    + " GLOB '*' || ?)";
            Cursor cursor = null;
            try 
            {
                cursor = mDatabase.query(mTableNames[TABLE_COOKIES_ID],
                        columns, selection, new String[] { domain }, null, null,
                        null);
                if(cursor.moveToFirst())                
                {
                    int domainCol = cursor.getColumnIndex(COOKIES_DOMAIN_COL);
                    int pathCol = cursor.getColumnIndex(COOKIES_PATH_COL);
                    int nameCol = cursor.getColumnIndex(COOKIES_NAME_COL);
                    int valueCol = cursor.getColumnIndex(COOKIES_VALUE_COL);
                    int expiresCol = cursor.getColumnIndex(COOKIES_EXPIRES_COL);
                    int secureCol = cursor.getColumnIndex(COOKIES_SECURE_COL);
                    do {
                        {
                            Cookie cookie = new Cookie();
                            cookie.domain = cursor.getString(domainCol);
                            cookie.path = cursor.getString(pathCol);
                            cookie.name = cursor.getString(nameCol);
                            cookie.value = cursor.getString(valueCol);
                            if(cursor.isNull(expiresCol))                            
                            {
                                cookie.expires = -1;
                            } //End block
                            else
                            {
                                cookie.expires = cursor.getLong(expiresCol);
                            } //End block
                            cookie.secure = cursor.getShort(secureCol) != 0;
                            cookie.mode = Cookie.MODE_NORMAL;
                            list.add(cookie);
                        } //End block
} while (cursor.moveToNext());
                } //End block
            } //End block
            catch (IllegalStateException e)
            {
            } //End block
            finally 
            {
                if(cursor != null)                
                cursor.close();
            } //End block
ArrayList<Cookie> varED12C351C2E8CA4F85F097DDC7E77B4D_1278538368 =             list;
            varED12C351C2E8CA4F85F097DDC7E77B4D_1278538368.addTaint(taint);
            return varED12C351C2E8CA4F85F097DDC7E77B4D_1278538368;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.495 -0400", hash_original_method = "BC23D2938EE88E31CA87024518493BE2", hash_generated_method = "C43938F5DE948F0ABDFD2070CF2A98D2")
     void deleteCookies(String domain, String path, String name) {
        addTaint(name.getTaint());
        addTaint(path.getTaint());
        addTaint(domain.getTaint());
        if(domain == null || !checkInitialized())        
        {
            return;
        } //End block
        synchronized
(mCookieLock)        {
            final String where = "(" + COOKIES_DOMAIN_COL + " == ?) AND ("
                    + COOKIES_PATH_COL + " == ?) AND (" + COOKIES_NAME_COL
                    + " == ?)";
            mDatabase.delete(mTableNames[TABLE_COOKIES_ID], where,
                    new String[] { domain, path, name });
        } //End block
        // ---------- Original Method ----------
        //if (domain == null || !checkInitialized()) {
            //return;
        //}
        //synchronized (mCookieLock) {
            //final String where = "(" + COOKIES_DOMAIN_COL + " == ?) AND ("
                    //+ COOKIES_PATH_COL + " == ?) AND (" + COOKIES_NAME_COL
                    //+ " == ?)";
            //mDatabase.delete(mTableNames[TABLE_COOKIES_ID], where,
                    //new String[] { domain, path, name });
        //}
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.495 -0400", hash_original_method = "33710CB1E65A2C52E9ABEE23433BB87F", hash_generated_method = "1208C4C0CE57D44963C19C22AD3D6115")
     void addCookie(Cookie cookie) {
        addTaint(cookie.getTaint());
        if(cookie.domain == null || cookie.path == null || cookie.name == null
                || !checkInitialized())        
        {
            return;
        } //End block
        synchronized
(mCookieLock)        {
            ContentValues cookieVal = new ContentValues();
            cookieVal.put(COOKIES_DOMAIN_COL, cookie.domain);
            cookieVal.put(COOKIES_PATH_COL, cookie.path);
            cookieVal.put(COOKIES_NAME_COL, cookie.name);
            cookieVal.put(COOKIES_VALUE_COL, cookie.value);
            if(cookie.expires != -1)            
            {
                cookieVal.put(COOKIES_EXPIRES_COL, cookie.expires);
            } //End block
            cookieVal.put(COOKIES_SECURE_COL, cookie.secure);
            mDatabase.insert(mTableNames[TABLE_COOKIES_ID], null, cookieVal);
        } //End block
        // ---------- Original Method ----------
        //if (cookie.domain == null || cookie.path == null || cookie.name == null
                //|| !checkInitialized()) {
            //return;
        //}
        //synchronized (mCookieLock) {
            //ContentValues cookieVal = new ContentValues();
            //cookieVal.put(COOKIES_DOMAIN_COL, cookie.domain);
            //cookieVal.put(COOKIES_PATH_COL, cookie.path);
            //cookieVal.put(COOKIES_NAME_COL, cookie.name);
            //cookieVal.put(COOKIES_VALUE_COL, cookie.value);
            //if (cookie.expires != -1) {
                //cookieVal.put(COOKIES_EXPIRES_COL, cookie.expires);
            //}
            //cookieVal.put(COOKIES_SECURE_COL, cookie.secure);
            //mDatabase.insert(mTableNames[TABLE_COOKIES_ID], null, cookieVal);
        //}
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.496 -0400", hash_original_method = "83E6237273AAD0C9F4D2DED923ACAFB7", hash_generated_method = "820177B30557F6F5E73B4E8608FD3FED")
     boolean hasCookies() {
        synchronized
(mCookieLock)        {
            boolean varDC4B474C1C5ADF138EE01798F6B0F909_278696792 = (hasEntries(TABLE_COOKIES_ID));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_683831007 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_683831007;
        } //End block
        // ---------- Original Method ----------
        //synchronized (mCookieLock) {
            //return hasEntries(TABLE_COOKIES_ID);
        //}
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.496 -0400", hash_original_method = "3E1D9455881C3029C0C51566A563B8F4", hash_generated_method = "99BB8A0AFB075E7668D74A6B4049265C")
     void clearCookies() {
        if(!checkInitialized())        
        {
            return;
        } //End block
        synchronized
(mCookieLock)        {
            mDatabase.delete(mTableNames[TABLE_COOKIES_ID], null, null);
        } //End block
        // ---------- Original Method ----------
        //if (!checkInitialized()) {
            //return;
        //}
        //synchronized (mCookieLock) {
            //mDatabase.delete(mTableNames[TABLE_COOKIES_ID], null, null);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.496 -0400", hash_original_method = "CAA5F0320575B2151920B0F146B122B7", hash_generated_method = "BB64A8073A1DE6E8A19C514111CEDB1F")
     void clearSessionCookies() {
        if(!checkInitialized())        
        {
            return;
        } //End block
        final String sessionExpired = COOKIES_EXPIRES_COL + " ISNULL";
        synchronized
(mCookieLock)        {
            mDatabase.delete(mTableNames[TABLE_COOKIES_ID], sessionExpired,
                    null);
        } //End block
        // ---------- Original Method ----------
        //if (!checkInitialized()) {
            //return;
        //}
        //final String sessionExpired = COOKIES_EXPIRES_COL + " ISNULL";
        //synchronized (mCookieLock) {
            //mDatabase.delete(mTableNames[TABLE_COOKIES_ID], sessionExpired,
                    //null);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.497 -0400", hash_original_method = "AD90F95A26E2D9ECD94EF58E091F4A84", hash_generated_method = "9E54FC9041F15868428F4CCF226A7F25")
     void clearExpiredCookies(long now) {
        addTaint(now);
        if(!checkInitialized())        
        {
            return;
        } //End block
        final String expires = COOKIES_EXPIRES_COL + " <= ?";
        synchronized
(mCookieLock)        {
            mDatabase.delete(mTableNames[TABLE_COOKIES_ID], expires,
                    new String[] { Long.toString(now) });
        } //End block
        // ---------- Original Method ----------
        //if (!checkInitialized()) {
            //return;
        //}
        //final String expires = COOKIES_EXPIRES_COL + " <= ?";
        //synchronized (mCookieLock) {
            //mDatabase.delete(mTableNames[TABLE_COOKIES_ID], expires,
                    //new String[] { Long.toString(now) });
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.497 -0400", hash_original_method = "26A436743D42208E44F8DC7C1FFF5A77", hash_generated_method = "D45847F592A9288E16B4C6619CB4BAE3")
     boolean startCacheTransaction() {
        if(++mCacheTransactionRefcount == 1)        
        {
            if(!Thread.currentThread().equals(
                    WebViewWorker.getHandler().getLooper().getThread()))            
            {
            } //End block
            mCacheDatabase.beginTransactionNonExclusive();
            boolean varB326B5062B2F0E69046810717534CB09_1900330761 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_921590636 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_921590636;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_282571613 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_61330088 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_61330088;
        // ---------- Original Method ----------
        //if (++mCacheTransactionRefcount == 1) {
            //if (!Thread.currentThread().equals(
                    //WebViewWorker.getHandler().getLooper().getThread())) {
                //Log.w(LOGTAG, "startCacheTransaction should be called from "
                        //+ "WebViewWorkerThread instead of from "
                        //+ Thread.currentThread().getName());
            //}
            //mCacheDatabase.beginTransactionNonExclusive();
            //return true;
        //}
        //return false;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.497 -0400", hash_original_method = "14B92CCE9ED71BB98EE6E80EBC3B995B", hash_generated_method = "7A8203DFFC1240C9698D1A3144B7975B")
     boolean endCacheTransaction() {
        if(--mCacheTransactionRefcount == 0)        
        {
            if(!Thread.currentThread().equals(
                    WebViewWorker.getHandler().getLooper().getThread()))            
            {
            } //End block
            try 
            {
                mCacheDatabase.setTransactionSuccessful();
            } //End block
            finally 
            {
                mCacheDatabase.endTransaction();
            } //End block
            boolean varB326B5062B2F0E69046810717534CB09_197231311 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2082793128 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2082793128;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_160495224 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1207665811 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1207665811;
        // ---------- Original Method ----------
        //if (--mCacheTransactionRefcount == 0) {
            //if (!Thread.currentThread().equals(
                    //WebViewWorker.getHandler().getLooper().getThread())) {
                //Log.w(LOGTAG, "endCacheTransaction should be called from "
                        //+ "WebViewWorkerThread instead of from "
                        //+ Thread.currentThread().getName());
            //}
            //try {
                //mCacheDatabase.setTransactionSuccessful();
            //} finally {
                //mCacheDatabase.endTransaction();
            //}
            //return true;
        //}
        //return false;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.499 -0400", hash_original_method = "BF73224910862A6343E046C49771A81E", hash_generated_method = "62B489DCC5AF390DAC4458B63653FFD9")
     CacheResult getCache(String url) {
        addTaint(url.getTaint());
        if(url == null || !checkInitialized())        
        {
CacheResult var540C13E9E156B687226421B24F2DF178_1653393166 =             null;
            var540C13E9E156B687226421B24F2DF178_1653393166.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1653393166;
        } //End block
        Cursor cursor = null;
        final String query = "SELECT filepath, lastmodify, etag, expires, "
                + "expiresstring, mimetype, encoding, httpstatus, location, contentlength, "
                + "contentdisposition, crossdomain FROM cache WHERE url = ?";
        try 
        {
            cursor = mCacheDatabase.rawQuery(query, new String[] { url });
            if(cursor.moveToFirst())            
            {
                CacheResult ret = new CacheResult();
                ret.localPath = cursor.getString(0);
                ret.lastModified = cursor.getString(1);
                ret.etag = cursor.getString(2);
                ret.expires = cursor.getLong(3);
                ret.expiresString = cursor.getString(4);
                ret.mimeType = cursor.getString(5);
                ret.encoding = cursor.getString(6);
                ret.httpStatusCode = cursor.getInt(7);
                ret.location = cursor.getString(8);
                ret.contentLength = cursor.getLong(9);
                ret.contentdisposition = cursor.getString(10);
                ret.crossDomain = cursor.getString(11);
CacheResult varEDFF4FBBF053B5DC2B444ADFA049EE0F_1043153344 =                 ret;
                varEDFF4FBBF053B5DC2B444ADFA049EE0F_1043153344.addTaint(taint);
                return varEDFF4FBBF053B5DC2B444ADFA049EE0F_1043153344;
            } //End block
        } //End block
        catch (IllegalStateException e)
        {
        } //End block
        finally 
        {
            if(cursor != null)            
            cursor.close();
        } //End block
CacheResult var540C13E9E156B687226421B24F2DF178_367889668 =         null;
        var540C13E9E156B687226421B24F2DF178_367889668.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_367889668;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.500 -0400", hash_original_method = "10415454EB24D9D06B07AD8A5863D117", hash_generated_method = "462197C7575AB43B2E552637537D2E6F")
     void removeCache(String url) {
        addTaint(url.getTaint());
        if(url == null || !checkInitialized())        
        {
            return;
        } //End block
        mCacheDatabase.execSQL("DELETE FROM cache WHERE url = ?", new String[] { url });
        // ---------- Original Method ----------
        //assert !JniUtil.useChromiumHttpStack();
        //if (url == null || !checkInitialized()) {
            //return;
        //}
        //mCacheDatabase.execSQL("DELETE FROM cache WHERE url = ?", new String[] { url });
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.500 -0400", hash_original_method = "C4FACCF94A8569C78058717A9665F703", hash_generated_method = "7CAC807D4E10D806454E462F731BE6DD")
     void addCache(String url, CacheResult c) {
        addTaint(c.getTaint());
        addTaint(url.getTaint());
        if(url == null || !checkInitialized())        
        {
            return;
        } //End block
        mCacheInserter.prepareForInsert();
        mCacheInserter.bind(mCacheUrlColIndex, url);
        mCacheInserter.bind(mCacheFilePathColIndex, c.localPath);
        mCacheInserter.bind(mCacheLastModifyColIndex, c.lastModified);
        mCacheInserter.bind(mCacheETagColIndex, c.etag);
        mCacheInserter.bind(mCacheExpiresColIndex, c.expires);
        mCacheInserter.bind(mCacheExpiresStringColIndex, c.expiresString);
        mCacheInserter.bind(mCacheMimeTypeColIndex, c.mimeType);
        mCacheInserter.bind(mCacheEncodingColIndex, c.encoding);
        mCacheInserter.bind(mCacheHttpStatusColIndex, c.httpStatusCode);
        mCacheInserter.bind(mCacheLocationColIndex, c.location);
        mCacheInserter.bind(mCacheContentLengthColIndex, c.contentLength);
        mCacheInserter.bind(mCacheContentDispositionColIndex,
                c.contentdisposition);
        mCacheInserter.bind(mCacheCrossDomainColIndex, c.crossDomain);
        mCacheInserter.execute();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.500 -0400", hash_original_method = "67241BF201ED077F6E669112ABB44844", hash_generated_method = "95748B92109956C5681FA87E0602B19D")
     void clearCache() {
        if(!checkInitialized())        
        {
            return;
        } //End block
        mCacheDatabase.delete("cache", null, null);
        // ---------- Original Method ----------
        //if (!checkInitialized()) {
            //return;
        //}
        //mCacheDatabase.delete("cache", null, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.501 -0400", hash_original_method = "0A5B6EFF79BC3227EAB74E5615633418", hash_generated_method = "0AFE9D00CA75F83312A5A8A76198C75A")
     boolean hasCache() {
        if(!checkInitialized())        
        {
            boolean var68934A3E9455FA72420237EB05902327_218206086 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1751588346 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1751588346;
        } //End block
        Cursor cursor = null;
        boolean ret = false;
        try 
        {
            cursor = mCacheDatabase.query("cache", ID_PROJECTION,
                    null, null, null, null, null);
            ret = cursor.moveToFirst() == true;
        } //End block
        catch (IllegalStateException e)
        {
        } //End block
        finally 
        {
            if(cursor != null)            
            cursor.close();
        } //End block
        boolean var2CB9DF9898E55FD0AD829DC202DDBD1C_1750919704 = (ret);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_257941816 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_257941816;
        // ---------- Original Method ----------
        //if (!checkInitialized()) {
            //return false;
        //}
        //Cursor cursor = null;
        //boolean ret = false;
        //try {
            //cursor = mCacheDatabase.query("cache", ID_PROJECTION,
                    //null, null, null, null, null);
            //ret = cursor.moveToFirst() == true;
        //} catch (IllegalStateException e) {
            //Log.e(LOGTAG, "hasCache", e);
        //} finally {
            //if (cursor != null) cursor.close();
        //}
        //return ret;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.502 -0400", hash_original_method = "08C6E9C5D3BD785D378572A4A550228E", hash_generated_method = "215094ABA08E6002D0ADD1BB47A5C69C")
     long getCacheTotalSize() {
        if(mCacheDatabase == null)        
        {
            long varCFCD208495D565EF66E7DFF9F98764DA_1626128967 = (0);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_589631554 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_589631554;
        } //End block
        long size = 0;
        Cursor cursor = null;
        final String query = "SELECT SUM(contentlength) as sum FROM cache";
        try 
        {
            cursor = mCacheDatabase.rawQuery(query, null);
            if(cursor.moveToFirst())            
            {
                size = cursor.getLong(0);
            } //End block
        } //End block
        catch (IllegalStateException e)
        {
        } //End block
        finally 
        {
            if(cursor != null)            
            cursor.close();
        } //End block
        long varF7BD60B75B29D79B660A2859395C1A24_1118089985 = (size);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_343079121 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_343079121;
        // ---------- Original Method ----------
        //if (mCacheDatabase == null) {
            //return 0;
        //}
        //long size = 0;
        //Cursor cursor = null;
        //final String query = "SELECT SUM(contentlength) as sum FROM cache";
        //try {
            //cursor = mCacheDatabase.rawQuery(query, null);
            //if (cursor.moveToFirst()) {
                //size = cursor.getLong(0);
            //}
        //} catch (IllegalStateException e) {
            //Log.e(LOGTAG, "getCacheTotalSize", e);
        //} finally {
            //if (cursor != null) cursor.close();
        //}
        //return size;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.503 -0400", hash_original_method = "E1CB3EA921D4F41F15D60CB73EFC3B4C", hash_generated_method = "7517E0009B43B11F716D77A103CB2BC2")
     List<String> trimCache(long amount) {
        addTaint(amount);
        ArrayList<String> pathList = new ArrayList<String>(100);
        Cursor cursor = null;
        final String query = "SELECT contentlength, filepath FROM cache ORDER BY expires ASC";
        try 
        {
            cursor = mCacheDatabase.rawQuery(query, null);
            if(cursor.moveToFirst())            
            {
                int batchSize = 100;
                StringBuilder pathStr = new StringBuilder(20 + 16 * batchSize);
                pathStr.append("DELETE FROM cache WHERE filepath IN (?");
for(int i = 1;i < batchSize;i++)
                {
                    pathStr.append(", ?");
                } //End block
                pathStr.append(")");
                SQLiteStatement statement = null;
                try 
                {
                    statement = mCacheDatabase.compileStatement(
                            pathStr.toString());
                    int index = 1;
                    do {
                        {
                            long length = cursor.getLong(0);
                            if(length == 0)                            
                            {
                                continue;
                            } //End block
                            amount -= length;
                            String filePath = cursor.getString(1);
                            statement.bindString(index, filePath);
                            pathList.add(filePath);
                            if(index++ == batchSize)                            
                            {
                                statement.execute();
                                statement.clearBindings();
                                index = 1;
                            } //End block
                        } //End block
} while (cursor.moveToNext() && amount > 0);
                    if(index > 1)                    
                    {
                        statement.execute();
                    } //End block
                } //End block
                catch (IllegalStateException e)
                {
                } //End block
                finally 
                {
                    if(statement != null)                    
                    statement.close();
                } //End block
            } //End block
        } //End block
        catch (IllegalStateException e)
        {
        } //End block
        finally 
        {
            if(cursor != null)            
            cursor.close();
        } //End block
List<String> var024CEB90B19D0AC297D288C50E00741D_609603434 =         pathList;
        var024CEB90B19D0AC297D288C50E00741D_609603434.addTaint(taint);
        return var024CEB90B19D0AC297D288C50E00741D_609603434;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.504 -0400", hash_original_method = "791DEB22BE9B55B5A0DA04ED6BE6D08D", hash_generated_method = "4AEBF4512506C3E2D3EAB3A48B69EA49")
     List<String> getAllCacheFileNames() {
        ArrayList<String> pathList = null;
        Cursor cursor = null;
        try 
        {
            cursor = mCacheDatabase.rawQuery("SELECT filepath FROM cache",
                    null);
            if(cursor != null && cursor.moveToFirst())            
            {
                pathList = new ArrayList<String>(cursor.getCount());
                do {
                    {
                        pathList.add(cursor.getString(0));
                    } //End block
} while (cursor.moveToNext());
            } //End block
        } //End block
        catch (IllegalStateException e)
        {
        } //End block
        finally 
        {
            if(cursor != null)            
            cursor.close();
        } //End block
List<String> var024CEB90B19D0AC297D288C50E00741D_808482493 =         pathList;
        var024CEB90B19D0AC297D288C50E00741D_808482493.addTaint(taint);
        return var024CEB90B19D0AC297D288C50E00741D_808482493;
        // ---------- Original Method ----------
        //ArrayList<String> pathList = null;
        //Cursor cursor = null;
        //try {
            //cursor = mCacheDatabase.rawQuery("SELECT filepath FROM cache",
                    //null);
            //if (cursor != null && cursor.moveToFirst()) {
                //pathList = new ArrayList<String>(cursor.getCount());
                //do {
                    //pathList.add(cursor.getString(0));
                //} while (cursor.moveToNext());
            //}
        //} catch (IllegalStateException e) {
            //Log.e(LOGTAG, "getAllCacheFileNames", e);
        //} finally {
            //if (cursor != null) cursor.close();
        //}
        //return pathList;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.504 -0400", hash_original_method = "06E61C8A80289A57F170E4E5B574929B", hash_generated_method = "8AB9F28DA1219E94220832982B1CC9DA")
     void setUsernamePassword(String schemePlusHost, String username,
                String password) {
        addTaint(password.getTaint());
        addTaint(username.getTaint());
        addTaint(schemePlusHost.getTaint());
        if(schemePlusHost == null || !checkInitialized())        
        {
            return;
        } //End block
        synchronized
(mPasswordLock)        {
            final ContentValues c = new ContentValues();
            c.put(PASSWORD_HOST_COL, schemePlusHost);
            c.put(PASSWORD_USERNAME_COL, username);
            c.put(PASSWORD_PASSWORD_COL, password);
            mDatabase.insert(mTableNames[TABLE_PASSWORD_ID], PASSWORD_HOST_COL,
                    c);
        } //End block
        // ---------- Original Method ----------
        //if (schemePlusHost == null || !checkInitialized()) {
            //return;
        //}
        //synchronized (mPasswordLock) {
            //final ContentValues c = new ContentValues();
            //c.put(PASSWORD_HOST_COL, schemePlusHost);
            //c.put(PASSWORD_USERNAME_COL, username);
            //c.put(PASSWORD_PASSWORD_COL, password);
            //mDatabase.insert(mTableNames[TABLE_PASSWORD_ID], PASSWORD_HOST_COL,
                    //c);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.505 -0400", hash_original_method = "AA29CF1F05823526F8013A43811B3B7E", hash_generated_method = "3D4CAC25E00210F7D4898C4A6F950BC6")
     String[] getUsernamePassword(String schemePlusHost) {
        addTaint(schemePlusHost.getTaint());
        if(schemePlusHost == null || !checkInitialized())        
        {
String[] var540C13E9E156B687226421B24F2DF178_1782191800 =             null;
            var540C13E9E156B687226421B24F2DF178_1782191800.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1782191800;
        } //End block
        final String[] columns = new String[] {
                PASSWORD_USERNAME_COL, PASSWORD_PASSWORD_COL
        };
        final String selection = "(" + PASSWORD_HOST_COL + " == ?)";
        synchronized
(mPasswordLock)        {
            String[] ret = null;
            Cursor cursor = null;
            try 
            {
                cursor = mDatabase.query(mTableNames[TABLE_PASSWORD_ID],
                        columns, selection, new String[] { schemePlusHost }, null,
                        null, null);
                if(cursor.moveToFirst())                
                {
                    ret = new String[2];
                    ret[0] = cursor.getString(
                            cursor.getColumnIndex(PASSWORD_USERNAME_COL));
                    ret[1] = cursor.getString(
                            cursor.getColumnIndex(PASSWORD_PASSWORD_COL));
                } //End block
            } //End block
            catch (IllegalStateException e)
            {
            } //End block
            finally 
            {
                if(cursor != null)                
                cursor.close();
            } //End block
String[] varEDFF4FBBF053B5DC2B444ADFA049EE0F_113023135 =             ret;
            varEDFF4FBBF053B5DC2B444ADFA049EE0F_113023135.addTaint(taint);
            return varEDFF4FBBF053B5DC2B444ADFA049EE0F_113023135;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.505 -0400", hash_original_method = "048A7854E0D4842D61BAD40D57C0F82F", hash_generated_method = "BB8A564EB073764CE9BF2FD6FE69893D")
    public boolean hasUsernamePassword() {
        synchronized
(mPasswordLock)        {
            boolean varCA6566241B9286BDE1D87EE5E743CB75_336973209 = (hasEntries(TABLE_PASSWORD_ID));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_727576800 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_727576800;
        } //End block
        // ---------- Original Method ----------
        //synchronized (mPasswordLock) {
            //return hasEntries(TABLE_PASSWORD_ID);
        //}
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.506 -0400", hash_original_method = "1884CD7855F3B6349631839451D5E408", hash_generated_method = "848F2BB39154CC500D95AF3DB97FEC12")
    public void clearUsernamePassword() {
        if(!checkInitialized())        
        {
            return;
        } //End block
        synchronized
(mPasswordLock)        {
            mDatabase.delete(mTableNames[TABLE_PASSWORD_ID], null, null);
        } //End block
        // ---------- Original Method ----------
        //if (!checkInitialized()) {
            //return;
        //}
        //synchronized (mPasswordLock) {
            //mDatabase.delete(mTableNames[TABLE_PASSWORD_ID], null, null);
        //}
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.506 -0400", hash_original_method = "AAEAEDF714B99771C21BA669DE54047C", hash_generated_method = "1F36241B323756F4E98AEF11E18858F2")
     void setHttpAuthUsernamePassword(String host, String realm, String username,
            String password) {
        addTaint(password.getTaint());
        addTaint(username.getTaint());
        addTaint(realm.getTaint());
        addTaint(host.getTaint());
        if(host == null || realm == null || !checkInitialized())        
        {
            return;
        } //End block
        synchronized
(mHttpAuthLock)        {
            final ContentValues c = new ContentValues();
            c.put(HTTPAUTH_HOST_COL, host);
            c.put(HTTPAUTH_REALM_COL, realm);
            c.put(HTTPAUTH_USERNAME_COL, username);
            c.put(HTTPAUTH_PASSWORD_COL, password);
            mDatabase.insert(mTableNames[TABLE_HTTPAUTH_ID], HTTPAUTH_HOST_COL,
                    c);
        } //End block
        // ---------- Original Method ----------
        //if (host == null || realm == null || !checkInitialized()) {
            //return;
        //}
        //synchronized (mHttpAuthLock) {
            //final ContentValues c = new ContentValues();
            //c.put(HTTPAUTH_HOST_COL, host);
            //c.put(HTTPAUTH_REALM_COL, realm);
            //c.put(HTTPAUTH_USERNAME_COL, username);
            //c.put(HTTPAUTH_PASSWORD_COL, password);
            //mDatabase.insert(mTableNames[TABLE_HTTPAUTH_ID], HTTPAUTH_HOST_COL,
                    //c);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.507 -0400", hash_original_method = "6E1D9953804AC08BC6DDA66478F3E8B6", hash_generated_method = "61B67D87E5A47D1A14ECC56CB2FCDB7E")
     String[] getHttpAuthUsernamePassword(String host, String realm) {
        addTaint(realm.getTaint());
        addTaint(host.getTaint());
        if(host == null || realm == null || !checkInitialized())        
        {
String[] var540C13E9E156B687226421B24F2DF178_2007564642 =             null;
            var540C13E9E156B687226421B24F2DF178_2007564642.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_2007564642;
        } //End block
        final String[] columns = new String[] {
                HTTPAUTH_USERNAME_COL, HTTPAUTH_PASSWORD_COL
        };
        final String selection = "(" + HTTPAUTH_HOST_COL + " == ?) AND ("
                + HTTPAUTH_REALM_COL + " == ?)";
        synchronized
(mHttpAuthLock)        {
            String[] ret = null;
            Cursor cursor = null;
            try 
            {
                cursor = mDatabase.query(mTableNames[TABLE_HTTPAUTH_ID],
                        columns, selection, new String[] { host, realm }, null,
                        null, null);
                if(cursor.moveToFirst())                
                {
                    ret = new String[2];
                    ret[0] = cursor.getString(
                            cursor.getColumnIndex(HTTPAUTH_USERNAME_COL));
                    ret[1] = cursor.getString(
                            cursor.getColumnIndex(HTTPAUTH_PASSWORD_COL));
                } //End block
            } //End block
            catch (IllegalStateException e)
            {
            } //End block
            finally 
            {
                if(cursor != null)                
                cursor.close();
            } //End block
String[] varEDFF4FBBF053B5DC2B444ADFA049EE0F_2135022401 =             ret;
            varEDFF4FBBF053B5DC2B444ADFA049EE0F_2135022401.addTaint(taint);
            return varEDFF4FBBF053B5DC2B444ADFA049EE0F_2135022401;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.507 -0400", hash_original_method = "50C83C4F45D13310D76D1C1AF4DB3EDF", hash_generated_method = "6085F253A0B717BD562FA44AA3D53D3C")
    public boolean hasHttpAuthUsernamePassword() {
        synchronized
(mHttpAuthLock)        {
            boolean var83A42B3DD44C5BDB18F9221C452437F2_776962620 = (hasEntries(TABLE_HTTPAUTH_ID));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1935681211 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1935681211;
        } //End block
        // ---------- Original Method ----------
        //synchronized (mHttpAuthLock) {
            //return hasEntries(TABLE_HTTPAUTH_ID);
        //}
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.507 -0400", hash_original_method = "447C774EFBF83BDF0A062EB0F2F80455", hash_generated_method = "83F28CF967DDDDC0A6E9120656A5332E")
    public void clearHttpAuthUsernamePassword() {
        if(!checkInitialized())        
        {
            return;
        } //End block
        synchronized
(mHttpAuthLock)        {
            mDatabase.delete(mTableNames[TABLE_HTTPAUTH_ID], null, null);
        } //End block
        // ---------- Original Method ----------
        //if (!checkInitialized()) {
            //return;
        //}
        //synchronized (mHttpAuthLock) {
            //mDatabase.delete(mTableNames[TABLE_HTTPAUTH_ID], null, null);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.508 -0400", hash_original_method = "1C1CA3B21EC6341A527B545FB0F444FE", hash_generated_method = "1135038A46DA6B895BD27078B651ACE7")
     void setFormData(String url, HashMap<String, String> formdata) {
        addTaint(formdata.getTaint());
        addTaint(url.getTaint());
        if(url == null || formdata == null || !checkInitialized())        
        {
            return;
        } //End block
        final String selection = "(" + FORMURL_URL_COL + " == ?)";
        synchronized
(mFormLock)        {
            long urlid = -1;
            Cursor cursor = null;
            try 
            {
                cursor = mDatabase.query(mTableNames[TABLE_FORMURL_ID],
                        ID_PROJECTION, selection, new String[] { url }, null, null,
                        null);
                if(cursor.moveToFirst())                
                {
                    urlid = cursor.getLong(cursor.getColumnIndex(ID_COL));
                } //End block
                else
                {
                    ContentValues c = new ContentValues();
                    c.put(FORMURL_URL_COL, url);
                    urlid = mDatabase.insert(
                            mTableNames[TABLE_FORMURL_ID], null, c);
                } //End block
            } //End block
            catch (IllegalStateException e)
            {
            } //End block
            finally 
            {
                if(cursor != null)                
                cursor.close();
            } //End block
            if(urlid >= 0)            
            {
                Set<Entry<String, String>> set = formdata.entrySet();
                Iterator<Entry<String, String>> iter = set.iterator();
                ContentValues map = new ContentValues();
                map.put(FORMDATA_URLID_COL, urlid);
                while
(iter.hasNext())                
                {
                    Entry<String, String> entry = iter.next();
                    map.put(FORMDATA_NAME_COL, entry.getKey());
                    map.put(FORMDATA_VALUE_COL, entry.getValue());
                    mDatabase.insert(mTableNames[TABLE_FORMDATA_ID], null, map);
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.509 -0400", hash_original_method = "699FE9DC5ACA57A32D74F51785DE679D", hash_generated_method = "9ACB07944ACB8C58F2835ADDA6A1785A")
     ArrayList<String> getFormData(String url, String name) {
        addTaint(name.getTaint());
        addTaint(url.getTaint());
        ArrayList<String> values = new ArrayList<String>();
        if(url == null || name == null || !checkInitialized())        
        {
ArrayList<String> var674B10C763DBAAF9696AD9A3DDAE07B3_1895256844 =             values;
            var674B10C763DBAAF9696AD9A3DDAE07B3_1895256844.addTaint(taint);
            return var674B10C763DBAAF9696AD9A3DDAE07B3_1895256844;
        } //End block
        final String urlSelection = "(" + FORMURL_URL_COL + " == ?)";
        final String dataSelection = "(" + FORMDATA_URLID_COL + " == ?) AND ("
                + FORMDATA_NAME_COL + " == ?)";
        synchronized
(mFormLock)        {
            Cursor cursor = null;
            try 
            {
                cursor = mDatabase.query(mTableNames[TABLE_FORMURL_ID],
                        ID_PROJECTION, urlSelection, new String[] { url }, null,
                        null, null);
                while
(cursor.moveToNext())                
                {
                    long urlid = cursor.getLong(cursor.getColumnIndex(ID_COL));
                    Cursor dataCursor = null;
                    try 
                    {
                        dataCursor = mDatabase.query(
                                mTableNames[TABLE_FORMDATA_ID],
                                new String[] { ID_COL, FORMDATA_VALUE_COL },
                                dataSelection,
                                new String[] { Long.toString(urlid), name },
                                null, null, null);
                        if(dataCursor.moveToFirst())                        
                        {
                            int valueCol = dataCursor.getColumnIndex(
                                    FORMDATA_VALUE_COL);
                            do {
                                {
                                    values.add(dataCursor.getString(valueCol));
                                } //End block
} while (dataCursor.moveToNext());
                        } //End block
                    } //End block
                    catch (IllegalStateException e)
                    {
                    } //End block
                    finally 
                    {
                        if(dataCursor != null)                        
                        dataCursor.close();
                    } //End block
                } //End block
            } //End block
            catch (IllegalStateException e)
            {
            } //End block
            finally 
            {
                if(cursor != null)                
                cursor.close();
            } //End block
ArrayList<String> var674B10C763DBAAF9696AD9A3DDAE07B3_1939149680 =             values;
            var674B10C763DBAAF9696AD9A3DDAE07B3_1939149680.addTaint(taint);
            return var674B10C763DBAAF9696AD9A3DDAE07B3_1939149680;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.509 -0400", hash_original_method = "6553D4A66AD572AF8668D3FA13E3C7D5", hash_generated_method = "9352C02C42453994165F175C0FABFE50")
    public boolean hasFormData() {
        synchronized
(mFormLock)        {
            boolean varB3DCC1A220E48009681D86C6BCA1CAF7_1094162313 = (hasEntries(TABLE_FORMURL_ID));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_930377562 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_930377562;
        } //End block
        // ---------- Original Method ----------
        //synchronized (mFormLock) {
            //return hasEntries(TABLE_FORMURL_ID);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.509 -0400", hash_original_method = "9C11F1BCAAD785FEF89EC2FF8E172198", hash_generated_method = "99D7836B91AD6ED5A7E1558ED3CF7130")
    public void clearFormData() {
        if(!checkInitialized())        
        {
            return;
        } //End block
        synchronized
(mFormLock)        {
            mDatabase.delete(mTableNames[TABLE_FORMURL_ID], null, null);
            mDatabase.delete(mTableNames[TABLE_FORMDATA_ID], null, null);
        } //End block
        // ---------- Original Method ----------
        //if (!checkInitialized()) {
            //return;
        //}
        //synchronized (mFormLock) {
            //mDatabase.delete(mTableNames[TABLE_FORMURL_ID], null, null);
            //mDatabase.delete(mTableNames[TABLE_FORMDATA_ID], null, null);
        //}
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.509 -0400", hash_original_field = "97FB093BE733A1BA7EBC7D4C2F724030", hash_generated_field = "E8D0A6CD52C04E0659D4FC87D336D0AC")

    private static final String DATABASE_FILE = "webview.db";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.509 -0400", hash_original_field = "0C79379A4FFB67C6B34DD7254190E080", hash_generated_field = "B17A3300247FF520B718A6CB6B02A944")

    private static final String CACHE_DATABASE_FILE = "webviewCache.db";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.509 -0400", hash_original_field = "5F2F293DA7031522319625D7791812FB", hash_generated_field = "24A942646779149EC1E70531789CBBAC")

    protected static final String LOGTAG = "webviewdatabase";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.509 -0400", hash_original_field = "31403FB301FD84D0D8EDD7CEBEFFEF27", hash_generated_field = "C1B002270A3E3DA04EE8826B5BFBB2B5")

    private static final int DATABASE_VERSION = 11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.509 -0400", hash_original_field = "9CC00DFB3E1D38EFCB8A11C16265B5E5", hash_generated_field = "9541082229959783D272F5B70DE9D33C")

    private static final int CACHE_DATABASE_VERSION = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.510 -0400", hash_original_field = "BB5542AD4EE4FC87B3BF30A334DCA037", hash_generated_field = "B8A911681F373C0D77BEF69151B32586")

    private static WebViewDatabase mInstance = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.510 -0400", hash_original_field = "961E4258F7E74A9EAA9E39B39D6F0A80", hash_generated_field = "2A9DC9A5BD2819616E44A0ADAFECE4A7")

    private static SQLiteDatabase mDatabase = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.510 -0400", hash_original_field = "471BCFDB7D950F157B32C5FC2BA7DD1E", hash_generated_field = "6216361743BC8C4805B411B6532C00A7")

    private static SQLiteDatabase mCacheDatabase = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.510 -0400", hash_original_field = "73DF9C71C5AD092E447107AB62B115B2", hash_generated_field = "82494AB72BCFBC647B4C24C95E37B56F")

    private static final String mTableNames[] = {
        "cookies", "password", "formurl", "formdata", "httpauth"
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.510 -0400", hash_original_field = "F593950478528A06B7E618081AF6BC06", hash_generated_field = "E071736BB1C54763EB26EE8955F646D4")

    private static final int TABLE_COOKIES_ID = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.510 -0400", hash_original_field = "FA94619CB79D784E757BAE068E993510", hash_generated_field = "C26654F80C65505FF03B4C5B6DA105F3")

    private static final int TABLE_PASSWORD_ID = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.510 -0400", hash_original_field = "D92065FCA5B01DC8E4A52875C8D97506", hash_generated_field = "F83A26899C0F0D2C1ACAA87EEDA0153E")

    private static final int TABLE_FORMURL_ID = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.510 -0400", hash_original_field = "7F257D48419A2777A6EA39E834F7207D", hash_generated_field = "D07F66BAD2BCF3FAD0DB03739B7A2A53")

    private static final int TABLE_FORMDATA_ID = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.510 -0400", hash_original_field = "A94514E22B657C7979ACEA63002C0267", hash_generated_field = "213F1FE4C5C8147C0E3AA82A86D16003")

    private static final int TABLE_HTTPAUTH_ID = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.510 -0400", hash_original_field = "95AAD2805FDD44BA5CEE24DC0D89F133", hash_generated_field = "544D8A467AF5FAAA84AB157CE043EFEA")

    private static final String ID_COL = "_id";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.510 -0400", hash_original_field = "8EFD18DD0B691B2376E9269460018650", hash_generated_field = "E30EDA8D5CEF5DBC0865B3EFC9FE624F")

    private static final String[] ID_PROJECTION = new String[] {
        "_id"
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.510 -0400", hash_original_field = "10031FB5E52444A11A3BCFFAFA0DB528", hash_generated_field = "9A9E4A560333679ACF0CA07A793F6029")

    private static final String COOKIES_NAME_COL = "name";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.510 -0400", hash_original_field = "7934BB4FC757A6BDF45F6DD59D588727", hash_generated_field = "36856FCE215FA203C61B4737E1A6D314")

    private static final String COOKIES_VALUE_COL = "value";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.510 -0400", hash_original_field = "0B900D9814FA51A015157D877FD0DE65", hash_generated_field = "974379DCBAF58FDB14009A07716F2DE3")

    private static final String COOKIES_DOMAIN_COL = "domain";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.510 -0400", hash_original_field = "62947D46AA00728C394B0C7F5ED76489", hash_generated_field = "919C7E98C32C3DE4E674B31354083103")

    private static final String COOKIES_PATH_COL = "path";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.510 -0400", hash_original_field = "35F03590FDED597FA22FC6D2F228B03B", hash_generated_field = "92595ACB5997D57A9912CEC295FFD385")

    private static final String COOKIES_EXPIRES_COL = "expires";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.510 -0400", hash_original_field = "9C3805CAF4F09E4D6BF79B844F71B6C7", hash_generated_field = "4555D5715510CC15CD635D945C145E69")

    private static final String COOKIES_SECURE_COL = "secure";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.510 -0400", hash_original_field = "A80A5692E900FB179643B9614EA0A73E", hash_generated_field = "26E13854774B9D7E5B3D124BA1DA43C8")

    private static final String CACHE_URL_COL = "url";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.510 -0400", hash_original_field = "712707BAA6B086C607E0202AAF178FBD", hash_generated_field = "FBB51F4E9164A38BC02FE055D0D31F69")

    private static final String CACHE_FILE_PATH_COL = "filepath";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.510 -0400", hash_original_field = "1EB91D94EDBC60EF9C1FA4511DE24937", hash_generated_field = "E4EDB200A85003914E478A614635D399")

    private static final String CACHE_LAST_MODIFY_COL = "lastmodify";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.510 -0400", hash_original_field = "A03AA7E24168AE56F7FF90675A1DAF68", hash_generated_field = "E63A0BBF23F285D448CCD1D377216419")

    private static final String CACHE_ETAG_COL = "etag";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.510 -0400", hash_original_field = "E2A338B20B6E3D0E8A2F1EB711F9B7C5", hash_generated_field = "D715992BD667778579FCD9642CD2DF0B")

    private static final String CACHE_EXPIRES_COL = "expires";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.510 -0400", hash_original_field = "A893B60A4C7E3090551F1A87DC567F05", hash_generated_field = "7EA32DCE9FCB8F00238F15D76A4D1EB0")

    private static final String CACHE_EXPIRES_STRING_COL = "expiresstring";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.510 -0400", hash_original_field = "34996420DB663AF981B76C3FFAECB4D2", hash_generated_field = "4346EC9A786A0D8B47B0AF2F746CCDF9")

    private static final String CACHE_MIMETYPE_COL = "mimetype";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.510 -0400", hash_original_field = "F3EDAB1F8BC7D0C841BC36BC6E8FDF85", hash_generated_field = "A5B14468B66E4C651D16A4B4EF3D4988")

    private static final String CACHE_ENCODING_COL = "encoding";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.510 -0400", hash_original_field = "8C6C0AB77168966480E9A2DC76DFF0A9", hash_generated_field = "74EDAC14B6454EB4BD8EC537D3A48C1D")

    private static final String CACHE_HTTP_STATUS_COL = "httpstatus";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.510 -0400", hash_original_field = "4039EE0305B9310C87FC6733374047E9", hash_generated_field = "AC242FF315AD73BD18B75D87F22A121D")

    private static final String CACHE_LOCATION_COL = "location";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.510 -0400", hash_original_field = "75D435936AED501CFCA0FE328E0E59FA", hash_generated_field = "A45041FED79C2F37B614E43E9EAA62EE")

    private static final String CACHE_CONTENTLENGTH_COL = "contentlength";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.510 -0400", hash_original_field = "3A78765ECB553FFA4185642D15F51660", hash_generated_field = "12021DAB4B009D47C4C0B03A8B7F08FB")

    private static final String CACHE_CONTENTDISPOSITION_COL = "contentdisposition";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.510 -0400", hash_original_field = "377B1EC21E011CF4D5C57C266BA339C3", hash_generated_field = "0C17DB9AB903701BF734F0A36DECDE32")

    private static final String CACHE_CROSSDOMAIN_COL = "crossdomain";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.510 -0400", hash_original_field = "4357EB3E2B353B26939F7CD277B802CE", hash_generated_field = "C9B09646DBA0EE3D1FD4703689B6709E")

    private static final String PASSWORD_HOST_COL = "host";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.511 -0400", hash_original_field = "5EA201ED1318E58ADA3981C6F9A89356", hash_generated_field = "4834A6E26AC690BEEDA4205B55E80F71")

    private static final String PASSWORD_USERNAME_COL = "username";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.511 -0400", hash_original_field = "E6B3A21470DBD7C6290F62AC3649EC3E", hash_generated_field = "6169E1A26615324546DDBAFA8EA35E46")

    private static final String PASSWORD_PASSWORD_COL = "password";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.511 -0400", hash_original_field = "508345AAA07699F2CFC5E79EC1FE4D96", hash_generated_field = "405F7907F7A8C1D13F6685D3670B540F")

    private static final String FORMURL_URL_COL = "url";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.511 -0400", hash_original_field = "B6AE36F0C577EED59663D75D6050DB36", hash_generated_field = "F5DC4499DBB3D0AB9C3FBC85716B75BD")

    private static final String FORMDATA_URLID_COL = "urlid";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.511 -0400", hash_original_field = "CB57F57686547126214EF36106A16F3A", hash_generated_field = "AC7FD45F189A1AFA7D8D735589B88FEC")

    private static final String FORMDATA_NAME_COL = "name";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.511 -0400", hash_original_field = "7B80A9211FC7021F6A780184A5E65546", hash_generated_field = "6301A8ABA0887A6D2B97FE4E3D00C0D7")

    private static final String FORMDATA_VALUE_COL = "value";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.511 -0400", hash_original_field = "218C4151B8B7B0BEFEBFE3A9D3598A58", hash_generated_field = "A49759473C2E0C990FC7CE8A30842EC9")

    private static final String HTTPAUTH_HOST_COL = "host";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.511 -0400", hash_original_field = "742869D98EC1C65FE55950316D908AE7", hash_generated_field = "A8836A926F4D3E2666084C23DE3ABA47")

    private static final String HTTPAUTH_REALM_COL = "realm";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.511 -0400", hash_original_field = "4735043625F795828DFBEC75674C1301", hash_generated_field = "E43FF3904390D4343F6CBCC7E76BB50A")

    private static final String HTTPAUTH_USERNAME_COL = "username";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.511 -0400", hash_original_field = "D470AC4924A89065E285659BD318A916", hash_generated_field = "306AFBB09ADAF2FFC1BE20DBB1DE10A6")

    private static final String HTTPAUTH_PASSWORD_COL = "password";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.511 -0400", hash_original_field = "02CCE22A311CADFB11AFA26DCB73108F", hash_generated_field = "9978AB64D9ADE743F038BE7845E6172E")

    private static DatabaseUtils.InsertHelper mCacheInserter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.511 -0400", hash_original_field = "530F644F14A9D5DD748EBC732472B324", hash_generated_field = "3910FC6AB35DAF5F19CCEF25E8654783")

    private static int mCacheUrlColIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.511 -0400", hash_original_field = "8F160C6A8858DBB8979E9D379C99A457", hash_generated_field = "6D70A03DEA5E92F04910BB7E9E1D9224")

    private static int mCacheFilePathColIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.511 -0400", hash_original_field = "6377FFA093CA55A749CCAF38186A15C1", hash_generated_field = "F297F7407A43B3D8B550234904F928F5")

    private static int mCacheLastModifyColIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.511 -0400", hash_original_field = "3669079542CCEB87D992EC9A2B016E6C", hash_generated_field = "7E671A6F0167C6AE2F10F590C7DC601E")

    private static int mCacheETagColIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.511 -0400", hash_original_field = "6F203D5A48CD57B37CA7994C04473BA1", hash_generated_field = "09E6E173F9C3511818B6258041F0A3BC")

    private static int mCacheExpiresColIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.511 -0400", hash_original_field = "8399E380BC6C8A7F8233460E5512C2EB", hash_generated_field = "9DDE47C8C21140680D9D21457C8BA030")

    private static int mCacheExpiresStringColIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.511 -0400", hash_original_field = "98BDBB3BB565D12BD211BF6037141DA5", hash_generated_field = "6EC0F1436186404D863C79D70C9D0422")

    private static int mCacheMimeTypeColIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.511 -0400", hash_original_field = "3BDEE775811BDD2BF14998EC6455776E", hash_generated_field = "67A46391EDD0D1EEFDAA1EF5F50C5C78")

    private static int mCacheEncodingColIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.511 -0400", hash_original_field = "CBCF5080B4DC20A6213C93C825039E53", hash_generated_field = "E8069F7EB9821C68B302A5C70FE84C68")

    private static int mCacheHttpStatusColIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.511 -0400", hash_original_field = "1FCF38A62D6BCBEBB44109FDE952327D", hash_generated_field = "DA4DBC2E2AF89F71F7CF53E4A0F9DB44")

    private static int mCacheLocationColIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.511 -0400", hash_original_field = "F85753B97AF9626AF8FA6CBB1D6C32CA", hash_generated_field = "2CEFBAF45A5360D0C6A73071406979A0")

    private static int mCacheContentLengthColIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.511 -0400", hash_original_field = "A220E2B3B8458CE24E0CBE61BBFE1F56", hash_generated_field = "C4C9ED448FAD4F85DBEA109ADF0942B5")

    private static int mCacheContentDispositionColIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.511 -0400", hash_original_field = "8AC55427B838864F99762F4B9E97B74A", hash_generated_field = "07EC8A1B46BF12BB85378082FD36D87C")

    private static int mCacheCrossDomainColIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.511 -0400", hash_original_field = "3A45B26C5E71778F0FB720FAABAC85BD", hash_generated_field = "BFC3FA813D8D5121BE43E51DCA5BBA65")

    private static int mCacheTransactionRefcount;
}

