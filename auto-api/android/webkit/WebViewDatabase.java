package android.webkit;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:03.440 -0400", hash_original_field = "867BB3294E9C68C99FCD8CAE06CC4189", hash_generated_field = "72C773362F8F65C2E3AF66E73A7B9459")

    private Object mCookieLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:03.440 -0400", hash_original_field = "8002E7A58D1BE5163381E484BA29B73A", hash_generated_field = "0844C5AB5778D8F66667FD901B098905")

    private Object mPasswordLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:03.440 -0400", hash_original_field = "1F62250EEFC8639157DBB68AD5BDC8F7", hash_generated_field = "B4B7AD045E0DD678DAE16A92FFEB907B")

    private Object mFormLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:03.440 -0400", hash_original_field = "4540D6026C066EC4C652DDF2BCB91F3D", hash_generated_field = "7ACD4543AB15D384AFD8C57638A5AB86")

    private Object mHttpAuthLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:03.440 -0400", hash_original_field = "82073B9F728953BFC0E99AB45C8BBB4A", hash_generated_field = "E5CA3845DA8FE08BE201D5EDF15F54DD")

    private boolean mInitialized = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:03.442 -0400", hash_original_method = "EFB05B9D3FCAB305323B10379F1EC778", hash_generated_method = "7EB69A54BB31C3AAEB39A19A1B796F9A")
    private  WebViewDatabase(final Context context) {
        new Thread() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:03.442 -0400", hash_original_method = "016F23FCFDABFB49215E1C5AD86A4960", hash_generated_method = "857237709B575C3CEAE7C4725FBD2553")
            @Override
            public void run() {
                init(context);
                // ---------- Original Method ----------
                //init(context);
            }
}.start();
        addTaint(context.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:03.453 -0400", hash_original_method = "AC87AD0E19559694D58F1943BD15C1D5", hash_generated_method = "2B8489666D31CA5F6A3CB2067959D576")
    private synchronized void init(Context context) {
        initDatabase(context);
        {
            boolean var9ACB1B3B30D2C0CED704DA8C8B3FC1B9_1748608851 = (JniUtil.useChromiumHttpStack());
            {
                context.deleteDatabase(CACHE_DATABASE_FILE);
            } //End block
            {
                initCacheDatabase(context);
            } //End block
        } //End collapsed parenthetic
        mInitialized = true;
        notify();
        addTaint(context.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:03.454 -0400", hash_original_method = "CE06D258DB88B89F42DED68141C198E0", hash_generated_method = "AA1F78746881CBBD4A094597DC027663")
    private void initDatabase(Context context) {
        try 
        {
            mDatabase = context.openOrCreateDatabase(DATABASE_FILE, 0, null);
        } //End block
        catch (SQLiteException e)
        {
            {
                boolean var8ADF77EF24056E62D97D24430E7CC726_1599613320 = (context.deleteDatabase(DATABASE_FILE));
                {
                    mDatabase = context.openOrCreateDatabase(DATABASE_FILE, 0,
                        null);
                } //End block
            } //End collapsed parenthetic
        } //End block
        mDatabase.enableWriteAheadLogging();
        {
            mInitialized = true;
            notify();
        } //End block
        {
            boolean varA450E818A17AB5CEAFA5DCA2D2F53F99_1992885457 = (mDatabase.getVersion() != DATABASE_VERSION);
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
        } //End collapsed parenthetic
        mDatabase.setLockingEnabled(false);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:03.456 -0400", hash_original_method = "C7A89DE182CA76C10CB3961C893695C2", hash_generated_method = "D668D568AD67B382623584DDBD058610")
    private void initCacheDatabase(Context context) {
        try 
        {
            mCacheDatabase = context.openOrCreateDatabase(
                    CACHE_DATABASE_FILE, 0, null);
        } //End block
        catch (SQLiteException e)
        {
            {
                boolean var06845C84D0D12A7575979F07C5042A97_487150493 = (context.deleteDatabase(CACHE_DATABASE_FILE));
                {
                    mCacheDatabase = context.openOrCreateDatabase(
                        CACHE_DATABASE_FILE, 0, null);
                } //End block
            } //End collapsed parenthetic
        } //End block
        mCacheDatabase.enableWriteAheadLogging();
        {
            mInitialized = true;
            notify();
        } //End block
        {
            boolean var9F5CCB2C1429C972D5DCFFA8EAC58C5C_1440804888 = (mCacheDatabase.getVersion() != CACHE_DATABASE_VERSION);
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
        } //End collapsed parenthetic
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        private static void upgradeDatabase() {
        upgradeDatabaseToV10();
        upgradeDatabaseFromV10ToV11();
        mDatabase.setVersion(DATABASE_VERSION);
    }

    
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:03.477 -0400", hash_original_method = "B19C14CCA683C2C1072DDA1B7A6274D5", hash_generated_method = "335D0BD587D8E116937CFF8A662BE875")
    private boolean checkInitialized() {
        {
            {
                try 
                {
                    wait();
                } //End block
                catch (InterruptedException e)
                { }
            } //End block
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1447342508 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1447342508;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:03.478 -0400", hash_original_method = "CBFCA06012BEB8B609A8EBC6EEC6D1A4", hash_generated_method = "E9A99CD18B5FAB31D0D9AE03BF01E4B1")
    private boolean hasEntries(int tableId) {
        {
            boolean var886CAF4B0310A6130F03FD63561B8234_1368414890 = (!checkInitialized());
        } //End collapsed parenthetic
        Cursor cursor;
        cursor = null;
        boolean ret;
        ret = false;
        try 
        {
            cursor = mDatabase.query(mTableNames[tableId], ID_PROJECTION,
                    null, null, null, null, null);
            ret = cursor.moveToFirst() == true;
        } //End block
        catch (IllegalStateException e)
        { }
        finally 
        {
            cursor.close();
        } //End block
        addTaint(tableId);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_340545074 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_340545074;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:03.490 -0400", hash_original_method = "4D94521780B9AD3D8F70E78E8CBCD3E0", hash_generated_method = "8FABDA5196D9178C02427AAA5FBED5F9")
     ArrayList<Cookie> getCookiesForDomain(String domain) {
        ArrayList<Cookie> varB4EAC82CA7396A68D541C85D26508E83_1358060157 = null; //Variable for return #1
        ArrayList<Cookie> varB4EAC82CA7396A68D541C85D26508E83_2117854759 = null; //Variable for return #2
        ArrayList<Cookie> list;
        list = new ArrayList<Cookie>();
        {
            boolean varA8DB3C3C11FB3F67134323DBA3E29A4F_1167641880 = (domain == null || !checkInitialized());
            {
                varB4EAC82CA7396A68D541C85D26508E83_1358060157 = list;
            } //End block
        } //End collapsed parenthetic
        {
            String[] columns;
            columns = new String[] {
                    ID_COL, COOKIES_DOMAIN_COL, COOKIES_PATH_COL,
                    COOKIES_NAME_COL, COOKIES_VALUE_COL, COOKIES_EXPIRES_COL,
                    COOKIES_SECURE_COL
            };
            String selection;
            selection = "(" + COOKIES_DOMAIN_COL
                    + " GLOB '*' || ?)";
            Cursor cursor;
            cursor = null;
            try 
            {
                cursor = mDatabase.query(mTableNames[TABLE_COOKIES_ID],
                        columns, selection, new String[] { domain }, null, null,
                        null);
                {
                    boolean var77D7361540339637C7B1B1A9F784B876_1334015301 = (cursor.moveToFirst());
                    {
                        int domainCol;
                        domainCol = cursor.getColumnIndex(COOKIES_DOMAIN_COL);
                        int pathCol;
                        pathCol = cursor.getColumnIndex(COOKIES_PATH_COL);
                        int nameCol;
                        nameCol = cursor.getColumnIndex(COOKIES_NAME_COL);
                        int valueCol;
                        valueCol = cursor.getColumnIndex(COOKIES_VALUE_COL);
                        int expiresCol;
                        expiresCol = cursor.getColumnIndex(COOKIES_EXPIRES_COL);
                        int secureCol;
                        secureCol = cursor.getColumnIndex(COOKIES_SECURE_COL);
                        {
                            Cookie cookie;
                            cookie = new Cookie();
                            cookie.domain = cursor.getString(domainCol);
                            cookie.path = cursor.getString(pathCol);
                            cookie.name = cursor.getString(nameCol);
                            cookie.value = cursor.getString(valueCol);
                            {
                                boolean var80D05DB7C23C7A8C68D1BD5C13F8B946_1865298641 = (cursor.isNull(expiresCol));
                                {
                                    cookie.expires = -1;
                                } //End block
                                {
                                    cookie.expires = cursor.getLong(expiresCol);
                                } //End block
                            } //End collapsed parenthetic
                            cookie.secure = cursor.getShort(secureCol) != 0;
                            cookie.mode = Cookie.MODE_NORMAL;
                            list.add(cookie);
                        } //End block
                        {
                            boolean varEEE3E1704288A6D03EB8C70F2484A2B3_1692149989 = (cursor.moveToNext());
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
            catch (IllegalStateException e)
            { }
            finally 
            {
                cursor.close();
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_2117854759 = list;
        } //End block
        addTaint(domain.getTaint());
        ArrayList<Cookie> varA7E53CE21691AB073D9660D615818899_966256884; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_966256884 = varB4EAC82CA7396A68D541C85D26508E83_1358060157;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_966256884 = varB4EAC82CA7396A68D541C85D26508E83_2117854759;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_966256884.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_966256884;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:03.494 -0400", hash_original_method = "BC23D2938EE88E31CA87024518493BE2", hash_generated_method = "8F41BB2FC9B66CA123E07821387E0458")
     void deleteCookies(String domain, String path, String name) {
        {
            boolean varA8DB3C3C11FB3F67134323DBA3E29A4F_1712370300 = (domain == null || !checkInitialized());
        } //End collapsed parenthetic
        {
            String where;
            where = "(" + COOKIES_DOMAIN_COL + " == ?) AND ("
                    + COOKIES_PATH_COL + " == ?) AND (" + COOKIES_NAME_COL
                    + " == ?)";
            mDatabase.delete(mTableNames[TABLE_COOKIES_ID], where,
                    new String[] { domain, path, name });
        } //End block
        addTaint(domain.getTaint());
        addTaint(path.getTaint());
        addTaint(name.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:03.495 -0400", hash_original_method = "33710CB1E65A2C52E9ABEE23433BB87F", hash_generated_method = "84A5748EF77BD28A43600716D61A2E06")
     void addCookie(Cookie cookie) {
        {
            boolean var39BA779873F941960A4C4EA6029A7B0F_1359515907 = (cookie.domain == null || cookie.path == null || cookie.name == null
                || !checkInitialized());
        } //End collapsed parenthetic
        {
            ContentValues cookieVal;
            cookieVal = new ContentValues();
            cookieVal.put(COOKIES_DOMAIN_COL, cookie.domain);
            cookieVal.put(COOKIES_PATH_COL, cookie.path);
            cookieVal.put(COOKIES_NAME_COL, cookie.name);
            cookieVal.put(COOKIES_VALUE_COL, cookie.value);
            {
                cookieVal.put(COOKIES_EXPIRES_COL, cookie.expires);
            } //End block
            cookieVal.put(COOKIES_SECURE_COL, cookie.secure);
            mDatabase.insert(mTableNames[TABLE_COOKIES_ID], null, cookieVal);
        } //End block
        addTaint(cookie.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:03.503 -0400", hash_original_method = "83E6237273AAD0C9F4D2DED923ACAFB7", hash_generated_method = "A3C6AE8A2563A057A8E8EB94BCF89A25")
     boolean hasCookies() {
        {
            boolean varDB253D8D15C430D06B36D069D7680A2A_748323411 = (hasEntries(TABLE_COOKIES_ID));
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1564226133 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1564226133;
        // ---------- Original Method ----------
        //synchronized (mCookieLock) {
            //return hasEntries(TABLE_COOKIES_ID);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:03.503 -0400", hash_original_method = "3E1D9455881C3029C0C51566A563B8F4", hash_generated_method = "32FC8EDA0955290469B07528EC9C7701")
     void clearCookies() {
        {
            boolean var886CAF4B0310A6130F03FD63561B8234_1303834722 = (!checkInitialized());
        } //End collapsed parenthetic
        {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:03.504 -0400", hash_original_method = "CAA5F0320575B2151920B0F146B122B7", hash_generated_method = "CDD565A733F9B7D96F46BCF3635B01C6")
     void clearSessionCookies() {
        {
            boolean var886CAF4B0310A6130F03FD63561B8234_366379529 = (!checkInitialized());
        } //End collapsed parenthetic
        String sessionExpired;
        sessionExpired = COOKIES_EXPIRES_COL + " ISNULL";
        {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:03.504 -0400", hash_original_method = "AD90F95A26E2D9ECD94EF58E091F4A84", hash_generated_method = "E2CCDDB673FFE6E01B9038287A2323AC")
     void clearExpiredCookies(long now) {
        {
            boolean var886CAF4B0310A6130F03FD63561B8234_924664520 = (!checkInitialized());
        } //End collapsed parenthetic
        String expires;
        expires = COOKIES_EXPIRES_COL + " <= ?";
        {
            mDatabase.delete(mTableNames[TABLE_COOKIES_ID], expires,
                    new String[] { Long.toString(now) });
        } //End block
        addTaint(now);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:03.511 -0400", hash_original_method = "26A436743D42208E44F8DC7C1FFF5A77", hash_generated_method = "F94A5BFB9F2343A901DCC87EDE488F04")
     boolean startCacheTransaction() {
        {
            {
                boolean var19CEF9F46A61A60E9C53BA833277B14B_2142240396 = (!Thread.currentThread().equals(
                    WebViewWorker.getHandler().getLooper().getThread()));
            } //End collapsed parenthetic
            mCacheDatabase.beginTransactionNonExclusive();
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_705094585 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_705094585;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:03.512 -0400", hash_original_method = "14B92CCE9ED71BB98EE6E80EBC3B995B", hash_generated_method = "35D99E6499750212068E152AD72715BB")
     boolean endCacheTransaction() {
        {
            {
                boolean var19CEF9F46A61A60E9C53BA833277B14B_1894724376 = (!Thread.currentThread().equals(
                    WebViewWorker.getHandler().getLooper().getThread()));
            } //End collapsed parenthetic
            try 
            {
                mCacheDatabase.setTransactionSuccessful();
            } //End block
            finally 
            {
                mCacheDatabase.endTransaction();
            } //End block
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1074968753 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1074968753;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:03.517 -0400", hash_original_method = "BF73224910862A6343E046C49771A81E", hash_generated_method = "285EABD15550FECAB4DCDF06A484918B")
     CacheResult getCache(String url) {
        CacheResult varB4EAC82CA7396A68D541C85D26508E83_1643994004 = null; //Variable for return #1
        CacheResult varB4EAC82CA7396A68D541C85D26508E83_852512324 = null; //Variable for return #2
        CacheResult varB4EAC82CA7396A68D541C85D26508E83_2089682823 = null; //Variable for return #3
        {
            boolean var5AE2624D4B934FA39D4CA4D237A622F0_249713913 = (url == null || !checkInitialized());
            {
                varB4EAC82CA7396A68D541C85D26508E83_1643994004 = null;
            } //End block
        } //End collapsed parenthetic
        Cursor cursor;
        cursor = null;
        String query;
        query = "SELECT filepath, lastmodify, etag, expires, "
                + "expiresstring, mimetype, encoding, httpstatus, location, contentlength, "
                + "contentdisposition, crossdomain FROM cache WHERE url = ?";
        try 
        {
            cursor = mCacheDatabase.rawQuery(query, new String[] { url });
            {
                boolean varCDEB7019138899FEAFBEC62FC2A4BF86_1111945920 = (cursor.moveToFirst());
                {
                    CacheResult ret;
                    ret = new CacheResult();
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
                    varB4EAC82CA7396A68D541C85D26508E83_852512324 = ret;
                } //End block
            } //End collapsed parenthetic
        } //End block
        catch (IllegalStateException e)
        { }
        finally 
        {
            cursor.close();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_2089682823 = null;
        addTaint(url.getTaint());
        CacheResult varA7E53CE21691AB073D9660D615818899_1176047865; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1176047865 = varB4EAC82CA7396A68D541C85D26508E83_1643994004;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1176047865 = varB4EAC82CA7396A68D541C85D26508E83_852512324;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1176047865 = varB4EAC82CA7396A68D541C85D26508E83_2089682823;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1176047865.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1176047865;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:03.524 -0400", hash_original_method = "10415454EB24D9D06B07AD8A5863D117", hash_generated_method = "FCFFB8BA3D63A32698D8B748AFA3C71C")
     void removeCache(String url) {
        {
            boolean var5AE2624D4B934FA39D4CA4D237A622F0_1998210451 = (url == null || !checkInitialized());
        } //End collapsed parenthetic
        mCacheDatabase.execSQL("DELETE FROM cache WHERE url = ?", new String[] { url });
        addTaint(url.getTaint());
        // ---------- Original Method ----------
        //assert !JniUtil.useChromiumHttpStack();
        //if (url == null || !checkInitialized()) {
            //return;
        //}
        //mCacheDatabase.execSQL("DELETE FROM cache WHERE url = ?", new String[] { url });
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:03.527 -0400", hash_original_method = "C4FACCF94A8569C78058717A9665F703", hash_generated_method = "C82EF473BB402CC4EC92F60448712747")
     void addCache(String url, CacheResult c) {
        {
            boolean var5AE2624D4B934FA39D4CA4D237A622F0_1912862077 = (url == null || !checkInitialized());
        } //End collapsed parenthetic
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:03.528 -0400", hash_original_method = "67241BF201ED077F6E669112ABB44844", hash_generated_method = "EE2D57E0D453C4CA6F26D37C29B12EAE")
     void clearCache() {
        {
            boolean var886CAF4B0310A6130F03FD63561B8234_1681384717 = (!checkInitialized());
        } //End collapsed parenthetic
        mCacheDatabase.delete("cache", null, null);
        // ---------- Original Method ----------
        //if (!checkInitialized()) {
            //return;
        //}
        //mCacheDatabase.delete("cache", null, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:03.528 -0400", hash_original_method = "0A5B6EFF79BC3227EAB74E5615633418", hash_generated_method = "2ACD4D83E7CAF473B571A6D66B269F3F")
     boolean hasCache() {
        {
            boolean var886CAF4B0310A6130F03FD63561B8234_1892180079 = (!checkInitialized());
        } //End collapsed parenthetic
        Cursor cursor;
        cursor = null;
        boolean ret;
        ret = false;
        try 
        {
            cursor = mCacheDatabase.query("cache", ID_PROJECTION,
                    null, null, null, null, null);
            ret = cursor.moveToFirst() == true;
        } //End block
        catch (IllegalStateException e)
        { }
        finally 
        {
            cursor.close();
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_929511197 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_929511197;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:03.529 -0400", hash_original_method = "08C6E9C5D3BD785D378572A4A550228E", hash_generated_method = "AEB16C6EDE85D1C278D7E7F0AB3964AB")
     long getCacheTotalSize() {
        long size;
        size = 0;
        Cursor cursor;
        cursor = null;
        String query;
        query = "SELECT SUM(contentlength) as sum FROM cache";
        try 
        {
            cursor = mCacheDatabase.rawQuery(query, null);
            {
                boolean varCDEB7019138899FEAFBEC62FC2A4BF86_1254864198 = (cursor.moveToFirst());
                {
                    size = cursor.getLong(0);
                } //End block
            } //End collapsed parenthetic
        } //End block
        catch (IllegalStateException e)
        { }
        finally 
        {
            cursor.close();
        } //End block
        long var0F5264038205EDFB1AC05FBB0E8C5E94_626791295 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_626791295;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:03.542 -0400", hash_original_method = "E1CB3EA921D4F41F15D60CB73EFC3B4C", hash_generated_method = "C8C1B91EBCE66E669CFA61A8C7C54E8B")
     List<String> trimCache(long amount) {
        List<String> varB4EAC82CA7396A68D541C85D26508E83_1065049014 = null; //Variable for return #1
        ArrayList<String> pathList;
        pathList = new ArrayList<String>(100);
        Cursor cursor;
        cursor = null;
        String query;
        query = "SELECT contentlength, filepath FROM cache ORDER BY expires ASC";
        try 
        {
            cursor = mCacheDatabase.rawQuery(query, null);
            {
                boolean varCDEB7019138899FEAFBEC62FC2A4BF86_98972110 = (cursor.moveToFirst());
                {
                    int batchSize;
                    batchSize = 100;
                    StringBuilder pathStr;
                    pathStr = new StringBuilder(20 + 16 * batchSize);
                    pathStr.append("DELETE FROM cache WHERE filepath IN (?");
                    {
                        int i;
                        i = 1;
                        {
                            pathStr.append(", ?");
                        } //End block
                    } //End collapsed parenthetic
                    pathStr.append(")");
                    SQLiteStatement statement;
                    statement = null;
                    try 
                    {
                        statement = mCacheDatabase.compileStatement(
                            pathStr.toString());
                        int index;
                        index = 1;
                        {
                            long length;
                            length = cursor.getLong(0);
                            amount -= length;
                            String filePath;
                            filePath = cursor.getString(1);
                            statement.bindString(index, filePath);
                            pathList.add(filePath);
                            {
                                statement.execute();
                                statement.clearBindings();
                                index = 1;
                            } //End block
                        } //End block
                        {
                            boolean var08B9D1EA537DD23B549DE53E3C14608E_198441600 = (cursor.moveToNext() && amount > 0);
                        } //End collapsed parenthetic
                        {
                            statement.execute();
                        } //End block
                    } //End block
                    catch (IllegalStateException e)
                    { }
                    finally 
                    {
                        statement.close();
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        catch (IllegalStateException e)
        { }
        finally 
        {
            cursor.close();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1065049014 = pathList;
        addTaint(amount);
        varB4EAC82CA7396A68D541C85D26508E83_1065049014.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1065049014;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:03.544 -0400", hash_original_method = "791DEB22BE9B55B5A0DA04ED6BE6D08D", hash_generated_method = "A9991159E5842636068BC0964072A98B")
     List<String> getAllCacheFileNames() {
        List<String> varB4EAC82CA7396A68D541C85D26508E83_755652500 = null; //Variable for return #1
        ArrayList<String> pathList;
        pathList = null;
        Cursor cursor;
        cursor = null;
        try 
        {
            cursor = mCacheDatabase.rawQuery("SELECT filepath FROM cache",
                    null);
            {
                boolean varAC25E083DAD430BEE33A18D42B764E17_1441583130 = (cursor != null && cursor.moveToFirst());
                {
                    pathList = new ArrayList<String>(cursor.getCount());
                    {
                        pathList.add(cursor.getString(0));
                    } //End block
                    {
                        boolean var4B88A4E0CCE1DD5CDA31BC6F14F1DD3B_743841454 = (cursor.moveToNext());
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        catch (IllegalStateException e)
        { }
        finally 
        {
            cursor.close();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_755652500 = pathList;
        varB4EAC82CA7396A68D541C85D26508E83_755652500.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_755652500;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:03.554 -0400", hash_original_method = "06E61C8A80289A57F170E4E5B574929B", hash_generated_method = "3BF9A5BABE2D50E42A54F7F3E85B3C27")
     void setUsernamePassword(String schemePlusHost, String username,
                String password) {
        {
            boolean var2649EC25D0E6A1FFB35B0F283FC7CC36_1762027535 = (schemePlusHost == null || !checkInitialized());
        } //End collapsed parenthetic
        {
            ContentValues c;
            c = new ContentValues();
            c.put(PASSWORD_HOST_COL, schemePlusHost);
            c.put(PASSWORD_USERNAME_COL, username);
            c.put(PASSWORD_PASSWORD_COL, password);
            mDatabase.insert(mTableNames[TABLE_PASSWORD_ID], PASSWORD_HOST_COL,
                    c);
        } //End block
        addTaint(schemePlusHost.getTaint());
        addTaint(username.getTaint());
        addTaint(password.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:03.565 -0400", hash_original_method = "AA29CF1F05823526F8013A43811B3B7E", hash_generated_method = "A58B0D43FC255D0AD8EBBDFE952155A2")
     String[] getUsernamePassword(String schemePlusHost) {
        String[] varB4EAC82CA7396A68D541C85D26508E83_1645048330 = null; //Variable for return #1
        String[] varB4EAC82CA7396A68D541C85D26508E83_885656912 = null; //Variable for return #2
        {
            boolean var2649EC25D0E6A1FFB35B0F283FC7CC36_352932289 = (schemePlusHost == null || !checkInitialized());
            {
                varB4EAC82CA7396A68D541C85D26508E83_1645048330 = null;
            } //End block
        } //End collapsed parenthetic
        String[] columns;
        columns = new String[] {
                PASSWORD_USERNAME_COL, PASSWORD_PASSWORD_COL
        };
        String selection;
        selection = "(" + PASSWORD_HOST_COL + " == ?)";
        {
            String[] ret;
            ret = null;
            Cursor cursor;
            cursor = null;
            try 
            {
                cursor = mDatabase.query(mTableNames[TABLE_PASSWORD_ID],
                        columns, selection, new String[] { schemePlusHost }, null,
                        null, null);
                {
                    boolean var77D7361540339637C7B1B1A9F784B876_716565963 = (cursor.moveToFirst());
                    {
                        ret = new String[2];
                        ret[0] = cursor.getString(
                            cursor.getColumnIndex(PASSWORD_USERNAME_COL));
                        ret[1] = cursor.getString(
                            cursor.getColumnIndex(PASSWORD_PASSWORD_COL));
                    } //End block
                } //End collapsed parenthetic
            } //End block
            catch (IllegalStateException e)
            { }
            finally 
            {
                cursor.close();
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_885656912 = ret;
        } //End block
        addTaint(schemePlusHost.getTaint());
        String[] varA7E53CE21691AB073D9660D615818899_1490744695; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1490744695 = varB4EAC82CA7396A68D541C85D26508E83_1645048330;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1490744695 = varB4EAC82CA7396A68D541C85D26508E83_885656912;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1490744695.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1490744695;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:03.565 -0400", hash_original_method = "048A7854E0D4842D61BAD40D57C0F82F", hash_generated_method = "B9203B60A1D3B6F45D798F711E016468")
    public boolean hasUsernamePassword() {
        {
            boolean var07B2D4F64AFC2C93C8D780D2FCE02B3B_499914287 = (hasEntries(TABLE_PASSWORD_ID));
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1361334935 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1361334935;
        // ---------- Original Method ----------
        //synchronized (mPasswordLock) {
            //return hasEntries(TABLE_PASSWORD_ID);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:03.566 -0400", hash_original_method = "1884CD7855F3B6349631839451D5E408", hash_generated_method = "F584FF01792EB1AC22F72BC62B33E12F")
    public void clearUsernamePassword() {
        {
            boolean var886CAF4B0310A6130F03FD63561B8234_1447990044 = (!checkInitialized());
        } //End collapsed parenthetic
        {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:03.566 -0400", hash_original_method = "AAEAEDF714B99771C21BA669DE54047C", hash_generated_method = "59A42583DD73ABD41D93A15B37F6C0D0")
     void setHttpAuthUsernamePassword(String host, String realm, String username,
            String password) {
        {
            boolean var344A515C901BE55759AAD36F5C91CBAB_1952564336 = (host == null || realm == null || !checkInitialized());
        } //End collapsed parenthetic
        {
            ContentValues c;
            c = new ContentValues();
            c.put(HTTPAUTH_HOST_COL, host);
            c.put(HTTPAUTH_REALM_COL, realm);
            c.put(HTTPAUTH_USERNAME_COL, username);
            c.put(HTTPAUTH_PASSWORD_COL, password);
            mDatabase.insert(mTableNames[TABLE_HTTPAUTH_ID], HTTPAUTH_HOST_COL,
                    c);
        } //End block
        addTaint(host.getTaint());
        addTaint(realm.getTaint());
        addTaint(username.getTaint());
        addTaint(password.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:03.588 -0400", hash_original_method = "6E1D9953804AC08BC6DDA66478F3E8B6", hash_generated_method = "D32197F85E5E8A76579E02020173F15B")
     String[] getHttpAuthUsernamePassword(String host, String realm) {
        String[] varB4EAC82CA7396A68D541C85D26508E83_1325720919 = null; //Variable for return #1
        String[] varB4EAC82CA7396A68D541C85D26508E83_703570178 = null; //Variable for return #2
        {
            boolean var344A515C901BE55759AAD36F5C91CBAB_1261291627 = (host == null || realm == null || !checkInitialized());
            {
                varB4EAC82CA7396A68D541C85D26508E83_1325720919 = null;
            } //End block
        } //End collapsed parenthetic
        String[] columns;
        columns = new String[] {
                HTTPAUTH_USERNAME_COL, HTTPAUTH_PASSWORD_COL
        };
        String selection;
        selection = "(" + HTTPAUTH_HOST_COL + " == ?) AND ("
                + HTTPAUTH_REALM_COL + " == ?)";
        {
            String[] ret;
            ret = null;
            Cursor cursor;
            cursor = null;
            try 
            {
                cursor = mDatabase.query(mTableNames[TABLE_HTTPAUTH_ID],
                        columns, selection, new String[] { host, realm }, null,
                        null, null);
                {
                    boolean var77D7361540339637C7B1B1A9F784B876_1643213089 = (cursor.moveToFirst());
                    {
                        ret = new String[2];
                        ret[0] = cursor.getString(
                            cursor.getColumnIndex(HTTPAUTH_USERNAME_COL));
                        ret[1] = cursor.getString(
                            cursor.getColumnIndex(HTTPAUTH_PASSWORD_COL));
                    } //End block
                } //End collapsed parenthetic
            } //End block
            catch (IllegalStateException e)
            { }
            finally 
            {
                cursor.close();
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_703570178 = ret;
        } //End block
        addTaint(host.getTaint());
        addTaint(realm.getTaint());
        String[] varA7E53CE21691AB073D9660D615818899_868552029; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_868552029 = varB4EAC82CA7396A68D541C85D26508E83_1325720919;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_868552029 = varB4EAC82CA7396A68D541C85D26508E83_703570178;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_868552029.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_868552029;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:03.589 -0400", hash_original_method = "50C83C4F45D13310D76D1C1AF4DB3EDF", hash_generated_method = "29B3710225A8BB6FF996F013D35301AB")
    public boolean hasHttpAuthUsernamePassword() {
        {
            boolean var3C1434142A0FDF9785EF38B5A38F85FE_2033791812 = (hasEntries(TABLE_HTTPAUTH_ID));
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1322492397 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1322492397;
        // ---------- Original Method ----------
        //synchronized (mHttpAuthLock) {
            //return hasEntries(TABLE_HTTPAUTH_ID);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:03.589 -0400", hash_original_method = "447C774EFBF83BDF0A062EB0F2F80455", hash_generated_method = "9ED0862B6C63847B41FEA7CCF8B37CC7")
    public void clearHttpAuthUsernamePassword() {
        {
            boolean var886CAF4B0310A6130F03FD63561B8234_1788595647 = (!checkInitialized());
        } //End collapsed parenthetic
        {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:03.591 -0400", hash_original_method = "1C1CA3B21EC6341A527B545FB0F444FE", hash_generated_method = "ADFAA23D2E2FC6C6E817F9D2A3C60806")
     void setFormData(String url, HashMap<String, String> formdata) {
        {
            boolean varEAA6464961CE63B8309DF6A515888FBD_970155806 = (url == null || formdata == null || !checkInitialized());
        } //End collapsed parenthetic
        String selection;
        selection = "(" + FORMURL_URL_COL + " == ?)";
        {
            long urlid;
            urlid = -1;
            Cursor cursor;
            cursor = null;
            try 
            {
                cursor = mDatabase.query(mTableNames[TABLE_FORMURL_ID],
                        ID_PROJECTION, selection, new String[] { url }, null, null,
                        null);
                {
                    boolean var77D7361540339637C7B1B1A9F784B876_1228837660 = (cursor.moveToFirst());
                    {
                        urlid = cursor.getLong(cursor.getColumnIndex(ID_COL));
                    } //End block
                    {
                        ContentValues c;
                        c = new ContentValues();
                        c.put(FORMURL_URL_COL, url);
                        urlid = mDatabase.insert(
                            mTableNames[TABLE_FORMURL_ID], null, c);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            catch (IllegalStateException e)
            { }
            finally 
            {
                cursor.close();
            } //End block
            {
                Set<Entry<String, String>> set;
                set = formdata.entrySet();
                Iterator<Entry<String, String>> iter;
                iter = set.iterator();
                ContentValues map;
                map = new ContentValues();
                map.put(FORMDATA_URLID_COL, urlid);
                {
                    boolean var2533A21149F7AACF984863A299EFC64E_1790739901 = (iter.hasNext());
                    {
                        Entry<String, String> entry;
                        entry = iter.next();
                        map.put(FORMDATA_NAME_COL, entry.getKey());
                        map.put(FORMDATA_VALUE_COL, entry.getValue());
                        mDatabase.insert(mTableNames[TABLE_FORMDATA_ID], null, map);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        addTaint(url.getTaint());
        addTaint(formdata.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:03.607 -0400", hash_original_method = "699FE9DC5ACA57A32D74F51785DE679D", hash_generated_method = "C228E6717B23F4204EA4DFC636D2F662")
     ArrayList<String> getFormData(String url, String name) {
        ArrayList<String> varB4EAC82CA7396A68D541C85D26508E83_1133456986 = null; //Variable for return #1
        ArrayList<String> varB4EAC82CA7396A68D541C85D26508E83_1607173071 = null; //Variable for return #2
        ArrayList<String> values;
        values = new ArrayList<String>();
        {
            boolean var117B0C9C104D1BD8746A9A506D51BADA_935391695 = (url == null || name == null || !checkInitialized());
            {
                varB4EAC82CA7396A68D541C85D26508E83_1133456986 = values;
            } //End block
        } //End collapsed parenthetic
        String urlSelection;
        urlSelection = "(" + FORMURL_URL_COL + " == ?)";
        String dataSelection;
        dataSelection = "(" + FORMDATA_URLID_COL + " == ?) AND ("
                + FORMDATA_NAME_COL + " == ?)";
        {
            Cursor cursor;
            cursor = null;
            try 
            {
                cursor = mDatabase.query(mTableNames[TABLE_FORMURL_ID],
                        ID_PROJECTION, urlSelection, new String[] { url }, null,
                        null, null);
                {
                    boolean var916090E1B2D032E1EC67FFC8B3451FBE_1300676310 = (cursor.moveToNext());
                    {
                        long urlid;
                        urlid = cursor.getLong(cursor.getColumnIndex(ID_COL));
                        Cursor dataCursor;
                        dataCursor = null;
                        try 
                        {
                            dataCursor = mDatabase.query(
                                mTableNames[TABLE_FORMDATA_ID],
                                new String[] { ID_COL, FORMDATA_VALUE_COL },
                                dataSelection,
                                new String[] { Long.toString(urlid), name },
                                null, null, null);
                            {
                                boolean var0EB2134124D3477C8F1F4B9930E6665F_705858367 = (dataCursor.moveToFirst());
                                {
                                    int valueCol;
                                    valueCol = dataCursor.getColumnIndex(
                                    FORMDATA_VALUE_COL);
                                    {
                                        values.add(dataCursor.getString(valueCol));
                                    } //End block
                                    {
                                        boolean var041EBA3F0B4A68A2FACFE169A0256538_1536542869 = (dataCursor.moveToNext());
                                    } //End collapsed parenthetic
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                        catch (IllegalStateException e)
                        { }
                        finally 
                        {
                            dataCursor.close();
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
            catch (IllegalStateException e)
            { }
            finally 
            {
                cursor.close();
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1607173071 = values;
        } //End block
        addTaint(url.getTaint());
        addTaint(name.getTaint());
        ArrayList<String> varA7E53CE21691AB073D9660D615818899_461427363; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_461427363 = varB4EAC82CA7396A68D541C85D26508E83_1133456986;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_461427363 = varB4EAC82CA7396A68D541C85D26508E83_1607173071;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_461427363.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_461427363;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:03.608 -0400", hash_original_method = "6553D4A66AD572AF8668D3FA13E3C7D5", hash_generated_method = "B4597F4F7D85B736BFEE7B9F7F77D994")
    public boolean hasFormData() {
        {
            boolean var187874045FD9FFC3AB266955A077A815_1025161306 = (hasEntries(TABLE_FORMURL_ID));
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1901069052 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1901069052;
        // ---------- Original Method ----------
        //synchronized (mFormLock) {
            //return hasEntries(TABLE_FORMURL_ID);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:03.608 -0400", hash_original_method = "9C11F1BCAAD785FEF89EC2FF8E172198", hash_generated_method = "AE408732B9DA0EFC31D104380861D1A6")
    public void clearFormData() {
        {
            boolean var886CAF4B0310A6130F03FD63561B8234_1688006085 = (!checkInitialized());
        } //End collapsed parenthetic
        {
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:03.615 -0400", hash_original_field = "97FB093BE733A1BA7EBC7D4C2F724030", hash_generated_field = "5B1225547FBD89536375A323903931B3")

    private static String DATABASE_FILE = "webview.db";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:03.615 -0400", hash_original_field = "0C79379A4FFB67C6B34DD7254190E080", hash_generated_field = "4CD88CD09E45BAAEBD6ED1148FF17E8C")

    private static String CACHE_DATABASE_FILE = "webviewCache.db";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:03.615 -0400", hash_original_field = "5F2F293DA7031522319625D7791812FB", hash_generated_field = "DB53C00D5AA4E1DC14DF3CAB1C606A79")

    protected static String LOGTAG = "webviewdatabase";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:03.615 -0400", hash_original_field = "31403FB301FD84D0D8EDD7CEBEFFEF27", hash_generated_field = "7C6C629DA1807F9D2960926D32247CC6")

    private static int DATABASE_VERSION = 11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:03.615 -0400", hash_original_field = "9CC00DFB3E1D38EFCB8A11C16265B5E5", hash_generated_field = "41548C5737392AE9BC3AAAEA83D2B9C6")

    private static int CACHE_DATABASE_VERSION = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:03.615 -0400", hash_original_field = "BB5542AD4EE4FC87B3BF30A334DCA037", hash_generated_field = "B8A911681F373C0D77BEF69151B32586")

    private static WebViewDatabase mInstance = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:03.615 -0400", hash_original_field = "961E4258F7E74A9EAA9E39B39D6F0A80", hash_generated_field = "2A9DC9A5BD2819616E44A0ADAFECE4A7")

    private static SQLiteDatabase mDatabase = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:03.615 -0400", hash_original_field = "471BCFDB7D950F157B32C5FC2BA7DD1E", hash_generated_field = "6216361743BC8C4805B411B6532C00A7")

    private static SQLiteDatabase mCacheDatabase = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:03.615 -0400", hash_original_field = "73DF9C71C5AD092E447107AB62B115B2", hash_generated_field = "D76E8358531073879D4E3CE39C0E010E")

    private static String mTableNames[] = {
        "cookies", "password", "formurl", "formdata", "httpauth"
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:03.615 -0400", hash_original_field = "F593950478528A06B7E618081AF6BC06", hash_generated_field = "31F89A03FEAB198EEBBF25CB46E13C02")

    private static int TABLE_COOKIES_ID = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:03.615 -0400", hash_original_field = "FA94619CB79D784E757BAE068E993510", hash_generated_field = "FDF954F5208B39037AE70E89D6A8728A")

    private static int TABLE_PASSWORD_ID = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:03.615 -0400", hash_original_field = "D92065FCA5B01DC8E4A52875C8D97506", hash_generated_field = "A4F74A196E83668EAB390D0175ED650E")

    private static int TABLE_FORMURL_ID = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:03.615 -0400", hash_original_field = "7F257D48419A2777A6EA39E834F7207D", hash_generated_field = "F2933B410959B83DE3636B581FC5E410")

    private static int TABLE_FORMDATA_ID = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:03.615 -0400", hash_original_field = "A94514E22B657C7979ACEA63002C0267", hash_generated_field = "FC7C369B6727FDD568D20402BC22AA28")

    private static int TABLE_HTTPAUTH_ID = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:03.615 -0400", hash_original_field = "95AAD2805FDD44BA5CEE24DC0D89F133", hash_generated_field = "9D16D6341F1B92C5A6CE74C2F80F5237")

    private static String ID_COL = "_id";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:03.615 -0400", hash_original_field = "8EFD18DD0B691B2376E9269460018650", hash_generated_field = "1B90E8FAD0776C09C992B5F6C86FD596")

    private static String[] ID_PROJECTION = new String[] {
        "_id"
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:03.615 -0400", hash_original_field = "10031FB5E52444A11A3BCFFAFA0DB528", hash_generated_field = "C65DC78871F4980429D42A9C3B191B81")

    private static String COOKIES_NAME_COL = "name";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:03.616 -0400", hash_original_field = "7934BB4FC757A6BDF45F6DD59D588727", hash_generated_field = "C88DD7E4ECA4A80EE5C90842AEDCE0CE")

    private static String COOKIES_VALUE_COL = "value";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:03.616 -0400", hash_original_field = "0B900D9814FA51A015157D877FD0DE65", hash_generated_field = "BDF5A25E048FD373263371893971B06D")

    private static String COOKIES_DOMAIN_COL = "domain";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:03.616 -0400", hash_original_field = "62947D46AA00728C394B0C7F5ED76489", hash_generated_field = "FBCC15A3CA35E17BEFF158B7792F08C0")

    private static String COOKIES_PATH_COL = "path";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:03.616 -0400", hash_original_field = "35F03590FDED597FA22FC6D2F228B03B", hash_generated_field = "7D91B7FFAD2E9C0E1166148C0A51A43A")

    private static String COOKIES_EXPIRES_COL = "expires";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:03.616 -0400", hash_original_field = "9C3805CAF4F09E4D6BF79B844F71B6C7", hash_generated_field = "A616255180A7C827D2A0019FFF8B2745")

    private static String COOKIES_SECURE_COL = "secure";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:03.616 -0400", hash_original_field = "A80A5692E900FB179643B9614EA0A73E", hash_generated_field = "176F06FAA72DAA2DCC70B61E401CA2ED")

    private static String CACHE_URL_COL = "url";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:03.616 -0400", hash_original_field = "712707BAA6B086C607E0202AAF178FBD", hash_generated_field = "41C8E8640C4C7248077070C7FA14124E")

    private static String CACHE_FILE_PATH_COL = "filepath";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:03.616 -0400", hash_original_field = "1EB91D94EDBC60EF9C1FA4511DE24937", hash_generated_field = "8E16E26CDDBDFBA31B9578558F7683ED")

    private static String CACHE_LAST_MODIFY_COL = "lastmodify";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:03.616 -0400", hash_original_field = "A03AA7E24168AE56F7FF90675A1DAF68", hash_generated_field = "ADF0D715C66C0FBC7FF42AC47B28539C")

    private static String CACHE_ETAG_COL = "etag";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:03.616 -0400", hash_original_field = "E2A338B20B6E3D0E8A2F1EB711F9B7C5", hash_generated_field = "419D268E12F560F3589A04906C1B8581")

    private static String CACHE_EXPIRES_COL = "expires";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:03.616 -0400", hash_original_field = "A893B60A4C7E3090551F1A87DC567F05", hash_generated_field = "C4131C80462BDF2F532462D72F5EDF27")

    private static String CACHE_EXPIRES_STRING_COL = "expiresstring";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:03.616 -0400", hash_original_field = "34996420DB663AF981B76C3FFAECB4D2", hash_generated_field = "175C8F63EB6E5FB547C48E0A259C0A23")

    private static String CACHE_MIMETYPE_COL = "mimetype";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:03.616 -0400", hash_original_field = "F3EDAB1F8BC7D0C841BC36BC6E8FDF85", hash_generated_field = "C0D77051E2EA59804DEA8B9BFA859A4C")

    private static String CACHE_ENCODING_COL = "encoding";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:03.616 -0400", hash_original_field = "8C6C0AB77168966480E9A2DC76DFF0A9", hash_generated_field = "678B30CEBB0E2B5413FE305497142D72")

    private static String CACHE_HTTP_STATUS_COL = "httpstatus";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:03.616 -0400", hash_original_field = "4039EE0305B9310C87FC6733374047E9", hash_generated_field = "F098D320BDE09132937DC78536A5F12E")

    private static String CACHE_LOCATION_COL = "location";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:03.616 -0400", hash_original_field = "75D435936AED501CFCA0FE328E0E59FA", hash_generated_field = "FC12A9E27CAAC7D315760A6BF167E2AF")

    private static String CACHE_CONTENTLENGTH_COL = "contentlength";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:03.616 -0400", hash_original_field = "3A78765ECB553FFA4185642D15F51660", hash_generated_field = "C4FCAADF1128AFC9E23EC7555B5136F6")

    private static String CACHE_CONTENTDISPOSITION_COL = "contentdisposition";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:03.616 -0400", hash_original_field = "377B1EC21E011CF4D5C57C266BA339C3", hash_generated_field = "4144CFE865E6371B2ED56B623FB87310")

    private static String CACHE_CROSSDOMAIN_COL = "crossdomain";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:03.616 -0400", hash_original_field = "4357EB3E2B353B26939F7CD277B802CE", hash_generated_field = "B72E81A72FF94868AED5A871CAF940E7")

    private static String PASSWORD_HOST_COL = "host";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:03.616 -0400", hash_original_field = "5EA201ED1318E58ADA3981C6F9A89356", hash_generated_field = "FAF7228D417CF7697D5430531EBB6CE4")

    private static String PASSWORD_USERNAME_COL = "username";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:03.616 -0400", hash_original_field = "E6B3A21470DBD7C6290F62AC3649EC3E", hash_generated_field = "05A7D15B88D87F202753A47CFA3768D4")

    private static String PASSWORD_PASSWORD_COL = "password";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:03.616 -0400", hash_original_field = "508345AAA07699F2CFC5E79EC1FE4D96", hash_generated_field = "22FCEF7CA3B0617A0F8258CA30D2698C")

    private static String FORMURL_URL_COL = "url";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:03.616 -0400", hash_original_field = "B6AE36F0C577EED59663D75D6050DB36", hash_generated_field = "C6132C54584652060BC43E94633FF0F1")

    private static String FORMDATA_URLID_COL = "urlid";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:03.616 -0400", hash_original_field = "CB57F57686547126214EF36106A16F3A", hash_generated_field = "76422316D64C66C053DD7A63CF363F3C")

    private static String FORMDATA_NAME_COL = "name";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:03.616 -0400", hash_original_field = "7B80A9211FC7021F6A780184A5E65546", hash_generated_field = "23803046625D2DDF27F313F5367923CB")

    private static String FORMDATA_VALUE_COL = "value";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:03.616 -0400", hash_original_field = "218C4151B8B7B0BEFEBFE3A9D3598A58", hash_generated_field = "4C17D5E1D3D7300B229CFFCED0B46E7D")

    private static String HTTPAUTH_HOST_COL = "host";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:03.617 -0400", hash_original_field = "742869D98EC1C65FE55950316D908AE7", hash_generated_field = "86C642B2B640CCAA812C7068236EA34D")

    private static String HTTPAUTH_REALM_COL = "realm";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:03.617 -0400", hash_original_field = "4735043625F795828DFBEC75674C1301", hash_generated_field = "FF69A8F0AEA30A060B036B7470400F18")

    private static String HTTPAUTH_USERNAME_COL = "username";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:03.617 -0400", hash_original_field = "D470AC4924A89065E285659BD318A916", hash_generated_field = "187F2A19AB54A0B6A102338547300E7A")

    private static String HTTPAUTH_PASSWORD_COL = "password";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:03.617 -0400", hash_original_field = "02CCE22A311CADFB11AFA26DCB73108F", hash_generated_field = "9978AB64D9ADE743F038BE7845E6172E")

    private static DatabaseUtils.InsertHelper mCacheInserter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:03.617 -0400", hash_original_field = "530F644F14A9D5DD748EBC732472B324", hash_generated_field = "3910FC6AB35DAF5F19CCEF25E8654783")

    private static int mCacheUrlColIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:03.617 -0400", hash_original_field = "8F160C6A8858DBB8979E9D379C99A457", hash_generated_field = "6D70A03DEA5E92F04910BB7E9E1D9224")

    private static int mCacheFilePathColIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:03.617 -0400", hash_original_field = "6377FFA093CA55A749CCAF38186A15C1", hash_generated_field = "F297F7407A43B3D8B550234904F928F5")

    private static int mCacheLastModifyColIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:03.617 -0400", hash_original_field = "3669079542CCEB87D992EC9A2B016E6C", hash_generated_field = "7E671A6F0167C6AE2F10F590C7DC601E")

    private static int mCacheETagColIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:03.617 -0400", hash_original_field = "6F203D5A48CD57B37CA7994C04473BA1", hash_generated_field = "09E6E173F9C3511818B6258041F0A3BC")

    private static int mCacheExpiresColIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:03.617 -0400", hash_original_field = "8399E380BC6C8A7F8233460E5512C2EB", hash_generated_field = "9DDE47C8C21140680D9D21457C8BA030")

    private static int mCacheExpiresStringColIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:03.617 -0400", hash_original_field = "98BDBB3BB565D12BD211BF6037141DA5", hash_generated_field = "6EC0F1436186404D863C79D70C9D0422")

    private static int mCacheMimeTypeColIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:03.617 -0400", hash_original_field = "3BDEE775811BDD2BF14998EC6455776E", hash_generated_field = "67A46391EDD0D1EEFDAA1EF5F50C5C78")

    private static int mCacheEncodingColIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:03.617 -0400", hash_original_field = "CBCF5080B4DC20A6213C93C825039E53", hash_generated_field = "E8069F7EB9821C68B302A5C70FE84C68")

    private static int mCacheHttpStatusColIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:03.617 -0400", hash_original_field = "1FCF38A62D6BCBEBB44109FDE952327D", hash_generated_field = "DA4DBC2E2AF89F71F7CF53E4A0F9DB44")

    private static int mCacheLocationColIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:03.617 -0400", hash_original_field = "F85753B97AF9626AF8FA6CBB1D6C32CA", hash_generated_field = "2CEFBAF45A5360D0C6A73071406979A0")

    private static int mCacheContentLengthColIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:03.617 -0400", hash_original_field = "A220E2B3B8458CE24E0CBE61BBFE1F56", hash_generated_field = "C4C9ED448FAD4F85DBEA109ADF0942B5")

    private static int mCacheContentDispositionColIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:03.617 -0400", hash_original_field = "8AC55427B838864F99762F4B9E97B74A", hash_generated_field = "07EC8A1B46BF12BB85378082FD36D87C")

    private static int mCacheCrossDomainColIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:03.617 -0400", hash_original_field = "3A45B26C5E71778F0FB720FAABAC85BD", hash_generated_field = "BFC3FA813D8D5121BE43E51DCA5BBA65")

    private static int mCacheTransactionRefcount;
}

