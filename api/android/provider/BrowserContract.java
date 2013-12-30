package android.provider;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.accounts.Account;
import android.content.ContentProviderClient;
import android.content.ContentProviderOperation;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.RemoteException;
import android.util.Pair;





public class BrowserContract {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:02.281 -0500", hash_original_field = "2A25262717489890CBEBAF94D3AA5F5F", hash_generated_field = "3226F8D573C55538143AADDEDE9BEDF1")

    public static final String AUTHORITY = "com.android.browser";


    public static final class ChromeSyncColumns {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:02.300 -0500", hash_original_field = "B5CE1614C744C7D7ABCA33717FE0B401", hash_generated_field = "BA004DD6C732A9DE7AE9F50F0365E343")

        public static final String SERVER_UNIQUE = BaseSyncColumns.SYNC3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:02.303 -0500", hash_original_field = "B20F4CDDA61C99CD459240E7EEBD4910", hash_generated_field = "8F8B59E19C1BFC825B3CFF4F6E7D2455")


        public static final String FOLDER_NAME_ROOT = "google_chrome";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:02.305 -0500", hash_original_field = "DA3DBC41138BEBA5B2614655370140C3", hash_generated_field = "7D7F7FF342C4D3964B81AA9C29FE0797")

        public static final String FOLDER_NAME_BOOKMARKS = "google_chrome_bookmarks";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:02.308 -0500", hash_original_field = "F9DE2D6434C9BC80A7BD5997C4E49B5F", hash_generated_field = "4D7461C20500A0C2B9C0C2ABF53B81C4")

        public static final String FOLDER_NAME_BOOKMARKS_BAR = "bookmark_bar";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:02.310 -0500", hash_original_field = "7E409C00EBF831E4AA7A7BEF9FA5E49F", hash_generated_field = "C3C745E3EDE408E69F187E5C6F906CD1")

        public static final String FOLDER_NAME_OTHER_BOOKMARKS = "other_bookmarks";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:02.313 -0500", hash_original_field = "F6706C3E2084D134E9959626B0DA9FC4", hash_generated_field = "489183F01776E5FE54CC501794239F31")

        public static final String CLIENT_UNIQUE = BaseSyncColumns.SYNC4;
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:02.297 -0500", hash_original_method = "FBBD23C5251F402AEB9A227B34F9A614", hash_generated_method = "1A7A2CEFBCA58FDC5FF4D33C30808C0A")
        
private ChromeSyncColumns() {}
    }


    
    public static final class Bookmarks implements CommonColumns, ImageColumns, SyncColumns {

        /**
         * Builds a URI that points to a specific folder.
         * @param folderId the ID of the folder to point to
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:02.348 -0500", hash_original_method = "6EDABC37CCD87E86BEFC5F3C9AF87B04", hash_generated_method = "2C5637A65B8FF550DAE40DB6E4B3C633")
        
public static final Uri buildFolderUri(long folderId) {
            return ContentUris.withAppendedId(CONTENT_URI_DEFAULT_FOLDER, folderId);
        }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:02.338 -0500", hash_original_field = "CD7B3657D170A207BFDE84B227C5D40B", hash_generated_field = "C49481B8A13B3E38FA18723878F078ED")

        public static final Uri CONTENT_URI = Uri.withAppendedPath(AUTHORITY_URI, "bookmarks");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:02.340 -0500", hash_original_field = "2B97112B69A312B00DFCAACD8812E718", hash_generated_field = "C1599CAC8E285CA509E0AAD137651201")

        public static final Uri CONTENT_URI_DEFAULT_FOLDER =
                Uri.withAppendedPath(CONTENT_URI, "folder");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:02.343 -0500", hash_original_field = "04B543F86A93C21C44FEEACACA07EBE2", hash_generated_field = "E3CD60134A98C9D36C268C6756428168")

        public static final String PARAM_ACCOUNT_NAME = "acct_name";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:02.346 -0500", hash_original_field = "5F32A973E7D2C42105CE1F168EFC65F8", hash_generated_field = "964B613506D0EE33656370D7E1BAEFA1")

        public static final String PARAM_ACCOUNT_TYPE = "acct_type";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:02.351 -0500", hash_original_field = "9C05E5F57B0C5D10005E7783C9186AFA", hash_generated_field = "6D464FB6792D1C0FA243269B71B6B0E1")

        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/bookmark";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:02.353 -0500", hash_original_field = "CB337188E9618A473DFDA7CF18D2B5E8", hash_generated_field = "B59C9205A1E1BF21557C6B2CED0377A7")

        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/bookmark";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:02.356 -0500", hash_original_field = "A0E263659A42D6DA664572B5BC330940", hash_generated_field = "DEB578B0B8F93DE15B2F9D69BAF61489")

        public static final String QUERY_PARAMETER_SHOW_DELETED = "show_deleted";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:02.358 -0500", hash_original_field = "D7D1D0ED4CC9E04BE36DDBFF24B490B9", hash_generated_field = "B755FA40DF1DBC4330580EE1206DBD73")

        public static final String IS_FOLDER = "folder";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:02.360 -0500", hash_original_field = "36E6756C21EE6B27A26CABD969C5C180", hash_generated_field = "CE0348C32EED8A51DAB611A944FB3F92")

        public static final String PARENT = "parent";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:02.363 -0500", hash_original_field = "1CC5824EB824A4A5104A1071A323C8D4", hash_generated_field = "725EDAB51F1D7421047A0F00203E71B7")

        public static final String PARENT_SOURCE_ID = "parent_source";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:02.365 -0500", hash_original_field = "C86C97D3CD4D0ECA2A9CBEF3111BE2ED", hash_generated_field = "F03504D46D80E70B2B2FBACB64377D6D")

        public static final String POSITION = "position";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:02.369 -0500", hash_original_field = "45EA21A9EEA90DF008809A1A8EFAF2ED", hash_generated_field = "89B08837D8EF8BDD89C63D168A94651D")

        public static final String INSERT_AFTER = "insert_after";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:02.371 -0500", hash_original_field = "416421166CC05FA0329264E33E87AD01", hash_generated_field = "1092FB3A80C7E111B4FF2E46C7969261")

        public static final String INSERT_AFTER_SOURCE_ID = "insert_after_source";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:02.374 -0500", hash_original_field = "9F1ADC7BFB077F23E49F1BF468D79CA4", hash_generated_field = "E773D733F12130115F529FEE80E251A5")

        public static final String IS_DELETED = "deleted";
        /**
         * This utility class cannot be instantiated.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:02.336 -0500", hash_original_method = "AE207FC542F592796C7137A1F40A9FC2", hash_generated_method = "A79ADE4DE1D184572ED0C7C3E91386CD")
        
private Bookmarks() {}
    }


    
    public static final class Accounts {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:02.379 -0500", hash_original_field = "794B6192C53E9ECC4C05DB65201B19BC", hash_generated_field = "F05ADCBC4299E845D0DE19D5F81FDF47")

        public static final Uri CONTENT_URI =
                AUTHORITY_URI.buildUpon().appendPath("accounts").build();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:02.382 -0500", hash_original_field = "1CF1CD5E24D446348AA64A8330702BBB", hash_generated_field = "D878A0BAFEF2B9E22E2355A3C81DF7B8")

        public static final String ACCOUNT_NAME = "account_name";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:02.384 -0500", hash_original_field = "A4C0743C190F90FEE8AD653B0CB5195A", hash_generated_field = "665F37455A5EB6E4C64E8C9A4998A28A")

        public static final String ACCOUNT_TYPE = "account_type";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:02.386 -0500", hash_original_field = "348C6F54AD2EC3CC79213E9134674A80", hash_generated_field = "F2E46C39CEAF95C1F74689541D6217F8")

        public static final String ROOT_ID = "root_id";
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:29.043 -0400", hash_original_method = "E861E18FAAD07B872BEA69DAA31ED960", hash_generated_method = "E861E18FAAD07B872BEA69DAA31ED960")
        public Accounts ()
        {
            //Synthesized constructor
        }
    }


    
    public static final class History implements CommonColumns, HistoryColumns, ImageColumns {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:02.394 -0500", hash_original_field = "CBB02B8090ABD11ACEDB3F582D2659CD", hash_generated_field = "8F6F422DADF0DFB5E5A398B59F81E1C8")

        public static final Uri CONTENT_URI = Uri.withAppendedPath(AUTHORITY_URI, "history");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:02.396 -0500", hash_original_field = "DC1116D6BE3A1BB4CB2A37E16CD7484D", hash_generated_field = "215841B540AE2CC48EC371DA2BA57375")

        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/browser-history";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:02.400 -0500", hash_original_field = "BED8BC93BEC923C1D32D04475AD5A4A6", hash_generated_field = "D931739950813715D0764D24789A1D6E")

        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/browser-history";
        /**
         * This utility class cannot be instantiated.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:02.391 -0500", hash_original_method = "9A3C530B0BF357B0539558761B1AC70C", hash_generated_method = "988E0C7B6C13324742BC106865E82AEA")
        
private History() {}
    }


    
    public static final class Searches {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:02.407 -0500", hash_original_field = "7B85A876F43C6C2E7D1B6B06CDDFB3B7", hash_generated_field = "FF24A32B9829C11115FDBD2035181FF7")

        public static final Uri CONTENT_URI = Uri.withAppendedPath(AUTHORITY_URI, "searches");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:02.409 -0500", hash_original_field = "5C1DD6431C34C50412E783F614F97B93", hash_generated_field = "3E7D57590369674A5E081A6FB93F3743")

        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/searches";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:02.412 -0500", hash_original_field = "0F24E10AE0918094AE5E8B45A1F99390", hash_generated_field = "483B181809C73C0B5AA6B2B2EE3FBEAE")

        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/searches";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:02.414 -0500", hash_original_field = "6FDF2F856E52A2C35AACBF9AF8171666", hash_generated_field = "B34A1444880FA153E0220CFB867105F7")

        public static final String _ID = "_id";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:02.417 -0500", hash_original_field = "F9A3A3183BB01BC91F2419D4415C4CB0", hash_generated_field = "FED10D8306AFD8BF2F59B1EAF3D09D65")

        public static final String SEARCH = "search";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:02.419 -0500", hash_original_field = "5B6FCEF8C44CB783DFFC37049083A6ED", hash_generated_field = "FDAA1E4DCD8393137807C1AA22ED16F2")

        public static final String DATE = "date";
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:02.404 -0500", hash_original_method = "7529334193E0AAE11CAF3EB6D8429B6D", hash_generated_method = "6495D0160998CD8474CAF15BFBC02214")
        
private Searches() {}
    }


    
    public static final class SyncState implements SyncStateContract.Columns {

        /**
         * @see android.provider.SyncStateContract.Helpers#get
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:02.431 -0500", hash_original_method = "466578A19F0FCF2DD10FDB6DAFFC0887", hash_generated_method = "2968688090F0A89899005B639287D49D")
        
public static byte[] get(ContentProviderClient provider, Account account)
                throws RemoteException {
            return SyncStateContract.Helpers.get(provider, CONTENT_URI, account);
        }

        /**
         * @see android.provider.SyncStateContract.Helpers#get
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:02.434 -0500", hash_original_method = "B9E8FB5AB055D4E1E45E9949F3C016CF", hash_generated_method = "6E822DD6634A9EBA8F5FA49F5EB38784")
        
public static Pair<Uri, byte[]> getWithUri(ContentProviderClient provider, Account account)
                throws RemoteException {
            return SyncStateContract.Helpers.getWithUri(provider, CONTENT_URI, account);
        }

        /**
         * @see android.provider.SyncStateContract.Helpers#set
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:02.437 -0500", hash_original_method = "579F427E12689D3799FB7240CB2CED7E", hash_generated_method = "0929C6A0E720D5E2073DF205F65D7551")
        
public static void set(ContentProviderClient provider, Account account, byte[] data)
                throws RemoteException {
            SyncStateContract.Helpers.set(provider, CONTENT_URI, account, data);
        }

        /**
         * @see android.provider.SyncStateContract.Helpers#newSetOperation
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:02.439 -0500", hash_original_method = "4E10B60B39C26218926D7406FB7CC71E", hash_generated_method = "4874286873285082166E1414165C7F12")
        
public static ContentProviderOperation newSetOperation(Account account, byte[] data) {
            return SyncStateContract.Helpers.newSetOperation(CONTENT_URI, account, data);
        }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:02.427 -0500", hash_original_field = "E8C57D74C792F88386CA3DAD09DDB1BA", hash_generated_field = "B8243A9F992B1927826CEDCE0876B770")


        public static final String CONTENT_DIRECTORY =
                SyncStateContract.Constants.CONTENT_DIRECTORY;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:02.429 -0500", hash_original_field = "C1EA74B2428365CED3D656387FEA49B7", hash_generated_field = "D7D188013240FCCAF388869D2E2EBFDE")

        public static final Uri CONTENT_URI =
                Uri.withAppendedPath(AUTHORITY_URI, CONTENT_DIRECTORY);
        /**
         * This utility class cannot be instantiated
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:02.424 -0500", hash_original_method = "C3CB9524AE86EE634A43E203167EAA5A", hash_generated_method = "B49E3D8116D56A750AEF2EA2BBA629A3")
        
private SyncState() {}
    }


    
    public static final class Images implements ImageColumns {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:02.448 -0500", hash_original_field = "8C95442A5BA581DDA4838D9481963330", hash_generated_field = "D17D0AFDB034395CE800191266DC06B2")

        public static final Uri CONTENT_URI = Uri.withAppendedPath(AUTHORITY_URI, "images");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:02.450 -0500", hash_original_field = "A930FFE8F4AD85075220CD7E6940E450", hash_generated_field = "52E740C89D47AF48ECBA43E5E359ECAD")

        public static final String URL = "url_key";
        /**
         * This utility class cannot be instantiated
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:02.444 -0500", hash_original_method = "7ABD1F4BB750369FFBE0EAAD80629925", hash_generated_method = "C2B023356DF2D8423B86547092C71691")
        
private Images() {}
    }


    
    public static final class Combined implements CommonColumns, HistoryColumns, ImageColumns {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:02.457 -0500", hash_original_field = "82D02F41998C8D9693D6B51D3940DDCE", hash_generated_field = "E5846D12A80FEBBC2EE6D3A1124B69D3")

        public static final Uri CONTENT_URI = Uri.withAppendedPath(AUTHORITY_URI, "combined");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:02.460 -0500", hash_original_field = "797EC16E0B89F74C8E6D4741056E0547", hash_generated_field = "83F4618C13EFC94EC2212A60FCB8DBE4")

        public static final String IS_BOOKMARK = "bookmark";
        /**
         * This utility class cannot be instantiated
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:02.455 -0500", hash_original_method = "A486C536CC2BBF7E5EE5092C736031C8", hash_generated_method = "70FFFC2D075451B0F1CD7FCCB9EFC19E")
        
private Combined() {}
    }


    
    public static final class Settings {

        /**
         * Returns true if bookmark sync is enabled
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:02.476 -0500", hash_original_method = "43F228216BAE54D0FCDF4DEA936A6994", hash_generated_method = "2D27E6B01FD5503A17C0CE28F2EA1FAE")
        
static public boolean isSyncEnabled(Context context) {
            Cursor cursor = null;
            try {
                cursor = context.getContentResolver().query(CONTENT_URI, new String[] { VALUE },
                        KEY + "=?", new String[] { KEY_SYNC_ENABLED }, null);
                if (cursor == null || !cursor.moveToFirst()) {
                    return false;
                }
                return cursor.getInt(0) != 0;
            } finally {
                if (cursor != null) cursor.close();
            }
        }

        /**
         * Sets the bookmark sync enabled setting.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:02.479 -0500", hash_original_method = "49EB5FA9A3B8CA38E9DEEF930223E7B9", hash_generated_method = "AA10285F7CFC2DD48F238E85947493B0")
        
static public void setSyncEnabled(Context context, boolean enabled) {
            ContentValues values = new ContentValues();
            values.put(KEY, KEY_SYNC_ENABLED);
            values.put(VALUE, enabled ? 1 : 0);
            context.getContentResolver().insert(CONTENT_URI, values);
        }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:02.467 -0500", hash_original_field = "188B5E40BA99617868308108494CFAB2", hash_generated_field = "C7297F3C14DD54EEFD43481001C6C3EF")

        public static final Uri CONTENT_URI = Uri.withAppendedPath(AUTHORITY_URI, "settings");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:02.469 -0500", hash_original_field = "860A5A4B293415F382F8DB5A3AFC31D8", hash_generated_field = "673CAEFD1E359D6E7B1DBA75A7CF8129")

        public static final String KEY = "key";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:02.472 -0500", hash_original_field = "A2895FC88154CFB96E0F519FA521FF35", hash_generated_field = "5D8DAB0D387706C30A46713A8E60D5A3")

        public static final String VALUE = "value";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:02.474 -0500", hash_original_field = "C5AC9DF676F8F1686D7D0D848E8A42F0", hash_generated_field = "6FB4CE760D58D24F0633A8BBC05A485A")

        public static final String KEY_SYNC_ENABLED = "sync_enabled";
        /**
         * This utility class cannot be instantiated
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:02.464 -0500", hash_original_method = "E49204FD271E895B10D86A1AFEA21B04", hash_generated_method = "59B3C6A592AE63BEE2BC1CC1723B36DF")
        
private Settings() {}
    }


    
    interface BaseSyncColumns {
        
        public static final String SYNC1 = "sync1";
        
        public static final String SYNC2 = "sync2";
        
        public static final String SYNC3 = "sync3";
        
        public static final String SYNC4 = "sync4";
        
        public static final String SYNC5 = "sync5";
    }
    
    interface SyncColumns extends BaseSyncColumns {
        
        public static final String ACCOUNT_NAME = "account_name";

        
        public static final String ACCOUNT_TYPE = "account_type";

        
        public static final String SOURCE_ID = "sourceid";

        
        public static final String VERSION = "version";

        
        public static final String DIRTY = "dirty";

        
        public static final String DATE_MODIFIED = "modified";
    }
    
    interface CommonColumns {
        
        public static final String _ID = "_id";

        
        public static final String URL = "url";

        
        public static final String TITLE = "title";

        
        public static final String DATE_CREATED = "created";
    }
    
    interface ImageColumns {
        
        public static final String FAVICON = "favicon";

        
        public static final String THUMBNAIL = "thumbnail";

        
        public static final String TOUCH_ICON = "touch_icon";
    }
    
    interface HistoryColumns {
        
        public static final String DATE_LAST_VISITED = "date";

        
        public static final String VISITS = "visits";

        public static final String USER_ENTERED = "user_entered";
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:02.285 -0500", hash_original_field = "1D115A05DC7E49A1F1C479FF10C36F87", hash_generated_field = "B1D8562AF60924B20700DDD648EE3109")

    public static final Uri AUTHORITY_URI = Uri.parse("content://" + AUTHORITY);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:02.287 -0500", hash_original_field = "65F0650BF967CAA3F47B71C9DCE7E498", hash_generated_field = "644CE73EB8766FA330BF3C4B8E384D0A")

    public static final String CALLER_IS_SYNCADAPTER = "caller_is_syncadapter";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:02.289 -0500", hash_original_field = "C12E5880AB5C8C76E7ED58FB69E802FB", hash_generated_field = "A01413BEB906B665DEC43D8D0EEFB30C")

    public static final String PARAM_LIMIT = "limit";
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:29.039 -0400", hash_original_method = "826484E4F7C2520B20953309D7672DA9", hash_generated_method = "826484E4F7C2520B20953309D7672DA9")
    public BrowserContract ()
    {
        //Synthesized constructor
    }
}

