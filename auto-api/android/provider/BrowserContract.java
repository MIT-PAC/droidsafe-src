package android.provider;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.accounts.Account;
import android.content.ContentProviderClient;
import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.RemoteException;
import android.util.Pair;

public class BrowserContract {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.211 -0400", hash_original_method = "826484E4F7C2520B20953309D7672DA9", hash_generated_method = "826484E4F7C2520B20953309D7672DA9")
    public BrowserContract ()
    {
        //Synthesized constructor
    }


    public static final class ChromeSyncColumns {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.212 -0400", hash_original_method = "FBBD23C5251F402AEB9A227B34F9A614", hash_generated_method = "BEC06E194004959088D683347529A16B")
        private  ChromeSyncColumns() {
            // ---------- Original Method ----------
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.212 -0400", hash_original_field = "AADC068E426BBECB909A19BA312B6DEF", hash_generated_field = "BA004DD6C732A9DE7AE9F50F0365E343")

        public static final String SERVER_UNIQUE = BaseSyncColumns.SYNC3;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.212 -0400", hash_original_field = "89595D9FF2C68352C54E5757401C765A", hash_generated_field = "8F8B59E19C1BFC825B3CFF4F6E7D2455")

        public static final String FOLDER_NAME_ROOT = "google_chrome";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.212 -0400", hash_original_field = "F278E28DFFFBA0131C336810C803D4F1", hash_generated_field = "7D7F7FF342C4D3964B81AA9C29FE0797")

        public static final String FOLDER_NAME_BOOKMARKS = "google_chrome_bookmarks";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.212 -0400", hash_original_field = "5E75A79C128F948D56EEEB61A837E512", hash_generated_field = "4D7461C20500A0C2B9C0C2ABF53B81C4")

        public static final String FOLDER_NAME_BOOKMARKS_BAR = "bookmark_bar";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.212 -0400", hash_original_field = "EEB7D03BE833C855FFD424ED422B7EB0", hash_generated_field = "C3C745E3EDE408E69F187E5C6F906CD1")

        public static final String FOLDER_NAME_OTHER_BOOKMARKS = "other_bookmarks";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.212 -0400", hash_original_field = "3F91FE167573C83EC5ADE1145C34917C", hash_generated_field = "489183F01776E5FE54CC501794239F31")

        public static final String CLIENT_UNIQUE = BaseSyncColumns.SYNC4;
    }


    
    public static final class Bookmarks implements CommonColumns, ImageColumns, SyncColumns {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.212 -0400", hash_original_method = "AE207FC542F592796C7137A1F40A9FC2", hash_generated_method = "9D9D5ADD5386AE15B67A1E746F9B5A2D")
        private  Bookmarks() {
            // ---------- Original Method ----------
        }

        
                public static final Uri buildFolderUri(long folderId) {
            return ContentUris.withAppendedId(CONTENT_URI_DEFAULT_FOLDER, folderId);
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.213 -0400", hash_original_field = "F04F2461202F6F6A5371AD13A30EFE64", hash_generated_field = "C49481B8A13B3E38FA18723878F078ED")

        public static final Uri CONTENT_URI = Uri.withAppendedPath(AUTHORITY_URI, "bookmarks");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.213 -0400", hash_original_field = "51D51394A68121851DE50A1A78834A1E", hash_generated_field = "C1599CAC8E285CA509E0AAD137651201")

        public static final Uri CONTENT_URI_DEFAULT_FOLDER =
                Uri.withAppendedPath(CONTENT_URI, "folder");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.213 -0400", hash_original_field = "42C7D8E31A1A2E5FCF7366E0F323F8FF", hash_generated_field = "E3CD60134A98C9D36C268C6756428168")

        public static final String PARAM_ACCOUNT_NAME = "acct_name";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.213 -0400", hash_original_field = "163503839D8B67565D1FEFF577D6214B", hash_generated_field = "964B613506D0EE33656370D7E1BAEFA1")

        public static final String PARAM_ACCOUNT_TYPE = "acct_type";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.213 -0400", hash_original_field = "938EE3182EBBFC61F3C0B51CAB28EB55", hash_generated_field = "6D464FB6792D1C0FA243269B71B6B0E1")

        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/bookmark";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.213 -0400", hash_original_field = "EA1D4F87CE9C84AD7DB51F3C1E627A0E", hash_generated_field = "B59C9205A1E1BF21557C6B2CED0377A7")

        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/bookmark";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.213 -0400", hash_original_field = "9D89CFEA256F88766D57E690D181212D", hash_generated_field = "DEB578B0B8F93DE15B2F9D69BAF61489")

        public static final String QUERY_PARAMETER_SHOW_DELETED = "show_deleted";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.213 -0400", hash_original_field = "52AC8AC41C1045F44A90A19BD6E8DA5C", hash_generated_field = "B755FA40DF1DBC4330580EE1206DBD73")

        public static final String IS_FOLDER = "folder";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.213 -0400", hash_original_field = "6ECCC3EF14363CC24EABC318ECBCC848", hash_generated_field = "CE0348C32EED8A51DAB611A944FB3F92")

        public static final String PARENT = "parent";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.213 -0400", hash_original_field = "32ED669DCC9A04FF02CD5A9C23B29A83", hash_generated_field = "725EDAB51F1D7421047A0F00203E71B7")

        public static final String PARENT_SOURCE_ID = "parent_source";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.213 -0400", hash_original_field = "F2140AED85CBAFD31943340845B76C75", hash_generated_field = "F03504D46D80E70B2B2FBACB64377D6D")

        public static final String POSITION = "position";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.219 -0400", hash_original_field = "6BD97BBDBC3BEBC1D63446557A9E1BB1", hash_generated_field = "89B08837D8EF8BDD89C63D168A94651D")

        public static final String INSERT_AFTER = "insert_after";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.219 -0400", hash_original_field = "DA62864F9E5EE9DE44654CAF6A11A6E2", hash_generated_field = "1092FB3A80C7E111B4FF2E46C7969261")

        public static final String INSERT_AFTER_SOURCE_ID = "insert_after_source";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.219 -0400", hash_original_field = "75ABB5DF18D8B3B25F1AD4F23D94D229", hash_generated_field = "E773D733F12130115F529FEE80E251A5")

        public static final String IS_DELETED = "deleted";
    }


    
    public static final class Accounts {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.220 -0400", hash_original_method = "E861E18FAAD07B872BEA69DAA31ED960", hash_generated_method = "E861E18FAAD07B872BEA69DAA31ED960")
        public Accounts ()
        {
            //Synthesized constructor
        }


        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.220 -0400", hash_original_field = "53FB4340B9EC2161E27553CDAF4FB69D", hash_generated_field = "F05ADCBC4299E845D0DE19D5F81FDF47")

        public static final Uri CONTENT_URI =
                AUTHORITY_URI.buildUpon().appendPath("accounts").build();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.220 -0400", hash_original_field = "6315A9962CD6F1381AC746291BB0B5AC", hash_generated_field = "D878A0BAFEF2B9E22E2355A3C81DF7B8")

        public static final String ACCOUNT_NAME = "account_name";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.220 -0400", hash_original_field = "565FDAEE22FB804C99C2A4FA562DCB09", hash_generated_field = "665F37455A5EB6E4C64E8C9A4998A28A")

        public static final String ACCOUNT_TYPE = "account_type";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.220 -0400", hash_original_field = "D89AF53F599F6B4786BE1096C4E6E943", hash_generated_field = "F2E46C39CEAF95C1F74689541D6217F8")

        public static final String ROOT_ID = "root_id";
    }


    
    public static final class History implements CommonColumns, HistoryColumns, ImageColumns {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.237 -0400", hash_original_method = "9A3C530B0BF357B0539558761B1AC70C", hash_generated_method = "AC080925E41FF1CF6AA63820F2EC55A2")
        private  History() {
            // ---------- Original Method ----------
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.237 -0400", hash_original_field = "C043AA0535952138C2241B58CBA7A004", hash_generated_field = "8F6F422DADF0DFB5E5A398B59F81E1C8")

        public static final Uri CONTENT_URI = Uri.withAppendedPath(AUTHORITY_URI, "history");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.237 -0400", hash_original_field = "F6C78D0679EB7E7C70019C1132EA53F5", hash_generated_field = "215841B540AE2CC48EC371DA2BA57375")

        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/browser-history";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.237 -0400", hash_original_field = "4C513FB130F1A4E67423DD80C663481D", hash_generated_field = "D931739950813715D0764D24789A1D6E")

        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/browser-history";
    }


    
    public static final class Searches {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.238 -0400", hash_original_method = "7529334193E0AAE11CAF3EB6D8429B6D", hash_generated_method = "9C96E7D9170F02C650F71A1C65F54A71")
        private  Searches() {
            // ---------- Original Method ----------
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.238 -0400", hash_original_field = "1DCC967533E32404340D049AB9782268", hash_generated_field = "FF24A32B9829C11115FDBD2035181FF7")

        public static final Uri CONTENT_URI = Uri.withAppendedPath(AUTHORITY_URI, "searches");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.238 -0400", hash_original_field = "3A34F82826C438ED1322970343A365BF", hash_generated_field = "3E7D57590369674A5E081A6FB93F3743")

        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/searches";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.238 -0400", hash_original_field = "CB2ABBD57B1ED804A96B66B16A86D4E2", hash_generated_field = "483B181809C73C0B5AA6B2B2EE3FBEAE")

        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/searches";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.238 -0400", hash_original_field = "1D76A1C4932B9BE76F07C85A41B71D02", hash_generated_field = "B34A1444880FA153E0220CFB867105F7")

        public static final String _ID = "_id";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.238 -0400", hash_original_field = "A4D3382BC0DFD72731E9EE63C90DA839", hash_generated_field = "FED10D8306AFD8BF2F59B1EAF3D09D65")

        public static final String SEARCH = "search";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.238 -0400", hash_original_field = "F0E69C8EA78964FE5493D0AE61D90B08", hash_generated_field = "FDAA1E4DCD8393137807C1AA22ED16F2")

        public static final String DATE = "date";
    }


    
    public static final class SyncState implements SyncStateContract.Columns {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.241 -0400", hash_original_method = "C3CB9524AE86EE634A43E203167EAA5A", hash_generated_method = "7C56DAB1CC85D73593C30D4266013E44")
        private  SyncState() {
            // ---------- Original Method ----------
        }

        
                public static byte[] get(ContentProviderClient provider, Account account) throws RemoteException {
            return SyncStateContract.Helpers.get(provider, CONTENT_URI, account);
        }

        
                public static Pair<Uri, byte[]> getWithUri(ContentProviderClient provider, Account account) throws RemoteException {
            return SyncStateContract.Helpers.getWithUri(provider, CONTENT_URI, account);
        }

        
                public static void set(ContentProviderClient provider, Account account, byte[] data) throws RemoteException {
            SyncStateContract.Helpers.set(provider, CONTENT_URI, account, data);
        }

        
                public static ContentProviderOperation newSetOperation(Account account, byte[] data) {
            return SyncStateContract.Helpers.newSetOperation(CONTENT_URI, account, data);
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.242 -0400", hash_original_field = "FC07B3975EDE6E134B03F9A154159E24", hash_generated_field = "B8243A9F992B1927826CEDCE0876B770")

        public static final String CONTENT_DIRECTORY =
                SyncStateContract.Constants.CONTENT_DIRECTORY;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.242 -0400", hash_original_field = "2C3AB54DE75FF386983DCDD52DECAD40", hash_generated_field = "D7D188013240FCCAF388869D2E2EBFDE")

        public static final Uri CONTENT_URI =
                Uri.withAppendedPath(AUTHORITY_URI, CONTENT_DIRECTORY);
    }


    
    public static final class Images implements ImageColumns {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.243 -0400", hash_original_method = "7ABD1F4BB750369FFBE0EAAD80629925", hash_generated_method = "64BCC625F43DCAD7D91867C70D1FE6C2")
        private  Images() {
            // ---------- Original Method ----------
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.243 -0400", hash_original_field = "AB94D3E2351087CCD3FF9B02988DE02D", hash_generated_field = "D17D0AFDB034395CE800191266DC06B2")

        public static final Uri CONTENT_URI = Uri.withAppendedPath(AUTHORITY_URI, "images");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.243 -0400", hash_original_field = "579992EE2B9E192A56F01D0182D98D69", hash_generated_field = "52E740C89D47AF48ECBA43E5E359ECAD")

        public static final String URL = "url_key";
    }


    
    public static final class Combined implements CommonColumns, HistoryColumns, ImageColumns {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.243 -0400", hash_original_method = "A486C536CC2BBF7E5EE5092C736031C8", hash_generated_method = "D09B023203FD1ACF44197D146AB0F998")
        private  Combined() {
            // ---------- Original Method ----------
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.243 -0400", hash_original_field = "6330EB2FF7C34CCEB420A102A5771A28", hash_generated_field = "E5846D12A80FEBBC2EE6D3A1124B69D3")

        public static final Uri CONTENT_URI = Uri.withAppendedPath(AUTHORITY_URI, "combined");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.243 -0400", hash_original_field = "F29F253ED108DF6FDA023E70D43FD1ED", hash_generated_field = "83F4618C13EFC94EC2212A60FCB8DBE4")

        public static final String IS_BOOKMARK = "bookmark";
    }


    
    public static final class Settings {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.247 -0400", hash_original_method = "E49204FD271E895B10D86A1AFEA21B04", hash_generated_method = "2C16D3C86A761A9DF5E58231442F813C")
        private  Settings() {
            // ---------- Original Method ----------
        }

        
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

        
                static public void setSyncEnabled(Context context, boolean enabled) {
            ContentValues values = new ContentValues();
            values.put(KEY, KEY_SYNC_ENABLED);
            values.put(VALUE, enabled ? 1 : 0);
            context.getContentResolver().insert(CONTENT_URI, values);
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.247 -0400", hash_original_field = "C4C43E73659E4B461BEA20ECD306D47C", hash_generated_field = "C7297F3C14DD54EEFD43481001C6C3EF")

        public static final Uri CONTENT_URI = Uri.withAppendedPath(AUTHORITY_URI, "settings");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.247 -0400", hash_original_field = "11F8A4C7768A8C6793592BD59E206D61", hash_generated_field = "673CAEFD1E359D6E7B1DBA75A7CF8129")

        public static final String KEY = "key";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.247 -0400", hash_original_field = "E2F29D4CBE5FD8C9FB6E536F08014752", hash_generated_field = "5D8DAB0D387706C30A46713A8E60D5A3")

        public static final String VALUE = "value";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.247 -0400", hash_original_field = "895AE0F09C4B5BA019B7D0BFDC3DCCC1", hash_generated_field = "6FB4CE760D58D24F0633A8BBC05A485A")

        public static final String KEY_SYNC_ENABLED = "sync_enabled";
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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.253 -0400", hash_original_field = "EFB48F541BE18D9B71E860C6205E9CB3", hash_generated_field = "3226F8D573C55538143AADDEDE9BEDF1")

    public static final String AUTHORITY = "com.android.browser";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.254 -0400", hash_original_field = "55E96C26125757F0C1CE97A122A8192C", hash_generated_field = "B1D8562AF60924B20700DDD648EE3109")

    public static final Uri AUTHORITY_URI = Uri.parse("content://" + AUTHORITY);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.254 -0400", hash_original_field = "B364F080B56F7180EA743D0D5C83FC49", hash_generated_field = "644CE73EB8766FA330BF3C4B8E384D0A")

    public static final String CALLER_IS_SYNCADAPTER = "caller_is_syncadapter";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.254 -0400", hash_original_field = "6604F0EA1106B724943719E44DD8E54F", hash_generated_field = "A01413BEB906B665DEC43D8D0EEFB30C")

    public static final String PARAM_LIMIT = "limit";
}

