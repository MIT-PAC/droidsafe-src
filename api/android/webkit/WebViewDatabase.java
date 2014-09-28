package android.webkit;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
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

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:43.555 -0500", hash_original_method = "18F043B8C68A94FA6BFE49237EDEA254", hash_generated_method = "643CAAE754ECA52FC0FF06A8140D4818")
    
public static synchronized WebViewDatabase getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new WebViewDatabase(context);
        }
        return mInstance;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:43.566 -0500", hash_original_method = "CACD524CEE6BCCEC4C67B8F67A8D3537", hash_generated_method = "A44E3FCB6B144AD8694E53470035E833")
    
private static void upgradeDatabase() {
        upgradeDatabaseToV10();
        upgradeDatabaseFromV10ToV11();
        // Add future database upgrade functions here, one version at a
        // time.
        mDatabase.setVersion(DATABASE_VERSION);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:43.568 -0500", hash_original_method = "ED07B1BE1AC91F6ECD95DC5AAED0BCFA", hash_generated_method = "486966A72C9993A0B2599BB26078DFBA")
    
private static void upgradeDatabaseFromV10ToV11() {
        int oldVersion = mDatabase.getVersion();

        if (oldVersion >= 11) {
            // Nothing to do.
            return;
        }

        if (JniUtil.useChromiumHttpStack()) {
            // Clear out old java stack cookies - this data is now stored in
            // a separate database managed by the Chrome stack.
            mDatabase.execSQL("DROP TABLE IF EXISTS " + mTableNames[TABLE_COOKIES_ID]);

            // Likewise for the old cache table.
            mDatabase.execSQL("DROP TABLE IF EXISTS cache");
        }

        // Update form autocomplete  URLs to match new ICS formatting.
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

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:43.572 -0500", hash_original_method = "80CCC21A4911CDD61A09E657607A861D", hash_generated_method = "585F9C5D7FEEB8266ECD96502329CCEC")
    
private static void upgradeDatabaseToV10() {
        int oldVersion = mDatabase.getVersion();

        if (oldVersion >= 10) {
            // Nothing to do.
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

        // cookies
        mDatabase.execSQL("CREATE TABLE " + mTableNames[TABLE_COOKIES_ID]
                + " (" + ID_COL + " INTEGER PRIMARY KEY, "
                + COOKIES_NAME_COL + " TEXT, " + COOKIES_VALUE_COL
                + " TEXT, " + COOKIES_DOMAIN_COL + " TEXT, "
                + COOKIES_PATH_COL + " TEXT, " + COOKIES_EXPIRES_COL
                + " INTEGER, " + COOKIES_SECURE_COL + " INTEGER" + ");");
        mDatabase.execSQL("CREATE INDEX cookiesIndex ON "
                + mTableNames[TABLE_COOKIES_ID] + " (path)");

        // formurl
        mDatabase.execSQL("CREATE TABLE " + mTableNames[TABLE_FORMURL_ID]
                + " (" + ID_COL + " INTEGER PRIMARY KEY, " + FORMURL_URL_COL
                + " TEXT" + ");");

        // formdata
        mDatabase.execSQL("CREATE TABLE " + mTableNames[TABLE_FORMDATA_ID]
                + " (" + ID_COL + " INTEGER PRIMARY KEY, "
                + FORMDATA_URLID_COL + " INTEGER, " + FORMDATA_NAME_COL
                + " TEXT, " + FORMDATA_VALUE_COL + " TEXT," + " UNIQUE ("
                + FORMDATA_URLID_COL + ", " + FORMDATA_NAME_COL + ", "
                + FORMDATA_VALUE_COL + ") ON CONFLICT IGNORE);");

        // httpauth
        mDatabase.execSQL("CREATE TABLE " + mTableNames[TABLE_HTTPAUTH_ID]
                + " (" + ID_COL + " INTEGER PRIMARY KEY, "
                + HTTPAUTH_HOST_COL + " TEXT, " + HTTPAUTH_REALM_COL
                + " TEXT, " + HTTPAUTH_USERNAME_COL + " TEXT, "
                + HTTPAUTH_PASSWORD_COL + " TEXT," + " UNIQUE ("
                + HTTPAUTH_HOST_COL + ", " + HTTPAUTH_REALM_COL
                + ") ON CONFLICT REPLACE);");
        // passwords
        mDatabase.execSQL("CREATE TABLE " + mTableNames[TABLE_PASSWORD_ID]
                + " (" + ID_COL + " INTEGER PRIMARY KEY, "
                + PASSWORD_HOST_COL + " TEXT, " + PASSWORD_USERNAME_COL
                + " TEXT, " + PASSWORD_PASSWORD_COL + " TEXT," + " UNIQUE ("
                + PASSWORD_HOST_COL + ", " + PASSWORD_USERNAME_COL
                + ") ON CONFLICT REPLACE);");
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:43.575 -0500", hash_original_method = "2A5D5D6A79FD2409A31A5B75AB574D72", hash_generated_method = "D0002634D18F5FF1F5DFEFBED5E8BD30")
    
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

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:43.578 -0500", hash_original_method = "F83DE2E969DF41D209691DE2D5D3DD69", hash_generated_method = "99E17F94B61FA8A58A45483A5CDA8385")
    
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:43.394 -0500", hash_original_field = "FAE34CC389AFAA7C8EDF8868AD6AF586", hash_generated_field = "E8D0A6CD52C04E0659D4FC87D336D0AC")

    private static final String DATABASE_FILE = "webview.db";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:43.396 -0500", hash_original_field = "BC7689F20B299C27BDF4DA58B6DBC7E9", hash_generated_field = "B17A3300247FF520B718A6CB6B02A944")

    private static final String CACHE_DATABASE_FILE = "webviewCache.db";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:43.399 -0500", hash_original_field = "3EB87ECAAA35A61AF287D56BA8223DB2", hash_generated_field = "24A942646779149EC1E70531789CBBAC")

    protected static final String LOGTAG = "webviewdatabase";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:43.401 -0500", hash_original_field = "E0DE33F41918CF52750B09DA72123EE2", hash_generated_field = "C1B002270A3E3DA04EE8826B5BFBB2B5")

    private static final int DATABASE_VERSION = 11;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:43.404 -0500", hash_original_field = "F6D7C499008BA6FA653597C349460CD9", hash_generated_field = "19606A19BE9C717B28787FFB93D34764")

    // 3 -> 4 Added Oma-Downloads table
    // 4 -> 5 Modified Cache table to support persistent contentLength
    // 5 -> 4 Removed Oma-Downoads table
    // 5 -> 6 Add INDEX for cache table
    // 6 -> 7 Change cache localPath from int to String
    // 7 -> 8 Move cache to its own db
    // 8 -> 9 Store both scheme and host when storing passwords
    // 9 -> 10 Update httpauth table UNIQUE
    // 10 -> 11 Drop cookies and cache now managed by the chromium stack,
    //          and update the form data table to use the new format
    //          implemented for b/5265606.
    private static final int CACHE_DATABASE_VERSION = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:43.406 -0500", hash_original_field = "B36851CF6A4F04E48D12FAC0E9686369", hash_generated_field = "70DECD2B778D59B098E9780B4F514662")

    // 2 -> 3 Add content-disposition
    // 3 -> 4 Add crossdomain (For x-permitted-cross-domain-policies header)

    private static WebViewDatabase mInstance = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:43.408 -0500", hash_original_field = "44FFBD8FF4418C357393646DA7699518", hash_generated_field = "2A9DC9A5BD2819616E44A0ADAFECE4A7")

    private static SQLiteDatabase mDatabase = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:43.410 -0500", hash_original_field = "5D3F3E6709C337548872A6970B078A30", hash_generated_field = "6216361743BC8C4805B411B6532C00A7")

    private static SQLiteDatabase mCacheDatabase = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:43.422 -0500", hash_original_field = "A1D52C97AD5B67F870C4011FA286F4AB", hash_generated_field = "245C6DBC8A323B94129838A862C9D38B")

    // We should consider removing the cookies table if and when we switch to
    // the Chromium HTTP stack for good.
    private static final String mTableNames[] = {
        "cookies", "password", "formurl", "formdata", "httpauth"
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:43.424 -0500", hash_original_field = "2DB5F8391A49F65BFA2D3B5FCBE4EEB0", hash_generated_field = "E071736BB1C54763EB26EE8955F646D4")

    private static final int TABLE_COOKIES_ID = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:43.426 -0500", hash_original_field = "FBFD14E14CD401E1A4DECB0090C03E7A", hash_generated_field = "C26654F80C65505FF03B4C5B6DA105F3")

    private static final int TABLE_PASSWORD_ID = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:43.428 -0500", hash_original_field = "4D697510213B16D4B09559710CC430C1", hash_generated_field = "F83A26899C0F0D2C1ACAA87EEDA0153E")

    private static final int TABLE_FORMURL_ID = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:43.431 -0500", hash_original_field = "294BAA5DCDBCA54B9FEA33C0E9843BE5", hash_generated_field = "D07F66BAD2BCF3FAD0DB03739B7A2A53")

    private static final int TABLE_FORMDATA_ID = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:43.433 -0500", hash_original_field = "E2BFBAEA3B0618C385B78347ED360C16", hash_generated_field = "213F1FE4C5C8147C0E3AA82A86D16003")

    private static final int TABLE_HTTPAUTH_ID = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:43.436 -0500", hash_original_field = "70305059E8AC5168EA563396F902132D", hash_generated_field = "544D8A467AF5FAAA84AB157CE043EFEA")

    private static final String ID_COL = "_id";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:43.438 -0500", hash_original_field = "68A77CA8F6BE9A20813C14CE9CB97E41", hash_generated_field = "E30EDA8D5CEF5DBC0865B3EFC9FE624F")

    private static final String[] ID_PROJECTION = new String[] {
        "_id"
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:43.440 -0500", hash_original_field = "5AA84C15DB83BA715B279031527DDC51", hash_generated_field = "9A9E4A560333679ACF0CA07A793F6029")

    private static final String COOKIES_NAME_COL = "name";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:43.442 -0500", hash_original_field = "711C9ECFC5AC063E97FD95D6382D408A", hash_generated_field = "36856FCE215FA203C61B4737E1A6D314")

    private static final String COOKIES_VALUE_COL = "value";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:43.445 -0500", hash_original_field = "B48DC6816AE2BC71A9252C2B4012188F", hash_generated_field = "974379DCBAF58FDB14009A07716F2DE3")

    private static final String COOKIES_DOMAIN_COL = "domain";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:43.448 -0500", hash_original_field = "8BA9D0D541F34EE156CB1652F567997D", hash_generated_field = "919C7E98C32C3DE4E674B31354083103")

    private static final String COOKIES_PATH_COL = "path";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:43.450 -0500", hash_original_field = "EF454B951E47581052E433D9C96DBDB3", hash_generated_field = "92595ACB5997D57A9912CEC295FFD385")

    private static final String COOKIES_EXPIRES_COL = "expires";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:43.452 -0500", hash_original_field = "EC0768312B074E5F7C07E3CEA278B571", hash_generated_field = "4555D5715510CC15CD635D945C145E69")

    private static final String COOKIES_SECURE_COL = "secure";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:43.455 -0500", hash_original_field = "39D375E133E52EACC16E1DDE34CEA07A", hash_generated_field = "26E13854774B9D7E5B3D124BA1DA43C8")

    private static final String CACHE_URL_COL = "url";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:43.457 -0500", hash_original_field = "2B1ADDE4B594AB37FD4947727F7747EE", hash_generated_field = "FBB51F4E9164A38BC02FE055D0D31F69")

    private static final String CACHE_FILE_PATH_COL = "filepath";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:43.459 -0500", hash_original_field = "907A854A84341BE97FD44275F86E123E", hash_generated_field = "E4EDB200A85003914E478A614635D399")

    private static final String CACHE_LAST_MODIFY_COL = "lastmodify";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:43.462 -0500", hash_original_field = "3CF18422A344A523ACE35D25D93C69E1", hash_generated_field = "E63A0BBF23F285D448CCD1D377216419")

    private static final String CACHE_ETAG_COL = "etag";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:43.464 -0500", hash_original_field = "9BF749881B29C74A8406C64D1F9BC4F1", hash_generated_field = "D715992BD667778579FCD9642CD2DF0B")

    private static final String CACHE_EXPIRES_COL = "expires";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:43.466 -0500", hash_original_field = "4784E065870C5FEB90FA0FC0A1D83320", hash_generated_field = "7EA32DCE9FCB8F00238F15D76A4D1EB0")

    private static final String CACHE_EXPIRES_STRING_COL = "expiresstring";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:43.468 -0500", hash_original_field = "5F7D97A330F7A2815E559ADACD04FF55", hash_generated_field = "4346EC9A786A0D8B47B0AF2F746CCDF9")

    private static final String CACHE_MIMETYPE_COL = "mimetype";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:43.470 -0500", hash_original_field = "C28CF5BC085E655A6364BF78ABCC312C", hash_generated_field = "A5B14468B66E4C651D16A4B4EF3D4988")

    private static final String CACHE_ENCODING_COL = "encoding";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:43.473 -0500", hash_original_field = "06F273089291EF31DADC979AFE6480FA", hash_generated_field = "74EDAC14B6454EB4BD8EC537D3A48C1D")

    private static final String CACHE_HTTP_STATUS_COL = "httpstatus";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:43.475 -0500", hash_original_field = "0A5EF2A3796699D42B1451BC37FD39C0", hash_generated_field = "AC242FF315AD73BD18B75D87F22A121D")

    private static final String CACHE_LOCATION_COL = "location";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:43.478 -0500", hash_original_field = "F8A3C83BD49E96641D70D13C52FC0DFC", hash_generated_field = "A45041FED79C2F37B614E43E9EAA62EE")

    private static final String CACHE_CONTENTLENGTH_COL = "contentlength";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:43.480 -0500", hash_original_field = "91E65F2474380E1F41401DC3CEE4A61D", hash_generated_field = "12021DAB4B009D47C4C0B03A8B7F08FB")

    private static final String CACHE_CONTENTDISPOSITION_COL = "contentdisposition";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:43.483 -0500", hash_original_field = "96E33401E1D745E54D56FEB661FB288E", hash_generated_field = "0C17DB9AB903701BF734F0A36DECDE32")

    private static final String CACHE_CROSSDOMAIN_COL = "crossdomain";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:43.486 -0500", hash_original_field = "23D37C52E26B6D7DD65365389ABE90AD", hash_generated_field = "C9B09646DBA0EE3D1FD4703689B6709E")

    private static final String PASSWORD_HOST_COL = "host";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:43.488 -0500", hash_original_field = "0C2217014CF0B31FA4B5F5CB30F4BD7D", hash_generated_field = "4834A6E26AC690BEEDA4205B55E80F71")

    private static final String PASSWORD_USERNAME_COL = "username";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:43.490 -0500", hash_original_field = "9A6B8D1997200C24D1C0C193E2364719", hash_generated_field = "6169E1A26615324546DDBAFA8EA35E46")

    private static final String PASSWORD_PASSWORD_COL = "password";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:43.493 -0500", hash_original_field = "77A187A5931C3B22CB1D1C29CDE634B3", hash_generated_field = "405F7907F7A8C1D13F6685D3670B540F")

    private static final String FORMURL_URL_COL = "url";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:43.495 -0500", hash_original_field = "8152E6AEB4E4345E418EC4CCCD11969C", hash_generated_field = "F5DC4499DBB3D0AB9C3FBC85716B75BD")

    private static final String FORMDATA_URLID_COL = "urlid";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:43.497 -0500", hash_original_field = "FCD36957F8E8AB96B23F4598654756AE", hash_generated_field = "AC7FD45F189A1AFA7D8D735589B88FEC")

    private static final String FORMDATA_NAME_COL = "name";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:43.500 -0500", hash_original_field = "EDB31DD1AC4ACB04411497E515F41DBD", hash_generated_field = "6301A8ABA0887A6D2B97FE4E3D00C0D7")

    private static final String FORMDATA_VALUE_COL = "value";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:43.502 -0500", hash_original_field = "A29AE8C42D20384A422E7E6D209BE74C", hash_generated_field = "A49759473C2E0C990FC7CE8A30842EC9")

    private static final String HTTPAUTH_HOST_COL = "host";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:43.504 -0500", hash_original_field = "AF2E79BA89DDC6CB04E16620BC6C6EE2", hash_generated_field = "A8836A926F4D3E2666084C23DE3ABA47")

    private static final String HTTPAUTH_REALM_COL = "realm";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:43.507 -0500", hash_original_field = "6A58497AA323F5248A55114D03D6E036", hash_generated_field = "E43FF3904390D4343F6CBCC7E76BB50A")

    private static final String HTTPAUTH_USERNAME_COL = "username";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:43.509 -0500", hash_original_field = "8450E49DB55159FAFB3C991B4AD67359", hash_generated_field = "306AFBB09ADAF2FFC1BE20DBB1DE10A6")

    private static final String HTTPAUTH_PASSWORD_COL = "password";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:43.512 -0500", hash_original_field = "F2A389B17CAA7CF4D46F64A17E55432B", hash_generated_field = "9978AB64D9ADE743F038BE7845E6172E")

    private static DatabaseUtils.InsertHelper mCacheInserter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:43.514 -0500", hash_original_field = "70D88C4F7EA86D3B89F070A244295CF9", hash_generated_field = "3910FC6AB35DAF5F19CCEF25E8654783")

    private static int mCacheUrlColIndex;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:43.517 -0500", hash_original_field = "4AB6E922396BC83979376C9366BE542F", hash_generated_field = "6D70A03DEA5E92F04910BB7E9E1D9224")

    private static int mCacheFilePathColIndex;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:43.519 -0500", hash_original_field = "7F410E676BABDBF81B3FDAE4417283C3", hash_generated_field = "F297F7407A43B3D8B550234904F928F5")

    private static int mCacheLastModifyColIndex;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:43.522 -0500", hash_original_field = "446D00822D3278D51C5F804AF81299F2", hash_generated_field = "7E671A6F0167C6AE2F10F590C7DC601E")

    private static int mCacheETagColIndex;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:43.524 -0500", hash_original_field = "ACB0095505D54F02CFB4BBC76E34411E", hash_generated_field = "09E6E173F9C3511818B6258041F0A3BC")

    private static int mCacheExpiresColIndex;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:43.527 -0500", hash_original_field = "EB2546EEFDEB84E6BD77DA197357393D", hash_generated_field = "9DDE47C8C21140680D9D21457C8BA030")

    private static int mCacheExpiresStringColIndex;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:43.529 -0500", hash_original_field = "39B7EC695759BA3A07DFDB99209432BD", hash_generated_field = "6EC0F1436186404D863C79D70C9D0422")

    private static int mCacheMimeTypeColIndex;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:43.531 -0500", hash_original_field = "8AC30E7C48AE33F9AFD8BC68BD8564F7", hash_generated_field = "67A46391EDD0D1EEFDAA1EF5F50C5C78")

    private static int mCacheEncodingColIndex;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:43.533 -0500", hash_original_field = "C4ECBDEDF3D40AFD741FB1BB3AF11AF6", hash_generated_field = "E8069F7EB9821C68B302A5C70FE84C68")

    private static int mCacheHttpStatusColIndex;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:43.535 -0500", hash_original_field = "DFB728F24E24D2E6D96660577F1F2CBA", hash_generated_field = "DA4DBC2E2AF89F71F7CF53E4A0F9DB44")

    private static int mCacheLocationColIndex;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:43.537 -0500", hash_original_field = "A67840F968DFD74FCDE83BE93D482617", hash_generated_field = "2CEFBAF45A5360D0C6A73071406979A0")

    private static int mCacheContentLengthColIndex;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:43.540 -0500", hash_original_field = "77604E6F9B048A6C1C5F6DEB45BC4EC0", hash_generated_field = "C4C9ED448FAD4F85DBEA109ADF0942B5")

    private static int mCacheContentDispositionColIndex;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:43.542 -0500", hash_original_field = "8700EB8E5504BC8ADEFDC94A33DA5F4B", hash_generated_field = "07EC8A1B46BF12BB85378082FD36D87C")

    private static int mCacheCrossDomainColIndex;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:43.544 -0500", hash_original_field = "F862681BA6DC02D348449FC30DBC8D17", hash_generated_field = "BFC3FA813D8D5121BE43E51DCA5BBA65")

    private static int mCacheTransactionRefcount;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:43.413 -0500", hash_original_field = "1CBCD28C0FF0FD1BA2527EF45D3C6F9B", hash_generated_field = "93D9ABAC661FEA809DA54BD9E7E9D9D3")

    private final Object mCookieLock = new Object();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:43.415 -0500", hash_original_field = "41E77FB21E6E4DD31EEEFC8EFC3B46A1", hash_generated_field = "B9AA262C50068E49E8D4989E6CB68357")

    private final Object mPasswordLock = new Object();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:43.417 -0500", hash_original_field = "100D4C712D92460BAF20430C97E51DFB", hash_generated_field = "FFB3B56DC6131C4C61A59C58082777D9")

    private final Object mFormLock = new Object();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:43.419 -0500", hash_original_field = "78B3D004413582CE1637BFDFECAA95F6", hash_generated_field = "5C47FB4E53C3D9C9795AB924F63FC85D")

    private final Object mHttpAuthLock = new Object();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:43.546 -0500", hash_original_field = "D7228C282593CDC77734D668B23541D3", hash_generated_field = "E5CA3845DA8FE08BE201D5EDF15F54DD")

    private boolean mInitialized = false;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:43.553 -0500", hash_original_method = "EFB05B9D3FCAB305323B10379F1EC778", hash_generated_method = "BCF7CE3EB8F14DCD97B7C38145DF17AD")
    
private WebViewDatabase(final Context context) {
        new Thread() {
            @DSSafe(DSCat.SAFE_LIST)
        @Override
            public void run() {
                init(context);
            }
        }.start();

        // Singleton only, use getInstance()
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:43.557 -0500", hash_original_method = "AC87AD0E19559694D58F1943BD15C1D5", hash_generated_method = "822C197CD2E58D61C2D5AC7021473447")
    
private synchronized void init(Context context) {
        if (mInitialized) {
            return;
        }

        initDatabase(context);
        if (JniUtil.useChromiumHttpStack()) {
            context.deleteDatabase(CACHE_DATABASE_FILE);
        } else {
            initCacheDatabase(context);
        }

        // Thread done, notify.
        mInitialized = true;
        notify();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:43.559 -0500", hash_original_method = "CE06D258DB88B89F42DED68141C198E0", hash_generated_method = "004791B0A102FDC8375CE88BA2A15064")
    
private void initDatabase(Context context) {
        try {
            mDatabase = context.openOrCreateDatabase(DATABASE_FILE, 0, null);
        } catch (SQLiteException e) {
            // try again by deleting the old db and create a new one
            if (context.deleteDatabase(DATABASE_FILE)) {
                mDatabase = context.openOrCreateDatabase(DATABASE_FILE, 0,
                        null);
            }
        }
        mDatabase.enableWriteAheadLogging();

        // mDatabase should not be null,
        // the only case is RequestAPI test has problem to create db
        if (mDatabase == null) {
            mInitialized = true;
            notify();
            return;
        }

        if (mDatabase.getVersion() != DATABASE_VERSION) {
            mDatabase.beginTransactionNonExclusive();
            try {
                upgradeDatabase();
                mDatabase.setTransactionSuccessful();
            } finally {
                mDatabase.endTransaction();
            }
        }

        // use per table Mutex lock, turn off database lock, this
        // improves performance as database's ReentrantLock is
        // expansive
        mDatabase.setLockingEnabled(false);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:43.563 -0500", hash_original_method = "C7A89DE182CA76C10CB3961C893695C2", hash_generated_method = "C6E624CC415EFE95EC25E57FC5741F8D")
    
private void initCacheDatabase(Context context) {
        assert !JniUtil.useChromiumHttpStack();

        try {
            mCacheDatabase = context.openOrCreateDatabase(
                    CACHE_DATABASE_FILE, 0, null);
        } catch (SQLiteException e) {
            // try again by deleting the old db and create a new one
            if (context.deleteDatabase(CACHE_DATABASE_FILE)) {
                mCacheDatabase = context.openOrCreateDatabase(
                        CACHE_DATABASE_FILE, 0, null);
            }
        }
        mCacheDatabase.enableWriteAheadLogging();

        // mCacheDatabase should not be null,
        // the only case is RequestAPI test has problem to create db
        if (mCacheDatabase == null) {
            mInitialized = true;
            notify();
            return;
        }

        if (mCacheDatabase.getVersion() != CACHE_DATABASE_VERSION) {
            mCacheDatabase.beginTransactionNonExclusive();
            try {
                upgradeCacheDatabase();
                bootstrapCacheDatabase();
                mCacheDatabase.setTransactionSuccessful();
            } finally {
                mCacheDatabase.endTransaction();
            }
            // Erase the files from the file system in the
            // case that the database was updated and the
            // there were existing cache content
            CacheManager.removeAllCacheFiles();
        }

        // use read_uncommitted to speed up READ
        mCacheDatabase.execSQL("PRAGMA read_uncommitted = true;");
        // as only READ can be called in the
        // non-WebViewWorkerThread, and read_uncommitted is used,
        // we can turn off database lock to use transaction.
        mCacheDatabase.setLockingEnabled(false);

        // use InsertHelper for faster insertion
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
    }

    // Wait for the background initialization thread to complete and check the
    // database creation status.
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:43.580 -0500", hash_original_method = "B19C14CCA683C2C1072DDA1B7A6274D5", hash_generated_method = "B96D5E4DBF7E7F145B43FDA8AF9694E5")
    
private boolean checkInitialized() {
        synchronized (this) {
            while (!mInitialized) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Log.e(LOGTAG, "Caught exception while checking " +
                                  "initialization");
                    Log.e(LOGTAG, Log.getStackTraceString(e));
                }
            }
        }
        return mDatabase != null;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:43.583 -0500", hash_original_method = "CBFCA06012BEB8B609A8EBC6EEC6D1A4", hash_generated_method = "2566BD63CB8252798FC115F8BF8641FE")
    
private boolean hasEntries(int tableId) {
        if (!checkInitialized()) {
            return false;
        }

        Cursor cursor = null;
        boolean ret = false;
        try {
            cursor = mDatabase.query(mTableNames[tableId], ID_PROJECTION,
                    null, null, null, null, null);
            ret = cursor.moveToFirst() == true;
        } catch (IllegalStateException e) {
            Log.e(LOGTAG, "hasEntries", e);
        } finally {
            if (cursor != null) cursor.close();
        }
        return ret;
    }

    //
    // cookies functions
    //

    /**
     * Get cookies in the format of CookieManager.Cookie inside an ArrayList for
     * a given domain
     *
     * @return ArrayList<Cookie> If nothing is found, return an empty list.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:43.587 -0500", hash_original_method = "4D94521780B9AD3D8F70E78E8CBCD3E0", hash_generated_method = "4D94521780B9AD3D8F70E78E8CBCD3E0")
    
ArrayList<Cookie> getCookiesForDomain(String domain) {
        ArrayList<Cookie> list = new ArrayList<Cookie>();
        if (domain == null || !checkInitialized()) {
            return list;
        }

        synchronized (mCookieLock) {
            final String[] columns = new String[] {
                    ID_COL, COOKIES_DOMAIN_COL, COOKIES_PATH_COL,
                    COOKIES_NAME_COL, COOKIES_VALUE_COL, COOKIES_EXPIRES_COL,
                    COOKIES_SECURE_COL
            };
            final String selection = "(" + COOKIES_DOMAIN_COL
                    + " GLOB '*' || ?)";
            Cursor cursor = null;
            try {
                cursor = mDatabase.query(mTableNames[TABLE_COOKIES_ID],
                        columns, selection, new String[] { domain }, null, null,
                        null);
                if (cursor.moveToFirst()) {
                    int domainCol = cursor.getColumnIndex(COOKIES_DOMAIN_COL);
                    int pathCol = cursor.getColumnIndex(COOKIES_PATH_COL);
                    int nameCol = cursor.getColumnIndex(COOKIES_NAME_COL);
                    int valueCol = cursor.getColumnIndex(COOKIES_VALUE_COL);
                    int expiresCol = cursor.getColumnIndex(COOKIES_EXPIRES_COL);
                    int secureCol = cursor.getColumnIndex(COOKIES_SECURE_COL);
                    do {
                        Cookie cookie = new Cookie();
                        cookie.domain = cursor.getString(domainCol);
                        cookie.path = cursor.getString(pathCol);
                        cookie.name = cursor.getString(nameCol);
                        cookie.value = cursor.getString(valueCol);
                        if (cursor.isNull(expiresCol)) {
                            cookie.expires = -1;
                        } else {
                            cookie.expires = cursor.getLong(expiresCol);
                        }
                        cookie.secure = cursor.getShort(secureCol) != 0;
                        cookie.mode = Cookie.MODE_NORMAL;
                        list.add(cookie);
                    } while (cursor.moveToNext());
                }
            } catch (IllegalStateException e) {
                Log.e(LOGTAG, "getCookiesForDomain", e);
            } finally {
                if (cursor != null) cursor.close();
            }
            return list;
        }
    }

    /**
     * Delete cookies which matches (domain, path, name).
     *
     * @param domain If it is null, nothing happens.
     * @param path If it is null, all the cookies match (domain) will be
     *            deleted.
     * @param name If it is null, all the cookies match (domain, path) will be
     *            deleted.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:43.589 -0500", hash_original_method = "BC23D2938EE88E31CA87024518493BE2", hash_generated_method = "BC23D2938EE88E31CA87024518493BE2")
    
void deleteCookies(String domain, String path, String name) {
        if (domain == null || !checkInitialized()) {
            return;
        }

        synchronized (mCookieLock) {
            final String where = "(" + COOKIES_DOMAIN_COL + " == ?) AND ("
                    + COOKIES_PATH_COL + " == ?) AND (" + COOKIES_NAME_COL
                    + " == ?)";
            mDatabase.delete(mTableNames[TABLE_COOKIES_ID], where,
                    new String[] { domain, path, name });
        }
    }

    /**
     * Add a cookie to the database
     *
     * @param cookie
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:43.591 -0500", hash_original_method = "33710CB1E65A2C52E9ABEE23433BB87F", hash_generated_method = "33710CB1E65A2C52E9ABEE23433BB87F")
    
void addCookie(Cookie cookie) {
        if (cookie.domain == null || cookie.path == null || cookie.name == null
                || !checkInitialized()) {
            return;
        }

        synchronized (mCookieLock) {
            ContentValues cookieVal = new ContentValues();
            cookieVal.put(COOKIES_DOMAIN_COL, cookie.domain);
            cookieVal.put(COOKIES_PATH_COL, cookie.path);
            cookieVal.put(COOKIES_NAME_COL, cookie.name);
            cookieVal.put(COOKIES_VALUE_COL, cookie.value);
            if (cookie.expires != -1) {
                cookieVal.put(COOKIES_EXPIRES_COL, cookie.expires);
            }
            cookieVal.put(COOKIES_SECURE_COL, cookie.secure);
            mDatabase.insert(mTableNames[TABLE_COOKIES_ID], null, cookieVal);
        }
    }

    /**
     * Whether there is any cookies in the database
     *
     * @return TRUE if there is cookie.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:43.593 -0500", hash_original_method = "83E6237273AAD0C9F4D2DED923ACAFB7", hash_generated_method = "83E6237273AAD0C9F4D2DED923ACAFB7")
    
boolean hasCookies() {
        synchronized (mCookieLock) {
            return hasEntries(TABLE_COOKIES_ID);
        }
    }

    /**
     * Clear cookie database
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:43.596 -0500", hash_original_method = "3E1D9455881C3029C0C51566A563B8F4", hash_generated_method = "3E1D9455881C3029C0C51566A563B8F4")
    
void clearCookies() {
        if (!checkInitialized()) {
            return;
        }

        synchronized (mCookieLock) {
            mDatabase.delete(mTableNames[TABLE_COOKIES_ID], null, null);
        }
    }

    /**
     * Clear session cookies, which means cookie doesn't have EXPIRES.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:43.598 -0500", hash_original_method = "CAA5F0320575B2151920B0F146B122B7", hash_generated_method = "CAA5F0320575B2151920B0F146B122B7")
    
void clearSessionCookies() {
        if (!checkInitialized()) {
            return;
        }

        final String sessionExpired = COOKIES_EXPIRES_COL + " ISNULL";
        synchronized (mCookieLock) {
            mDatabase.delete(mTableNames[TABLE_COOKIES_ID], sessionExpired,
                    null);
        }
    }

    /**
     * Clear expired cookies
     *
     * @param now Time for now
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:43.600 -0500", hash_original_method = "AD90F95A26E2D9ECD94EF58E091F4A84", hash_generated_method = "AD90F95A26E2D9ECD94EF58E091F4A84")
    
void clearExpiredCookies(long now) {
        if (!checkInitialized()) {
            return;
        }

        final String expires = COOKIES_EXPIRES_COL + " <= ?";
        synchronized (mCookieLock) {
            mDatabase.delete(mTableNames[TABLE_COOKIES_ID], expires,
                    new String[] { Long.toString(now) });
        }
    }

    //
    // cache functions
    //

    // only called from WebViewWorkerThread
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:43.602 -0500", hash_original_method = "26A436743D42208E44F8DC7C1FFF5A77", hash_generated_method = "26A436743D42208E44F8DC7C1FFF5A77")
    
boolean startCacheTransaction() {
        if (++mCacheTransactionRefcount == 1) {
            if (!Thread.currentThread().equals(
                    WebViewWorker.getHandler().getLooper().getThread())) {
                Log.w(LOGTAG, "startCacheTransaction should be called from "
                        + "WebViewWorkerThread instead of from "
                        + Thread.currentThread().getName());
            }
            mCacheDatabase.beginTransactionNonExclusive();
            return true;
        }
        return false;
    }

    // only called from WebViewWorkerThread
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:43.604 -0500", hash_original_method = "14B92CCE9ED71BB98EE6E80EBC3B995B", hash_generated_method = "14B92CCE9ED71BB98EE6E80EBC3B995B")
    
boolean endCacheTransaction() {
        if (--mCacheTransactionRefcount == 0) {
            if (!Thread.currentThread().equals(
                    WebViewWorker.getHandler().getLooper().getThread())) {
                Log.w(LOGTAG, "endCacheTransaction should be called from "
                        + "WebViewWorkerThread instead of from "
                        + Thread.currentThread().getName());
            }
            try {
                mCacheDatabase.setTransactionSuccessful();
            } finally {
                mCacheDatabase.endTransaction();
            }
            return true;
        }
        return false;
    }

    /**
     * Get a cache item.
     * 
     * @param url The url
     * @return CacheResult The CacheManager.CacheResult
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:43.607 -0500", hash_original_method = "BF73224910862A6343E046C49771A81E", hash_generated_method = "BF73224910862A6343E046C49771A81E")
    
CacheResult getCache(String url) {
        assert !JniUtil.useChromiumHttpStack();

        if (url == null || !checkInitialized()) {
            return null;
        }

        Cursor cursor = null;
        final String query = "SELECT filepath, lastmodify, etag, expires, "
                + "expiresstring, mimetype, encoding, httpstatus, location, contentlength, "
                + "contentdisposition, crossdomain FROM cache WHERE url = ?";
        try {
            cursor = mCacheDatabase.rawQuery(query, new String[] { url });
            if (cursor.moveToFirst()) {
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
                return ret;
            }
        } catch (IllegalStateException e) {
            Log.e(LOGTAG, "getCache", e);
        } finally {
            if (cursor != null) cursor.close();
        }
        return null;
    }

    /**
     * Remove a cache item.
     * 
     * @param url The url
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:43.609 -0500", hash_original_method = "10415454EB24D9D06B07AD8A5863D117", hash_generated_method = "10415454EB24D9D06B07AD8A5863D117")
    
void removeCache(String url) {
        assert !JniUtil.useChromiumHttpStack();

        if (url == null || !checkInitialized()) {
            return;
        }

        mCacheDatabase.execSQL("DELETE FROM cache WHERE url = ?", new String[] { url });
    }

    /**
     * Add or update a cache. CACHE_URL_COL is unique in the table.
     *
     * @param url The url
     * @param c The CacheManager.CacheResult
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:43.612 -0500", hash_original_method = "C4FACCF94A8569C78058717A9665F703", hash_generated_method = "C4FACCF94A8569C78058717A9665F703")
    
void addCache(String url, CacheResult c) {
        assert !JniUtil.useChromiumHttpStack();

        if (url == null || !checkInitialized()) {
            return;
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
    }

    /**
     * Clear cache database
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:43.614 -0500", hash_original_method = "67241BF201ED077F6E669112ABB44844", hash_generated_method = "67241BF201ED077F6E669112ABB44844")
    
void clearCache() {
        if (!checkInitialized()) {
            return;
        }

        mCacheDatabase.delete("cache", null, null);
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:43.616 -0500", hash_original_method = "0A5B6EFF79BC3227EAB74E5615633418", hash_generated_method = "0A5B6EFF79BC3227EAB74E5615633418")
    
boolean hasCache() {
        if (!checkInitialized()) {
            return false;
        }

        Cursor cursor = null;
        boolean ret = false;
        try {
            cursor = mCacheDatabase.query("cache", ID_PROJECTION,
                    null, null, null, null, null);
            ret = cursor.moveToFirst() == true;
        } catch (IllegalStateException e) {
            Log.e(LOGTAG, "hasCache", e);
        } finally {
            if (cursor != null) cursor.close();
        }
        return ret;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:43.618 -0500", hash_original_method = "08C6E9C5D3BD785D378572A4A550228E", hash_generated_method = "08C6E9C5D3BD785D378572A4A550228E")
    
long getCacheTotalSize() {
        if (mCacheDatabase == null) {
            return 0;
        }
        long size = 0;
        Cursor cursor = null;
        final String query = "SELECT SUM(contentlength) as sum FROM cache";
        try {
            cursor = mCacheDatabase.rawQuery(query, null);
            if (cursor.moveToFirst()) {
                size = cursor.getLong(0);
            }
        } catch (IllegalStateException e) {
            Log.e(LOGTAG, "getCacheTotalSize", e);
        } finally {
            if (cursor != null) cursor.close();
        }
        return size;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:43.621 -0500", hash_original_method = "E1CB3EA921D4F41F15D60CB73EFC3B4C", hash_generated_method = "F5F630BF6A0A63E017E7A5708F2FBF06")
    
List<String> trimCache(long amount) {
        ArrayList<String> pathList = new ArrayList<String>(100);
        Cursor cursor = null;
        final String query = "SELECT contentlength, filepath FROM cache ORDER BY expires ASC";
        try {
            cursor = mCacheDatabase.rawQuery(query, null);
            if (cursor.moveToFirst()) {
                int batchSize = 100;
                StringBuilder pathStr = new StringBuilder(20 + 16 * batchSize);
                pathStr.append("DELETE FROM cache WHERE filepath IN (?");
                for (int i = 1; i < batchSize; i++) {
                    pathStr.append(", ?");
                }
                pathStr.append(")");
                SQLiteStatement statement = null;
                try {
                    statement = mCacheDatabase.compileStatement(
                            pathStr.toString());
                    // as bindString() uses 1-based index, initialize index to 1
                    int index = 1;
                    do {
                        long length = cursor.getLong(0);
                        if (length == 0) {
                            continue;
                        }
                        amount -= length;
                        String filePath = cursor.getString(1);
                        statement.bindString(index, filePath);
                        pathList.add(filePath);
                        if (index++ == batchSize) {
                            statement.execute();
                            statement.clearBindings();
                            index = 1;
                        }
                    } while (cursor.moveToNext() && amount > 0);
                    if (index > 1) {
                        // there may be old bindings from the previous statement
                        // if index is less than batchSize, which is Ok.
                        statement.execute();
                    }
                } catch (IllegalStateException e) {
                    Log.e(LOGTAG, "trimCache SQLiteStatement", e);
                } finally {
                    if (statement != null) statement.close();
                }
            }
        } catch (IllegalStateException e) {
            Log.e(LOGTAG, "trimCache Cursor", e);
        } finally {
            if (cursor != null) cursor.close();
        }
        return pathList;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:43.625 -0500", hash_original_method = "791DEB22BE9B55B5A0DA04ED6BE6D08D", hash_generated_method = "791DEB22BE9B55B5A0DA04ED6BE6D08D")
    
List<String> getAllCacheFileNames() {
        ArrayList<String> pathList = null;
        Cursor cursor = null;
        try {
            cursor = mCacheDatabase.rawQuery("SELECT filepath FROM cache",
                    null);
            if (cursor != null && cursor.moveToFirst()) {
                pathList = new ArrayList<String>(cursor.getCount());
                do {
                    pathList.add(cursor.getString(0));
                } while (cursor.moveToNext());
            }
        } catch (IllegalStateException e) {
            Log.e(LOGTAG, "getAllCacheFileNames", e);
        } finally {
            if (cursor != null) cursor.close();
        }
        return pathList;
    }

    //
    // password functions
    //

    /**
     * Set password. Tuple (PASSWORD_HOST_COL, PASSWORD_USERNAME_COL) is unique.
     *
     * @param schemePlusHost The scheme and host for the password
     * @param username The username for the password. If it is null, it means
     *            password can't be saved.
     * @param password The password
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:43.627 -0500", hash_original_method = "06E61C8A80289A57F170E4E5B574929B", hash_generated_method = "06E61C8A80289A57F170E4E5B574929B")
    
void setUsernamePassword(String schemePlusHost, String username,
                String password) {
        if (schemePlusHost == null || !checkInitialized()) {
            return;
        }

        synchronized (mPasswordLock) {
            final ContentValues c = new ContentValues();
            c.put(PASSWORD_HOST_COL, schemePlusHost);
            c.put(PASSWORD_USERNAME_COL, username);
            c.put(PASSWORD_PASSWORD_COL, password);
            mDatabase.insert(mTableNames[TABLE_PASSWORD_ID], PASSWORD_HOST_COL,
                    c);
        }
    }

    /**
     * Retrieve the username and password for a given host
     *
     * @param schemePlusHost The scheme and host which passwords applies to
     * @return String[] if found, String[0] is username, which can be null and
     *         String[1] is password. Return null if it can't find anything.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:43.630 -0500", hash_original_method = "AA29CF1F05823526F8013A43811B3B7E", hash_generated_method = "AA29CF1F05823526F8013A43811B3B7E")
    
String[] getUsernamePassword(String schemePlusHost) {
        if (schemePlusHost == null || !checkInitialized()) {
            return null;
        }

        final String[] columns = new String[] {
                PASSWORD_USERNAME_COL, PASSWORD_PASSWORD_COL
        };
        final String selection = "(" + PASSWORD_HOST_COL + " == ?)";
        synchronized (mPasswordLock) {
            String[] ret = null;
            Cursor cursor = null;
            try {
                cursor = mDatabase.query(mTableNames[TABLE_PASSWORD_ID],
                        columns, selection, new String[] { schemePlusHost }, null,
                        null, null);
                if (cursor.moveToFirst()) {
                    ret = new String[2];
                    ret[0] = cursor.getString(
                            cursor.getColumnIndex(PASSWORD_USERNAME_COL));
                    ret[1] = cursor.getString(
                            cursor.getColumnIndex(PASSWORD_PASSWORD_COL));
                }
            } catch (IllegalStateException e) {
                Log.e(LOGTAG, "getUsernamePassword", e);
            } finally {
                if (cursor != null) cursor.close();
            }
            return ret;
        }
    }

    /**
     * Find out if there are any passwords saved. 
     *
     * @return TRUE if there is passwords saved
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:43.632 -0500", hash_original_method = "048A7854E0D4842D61BAD40D57C0F82F", hash_generated_method = "6F116209E01E7D086216611601F1D84C")
    
public boolean hasUsernamePassword() {
        synchronized (mPasswordLock) {
            return hasEntries(TABLE_PASSWORD_ID);
        }
    }

    /**
     * Clear password database
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:43.634 -0500", hash_original_method = "1884CD7855F3B6349631839451D5E408", hash_generated_method = "EEBA90E2F8BF084132325346A2CC0D43")
    
public void clearUsernamePassword() {
        if (!checkInitialized()) {
            return;
        }

        synchronized (mPasswordLock) {
            mDatabase.delete(mTableNames[TABLE_PASSWORD_ID], null, null);
        }
    }

    //
    // http authentication password functions
    //

    /**
     * Set HTTP authentication password. Tuple (HTTPAUTH_HOST_COL,
     * HTTPAUTH_REALM_COL, HTTPAUTH_USERNAME_COL) is unique.
     *
     * @param host The host for the password
     * @param realm The realm for the password
     * @param username The username for the password. If it is null, it means
     *            password can't be saved.
     * @param password The password
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:43.636 -0500", hash_original_method = "AAEAEDF714B99771C21BA669DE54047C", hash_generated_method = "AAEAEDF714B99771C21BA669DE54047C")
    
void setHttpAuthUsernamePassword(String host, String realm, String username,
            String password) {
        if (host == null || realm == null || !checkInitialized()) {
            return;
        }

        synchronized (mHttpAuthLock) {
            final ContentValues c = new ContentValues();
            c.put(HTTPAUTH_HOST_COL, host);
            c.put(HTTPAUTH_REALM_COL, realm);
            c.put(HTTPAUTH_USERNAME_COL, username);
            c.put(HTTPAUTH_PASSWORD_COL, password);
            mDatabase.insert(mTableNames[TABLE_HTTPAUTH_ID], HTTPAUTH_HOST_COL,
                    c);
        }
    }

    /**
     * Retrieve the HTTP authentication username and password for a given
     * host+realm pair
     *
     * @param host The host the password applies to
     * @param realm The realm the password applies to
     * @return String[] if found, String[0] is username, which can be null and
     *         String[1] is password. Return null if it can't find anything.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:43.639 -0500", hash_original_method = "6E1D9953804AC08BC6DDA66478F3E8B6", hash_generated_method = "6E1D9953804AC08BC6DDA66478F3E8B6")
    
String[] getHttpAuthUsernamePassword(String host, String realm) {
        if (host == null || realm == null || !checkInitialized()){
            return null;
        }

        final String[] columns = new String[] {
                HTTPAUTH_USERNAME_COL, HTTPAUTH_PASSWORD_COL
        };
        final String selection = "(" + HTTPAUTH_HOST_COL + " == ?) AND ("
                + HTTPAUTH_REALM_COL + " == ?)";
        synchronized (mHttpAuthLock) {
            String[] ret = null;
            Cursor cursor = null;
            try {
                cursor = mDatabase.query(mTableNames[TABLE_HTTPAUTH_ID],
                        columns, selection, new String[] { host, realm }, null,
                        null, null);
                if (cursor.moveToFirst()) {
                    ret = new String[2];
                    ret[0] = cursor.getString(
                            cursor.getColumnIndex(HTTPAUTH_USERNAME_COL));
                    ret[1] = cursor.getString(
                            cursor.getColumnIndex(HTTPAUTH_PASSWORD_COL));
                }
            } catch (IllegalStateException e) {
                Log.e(LOGTAG, "getHttpAuthUsernamePassword", e);
            } finally {
                if (cursor != null) cursor.close();
            }
            return ret;
        }
    }

    /**
     *  Find out if there are any HTTP authentication passwords saved.   
     *
     * @return TRUE if there are passwords saved
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:43.641 -0500", hash_original_method = "50C83C4F45D13310D76D1C1AF4DB3EDF", hash_generated_method = "7A375570FF1943C0937CEFC037A47BFA")
    
public boolean hasHttpAuthUsernamePassword() {
        synchronized (mHttpAuthLock) {
            return hasEntries(TABLE_HTTPAUTH_ID);
        }
    }

    /**
     * Clear HTTP authentication password database
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:43.643 -0500", hash_original_method = "447C774EFBF83BDF0A062EB0F2F80455", hash_generated_method = "F06727EF6D7FC09FF090F4AFB6DC509B")
    
public void clearHttpAuthUsernamePassword() {
        if (!checkInitialized()) {
            return;
        }

        synchronized (mHttpAuthLock) {
            mDatabase.delete(mTableNames[TABLE_HTTPAUTH_ID], null, null);
        }
    }

    //
    // form data functions
    //

    /**
     * Set form data for a site. Tuple (FORMDATA_URLID_COL, FORMDATA_NAME_COL,
     * FORMDATA_VALUE_COL) is unique
     *
     * @param url The url of the site
     * @param formdata The form data in HashMap
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:43.646 -0500", hash_original_method = "1C1CA3B21EC6341A527B545FB0F444FE", hash_generated_method = "1C1CA3B21EC6341A527B545FB0F444FE")
    
void setFormData(String url, HashMap<String, String> formdata) {
        if (url == null || formdata == null || !checkInitialized()) {
            return;
        }

        final String selection = "(" + FORMURL_URL_COL + " == ?)";
        synchronized (mFormLock) {
            long urlid = -1;
            Cursor cursor = null;
            try {
                cursor = mDatabase.query(mTableNames[TABLE_FORMURL_ID],
                        ID_PROJECTION, selection, new String[] { url }, null, null,
                        null);
                if (cursor.moveToFirst()) {
                    urlid = cursor.getLong(cursor.getColumnIndex(ID_COL));
                } else {
                    ContentValues c = new ContentValues();
                    c.put(FORMURL_URL_COL, url);
                    urlid = mDatabase.insert(
                            mTableNames[TABLE_FORMURL_ID], null, c);
                }
            } catch (IllegalStateException e) {
                Log.e(LOGTAG, "setFormData", e);
            } finally {
                if (cursor != null) cursor.close();
            }
            if (urlid >= 0) {
                Set<Entry<String, String>> set = formdata.entrySet();
                Iterator<Entry<String, String>> iter = set.iterator();
                ContentValues map = new ContentValues();
                map.put(FORMDATA_URLID_COL, urlid);
                while (iter.hasNext()) {
                    Entry<String, String> entry = iter.next();
                    map.put(FORMDATA_NAME_COL, entry.getKey());
                    map.put(FORMDATA_VALUE_COL, entry.getValue());
                    mDatabase.insert(mTableNames[TABLE_FORMDATA_ID], null, map);
                }
            }
        }
    }

    /**
     * Get all the values for a form entry with "name" in a given site
     *
     * @param url The url of the site
     * @param name The name of the form entry
     * @return A list of values. Return empty list if nothing is found.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:43.649 -0500", hash_original_method = "699FE9DC5ACA57A32D74F51785DE679D", hash_generated_method = "699FE9DC5ACA57A32D74F51785DE679D")
    
ArrayList<String> getFormData(String url, String name) {
        ArrayList<String> values = new ArrayList<String>();
        if (url == null || name == null || !checkInitialized()) {
            return values;
        }

        final String urlSelection = "(" + FORMURL_URL_COL + " == ?)";
        final String dataSelection = "(" + FORMDATA_URLID_COL + " == ?) AND ("
                + FORMDATA_NAME_COL + " == ?)";
        synchronized (mFormLock) {
            Cursor cursor = null;
            try {
                cursor = mDatabase.query(mTableNames[TABLE_FORMURL_ID],
                        ID_PROJECTION, urlSelection, new String[] { url }, null,
                        null, null);
                while (cursor.moveToNext()) {
                    long urlid = cursor.getLong(cursor.getColumnIndex(ID_COL));
                    Cursor dataCursor = null;
                    try {
                        dataCursor = mDatabase.query(
                                mTableNames[TABLE_FORMDATA_ID],
                                new String[] { ID_COL, FORMDATA_VALUE_COL },
                                dataSelection,
                                new String[] { Long.toString(urlid), name },
                                null, null, null);
                        if (dataCursor.moveToFirst()) {
                            int valueCol = dataCursor.getColumnIndex(
                                    FORMDATA_VALUE_COL);
                            do {
                                values.add(dataCursor.getString(valueCol));
                            } while (dataCursor.moveToNext());
                        }
                    } catch (IllegalStateException e) {
                        Log.e(LOGTAG, "getFormData dataCursor", e);
                    } finally {
                        if (dataCursor != null) dataCursor.close();
                    }
                }
            } catch (IllegalStateException e) {
                Log.e(LOGTAG, "getFormData cursor", e);
            } finally {
                if (cursor != null) cursor.close();
            }
            return values;
        }
    }

    /**
     * Find out if there is form data saved.
     *
     * @return TRUE if there is form data in the database
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:43.651 -0500", hash_original_method = "6553D4A66AD572AF8668D3FA13E3C7D5", hash_generated_method = "A6DC5F11A0D1EF7379DECEBBBC7C000D")
    
public boolean hasFormData() {
        synchronized (mFormLock) {
            return hasEntries(TABLE_FORMURL_ID);
        }
    }

    /**
     * Clear form database
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:43.653 -0500", hash_original_method = "9C11F1BCAAD785FEF89EC2FF8E172198", hash_generated_method = "26A919B3D88DD9507FE4C514B76C8A9E")
    
public void clearFormData() {
        if (!checkInitialized()) {
            return;
        }

        synchronized (mFormLock) {
            mDatabase.delete(mTableNames[TABLE_FORMURL_ID], null, null);
            mDatabase.delete(mTableNames[TABLE_FORMDATA_ID], null, null);
        }
    }
}

