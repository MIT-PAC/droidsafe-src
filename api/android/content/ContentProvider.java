package android.content;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.471 -0400", hash_original_field = "EC9A3144C1687F6FFFFC7AC4B8A997AD", hash_generated_field = "64C2E29345D1A72D78C884235FF4120B")

    private Context mContext = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.472 -0400", hash_original_field = "2C2F002F67CB0ABAF6E9BE038FA0C0A5", hash_generated_field = "BAE02AD4841B16814759F68D3AA9D00B")

    private int mMyUid;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.472 -0400", hash_original_field = "3805826D63CBE0EFB018A286F189CC44", hash_generated_field = "F91CBC541AE5EA168107190D1A494CD8")

    private String mReadPermission;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.472 -0400", hash_original_field = "EA3BA31BE3E977A5CA4A690ADA101637", hash_generated_field = "02101D3B9ECFAAEB0689EF2DAEF4A808")

    private String mWritePermission;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.472 -0400", hash_original_field = "00F4643DBE3AE1276B44E74500631096", hash_generated_field = "15E0F7E05B281A905081D65ED9192FDD")

    private PathPermission[] mPathPermissions;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.472 -0400", hash_original_field = "5DCBFC76DAEB92A3E3FD1528EAC8DAB3", hash_generated_field = "5F31C09AB3C1B6A6E2600C83F2928ABF")

    private boolean mExported;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.472 -0400", hash_original_field = "E1D0BDA9D633EC3C8F88DD17C08825F1", hash_generated_field = "B996B8C49C2307FDF0CA3803832CA9DC")

    private Transport mTransport = new Transport();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.473 -0400", hash_original_method = "F039A73ADD81439EFEE4572A926905FF", hash_generated_method = "AE9E67C0D421B97975CBD6F5E7DAC5C3")
    public  ContentProvider() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.474 -0400", hash_original_method = "40393AF8078D8D6FEE29B00460ADF530", hash_generated_method = "1AEE9CFE935A08AC9F4B6B91141A98D6")
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

    
        public static ContentProvider coerceToLocalContentProvider(
            IContentProvider abstractInterface) {
        if (abstractInterface instanceof Transport) {
            return ((Transport)abstractInterface).getContentProvider();
        }
        return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.474 -0400", hash_original_method = "4F4EBC54D108D66F416C93B46580E117", hash_generated_method = "7D2EA73D7A91F6711610B1C684C9E7DC")
    public final Context getContext() {
Context var178E2AD52D6FBBB503F908168856B574_1423167284 =         mContext;
        var178E2AD52D6FBBB503F908168856B574_1423167284.addTaint(taint);
        return var178E2AD52D6FBBB503F908168856B574_1423167284;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.475 -0400", hash_original_method = "C738A12EDF7704A3BEC0DFE17330C819", hash_generated_method = "5E4FF5E477D8E19F78CD67B08931B74B")
    protected final void setReadPermission(String permission) {
        mReadPermission = permission;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.475 -0400", hash_original_method = "5C94FD95ADD3C0054247C1BF6F500E4F", hash_generated_method = "8EEA44A1D3805B5854326471B275DB82")
    public final String getReadPermission() {
String varB7C8F391110CA2789E72296FC3D45BB5_136666160 =         mReadPermission;
        varB7C8F391110CA2789E72296FC3D45BB5_136666160.addTaint(taint);
        return varB7C8F391110CA2789E72296FC3D45BB5_136666160;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.476 -0400", hash_original_method = "6A71B3652F16CF9160129E3EF306B0DC", hash_generated_method = "700C15F3C9EBC3D7B5D3FCF9D079867A")
    protected final void setWritePermission(String permission) {
        mWritePermission = permission;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.477 -0400", hash_original_method = "7A0A16A9FA1EB10AD9D087C65A3EFFB1", hash_generated_method = "B3C24700F898EB3E5CB8A9DB68FD01FF")
    public final String getWritePermission() {
String var59D1027D8312A72F6CBAE99932E8098B_107736929 =         mWritePermission;
        var59D1027D8312A72F6CBAE99932E8098B_107736929.addTaint(taint);
        return var59D1027D8312A72F6CBAE99932E8098B_107736929;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.477 -0400", hash_original_method = "16570AF799E31BB65FFA9254DA0AB517", hash_generated_method = "1CF8FB57421D0861F87CB9D1F6E697A3")
    protected final void setPathPermissions(PathPermission[] permissions) {
        mPathPermissions = permissions;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.478 -0400", hash_original_method = "E38FFC0E115EF293B9FB9C6179B78AA8", hash_generated_method = "E37D3D87355BFD43D8EA1028ACEBDD03")
    public final PathPermission[] getPathPermissions() {
PathPermission[] var24E2D1568C411176949D95742C7A4275_180389765 =         mPathPermissions;
        var24E2D1568C411176949D95742C7A4275_180389765.addTaint(taint);
        return var24E2D1568C411176949D95742C7A4275_180389765;
        
        
    }

    
    public abstract boolean onCreate();

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.479 -0400", hash_original_method = "8287235C28E9D1E310027A2DDEB95FCD", hash_generated_method = "BA7F1E69C22467D62A959775F321C0BA")
    public void onConfigurationChanged(Configuration newConfig) {
        
        addTaint(newConfig.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.480 -0400", hash_original_method = "4F0E380BE715BF5B2ECCDB1794C8905E", hash_generated_method = "39AEB8790734ECC8DC70BBAAEE0BAB0B")
    public void onLowMemory() {
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.480 -0400", hash_original_method = "3AE0D4ACEA3D5F3B779A378D5AB27A6A", hash_generated_method = "C1AFC91F30E138BA03233A690A40C0CC")
    public void onTrimMemory(int level) {
        
        addTaint(level);
        
    }

    
    public abstract Cursor query(Uri uri, String[] projection,
            String selection, String[] selectionArgs, String sortOrder);

    
    public abstract String getType(Uri uri);

    
    public abstract Uri insert(Uri uri, ContentValues values);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.482 -0400", hash_original_method = "C678349FF8875CB9D22305FF9A5474DD", hash_generated_method = "85425066C1203911437F06D93CF76387")
    public int bulkInsert(Uri uri, ContentValues[] values) {
        addTaint(values[0].getTaint());
        addTaint(uri.getTaint());
        int numValues = values.length;
for(int i = 0;i < numValues;i++)
        {
            insert(uri, values[i]);
        } 
        int var66D01EB691C0B5789D1BA5D45CF56B07_523579417 = (numValues);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1526561574 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1526561574;
        
        
        
            
        
        
    }

    
    public abstract int delete(Uri uri, String selection, String[] selectionArgs);

    
    public abstract int update(Uri uri, ContentValues values, String selection,
            String[] selectionArgs);

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.483 -0400", hash_original_method = "DCC5B23EAE3536B2EEFB8F5A1AA89B13", hash_generated_method = "BB60EACF0AB1FBBAAB5A9386D5852835")
    public ParcelFileDescriptor openFile(Uri uri, String mode) throws FileNotFoundException {
        addTaint(mode.getTaint());
        addTaint(uri.getTaint());
        FileNotFoundException varD427DDF9A24345493FBC896AC82582D9_1181462380 = new FileNotFoundException("No files supported by provider at "
                + uri);
        varD427DDF9A24345493FBC896AC82582D9_1181462380.addTaint(taint);
        throw varD427DDF9A24345493FBC896AC82582D9_1181462380;
        
        
                
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.483 -0400", hash_original_method = "58BEA9E66A4FD3FC19246F4A2CA5B928", hash_generated_method = "9138B1A6B04624DA9FD92852416358A4")
    public AssetFileDescriptor openAssetFile(Uri uri, String mode) throws FileNotFoundException {
        addTaint(mode.getTaint());
        addTaint(uri.getTaint());
        ParcelFileDescriptor fd = openFile(uri, mode);
AssetFileDescriptor varA57245475EB9DCE6168AA22F54422F97_1247892756 =         fd != null ? new AssetFileDescriptor(fd, 0, -1) : null;
        varA57245475EB9DCE6168AA22F54422F97_1247892756.addTaint(taint);
        return varA57245475EB9DCE6168AA22F54422F97_1247892756;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.484 -0400", hash_original_method = "B77C082B2FC41ABB2AC9CAAF0861BB6A", hash_generated_method = "EB449B9F78BE0677A2B03A5185B2BBA5")
    protected final ParcelFileDescriptor openFileHelper(Uri uri,
            String mode) throws FileNotFoundException {
        addTaint(mode.getTaint());
        addTaint(uri.getTaint());
        Cursor c = query(uri, new String[]{"_data"}, null, null, null);
        int count = (c != null) ? c.getCount() : 0;
    if(count != 1)        
        {
    if(c != null)            
            {
                c.close();
            } 
    if(count == 0)            
            {
                FileNotFoundException var803CF12C6BFA3F6E4495A8A2D15BF172_2138800751 = new FileNotFoundException("No entry for " + uri);
                var803CF12C6BFA3F6E4495A8A2D15BF172_2138800751.addTaint(taint);
                throw var803CF12C6BFA3F6E4495A8A2D15BF172_2138800751;
            } 
            FileNotFoundException varCCB1A3D8F9EB0D95AA719F589741DB21_1789569934 = new FileNotFoundException("Multiple items at " + uri);
            varCCB1A3D8F9EB0D95AA719F589741DB21_1789569934.addTaint(taint);
            throw varCCB1A3D8F9EB0D95AA719F589741DB21_1789569934;
        } 
        c.moveToFirst();
        int i = c.getColumnIndex("_data");
        String path = (i >= 0 ? c.getString(i) : null);
        c.close();
    if(path == null)        
        {
            FileNotFoundException varBC179702CCC142CA58BA59421BCB8885_1148316754 = new FileNotFoundException("Column _data not found.");
            varBC179702CCC142CA58BA59421BCB8885_1148316754.addTaint(taint);
            throw varBC179702CCC142CA58BA59421BCB8885_1148316754;
        } 
        int modeBits = ContentResolver.modeToMode(uri, mode);
ParcelFileDescriptor varBAB37DE04A5B7A40E055BD5EA30CAC7D_715317859 =         ParcelFileDescriptor.open(new File(path), modeBits);
        varBAB37DE04A5B7A40E055BD5EA30CAC7D_715317859.addTaint(taint);
        return varBAB37DE04A5B7A40E055BD5EA30CAC7D_715317859;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.485 -0400", hash_original_method = "BEF8B956D915C9CD914319D11D9F55DF", hash_generated_method = "6041F981ED1A08F8ED6A70A208E0EB54")
    public String[] getStreamTypes(Uri uri, String mimeTypeFilter) {
        addTaint(mimeTypeFilter.getTaint());
        addTaint(uri.getTaint());
String[] var540C13E9E156B687226421B24F2DF178_1609726229 =         null;
        var540C13E9E156B687226421B24F2DF178_1609726229.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1609726229;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.485 -0400", hash_original_method = "4E83B7632E2F0C6C101685B3A453F6C7", hash_generated_method = "F27A6AE100B2D97D045387F2B6F41A1A")
    public AssetFileDescriptor openTypedAssetFile(Uri uri, String mimeTypeFilter, Bundle opts) throws FileNotFoundException {
        addTaint(opts.getTaint());
        addTaint(mimeTypeFilter.getTaint());
        addTaint(uri.getTaint());
    if("*/*".equals(mimeTypeFilter))        
        {
AssetFileDescriptor varCFD1DF6ECCCC8237B83DC46BE40175A9_1298523683 =             openAssetFile(uri, "r");
            varCFD1DF6ECCCC8237B83DC46BE40175A9_1298523683.addTaint(taint);
            return varCFD1DF6ECCCC8237B83DC46BE40175A9_1298523683;
        } 
        String baseType = getType(uri);
    if(baseType != null && ClipDescription.compareMimeTypes(baseType, mimeTypeFilter))        
        {
AssetFileDescriptor varCFD1DF6ECCCC8237B83DC46BE40175A9_1270015553 =             openAssetFile(uri, "r");
            varCFD1DF6ECCCC8237B83DC46BE40175A9_1270015553.addTaint(taint);
            return varCFD1DF6ECCCC8237B83DC46BE40175A9_1270015553;
        } 
        FileNotFoundException var9704B4F4149597D88475264DFB8FD1D7_1618741174 = new FileNotFoundException("Can't open " + uri + " as type " + mimeTypeFilter);
        var9704B4F4149597D88475264DFB8FD1D7_1618741174.addTaint(taint);
        throw var9704B4F4149597D88475264DFB8FD1D7_1618741174;
        
        
            
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.486 -0400", hash_original_method = "BC63CE555A1B156ABB3D2B022F0E90CE", hash_generated_method = "7047AF868400B8BF70C4F84DC9D61210")
    public <T> ParcelFileDescriptor openPipeHelper(final Uri uri, final String mimeType,
            final Bundle opts, final T args, final PipeDataWriter<T> func) throws FileNotFoundException {
        addTaint(func.getTaint());
        addTaint(args.getTaint());
        addTaint(opts.getTaint());
        addTaint(mimeType.getTaint());
        addTaint(uri.getTaint());
        try 
        {
            final ParcelFileDescriptor[] fds = ParcelFileDescriptor.createPipe();
            AsyncTask<Object, Object, Object> task = new AsyncTask<Object, Object, Object>() {
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
ParcelFileDescriptor var0A32740862433E6F4A2B631AD9C65F9E_207390444 =             fds[0];
            var0A32740862433E6F4A2B631AD9C65F9E_207390444.addTaint(taint);
            return var0A32740862433E6F4A2B631AD9C65F9E_207390444;
        } 
        catch (IOException e)
        {
            FileNotFoundException var9BBB3DDA0FD7526E4D3B8A7AF6DADB25_631482816 = new FileNotFoundException("failure making pipe");
            var9BBB3DDA0FD7526E4D3B8A7AF6DADB25_631482816.addTaint(taint);
            throw var9BBB3DDA0FD7526E4D3B8A7AF6DADB25_631482816;
        } 
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.487 -0400", hash_original_method = "5727E4CF3A64759CEEBA62DE047537C3", hash_generated_method = "4D08BF1EB00335422B5EB180110E1297")
    protected boolean isTemporary() {
        boolean var68934A3E9455FA72420237EB05902327_1055443931 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_635911740 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_635911740;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.487 -0400", hash_original_method = "883A061900350051FBA62F6F6FD9E085", hash_generated_method = "B95B58BA423DEA58516FBB9436696F1D")
    public IContentProvider getIContentProvider() {
IContentProvider varF2CB7A1EAFE712633AC71AFDD720A221_639581215 =         mTransport;
        varF2CB7A1EAFE712633AC71AFDD720A221_639581215.addTaint(taint);
        return varF2CB7A1EAFE712633AC71AFDD720A221_639581215;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.488 -0400", hash_original_method = "0A143494E98F1D73DE768E656190D91A", hash_generated_method = "9FA89A715BE7713F7EA224760E9A3174")
    public void attachInfo(Context context, ProviderInfo info) {
        AsyncTask.init();
    if(mContext == null)        
        {
            mContext = context;
            mMyUid = Process.myUid();
    if(info != null)            
            {
                setReadPermission(info.readPermission);
                setWritePermission(info.writePermission);
                setPathPermissions(info.pathPermissions);
                mExported = info.exported;
            } 
            ContentProvider.this.onCreate();
        } 
        
        
        
            
            
            
                
                
                
                
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.489 -0400", hash_original_method = "E0DAC3050A9BAD12465D5076F1EE0420", hash_generated_method = "94B6FE2C29359490C6B39493A3F22144")
    public ContentProviderResult[] applyBatch(ArrayList<ContentProviderOperation> operations) throws OperationApplicationException {
        addTaint(operations.getTaint());
        final int numOperations = operations.size();
        final ContentProviderResult[] results = new ContentProviderResult[numOperations];
for(int i = 0;i < numOperations;i++)
        {
            results[i] = operations.get(i).apply(this, results, i);
        } 
ContentProviderResult[] var238ECCC9872FFCA0B3C3DB83598FF044_1541909471 =         results;
        var238ECCC9872FFCA0B3C3DB83598FF044_1541909471.addTaint(taint);
        return var238ECCC9872FFCA0B3C3DB83598FF044_1541909471;
        
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.490 -0400", hash_original_method = "FDEF25FCA992321C96D9ED3D525FD124", hash_generated_method = "00B9E306A083E8B59F99C1EDE86F0FA4")
    public Bundle call(String method, String arg, Bundle extras) {
        addTaint(extras.getTaint());
        addTaint(arg.getTaint());
        addTaint(method.getTaint());
Bundle var540C13E9E156B687226421B24F2DF178_1681377404 =         null;
        var540C13E9E156B687226421B24F2DF178_1681377404.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1681377404;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.490 -0400", hash_original_method = "D03BEE67B09D4B1E8C6E9290C7758C5F", hash_generated_method = "B150A4E1DC19A0FA6E8508D3F3E8E47D")
    public void shutdown() {
        
        
                
    }

    
    class Transport extends ContentProviderNative {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.490 -0400", hash_original_method = "E8AA98EC6BE3CDFD6C8382F7CC9C6C6F", hash_generated_method = "E8AA98EC6BE3CDFD6C8382F7CC9C6C6F")
        public Transport ()
        {
            
        }


        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.491 -0400", hash_original_method = "D85CC82248E7B34649DA1C02380D9E2C", hash_generated_method = "60F7249A8D113A609890AF5C2E67BCAD")
         ContentProvider getContentProvider() {
ContentProvider varC964AD0B3FDDC5F592DBC6B2E7A7AF92_1459021034 =             ContentProvider.this;
            varC964AD0B3FDDC5F592DBC6B2E7A7AF92_1459021034.addTaint(taint);
            return varC964AD0B3FDDC5F592DBC6B2E7A7AF92_1459021034;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.491 -0400", hash_original_method = "157A3AC2CED86E999B16E7CDFBD5AE31", hash_generated_method = "67425FCADAD50C40E49A237016C019BA")
        @Override
        public String getProviderName() {
String varED11270F9E13FAAC581C2CCBE7C2F48C_206486987 =             getContentProvider().getClass().getName();
            varED11270F9E13FAAC581C2CCBE7C2F48C_206486987.addTaint(taint);
            return varED11270F9E13FAAC581C2CCBE7C2F48C_206486987;
            
            
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.492 -0400", hash_original_method = "C07C2CC52F2EA8ADD199B18CF964D47B", hash_generated_method = "DAE200F7D0658B934406560AD7CCA122")
        public Cursor query(Uri uri, String[] projection,
                String selection, String[] selectionArgs, String sortOrder) {
            addTaint(sortOrder.getTaint());
            addTaint(selectionArgs[0].getTaint());
            addTaint(selection.getTaint());
            addTaint(projection[0].getTaint());
            addTaint(uri.getTaint());
            enforceReadPermission(uri);
Cursor var5BED765E00858C646DF14C0893EB6B41_1494618190 =             ContentProvider.this.query(uri, projection, selection,
                    selectionArgs, sortOrder);
            var5BED765E00858C646DF14C0893EB6B41_1494618190.addTaint(taint);
            return var5BED765E00858C646DF14C0893EB6B41_1494618190;
            
            
            
                    
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.492 -0400", hash_original_method = "BE9D1875DBA635C7BA04B42A3E893DA2", hash_generated_method = "C1E23BACFAD26A7D9034DE38CAE0F4BA")
        public String getType(Uri uri) {
            addTaint(uri.getTaint());
String var5B9B0993930B2F3B1729C74908362C2C_1079083253 =             ContentProvider.this.getType(uri);
            var5B9B0993930B2F3B1729C74908362C2C_1079083253.addTaint(taint);
            return var5B9B0993930B2F3B1729C74908362C2C_1079083253;
            
            
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.493 -0400", hash_original_method = "2D883DF9190F17ADC9F3F05EDAD4CA9E", hash_generated_method = "746ABCE0F7D3FD5A6BA9B5FBA4731DDA")
        public Uri insert(Uri uri, ContentValues initialValues) {
            addTaint(initialValues.getTaint());
            addTaint(uri.getTaint());
            enforceWritePermission(uri);
Uri var8209C23EA48B1C7744571EB5BC75334C_301632948 =             ContentProvider.this.insert(uri, initialValues);
            var8209C23EA48B1C7744571EB5BC75334C_301632948.addTaint(taint);
            return var8209C23EA48B1C7744571EB5BC75334C_301632948;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.493 -0400", hash_original_method = "9C9FBE82EEDFD6251BF8F9B258727CC2", hash_generated_method = "6CAD5AB14D7A1F701DAA1BA271D8B5ED")
        public int bulkInsert(Uri uri, ContentValues[] initialValues) {
            addTaint(initialValues[0].getTaint());
            addTaint(uri.getTaint());
            enforceWritePermission(uri);
            int var74D767A98B755F12AF9D899F2667AC64_1800822313 = (ContentProvider.this.bulkInsert(uri, initialValues));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_879557891 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_879557891;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.494 -0400", hash_original_method = "8198345EE7E6B486A1CABFB05410D25E", hash_generated_method = "F7089DC572B5B5A9DFEB177B205D7C78")
        public ContentProviderResult[] applyBatch(ArrayList<ContentProviderOperation> operations) throws OperationApplicationException {
            addTaint(operations.getTaint());
for(ContentProviderOperation operation : operations)
            {
    if(operation.isReadOperation())                
                {
                    enforceReadPermission(operation.getUri());
                } 
    if(operation.isWriteOperation())                
                {
                    enforceWritePermission(operation.getUri());
                } 
            } 
ContentProviderResult[] var315BC8DBA4C3A0CFC21570E22B483988_1467323190 =             ContentProvider.this.applyBatch(operations);
            var315BC8DBA4C3A0CFC21570E22B483988_1467323190.addTaint(taint);
            return var315BC8DBA4C3A0CFC21570E22B483988_1467323190;
            
            
                
                    
                
                
                    
                
            
            
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.494 -0400", hash_original_method = "9F536F247E1CDAAB23A0513292709CB1", hash_generated_method = "28B621AEB31ED124585CF76E37BBD589")
        public int delete(Uri uri, String selection, String[] selectionArgs) {
            addTaint(selectionArgs[0].getTaint());
            addTaint(selection.getTaint());
            addTaint(uri.getTaint());
            enforceWritePermission(uri);
            int var2F009A06449C223FD617D5D3F4FF4E6C_1662864541 = (ContentProvider.this.delete(uri, selection, selectionArgs));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1582729262 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1582729262;
            
            
            
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.495 -0400", hash_original_method = "A4C580D76A4BE435F05FDF3658D031E7", hash_generated_method = "31BEC81B34CA2AEFD75D794DE3D28811")
        public int update(Uri uri, ContentValues values, String selection,
                String[] selectionArgs) {
            addTaint(selectionArgs[0].getTaint());
            addTaint(selection.getTaint());
            addTaint(values.getTaint());
            addTaint(uri.getTaint());
            enforceWritePermission(uri);
            int varECC72D9487713202C2D2D0C54119773F_960642380 = (ContentProvider.this.update(uri, values, selection, selectionArgs));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1774904923 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1774904923;
            
            
            
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.495 -0400", hash_original_method = "A3B5DD3A6EF0BED7F3109E14959CA5EF", hash_generated_method = "BBBADA0D90E2D9F47A2E954F89A131C4")
        public ParcelFileDescriptor openFile(Uri uri, String mode) throws FileNotFoundException {
            addTaint(mode.getTaint());
            addTaint(uri.getTaint());
    if(mode != null && mode.startsWith("rw"))            
            enforceWritePermission(uri);
            else
            enforceReadPermission(uri);
ParcelFileDescriptor var92B3985CCA3575439B2C1D8C87C145BD_2134652306 =             ContentProvider.this.openFile(uri, mode);
            var92B3985CCA3575439B2C1D8C87C145BD_2134652306.addTaint(taint);
            return var92B3985CCA3575439B2C1D8C87C145BD_2134652306;
            
            
            
            
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.496 -0400", hash_original_method = "9FC3CF0D01502503E6A8E959789D91E0", hash_generated_method = "3A254281863B254E3F4B7A880CFCE773")
        public AssetFileDescriptor openAssetFile(Uri uri, String mode) throws FileNotFoundException {
            addTaint(mode.getTaint());
            addTaint(uri.getTaint());
    if(mode != null && mode.startsWith("rw"))            
            enforceWritePermission(uri);
            else
            enforceReadPermission(uri);
AssetFileDescriptor var55EAB6F02B22D2BCFE59AE1EC2B8FA58_703150342 =             ContentProvider.this.openAssetFile(uri, mode);
            var55EAB6F02B22D2BCFE59AE1EC2B8FA58_703150342.addTaint(taint);
            return var55EAB6F02B22D2BCFE59AE1EC2B8FA58_703150342;
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.496 -0400", hash_original_method = "F8D45B029854B0071CB25BB646C6653D", hash_generated_method = "4521676F8E24915B9841AFBA58B4EA59")
        public Bundle call(String method, String arg, Bundle extras) {
            addTaint(extras.getTaint());
            addTaint(arg.getTaint());
            addTaint(method.getTaint());
Bundle varE50CAEED571D4508C1B829BFA060E554_1091371413 =             ContentProvider.this.call(method, arg, extras);
            varE50CAEED571D4508C1B829BFA060E554_1091371413.addTaint(taint);
            return varE50CAEED571D4508C1B829BFA060E554_1091371413;
            
            
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.497 -0400", hash_original_method = "8E1F3128EE5808B485D05EE809576B99", hash_generated_method = "3F8D46B5209E15E5799D33FF7FA83081")
        @Override
        public String[] getStreamTypes(Uri uri, String mimeTypeFilter) {
            addTaint(mimeTypeFilter.getTaint());
            addTaint(uri.getTaint());
String[] var9C4CD0F20752BB51B9C837E84E409BD1_444445777 =             ContentProvider.this.getStreamTypes(uri, mimeTypeFilter);
            var9C4CD0F20752BB51B9C837E84E409BD1_444445777.addTaint(taint);
            return var9C4CD0F20752BB51B9C837E84E409BD1_444445777;
            
            
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.497 -0400", hash_original_method = "C18E75C38B25261EF8CFA8F7B83C6E2D", hash_generated_method = "833FEBCF74B5955E7324D58C2ECA42D9")
        @Override
        public AssetFileDescriptor openTypedAssetFile(Uri uri, String mimeType, Bundle opts) throws FileNotFoundException {
            addTaint(opts.getTaint());
            addTaint(mimeType.getTaint());
            addTaint(uri.getTaint());
            enforceReadPermission(uri);
AssetFileDescriptor varD029E2BF2AD851D0E5EAF5BF04D93B06_723165 =             ContentProvider.this.openTypedAssetFile(uri, mimeType, opts);
            varD029E2BF2AD851D0E5EAF5BF04D93B06_723165.addTaint(taint);
            return varD029E2BF2AD851D0E5EAF5BF04D93B06_723165;
            
            
            
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.498 -0400", hash_original_method = "E57399204B1619B526E92C84388A407F", hash_generated_method = "79E1C2F56976B63B1B6CE84E8A09D9CC")
        private void enforceReadPermission(Uri uri) {
            addTaint(uri.getTaint());
            final int uid = Binder.getCallingUid();
    if(uid == mMyUid)            
            {
                return;
            } 
            final Context context = getContext();
            final String rperm = getReadPermission();
            final int pid = Binder.getCallingPid();
    if(mExported && (rperm == null
                    || context.checkPermission(rperm, pid, uid)
                    == PackageManager.PERMISSION_GRANTED))            
            {
                return;
            } 
            PathPermission[] pps = getPathPermissions();
    if(pps != null)            
            {
                final String path = uri.getPath();
                int i = pps.length;
                while
(i > 0)                
                {
                    i--;
                    final PathPermission pp = pps[i];
                    final String pprperm = pp.getReadPermission();
    if(pprperm != null && pp.match(path))                    
                    {
    if(context.checkPermission(pprperm, pid, uid)
                                == PackageManager.PERMISSION_GRANTED)                        
                        {
                            return;
                        } 
                    } 
                } 
            } 
    if(context.checkUriPermission(uri, pid, uid,
                    Intent.FLAG_GRANT_READ_URI_PERMISSION)
                    == PackageManager.PERMISSION_GRANTED)            
            {
                return;
            } 
            String msg = "Permission Denial: reading "
                    + ContentProvider.this.getClass().getName()
                    + " uri " + uri + " from pid=" + Binder.getCallingPid()
                    + ", uid=" + Binder.getCallingUid()
                    + " requires " + rperm;
            SecurityException varC5EE93F1F5A2A36B7796B378C69384FB_1923521562 = new SecurityException(msg);
            varC5EE93F1F5A2A36B7796B378C69384FB_1923521562.addTaint(taint);
            throw varC5EE93F1F5A2A36B7796B378C69384FB_1923521562;
            
            
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.499 -0400", hash_original_method = "329C06E4068EEDF4ECCAEC3BA5AB45CE", hash_generated_method = "AD3DA02C67883C05E3F2D0935019D647")
        private boolean hasWritePermission(Uri uri) {
            addTaint(uri.getTaint());
            final int uid = Binder.getCallingUid();
    if(uid == mMyUid)            
            {
                boolean varB326B5062B2F0E69046810717534CB09_1894487441 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1728195790 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1728195790;
            } 
            final Context context = getContext();
            final String wperm = getWritePermission();
            final int pid = Binder.getCallingPid();
    if(mExported && (wperm == null
                    || context.checkPermission(wperm, pid, uid)
                    == PackageManager.PERMISSION_GRANTED))            
            {
                boolean varB326B5062B2F0E69046810717534CB09_1507086741 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_136272208 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_136272208;
            } 
            PathPermission[] pps = getPathPermissions();
    if(pps != null)            
            {
                final String path = uri.getPath();
                int i = pps.length;
                while
(i > 0)                
                {
                    i--;
                    final PathPermission pp = pps[i];
                    final String ppwperm = pp.getWritePermission();
    if(ppwperm != null && pp.match(path))                    
                    {
    if(context.checkPermission(ppwperm, pid, uid)
                                == PackageManager.PERMISSION_GRANTED)                        
                        {
                            boolean varB326B5062B2F0E69046810717534CB09_6756232 = (true);
                                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_151541587 = getTaintBoolean();
                            return var84E2C64F38F78BA3EA5C905AB5A2DA27_151541587;
                        } 
                    } 
                } 
            } 
    if(context.checkUriPermission(uri, pid, uid,
                    Intent.FLAG_GRANT_WRITE_URI_PERMISSION)
                    == PackageManager.PERMISSION_GRANTED)            
            {
                boolean varB326B5062B2F0E69046810717534CB09_1387990339 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1297425958 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1297425958;
            } 
            boolean var68934A3E9455FA72420237EB05902327_148740190 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_494647650 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_494647650;
            
            
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.500 -0400", hash_original_method = "7CEC600BB70206A61DA89C0C0D2014C1", hash_generated_method = "E1150802EE346EF34326C3D7649BF9CC")
        private void enforceWritePermission(Uri uri) {
            addTaint(uri.getTaint());
    if(hasWritePermission(uri))            
            {
                return;
            } 
            String msg = "Permission Denial: writing "
                    + ContentProvider.this.getClass().getName()
                    + " uri " + uri + " from pid=" + Binder.getCallingPid()
                    + ", uid=" + Binder.getCallingUid()
                    + " requires " + getWritePermission();
            SecurityException varC5EE93F1F5A2A36B7796B378C69384FB_1047048108 = new SecurityException(msg);
            varC5EE93F1F5A2A36B7796B378C69384FB_1047048108.addTaint(taint);
            throw varC5EE93F1F5A2A36B7796B378C69384FB_1047048108;
            
            
                
            
            
                    
                    
                    
                    
            
        }

        
    }


    
    public interface PipeDataWriter<T> {
        
        public void writeDataToPipe(ParcelFileDescriptor output, Uri uri, String mimeType,
                Bundle opts, T args);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.501 -0400", hash_original_field = "D9DEAD4FE5612F0F829FC72D942CF904", hash_generated_field = "DA15E6471BF02EF7674EB3675F3C058F")

    private static final String TAG = "ContentProvider";
}

