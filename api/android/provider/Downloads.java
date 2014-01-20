package android.provider;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.app.DownloadManager;
import android.net.Uri;

public final class Downloads {
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:56.203 -0500", hash_original_method = "9B4A677720B6322F28A15E895C99B092", hash_generated_method = "4EDA36C3C41965990B9DBE385624F13F")
    
private Downloads() {}
    
    public static final class Impl implements BaseColumns {

        /*
         * Lists the states that the download manager can set on a download
         * to notify applications of the download progress.
         * The codes follow the HTTP families:<br>
         * 1xx: informational<br>
         * 2xx: success<br>
         * 3xx: redirects (not used by the download manager)<br>
         * 4xx: client errors<br>
         * 5xx: server errors
         */

        /**
         * Returns whether the status is informational (i.e. 1xx).
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:56.357 -0500", hash_original_method = "A8312771025DBE8D4F255A5056997C06", hash_generated_method = "13467E97E20DA612E52BB1C5D9E3ECF2")
        
public static boolean isStatusInformational(int status) {
            return (status >= 100 && status < 200);
        }

        /**
         * Returns whether the status is a success (i.e. 2xx).
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:56.359 -0500", hash_original_method = "C166F600410D67F2CE19D27C7CE50EE0", hash_generated_method = "B19DF6F3311959551E5DC9F49D6704FB")
        
public static boolean isStatusSuccess(int status) {
            return (status >= 200 && status < 300);
        }

        /**
         * Returns whether the status is an error (i.e. 4xx or 5xx).
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:56.362 -0500", hash_original_method = "C591B8BF2CAD63BD466BDA5E0AF86D43", hash_generated_method = "9126AE3B0F34FBB9DF05F13B7A451F65")
        
public static boolean isStatusError(int status) {
            return (status >= 400 && status < 600);
        }

        /**
         * Returns whether the status is a client error (i.e. 4xx).
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:56.365 -0500", hash_original_method = "489D29010318A7E75E7BD15B3041DE9E", hash_generated_method = "879A428473929333048F52A723E405DE")
        
public static boolean isStatusClientError(int status) {
            return (status >= 400 && status < 500);
        }

        /**
         * Returns whether the status is a server error (i.e. 5xx).
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:56.367 -0500", hash_original_method = "7820E53496F884EF2746E72E77D564A9", hash_generated_method = "12DF36F239CCC00EC8C6997617C75F9B")
        
public static boolean isStatusServerError(int status) {
            return (status >= 500 && status < 600);
        }

        /**
         * this method determines if a notification should be displayed for a
         * given {@link #COLUMN_VISIBILITY} value
         * @param visibility the value of {@link #COLUMN_VISIBILITY}.
         * @return true if the notification should be displayed. false otherwise.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:56.370 -0500", hash_original_method = "EB2AD52BDA0781DB0D3D307CC4A1672A", hash_generated_method = "F0256992366BDD76F21ADFBD67D009D6")
        
public static boolean isNotificationToBeDisplayed(int visibility) {
            return visibility == DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED ||
                    visibility == DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_ONLY_COMPLETION;
        }

        /**
         * Returns whether the download has completed (either with success or
         * error).
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:56.372 -0500", hash_original_method = "D5FF53CF24644619C5751BB5240DB34B", hash_generated_method = "326B50B15E660E78D5564B8F03966ABE")
        
public static boolean isStatusCompleted(int status) {
            return (status >= 200 && status < 300) || (status >= 400 && status < 600);
        }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:56.210 -0500", hash_original_field = "6CC91191DBBE5DDD4D947582F23DEB7A", hash_generated_field = "A16F8C5C1BDFFBA8B2519500C603637B")

        public static final String PERMISSION_ACCESS = "android.permission.ACCESS_DOWNLOAD_MANAGER";
        
        public static class RequestHeaders {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:56.447 -0500", hash_original_field = "6A25E4E65891B8E7F6078DEA2F08B82F", hash_generated_field = "5028F2620B4D52418A7802C0D5210CA6")

            public static final String HEADERS_DB_TABLE = "request_headers";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:56.451 -0500", hash_original_field = "CEFF8AB25EFB335D5A117E4CE6BED660", hash_generated_field = "B81DA13D18B77B42C85F2FA517DBAF92")

            public static final String COLUMN_DOWNLOAD_ID = "download_id";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:56.453 -0500", hash_original_field = "A3C619CC1DD730C7CF7D775574384B08", hash_generated_field = "9EB0402A4C62BAA3817FC93F001711D6")

            public static final String COLUMN_HEADER = "header";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:56.456 -0500", hash_original_field = "457F947C16A57202F1546D3B8118D5BE", hash_generated_field = "479F7B3899792931C8CAF909C6ECDB70")

            public static final String COLUMN_VALUE = "value";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:56.459 -0500", hash_original_field = "219A304169E4A0C46AE2AE19A150F70F", hash_generated_field = "21593E7AE8BC5E336643B6302EF3C15E")

            public static final String URI_SEGMENT = "headers";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:56.461 -0500", hash_original_field = "3D0CA3315A1D47248C07E485066A1B5B", hash_generated_field = "A05066D0439CD0B36D54064E40604CFE")

            public static final String INSERT_KEY_PREFIX = "http_header_";
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.298 -0400", hash_original_method = "B06C81148D4BC4223C2D3A656DC9543B", hash_generated_method = "B06C81148D4BC4223C2D3A656DC9543B")
            public RequestHeaders ()
            {
                //Synthesized constructor
            }
        }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:56.213 -0500", hash_original_field = "3BFB4976CA811316D3B56F8D2D0CEB21", hash_generated_field = "C8C2B81A4A69800F3EFC0A9A3E867581")

        public static final String PERMISSION_ACCESS_ADVANCED =
                "android.permission.ACCESS_DOWNLOAD_MANAGER_ADVANCED";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:56.216 -0500", hash_original_field = "868554319FDF27832D43B5975034257F", hash_generated_field = "A32B44BFDFE95E2AA1F77E1DA1195A97")

        public static final String PERMISSION_ACCESS_ALL =
                "android.permission.ACCESS_ALL_DOWNLOADS";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:56.218 -0500", hash_original_field = "002637F810B18854BA9D36AA8A647883", hash_generated_field = "BE3F936FE4DB087834D7D6559CC44DB7")

        public static final String PERMISSION_CACHE = "android.permission.ACCESS_CACHE_FILESYSTEM";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:56.221 -0500", hash_original_field = "C2204CFF731E566454F23E5F68C58E81", hash_generated_field = "B1459544A5439501FD34CC98FB382F02")

        public static final String PERMISSION_SEND_INTENTS =
                "android.permission.SEND_DOWNLOAD_COMPLETED_INTENTS";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:56.223 -0500", hash_original_field = "9B00595B0B6EFEE779A6AA716C9EF3B8", hash_generated_field = "80AC17EE9B4AA8057C08E0004D4C6415")

        public static final String PERMISSION_CACHE_NON_PURGEABLE =
                "android.permission.DOWNLOAD_CACHE_NON_PURGEABLE";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:56.226 -0500", hash_original_field = "380E610B9ACCBF1A5D2F1CE14C38B214", hash_generated_field = "8DA517ED537BD69051CC804AE5E71918")

        public static final String PERMISSION_NO_NOTIFICATION =
                "android.permission.DOWNLOAD_WITHOUT_NOTIFICATION";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:56.229 -0500", hash_original_field = "04DAC5FD1BD0B97C5BB8885AD5DB5AEE", hash_generated_field = "9184A7EAB5305E6472D5AC7D2BD750F6")

        public static final Uri CONTENT_URI =
                Uri.parse("content://downloads/my_downloads");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:56.231 -0500", hash_original_field = "766AE71604C73EB5451AE60E59147624", hash_generated_field = "F30B5813D7922AC50CEF61CFE01A647D")

        public static final Uri ALL_DOWNLOADS_CONTENT_URI =
                Uri.parse("content://downloads/all_downloads");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:56.234 -0500", hash_original_field = "116AB5ED7A43438D6183035C4C50C078", hash_generated_field = "D0E37F8E10B8E00DEB1FDD24489E85E5")

        public static final String PUBLICLY_ACCESSIBLE_DOWNLOADS_URI_SEGMENT = "public_downloads";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:56.237 -0500", hash_original_field = "DC96B7DE96EE45D9755BBB5FFF1A2764", hash_generated_field = "3B8CE038C221202A2EEBC515E104909B")

        public static final Uri PUBLICLY_ACCESSIBLE_DOWNLOADS_URI =
                Uri.parse("content://downloads/" + PUBLICLY_ACCESSIBLE_DOWNLOADS_URI_SEGMENT);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:56.239 -0500", hash_original_field = "5C45D7B624B0B5CAEEDE6DDE11098AED", hash_generated_field = "F65F922C3691266F6C8D1C9707D111C4")

        public static final String ACTION_DOWNLOAD_COMPLETED =
                "android.intent.action.DOWNLOAD_COMPLETED";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:56.242 -0500", hash_original_field = "4ABB7637530E8370304C1CF46398F70D", hash_generated_field = "1FFA83D95534766F1D19122DE8BD3A39")

        public static final String ACTION_NOTIFICATION_CLICKED =
                "android.intent.action.DOWNLOAD_NOTIFICATION_CLICKED";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:56.244 -0500", hash_original_field = "E0274B6D0F5E365152935FF2996F0E06", hash_generated_field = "D81BD05E4DF45DF569189EB3D450C2B0")

        public static final String COLUMN_URI = "uri";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:56.247 -0500", hash_original_field = "55E0BC471B47B86E23AF1B8CE1E22ABB", hash_generated_field = "B7D2016A80C94B7946A244F5F04A3353")

        public static final String COLUMN_APP_DATA = "entity";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:56.250 -0500", hash_original_field = "3A6A6F0CABFEE6D24EFB4D6B1399DBC3", hash_generated_field = "91ABE4DBBC326AA24C494E9F1C9E1505")

        public static final String COLUMN_NO_INTEGRITY = "no_integrity";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:56.252 -0500", hash_original_field = "E324F27032F7E7F3C9EBAFF2DD8874E4", hash_generated_field = "B14C40E7AADBD89B86F8806CAC28380F")

        public static final String COLUMN_FILE_NAME_HINT = "hint";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:56.255 -0500", hash_original_field = "6627A0AE689A0C6C1260E2B9DD1E3940", hash_generated_field = "6019C57F4087C2B434AB905CD1126FDC")

        public static final String _DATA = "_data";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:56.257 -0500", hash_original_field = "F684AC99BFEA89DB8589BE15AA232BCB", hash_generated_field = "83575A1B7857638511FB58537C125579")

        public static final String COLUMN_MIME_TYPE = "mimetype";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:56.260 -0500", hash_original_field = "A47C11300C1213B715081709A8B20054", hash_generated_field = "ADFBBBCD12DCB7DF297C2138F761D76C")

        public static final String COLUMN_DESTINATION = "destination";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:56.262 -0500", hash_original_field = "601C7B3FB31E768364333ADD691F89D6", hash_generated_field = "23C88DD246976CB8051F4C49E6BFBC45")

        public static final String COLUMN_VISIBILITY = "visibility";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:56.265 -0500", hash_original_field = "82722ECBDC45405ADAE5F2E0DB82D6AF", hash_generated_field = "6A11766B6729709EEAC782B0CCDE3E1E")

        public static final String COLUMN_CONTROL = "control";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:56.267 -0500", hash_original_field = "A543CE9DD7A278531EE2D7FD02EEC4E6", hash_generated_field = "657CEFEF9A4B1B21BFEC7E041A29089C")

        public static final String COLUMN_STATUS = "status";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:56.272 -0500", hash_original_field = "EC0B977A529976DA81E9D8889A7F3448", hash_generated_field = "8EE3261AEB5C99D4587C73EDA5598D7E")

        public static final String COLUMN_LAST_MODIFICATION = "lastmod";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:56.274 -0500", hash_original_field = "DD81BEEC63402C91699388EA8D8937E8", hash_generated_field = "907B711355BD8DD8B8741120FB6F6A61")

        public static final String COLUMN_NOTIFICATION_PACKAGE = "notificationpackage";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:56.277 -0500", hash_original_field = "299802E67B98B5D7A87E6553F09FC55C", hash_generated_field = "4A9026CE90135EE58BC862A3C9CD0818")

        public static final String COLUMN_NOTIFICATION_CLASS = "notificationclass";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:56.279 -0500", hash_original_field = "0D2F033CCB649C355E7861C45C901B90", hash_generated_field = "01D44AF36D93BD4CD943A0CA87474DC4")

        public static final String COLUMN_NOTIFICATION_EXTRAS = "notificationextras";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:56.282 -0500", hash_original_field = "6D2B48E1209EFD4C3E81FB45EBB6D287", hash_generated_field = "3B0092F29A33CBA1B7D799483889F544")

        public static final String COLUMN_COOKIE_DATA = "cookiedata";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:56.285 -0500", hash_original_field = "0BF1B5C2DB3832C692BBC7349A5E92D1", hash_generated_field = "FBC148E4D36504367DBD9CA67230B073")

        public static final String COLUMN_USER_AGENT = "useragent";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:56.287 -0500", hash_original_field = "50581C56937E7E87A5A944E22516EB83", hash_generated_field = "343BC9050B25C1E78AF0B588BF4908FD")

        public static final String COLUMN_REFERER = "referer";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:56.290 -0500", hash_original_field = "5E8B749BE4403992E4A0CFB25CF316A1", hash_generated_field = "5FA40E545C192F33B148A2956B795C2A")

        public static final String COLUMN_TOTAL_BYTES = "total_bytes";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:56.292 -0500", hash_original_field = "B7EE19AA300085D9A888BC76C0F0AE5E", hash_generated_field = "48696BD7ED41BFEBC24337893CD32913")

        public static final String COLUMN_CURRENT_BYTES = "current_bytes";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:56.295 -0500", hash_original_field = "82D668844A53A4379ED8AAF5AF6C4480", hash_generated_field = "4617E0D8E78AB098AB3BAFE56815BB4D")

        public static final String COLUMN_OTHER_UID = "otheruid";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:56.297 -0500", hash_original_field = "12F08ADFB7A18D4F68D6AFEBDD9A5C91", hash_generated_field = "D5100FB967A5E55DC760E93EF45526F8")

        public static final String COLUMN_TITLE = "title";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:56.300 -0500", hash_original_field = "3694D3DBA8CE67FF6E7526316FC3CD23", hash_generated_field = "299EF942613B8752095DF3ACB6D6111D")

        public static final String COLUMN_DESCRIPTION = "description";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:56.303 -0500", hash_original_field = "5130AD44ED22B5EB9189BB7B995FC760", hash_generated_field = "C92CECDC1949B9336565693681BB95C7")

        public static final String COLUMN_IS_PUBLIC_API = "is_public_api";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:56.305 -0500", hash_original_field = "4E66F251848B9F05B85805E0C744080C", hash_generated_field = "2FE7293CC65448FF0BDF5F041C1FF22E")

        public static final String COLUMN_ALLOW_ROAMING = "allow_roaming";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:56.307 -0500", hash_original_field = "C59AEF0C762454C2DF86211AC366673D", hash_generated_field = "BC731B6C4EA7EC957B88A1C81F5B88A9")

        public static final String COLUMN_ALLOWED_NETWORK_TYPES = "allowed_network_types";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:56.310 -0500", hash_original_field = "02B13BDB398AB119DF8A75E97439DEA7", hash_generated_field = "5D045E6C307D3238D44B5C0041271415")

        public static final String COLUMN_IS_VISIBLE_IN_DOWNLOADS_UI = "is_visible_in_downloads_ui";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:56.312 -0500", hash_original_field = "671EE79CC4D6803044D71D3CD04A09AA", hash_generated_field = "D8A8996485D059E6B0A05B1C26722A13")

        public static final String COLUMN_BYPASS_RECOMMENDED_SIZE_LIMIT =
            "bypass_recommended_size_limit";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:56.316 -0500", hash_original_field = "C897A77ABFA68AD3EA0AB63198642CA4", hash_generated_field = "B6CC78A4561FC36957ACC55030F54D48")

        public static final String COLUMN_DELETED = "deleted";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:56.319 -0500", hash_original_field = "09BD0131BB4E6789C77C5FCCDB9C6C5C", hash_generated_field = "41FE0BD5EBCEA7804ADB2A926C59F5CA")

        public static final String COLUMN_MEDIAPROVIDER_URI = "mediaprovider_uri";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:56.321 -0500", hash_original_field = "6CDFF2C3DEDB6E98945C0C7F839AE579", hash_generated_field = "77E97461784D03F4199C2869111F2F2B")

        public static final String COLUMN_MEDIA_SCANNED = "scanned";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:56.324 -0500", hash_original_field = "5EA4432190A652D73B4E5E7813D53AC4", hash_generated_field = "04256B1F0E23E5FA1620FCF34E08A35C")

        public static final String COLUMN_ERROR_MSG = "errorMsg";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:56.326 -0500", hash_original_field = "7D3F904D01EF1EA9172E668281006CFD", hash_generated_field = "37308CABB2DAC3EE9C880C8E9C0D03FC")

        public static final String COLUMN_LAST_UPDATESRC = "lastUpdateSrc";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:56.329 -0500", hash_original_field = "4C48BD47E8F160D6FA5ACFCAADF4F372", hash_generated_field = "5D7BE9C8913A4CEE62B68DCFE5F3502C")

        public static final int LAST_UPDATESRC_NOT_RELEVANT = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:56.331 -0500", hash_original_field = "FDF51A4134DC20B6A6FDD78193E5DB46", hash_generated_field = "D78C133663B74B2E4230686EAB613FBD")

        public static final int LAST_UPDATESRC_DONT_NOTIFY_DOWNLOADSVC = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:56.334 -0500", hash_original_field = "0A62CBBD4A3FED29703D4F13DD822B77", hash_generated_field = "3E52737E9B7A7A575774600F119868AA")

        /**
         * This download will be saved to the external storage. This is the
         * default behavior, and should be used for any file that the user
         * can freely access, copy, delete. Even with that destination,
         * unencrypted DRM files are saved in secure internal storage.
         * Downloads to the external destination only write files for which
         * there is a registered handler. The resulting files are accessible
         * by filename to all applications.
         */
        public static final int DESTINATION_EXTERNAL = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:56.336 -0500", hash_original_field = "90886AB811D4BBABAABFA224BCAD2D09", hash_generated_field = "F52740406CB0461983A1EDB08C6A069B")

        public static final int DESTINATION_CACHE_PARTITION = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:56.339 -0500", hash_original_field = "236DF7DDAF387C1DC37CB32A0389355D", hash_generated_field = "9B292F450E3486073D7179E982838E1E")

        public static final int DESTINATION_CACHE_PARTITION_PURGEABLE = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:56.341 -0500", hash_original_field = "284290F7A457E69A685DAB39EC61F9B4", hash_generated_field = "25906328F9BD422302DFBEECC807CB91")

        public static final int DESTINATION_CACHE_PARTITION_NOROAMING = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:56.344 -0500", hash_original_field = "653F0A0547F37F9259DBF9250A2918D3", hash_generated_field = "7A64CF59FE1283766D6ED985DD7ECDFE")

        public static final int DESTINATION_FILE_URI = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:56.348 -0500", hash_original_field = "7F78FCE91537575C0C23C0D6FD74761C", hash_generated_field = "921E449F8C394DEE5B1F707795178D30")

        public static final int DESTINATION_SYSTEMCACHE_PARTITION = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:56.350 -0500", hash_original_field = "66A067C0E6729D88E87BDCC62C4C21E3", hash_generated_field = "5BB1FC4222192891DE774A4D708F1362")

        public static final int DESTINATION_NON_DOWNLOADMANAGER_DOWNLOAD = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:56.352 -0500", hash_original_field = "E62E3926C396224758B2E2B0B9DC3DD4", hash_generated_field = "DDEAC82C18594EBFB1C6811E94BEC0BA")

        public static final int CONTROL_RUN = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:56.355 -0500", hash_original_field = "FF98A471BB5B5C899FD411861A441E1A", hash_generated_field = "5D89151671D7E898CD5352CA807AEF19")

        public static final int CONTROL_PAUSED = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:56.375 -0500", hash_original_field = "D362EB3362BF4327BE7F2EECFF0FCA44", hash_generated_field = "B6A6B76C4B43C465BD1D92434C9D71AB")

        public static final int STATUS_PENDING = 190;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:56.377 -0500", hash_original_field = "2E3C64154C26C057409BB84827E963BB", hash_generated_field = "8259640DC7701A5FC7D4CFBB646C50F3")

        public static final int STATUS_RUNNING = 192;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:56.380 -0500", hash_original_field = "214A09EFBBF8074C88592130AFE09848", hash_generated_field = "940ADC22C600C072B95478948C568F9F")

        public static final int STATUS_PAUSED_BY_APP = 193;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:56.383 -0500", hash_original_field = "41743460C04EDF23E4C19495C1381EB4", hash_generated_field = "737C93204DDE6CA5490870BD3CD3FBC8")

        public static final int STATUS_WAITING_TO_RETRY = 194;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:56.385 -0500", hash_original_field = "217B1E7249E6B4B0AC451021D3694A13", hash_generated_field = "871332CB6C1CF939ED89371EE5D603B8")

        public static final int STATUS_WAITING_FOR_NETWORK = 195;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:56.388 -0500", hash_original_field = "E896C9E48FC6A49E90E4AAD641FB0858", hash_generated_field = "870A4A7B3626863F90B9E90E3C175C94")

        public static final int STATUS_QUEUED_FOR_WIFI = 196;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:56.391 -0500", hash_original_field = "1BF6FC70FC12728D100422FA4B9D52F0", hash_generated_field = "8090C13160C2FBADD9BD3C2FA9A5AC20")

        public static final int STATUS_INSUFFICIENT_SPACE_ERROR = 198;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:56.393 -0500", hash_original_field = "E874E77E5DF29E7778FB08200CD0C0E1", hash_generated_field = "F1380D594F2450789D8C71352DF234B1")

        public static final int STATUS_DEVICE_NOT_FOUND_ERROR = 199;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:56.396 -0500", hash_original_field = "06B6FD98B7CEFF7F47087EFC7BC63000", hash_generated_field = "FEA66F1961DC7E8B250797FF4270F303")

        public static final int STATUS_SUCCESS = 200;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:56.398 -0500", hash_original_field = "5FFF2C441AC473F43010E8E83A554613", hash_generated_field = "A1ED037B27B69F562A310A9AC61130D0")

        public static final int STATUS_BAD_REQUEST = 400;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:56.400 -0500", hash_original_field = "AACC003B1DCBD95250C4B10BC5646879", hash_generated_field = "4168FBF7E94E10C246D9B5D4D6C702B9")

        public static final int STATUS_NOT_ACCEPTABLE = 406;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:56.403 -0500", hash_original_field = "8C798004B8F3AB3B6C53411ED5833F6F", hash_generated_field = "9C93BE484B03107766F5834ABA575502")

        public static final int STATUS_LENGTH_REQUIRED = 411;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:56.406 -0500", hash_original_field = "80CD6620E845C6996B29E2582C9573E5", hash_generated_field = "A2A9BFB102E893D51705859D42793AB4")

        public static final int STATUS_PRECONDITION_FAILED = 412;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:56.408 -0500", hash_original_field = "9E38620F350190542C4AE217AD780EDB", hash_generated_field = "478DF663F634CE3DCFD005FC3DE497AD")

        public static final int MIN_ARTIFICIAL_ERROR_STATUS = 488;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:56.411 -0500", hash_original_field = "A0D18FEFAC02CAF97961591C0E4F06DD", hash_generated_field = "711C26F047E8DBF4947F7F22461CFB66")

        public static final int STATUS_FILE_ALREADY_EXISTS_ERROR = 488;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:56.413 -0500", hash_original_field = "23FC02DFFEC5A7B9C3046D52007DAD47", hash_generated_field = "83DC7829F4544E4C2767D8774602ED05")

        public static final int STATUS_CANNOT_RESUME = 489;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:56.416 -0500", hash_original_field = "A7D8272B10D6D7E3662FA279651420BE", hash_generated_field = "C5ECE5FA253A439775CB88D0A8EEDEA4")

        public static final int STATUS_CANCELED = 490;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:56.419 -0500", hash_original_field = "19F5302F1F63E54D78436810C4A218C4", hash_generated_field = "E8E401F994A50361357CB61E27FFE0BD")

        public static final int STATUS_UNKNOWN_ERROR = 491;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:56.421 -0500", hash_original_field = "7A5247BCFF3764B34A0B7D360F9B8A68", hash_generated_field = "9A72C1E44A43E2D44456CEABC6AD9E3F")

        public static final int STATUS_FILE_ERROR = 492;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:56.424 -0500", hash_original_field = "EF12D2C80FAE06A156284290E204F573", hash_generated_field = "23BA6F7B61599A741C5535194EE2E30B")

        public static final int STATUS_UNHANDLED_REDIRECT = 493;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:56.426 -0500", hash_original_field = "1A0834C0E16475B204B1E0669F0AA158", hash_generated_field = "B61E43C3BF6C617E649EF3E8FA0B01BC")

        public static final int STATUS_UNHANDLED_HTTP_CODE = 494;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:56.429 -0500", hash_original_field = "FA92EDCEA56F80CFC07C60E9350EBCCE", hash_generated_field = "8A3F09CB8D02F80A71933576DE6BC580")

        public static final int STATUS_HTTP_DATA_ERROR = 495;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:56.432 -0500", hash_original_field = "1C90CA5AF3A8419B26491711BE13858B", hash_generated_field = "4D5C202EAE1A9AB9CAB18BD9A2DFD23F")

        public static final int STATUS_HTTP_EXCEPTION = 496;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:56.434 -0500", hash_original_field = "9FBDB30BCBE8F5282C80F37EC28276AE", hash_generated_field = "597BFEAB28215A70723ED8175152D3BF")

        public static final int STATUS_TOO_MANY_REDIRECTS = 497;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:56.437 -0500", hash_original_field = "41A55C88A2409B1D89F6561A6481D47D", hash_generated_field = "DB3EE0D6AF758EAA4F14D39222150B1A")

        public static final int STATUS_BLOCKED = 498;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:56.439 -0500", hash_original_field = "53D0760B5F5C8C6B1E21A5149FF7138F", hash_generated_field = "8AFD22E9073E10A3BC6106DA63067AB4")

        public static final int VISIBILITY_VISIBLE = DownloadManager.Request.VISIBILITY_VISIBLE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:56.442 -0500", hash_original_field = "2BEBC737858540A5BDDFB32AC6F93391", hash_generated_field = "228082D58AD2DB0C061C92D8C7ED0404")

        public static final int VISIBILITY_VISIBLE_NOTIFY_COMPLETED =
                DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:56.444 -0500", hash_original_field = "D7ECDCC7F0576F5E52A682ADB1C04784", hash_generated_field = "D7B83DB94501403C446B003FF3C4C516")

        public static final int VISIBILITY_HIDDEN = DownloadManager.Request.VISIBILITY_HIDDEN;
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:56.207 -0500", hash_original_method = "BBF0D9B1CF16C5FC7549DABF49EBEFE0", hash_generated_method = "85EA5655661B5E305978CD7B13301ACE")
        
private Impl() {}
    }
    
}

