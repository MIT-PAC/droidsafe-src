package android.app;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.114 -0400", hash_original_field = "CF849E3C15214EFD093D4303B542BF44", hash_generated_field = "2ABF989C5B8F051BCBEE638ED1EA2586")

    private ContentResolver mResolver;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.114 -0400", hash_original_field = "BE0173788749EF3CF5679DF9E1224605", hash_generated_field = "6F81845A3A2771C3EC987E5A01DBA4C6")

    private String mPackageName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.114 -0400", hash_original_field = "55833456165B236ED25F84EACF5CF2CA", hash_generated_field = "1AFB71B4D196CA91BC22831E08A191CF")

    private Uri mBaseUri = Downloads.Impl.CONTENT_URI;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.115 -0400", hash_original_method = "E62D0E970789924902081BF03F031FF8", hash_generated_method = "7F4F9C5FA27047A7434D2EC70ADE844E")
    public  DownloadManager(ContentResolver resolver, String packageName) {
        mResolver = resolver;
        mPackageName = packageName;
        // ---------- Original Method ----------
        //mResolver = resolver;
        //mPackageName = packageName;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.116 -0400", hash_original_method = "93AAF1C0A18C9EFC24526B178CE628E3", hash_generated_method = "F58E623A8B3CC778D0FE745DFD0F353B")
    public void setAccessAllDownloads(boolean accessAllDownloads) {
        addTaint(accessAllDownloads);
    if(accessAllDownloads)        
        {
            mBaseUri = Downloads.Impl.ALL_DOWNLOADS_CONTENT_URI;
        } //End block
        else
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.116 -0400", hash_original_method = "A2E8022D1487E0DC7C6CC7B8DABAC46D", hash_generated_method = "12866FC09FE673106E9917A6C7A0757B")
    public long enqueue(Request request) {
        addTaint(request.getTaint());
        ContentValues values = request.toContentValues(mPackageName);
        Uri downloadUri = mResolver.insert(Downloads.Impl.CONTENT_URI, values);
        long id = Long.parseLong(downloadUri.getLastPathSegment());
        long varB80BB7740288FDA1F201890375A60C8F_1310090415 = (id);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_405886697 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_405886697;
        // ---------- Original Method ----------
        //ContentValues values = request.toContentValues(mPackageName);
        //Uri downloadUri = mResolver.insert(Downloads.Impl.CONTENT_URI, values);
        //long id = Long.parseLong(downloadUri.getLastPathSegment());
        //return id;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.117 -0400", hash_original_method = "6A912115CBBE4D263FCD27B2696D5371", hash_generated_method = "CE6DF9BC49F1868CC19F376F0B95A34E")
    public int markRowDeleted(long... ids) {
        addTaint(ids[0]);
    if(ids == null || ids.length == 0)        
        {
            IllegalArgumentException varB0AA7F7EAFE0B8E4691D1DF1E5E39DE7_420577895 = new IllegalArgumentException("input param 'ids' can't be null");
            varB0AA7F7EAFE0B8E4691D1DF1E5E39DE7_420577895.addTaint(taint);
            throw varB0AA7F7EAFE0B8E4691D1DF1E5E39DE7_420577895;
        } //End block
        ContentValues values = new ContentValues();
        values.put(Downloads.Impl.COLUMN_DELETED, 1);
    if(ids.length == 1)        
        {
            int var586F54E937619AA143FB3FF17B95D3BB_1322697430 = (mResolver.update(ContentUris.withAppendedId(mBaseUri, ids[0]), values,
                    null, null));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1138122801 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1138122801;
        } //End block
        int var5E2A7E0587FF53B9A53FD3F75E5D40DD_819100123 = (mResolver.update(mBaseUri, values, getWhereClauseForIds(ids),
                getWhereArgsForIds(ids)));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1017455185 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1017455185;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.118 -0400", hash_original_method = "E87735CFC3568A22F95F85C3BABBD5E2", hash_generated_method = "7FF5572F3ED9BF9E5E01295DEF1956EE")
    public int remove(long... ids) {
        addTaint(ids[0]);
        int var64F1F34DFB9E5CAAB42D28192658E14B_231795814 = (markRowDeleted(ids));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_287208331 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_287208331;
        // ---------- Original Method ----------
        //return markRowDeleted(ids);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.119 -0400", hash_original_method = "AA3C14DF1A360F6707C442D7B10D5AD3", hash_generated_method = "0C6D894D524D2C4526B0CCAD977AA537")
    public Cursor query(Query query) {
        addTaint(query.getTaint());
        Cursor underlyingCursor = query.runQuery(mResolver, UNDERLYING_COLUMNS, mBaseUri);
    if(underlyingCursor == null)        
        {
Cursor var540C13E9E156B687226421B24F2DF178_1587751577 =             null;
            var540C13E9E156B687226421B24F2DF178_1587751577.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1587751577;
        } //End block
Cursor var345F2E3650A7E272359E32D8CD68FEC4_544006767 =         new CursorTranslator(underlyingCursor, mBaseUri);
        var345F2E3650A7E272359E32D8CD68FEC4_544006767.addTaint(taint);
        return var345F2E3650A7E272359E32D8CD68FEC4_544006767;
        // ---------- Original Method ----------
        //Cursor underlyingCursor = query.runQuery(mResolver, UNDERLYING_COLUMNS, mBaseUri);
        //if (underlyingCursor == null) {
            //return null;
        //}
        //return new CursorTranslator(underlyingCursor, mBaseUri);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.119 -0400", hash_original_method = "41561235219E48E784E85B3D8CB5CB93", hash_generated_method = "C05FF84AF119A830240CB6A68ED3A56A")
    public ParcelFileDescriptor openDownloadedFile(long id) throws FileNotFoundException {
        addTaint(id);
ParcelFileDescriptor varE0B9C67C78275AE598AB57CBAB5E0103_1272651106 =         mResolver.openFileDescriptor(getDownloadUri(id), "r");
        varE0B9C67C78275AE598AB57CBAB5E0103_1272651106.addTaint(taint);
        return varE0B9C67C78275AE598AB57CBAB5E0103_1272651106;
        // ---------- Original Method ----------
        //return mResolver.openFileDescriptor(getDownloadUri(id), "r");
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.121 -0400", hash_original_method = "82FD0DABBA6B80B8B4BA3DF76B66A3D1", hash_generated_method = "0AE6CFD21E8158844F618910751EDA6D")
    public Uri getUriForDownloadedFile(long id) {
        addTaint(id);
        Query query = new Query().setFilterById(id);
        Cursor cursor = null;
        try 
        {
            cursor = query(query);
    if(cursor == null)            
            {
Uri var540C13E9E156B687226421B24F2DF178_1876989545 =                 null;
                var540C13E9E156B687226421B24F2DF178_1876989545.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_1876989545;
            } //End block
    if(cursor.moveToFirst())            
            {
                int status = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_STATUS));
    if(DownloadManager.STATUS_SUCCESSFUL == status)                
                {
                    int indx = cursor.getColumnIndexOrThrow(
                            Downloads.Impl.COLUMN_DESTINATION);
                    int destination = cursor.getInt(indx);
    if(destination == Downloads.Impl.DESTINATION_CACHE_PARTITION ||
                            destination == Downloads.Impl.DESTINATION_SYSTEMCACHE_PARTITION ||
                            destination == Downloads.Impl.DESTINATION_CACHE_PARTITION_NOROAMING ||
                            destination == Downloads.Impl.DESTINATION_CACHE_PARTITION_PURGEABLE)                    
                    {
Uri var9B8174AF1618F483458679910F62C07F_1569695152 =                         ContentUris.withAppendedId(Downloads.Impl.CONTENT_URI, id);
                        var9B8174AF1618F483458679910F62C07F_1569695152.addTaint(taint);
                        return var9B8174AF1618F483458679910F62C07F_1569695152;
                    } //End block
                    else
                    {
                        String path = cursor.getString(
                                cursor.getColumnIndexOrThrow(COLUMN_LOCAL_FILENAME));
Uri varF6123B6F430C46680082B89A4A17F9FA_394923320 =                         Uri.fromFile(new File(path));
                        varF6123B6F430C46680082B89A4A17F9FA_394923320.addTaint(taint);
                        return varF6123B6F430C46680082B89A4A17F9FA_394923320;
                    } //End block
                } //End block
            } //End block
        } //End block
        finally 
        {
    if(cursor != null)            
            {
                cursor.close();
            } //End block
        } //End block
Uri var540C13E9E156B687226421B24F2DF178_377251435 =         null;
        var540C13E9E156B687226421B24F2DF178_377251435.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_377251435;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.122 -0400", hash_original_method = "EC65E8932FA161BF4DAEC74FC802F48D", hash_generated_method = "6AC79C3F5D4BBC230C104E1A8574BD43")
    public String getMimeTypeForDownloadedFile(long id) {
        addTaint(id);
        Query query = new Query().setFilterById(id);
        Cursor cursor = null;
        try 
        {
            cursor = query(query);
    if(cursor == null)            
            {
String var540C13E9E156B687226421B24F2DF178_774219285 =                 null;
                var540C13E9E156B687226421B24F2DF178_774219285.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_774219285;
            } //End block
            while
(cursor.moveToFirst())            
            {
String varD5E41397B22B1AACDACF2F6426E92502_1376066916 =                 cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_MEDIA_TYPE));
                varD5E41397B22B1AACDACF2F6426E92502_1376066916.addTaint(taint);
                return varD5E41397B22B1AACDACF2F6426E92502_1376066916;
            } //End block
        } //End block
        finally 
        {
    if(cursor != null)            
            {
                cursor.close();
            } //End block
        } //End block
String var540C13E9E156B687226421B24F2DF178_1594134575 =         null;
        var540C13E9E156B687226421B24F2DF178_1594134575.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1594134575;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.123 -0400", hash_original_method = "ABDC33D84A29539A96C484C81BD10405", hash_generated_method = "E0FFEF1322D058A1A52BA4EE691ED3A9")
    public void restartDownload(long... ids) {
        addTaint(ids[0]);
        Cursor cursor = query(new Query().setFilterById(ids));
        try 
        {
for(cursor.moveToFirst();!cursor.isAfterLast();cursor.moveToNext())
            {
                int status = cursor.getInt(cursor.getColumnIndex(COLUMN_STATUS));
    if(status != STATUS_SUCCESSFUL && status != STATUS_FAILED)                
                {
                    IllegalArgumentException var2EFBE7C3E3A8515841F5640C5124A4D9_1802218778 = new IllegalArgumentException("Cannot restart incomplete download: "
                            + cursor.getLong(cursor.getColumnIndex(COLUMN_ID)));
                    var2EFBE7C3E3A8515841F5640C5124A4D9_1802218778.addTaint(taint);
                    throw var2EFBE7C3E3A8515841F5640C5124A4D9_1802218778;
                } //End block
            } //End block
        } //End block
        finally 
        {
            cursor.close();
        } //End block
        ContentValues values = new ContentValues();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.126 -0400", hash_original_method = "58F6793B30C14E2CFD3653910A805BA2", hash_generated_method = "7349CEDB24A4D903976C93DB22F8F1C9")
    public long addCompletedDownload(String title, String description,
            boolean isMediaScannerScannable, String mimeType, String path, long length,
            boolean showNotification) {
        addTaint(showNotification);
        addTaint(length);
        addTaint(path.getTaint());
        addTaint(mimeType.getTaint());
        addTaint(isMediaScannerScannable);
        addTaint(description.getTaint());
        addTaint(title.getTaint());
        validateArgumentIsNonEmpty("title", title);
        validateArgumentIsNonEmpty("description", description);
        validateArgumentIsNonEmpty("path", path);
        validateArgumentIsNonEmpty("mimeType", mimeType);
    if(length <= 0)        
        {
            IllegalArgumentException varB36EC5ACCAC0915566AE4AB67A6E7FB5_815284944 = new IllegalArgumentException(" invalid value for param: totalBytes");
            varB36EC5ACCAC0915566AE4AB67A6E7FB5_815284944.addTaint(taint);
            throw varB36EC5ACCAC0915566AE4AB67A6E7FB5_815284944;
        } //End block
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
    if(downloadUri == null)        
        {
            long var6BB61E3B7BCE0931DA574D19D1D82C88_1630069205 = (-1);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1383691520 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1383691520;
        } //End block
        long varB777594B5793AB30472F2D124D705335_699140841 = (Long.parseLong(downloadUri.getLastPathSegment()));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_225732881 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_225732881;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        private static void validateArgumentIsNonEmpty(String paramName, String val) {
        if (TextUtils.isEmpty(val)) {
            throw new IllegalArgumentException(paramName + " can't be null");
        }
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.128 -0400", hash_original_method = "D1EE950396677328804F68406B4587AE", hash_generated_method = "2BC46C7913134E0B4AABFD21AF98B897")
     Uri getDownloadUri(long id) {
        addTaint(id);
Uri varCB06EC07B2D6682F3C59CCA414EC1632_1038656105 =         ContentUris.withAppendedId(mBaseUri, id);
        varCB06EC07B2D6682F3C59CCA414EC1632_1038656105.addTaint(taint);
        return varCB06EC07B2D6682F3C59CCA414EC1632_1038656105;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.131 -0400", hash_original_field = "5FBE3730DCFF234F97B15868D5CE649D", hash_generated_field = "04FA8EB5D9FB8AC4AAE6453BCF1BBF82")

        private Uri mUri;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.131 -0400", hash_original_field = "D56C02C2196A65236C80C7DCE28A3AB7", hash_generated_field = "83BAA5C2BC0662F1D32FE83EA4951897")

        private Uri mDestinationUri;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.131 -0400", hash_original_field = "9902E4AE0DF2B59C61F5118F9D0AAC2F", hash_generated_field = "13A8BF554467B5955E7580E17A5A2DDA")

        private List<Pair<String, String>> mRequestHeaders = new ArrayList<Pair<String, String>>();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.131 -0400", hash_original_field = "4B03BBB3AD21DBD17B2B689923FCF1F6", hash_generated_field = "ECAB18871B55104BACD4283C12B1074D")

        private CharSequence mTitle;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.132 -0400", hash_original_field = "FF2B9B684DDD70D7BE468C8D9A54343D", hash_generated_field = "18C3493923549BAE766F057DAF8B146B")

        private CharSequence mDescription;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.132 -0400", hash_original_field = "FA38F1960A45A7EC16349AAF783A80BC", hash_generated_field = "D6D2783B71AE4BF9CBF84D44336E2BF9")

        private String mMimeType;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.132 -0400", hash_original_field = "88BCF3A961C3BE410BDE5D1BF8DFDE19", hash_generated_field = "952A1377CC9FB93E78D671C8656DC930")

        private boolean mRoamingAllowed = true;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.132 -0400", hash_original_field = "5EE6AA01E98013CD1FB70EC74A5B6859", hash_generated_field = "5A39BA83CA95D987B9F58ECEB876274F")

        private int mAllowedNetworkTypes = ~0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.132 -0400", hash_original_field = "14EB015AA8D6AE536374773FE32BA9C3", hash_generated_field = "CDF7B3598ECC145AEC167A93A8BA96F5")

        private boolean mIsVisibleInDownloadsUi = true;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.132 -0400", hash_original_field = "BDEF670E22CB4C3CEDAF7D0CD809FB30", hash_generated_field = "D6ACB722C57F150FD71504D93C5E360B")

        private boolean mScannable = false;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.132 -0400", hash_original_field = "D350B669F5679FD50E4690CE8AC72A14", hash_generated_field = "3DE0461D1F897FC34AAEB85C39656726")

        private boolean mUseSystemCache = false;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.132 -0400", hash_original_field = "3AE7BFD550D220788CDE382866503478", hash_generated_field = "BC737294552DD713920EAAEBBC85199C")

        private int mNotificationVisibility = VISIBILITY_VISIBLE;
        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.133 -0400", hash_original_method = "38AB51743560DA4EF393F63C39D43853", hash_generated_method = "0239CCDAF308BBBDC57A66371279B683")
        public  Request(Uri uri) {
    if(uri == null)            
            {
                NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_457828628 = new NullPointerException();
                var7338BC9F48D81FE0BBD6183F4014DCC4_457828628.addTaint(taint);
                throw var7338BC9F48D81FE0BBD6183F4014DCC4_457828628;
            } //End block
            String scheme = uri.getScheme();
    if(scheme == null || (!scheme.equals("http") && !scheme.equals("https")))            
            {
                IllegalArgumentException var0678862243B25C4B4E0114CE914A348F_2131078117 = new IllegalArgumentException("Can only download HTTP/HTTPS URIs: " + uri);
                var0678862243B25C4B4E0114CE914A348F_2131078117.addTaint(taint);
                throw var0678862243B25C4B4E0114CE914A348F_2131078117;
            } //End block
            mUri = uri;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.134 -0400", hash_original_method = "DEE528427F50C6163D0C2E44786A5A1B", hash_generated_method = "FDA44BFC9F8B59AE2D2550C14110C5D8")
          Request(String uriString) {
            mUri = Uri.parse(uriString);
            // ---------- Original Method ----------
            //mUri = Uri.parse(uriString);
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.134 -0400", hash_original_method = "D90BC1E489B6C6F52B7EAE5F6B3F7838", hash_generated_method = "958457ABF4D57CE6FA33C03E6713065C")
        public Request setDestinationUri(Uri uri) {
            mDestinationUri = uri;
Request var72A74007B2BE62B849F475C7BDA4658B_1343857770 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1343857770.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1343857770;
            // ---------- Original Method ----------
            //mDestinationUri = uri;
            //return this;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.135 -0400", hash_original_method = "D82AD486A04E11ACCF6C157FAE4ED191", hash_generated_method = "D3F026EAD8C64225CFAAB0365879BEA7")
        public Request setDestinationToSystemCache() {
            mUseSystemCache = true;
Request var72A74007B2BE62B849F475C7BDA4658B_1217175426 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1217175426.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1217175426;
            // ---------- Original Method ----------
            //mUseSystemCache = true;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.136 -0400", hash_original_method = "D36C94DA39C2A5C5097A71BFF458D119", hash_generated_method = "6A2EA326B41B2C942057B319EB479DC5")
        public Request setDestinationInExternalFilesDir(Context context, String dirType,
                String subPath) {
            addTaint(subPath.getTaint());
            addTaint(dirType.getTaint());
            addTaint(context.getTaint());
            setDestinationFromBase(context.getExternalFilesDir(dirType), subPath);
Request var72A74007B2BE62B849F475C7BDA4658B_2005311283 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_2005311283.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_2005311283;
            // ---------- Original Method ----------
            //setDestinationFromBase(context.getExternalFilesDir(dirType), subPath);
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.136 -0400", hash_original_method = "DE3A2CC0AFE35B8C7E88937E379D2ACE", hash_generated_method = "5BD337C77DAFA4E755F702A92E7DB00A")
        public Request setDestinationInExternalPublicDir(String dirType, String subPath) {
            addTaint(subPath.getTaint());
            addTaint(dirType.getTaint());
            File file = Environment.getExternalStoragePublicDirectory(dirType);
    if(file.exists())            
            {
    if(!file.isDirectory())                
                {
                    IllegalStateException var4DF52C9014DA9E7AF153669FCD750E43_28711411 = new IllegalStateException(file.getAbsolutePath() +
                            " already exists and is not a directory");
                    var4DF52C9014DA9E7AF153669FCD750E43_28711411.addTaint(taint);
                    throw var4DF52C9014DA9E7AF153669FCD750E43_28711411;
                } //End block
            } //End block
            else
            {
    if(!file.mkdir())                
                {
                    IllegalStateException var1471AD8F863D5F5F50A2B118008DB470_1990460348 = new IllegalStateException("Unable to create directory: "+
                            file.getAbsolutePath());
                    var1471AD8F863D5F5F50A2B118008DB470_1990460348.addTaint(taint);
                    throw var1471AD8F863D5F5F50A2B118008DB470_1990460348;
                } //End block
            } //End block
            setDestinationFromBase(file, subPath);
Request var72A74007B2BE62B849F475C7BDA4658B_1164534137 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1164534137.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1164534137;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.137 -0400", hash_original_method = "53900E0DE3709F8E65CE6AB9A613EA7C", hash_generated_method = "2A28600060BFE6BBC1D5696C93200D71")
        private void setDestinationFromBase(File base, String subPath) {
    if(subPath == null)            
            {
                NullPointerException var5FE433429ADDD12C5141BD5BCB8F8D19_1614558005 = new NullPointerException("subPath cannot be null");
                var5FE433429ADDD12C5141BD5BCB8F8D19_1614558005.addTaint(taint);
                throw var5FE433429ADDD12C5141BD5BCB8F8D19_1614558005;
            } //End block
            mDestinationUri = Uri.withAppendedPath(Uri.fromFile(base), subPath);
            // ---------- Original Method ----------
            //if (subPath == null) {
                //throw new NullPointerException("subPath cannot be null");
            //}
            //mDestinationUri = Uri.withAppendedPath(Uri.fromFile(base), subPath);
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.138 -0400", hash_original_method = "39458C7E93B4E0F8CC50399F7846AF71", hash_generated_method = "C96F98A19F0478D3BC60EAEC74698C65")
        public void allowScanningByMediaScanner() {
            mScannable = true;
            // ---------- Original Method ----------
            //mScannable = true;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.139 -0400", hash_original_method = "84826A0727261744241F6F54A16F49D4", hash_generated_method = "B4428B749A0E63876CF6B1B6E2A0CA9A")
        public Request addRequestHeader(String header, String value) {
            addTaint(value.getTaint());
            addTaint(header.getTaint());
    if(header == null)            
            {
                NullPointerException varBEC12ED34A780A15360098A11EAAB629_379504344 = new NullPointerException("header cannot be null");
                varBEC12ED34A780A15360098A11EAAB629_379504344.addTaint(taint);
                throw varBEC12ED34A780A15360098A11EAAB629_379504344;
            } //End block
    if(header.contains(":"))            
            {
                IllegalArgumentException varBC95CC0E0AF1D960AB18179234058DBC_747357320 = new IllegalArgumentException("header may not contain ':'");
                varBC95CC0E0AF1D960AB18179234058DBC_747357320.addTaint(taint);
                throw varBC95CC0E0AF1D960AB18179234058DBC_747357320;
            } //End block
    if(value == null)            
            {
                value = "";
            } //End block
            mRequestHeaders.add(Pair.create(header, value));
Request var72A74007B2BE62B849F475C7BDA4658B_597978675 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_597978675.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_597978675;
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

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.140 -0400", hash_original_method = "D2617ADF02871E26D8818B6B93DA088D", hash_generated_method = "D665C4F709DCC3EEEDB892BDD91C3352")
        public Request setTitle(CharSequence title) {
            mTitle = title;
Request var72A74007B2BE62B849F475C7BDA4658B_1191771033 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1191771033.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1191771033;
            // ---------- Original Method ----------
            //mTitle = title;
            //return this;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.141 -0400", hash_original_method = "3BFD78827604EC47FE3892636D121D42", hash_generated_method = "D32094E5D348BCCBE9ED4EF9AC30E9AC")
        public Request setDescription(CharSequence description) {
            mDescription = description;
Request var72A74007B2BE62B849F475C7BDA4658B_1785718829 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1785718829.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1785718829;
            // ---------- Original Method ----------
            //mDescription = description;
            //return this;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.142 -0400", hash_original_method = "EAEBE95F38EAF7D74F8EC9BD89175C39", hash_generated_method = "3CA36195C36D9EBBE948F020C5472736")
        public Request setMimeType(String mimeType) {
            mMimeType = mimeType;
Request var72A74007B2BE62B849F475C7BDA4658B_803745368 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_803745368.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_803745368;
            // ---------- Original Method ----------
            //mMimeType = mimeType;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.142 -0400", hash_original_method = "F75AFBEFCFC8BE21F83F018EA7CEB6E1", hash_generated_method = "EDCA282D2766634BF5E6E35B78DCE345")
        @Deprecated
        public Request setShowRunningNotification(boolean show) {
            addTaint(show);
Request var9F4F13FEB5BF8371C67753BBCD589B52_421048325 =             (show) ? setNotificationVisibility(VISIBILITY_VISIBLE) :
                    setNotificationVisibility(VISIBILITY_HIDDEN);
            var9F4F13FEB5BF8371C67753BBCD589B52_421048325.addTaint(taint);
            return var9F4F13FEB5BF8371C67753BBCD589B52_421048325;
            // ---------- Original Method ----------
            //return (show) ? setNotificationVisibility(VISIBILITY_VISIBLE) :
                    //setNotificationVisibility(VISIBILITY_HIDDEN);
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.143 -0400", hash_original_method = "0E1BEC1EE7CB7BCA18E6C69650765291", hash_generated_method = "15B5FDC1BBA28908E35F9BF3A736A99C")
        public Request setNotificationVisibility(int visibility) {
            mNotificationVisibility = visibility;
Request var72A74007B2BE62B849F475C7BDA4658B_907499053 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_907499053.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_907499053;
            // ---------- Original Method ----------
            //mNotificationVisibility = visibility;
            //return this;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.144 -0400", hash_original_method = "1FB95247AA3BF4BC290C0031C887893C", hash_generated_method = "D16C103E29FA6C1DC9AD8E4C1BC0D21B")
        public Request setAllowedNetworkTypes(int flags) {
            mAllowedNetworkTypes = flags;
Request var72A74007B2BE62B849F475C7BDA4658B_250441715 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_250441715.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_250441715;
            // ---------- Original Method ----------
            //mAllowedNetworkTypes = flags;
            //return this;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.145 -0400", hash_original_method = "EED7837CFCCAA493B8F853E6287613BD", hash_generated_method = "6E23AAE334B5C22D22B3F3A4D021AD7D")
        public Request setAllowedOverRoaming(boolean allowed) {
            mRoamingAllowed = allowed;
Request var72A74007B2BE62B849F475C7BDA4658B_1231128019 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1231128019.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1231128019;
            // ---------- Original Method ----------
            //mRoamingAllowed = allowed;
            //return this;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.146 -0400", hash_original_method = "865D9FB8BB624139754E18F2F470A937", hash_generated_method = "5B1D70A8E1EC503C8963776C6A37E170")
        public Request setVisibleInDownloadsUi(boolean isVisible) {
            mIsVisibleInDownloadsUi = isVisible;
Request var72A74007B2BE62B849F475C7BDA4658B_1830702448 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1830702448.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1830702448;
            // ---------- Original Method ----------
            //mIsVisibleInDownloadsUi = isVisible;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.147 -0400", hash_original_method = "A794ABF9FD18E330B670B5AD24CF2800", hash_generated_method = "A228BEEA0BB45F63799822EE19ED5468")
         ContentValues toContentValues(String packageName) {
            addTaint(packageName.getTaint());
            ContentValues values = new ContentValues();
            values.put(Downloads.Impl.COLUMN_URI, mUri.toString());
            values.put(Downloads.Impl.COLUMN_IS_PUBLIC_API, true);
            values.put(Downloads.Impl.COLUMN_NOTIFICATION_PACKAGE, packageName);
    if(mDestinationUri != null)            
            {
                values.put(Downloads.Impl.COLUMN_DESTINATION, Downloads.Impl.DESTINATION_FILE_URI);
                values.put(Downloads.Impl.COLUMN_FILE_NAME_HINT, mDestinationUri.toString());
            } //End block
            else
            {
                values.put(Downloads.Impl.COLUMN_DESTINATION,
                           (this.mUseSystemCache) ?
                                   Downloads.Impl.DESTINATION_SYSTEMCACHE_PARTITION :
                                   Downloads.Impl.DESTINATION_CACHE_PARTITION_PURGEABLE);
            } //End block
            values.put(Downloads.Impl.COLUMN_MEDIA_SCANNED, (mScannable) ? SCANNABLE_VALUE_YES :
                    SCANNABLE_VALUE_NO);
    if(!mRequestHeaders.isEmpty())            
            {
                encodeHttpHeaders(values);
            } //End block
            putIfNonNull(values, Downloads.Impl.COLUMN_TITLE, mTitle);
            putIfNonNull(values, Downloads.Impl.COLUMN_DESCRIPTION, mDescription);
            putIfNonNull(values, Downloads.Impl.COLUMN_MIME_TYPE, mMimeType);
            values.put(Downloads.Impl.COLUMN_VISIBILITY, mNotificationVisibility);
            values.put(Downloads.Impl.COLUMN_ALLOWED_NETWORK_TYPES, mAllowedNetworkTypes);
            values.put(Downloads.Impl.COLUMN_ALLOW_ROAMING, mRoamingAllowed);
            values.put(Downloads.Impl.COLUMN_IS_VISIBLE_IN_DOWNLOADS_UI, mIsVisibleInDownloadsUi);
ContentValues var674B10C763DBAAF9696AD9A3DDAE07B3_649492246 =             values;
            var674B10C763DBAAF9696AD9A3DDAE07B3_649492246.addTaint(taint);
            return var674B10C763DBAAF9696AD9A3DDAE07B3_649492246;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.150 -0400", hash_original_method = "26D27F1BE5E3A68003877A062F0DAD99", hash_generated_method = "D33449BBE219982BDFC88623DDD51572")
        private void encodeHttpHeaders(ContentValues values) {
            addTaint(values.getTaint());
            int index = 0;
for(Pair<String, String> header : mRequestHeaders)
            {
                String headerString = header.first + ": " + header.second;
                values.put(Downloads.Impl.RequestHeaders.INSERT_KEY_PREFIX + index, headerString);
                index++;
            } //End block
            // ---------- Original Method ----------
            //int index = 0;
            //for (Pair<String, String> header : mRequestHeaders) {
                //String headerString = header.first + ": " + header.second;
                //values.put(Downloads.Impl.RequestHeaders.INSERT_KEY_PREFIX + index, headerString);
                //index++;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.153 -0400", hash_original_method = "19BA5B9D42AC58D8841CDF02C796EE38", hash_generated_method = "8AAA05226FC3A7C21CAD91BD68253EE9")
        private void putIfNonNull(ContentValues contentValues, String key, Object value) {
            addTaint(value.getTaint());
            addTaint(key.getTaint());
            addTaint(contentValues.getTaint());
    if(value != null)            
            {
                contentValues.put(key, value.toString());
            } //End block
            // ---------- Original Method ----------
            //if (value != null) {
                //contentValues.put(key, value.toString());
            //}
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.154 -0400", hash_original_field = "2DECCABC6A842947B60E39EA0FC15085", hash_generated_field = "2A08EDDDB593C12F8423C559DB638960")

        public static final int NETWORK_MOBILE = 1 << 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.154 -0400", hash_original_field = "C54F5B644D418630CECD1427EC0D4736", hash_generated_field = "A0D2C438A9D332F064354E5B5CD56CD8")

        public static final int NETWORK_WIFI = 1 << 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.155 -0400", hash_original_field = "9A22B40090C002AE86B482C4964ECE31", hash_generated_field = "6644414BD8BF5CC6D8AD8B436963ECCC")

        private static final int SCANNABLE_VALUE_YES = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.155 -0400", hash_original_field = "D84387C59443EF1276F988651568F162", hash_generated_field = "F899C70B939A165A118DBF442F8E45A8")

        private static final int SCANNABLE_VALUE_NO = 2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.155 -0400", hash_original_field = "EE7FE8DE87F42C3C75936AB3D965CBF9", hash_generated_field = "678667850A54425C02D37FACB767853B")

        public static final int VISIBILITY_VISIBLE = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.156 -0400", hash_original_field = "0B822A7032D74847E7AA17804167F0FE", hash_generated_field = "F285E9AEAAA3AB3B3BF3A904EF1F15E0")

        public static final int VISIBILITY_VISIBLE_NOTIFY_COMPLETED = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.156 -0400", hash_original_field = "3A9106B0FA476D6F55EC1E276A420B9C", hash_generated_field = "7C647F96488D335DF451E9699546D435")

        public static final int VISIBILITY_HIDDEN = 2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.156 -0400", hash_original_field = "D4129AD1EEC3964E36935A2F614BC446", hash_generated_field = "F99A308F434AB6F300224D2C143BC731")

        public static final int VISIBILITY_VISIBLE_NOTIFY_ONLY_COMPLETION = 3;
    }


    
    public static class Query {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.157 -0400", hash_original_field = "4F579D3D7BCB1271CC18AC1E755540D2", hash_generated_field = "5F8E81DCB2F7B395E24A391C0FACBDE6")

        private long[] mIds = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.158 -0400", hash_original_field = "AE5DCEBD02CF265CFB94CBED107BC43B", hash_generated_field = "F78B9285416B8C880978036645800403")

        private Integer mStatusFlags = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.159 -0400", hash_original_field = "7D3F9ACFBFDEDC26C8A47E8138C1E1A8", hash_generated_field = "39E6027705921A51748F7FC07E010111")

        private String mOrderByColumn = Downloads.Impl.COLUMN_LAST_MODIFICATION;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.159 -0400", hash_original_field = "707ADE263B8DE3CF22961F4796A34FED", hash_generated_field = "EED59D0671C844A1902BF26138BB3F37")

        private int mOrderDirection = ORDER_DESCENDING;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.160 -0400", hash_original_field = "BB54684F97A66C91A29A969F6C84B13D", hash_generated_field = "964B69564A78D777DDBF359D9B2AA67B")

        private boolean mOnlyIncludeVisibleInDownloadsUi = false;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.160 -0400", hash_original_method = "EFCA8790A91D69466A874AF6524F8E69", hash_generated_method = "EFCA8790A91D69466A874AF6524F8E69")
        public Query ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.162 -0400", hash_original_method = "782D3BAE9A57AE7F89D5C5E0BBC212BD", hash_generated_method = "E822746316D94D899C141F25E030DCD3")
        public Query setFilterById(long... ids) {
            mIds = ids;
Query var72A74007B2BE62B849F475C7BDA4658B_1144806736 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1144806736.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1144806736;
            // ---------- Original Method ----------
            //mIds = ids;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.163 -0400", hash_original_method = "CE9295EE41F323C50B34B72F478BD4C2", hash_generated_method = "2E90E0F8085B394911CA245A052F7F84")
        public Query setFilterByStatus(int flags) {
            mStatusFlags = flags;
Query var72A74007B2BE62B849F475C7BDA4658B_73211126 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_73211126.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_73211126;
            // ---------- Original Method ----------
            //mStatusFlags = flags;
            //return this;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.163 -0400", hash_original_method = "9600119EF208E670C5EE47F5F776ED3A", hash_generated_method = "51B69D3C5837D45F0AAC055E9F8B5D70")
        public Query setOnlyIncludeVisibleInDownloadsUi(boolean value) {
            mOnlyIncludeVisibleInDownloadsUi = value;
Query var72A74007B2BE62B849F475C7BDA4658B_1914485074 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1914485074.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1914485074;
            // ---------- Original Method ----------
            //mOnlyIncludeVisibleInDownloadsUi = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.164 -0400", hash_original_method = "969F069748FB75BDEDE2897D8F038415", hash_generated_method = "28E753F3AAB9EC3638F243DE68528E6A")
        public Query orderBy(String column, int direction) {
            addTaint(column.getTaint());
    if(direction != ORDER_ASCENDING && direction != ORDER_DESCENDING)            
            {
                IllegalArgumentException var208EC761F912C8057CB0FE9EF916DC3A_345212602 = new IllegalArgumentException("Invalid direction: " + direction);
                var208EC761F912C8057CB0FE9EF916DC3A_345212602.addTaint(taint);
                throw var208EC761F912C8057CB0FE9EF916DC3A_345212602;
            } //End block
    if(column.equals(COLUMN_LAST_MODIFIED_TIMESTAMP))            
            {
                mOrderByColumn = Downloads.Impl.COLUMN_LAST_MODIFICATION;
            } //End block
            else
    if(column.equals(COLUMN_TOTAL_SIZE_BYTES))            
            {
                mOrderByColumn = Downloads.Impl.COLUMN_TOTAL_BYTES;
            } //End block
            else
            {
                IllegalArgumentException varBFF98A55C1C699C2814EE99061C831C8_770733641 = new IllegalArgumentException("Cannot order by " + column);
                varBFF98A55C1C699C2814EE99061C831C8_770733641.addTaint(taint);
                throw varBFF98A55C1C699C2814EE99061C831C8_770733641;
            } //End block
            mOrderDirection = direction;
Query var72A74007B2BE62B849F475C7BDA4658B_1951044277 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1951044277.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1951044277;
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

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.166 -0400", hash_original_method = "3E117BB34A8C7FFA67D17AB4CC250832", hash_generated_method = "A3485872BB9D37066887952E2FE91145")
         Cursor runQuery(ContentResolver resolver, String[] projection, Uri baseUri) {
            addTaint(baseUri.getTaint());
            addTaint(projection[0].getTaint());
            addTaint(resolver.getTaint());
            Uri uri = baseUri;
            List<String> selectionParts = new ArrayList<String>();
            String[] selectionArgs = null;
    if(mIds != null)            
            {
                selectionParts.add(getWhereClauseForIds(mIds));
                selectionArgs = getWhereArgsForIds(mIds);
            } //End block
    if(mStatusFlags != null)            
            {
                List<String> parts = new ArrayList<String>();
    if((mStatusFlags & STATUS_PENDING) != 0)                
                {
                    parts.add(statusClause("=", Downloads.Impl.STATUS_PENDING));
                } //End block
    if((mStatusFlags & STATUS_RUNNING) != 0)                
                {
                    parts.add(statusClause("=", Downloads.Impl.STATUS_RUNNING));
                } //End block
    if((mStatusFlags & STATUS_PAUSED) != 0)                
                {
                    parts.add(statusClause("=", Downloads.Impl.STATUS_PAUSED_BY_APP));
                    parts.add(statusClause("=", Downloads.Impl.STATUS_WAITING_TO_RETRY));
                    parts.add(statusClause("=", Downloads.Impl.STATUS_WAITING_FOR_NETWORK));
                    parts.add(statusClause("=", Downloads.Impl.STATUS_QUEUED_FOR_WIFI));
                } //End block
    if((mStatusFlags & STATUS_SUCCESSFUL) != 0)                
                {
                    parts.add(statusClause("=", Downloads.Impl.STATUS_SUCCESS));
                } //End block
    if((mStatusFlags & STATUS_FAILED) != 0)                
                {
                    parts.add("(" + statusClause(">=", 400)
                              + " AND " + statusClause("<", 600) + ")");
                } //End block
                selectionParts.add(joinStrings(" OR ", parts));
            } //End block
    if(mOnlyIncludeVisibleInDownloadsUi)            
            {
                selectionParts.add(Downloads.Impl.COLUMN_IS_VISIBLE_IN_DOWNLOADS_UI + " != '0'");
            } //End block
            selectionParts.add(Downloads.Impl.COLUMN_DELETED + " != '1'");
            String selection = joinStrings(" AND ", selectionParts);
            String orderDirection = (mOrderDirection == ORDER_ASCENDING ? "ASC" : "DESC");
            String orderBy = mOrderByColumn + " " + orderDirection;
Cursor varED0136AE3D1D451722AEDAE7CBDBB4AC_172892746 =             resolver.query(uri, projection, selection, selectionArgs, orderBy);
            varED0136AE3D1D451722AEDAE7CBDBB4AC_172892746.addTaint(taint);
            return varED0136AE3D1D451722AEDAE7CBDBB4AC_172892746;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.168 -0400", hash_original_method = "E982889F0CE13C731CA9D89AB5FD3B78", hash_generated_method = "7561A51B5547EB4C8F27CD1D7CB31F7D")
        private String joinStrings(String joiner, Iterable<String> parts) {
            addTaint(parts.getTaint());
            addTaint(joiner.getTaint());
            StringBuilder builder = new StringBuilder();
            boolean first = true;
for(String part : parts)
            {
    if(!first)                
                {
                    builder.append(joiner);
                } //End block
                builder.append(part);
                first = false;
            } //End block
String varF4CF030572656354ACFDF83FEE21D7A6_164396247 =             builder.toString();
            varF4CF030572656354ACFDF83FEE21D7A6_164396247.addTaint(taint);
            return varF4CF030572656354ACFDF83FEE21D7A6_164396247;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.168 -0400", hash_original_method = "F1C2C126003D565FB51A9C1A25E86357", hash_generated_method = "AD9E53716F87E5F88963A98F429E2DDE")
        private String statusClause(String operator, int value) {
            addTaint(value);
            addTaint(operator.getTaint());
String var301A4207D137C8EA4EF56F87F78044E6_1308900692 =             Downloads.Impl.COLUMN_STATUS + operator + "'" + value + "'";
            var301A4207D137C8EA4EF56F87F78044E6_1308900692.addTaint(taint);
            return var301A4207D137C8EA4EF56F87F78044E6_1308900692;
            // ---------- Original Method ----------
            //return Downloads.Impl.COLUMN_STATUS + operator + "'" + value + "'";
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.169 -0400", hash_original_field = "4FDB899E3766A064074C9081C7B6A267", hash_generated_field = "33AF9DE750C57D52372B21F0E7746D47")

        public static final int ORDER_ASCENDING = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.169 -0400", hash_original_field = "2E1B9074F3BE6834ABC0129E780F4F46", hash_generated_field = "2CF799A3EEA7BC4C831B8EB82D2B58DE")

        public static final int ORDER_DESCENDING = 2;
    }


    
    private static class CursorTranslator extends CursorWrapper {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.169 -0400", hash_original_field = "718CF095732EDC4F563D086AE0B1FE46", hash_generated_field = "352FDC66A51EED366C84411537612673")

        private Uri mBaseUri;
        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.170 -0400", hash_original_method = "DA2C30EB999FAADAF9AB1439D3B9F223", hash_generated_method = "1DA672EC02AC581A572B00BC4EEFBBB5")
        public  CursorTranslator(Cursor cursor, Uri baseUri) {
            super(cursor);
            addTaint(cursor.getTaint());
            mBaseUri = baseUri;
            // ---------- Original Method ----------
            //mBaseUri = baseUri;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.170 -0400", hash_original_method = "34538125BB8387937A75DA11F9FB5B65", hash_generated_method = "C63837AED63065F09D9917E8495153D0")
        @Override
        public int getInt(int columnIndex) {
            addTaint(columnIndex);
            int var37F43EAAC0B26577EBF325916B1F1DB0_1717910506 = ((int) getLong(columnIndex));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_159430292 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_159430292;
            // ---------- Original Method ----------
            //return (int) getLong(columnIndex);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.171 -0400", hash_original_method = "744FA54C78DD5C7B6737C741AD0EB8F1", hash_generated_method = "499BB49980D20C9C7368F47E720EF241")
        @Override
        public long getLong(int columnIndex) {
            addTaint(columnIndex);
    if(getColumnName(columnIndex).equals(COLUMN_REASON))            
            {
                long varF224FE737393835BE02803E904D84F4D_2004072642 = (getReason(super.getInt(getColumnIndex(Downloads.Impl.COLUMN_STATUS))));
                                long var0F5264038205EDFB1AC05FBB0E8C5E94_1161095069 = getTaintLong();
                return var0F5264038205EDFB1AC05FBB0E8C5E94_1161095069;
            } //End block
            else
    if(getColumnName(columnIndex).equals(COLUMN_STATUS))            
            {
                long varE5C0E5E9365838567EE57EFD92E1E6E4_1868844644 = (translateStatus(super.getInt(getColumnIndex(Downloads.Impl.COLUMN_STATUS))));
                                long var0F5264038205EDFB1AC05FBB0E8C5E94_893887261 = getTaintLong();
                return var0F5264038205EDFB1AC05FBB0E8C5E94_893887261;
            } //End block
            else
            {
                long var6CA48391079998EF08A6D1544DA59BD5_2144111983 = (super.getLong(columnIndex));
                                long var0F5264038205EDFB1AC05FBB0E8C5E94_1320608161 = getTaintLong();
                return var0F5264038205EDFB1AC05FBB0E8C5E94_1320608161;
            } //End block
            // ---------- Original Method ----------
            //if (getColumnName(columnIndex).equals(COLUMN_REASON)) {
                //return getReason(super.getInt(getColumnIndex(Downloads.Impl.COLUMN_STATUS)));
            //} else if (getColumnName(columnIndex).equals(COLUMN_STATUS)) {
                //return translateStatus(super.getInt(getColumnIndex(Downloads.Impl.COLUMN_STATUS)));
            //} else {
                //return super.getLong(columnIndex);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.172 -0400", hash_original_method = "2A6CC35BB4DF843267A861B5828C6994", hash_generated_method = "4B943E674521B94101464E26F6EC582F")
        @Override
        public String getString(int columnIndex) {
            addTaint(columnIndex);
String varE33FF2323B78F36FA3951A6E8D3B7DBC_1402241148 =             (getColumnName(columnIndex).equals(COLUMN_LOCAL_URI)) ? getLocalUri() :
                    super.getString(columnIndex);
            varE33FF2323B78F36FA3951A6E8D3B7DBC_1402241148.addTaint(taint);
            return varE33FF2323B78F36FA3951A6E8D3B7DBC_1402241148;
            // ---------- Original Method ----------
            //return (getColumnName(columnIndex).equals(COLUMN_LOCAL_URI)) ? getLocalUri() :
                    //super.getString(columnIndex);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.172 -0400", hash_original_method = "C2F388AD18BA84031DEC0607FBEAB7C5", hash_generated_method = "872A12265E9FC89497627D058674B594")
        private String getLocalUri() {
            long destinationType = getLong(getColumnIndex(Downloads.Impl.COLUMN_DESTINATION));
    if(destinationType == Downloads.Impl.DESTINATION_FILE_URI ||
                    destinationType == Downloads.Impl.DESTINATION_EXTERNAL ||
                    destinationType == Downloads.Impl.DESTINATION_NON_DOWNLOADMANAGER_DOWNLOAD)            
            {
                String localPath = getString(getColumnIndex(COLUMN_LOCAL_FILENAME));
    if(localPath == null)                
                {
String var540C13E9E156B687226421B24F2DF178_995643124 =                     null;
                    var540C13E9E156B687226421B24F2DF178_995643124.addTaint(taint);
                    return var540C13E9E156B687226421B24F2DF178_995643124;
                } //End block
String var920B90299FCF0ADD777961EEC56ACE33_631834561 =                 Uri.fromFile(new File(localPath)).toString();
                var920B90299FCF0ADD777961EEC56ACE33_631834561.addTaint(taint);
                return var920B90299FCF0ADD777961EEC56ACE33_631834561;
            } //End block
            long downloadId = getLong(getColumnIndex(Downloads.Impl._ID));
String var1D634E7EDE0A065AC76D9E1BA7D6C3B8_68849718 =             ContentUris.withAppendedId(mBaseUri, downloadId).toString();
            var1D634E7EDE0A065AC76D9E1BA7D6C3B8_68849718.addTaint(taint);
            return var1D634E7EDE0A065AC76D9E1BA7D6C3B8_68849718;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.174 -0400", hash_original_method = "A69C93787DF2FD0B667931CA82E74881", hash_generated_method = "95B50749EC48F8FEB934CC2AACAC9856")
        private long getReason(int status) {
            addTaint(status);
switch(translateStatus(status)){
            case STATUS_FAILED:
            long varF98D0AF95D2EDD390B627529438E42C7_535475917 = (getErrorCode(status));
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1631309285 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1631309285;
            case STATUS_PAUSED:
            long var8D0F1203B948621892BF61A05BCE8885_149493985 = (getPausedReason(status));
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1226797605 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1226797605;
            default:
            long varCFCD208495D565EF66E7DFF9F98764DA_445737243 = (0);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1816245432 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1816245432;
}
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

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.175 -0400", hash_original_method = "8BF9F68328111BA50CCB78B1792F76F0", hash_generated_method = "3AC6BE649EDEEF478E9C97CF1DE594CC")
        private long getPausedReason(int status) {
            addTaint(status);
switch(status){
            case Downloads.Impl.STATUS_WAITING_TO_RETRY:
            long var028154002A745F58A087B20D091D8B66_1523910425 = (PAUSED_WAITING_TO_RETRY);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1031292045 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1031292045;
            case Downloads.Impl.STATUS_WAITING_FOR_NETWORK:
            long var0B11E891B95094A89129817F9A2E4EC8_1139888079 = (PAUSED_WAITING_FOR_NETWORK);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_644830200 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_644830200;
            case Downloads.Impl.STATUS_QUEUED_FOR_WIFI:
            long var0662F13983CD54EA13B576ECFEA23F74_821501069 = (PAUSED_QUEUED_FOR_WIFI);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_742381889 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_742381889;
            default:
            long var2674015F84C736FD016B900595AE74A0_659938424 = (PAUSED_UNKNOWN);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_396399307 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_396399307;
}
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

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.177 -0400", hash_original_method = "A27080D0C32BDBDFED7217EFE39DC72F", hash_generated_method = "97FEDD69875AAE1B51FB919DEDCE1D63")
        private long getErrorCode(int status) {
            addTaint(status);
    if((400 <= status && status < Downloads.Impl.MIN_ARTIFICIAL_ERROR_STATUS)
                    || (500 <= status && status < 600))            
            {
                long var9ACB44549B41563697BB490144EC6258_977098628 = (status);
                                long var0F5264038205EDFB1AC05FBB0E8C5E94_1001823715 = getTaintLong();
                return var0F5264038205EDFB1AC05FBB0E8C5E94_1001823715;
            } //End block
switch(status){
            case Downloads.Impl.STATUS_FILE_ERROR:
            long var9F98BB971CB17EFF48E9FAAFE1FAD494_1446156308 = (ERROR_FILE_ERROR);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_309147249 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_309147249;
            case Downloads.Impl.STATUS_UNHANDLED_HTTP_CODE:
            case Downloads.Impl.STATUS_UNHANDLED_REDIRECT:
            long var9B427B8D3E7A704D2BC0EDB480B34A1E_229983063 = (ERROR_UNHANDLED_HTTP_CODE);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_302762092 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_302762092;
            case Downloads.Impl.STATUS_HTTP_DATA_ERROR:
            long varA58F6D32A05063580E0672B0DEAC0549_1020047271 = (ERROR_HTTP_DATA_ERROR);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1190122540 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1190122540;
            case Downloads.Impl.STATUS_TOO_MANY_REDIRECTS:
            long varBDE5DA8B2A96469F5AD43D3FE4BCA209_1670245879 = (ERROR_TOO_MANY_REDIRECTS);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_846222069 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_846222069;
            case Downloads.Impl.STATUS_INSUFFICIENT_SPACE_ERROR:
            long varEC340D80CCD7319AFB39349EC6AE3A2D_499540813 = (ERROR_INSUFFICIENT_SPACE);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1452079561 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1452079561;
            case Downloads.Impl.STATUS_DEVICE_NOT_FOUND_ERROR:
            long var435F5D8F4B2415112B9E4E3B352FD999_600600449 = (ERROR_DEVICE_NOT_FOUND);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1794717746 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1794717746;
            case Downloads.Impl.STATUS_CANNOT_RESUME:
            long varDA482B5542F90F4EC3A0841DA7F4A93F_542056666 = (ERROR_CANNOT_RESUME);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1870103562 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1870103562;
            case Downloads.Impl.STATUS_FILE_ALREADY_EXISTS_ERROR:
            long var50D40A1F865F4D83F5F8C75DA06D841C_607852916 = (ERROR_FILE_ALREADY_EXISTS);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_445125527 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_445125527;
            case Downloads.Impl.STATUS_BLOCKED:
            long varD5FB9C9910695BA8D67D80F93F747A9A_665830008 = (ERROR_BLOCKED);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1199285906 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1199285906;
            default:
            long var0A306E577F7923AC78D86A60BEE66966_516047544 = (ERROR_UNKNOWN);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1779010870 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1779010870;
}
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.179 -0400", hash_original_method = "AC0B465D7BF7B10F5608906AFAA7CE72", hash_generated_method = "82B2CF8D41F8D4846D041B0988B97887")
        private int translateStatus(int status) {
            addTaint(status);
switch(status){
            case Downloads.Impl.STATUS_PENDING:
            int var767DDE9D10DAC1B1EAABBF0F6C51814C_490531205 = (STATUS_PENDING);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1693804042 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1693804042;
            case Downloads.Impl.STATUS_RUNNING:
            int var727C712953EA5A6C4F963C95B3B750E3_1714703418 = (STATUS_RUNNING);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_633164233 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_633164233;
            case Downloads.Impl.STATUS_PAUSED_BY_APP:
            case Downloads.Impl.STATUS_WAITING_TO_RETRY:
            case Downloads.Impl.STATUS_WAITING_FOR_NETWORK:
            case Downloads.Impl.STATUS_QUEUED_FOR_WIFI:
            int varB2C59B446ED2CEDD216E038017091B2E_5801773 = (STATUS_PAUSED);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1510173230 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1510173230;
            case Downloads.Impl.STATUS_SUCCESS:
            int varD23D9492A3BD1374EC1F40BED7C7B412_880703253 = (STATUS_SUCCESSFUL);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_793203237 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_793203237;
            default:
            int var073697B2A5BF9563BC184F10E3DB1511_2103822445 = (STATUS_FAILED);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_383341264 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_383341264;
}
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


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.180 -0400", hash_original_field = "28E13913130DC317027A75F9CAADB6E6", hash_generated_field = "A7E023A8D48EDA84D30E823FC247AC7D")

    public final static String COLUMN_ID = Downloads.Impl._ID;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.180 -0400", hash_original_field = "4F18DB729598483955C67DF843942E9B", hash_generated_field = "E0475ED0F443C2F35BA6DAC29B806E15")

    public final static String COLUMN_TITLE = Downloads.Impl.COLUMN_TITLE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.180 -0400", hash_original_field = "C7A6174B374253166E3D4F540CB3899A", hash_generated_field = "2ADDAD1D6BE2368DD43079C018505DC2")

    public final static String COLUMN_DESCRIPTION = Downloads.Impl.COLUMN_DESCRIPTION;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.180 -0400", hash_original_field = "8AAE7CAB40335C45902B3C3A4B4359D4", hash_generated_field = "143198F8ECD99C932C3BA352BDD7B4F6")

    public final static String COLUMN_URI = Downloads.Impl.COLUMN_URI;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.180 -0400", hash_original_field = "769FA87A9CCB7D4CA16571486316ACCC", hash_generated_field = "9BF784ED01C8E5392F5BB2D34F27F68B")

    public final static String COLUMN_MEDIA_TYPE = "media_type";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.180 -0400", hash_original_field = "26A36CC9B29C427A7705DA55CD804EB2", hash_generated_field = "84BD203A764C2D32D032768E5BA85C6A")

    public final static String COLUMN_TOTAL_SIZE_BYTES = "total_size";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.181 -0400", hash_original_field = "E36D1141E52AA346782AC8609221301B", hash_generated_field = "87092124AEB640ED262648BE065600C9")

    public final static String COLUMN_LOCAL_URI = "local_uri";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.181 -0400", hash_original_field = "E6F63FD9C72D36809812647B3A97AAC7", hash_generated_field = "38930F295047A3F6AE0AC7B02C24770A")

    public final static String COLUMN_LOCAL_FILENAME = "local_filename";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.181 -0400", hash_original_field = "D0941CF2EAA2934186552963A9F2F3C1", hash_generated_field = "AD200817B86CDDB6809552A585F6F3CB")

    public final static String COLUMN_STATUS = Downloads.Impl.COLUMN_STATUS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.181 -0400", hash_original_field = "B392173D4EE64EB34E055EAA4249CA25", hash_generated_field = "D7D42B4B48EDF0D303BF107E8C2B9639")

    public final static String COLUMN_REASON = "reason";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.181 -0400", hash_original_field = "D4687D5D1BC923240E08E965E50C32D3", hash_generated_field = "E75A5474EBC7BBC6DB9427B4EA03D662")

    public final static String COLUMN_BYTES_DOWNLOADED_SO_FAR = "bytes_so_far";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.181 -0400", hash_original_field = "CF721E7C812971EC93264A0FEA00EFD1", hash_generated_field = "70EB989845348DC7DAA5AF45C362A8C0")

    public final static String COLUMN_LAST_MODIFIED_TIMESTAMP = "last_modified_timestamp";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.181 -0400", hash_original_field = "B8D99CC2D9EE6FDC3C5B92F362B619D5", hash_generated_field = "E798B6BCD082848B6F5403070514339F")

    public static final String COLUMN_MEDIAPROVIDER_URI = Downloads.Impl.COLUMN_MEDIAPROVIDER_URI;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.181 -0400", hash_original_field = "D9920B04BB8875828838F10EF6BCAC8A", hash_generated_field = "5A6A6A376CA33569B014DF98BB4486F5")

    public final static int STATUS_PENDING = 1 << 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.182 -0400", hash_original_field = "787F81C54F7669D7B5DFC4C4E59E3970", hash_generated_field = "DDF3A08F677DC31638E00F51A652178C")

    public final static int STATUS_RUNNING = 1 << 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.182 -0400", hash_original_field = "CD3563EE6AD32EC86F2B215DEE0E86AA", hash_generated_field = "B6CF42D4BE6CC4E35C56FF7AFD758358")

    public final static int STATUS_PAUSED = 1 << 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.182 -0400", hash_original_field = "F5C8808AF0D080F35FEB54862F0B5E83", hash_generated_field = "16CE303BA58E19D2E9F3935ACB3CE0FB")

    public final static int STATUS_SUCCESSFUL = 1 << 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.182 -0400", hash_original_field = "F2A4B8336D15E7C1C353A849AA6B8458", hash_generated_field = "1BCCE4C740453C51D27A9C44E3F68B40")

    public final static int STATUS_FAILED = 1 << 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.182 -0400", hash_original_field = "B1B8CF8DDF7369BDFB1FDEFD0E148A26", hash_generated_field = "49F5D6EC283C95877C76975EF6E926C6")

    public final static int ERROR_UNKNOWN = 1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.182 -0400", hash_original_field = "87C83208A97BE663E34D9647DF2EF7E6", hash_generated_field = "0E73FEF6AA8AAE6DB010C8400B9928BE")

    public final static int ERROR_FILE_ERROR = 1001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.183 -0400", hash_original_field = "CFCFE2CD6A0A8BD4DF43CEFE343700A7", hash_generated_field = "1AC4CB82DAEB32AFCC84E359B353A84E")

    public final static int ERROR_UNHANDLED_HTTP_CODE = 1002;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.183 -0400", hash_original_field = "6E78B11D35FB475E28CA97D4E6C547B1", hash_generated_field = "7D7BB2F4DF6F4E9B6967224CE2FAF5E8")

    public final static int ERROR_HTTP_DATA_ERROR = 1004;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.183 -0400", hash_original_field = "E97C109F2226A38F6B0A0CBFBF78E56E", hash_generated_field = "7D1894872E657F2F1D75836AC335D1AF")

    public final static int ERROR_TOO_MANY_REDIRECTS = 1005;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.183 -0400", hash_original_field = "5B6B1D13BAF3583DB3FC3880D5CF5310", hash_generated_field = "4745C1817D6FFD01542FD1D7B9BCDF6B")

    public final static int ERROR_INSUFFICIENT_SPACE = 1006;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.183 -0400", hash_original_field = "42B9606B5DE02CD5B870EC439CBC4799", hash_generated_field = "D22E5678B4FACB05F514DC5331AD6F98")

    public final static int ERROR_DEVICE_NOT_FOUND = 1007;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.183 -0400", hash_original_field = "D9CB71BDB7ED1A07CEDC0B5C7ACF2016", hash_generated_field = "310C5FB2CCFCEBB3F61B6B0F16B85CE9")

    public final static int ERROR_CANNOT_RESUME = 1008;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.183 -0400", hash_original_field = "4DADA07169D41492B63745757EBB9BAE", hash_generated_field = "03022A2BA7BEFEFA9680B89BFC241220")

    public final static int ERROR_FILE_ALREADY_EXISTS = 1009;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.184 -0400", hash_original_field = "742BD13A8B7D1BAC4F048EE8E11696BA", hash_generated_field = "95F9CC4D3D18A2E56CF90C0970647D3D")

    public final static int ERROR_BLOCKED = 1010;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.184 -0400", hash_original_field = "53DCCFB529054899419C09B1FC8D527A", hash_generated_field = "375A127B5A11AB6F86CDA6C2E7687C81")

    public final static int PAUSED_WAITING_TO_RETRY = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.184 -0400", hash_original_field = "CF8B92A918BA25E72267510856BBDF24", hash_generated_field = "1AB4E417B461169A72753CA5536FB9C8")

    public final static int PAUSED_WAITING_FOR_NETWORK = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.184 -0400", hash_original_field = "D315A0B4812ACA7922F6DE58705DC22F", hash_generated_field = "4C94328F0C2918D47EFCEA3271E499DF")

    public final static int PAUSED_QUEUED_FOR_WIFI = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.184 -0400", hash_original_field = "D77A325B9B8C28B05140B5D47218D329", hash_generated_field = "4D9D144F191E78908A11C759352904B6")

    public final static int PAUSED_UNKNOWN = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.184 -0400", hash_original_field = "278C5BA979AEAF9E5167F1A8C082AE5B", hash_generated_field = "F59DDF2C5961F68B20C867F8313BBEFB")

    public final static String ACTION_DOWNLOAD_COMPLETE = "android.intent.action.DOWNLOAD_COMPLETE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.185 -0400", hash_original_field = "7749EC94D727FDDDEFDAB2D0EAE57B72", hash_generated_field = "C99B78141EF70699F8A2ED7E9CB8DD42")

    public final static String ACTION_NOTIFICATION_CLICKED =
            "android.intent.action.DOWNLOAD_NOTIFICATION_CLICKED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.185 -0400", hash_original_field = "036041F33A2303C21F448683E744290A", hash_generated_field = "DE2A2BF8E91A6F3A9065C043915477FB")

    public final static String ACTION_VIEW_DOWNLOADS = "android.intent.action.VIEW_DOWNLOADS";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.185 -0400", hash_original_field = "A5BDC999C90856BFDD040E48EF31A616", hash_generated_field = "3301DDAE8E2BAA3A9528297879FE4303")

    public final static String INTENT_EXTRAS_SORT_BY_SIZE =
            "android.app.DownloadManager.extra_sortBySize";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.185 -0400", hash_original_field = "5220593F731D0C32288FAAE6C6B442FF", hash_generated_field = "937B93366C4C3FE30B8BE2FA09D9B445")

    public static final String EXTRA_DOWNLOAD_ID = "extra_download_id";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.185 -0400", hash_original_field = "7F8AD7318CBA22EA99DF8C7689BD846C", hash_generated_field = "4DF09F4FBB097DF9B81CC166A5136DAA")

    public static final String EXTRA_NOTIFICATION_CLICK_DOWNLOAD_IDS = "extra_click_download_ids";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.185 -0400", hash_original_field = "D950C56A7A90C4B58D865C265F965355", hash_generated_field = "35D0E0EA646E6DE036699985804C1F7A")

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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:02.186 -0400", hash_original_field = "CB6BAA7FD313D1CA2A881424B9358C2E", hash_generated_field = "7F3BE0CBA2F29054F2C27E2E352EC965")

    private static final String NON_DOWNLOADMANAGER_DOWNLOAD = "non-dwnldmngr-download-dont-retry2download";
}

