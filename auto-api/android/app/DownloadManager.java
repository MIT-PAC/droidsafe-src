package android.app;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorWrapper;
import android.net.ConnectivityManager;
import android.net.NetworkPolicyManager;
import android.net.Uri;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.provider.Downloads;
import android.provider.Settings;
import android.provider.Settings.SettingNotFoundException;
import android.text.TextUtils;
import android.util.Pair;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class DownloadManager {
    private ContentResolver mResolver;
    private String mPackageName;
    private Uri mBaseUri = Downloads.Impl.CONTENT_URI;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.393 -0400", hash_original_method = "E62D0E970789924902081BF03F031FF8", hash_generated_method = "E7A64ED22CA8D39E2CFE42BB195380B1")
    @DSModeled(DSC.SAFE)
    public DownloadManager(ContentResolver resolver, String packageName) {
        dsTaint.addTaint(packageName);
        dsTaint.addTaint(resolver.dsTaint);
        // ---------- Original Method ----------
        //mResolver = resolver;
        //mPackageName = packageName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.393 -0400", hash_original_method = "93AAF1C0A18C9EFC24526B178CE628E3", hash_generated_method = "60A23719EE8E9FD1FDD3828F11D7FDEB")
    @DSModeled(DSC.SAFE)
    public void setAccessAllDownloads(boolean accessAllDownloads) {
        dsTaint.addTaint(accessAllDownloads);
        {
            mBaseUri = Downloads.Impl.ALL_DOWNLOADS_CONTENT_URI;
        } //End block
        {
            mBaseUri = Downloads.Impl.CONTENT_URI;
        } //End block
        // ---------- Original Method ----------
        //if (accessAllDownloads) {
            //mBaseUri = Downloads.Impl.ALL_DOWNLOADS_CONTENT_URI;
        //} else {
            //mBaseUri = Downloads.Impl.CONTENT_URI;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.394 -0400", hash_original_method = "A2E8022D1487E0DC7C6CC7B8DABAC46D", hash_generated_method = "D2EC2642D6504D46F7931DD25B6E696C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long enqueue(Request request) {
        dsTaint.addTaint(request.dsTaint);
        ContentValues values;
        values = request.toContentValues(mPackageName);
        Uri downloadUri;
        downloadUri = mResolver.insert(Downloads.Impl.CONTENT_URI, values);
        long id;
        id = Long.parseLong(downloadUri.getLastPathSegment());
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //ContentValues values = request.toContentValues(mPackageName);
        //Uri downloadUri = mResolver.insert(Downloads.Impl.CONTENT_URI, values);
        //long id = Long.parseLong(downloadUri.getLastPathSegment());
        //return id;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.394 -0400", hash_original_method = "6A912115CBBE4D263FCD27B2696D5371", hash_generated_method = "6A76B3935632BB326BD49908E51CE90C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int markRowDeleted(long... ids) {
        dsTaint.addTaint(ids[0]);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("input param 'ids' can't be null");
        } //End block
        ContentValues values;
        values = new ContentValues();
        values.put(Downloads.Impl.COLUMN_DELETED, 1);
        {
            int var393CDEAF16A98CB7AA432C3584D5C8FE_1464498816 = (mResolver.update(ContentUris.withAppendedId(mBaseUri, ids[0]), values,
                    null, null));
        } //End block
        int varA0E20C895CB99149E1A0E29E0C592FBD_722433236 = (mResolver.update(mBaseUri, values, getWhereClauseForIds(ids),
                getWhereArgsForIds(ids)));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (ids == null || ids.length == 0) {
            //throw new IllegalArgumentException("input param 'ids' can't be null");
        //}
        //ContentValues values = new ContentValues();
        //values.put(Downloads.Impl.COLUMN_DELETED, 1);
        //if (ids.length == 1) {
            //return mResolver.update(ContentUris.withAppendedId(mBaseUri, ids[0]), values,
                    //null, null);
        //}
        //return mResolver.update(mBaseUri, values, getWhereClauseForIds(ids),
                //getWhereArgsForIds(ids));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.395 -0400", hash_original_method = "E87735CFC3568A22F95F85C3BABBD5E2", hash_generated_method = "738F3A822344DF700949064225373536")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int remove(long... ids) {
        dsTaint.addTaint(ids[0]);
        int var0D18E7E451A7FE8C6FC024A1060C0496_1465373063 = (markRowDeleted(ids));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return markRowDeleted(ids);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.395 -0400", hash_original_method = "AA3C14DF1A360F6707C442D7B10D5AD3", hash_generated_method = "6E09E49E0003E8C550D49B0505946FFD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Cursor query(Query query) {
        dsTaint.addTaint(query.dsTaint);
        Cursor underlyingCursor;
        underlyingCursor = query.runQuery(mResolver, UNDERLYING_COLUMNS, mBaseUri);
        Cursor varD5AA743567C639EEE89DC01AB450CC3F_1310077284 = (new CursorTranslator(underlyingCursor, mBaseUri));
        return (Cursor)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Cursor underlyingCursor = query.runQuery(mResolver, UNDERLYING_COLUMNS, mBaseUri);
        //if (underlyingCursor == null) {
            //return null;
        //}
        //return new CursorTranslator(underlyingCursor, mBaseUri);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.396 -0400", hash_original_method = "41561235219E48E784E85B3D8CB5CB93", hash_generated_method = "67BDBA74D2D8B7A18D0871C28BFD644C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ParcelFileDescriptor openDownloadedFile(long id) throws FileNotFoundException {
        dsTaint.addTaint(id);
        ParcelFileDescriptor varCB6960E142FA9B798F8E0A15EE33C2E5_915286707 = (mResolver.openFileDescriptor(getDownloadUri(id), "r"));
        return (ParcelFileDescriptor)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mResolver.openFileDescriptor(getDownloadUri(id), "r");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.397 -0400", hash_original_method = "82FD0DABBA6B80B8B4BA3DF76B66A3D1", hash_generated_method = "7E07643E0DA468861BB2C21524C26037")
    @DSModeled(DSC.SPEC)
    public Uri getUriForDownloadedFile(long id) {
        dsTaint.addTaint(id);
        Query query;
        query = new Query().setFilterById(id);
        Cursor cursor;
        cursor = null;
        try 
        {
            cursor = query(query);
            {
                boolean varCDEB7019138899FEAFBEC62FC2A4BF86_2021874894 = (cursor.moveToFirst());
                {
                    int status;
                    status = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_STATUS));
                    {
                        int indx;
                        indx = cursor.getColumnIndexOrThrow(
                            Downloads.Impl.COLUMN_DESTINATION);
                        int destination;
                        destination = cursor.getInt(indx);
                        {
                            Uri varDD0416423CBB25CC8D54BDAC3B6F104C_1474685220 = (ContentUris.withAppendedId(Downloads.Impl.CONTENT_URI, id));
                        } //End block
                        {
                            String path;
                            path = cursor.getString(
                                cursor.getColumnIndexOrThrow(COLUMN_LOCAL_FILENAME));
                            Uri var6D606BED2EAC443ABA66B96810ACD4A2_894265996 = (Uri.fromFile(new File(path)));
                        } //End block
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        finally 
        {
            {
                cursor.close();
            } //End block
        } //End block
        return (Uri)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.397 -0400", hash_original_method = "EC65E8932FA161BF4DAEC74FC802F48D", hash_generated_method = "A9557F86255BFC9F222C505F7B144814")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getMimeTypeForDownloadedFile(long id) {
        dsTaint.addTaint(id);
        Query query;
        query = new Query().setFilterById(id);
        Cursor cursor;
        cursor = null;
        try 
        {
            cursor = query(query);
            {
                boolean varCDEB7019138899FEAFBEC62FC2A4BF86_932127531 = (cursor.moveToFirst());
                {
                    String var50CEE1B788593327F0962B9200E8D0D4_1062812116 = (cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_MEDIA_TYPE)));
                } //End block
            } //End collapsed parenthetic
        } //End block
        finally 
        {
            {
                cursor.close();
            } //End block
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //Query query = new Query().setFilterById(id);
        //Cursor cursor = null;
        //try {
            //cursor = query(query);
            //if (cursor == null) {
                //return null;
            //}
            //while (cursor.moveToFirst()) {
                //return cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_MEDIA_TYPE));
            //}
        //} finally {
            //if (cursor != null) {
                //cursor.close();
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.398 -0400", hash_original_method = "ABDC33D84A29539A96C484C81BD10405", hash_generated_method = "80E9A9F5078C1EE3CB15684115A4A21F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void restartDownload(long... ids) {
        dsTaint.addTaint(ids[0]);
        Cursor cursor;
        cursor = query(new Query().setFilterById(ids));
        try 
        {
            {
                cursor.moveToFirst();
                boolean varC9BB7A46744D2622E2F78BF928704FDD_1656988349 = (!cursor.isAfterLast());
                cursor.moveToNext();
                {
                    int status;
                    status = cursor.getInt(cursor.getColumnIndex(COLUMN_STATUS));
                    {
                        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Cannot restart incomplete download: "
                            + cursor.getLong(cursor.getColumnIndex(COLUMN_ID)));
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        finally 
        {
            cursor.close();
        } //End block
        ContentValues values;
        values = new ContentValues();
        values.put(Downloads.Impl.COLUMN_CURRENT_BYTES, 0);
        values.put(Downloads.Impl.COLUMN_TOTAL_BYTES, -1);
        values.putNull(Downloads.Impl._DATA);
        values.put(Downloads.Impl.COLUMN_STATUS, Downloads.Impl.STATUS_PENDING);
        mResolver.update(mBaseUri, values, getWhereClauseForIds(ids), getWhereArgsForIds(ids));
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        public static Long getMaxBytesOverMobile(Context context) {
        try {
            return Settings.Secure.getLong(context.getContentResolver(),
                    Settings.Secure.DOWNLOAD_MAX_BYTES_OVER_MOBILE);
        } catch (SettingNotFoundException exc) {
            return null;
        }
    }

    
        public static Long getRecommendedMaxBytesOverMobile(Context context) {
        try {
            return Settings.Secure.getLong(context.getContentResolver(),
                    Settings.Secure.DOWNLOAD_RECOMMENDED_MAX_BYTES_OVER_MOBILE);
        } catch (SettingNotFoundException exc) {
            return null;
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.399 -0400", hash_original_method = "58F6793B30C14E2CFD3653910A805BA2", hash_generated_method = "C45A1652B4A11AFFE51E7DADFABC3907")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long addCompletedDownload(String title, String description,
            boolean isMediaScannerScannable, String mimeType, String path, long length,
            boolean showNotification) {
        dsTaint.addTaint(showNotification);
        dsTaint.addTaint(title);
        dsTaint.addTaint(isMediaScannerScannable);
        dsTaint.addTaint(description);
        dsTaint.addTaint(length);
        dsTaint.addTaint(path);
        dsTaint.addTaint(mimeType);
        validateArgumentIsNonEmpty("title", title);
        validateArgumentIsNonEmpty("description", description);
        validateArgumentIsNonEmpty("path", path);
        validateArgumentIsNonEmpty("mimeType", mimeType);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(" invalid value for param: totalBytes");
        } //End block
        Request request;
        request = new Request(NON_DOWNLOADMANAGER_DOWNLOAD)
                .setTitle(title)
                .setDescription(description)
                .setMimeType(mimeType);
        ContentValues values;
        values = request.toContentValues(null);
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
        Uri downloadUri;
        downloadUri = mResolver.insert(Downloads.Impl.CONTENT_URI, values);
        long varA2F7CDA3EACA1ABC1BF253D57B57724C_1620222764 = (Long.parseLong(downloadUri.getLastPathSegment()));
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        private static void validateArgumentIsNonEmpty(String paramName, String val) {
        if (TextUtils.isEmpty(val)) {
            throw new IllegalArgumentException(paramName + " can't be null");
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.400 -0400", hash_original_method = "D1EE950396677328804F68406B4587AE", hash_generated_method = "3D896EFAC10F87A744D930F220EFEC4F")
    @DSModeled(DSC.SPEC)
     Uri getDownloadUri(long id) {
        dsTaint.addTaint(id);
        Uri var60A0AA9845E051D4E7C58878D90D5DCF_606234006 = (ContentUris.withAppendedId(mBaseUri, id));
        return (Uri)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return ContentUris.withAppendedId(mBaseUri, id);
    }

    
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

    
        static String[] getWhereArgsForIds(long[] ids) {
        String[] whereArgs = new String[ids.length];
        for (int i = 0; i < ids.length; i++) {
            whereArgs[i] = Long.toString(ids[i]);
        }
        return whereArgs;
    }

    
    public static class Request {
        private Uri mUri;
        private Uri mDestinationUri;
        private List<Pair<String, String>> mRequestHeaders = new ArrayList<Pair<String, String>>();
        private CharSequence mTitle;
        private CharSequence mDescription;
        private String mMimeType;
        private boolean mRoamingAllowed = true;
        private int mAllowedNetworkTypes = ~0;
        private boolean mIsVisibleInDownloadsUi = true;
        private boolean mScannable = false;
        private boolean mUseSystemCache = false;
        private int mNotificationVisibility = VISIBILITY_VISIBLE;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.401 -0400", hash_original_method = "38AB51743560DA4EF393F63C39D43853", hash_generated_method = "62B09617479C3B52585F0DD40C68E19D")
        @DSModeled(DSC.SPEC)
        public Request(Uri uri) {
            dsTaint.addTaint(uri.dsTaint);
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            } //End block
            String scheme;
            scheme = uri.getScheme();
            {
                boolean var697E1C480030E2C3839AD6831BF2A446_647123816 = (scheme == null || (!scheme.equals("http") && !scheme.equals("https")));
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Can only download HTTP/HTTPS URIs: " + uri);
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //if (uri == null) {
                //throw new NullPointerException();
            //}
            //String scheme = uri.getScheme();
            //if (scheme == null || (!scheme.equals("http") && !scheme.equals("https"))) {
                //throw new IllegalArgumentException("Can only download HTTP/HTTPS URIs: " + uri);
            //}
            //mUri = uri;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.402 -0400", hash_original_method = "DEE528427F50C6163D0C2E44786A5A1B", hash_generated_method = "325F49A0748436478B774C25EBDDF40D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         Request(String uriString) {
            dsTaint.addTaint(uriString);
            mUri = Uri.parse(uriString);
            // ---------- Original Method ----------
            //mUri = Uri.parse(uriString);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.402 -0400", hash_original_method = "D90BC1E489B6C6F52B7EAE5F6B3F7838", hash_generated_method = "1B134842C2E27AA0A0758B803E45AE30")
        @DSModeled(DSC.SPEC)
        public Request setDestinationUri(Uri uri) {
            dsTaint.addTaint(uri.dsTaint);
            return (Request)dsTaint.getTaint();
            // ---------- Original Method ----------
            //mDestinationUri = uri;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.402 -0400", hash_original_method = "D82AD486A04E11ACCF6C157FAE4ED191", hash_generated_method = "5A7C9BA8C59745E07B6A1E4B402C1378")
        @DSModeled(DSC.SAFE)
        public Request setDestinationToSystemCache() {
            mUseSystemCache = true;
            return (Request)dsTaint.getTaint();
            // ---------- Original Method ----------
            //mUseSystemCache = true;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.403 -0400", hash_original_method = "D36C94DA39C2A5C5097A71BFF458D119", hash_generated_method = "CCC1F8369E0C21C3ACD45CC3677EB0B1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Request setDestinationInExternalFilesDir(Context context, String dirType,
                String subPath) {
            dsTaint.addTaint(subPath);
            dsTaint.addTaint(dirType);
            dsTaint.addTaint(context.dsTaint);
            setDestinationFromBase(context.getExternalFilesDir(dirType), subPath);
            return (Request)dsTaint.getTaint();
            // ---------- Original Method ----------
            //setDestinationFromBase(context.getExternalFilesDir(dirType), subPath);
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.403 -0400", hash_original_method = "DE3A2CC0AFE35B8C7E88937E379D2ACE", hash_generated_method = "A4E7D301FBC69BAB52465A1AAD727900")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Request setDestinationInExternalPublicDir(String dirType, String subPath) {
            dsTaint.addTaint(subPath);
            dsTaint.addTaint(dirType);
            File file;
            file = Environment.getExternalStoragePublicDirectory(dirType);
            {
                boolean var59AA0F7651ECC78FBF1607A856F762E1_394582779 = (file.exists());
                {
                    {
                        boolean var64D52B1E6C0DE0079880D4A605C58A0F_1612622433 = (!file.isDirectory());
                        {
                            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(file.getAbsolutePath() +
                            " already exists and is not a directory");
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    {
                        boolean var5FE45863B1A6CF5B78D16EE3A822F850_308473713 = (!file.mkdir());
                        {
                            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Unable to create directory: "+
                            file.getAbsolutePath());
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            setDestinationFromBase(file, subPath);
            return (Request)dsTaint.getTaint();
            // ---------- Original Method ----------
            //File file = Environment.getExternalStoragePublicDirectory(dirType);
            //if (file.exists()) {
                //if (!file.isDirectory()) {
                    //throw new IllegalStateException(file.getAbsolutePath() +
                            //" already exists and is not a directory");
                //}
            //} else {
                //if (!file.mkdir()) {
                    //throw new IllegalStateException("Unable to create directory: "+
                            //file.getAbsolutePath());
                //}
            //}
            //setDestinationFromBase(file, subPath);
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.404 -0400", hash_original_method = "53900E0DE3709F8E65CE6AB9A613EA7C", hash_generated_method = "8EC90A9C77960D6E748A27929604D622")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void setDestinationFromBase(File base, String subPath) {
            dsTaint.addTaint(subPath);
            dsTaint.addTaint(base.dsTaint);
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException("subPath cannot be null");
            } //End block
            mDestinationUri = Uri.withAppendedPath(Uri.fromFile(base), subPath);
            // ---------- Original Method ----------
            //if (subPath == null) {
                //throw new NullPointerException("subPath cannot be null");
            //}
            //mDestinationUri = Uri.withAppendedPath(Uri.fromFile(base), subPath);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.404 -0400", hash_original_method = "39458C7E93B4E0F8CC50399F7846AF71", hash_generated_method = "C96F98A19F0478D3BC60EAEC74698C65")
        @DSModeled(DSC.SAFE)
        public void allowScanningByMediaScanner() {
            mScannable = true;
            // ---------- Original Method ----------
            //mScannable = true;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.405 -0400", hash_original_method = "84826A0727261744241F6F54A16F49D4", hash_generated_method = "C27E4075BED06BD5910AA6C8BD9F930C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Request addRequestHeader(String header, String value) {
            dsTaint.addTaint(value);
            dsTaint.addTaint(header);
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException("header cannot be null");
            } //End block
            {
                boolean varDC5B1563EB0301505BACEAFD06DE4615_847655149 = (header.contains(":"));
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("header may not contain ':'");
                } //End block
            } //End collapsed parenthetic
            {
                value = "";
            } //End block
            mRequestHeaders.add(Pair.create(header, value));
            return (Request)dsTaint.getTaint();
            // ---------- Original Method ----------
            //if (header == null) {
                //throw new NullPointerException("header cannot be null");
            //}
            //if (header.contains(":")) {
                //throw new IllegalArgumentException("header may not contain ':'");
            //}
            //if (value == null) {
                //value = "";
            //}
            //mRequestHeaders.add(Pair.create(header, value));
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.405 -0400", hash_original_method = "D2617ADF02871E26D8818B6B93DA088D", hash_generated_method = "CC94E6D5E4D9BB1E1EC8F6E4181E8142")
        @DSModeled(DSC.SAFE)
        public Request setTitle(CharSequence title) {
            dsTaint.addTaint(title);
            return (Request)dsTaint.getTaint();
            // ---------- Original Method ----------
            //mTitle = title;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.406 -0400", hash_original_method = "3BFD78827604EC47FE3892636D121D42", hash_generated_method = "F0ECC9A2027CDE44B3DF93CCD3EE2042")
        @DSModeled(DSC.SAFE)
        public Request setDescription(CharSequence description) {
            dsTaint.addTaint(description);
            return (Request)dsTaint.getTaint();
            // ---------- Original Method ----------
            //mDescription = description;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.406 -0400", hash_original_method = "EAEBE95F38EAF7D74F8EC9BD89175C39", hash_generated_method = "96B36157850D0B989873209DF2A7F299")
        @DSModeled(DSC.SAFE)
        public Request setMimeType(String mimeType) {
            dsTaint.addTaint(mimeType);
            return (Request)dsTaint.getTaint();
            // ---------- Original Method ----------
            //mMimeType = mimeType;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.407 -0400", hash_original_method = "F75AFBEFCFC8BE21F83F018EA7CEB6E1", hash_generated_method = "A0EF775849688DAB8BEC0163341912E3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Deprecated
        public Request setShowRunningNotification(boolean show) {
            dsTaint.addTaint(show);
            {
                Object var55DFD9A4D8B904A9BB036B8C693EDD14_1804278409 = (setNotificationVisibility(VISIBILITY_VISIBLE));
                Object varFC92039E72D9B2DCE24942407B8FE127_1845397297 = (setNotificationVisibility(VISIBILITY_HIDDEN));
            } //End flattened ternary
            return (Request)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return (show) ? setNotificationVisibility(VISIBILITY_VISIBLE) :
                    //setNotificationVisibility(VISIBILITY_HIDDEN);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.407 -0400", hash_original_method = "0E1BEC1EE7CB7BCA18E6C69650765291", hash_generated_method = "A2D2EBD79460A8DB54C4B78E84E8AB33")
        @DSModeled(DSC.SAFE)
        public Request setNotificationVisibility(int visibility) {
            dsTaint.addTaint(visibility);
            return (Request)dsTaint.getTaint();
            // ---------- Original Method ----------
            //mNotificationVisibility = visibility;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.407 -0400", hash_original_method = "1FB95247AA3BF4BC290C0031C887893C", hash_generated_method = "5DE92E9B3C9F6B57ACD93040D36A4CCB")
        @DSModeled(DSC.SAFE)
        public Request setAllowedNetworkTypes(int flags) {
            dsTaint.addTaint(flags);
            return (Request)dsTaint.getTaint();
            // ---------- Original Method ----------
            //mAllowedNetworkTypes = flags;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.408 -0400", hash_original_method = "EED7837CFCCAA493B8F853E6287613BD", hash_generated_method = "D7FDE58D87A27E85396FB5E8D4A210A4")
        @DSModeled(DSC.SAFE)
        public Request setAllowedOverRoaming(boolean allowed) {
            dsTaint.addTaint(allowed);
            return (Request)dsTaint.getTaint();
            // ---------- Original Method ----------
            //mRoamingAllowed = allowed;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.408 -0400", hash_original_method = "865D9FB8BB624139754E18F2F470A937", hash_generated_method = "AE8C4E069D7C931B01AEDFBFDE694826")
        @DSModeled(DSC.SAFE)
        public Request setVisibleInDownloadsUi(boolean isVisible) {
            dsTaint.addTaint(isVisible);
            return (Request)dsTaint.getTaint();
            // ---------- Original Method ----------
            //mIsVisibleInDownloadsUi = isVisible;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.409 -0400", hash_original_method = "A794ABF9FD18E330B670B5AD24CF2800", hash_generated_method = "BF781F11997F31330173CE85D681C94E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         ContentValues toContentValues(String packageName) {
            dsTaint.addTaint(packageName);
            ContentValues values;
            values = new ContentValues();
            values.put(Downloads.Impl.COLUMN_URI, mUri.toString());
            values.put(Downloads.Impl.COLUMN_IS_PUBLIC_API, true);
            values.put(Downloads.Impl.COLUMN_NOTIFICATION_PACKAGE, packageName);
            {
                values.put(Downloads.Impl.COLUMN_DESTINATION, Downloads.Impl.DESTINATION_FILE_URI);
                values.put(Downloads.Impl.COLUMN_FILE_NAME_HINT, mDestinationUri.toString());
            } //End block
            {
                values.put(Downloads.Impl.COLUMN_DESTINATION,
                           (this.mUseSystemCache) ?
                                   Downloads.Impl.DESTINATION_SYSTEMCACHE_PARTITION :
                                   Downloads.Impl.DESTINATION_CACHE_PARTITION_PURGEABLE);
            } //End block
            values.put(Downloads.Impl.COLUMN_MEDIA_SCANNED, (mScannable) ? SCANNABLE_VALUE_YES :
                    SCANNABLE_VALUE_NO);
            {
                boolean varE410073C37185297D362C1E68809DB54_1381010466 = (!mRequestHeaders.isEmpty());
                {
                    encodeHttpHeaders(values);
                } //End block
            } //End collapsed parenthetic
            putIfNonNull(values, Downloads.Impl.COLUMN_TITLE, mTitle);
            putIfNonNull(values, Downloads.Impl.COLUMN_DESCRIPTION, mDescription);
            putIfNonNull(values, Downloads.Impl.COLUMN_MIME_TYPE, mMimeType);
            values.put(Downloads.Impl.COLUMN_VISIBILITY, mNotificationVisibility);
            values.put(Downloads.Impl.COLUMN_ALLOWED_NETWORK_TYPES, mAllowedNetworkTypes);
            values.put(Downloads.Impl.COLUMN_ALLOW_ROAMING, mRoamingAllowed);
            values.put(Downloads.Impl.COLUMN_IS_VISIBLE_IN_DOWNLOADS_UI, mIsVisibleInDownloadsUi);
            return (ContentValues)dsTaint.getTaint();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.429 -0400", hash_original_method = "26D27F1BE5E3A68003877A062F0DAD99", hash_generated_method = "6BB0BC7073A0CF343BC220B2695C83E0")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void encodeHttpHeaders(ContentValues values) {
            dsTaint.addTaint(values.dsTaint);
            int index;
            index = 0;
            {
                Iterator<Pair<String, String>> var6EC36093AF9DC0A9505C9A55F0DE4444_400315710 = (mRequestHeaders).iterator();
                var6EC36093AF9DC0A9505C9A55F0DE4444_400315710.hasNext();
                Pair<String, String> header = var6EC36093AF9DC0A9505C9A55F0DE4444_400315710.next();
                {
                    String headerString;
                    headerString = header.first + ": " + header.second;
                    values.put(Downloads.Impl.RequestHeaders.INSERT_KEY_PREFIX + index, headerString);
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //int index = 0;
            //for (Pair<String, String> header : mRequestHeaders) {
                //String headerString = header.first + ": " + header.second;
                //values.put(Downloads.Impl.RequestHeaders.INSERT_KEY_PREFIX + index, headerString);
                //index++;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.429 -0400", hash_original_method = "19BA5B9D42AC58D8841CDF02C796EE38", hash_generated_method = "2E7A654B41EADE44496D118668CBBB72")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void putIfNonNull(ContentValues contentValues, String key, Object value) {
            dsTaint.addTaint(value.dsTaint);
            dsTaint.addTaint(contentValues.dsTaint);
            dsTaint.addTaint(key);
            {
                contentValues.put(key, value.toString());
            } //End block
            // ---------- Original Method ----------
            //if (value != null) {
                //contentValues.put(key, value.toString());
            //}
        }

        
        public static final int NETWORK_MOBILE = 1 << 0;
        public static final int NETWORK_WIFI = 1 << 1;
        private static final int SCANNABLE_VALUE_YES = 0;
        private static final int SCANNABLE_VALUE_NO = 2;
        public static final int VISIBILITY_VISIBLE = 0;
        public static final int VISIBILITY_VISIBLE_NOTIFY_COMPLETED = 1;
        public static final int VISIBILITY_HIDDEN = 2;
        public static final int VISIBILITY_VISIBLE_NOTIFY_ONLY_COMPLETION = 3;
    }


    
    public static class Query {
        private long[] mIds = null;
        private Integer mStatusFlags = null;
        private String mOrderByColumn = Downloads.Impl.COLUMN_LAST_MODIFICATION;
        private int mOrderDirection = ORDER_DESCENDING;
        private boolean mOnlyIncludeVisibleInDownloadsUi = false;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.430 -0400", hash_original_method = "DDB64BDDD962BAC05D8672F00DC4C185", hash_generated_method = "DDB64BDDD962BAC05D8672F00DC4C185")
                public Query ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.430 -0400", hash_original_method = "782D3BAE9A57AE7F89D5C5E0BBC212BD", hash_generated_method = "35DE494356AC75D8F21CCD511233109D")
        @DSModeled(DSC.SAFE)
        public Query setFilterById(long... ids) {
            dsTaint.addTaint(ids[0]);
            return (Query)dsTaint.getTaint();
            // ---------- Original Method ----------
            //mIds = ids;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.430 -0400", hash_original_method = "CE9295EE41F323C50B34B72F478BD4C2", hash_generated_method = "B7265361CDF6C76D47B4D3D4F8A958A0")
        @DSModeled(DSC.SAFE)
        public Query setFilterByStatus(int flags) {
            dsTaint.addTaint(flags);
            return (Query)dsTaint.getTaint();
            // ---------- Original Method ----------
            //mStatusFlags = flags;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.431 -0400", hash_original_method = "9600119EF208E670C5EE47F5F776ED3A", hash_generated_method = "7AC75308C22C82E695711DF89B9D840B")
        @DSModeled(DSC.SAFE)
        public Query setOnlyIncludeVisibleInDownloadsUi(boolean value) {
            dsTaint.addTaint(value);
            return (Query)dsTaint.getTaint();
            // ---------- Original Method ----------
            //mOnlyIncludeVisibleInDownloadsUi = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.431 -0400", hash_original_method = "969F069748FB75BDEDE2897D8F038415", hash_generated_method = "BD2DC836A6D282770091C90B3885A6BA")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Query orderBy(String column, int direction) {
            dsTaint.addTaint(direction);
            dsTaint.addTaint(column);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Invalid direction: " + direction);
            } //End block
            {
                boolean varB0B34C57CB5381E2A5D80B1DAEBC2C51_963292203 = (column.equals(COLUMN_LAST_MODIFIED_TIMESTAMP));
                {
                    mOrderByColumn = Downloads.Impl.COLUMN_LAST_MODIFICATION;
                } //End block
                {
                    boolean varEBF14B99C957D46FCEDCE1161497CE7F_1711474222 = (column.equals(COLUMN_TOTAL_SIZE_BYTES));
                    {
                        mOrderByColumn = Downloads.Impl.COLUMN_TOTAL_BYTES;
                    } //End block
                    {
                        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Cannot order by " + column);
                    } //End block
                } //End collapsed parenthetic
            } //End collapsed parenthetic
            return (Query)dsTaint.getTaint();
            // ---------- Original Method ----------
            //if (direction != ORDER_ASCENDING && direction != ORDER_DESCENDING) {
                //throw new IllegalArgumentException("Invalid direction: " + direction);
            //}
            //if (column.equals(COLUMN_LAST_MODIFIED_TIMESTAMP)) {
                //mOrderByColumn = Downloads.Impl.COLUMN_LAST_MODIFICATION;
            //} else if (column.equals(COLUMN_TOTAL_SIZE_BYTES)) {
                //mOrderByColumn = Downloads.Impl.COLUMN_TOTAL_BYTES;
            //} else {
                //throw new IllegalArgumentException("Cannot order by " + column);
            //}
            //mOrderDirection = direction;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.432 -0400", hash_original_method = "3E117BB34A8C7FFA67D17AB4CC250832", hash_generated_method = "51E20A72FCD2DCC7EFEC98FE799DF993")
        @DSModeled(DSC.SPEC)
         Cursor runQuery(ContentResolver resolver, String[] projection, Uri baseUri) {
            dsTaint.addTaint(baseUri.dsTaint);
            dsTaint.addTaint(projection[0]);
            dsTaint.addTaint(resolver.dsTaint);
            Uri uri;
            uri = baseUri;
            List<String> selectionParts;
            selectionParts = new ArrayList<String>();
            String[] selectionArgs;
            selectionArgs = null;
            {
                selectionParts.add(getWhereClauseForIds(mIds));
                selectionArgs = getWhereArgsForIds(mIds);
            } //End block
            {
                List<String> parts;
                parts = new ArrayList<String>();
                {
                    parts.add(statusClause("=", Downloads.Impl.STATUS_PENDING));
                } //End block
                {
                    parts.add(statusClause("=", Downloads.Impl.STATUS_RUNNING));
                } //End block
                {
                    parts.add(statusClause("=", Downloads.Impl.STATUS_PAUSED_BY_APP));
                    parts.add(statusClause("=", Downloads.Impl.STATUS_WAITING_TO_RETRY));
                    parts.add(statusClause("=", Downloads.Impl.STATUS_WAITING_FOR_NETWORK));
                    parts.add(statusClause("=", Downloads.Impl.STATUS_QUEUED_FOR_WIFI));
                } //End block
                {
                    parts.add(statusClause("=", Downloads.Impl.STATUS_SUCCESS));
                } //End block
                {
                    parts.add("(" + statusClause(">=", 400)
                              + " AND " + statusClause("<", 600) + ")");
                } //End block
                selectionParts.add(joinStrings(" OR ", parts));
            } //End block
            {
                selectionParts.add(Downloads.Impl.COLUMN_IS_VISIBLE_IN_DOWNLOADS_UI + " != '0'");
            } //End block
            selectionParts.add(Downloads.Impl.COLUMN_DELETED + " != '1'");
            String selection;
            selection = joinStrings(" AND ", selectionParts);
            String orderDirection;
            orderDirection = (mOrderDirection == ORDER_ASCENDING ? "ASC" : "DESC");//DSFIXME:  CODE0008: Nested ternary operator in expression
            String orderBy;
            orderBy = mOrderByColumn + " " + orderDirection;
            Cursor var80CC681208EC6C33CAE3AB017E90AECC_1089696212 = (resolver.query(uri, projection, selection, selectionArgs, orderBy));
            return (Cursor)dsTaint.getTaint();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.439 -0400", hash_original_method = "E982889F0CE13C731CA9D89AB5FD3B78", hash_generated_method = "BF062C8642E3616129E69CD50A21398F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private String joinStrings(String joiner, Iterable<String> parts) {
            dsTaint.addTaint(parts.dsTaint);
            dsTaint.addTaint(joiner);
            StringBuilder builder;
            builder = new StringBuilder();
            boolean first;
            first = true;
            {
                Iterator<String> var4E9C8AFBA69334251664FB12D52EFE6A_84506770 = (parts).iterator();
                var4E9C8AFBA69334251664FB12D52EFE6A_84506770.hasNext();
                String part = var4E9C8AFBA69334251664FB12D52EFE6A_84506770.next();
                {
                    {
                        builder.append(joiner);
                    } //End block
                    builder.append(part);
                    first = false;
                } //End block
            } //End collapsed parenthetic
            String varCEB98099F8B5AF9267E3A4873F9FB1DE_671391148 = (builder.toString());
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //StringBuilder builder = new StringBuilder();
            //boolean first = true;
            //for (String part : parts) {
                //if (!first) {
                    //builder.append(joiner);
                //}
                //builder.append(part);
                //first = false;
            //}
            //return builder.toString();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.440 -0400", hash_original_method = "F1C2C126003D565FB51A9C1A25E86357", hash_generated_method = "2B18C21E7A103EC6C184F5D16D61F688")
        @DSModeled(DSC.SAFE)
        private String statusClause(String operator, int value) {
            dsTaint.addTaint(value);
            dsTaint.addTaint(operator);
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return Downloads.Impl.COLUMN_STATUS + operator + "'" + value + "'";
        }

        
        public static final int ORDER_ASCENDING = 1;
        public static final int ORDER_DESCENDING = 2;
    }


    
    private static class CursorTranslator extends CursorWrapper {
        private Uri mBaseUri;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.440 -0400", hash_original_method = "DA2C30EB999FAADAF9AB1439D3B9F223", hash_generated_method = "9C74F42918EE20079127F577E94E5DDA")
        @DSModeled(DSC.SPEC)
        public CursorTranslator(Cursor cursor, Uri baseUri) {
            super(cursor);
            dsTaint.addTaint(cursor.dsTaint);
            dsTaint.addTaint(baseUri.dsTaint);
            // ---------- Original Method ----------
            //mBaseUri = baseUri;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.440 -0400", hash_original_method = "34538125BB8387937A75DA11F9FB5B65", hash_generated_method = "985A2D140D94686A5D7AC74C35DB399D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int getInt(int columnIndex) {
            dsTaint.addTaint(columnIndex);
            int var3CD82268530977C7C6744F3E8BBDD7D6_1218884600 = ((int) getLong(columnIndex));
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return (int) getLong(columnIndex);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.441 -0400", hash_original_method = "744FA54C78DD5C7B6737C741AD0EB8F1", hash_generated_method = "F25F6F605558AAC2AE399298DE4A5ACC")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public long getLong(int columnIndex) {
            dsTaint.addTaint(columnIndex);
            {
                boolean var64C1AD00092BC2F5CCD236C968ADB1F7_1094758378 = (getColumnName(columnIndex).equals(COLUMN_REASON));
                {
                    long varEA20B4C0EF19C4D7CCB17B21400F6CFF_1483264233 = (getReason(super.getInt(getColumnIndex(Downloads.Impl.COLUMN_STATUS))));
                } //End block
                {
                    boolean var354558F166115927AECC93EF734F99AA_614743257 = (getColumnName(columnIndex).equals(COLUMN_STATUS));
                    {
                        long var7FCD1CEC76DC9A06E3A454B471B4004B_1377240243 = (translateStatus(super.getInt(getColumnIndex(Downloads.Impl.COLUMN_STATUS))));
                    } //End block
                    {
                        long varC0843ACC657E8C550727A370AD3FD7B2_714920910 = (super.getLong(columnIndex));
                    } //End block
                } //End collapsed parenthetic
            } //End collapsed parenthetic
            return dsTaint.getTaintLong();
            // ---------- Original Method ----------
            //if (getColumnName(columnIndex).equals(COLUMN_REASON)) {
                //return getReason(super.getInt(getColumnIndex(Downloads.Impl.COLUMN_STATUS)));
            //} else if (getColumnName(columnIndex).equals(COLUMN_STATUS)) {
                //return translateStatus(super.getInt(getColumnIndex(Downloads.Impl.COLUMN_STATUS)));
            //} else {
                //return super.getLong(columnIndex);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.442 -0400", hash_original_method = "2A6CC35BB4DF843267A861B5828C6994", hash_generated_method = "8F517614E58DBF0030B95B8BA1F18D87")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public String getString(int columnIndex) {
            dsTaint.addTaint(columnIndex);
            {
                boolean varC95BAFFAC67B685E6EE3F69E8E2B8BDA_2092559883 = ((getColumnName(columnIndex).equals(COLUMN_LOCAL_URI)));
                Object var7750BF7ED730EB367E7CBE6A63821BA0_1688159715 = (getLocalUri());
                Object var43C2ABBB273D30E965CD5FCD5C4B96B4_1705239370 = (super.getString(columnIndex));
            } //End flattened ternary
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return (getColumnName(columnIndex).equals(COLUMN_LOCAL_URI)) ? getLocalUri() :
                    //super.getString(columnIndex);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.442 -0400", hash_original_method = "C2F388AD18BA84031DEC0607FBEAB7C5", hash_generated_method = "6436DC682F2BA60BF3E7EC1681F036DF")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private String getLocalUri() {
            long destinationType;
            destinationType = getLong(getColumnIndex(Downloads.Impl.COLUMN_DESTINATION));
            {
                String localPath;
                localPath = getString(getColumnIndex(COLUMN_LOCAL_FILENAME));
                String var5231ADCFFC9253691D9F19C5D8D5554C_2127747249 = (Uri.fromFile(new File(localPath)).toString());
            } //End block
            long downloadId;
            downloadId = getLong(getColumnIndex(Downloads.Impl._ID));
            String varFFF72DD16285989914F5B1435595322D_1972139007 = (ContentUris.withAppendedId(mBaseUri, downloadId).toString());
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //long destinationType = getLong(getColumnIndex(Downloads.Impl.COLUMN_DESTINATION));
            //if (destinationType == Downloads.Impl.DESTINATION_FILE_URI ||
                    //destinationType == Downloads.Impl.DESTINATION_EXTERNAL ||
                    //destinationType == Downloads.Impl.DESTINATION_NON_DOWNLOADMANAGER_DOWNLOAD) {
                //String localPath = getString(getColumnIndex(COLUMN_LOCAL_FILENAME));
                //if (localPath == null) {
                    //return null;
                //}
                //return Uri.fromFile(new File(localPath)).toString();
            //}
            //long downloadId = getLong(getColumnIndex(Downloads.Impl._ID));
            //return ContentUris.withAppendedId(mBaseUri, downloadId).toString();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.443 -0400", hash_original_method = "A69C93787DF2FD0B667931CA82E74881", hash_generated_method = "B9F926B6C93831A72AFA5F97397CDA82")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private long getReason(int status) {
            dsTaint.addTaint(status);
            {
                Object varBFF60C51F3561C06BE2F47ADE835EC83_150663714 = (translateStatus(status));
                //Begin case STATUS_FAILED 
                long varA00E54BE3716406F658C01669FEA3255_40870127 = (getErrorCode(status));
                //End case STATUS_FAILED 
                //Begin case STATUS_PAUSED 
                long var0684DD53D22A9802EEC682794798C46B_671025734 = (getPausedReason(status));
                //End case STATUS_PAUSED 
            } //End collapsed parenthetic
            return dsTaint.getTaintLong();
            // ---------- Original Method ----------
            //switch (translateStatus(status)) {
                //case STATUS_FAILED:
                    //return getErrorCode(status);
                //case STATUS_PAUSED:
                    //return getPausedReason(status);
                //default:
                    //return 0; 
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.443 -0400", hash_original_method = "8BF9F68328111BA50CCB78B1792F76F0", hash_generated_method = "0DD1950CE14612ED202FB1766DADAC4A")
        @DSModeled(DSC.SAFE)
        private long getPausedReason(int status) {
            dsTaint.addTaint(status);
            return dsTaint.getTaintLong();
            // ---------- Original Method ----------
            //switch (status) {
                //case Downloads.Impl.STATUS_WAITING_TO_RETRY:
                    //return PAUSED_WAITING_TO_RETRY;
                //case Downloads.Impl.STATUS_WAITING_FOR_NETWORK:
                    //return PAUSED_WAITING_FOR_NETWORK;
                //case Downloads.Impl.STATUS_QUEUED_FOR_WIFI:
                    //return PAUSED_QUEUED_FOR_WIFI;
                //default:
                    //return PAUSED_UNKNOWN;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.444 -0400", hash_original_method = "A27080D0C32BDBDFED7217EFE39DC72F", hash_generated_method = "5EA7C6865BAABA19854637FD17E63773")
        @DSModeled(DSC.SAFE)
        private long getErrorCode(int status) {
            dsTaint.addTaint(status);
            return dsTaint.getTaintLong();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.444 -0400", hash_original_method = "AC0B465D7BF7B10F5608906AFAA7CE72", hash_generated_method = "4CB953AC1F75C8D8827992AB97F6A794")
        @DSModeled(DSC.SAFE)
        private int translateStatus(int status) {
            dsTaint.addTaint(status);
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //switch (status) {
                //case Downloads.Impl.STATUS_PENDING:
                    //return STATUS_PENDING;
                //case Downloads.Impl.STATUS_RUNNING:
                    //return STATUS_RUNNING;
                //case Downloads.Impl.STATUS_PAUSED_BY_APP:
                //case Downloads.Impl.STATUS_WAITING_TO_RETRY:
                //case Downloads.Impl.STATUS_WAITING_FOR_NETWORK:
                //case Downloads.Impl.STATUS_QUEUED_FOR_WIFI:
                    //return STATUS_PAUSED;
                //case Downloads.Impl.STATUS_SUCCESS:
                    //return STATUS_SUCCESSFUL;
                //default:
                    //assert Downloads.Impl.isStatusError(status);
                    //return STATUS_FAILED;
            //}
        }

        
    }


    
    public final static String COLUMN_ID = Downloads.Impl._ID;
    public final static String COLUMN_TITLE = Downloads.Impl.COLUMN_TITLE;
    public final static String COLUMN_DESCRIPTION = Downloads.Impl.COLUMN_DESCRIPTION;
    public final static String COLUMN_URI = Downloads.Impl.COLUMN_URI;
    public final static String COLUMN_MEDIA_TYPE = "media_type";
    public final static String COLUMN_TOTAL_SIZE_BYTES = "total_size";
    public final static String COLUMN_LOCAL_URI = "local_uri";
    public final static String COLUMN_LOCAL_FILENAME = "local_filename";
    public final static String COLUMN_STATUS = Downloads.Impl.COLUMN_STATUS;
    public final static String COLUMN_REASON = "reason";
    public final static String COLUMN_BYTES_DOWNLOADED_SO_FAR = "bytes_so_far";
    public final static String COLUMN_LAST_MODIFIED_TIMESTAMP = "last_modified_timestamp";
    public static final String COLUMN_MEDIAPROVIDER_URI = Downloads.Impl.COLUMN_MEDIAPROVIDER_URI;
    public final static int STATUS_PENDING = 1 << 0;
    public final static int STATUS_RUNNING = 1 << 1;
    public final static int STATUS_PAUSED = 1 << 2;
    public final static int STATUS_SUCCESSFUL = 1 << 3;
    public final static int STATUS_FAILED = 1 << 4;
    public final static int ERROR_UNKNOWN = 1000;
    public final static int ERROR_FILE_ERROR = 1001;
    public final static int ERROR_UNHANDLED_HTTP_CODE = 1002;
    public final static int ERROR_HTTP_DATA_ERROR = 1004;
    public final static int ERROR_TOO_MANY_REDIRECTS = 1005;
    public final static int ERROR_INSUFFICIENT_SPACE = 1006;
    public final static int ERROR_DEVICE_NOT_FOUND = 1007;
    public final static int ERROR_CANNOT_RESUME = 1008;
    public final static int ERROR_FILE_ALREADY_EXISTS = 1009;
    public final static int ERROR_BLOCKED = 1010;
    public final static int PAUSED_WAITING_TO_RETRY = 1;
    public final static int PAUSED_WAITING_FOR_NETWORK = 2;
    public final static int PAUSED_QUEUED_FOR_WIFI = 3;
    public final static int PAUSED_UNKNOWN = 4;
    public final static String ACTION_DOWNLOAD_COMPLETE = "android.intent.action.DOWNLOAD_COMPLETE";
    public final static String ACTION_NOTIFICATION_CLICKED =
            "android.intent.action.DOWNLOAD_NOTIFICATION_CLICKED";
    public final static String ACTION_VIEW_DOWNLOADS = "android.intent.action.VIEW_DOWNLOADS";
    public final static String INTENT_EXTRAS_SORT_BY_SIZE =
            "android.app.DownloadManager.extra_sortBySize";
    public static final String EXTRA_DOWNLOAD_ID = "extra_download_id";
    public static final String EXTRA_NOTIFICATION_CLICK_DOWNLOAD_IDS = "extra_click_download_ids";
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
        
        "'placeholder' AS " + COLUMN_LOCAL_URI,
        "'placeholder' AS " + COLUMN_REASON
    };
    private static final String NON_DOWNLOADMANAGER_DOWNLOAD =
            "non-dwnldmngr-download-dont-retry2download";
}

