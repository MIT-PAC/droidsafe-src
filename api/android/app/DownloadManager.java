package android.app;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorWrapper;
import android.net.Uri;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.provider.Downloads;
import android.provider.Settings;
import android.provider.Settings.SettingNotFoundException;
import android.text.TextUtils;
import android.util.Pair;

public class DownloadManager {

    /**
     * Returns maximum size, in bytes, of downloads that may go over a mobile connection; or null if
     * there's no limit
     *
     * @param context the {@link Context} to use for accessing the {@link ContentResolver}
     * @return maximum size, in bytes, of downloads that may go over a mobile connection; or null if
     * there's no limit
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.322 -0500", hash_original_method = "40957C5003DF164899899BBA93624DC8", hash_generated_method = "2259D576AF4DBF3460D15E09CA681E98")
    
public static Long getMaxBytesOverMobile(Context context) {
        try {
            return Settings.Secure.getLong(context.getContentResolver(),
                    Settings.Secure.DOWNLOAD_MAX_BYTES_OVER_MOBILE);
        } catch (SettingNotFoundException exc) {
            return null;
        }
    }

    /**
     * Returns recommended maximum size, in bytes, of downloads that may go over a mobile
     * connection; or null if there's no recommended limit.  The user will have the option to bypass
     * this limit.
     *
     * @param context the {@link Context} to use for accessing the {@link ContentResolver}
     * @return recommended maximum size, in bytes, of downloads that may go over a mobile
     * connection; or null if there's no recommended limit.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.324 -0500", hash_original_method = "09D101EEE583F1F428ABFAC2A3E1C48B", hash_generated_method = "785E14E7905676E9853C42E4BF4DFE9B")
    
public static Long getRecommendedMaxBytesOverMobile(Context context) {
        try {
            return Settings.Secure.getLong(context.getContentResolver(),
                    Settings.Secure.DOWNLOAD_RECOMMENDED_MAX_BYTES_OVER_MOBILE);
        } catch (SettingNotFoundException exc) {
            return null;
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.332 -0500", hash_original_method = "84ECCC03BFC76932B52057F843DCE0B3", hash_generated_method = "BFBF9D603AFF992C4BDC463233917D80")
    
private static void validateArgumentIsNonEmpty(String paramName, String val) {
        if (TextUtils.isEmpty(val)) {
            throw new IllegalArgumentException(paramName + " can't be null");
        }
    }

    /**
     * Get a parameterized SQL WHERE clause to select a bunch of IDs.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.337 -0500", hash_original_method = "58FA33488269F1928D1ACA78136BAF7B", hash_generated_method = "220415491416EE285B2042B34738A83B")
    
static String getWhereClauseForIds(long[] ids) {
        StringBuilder whereClause = new StringBuilder();
        whereClause.append("(");
        for (int i = 0; i < ids.length; i++) {
            if (i > 0) {
                whereClause.append("OR ");
            }
            whereClause.append(Downloads.Impl._ID);
            whereClause.append(" = ? ");
        }
        whereClause.append(")");
        return whereClause.toString();
    }

    /**
     * Get the selection args for a clause returned by {@link #getWhereClauseForIds(long[])}.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.339 -0500", hash_original_method = "18769EFB7E28EF76AE4BA41FDCD2B58B", hash_generated_method = "7DB914CCE4DB3334C6CA4853316B3678")
    
static String[] getWhereArgsForIds(long[] ids) {
        String[] whereArgs = new String[ids.length];
        for (int i = 0; i < ids.length; i++) {
            whereArgs[i] = Long.toString(ids[i]);
        }
        return whereArgs;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.061 -0500", hash_original_field = "CB84910C1EC3C3F3FE416DBBC7BF0E8B", hash_generated_field = "A7E023A8D48EDA84D30E823FC247AC7D")

    public final static String COLUMN_ID = Downloads.Impl._ID;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.063 -0500", hash_original_field = "95495036E4CD10B59AE4A8CDA45C6D06", hash_generated_field = "E0475ED0F443C2F35BA6DAC29B806E15")

    public final static String COLUMN_TITLE = Downloads.Impl.COLUMN_TITLE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.066 -0500", hash_original_field = "298FDAE7417D4D56D210ACEE306675A0", hash_generated_field = "2ADDAD1D6BE2368DD43079C018505DC2")

    public final static String COLUMN_DESCRIPTION = Downloads.Impl.COLUMN_DESCRIPTION;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.068 -0500", hash_original_field = "D87F6D8996E9B2131A0B479738C87115", hash_generated_field = "143198F8ECD99C932C3BA352BDD7B4F6")

    public final static String COLUMN_URI = Downloads.Impl.COLUMN_URI;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.071 -0500", hash_original_field = "D13045CAEC26F89C179AA9A3F645E24E", hash_generated_field = "9BF784ED01C8E5392F5BB2D34F27F68B")

    public final static String COLUMN_MEDIA_TYPE = "media_type";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.073 -0500", hash_original_field = "45CA693D3EB635EC75189E11F74F07E3", hash_generated_field = "84BD203A764C2D32D032768E5BA85C6A")

    public final static String COLUMN_TOTAL_SIZE_BYTES = "total_size";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.075 -0500", hash_original_field = "34B54FF378AD0C36AF09E1AF72BEF8C8", hash_generated_field = "87092124AEB640ED262648BE065600C9")

    public final static String COLUMN_LOCAL_URI = "local_uri";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.078 -0500", hash_original_field = "A66249E5037940C8A6BF6B00587A3D03", hash_generated_field = "38930F295047A3F6AE0AC7B02C24770A")

    public final static String COLUMN_LOCAL_FILENAME = "local_filename";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.080 -0500", hash_original_field = "DFF67D7699EBA54BC8EBD3BC503E782E", hash_generated_field = "AD200817B86CDDB6809552A585F6F3CB")

    public final static String COLUMN_STATUS = Downloads.Impl.COLUMN_STATUS;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.083 -0500", hash_original_field = "C9B4C097B6B7E67D0F57789E67516E3E", hash_generated_field = "D7D42B4B48EDF0D303BF107E8C2B9639")

    public final static String COLUMN_REASON = "reason";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.085 -0500", hash_original_field = "3720F3516EE5C52FBCA29993975BD1A2", hash_generated_field = "E75A5474EBC7BBC6DB9427B4EA03D662")

    public final static String COLUMN_BYTES_DOWNLOADED_SO_FAR = "bytes_so_far";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.087 -0500", hash_original_field = "F2B6DF6F332227CA6E273F07E59BA467", hash_generated_field = "70EB989845348DC7DAA5AF45C362A8C0")

    public final static String COLUMN_LAST_MODIFIED_TIMESTAMP = "last_modified_timestamp";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.089 -0500", hash_original_field = "8855EA137B29D308CAA457DD1F6E292E", hash_generated_field = "E798B6BCD082848B6F5403070514339F")

    public static final String COLUMN_MEDIAPROVIDER_URI = Downloads.Impl.COLUMN_MEDIAPROVIDER_URI;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.092 -0500", hash_original_field = "487F26253F13AC0AC02BC04C30C5E7F2", hash_generated_field = "5A6A6A376CA33569B014DF98BB4486F5")

    public final static int STATUS_PENDING = 1 << 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.094 -0500", hash_original_field = "FDC0D3C4E44FF07FAC2FA5F2FA6E04C8", hash_generated_field = "DDF3A08F677DC31638E00F51A652178C")

    public final static int STATUS_RUNNING = 1 << 1;
    
    public static class Request {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.154 -0500", hash_original_field = "34AAE32633C2FC529AAA5F28B4CC5D3D", hash_generated_field = "2A08EDDDB593C12F8423C559DB638960")

        public static final int NETWORK_MOBILE = 1 << 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.157 -0500", hash_original_field = "CD18E20A008EC8C813269F23A3C7509E", hash_generated_field = "A0D2C438A9D332F064354E5B5CD56CD8")

        public static final int NETWORK_WIFI = 1 << 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.184 -0500", hash_original_field = "D4A79713383459B98FC0AE2964315B4E", hash_generated_field = "6644414BD8BF5CC6D8AD8B436963ECCC")

        private static final int SCANNABLE_VALUE_YES = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.187 -0500", hash_original_field = "91A8B00F64A4701C9C19AD1D0142A856", hash_generated_field = "A30C45D330314B4F88C84421EA968262")

        // MediaScanner
        /** if a file is designated as a file that should not be scanned by MediaScanner,
         * the following value is stored in the database column
         * {@link Downloads.Impl#COLUMN_MEDIA_SCANNED}.
         */
        private static final int SCANNABLE_VALUE_NO = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.189 -0500", hash_original_field = "4C2055E9BE6F186C7D161B4B8037C9C4", hash_generated_field = "678667850A54425C02D37FACB767853B")

        public static final int VISIBILITY_VISIBLE = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.192 -0500", hash_original_field = "39CD282B85EAF22F46988F28D0F66518", hash_generated_field = "F285E9AEAAA3AB3B3BF3A904EF1F15E0")

        public static final int VISIBILITY_VISIBLE_NOTIFY_COMPLETED = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.194 -0500", hash_original_field = "1D617B454276D9C4EEFF5184EAC02CE7", hash_generated_field = "7C647F96488D335DF451E9699546D435")

        public static final int VISIBILITY_HIDDEN = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.197 -0500", hash_original_field = "E5998916935931E828A8AA929E8AA6D6", hash_generated_field = "F99A308F434AB6F300224D2C143BC731")

        public static final int VISIBILITY_VISIBLE_NOTIFY_ONLY_COMPLETION = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.160 -0500", hash_original_field = "49226456B4CE4E55A779249DE3DC63D4", hash_generated_field = "04FA8EB5D9FB8AC4AAE6453BCF1BBF82")

        private Uri mUri;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.162 -0500", hash_original_field = "6C658875A9D361B2F63B3CA23BA7E0E7", hash_generated_field = "83BAA5C2BC0662F1D32FE83EA4951897")

        private Uri mDestinationUri;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.164 -0500", hash_original_field = "485F334D3262C1382AB4D39147634899", hash_generated_field = "13A8BF554467B5955E7580E17A5A2DDA")

        private List<Pair<String, String>> mRequestHeaders = new ArrayList<Pair<String, String>>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.166 -0500", hash_original_field = "8C445459F9A68BF8713F87AC9D695E47", hash_generated_field = "ECAB18871B55104BACD4283C12B1074D")

        private CharSequence mTitle;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.169 -0500", hash_original_field = "9F468A0F2DBE14B148495038BE3BEA0B", hash_generated_field = "18C3493923549BAE766F057DAF8B146B")

        private CharSequence mDescription;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.171 -0500", hash_original_field = "B161F982909610C03B68BAACDD54E076", hash_generated_field = "D6D2783B71AE4BF9CBF84D44336E2BF9")

        private String mMimeType;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.173 -0500", hash_original_field = "A3EC5EFE6EA35C45D375C7648A361736", hash_generated_field = "952A1377CC9FB93E78D671C8656DC930")

        private boolean mRoamingAllowed = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.175 -0500", hash_original_field = "5C165101149120E89A1022EE06CF4DBC", hash_generated_field = "5A39BA83CA95D987B9F58ECEB876274F")

        private int mAllowedNetworkTypes = ~0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.177 -0500", hash_original_field = "37CDCBA0FC5A0A1B5BD3A530F202B898", hash_generated_field = "CDF7B3598ECC145AEC167A93A8BA96F5")

        private boolean mIsVisibleInDownloadsUi = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.179 -0500", hash_original_field = "FC90C26117E5D887D0B68E7615353B82", hash_generated_field = "D6ACB722C57F150FD71504D93C5E360B")

        private boolean mScannable = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.181 -0500", hash_original_field = "88E8587EB47DE21166B66D0E16A0E67C", hash_generated_field = "3DE0461D1F897FC34AAEB85C39656726")

        private boolean mUseSystemCache = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.200 -0500", hash_original_field = "984D82AC64986F83FC10FF8F7A98F924", hash_generated_field = "BC737294552DD713920EAAEBBC85199C")

        private int mNotificationVisibility = VISIBILITY_VISIBLE;

        /**
         * @param uri the HTTP URI to download.
         */
        @DSComment("Formulating request to download")
        @DSSafe(DSCat.DATA_STRUCTURE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.202 -0500", hash_original_method = "38AB51743560DA4EF393F63C39D43853", hash_generated_method = "096BB787554DF617318716F9A3074D79")
        
public Request(Uri uri) {
            if (uri == null) {
                throw new NullPointerException();
            }
            String scheme = uri.getScheme();
            if (scheme == null || (!scheme.equals("http") && !scheme.equals("https"))) {
                throw new IllegalArgumentException("Can only download HTTP/HTTPS URIs: " + uri);
            }
            mUri = uri;
        }

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.205 -0500", hash_original_method = "DEE528427F50C6163D0C2E44786A5A1B", hash_generated_method = "DEE528427F50C6163D0C2E44786A5A1B")
        
Request(String uriString) {
            mUri = Uri.parse(uriString);
        }

        /**
         * Set the local destination for the downloaded file. Must be a file URI to a path on
         * external storage, and the calling application must have the WRITE_EXTERNAL_STORAGE
         * permission.
         * <p>
         * The downloaded file is not scanned by MediaScanner.
         * But it can be made scannable by calling {@link #allowScanningByMediaScanner()}.
         * <p>
         * By default, downloads are saved to a generated filename in the shared download cache and
         * may be deleted by the system at any time to reclaim space.
         *
         * @return this object
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.207 -0500", hash_original_method = "D90BC1E489B6C6F52B7EAE5F6B3F7838", hash_generated_method = "A976BB0A6A42ED3CBC6CBDB911D80471")
        
public Request setDestinationUri(Uri uri) {
            mDestinationUri = uri;
            return this;
        }

        /**
         * Set the local destination for the downloaded file to the system cache dir (/cache).
         * This is only available to System apps with the permission
         * {@link android.Manifest.permission#ACCESS_CACHE_FILESYSTEM}.
         * <p>
         * The downloaded file is not scanned by MediaScanner.
         * But it can be made scannable by calling {@link #allowScanningByMediaScanner()}.
         * <p>
         * Files downloaded to /cache may be deleted by the system at any time to reclaim space.
         *
         * @return this object
         * @hide
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.209 -0500", hash_original_method = "D82AD486A04E11ACCF6C157FAE4ED191", hash_generated_method = "E98F16ED67BAF6BED36557B9E229A958")
        
public Request setDestinationToSystemCache() {
            mUseSystemCache = true;
            return this;
        }

        /**
         * Set the local destination for the downloaded file to a path within the application's
         * external files directory (as returned by {@link Context#getExternalFilesDir(String)}.
         * <p>
         * The downloaded file is not scanned by MediaScanner.
         * But it can be made scannable by calling {@link #allowScanningByMediaScanner()}.
         *
         * @param context the {@link Context} to use in determining the external files directory
         * @param dirType the directory type to pass to {@link Context#getExternalFilesDir(String)}
         * @param subPath the path within the external directory, including the destination filename
         * @return this object
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.211 -0500", hash_original_method = "D36C94DA39C2A5C5097A71BFF458D119", hash_generated_method = "6C1FFE43F5201F96007F6892F1F4A8D4")
        
public Request setDestinationInExternalFilesDir(Context context, String dirType,
                String subPath) {
            setDestinationFromBase(context.getExternalFilesDir(dirType), subPath);
            return this;
        }

        /**
         * Set the local destination for the downloaded file to a path within the public external
         * storage directory (as returned by
         * {@link Environment#getExternalStoragePublicDirectory(String)}.
         *<p>
         * The downloaded file is not scanned by MediaScanner.
         * But it can be made scannable by calling {@link #allowScanningByMediaScanner()}.
         *
         * @param dirType the directory type to pass to
         *        {@link Environment#getExternalStoragePublicDirectory(String)}
         * @param subPath the path within the external directory, including the destination filename
         * @return this object
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.214 -0500", hash_original_method = "DE3A2CC0AFE35B8C7E88937E379D2ACE", hash_generated_method = "BC5D5E7089488ADF5AE7C5531EFD4A21")
        
public Request setDestinationInExternalPublicDir(String dirType, String subPath) {
            File file = Environment.getExternalStoragePublicDirectory(dirType);
            if (file.exists()) {
                if (!file.isDirectory()) {
                    throw new IllegalStateException(file.getAbsolutePath() +
                            " already exists and is not a directory");
                }
            } else {
                if (!file.mkdir()) {
                    throw new IllegalStateException("Unable to create directory: "+
                            file.getAbsolutePath());
                }
            }
            setDestinationFromBase(file, subPath);
            return this;
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.217 -0500", hash_original_method = "53900E0DE3709F8E65CE6AB9A613EA7C", hash_generated_method = "54B99ABCE4759B5DFBB833E8E956CD7B")
        
private void setDestinationFromBase(File base, String subPath) {
            if (subPath == null) {
                throw new NullPointerException("subPath cannot be null");
            }
            mDestinationUri = Uri.withAppendedPath(Uri.fromFile(base), subPath);
        }

        /**
         * If the file to be downloaded is to be scanned by MediaScanner, this method
         * should be called before {@link DownloadManager#enqueue(Request)} is called.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.219 -0500", hash_original_method = "39458C7E93B4E0F8CC50399F7846AF71", hash_generated_method = "3501D5A13151BD07AF9926CB88529F8F")
        
public void allowScanningByMediaScanner() {
            mScannable = true;
        }

        /**
         * Add an HTTP header to be included with the download request.  The header will be added to
         * the end of the list.
         * @param header HTTP header name
         * @param value header value
         * @return this object
         * @see <a href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec4.html#sec4.2">HTTP/1.1
         *      Message Headers</a>
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.221 -0500", hash_original_method = "84826A0727261744241F6F54A16F49D4", hash_generated_method = "A36C205E088A9E4C3D9C93BF346D1FC0")
        
public Request addRequestHeader(String header, String value) {
            if (header == null) {
                throw new NullPointerException("header cannot be null");
            }
            if (header.contains(":")) {
                throw new IllegalArgumentException("header may not contain ':'");
            }
            if (value == null) {
                value = "";
            }
            mRequestHeaders.add(Pair.create(header, value));
            return this;
        }

        /**
         * Set the title of this download, to be displayed in notifications (if enabled).  If no
         * title is given, a default one will be assigned based on the download filename, once the
         * download starts.
         * @return this object
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.223 -0500", hash_original_method = "D2617ADF02871E26D8818B6B93DA088D", hash_generated_method = "961D5A3917CF533C5A73BF022132F3C1")
        
public Request setTitle(CharSequence title) {
            mTitle = title;
            return this;
        }

        /**
         * Set a description of this download, to be displayed in notifications (if enabled)
         * @return this object
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.225 -0500", hash_original_method = "3BFD78827604EC47FE3892636D121D42", hash_generated_method = "1B94AFBF651A491856C55DB06D4053FB")
        
public Request setDescription(CharSequence description) {
            mDescription = description;
            return this;
        }

        /**
         * Set the MIME content type of this download.  This will override the content type declared
         * in the server's response.
         * @see <a href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec3.html#sec3.7">HTTP/1.1
         *      Media Types</a>
         * @return this object
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.227 -0500", hash_original_method = "EAEBE95F38EAF7D74F8EC9BD89175C39", hash_generated_method = "2FA4D8F585088F3EB05BED4F56013FF7")
        
public Request setMimeType(String mimeType) {
            mMimeType = mimeType;
            return this;
        }

        /**
         * Control whether a system notification is posted by the download manager while this
         * download is running. If enabled, the download manager posts notifications about downloads
         * through the system {@link android.app.NotificationManager}. By default, a notification is
         * shown.
         *
         * If set to false, this requires the permission
         * android.permission.DOWNLOAD_WITHOUT_NOTIFICATION.
         *
         * @param show whether the download manager should show a notification for this download.
         * @return this object
         * @deprecated use {@link #setNotificationVisibility(int)}
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.229 -0500", hash_original_method = "F75AFBEFCFC8BE21F83F018EA7CEB6E1", hash_generated_method = "D90D354525ABD060F8B8C95F36F9C80C")
        
@Deprecated
        public Request setShowRunningNotification(boolean show) {
            return (show) ? setNotificationVisibility(VISIBILITY_VISIBLE) :
                    setNotificationVisibility(VISIBILITY_HIDDEN);
        }

        /**
         * Control whether a system notification is posted by the download manager while this
         * download is running or when it is completed.
         * If enabled, the download manager posts notifications about downloads
         * through the system {@link android.app.NotificationManager}.
         * By default, a notification is shown only when the download is in progress.
         *<p>
         * It can take the following values: {@link #VISIBILITY_HIDDEN},
         * {@link #VISIBILITY_VISIBLE},
         * {@link #VISIBILITY_VISIBLE_NOTIFY_COMPLETED}.
         *<p>
         * If set to {@link #VISIBILITY_HIDDEN}, this requires the permission
         * android.permission.DOWNLOAD_WITHOUT_NOTIFICATION.
         *
         * @param visibility the visibility setting value
         * @return this object
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.232 -0500", hash_original_method = "0E1BEC1EE7CB7BCA18E6C69650765291", hash_generated_method = "0E52DB0A77A35281626B3C1CF28503E5")
        
public Request setNotificationVisibility(int visibility) {
            mNotificationVisibility = visibility;
            return this;
        }

        /**
         * Restrict the types of networks over which this download may proceed.  By default, all
         * network types are allowed.
         * @param flags any combination of the NETWORK_* bit flags.
         * @return this object
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.234 -0500", hash_original_method = "1FB95247AA3BF4BC290C0031C887893C", hash_generated_method = "6135FA39CD5CB54658A2552178F20F74")
        
public Request setAllowedNetworkTypes(int flags) {
            mAllowedNetworkTypes = flags;
            return this;
        }

        /**
         * Set whether this download may proceed over a roaming connection.  By default, roaming is
         * allowed.
         * @param allowed whether to allow a roaming connection to be used
         * @return this object
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.236 -0500", hash_original_method = "EED7837CFCCAA493B8F853E6287613BD", hash_generated_method = "48D13C56E48CEF8E066FC870AE7337F3")
        
public Request setAllowedOverRoaming(boolean allowed) {
            mRoamingAllowed = allowed;
            return this;
        }

        /**
         * Set whether this download should be displayed in the system's Downloads UI. True by
         * default.
         * @param isVisible whether to display this download in the Downloads UI
         * @return this object
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.240 -0500", hash_original_method = "865D9FB8BB624139754E18F2F470A937", hash_generated_method = "E20BC2500DC6F65449B4D2406C98F1E1")
        
public Request setVisibleInDownloadsUi(boolean isVisible) {
            mIsVisibleInDownloadsUi = isVisible;
            return this;
        }

        /**
         * @return ContentValues to be passed to DownloadProvider.insert()
         */
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.243 -0500", hash_original_method = "A794ABF9FD18E330B670B5AD24CF2800", hash_generated_method = "42CAA0C4E10C8216BBA189F252261D49")
        
ContentValues toContentValues(String packageName) {
            ContentValues values = new ContentValues();
            assert mUri != null;
            values.put(Downloads.Impl.COLUMN_URI, mUri.toString());
            values.put(Downloads.Impl.COLUMN_IS_PUBLIC_API, true);
            values.put(Downloads.Impl.COLUMN_NOTIFICATION_PACKAGE, packageName);

            if (mDestinationUri != null) {
                values.put(Downloads.Impl.COLUMN_DESTINATION, Downloads.Impl.DESTINATION_FILE_URI);
                values.put(Downloads.Impl.COLUMN_FILE_NAME_HINT, mDestinationUri.toString());
            } else {
                values.put(Downloads.Impl.COLUMN_DESTINATION,
                           (this.mUseSystemCache) ?
                                   Downloads.Impl.DESTINATION_SYSTEMCACHE_PARTITION :
                                   Downloads.Impl.DESTINATION_CACHE_PARTITION_PURGEABLE);
            }
            // is the file supposed to be media-scannable?
            values.put(Downloads.Impl.COLUMN_MEDIA_SCANNED, (mScannable) ? SCANNABLE_VALUE_YES :
                    SCANNABLE_VALUE_NO);

            if (!mRequestHeaders.isEmpty()) {
                encodeHttpHeaders(values);
            }

            putIfNonNull(values, Downloads.Impl.COLUMN_TITLE, mTitle);
            putIfNonNull(values, Downloads.Impl.COLUMN_DESCRIPTION, mDescription);
            putIfNonNull(values, Downloads.Impl.COLUMN_MIME_TYPE, mMimeType);

            values.put(Downloads.Impl.COLUMN_VISIBILITY, mNotificationVisibility);
            values.put(Downloads.Impl.COLUMN_ALLOWED_NETWORK_TYPES, mAllowedNetworkTypes);
            values.put(Downloads.Impl.COLUMN_ALLOW_ROAMING, mRoamingAllowed);
            values.put(Downloads.Impl.COLUMN_IS_VISIBLE_IN_DOWNLOADS_UI, mIsVisibleInDownloadsUi);

            return values;
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.245 -0500", hash_original_method = "26D27F1BE5E3A68003877A062F0DAD99", hash_generated_method = "413384943EE25FF07BBAB4BC2FB2171C")
        
private void encodeHttpHeaders(ContentValues values) {
            int index = 0;
            for (Pair<String, String> header : mRequestHeaders) {
                String headerString = header.first + ": " + header.second;
                values.put(Downloads.Impl.RequestHeaders.INSERT_KEY_PREFIX + index, headerString);
                index++;
            }
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.247 -0500", hash_original_method = "19BA5B9D42AC58D8841CDF02C796EE38", hash_generated_method = "C5A82A9F598709FF9CD8CD7A261A76DE")
        
private void putIfNonNull(ContentValues contentValues, String key, Object value) {
            if (value != null) {
                contentValues.put(key, value.toString());
            }
        }
    }
    
    public static class Query {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.255 -0500", hash_original_field = "6EBAC7E6F58EC7F4CA632A08808D4745", hash_generated_field = "33AF9DE750C57D52372B21F0E7746D47")

        public static final int ORDER_ASCENDING = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.257 -0500", hash_original_field = "EAB4B5CF855BBC732872934D457DEF7A", hash_generated_field = "2CF799A3EEA7BC4C831B8EB82D2B58DE")

        public static final int ORDER_DESCENDING = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.260 -0500", hash_original_field = "E92E843A274AA67C68B06CB672417BD6", hash_generated_field = "5F8E81DCB2F7B395E24A391C0FACBDE6")

        private long[] mIds = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.262 -0500", hash_original_field = "1DFA2135BEE4B07438926787FA0F3FD0", hash_generated_field = "F78B9285416B8C880978036645800403")

        private Integer mStatusFlags = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.264 -0500", hash_original_field = "10D499FC6B1078BF3D37FDD1D50CB9F9", hash_generated_field = "39E6027705921A51748F7FC07E010111")

        private String mOrderByColumn = Downloads.Impl.COLUMN_LAST_MODIFICATION;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.266 -0500", hash_original_field = "04FCB4CC5EB491E4AAF2527AABADDBC3", hash_generated_field = "EED59D0671C844A1902BF26138BB3F37")

        private int mOrderDirection = ORDER_DESCENDING;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.268 -0500", hash_original_field = "8BCEB1862554D9C37D9507D6C98AB632", hash_generated_field = "964B69564A78D777DDBF359D9B2AA67B")

        private boolean mOnlyIncludeVisibleInDownloadsUi = false;
        
        @DSComment("Formulating request to download")
        @DSSafe(DSCat.DATA_STRUCTURE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:53.054 -0400", hash_original_method = "EFCA8790A91D69466A874AF6524F8E69", hash_generated_method = "EFCA8790A91D69466A874AF6524F8E69")
        public Query ()
        {
            //Synthesized constructor
        }

        /**
         * Include only the downloads with the given IDs.
         * @return this object
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.270 -0500", hash_original_method = "782D3BAE9A57AE7F89D5C5E0BBC212BD", hash_generated_method = "97772D317D9F256D0A6807C763524088")
        
public Query setFilterById(long... ids) {
            mIds = ids;
            return this;
        }

        /**
         * Include only downloads with status matching any the given status flags.
         * @param flags any combination of the STATUS_* bit flags
         * @return this object
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.272 -0500", hash_original_method = "CE9295EE41F323C50B34B72F478BD4C2", hash_generated_method = "D5B7CAEED13489D23C2D8659EBCC30DF")
        
public Query setFilterByStatus(int flags) {
            mStatusFlags = flags;
            return this;
        }

        /**
         * Controls whether this query includes downloads not visible in the system's Downloads UI.
         * @param value if true, this query will only include downloads that should be displayed in
         *            the system's Downloads UI; if false (the default), this query will include
         *            both visible and invisible downloads.
         * @return this object
         * @hide
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.275 -0500", hash_original_method = "9600119EF208E670C5EE47F5F776ED3A", hash_generated_method = "D8A347DE267898614A533654BC957197")
        
public Query setOnlyIncludeVisibleInDownloadsUi(boolean value) {
            mOnlyIncludeVisibleInDownloadsUi = value;
            return this;
        }

        /**
         * Change the sort order of the returned Cursor.
         *
         * @param column one of the COLUMN_* constants; currently, only
         *         {@link #COLUMN_LAST_MODIFIED_TIMESTAMP} and {@link #COLUMN_TOTAL_SIZE_BYTES} are
         *         supported.
         * @param direction either {@link #ORDER_ASCENDING} or {@link #ORDER_DESCENDING}
         * @return this object
         * @hide
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.278 -0500", hash_original_method = "969F069748FB75BDEDE2897D8F038415", hash_generated_method = "D4CDD87FAE7CA4C2F40C5A9FA4450F03")
        
public Query orderBy(String column, int direction) {
            if (direction != ORDER_ASCENDING && direction != ORDER_DESCENDING) {
                throw new IllegalArgumentException("Invalid direction: " + direction);
            }

            if (column.equals(COLUMN_LAST_MODIFIED_TIMESTAMP)) {
                mOrderByColumn = Downloads.Impl.COLUMN_LAST_MODIFICATION;
            } else if (column.equals(COLUMN_TOTAL_SIZE_BYTES)) {
                mOrderByColumn = Downloads.Impl.COLUMN_TOTAL_BYTES;
            } else {
                throw new IllegalArgumentException("Cannot order by " + column);
            }
            mOrderDirection = direction;
            return this;
        }

        /**
         * Run this query using the given ContentResolver.
         * @param projection the projection to pass to ContentResolver.query()
         * @return the Cursor returned by ContentResolver.query()
         */
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.281 -0500", hash_original_method = "3E117BB34A8C7FFA67D17AB4CC250832", hash_generated_method = "DAA7599D89038CFF9301BC5C895B0144")
        
Cursor runQuery(ContentResolver resolver, String[] projection, Uri baseUri) {
            Uri uri = baseUri;
            List<String> selectionParts = new ArrayList<String>();
            String[] selectionArgs = null;

            if (mIds != null) {
                selectionParts.add(getWhereClauseForIds(mIds));
                selectionArgs = getWhereArgsForIds(mIds);
            }

            if (mStatusFlags != null) {
                List<String> parts = new ArrayList<String>();
                if ((mStatusFlags & STATUS_PENDING) != 0) {
                    parts.add(statusClause("=", Downloads.Impl.STATUS_PENDING));
                }
                if ((mStatusFlags & STATUS_RUNNING) != 0) {
                    parts.add(statusClause("=", Downloads.Impl.STATUS_RUNNING));
                }
                if ((mStatusFlags & STATUS_PAUSED) != 0) {
                    parts.add(statusClause("=", Downloads.Impl.STATUS_PAUSED_BY_APP));
                    parts.add(statusClause("=", Downloads.Impl.STATUS_WAITING_TO_RETRY));
                    parts.add(statusClause("=", Downloads.Impl.STATUS_WAITING_FOR_NETWORK));
                    parts.add(statusClause("=", Downloads.Impl.STATUS_QUEUED_FOR_WIFI));
                }
                if ((mStatusFlags & STATUS_SUCCESSFUL) != 0) {
                    parts.add(statusClause("=", Downloads.Impl.STATUS_SUCCESS));
                }
                if ((mStatusFlags & STATUS_FAILED) != 0) {
                    parts.add("(" + statusClause(">=", 400)
                              + " AND " + statusClause("<", 600) + ")");
                }
                selectionParts.add(joinStrings(" OR ", parts));
            }

            if (mOnlyIncludeVisibleInDownloadsUi) {
                selectionParts.add(Downloads.Impl.COLUMN_IS_VISIBLE_IN_DOWNLOADS_UI + " != '0'");
            }

            // only return rows which are not marked 'deleted = 1'
            selectionParts.add(Downloads.Impl.COLUMN_DELETED + " != '1'");

            String selection = joinStrings(" AND ", selectionParts);
            String orderDirection = (mOrderDirection == ORDER_ASCENDING ? "ASC" : "DESC");
            String orderBy = mOrderByColumn + " " + orderDirection;

            return resolver.query(uri, projection, selection, selectionArgs, orderBy);
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.284 -0500", hash_original_method = "E982889F0CE13C731CA9D89AB5FD3B78", hash_generated_method = "57723C7A553B25E7484933DE4FA21283")
        
private String joinStrings(String joiner, Iterable<String> parts) {
            StringBuilder builder = new StringBuilder();
            boolean first = true;
            for (String part : parts) {
                if (!first) {
                    builder.append(joiner);
                }
                builder.append(part);
                first = false;
            }
            return builder.toString();
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.286 -0500", hash_original_method = "F1C2C126003D565FB51A9C1A25E86357", hash_generated_method = "81C724EE30870939B7326C4556372EBA")
        
private String statusClause(String operator, int value) {
            return Downloads.Impl.COLUMN_STATUS + operator + "'" + value + "'";
        }
    }
    
    private static class CursorTranslator extends CursorWrapper {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.342 -0500", hash_original_field = "BAA66B2FF4013EF5EF0725340E08B737", hash_generated_field = "352FDC66A51EED366C84411537612673")

        private Uri mBaseUri;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.344 -0500", hash_original_method = "DA2C30EB999FAADAF9AB1439D3B9F223", hash_generated_method = "E8C7E794E8ADE1C39D845A433C5182E5")
        
public CursorTranslator(Cursor cursor, Uri baseUri) {
            super(cursor);
            mBaseUri = baseUri;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.346 -0500", hash_original_method = "34538125BB8387937A75DA11F9FB5B65", hash_generated_method = "E10ECDBF2C54F04D7FF9A1CA174DCCBE")
        
@Override
        public int getInt(int columnIndex) {
            return (int) getLong(columnIndex);
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.349 -0500", hash_original_method = "744FA54C78DD5C7B6737C741AD0EB8F1", hash_generated_method = "0D6EDC1E2F6C5CBF721F5287DD1EEAD1")
        
@Override
        public long getLong(int columnIndex) {
            if (getColumnName(columnIndex).equals(COLUMN_REASON)) {
                return getReason(super.getInt(getColumnIndex(Downloads.Impl.COLUMN_STATUS)));
            } else if (getColumnName(columnIndex).equals(COLUMN_STATUS)) {
                return translateStatus(super.getInt(getColumnIndex(Downloads.Impl.COLUMN_STATUS)));
            } else {
                return super.getLong(columnIndex);
            }
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.352 -0500", hash_original_method = "2A6CC35BB4DF843267A861B5828C6994", hash_generated_method = "929012F2E107068061EF91058A6E83D5")
        
@Override
        public String getString(int columnIndex) {
            return (getColumnName(columnIndex).equals(COLUMN_LOCAL_URI)) ? getLocalUri() :
                    super.getString(columnIndex);
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.354 -0500", hash_original_method = "C2F388AD18BA84031DEC0607FBEAB7C5", hash_generated_method = "3377C7763DFFB9934FEBD99B84F91314")
        
private String getLocalUri() {
            long destinationType = getLong(getColumnIndex(Downloads.Impl.COLUMN_DESTINATION));
            if (destinationType == Downloads.Impl.DESTINATION_FILE_URI ||
                    destinationType == Downloads.Impl.DESTINATION_EXTERNAL ||
                    destinationType == Downloads.Impl.DESTINATION_NON_DOWNLOADMANAGER_DOWNLOAD) {
                String localPath = getString(getColumnIndex(COLUMN_LOCAL_FILENAME));
                if (localPath == null) {
                    return null;
                }
                return Uri.fromFile(new File(localPath)).toString();
            }

            // return content URI for cache download
            long downloadId = getLong(getColumnIndex(Downloads.Impl._ID));
            return ContentUris.withAppendedId(mBaseUri, downloadId).toString();
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.356 -0500", hash_original_method = "A69C93787DF2FD0B667931CA82E74881", hash_generated_method = "20DEA6E2661124B48C431CEB910A1249")
        
private long getReason(int status) {
            switch (translateStatus(status)) {
                case STATUS_FAILED:
                    return getErrorCode(status);

                case STATUS_PAUSED:
                    return getPausedReason(status);

                default:
                    return 0; // arbitrary value when status is not an error
            }
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.358 -0500", hash_original_method = "8BF9F68328111BA50CCB78B1792F76F0", hash_generated_method = "2A0069F7861C1B95A00AFD0562DDBFD9")
        
private long getPausedReason(int status) {
            switch (status) {
                case Downloads.Impl.STATUS_WAITING_TO_RETRY:
                    return PAUSED_WAITING_TO_RETRY;

                case Downloads.Impl.STATUS_WAITING_FOR_NETWORK:
                    return PAUSED_WAITING_FOR_NETWORK;

                case Downloads.Impl.STATUS_QUEUED_FOR_WIFI:
                    return PAUSED_QUEUED_FOR_WIFI;

                default:
                    return PAUSED_UNKNOWN;
            }
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.361 -0500", hash_original_method = "A27080D0C32BDBDFED7217EFE39DC72F", hash_generated_method = "ECE7754021DA5E8ED32EDCC50D1D6B87")
        
private long getErrorCode(int status) {
            if ((400 <= status && status < Downloads.Impl.MIN_ARTIFICIAL_ERROR_STATUS)
                    || (500 <= status && status < 600)) {
                // HTTP status code
                return status;
            }

            switch (status) {
                case Downloads.Impl.STATUS_FILE_ERROR:
                    return ERROR_FILE_ERROR;

                case Downloads.Impl.STATUS_UNHANDLED_HTTP_CODE:
                case Downloads.Impl.STATUS_UNHANDLED_REDIRECT:
                    return ERROR_UNHANDLED_HTTP_CODE;

                case Downloads.Impl.STATUS_HTTP_DATA_ERROR:
                    return ERROR_HTTP_DATA_ERROR;

                case Downloads.Impl.STATUS_TOO_MANY_REDIRECTS:
                    return ERROR_TOO_MANY_REDIRECTS;

                case Downloads.Impl.STATUS_INSUFFICIENT_SPACE_ERROR:
                    return ERROR_INSUFFICIENT_SPACE;

                case Downloads.Impl.STATUS_DEVICE_NOT_FOUND_ERROR:
                    return ERROR_DEVICE_NOT_FOUND;

                case Downloads.Impl.STATUS_CANNOT_RESUME:
                    return ERROR_CANNOT_RESUME;

                case Downloads.Impl.STATUS_FILE_ALREADY_EXISTS_ERROR:
                    return ERROR_FILE_ALREADY_EXISTS;

                case Downloads.Impl.STATUS_BLOCKED:
                    return ERROR_BLOCKED;

                default:
                    return ERROR_UNKNOWN;
            }
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.364 -0500", hash_original_method = "AC0B465D7BF7B10F5608906AFAA7CE72", hash_generated_method = "5994EBD05BD1AB259151C8084D984FF7")
        
private int translateStatus(int status) {
            switch (status) {
                case Downloads.Impl.STATUS_PENDING:
                    return STATUS_PENDING;

                case Downloads.Impl.STATUS_RUNNING:
                    return STATUS_RUNNING;

                case Downloads.Impl.STATUS_PAUSED_BY_APP:
                case Downloads.Impl.STATUS_WAITING_TO_RETRY:
                case Downloads.Impl.STATUS_WAITING_FOR_NETWORK:
                case Downloads.Impl.STATUS_QUEUED_FOR_WIFI:
                    return STATUS_PAUSED;

                case Downloads.Impl.STATUS_SUCCESS:
                    return STATUS_SUCCESSFUL;

                default:
                    assert Downloads.Impl.isStatusError(status);
                    return STATUS_FAILED;
            }
        }
        
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.097 -0500", hash_original_field = "696ACAA095AB9B422196CF224B0C3BC6", hash_generated_field = "B6CF42D4BE6CC4E35C56FF7AFD758358")

    public final static int STATUS_PAUSED = 1 << 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.099 -0500", hash_original_field = "8C4F417419DA100D9CCCEB9DE3DF0C02", hash_generated_field = "16CE303BA58E19D2E9F3935ACB3CE0FB")

    public final static int STATUS_SUCCESSFUL = 1 << 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.102 -0500", hash_original_field = "87F73CB89FC74BC301646DAD19B8DE68", hash_generated_field = "1BCCE4C740453C51D27A9C44E3F68B40")

    public final static int STATUS_FAILED = 1 << 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.104 -0500", hash_original_field = "FAC3A928ED1BA99E388A190A1E0269E5", hash_generated_field = "49F5D6EC283C95877C76975EF6E926C6")

    public final static int ERROR_UNKNOWN = 1000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.106 -0500", hash_original_field = "37B50D186CA61B80ED25BCBC5F26E98E", hash_generated_field = "0E73FEF6AA8AAE6DB010C8400B9928BE")

    public final static int ERROR_FILE_ERROR = 1001;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.108 -0500", hash_original_field = "AD4BCADDF1E0FE17BBF50A050B0DEC3F", hash_generated_field = "1AC4CB82DAEB32AFCC84E359B353A84E")

    public final static int ERROR_UNHANDLED_HTTP_CODE = 1002;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.111 -0500", hash_original_field = "7EF5F9F32A9C16714396917053605E1A", hash_generated_field = "7D7BB2F4DF6F4E9B6967224CE2FAF5E8")

    public final static int ERROR_HTTP_DATA_ERROR = 1004;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.113 -0500", hash_original_field = "AB752E2589144147F0BE023E11D73701", hash_generated_field = "7D1894872E657F2F1D75836AC335D1AF")

    public final static int ERROR_TOO_MANY_REDIRECTS = 1005;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.115 -0500", hash_original_field = "60FE0B28BDABB3E3EF0760A4DEF6DFFF", hash_generated_field = "4745C1817D6FFD01542FD1D7B9BCDF6B")

    public final static int ERROR_INSUFFICIENT_SPACE = 1006;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.118 -0500", hash_original_field = "8B48BCFA7E355BBC380B7C5937940F51", hash_generated_field = "D22E5678B4FACB05F514DC5331AD6F98")

    public final static int ERROR_DEVICE_NOT_FOUND = 1007;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.120 -0500", hash_original_field = "9294899CB600A1A15F324300E382639C", hash_generated_field = "310C5FB2CCFCEBB3F61B6B0F16B85CE9")

    public final static int ERROR_CANNOT_RESUME = 1008;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.122 -0500", hash_original_field = "2D010621866A351AFF4CED33B981398E", hash_generated_field = "03022A2BA7BEFEFA9680B89BFC241220")

    public final static int ERROR_FILE_ALREADY_EXISTS = 1009;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.125 -0500", hash_original_field = "1AB2DD35D9A22157F228774F63A93BBD", hash_generated_field = "95F9CC4D3D18A2E56CF90C0970647D3D")

    public final static int ERROR_BLOCKED = 1010;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.127 -0500", hash_original_field = "2419089A5AD41DF8651F79A449FE3D86", hash_generated_field = "375A127B5A11AB6F86CDA6C2E7687C81")

    public final static int PAUSED_WAITING_TO_RETRY = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.129 -0500", hash_original_field = "5A9392182BB6D588DA4F5B6E601C8507", hash_generated_field = "1AB4E417B461169A72753CA5536FB9C8")

    public final static int PAUSED_WAITING_FOR_NETWORK = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.132 -0500", hash_original_field = "2555D5F49EA2AC81FF50CE5D7A8FF017", hash_generated_field = "4C94328F0C2918D47EFCEA3271E499DF")

    public final static int PAUSED_QUEUED_FOR_WIFI = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.134 -0500", hash_original_field = "85F603FDAF9EF97A6A48A04BEF4DA5A3", hash_generated_field = "4D9D144F191E78908A11C759352904B6")

    public final static int PAUSED_UNKNOWN = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.136 -0500", hash_original_field = "12152209913869ACD97034AE06AE19CB", hash_generated_field = "F59DDF2C5961F68B20C867F8313BBEFB")

    public final static String ACTION_DOWNLOAD_COMPLETE = "android.intent.action.DOWNLOAD_COMPLETE";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.138 -0500", hash_original_field = "4ABB7637530E8370304C1CF46398F70D", hash_generated_field = "C99B78141EF70699F8A2ED7E9CB8DD42")

    public final static String ACTION_NOTIFICATION_CLICKED =
            "android.intent.action.DOWNLOAD_NOTIFICATION_CLICKED";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.141 -0500", hash_original_field = "9CA8272CA4E132421E7D8C74CA34EDAD", hash_generated_field = "DE2A2BF8E91A6F3A9065C043915477FB")

    public final static String ACTION_VIEW_DOWNLOADS = "android.intent.action.VIEW_DOWNLOADS";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.144 -0500", hash_original_field = "C257C64477CD29A577436DC8B92A4BBF", hash_generated_field = "3301DDAE8E2BAA3A9528297879FE4303")

    public final static String INTENT_EXTRAS_SORT_BY_SIZE =
            "android.app.DownloadManager.extra_sortBySize";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.146 -0500", hash_original_field = "F414D33DA4FFD100F4EA4015A03422E2", hash_generated_field = "937B93366C4C3FE30B8BE2FA09D9B445")

    public static final String EXTRA_DOWNLOAD_ID = "extra_download_id";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.148 -0500", hash_original_field = "9AB0F78517A5B37AE4775FC3941AA90B", hash_generated_field = "4DF09F4FBB097DF9B81CC166A5136DAA")

    public static final String EXTRA_NOTIFICATION_CLICK_DOWNLOAD_IDS = "extra_click_download_ids";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.151 -0500", hash_original_field = "28211A6DBEE466E37FA8EBF4743C7653", hash_generated_field = "5D547EE5EDD8D4E5F3A84560D4BC2EC6")

    public static final String[] UNDERLYING_COLUMNS = new String[] {
        Downloads.Impl._ID,
        Downloads.Impl._DATA + " AS " + COLUMN_LOCAL_FILENAME,
        Downloads.Impl.COLUMN_MEDIAPROVIDER_URI,
        Downloads.Impl.COLUMN_DESTINATION,
        Downloads.Impl.COLUMN_TITLE,
        Downloads.Impl.COLUMN_DESCRIPTION,
        Downloads.Impl.COLUMN_URI,
        Downloads.Impl.COLUMN_STATUS,
        Downloads.Impl.COLUMN_FILE_NAME_HINT,
        Downloads.Impl.COLUMN_MIME_TYPE + " AS " + COLUMN_MEDIA_TYPE,
        Downloads.Impl.COLUMN_TOTAL_BYTES + " AS " + COLUMN_TOTAL_SIZE_BYTES,
        Downloads.Impl.COLUMN_LAST_MODIFICATION + " AS " + COLUMN_LAST_MODIFIED_TIMESTAMP,
        Downloads.Impl.COLUMN_CURRENT_BYTES + " AS " + COLUMN_BYTES_DOWNLOADED_SO_FAR,
        /* add the following 'computed' columns to the cursor.
         * they are not 'returned' by the database, but their inclusion
         * eliminates need to have lot of methods in CursorTranslator
         */
        "'placeholder' AS " + COLUMN_LOCAL_URI,
        "'placeholder' AS " + COLUMN_REASON
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.330 -0500", hash_original_field = "9F7BFE93CC62EF63B18BC1521B460342", hash_generated_field = "7F3BE0CBA2F29054F2C27E2E352EC965")

    private static final String NON_DOWNLOADMANAGER_DOWNLOAD =
            "non-dwnldmngr-download-dont-retry2download";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.292 -0500", hash_original_field = "D9EFC53032006A099035E3EBF749F453", hash_generated_field = "2ABF989C5B8F051BCBEE638ED1EA2586")

    private ContentResolver mResolver;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.294 -0500", hash_original_field = "7A5990DF4A54BF373C395B6501E20B02", hash_generated_field = "6F81845A3A2771C3EC987E5A01DBA4C6")

    private String mPackageName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.296 -0500", hash_original_field = "73E2161A66146F76EE6ECF66DC981BF9", hash_generated_field = "1AFB71B4D196CA91BC22831E08A191CF")

    private Uri mBaseUri = Downloads.Impl.CONTENT_URI;

    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.299 -0500", hash_original_method = "E62D0E970789924902081BF03F031FF8", hash_generated_method = "B9A2FEA616C5D3AF741821E2DE5D7276")
    
public DownloadManager(ContentResolver resolver, String packageName) {
        mResolver = resolver;
        mPackageName = packageName;
    }

    /**
     * Makes this object access the download provider through /all_downloads URIs rather than
     * /my_downloads URIs, for clients that have permission to do so.
     * @hide
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.301 -0500", hash_original_method = "93AAF1C0A18C9EFC24526B178CE628E3", hash_generated_method = "B6D9A7874E112639A963C2842C6A60FF")
    
public void setAccessAllDownloads(boolean accessAllDownloads) {
        if (accessAllDownloads) {
            mBaseUri = Downloads.Impl.ALL_DOWNLOADS_CONTENT_URI;
        } else {
            mBaseUri = Downloads.Impl.CONTENT_URI;
        }
    }

    /**
     * Enqueue a new download.  The download will start automatically once the download manager is
     * ready to execute it and connectivity is available.
     *
     * @param request the parameters specifying this download
     * @return an ID for the download, unique across the system.  This ID is used to make future
     * calls related to this download.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.303 -0500", hash_original_method = "A2E8022D1487E0DC7C6CC7B8DABAC46D", hash_generated_method = "2712DC25701C2412109D20CF38B652E3")
    
public long enqueue(Request request) {
        ContentValues values = request.toContentValues(mPackageName);
        Uri downloadUri = mResolver.insert(Downloads.Impl.CONTENT_URI, values);
        long id = Long.parseLong(downloadUri.getLastPathSegment());
        return id;
    }

    /**
     * Marks the specified download as 'to be deleted'. This is done when a completed download
     * is to be removed but the row was stored without enough info to delete the corresponding
     * metadata from Mediaprovider database. Actual cleanup of this row is done in DownloadService.
     *
     * @param ids the IDs of the downloads to be marked 'deleted'
     * @return the number of downloads actually updated
     * @hide
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.305 -0500", hash_original_method = "6A912115CBBE4D263FCD27B2696D5371", hash_generated_method = "064D786D7C16F2FBA0BDD430C5FF9CA7")
    
public int markRowDeleted(long... ids) {
        if (ids == null || ids.length == 0) {
            // called with nothing to remove!
            throw new IllegalArgumentException("input param 'ids' can't be null");
        }
        ContentValues values = new ContentValues();
        values.put(Downloads.Impl.COLUMN_DELETED, 1);
        // if only one id is passed in, then include it in the uri itself.
        // this will eliminate a full database scan in the download service.
        if (ids.length == 1) {
            return mResolver.update(ContentUris.withAppendedId(mBaseUri, ids[0]), values,
                    null, null);
        } 
        return mResolver.update(mBaseUri, values, getWhereClauseForIds(ids),
                getWhereArgsForIds(ids));
    }

    /**
     * Cancel downloads and remove them from the download manager.  Each download will be stopped if
     * it was running, and it will no longer be accessible through the download manager.
     * If there is a downloaded file, partial or complete, it is deleted.
     *
     * @param ids the IDs of the downloads to remove
     * @return the number of downloads actually removed
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.308 -0500", hash_original_method = "E87735CFC3568A22F95F85C3BABBD5E2", hash_generated_method = "1BCB57549E8D5FC89BAEB4083D3C579A")
    
public int remove(long... ids) {
        return markRowDeleted(ids);
    }

    /**
     * Query the download manager about downloads that have been requested.
     * @param query parameters specifying filters for this query
     * @return a Cursor over the result set of downloads, with columns consisting of all the
     * COLUMN_* constants.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.309 -0500", hash_original_method = "AA3C14DF1A360F6707C442D7B10D5AD3", hash_generated_method = "A19296660FFFEF5084831EBC6F0048F3")
    
public Cursor query(Query query) {
        Cursor underlyingCursor = query.runQuery(mResolver, UNDERLYING_COLUMNS, mBaseUri);
        if (underlyingCursor == null) {
            return null;
        }
        return new CursorTranslator(underlyingCursor, mBaseUri);
    }

    /**
     * Open a downloaded file for reading.  The download must have completed.
     * @param id the ID of the download
     * @return a read-only {@link ParcelFileDescriptor}
     * @throws FileNotFoundException if the destination file does not already exist
     */
    @DSSink({DSSinkKind.FILE})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.312 -0500", hash_original_method = "41561235219E48E784E85B3D8CB5CB93", hash_generated_method = "84C045836AE6DFB7D5B0A78EC05DE96A")
    
public ParcelFileDescriptor openDownloadedFile(long id) throws FileNotFoundException {
        return mResolver.openFileDescriptor(getDownloadUri(id), "r");
    }

    /**
     * Returns {@link Uri} for the given downloaded file id, if the file is
     * downloaded successfully. otherwise, null is returned.
     *<p>
     * If the specified downloaded file is in external storage (for example, /sdcard dir),
     * then it is assumed to be safe for anyone to read and the returned {@link Uri} corresponds
     * to the filepath on sdcard.
     *
     * @param id the id of the downloaded file.
     * @return the {@link Uri} for the given downloaded file id, if download was successful. null
     * otherwise.
     */
    @DSComment("Request/Change/Listen Android Manger")
    @DSSpec(DSCat.ANDROID_MANAGER)
    @DSSource({DSSourceKind.FILE_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.314 -0500", hash_original_method = "82FD0DABBA6B80B8B4BA3DF76B66A3D1", hash_generated_method = "5267155AA394E91A4D5F97C5C7CD51C4")
    
public Uri getUriForDownloadedFile(long id) {
        // to check if the file is in cache, get its destination from the database
        Query query = new Query().setFilterById(id);
        Cursor cursor = null;
        try {
            cursor = query(query);
            if (cursor == null) {
                return null;
            }
            if (cursor.moveToFirst()) {
                int status = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_STATUS));
                if (DownloadManager.STATUS_SUCCESSFUL == status) {
                    int indx = cursor.getColumnIndexOrThrow(
                            Downloads.Impl.COLUMN_DESTINATION);
                    int destination = cursor.getInt(indx);
                    // TODO: if we ever add API to DownloadManager to let the caller specify
                    // non-external storage for a downloaded file, then the following code
                    // should also check for that destination.
                    if (destination == Downloads.Impl.DESTINATION_CACHE_PARTITION ||
                            destination == Downloads.Impl.DESTINATION_SYSTEMCACHE_PARTITION ||
                            destination == Downloads.Impl.DESTINATION_CACHE_PARTITION_NOROAMING ||
                            destination == Downloads.Impl.DESTINATION_CACHE_PARTITION_PURGEABLE) {
                        // return private uri
                        return ContentUris.withAppendedId(Downloads.Impl.CONTENT_URI, id);
                    } else {
                        // return public uri
                        String path = cursor.getString(
                                cursor.getColumnIndexOrThrow(COLUMN_LOCAL_FILENAME));
                        return Uri.fromFile(new File(path));
                    }
                }
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        // downloaded file not found or its status is not 'successfully completed'
        return null;
    }

    /**
     * Returns {@link Uri} for the given downloaded file id, if the file is
     * downloaded successfully. otherwise, null is returned.
     *<p>
     * If the specified downloaded file is in external storage (for example, /sdcard dir),
     * then it is assumed to be safe for anyone to read and the returned {@link Uri} corresponds
     * to the filepath on sdcard.
     *
     * @param id the id of the downloaded file.
     * @return the {@link Uri} for the given downloaded file id, if download was successful. null
     * otherwise.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.317 -0500", hash_original_method = "EC65E8932FA161BF4DAEC74FC802F48D", hash_generated_method = "EB14CD0D70CA24E0BB9121EAFEC0367A")
    
public String getMimeTypeForDownloadedFile(long id) {
        Query query = new Query().setFilterById(id);
        Cursor cursor = null;
        try {
            cursor = query(query);
            if (cursor == null) {
                return null;
            }
            while (cursor.moveToFirst()) {
                return cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_MEDIA_TYPE));
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        // downloaded file not found or its status is not 'successfully completed'
        return null;
    }

    /**
     * Restart the given downloads, which must have already completed (successfully or not).  This
     * method will only work when called from within the download manager's process.
     * @param ids the IDs of the downloads
     * @hide
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.319 -0500", hash_original_method = "ABDC33D84A29539A96C484C81BD10405", hash_generated_method = "865818060927F98B30D45F5724B92304")
    
public void restartDownload(long... ids) {
        Cursor cursor = query(new Query().setFilterById(ids));
        try {
            for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
                int status = cursor.getInt(cursor.getColumnIndex(COLUMN_STATUS));
                if (status != STATUS_SUCCESSFUL && status != STATUS_FAILED) {
                    throw new IllegalArgumentException("Cannot restart incomplete download: "
                            + cursor.getLong(cursor.getColumnIndex(COLUMN_ID)));
                }
            }
        } finally {
            cursor.close();
        }

        ContentValues values = new ContentValues();
        values.put(Downloads.Impl.COLUMN_CURRENT_BYTES, 0);
        values.put(Downloads.Impl.COLUMN_TOTAL_BYTES, -1);
        values.putNull(Downloads.Impl._DATA);
        values.put(Downloads.Impl.COLUMN_STATUS, Downloads.Impl.STATUS_PENDING);
        mResolver.update(mBaseUri, values, getWhereClauseForIds(ids), getWhereArgsForIds(ids));
    }

    /**
     * Adds a file to the downloads database system, so it could appear in Downloads App
     * (and thus become eligible for management by the Downloads App).
     * <p>
     * It is helpful to make the file scannable by MediaScanner by setting the param
     * isMediaScannerScannable to true. It makes the file visible in media managing
     * applications such as Gallery App, which could be a useful purpose of using this API.
     *
     * @param title the title that would appear for this file in Downloads App.
     * @param description the description that would appear for this file in Downloads App.
     * @param isMediaScannerScannable true if the file is to be scanned by MediaScanner. Files
     * scanned by MediaScanner appear in the applications used to view media (for example,
     * Gallery app).
     * @param mimeType mimetype of the file.
     * @param path absolute pathname to the file. The file should be world-readable, so that it can
     * be managed by the Downloads App and any other app that is used to read it (for example,
     * Gallery app to display the file, if the file contents represent a video/image).
     * @param length length of the downloaded file
     * @param showNotification true if a notification is to be sent, false otherwise
     * @return  an ID for the download entry added to the downloads app, unique across the system
     * This ID is used to make future calls related to this download.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.327 -0500", hash_original_method = "58F6793B30C14E2CFD3653910A805BA2", hash_generated_method = "D6CA73B06B0115738CCFC5715639C99F")
    
public long addCompletedDownload(String title, String description,
            boolean isMediaScannerScannable, String mimeType, String path, long length,
            boolean showNotification) {
        // make sure the input args are non-null/non-zero
        validateArgumentIsNonEmpty("title", title);
        validateArgumentIsNonEmpty("description", description);
        validateArgumentIsNonEmpty("path", path);
        validateArgumentIsNonEmpty("mimeType", mimeType);
        if (length <= 0) {
            throw new IllegalArgumentException(" invalid value for param: totalBytes");
        }

        // if there is already an entry with the given path name in downloads.db, return its id
        Request request = new Request(NON_DOWNLOADMANAGER_DOWNLOAD)
                .setTitle(title)
                .setDescription(description)
                .setMimeType(mimeType);
        ContentValues values = request.toContentValues(null);
        values.put(Downloads.Impl.COLUMN_DESTINATION,
                Downloads.Impl.DESTINATION_NON_DOWNLOADMANAGER_DOWNLOAD);
        values.put(Downloads.Impl._DATA, path);
        values.put(Downloads.Impl.COLUMN_STATUS, Downloads.Impl.STATUS_SUCCESS);
        values.put(Downloads.Impl.COLUMN_TOTAL_BYTES, length);
        values.put(Downloads.Impl.COLUMN_MEDIA_SCANNED,
                (isMediaScannerScannable) ? Request.SCANNABLE_VALUE_YES :
                        Request.SCANNABLE_VALUE_NO);
        values.put(Downloads.Impl.COLUMN_VISIBILITY, (showNotification) ?
                Request.VISIBILITY_VISIBLE_NOTIFY_ONLY_COMPLETION : Request.VISIBILITY_HIDDEN);
        Uri downloadUri = mResolver.insert(Downloads.Impl.CONTENT_URI, values);
        if (downloadUri == null) {
            return -1;
        }
        return Long.parseLong(downloadUri.getLastPathSegment());
    }

    /**
     * Get the DownloadProvider URI for the download with the given ID.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.FILE_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:27.334 -0500", hash_original_method = "D1EE950396677328804F68406B4587AE", hash_generated_method = "D1EE950396677328804F68406B4587AE")
    
Uri getDownloadUri(long id) {
        return ContentUris.withAppendedId(mBaseUri, id);
    }
}

