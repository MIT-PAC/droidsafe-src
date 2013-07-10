package android.app;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.637 -0400", hash_original_field = "CF849E3C15214EFD093D4303B542BF44", hash_generated_field = "2ABF989C5B8F051BCBEE638ED1EA2586")

    private ContentResolver mResolver;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.637 -0400", hash_original_field = "BE0173788749EF3CF5679DF9E1224605", hash_generated_field = "6F81845A3A2771C3EC987E5A01DBA4C6")

    private String mPackageName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.637 -0400", hash_original_field = "55833456165B236ED25F84EACF5CF2CA", hash_generated_field = "1AFB71B4D196CA91BC22831E08A191CF")

    private Uri mBaseUri = Downloads.Impl.CONTENT_URI;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.638 -0400", hash_original_method = "E62D0E970789924902081BF03F031FF8", hash_generated_method = "7F4F9C5FA27047A7434D2EC70ADE844E")
    public  DownloadManager(ContentResolver resolver, String packageName) {
        mResolver = resolver;
        mPackageName = packageName;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.639 -0400", hash_original_method = "93AAF1C0A18C9EFC24526B178CE628E3", hash_generated_method = "4B3277B5958759FC38CEC345308879B2")
    public void setAccessAllDownloads(boolean accessAllDownloads) {
        {
            mBaseUri = Downloads.Impl.ALL_DOWNLOADS_CONTENT_URI;
        } 
        {
            mBaseUri = Downloads.Impl.CONTENT_URI;
        } 
        addTaint(accessAllDownloads);
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.639 -0400", hash_original_method = "A2E8022D1487E0DC7C6CC7B8DABAC46D", hash_generated_method = "3DFA09B3B98785A7F3478FB3684BAE87")
    public long enqueue(Request request) {
        ContentValues values = request.toContentValues(mPackageName);
        Uri downloadUri = mResolver.insert(Downloads.Impl.CONTENT_URI, values);
        long id = Long.parseLong(downloadUri.getLastPathSegment());
        addTaint(request.getTaint());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1973675928 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1973675928;
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.640 -0400", hash_original_method = "6A912115CBBE4D263FCD27B2696D5371", hash_generated_method = "01E5C06C758970302FEEF6BE6DC73E6C")
    public int markRowDeleted(long... ids) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("input param 'ids' can't be null");
        } 
        ContentValues values = new ContentValues();
        values.put(Downloads.Impl.COLUMN_DELETED, 1);
        {
            int var393CDEAF16A98CB7AA432C3584D5C8FE_1017098702 = (mResolver.update(ContentUris.withAppendedId(mBaseUri, ids[0]), values,
                    null, null));
        } 
        int varA0E20C895CB99149E1A0E29E0C592FBD_1169510275 = (mResolver.update(mBaseUri, values, getWhereClauseForIds(ids),
                getWhereArgsForIds(ids)));
        addTaint(ids[0]);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1835049661 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1835049661;
        
        
            
        
        
        
        
            
                    
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.641 -0400", hash_original_method = "E87735CFC3568A22F95F85C3BABBD5E2", hash_generated_method = "CA870F0E8316547122F74B2AA63B6841")
    public int remove(long... ids) {
        int var0D18E7E451A7FE8C6FC024A1060C0496_125561285 = (markRowDeleted(ids));
        addTaint(ids[0]);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_233959870 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_233959870;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.642 -0400", hash_original_method = "AA3C14DF1A360F6707C442D7B10D5AD3", hash_generated_method = "DE622C287CDD51E4AE7A19E9D4312EB0")
    public Cursor query(Query query) {
        Cursor varB4EAC82CA7396A68D541C85D26508E83_749089532 = null; 
        Cursor varB4EAC82CA7396A68D541C85D26508E83_594803171 = null; 
        Cursor underlyingCursor = query.runQuery(mResolver, UNDERLYING_COLUMNS, mBaseUri);
        {
            varB4EAC82CA7396A68D541C85D26508E83_749089532 = null;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_594803171 = new CursorTranslator(underlyingCursor, mBaseUri);
        addTaint(query.getTaint());
        Cursor varA7E53CE21691AB073D9660D615818899_1981275096; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1981275096 = varB4EAC82CA7396A68D541C85D26508E83_749089532;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1981275096 = varB4EAC82CA7396A68D541C85D26508E83_594803171;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1981275096.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1981275096;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.643 -0400", hash_original_method = "41561235219E48E784E85B3D8CB5CB93", hash_generated_method = "DCA856F14792CCD81FC603BE80E978FB")
    public ParcelFileDescriptor openDownloadedFile(long id) throws FileNotFoundException {
        ParcelFileDescriptor varB4EAC82CA7396A68D541C85D26508E83_567329041 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_567329041 = mResolver.openFileDescriptor(getDownloadUri(id), "r");
        addTaint(id);
        varB4EAC82CA7396A68D541C85D26508E83_567329041.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_567329041;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.645 -0400", hash_original_method = "82FD0DABBA6B80B8B4BA3DF76B66A3D1", hash_generated_method = "46C03490D7809AD2D19525D4E55B0F4B")
    public Uri getUriForDownloadedFile(long id) {
        Uri varB4EAC82CA7396A68D541C85D26508E83_481965130 = null; 
        Uri varB4EAC82CA7396A68D541C85D26508E83_653427257 = null; 
        Uri varB4EAC82CA7396A68D541C85D26508E83_1168178471 = null; 
        Uri varB4EAC82CA7396A68D541C85D26508E83_1780612868 = null; 
        Query query = new Query().setFilterById(id);
        Cursor cursor = null;
        try 
        {
            cursor = query(query);
            {
                varB4EAC82CA7396A68D541C85D26508E83_481965130 = null;
            } 
            {
                boolean varCDEB7019138899FEAFBEC62FC2A4BF86_797728760 = (cursor.moveToFirst());
                {
                    int status = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_STATUS));
                    {
                        int indx = cursor.getColumnIndexOrThrow(
                            Downloads.Impl.COLUMN_DESTINATION);
                        int destination = cursor.getInt(indx);
                        {
                            varB4EAC82CA7396A68D541C85D26508E83_653427257 = ContentUris.withAppendedId(Downloads.Impl.CONTENT_URI, id);
                        } 
                        {
                            String path = cursor.getString(
                                cursor.getColumnIndexOrThrow(COLUMN_LOCAL_FILENAME));
                            varB4EAC82CA7396A68D541C85D26508E83_1168178471 = Uri.fromFile(new File(path));
                        } 
                    } 
                } 
            } 
        } 
        finally 
        {
            {
                cursor.close();
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1780612868 = null;
        addTaint(id);
        Uri varA7E53CE21691AB073D9660D615818899_1497975983; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1497975983 = varB4EAC82CA7396A68D541C85D26508E83_481965130;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1497975983 = varB4EAC82CA7396A68D541C85D26508E83_653427257;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_1497975983 = varB4EAC82CA7396A68D541C85D26508E83_1168178471;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1497975983 = varB4EAC82CA7396A68D541C85D26508E83_1780612868;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1497975983.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1497975983;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.646 -0400", hash_original_method = "EC65E8932FA161BF4DAEC74FC802F48D", hash_generated_method = "ADB7468D61060F4B314429444973B22C")
    public String getMimeTypeForDownloadedFile(long id) {
        String varB4EAC82CA7396A68D541C85D26508E83_1153327900 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_332360576 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1611610882 = null; 
        Query query = new Query().setFilterById(id);
        Cursor cursor = null;
        try 
        {
            cursor = query(query);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1153327900 = null;
            } 
            {
                boolean varCDEB7019138899FEAFBEC62FC2A4BF86_750335273 = (cursor.moveToFirst());
                {
                    varB4EAC82CA7396A68D541C85D26508E83_332360576 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_MEDIA_TYPE));
                } 
            } 
        } 
        finally 
        {
            {
                cursor.close();
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1611610882 = null;
        addTaint(id);
        String varA7E53CE21691AB073D9660D615818899_227380400; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_227380400 = varB4EAC82CA7396A68D541C85D26508E83_1153327900;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_227380400 = varB4EAC82CA7396A68D541C85D26508E83_332360576;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_227380400 = varB4EAC82CA7396A68D541C85D26508E83_1611610882;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_227380400.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_227380400;
        
        
        
        
            
            
                
            
            
                
            
        
            
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.647 -0400", hash_original_method = "ABDC33D84A29539A96C484C81BD10405", hash_generated_method = "3022BDC7BA7CA89E0C1D40A82E3AFB49")
    public void restartDownload(long... ids) {
        Cursor cursor = query(new Query().setFilterById(ids));
        try 
        {
            {
                cursor.moveToFirst();
                boolean varC9BB7A46744D2622E2F78BF928704FDD_1876301001 = (!cursor.isAfterLast());
                cursor.moveToNext();
                {
                    int status = cursor.getInt(cursor.getColumnIndex(COLUMN_STATUS));
                    {
                        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Cannot restart incomplete download: "
                            + cursor.getLong(cursor.getColumnIndex(COLUMN_ID)));
                    } 
                } 
            } 
        } 
        finally 
        {
            cursor.close();
        } 
        ContentValues values = new ContentValues();
        values.put(Downloads.Impl.COLUMN_CURRENT_BYTES, 0);
        values.put(Downloads.Impl.COLUMN_TOTAL_BYTES, -1);
        values.putNull(Downloads.Impl._DATA);
        values.put(Downloads.Impl.COLUMN_STATUS, Downloads.Impl.STATUS_PENDING);
        mResolver.update(mBaseUri, values, getWhereClauseForIds(ids), getWhereArgsForIds(ids));
        addTaint(ids[0]);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    public static Long getMaxBytesOverMobile(Context context) {
        try {
            return Settings.Secure.getLong(context.getContentResolver(),
                    Settings.Secure.DOWNLOAD_MAX_BYTES_OVER_MOBILE);
        } catch (SettingNotFoundException exc) {
            return null;
        }
    }

    
    @DSModeled(DSC.SAFE)
    public static Long getRecommendedMaxBytesOverMobile(Context context) {
        try {
            return Settings.Secure.getLong(context.getContentResolver(),
                    Settings.Secure.DOWNLOAD_RECOMMENDED_MAX_BYTES_OVER_MOBILE);
        } catch (SettingNotFoundException exc) {
            return null;
        }
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.648 -0400", hash_original_method = "58F6793B30C14E2CFD3653910A805BA2", hash_generated_method = "1C3DDC03D730FAE0B6BF062D0F53B03F")
    public long addCompletedDownload(String title, String description,
            boolean isMediaScannerScannable, String mimeType, String path, long length,
            boolean showNotification) {
        validateArgumentIsNonEmpty("title", title);
        validateArgumentIsNonEmpty("description", description);
        validateArgumentIsNonEmpty("path", path);
        validateArgumentIsNonEmpty("mimeType", mimeType);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(" invalid value for param: totalBytes");
        } 
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
        long varA2F7CDA3EACA1ABC1BF253D57B57724C_809526619 = (Long.parseLong(downloadUri.getLastPathSegment()));
        addTaint(title.getTaint());
        addTaint(description.getTaint());
        addTaint(isMediaScannerScannable);
        addTaint(mimeType.getTaint());
        addTaint(path.getTaint());
        addTaint(length);
        addTaint(showNotification);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_350586223 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_350586223;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    private static void validateArgumentIsNonEmpty(String paramName, String val) {
        if (TextUtils.isEmpty(val)) {
            throw new IllegalArgumentException(paramName + " can't be null");
        }
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.650 -0400", hash_original_method = "D1EE950396677328804F68406B4587AE", hash_generated_method = "187E43201E8E30BE5DA030213E301268")
     Uri getDownloadUri(long id) {
        Uri varB4EAC82CA7396A68D541C85D26508E83_1658615084 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1658615084 = ContentUris.withAppendedId(mBaseUri, id);
        addTaint(id);
        varB4EAC82CA7396A68D541C85D26508E83_1658615084.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1658615084;
        
        
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    static String[] getWhereArgsForIds(long[] ids) {
        String[] whereArgs = new String[ids.length];
        for (int i = 0; i < ids.length; i++) {
            whereArgs[i] = Long.toString(ids[i]);
        }
        return whereArgs;
    }

    
    public static class Request {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.651 -0400", hash_original_field = "5FBE3730DCFF234F97B15868D5CE649D", hash_generated_field = "04FA8EB5D9FB8AC4AAE6453BCF1BBF82")

        private Uri mUri;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.651 -0400", hash_original_field = "D56C02C2196A65236C80C7DCE28A3AB7", hash_generated_field = "83BAA5C2BC0662F1D32FE83EA4951897")

        private Uri mDestinationUri;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.651 -0400", hash_original_field = "9902E4AE0DF2B59C61F5118F9D0AAC2F", hash_generated_field = "13A8BF554467B5955E7580E17A5A2DDA")

        private List<Pair<String, String>> mRequestHeaders = new ArrayList<Pair<String, String>>();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.651 -0400", hash_original_field = "4B03BBB3AD21DBD17B2B689923FCF1F6", hash_generated_field = "ECAB18871B55104BACD4283C12B1074D")

        private CharSequence mTitle;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.651 -0400", hash_original_field = "FF2B9B684DDD70D7BE468C8D9A54343D", hash_generated_field = "18C3493923549BAE766F057DAF8B146B")

        private CharSequence mDescription;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.651 -0400", hash_original_field = "FA38F1960A45A7EC16349AAF783A80BC", hash_generated_field = "D6D2783B71AE4BF9CBF84D44336E2BF9")

        private String mMimeType;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.651 -0400", hash_original_field = "88BCF3A961C3BE410BDE5D1BF8DFDE19", hash_generated_field = "952A1377CC9FB93E78D671C8656DC930")

        private boolean mRoamingAllowed = true;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.651 -0400", hash_original_field = "5EE6AA01E98013CD1FB70EC74A5B6859", hash_generated_field = "5A39BA83CA95D987B9F58ECEB876274F")

        private int mAllowedNetworkTypes = ~0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.652 -0400", hash_original_field = "14EB015AA8D6AE536374773FE32BA9C3", hash_generated_field = "CDF7B3598ECC145AEC167A93A8BA96F5")

        private boolean mIsVisibleInDownloadsUi = true;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.652 -0400", hash_original_field = "BDEF670E22CB4C3CEDAF7D0CD809FB30", hash_generated_field = "D6ACB722C57F150FD71504D93C5E360B")

        private boolean mScannable = false;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.652 -0400", hash_original_field = "D350B669F5679FD50E4690CE8AC72A14", hash_generated_field = "3DE0461D1F897FC34AAEB85C39656726")

        private boolean mUseSystemCache = false;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.652 -0400", hash_original_field = "3AE7BFD550D220788CDE382866503478", hash_generated_field = "BC737294552DD713920EAAEBBC85199C")

        private int mNotificationVisibility = VISIBILITY_VISIBLE;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.654 -0400", hash_original_method = "38AB51743560DA4EF393F63C39D43853", hash_generated_method = "1756E5FDB8AEA1AED54E3468E89F77A7")
        public  Request(Uri uri) {
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            } 
            String scheme = uri.getScheme();
            {
                boolean var697E1C480030E2C3839AD6831BF2A446_1968051841 = (scheme == null || (!scheme.equals("http") && !scheme.equals("https")));
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Can only download HTTP/HTTPS URIs: " + uri);
                } 
            } 
            mUri = uri;
            
            
                
            
            
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.654 -0400", hash_original_method = "DEE528427F50C6163D0C2E44786A5A1B", hash_generated_method = "FDA44BFC9F8B59AE2D2550C14110C5D8")
          Request(String uriString) {
            mUri = Uri.parse(uriString);
            
            
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.655 -0400", hash_original_method = "D90BC1E489B6C6F52B7EAE5F6B3F7838", hash_generated_method = "4F4D4CBE9B753F0A04A89B50BEFF8EA2")
        public Request setDestinationUri(Uri uri) {
            Request varB4EAC82CA7396A68D541C85D26508E83_302114779 = null; 
            mDestinationUri = uri;
            varB4EAC82CA7396A68D541C85D26508E83_302114779 = this;
            varB4EAC82CA7396A68D541C85D26508E83_302114779.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_302114779;
            
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.656 -0400", hash_original_method = "D82AD486A04E11ACCF6C157FAE4ED191", hash_generated_method = "C15D5EAB5DC2B9E68F6A6D9F3FEAED2A")
        public Request setDestinationToSystemCache() {
            Request varB4EAC82CA7396A68D541C85D26508E83_233047530 = null; 
            mUseSystemCache = true;
            varB4EAC82CA7396A68D541C85D26508E83_233047530 = this;
            varB4EAC82CA7396A68D541C85D26508E83_233047530.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_233047530;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.657 -0400", hash_original_method = "D36C94DA39C2A5C5097A71BFF458D119", hash_generated_method = "0CB045E3701586D1AE178DF65B898372")
        public Request setDestinationInExternalFilesDir(Context context, String dirType,
                String subPath) {
            Request varB4EAC82CA7396A68D541C85D26508E83_1121103489 = null; 
            setDestinationFromBase(context.getExternalFilesDir(dirType), subPath);
            varB4EAC82CA7396A68D541C85D26508E83_1121103489 = this;
            addTaint(context.getTaint());
            addTaint(dirType.getTaint());
            addTaint(subPath.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1121103489.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1121103489;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.658 -0400", hash_original_method = "DE3A2CC0AFE35B8C7E88937E379D2ACE", hash_generated_method = "D8136B1094D3EDD95D92481536357049")
        public Request setDestinationInExternalPublicDir(String dirType, String subPath) {
            Request varB4EAC82CA7396A68D541C85D26508E83_1561676377 = null; 
            File file = Environment.getExternalStoragePublicDirectory(dirType);
            {
                boolean var59AA0F7651ECC78FBF1607A856F762E1_1622690416 = (file.exists());
                {
                    {
                        boolean var64D52B1E6C0DE0079880D4A605C58A0F_924776529 = (!file.isDirectory());
                        {
                            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(file.getAbsolutePath() +
                            " already exists and is not a directory");
                        } 
                    } 
                } 
                {
                    {
                        boolean var5FE45863B1A6CF5B78D16EE3A822F850_564185614 = (!file.mkdir());
                        {
                            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Unable to create directory: "+
                            file.getAbsolutePath());
                        } 
                    } 
                } 
            } 
            setDestinationFromBase(file, subPath);
            varB4EAC82CA7396A68D541C85D26508E83_1561676377 = this;
            addTaint(dirType.getTaint());
            addTaint(subPath.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1561676377.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1561676377;
            
            
            
                
                    
                            
                
            
                
                    
                            
                
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.659 -0400", hash_original_method = "53900E0DE3709F8E65CE6AB9A613EA7C", hash_generated_method = "F9CF4996862359ED2F1C058BE6117363")
        private void setDestinationFromBase(File base, String subPath) {
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException("subPath cannot be null");
            } 
            mDestinationUri = Uri.withAppendedPath(Uri.fromFile(base), subPath);
            
            
                
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.659 -0400", hash_original_method = "39458C7E93B4E0F8CC50399F7846AF71", hash_generated_method = "C96F98A19F0478D3BC60EAEC74698C65")
        public void allowScanningByMediaScanner() {
            mScannable = true;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.660 -0400", hash_original_method = "84826A0727261744241F6F54A16F49D4", hash_generated_method = "524CB34E02A873345CE248B7650FDB1E")
        public Request addRequestHeader(String header, String value) {
            Request varB4EAC82CA7396A68D541C85D26508E83_548553838 = null; 
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException("header cannot be null");
            } 
            {
                boolean varDC5B1563EB0301505BACEAFD06DE4615_237220566 = (header.contains(":"));
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("header may not contain ':'");
                } 
            } 
            {
                value = "";
            } 
            mRequestHeaders.add(Pair.create(header, value));
            varB4EAC82CA7396A68D541C85D26508E83_548553838 = this;
            addTaint(header.getTaint());
            addTaint(value.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_548553838.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_548553838;
            
            
                
            
            
                
            
            
                
            
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.662 -0400", hash_original_method = "D2617ADF02871E26D8818B6B93DA088D", hash_generated_method = "077DDAD3E173F47D63003245EC9B2D12")
        public Request setTitle(CharSequence title) {
            Request varB4EAC82CA7396A68D541C85D26508E83_2041817269 = null; 
            mTitle = title;
            varB4EAC82CA7396A68D541C85D26508E83_2041817269 = this;
            varB4EAC82CA7396A68D541C85D26508E83_2041817269.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_2041817269;
            
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.664 -0400", hash_original_method = "3BFD78827604EC47FE3892636D121D42", hash_generated_method = "4A8E9F695664C0779B03F5B6BB27E88E")
        public Request setDescription(CharSequence description) {
            Request varB4EAC82CA7396A68D541C85D26508E83_369526079 = null; 
            mDescription = description;
            varB4EAC82CA7396A68D541C85D26508E83_369526079 = this;
            varB4EAC82CA7396A68D541C85D26508E83_369526079.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_369526079;
            
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.665 -0400", hash_original_method = "EAEBE95F38EAF7D74F8EC9BD89175C39", hash_generated_method = "A8A686003095FA3B7EA76F4EA881088F")
        public Request setMimeType(String mimeType) {
            Request varB4EAC82CA7396A68D541C85D26508E83_1466767399 = null; 
            mMimeType = mimeType;
            varB4EAC82CA7396A68D541C85D26508E83_1466767399 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1466767399.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1466767399;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.666 -0400", hash_original_method = "F75AFBEFCFC8BE21F83F018EA7CEB6E1", hash_generated_method = "4509B16055D807043C799BAD48399B55")
        @Deprecated
        public Request setShowRunningNotification(boolean show) {
            Request varB4EAC82CA7396A68D541C85D26508E83_1097861236 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1097861236 = (show) ? setNotificationVisibility(VISIBILITY_VISIBLE) :
                    setNotificationVisibility(VISIBILITY_HIDDEN);
            addTaint(show);
            varB4EAC82CA7396A68D541C85D26508E83_1097861236.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1097861236;
            
            
                    
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.667 -0400", hash_original_method = "0E1BEC1EE7CB7BCA18E6C69650765291", hash_generated_method = "1163C85CEF9D320FBF873CCEEFD84563")
        public Request setNotificationVisibility(int visibility) {
            Request varB4EAC82CA7396A68D541C85D26508E83_379328451 = null; 
            mNotificationVisibility = visibility;
            varB4EAC82CA7396A68D541C85D26508E83_379328451 = this;
            varB4EAC82CA7396A68D541C85D26508E83_379328451.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_379328451;
            
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.668 -0400", hash_original_method = "1FB95247AA3BF4BC290C0031C887893C", hash_generated_method = "D52436DE776034E0F138B45C45742230")
        public Request setAllowedNetworkTypes(int flags) {
            Request varB4EAC82CA7396A68D541C85D26508E83_579842364 = null; 
            mAllowedNetworkTypes = flags;
            varB4EAC82CA7396A68D541C85D26508E83_579842364 = this;
            varB4EAC82CA7396A68D541C85D26508E83_579842364.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_579842364;
            
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.669 -0400", hash_original_method = "EED7837CFCCAA493B8F853E6287613BD", hash_generated_method = "6EEE32AD5EC1C5A0E397A96A212D5C94")
        public Request setAllowedOverRoaming(boolean allowed) {
            Request varB4EAC82CA7396A68D541C85D26508E83_1469539557 = null; 
            mRoamingAllowed = allowed;
            varB4EAC82CA7396A68D541C85D26508E83_1469539557 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1469539557.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1469539557;
            
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.671 -0400", hash_original_method = "865D9FB8BB624139754E18F2F470A937", hash_generated_method = "E3023186A722C6AC67F6EB94776DCA25")
        public Request setVisibleInDownloadsUi(boolean isVisible) {
            Request varB4EAC82CA7396A68D541C85D26508E83_1865109093 = null; 
            mIsVisibleInDownloadsUi = isVisible;
            varB4EAC82CA7396A68D541C85D26508E83_1865109093 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1865109093.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1865109093;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.673 -0400", hash_original_method = "A794ABF9FD18E330B670B5AD24CF2800", hash_generated_method = "BD3E1ADBD28457569391B56510C23EB2")
         ContentValues toContentValues(String packageName) {
            ContentValues varB4EAC82CA7396A68D541C85D26508E83_1221342763 = null; 
            ContentValues values = new ContentValues();
            values.put(Downloads.Impl.COLUMN_URI, mUri.toString());
            values.put(Downloads.Impl.COLUMN_IS_PUBLIC_API, true);
            values.put(Downloads.Impl.COLUMN_NOTIFICATION_PACKAGE, packageName);
            {
                values.put(Downloads.Impl.COLUMN_DESTINATION, Downloads.Impl.DESTINATION_FILE_URI);
                values.put(Downloads.Impl.COLUMN_FILE_NAME_HINT, mDestinationUri.toString());
            } 
            {
                values.put(Downloads.Impl.COLUMN_DESTINATION,
                           (this.mUseSystemCache) ?
                                   Downloads.Impl.DESTINATION_SYSTEMCACHE_PARTITION :
                                   Downloads.Impl.DESTINATION_CACHE_PARTITION_PURGEABLE);
            } 
            values.put(Downloads.Impl.COLUMN_MEDIA_SCANNED, (mScannable) ? SCANNABLE_VALUE_YES :
                    SCANNABLE_VALUE_NO);
            {
                boolean varE410073C37185297D362C1E68809DB54_782034857 = (!mRequestHeaders.isEmpty());
                {
                    encodeHttpHeaders(values);
                } 
            } 
            putIfNonNull(values, Downloads.Impl.COLUMN_TITLE, mTitle);
            putIfNonNull(values, Downloads.Impl.COLUMN_DESCRIPTION, mDescription);
            putIfNonNull(values, Downloads.Impl.COLUMN_MIME_TYPE, mMimeType);
            values.put(Downloads.Impl.COLUMN_VISIBILITY, mNotificationVisibility);
            values.put(Downloads.Impl.COLUMN_ALLOWED_NETWORK_TYPES, mAllowedNetworkTypes);
            values.put(Downloads.Impl.COLUMN_ALLOW_ROAMING, mRoamingAllowed);
            values.put(Downloads.Impl.COLUMN_IS_VISIBLE_IN_DOWNLOADS_UI, mIsVisibleInDownloadsUi);
            varB4EAC82CA7396A68D541C85D26508E83_1221342763 = values;
            addTaint(packageName.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1221342763.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1221342763;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.687 -0400", hash_original_method = "26D27F1BE5E3A68003877A062F0DAD99", hash_generated_method = "0736ECEEDF39D92C8F1B64C381DE1421")
        private void encodeHttpHeaders(ContentValues values) {
            int index = 0;
            {
                Iterator<Pair<String, String>> var6EC36093AF9DC0A9505C9A55F0DE4444_393383088 = (mRequestHeaders).iterator();
                var6EC36093AF9DC0A9505C9A55F0DE4444_393383088.hasNext();
                Pair<String, String> header = var6EC36093AF9DC0A9505C9A55F0DE4444_393383088.next();
                {
                    String headerString = header.first + ": " + header.second;
                    values.put(Downloads.Impl.RequestHeaders.INSERT_KEY_PREFIX + index, headerString);
                } 
            } 
            addTaint(values.getTaint());
            
            
            
                
                
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.691 -0400", hash_original_method = "19BA5B9D42AC58D8841CDF02C796EE38", hash_generated_method = "E11F9E185847FF673D7FBCD1C9033B18")
        private void putIfNonNull(ContentValues contentValues, String key, Object value) {
            {
                contentValues.put(key, value.toString());
            } 
            addTaint(contentValues.getTaint());
            addTaint(key.getTaint());
            addTaint(value.getTaint());
            
            
                
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.691 -0400", hash_original_field = "2DECCABC6A842947B60E39EA0FC15085", hash_generated_field = "2A08EDDDB593C12F8423C559DB638960")

        public static final int NETWORK_MOBILE = 1 << 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.692 -0400", hash_original_field = "C54F5B644D418630CECD1427EC0D4736", hash_generated_field = "A0D2C438A9D332F064354E5B5CD56CD8")

        public static final int NETWORK_WIFI = 1 << 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.692 -0400", hash_original_field = "9A22B40090C002AE86B482C4964ECE31", hash_generated_field = "6644414BD8BF5CC6D8AD8B436963ECCC")

        private static final int SCANNABLE_VALUE_YES = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.692 -0400", hash_original_field = "D84387C59443EF1276F988651568F162", hash_generated_field = "F899C70B939A165A118DBF442F8E45A8")

        private static final int SCANNABLE_VALUE_NO = 2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.692 -0400", hash_original_field = "EE7FE8DE87F42C3C75936AB3D965CBF9", hash_generated_field = "678667850A54425C02D37FACB767853B")

        public static final int VISIBILITY_VISIBLE = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.692 -0400", hash_original_field = "0B822A7032D74847E7AA17804167F0FE", hash_generated_field = "F285E9AEAAA3AB3B3BF3A904EF1F15E0")

        public static final int VISIBILITY_VISIBLE_NOTIFY_COMPLETED = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.692 -0400", hash_original_field = "3A9106B0FA476D6F55EC1E276A420B9C", hash_generated_field = "7C647F96488D335DF451E9699546D435")

        public static final int VISIBILITY_HIDDEN = 2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.692 -0400", hash_original_field = "D4129AD1EEC3964E36935A2F614BC446", hash_generated_field = "F99A308F434AB6F300224D2C143BC731")

        public static final int VISIBILITY_VISIBLE_NOTIFY_ONLY_COMPLETION = 3;
    }


    
    public static class Query {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.692 -0400", hash_original_field = "4F579D3D7BCB1271CC18AC1E755540D2", hash_generated_field = "5F8E81DCB2F7B395E24A391C0FACBDE6")

        private long[] mIds = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.692 -0400", hash_original_field = "AE5DCEBD02CF265CFB94CBED107BC43B", hash_generated_field = "F78B9285416B8C880978036645800403")

        private Integer mStatusFlags = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.692 -0400", hash_original_field = "7D3F9ACFBFDEDC26C8A47E8138C1E1A8", hash_generated_field = "39E6027705921A51748F7FC07E010111")

        private String mOrderByColumn = Downloads.Impl.COLUMN_LAST_MODIFICATION;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.692 -0400", hash_original_field = "707ADE263B8DE3CF22961F4796A34FED", hash_generated_field = "EED59D0671C844A1902BF26138BB3F37")

        private int mOrderDirection = ORDER_DESCENDING;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.692 -0400", hash_original_field = "BB54684F97A66C91A29A969F6C84B13D", hash_generated_field = "964B69564A78D777DDBF359D9B2AA67B")

        private boolean mOnlyIncludeVisibleInDownloadsUi = false;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.693 -0400", hash_original_method = "EFCA8790A91D69466A874AF6524F8E69", hash_generated_method = "EFCA8790A91D69466A874AF6524F8E69")
        public Query ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.693 -0400", hash_original_method = "782D3BAE9A57AE7F89D5C5E0BBC212BD", hash_generated_method = "D84B6A78487F3B30B474ED28120BF236")
        public Query setFilterById(long... ids) {
            Query varB4EAC82CA7396A68D541C85D26508E83_1481531224 = null; 
            mIds = ids;
            varB4EAC82CA7396A68D541C85D26508E83_1481531224 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1481531224.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1481531224;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.694 -0400", hash_original_method = "CE9295EE41F323C50B34B72F478BD4C2", hash_generated_method = "E29ADD79382A4A466F943B3628726BE3")
        public Query setFilterByStatus(int flags) {
            Query varB4EAC82CA7396A68D541C85D26508E83_1428030340 = null; 
            mStatusFlags = flags;
            varB4EAC82CA7396A68D541C85D26508E83_1428030340 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1428030340.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1428030340;
            
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.695 -0400", hash_original_method = "9600119EF208E670C5EE47F5F776ED3A", hash_generated_method = "822C10171C17BBF9FE27C48E41235293")
        public Query setOnlyIncludeVisibleInDownloadsUi(boolean value) {
            Query varB4EAC82CA7396A68D541C85D26508E83_1247038235 = null; 
            mOnlyIncludeVisibleInDownloadsUi = value;
            varB4EAC82CA7396A68D541C85D26508E83_1247038235 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1247038235.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1247038235;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.696 -0400", hash_original_method = "969F069748FB75BDEDE2897D8F038415", hash_generated_method = "8625F1FDA0B8EC1762D4BF93BDBC1699")
        public Query orderBy(String column, int direction) {
            Query varB4EAC82CA7396A68D541C85D26508E83_897298747 = null; 
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Invalid direction: " + direction);
            } 
            {
                boolean varB0B34C57CB5381E2A5D80B1DAEBC2C51_1707777072 = (column.equals(COLUMN_LAST_MODIFIED_TIMESTAMP));
                {
                    mOrderByColumn = Downloads.Impl.COLUMN_LAST_MODIFICATION;
                } 
                {
                    boolean varEBF14B99C957D46FCEDCE1161497CE7F_852780077 = (column.equals(COLUMN_TOTAL_SIZE_BYTES));
                    {
                        mOrderByColumn = Downloads.Impl.COLUMN_TOTAL_BYTES;
                    } 
                    {
                        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Cannot order by " + column);
                    } 
                } 
            } 
            mOrderDirection = direction;
            varB4EAC82CA7396A68D541C85D26508E83_897298747 = this;
            addTaint(column.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_897298747.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_897298747;
            
            
                
            
            
                
            
                
            
                
            
            
            
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.699 -0400", hash_original_method = "3E117BB34A8C7FFA67D17AB4CC250832", hash_generated_method = "1B288235ABEFCA780C05F0AE60BEFB7A")
         Cursor runQuery(ContentResolver resolver, String[] projection, Uri baseUri) {
            Cursor varB4EAC82CA7396A68D541C85D26508E83_1545597950 = null; 
            Uri uri = baseUri;
            List<String> selectionParts = new ArrayList<String>();
            String[] selectionArgs = null;
            {
                selectionParts.add(getWhereClauseForIds(mIds));
                selectionArgs = getWhereArgsForIds(mIds);
            } 
            {
                List<String> parts = new ArrayList<String>();
                {
                    parts.add(statusClause("=", Downloads.Impl.STATUS_PENDING));
                } 
                {
                    parts.add(statusClause("=", Downloads.Impl.STATUS_RUNNING));
                } 
                {
                    parts.add(statusClause("=", Downloads.Impl.STATUS_PAUSED_BY_APP));
                    parts.add(statusClause("=", Downloads.Impl.STATUS_WAITING_TO_RETRY));
                    parts.add(statusClause("=", Downloads.Impl.STATUS_WAITING_FOR_NETWORK));
                    parts.add(statusClause("=", Downloads.Impl.STATUS_QUEUED_FOR_WIFI));
                } 
                {
                    parts.add(statusClause("=", Downloads.Impl.STATUS_SUCCESS));
                } 
                {
                    parts.add("(" + statusClause(">=", 400)
                              + " AND " + statusClause("<", 600) + ")");
                } 
                selectionParts.add(joinStrings(" OR ", parts));
            } 
            {
                selectionParts.add(Downloads.Impl.COLUMN_IS_VISIBLE_IN_DOWNLOADS_UI + " != '0'");
            } 
            selectionParts.add(Downloads.Impl.COLUMN_DELETED + " != '1'");
            String selection = joinStrings(" AND ", selectionParts);
            String orderDirection = (mOrderDirection == ORDER_ASCENDING ? "ASC" : "DESC");
            String orderBy = mOrderByColumn + " " + orderDirection;
            varB4EAC82CA7396A68D541C85D26508E83_1545597950 = resolver.query(uri, projection, selection, selectionArgs, orderBy);
            addTaint(resolver.getTaint());
            addTaint(projection[0].getTaint());
            addTaint(baseUri.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1545597950.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1545597950;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.709 -0400", hash_original_method = "E982889F0CE13C731CA9D89AB5FD3B78", hash_generated_method = "3AC315E0DA21198396505E169AA78E55")
        private String joinStrings(String joiner, Iterable<String> parts) {
            String varB4EAC82CA7396A68D541C85D26508E83_857987042 = null; 
            StringBuilder builder = new StringBuilder();
            boolean first = true;
            {
                Iterator<String> var4E9C8AFBA69334251664FB12D52EFE6A_141868178 = (parts).iterator();
                var4E9C8AFBA69334251664FB12D52EFE6A_141868178.hasNext();
                String part = var4E9C8AFBA69334251664FB12D52EFE6A_141868178.next();
                {
                    {
                        builder.append(joiner);
                    } 
                    builder.append(part);
                    first = false;
                } 
            } 
            varB4EAC82CA7396A68D541C85D26508E83_857987042 = builder.toString();
            addTaint(joiner.getTaint());
            addTaint(parts.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_857987042.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_857987042;
            
            
            
            
                
                    
                
                
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.710 -0400", hash_original_method = "F1C2C126003D565FB51A9C1A25E86357", hash_generated_method = "09DC80888485082C044A601F2BED9817")
        private String statusClause(String operator, int value) {
            String varB4EAC82CA7396A68D541C85D26508E83_1626558160 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1626558160 = Downloads.Impl.COLUMN_STATUS + operator + "'" + value + "'";
            addTaint(operator.getTaint());
            addTaint(value);
            varB4EAC82CA7396A68D541C85D26508E83_1626558160.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1626558160;
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.710 -0400", hash_original_field = "4FDB899E3766A064074C9081C7B6A267", hash_generated_field = "33AF9DE750C57D52372B21F0E7746D47")

        public static final int ORDER_ASCENDING = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.711 -0400", hash_original_field = "2E1B9074F3BE6834ABC0129E780F4F46", hash_generated_field = "2CF799A3EEA7BC4C831B8EB82D2B58DE")

        public static final int ORDER_DESCENDING = 2;
    }


    
    private static class CursorTranslator extends CursorWrapper {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.711 -0400", hash_original_field = "718CF095732EDC4F563D086AE0B1FE46", hash_generated_field = "352FDC66A51EED366C84411537612673")

        private Uri mBaseUri;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.714 -0400", hash_original_method = "DA2C30EB999FAADAF9AB1439D3B9F223", hash_generated_method = "6B0EF03C13B7FAD8859BBDC072D4B1C9")
        public  CursorTranslator(Cursor cursor, Uri baseUri) {
            super(cursor);
            mBaseUri = baseUri;
            addTaint(cursor.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.715 -0400", hash_original_method = "34538125BB8387937A75DA11F9FB5B65", hash_generated_method = "D4A53E049EA068E076106E1DEB8E7381")
        @Override
        public int getInt(int columnIndex) {
            int var3CD82268530977C7C6744F3E8BBDD7D6_1348890412 = ((int) getLong(columnIndex));
            addTaint(columnIndex);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_407450149 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_407450149;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.716 -0400", hash_original_method = "744FA54C78DD5C7B6737C741AD0EB8F1", hash_generated_method = "576D84F315E93536959D8F49E24461A5")
        @Override
        public long getLong(int columnIndex) {
            {
                boolean var64C1AD00092BC2F5CCD236C968ADB1F7_1548735682 = (getColumnName(columnIndex).equals(COLUMN_REASON));
                {
                    long varEA20B4C0EF19C4D7CCB17B21400F6CFF_1717116371 = (getReason(super.getInt(getColumnIndex(Downloads.Impl.COLUMN_STATUS))));
                } 
                {
                    boolean var354558F166115927AECC93EF734F99AA_1063631218 = (getColumnName(columnIndex).equals(COLUMN_STATUS));
                    {
                        long var7FCD1CEC76DC9A06E3A454B471B4004B_1641015251 = (translateStatus(super.getInt(getColumnIndex(Downloads.Impl.COLUMN_STATUS))));
                    } 
                    {
                        long varC0843ACC657E8C550727A370AD3FD7B2_21616876 = (super.getLong(columnIndex));
                    } 
                } 
            } 
            addTaint(columnIndex);
            long var0F5264038205EDFB1AC05FBB0E8C5E94_1408561159 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1408561159;
            
            
                
            
                
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.717 -0400", hash_original_method = "2A6CC35BB4DF843267A861B5828C6994", hash_generated_method = "F75B691309A9F3D07C8F2F43B33D7872")
        @Override
        public String getString(int columnIndex) {
            String varB4EAC82CA7396A68D541C85D26508E83_94441693 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_94441693 = (getColumnName(columnIndex).equals(COLUMN_LOCAL_URI)) ? getLocalUri() :
                    super.getString(columnIndex);
            addTaint(columnIndex);
            varB4EAC82CA7396A68D541C85D26508E83_94441693.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_94441693;
            
            
                    
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.719 -0400", hash_original_method = "C2F388AD18BA84031DEC0607FBEAB7C5", hash_generated_method = "B741195D5FD996B62ABE4FAD8A294C83")
        private String getLocalUri() {
            String varB4EAC82CA7396A68D541C85D26508E83_57600026 = null; 
            String varB4EAC82CA7396A68D541C85D26508E83_735586940 = null; 
            String varB4EAC82CA7396A68D541C85D26508E83_1675348183 = null; 
            long destinationType = getLong(getColumnIndex(Downloads.Impl.COLUMN_DESTINATION));
            {
                String localPath = getString(getColumnIndex(COLUMN_LOCAL_FILENAME));
                {
                    varB4EAC82CA7396A68D541C85D26508E83_57600026 = null;
                } 
                varB4EAC82CA7396A68D541C85D26508E83_735586940 = Uri.fromFile(new File(localPath)).toString();
            } 
            long downloadId = getLong(getColumnIndex(Downloads.Impl._ID));
            varB4EAC82CA7396A68D541C85D26508E83_1675348183 = ContentUris.withAppendedId(mBaseUri, downloadId).toString();
            String varA7E53CE21691AB073D9660D615818899_983052853; 
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: 
                    varA7E53CE21691AB073D9660D615818899_983052853 = varB4EAC82CA7396A68D541C85D26508E83_57600026;
                    break;
                case 2: 
                    varA7E53CE21691AB073D9660D615818899_983052853 = varB4EAC82CA7396A68D541C85D26508E83_735586940;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_983052853 = varB4EAC82CA7396A68D541C85D26508E83_1675348183;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_983052853.addTaint(getTaint()); 
            return varA7E53CE21691AB073D9660D615818899_983052853;
            
            
            
                    
                    
                
                
                    
                
                
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.721 -0400", hash_original_method = "A69C93787DF2FD0B667931CA82E74881", hash_generated_method = "5788D950FD5FDC957C63C7CD9CD94827")
        private long getReason(int status) {
            {
                Object varBFF60C51F3561C06BE2F47ADE835EC83_551863161 = (translateStatus(status));
                
                long varA00E54BE3716406F658C01669FEA3255_775890604 = (getErrorCode(status));
                
                
                long var0684DD53D22A9802EEC682794798C46B_856333456 = (getPausedReason(status));
                
            } 
            addTaint(status);
            long var0F5264038205EDFB1AC05FBB0E8C5E94_1687578273 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1687578273;
            
            
                
                    
                
                    
                
                    
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.724 -0400", hash_original_method = "8BF9F68328111BA50CCB78B1792F76F0", hash_generated_method = "B614B12B7CEE9238046F645BCE14F1AB")
        private long getPausedReason(int status) {
            addTaint(status);
            long var0F5264038205EDFB1AC05FBB0E8C5E94_1132410273 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1132410273;
            
            
                
                    
                
                    
                
                    
                
                    
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.725 -0400", hash_original_method = "A27080D0C32BDBDFED7217EFE39DC72F", hash_generated_method = "183C5B9367D957D1DE8BB507628098DD")
        private long getErrorCode(int status) {
            addTaint(status);
            long var0F5264038205EDFB1AC05FBB0E8C5E94_1907067486 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1907067486;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.726 -0400", hash_original_method = "AC0B465D7BF7B10F5608906AFAA7CE72", hash_generated_method = "76E9F7E6E51D9CEE51F4AA35B316E633")
        private int translateStatus(int status) {
            addTaint(status);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1300363884 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1300363884;
            
            
                
                    
                
                    
                
                
                
                
                    
                
                    
                
                    
                    
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.726 -0400", hash_original_field = "28E13913130DC317027A75F9CAADB6E6", hash_generated_field = "A7E023A8D48EDA84D30E823FC247AC7D")

    public final static String COLUMN_ID = Downloads.Impl._ID;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.727 -0400", hash_original_field = "4F18DB729598483955C67DF843942E9B", hash_generated_field = "E0475ED0F443C2F35BA6DAC29B806E15")

    public final static String COLUMN_TITLE = Downloads.Impl.COLUMN_TITLE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.727 -0400", hash_original_field = "C7A6174B374253166E3D4F540CB3899A", hash_generated_field = "2ADDAD1D6BE2368DD43079C018505DC2")

    public final static String COLUMN_DESCRIPTION = Downloads.Impl.COLUMN_DESCRIPTION;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.727 -0400", hash_original_field = "8AAE7CAB40335C45902B3C3A4B4359D4", hash_generated_field = "143198F8ECD99C932C3BA352BDD7B4F6")

    public final static String COLUMN_URI = Downloads.Impl.COLUMN_URI;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.727 -0400", hash_original_field = "769FA87A9CCB7D4CA16571486316ACCC", hash_generated_field = "9BF784ED01C8E5392F5BB2D34F27F68B")

    public final static String COLUMN_MEDIA_TYPE = "media_type";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.727 -0400", hash_original_field = "26A36CC9B29C427A7705DA55CD804EB2", hash_generated_field = "84BD203A764C2D32D032768E5BA85C6A")

    public final static String COLUMN_TOTAL_SIZE_BYTES = "total_size";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.727 -0400", hash_original_field = "E36D1141E52AA346782AC8609221301B", hash_generated_field = "87092124AEB640ED262648BE065600C9")

    public final static String COLUMN_LOCAL_URI = "local_uri";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.727 -0400", hash_original_field = "E6F63FD9C72D36809812647B3A97AAC7", hash_generated_field = "38930F295047A3F6AE0AC7B02C24770A")

    public final static String COLUMN_LOCAL_FILENAME = "local_filename";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.727 -0400", hash_original_field = "D0941CF2EAA2934186552963A9F2F3C1", hash_generated_field = "AD200817B86CDDB6809552A585F6F3CB")

    public final static String COLUMN_STATUS = Downloads.Impl.COLUMN_STATUS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.727 -0400", hash_original_field = "B392173D4EE64EB34E055EAA4249CA25", hash_generated_field = "D7D42B4B48EDF0D303BF107E8C2B9639")

    public final static String COLUMN_REASON = "reason";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.727 -0400", hash_original_field = "D4687D5D1BC923240E08E965E50C32D3", hash_generated_field = "E75A5474EBC7BBC6DB9427B4EA03D662")

    public final static String COLUMN_BYTES_DOWNLOADED_SO_FAR = "bytes_so_far";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.727 -0400", hash_original_field = "CF721E7C812971EC93264A0FEA00EFD1", hash_generated_field = "70EB989845348DC7DAA5AF45C362A8C0")

    public final static String COLUMN_LAST_MODIFIED_TIMESTAMP = "last_modified_timestamp";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.728 -0400", hash_original_field = "B8D99CC2D9EE6FDC3C5B92F362B619D5", hash_generated_field = "E798B6BCD082848B6F5403070514339F")

    public static final String COLUMN_MEDIAPROVIDER_URI = Downloads.Impl.COLUMN_MEDIAPROVIDER_URI;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.728 -0400", hash_original_field = "D9920B04BB8875828838F10EF6BCAC8A", hash_generated_field = "5A6A6A376CA33569B014DF98BB4486F5")

    public final static int STATUS_PENDING = 1 << 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.728 -0400", hash_original_field = "787F81C54F7669D7B5DFC4C4E59E3970", hash_generated_field = "DDF3A08F677DC31638E00F51A652178C")

    public final static int STATUS_RUNNING = 1 << 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.728 -0400", hash_original_field = "CD3563EE6AD32EC86F2B215DEE0E86AA", hash_generated_field = "B6CF42D4BE6CC4E35C56FF7AFD758358")

    public final static int STATUS_PAUSED = 1 << 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.728 -0400", hash_original_field = "F5C8808AF0D080F35FEB54862F0B5E83", hash_generated_field = "16CE303BA58E19D2E9F3935ACB3CE0FB")

    public final static int STATUS_SUCCESSFUL = 1 << 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.728 -0400", hash_original_field = "F2A4B8336D15E7C1C353A849AA6B8458", hash_generated_field = "1BCCE4C740453C51D27A9C44E3F68B40")

    public final static int STATUS_FAILED = 1 << 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.728 -0400", hash_original_field = "B1B8CF8DDF7369BDFB1FDEFD0E148A26", hash_generated_field = "49F5D6EC283C95877C76975EF6E926C6")

    public final static int ERROR_UNKNOWN = 1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.728 -0400", hash_original_field = "87C83208A97BE663E34D9647DF2EF7E6", hash_generated_field = "0E73FEF6AA8AAE6DB010C8400B9928BE")

    public final static int ERROR_FILE_ERROR = 1001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.728 -0400", hash_original_field = "CFCFE2CD6A0A8BD4DF43CEFE343700A7", hash_generated_field = "1AC4CB82DAEB32AFCC84E359B353A84E")

    public final static int ERROR_UNHANDLED_HTTP_CODE = 1002;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.728 -0400", hash_original_field = "6E78B11D35FB475E28CA97D4E6C547B1", hash_generated_field = "7D7BB2F4DF6F4E9B6967224CE2FAF5E8")

    public final static int ERROR_HTTP_DATA_ERROR = 1004;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.728 -0400", hash_original_field = "E97C109F2226A38F6B0A0CBFBF78E56E", hash_generated_field = "7D1894872E657F2F1D75836AC335D1AF")

    public final static int ERROR_TOO_MANY_REDIRECTS = 1005;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.728 -0400", hash_original_field = "5B6B1D13BAF3583DB3FC3880D5CF5310", hash_generated_field = "4745C1817D6FFD01542FD1D7B9BCDF6B")

    public final static int ERROR_INSUFFICIENT_SPACE = 1006;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.728 -0400", hash_original_field = "42B9606B5DE02CD5B870EC439CBC4799", hash_generated_field = "D22E5678B4FACB05F514DC5331AD6F98")

    public final static int ERROR_DEVICE_NOT_FOUND = 1007;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.728 -0400", hash_original_field = "D9CB71BDB7ED1A07CEDC0B5C7ACF2016", hash_generated_field = "310C5FB2CCFCEBB3F61B6B0F16B85CE9")

    public final static int ERROR_CANNOT_RESUME = 1008;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.729 -0400", hash_original_field = "4DADA07169D41492B63745757EBB9BAE", hash_generated_field = "03022A2BA7BEFEFA9680B89BFC241220")

    public final static int ERROR_FILE_ALREADY_EXISTS = 1009;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.729 -0400", hash_original_field = "742BD13A8B7D1BAC4F048EE8E11696BA", hash_generated_field = "95F9CC4D3D18A2E56CF90C0970647D3D")

    public final static int ERROR_BLOCKED = 1010;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.729 -0400", hash_original_field = "53DCCFB529054899419C09B1FC8D527A", hash_generated_field = "375A127B5A11AB6F86CDA6C2E7687C81")

    public final static int PAUSED_WAITING_TO_RETRY = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.729 -0400", hash_original_field = "CF8B92A918BA25E72267510856BBDF24", hash_generated_field = "1AB4E417B461169A72753CA5536FB9C8")

    public final static int PAUSED_WAITING_FOR_NETWORK = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.729 -0400", hash_original_field = "D315A0B4812ACA7922F6DE58705DC22F", hash_generated_field = "4C94328F0C2918D47EFCEA3271E499DF")

    public final static int PAUSED_QUEUED_FOR_WIFI = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.729 -0400", hash_original_field = "D77A325B9B8C28B05140B5D47218D329", hash_generated_field = "4D9D144F191E78908A11C759352904B6")

    public final static int PAUSED_UNKNOWN = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.729 -0400", hash_original_field = "278C5BA979AEAF9E5167F1A8C082AE5B", hash_generated_field = "F59DDF2C5961F68B20C867F8313BBEFB")

    public final static String ACTION_DOWNLOAD_COMPLETE = "android.intent.action.DOWNLOAD_COMPLETE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.729 -0400", hash_original_field = "7749EC94D727FDDDEFDAB2D0EAE57B72", hash_generated_field = "C99B78141EF70699F8A2ED7E9CB8DD42")

    public final static String ACTION_NOTIFICATION_CLICKED =
            "android.intent.action.DOWNLOAD_NOTIFICATION_CLICKED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.729 -0400", hash_original_field = "036041F33A2303C21F448683E744290A", hash_generated_field = "DE2A2BF8E91A6F3A9065C043915477FB")

    public final static String ACTION_VIEW_DOWNLOADS = "android.intent.action.VIEW_DOWNLOADS";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.729 -0400", hash_original_field = "A5BDC999C90856BFDD040E48EF31A616", hash_generated_field = "3301DDAE8E2BAA3A9528297879FE4303")

    public final static String INTENT_EXTRAS_SORT_BY_SIZE =
            "android.app.DownloadManager.extra_sortBySize";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.729 -0400", hash_original_field = "5220593F731D0C32288FAAE6C6B442FF", hash_generated_field = "937B93366C4C3FE30B8BE2FA09D9B445")

    public static final String EXTRA_DOWNLOAD_ID = "extra_download_id";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.729 -0400", hash_original_field = "7F8AD7318CBA22EA99DF8C7689BD846C", hash_generated_field = "4DF09F4FBB097DF9B81CC166A5136DAA")

    public static final String EXTRA_NOTIFICATION_CLICK_DOWNLOAD_IDS = "extra_click_download_ids";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.729 -0400", hash_original_field = "D950C56A7A90C4B58D865C265F965355", hash_generated_field = "35D0E0EA646E6DE036699985804C1F7A")

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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.730 -0400", hash_original_field = "CB6BAA7FD313D1CA2A881424B9358C2E", hash_generated_field = "7F3BE0CBA2F29054F2C27E2E352EC965")

    private static final String NON_DOWNLOADMANAGER_DOWNLOAD = "non-dwnldmngr-download-dont-retry2download";
}

