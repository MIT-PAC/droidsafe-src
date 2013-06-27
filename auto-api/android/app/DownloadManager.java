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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.714 -0400", hash_original_field = "CF849E3C15214EFD093D4303B542BF44", hash_generated_field = "2ABF989C5B8F051BCBEE638ED1EA2586")

    private ContentResolver mResolver;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.714 -0400", hash_original_field = "BE0173788749EF3CF5679DF9E1224605", hash_generated_field = "6F81845A3A2771C3EC987E5A01DBA4C6")

    private String mPackageName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.715 -0400", hash_original_field = "55833456165B236ED25F84EACF5CF2CA", hash_generated_field = "1AFB71B4D196CA91BC22831E08A191CF")

    private Uri mBaseUri = Downloads.Impl.CONTENT_URI;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.727 -0400", hash_original_method = "E62D0E970789924902081BF03F031FF8", hash_generated_method = "7F4F9C5FA27047A7434D2EC70ADE844E")
    public  DownloadManager(ContentResolver resolver, String packageName) {
        mResolver = resolver;
        mPackageName = packageName;
        // ---------- Original Method ----------
        //mResolver = resolver;
        //mPackageName = packageName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.729 -0400", hash_original_method = "93AAF1C0A18C9EFC24526B178CE628E3", hash_generated_method = "4B3277B5958759FC38CEC345308879B2")
    public void setAccessAllDownloads(boolean accessAllDownloads) {
        {
            mBaseUri = Downloads.Impl.ALL_DOWNLOADS_CONTENT_URI;
        } //End block
        {
            mBaseUri = Downloads.Impl.CONTENT_URI;
        } //End block
        addTaint(accessAllDownloads);
        // ---------- Original Method ----------
        //if (accessAllDownloads) {
            //mBaseUri = Downloads.Impl.ALL_DOWNLOADS_CONTENT_URI;
        //} else {
            //mBaseUri = Downloads.Impl.CONTENT_URI;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.742 -0400", hash_original_method = "A2E8022D1487E0DC7C6CC7B8DABAC46D", hash_generated_method = "94891EF9E56BDCDDA31A22E8DC81AC44")
    public long enqueue(Request request) {
        ContentValues values;
        values = request.toContentValues(mPackageName);
        Uri downloadUri;
        downloadUri = mResolver.insert(Downloads.Impl.CONTENT_URI, values);
        long id;
        id = Long.parseLong(downloadUri.getLastPathSegment());
        addTaint(request.getTaint());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1459409787 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1459409787;
        // ---------- Original Method ----------
        //ContentValues values = request.toContentValues(mPackageName);
        //Uri downloadUri = mResolver.insert(Downloads.Impl.CONTENT_URI, values);
        //long id = Long.parseLong(downloadUri.getLastPathSegment());
        //return id;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.760 -0400", hash_original_method = "6A912115CBBE4D263FCD27B2696D5371", hash_generated_method = "B08D99F537FF63F92CDE7EDCE22559E3")
    public int markRowDeleted(long... ids) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("input param 'ids' can't be null");
        } //End block
        ContentValues values;
        values = new ContentValues();
        values.put(Downloads.Impl.COLUMN_DELETED, 1);
        {
            int var393CDEAF16A98CB7AA432C3584D5C8FE_1603490276 = (mResolver.update(ContentUris.withAppendedId(mBaseUri, ids[0]), values,
                    null, null));
        } //End block
        int varA0E20C895CB99149E1A0E29E0C592FBD_761271987 = (mResolver.update(mBaseUri, values, getWhereClauseForIds(ids),
                getWhereArgsForIds(ids)));
        addTaint(ids[0]);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1253544072 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1253544072;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.765 -0400", hash_original_method = "E87735CFC3568A22F95F85C3BABBD5E2", hash_generated_method = "B639CE2AA2B8C108AF0435AD88A88B41")
    public int remove(long... ids) {
        int var0D18E7E451A7FE8C6FC024A1060C0496_1381572899 = (markRowDeleted(ids));
        addTaint(ids[0]);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1992418657 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1992418657;
        // ---------- Original Method ----------
        //return markRowDeleted(ids);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.787 -0400", hash_original_method = "AA3C14DF1A360F6707C442D7B10D5AD3", hash_generated_method = "5FF191696EF06E30ED48D985E282B549")
    public Cursor query(Query query) {
        Cursor varB4EAC82CA7396A68D541C85D26508E83_1270722989 = null; //Variable for return #1
        Cursor varB4EAC82CA7396A68D541C85D26508E83_1425488077 = null; //Variable for return #2
        Cursor underlyingCursor;
        underlyingCursor = query.runQuery(mResolver, UNDERLYING_COLUMNS, mBaseUri);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1270722989 = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1425488077 = new CursorTranslator(underlyingCursor, mBaseUri);
        addTaint(query.getTaint());
        Cursor varA7E53CE21691AB073D9660D615818899_414340242; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_414340242 = varB4EAC82CA7396A68D541C85D26508E83_1270722989;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_414340242 = varB4EAC82CA7396A68D541C85D26508E83_1425488077;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_414340242.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_414340242;
        // ---------- Original Method ----------
        //Cursor underlyingCursor = query.runQuery(mResolver, UNDERLYING_COLUMNS, mBaseUri);
        //if (underlyingCursor == null) {
            //return null;
        //}
        //return new CursorTranslator(underlyingCursor, mBaseUri);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.811 -0400", hash_original_method = "41561235219E48E784E85B3D8CB5CB93", hash_generated_method = "90A5BA1AFFFC22E2EAFD91B4D65B7D4F")
    public ParcelFileDescriptor openDownloadedFile(long id) throws FileNotFoundException {
        ParcelFileDescriptor varB4EAC82CA7396A68D541C85D26508E83_949836385 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_949836385 = mResolver.openFileDescriptor(getDownloadUri(id), "r");
        addTaint(id);
        varB4EAC82CA7396A68D541C85D26508E83_949836385.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_949836385;
        // ---------- Original Method ----------
        //return mResolver.openFileDescriptor(getDownloadUri(id), "r");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.854 -0400", hash_original_method = "82FD0DABBA6B80B8B4BA3DF76B66A3D1", hash_generated_method = "74EF869474EA3ABA135B3DF30922150A")
    public Uri getUriForDownloadedFile(long id) {
        Uri varB4EAC82CA7396A68D541C85D26508E83_2108193922 = null; //Variable for return #1
        Uri varB4EAC82CA7396A68D541C85D26508E83_893336365 = null; //Variable for return #2
        Uri varB4EAC82CA7396A68D541C85D26508E83_2034326840 = null; //Variable for return #3
        Uri varB4EAC82CA7396A68D541C85D26508E83_1707521222 = null; //Variable for return #4
        Query query;
        query = new Query().setFilterById(id);
        Cursor cursor;
        cursor = null;
        try 
        {
            cursor = query(query);
            {
                varB4EAC82CA7396A68D541C85D26508E83_2108193922 = null;
            } //End block
            {
                boolean varCDEB7019138899FEAFBEC62FC2A4BF86_1067888366 = (cursor.moveToFirst());
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
                            varB4EAC82CA7396A68D541C85D26508E83_893336365 = ContentUris.withAppendedId(Downloads.Impl.CONTENT_URI, id);
                        } //End block
                        {
                            String path;
                            path = cursor.getString(
                                cursor.getColumnIndexOrThrow(COLUMN_LOCAL_FILENAME));
                            varB4EAC82CA7396A68D541C85D26508E83_2034326840 = Uri.fromFile(new File(path));
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
        varB4EAC82CA7396A68D541C85D26508E83_1707521222 = null;
        addTaint(id);
        Uri varA7E53CE21691AB073D9660D615818899_239635674; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_239635674 = varB4EAC82CA7396A68D541C85D26508E83_2108193922;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_239635674 = varB4EAC82CA7396A68D541C85D26508E83_893336365;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_239635674 = varB4EAC82CA7396A68D541C85D26508E83_2034326840;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_239635674 = varB4EAC82CA7396A68D541C85D26508E83_1707521222;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_239635674.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_239635674;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.868 -0400", hash_original_method = "EC65E8932FA161BF4DAEC74FC802F48D", hash_generated_method = "A42ACB5ECDE99318D2FD6EE0790CFBF2")
    public String getMimeTypeForDownloadedFile(long id) {
        String varB4EAC82CA7396A68D541C85D26508E83_2121048364 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_850722383 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_930646217 = null; //Variable for return #3
        Query query;
        query = new Query().setFilterById(id);
        Cursor cursor;
        cursor = null;
        try 
        {
            cursor = query(query);
            {
                varB4EAC82CA7396A68D541C85D26508E83_2121048364 = null;
            } //End block
            {
                boolean varCDEB7019138899FEAFBEC62FC2A4BF86_2106851226 = (cursor.moveToFirst());
                {
                    varB4EAC82CA7396A68D541C85D26508E83_850722383 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_MEDIA_TYPE));
                } //End block
            } //End collapsed parenthetic
        } //End block
        finally 
        {
            {
                cursor.close();
            } //End block
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_930646217 = null;
        addTaint(id);
        String varA7E53CE21691AB073D9660D615818899_2079410565; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2079410565 = varB4EAC82CA7396A68D541C85D26508E83_2121048364;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_2079410565 = varB4EAC82CA7396A68D541C85D26508E83_850722383;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2079410565 = varB4EAC82CA7396A68D541C85D26508E83_930646217;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2079410565.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2079410565;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.905 -0400", hash_original_method = "ABDC33D84A29539A96C484C81BD10405", hash_generated_method = "51F1D24CA61F0BC9911A3F0579046F6C")
    public void restartDownload(long... ids) {
        Cursor cursor;
        cursor = query(new Query().setFilterById(ids));
        try 
        {
            {
                cursor.moveToFirst();
                boolean varC9BB7A46744D2622E2F78BF928704FDD_451855418 = (!cursor.isAfterLast());
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
        addTaint(ids[0]);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.942 -0400", hash_original_method = "58F6793B30C14E2CFD3653910A805BA2", hash_generated_method = "0A1560B162564B9AF27E22BA55496555")
    public long addCompletedDownload(String title, String description,
            boolean isMediaScannerScannable, String mimeType, String path, long length,
            boolean showNotification) {
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
        long varA2F7CDA3EACA1ABC1BF253D57B57724C_2137941036 = (Long.parseLong(downloadUri.getLastPathSegment()));
        addTaint(title.getTaint());
        addTaint(description.getTaint());
        addTaint(isMediaScannerScannable);
        addTaint(mimeType.getTaint());
        addTaint(path.getTaint());
        addTaint(length);
        addTaint(showNotification);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1549656974 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1549656974;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        private static void validateArgumentIsNonEmpty(String paramName, String val) {
        if (TextUtils.isEmpty(val)) {
            throw new IllegalArgumentException(paramName + " can't be null");
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.027 -0400", hash_original_method = "D1EE950396677328804F68406B4587AE", hash_generated_method = "CD49C23C66D35386ECE61C3EE80BA89A")
     Uri getDownloadUri(long id) {
        Uri varB4EAC82CA7396A68D541C85D26508E83_1178126577 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1178126577 = ContentUris.withAppendedId(mBaseUri, id);
        addTaint(id);
        varB4EAC82CA7396A68D541C85D26508E83_1178126577.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1178126577;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.029 -0400", hash_original_field = "5FBE3730DCFF234F97B15868D5CE649D", hash_generated_field = "04FA8EB5D9FB8AC4AAE6453BCF1BBF82")

        private Uri mUri;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.034 -0400", hash_original_field = "D56C02C2196A65236C80C7DCE28A3AB7", hash_generated_field = "83BAA5C2BC0662F1D32FE83EA4951897")

        private Uri mDestinationUri;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.035 -0400", hash_original_field = "9902E4AE0DF2B59C61F5118F9D0AAC2F", hash_generated_field = "13A8BF554467B5955E7580E17A5A2DDA")

        private List<Pair<String, String>> mRequestHeaders = new ArrayList<Pair<String, String>>();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.035 -0400", hash_original_field = "4B03BBB3AD21DBD17B2B689923FCF1F6", hash_generated_field = "ECAB18871B55104BACD4283C12B1074D")

        private CharSequence mTitle;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.045 -0400", hash_original_field = "FF2B9B684DDD70D7BE468C8D9A54343D", hash_generated_field = "18C3493923549BAE766F057DAF8B146B")

        private CharSequence mDescription;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.046 -0400", hash_original_field = "FA38F1960A45A7EC16349AAF783A80BC", hash_generated_field = "D6D2783B71AE4BF9CBF84D44336E2BF9")

        private String mMimeType;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.046 -0400", hash_original_field = "88BCF3A961C3BE410BDE5D1BF8DFDE19", hash_generated_field = "952A1377CC9FB93E78D671C8656DC930")

        private boolean mRoamingAllowed = true;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.047 -0400", hash_original_field = "5EE6AA01E98013CD1FB70EC74A5B6859", hash_generated_field = "5A39BA83CA95D987B9F58ECEB876274F")

        private int mAllowedNetworkTypes = ~0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.047 -0400", hash_original_field = "14EB015AA8D6AE536374773FE32BA9C3", hash_generated_field = "CDF7B3598ECC145AEC167A93A8BA96F5")

        private boolean mIsVisibleInDownloadsUi = true;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.048 -0400", hash_original_field = "BDEF670E22CB4C3CEDAF7D0CD809FB30", hash_generated_field = "D6ACB722C57F150FD71504D93C5E360B")

        private boolean mScannable = false;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.048 -0400", hash_original_field = "D350B669F5679FD50E4690CE8AC72A14", hash_generated_field = "3DE0461D1F897FC34AAEB85C39656726")

        private boolean mUseSystemCache = false;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.065 -0400", hash_original_field = "3AE7BFD550D220788CDE382866503478", hash_generated_field = "BC737294552DD713920EAAEBBC85199C")

        private int mNotificationVisibility = VISIBILITY_VISIBLE;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.068 -0400", hash_original_method = "38AB51743560DA4EF393F63C39D43853", hash_generated_method = "7464FC700BDAE50D0726E5076FAC0F70")
        public  Request(Uri uri) {
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            } //End block
            String scheme;
            scheme = uri.getScheme();
            {
                boolean var697E1C480030E2C3839AD6831BF2A446_1796333193 = (scheme == null || (!scheme.equals("http") && !scheme.equals("https")));
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Can only download HTTP/HTTPS URIs: " + uri);
                } //End block
            } //End collapsed parenthetic
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.069 -0400", hash_original_method = "DEE528427F50C6163D0C2E44786A5A1B", hash_generated_method = "FDA44BFC9F8B59AE2D2550C14110C5D8")
          Request(String uriString) {
            mUri = Uri.parse(uriString);
            // ---------- Original Method ----------
            //mUri = Uri.parse(uriString);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.092 -0400", hash_original_method = "D90BC1E489B6C6F52B7EAE5F6B3F7838", hash_generated_method = "1B1EA0849A17656539F3175E23AA5842")
        public Request setDestinationUri(Uri uri) {
            Request varB4EAC82CA7396A68D541C85D26508E83_2105090594 = null; //Variable for return #1
            mDestinationUri = uri;
            varB4EAC82CA7396A68D541C85D26508E83_2105090594 = this;
            varB4EAC82CA7396A68D541C85D26508E83_2105090594.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2105090594;
            // ---------- Original Method ----------
            //mDestinationUri = uri;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.116 -0400", hash_original_method = "D82AD486A04E11ACCF6C157FAE4ED191", hash_generated_method = "2AEE56277953F5D7CAF69EC5B97285EA")
        public Request setDestinationToSystemCache() {
            Request varB4EAC82CA7396A68D541C85D26508E83_1723683964 = null; //Variable for return #1
            mUseSystemCache = true;
            varB4EAC82CA7396A68D541C85D26508E83_1723683964 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1723683964.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1723683964;
            // ---------- Original Method ----------
            //mUseSystemCache = true;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.119 -0400", hash_original_method = "D36C94DA39C2A5C5097A71BFF458D119", hash_generated_method = "3B104D79426A1E633042DCB7C3A1C427")
        public Request setDestinationInExternalFilesDir(Context context, String dirType,
                String subPath) {
            Request varB4EAC82CA7396A68D541C85D26508E83_1833413021 = null; //Variable for return #1
            setDestinationFromBase(context.getExternalFilesDir(dirType), subPath);
            varB4EAC82CA7396A68D541C85D26508E83_1833413021 = this;
            addTaint(context.getTaint());
            addTaint(dirType.getTaint());
            addTaint(subPath.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1833413021.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1833413021;
            // ---------- Original Method ----------
            //setDestinationFromBase(context.getExternalFilesDir(dirType), subPath);
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.151 -0400", hash_original_method = "DE3A2CC0AFE35B8C7E88937E379D2ACE", hash_generated_method = "B3BC16DC088F6AAC8AE08EABEC190C99")
        public Request setDestinationInExternalPublicDir(String dirType, String subPath) {
            Request varB4EAC82CA7396A68D541C85D26508E83_1661781100 = null; //Variable for return #1
            File file;
            file = Environment.getExternalStoragePublicDirectory(dirType);
            {
                boolean var59AA0F7651ECC78FBF1607A856F762E1_1378083158 = (file.exists());
                {
                    {
                        boolean var64D52B1E6C0DE0079880D4A605C58A0F_1193092569 = (!file.isDirectory());
                        {
                            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(file.getAbsolutePath() +
                            " already exists and is not a directory");
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    {
                        boolean var5FE45863B1A6CF5B78D16EE3A822F850_1654467493 = (!file.mkdir());
                        {
                            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Unable to create directory: "+
                            file.getAbsolutePath());
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            setDestinationFromBase(file, subPath);
            varB4EAC82CA7396A68D541C85D26508E83_1661781100 = this;
            addTaint(dirType.getTaint());
            addTaint(subPath.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1661781100.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1661781100;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.153 -0400", hash_original_method = "53900E0DE3709F8E65CE6AB9A613EA7C", hash_generated_method = "F9CF4996862359ED2F1C058BE6117363")
        private void setDestinationFromBase(File base, String subPath) {
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.180 -0400", hash_original_method = "39458C7E93B4E0F8CC50399F7846AF71", hash_generated_method = "C96F98A19F0478D3BC60EAEC74698C65")
        public void allowScanningByMediaScanner() {
            mScannable = true;
            // ---------- Original Method ----------
            //mScannable = true;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.183 -0400", hash_original_method = "84826A0727261744241F6F54A16F49D4", hash_generated_method = "DC176DAEA57D80726AB3E4B17C7D6786")
        public Request addRequestHeader(String header, String value) {
            Request varB4EAC82CA7396A68D541C85D26508E83_13015209 = null; //Variable for return #1
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException("header cannot be null");
            } //End block
            {
                boolean varDC5B1563EB0301505BACEAFD06DE4615_1600089259 = (header.contains(":"));
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("header may not contain ':'");
                } //End block
            } //End collapsed parenthetic
            {
                value = "";
            } //End block
            mRequestHeaders.add(Pair.create(header, value));
            varB4EAC82CA7396A68D541C85D26508E83_13015209 = this;
            addTaint(header.getTaint());
            addTaint(value.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_13015209.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_13015209;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.198 -0400", hash_original_method = "D2617ADF02871E26D8818B6B93DA088D", hash_generated_method = "02170C28150DA179B313AC73B51EC452")
        public Request setTitle(CharSequence title) {
            Request varB4EAC82CA7396A68D541C85D26508E83_515558874 = null; //Variable for return #1
            mTitle = title;
            varB4EAC82CA7396A68D541C85D26508E83_515558874 = this;
            varB4EAC82CA7396A68D541C85D26508E83_515558874.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_515558874;
            // ---------- Original Method ----------
            //mTitle = title;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.217 -0400", hash_original_method = "3BFD78827604EC47FE3892636D121D42", hash_generated_method = "C86D54904C191912FF4EDD44666EEC9F")
        public Request setDescription(CharSequence description) {
            Request varB4EAC82CA7396A68D541C85D26508E83_935989209 = null; //Variable for return #1
            mDescription = description;
            varB4EAC82CA7396A68D541C85D26508E83_935989209 = this;
            varB4EAC82CA7396A68D541C85D26508E83_935989209.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_935989209;
            // ---------- Original Method ----------
            //mDescription = description;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.222 -0400", hash_original_method = "EAEBE95F38EAF7D74F8EC9BD89175C39", hash_generated_method = "704A754DDA4E128B75FB51FBD04E7E68")
        public Request setMimeType(String mimeType) {
            Request varB4EAC82CA7396A68D541C85D26508E83_320488887 = null; //Variable for return #1
            mMimeType = mimeType;
            varB4EAC82CA7396A68D541C85D26508E83_320488887 = this;
            varB4EAC82CA7396A68D541C85D26508E83_320488887.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_320488887;
            // ---------- Original Method ----------
            //mMimeType = mimeType;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.253 -0400", hash_original_method = "F75AFBEFCFC8BE21F83F018EA7CEB6E1", hash_generated_method = "F11BE0C26E8739E8C6018CA1BB70DB46")
        @Deprecated
        public Request setShowRunningNotification(boolean show) {
            Request varB4EAC82CA7396A68D541C85D26508E83_384121551 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_384121551 = (show) ? setNotificationVisibility(VISIBILITY_VISIBLE) :
                    setNotificationVisibility(VISIBILITY_HIDDEN);
            addTaint(show);
            varB4EAC82CA7396A68D541C85D26508E83_384121551.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_384121551;
            // ---------- Original Method ----------
            //return (show) ? setNotificationVisibility(VISIBILITY_VISIBLE) :
                    //setNotificationVisibility(VISIBILITY_HIDDEN);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.258 -0400", hash_original_method = "0E1BEC1EE7CB7BCA18E6C69650765291", hash_generated_method = "DAE09034509A4377846DBC605FC35AAC")
        public Request setNotificationVisibility(int visibility) {
            Request varB4EAC82CA7396A68D541C85D26508E83_2083017389 = null; //Variable for return #1
            mNotificationVisibility = visibility;
            varB4EAC82CA7396A68D541C85D26508E83_2083017389 = this;
            varB4EAC82CA7396A68D541C85D26508E83_2083017389.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2083017389;
            // ---------- Original Method ----------
            //mNotificationVisibility = visibility;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.282 -0400", hash_original_method = "1FB95247AA3BF4BC290C0031C887893C", hash_generated_method = "9E32D4FEC48CCEA34BC31CC2157208FA")
        public Request setAllowedNetworkTypes(int flags) {
            Request varB4EAC82CA7396A68D541C85D26508E83_293451847 = null; //Variable for return #1
            mAllowedNetworkTypes = flags;
            varB4EAC82CA7396A68D541C85D26508E83_293451847 = this;
            varB4EAC82CA7396A68D541C85D26508E83_293451847.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_293451847;
            // ---------- Original Method ----------
            //mAllowedNetworkTypes = flags;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.300 -0400", hash_original_method = "EED7837CFCCAA493B8F853E6287613BD", hash_generated_method = "BC72145C67470A542992D64888271D0B")
        public Request setAllowedOverRoaming(boolean allowed) {
            Request varB4EAC82CA7396A68D541C85D26508E83_271225106 = null; //Variable for return #1
            mRoamingAllowed = allowed;
            varB4EAC82CA7396A68D541C85D26508E83_271225106 = this;
            varB4EAC82CA7396A68D541C85D26508E83_271225106.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_271225106;
            // ---------- Original Method ----------
            //mRoamingAllowed = allowed;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.315 -0400", hash_original_method = "865D9FB8BB624139754E18F2F470A937", hash_generated_method = "151BD4538B9E25450718F03DC79EE278")
        public Request setVisibleInDownloadsUi(boolean isVisible) {
            Request varB4EAC82CA7396A68D541C85D26508E83_1935123589 = null; //Variable for return #1
            mIsVisibleInDownloadsUi = isVisible;
            varB4EAC82CA7396A68D541C85D26508E83_1935123589 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1935123589.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1935123589;
            // ---------- Original Method ----------
            //mIsVisibleInDownloadsUi = isVisible;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.356 -0400", hash_original_method = "A794ABF9FD18E330B670B5AD24CF2800", hash_generated_method = "FF8E4C6DE5C046C9275FBE4287AFE7A7")
         ContentValues toContentValues(String packageName) {
            ContentValues varB4EAC82CA7396A68D541C85D26508E83_2113744370 = null; //Variable for return #1
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
                boolean varE410073C37185297D362C1E68809DB54_1926428052 = (!mRequestHeaders.isEmpty());
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
            varB4EAC82CA7396A68D541C85D26508E83_2113744370 = values;
            addTaint(packageName.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_2113744370.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2113744370;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.517 -0400", hash_original_method = "26D27F1BE5E3A68003877A062F0DAD99", hash_generated_method = "818D8A142570F2551611E17A25B1740E")
        private void encodeHttpHeaders(ContentValues values) {
            int index;
            index = 0;
            {
                Iterator<Pair<String, String>> var6EC36093AF9DC0A9505C9A55F0DE4444_199049805 = (mRequestHeaders).iterator();
                var6EC36093AF9DC0A9505C9A55F0DE4444_199049805.hasNext();
                Pair<String, String> header = var6EC36093AF9DC0A9505C9A55F0DE4444_199049805.next();
                {
                    String headerString;
                    headerString = header.first + ": " + header.second;
                    values.put(Downloads.Impl.RequestHeaders.INSERT_KEY_PREFIX + index, headerString);
                } //End block
            } //End collapsed parenthetic
            addTaint(values.getTaint());
            // ---------- Original Method ----------
            //int index = 0;
            //for (Pair<String, String> header : mRequestHeaders) {
                //String headerString = header.first + ": " + header.second;
                //values.put(Downloads.Impl.RequestHeaders.INSERT_KEY_PREFIX + index, headerString);
                //index++;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.522 -0400", hash_original_method = "19BA5B9D42AC58D8841CDF02C796EE38", hash_generated_method = "E11F9E185847FF673D7FBCD1C9033B18")
        private void putIfNonNull(ContentValues contentValues, String key, Object value) {
            {
                contentValues.put(key, value.toString());
            } //End block
            addTaint(contentValues.getTaint());
            addTaint(key.getTaint());
            addTaint(value.getTaint());
            // ---------- Original Method ----------
            //if (value != null) {
                //contentValues.put(key, value.toString());
            //}
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.523 -0400", hash_original_field = "2DECCABC6A842947B60E39EA0FC15085", hash_generated_field = "2A08EDDDB593C12F8423C559DB638960")

        public static final int NETWORK_MOBILE = 1 << 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.523 -0400", hash_original_field = "C54F5B644D418630CECD1427EC0D4736", hash_generated_field = "A0D2C438A9D332F064354E5B5CD56CD8")

        public static final int NETWORK_WIFI = 1 << 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.524 -0400", hash_original_field = "9A22B40090C002AE86B482C4964ECE31", hash_generated_field = "A0A1DFC48007AE6EEFDA8728DDF4E551")

        private static int SCANNABLE_VALUE_YES = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.552 -0400", hash_original_field = "D84387C59443EF1276F988651568F162", hash_generated_field = "0442BB239E138C2DA8B6AE10261F8F61")

        private static int SCANNABLE_VALUE_NO = 2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.552 -0400", hash_original_field = "EE7FE8DE87F42C3C75936AB3D965CBF9", hash_generated_field = "678667850A54425C02D37FACB767853B")

        public static final int VISIBILITY_VISIBLE = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.553 -0400", hash_original_field = "0B822A7032D74847E7AA17804167F0FE", hash_generated_field = "F285E9AEAAA3AB3B3BF3A904EF1F15E0")

        public static final int VISIBILITY_VISIBLE_NOTIFY_COMPLETED = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.554 -0400", hash_original_field = "3A9106B0FA476D6F55EC1E276A420B9C", hash_generated_field = "7C647F96488D335DF451E9699546D435")

        public static final int VISIBILITY_HIDDEN = 2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.554 -0400", hash_original_field = "D4129AD1EEC3964E36935A2F614BC446", hash_generated_field = "F99A308F434AB6F300224D2C143BC731")

        public static final int VISIBILITY_VISIBLE_NOTIFY_ONLY_COMPLETION = 3;
    }


    
    public static class Query {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.563 -0400", hash_original_field = "4F579D3D7BCB1271CC18AC1E755540D2", hash_generated_field = "5F8E81DCB2F7B395E24A391C0FACBDE6")

        private long[] mIds = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.563 -0400", hash_original_field = "AE5DCEBD02CF265CFB94CBED107BC43B", hash_generated_field = "F78B9285416B8C880978036645800403")

        private Integer mStatusFlags = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.567 -0400", hash_original_field = "7D3F9ACFBFDEDC26C8A47E8138C1E1A8", hash_generated_field = "39E6027705921A51748F7FC07E010111")

        private String mOrderByColumn = Downloads.Impl.COLUMN_LAST_MODIFICATION;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.568 -0400", hash_original_field = "707ADE263B8DE3CF22961F4796A34FED", hash_generated_field = "EED59D0671C844A1902BF26138BB3F37")

        private int mOrderDirection = ORDER_DESCENDING;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.589 -0400", hash_original_field = "BB54684F97A66C91A29A969F6C84B13D", hash_generated_field = "964B69564A78D777DDBF359D9B2AA67B")

        private boolean mOnlyIncludeVisibleInDownloadsUi = false;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.590 -0400", hash_original_method = "EFCA8790A91D69466A874AF6524F8E69", hash_generated_method = "EFCA8790A91D69466A874AF6524F8E69")
        public Query ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.614 -0400", hash_original_method = "782D3BAE9A57AE7F89D5C5E0BBC212BD", hash_generated_method = "7516586B87DBDF629187828BA7C319FB")
        public Query setFilterById(long... ids) {
            Query varB4EAC82CA7396A68D541C85D26508E83_1088320229 = null; //Variable for return #1
            mIds = ids;
            varB4EAC82CA7396A68D541C85D26508E83_1088320229 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1088320229.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1088320229;
            // ---------- Original Method ----------
            //mIds = ids;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.631 -0400", hash_original_method = "CE9295EE41F323C50B34B72F478BD4C2", hash_generated_method = "73550C95013150C63C21B985A7739049")
        public Query setFilterByStatus(int flags) {
            Query varB4EAC82CA7396A68D541C85D26508E83_902079042 = null; //Variable for return #1
            mStatusFlags = flags;
            varB4EAC82CA7396A68D541C85D26508E83_902079042 = this;
            varB4EAC82CA7396A68D541C85D26508E83_902079042.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_902079042;
            // ---------- Original Method ----------
            //mStatusFlags = flags;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.647 -0400", hash_original_method = "9600119EF208E670C5EE47F5F776ED3A", hash_generated_method = "260AA097F7C84F37BD49FDF99F186FDA")
        public Query setOnlyIncludeVisibleInDownloadsUi(boolean value) {
            Query varB4EAC82CA7396A68D541C85D26508E83_1471715990 = null; //Variable for return #1
            mOnlyIncludeVisibleInDownloadsUi = value;
            varB4EAC82CA7396A68D541C85D26508E83_1471715990 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1471715990.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1471715990;
            // ---------- Original Method ----------
            //mOnlyIncludeVisibleInDownloadsUi = value;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.660 -0400", hash_original_method = "969F069748FB75BDEDE2897D8F038415", hash_generated_method = "DAA33FE75A0037AEB336619FEBDDC7B0")
        public Query orderBy(String column, int direction) {
            Query varB4EAC82CA7396A68D541C85D26508E83_1930485807 = null; //Variable for return #1
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Invalid direction: " + direction);
            } //End block
            {
                boolean varB0B34C57CB5381E2A5D80B1DAEBC2C51_1786018935 = (column.equals(COLUMN_LAST_MODIFIED_TIMESTAMP));
                {
                    mOrderByColumn = Downloads.Impl.COLUMN_LAST_MODIFICATION;
                } //End block
                {
                    boolean varEBF14B99C957D46FCEDCE1161497CE7F_1448288029 = (column.equals(COLUMN_TOTAL_SIZE_BYTES));
                    {
                        mOrderByColumn = Downloads.Impl.COLUMN_TOTAL_BYTES;
                    } //End block
                    {
                        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Cannot order by " + column);
                    } //End block
                } //End collapsed parenthetic
            } //End collapsed parenthetic
            mOrderDirection = direction;
            varB4EAC82CA7396A68D541C85D26508E83_1930485807 = this;
            addTaint(column.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1930485807.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1930485807;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.701 -0400", hash_original_method = "3E117BB34A8C7FFA67D17AB4CC250832", hash_generated_method = "F638EB6B012D9A1BAA3F283103CB9D55")
         Cursor runQuery(ContentResolver resolver, String[] projection, Uri baseUri) {
            Cursor varB4EAC82CA7396A68D541C85D26508E83_459346588 = null; //Variable for return #1
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
            varB4EAC82CA7396A68D541C85D26508E83_459346588 = resolver.query(uri, projection, selection, selectionArgs, orderBy);
            addTaint(resolver.getTaint());
            addTaint(projection[0].getTaint());
            addTaint(baseUri.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_459346588.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_459346588;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.851 -0400", hash_original_method = "E982889F0CE13C731CA9D89AB5FD3B78", hash_generated_method = "FBE9807C0DDFE1BC23A81CD8F6D7A072")
        private String joinStrings(String joiner, Iterable<String> parts) {
            String varB4EAC82CA7396A68D541C85D26508E83_692500165 = null; //Variable for return #1
            StringBuilder builder;
            builder = new StringBuilder();
            boolean first;
            first = true;
            {
                Iterator<String> var4E9C8AFBA69334251664FB12D52EFE6A_1442026728 = (parts).iterator();
                var4E9C8AFBA69334251664FB12D52EFE6A_1442026728.hasNext();
                String part = var4E9C8AFBA69334251664FB12D52EFE6A_1442026728.next();
                {
                    {
                        builder.append(joiner);
                    } //End block
                    builder.append(part);
                    first = false;
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_692500165 = builder.toString();
            addTaint(joiner.getTaint());
            addTaint(parts.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_692500165.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_692500165;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.870 -0400", hash_original_method = "F1C2C126003D565FB51A9C1A25E86357", hash_generated_method = "15509A688533BAC4FCF8629E5BCA0F4A")
        private String statusClause(String operator, int value) {
            String varB4EAC82CA7396A68D541C85D26508E83_544053749 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_544053749 = Downloads.Impl.COLUMN_STATUS + operator + "'" + value + "'";
            addTaint(operator.getTaint());
            addTaint(value);
            varB4EAC82CA7396A68D541C85D26508E83_544053749.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_544053749;
            // ---------- Original Method ----------
            //return Downloads.Impl.COLUMN_STATUS + operator + "'" + value + "'";
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.871 -0400", hash_original_field = "4FDB899E3766A064074C9081C7B6A267", hash_generated_field = "33AF9DE750C57D52372B21F0E7746D47")

        public static final int ORDER_ASCENDING = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.871 -0400", hash_original_field = "2E1B9074F3BE6834ABC0129E780F4F46", hash_generated_field = "2CF799A3EEA7BC4C831B8EB82D2B58DE")

        public static final int ORDER_DESCENDING = 2;
    }


    
    private static class CursorTranslator extends CursorWrapper {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.872 -0400", hash_original_field = "718CF095732EDC4F563D086AE0B1FE46", hash_generated_field = "352FDC66A51EED366C84411537612673")

        private Uri mBaseUri;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.890 -0400", hash_original_method = "DA2C30EB999FAADAF9AB1439D3B9F223", hash_generated_method = "6B0EF03C13B7FAD8859BBDC072D4B1C9")
        public  CursorTranslator(Cursor cursor, Uri baseUri) {
            super(cursor);
            mBaseUri = baseUri;
            addTaint(cursor.getTaint());
            // ---------- Original Method ----------
            //mBaseUri = baseUri;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.903 -0400", hash_original_method = "34538125BB8387937A75DA11F9FB5B65", hash_generated_method = "0C5BC5033CA4FC4E7668F92C1D481C82")
        @Override
        public int getInt(int columnIndex) {
            int var3CD82268530977C7C6744F3E8BBDD7D6_1146637889 = ((int) getLong(columnIndex));
            addTaint(columnIndex);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_622593320 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_622593320;
            // ---------- Original Method ----------
            //return (int) getLong(columnIndex);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.920 -0400", hash_original_method = "744FA54C78DD5C7B6737C741AD0EB8F1", hash_generated_method = "17223A1C77093F04AF85F63C407C06F6")
        @Override
        public long getLong(int columnIndex) {
            {
                boolean var64C1AD00092BC2F5CCD236C968ADB1F7_534883473 = (getColumnName(columnIndex).equals(COLUMN_REASON));
                {
                    long varEA20B4C0EF19C4D7CCB17B21400F6CFF_1038727735 = (getReason(super.getInt(getColumnIndex(Downloads.Impl.COLUMN_STATUS))));
                } //End block
                {
                    boolean var354558F166115927AECC93EF734F99AA_1098250879 = (getColumnName(columnIndex).equals(COLUMN_STATUS));
                    {
                        long var7FCD1CEC76DC9A06E3A454B471B4004B_437322785 = (translateStatus(super.getInt(getColumnIndex(Downloads.Impl.COLUMN_STATUS))));
                    } //End block
                    {
                        long varC0843ACC657E8C550727A370AD3FD7B2_816015892 = (super.getLong(columnIndex));
                    } //End block
                } //End collapsed parenthetic
            } //End collapsed parenthetic
            addTaint(columnIndex);
            long var0F5264038205EDFB1AC05FBB0E8C5E94_139840816 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_139840816;
            // ---------- Original Method ----------
            //if (getColumnName(columnIndex).equals(COLUMN_REASON)) {
                //return getReason(super.getInt(getColumnIndex(Downloads.Impl.COLUMN_STATUS)));
            //} else if (getColumnName(columnIndex).equals(COLUMN_STATUS)) {
                //return translateStatus(super.getInt(getColumnIndex(Downloads.Impl.COLUMN_STATUS)));
            //} else {
                //return super.getLong(columnIndex);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.934 -0400", hash_original_method = "2A6CC35BB4DF843267A861B5828C6994", hash_generated_method = "979C8A626430CC9577C77AE6C9F92E24")
        @Override
        public String getString(int columnIndex) {
            String varB4EAC82CA7396A68D541C85D26508E83_448683605 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_448683605 = (getColumnName(columnIndex).equals(COLUMN_LOCAL_URI)) ? getLocalUri() :
                    super.getString(columnIndex);
            addTaint(columnIndex);
            varB4EAC82CA7396A68D541C85D26508E83_448683605.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_448683605;
            // ---------- Original Method ----------
            //return (getColumnName(columnIndex).equals(COLUMN_LOCAL_URI)) ? getLocalUri() :
                    //super.getString(columnIndex);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.954 -0400", hash_original_method = "C2F388AD18BA84031DEC0607FBEAB7C5", hash_generated_method = "F71E41623B5260F4C123A02D82AA038A")
        private String getLocalUri() {
            String varB4EAC82CA7396A68D541C85D26508E83_1347259895 = null; //Variable for return #1
            String varB4EAC82CA7396A68D541C85D26508E83_1441625376 = null; //Variable for return #2
            String varB4EAC82CA7396A68D541C85D26508E83_957193998 = null; //Variable for return #3
            long destinationType;
            destinationType = getLong(getColumnIndex(Downloads.Impl.COLUMN_DESTINATION));
            {
                String localPath;
                localPath = getString(getColumnIndex(COLUMN_LOCAL_FILENAME));
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1347259895 = null;
                } //End block
                varB4EAC82CA7396A68D541C85D26508E83_1441625376 = Uri.fromFile(new File(localPath)).toString();
            } //End block
            long downloadId;
            downloadId = getLong(getColumnIndex(Downloads.Impl._ID));
            varB4EAC82CA7396A68D541C85D26508E83_957193998 = ContentUris.withAppendedId(mBaseUri, downloadId).toString();
            String varA7E53CE21691AB073D9660D615818899_358139789; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_358139789 = varB4EAC82CA7396A68D541C85D26508E83_1347259895;
                    break;
                case 2: //Assign result for return ordinal #2
                    varA7E53CE21691AB073D9660D615818899_358139789 = varB4EAC82CA7396A68D541C85D26508E83_1441625376;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_358139789 = varB4EAC82CA7396A68D541C85D26508E83_957193998;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_358139789.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_358139789;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.971 -0400", hash_original_method = "A69C93787DF2FD0B667931CA82E74881", hash_generated_method = "D88EB88F462FF8F9D15AE9816C5B771C")
        private long getReason(int status) {
            {
                Object varBFF60C51F3561C06BE2F47ADE835EC83_673492032 = (translateStatus(status));
                //Begin case STATUS_FAILED 
                long varA00E54BE3716406F658C01669FEA3255_482247004 = (getErrorCode(status));
                //End case STATUS_FAILED 
                //Begin case STATUS_PAUSED 
                long var0684DD53D22A9802EEC682794798C46B_1867305314 = (getPausedReason(status));
                //End case STATUS_PAUSED 
            } //End collapsed parenthetic
            addTaint(status);
            long var0F5264038205EDFB1AC05FBB0E8C5E94_1956280859 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1956280859;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.973 -0400", hash_original_method = "8BF9F68328111BA50CCB78B1792F76F0", hash_generated_method = "A78FB4B931C22AF82390A7886413CBDA")
        private long getPausedReason(int status) {
            addTaint(status);
            long var0F5264038205EDFB1AC05FBB0E8C5E94_704647994 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_704647994;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.991 -0400", hash_original_method = "A27080D0C32BDBDFED7217EFE39DC72F", hash_generated_method = "39C6E3E8CD65B8068A0236771438A440")
        private long getErrorCode(int status) {
            addTaint(status);
            long var0F5264038205EDFB1AC05FBB0E8C5E94_263502030 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_263502030;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:48.014 -0400", hash_original_method = "AC0B465D7BF7B10F5608906AFAA7CE72", hash_generated_method = "351079709F58B514170BD23DC9B4711E")
        private int translateStatus(int status) {
            addTaint(status);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_9106880 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_9106880;
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


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:48.015 -0400", hash_original_field = "28E13913130DC317027A75F9CAADB6E6", hash_generated_field = "A7E023A8D48EDA84D30E823FC247AC7D")

    public final static String COLUMN_ID = Downloads.Impl._ID;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:48.015 -0400", hash_original_field = "4F18DB729598483955C67DF843942E9B", hash_generated_field = "E0475ED0F443C2F35BA6DAC29B806E15")

    public final static String COLUMN_TITLE = Downloads.Impl.COLUMN_TITLE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:48.016 -0400", hash_original_field = "C7A6174B374253166E3D4F540CB3899A", hash_generated_field = "2ADDAD1D6BE2368DD43079C018505DC2")

    public final static String COLUMN_DESCRIPTION = Downloads.Impl.COLUMN_DESCRIPTION;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:48.022 -0400", hash_original_field = "8AAE7CAB40335C45902B3C3A4B4359D4", hash_generated_field = "143198F8ECD99C932C3BA352BDD7B4F6")

    public final static String COLUMN_URI = Downloads.Impl.COLUMN_URI;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:48.022 -0400", hash_original_field = "769FA87A9CCB7D4CA16571486316ACCC", hash_generated_field = "9BF784ED01C8E5392F5BB2D34F27F68B")

    public final static String COLUMN_MEDIA_TYPE = "media_type";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:48.023 -0400", hash_original_field = "26A36CC9B29C427A7705DA55CD804EB2", hash_generated_field = "84BD203A764C2D32D032768E5BA85C6A")

    public final static String COLUMN_TOTAL_SIZE_BYTES = "total_size";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:48.025 -0400", hash_original_field = "E36D1141E52AA346782AC8609221301B", hash_generated_field = "87092124AEB640ED262648BE065600C9")

    public final static String COLUMN_LOCAL_URI = "local_uri";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:48.026 -0400", hash_original_field = "E6F63FD9C72D36809812647B3A97AAC7", hash_generated_field = "38930F295047A3F6AE0AC7B02C24770A")

    public final static String COLUMN_LOCAL_FILENAME = "local_filename";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:48.026 -0400", hash_original_field = "D0941CF2EAA2934186552963A9F2F3C1", hash_generated_field = "AD200817B86CDDB6809552A585F6F3CB")

    public final static String COLUMN_STATUS = Downloads.Impl.COLUMN_STATUS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:48.027 -0400", hash_original_field = "B392173D4EE64EB34E055EAA4249CA25", hash_generated_field = "D7D42B4B48EDF0D303BF107E8C2B9639")

    public final static String COLUMN_REASON = "reason";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:48.028 -0400", hash_original_field = "D4687D5D1BC923240E08E965E50C32D3", hash_generated_field = "E75A5474EBC7BBC6DB9427B4EA03D662")

    public final static String COLUMN_BYTES_DOWNLOADED_SO_FAR = "bytes_so_far";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:48.028 -0400", hash_original_field = "CF721E7C812971EC93264A0FEA00EFD1", hash_generated_field = "70EB989845348DC7DAA5AF45C362A8C0")

    public final static String COLUMN_LAST_MODIFIED_TIMESTAMP = "last_modified_timestamp";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:48.043 -0400", hash_original_field = "B8D99CC2D9EE6FDC3C5B92F362B619D5", hash_generated_field = "E798B6BCD082848B6F5403070514339F")

    public static final String COLUMN_MEDIAPROVIDER_URI = Downloads.Impl.COLUMN_MEDIAPROVIDER_URI;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:48.044 -0400", hash_original_field = "D9920B04BB8875828838F10EF6BCAC8A", hash_generated_field = "5A6A6A376CA33569B014DF98BB4486F5")

    public final static int STATUS_PENDING = 1 << 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:48.044 -0400", hash_original_field = "787F81C54F7669D7B5DFC4C4E59E3970", hash_generated_field = "DDF3A08F677DC31638E00F51A652178C")

    public final static int STATUS_RUNNING = 1 << 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:48.065 -0400", hash_original_field = "CD3563EE6AD32EC86F2B215DEE0E86AA", hash_generated_field = "B6CF42D4BE6CC4E35C56FF7AFD758358")

    public final static int STATUS_PAUSED = 1 << 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:48.065 -0400", hash_original_field = "F5C8808AF0D080F35FEB54862F0B5E83", hash_generated_field = "16CE303BA58E19D2E9F3935ACB3CE0FB")

    public final static int STATUS_SUCCESSFUL = 1 << 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:48.066 -0400", hash_original_field = "F2A4B8336D15E7C1C353A849AA6B8458", hash_generated_field = "1BCCE4C740453C51D27A9C44E3F68B40")

    public final static int STATUS_FAILED = 1 << 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:48.066 -0400", hash_original_field = "B1B8CF8DDF7369BDFB1FDEFD0E148A26", hash_generated_field = "49F5D6EC283C95877C76975EF6E926C6")

    public final static int ERROR_UNKNOWN = 1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:48.067 -0400", hash_original_field = "87C83208A97BE663E34D9647DF2EF7E6", hash_generated_field = "0E73FEF6AA8AAE6DB010C8400B9928BE")

    public final static int ERROR_FILE_ERROR = 1001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:48.068 -0400", hash_original_field = "CFCFE2CD6A0A8BD4DF43CEFE343700A7", hash_generated_field = "1AC4CB82DAEB32AFCC84E359B353A84E")

    public final static int ERROR_UNHANDLED_HTTP_CODE = 1002;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:48.071 -0400", hash_original_field = "6E78B11D35FB475E28CA97D4E6C547B1", hash_generated_field = "7D7BB2F4DF6F4E9B6967224CE2FAF5E8")

    public final static int ERROR_HTTP_DATA_ERROR = 1004;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:48.071 -0400", hash_original_field = "E97C109F2226A38F6B0A0CBFBF78E56E", hash_generated_field = "7D1894872E657F2F1D75836AC335D1AF")

    public final static int ERROR_TOO_MANY_REDIRECTS = 1005;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:48.084 -0400", hash_original_field = "5B6B1D13BAF3583DB3FC3880D5CF5310", hash_generated_field = "4745C1817D6FFD01542FD1D7B9BCDF6B")

    public final static int ERROR_INSUFFICIENT_SPACE = 1006;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:48.085 -0400", hash_original_field = "42B9606B5DE02CD5B870EC439CBC4799", hash_generated_field = "D22E5678B4FACB05F514DC5331AD6F98")

    public final static int ERROR_DEVICE_NOT_FOUND = 1007;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:48.085 -0400", hash_original_field = "D9CB71BDB7ED1A07CEDC0B5C7ACF2016", hash_generated_field = "310C5FB2CCFCEBB3F61B6B0F16B85CE9")

    public final static int ERROR_CANNOT_RESUME = 1008;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:48.086 -0400", hash_original_field = "4DADA07169D41492B63745757EBB9BAE", hash_generated_field = "03022A2BA7BEFEFA9680B89BFC241220")

    public final static int ERROR_FILE_ALREADY_EXISTS = 1009;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:48.088 -0400", hash_original_field = "742BD13A8B7D1BAC4F048EE8E11696BA", hash_generated_field = "95F9CC4D3D18A2E56CF90C0970647D3D")

    public final static int ERROR_BLOCKED = 1010;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:48.090 -0400", hash_original_field = "53DCCFB529054899419C09B1FC8D527A", hash_generated_field = "375A127B5A11AB6F86CDA6C2E7687C81")

    public final static int PAUSED_WAITING_TO_RETRY = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:48.093 -0400", hash_original_field = "CF8B92A918BA25E72267510856BBDF24", hash_generated_field = "1AB4E417B461169A72753CA5536FB9C8")

    public final static int PAUSED_WAITING_FOR_NETWORK = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:48.093 -0400", hash_original_field = "D315A0B4812ACA7922F6DE58705DC22F", hash_generated_field = "4C94328F0C2918D47EFCEA3271E499DF")

    public final static int PAUSED_QUEUED_FOR_WIFI = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:48.094 -0400", hash_original_field = "D77A325B9B8C28B05140B5D47218D329", hash_generated_field = "4D9D144F191E78908A11C759352904B6")

    public final static int PAUSED_UNKNOWN = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:48.094 -0400", hash_original_field = "278C5BA979AEAF9E5167F1A8C082AE5B", hash_generated_field = "F59DDF2C5961F68B20C867F8313BBEFB")

    public final static String ACTION_DOWNLOAD_COMPLETE = "android.intent.action.DOWNLOAD_COMPLETE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:48.108 -0400", hash_original_field = "7749EC94D727FDDDEFDAB2D0EAE57B72", hash_generated_field = "C99B78141EF70699F8A2ED7E9CB8DD42")

    public final static String ACTION_NOTIFICATION_CLICKED =
            "android.intent.action.DOWNLOAD_NOTIFICATION_CLICKED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:48.109 -0400", hash_original_field = "036041F33A2303C21F448683E744290A", hash_generated_field = "DE2A2BF8E91A6F3A9065C043915477FB")

    public final static String ACTION_VIEW_DOWNLOADS = "android.intent.action.VIEW_DOWNLOADS";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:48.109 -0400", hash_original_field = "A5BDC999C90856BFDD040E48EF31A616", hash_generated_field = "3301DDAE8E2BAA3A9528297879FE4303")

    public final static String INTENT_EXTRAS_SORT_BY_SIZE =
            "android.app.DownloadManager.extra_sortBySize";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:48.110 -0400", hash_original_field = "5220593F731D0C32288FAAE6C6B442FF", hash_generated_field = "937B93366C4C3FE30B8BE2FA09D9B445")

    public static final String EXTRA_DOWNLOAD_ID = "extra_download_id";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:48.120 -0400", hash_original_field = "7F8AD7318CBA22EA99DF8C7689BD846C", hash_generated_field = "4DF09F4FBB097DF9B81CC166A5136DAA")

    public static final String EXTRA_NOTIFICATION_CLICK_DOWNLOAD_IDS = "extra_click_download_ids";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:48.121 -0400", hash_original_field = "D950C56A7A90C4B58D865C265F965355", hash_generated_field = "35D0E0EA646E6DE036699985804C1F7A")

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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:48.122 -0400", hash_original_field = "CB6BAA7FD313D1CA2A881424B9358C2E", hash_generated_field = "90B406885EF8D01AC85929FE6261C83C")

    private static String NON_DOWNLOADMANAGER_DOWNLOAD = "non-dwnldmngr-download-dont-retry2download";
}

