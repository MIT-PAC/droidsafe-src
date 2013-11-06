package android.content;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import android.content.pm.PackageManager;
import android.content.pm.PathPermission;
import android.content.pm.ProviderInfo;
import android.content.res.AssetFileDescriptor;
import android.content.res.Configuration;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Binder;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.util.Log;





public abstract class ContentProvider implements ComponentCallbacks2 {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.783 -0400", hash_original_field = "EC9A3144C1687F6FFFFC7AC4B8A997AD", hash_generated_field = "64C2E29345D1A72D78C884235FF4120B")

    private Context mContext = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.783 -0400", hash_original_field = "2C2F002F67CB0ABAF6E9BE038FA0C0A5", hash_generated_field = "BAE02AD4841B16814759F68D3AA9D00B")

    private int mMyUid;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.784 -0400", hash_original_field = "3805826D63CBE0EFB018A286F189CC44", hash_generated_field = "F91CBC541AE5EA168107190D1A494CD8")

    private String mReadPermission;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.784 -0400", hash_original_field = "EA3BA31BE3E977A5CA4A690ADA101637", hash_generated_field = "02101D3B9ECFAAEB0689EF2DAEF4A808")

    private String mWritePermission;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.784 -0400", hash_original_field = "00F4643DBE3AE1276B44E74500631096", hash_generated_field = "15E0F7E05B281A905081D65ED9192FDD")

    private PathPermission[] mPathPermissions;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.784 -0400", hash_original_field = "5DCBFC76DAEB92A3E3FD1528EAC8DAB3", hash_generated_field = "5F31C09AB3C1B6A6E2600C83F2928ABF")

    private boolean mExported;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.784 -0400", hash_original_field = "E1D0BDA9D633EC3C8F88DD17C08825F1", hash_generated_field = "B996B8C49C2307FDF0CA3803832CA9DC")

    private Transport mTransport = new Transport();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.784 -0400", hash_original_method = "F039A73ADD81439EFEE4572A926905FF", hash_generated_method = "AE9E67C0D421B97975CBD6F5E7DAC5C3")
    @DSModeled(DSC.SAFE)
    public  ContentProvider() {
        
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.785 -0400", hash_original_method = "40393AF8078D8D6FEE29B00460ADF530", hash_generated_method = "1AEE9CFE935A08AC9F4B6B91141A98D6")
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

    
    @DSModeled(DSC.BAN)
    public static ContentProvider coerceToLocalContentProvider(
            IContentProvider abstractInterface) {
        if (abstractInterface instanceof Transport) {
            return ((Transport)abstractInterface).getContentProvider();
        }
        return null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.786 -0400", hash_original_method = "4F4EBC54D108D66F416C93B46580E117", hash_generated_method = "E3634F2044603A607ED25FFA0DB1AE98")
    public final Context getContext() {
Context var178E2AD52D6FBBB503F908168856B574_2116415209 =         mContext;
        var178E2AD52D6FBBB503F908168856B574_2116415209.addTaint(taint);
        return var178E2AD52D6FBBB503F908168856B574_2116415209;
        // ---------- Original Method ----------
        //return mContext;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.787 -0400", hash_original_method = "C738A12EDF7704A3BEC0DFE17330C819", hash_generated_method = "5E4FF5E477D8E19F78CD67B08931B74B")
    protected final void setReadPermission(String permission) {
        mReadPermission = permission;
        // ---------- Original Method ----------
        //mReadPermission = permission;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.788 -0400", hash_original_method = "5C94FD95ADD3C0054247C1BF6F500E4F", hash_generated_method = "C0F127F3EC1BA2638555DB17643C28C6")
    public final String getReadPermission() {
String varB7C8F391110CA2789E72296FC3D45BB5_643543003 =         mReadPermission;
        varB7C8F391110CA2789E72296FC3D45BB5_643543003.addTaint(taint);
        return varB7C8F391110CA2789E72296FC3D45BB5_643543003;
        // ---------- Original Method ----------
        //return mReadPermission;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.789 -0400", hash_original_method = "6A71B3652F16CF9160129E3EF306B0DC", hash_generated_method = "700C15F3C9EBC3D7B5D3FCF9D079867A")
    protected final void setWritePermission(String permission) {
        mWritePermission = permission;
        // ---------- Original Method ----------
        //mWritePermission = permission;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.789 -0400", hash_original_method = "7A0A16A9FA1EB10AD9D087C65A3EFFB1", hash_generated_method = "9CCE16788971E368764DF7585A6B99B0")
    public final String getWritePermission() {
String var59D1027D8312A72F6CBAE99932E8098B_1514742998 =         mWritePermission;
        var59D1027D8312A72F6CBAE99932E8098B_1514742998.addTaint(taint);
        return var59D1027D8312A72F6CBAE99932E8098B_1514742998;
        // ---------- Original Method ----------
        //return mWritePermission;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.790 -0400", hash_original_method = "16570AF799E31BB65FFA9254DA0AB517", hash_generated_method = "1CF8FB57421D0861F87CB9D1F6E697A3")
    protected final void setPathPermissions(PathPermission[] permissions) {
        mPathPermissions = permissions;
        // ---------- Original Method ----------
        //mPathPermissions = permissions;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.790 -0400", hash_original_method = "E38FFC0E115EF293B9FB9C6179B78AA8", hash_generated_method = "562B179551D663C5CB0B6EEBC16AE126")
    public final PathPermission[] getPathPermissions() {
PathPermission[] var24E2D1568C411176949D95742C7A4275_1373800687 =         mPathPermissions;
        var24E2D1568C411176949D95742C7A4275_1373800687.addTaint(taint);
        return var24E2D1568C411176949D95742C7A4275_1373800687;
        // ---------- Original Method ----------
        //return mPathPermissions;
    }

    
    @DSModeled(DSC.SAFE)
    public abstract boolean onCreate();

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.792 -0400", hash_original_method = "8287235C28E9D1E310027A2DDEB95FCD", hash_generated_method = "BA7F1E69C22467D62A959775F321C0BA")
    public void onConfigurationChanged(Configuration newConfig) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(newConfig.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.792 -0400", hash_original_method = "4F0E380BE715BF5B2ECCDB1794C8905E", hash_generated_method = "39AEB8790734ECC8DC70BBAAEE0BAB0B")
    public void onLowMemory() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.793 -0400", hash_original_method = "3AE0D4ACEA3D5F3B779A378D5AB27A6A", hash_generated_method = "C1AFC91F30E138BA03233A690A40C0CC")
    public void onTrimMemory(int level) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(level);
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SPEC)
    public abstract Cursor query(Uri uri, String[] projection,
            String selection, String[] selectionArgs, String sortOrder);

    
    @DSModeled(DSC.SAFE)
    public abstract String getType(Uri uri);

    
    @DSModeled(DSC.SPEC)
    public abstract Uri insert(Uri uri, ContentValues values);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.794 -0400", hash_original_method = "C678349FF8875CB9D22305FF9A5474DD", hash_generated_method = "70D7D564366AB280034385D85DE50F8E")
    public int bulkInsert(Uri uri, ContentValues[] values) {
        addTaint(values[0].getTaint());
        addTaint(uri.getTaint());
        int numValues = values.length;
for(int i = 0;i < numValues;i++)
        {
            insert(uri, values[i]);
        } //End block
        int var66D01EB691C0B5789D1BA5D45CF56B07_11902728 = (numValues);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_807419137 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_807419137;
        // ---------- Original Method ----------
        //int numValues = values.length;
        //for (int i = 0; i < numValues; i++) {
            //insert(uri, values[i]);
        //}
        //return numValues;
    }

    
    @DSModeled(DSC.SPEC)
    public abstract int delete(Uri uri, String selection, String[] selectionArgs);

    
    @DSModeled(DSC.SPEC)
    public abstract int update(Uri uri, ContentValues values, String selection,
            String[] selectionArgs);

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.796 -0400", hash_original_method = "DCC5B23EAE3536B2EEFB8F5A1AA89B13", hash_generated_method = "9FF574AACB5D7A3C9884623C8A7B816A")
    public ParcelFileDescriptor openFile(Uri uri, String mode) throws FileNotFoundException {
        addTaint(mode.getTaint());
        addTaint(uri.getTaint());
        FileNotFoundException varD427DDF9A24345493FBC896AC82582D9_1745870239 = new FileNotFoundException("No files supported by provider at "
                + uri);
        varD427DDF9A24345493FBC896AC82582D9_1745870239.addTaint(taint);
        throw varD427DDF9A24345493FBC896AC82582D9_1745870239;
        // ---------- Original Method ----------
        //throw new FileNotFoundException("No files supported by provider at "
                //+ uri);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.796 -0400", hash_original_method = "58BEA9E66A4FD3FC19246F4A2CA5B928", hash_generated_method = "C888610A939607E6CF471741E804F4E7")
    public AssetFileDescriptor openAssetFile(Uri uri, String mode) throws FileNotFoundException {
        addTaint(mode.getTaint());
        addTaint(uri.getTaint());
        ParcelFileDescriptor fd = openFile(uri, mode);
AssetFileDescriptor varA57245475EB9DCE6168AA22F54422F97_904246781 =         fd != null ? new AssetFileDescriptor(fd, 0, -1) : null;
        varA57245475EB9DCE6168AA22F54422F97_904246781.addTaint(taint);
        return varA57245475EB9DCE6168AA22F54422F97_904246781;
        // ---------- Original Method ----------
        //ParcelFileDescriptor fd = openFile(uri, mode);
        //return fd != null ? new AssetFileDescriptor(fd, 0, -1) : null;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.797 -0400", hash_original_method = "B77C082B2FC41ABB2AC9CAAF0861BB6A", hash_generated_method = "0A2ED894F72D94BA735F74663C36368C")
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
            } //End block
            if(count == 0)            
            {
                FileNotFoundException var803CF12C6BFA3F6E4495A8A2D15BF172_1528789551 = new FileNotFoundException("No entry for " + uri);
                var803CF12C6BFA3F6E4495A8A2D15BF172_1528789551.addTaint(taint);
                throw var803CF12C6BFA3F6E4495A8A2D15BF172_1528789551;
            } //End block
            FileNotFoundException varCCB1A3D8F9EB0D95AA719F589741DB21_1741983052 = new FileNotFoundException("Multiple items at " + uri);
            varCCB1A3D8F9EB0D95AA719F589741DB21_1741983052.addTaint(taint);
            throw varCCB1A3D8F9EB0D95AA719F589741DB21_1741983052;
        } //End block
        c.moveToFirst();
        int i = c.getColumnIndex("_data");
        String path = (i >= 0 ? c.getString(i) : null);
        c.close();
        if(path == null)        
        {
            FileNotFoundException varBC179702CCC142CA58BA59421BCB8885_1720252136 = new FileNotFoundException("Column _data not found.");
            varBC179702CCC142CA58BA59421BCB8885_1720252136.addTaint(taint);
            throw varBC179702CCC142CA58BA59421BCB8885_1720252136;
        } //End block
        int modeBits = ContentResolver.modeToMode(uri, mode);
ParcelFileDescriptor varBAB37DE04A5B7A40E055BD5EA30CAC7D_977189396 =         ParcelFileDescriptor.open(new File(path), modeBits);
        varBAB37DE04A5B7A40E055BD5EA30CAC7D_977189396.addTaint(taint);
        return varBAB37DE04A5B7A40E055BD5EA30CAC7D_977189396;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.799 -0400", hash_original_method = "BEF8B956D915C9CD914319D11D9F55DF", hash_generated_method = "E4CDAA6EA618D1B6D9BEC52169B55C94")
    public String[] getStreamTypes(Uri uri, String mimeTypeFilter) {
        addTaint(mimeTypeFilter.getTaint());
        addTaint(uri.getTaint());
String[] var540C13E9E156B687226421B24F2DF178_793439806 =         null;
        var540C13E9E156B687226421B24F2DF178_793439806.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_793439806;
        // ---------- Original Method ----------
        //return null;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.800 -0400", hash_original_method = "4E83B7632E2F0C6C101685B3A453F6C7", hash_generated_method = "F86504E275731F8D1393D665773D5D9C")
    public AssetFileDescriptor openTypedAssetFile(Uri uri, String mimeTypeFilter, Bundle opts) throws FileNotFoundException {
        addTaint(opts.getTaint());
        addTaint(mimeTypeFilter.getTaint());
        addTaint(uri.getTaint());
        if("*/*".equals(mimeTypeFilter))        
        {
AssetFileDescriptor varCFD1DF6ECCCC8237B83DC46BE40175A9_2135983325 =             openAssetFile(uri, "r");
            varCFD1DF6ECCCC8237B83DC46BE40175A9_2135983325.addTaint(taint);
            return varCFD1DF6ECCCC8237B83DC46BE40175A9_2135983325;
        } //End block
        String baseType = getType(uri);
        if(baseType != null && ClipDescription.compareMimeTypes(baseType, mimeTypeFilter))        
        {
AssetFileDescriptor varCFD1DF6ECCCC8237B83DC46BE40175A9_100166592 =             openAssetFile(uri, "r");
            varCFD1DF6ECCCC8237B83DC46BE40175A9_100166592.addTaint(taint);
            return varCFD1DF6ECCCC8237B83DC46BE40175A9_100166592;
        } //End block
        FileNotFoundException var9704B4F4149597D88475264DFB8FD1D7_1016243839 = new FileNotFoundException("Can't open " + uri + " as type " + mimeTypeFilter);
        var9704B4F4149597D88475264DFB8FD1D7_1016243839.addTaint(taint);
        throw var9704B4F4149597D88475264DFB8FD1D7_1016243839;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.801 -0400", hash_original_method = "BC63CE555A1B156ABB3D2B022F0E90CE", hash_generated_method = "1600271E293F4C12749AC8508682DA08")
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
ParcelFileDescriptor var0A32740862433E6F4A2B631AD9C65F9E_1518019049 =             fds[0];
            var0A32740862433E6F4A2B631AD9C65F9E_1518019049.addTaint(taint);
            return var0A32740862433E6F4A2B631AD9C65F9E_1518019049;
        } //End block
        catch (IOException e)
        {
            FileNotFoundException var9BBB3DDA0FD7526E4D3B8A7AF6DADB25_861167959 = new FileNotFoundException("failure making pipe");
            var9BBB3DDA0FD7526E4D3B8A7AF6DADB25_861167959.addTaint(taint);
            throw var9BBB3DDA0FD7526E4D3B8A7AF6DADB25_861167959;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.802 -0400", hash_original_method = "5727E4CF3A64759CEEBA62DE047537C3", hash_generated_method = "9A2ABAF5BD2C8C5B95291BC9FB8D70E8")
    protected boolean isTemporary() {
        boolean var68934A3E9455FA72420237EB05902327_588489666 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_896479724 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_896479724;
        // ---------- Original Method ----------
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.803 -0400", hash_original_method = "883A061900350051FBA62F6F6FD9E085", hash_generated_method = "46A8624B861864E277103565CF688A6E")
    public IContentProvider getIContentProvider() {
IContentProvider varF2CB7A1EAFE712633AC71AFDD720A221_158837669 =         mTransport;
        varF2CB7A1EAFE712633AC71AFDD720A221_158837669.addTaint(taint);
        return varF2CB7A1EAFE712633AC71AFDD720A221_158837669;
        // ---------- Original Method ----------
        //return mTransport;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.805 -0400", hash_original_method = "0A143494E98F1D73DE768E656190D91A", hash_generated_method = "9FA89A715BE7713F7EA224760E9A3174")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.806 -0400", hash_original_method = "E0DAC3050A9BAD12465D5076F1EE0420", hash_generated_method = "C9BFB1CEDD94CBB655EB1CB5BF1F5867")
    public ContentProviderResult[] applyBatch(ArrayList<ContentProviderOperation> operations) throws OperationApplicationException {
        addTaint(operations.getTaint());
        final int numOperations = operations.size();
        final ContentProviderResult[] results = new ContentProviderResult[numOperations];
for(int i = 0;i < numOperations;i++)
        {
            results[i] = operations.get(i).apply(this, results, i);
        } //End block
ContentProviderResult[] var238ECCC9872FFCA0B3C3DB83598FF044_1734360218 =         results;
        var238ECCC9872FFCA0B3C3DB83598FF044_1734360218.addTaint(taint);
        return var238ECCC9872FFCA0B3C3DB83598FF044_1734360218;
        // ---------- Original Method ----------
        //final int numOperations = operations.size();
        //final ContentProviderResult[] results = new ContentProviderResult[numOperations];
        //for (int i = 0; i < numOperations; i++) {
            //results[i] = operations.get(i).apply(this, results, i);
        //}
        //return results;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.807 -0400", hash_original_method = "FDEF25FCA992321C96D9ED3D525FD124", hash_generated_method = "7C653215BB1BA46A7F976FB492B91F6B")
    public Bundle call(String method, String arg, Bundle extras) {
        addTaint(extras.getTaint());
        addTaint(arg.getTaint());
        addTaint(method.getTaint());
Bundle var540C13E9E156B687226421B24F2DF178_710145303 =         null;
        var540C13E9E156B687226421B24F2DF178_710145303.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_710145303;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.807 -0400", hash_original_method = "D03BEE67B09D4B1E8C6E9290C7758C5F", hash_generated_method = "B150A4E1DC19A0FA6E8508D3F3E8E47D")
    public void shutdown() {
        // ---------- Original Method ----------
        //Log.w(TAG, "implement ContentProvider shutdown() to make sure all database " +
                //"connections are gracefully shutdown");
    }

    
    class Transport extends ContentProviderNative {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.808 -0400", hash_original_method = "E8AA98EC6BE3CDFD6C8382F7CC9C6C6F", hash_generated_method = "E8AA98EC6BE3CDFD6C8382F7CC9C6C6F")
        public Transport ()
        {
            //Synthesized constructor
        }


                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.808 -0400", hash_original_method = "D85CC82248E7B34649DA1C02380D9E2C", hash_generated_method = "E01166BF7B14FF90077122B48799BA33")
         ContentProvider getContentProvider() {
ContentProvider varC964AD0B3FDDC5F592DBC6B2E7A7AF92_1242787189 =             ContentProvider.this;
            varC964AD0B3FDDC5F592DBC6B2E7A7AF92_1242787189.addTaint(taint);
            return varC964AD0B3FDDC5F592DBC6B2E7A7AF92_1242787189;
            // ---------- Original Method ----------
            //return ContentProvider.this;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.808 -0400", hash_original_method = "157A3AC2CED86E999B16E7CDFBD5AE31", hash_generated_method = "7C169116488E43F1AC706B9D1269C758")
        @Override
        public String getProviderName() {
String varED11270F9E13FAAC581C2CCBE7C2F48C_584402261 =             getContentProvider().getClass().getName();
            varED11270F9E13FAAC581C2CCBE7C2F48C_584402261.addTaint(taint);
            return varED11270F9E13FAAC581C2CCBE7C2F48C_584402261;
            // ---------- Original Method ----------
            //return getContentProvider().getClass().getName();
        }

        
                @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.809 -0400", hash_original_method = "C07C2CC52F2EA8ADD199B18CF964D47B", hash_generated_method = "19525FBC7737D4F9B5460AAA69EFAFE9")
        public Cursor query(Uri uri, String[] projection,
                String selection, String[] selectionArgs, String sortOrder) {
            addTaint(sortOrder.getTaint());
            addTaint(selectionArgs[0].getTaint());
            addTaint(selection.getTaint());
            addTaint(projection[0].getTaint());
            addTaint(uri.getTaint());
            enforceReadPermission(uri);
Cursor var5BED765E00858C646DF14C0893EB6B41_776563674 =             ContentProvider.this.query(uri, projection, selection,
                    selectionArgs, sortOrder);
            var5BED765E00858C646DF14C0893EB6B41_776563674.addTaint(taint);
            return var5BED765E00858C646DF14C0893EB6B41_776563674;
            // ---------- Original Method ----------
            //enforceReadPermission(uri);
            //return ContentProvider.this.query(uri, projection, selection,
                    //selectionArgs, sortOrder);
        }

        
                @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.810 -0400", hash_original_method = "BE9D1875DBA635C7BA04B42A3E893DA2", hash_generated_method = "45C2143CC76EDE46B45B7DF4238DAE30")
        public String getType(Uri uri) {
            addTaint(uri.getTaint());
String var5B9B0993930B2F3B1729C74908362C2C_150895019 =             ContentProvider.this.getType(uri);
            var5B9B0993930B2F3B1729C74908362C2C_150895019.addTaint(taint);
            return var5B9B0993930B2F3B1729C74908362C2C_150895019;
            // ---------- Original Method ----------
            //return ContentProvider.this.getType(uri);
        }

        
                @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.811 -0400", hash_original_method = "2D883DF9190F17ADC9F3F05EDAD4CA9E", hash_generated_method = "928902E0C9910A5C6EFFCACF03117D44")
        public Uri insert(Uri uri, ContentValues initialValues) {
            addTaint(initialValues.getTaint());
            addTaint(uri.getTaint());
            enforceWritePermission(uri);
Uri var8209C23EA48B1C7744571EB5BC75334C_1231819667 =             ContentProvider.this.insert(uri, initialValues);
            var8209C23EA48B1C7744571EB5BC75334C_1231819667.addTaint(taint);
            return var8209C23EA48B1C7744571EB5BC75334C_1231819667;
            // ---------- Original Method ----------
            //enforceWritePermission(uri);
            //return ContentProvider.this.insert(uri, initialValues);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.812 -0400", hash_original_method = "9C9FBE82EEDFD6251BF8F9B258727CC2", hash_generated_method = "5191A0421D5D348BCE9C4F3BBD474F76")
        public int bulkInsert(Uri uri, ContentValues[] initialValues) {
            addTaint(initialValues[0].getTaint());
            addTaint(uri.getTaint());
            enforceWritePermission(uri);
            int var74D767A98B755F12AF9D899F2667AC64_891120490 = (ContentProvider.this.bulkInsert(uri, initialValues));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_228941535 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_228941535;
            // ---------- Original Method ----------
            //enforceWritePermission(uri);
            //return ContentProvider.this.bulkInsert(uri, initialValues);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.813 -0400", hash_original_method = "8198345EE7E6B486A1CABFB05410D25E", hash_generated_method = "7512E0A01B13660BF94CB2C6A0FAD732")
        public ContentProviderResult[] applyBatch(ArrayList<ContentProviderOperation> operations) throws OperationApplicationException {
            addTaint(operations.getTaint());
for(ContentProviderOperation operation : operations)
            {
                if(operation.isReadOperation())                
                {
                    enforceReadPermission(operation.getUri());
                } //End block
                if(operation.isWriteOperation())                
                {
                    enforceWritePermission(operation.getUri());
                } //End block
            } //End block
ContentProviderResult[] var315BC8DBA4C3A0CFC21570E22B483988_568690353 =             ContentProvider.this.applyBatch(operations);
            var315BC8DBA4C3A0CFC21570E22B483988_568690353.addTaint(taint);
            return var315BC8DBA4C3A0CFC21570E22B483988_568690353;
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

        
                @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.814 -0400", hash_original_method = "9F536F247E1CDAAB23A0513292709CB1", hash_generated_method = "1C2948538F4698A67331FD3CD96E2F58")
        public int delete(Uri uri, String selection, String[] selectionArgs) {
            addTaint(selectionArgs[0].getTaint());
            addTaint(selection.getTaint());
            addTaint(uri.getTaint());
            enforceWritePermission(uri);
            int var2F009A06449C223FD617D5D3F4FF4E6C_2115006861 = (ContentProvider.this.delete(uri, selection, selectionArgs));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1373843469 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1373843469;
            // ---------- Original Method ----------
            //enforceWritePermission(uri);
            //return ContentProvider.this.delete(uri, selection, selectionArgs);
        }

        
                @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.815 -0400", hash_original_method = "A4C580D76A4BE435F05FDF3658D031E7", hash_generated_method = "D68516697A9244142486C8688A4AD3F9")
        public int update(Uri uri, ContentValues values, String selection,
                String[] selectionArgs) {
            addTaint(selectionArgs[0].getTaint());
            addTaint(selection.getTaint());
            addTaint(values.getTaint());
            addTaint(uri.getTaint());
            enforceWritePermission(uri);
            int varECC72D9487713202C2D2D0C54119773F_509224028 = (ContentProvider.this.update(uri, values, selection, selectionArgs));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2076276184 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2076276184;
            // ---------- Original Method ----------
            //enforceWritePermission(uri);
            //return ContentProvider.this.update(uri, values, selection, selectionArgs);
        }

        
                @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.816 -0400", hash_original_method = "A3B5DD3A6EF0BED7F3109E14959CA5EF", hash_generated_method = "CDDF3C677EE7DFD9C4F0F51B61823B30")
        public ParcelFileDescriptor openFile(Uri uri, String mode) throws FileNotFoundException {
            addTaint(mode.getTaint());
            addTaint(uri.getTaint());
            if(mode != null && mode.startsWith("rw"))            
            enforceWritePermission(uri);
            else
            enforceReadPermission(uri);
ParcelFileDescriptor var92B3985CCA3575439B2C1D8C87C145BD_1110613964 =             ContentProvider.this.openFile(uri, mode);
            var92B3985CCA3575439B2C1D8C87C145BD_1110613964.addTaint(taint);
            return var92B3985CCA3575439B2C1D8C87C145BD_1110613964;
            // ---------- Original Method ----------
            //if (mode != null && mode.startsWith("rw")) enforceWritePermission(uri);
            //else enforceReadPermission(uri);
            //return ContentProvider.this.openFile(uri, mode);
        }

        
                @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.817 -0400", hash_original_method = "9FC3CF0D01502503E6A8E959789D91E0", hash_generated_method = "274D9CC0A74F90EB4ECA63981024C6F2")
        public AssetFileDescriptor openAssetFile(Uri uri, String mode) throws FileNotFoundException {
            addTaint(mode.getTaint());
            addTaint(uri.getTaint());
            if(mode != null && mode.startsWith("rw"))            
            enforceWritePermission(uri);
            else
            enforceReadPermission(uri);
AssetFileDescriptor var55EAB6F02B22D2BCFE59AE1EC2B8FA58_1528724256 =             ContentProvider.this.openAssetFile(uri, mode);
            var55EAB6F02B22D2BCFE59AE1EC2B8FA58_1528724256.addTaint(taint);
            return var55EAB6F02B22D2BCFE59AE1EC2B8FA58_1528724256;
            // ---------- Original Method ----------
            //if (mode != null && mode.startsWith("rw")) enforceWritePermission(uri);
            //else enforceReadPermission(uri);
            //return ContentProvider.this.openAssetFile(uri, mode);
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.820 -0400", hash_original_method = "F8D45B029854B0071CB25BB646C6653D", hash_generated_method = "C66F7DEE9C872474E2EFF5F3C4EADF6B")
        public Bundle call(String method, String arg, Bundle extras) {
            addTaint(extras.getTaint());
            addTaint(arg.getTaint());
            addTaint(method.getTaint());
Bundle varE50CAEED571D4508C1B829BFA060E554_2074597298 =             ContentProvider.this.call(method, arg, extras);
            varE50CAEED571D4508C1B829BFA060E554_2074597298.addTaint(taint);
            return varE50CAEED571D4508C1B829BFA060E554_2074597298;
            // ---------- Original Method ----------
            //return ContentProvider.this.call(method, arg, extras);
        }

        
                @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.821 -0400", hash_original_method = "8E1F3128EE5808B485D05EE809576B99", hash_generated_method = "3A959FFD607D75300DEC01C922D6EBCB")
        @Override
        public String[] getStreamTypes(Uri uri, String mimeTypeFilter) {
            addTaint(mimeTypeFilter.getTaint());
            addTaint(uri.getTaint());
String[] var9C4CD0F20752BB51B9C837E84E409BD1_624698583 =             ContentProvider.this.getStreamTypes(uri, mimeTypeFilter);
            var9C4CD0F20752BB51B9C837E84E409BD1_624698583.addTaint(taint);
            return var9C4CD0F20752BB51B9C837E84E409BD1_624698583;
            // ---------- Original Method ----------
            //return ContentProvider.this.getStreamTypes(uri, mimeTypeFilter);
        }

        
                @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.822 -0400", hash_original_method = "C18E75C38B25261EF8CFA8F7B83C6E2D", hash_generated_method = "42F49F0AFA313FF38F62638152DFB8D2")
        @Override
        public AssetFileDescriptor openTypedAssetFile(Uri uri, String mimeType, Bundle opts) throws FileNotFoundException {
            addTaint(opts.getTaint());
            addTaint(mimeType.getTaint());
            addTaint(uri.getTaint());
            enforceReadPermission(uri);
AssetFileDescriptor varD029E2BF2AD851D0E5EAF5BF04D93B06_142278736 =             ContentProvider.this.openTypedAssetFile(uri, mimeType, opts);
            varD029E2BF2AD851D0E5EAF5BF04D93B06_142278736.addTaint(taint);
            return varD029E2BF2AD851D0E5EAF5BF04D93B06_142278736;
            // ---------- Original Method ----------
            //enforceReadPermission(uri);
            //return ContentProvider.this.openTypedAssetFile(uri, mimeType, opts);
        }

        
                @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.823 -0400", hash_original_method = "E57399204B1619B526E92C84388A407F", hash_generated_method = "FAE33D2F349D1E8E2627A2CD2A10103B")
        private void enforceReadPermission(Uri uri) {
            addTaint(uri.getTaint());
            final int uid = Binder.getCallingUid();
            if(uid == mMyUid)            
            {
                return;
            } //End block
            final Context context = getContext();
            final String rperm = getReadPermission();
            final int pid = Binder.getCallingPid();
            if(mExported && (rperm == null
                    || context.checkPermission(rperm, pid, uid)
                    == PackageManager.PERMISSION_GRANTED))            
            {
                return;
            } //End block
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
                        } //End block
                    } //End block
                } //End block
            } //End block
            if(context.checkUriPermission(uri, pid, uid,
                    Intent.FLAG_GRANT_READ_URI_PERMISSION)
                    == PackageManager.PERMISSION_GRANTED)            
            {
                return;
            } //End block
            String msg = "Permission Denial: reading "
                    + ContentProvider.this.getClass().getName()
                    + " uri " + uri + " from pid=" + Binder.getCallingPid()
                    + ", uid=" + Binder.getCallingUid()
                    + " requires " + rperm;
            SecurityException varC5EE93F1F5A2A36B7796B378C69384FB_1141768634 = new SecurityException(msg);
            varC5EE93F1F5A2A36B7796B378C69384FB_1141768634.addTaint(taint);
            throw varC5EE93F1F5A2A36B7796B378C69384FB_1141768634;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
                @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.826 -0400", hash_original_method = "329C06E4068EEDF4ECCAEC3BA5AB45CE", hash_generated_method = "2C24E8671BCBD9C82D003E6BC222B131")
        private boolean hasWritePermission(Uri uri) {
            addTaint(uri.getTaint());
            final int uid = Binder.getCallingUid();
            if(uid == mMyUid)            
            {
                boolean varB326B5062B2F0E69046810717534CB09_1277758267 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_975972820 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_975972820;
            } //End block
            final Context context = getContext();
            final String wperm = getWritePermission();
            final int pid = Binder.getCallingPid();
            if(mExported && (wperm == null
                    || context.checkPermission(wperm, pid, uid)
                    == PackageManager.PERMISSION_GRANTED))            
            {
                boolean varB326B5062B2F0E69046810717534CB09_2034537182 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_906799238 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_906799238;
            } //End block
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
                            boolean varB326B5062B2F0E69046810717534CB09_444471798 = (true);
                                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_235913529 = getTaintBoolean();
                            return var84E2C64F38F78BA3EA5C905AB5A2DA27_235913529;
                        } //End block
                    } //End block
                } //End block
            } //End block
            if(context.checkUriPermission(uri, pid, uid,
                    Intent.FLAG_GRANT_WRITE_URI_PERMISSION)
                    == PackageManager.PERMISSION_GRANTED)            
            {
                boolean varB326B5062B2F0E69046810717534CB09_53489241 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1252220018 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1252220018;
            } //End block
            boolean var68934A3E9455FA72420237EB05902327_451210685 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_571784583 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_571784583;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
                @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.827 -0400", hash_original_method = "7CEC600BB70206A61DA89C0C0D2014C1", hash_generated_method = "699A190FB6B3D12861B2F3BF1336EEE8")
        private void enforceWritePermission(Uri uri) {
            addTaint(uri.getTaint());
            if(hasWritePermission(uri))            
            {
                return;
            } //End block
            String msg = "Permission Denial: writing "
                    + ContentProvider.this.getClass().getName()
                    + " uri " + uri + " from pid=" + Binder.getCallingPid()
                    + ", uid=" + Binder.getCallingUid()
                    + " requires " + getWritePermission();
            SecurityException varC5EE93F1F5A2A36B7796B378C69384FB_1592148872 = new SecurityException(msg);
            varC5EE93F1F5A2A36B7796B378C69384FB_1592148872.addTaint(taint);
            throw varC5EE93F1F5A2A36B7796B378C69384FB_1592148872;
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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.828 -0400", hash_original_field = "D9DEAD4FE5612F0F829FC72D942CF904", hash_generated_field = "DA15E6471BF02EF7674EB3675F3C058F")

    private static final String TAG = "ContentProvider";
}

