package android.provider;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.app.DownloadManager;
import android.net.NetworkPolicyManager;
import android.net.Uri;

public final class Downloads {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.273 -0400", hash_original_method = "9B4A677720B6322F28A15E895C99B092", hash_generated_method = "BCFC969F167E5171E2BDC38F7DDB8203")
    private  Downloads() {
        // ---------- Original Method ----------
    }

    
    public static final class Impl implements BaseColumns {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.275 -0400", hash_original_method = "BBF0D9B1CF16C5FC7549DABF49EBEFE0", hash_generated_method = "3F538DB11C86ADB27843AD5963111DF7")
        private  Impl() {
            // ---------- Original Method ----------
        }

        
                @DSModeled(DSC.SAFE)
        public static boolean isStatusInformational(int status) {
            return (status >= 100 && status < 200);
        }

        
                @DSModeled(DSC.SAFE)
        public static boolean isStatusSuccess(int status) {
            return (status >= 200 && status < 300);
        }

        
                @DSModeled(DSC.SAFE)
        public static boolean isStatusError(int status) {
            return (status >= 400 && status < 600);
        }

        
                @DSModeled(DSC.SAFE)
        public static boolean isStatusClientError(int status) {
            return (status >= 400 && status < 500);
        }

        
                @DSModeled(DSC.SAFE)
        public static boolean isStatusServerError(int status) {
            return (status >= 500 && status < 600);
        }

        
                @DSModeled(DSC.SAFE)
        public static boolean isNotificationToBeDisplayed(int visibility) {
            return visibility == DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED ||
                    visibility == DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_ONLY_COMPLETION;
        }

        
                @DSModeled(DSC.SAFE)
        public static boolean isStatusCompleted(int status) {
            return (status >= 200 && status < 300) || (status >= 400 && status < 600);
        }

        
        public static class RequestHeaders {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.276 -0400", hash_original_method = "B06C81148D4BC4223C2D3A656DC9543B", hash_generated_method = "B06C81148D4BC4223C2D3A656DC9543B")
            public RequestHeaders ()
            {
                //Synthesized constructor
            }


            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.276 -0400", hash_original_field = "F6F72829649F133D0B50754521ED19EF", hash_generated_field = "5028F2620B4D52418A7802C0D5210CA6")

            public static final String HEADERS_DB_TABLE = "request_headers";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.276 -0400", hash_original_field = "99E02602643767E5CA2D885FDABBC768", hash_generated_field = "B81DA13D18B77B42C85F2FA517DBAF92")

            public static final String COLUMN_DOWNLOAD_ID = "download_id";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.277 -0400", hash_original_field = "862D2C569102C71ECB1989E6F1353F3A", hash_generated_field = "9EB0402A4C62BAA3817FC93F001711D6")

            public static final String COLUMN_HEADER = "header";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.277 -0400", hash_original_field = "6239F06D2AE5751356D4CC493253F955", hash_generated_field = "479F7B3899792931C8CAF909C6ECDB70")

            public static final String COLUMN_VALUE = "value";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.277 -0400", hash_original_field = "163DAAA001A8856AB07BC9B2DFB5BE7D", hash_generated_field = "21593E7AE8BC5E336643B6302EF3C15E")

            public static final String URI_SEGMENT = "headers";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.277 -0400", hash_original_field = "5FEEF2618D99630168497FE9F32BB990", hash_generated_field = "A05066D0439CD0B36D54064E40604CFE")

            public static final String INSERT_KEY_PREFIX = "http_header_";
        }


        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.277 -0400", hash_original_field = "64305F2D2DCF757B21D74235359C9E53", hash_generated_field = "A16F8C5C1BDFFBA8B2519500C603637B")

        public static final String PERMISSION_ACCESS = "android.permission.ACCESS_DOWNLOAD_MANAGER";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.277 -0400", hash_original_field = "178BE1F07B5ACBBF1608636FDF0C63EB", hash_generated_field = "C8C2B81A4A69800F3EFC0A9A3E867581")

        public static final String PERMISSION_ACCESS_ADVANCED =
                "android.permission.ACCESS_DOWNLOAD_MANAGER_ADVANCED";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.277 -0400", hash_original_field = "68550F12E20B75C385520B9453B6262A", hash_generated_field = "A32B44BFDFE95E2AA1F77E1DA1195A97")

        public static final String PERMISSION_ACCESS_ALL =
                "android.permission.ACCESS_ALL_DOWNLOADS";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.277 -0400", hash_original_field = "00E240AACE81850CBF170C274CF234FB", hash_generated_field = "BE3F936FE4DB087834D7D6559CC44DB7")

        public static final String PERMISSION_CACHE = "android.permission.ACCESS_CACHE_FILESYSTEM";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.277 -0400", hash_original_field = "9120E4E95D2CEB3B283164CE4882487A", hash_generated_field = "B1459544A5439501FD34CC98FB382F02")

        public static final String PERMISSION_SEND_INTENTS =
                "android.permission.SEND_DOWNLOAD_COMPLETED_INTENTS";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.277 -0400", hash_original_field = "9C6AA58154ABEFE800FD5BE9BB2A0551", hash_generated_field = "80AC17EE9B4AA8057C08E0004D4C6415")

        public static final String PERMISSION_CACHE_NON_PURGEABLE =
                "android.permission.DOWNLOAD_CACHE_NON_PURGEABLE";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.277 -0400", hash_original_field = "082BE4B6D4A794421ADF2B11F953FE62", hash_generated_field = "8DA517ED537BD69051CC804AE5E71918")

        public static final String PERMISSION_NO_NOTIFICATION =
                "android.permission.DOWNLOAD_WITHOUT_NOTIFICATION";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.277 -0400", hash_original_field = "B2E0592EB853183507009A0CE33BAC5B", hash_generated_field = "9184A7EAB5305E6472D5AC7D2BD750F6")

        public static final Uri CONTENT_URI =
                Uri.parse("content://downloads/my_downloads");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.277 -0400", hash_original_field = "8F32EF8D50D559279C447AA00ABBC2DC", hash_generated_field = "F30B5813D7922AC50CEF61CFE01A647D")

        public static final Uri ALL_DOWNLOADS_CONTENT_URI =
                Uri.parse("content://downloads/all_downloads");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.277 -0400", hash_original_field = "11D91D8D05FD29A0F7636A8DF4CD4F66", hash_generated_field = "D0E37F8E10B8E00DEB1FDD24489E85E5")

        public static final String PUBLICLY_ACCESSIBLE_DOWNLOADS_URI_SEGMENT = "public_downloads";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.278 -0400", hash_original_field = "0738A15A858165AF0C521FE529AFD698", hash_generated_field = "3B8CE038C221202A2EEBC515E104909B")

        public static final Uri PUBLICLY_ACCESSIBLE_DOWNLOADS_URI =
                Uri.parse("content://downloads/" + PUBLICLY_ACCESSIBLE_DOWNLOADS_URI_SEGMENT);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.278 -0400", hash_original_field = "9842D53D106475279AAB7B3732C79DEB", hash_generated_field = "F65F922C3691266F6C8D1C9707D111C4")

        public static final String ACTION_DOWNLOAD_COMPLETED =
                "android.intent.action.DOWNLOAD_COMPLETED";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.278 -0400", hash_original_field = "7749EC94D727FDDDEFDAB2D0EAE57B72", hash_generated_field = "1FFA83D95534766F1D19122DE8BD3A39")

        public static final String ACTION_NOTIFICATION_CLICKED =
                "android.intent.action.DOWNLOAD_NOTIFICATION_CLICKED";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.278 -0400", hash_original_field = "82EEAC53E156AC053E45C9E0A6AF3447", hash_generated_field = "D81BD05E4DF45DF569189EB3D450C2B0")

        public static final String COLUMN_URI = "uri";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.278 -0400", hash_original_field = "DE52B4797845AEA7863B5A80200F6CF2", hash_generated_field = "B7D2016A80C94B7946A244F5F04A3353")

        public static final String COLUMN_APP_DATA = "entity";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.278 -0400", hash_original_field = "3262C5B02E5D731D370D91843C7D2316", hash_generated_field = "91ABE4DBBC326AA24C494E9F1C9E1505")

        public static final String COLUMN_NO_INTEGRITY = "no_integrity";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.278 -0400", hash_original_field = "0A38AF419BF51E63B31E1D30A5DBD47E", hash_generated_field = "B14C40E7AADBD89B86F8806CAC28380F")

        public static final String COLUMN_FILE_NAME_HINT = "hint";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.278 -0400", hash_original_field = "18906D7639726B192F36BA34222E9041", hash_generated_field = "6019C57F4087C2B434AB905CD1126FDC")

        public static final String _DATA = "_data";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.278 -0400", hash_original_field = "FE40BF74A4338721A33699BB105A330E", hash_generated_field = "83575A1B7857638511FB58537C125579")

        public static final String COLUMN_MIME_TYPE = "mimetype";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.278 -0400", hash_original_field = "48FD722E807549343054F55847C2F898", hash_generated_field = "ADFBBBCD12DCB7DF297C2138F761D76C")

        public static final String COLUMN_DESTINATION = "destination";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.278 -0400", hash_original_field = "25E32E562BD9A94E7BBF899CF24FAE84", hash_generated_field = "23C88DD246976CB8051F4C49E6BFBC45")

        public static final String COLUMN_VISIBILITY = "visibility";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.278 -0400", hash_original_field = "B68472D4E24CF29B3DFE9B78D9E059B1", hash_generated_field = "6A11766B6729709EEAC782B0CCDE3E1E")

        public static final String COLUMN_CONTROL = "control";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.278 -0400", hash_original_field = "ECD5DDCF1DE7F8075480DCBB3AB8FAB6", hash_generated_field = "657CEFEF9A4B1B21BFEC7E041A29089C")

        public static final String COLUMN_STATUS = "status";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.279 -0400", hash_original_field = "FEC21A62484C1F5FC8779AC44ED0683C", hash_generated_field = "8EE3261AEB5C99D4587C73EDA5598D7E")

        public static final String COLUMN_LAST_MODIFICATION = "lastmod";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.279 -0400", hash_original_field = "E27AFBA407A1DAF9CE722DF7B2C82A01", hash_generated_field = "907B711355BD8DD8B8741120FB6F6A61")

        public static final String COLUMN_NOTIFICATION_PACKAGE = "notificationpackage";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.279 -0400", hash_original_field = "636F6FA3A0AB02EC8C3FE4F842238672", hash_generated_field = "4A9026CE90135EE58BC862A3C9CD0818")

        public static final String COLUMN_NOTIFICATION_CLASS = "notificationclass";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.279 -0400", hash_original_field = "6C032D2F0A691720CBFCE78641477853", hash_generated_field = "01D44AF36D93BD4CD943A0CA87474DC4")

        public static final String COLUMN_NOTIFICATION_EXTRAS = "notificationextras";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.279 -0400", hash_original_field = "B9BDE45C3960DF0CFDF204B2710E4B19", hash_generated_field = "3B0092F29A33CBA1B7D799483889F544")

        public static final String COLUMN_COOKIE_DATA = "cookiedata";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.279 -0400", hash_original_field = "016CF9EE514C10BD2DC2DFF0AECA64B3", hash_generated_field = "FBC148E4D36504367DBD9CA67230B073")

        public static final String COLUMN_USER_AGENT = "useragent";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.279 -0400", hash_original_field = "6927FF6DE0887820CBDB4CDEF216FC1F", hash_generated_field = "343BC9050B25C1E78AF0B588BF4908FD")

        public static final String COLUMN_REFERER = "referer";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.279 -0400", hash_original_field = "463EB63D543739B3BB714FA2EF3A516C", hash_generated_field = "5FA40E545C192F33B148A2956B795C2A")

        public static final String COLUMN_TOTAL_BYTES = "total_bytes";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.279 -0400", hash_original_field = "08CAFD988D885ABD5AB1BCCCFE6923BE", hash_generated_field = "48696BD7ED41BFEBC24337893CD32913")

        public static final String COLUMN_CURRENT_BYTES = "current_bytes";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.279 -0400", hash_original_field = "ABF02F1C95120CC1BED570118792C284", hash_generated_field = "4617E0D8E78AB098AB3BAFE56815BB4D")

        public static final String COLUMN_OTHER_UID = "otheruid";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.279 -0400", hash_original_field = "F6C4DC30A6218CD6A860F634446A8CC4", hash_generated_field = "D5100FB967A5E55DC760E93EF45526F8")

        public static final String COLUMN_TITLE = "title";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.279 -0400", hash_original_field = "F34B514F0DE1A3814B4F0CACFAC6E935", hash_generated_field = "299EF942613B8752095DF3ACB6D6111D")

        public static final String COLUMN_DESCRIPTION = "description";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.279 -0400", hash_original_field = "DF14D7D936ECC8E2AADB00DB6D4CB6FA", hash_generated_field = "C92CECDC1949B9336565693681BB95C7")

        public static final String COLUMN_IS_PUBLIC_API = "is_public_api";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.279 -0400", hash_original_field = "015CB4462670BECFCE060DB985930B57", hash_generated_field = "2FE7293CC65448FF0BDF5F041C1FF22E")

        public static final String COLUMN_ALLOW_ROAMING = "allow_roaming";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.279 -0400", hash_original_field = "C516FECA4F55EA3BC816B01E47112FB9", hash_generated_field = "BC731B6C4EA7EC957B88A1C81F5B88A9")

        public static final String COLUMN_ALLOWED_NETWORK_TYPES = "allowed_network_types";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.280 -0400", hash_original_field = "A0F0D9857B6845FCFF1D4643E1ED35F7", hash_generated_field = "5D045E6C307D3238D44B5C0041271415")

        public static final String COLUMN_IS_VISIBLE_IN_DOWNLOADS_UI = "is_visible_in_downloads_ui";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.280 -0400", hash_original_field = "ECC84991C395FA44760F41848FAE9059", hash_generated_field = "D8A8996485D059E6B0A05B1C26722A13")

        public static final String COLUMN_BYPASS_RECOMMENDED_SIZE_LIMIT =
            "bypass_recommended_size_limit";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.280 -0400", hash_original_field = "9F50D96CA920DDE7A410805FD869AA8E", hash_generated_field = "B6CC78A4561FC36957ACC55030F54D48")

        public static final String COLUMN_DELETED = "deleted";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.280 -0400", hash_original_field = "824FD1804C59E008542C249D78EDC971", hash_generated_field = "41FE0BD5EBCEA7804ADB2A926C59F5CA")

        public static final String COLUMN_MEDIAPROVIDER_URI = "mediaprovider_uri";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.280 -0400", hash_original_field = "E5550835DC9506514BB057B8026A7194", hash_generated_field = "77E97461784D03F4199C2869111F2F2B")

        public static final String COLUMN_MEDIA_SCANNED = "scanned";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.280 -0400", hash_original_field = "3188E667A0446D31D8D0C5E4D8893B71", hash_generated_field = "04256B1F0E23E5FA1620FCF34E08A35C")

        public static final String COLUMN_ERROR_MSG = "errorMsg";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.280 -0400", hash_original_field = "4B3D46BBCA9B6C217E7C0187CD0C331C", hash_generated_field = "37308CABB2DAC3EE9C880C8E9C0D03FC")

        public static final String COLUMN_LAST_UPDATESRC = "lastUpdateSrc";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.280 -0400", hash_original_field = "65086275B4B2C2CE59EB16A1F370E11F", hash_generated_field = "5D7BE9C8913A4CEE62B68DCFE5F3502C")

        public static final int LAST_UPDATESRC_NOT_RELEVANT = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.280 -0400", hash_original_field = "838C8875A3E1543047D56D10535AEEF2", hash_generated_field = "D78C133663B74B2E4230686EAB613FBD")

        public static final int LAST_UPDATESRC_DONT_NOTIFY_DOWNLOADSVC = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.280 -0400", hash_original_field = "55CA998CAE62903C9480C8E099DDAD71", hash_generated_field = "ABCC3BD6D5FB32653F1A52DFA4CEEA6C")

        public static final int DESTINATION_EXTERNAL = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.280 -0400", hash_original_field = "22BA676C0A39F1D7C00FAA1E6C8C09AE", hash_generated_field = "F52740406CB0461983A1EDB08C6A069B")

        public static final int DESTINATION_CACHE_PARTITION = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.280 -0400", hash_original_field = "98E7AB5FC292A51B96663828EB6AFC75", hash_generated_field = "9B292F450E3486073D7179E982838E1E")

        public static final int DESTINATION_CACHE_PARTITION_PURGEABLE = 2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.280 -0400", hash_original_field = "B8A84AB007BE92844E985FA561A41B3D", hash_generated_field = "25906328F9BD422302DFBEECC807CB91")

        public static final int DESTINATION_CACHE_PARTITION_NOROAMING = 3;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.280 -0400", hash_original_field = "5D3FDFE8772007B4E161324685B1B4B3", hash_generated_field = "7A64CF59FE1283766D6ED985DD7ECDFE")

        public static final int DESTINATION_FILE_URI = 4;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.281 -0400", hash_original_field = "A2F2C9C0EE76570FD1215237170A1E43", hash_generated_field = "921E449F8C394DEE5B1F707795178D30")

        public static final int DESTINATION_SYSTEMCACHE_PARTITION = 5;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.281 -0400", hash_original_field = "B501EA4CEF7AD64F10B7B2EA6069117F", hash_generated_field = "5BB1FC4222192891DE774A4D708F1362")

        public static final int DESTINATION_NON_DOWNLOADMANAGER_DOWNLOAD = 6;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.281 -0400", hash_original_field = "5F2C6CF2AFD580AB510CA8B61762DC65", hash_generated_field = "DDEAC82C18594EBFB1C6811E94BEC0BA")

        public static final int CONTROL_RUN = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.281 -0400", hash_original_field = "11C7EA9AF1DEB72A29E72CD2C0073240", hash_generated_field = "5D89151671D7E898CD5352CA807AEF19")

        public static final int CONTROL_PAUSED = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.281 -0400", hash_original_field = "C43AB89F4162DB5EB0BBC00A8FB94702", hash_generated_field = "B6A6B76C4B43C465BD1D92434C9D71AB")

        public static final int STATUS_PENDING = 190;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.281 -0400", hash_original_field = "CD07DEB960E3AAD20ACC0ECA9356A3EE", hash_generated_field = "8259640DC7701A5FC7D4CFBB646C50F3")

        public static final int STATUS_RUNNING = 192;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.281 -0400", hash_original_field = "35D4A97FB23D781C8A1673A67F44BA1A", hash_generated_field = "940ADC22C600C072B95478948C568F9F")

        public static final int STATUS_PAUSED_BY_APP = 193;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.281 -0400", hash_original_field = "0599E61B41FF26BFFB8418F41AACC6BF", hash_generated_field = "737C93204DDE6CA5490870BD3CD3FBC8")

        public static final int STATUS_WAITING_TO_RETRY = 194;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.281 -0400", hash_original_field = "24F1DF7DE1C7353318E8E4E610D42EE0", hash_generated_field = "871332CB6C1CF939ED89371EE5D603B8")

        public static final int STATUS_WAITING_FOR_NETWORK = 195;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.281 -0400", hash_original_field = "BAA3C90B8614E2F7F19EA78722BAF6D5", hash_generated_field = "870A4A7B3626863F90B9E90E3C175C94")

        public static final int STATUS_QUEUED_FOR_WIFI = 196;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.281 -0400", hash_original_field = "40CBF47B3C0D4D738C1277E8EAEE9760", hash_generated_field = "8090C13160C2FBADD9BD3C2FA9A5AC20")

        public static final int STATUS_INSUFFICIENT_SPACE_ERROR = 198;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.281 -0400", hash_original_field = "6687EF370623FF36D6A27D81B5FE5211", hash_generated_field = "F1380D594F2450789D8C71352DF234B1")

        public static final int STATUS_DEVICE_NOT_FOUND_ERROR = 199;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.281 -0400", hash_original_field = "30BCD4815AB4AD8B6E4F303E833E854E", hash_generated_field = "FEA66F1961DC7E8B250797FF4270F303")

        public static final int STATUS_SUCCESS = 200;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.281 -0400", hash_original_field = "09819EDA4D68DF59B424D209FCDFC421", hash_generated_field = "A1ED037B27B69F562A310A9AC61130D0")

        public static final int STATUS_BAD_REQUEST = 400;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.282 -0400", hash_original_field = "77F695442E1A365795CE422304ED45AE", hash_generated_field = "4168FBF7E94E10C246D9B5D4D6C702B9")

        public static final int STATUS_NOT_ACCEPTABLE = 406;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.282 -0400", hash_original_field = "BAF0034AB067C7C1E377F5A624B5A725", hash_generated_field = "9C93BE484B03107766F5834ABA575502")

        public static final int STATUS_LENGTH_REQUIRED = 411;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.282 -0400", hash_original_field = "33E520A77893F4F422E669C88616E4CB", hash_generated_field = "A2A9BFB102E893D51705859D42793AB4")

        public static final int STATUS_PRECONDITION_FAILED = 412;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.282 -0400", hash_original_field = "04E352F501DA824B87FB22903D296D9E", hash_generated_field = "478DF663F634CE3DCFD005FC3DE497AD")

        public static final int MIN_ARTIFICIAL_ERROR_STATUS = 488;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.282 -0400", hash_original_field = "2374E8EAB98D818A22A2E11960272560", hash_generated_field = "711C26F047E8DBF4947F7F22461CFB66")

        public static final int STATUS_FILE_ALREADY_EXISTS_ERROR = 488;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.282 -0400", hash_original_field = "800E19D0416054C0DB756F0EED97BEBD", hash_generated_field = "83DC7829F4544E4C2767D8774602ED05")

        public static final int STATUS_CANNOT_RESUME = 489;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.282 -0400", hash_original_field = "836E45EC16881E04701311969EE486FA", hash_generated_field = "C5ECE5FA253A439775CB88D0A8EEDEA4")

        public static final int STATUS_CANCELED = 490;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.282 -0400", hash_original_field = "175C3759561CCB1D29513CDBAC29D884", hash_generated_field = "E8E401F994A50361357CB61E27FFE0BD")

        public static final int STATUS_UNKNOWN_ERROR = 491;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.282 -0400", hash_original_field = "DD4032A53E12D45F76D1D9E4CF2EDBE1", hash_generated_field = "9A72C1E44A43E2D44456CEABC6AD9E3F")

        public static final int STATUS_FILE_ERROR = 492;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.282 -0400", hash_original_field = "5ED5BD750D29341A62450668D2205D64", hash_generated_field = "23BA6F7B61599A741C5535194EE2E30B")

        public static final int STATUS_UNHANDLED_REDIRECT = 493;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.282 -0400", hash_original_field = "3DD9348930C3B3FB94A5A93B4D3CBD68", hash_generated_field = "B61E43C3BF6C617E649EF3E8FA0B01BC")

        public static final int STATUS_UNHANDLED_HTTP_CODE = 494;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.282 -0400", hash_original_field = "64D3E1802C141C89CE2656E0C876E200", hash_generated_field = "8A3F09CB8D02F80A71933576DE6BC580")

        public static final int STATUS_HTTP_DATA_ERROR = 495;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.282 -0400", hash_original_field = "44F39D83AB676C9263A70DA2EE5EE781", hash_generated_field = "4D5C202EAE1A9AB9CAB18BD9A2DFD23F")

        public static final int STATUS_HTTP_EXCEPTION = 496;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.282 -0400", hash_original_field = "ED24BD13932C696F198949184B837522", hash_generated_field = "597BFEAB28215A70723ED8175152D3BF")

        public static final int STATUS_TOO_MANY_REDIRECTS = 497;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.282 -0400", hash_original_field = "F22EC75652018DAC84CB9F8DB038E5A1", hash_generated_field = "DB3EE0D6AF758EAA4F14D39222150B1A")

        public static final int STATUS_BLOCKED = 498;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.283 -0400", hash_original_field = "57B1AAFD9EF3E360B5F19F83DA747688", hash_generated_field = "8AFD22E9073E10A3BC6106DA63067AB4")

        public static final int VISIBILITY_VISIBLE = DownloadManager.Request.VISIBILITY_VISIBLE;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.283 -0400", hash_original_field = "234E457B823B16145C4B4146C661124C", hash_generated_field = "228082D58AD2DB0C061C92D8C7ED0404")

        public static final int VISIBILITY_VISIBLE_NOTIFY_COMPLETED =
                DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.283 -0400", hash_original_field = "4C141C70B4E2F49E1AF43CAB4B05B19B", hash_generated_field = "D7B83DB94501403C446B003FF3C4C516")

        public static final int VISIBILITY_HIDDEN = DownloadManager.Request.VISIBILITY_HIDDEN;
    }


    
}

