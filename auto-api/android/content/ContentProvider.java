package android.content;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.339 -0400", hash_original_field = "EC9A3144C1687F6FFFFC7AC4B8A997AD", hash_generated_field = "64C2E29345D1A72D78C884235FF4120B")

    private Context mContext = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.339 -0400", hash_original_field = "2C2F002F67CB0ABAF6E9BE038FA0C0A5", hash_generated_field = "BAE02AD4841B16814759F68D3AA9D00B")

    private int mMyUid;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.339 -0400", hash_original_field = "3805826D63CBE0EFB018A286F189CC44", hash_generated_field = "F91CBC541AE5EA168107190D1A494CD8")

    private String mReadPermission;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.339 -0400", hash_original_field = "EA3BA31BE3E977A5CA4A690ADA101637", hash_generated_field = "02101D3B9ECFAAEB0689EF2DAEF4A808")

    private String mWritePermission;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.339 -0400", hash_original_field = "00F4643DBE3AE1276B44E74500631096", hash_generated_field = "15E0F7E05B281A905081D65ED9192FDD")

    private PathPermission[] mPathPermissions;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.339 -0400", hash_original_field = "5DCBFC76DAEB92A3E3FD1528EAC8DAB3", hash_generated_field = "5F31C09AB3C1B6A6E2600C83F2928ABF")

    private boolean mExported;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.339 -0400", hash_original_field = "E1D0BDA9D633EC3C8F88DD17C08825F1", hash_generated_field = "B996B8C49C2307FDF0CA3803832CA9DC")

    private Transport mTransport = new Transport();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.340 -0400", hash_original_method = "F039A73ADD81439EFEE4572A926905FF", hash_generated_method = "AE9E67C0D421B97975CBD6F5E7DAC5C3")
    public  ContentProvider() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.340 -0400", hash_original_method = "40393AF8078D8D6FEE29B00460ADF530", hash_generated_method = "1AEE9CFE935A08AC9F4B6B91141A98D6")
    public  ContentProvider(
            Context context,
            String readPermission,
            String writePermission,
            PathPermission[] pathPermissions) {
        mContext = context;
        mReadPermission = readPermission;
        mWritePermission = writePermission;
        mPathPermissions = pathPermissions;
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    public static ContentProvider coerceToLocalContentProvider(
            IContentProvider abstractInterface) {
        if (abstractInterface instanceof Transport) {
            return ((Transport)abstractInterface).getContentProvider();
        }
        return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.341 -0400", hash_original_method = "4F4EBC54D108D66F416C93B46580E117", hash_generated_method = "CE44610C369E6C0E7F7D982C1E0603A8")
    public final Context getContext() {
        Context varB4EAC82CA7396A68D541C85D26508E83_1799162595 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1799162595 = mContext;
        varB4EAC82CA7396A68D541C85D26508E83_1799162595.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1799162595;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.342 -0400", hash_original_method = "C738A12EDF7704A3BEC0DFE17330C819", hash_generated_method = "5E4FF5E477D8E19F78CD67B08931B74B")
    protected final void setReadPermission(String permission) {
        mReadPermission = permission;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.343 -0400", hash_original_method = "5C94FD95ADD3C0054247C1BF6F500E4F", hash_generated_method = "D39DFEB733D8AFA705E2196032B15225")
    public final String getReadPermission() {
        String varB4EAC82CA7396A68D541C85D26508E83_90295242 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_90295242 = mReadPermission;
        varB4EAC82CA7396A68D541C85D26508E83_90295242.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_90295242;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.343 -0400", hash_original_method = "6A71B3652F16CF9160129E3EF306B0DC", hash_generated_method = "700C15F3C9EBC3D7B5D3FCF9D079867A")
    protected final void setWritePermission(String permission) {
        mWritePermission = permission;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.344 -0400", hash_original_method = "7A0A16A9FA1EB10AD9D087C65A3EFFB1", hash_generated_method = "41FA4082D55D729A951F6F2A3770B1DD")
    public final String getWritePermission() {
        String varB4EAC82CA7396A68D541C85D26508E83_1807923361 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1807923361 = mWritePermission;
        varB4EAC82CA7396A68D541C85D26508E83_1807923361.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1807923361;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.345 -0400", hash_original_method = "16570AF799E31BB65FFA9254DA0AB517", hash_generated_method = "1CF8FB57421D0861F87CB9D1F6E697A3")
    protected final void setPathPermissions(PathPermission[] permissions) {
        mPathPermissions = permissions;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.345 -0400", hash_original_method = "E38FFC0E115EF293B9FB9C6179B78AA8", hash_generated_method = "FFC998A5B7877B8727525DFC08B3CA88")
    public final PathPermission[] getPathPermissions() {
        PathPermission[] varB4EAC82CA7396A68D541C85D26508E83_867714524 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_867714524 = mPathPermissions;
        varB4EAC82CA7396A68D541C85D26508E83_867714524.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_867714524;
        
        
    }

    
    public abstract boolean onCreate();

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.346 -0400", hash_original_method = "8287235C28E9D1E310027A2DDEB95FCD", hash_generated_method = "BA7F1E69C22467D62A959775F321C0BA")
    public void onConfigurationChanged(Configuration newConfig) {
        
        addTaint(newConfig.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.346 -0400", hash_original_method = "4F0E380BE715BF5B2ECCDB1794C8905E", hash_generated_method = "39AEB8790734ECC8DC70BBAAEE0BAB0B")
    public void onLowMemory() {
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.346 -0400", hash_original_method = "3AE0D4ACEA3D5F3B779A378D5AB27A6A", hash_generated_method = "C1AFC91F30E138BA03233A690A40C0CC")
    public void onTrimMemory(int level) {
        
        addTaint(level);
        
    }

    
    public abstract Cursor query(Uri uri, String[] projection,
            String selection, String[] selectionArgs, String sortOrder);

    
    public abstract String getType(Uri uri);

    
    public abstract Uri insert(Uri uri, ContentValues values);

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.347 -0400", hash_original_method = "C678349FF8875CB9D22305FF9A5474DD", hash_generated_method = "1A9306EDB355255CF051ABA4546E09F0")
    public int bulkInsert(Uri uri, ContentValues[] values) {
        int numValues = values.length;
        {
            int i = 0;
            {
                insert(uri, values[i]);
            } 
        } 
        addTaint(uri.getTaint());
        addTaint(values[0].getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2044702471 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2044702471;
        
        
        
            
        
        
    }

    
    public abstract int delete(Uri uri, String selection, String[] selectionArgs);

    
    public abstract int update(Uri uri, ContentValues values, String selection,
            String[] selectionArgs);

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.952 -0400", hash_original_method = "DCC5B23EAE3536B2EEFB8F5A1AA89B13", hash_generated_method = "F0E385AF3A2C7AAC1B33594FE9D3AABB")
    public ParcelFileDescriptor openFile(Uri uri, String mode) throws FileNotFoundException {
    	throw new FileNotFoundException("No files supported by provider at "
                + uri);
        
        
                
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.349 -0400", hash_original_method = "58BEA9E66A4FD3FC19246F4A2CA5B928", hash_generated_method = "E2FE7B71DF893DFBE2E8AB984768A07D")
    public AssetFileDescriptor openAssetFile(Uri uri, String mode) throws FileNotFoundException {
        AssetFileDescriptor varB4EAC82CA7396A68D541C85D26508E83_1546008861 = null; 
        ParcelFileDescriptor fd = openFile(uri, mode);
        varB4EAC82CA7396A68D541C85D26508E83_1546008861 = fd != null ? new AssetFileDescriptor(fd, 0, -1) : null;
        addTaint(uri.getTaint());
        addTaint(mode.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1546008861.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1546008861;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.350 -0400", hash_original_method = "B77C082B2FC41ABB2AC9CAAF0861BB6A", hash_generated_method = "75A04885CA84C92984326E284F7271BF")
    protected final ParcelFileDescriptor openFileHelper(Uri uri,
            String mode) throws FileNotFoundException {
        ParcelFileDescriptor varB4EAC82CA7396A68D541C85D26508E83_2020074063 = null; 
        Cursor c = query(uri, new String[]{"_data"}, null, null, null);
        int count;
        count = c.getCount();
        count = 0;
        {
            {
                c.close();
            } 
            {
                if (DroidSafeAndroidRuntime.control) throw new FileNotFoundException("No entry for " + uri);
            } 
            if (DroidSafeAndroidRuntime.control) throw new FileNotFoundException("Multiple items at " + uri);
        } 
        c.moveToFirst();
        int i = c.getColumnIndex("_data");
        String path = (i >= 0 ? c.getString(i) : null);
        c.close();
        {
            if (DroidSafeAndroidRuntime.control) throw new FileNotFoundException("Column _data not found.");
        } 
        int modeBits = ContentResolver.modeToMode(uri, mode);
        varB4EAC82CA7396A68D541C85D26508E83_2020074063 = ParcelFileDescriptor.open(new File(path), modeBits);
        addTaint(uri.getTaint());
        addTaint(mode.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2020074063.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2020074063;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.351 -0400", hash_original_method = "BEF8B956D915C9CD914319D11D9F55DF", hash_generated_method = "3D7B6A8418C227F424DED7514949ADD0")
    public String[] getStreamTypes(Uri uri, String mimeTypeFilter) {
        String[] varB4EAC82CA7396A68D541C85D26508E83_1523772123 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1523772123 = null;
        addTaint(uri.getTaint());
        addTaint(mimeTypeFilter.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1523772123.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1523772123;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.352 -0400", hash_original_method = "4E83B7632E2F0C6C101685B3A453F6C7", hash_generated_method = "56D0C056D21B4FD4910A9FFFDF9970DB")
    public AssetFileDescriptor openTypedAssetFile(Uri uri, String mimeTypeFilter, Bundle opts) throws FileNotFoundException {
        AssetFileDescriptor varB4EAC82CA7396A68D541C85D26508E83_495536272 = null; 
        AssetFileDescriptor varB4EAC82CA7396A68D541C85D26508E83_1582947068 = null; 
        {
            boolean var4C01B825A6B874B80EFDC93B5CFAC70D_1301690093 = ("*/*".equals(mimeTypeFilter));
            {
                varB4EAC82CA7396A68D541C85D26508E83_495536272 = openAssetFile(uri, "r");
            } 
        } 
        String baseType = getType(uri);
        {
            boolean var0B401450AF28FAA821E202DA316A98D6_1142197979 = (baseType != null && ClipDescription.compareMimeTypes(baseType, mimeTypeFilter));
            {
                varB4EAC82CA7396A68D541C85D26508E83_1582947068 = openAssetFile(uri, "r");
            } 
        } 
        if (DroidSafeAndroidRuntime.control) throw new FileNotFoundException("Can't open " + uri + " as type " + mimeTypeFilter);
        addTaint(uri.getTaint());
        addTaint(mimeTypeFilter.getTaint());
        addTaint(opts.getTaint());
        AssetFileDescriptor varA7E53CE21691AB073D9660D615818899_889956163; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_889956163 = varB4EAC82CA7396A68D541C85D26508E83_495536272;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_889956163 = varB4EAC82CA7396A68D541C85D26508E83_1582947068;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_889956163.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_889956163;
        
        
            
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.013 -0400", hash_original_method = "BC63CE555A1B156ABB3D2B022F0E90CE", hash_generated_method = "A41BDF898F7012C6B71E0A66B151EE80")
    public <T> ParcelFileDescriptor openPipeHelper(final Uri uri, final String mimeType,
            final Bundle opts, final T args, final PipeDataWriter<T> func) throws FileNotFoundException {
        ParcelFileDescriptor varB4EAC82CA7396A68D541C85D26508E83_911275854 = null; 
        try 
        {
            final ParcelFileDescriptor[] fds;
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
        } 
        catch (IOException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new FileNotFoundException("failure making pipe");
        } 
        addTaint(uri.getTaint());
        addTaint(mimeType.getTaint());
        addTaint(opts.getTaint());
        addTaint(args.getTaint());
        addTaint(func.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_911275854.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_911275854;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.353 -0400", hash_original_method = "5727E4CF3A64759CEEBA62DE047537C3", hash_generated_method = "C04B76D530B22E25019680A9EE63C6F8")
    protected boolean isTemporary() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1698133992 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1698133992;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.355 -0400", hash_original_method = "883A061900350051FBA62F6F6FD9E085", hash_generated_method = "E46DBFD2C7C44B521F77AEDFF13AFFBB")
    public IContentProvider getIContentProvider() {
        IContentProvider varB4EAC82CA7396A68D541C85D26508E83_1316038692 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1316038692 = mTransport;
        varB4EAC82CA7396A68D541C85D26508E83_1316038692.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1316038692;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.356 -0400", hash_original_method = "0A143494E98F1D73DE768E656190D91A", hash_generated_method = "B0B0127074730EBBA3233ED75AD752D2")
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
            } 
            ContentProvider.this.onCreate();
        } 
        
        
        
            
            
            
                
                
                
                
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.357 -0400", hash_original_method = "E0DAC3050A9BAD12465D5076F1EE0420", hash_generated_method = "A7ADFDD023688DB1771C71CA30FAFE27")
    public ContentProviderResult[] applyBatch(ArrayList<ContentProviderOperation> operations) throws OperationApplicationException {
        ContentProviderResult[] varB4EAC82CA7396A68D541C85D26508E83_432541459 = null; 
        final int numOperations = operations.size();
        final ContentProviderResult[] results = new ContentProviderResult[numOperations];
        {
            int i = 0;
            {
                results[i] = operations.get(i).apply(this, results, i);
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_432541459 = results;
        addTaint(operations.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_432541459.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_432541459;
        
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.358 -0400", hash_original_method = "FDEF25FCA992321C96D9ED3D525FD124", hash_generated_method = "0A0BAD4C2A21828DF7A35865E49257E9")
    public Bundle call(String method, String arg, Bundle extras) {
        Bundle varB4EAC82CA7396A68D541C85D26508E83_1918143643 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1918143643 = null;
        addTaint(method.getTaint());
        addTaint(arg.getTaint());
        addTaint(extras.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1918143643.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1918143643;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.358 -0400", hash_original_method = "D03BEE67B09D4B1E8C6E9290C7758C5F", hash_generated_method = "B150A4E1DC19A0FA6E8508D3F3E8E47D")
    public void shutdown() {
        
        
                
    }

    
    class Transport extends ContentProviderNative {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.359 -0400", hash_original_method = "E8AA98EC6BE3CDFD6C8382F7CC9C6C6F", hash_generated_method = "E8AA98EC6BE3CDFD6C8382F7CC9C6C6F")
        public Transport ()
        {
            
        }


        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.359 -0400", hash_original_method = "D85CC82248E7B34649DA1C02380D9E2C", hash_generated_method = "88F04C1F1C5D28CF911DE96EE5BA418B")
         ContentProvider getContentProvider() {
            ContentProvider varB4EAC82CA7396A68D541C85D26508E83_47817433 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_47817433 = ContentProvider.this;
            varB4EAC82CA7396A68D541C85D26508E83_47817433.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_47817433;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.360 -0400", hash_original_method = "157A3AC2CED86E999B16E7CDFBD5AE31", hash_generated_method = "7EF98D9F83DBB4C2D1D222D43388121F")
        @Override
        public String getProviderName() {
            String varB4EAC82CA7396A68D541C85D26508E83_715962022 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_715962022 = getContentProvider().getClass().getName();
            varB4EAC82CA7396A68D541C85D26508E83_715962022.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_715962022;
            
            
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.361 -0400", hash_original_method = "C07C2CC52F2EA8ADD199B18CF964D47B", hash_generated_method = "D9FB4EBE980A4F16F0F0246698621944")
        public Cursor query(Uri uri, String[] projection,
                String selection, String[] selectionArgs, String sortOrder) {
            Cursor varB4EAC82CA7396A68D541C85D26508E83_558101988 = null; 
            enforceReadPermission(uri);
            varB4EAC82CA7396A68D541C85D26508E83_558101988 = ContentProvider.this.query(uri, projection, selection,
                    selectionArgs, sortOrder);
            addTaint(uri.getTaint());
            addTaint(projection[0].getTaint());
            addTaint(selection.getTaint());
            addTaint(selectionArgs[0].getTaint());
            addTaint(sortOrder.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_558101988.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_558101988;
            
            
            
                    
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.362 -0400", hash_original_method = "BE9D1875DBA635C7BA04B42A3E893DA2", hash_generated_method = "615F69165F81F6E9A61E8546E545BEBD")
        public String getType(Uri uri) {
            String varB4EAC82CA7396A68D541C85D26508E83_844904804 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_844904804 = ContentProvider.this.getType(uri);
            addTaint(uri.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_844904804.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_844904804;
            
            
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.363 -0400", hash_original_method = "2D883DF9190F17ADC9F3F05EDAD4CA9E", hash_generated_method = "744C91E9711DDDD9A244BFB8F6B9466D")
        public Uri insert(Uri uri, ContentValues initialValues) {
            Uri varB4EAC82CA7396A68D541C85D26508E83_252942102 = null; 
            enforceWritePermission(uri);
            varB4EAC82CA7396A68D541C85D26508E83_252942102 = ContentProvider.this.insert(uri, initialValues);
            addTaint(uri.getTaint());
            addTaint(initialValues.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_252942102.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_252942102;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.364 -0400", hash_original_method = "9C9FBE82EEDFD6251BF8F9B258727CC2", hash_generated_method = "F3AFBD0CBA490F01808148D8DE96AE6B")
        public int bulkInsert(Uri uri, ContentValues[] initialValues) {
            enforceWritePermission(uri);
            int var356BE9FE6F30A259688B8E3862579DF5_1668778123 = (ContentProvider.this.bulkInsert(uri, initialValues));
            addTaint(uri.getTaint());
            addTaint(initialValues[0].getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1757605872 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1757605872;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.371 -0400", hash_original_method = "8198345EE7E6B486A1CABFB05410D25E", hash_generated_method = "5A7284854FE3808FE307D85186041BC0")
        public ContentProviderResult[] applyBatch(ArrayList<ContentProviderOperation> operations) throws OperationApplicationException {
            ContentProviderResult[] varB4EAC82CA7396A68D541C85D26508E83_895072536 = null; 
            {
                Iterator<ContentProviderOperation> varE9602D9F0CB9F920ADAA80E0AEDB4F89_1379530336 = (operations).iterator();
                varE9602D9F0CB9F920ADAA80E0AEDB4F89_1379530336.hasNext();
                ContentProviderOperation operation = varE9602D9F0CB9F920ADAA80E0AEDB4F89_1379530336.next();
                {
                    {
                        boolean var648C2431FEB36CA6BCD4B44ED4DEFABF_625273070 = (operation.isReadOperation());
                        {
                            enforceReadPermission(operation.getUri());
                        } 
                    } 
                    {
                        boolean var76F7573D9527D4C4854BC03A7AAE3020_1212971807 = (operation.isWriteOperation());
                        {
                            enforceWritePermission(operation.getUri());
                        } 
                    } 
                } 
            } 
            varB4EAC82CA7396A68D541C85D26508E83_895072536 = ContentProvider.this.applyBatch(operations);
            addTaint(operations.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_895072536.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_895072536;
            
            
                
                    
                
                
                    
                
            
            
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.372 -0400", hash_original_method = "9F536F247E1CDAAB23A0513292709CB1", hash_generated_method = "F44A74FD8EC170406B06F5064CB3F916")
        public int delete(Uri uri, String selection, String[] selectionArgs) {
            enforceWritePermission(uri);
            int var139826D116DF5B4480C4A435A77A7184_100464900 = (ContentProvider.this.delete(uri, selection, selectionArgs));
            addTaint(uri.getTaint());
            addTaint(selection.getTaint());
            addTaint(selectionArgs[0].getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2124004830 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2124004830;
            
            
            
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.373 -0400", hash_original_method = "A4C580D76A4BE435F05FDF3658D031E7", hash_generated_method = "71DCF894B3F2AAA4BCC7D753E49E6229")
        public int update(Uri uri, ContentValues values, String selection,
                String[] selectionArgs) {
            enforceWritePermission(uri);
            int varA1651BA01E90DA8CC721F5ADFBEC3CCE_1762407036 = (ContentProvider.this.update(uri, values, selection, selectionArgs));
            addTaint(uri.getTaint());
            addTaint(values.getTaint());
            addTaint(selection.getTaint());
            addTaint(selectionArgs[0].getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_461419225 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_461419225;
            
            
            
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.374 -0400", hash_original_method = "A3B5DD3A6EF0BED7F3109E14959CA5EF", hash_generated_method = "05CBA4470472057499B6512A21EF1E39")
        public ParcelFileDescriptor openFile(Uri uri, String mode) throws FileNotFoundException {
            ParcelFileDescriptor varB4EAC82CA7396A68D541C85D26508E83_10163974 = null; 
            {
                boolean var990C6E0E8CA37484AEEB3E9453431412_1294852661 = (mode != null && mode.startsWith("rw"));
                enforceWritePermission(uri);
                enforceReadPermission(uri);
            } 
            varB4EAC82CA7396A68D541C85D26508E83_10163974 = ContentProvider.this.openFile(uri, mode);
            addTaint(uri.getTaint());
            addTaint(mode.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_10163974.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_10163974;
            
            
            
            
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.375 -0400", hash_original_method = "9FC3CF0D01502503E6A8E959789D91E0", hash_generated_method = "6939686D91FA4DA86FA7C3BFB5101E9A")
        public AssetFileDescriptor openAssetFile(Uri uri, String mode) throws FileNotFoundException {
            AssetFileDescriptor varB4EAC82CA7396A68D541C85D26508E83_1819448755 = null; 
            {
                boolean var990C6E0E8CA37484AEEB3E9453431412_1145177173 = (mode != null && mode.startsWith("rw"));
                enforceWritePermission(uri);
                enforceReadPermission(uri);
            } 
            varB4EAC82CA7396A68D541C85D26508E83_1819448755 = ContentProvider.this.openAssetFile(uri, mode);
            addTaint(uri.getTaint());
            addTaint(mode.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1819448755.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1819448755;
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.376 -0400", hash_original_method = "F8D45B029854B0071CB25BB646C6653D", hash_generated_method = "07A0EEB1EE7603A1A72DCA05AE641757")
        public Bundle call(String method, String arg, Bundle extras) {
            Bundle varB4EAC82CA7396A68D541C85D26508E83_541072445 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_541072445 = ContentProvider.this.call(method, arg, extras);
            addTaint(method.getTaint());
            addTaint(arg.getTaint());
            addTaint(extras.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_541072445.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_541072445;
            
            
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.377 -0400", hash_original_method = "8E1F3128EE5808B485D05EE809576B99", hash_generated_method = "2C77FAFE3671C60C83CB825A93C49A01")
        @Override
        public String[] getStreamTypes(Uri uri, String mimeTypeFilter) {
            String[] varB4EAC82CA7396A68D541C85D26508E83_2120523745 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_2120523745 = ContentProvider.this.getStreamTypes(uri, mimeTypeFilter);
            addTaint(uri.getTaint());
            addTaint(mimeTypeFilter.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_2120523745.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_2120523745;
            
            
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.377 -0400", hash_original_method = "C18E75C38B25261EF8CFA8F7B83C6E2D", hash_generated_method = "64E8527EFEBACD75583265E1BCED95FD")
        @Override
        public AssetFileDescriptor openTypedAssetFile(Uri uri, String mimeType, Bundle opts) throws FileNotFoundException {
            AssetFileDescriptor varB4EAC82CA7396A68D541C85D26508E83_721664105 = null; 
            enforceReadPermission(uri);
            varB4EAC82CA7396A68D541C85D26508E83_721664105 = ContentProvider.this.openTypedAssetFile(uri, mimeType, opts);
            addTaint(uri.getTaint());
            addTaint(mimeType.getTaint());
            addTaint(opts.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_721664105.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_721664105;
            
            
            
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.378 -0400", hash_original_method = "E57399204B1619B526E92C84388A407F", hash_generated_method = "B05CBF9347CC985E7C512E67451A8860")
        private void enforceReadPermission(Uri uri) {
            final int uid = Binder.getCallingUid();
            final Context context = getContext();
            final String rperm = getReadPermission();
            final int pid = Binder.getCallingPid();
            {
                boolean var11ABD9D7DE204BDD0582E9A702BF61D0_1368732750 = (mExported && (rperm == null
                    || context.checkPermission(rperm, pid, uid)
                    == PackageManager.PERMISSION_GRANTED));
            } 
            PathPermission[] pps = getPathPermissions();
            {
                final String path = uri.getPath();
                int i = pps.length;
                {
                    final PathPermission pp = pps[i];
                    final String pprperm = pp.getReadPermission();
                    {
                        boolean var8BB21B2E5376BD16A5FBA892743AFFA3_1721184142 = (pprperm != null && pp.match(path));
                        {
                            {
                                boolean var02C738C973D4432B9D925BA7105A8603_2082064516 = (context.checkPermission(pprperm, pid, uid)
                                == PackageManager.PERMISSION_GRANTED);
                            } 
                        } 
                    } 
                } 
            } 
            {
                boolean var13E8497132730133410D53B1797E5D75_841590279 = (context.checkUriPermission(uri, pid, uid,
                    Intent.FLAG_GRANT_READ_URI_PERMISSION)
                    == PackageManager.PERMISSION_GRANTED);
            } 
            String msg = "Permission Denial: reading "
                    + ContentProvider.this.getClass().getName()
                    + " uri " + uri + " from pid=" + Binder.getCallingPid()
                    + ", uid=" + Binder.getCallingUid()
                    + " requires " + rperm;
            if (DroidSafeAndroidRuntime.control) throw new SecurityException(msg);
            addTaint(uri.getTaint());
            
            
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.379 -0400", hash_original_method = "329C06E4068EEDF4ECCAEC3BA5AB45CE", hash_generated_method = "2F7B71C396C276C40C50D30A62E53EB0")
        private boolean hasWritePermission(Uri uri) {
            final int uid = Binder.getCallingUid();
            final Context context = getContext();
            final String wperm = getWritePermission();
            final int pid = Binder.getCallingPid();
            {
                boolean var87DDA52804F18883BB0B0CEC23D0EDFD_1569688565 = (mExported && (wperm == null
                    || context.checkPermission(wperm, pid, uid)
                    == PackageManager.PERMISSION_GRANTED));
            } 
            PathPermission[] pps = getPathPermissions();
            {
                final String path = uri.getPath();
                int i = pps.length;
                {
                    final PathPermission pp = pps[i];
                    final String ppwperm = pp.getWritePermission();
                    {
                        boolean var34B7F3F44D970AFAF42A1A9113878492_133310321 = (ppwperm != null && pp.match(path));
                        {
                            {
                                boolean var635E8626A3F8934298FFDD63E2789994_302980783 = (context.checkPermission(ppwperm, pid, uid)
                                == PackageManager.PERMISSION_GRANTED);
                            } 
                        } 
                    } 
                } 
            } 
            {
                boolean var88D202BB8B1056D8C1A0EE22D8D71A13_1322298373 = (context.checkUriPermission(uri, pid, uid,
                    Intent.FLAG_GRANT_WRITE_URI_PERMISSION)
                    == PackageManager.PERMISSION_GRANTED);
            } 
            addTaint(uri.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_758750935 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_758750935;
            
            
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.380 -0400", hash_original_method = "7CEC600BB70206A61DA89C0C0D2014C1", hash_generated_method = "65E44B639467E55543914E4573BCC130")
        private void enforceWritePermission(Uri uri) {
            {
                boolean var24C3F28B334AD89BB610904621BC7375_2022885375 = (hasWritePermission(uri));
            } 
            String msg = "Permission Denial: writing "
                    + ContentProvider.this.getClass().getName()
                    + " uri " + uri + " from pid=" + Binder.getCallingPid()
                    + ", uid=" + Binder.getCallingUid()
                    + " requires " + getWritePermission();
            if (DroidSafeAndroidRuntime.control) throw new SecurityException(msg);
            addTaint(uri.getTaint());
            
            
                
            
            
                    
                    
                    
                    
            
        }

        
    }


    
    public interface PipeDataWriter<T> {
        
        public void writeDataToPipe(ParcelFileDescriptor output, Uri uri, String mimeType,
                Bundle opts, T args);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.380 -0400", hash_original_field = "D9DEAD4FE5612F0F829FC72D942CF904", hash_generated_field = "DA15E6471BF02EF7674EB3675F3C058F")

    private static final String TAG = "ContentProvider";
    
       
}

