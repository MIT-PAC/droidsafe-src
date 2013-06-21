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
    private Object mCookieLock = new Object();
    private Object mPasswordLock = new Object();
    private Object mFormLock = new Object();
    private Object mHttpAuthLock = new Object();
    private boolean mInitialized = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.343 -0400", hash_original_method = "EFB05B9D3FCAB305323B10379F1EC778", hash_generated_method = "D5B22004E4F2320840358BC835CE7A29")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private WebViewDatabase(final Context context) {
        dsTaint.addTaint(context.dsTaint);
        new Thread() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.343 -0400", hash_original_method = "016F23FCFDABFB49215E1C5AD86A4960", hash_generated_method = "857237709B575C3CEAE7C4725FBD2553")
            //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.344 -0400", hash_original_method = "AC87AD0E19559694D58F1943BD15C1D5", hash_generated_method = "0943D60EFBC966AFB0625198A8427221")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private synchronized void init(Context context) {
        dsTaint.addTaint(context.dsTaint);
        initDatabase(context);
        {
            boolean var9ACB1B3B30D2C0CED704DA8C8B3FC1B9_42237971 = (JniUtil.useChromiumHttpStack());
            {
                context.deleteDatabase(CACHE_DATABASE_FILE);
            } //End block
            {
                initCacheDatabase(context);
            } //End block
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.344 -0400", hash_original_method = "CE06D258DB88B89F42DED68141C198E0", hash_generated_method = "6A4DCB68B2558D57E9129750CBEB3DF2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void initDatabase(Context context) {
        dsTaint.addTaint(context.dsTaint);
        try 
        {
            mDatabase = context.openOrCreateDatabase(DATABASE_FILE, 0, null);
        } //End block
        catch (SQLiteException e)
        {
            {
                boolean var8ADF77EF24056E62D97D24430E7CC726_1783956555 = (context.deleteDatabase(DATABASE_FILE));
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
            boolean varA450E818A17AB5CEAFA5DCA2D2F53F99_850130545 = (mDatabase.getVersion() != DATABASE_VERSION);
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.345 -0400", hash_original_method = "C7A89DE182CA76C10CB3961C893695C2", hash_generated_method = "C9B27DCD424C7B9054A4FCC4F0AC2EB3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void initCacheDatabase(Context context) {
        dsTaint.addTaint(context.dsTaint);
        try 
        {
            mCacheDatabase = context.openOrCreateDatabase(
                    CACHE_DATABASE_FILE, 0, null);
        } //End block
        catch (SQLiteException e)
        {
            {
                boolean var06845C84D0D12A7575979F07C5042A97_1667611020 = (context.deleteDatabase(CACHE_DATABASE_FILE));
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
            boolean var9F5CCB2C1429C972D5DCFFA8EAC58C5C_1865256009 = (mCacheDatabase.getVersion() != CACHE_DATABASE_VERSION);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.346 -0400", hash_original_method = "B19C14CCA683C2C1072DDA1B7A6274D5", hash_generated_method = "85F0AC38B117FBE922C4F02D5A0D66A8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.347 -0400", hash_original_method = "CBFCA06012BEB8B609A8EBC6EEC6D1A4", hash_generated_method = "1D498EA1846E79EEE274078A52AC249C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean hasEntries(int tableId) {
        dsTaint.addTaint(tableId);
        {
            boolean var886CAF4B0310A6130F03FD63561B8234_458615403 = (!checkInitialized());
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
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.347 -0400", hash_original_method = "4D94521780B9AD3D8F70E78E8CBCD3E0", hash_generated_method = "AF69DCD763572A8770A5749AC68126BF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     ArrayList<Cookie> getCookiesForDomain(String domain) {
        dsTaint.addTaint(domain);
        ArrayList<Cookie> list;
        list = new ArrayList<Cookie>();
        {
            boolean varA8DB3C3C11FB3F67134323DBA3E29A4F_1970027288 = (domain == null || !checkInitialized());
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
                    boolean var77D7361540339637C7B1B1A9F784B876_1921106146 = (cursor.moveToFirst());
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
                                boolean var80D05DB7C23C7A8C68D1BD5C13F8B946_99466776 = (cursor.isNull(expiresCol));
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
                            boolean varEEE3E1704288A6D03EB8C70F2484A2B3_803627278 = (cursor.moveToNext());
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
        } //End block
        return (ArrayList<Cookie>)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.348 -0400", hash_original_method = "BC23D2938EE88E31CA87024518493BE2", hash_generated_method = "375DB005AA4133310F5BFF722100C5E9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void deleteCookies(String domain, String path, String name) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(path);
        dsTaint.addTaint(domain);
        {
            boolean varA8DB3C3C11FB3F67134323DBA3E29A4F_1898266253 = (domain == null || !checkInitialized());
        } //End collapsed parenthetic
        {
            String where;
            where = "(" + COOKIES_DOMAIN_COL + " == ?) AND ("
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.348 -0400", hash_original_method = "33710CB1E65A2C52E9ABEE23433BB87F", hash_generated_method = "BF2FC346176A9B637076F1118430C4AF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void addCookie(Cookie cookie) {
        dsTaint.addTaint(cookie.dsTaint);
        {
            boolean var39BA779873F941960A4C4EA6029A7B0F_1403262585 = (cookie.domain == null || cookie.path == null || cookie.name == null
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.348 -0400", hash_original_method = "83E6237273AAD0C9F4D2DED923ACAFB7", hash_generated_method = "FDA438D5AB4A73A39C2AB1C72EA8245A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean hasCookies() {
        {
            boolean varDB253D8D15C430D06B36D069D7680A2A_1488446481 = (hasEntries(TABLE_COOKIES_ID));
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //synchronized (mCookieLock) {
            //return hasEntries(TABLE_COOKIES_ID);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.348 -0400", hash_original_method = "3E1D9455881C3029C0C51566A563B8F4", hash_generated_method = "66CC5D2A293CC42C48CEEE80F4A33E6D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void clearCookies() {
        {
            boolean var886CAF4B0310A6130F03FD63561B8234_1971770180 = (!checkInitialized());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.349 -0400", hash_original_method = "CAA5F0320575B2151920B0F146B122B7", hash_generated_method = "381125CC19E2277B7AB745526D60BF6F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void clearSessionCookies() {
        {
            boolean var886CAF4B0310A6130F03FD63561B8234_1450223075 = (!checkInitialized());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.349 -0400", hash_original_method = "AD90F95A26E2D9ECD94EF58E091F4A84", hash_generated_method = "95A4EF927DFAFFCE98FAE5AB056D6F41")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void clearExpiredCookies(long now) {
        dsTaint.addTaint(now);
        {
            boolean var886CAF4B0310A6130F03FD63561B8234_909907080 = (!checkInitialized());
        } //End collapsed parenthetic
        String expires;
        expires = COOKIES_EXPIRES_COL + " <= ?";
        {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.349 -0400", hash_original_method = "26A436743D42208E44F8DC7C1FFF5A77", hash_generated_method = "91780D374F38A7B4A27DAD3DD8F6BAAE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean startCacheTransaction() {
        {
            {
                boolean var19CEF9F46A61A60E9C53BA833277B14B_593622418 = (!Thread.currentThread().equals(
                    WebViewWorker.getHandler().getLooper().getThread()));
            } //End collapsed parenthetic
            mCacheDatabase.beginTransactionNonExclusive();
        } //End block
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.349 -0400", hash_original_method = "14B92CCE9ED71BB98EE6E80EBC3B995B", hash_generated_method = "94095DB3877D1298E55BF82A45CA0A1D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean endCacheTransaction() {
        {
            {
                boolean var19CEF9F46A61A60E9C53BA833277B14B_1570944922 = (!Thread.currentThread().equals(
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
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.350 -0400", hash_original_method = "BF73224910862A6343E046C49771A81E", hash_generated_method = "53008EF697DBDAC8D6EE807800472716")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     CacheResult getCache(String url) {
        dsTaint.addTaint(url);
        {
            boolean var5AE2624D4B934FA39D4CA4D237A622F0_1808270159 = (url == null || !checkInitialized());
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
                boolean varCDEB7019138899FEAFBEC62FC2A4BF86_262592856 = (cursor.moveToFirst());
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
                } //End block
            } //End collapsed parenthetic
        } //End block
        catch (IllegalStateException e)
        { }
        finally 
        {
            cursor.close();
        } //End block
        return (CacheResult)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.350 -0400", hash_original_method = "10415454EB24D9D06B07AD8A5863D117", hash_generated_method = "8EAB9914E0D01DBE6F044EF0B1FC7891")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void removeCache(String url) {
        dsTaint.addTaint(url);
        {
            boolean var5AE2624D4B934FA39D4CA4D237A622F0_1821278313 = (url == null || !checkInitialized());
        } //End collapsed parenthetic
        mCacheDatabase.execSQL("DELETE FROM cache WHERE url = ?", new String[] { url });
        // ---------- Original Method ----------
        //assert !JniUtil.useChromiumHttpStack();
        //if (url == null || !checkInitialized()) {
            //return;
        //}
        //mCacheDatabase.execSQL("DELETE FROM cache WHERE url = ?", new String[] { url });
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.351 -0400", hash_original_method = "C4FACCF94A8569C78058717A9665F703", hash_generated_method = "62084D30F440EDFCA409603901B1EEDB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void addCache(String url, CacheResult c) {
        dsTaint.addTaint(c.dsTaint);
        dsTaint.addTaint(url);
        {
            boolean var5AE2624D4B934FA39D4CA4D237A622F0_79705222 = (url == null || !checkInitialized());
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.351 -0400", hash_original_method = "67241BF201ED077F6E669112ABB44844", hash_generated_method = "6EFE0496E1C869BBB04D99EC46F8CCD6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void clearCache() {
        {
            boolean var886CAF4B0310A6130F03FD63561B8234_1336336062 = (!checkInitialized());
        } //End collapsed parenthetic
        mCacheDatabase.delete("cache", null, null);
        // ---------- Original Method ----------
        //if (!checkInitialized()) {
            //return;
        //}
        //mCacheDatabase.delete("cache", null, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.351 -0400", hash_original_method = "0A5B6EFF79BC3227EAB74E5615633418", hash_generated_method = "B1C39B9698041ABFF45D9F21BD07FBAE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean hasCache() {
        {
            boolean var886CAF4B0310A6130F03FD63561B8234_1532541620 = (!checkInitialized());
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
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.352 -0400", hash_original_method = "08C6E9C5D3BD785D378572A4A550228E", hash_generated_method = "B3FD0853A9F62AB6DAA487FFC4E9DB19")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
                boolean varCDEB7019138899FEAFBEC62FC2A4BF86_58010031 = (cursor.moveToFirst());
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
        return dsTaint.getTaintLong();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.352 -0400", hash_original_method = "E1CB3EA921D4F41F15D60CB73EFC3B4C", hash_generated_method = "C77440DC5E73CB9AF803FCBBB4CF0445")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     List<String> trimCache(long amount) {
        dsTaint.addTaint(amount);
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
                boolean varCDEB7019138899FEAFBEC62FC2A4BF86_1947200607 = (cursor.moveToFirst());
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
                            boolean var08B9D1EA537DD23B549DE53E3C14608E_1798224760 = (cursor.moveToNext() && amount > 0);
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
        return (List<String>)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.353 -0400", hash_original_method = "791DEB22BE9B55B5A0DA04ED6BE6D08D", hash_generated_method = "0462F6FFD5E8FD7F4D4F6910A14473A5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     List<String> getAllCacheFileNames() {
        ArrayList<String> pathList;
        pathList = null;
        Cursor cursor;
        cursor = null;
        try 
        {
            cursor = mCacheDatabase.rawQuery("SELECT filepath FROM cache",
                    null);
            {
                boolean varAC25E083DAD430BEE33A18D42B764E17_1827874237 = (cursor != null && cursor.moveToFirst());
                {
                    pathList = new ArrayList<String>(cursor.getCount());
                    {
                        pathList.add(cursor.getString(0));
                    } //End block
                    {
                        boolean var4B88A4E0CCE1DD5CDA31BC6F14F1DD3B_306650904 = (cursor.moveToNext());
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
        return (List<String>)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.353 -0400", hash_original_method = "06E61C8A80289A57F170E4E5B574929B", hash_generated_method = "B56C3A8DF6479A18788576B45B349E2C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void setUsernamePassword(String schemePlusHost, String username,
                String password) {
        dsTaint.addTaint(username);
        dsTaint.addTaint(schemePlusHost);
        dsTaint.addTaint(password);
        {
            boolean var2649EC25D0E6A1FFB35B0F283FC7CC36_605202891 = (schemePlusHost == null || !checkInitialized());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.353 -0400", hash_original_method = "AA29CF1F05823526F8013A43811B3B7E", hash_generated_method = "447D1BB9379A2B5AD375903EB67870C4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     String[] getUsernamePassword(String schemePlusHost) {
        dsTaint.addTaint(schemePlusHost);
        {
            boolean var2649EC25D0E6A1FFB35B0F283FC7CC36_782307652 = (schemePlusHost == null || !checkInitialized());
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
                    boolean var77D7361540339637C7B1B1A9F784B876_1008816832 = (cursor.moveToFirst());
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
        } //End block
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.354 -0400", hash_original_method = "048A7854E0D4842D61BAD40D57C0F82F", hash_generated_method = "B7569FFB08072461554F2EE198EEF4EB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean hasUsernamePassword() {
        {
            boolean var07B2D4F64AFC2C93C8D780D2FCE02B3B_829612362 = (hasEntries(TABLE_PASSWORD_ID));
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //synchronized (mPasswordLock) {
            //return hasEntries(TABLE_PASSWORD_ID);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.354 -0400", hash_original_method = "1884CD7855F3B6349631839451D5E408", hash_generated_method = "ADB7A43065E9C13E446BE49C99609ED8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void clearUsernamePassword() {
        {
            boolean var886CAF4B0310A6130F03FD63561B8234_626080137 = (!checkInitialized());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.354 -0400", hash_original_method = "AAEAEDF714B99771C21BA669DE54047C", hash_generated_method = "8DB45866538214A953668E07DF4A33D3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void setHttpAuthUsernamePassword(String host, String realm, String username,
            String password) {
        dsTaint.addTaint(username);
        dsTaint.addTaint(host);
        dsTaint.addTaint(realm);
        dsTaint.addTaint(password);
        {
            boolean var344A515C901BE55759AAD36F5C91CBAB_1186437047 = (host == null || realm == null || !checkInitialized());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.354 -0400", hash_original_method = "6E1D9953804AC08BC6DDA66478F3E8B6", hash_generated_method = "6F62BF3D32AF200AD875E488A4B2E89C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     String[] getHttpAuthUsernamePassword(String host, String realm) {
        dsTaint.addTaint(host);
        dsTaint.addTaint(realm);
        {
            boolean var344A515C901BE55759AAD36F5C91CBAB_1273934259 = (host == null || realm == null || !checkInitialized());
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
                    boolean var77D7361540339637C7B1B1A9F784B876_1080815846 = (cursor.moveToFirst());
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
        } //End block
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.355 -0400", hash_original_method = "50C83C4F45D13310D76D1C1AF4DB3EDF", hash_generated_method = "783BB32F50A7DC1017C11249F6344FB5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean hasHttpAuthUsernamePassword() {
        {
            boolean var3C1434142A0FDF9785EF38B5A38F85FE_1096373809 = (hasEntries(TABLE_HTTPAUTH_ID));
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //synchronized (mHttpAuthLock) {
            //return hasEntries(TABLE_HTTPAUTH_ID);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.355 -0400", hash_original_method = "447C774EFBF83BDF0A062EB0F2F80455", hash_generated_method = "9C4988AE7DD20ACB189199F2E4E605FB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void clearHttpAuthUsernamePassword() {
        {
            boolean var886CAF4B0310A6130F03FD63561B8234_1953185291 = (!checkInitialized());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.356 -0400", hash_original_method = "1C1CA3B21EC6341A527B545FB0F444FE", hash_generated_method = "167D25BD3C9D06705D167CEA48EA2C32")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void setFormData(String url, HashMap<String, String> formdata) {
        dsTaint.addTaint(formdata.dsTaint);
        dsTaint.addTaint(url);
        {
            boolean varEAA6464961CE63B8309DF6A515888FBD_1596405093 = (url == null || formdata == null || !checkInitialized());
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
                    boolean var77D7361540339637C7B1B1A9F784B876_1251282698 = (cursor.moveToFirst());
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
                    boolean var2533A21149F7AACF984863A299EFC64E_479378852 = (iter.hasNext());
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.356 -0400", hash_original_method = "699FE9DC5ACA57A32D74F51785DE679D", hash_generated_method = "30051343040D2CCB7601CE21FD951811")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     ArrayList<String> getFormData(String url, String name) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(url);
        ArrayList<String> values;
        values = new ArrayList<String>();
        {
            boolean var117B0C9C104D1BD8746A9A506D51BADA_935111496 = (url == null || name == null || !checkInitialized());
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
                    boolean var916090E1B2D032E1EC67FFC8B3451FBE_35007726 = (cursor.moveToNext());
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
                                boolean var0EB2134124D3477C8F1F4B9930E6665F_493469671 = (dataCursor.moveToFirst());
                                {
                                    int valueCol;
                                    valueCol = dataCursor.getColumnIndex(
                                    FORMDATA_VALUE_COL);
                                    {
                                        values.add(dataCursor.getString(valueCol));
                                    } //End block
                                    {
                                        boolean var041EBA3F0B4A68A2FACFE169A0256538_964231729 = (dataCursor.moveToNext());
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
        } //End block
        return (ArrayList<String>)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.356 -0400", hash_original_method = "6553D4A66AD572AF8668D3FA13E3C7D5", hash_generated_method = "0902BC6EB9C66DD6F63B4A498341496B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean hasFormData() {
        {
            boolean var187874045FD9FFC3AB266955A077A815_1435189150 = (hasEntries(TABLE_FORMURL_ID));
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //synchronized (mFormLock) {
            //return hasEntries(TABLE_FORMURL_ID);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.357 -0400", hash_original_method = "9C11F1BCAAD785FEF89EC2FF8E172198", hash_generated_method = "D78CB0B02D8DAF4F34729A2605CB9DA2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void clearFormData() {
        {
            boolean var886CAF4B0310A6130F03FD63561B8234_613277641 = (!checkInitialized());
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

    
    private static final String DATABASE_FILE = "webview.db";
    private static final String CACHE_DATABASE_FILE = "webviewCache.db";
    protected static final String LOGTAG = "webviewdatabase";
    private static final int DATABASE_VERSION = 11;
    private static final int CACHE_DATABASE_VERSION = 4;
    private static WebViewDatabase mInstance = null;
    private static SQLiteDatabase mDatabase = null;
    private static SQLiteDatabase mCacheDatabase = null;
    private static final String mTableNames[] = {
        "cookies", "password", "formurl", "formdata", "httpauth"
    };
    private static final int TABLE_COOKIES_ID = 0;
    private static final int TABLE_PASSWORD_ID = 1;
    private static final int TABLE_FORMURL_ID = 2;
    private static final int TABLE_FORMDATA_ID = 3;
    private static final int TABLE_HTTPAUTH_ID = 4;
    private static final String ID_COL = "_id";
    private static final String[] ID_PROJECTION = new String[] {
        "_id"
    };
    private static final String COOKIES_NAME_COL = "name";
    private static final String COOKIES_VALUE_COL = "value";
    private static final String COOKIES_DOMAIN_COL = "domain";
    private static final String COOKIES_PATH_COL = "path";
    private static final String COOKIES_EXPIRES_COL = "expires";
    private static final String COOKIES_SECURE_COL = "secure";
    private static final String CACHE_URL_COL = "url";
    private static final String CACHE_FILE_PATH_COL = "filepath";
    private static final String CACHE_LAST_MODIFY_COL = "lastmodify";
    private static final String CACHE_ETAG_COL = "etag";
    private static final String CACHE_EXPIRES_COL = "expires";
    private static final String CACHE_EXPIRES_STRING_COL = "expiresstring";
    private static final String CACHE_MIMETYPE_COL = "mimetype";
    private static final String CACHE_ENCODING_COL = "encoding";
    private static final String CACHE_HTTP_STATUS_COL = "httpstatus";
    private static final String CACHE_LOCATION_COL = "location";
    private static final String CACHE_CONTENTLENGTH_COL = "contentlength";
    private static final String CACHE_CONTENTDISPOSITION_COL = "contentdisposition";
    private static final String CACHE_CROSSDOMAIN_COL = "crossdomain";
    private static final String PASSWORD_HOST_COL = "host";
    private static final String PASSWORD_USERNAME_COL = "username";
    private static final String PASSWORD_PASSWORD_COL = "password";
    private static final String FORMURL_URL_COL = "url";
    private static final String FORMDATA_URLID_COL = "urlid";
    private static final String FORMDATA_NAME_COL = "name";
    private static final String FORMDATA_VALUE_COL = "value";
    private static final String HTTPAUTH_HOST_COL = "host";
    private static final String HTTPAUTH_REALM_COL = "realm";
    private static final String HTTPAUTH_USERNAME_COL = "username";
    private static final String HTTPAUTH_PASSWORD_COL = "password";
    private static DatabaseUtils.InsertHelper mCacheInserter;
    private static int mCacheUrlColIndex;
    private static int mCacheFilePathColIndex;
    private static int mCacheLastModifyColIndex;
    private static int mCacheETagColIndex;
    private static int mCacheExpiresColIndex;
    private static int mCacheExpiresStringColIndex;
    private static int mCacheMimeTypeColIndex;
    private static int mCacheEncodingColIndex;
    private static int mCacheHttpStatusColIndex;
    private static int mCacheLocationColIndex;
    private static int mCacheContentLengthColIndex;
    private static int mCacheContentDispositionColIndex;
    private static int mCacheCrossDomainColIndex;
    private static int mCacheTransactionRefcount;
}

