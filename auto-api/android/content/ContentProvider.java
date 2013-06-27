package android.content;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.pm.PackageManager;
import android.content.pm.PathPermission;
import android.content.pm.ProviderInfo;
import android.content.res.AssetFileDescriptor;
import android.content.res.Configuration;
import android.database.Cursor;
import android.database.SQLException;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Binder;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.util.Log;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public abstract class ContentProvider implements ComponentCallbacks2 {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.791 -0400", hash_original_field = "EC9A3144C1687F6FFFFC7AC4B8A997AD", hash_generated_field = "64C2E29345D1A72D78C884235FF4120B")

    private Context mContext = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.791 -0400", hash_original_field = "2C2F002F67CB0ABAF6E9BE038FA0C0A5", hash_generated_field = "BAE02AD4841B16814759F68D3AA9D00B")

    private int mMyUid;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.791 -0400", hash_original_field = "3805826D63CBE0EFB018A286F189CC44", hash_generated_field = "F91CBC541AE5EA168107190D1A494CD8")

    private String mReadPermission;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.792 -0400", hash_original_field = "EA3BA31BE3E977A5CA4A690ADA101637", hash_generated_field = "02101D3B9ECFAAEB0689EF2DAEF4A808")

    private String mWritePermission;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.792 -0400", hash_original_field = "00F4643DBE3AE1276B44E74500631096", hash_generated_field = "15E0F7E05B281A905081D65ED9192FDD")

    private PathPermission[] mPathPermissions;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.792 -0400", hash_original_field = "5DCBFC76DAEB92A3E3FD1528EAC8DAB3", hash_generated_field = "5F31C09AB3C1B6A6E2600C83F2928ABF")

    private boolean mExported;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.792 -0400", hash_original_field = "E1D0BDA9D633EC3C8F88DD17C08825F1", hash_generated_field = "B996B8C49C2307FDF0CA3803832CA9DC")

    private Transport mTransport = new Transport();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.844 -0400", hash_original_method = "F039A73ADD81439EFEE4572A926905FF", hash_generated_method = "AE9E67C0D421B97975CBD6F5E7DAC5C3")
    public  ContentProvider() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.848 -0400", hash_original_method = "40393AF8078D8D6FEE29B00460ADF530", hash_generated_method = "1AEE9CFE935A08AC9F4B6B91141A98D6")
    public  ContentProvider(
            Context context,
            String readPermission,
            String writePermission,
            PathPermission[] pathPermissions) {
        mContext = context;
        mReadPermission = readPermission;
        mWritePermission = writePermission;
        mPathPermissions = pathPermissions;
        // ---------- Original Method ----------
        //mContext = context;
        //mReadPermission = readPermission;
        //mWritePermission = writePermission;
        //mPathPermissions = pathPermissions;
    }

    
        public static ContentProvider coerceToLocalContentProvider(
            IContentProvider abstractInterface) {
        if (abstractInterface instanceof Transport) {
            return ((Transport)abstractInterface).getContentProvider();
        }
        return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.863 -0400", hash_original_method = "4F4EBC54D108D66F416C93B46580E117", hash_generated_method = "8C2E01D621DE61593EB2CD95FBFA5A75")
    public final Context getContext() {
        Context varB4EAC82CA7396A68D541C85D26508E83_277073859 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_277073859 = mContext;
        varB4EAC82CA7396A68D541C85D26508E83_277073859.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_277073859;
        // ---------- Original Method ----------
        //return mContext;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.864 -0400", hash_original_method = "C738A12EDF7704A3BEC0DFE17330C819", hash_generated_method = "5E4FF5E477D8E19F78CD67B08931B74B")
    protected final void setReadPermission(String permission) {
        mReadPermission = permission;
        // ---------- Original Method ----------
        //mReadPermission = permission;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.873 -0400", hash_original_method = "5C94FD95ADD3C0054247C1BF6F500E4F", hash_generated_method = "0C266593AB0E4C1738AA96D8E72F48F4")
    public final String getReadPermission() {
        String varB4EAC82CA7396A68D541C85D26508E83_1325197158 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1325197158 = mReadPermission;
        varB4EAC82CA7396A68D541C85D26508E83_1325197158.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1325197158;
        // ---------- Original Method ----------
        //return mReadPermission;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.883 -0400", hash_original_method = "6A71B3652F16CF9160129E3EF306B0DC", hash_generated_method = "700C15F3C9EBC3D7B5D3FCF9D079867A")
    protected final void setWritePermission(String permission) {
        mWritePermission = permission;
        // ---------- Original Method ----------
        //mWritePermission = permission;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.886 -0400", hash_original_method = "7A0A16A9FA1EB10AD9D087C65A3EFFB1", hash_generated_method = "75A9BA8CAF427B728EA917E7336A8010")
    public final String getWritePermission() {
        String varB4EAC82CA7396A68D541C85D26508E83_729382095 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_729382095 = mWritePermission;
        varB4EAC82CA7396A68D541C85D26508E83_729382095.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_729382095;
        // ---------- Original Method ----------
        //return mWritePermission;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.887 -0400", hash_original_method = "16570AF799E31BB65FFA9254DA0AB517", hash_generated_method = "1CF8FB57421D0861F87CB9D1F6E697A3")
    protected final void setPathPermissions(PathPermission[] permissions) {
        mPathPermissions = permissions;
        // ---------- Original Method ----------
        //mPathPermissions = permissions;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.911 -0400", hash_original_method = "E38FFC0E115EF293B9FB9C6179B78AA8", hash_generated_method = "CFF2BC1C7341C95AB172F2069AB3BDC1")
    public final PathPermission[] getPathPermissions() {
        PathPermission[] varB4EAC82CA7396A68D541C85D26508E83_1387973837 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1387973837 = mPathPermissions;
        varB4EAC82CA7396A68D541C85D26508E83_1387973837.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1387973837;
        // ---------- Original Method ----------
        //return mPathPermissions;
    }

    
    public abstract boolean onCreate();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.912 -0400", hash_original_method = "8287235C28E9D1E310027A2DDEB95FCD", hash_generated_method = "BA7F1E69C22467D62A959775F321C0BA")
    public void onConfigurationChanged(Configuration newConfig) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(newConfig.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.913 -0400", hash_original_method = "4F0E380BE715BF5B2ECCDB1794C8905E", hash_generated_method = "39AEB8790734ECC8DC70BBAAEE0BAB0B")
    public void onLowMemory() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.929 -0400", hash_original_method = "3AE0D4ACEA3D5F3B779A378D5AB27A6A", hash_generated_method = "C1AFC91F30E138BA03233A690A40C0CC")
    public void onTrimMemory(int level) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(level);
        // ---------- Original Method ----------
    }

    
    public abstract Cursor query(Uri uri, String[] projection,
            String selection, String[] selectionArgs, String sortOrder);

    
    public abstract String getType(Uri uri);

    
    public abstract Uri insert(Uri uri, ContentValues values);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.933 -0400", hash_original_method = "C678349FF8875CB9D22305FF9A5474DD", hash_generated_method = "F5EEC96F2DD8BBB9A757043DB787B798")
    public int bulkInsert(Uri uri, ContentValues[] values) {
        int numValues;
        numValues = values.length;
        {
            int i;
            i = 0;
            {
                insert(uri, values[i]);
            } //End block
        } //End collapsed parenthetic
        addTaint(uri.getTaint());
        addTaint(values[0].getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1175210713 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1175210713;
        // ---------- Original Method ----------
        //int numValues = values.length;
        //for (int i = 0; i < numValues; i++) {
            //insert(uri, values[i]);
        //}
        //return numValues;
    }

    
    public abstract int delete(Uri uri, String selection, String[] selectionArgs);

    
    public abstract int update(Uri uri, ContentValues values, String selection,
            String[] selectionArgs);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.952 -0400", hash_original_method = "DCC5B23EAE3536B2EEFB8F5A1AA89B13", hash_generated_method = "F0E385AF3A2C7AAC1B33594FE9D3AABB")
    public ParcelFileDescriptor openFile(Uri uri, String mode) throws FileNotFoundException {
        if (DroidSafeAndroidRuntime.control) throw new FileNotFoundException("No files supported by provider at "
                + uri);
        addTaint(uri.getTaint());
        addTaint(mode.getTaint());
        // ---------- Original Method ----------
        //throw new FileNotFoundException("No files supported by provider at "
                //+ uri);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.959 -0400", hash_original_method = "58BEA9E66A4FD3FC19246F4A2CA5B928", hash_generated_method = "A71CB190AC44DDD521D7EDD3CE4A6277")
    public AssetFileDescriptor openAssetFile(Uri uri, String mode) throws FileNotFoundException {
        AssetFileDescriptor varB4EAC82CA7396A68D541C85D26508E83_25806809 = null; //Variable for return #1
        ParcelFileDescriptor fd;
        fd = openFile(uri, mode);
        varB4EAC82CA7396A68D541C85D26508E83_25806809 = fd != null ? new AssetFileDescriptor(fd, 0, -1) : null;
        addTaint(uri.getTaint());
        addTaint(mode.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_25806809.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_25806809;
        // ---------- Original Method ----------
        //ParcelFileDescriptor fd = openFile(uri, mode);
        //return fd != null ? new AssetFileDescriptor(fd, 0, -1) : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.987 -0400", hash_original_method = "B77C082B2FC41ABB2AC9CAAF0861BB6A", hash_generated_method = "206923F1F8976DAF25B2CC3AF69D7959")
    protected final ParcelFileDescriptor openFileHelper(Uri uri,
            String mode) throws FileNotFoundException {
        ParcelFileDescriptor varB4EAC82CA7396A68D541C85D26508E83_1561135252 = null; //Variable for return #1
        Cursor c;
        c = query(uri, new String[]{"_data"}, null, null, null);
        int count;
        count = c.getCount();
        count = 0;
        {
            {
                c.close();
            } //End block
            {
                if (DroidSafeAndroidRuntime.control) throw new FileNotFoundException("No entry for " + uri);
            } //End block
            if (DroidSafeAndroidRuntime.control) throw new FileNotFoundException("Multiple items at " + uri);
        } //End block
        c.moveToFirst();
        int i;
        i = c.getColumnIndex("_data");
        String path;
        path = (i >= 0 ? c.getString(i) : null);//DSFIXME:  CODE0008: Nested ternary operator in expression
        c.close();
        {
            if (DroidSafeAndroidRuntime.control) throw new FileNotFoundException("Column _data not found.");
        } //End block
        int modeBits;
        modeBits = ContentResolver.modeToMode(uri, mode);
        varB4EAC82CA7396A68D541C85D26508E83_1561135252 = ParcelFileDescriptor.open(new File(path), modeBits);
        addTaint(uri.getTaint());
        addTaint(mode.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1561135252.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1561135252;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.988 -0400", hash_original_method = "BEF8B956D915C9CD914319D11D9F55DF", hash_generated_method = "73BF788B608891F95DD569399342F595")
    public String[] getStreamTypes(Uri uri, String mimeTypeFilter) {
        String[] varB4EAC82CA7396A68D541C85D26508E83_339696846 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_339696846 = null;
        addTaint(uri.getTaint());
        addTaint(mimeTypeFilter.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_339696846.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_339696846;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.012 -0400", hash_original_method = "4E83B7632E2F0C6C101685B3A453F6C7", hash_generated_method = "340ADDE46B77D90CC3DB33AEBF2763E0")
    public AssetFileDescriptor openTypedAssetFile(Uri uri, String mimeTypeFilter, Bundle opts) throws FileNotFoundException {
        AssetFileDescriptor varB4EAC82CA7396A68D541C85D26508E83_605001430 = null; //Variable for return #1
        AssetFileDescriptor varB4EAC82CA7396A68D541C85D26508E83_1282240032 = null; //Variable for return #2
        {
            boolean var4C01B825A6B874B80EFDC93B5CFAC70D_815412834 = ("*/*".equals(mimeTypeFilter));
            {
                varB4EAC82CA7396A68D541C85D26508E83_605001430 = openAssetFile(uri, "r");
            } //End block
        } //End collapsed parenthetic
        String baseType;
        baseType = getType(uri);
        {
            boolean var0B401450AF28FAA821E202DA316A98D6_544895419 = (baseType != null && ClipDescription.compareMimeTypes(baseType, mimeTypeFilter));
            {
                varB4EAC82CA7396A68D541C85D26508E83_1282240032 = openAssetFile(uri, "r");
            } //End block
        } //End collapsed parenthetic
        if (DroidSafeAndroidRuntime.control) throw new FileNotFoundException("Can't open " + uri + " as type " + mimeTypeFilter);
        addTaint(uri.getTaint());
        addTaint(mimeTypeFilter.getTaint());
        addTaint(opts.getTaint());
        AssetFileDescriptor varA7E53CE21691AB073D9660D615818899_1481877448; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1481877448 = varB4EAC82CA7396A68D541C85D26508E83_605001430;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1481877448 = varB4EAC82CA7396A68D541C85D26508E83_1282240032;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1481877448.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1481877448;
        // ---------- Original Method ----------
        //if ("*/*".equals(mimeTypeFilter)) {
            //return openAssetFile(uri, "r");
        //}
        //String baseType = getType(uri);
        //if (baseType != null && ClipDescription.compareMimeTypes(baseType, mimeTypeFilter)) {
            //return openAssetFile(uri, "r");
        //}
        //throw new FileNotFoundException("Can't open " + uri + " as type " + mimeTypeFilter);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.013 -0400", hash_original_method = "BC63CE555A1B156ABB3D2B022F0E90CE", hash_generated_method = "A41BDF898F7012C6B71E0A66B151EE80")
    public <T> ParcelFileDescriptor openPipeHelper(final Uri uri, final String mimeType,
            final Bundle opts, final T args, final PipeDataWriter<T> func) throws FileNotFoundException {
        ParcelFileDescriptor varB4EAC82CA7396A68D541C85D26508E83_911275854 = null; //Variable for return #1
        try 
        {
            ParcelFileDescriptor[] fds;
            fds = ParcelFileDescriptor.createPipe();
            AsyncTask<Object, Object, Object> task;
            task = new AsyncTask<Object, Object, Object>() {
                @Override
                protected Object doInBackground(Object... params) {
                    func.writeDataToPipe(fds[1], uri, mimeType, opts, args);
                    try {
                        fds[1].close();
                    } catch (IOException e) {
                        Log.w(TAG, "Failure closing pipe", e);
                    }
                    return null;
                }
            };
            task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, (Object[])null);
            varB4EAC82CA7396A68D541C85D26508E83_911275854 = fds[0];
        } //End block
        catch (IOException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new FileNotFoundException("failure making pipe");
        } //End block
        addTaint(uri.getTaint());
        addTaint(mimeType.getTaint());
        addTaint(opts.getTaint());
        addTaint(args.getTaint());
        addTaint(func.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_911275854.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_911275854;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.019 -0400", hash_original_method = "5727E4CF3A64759CEEBA62DE047537C3", hash_generated_method = "12F1F53EB2EBA91BC505CB1720FECAC9")
    protected boolean isTemporary() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1520303186 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1520303186;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.036 -0400", hash_original_method = "883A061900350051FBA62F6F6FD9E085", hash_generated_method = "CDB18AD4203D6F621E10F3690539B295")
    public IContentProvider getIContentProvider() {
        IContentProvider varB4EAC82CA7396A68D541C85D26508E83_2074253775 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2074253775 = mTransport;
        varB4EAC82CA7396A68D541C85D26508E83_2074253775.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2074253775;
        // ---------- Original Method ----------
        //return mTransport;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.047 -0400", hash_original_method = "0A143494E98F1D73DE768E656190D91A", hash_generated_method = "B0B0127074730EBBA3233ED75AD752D2")
    public void attachInfo(Context context, ProviderInfo info) {
        AsyncTask.init();
        {
            mContext = context;
            mMyUid = Process.myUid();
            {
                setReadPermission(info.readPermission);
                setWritePermission(info.writePermission);
                setPathPermissions(info.pathPermissions);
                mExported = info.exported;
            } //End block
            ContentProvider.this.onCreate();
        } //End block
        // ---------- Original Method ----------
        //AsyncTask.init();
        //if (mContext == null) {
            //mContext = context;
            //mMyUid = Process.myUid();
            //if (info != null) {
                //setReadPermission(info.readPermission);
                //setWritePermission(info.writePermission);
                //setPathPermissions(info.pathPermissions);
                //mExported = info.exported;
            //}
            //ContentProvider.this.onCreate();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.049 -0400", hash_original_method = "E0DAC3050A9BAD12465D5076F1EE0420", hash_generated_method = "4A309A97EE29A3E4C62E63C5C33B8492")
    public ContentProviderResult[] applyBatch(ArrayList<ContentProviderOperation> operations) throws OperationApplicationException {
        ContentProviderResult[] varB4EAC82CA7396A68D541C85D26508E83_1804372802 = null; //Variable for return #1
        int numOperations;
        numOperations = operations.size();
        ContentProviderResult[] results;
        results = new ContentProviderResult[numOperations];
        {
            int i;
            i = 0;
            {
                results[i] = operations.get(i).apply(this, results, i);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1804372802 = results;
        addTaint(operations.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1804372802.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1804372802;
        // ---------- Original Method ----------
        //final int numOperations = operations.size();
        //final ContentProviderResult[] results = new ContentProviderResult[numOperations];
        //for (int i = 0; i < numOperations; i++) {
            //results[i] = operations.get(i).apply(this, results, i);
        //}
        //return results;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.072 -0400", hash_original_method = "FDEF25FCA992321C96D9ED3D525FD124", hash_generated_method = "5A3A2F97A3165572CCC101057483C6F9")
    public Bundle call(String method, String arg, Bundle extras) {
        Bundle varB4EAC82CA7396A68D541C85D26508E83_910660889 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_910660889 = null;
        addTaint(method.getTaint());
        addTaint(arg.getTaint());
        addTaint(extras.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_910660889.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_910660889;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.073 -0400", hash_original_method = "D03BEE67B09D4B1E8C6E9290C7758C5F", hash_generated_method = "B150A4E1DC19A0FA6E8508D3F3E8E47D")
    public void shutdown() {
        // ---------- Original Method ----------
        //Log.w(TAG, "implement ContentProvider shutdown() to make sure all database " +
                //"connections are gracefully shutdown");
    }

    
    class Transport extends ContentProviderNative {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.074 -0400", hash_original_method = "E8AA98EC6BE3CDFD6C8382F7CC9C6C6F", hash_generated_method = "E8AA98EC6BE3CDFD6C8382F7CC9C6C6F")
        public Transport ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.080 -0400", hash_original_method = "D85CC82248E7B34649DA1C02380D9E2C", hash_generated_method = "A883532332FB4DC80231811E0BE1D0F0")
         ContentProvider getContentProvider() {
            ContentProvider varB4EAC82CA7396A68D541C85D26508E83_614354000 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_614354000 = ContentProvider.this;
            varB4EAC82CA7396A68D541C85D26508E83_614354000.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_614354000;
            // ---------- Original Method ----------
            //return ContentProvider.this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.103 -0400", hash_original_method = "157A3AC2CED86E999B16E7CDFBD5AE31", hash_generated_method = "F06614D6AA0A8DFB677A91CC611CBD21")
        @Override
        public String getProviderName() {
            String varB4EAC82CA7396A68D541C85D26508E83_1653893466 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1653893466 = getContentProvider().getClass().getName();
            varB4EAC82CA7396A68D541C85D26508E83_1653893466.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1653893466;
            // ---------- Original Method ----------
            //return getContentProvider().getClass().getName();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.105 -0400", hash_original_method = "C07C2CC52F2EA8ADD199B18CF964D47B", hash_generated_method = "858114F4783DB9C144EFD941F757D286")
        public Cursor query(Uri uri, String[] projection,
                String selection, String[] selectionArgs, String sortOrder) {
            Cursor varB4EAC82CA7396A68D541C85D26508E83_1506543170 = null; //Variable for return #1
            enforceReadPermission(uri);
            varB4EAC82CA7396A68D541C85D26508E83_1506543170 = ContentProvider.this.query(uri, projection, selection,
                    selectionArgs, sortOrder);
            addTaint(uri.getTaint());
            addTaint(projection[0].getTaint());
            addTaint(selection.getTaint());
            addTaint(selectionArgs[0].getTaint());
            addTaint(sortOrder.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1506543170.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1506543170;
            // ---------- Original Method ----------
            //enforceReadPermission(uri);
            //return ContentProvider.this.query(uri, projection, selection,
                    //selectionArgs, sortOrder);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.117 -0400", hash_original_method = "BE9D1875DBA635C7BA04B42A3E893DA2", hash_generated_method = "D2F825D2DDDC3E81ABC110AD22056F94")
        public String getType(Uri uri) {
            String varB4EAC82CA7396A68D541C85D26508E83_2103635898 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_2103635898 = ContentProvider.this.getType(uri);
            addTaint(uri.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_2103635898.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2103635898;
            // ---------- Original Method ----------
            //return ContentProvider.this.getType(uri);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.118 -0400", hash_original_method = "2D883DF9190F17ADC9F3F05EDAD4CA9E", hash_generated_method = "243EAD949E65D2136EC8602F3FAC67E3")
        public Uri insert(Uri uri, ContentValues initialValues) {
            Uri varB4EAC82CA7396A68D541C85D26508E83_2144644257 = null; //Variable for return #1
            enforceWritePermission(uri);
            varB4EAC82CA7396A68D541C85D26508E83_2144644257 = ContentProvider.this.insert(uri, initialValues);
            addTaint(uri.getTaint());
            addTaint(initialValues.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_2144644257.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2144644257;
            // ---------- Original Method ----------
            //enforceWritePermission(uri);
            //return ContentProvider.this.insert(uri, initialValues);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.120 -0400", hash_original_method = "9C9FBE82EEDFD6251BF8F9B258727CC2", hash_generated_method = "AAFF379FB178143CF14CE6D947DBE0BF")
        public int bulkInsert(Uri uri, ContentValues[] initialValues) {
            enforceWritePermission(uri);
            int var356BE9FE6F30A259688B8E3862579DF5_674291305 = (ContentProvider.this.bulkInsert(uri, initialValues));
            addTaint(uri.getTaint());
            addTaint(initialValues[0].getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1563159609 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1563159609;
            // ---------- Original Method ----------
            //enforceWritePermission(uri);
            //return ContentProvider.this.bulkInsert(uri, initialValues);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.302 -0400", hash_original_method = "8198345EE7E6B486A1CABFB05410D25E", hash_generated_method = "B256F2128DBC7AD535CDE11ED18E370B")
        public ContentProviderResult[] applyBatch(ArrayList<ContentProviderOperation> operations) throws OperationApplicationException {
            ContentProviderResult[] varB4EAC82CA7396A68D541C85D26508E83_1939576076 = null; //Variable for return #1
            {
                Iterator<ContentProviderOperation> varE9602D9F0CB9F920ADAA80E0AEDB4F89_547343806 = (operations).iterator();
                varE9602D9F0CB9F920ADAA80E0AEDB4F89_547343806.hasNext();
                ContentProviderOperation operation = varE9602D9F0CB9F920ADAA80E0AEDB4F89_547343806.next();
                {
                    {
                        boolean var648C2431FEB36CA6BCD4B44ED4DEFABF_1060268343 = (operation.isReadOperation());
                        {
                            enforceReadPermission(operation.getUri());
                        } //End block
                    } //End collapsed parenthetic
                    {
                        boolean var76F7573D9527D4C4854BC03A7AAE3020_1160004887 = (operation.isWriteOperation());
                        {
                            enforceWritePermission(operation.getUri());
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_1939576076 = ContentProvider.this.applyBatch(operations);
            addTaint(operations.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1939576076.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1939576076;
            // ---------- Original Method ----------
            //for (ContentProviderOperation operation : operations) {
                //if (operation.isReadOperation()) {
                    //enforceReadPermission(operation.getUri());
                //}
                //if (operation.isWriteOperation()) {
                    //enforceWritePermission(operation.getUri());
                //}
            //}
            //return ContentProvider.this.applyBatch(operations);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.304 -0400", hash_original_method = "9F536F247E1CDAAB23A0513292709CB1", hash_generated_method = "3495F06734BB53571D29B3D0294A3A0E")
        public int delete(Uri uri, String selection, String[] selectionArgs) {
            enforceWritePermission(uri);
            int var139826D116DF5B4480C4A435A77A7184_845454827 = (ContentProvider.this.delete(uri, selection, selectionArgs));
            addTaint(uri.getTaint());
            addTaint(selection.getTaint());
            addTaint(selectionArgs[0].getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_565544221 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_565544221;
            // ---------- Original Method ----------
            //enforceWritePermission(uri);
            //return ContentProvider.this.delete(uri, selection, selectionArgs);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.306 -0400", hash_original_method = "A4C580D76A4BE435F05FDF3658D031E7", hash_generated_method = "0F3FC391A47AB6AD7E07BA0EF9F4D770")
        public int update(Uri uri, ContentValues values, String selection,
                String[] selectionArgs) {
            enforceWritePermission(uri);
            int varA1651BA01E90DA8CC721F5ADFBEC3CCE_1914177177 = (ContentProvider.this.update(uri, values, selection, selectionArgs));
            addTaint(uri.getTaint());
            addTaint(values.getTaint());
            addTaint(selection.getTaint());
            addTaint(selectionArgs[0].getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_580033450 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_580033450;
            // ---------- Original Method ----------
            //enforceWritePermission(uri);
            //return ContentProvider.this.update(uri, values, selection, selectionArgs);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.320 -0400", hash_original_method = "A3B5DD3A6EF0BED7F3109E14959CA5EF", hash_generated_method = "1BA433EECB303484F2EE0CDFD757D075")
        public ParcelFileDescriptor openFile(Uri uri, String mode) throws FileNotFoundException {
            ParcelFileDescriptor varB4EAC82CA7396A68D541C85D26508E83_373162130 = null; //Variable for return #1
            {
                boolean var990C6E0E8CA37484AEEB3E9453431412_819700793 = (mode != null && mode.startsWith("rw"));
                enforceWritePermission(uri);
                enforceReadPermission(uri);
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_373162130 = ContentProvider.this.openFile(uri, mode);
            addTaint(uri.getTaint());
            addTaint(mode.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_373162130.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_373162130;
            // ---------- Original Method ----------
            //if (mode != null && mode.startsWith("rw")) enforceWritePermission(uri);
            //else enforceReadPermission(uri);
            //return ContentProvider.this.openFile(uri, mode);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.346 -0400", hash_original_method = "9FC3CF0D01502503E6A8E959789D91E0", hash_generated_method = "CE4FA7245404E061DB1D17EE1F6C2412")
        public AssetFileDescriptor openAssetFile(Uri uri, String mode) throws FileNotFoundException {
            AssetFileDescriptor varB4EAC82CA7396A68D541C85D26508E83_1229637247 = null; //Variable for return #1
            {
                boolean var990C6E0E8CA37484AEEB3E9453431412_635078756 = (mode != null && mode.startsWith("rw"));
                enforceWritePermission(uri);
                enforceReadPermission(uri);
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_1229637247 = ContentProvider.this.openAssetFile(uri, mode);
            addTaint(uri.getTaint());
            addTaint(mode.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1229637247.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1229637247;
            // ---------- Original Method ----------
            //if (mode != null && mode.startsWith("rw")) enforceWritePermission(uri);
            //else enforceReadPermission(uri);
            //return ContentProvider.this.openAssetFile(uri, mode);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.358 -0400", hash_original_method = "F8D45B029854B0071CB25BB646C6653D", hash_generated_method = "8A3138D918A96CC5254703ACA7DEF357")
        public Bundle call(String method, String arg, Bundle extras) {
            Bundle varB4EAC82CA7396A68D541C85D26508E83_1188295635 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1188295635 = ContentProvider.this.call(method, arg, extras);
            addTaint(method.getTaint());
            addTaint(arg.getTaint());
            addTaint(extras.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1188295635.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1188295635;
            // ---------- Original Method ----------
            //return ContentProvider.this.call(method, arg, extras);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.372 -0400", hash_original_method = "8E1F3128EE5808B485D05EE809576B99", hash_generated_method = "AB786D0FF1466EA4C9270786117834EC")
        @Override
        public String[] getStreamTypes(Uri uri, String mimeTypeFilter) {
            String[] varB4EAC82CA7396A68D541C85D26508E83_1316920619 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1316920619 = ContentProvider.this.getStreamTypes(uri, mimeTypeFilter);
            addTaint(uri.getTaint());
            addTaint(mimeTypeFilter.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1316920619.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1316920619;
            // ---------- Original Method ----------
            //return ContentProvider.this.getStreamTypes(uri, mimeTypeFilter);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.373 -0400", hash_original_method = "C18E75C38B25261EF8CFA8F7B83C6E2D", hash_generated_method = "70A837103455E7D50DD7993E68335670")
        @Override
        public AssetFileDescriptor openTypedAssetFile(Uri uri, String mimeType, Bundle opts) throws FileNotFoundException {
            AssetFileDescriptor varB4EAC82CA7396A68D541C85D26508E83_1923940174 = null; //Variable for return #1
            enforceReadPermission(uri);
            varB4EAC82CA7396A68D541C85D26508E83_1923940174 = ContentProvider.this.openTypedAssetFile(uri, mimeType, opts);
            addTaint(uri.getTaint());
            addTaint(mimeType.getTaint());
            addTaint(opts.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1923940174.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1923940174;
            // ---------- Original Method ----------
            //enforceReadPermission(uri);
            //return ContentProvider.this.openTypedAssetFile(uri, mimeType, opts);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.390 -0400", hash_original_method = "E57399204B1619B526E92C84388A407F", hash_generated_method = "BEDA38A5EC81B56D33C3D66430FAFE2A")
        private void enforceReadPermission(Uri uri) {
            int uid;
            uid = Binder.getCallingUid();
            Context context;
            context = getContext();
            String rperm;
            rperm = getReadPermission();
            int pid;
            pid = Binder.getCallingPid();
            {
                boolean var11ABD9D7DE204BDD0582E9A702BF61D0_1668773796 = (mExported && (rperm == null
                    || context.checkPermission(rperm, pid, uid)
                    == PackageManager.PERMISSION_GRANTED));
            } //End collapsed parenthetic
            PathPermission[] pps;
            pps = getPathPermissions();
            {
                String path;
                path = uri.getPath();
                int i;
                i = pps.length;
                {
                    PathPermission pp;
                    pp = pps[i];
                    String pprperm;
                    pprperm = pp.getReadPermission();
                    {
                        boolean var8BB21B2E5376BD16A5FBA892743AFFA3_345325087 = (pprperm != null && pp.match(path));
                        {
                            {
                                boolean var02C738C973D4432B9D925BA7105A8603_1547830900 = (context.checkPermission(pprperm, pid, uid)
                                == PackageManager.PERMISSION_GRANTED);
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End block
            {
                boolean var13E8497132730133410D53B1797E5D75_1094703219 = (context.checkUriPermission(uri, pid, uid,
                    Intent.FLAG_GRANT_READ_URI_PERMISSION)
                    == PackageManager.PERMISSION_GRANTED);
            } //End collapsed parenthetic
            String msg;
            msg = "Permission Denial: reading "
                    + ContentProvider.this.getClass().getName()
                    + " uri " + uri + " from pid=" + Binder.getCallingPid()
                    + ", uid=" + Binder.getCallingUid()
                    + " requires " + rperm;
            if (DroidSafeAndroidRuntime.control) throw new SecurityException(msg);
            addTaint(uri.getTaint());
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.406 -0400", hash_original_method = "329C06E4068EEDF4ECCAEC3BA5AB45CE", hash_generated_method = "BFEF89B096699C48A8017398B85575B5")
        private boolean hasWritePermission(Uri uri) {
            int uid;
            uid = Binder.getCallingUid();
            Context context;
            context = getContext();
            String wperm;
            wperm = getWritePermission();
            int pid;
            pid = Binder.getCallingPid();
            {
                boolean var87DDA52804F18883BB0B0CEC23D0EDFD_567526194 = (mExported && (wperm == null
                    || context.checkPermission(wperm, pid, uid)
                    == PackageManager.PERMISSION_GRANTED));
            } //End collapsed parenthetic
            PathPermission[] pps;
            pps = getPathPermissions();
            {
                String path;
                path = uri.getPath();
                int i;
                i = pps.length;
                {
                    PathPermission pp;
                    pp = pps[i];
                    String ppwperm;
                    ppwperm = pp.getWritePermission();
                    {
                        boolean var34B7F3F44D970AFAF42A1A9113878492_1900510321 = (ppwperm != null && pp.match(path));
                        {
                            {
                                boolean var635E8626A3F8934298FFDD63E2789994_191199670 = (context.checkPermission(ppwperm, pid, uid)
                                == PackageManager.PERMISSION_GRANTED);
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End block
            {
                boolean var88D202BB8B1056D8C1A0EE22D8D71A13_1864331356 = (context.checkUriPermission(uri, pid, uid,
                    Intent.FLAG_GRANT_WRITE_URI_PERMISSION)
                    == PackageManager.PERMISSION_GRANTED);
            } //End collapsed parenthetic
            addTaint(uri.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_412941185 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_412941185;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.415 -0400", hash_original_method = "7CEC600BB70206A61DA89C0C0D2014C1", hash_generated_method = "E39B1D665AFF60EA5E7D9D7C94E371A6")
        private void enforceWritePermission(Uri uri) {
            {
                boolean var24C3F28B334AD89BB610904621BC7375_543525545 = (hasWritePermission(uri));
            } //End collapsed parenthetic
            String msg;
            msg = "Permission Denial: writing "
                    + ContentProvider.this.getClass().getName()
                    + " uri " + uri + " from pid=" + Binder.getCallingPid()
                    + ", uid=" + Binder.getCallingUid()
                    + " requires " + getWritePermission();
            if (DroidSafeAndroidRuntime.control) throw new SecurityException(msg);
            addTaint(uri.getTaint());
            // ---------- Original Method ----------
            //if (hasWritePermission(uri)) {
                //return;
            //}
            //String msg = "Permission Denial: writing "
                    //+ ContentProvider.this.getClass().getName()
                    //+ " uri " + uri + " from pid=" + Binder.getCallingPid()
                    //+ ", uid=" + Binder.getCallingUid()
                    //+ " requires " + getWritePermission();
            //throw new SecurityException(msg);
        }

        
    }


    
    public interface PipeDataWriter<T> {
        
        public void writeDataToPipe(ParcelFileDescriptor output, Uri uri, String mimeType,
                Bundle opts, T args);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.416 -0400", hash_original_field = "D9DEAD4FE5612F0F829FC72D942CF904", hash_generated_field = "F9B6CF50A3968BFD24779BA47C347A53")

    private static String TAG = "ContentProvider";
}

