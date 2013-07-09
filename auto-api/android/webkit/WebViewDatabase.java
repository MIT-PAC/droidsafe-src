package android.webkit;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Map.Entry;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;
import android.webkit.CookieManager.Cookie;
import android.webkit.CacheManager.CacheResult;
import android.webkit.JniUtil;

public class WebViewDatabase {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.986 -0400", hash_original_field = "867BB3294E9C68C99FCD8CAE06CC4189", hash_generated_field = "93D9ABAC661FEA809DA54BD9E7E9D9D3")

    private final Object mCookieLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.986 -0400", hash_original_field = "8002E7A58D1BE5163381E484BA29B73A", hash_generated_field = "B9AA262C50068E49E8D4989E6CB68357")

    private final Object mPasswordLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.986 -0400", hash_original_field = "1F62250EEFC8639157DBB68AD5BDC8F7", hash_generated_field = "FFB3B56DC6131C4C61A59C58082777D9")

    private final Object mFormLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.986 -0400", hash_original_field = "4540D6026C066EC4C652DDF2BCB91F3D", hash_generated_field = "5C47FB4E53C3D9C9795AB924F63FC85D")

    private final Object mHttpAuthLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.986 -0400", hash_original_field = "82073B9F728953BFC0E99AB45C8BBB4A", hash_generated_field = "E5CA3845DA8FE08BE201D5EDF15F54DD")

    private boolean mInitialized = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.987 -0400", hash_original_method = "EFB05B9D3FCAB305323B10379F1EC778", hash_generated_method = "D48DD0370FD0802A0C87400BAA4F1656")
    private  WebViewDatabase(final Context context) {
        new Thread() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.987 -0400", hash_original_method = "016F23FCFDABFB49215E1C5AD86A4960", hash_generated_method = "857237709B575C3CEAE7C4725FBD2553")
            @Override
            public void run() {
                init(context);
                
                
            }
}.start();
        addTaint(context.getTaint());
        
        
            
            
                
            
        
    }

    
        public static synchronized WebViewDatabase getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new WebViewDatabase(context);
        }
        return mInstance;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.988 -0400", hash_original_method = "AC87AD0E19559694D58F1943BD15C1D5", hash_generated_method = "146D28A96EAE252B3E40F53A223B33A2")
    private synchronized void init(Context context) {
        initDatabase(context);
        {
            boolean var9ACB1B3B30D2C0CED704DA8C8B3FC1B9_1958463389 = (JniUtil.useChromiumHttpStack());
            {
                context.deleteDatabase(CACHE_DATABASE_FILE);
            } 
            {
                initCacheDatabase(context);
            } 
        } 
        mInitialized = true;
        notify();
        addTaint(context.getTaint());
        
        
            
        
        
        
            
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.988 -0400", hash_original_method = "CE06D258DB88B89F42DED68141C198E0", hash_generated_method = "6CF3EB7E30F6FAA94B9B0ABE550D64C9")
    private void initDatabase(Context context) {
        try 
        {
            mDatabase = context.openOrCreateDatabase(DATABASE_FILE, 0, null);
        } 
        catch (SQLiteException e)
        {
            {
                boolean var8ADF77EF24056E62D97D24430E7CC726_2001928248 = (context.deleteDatabase(DATABASE_FILE));
                {
                    mDatabase = context.openOrCreateDatabase(DATABASE_FILE, 0,
                        null);
                } 
            } 
        } 
        mDatabase.enableWriteAheadLogging();
        {
            mInitialized = true;
            notify();
        } 
        {
            boolean varA450E818A17AB5CEAFA5DCA2D2F53F99_1590450301 = (mDatabase.getVersion() != DATABASE_VERSION);
            {
                mDatabase.beginTransactionNonExclusive();
                try 
                {
                    upgradeDatabase();
                    mDatabase.setTransactionSuccessful();
                } 
                finally 
                {
                    mDatabase.endTransaction();
                } 
            } 
        } 
        mDatabase.setLockingEnabled(false);
        addTaint(context.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.990 -0400", hash_original_method = "C7A89DE182CA76C10CB3961C893695C2", hash_generated_method = "37B88A5928D876D410FD912F204A4F09")
    private void initCacheDatabase(Context context) {
        try 
        {
            mCacheDatabase = context.openOrCreateDatabase(
                    CACHE_DATABASE_FILE, 0, null);
        } 
        catch (SQLiteException e)
        {
            {
                boolean var06845C84D0D12A7575979F07C5042A97_457410079 = (context.deleteDatabase(CACHE_DATABASE_FILE));
                {
                    mCacheDatabase = context.openOrCreateDatabase(
                        CACHE_DATABASE_FILE, 0, null);
                } 
            } 
        } 
        mCacheDatabase.enableWriteAheadLogging();
        {
            mInitialized = true;
            notify();
        } 
        {
            boolean var9F5CCB2C1429C972D5DCFFA8EAC58C5C_386114013 = (mCacheDatabase.getVersion() != CACHE_DATABASE_VERSION);
            {
                mCacheDatabase.beginTransactionNonExclusive();
                try 
                {
                    upgradeCacheDatabase();
                    bootstrapCacheDatabase();
                    mCacheDatabase.setTransactionSuccessful();
                } 
                finally 
                {
                    mCacheDatabase.endTransaction();
                } 
                CacheManager.removeAllCacheFiles();
            } 
        } 
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
        addTaint(context.getTaint());
        
        
    }

    
        @DSModeled(DSC.SAFE)
    private static void upgradeDatabase() {
        upgradeDatabaseToV10();
        upgradeDatabaseFromV10ToV11();
        mDatabase.setVersion(DATABASE_VERSION);
    }

    
        @DSModeled(DSC.SAFE)
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

    
        @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.991 -0400", hash_original_method = "B19C14CCA683C2C1072DDA1B7A6274D5", hash_generated_method = "7E773CBFE916496DE76E7E76240A24DB")
    private boolean checkInitialized() {
        {
            {
                try 
                {
                    wait();
                } 
                catch (InterruptedException e)
                { }
            } 
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1223268050 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1223268050;
        
        
            
                
                    
                
                    
                                  
                    
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.992 -0400", hash_original_method = "CBFCA06012BEB8B609A8EBC6EEC6D1A4", hash_generated_method = "4F971E218F67B4B96D3A2364AFA21397")
    private boolean hasEntries(int tableId) {
        {
            boolean var886CAF4B0310A6130F03FD63561B8234_1910752798 = (!checkInitialized());
        } 
        Cursor cursor = null;
        boolean ret = false;
        try 
        {
            cursor = mDatabase.query(mTableNames[tableId], ID_PROJECTION,
                    null, null, null, null, null);
            ret = cursor.moveToFirst() == true;
        } 
        catch (IllegalStateException e)
        { }
        finally 
        {
            cursor.close();
        } 
        addTaint(tableId);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1235481857 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1235481857;
        
        
            
        
        
        
        
            
                    
            
        
            
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.993 -0400", hash_original_method = "4D94521780B9AD3D8F70E78E8CBCD3E0", hash_generated_method = "1A34BC38654B7F28FCC0FA62C4022CE2")
     ArrayList<Cookie> getCookiesForDomain(String domain) {
        ArrayList<Cookie> varB4EAC82CA7396A68D541C85D26508E83_977649692 = null; 
        ArrayList<Cookie> varB4EAC82CA7396A68D541C85D26508E83_1394652958 = null; 
        ArrayList<Cookie> list = new ArrayList<Cookie>();
        {
            boolean varA8DB3C3C11FB3F67134323DBA3E29A4F_1966232174 = (domain == null || !checkInitialized());
            {
                varB4EAC82CA7396A68D541C85D26508E83_977649692 = list;
            } 
        } 
        {
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
                {
                    boolean var77D7361540339637C7B1B1A9F784B876_56684056 = (cursor.moveToFirst());
                    {
                        int domainCol = cursor.getColumnIndex(COOKIES_DOMAIN_COL);
                        int pathCol = cursor.getColumnIndex(COOKIES_PATH_COL);
                        int nameCol = cursor.getColumnIndex(COOKIES_NAME_COL);
                        int valueCol = cursor.getColumnIndex(COOKIES_VALUE_COL);
                        int expiresCol = cursor.getColumnIndex(COOKIES_EXPIRES_COL);
                        int secureCol = cursor.getColumnIndex(COOKIES_SECURE_COL);
                        {
                            Cookie cookie = new Cookie();
                            cookie.domain = cursor.getString(domainCol);
                            cookie.path = cursor.getString(pathCol);
                            cookie.name = cursor.getString(nameCol);
                            cookie.value = cursor.getString(valueCol);
                            {
                                boolean var80D05DB7C23C7A8C68D1BD5C13F8B946_1922327597 = (cursor.isNull(expiresCol));
                                {
                                    cookie.expires = -1;
                                } 
                                {
                                    cookie.expires = cursor.getLong(expiresCol);
                                } 
                            } 
                            cookie.secure = cursor.getShort(secureCol) != 0;
                            cookie.mode = Cookie.MODE_NORMAL;
                            list.add(cookie);
                        } 
                        {
                            boolean varEEE3E1704288A6D03EB8C70F2484A2B3_1835498160 = (cursor.moveToNext());
                        } 
                    } 
                } 
            } 
            catch (IllegalStateException e)
            { }
            finally 
            {
                cursor.close();
            } 
            varB4EAC82CA7396A68D541C85D26508E83_1394652958 = list;
        } 
        addTaint(domain.getTaint());
        ArrayList<Cookie> varA7E53CE21691AB073D9660D615818899_1232730710; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1232730710 = varB4EAC82CA7396A68D541C85D26508E83_977649692;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1232730710 = varB4EAC82CA7396A68D541C85D26508E83_1394652958;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1232730710.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1232730710;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.994 -0400", hash_original_method = "BC23D2938EE88E31CA87024518493BE2", hash_generated_method = "B72D032585281CD44C5B801ED9E40347")
     void deleteCookies(String domain, String path, String name) {
        {
            boolean varA8DB3C3C11FB3F67134323DBA3E29A4F_570856495 = (domain == null || !checkInitialized());
        } 
        {
            final String where = "(" + COOKIES_DOMAIN_COL + " == ?) AND ("
                    + COOKIES_PATH_COL + " == ?) AND (" + COOKIES_NAME_COL
                    + " == ?)";
            mDatabase.delete(mTableNames[TABLE_COOKIES_ID], where,
                    new String[] { domain, path, name });
        } 
        addTaint(domain.getTaint());
        addTaint(path.getTaint());
        addTaint(name.getTaint());
        
        
            
        
        
            
                    
                    
            
                    
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.994 -0400", hash_original_method = "33710CB1E65A2C52E9ABEE23433BB87F", hash_generated_method = "3CDFFCED88EEBFC78398003EE71F3DC8")
     void addCookie(Cookie cookie) {
        {
            boolean var39BA779873F941960A4C4EA6029A7B0F_646256268 = (cookie.domain == null || cookie.path == null || cookie.name == null
                || !checkInitialized());
        } 
        {
            ContentValues cookieVal = new ContentValues();
            cookieVal.put(COOKIES_DOMAIN_COL, cookie.domain);
            cookieVal.put(COOKIES_PATH_COL, cookie.path);
            cookieVal.put(COOKIES_NAME_COL, cookie.name);
            cookieVal.put(COOKIES_VALUE_COL, cookie.value);
            {
                cookieVal.put(COOKIES_EXPIRES_COL, cookie.expires);
            } 
            cookieVal.put(COOKIES_SECURE_COL, cookie.secure);
            mDatabase.insert(mTableNames[TABLE_COOKIES_ID], null, cookieVal);
        } 
        addTaint(cookie.getTaint());
        
        
                
            
        
        
            
            
            
            
            
            
                
            
            
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.995 -0400", hash_original_method = "83E6237273AAD0C9F4D2DED923ACAFB7", hash_generated_method = "5008768C4B96C7E81C194C2997484D15")
     boolean hasCookies() {
        {
            boolean varDB253D8D15C430D06B36D069D7680A2A_1214259506 = (hasEntries(TABLE_COOKIES_ID));
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1066883261 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1066883261;
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.995 -0400", hash_original_method = "3E1D9455881C3029C0C51566A563B8F4", hash_generated_method = "9F1F7BBB486288176E42F89E12144157")
     void clearCookies() {
        {
            boolean var886CAF4B0310A6130F03FD63561B8234_768158508 = (!checkInitialized());
        } 
        {
            mDatabase.delete(mTableNames[TABLE_COOKIES_ID], null, null);
        } 
        
        
            
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.995 -0400", hash_original_method = "CAA5F0320575B2151920B0F146B122B7", hash_generated_method = "407B64C55510BDA1EBDD2F97A1A9C14C")
     void clearSessionCookies() {
        {
            boolean var886CAF4B0310A6130F03FD63561B8234_1083350822 = (!checkInitialized());
        } 
        final String sessionExpired = COOKIES_EXPIRES_COL + " ISNULL";
        {
            mDatabase.delete(mTableNames[TABLE_COOKIES_ID], sessionExpired,
                    null);
        } 
        
        
            
        
        
        
            
                    
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.995 -0400", hash_original_method = "AD90F95A26E2D9ECD94EF58E091F4A84", hash_generated_method = "C8E468D28170AB931DF962C5F972C3E7")
     void clearExpiredCookies(long now) {
        {
            boolean var886CAF4B0310A6130F03FD63561B8234_1506432175 = (!checkInitialized());
        } 
        final String expires = COOKIES_EXPIRES_COL + " <= ?";
        {
            mDatabase.delete(mTableNames[TABLE_COOKIES_ID], expires,
                    new String[] { Long.toString(now) });
        } 
        addTaint(now);
        
        
            
        
        
        
            
                    
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.996 -0400", hash_original_method = "26A436743D42208E44F8DC7C1FFF5A77", hash_generated_method = "8C320BF3A226FB4E71F777A22B61CA6E")
     boolean startCacheTransaction() {
        {
            {
                boolean var19CEF9F46A61A60E9C53BA833277B14B_1883018689 = (!Thread.currentThread().equals(
                    WebViewWorker.getHandler().getLooper().getThread()));
            } 
            mCacheDatabase.beginTransactionNonExclusive();
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1796807561 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1796807561;
        
        
            
                    
                
                        
                        
            
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.996 -0400", hash_original_method = "14B92CCE9ED71BB98EE6E80EBC3B995B", hash_generated_method = "D60120728DB88ED16EA28AEEC6FFFBFC")
     boolean endCacheTransaction() {
        {
            {
                boolean var19CEF9F46A61A60E9C53BA833277B14B_1950640349 = (!Thread.currentThread().equals(
                    WebViewWorker.getHandler().getLooper().getThread()));
            } 
            try 
            {
                mCacheDatabase.setTransactionSuccessful();
            } 
            finally 
            {
                mCacheDatabase.endTransaction();
            } 
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1065863125 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1065863125;
        
        
            
                    
                
                        
                        
            
            
                
            
                
            
            
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.998 -0400", hash_original_method = "BF73224910862A6343E046C49771A81E", hash_generated_method = "8E1E957D3F1FCF47EEC5FBEA0E345AB5")
     CacheResult getCache(String url) {
        CacheResult varB4EAC82CA7396A68D541C85D26508E83_173943745 = null; 
        CacheResult varB4EAC82CA7396A68D541C85D26508E83_1239863773 = null; 
        CacheResult varB4EAC82CA7396A68D541C85D26508E83_854839426 = null; 
        {
            boolean var5AE2624D4B934FA39D4CA4D237A622F0_51827205 = (url == null || !checkInitialized());
            {
                varB4EAC82CA7396A68D541C85D26508E83_173943745 = null;
            } 
        } 
        Cursor cursor = null;
        final String query = "SELECT filepath, lastmodify, etag, expires, "
                + "expiresstring, mimetype, encoding, httpstatus, location, contentlength, "
                + "contentdisposition, crossdomain FROM cache WHERE url = ?";
        try 
        {
            cursor = mCacheDatabase.rawQuery(query, new String[] { url });
            {
                boolean varCDEB7019138899FEAFBEC62FC2A4BF86_527040583 = (cursor.moveToFirst());
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
                    varB4EAC82CA7396A68D541C85D26508E83_1239863773 = ret;
                } 
            } 
        } 
        catch (IllegalStateException e)
        { }
        finally 
        {
            cursor.close();
        } 
        varB4EAC82CA7396A68D541C85D26508E83_854839426 = null;
        addTaint(url.getTaint());
        CacheResult varA7E53CE21691AB073D9660D615818899_1682191685; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1682191685 = varB4EAC82CA7396A68D541C85D26508E83_173943745;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1682191685 = varB4EAC82CA7396A68D541C85D26508E83_1239863773;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1682191685 = varB4EAC82CA7396A68D541C85D26508E83_854839426;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1682191685.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1682191685;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.998 -0400", hash_original_method = "10415454EB24D9D06B07AD8A5863D117", hash_generated_method = "3DCE24CBFC5E57897D80E651958D2EDA")
     void removeCache(String url) {
        {
            boolean var5AE2624D4B934FA39D4CA4D237A622F0_669134210 = (url == null || !checkInitialized());
        } 
        mCacheDatabase.execSQL("DELETE FROM cache WHERE url = ?", new String[] { url });
        addTaint(url.getTaint());
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.999 -0400", hash_original_method = "C4FACCF94A8569C78058717A9665F703", hash_generated_method = "BEE9D1933318F1528F483AB986F960B8")
     void addCache(String url, CacheResult c) {
        {
            boolean var5AE2624D4B934FA39D4CA4D237A622F0_1578321306 = (url == null || !checkInitialized());
        } 
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
        addTaint(url.getTaint());
        addTaint(c.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.999 -0400", hash_original_method = "67241BF201ED077F6E669112ABB44844", hash_generated_method = "DC4E84F0511FA51A8BD705714F5381DB")
     void clearCache() {
        {
            boolean var886CAF4B0310A6130F03FD63561B8234_413982854 = (!checkInitialized());
        } 
        mCacheDatabase.delete("cache", null, null);
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.000 -0400", hash_original_method = "0A5B6EFF79BC3227EAB74E5615633418", hash_generated_method = "2A9E705FEA27D32EF921E027AA751242")
     boolean hasCache() {
        {
            boolean var886CAF4B0310A6130F03FD63561B8234_1646233854 = (!checkInitialized());
        } 
        Cursor cursor = null;
        boolean ret = false;
        try 
        {
            cursor = mCacheDatabase.query("cache", ID_PROJECTION,
                    null, null, null, null, null);
            ret = cursor.moveToFirst() == true;
        } 
        catch (IllegalStateException e)
        { }
        finally 
        {
            cursor.close();
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_280869556 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_280869556;
        
        
            
        
        
        
        
            
                    
            
        
            
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.001 -0400", hash_original_method = "08C6E9C5D3BD785D378572A4A550228E", hash_generated_method = "C69E40C4F89FEAB319D8C75287F34927")
     long getCacheTotalSize() {
        long size = 0;
        Cursor cursor = null;
        final String query = "SELECT SUM(contentlength) as sum FROM cache";
        try 
        {
            cursor = mCacheDatabase.rawQuery(query, null);
            {
                boolean varCDEB7019138899FEAFBEC62FC2A4BF86_857391459 = (cursor.moveToFirst());
                {
                    size = cursor.getLong(0);
                } 
            } 
        } 
        catch (IllegalStateException e)
        { }
        finally 
        {
            cursor.close();
        } 
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1574066507 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1574066507;
        
        
            
        
        
        
        
        
            
            
                
            
        
            
        
            
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.003 -0400", hash_original_method = "E1CB3EA921D4F41F15D60CB73EFC3B4C", hash_generated_method = "0DB734BC8669DE60E56F480947773C8E")
     List<String> trimCache(long amount) {
        List<String> varB4EAC82CA7396A68D541C85D26508E83_1383646375 = null; 
        ArrayList<String> pathList = new ArrayList<String>(100);
        Cursor cursor = null;
        final String query = "SELECT contentlength, filepath FROM cache ORDER BY expires ASC";
        try 
        {
            cursor = mCacheDatabase.rawQuery(query, null);
            {
                boolean varCDEB7019138899FEAFBEC62FC2A4BF86_1443996494 = (cursor.moveToFirst());
                {
                    int batchSize = 100;
                    StringBuilder pathStr = new StringBuilder(20 + 16 * batchSize);
                    pathStr.append("DELETE FROM cache WHERE filepath IN (?");
                    {
                        int i = 1;
                        {
                            pathStr.append(", ?");
                        } 
                    } 
                    pathStr.append(")");
                    SQLiteStatement statement = null;
                    try 
                    {
                        statement = mCacheDatabase.compileStatement(
                            pathStr.toString());
                        int index = 1;
                        {
                            long length = cursor.getLong(0);
                            amount -= length;
                            String filePath = cursor.getString(1);
                            statement.bindString(index, filePath);
                            pathList.add(filePath);
                            {
                                statement.execute();
                                statement.clearBindings();
                                index = 1;
                            } 
                        } 
                        {
                            boolean var08B9D1EA537DD23B549DE53E3C14608E_1570650410 = (cursor.moveToNext() && amount > 0);
                        } 
                        {
                            statement.execute();
                        } 
                    } 
                    catch (IllegalStateException e)
                    { }
                    finally 
                    {
                        statement.close();
                    } 
                } 
            } 
        } 
        catch (IllegalStateException e)
        { }
        finally 
        {
            cursor.close();
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1383646375 = pathList;
        addTaint(amount);
        varB4EAC82CA7396A68D541C85D26508E83_1383646375.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1383646375;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.004 -0400", hash_original_method = "791DEB22BE9B55B5A0DA04ED6BE6D08D", hash_generated_method = "3497682D801607408DF6D0C6B7FEF45E")
     List<String> getAllCacheFileNames() {
        List<String> varB4EAC82CA7396A68D541C85D26508E83_1525505630 = null; 
        ArrayList<String> pathList = null;
        Cursor cursor = null;
        try 
        {
            cursor = mCacheDatabase.rawQuery("SELECT filepath FROM cache",
                    null);
            {
                boolean varAC25E083DAD430BEE33A18D42B764E17_1927599320 = (cursor != null && cursor.moveToFirst());
                {
                    pathList = new ArrayList<String>(cursor.getCount());
                    {
                        pathList.add(cursor.getString(0));
                    } 
                    {
                        boolean var4B88A4E0CCE1DD5CDA31BC6F14F1DD3B_227927262 = (cursor.moveToNext());
                    } 
                } 
            } 
        } 
        catch (IllegalStateException e)
        { }
        finally 
        {
            cursor.close();
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1525505630 = pathList;
        varB4EAC82CA7396A68D541C85D26508E83_1525505630.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1525505630;
        
        
        
        
            
                    
            
                
                
                    
                
            
        
            
        
            
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.005 -0400", hash_original_method = "06E61C8A80289A57F170E4E5B574929B", hash_generated_method = "BCB0D93CB9622210D4CDA3387D982EEF")
     void setUsernamePassword(String schemePlusHost, String username,
                String password) {
        {
            boolean var2649EC25D0E6A1FFB35B0F283FC7CC36_1319653790 = (schemePlusHost == null || !checkInitialized());
        } 
        {
            final ContentValues c = new ContentValues();
            c.put(PASSWORD_HOST_COL, schemePlusHost);
            c.put(PASSWORD_USERNAME_COL, username);
            c.put(PASSWORD_PASSWORD_COL, password);
            mDatabase.insert(mTableNames[TABLE_PASSWORD_ID], PASSWORD_HOST_COL,
                    c);
        } 
        addTaint(schemePlusHost.getTaint());
        addTaint(username.getTaint());
        addTaint(password.getTaint());
        
        
            
        
        
            
            
            
            
            
                    
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.006 -0400", hash_original_method = "AA29CF1F05823526F8013A43811B3B7E", hash_generated_method = "0303A4D9CBCC39DD5C876220F3734F98")
     String[] getUsernamePassword(String schemePlusHost) {
        String[] varB4EAC82CA7396A68D541C85D26508E83_1713044408 = null; 
        String[] varB4EAC82CA7396A68D541C85D26508E83_1759050835 = null; 
        {
            boolean var2649EC25D0E6A1FFB35B0F283FC7CC36_356552058 = (schemePlusHost == null || !checkInitialized());
            {
                varB4EAC82CA7396A68D541C85D26508E83_1713044408 = null;
            } 
        } 
        final String[] columns = new String[] {
                PASSWORD_USERNAME_COL, PASSWORD_PASSWORD_COL
        };
        final String selection = "(" + PASSWORD_HOST_COL + " == ?)";
        {
            String[] ret = null;
            Cursor cursor = null;
            try 
            {
                cursor = mDatabase.query(mTableNames[TABLE_PASSWORD_ID],
                        columns, selection, new String[] { schemePlusHost }, null,
                        null, null);
                {
                    boolean var77D7361540339637C7B1B1A9F784B876_1470880224 = (cursor.moveToFirst());
                    {
                        ret = new String[2];
                        ret[0] = cursor.getString(
                            cursor.getColumnIndex(PASSWORD_USERNAME_COL));
                        ret[1] = cursor.getString(
                            cursor.getColumnIndex(PASSWORD_PASSWORD_COL));
                    } 
                } 
            } 
            catch (IllegalStateException e)
            { }
            finally 
            {
                cursor.close();
            } 
            varB4EAC82CA7396A68D541C85D26508E83_1759050835 = ret;
        } 
        addTaint(schemePlusHost.getTaint());
        String[] varA7E53CE21691AB073D9660D615818899_1988621267; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1988621267 = varB4EAC82CA7396A68D541C85D26508E83_1713044408;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1988621267 = varB4EAC82CA7396A68D541C85D26508E83_1759050835;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1988621267.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1988621267;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.006 -0400", hash_original_method = "048A7854E0D4842D61BAD40D57C0F82F", hash_generated_method = "54D1553CE9C6E258053C3443D21403B2")
    public boolean hasUsernamePassword() {
        {
            boolean var07B2D4F64AFC2C93C8D780D2FCE02B3B_1253699788 = (hasEntries(TABLE_PASSWORD_ID));
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2067200804 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2067200804;
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.006 -0400", hash_original_method = "1884CD7855F3B6349631839451D5E408", hash_generated_method = "318A85CD089C52F9A57457860FD35DC3")
    public void clearUsernamePassword() {
        {
            boolean var886CAF4B0310A6130F03FD63561B8234_1410380669 = (!checkInitialized());
        } 
        {
            mDatabase.delete(mTableNames[TABLE_PASSWORD_ID], null, null);
        } 
        
        
            
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.007 -0400", hash_original_method = "AAEAEDF714B99771C21BA669DE54047C", hash_generated_method = "660EE3D34F17D88492ECCA0BCF534D73")
     void setHttpAuthUsernamePassword(String host, String realm, String username,
            String password) {
        {
            boolean var344A515C901BE55759AAD36F5C91CBAB_1592347229 = (host == null || realm == null || !checkInitialized());
        } 
        {
            final ContentValues c = new ContentValues();
            c.put(HTTPAUTH_HOST_COL, host);
            c.put(HTTPAUTH_REALM_COL, realm);
            c.put(HTTPAUTH_USERNAME_COL, username);
            c.put(HTTPAUTH_PASSWORD_COL, password);
            mDatabase.insert(mTableNames[TABLE_HTTPAUTH_ID], HTTPAUTH_HOST_COL,
                    c);
        } 
        addTaint(host.getTaint());
        addTaint(realm.getTaint());
        addTaint(username.getTaint());
        addTaint(password.getTaint());
        
        
            
        
        
            
            
            
            
            
            
                    
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.008 -0400", hash_original_method = "6E1D9953804AC08BC6DDA66478F3E8B6", hash_generated_method = "19638BB93FCD4562289D9914D7E199B7")
     String[] getHttpAuthUsernamePassword(String host, String realm) {
        String[] varB4EAC82CA7396A68D541C85D26508E83_1560253044 = null; 
        String[] varB4EAC82CA7396A68D541C85D26508E83_616764990 = null; 
        {
            boolean var344A515C901BE55759AAD36F5C91CBAB_1967270497 = (host == null || realm == null || !checkInitialized());
            {
                varB4EAC82CA7396A68D541C85D26508E83_1560253044 = null;
            } 
        } 
        final String[] columns = new String[] {
                HTTPAUTH_USERNAME_COL, HTTPAUTH_PASSWORD_COL
        };
        final String selection = "(" + HTTPAUTH_HOST_COL + " == ?) AND ("
                + HTTPAUTH_REALM_COL + " == ?)";
        {
            String[] ret = null;
            Cursor cursor = null;
            try 
            {
                cursor = mDatabase.query(mTableNames[TABLE_HTTPAUTH_ID],
                        columns, selection, new String[] { host, realm }, null,
                        null, null);
                {
                    boolean var77D7361540339637C7B1B1A9F784B876_955731848 = (cursor.moveToFirst());
                    {
                        ret = new String[2];
                        ret[0] = cursor.getString(
                            cursor.getColumnIndex(HTTPAUTH_USERNAME_COL));
                        ret[1] = cursor.getString(
                            cursor.getColumnIndex(HTTPAUTH_PASSWORD_COL));
                    } 
                } 
            } 
            catch (IllegalStateException e)
            { }
            finally 
            {
                cursor.close();
            } 
            varB4EAC82CA7396A68D541C85D26508E83_616764990 = ret;
        } 
        addTaint(host.getTaint());
        addTaint(realm.getTaint());
        String[] varA7E53CE21691AB073D9660D615818899_1428880974; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1428880974 = varB4EAC82CA7396A68D541C85D26508E83_1560253044;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1428880974 = varB4EAC82CA7396A68D541C85D26508E83_616764990;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1428880974.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1428880974;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.008 -0400", hash_original_method = "50C83C4F45D13310D76D1C1AF4DB3EDF", hash_generated_method = "5B3A2522259687FED1D7EC66EF0E19B2")
    public boolean hasHttpAuthUsernamePassword() {
        {
            boolean var3C1434142A0FDF9785EF38B5A38F85FE_1558136186 = (hasEntries(TABLE_HTTPAUTH_ID));
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1395651220 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1395651220;
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.009 -0400", hash_original_method = "447C774EFBF83BDF0A062EB0F2F80455", hash_generated_method = "217235795F5F2C3B0627ACC9D2890462")
    public void clearHttpAuthUsernamePassword() {
        {
            boolean var886CAF4B0310A6130F03FD63561B8234_334111792 = (!checkInitialized());
        } 
        {
            mDatabase.delete(mTableNames[TABLE_HTTPAUTH_ID], null, null);
        } 
        
        
            
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.010 -0400", hash_original_method = "1C1CA3B21EC6341A527B545FB0F444FE", hash_generated_method = "29C4F9FF9B2E0937394719AD2FF3AA7B")
     void setFormData(String url, HashMap<String, String> formdata) {
        {
            boolean varEAA6464961CE63B8309DF6A515888FBD_1915540170 = (url == null || formdata == null || !checkInitialized());
        } 
        final String selection = "(" + FORMURL_URL_COL + " == ?)";
        {
            long urlid = -1;
            Cursor cursor = null;
            try 
            {
                cursor = mDatabase.query(mTableNames[TABLE_FORMURL_ID],
                        ID_PROJECTION, selection, new String[] { url }, null, null,
                        null);
                {
                    boolean var77D7361540339637C7B1B1A9F784B876_321645616 = (cursor.moveToFirst());
                    {
                        urlid = cursor.getLong(cursor.getColumnIndex(ID_COL));
                    } 
                    {
                        ContentValues c = new ContentValues();
                        c.put(FORMURL_URL_COL, url);
                        urlid = mDatabase.insert(
                            mTableNames[TABLE_FORMURL_ID], null, c);
                    } 
                } 
            } 
            catch (IllegalStateException e)
            { }
            finally 
            {
                cursor.close();
            } 
            {
                Set<Entry<String, String>> set = formdata.entrySet();
                Iterator<Entry<String, String>> iter = set.iterator();
                ContentValues map = new ContentValues();
                map.put(FORMDATA_URLID_COL, urlid);
                {
                    boolean var2533A21149F7AACF984863A299EFC64E_61849437 = (iter.hasNext());
                    {
                        Entry<String, String> entry = iter.next();
                        map.put(FORMDATA_NAME_COL, entry.getKey());
                        map.put(FORMDATA_VALUE_COL, entry.getValue());
                        mDatabase.insert(mTableNames[TABLE_FORMDATA_ID], null, map);
                    } 
                } 
            } 
        } 
        addTaint(url.getTaint());
        addTaint(formdata.getTaint());
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.013 -0400", hash_original_method = "699FE9DC5ACA57A32D74F51785DE679D", hash_generated_method = "AE5975E3CD0E4039E44F01A3104B122D")
     ArrayList<String> getFormData(String url, String name) {
        ArrayList<String> varB4EAC82CA7396A68D541C85D26508E83_1840212567 = null; 
        ArrayList<String> varB4EAC82CA7396A68D541C85D26508E83_573502513 = null; 
        ArrayList<String> values = new ArrayList<String>();
        {
            boolean var117B0C9C104D1BD8746A9A506D51BADA_287500809 = (url == null || name == null || !checkInitialized());
            {
                varB4EAC82CA7396A68D541C85D26508E83_1840212567 = values;
            } 
        } 
        final String urlSelection = "(" + FORMURL_URL_COL + " == ?)";
        final String dataSelection = "(" + FORMDATA_URLID_COL + " == ?) AND ("
                + FORMDATA_NAME_COL + " == ?)";
        {
            Cursor cursor = null;
            try 
            {
                cursor = mDatabase.query(mTableNames[TABLE_FORMURL_ID],
                        ID_PROJECTION, urlSelection, new String[] { url }, null,
                        null, null);
                {
                    boolean var916090E1B2D032E1EC67FFC8B3451FBE_1748147563 = (cursor.moveToNext());
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
                            {
                                boolean var0EB2134124D3477C8F1F4B9930E6665F_389190995 = (dataCursor.moveToFirst());
                                {
                                    int valueCol = dataCursor.getColumnIndex(
                                    FORMDATA_VALUE_COL);
                                    {
                                        values.add(dataCursor.getString(valueCol));
                                    } 
                                    {
                                        boolean var041EBA3F0B4A68A2FACFE169A0256538_2085953719 = (dataCursor.moveToNext());
                                    } 
                                } 
                            } 
                        } 
                        catch (IllegalStateException e)
                        { }
                        finally 
                        {
                            dataCursor.close();
                        } 
                    } 
                } 
            } 
            catch (IllegalStateException e)
            { }
            finally 
            {
                cursor.close();
            } 
            varB4EAC82CA7396A68D541C85D26508E83_573502513 = values;
        } 
        addTaint(url.getTaint());
        addTaint(name.getTaint());
        ArrayList<String> varA7E53CE21691AB073D9660D615818899_2489497; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_2489497 = varB4EAC82CA7396A68D541C85D26508E83_1840212567;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2489497 = varB4EAC82CA7396A68D541C85D26508E83_573502513;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2489497.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_2489497;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.013 -0400", hash_original_method = "6553D4A66AD572AF8668D3FA13E3C7D5", hash_generated_method = "05181152AEDAB6731851B6A67E50FD1E")
    public boolean hasFormData() {
        {
            boolean var187874045FD9FFC3AB266955A077A815_855276281 = (hasEntries(TABLE_FORMURL_ID));
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2059063162 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2059063162;
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.014 -0400", hash_original_method = "9C11F1BCAAD785FEF89EC2FF8E172198", hash_generated_method = "DD6DCB08E4583A8C7A4F0309331370C9")
    public void clearFormData() {
        {
            boolean var886CAF4B0310A6130F03FD63561B8234_1700618069 = (!checkInitialized());
        } 
        {
            mDatabase.delete(mTableNames[TABLE_FORMURL_ID], null, null);
            mDatabase.delete(mTableNames[TABLE_FORMDATA_ID], null, null);
        } 
        
        
            
        
        
            
            
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.014 -0400", hash_original_field = "97FB093BE733A1BA7EBC7D4C2F724030", hash_generated_field = "E8D0A6CD52C04E0659D4FC87D336D0AC")

    private static final String DATABASE_FILE = "webview.db";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.014 -0400", hash_original_field = "0C79379A4FFB67C6B34DD7254190E080", hash_generated_field = "B17A3300247FF520B718A6CB6B02A944")

    private static final String CACHE_DATABASE_FILE = "webviewCache.db";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.014 -0400", hash_original_field = "5F2F293DA7031522319625D7791812FB", hash_generated_field = "24A942646779149EC1E70531789CBBAC")

    protected static final String LOGTAG = "webviewdatabase";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.014 -0400", hash_original_field = "31403FB301FD84D0D8EDD7CEBEFFEF27", hash_generated_field = "C1B002270A3E3DA04EE8826B5BFBB2B5")

    private static final int DATABASE_VERSION = 11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.014 -0400", hash_original_field = "9CC00DFB3E1D38EFCB8A11C16265B5E5", hash_generated_field = "9541082229959783D272F5B70DE9D33C")

    private static final int CACHE_DATABASE_VERSION = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.014 -0400", hash_original_field = "BB5542AD4EE4FC87B3BF30A334DCA037", hash_generated_field = "B8A911681F373C0D77BEF69151B32586")

    private static WebViewDatabase mInstance = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.014 -0400", hash_original_field = "961E4258F7E74A9EAA9E39B39D6F0A80", hash_generated_field = "2A9DC9A5BD2819616E44A0ADAFECE4A7")

    private static SQLiteDatabase mDatabase = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.014 -0400", hash_original_field = "471BCFDB7D950F157B32C5FC2BA7DD1E", hash_generated_field = "6216361743BC8C4805B411B6532C00A7")

    private static SQLiteDatabase mCacheDatabase = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.014 -0400", hash_original_field = "73DF9C71C5AD092E447107AB62B115B2", hash_generated_field = "82494AB72BCFBC647B4C24C95E37B56F")

    private static final String mTableNames[] = {
        "cookies", "password", "formurl", "formdata", "httpauth"
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.014 -0400", hash_original_field = "F593950478528A06B7E618081AF6BC06", hash_generated_field = "E071736BB1C54763EB26EE8955F646D4")

    private static final int TABLE_COOKIES_ID = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.014 -0400", hash_original_field = "FA94619CB79D784E757BAE068E993510", hash_generated_field = "C26654F80C65505FF03B4C5B6DA105F3")

    private static final int TABLE_PASSWORD_ID = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.014 -0400", hash_original_field = "D92065FCA5B01DC8E4A52875C8D97506", hash_generated_field = "F83A26899C0F0D2C1ACAA87EEDA0153E")

    private static final int TABLE_FORMURL_ID = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.014 -0400", hash_original_field = "7F257D48419A2777A6EA39E834F7207D", hash_generated_field = "D07F66BAD2BCF3FAD0DB03739B7A2A53")

    private static final int TABLE_FORMDATA_ID = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.014 -0400", hash_original_field = "A94514E22B657C7979ACEA63002C0267", hash_generated_field = "213F1FE4C5C8147C0E3AA82A86D16003")

    private static final int TABLE_HTTPAUTH_ID = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.014 -0400", hash_original_field = "95AAD2805FDD44BA5CEE24DC0D89F133", hash_generated_field = "544D8A467AF5FAAA84AB157CE043EFEA")

    private static final String ID_COL = "_id";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.014 -0400", hash_original_field = "8EFD18DD0B691B2376E9269460018650", hash_generated_field = "E30EDA8D5CEF5DBC0865B3EFC9FE624F")

    private static final String[] ID_PROJECTION = new String[] {
        "_id"
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.014 -0400", hash_original_field = "10031FB5E52444A11A3BCFFAFA0DB528", hash_generated_field = "9A9E4A560333679ACF0CA07A793F6029")

    private static final String COOKIES_NAME_COL = "name";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.014 -0400", hash_original_field = "7934BB4FC757A6BDF45F6DD59D588727", hash_generated_field = "36856FCE215FA203C61B4737E1A6D314")

    private static final String COOKIES_VALUE_COL = "value";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.014 -0400", hash_original_field = "0B900D9814FA51A015157D877FD0DE65", hash_generated_field = "974379DCBAF58FDB14009A07716F2DE3")

    private static final String COOKIES_DOMAIN_COL = "domain";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.014 -0400", hash_original_field = "62947D46AA00728C394B0C7F5ED76489", hash_generated_field = "919C7E98C32C3DE4E674B31354083103")

    private static final String COOKIES_PATH_COL = "path";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.014 -0400", hash_original_field = "35F03590FDED597FA22FC6D2F228B03B", hash_generated_field = "92595ACB5997D57A9912CEC295FFD385")

    private static final String COOKIES_EXPIRES_COL = "expires";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.014 -0400", hash_original_field = "9C3805CAF4F09E4D6BF79B844F71B6C7", hash_generated_field = "4555D5715510CC15CD635D945C145E69")

    private static final String COOKIES_SECURE_COL = "secure";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.014 -0400", hash_original_field = "A80A5692E900FB179643B9614EA0A73E", hash_generated_field = "26E13854774B9D7E5B3D124BA1DA43C8")

    private static final String CACHE_URL_COL = "url";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.014 -0400", hash_original_field = "712707BAA6B086C607E0202AAF178FBD", hash_generated_field = "FBB51F4E9164A38BC02FE055D0D31F69")

    private static final String CACHE_FILE_PATH_COL = "filepath";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.014 -0400", hash_original_field = "1EB91D94EDBC60EF9C1FA4511DE24937", hash_generated_field = "E4EDB200A85003914E478A614635D399")

    private static final String CACHE_LAST_MODIFY_COL = "lastmodify";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.014 -0400", hash_original_field = "A03AA7E24168AE56F7FF90675A1DAF68", hash_generated_field = "E63A0BBF23F285D448CCD1D377216419")

    private static final String CACHE_ETAG_COL = "etag";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.014 -0400", hash_original_field = "E2A338B20B6E3D0E8A2F1EB711F9B7C5", hash_generated_field = "D715992BD667778579FCD9642CD2DF0B")

    private static final String CACHE_EXPIRES_COL = "expires";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.014 -0400", hash_original_field = "A893B60A4C7E3090551F1A87DC567F05", hash_generated_field = "7EA32DCE9FCB8F00238F15D76A4D1EB0")

    private static final String CACHE_EXPIRES_STRING_COL = "expiresstring";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.014 -0400", hash_original_field = "34996420DB663AF981B76C3FFAECB4D2", hash_generated_field = "4346EC9A786A0D8B47B0AF2F746CCDF9")

    private static final String CACHE_MIMETYPE_COL = "mimetype";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.014 -0400", hash_original_field = "F3EDAB1F8BC7D0C841BC36BC6E8FDF85", hash_generated_field = "A5B14468B66E4C651D16A4B4EF3D4988")

    private static final String CACHE_ENCODING_COL = "encoding";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.014 -0400", hash_original_field = "8C6C0AB77168966480E9A2DC76DFF0A9", hash_generated_field = "74EDAC14B6454EB4BD8EC537D3A48C1D")

    private static final String CACHE_HTTP_STATUS_COL = "httpstatus";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.014 -0400", hash_original_field = "4039EE0305B9310C87FC6733374047E9", hash_generated_field = "AC242FF315AD73BD18B75D87F22A121D")

    private static final String CACHE_LOCATION_COL = "location";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.015 -0400", hash_original_field = "75D435936AED501CFCA0FE328E0E59FA", hash_generated_field = "A45041FED79C2F37B614E43E9EAA62EE")

    private static final String CACHE_CONTENTLENGTH_COL = "contentlength";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.015 -0400", hash_original_field = "3A78765ECB553FFA4185642D15F51660", hash_generated_field = "12021DAB4B009D47C4C0B03A8B7F08FB")

    private static final String CACHE_CONTENTDISPOSITION_COL = "contentdisposition";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.015 -0400", hash_original_field = "377B1EC21E011CF4D5C57C266BA339C3", hash_generated_field = "0C17DB9AB903701BF734F0A36DECDE32")

    private static final String CACHE_CROSSDOMAIN_COL = "crossdomain";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.015 -0400", hash_original_field = "4357EB3E2B353B26939F7CD277B802CE", hash_generated_field = "C9B09646DBA0EE3D1FD4703689B6709E")

    private static final String PASSWORD_HOST_COL = "host";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.015 -0400", hash_original_field = "5EA201ED1318E58ADA3981C6F9A89356", hash_generated_field = "4834A6E26AC690BEEDA4205B55E80F71")

    private static final String PASSWORD_USERNAME_COL = "username";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.015 -0400", hash_original_field = "E6B3A21470DBD7C6290F62AC3649EC3E", hash_generated_field = "6169E1A26615324546DDBAFA8EA35E46")

    private static final String PASSWORD_PASSWORD_COL = "password";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.015 -0400", hash_original_field = "508345AAA07699F2CFC5E79EC1FE4D96", hash_generated_field = "405F7907F7A8C1D13F6685D3670B540F")

    private static final String FORMURL_URL_COL = "url";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.015 -0400", hash_original_field = "B6AE36F0C577EED59663D75D6050DB36", hash_generated_field = "F5DC4499DBB3D0AB9C3FBC85716B75BD")

    private static final String FORMDATA_URLID_COL = "urlid";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.015 -0400", hash_original_field = "CB57F57686547126214EF36106A16F3A", hash_generated_field = "AC7FD45F189A1AFA7D8D735589B88FEC")

    private static final String FORMDATA_NAME_COL = "name";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.015 -0400", hash_original_field = "7B80A9211FC7021F6A780184A5E65546", hash_generated_field = "6301A8ABA0887A6D2B97FE4E3D00C0D7")

    private static final String FORMDATA_VALUE_COL = "value";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.015 -0400", hash_original_field = "218C4151B8B7B0BEFEBFE3A9D3598A58", hash_generated_field = "A49759473C2E0C990FC7CE8A30842EC9")

    private static final String HTTPAUTH_HOST_COL = "host";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.015 -0400", hash_original_field = "742869D98EC1C65FE55950316D908AE7", hash_generated_field = "A8836A926F4D3E2666084C23DE3ABA47")

    private static final String HTTPAUTH_REALM_COL = "realm";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.015 -0400", hash_original_field = "4735043625F795828DFBEC75674C1301", hash_generated_field = "E43FF3904390D4343F6CBCC7E76BB50A")

    private static final String HTTPAUTH_USERNAME_COL = "username";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.015 -0400", hash_original_field = "D470AC4924A89065E285659BD318A916", hash_generated_field = "306AFBB09ADAF2FFC1BE20DBB1DE10A6")

    private static final String HTTPAUTH_PASSWORD_COL = "password";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.015 -0400", hash_original_field = "02CCE22A311CADFB11AFA26DCB73108F", hash_generated_field = "9978AB64D9ADE743F038BE7845E6172E")

    private static DatabaseUtils.InsertHelper mCacheInserter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.015 -0400", hash_original_field = "530F644F14A9D5DD748EBC732472B324", hash_generated_field = "3910FC6AB35DAF5F19CCEF25E8654783")

    private static int mCacheUrlColIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.015 -0400", hash_original_field = "8F160C6A8858DBB8979E9D379C99A457", hash_generated_field = "6D70A03DEA5E92F04910BB7E9E1D9224")

    private static int mCacheFilePathColIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.015 -0400", hash_original_field = "6377FFA093CA55A749CCAF38186A15C1", hash_generated_field = "F297F7407A43B3D8B550234904F928F5")

    private static int mCacheLastModifyColIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.015 -0400", hash_original_field = "3669079542CCEB87D992EC9A2B016E6C", hash_generated_field = "7E671A6F0167C6AE2F10F590C7DC601E")

    private static int mCacheETagColIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.015 -0400", hash_original_field = "6F203D5A48CD57B37CA7994C04473BA1", hash_generated_field = "09E6E173F9C3511818B6258041F0A3BC")

    private static int mCacheExpiresColIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.015 -0400", hash_original_field = "8399E380BC6C8A7F8233460E5512C2EB", hash_generated_field = "9DDE47C8C21140680D9D21457C8BA030")

    private static int mCacheExpiresStringColIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.015 -0400", hash_original_field = "98BDBB3BB565D12BD211BF6037141DA5", hash_generated_field = "6EC0F1436186404D863C79D70C9D0422")

    private static int mCacheMimeTypeColIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.015 -0400", hash_original_field = "3BDEE775811BDD2BF14998EC6455776E", hash_generated_field = "67A46391EDD0D1EEFDAA1EF5F50C5C78")

    private static int mCacheEncodingColIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.015 -0400", hash_original_field = "CBCF5080B4DC20A6213C93C825039E53", hash_generated_field = "E8069F7EB9821C68B302A5C70FE84C68")

    private static int mCacheHttpStatusColIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.015 -0400", hash_original_field = "1FCF38A62D6BCBEBB44109FDE952327D", hash_generated_field = "DA4DBC2E2AF89F71F7CF53E4A0F9DB44")

    private static int mCacheLocationColIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.015 -0400", hash_original_field = "F85753B97AF9626AF8FA6CBB1D6C32CA", hash_generated_field = "2CEFBAF45A5360D0C6A73071406979A0")

    private static int mCacheContentLengthColIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.015 -0400", hash_original_field = "A220E2B3B8458CE24E0CBE61BBFE1F56", hash_generated_field = "C4C9ED448FAD4F85DBEA109ADF0942B5")

    private static int mCacheContentDispositionColIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.015 -0400", hash_original_field = "8AC55427B838864F99762F4B9E97B74A", hash_generated_field = "07EC8A1B46BF12BB85378082FD36D87C")

    private static int mCacheCrossDomainColIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.015 -0400", hash_original_field = "3A45B26C5E71778F0FB720FAABAC85BD", hash_generated_field = "BFC3FA813D8D5121BE43E51DCA5BBA65")

    private static int mCacheTransactionRefcount;
}

