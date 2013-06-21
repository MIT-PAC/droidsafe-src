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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.816 -0400", hash_original_method = "FF080E050CC891BDDAB9B7A0CA85FB81", hash_generated_method = "FF080E050CC891BDDAB9B7A0CA85FB81")
        public BrowserContract ()
    {
    }


    public static final class ChromeSyncColumns {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.817 -0400", hash_original_method = "FBBD23C5251F402AEB9A227B34F9A614", hash_generated_method = "BEC06E194004959088D683347529A16B")
        @DSModeled(DSC.SAFE)
        private ChromeSyncColumns() {
            // ---------- Original Method ----------
        }

        
        public static final String SERVER_UNIQUE = BaseSyncColumns.SYNC3;
        public static final String FOLDER_NAME_ROOT = "google_chrome";
        public static final String FOLDER_NAME_BOOKMARKS = "google_chrome_bookmarks";
        public static final String FOLDER_NAME_BOOKMARKS_BAR = "bookmark_bar";
        public static final String FOLDER_NAME_OTHER_BOOKMARKS = "other_bookmarks";
        public static final String CLIENT_UNIQUE = BaseSyncColumns.SYNC4;
    }


    
    public static final class Bookmarks implements CommonColumns, ImageColumns, SyncColumns {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.817 -0400", hash_original_method = "AE207FC542F592796C7137A1F40A9FC2", hash_generated_method = "9D9D5ADD5386AE15B67A1E746F9B5A2D")
        @DSModeled(DSC.SAFE)
        private Bookmarks() {
            // ---------- Original Method ----------
        }

        
                public static final Uri buildFolderUri(long folderId) {
            return ContentUris.withAppendedId(CONTENT_URI_DEFAULT_FOLDER, folderId);
        }

        
        public static final Uri CONTENT_URI = Uri.withAppendedPath(AUTHORITY_URI, "bookmarks");
        public static final Uri CONTENT_URI_DEFAULT_FOLDER =
                Uri.withAppendedPath(CONTENT_URI, "folder");
        public static final String PARAM_ACCOUNT_NAME = "acct_name";
        public static final String PARAM_ACCOUNT_TYPE = "acct_type";
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/bookmark";
        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/bookmark";
        public static final String QUERY_PARAMETER_SHOW_DELETED = "show_deleted";
        public static final String IS_FOLDER = "folder";
        public static final String PARENT = "parent";
        public static final String PARENT_SOURCE_ID = "parent_source";
        public static final String POSITION = "position";
        public static final String INSERT_AFTER = "insert_after";
        public static final String INSERT_AFTER_SOURCE_ID = "insert_after_source";
        public static final String IS_DELETED = "deleted";
    }


    
    public static final class Accounts {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.817 -0400", hash_original_method = "ADB4BC07FBF18D574DEA2368EAE655B5", hash_generated_method = "ADB4BC07FBF18D574DEA2368EAE655B5")
                public Accounts ()
        {
        }


        public static final Uri CONTENT_URI =
                AUTHORITY_URI.buildUpon().appendPath("accounts").build();
        public static final String ACCOUNT_NAME = "account_name";
        public static final String ACCOUNT_TYPE = "account_type";
        public static final String ROOT_ID = "root_id";
    }


    
    public static final class History implements CommonColumns, HistoryColumns, ImageColumns {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.818 -0400", hash_original_method = "9A3C530B0BF357B0539558761B1AC70C", hash_generated_method = "AC080925E41FF1CF6AA63820F2EC55A2")
        @DSModeled(DSC.SAFE)
        private History() {
            // ---------- Original Method ----------
        }

        
        public static final Uri CONTENT_URI = Uri.withAppendedPath(AUTHORITY_URI, "history");
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/browser-history";
        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/browser-history";
    }


    
    public static final class Searches {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.818 -0400", hash_original_method = "7529334193E0AAE11CAF3EB6D8429B6D", hash_generated_method = "9C96E7D9170F02C650F71A1C65F54A71")
        @DSModeled(DSC.SAFE)
        private Searches() {
            // ---------- Original Method ----------
        }

        
        public static final Uri CONTENT_URI = Uri.withAppendedPath(AUTHORITY_URI, "searches");
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/searches";
        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/searches";
        public static final String _ID = "_id";
        public static final String SEARCH = "search";
        public static final String DATE = "date";
    }


    
    public static final class SyncState implements SyncStateContract.Columns {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.819 -0400", hash_original_method = "C3CB9524AE86EE634A43E203167EAA5A", hash_generated_method = "7C56DAB1CC85D73593C30D4266013E44")
        @DSModeled(DSC.SAFE)
        private SyncState() {
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

        
        public static final String CONTENT_DIRECTORY =
                SyncStateContract.Constants.CONTENT_DIRECTORY;
        public static final Uri CONTENT_URI =
                Uri.withAppendedPath(AUTHORITY_URI, CONTENT_DIRECTORY);
    }


    
    public static final class Images implements ImageColumns {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.820 -0400", hash_original_method = "7ABD1F4BB750369FFBE0EAAD80629925", hash_generated_method = "64BCC625F43DCAD7D91867C70D1FE6C2")
        @DSModeled(DSC.SAFE)
        private Images() {
            // ---------- Original Method ----------
        }

        
        public static final Uri CONTENT_URI = Uri.withAppendedPath(AUTHORITY_URI, "images");
        public static final String URL = "url_key";
    }


    
    public static final class Combined implements CommonColumns, HistoryColumns, ImageColumns {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.820 -0400", hash_original_method = "A486C536CC2BBF7E5EE5092C736031C8", hash_generated_method = "D09B023203FD1ACF44197D146AB0F998")
        @DSModeled(DSC.SAFE)
        private Combined() {
            // ---------- Original Method ----------
        }

        
        public static final Uri CONTENT_URI = Uri.withAppendedPath(AUTHORITY_URI, "combined");
        public static final String IS_BOOKMARK = "bookmark";
    }


    
    public static final class Settings {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.820 -0400", hash_original_method = "E49204FD271E895B10D86A1AFEA21B04", hash_generated_method = "2C16D3C86A761A9DF5E58231442F813C")
        @DSModeled(DSC.SAFE)
        private Settings() {
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

        
        public static final Uri CONTENT_URI = Uri.withAppendedPath(AUTHORITY_URI, "settings");
        public static final String KEY = "key";
        public static final String VALUE = "value";
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
    
    public static final String AUTHORITY = "com.android.browser";
    public static final Uri AUTHORITY_URI = Uri.parse("content://" + AUTHORITY);
    public static final String CALLER_IS_SYNCADAPTER = "caller_is_syncadapter";
    public static final String PARAM_LIMIT = "limit";
}

