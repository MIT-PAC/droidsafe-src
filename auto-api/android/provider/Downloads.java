package android.provider;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.app.DownloadManager;
import android.net.NetworkPolicyManager;
import android.net.Uri;

public final class Downloads {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.933 -0400", hash_original_method = "9B4A677720B6322F28A15E895C99B092", hash_generated_method = "BCFC969F167E5171E2BDC38F7DDB8203")
    @DSModeled(DSC.SAFE)
    private Downloads() {
        // ---------- Original Method ----------
    }

    
    public static final class Impl implements BaseColumns {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.933 -0400", hash_original_method = "BBF0D9B1CF16C5FC7549DABF49EBEFE0", hash_generated_method = "3F538DB11C86ADB27843AD5963111DF7")
        @DSModeled(DSC.SAFE)
        private Impl() {
            // ---------- Original Method ----------
        }

        
                public static boolean isStatusInformational(int status) {
            return (status >= 100 && status < 200);
        }

        
                public static boolean isStatusSuccess(int status) {
            return (status >= 200 && status < 300);
        }

        
                public static boolean isStatusError(int status) {
            return (status >= 400 && status < 600);
        }

        
                public static boolean isStatusClientError(int status) {
            return (status >= 400 && status < 500);
        }

        
                public static boolean isStatusServerError(int status) {
            return (status >= 500 && status < 600);
        }

        
                public static boolean isNotificationToBeDisplayed(int visibility) {
            return visibility == DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED ||
                    visibility == DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_ONLY_COMPLETION;
        }

        
                public static boolean isStatusCompleted(int status) {
            return (status >= 200 && status < 300) || (status >= 400 && status < 600);
        }

        
        public static class RequestHeaders {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.935 -0400", hash_original_method = "3074B2C9C6E140A20CCE95E57FA158C3", hash_generated_method = "3074B2C9C6E140A20CCE95E57FA158C3")
                        public RequestHeaders ()
            {
            }


            public static final String HEADERS_DB_TABLE = "request_headers";
            public static final String COLUMN_DOWNLOAD_ID = "download_id";
            public static final String COLUMN_HEADER = "header";
            public static final String COLUMN_VALUE = "value";
            public static final String URI_SEGMENT = "headers";
            public static final String INSERT_KEY_PREFIX = "http_header_";
        }


        
        public static final String PERMISSION_ACCESS = "android.permission.ACCESS_DOWNLOAD_MANAGER";
        public static final String PERMISSION_ACCESS_ADVANCED =
                "android.permission.ACCESS_DOWNLOAD_MANAGER_ADVANCED";
        public static final String PERMISSION_ACCESS_ALL =
                "android.permission.ACCESS_ALL_DOWNLOADS";
        public static final String PERMISSION_CACHE = "android.permission.ACCESS_CACHE_FILESYSTEM";
        public static final String PERMISSION_SEND_INTENTS =
                "android.permission.SEND_DOWNLOAD_COMPLETED_INTENTS";
        public static final String PERMISSION_CACHE_NON_PURGEABLE =
                "android.permission.DOWNLOAD_CACHE_NON_PURGEABLE";
        public static final String PERMISSION_NO_NOTIFICATION =
                "android.permission.DOWNLOAD_WITHOUT_NOTIFICATION";
        public static final Uri CONTENT_URI =
                Uri.parse("content://downloads/my_downloads");
        public static final Uri ALL_DOWNLOADS_CONTENT_URI =
                Uri.parse("content://downloads/all_downloads");
        public static final String PUBLICLY_ACCESSIBLE_DOWNLOADS_URI_SEGMENT = "public_downloads";
        public static final Uri PUBLICLY_ACCESSIBLE_DOWNLOADS_URI =
                Uri.parse("content://downloads/" + PUBLICLY_ACCESSIBLE_DOWNLOADS_URI_SEGMENT);
        public static final String ACTION_DOWNLOAD_COMPLETED =
                "android.intent.action.DOWNLOAD_COMPLETED";
        public static final String ACTION_NOTIFICATION_CLICKED =
                "android.intent.action.DOWNLOAD_NOTIFICATION_CLICKED";
        public static final String COLUMN_URI = "uri";
        public static final String COLUMN_APP_DATA = "entity";
        public static final String COLUMN_NO_INTEGRITY = "no_integrity";
        public static final String COLUMN_FILE_NAME_HINT = "hint";
        public static final String _DATA = "_data";
        public static final String COLUMN_MIME_TYPE = "mimetype";
        public static final String COLUMN_DESTINATION = "destination";
        public static final String COLUMN_VISIBILITY = "visibility";
        public static final String COLUMN_CONTROL = "control";
        public static final String COLUMN_STATUS = "status";
        public static final String COLUMN_LAST_MODIFICATION = "lastmod";
        public static final String COLUMN_NOTIFICATION_PACKAGE = "notificationpackage";
        public static final String COLUMN_NOTIFICATION_CLASS = "notificationclass";
        public static final String COLUMN_NOTIFICATION_EXTRAS = "notificationextras";
        public static final String COLUMN_COOKIE_DATA = "cookiedata";
        public static final String COLUMN_USER_AGENT = "useragent";
        public static final String COLUMN_REFERER = "referer";
        public static final String COLUMN_TOTAL_BYTES = "total_bytes";
        public static final String COLUMN_CURRENT_BYTES = "current_bytes";
        public static final String COLUMN_OTHER_UID = "otheruid";
        public static final String COLUMN_TITLE = "title";
        public static final String COLUMN_DESCRIPTION = "description";
        public static final String COLUMN_IS_PUBLIC_API = "is_public_api";
        public static final String COLUMN_ALLOW_ROAMING = "allow_roaming";
        public static final String COLUMN_ALLOWED_NETWORK_TYPES = "allowed_network_types";
        public static final String COLUMN_IS_VISIBLE_IN_DOWNLOADS_UI = "is_visible_in_downloads_ui";
        public static final String COLUMN_BYPASS_RECOMMENDED_SIZE_LIMIT =
            "bypass_recommended_size_limit";
        public static final String COLUMN_DELETED = "deleted";
        public static final String COLUMN_MEDIAPROVIDER_URI = "mediaprovider_uri";
        public static final String COLUMN_MEDIA_SCANNED = "scanned";
        public static final String COLUMN_ERROR_MSG = "errorMsg";
        public static final String COLUMN_LAST_UPDATESRC = "lastUpdateSrc";
        public static final int LAST_UPDATESRC_NOT_RELEVANT = 0;
        public static final int LAST_UPDATESRC_DONT_NOTIFY_DOWNLOADSVC = 1;
        public static final int DESTINATION_EXTERNAL = 0;
        public static final int DESTINATION_CACHE_PARTITION = 1;
        public static final int DESTINATION_CACHE_PARTITION_PURGEABLE = 2;
        public static final int DESTINATION_CACHE_PARTITION_NOROAMING = 3;
        public static final int DESTINATION_FILE_URI = 4;
        public static final int DESTINATION_SYSTEMCACHE_PARTITION = 5;
        public static final int DESTINATION_NON_DOWNLOADMANAGER_DOWNLOAD = 6;
        public static final int CONTROL_RUN = 0;
        public static final int CONTROL_PAUSED = 1;
        public static final int STATUS_PENDING = 190;
        public static final int STATUS_RUNNING = 192;
        public static final int STATUS_PAUSED_BY_APP = 193;
        public static final int STATUS_WAITING_TO_RETRY = 194;
        public static final int STATUS_WAITING_FOR_NETWORK = 195;
        public static final int STATUS_QUEUED_FOR_WIFI = 196;
        public static final int STATUS_INSUFFICIENT_SPACE_ERROR = 198;
        public static final int STATUS_DEVICE_NOT_FOUND_ERROR = 199;
        public static final int STATUS_SUCCESS = 200;
        public static final int STATUS_BAD_REQUEST = 400;
        public static final int STATUS_NOT_ACCEPTABLE = 406;
        public static final int STATUS_LENGTH_REQUIRED = 411;
        public static final int STATUS_PRECONDITION_FAILED = 412;
        public static final int MIN_ARTIFICIAL_ERROR_STATUS = 488;
        public static final int STATUS_FILE_ALREADY_EXISTS_ERROR = 488;
        public static final int STATUS_CANNOT_RESUME = 489;
        public static final int STATUS_CANCELED = 490;
        public static final int STATUS_UNKNOWN_ERROR = 491;
        public static final int STATUS_FILE_ERROR = 492;
        public static final int STATUS_UNHANDLED_REDIRECT = 493;
        public static final int STATUS_UNHANDLED_HTTP_CODE = 494;
        public static final int STATUS_HTTP_DATA_ERROR = 495;
        public static final int STATUS_HTTP_EXCEPTION = 496;
        public static final int STATUS_TOO_MANY_REDIRECTS = 497;
        public static final int STATUS_BLOCKED = 498;
        public static final int VISIBILITY_VISIBLE = DownloadManager.Request.VISIBILITY_VISIBLE;
        public static final int VISIBILITY_VISIBLE_NOTIFY_COMPLETED =
                DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED;
        public static final int VISIBILITY_HIDDEN = DownloadManager.Request.VISIBILITY_HIDDEN;
    }


    
}

