package android.content;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
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
    private static final String TAG = "ContentProvider";
    private Context mContext = null;
    private int mMyUid;
    private String mReadPermission;
    private String mWritePermission;
    private PathPermission[] mPathPermissions;
    private boolean mExported;
    private Transport mTransport = new Transport();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.303 -0400", hash_original_method = "F039A73ADD81439EFEE4572A926905FF", hash_generated_method = "49043F39A762875A4AD9FF10C4D6D2BE")
    @DSModeled(DSC.SAFE)
    public ContentProvider() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.304 -0400", hash_original_method = "40393AF8078D8D6FEE29B00460ADF530", hash_generated_method = "BFAD397FCF68C68F7F7EF698CD1905E9")
    @DSModeled(DSC.SAFE)
    public ContentProvider(
            Context context,
            String readPermission,
            String writePermission,
            PathPermission[] pathPermissions) {
        dsTaint.addTaint(writePermission);
        dsTaint.addTaint(pathPermissions.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(readPermission);
        // ---------- Original Method ----------
        //mContext = context;
        //mReadPermission = readPermission;
        //mWritePermission = writePermission;
        //mPathPermissions = pathPermissions;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.304 -0400", hash_original_method = "78A656DFF4A6B0DA3835B9463B1DFC23", hash_generated_method = "18651F5EF5004371CFE478157CEAA5FB")
    public static ContentProvider coerceToLocalContentProvider(
            IContentProvider abstractInterface) {
        if (abstractInterface instanceof Transport) {
            return ((Transport)abstractInterface).getContentProvider();
        }
        return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.304 -0400", hash_original_method = "4F4EBC54D108D66F416C93B46580E117", hash_generated_method = "DBB43A20BBBE6CCCD86C4B46BDAF1D4B")
    @DSModeled(DSC.SAFE)
    public final Context getContext() {
        return (Context)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mContext;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.304 -0400", hash_original_method = "C738A12EDF7704A3BEC0DFE17330C819", hash_generated_method = "9C7164FF962103710EA46C82AFD6619A")
    @DSModeled(DSC.SAFE)
    protected final void setReadPermission(String permission) {
        dsTaint.addTaint(permission);
        // ---------- Original Method ----------
        //mReadPermission = permission;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.305 -0400", hash_original_method = "5C94FD95ADD3C0054247C1BF6F500E4F", hash_generated_method = "48054527114202E631770740C025D842")
    @DSModeled(DSC.SAFE)
    public final String getReadPermission() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mReadPermission;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.305 -0400", hash_original_method = "6A71B3652F16CF9160129E3EF306B0DC", hash_generated_method = "B8BEA14F6FA8EADB752CF9B6E3E055DB")
    @DSModeled(DSC.SAFE)
    protected final void setWritePermission(String permission) {
        dsTaint.addTaint(permission);
        // ---------- Original Method ----------
        //mWritePermission = permission;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.305 -0400", hash_original_method = "7A0A16A9FA1EB10AD9D087C65A3EFFB1", hash_generated_method = "3B89FDD7538FB2E37CA0D103FEC1A220")
    @DSModeled(DSC.SAFE)
    public final String getWritePermission() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mWritePermission;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.305 -0400", hash_original_method = "16570AF799E31BB65FFA9254DA0AB517", hash_generated_method = "42219B283AB858EF2A53438BFAF6DD49")
    @DSModeled(DSC.SAFE)
    protected final void setPathPermissions(PathPermission[] permissions) {
        dsTaint.addTaint(permissions.dsTaint);
        // ---------- Original Method ----------
        //mPathPermissions = permissions;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.306 -0400", hash_original_method = "E38FFC0E115EF293B9FB9C6179B78AA8", hash_generated_method = "BE5671A5DA1C3BC4045ED779DC03F45E")
    @DSModeled(DSC.SAFE)
    public final PathPermission[] getPathPermissions() {
        return (PathPermission[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mPathPermissions;
    }

    
    public abstract boolean onCreate();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.306 -0400", hash_original_method = "8287235C28E9D1E310027A2DDEB95FCD", hash_generated_method = "0111966F0794F2BC3F7978E54DEB39B2")
    @DSModeled(DSC.SAFE)
    public void onConfigurationChanged(Configuration newConfig) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(newConfig.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.306 -0400", hash_original_method = "4F0E380BE715BF5B2ECCDB1794C8905E", hash_generated_method = "A3C692658B31DDB49D7C6E6054846E8F")
    @DSModeled(DSC.SAFE)
    public void onLowMemory() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.306 -0400", hash_original_method = "3AE0D4ACEA3D5F3B779A378D5AB27A6A", hash_generated_method = "CBC416E0369565BE2BA32918CD374171")
    @DSModeled(DSC.SAFE)
    public void onTrimMemory(int level) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(level);
        // ---------- Original Method ----------
    }

    
    public abstract Cursor query(Uri uri, String[] projection,
            String selection, String[] selectionArgs, String sortOrder);

    
    public abstract String getType(Uri uri);

    
    public abstract Uri insert(Uri uri, ContentValues values);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.307 -0400", hash_original_method = "C678349FF8875CB9D22305FF9A5474DD", hash_generated_method = "A7DF7C8490197BB836E7CDB16C3684EA")
    @DSModeled(DSC.SPEC)
    public int bulkInsert(Uri uri, ContentValues[] values) {
        dsTaint.addTaint(values.dsTaint);
        dsTaint.addTaint(uri.dsTaint);
        int numValues;
        numValues = values.length;
        {
            int i;
            i = 0;
            {
                insert(uri, values[i]);
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.307 -0400", hash_original_method = "DCC5B23EAE3536B2EEFB8F5A1AA89B13", hash_generated_method = "1D79F945735CCA48BE140B42A1304B0B")
    @DSModeled(DSC.SPEC)
    public ParcelFileDescriptor openFile(Uri uri, String mode) throws FileNotFoundException {
        dsTaint.addTaint(uri.dsTaint);
        dsTaint.addTaint(mode);
        throw new FileNotFoundException("No files supported by provider at "
                + uri);
        return (ParcelFileDescriptor)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new FileNotFoundException("No files supported by provider at "
                //+ uri);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.307 -0400", hash_original_method = "58BEA9E66A4FD3FC19246F4A2CA5B928", hash_generated_method = "875F290A53073953EBA178E8C6E72F2B")
    @DSModeled(DSC.SPEC)
    public AssetFileDescriptor openAssetFile(Uri uri, String mode) throws FileNotFoundException {
        dsTaint.addTaint(uri.dsTaint);
        dsTaint.addTaint(mode);
        ParcelFileDescriptor fd;
        fd = openFile(uri, mode);
        return (AssetFileDescriptor)dsTaint.getTaint();
        // ---------- Original Method ----------
        //ParcelFileDescriptor fd = openFile(uri, mode);
        //return fd != null ? new AssetFileDescriptor(fd, 0, -1) : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.308 -0400", hash_original_method = "B77C082B2FC41ABB2AC9CAAF0861BB6A", hash_generated_method = "6BC345B79C96412EBBDF0CC6000D25FB")
    @DSModeled(DSC.SPEC)
    protected final ParcelFileDescriptor openFileHelper(Uri uri,
            String mode) throws FileNotFoundException {
        dsTaint.addTaint(uri.dsTaint);
        dsTaint.addTaint(mode);
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
                throw new FileNotFoundException("No entry for " + uri);
            } //End block
            throw new FileNotFoundException("Multiple items at " + uri);
        } //End block
        c.moveToFirst();
        int i;
        i = c.getColumnIndex("_data");
        String path;
        path = (i >= 0 ? c.getString(i) : null);//DSFIXME:  CODE0008: Nested ternary operator in expression
        c.close();
        {
            throw new FileNotFoundException("Column _data not found.");
        } //End block
        int modeBits;
        modeBits = ContentResolver.modeToMode(uri, mode);
        ParcelFileDescriptor var67B1B3A0DB860173C5A90A5A2CE49BDB_49155600 = (ParcelFileDescriptor.open(new File(path), modeBits));
        return (ParcelFileDescriptor)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.308 -0400", hash_original_method = "BEF8B956D915C9CD914319D11D9F55DF", hash_generated_method = "F124E8ECECF84DC1428BEFF337618037")
    @DSModeled(DSC.SPEC)
    public String[] getStreamTypes(Uri uri, String mimeTypeFilter) {
        dsTaint.addTaint(mimeTypeFilter);
        dsTaint.addTaint(uri.dsTaint);
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.309 -0400", hash_original_method = "4E83B7632E2F0C6C101685B3A453F6C7", hash_generated_method = "A0175A9253D79F49578E8A937108605A")
    @DSModeled(DSC.SPEC)
    public AssetFileDescriptor openTypedAssetFile(Uri uri, String mimeTypeFilter, Bundle opts) throws FileNotFoundException {
        dsTaint.addTaint(opts.dsTaint);
        dsTaint.addTaint(mimeTypeFilter);
        dsTaint.addTaint(uri.dsTaint);
        {
            boolean var4C01B825A6B874B80EFDC93B5CFAC70D_2017450588 = ("*/*".equals(mimeTypeFilter));
            {
                AssetFileDescriptor var3299E6D6C5525EC6ED7614AA40265F97_1922373422 = (openAssetFile(uri, "r"));
            } //End block
        } //End collapsed parenthetic
        String baseType;
        baseType = getType(uri);
        {
            boolean var0B401450AF28FAA821E202DA316A98D6_2128560204 = (baseType != null && ClipDescription.compareMimeTypes(baseType, mimeTypeFilter));
            {
                AssetFileDescriptor var3299E6D6C5525EC6ED7614AA40265F97_1080159044 = (openAssetFile(uri, "r"));
            } //End block
        } //End collapsed parenthetic
        throw new FileNotFoundException("Can't open " + uri + " as type " + mimeTypeFilter);
        return (AssetFileDescriptor)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.309 -0400", hash_original_method = "BC63CE555A1B156ABB3D2B022F0E90CE", hash_generated_method = "55448A7347DD977DBE358CB8341F5A3E")
    @DSModeled(DSC.SPEC)
    public <T> ParcelFileDescriptor openPipeHelper(final Uri uri, final String mimeType,
            final Bundle opts, final T args, final PipeDataWriter<T> func) throws FileNotFoundException {
        dsTaint.addTaint(opts.dsTaint);
        dsTaint.addTaint(args.dsTaint);
        dsTaint.addTaint(func.dsTaint);
        dsTaint.addTaint(uri.dsTaint);
        dsTaint.addTaint(mimeType);
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
        } //End block
        catch (IOException e)
        {
            throw new FileNotFoundException("failure making pipe");
        } //End block
        return (ParcelFileDescriptor)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.309 -0400", hash_original_method = "5727E4CF3A64759CEEBA62DE047537C3", hash_generated_method = "44F12669F2F62B34C5A728BF4AF436E5")
    @DSModeled(DSC.SAFE)
    protected boolean isTemporary() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.310 -0400", hash_original_method = "883A061900350051FBA62F6F6FD9E085", hash_generated_method = "8F1DEC422E66C1A716E1749638AF1951")
    @DSModeled(DSC.SAFE)
    public IContentProvider getIContentProvider() {
        return (IContentProvider)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mTransport;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.310 -0400", hash_original_method = "0A143494E98F1D73DE768E656190D91A", hash_generated_method = "3A67D9F3225C1743867EBCA62F8E9FD9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void attachInfo(Context context, ProviderInfo info) {
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(info.dsTaint);
        AsyncTask.init();
        {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.310 -0400", hash_original_method = "E0DAC3050A9BAD12465D5076F1EE0420", hash_generated_method = "60E6B2EE53C1746A4BF620E95FEE766F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ContentProviderResult[] applyBatch(ArrayList<ContentProviderOperation> operations) throws OperationApplicationException {
        dsTaint.addTaint(operations.dsTaint);
        final int numOperations;
        numOperations = operations.size();
        final ContentProviderResult[] results;
        results = new ContentProviderResult[numOperations];
        {
            int i;
            i = 0;
            {
                results[i] = operations.get(i).apply(this, results, i);
            } //End block
        } //End collapsed parenthetic
        return (ContentProviderResult[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //final int numOperations = operations.size();
        //final ContentProviderResult[] results = new ContentProviderResult[numOperations];
        //for (int i = 0; i < numOperations; i++) {
            //results[i] = operations.get(i).apply(this, results, i);
        //}
        //return results;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.310 -0400", hash_original_method = "FDEF25FCA992321C96D9ED3D525FD124", hash_generated_method = "99B41B22697776E4128FCB0EAF4C2E18")
    @DSModeled(DSC.SAFE)
    public Bundle call(String method, String arg, Bundle extras) {
        dsTaint.addTaint(arg);
        dsTaint.addTaint(method);
        dsTaint.addTaint(extras.dsTaint);
        return (Bundle)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.311 -0400", hash_original_method = "D03BEE67B09D4B1E8C6E9290C7758C5F", hash_generated_method = "023392064AFE8C2CBA93E1C808E4F473")
    @DSModeled(DSC.SAFE)
    public void shutdown() {
        // ---------- Original Method ----------
        //Log.w(TAG, "implement ContentProvider shutdown() to make sure all database " +
                //"connections are gracefully shutdown");
    }

    
    class Transport extends ContentProviderNative {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.311 -0400", hash_original_method = "D85CC82248E7B34649DA1C02380D9E2C", hash_generated_method = "1C1CD701941E9FB48845593EC697B475")
        @DSModeled(DSC.SAFE)
         ContentProvider getContentProvider() {
            return (ContentProvider)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return ContentProvider.this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.311 -0400", hash_original_method = "157A3AC2CED86E999B16E7CDFBD5AE31", hash_generated_method = "1F65E1A8A40E1B35E0530463BEA11608")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public String getProviderName() {
            String var157404E5DCFB8FC2E334CF3E487E595B_10598470 = (getContentProvider().getClass().getName());
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return getContentProvider().getClass().getName();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.312 -0400", hash_original_method = "C07C2CC52F2EA8ADD199B18CF964D47B", hash_generated_method = "95AB8D7D22170BB33EEE2141185F99DC")
        @DSModeled(DSC.SPEC)
        public Cursor query(Uri uri, String[] projection,
                String selection, String[] selectionArgs, String sortOrder) {
            dsTaint.addTaint(selectionArgs);
            dsTaint.addTaint(sortOrder);
            dsTaint.addTaint(projection);
            dsTaint.addTaint(uri.dsTaint);
            dsTaint.addTaint(selection);
            enforceReadPermission(uri);
            Cursor var5C28E3328B10B24ECF53D389C220FA30_868856314 = (ContentProvider.this.query(uri, projection, selection,
                    selectionArgs, sortOrder));
            return (Cursor)dsTaint.getTaint();
            // ---------- Original Method ----------
            //enforceReadPermission(uri);
            //return ContentProvider.this.query(uri, projection, selection,
                    //selectionArgs, sortOrder);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.312 -0400", hash_original_method = "BE9D1875DBA635C7BA04B42A3E893DA2", hash_generated_method = "E1E8D08207227ED2B47488093AC2CB9B")
        @DSModeled(DSC.SPEC)
        public String getType(Uri uri) {
            dsTaint.addTaint(uri.dsTaint);
            String var6951334A90CE09A089A1C7A59067C6AC_1463206997 = (ContentProvider.this.getType(uri));
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return ContentProvider.this.getType(uri);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.312 -0400", hash_original_method = "2D883DF9190F17ADC9F3F05EDAD4CA9E", hash_generated_method = "328E11FA91081B1737C9B9BA949094DC")
        @DSModeled(DSC.SPEC)
        public Uri insert(Uri uri, ContentValues initialValues) {
            dsTaint.addTaint(initialValues.dsTaint);
            dsTaint.addTaint(uri.dsTaint);
            enforceWritePermission(uri);
            Uri varC19F7C6D0C2A6285D0C6DBA03A193244_426163927 = (ContentProvider.this.insert(uri, initialValues));
            return (Uri)dsTaint.getTaint();
            // ---------- Original Method ----------
            //enforceWritePermission(uri);
            //return ContentProvider.this.insert(uri, initialValues);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.312 -0400", hash_original_method = "9C9FBE82EEDFD6251BF8F9B258727CC2", hash_generated_method = "15DA282841460BF2ACDE453189599335")
        @DSModeled(DSC.SPEC)
        public int bulkInsert(Uri uri, ContentValues[] initialValues) {
            dsTaint.addTaint(initialValues.dsTaint);
            dsTaint.addTaint(uri.dsTaint);
            enforceWritePermission(uri);
            int var356BE9FE6F30A259688B8E3862579DF5_1102218416 = (ContentProvider.this.bulkInsert(uri, initialValues));
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //enforceWritePermission(uri);
            //return ContentProvider.this.bulkInsert(uri, initialValues);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.313 -0400", hash_original_method = "8198345EE7E6B486A1CABFB05410D25E", hash_generated_method = "AA5112356661AB287F062F401D9A1D9A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public ContentProviderResult[] applyBatch(ArrayList<ContentProviderOperation> operations) throws OperationApplicationException {
            dsTaint.addTaint(operations.dsTaint);
            {
                Iterator<ContentProviderOperation> seatecAstronomy42 = operations.iterator();
                seatecAstronomy42.hasNext();
                ContentProviderOperation operation = seatecAstronomy42.next();
                {
                    {
                        boolean var648C2431FEB36CA6BCD4B44ED4DEFABF_664778544 = (operation.isReadOperation());
                        {
                            enforceReadPermission(operation.getUri());
                        } //End block
                    } //End collapsed parenthetic
                    {
                        boolean var76F7573D9527D4C4854BC03A7AAE3020_1604570264 = (operation.isWriteOperation());
                        {
                            enforceWritePermission(operation.getUri());
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            ContentProviderResult[] var68F17EF28B31B0A51FD301395D584848_169347665 = (ContentProvider.this.applyBatch(operations));
            return (ContentProviderResult[])dsTaint.getTaint();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.313 -0400", hash_original_method = "9F536F247E1CDAAB23A0513292709CB1", hash_generated_method = "903C8BE3A5A5D5190C0D2D16806C1478")
        @DSModeled(DSC.SPEC)
        public int delete(Uri uri, String selection, String[] selectionArgs) {
            dsTaint.addTaint(selectionArgs);
            dsTaint.addTaint(uri.dsTaint);
            dsTaint.addTaint(selection);
            enforceWritePermission(uri);
            int var139826D116DF5B4480C4A435A77A7184_1184139143 = (ContentProvider.this.delete(uri, selection, selectionArgs));
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //enforceWritePermission(uri);
            //return ContentProvider.this.delete(uri, selection, selectionArgs);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.314 -0400", hash_original_method = "A4C580D76A4BE435F05FDF3658D031E7", hash_generated_method = "88514185648F3D3867099F0A0772547D")
        @DSModeled(DSC.SPEC)
        public int update(Uri uri, ContentValues values, String selection,
                String[] selectionArgs) {
            dsTaint.addTaint(values.dsTaint);
            dsTaint.addTaint(selectionArgs);
            dsTaint.addTaint(uri.dsTaint);
            dsTaint.addTaint(selection);
            enforceWritePermission(uri);
            int varA1651BA01E90DA8CC721F5ADFBEC3CCE_851054564 = (ContentProvider.this.update(uri, values, selection, selectionArgs));
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //enforceWritePermission(uri);
            //return ContentProvider.this.update(uri, values, selection, selectionArgs);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.314 -0400", hash_original_method = "A3B5DD3A6EF0BED7F3109E14959CA5EF", hash_generated_method = "17C6A08FE5BC7D842382E65D1D353A2A")
        @DSModeled(DSC.SPEC)
        public ParcelFileDescriptor openFile(Uri uri, String mode) throws FileNotFoundException {
            dsTaint.addTaint(uri.dsTaint);
            dsTaint.addTaint(mode);
            {
                boolean var990C6E0E8CA37484AEEB3E9453431412_1414052755 = (mode != null && mode.startsWith("rw"));
                enforceWritePermission(uri);
                enforceReadPermission(uri);
            } //End collapsed parenthetic
            ParcelFileDescriptor varD99EE13A26134BDDDF7AE3B4D9706108_1810691704 = (ContentProvider.this.openFile(uri, mode));
            return (ParcelFileDescriptor)dsTaint.getTaint();
            // ---------- Original Method ----------
            //if (mode != null && mode.startsWith("rw")) enforceWritePermission(uri);
            //else enforceReadPermission(uri);
            //return ContentProvider.this.openFile(uri, mode);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.314 -0400", hash_original_method = "9FC3CF0D01502503E6A8E959789D91E0", hash_generated_method = "53BCDD27BE365B5DBF6A6AA7ACE29997")
        @DSModeled(DSC.SPEC)
        public AssetFileDescriptor openAssetFile(Uri uri, String mode) throws FileNotFoundException {
            dsTaint.addTaint(uri.dsTaint);
            dsTaint.addTaint(mode);
            {
                boolean var990C6E0E8CA37484AEEB3E9453431412_216096161 = (mode != null && mode.startsWith("rw"));
                enforceWritePermission(uri);
                enforceReadPermission(uri);
            } //End collapsed parenthetic
            AssetFileDescriptor var156C3BE019934EED263355F824014D8D_1449334360 = (ContentProvider.this.openAssetFile(uri, mode));
            return (AssetFileDescriptor)dsTaint.getTaint();
            // ---------- Original Method ----------
            //if (mode != null && mode.startsWith("rw")) enforceWritePermission(uri);
            //else enforceReadPermission(uri);
            //return ContentProvider.this.openAssetFile(uri, mode);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.315 -0400", hash_original_method = "F8D45B029854B0071CB25BB646C6653D", hash_generated_method = "502E30DD09B7055BA025B3E2913B63AD")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Bundle call(String method, String arg, Bundle extras) {
            dsTaint.addTaint(arg);
            dsTaint.addTaint(method);
            dsTaint.addTaint(extras.dsTaint);
            Bundle varFDBC882DA44662AEBDAD2C7F7CD77F71_1797481576 = (ContentProvider.this.call(method, arg, extras));
            return (Bundle)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return ContentProvider.this.call(method, arg, extras);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.315 -0400", hash_original_method = "8E1F3128EE5808B485D05EE809576B99", hash_generated_method = "114FF0423BF2B3E2380F924E84B8C5DE")
        @DSModeled(DSC.SPEC)
        @Override
        public String[] getStreamTypes(Uri uri, String mimeTypeFilter) {
            dsTaint.addTaint(mimeTypeFilter);
            dsTaint.addTaint(uri.dsTaint);
            String[] varE391CF4EE01C283958EEDB8CB78C3F40_1264773789 = (ContentProvider.this.getStreamTypes(uri, mimeTypeFilter));
            String[] retVal = new String[1];
            retVal[0] = dsTaint.getTaintString();
            return retVal;
            // ---------- Original Method ----------
            //return ContentProvider.this.getStreamTypes(uri, mimeTypeFilter);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.315 -0400", hash_original_method = "C18E75C38B25261EF8CFA8F7B83C6E2D", hash_generated_method = "35D70A0FF2055177A6A18511EC80B01E")
        @DSModeled(DSC.SPEC)
        @Override
        public AssetFileDescriptor openTypedAssetFile(Uri uri, String mimeType, Bundle opts) throws FileNotFoundException {
            dsTaint.addTaint(opts.dsTaint);
            dsTaint.addTaint(uri.dsTaint);
            dsTaint.addTaint(mimeType);
            enforceReadPermission(uri);
            AssetFileDescriptor var4B9E23BE2B847B6B8000BB162753ECFE_434585214 = (ContentProvider.this.openTypedAssetFile(uri, mimeType, opts));
            return (AssetFileDescriptor)dsTaint.getTaint();
            // ---------- Original Method ----------
            //enforceReadPermission(uri);
            //return ContentProvider.this.openTypedAssetFile(uri, mimeType, opts);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.316 -0400", hash_original_method = "E57399204B1619B526E92C84388A407F", hash_generated_method = "56EF3E7C718BB006FA8E1E2A044F736C")
        @DSModeled(DSC.SPEC)
        private void enforceReadPermission(Uri uri) {
            dsTaint.addTaint(uri.dsTaint);
            final int uid;
            uid = Binder.getCallingUid();
            final Context context;
            context = getContext();
            final String rperm;
            rperm = getReadPermission();
            final int pid;
            pid = Binder.getCallingPid();
            {
                boolean var11ABD9D7DE204BDD0582E9A702BF61D0_1441151216 = (mExported && (rperm == null
                    || context.checkPermission(rperm, pid, uid)
                    == PackageManager.PERMISSION_GRANTED));
            } //End collapsed parenthetic
            PathPermission[] pps;
            pps = getPathPermissions();
            {
                final String path;
                path = uri.getPath();
                int i;
                i = pps.length;
                {
                    i--;
                    final PathPermission pp;
                    pp = pps[i];
                    final String pprperm;
                    pprperm = pp.getReadPermission();
                    {
                        boolean var8BB21B2E5376BD16A5FBA892743AFFA3_1555229172 = (pprperm != null && pp.match(path));
                        {
                            {
                                boolean var02C738C973D4432B9D925BA7105A8603_1305067958 = (context.checkPermission(pprperm, pid, uid)
                                == PackageManager.PERMISSION_GRANTED);
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End block
            {
                boolean var13E8497132730133410D53B1797E5D75_1090806678 = (context.checkUriPermission(uri, pid, uid,
                    Intent.FLAG_GRANT_READ_URI_PERMISSION)
                    == PackageManager.PERMISSION_GRANTED);
            } //End collapsed parenthetic
            String msg;
            msg = "Permission Denial: reading "
                    + ContentProvider.this.getClass().getName()
                    + " uri " + uri + " from pid=" + Binder.getCallingPid()
                    + ", uid=" + Binder.getCallingUid()
                    + " requires " + rperm;
            throw new SecurityException(msg);
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.317 -0400", hash_original_method = "329C06E4068EEDF4ECCAEC3BA5AB45CE", hash_generated_method = "771BDB373190C8ED6B8EE7712666B6DB")
        @DSModeled(DSC.SPEC)
        private boolean hasWritePermission(Uri uri) {
            dsTaint.addTaint(uri.dsTaint);
            final int uid;
            uid = Binder.getCallingUid();
            final Context context;
            context = getContext();
            final String wperm;
            wperm = getWritePermission();
            final int pid;
            pid = Binder.getCallingPid();
            {
                boolean var87DDA52804F18883BB0B0CEC23D0EDFD_1917482088 = (mExported && (wperm == null
                    || context.checkPermission(wperm, pid, uid)
                    == PackageManager.PERMISSION_GRANTED));
            } //End collapsed parenthetic
            PathPermission[] pps;
            pps = getPathPermissions();
            {
                final String path;
                path = uri.getPath();
                int i;
                i = pps.length;
                {
                    i--;
                    final PathPermission pp;
                    pp = pps[i];
                    final String ppwperm;
                    ppwperm = pp.getWritePermission();
                    {
                        boolean var34B7F3F44D970AFAF42A1A9113878492_1786272440 = (ppwperm != null && pp.match(path));
                        {
                            {
                                boolean var635E8626A3F8934298FFDD63E2789994_658399977 = (context.checkPermission(ppwperm, pid, uid)
                                == PackageManager.PERMISSION_GRANTED);
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End block
            {
                boolean var88D202BB8B1056D8C1A0EE22D8D71A13_2099059410 = (context.checkUriPermission(uri, pid, uid,
                    Intent.FLAG_GRANT_WRITE_URI_PERMISSION)
                    == PackageManager.PERMISSION_GRANTED);
            } //End collapsed parenthetic
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.317 -0400", hash_original_method = "7CEC600BB70206A61DA89C0C0D2014C1", hash_generated_method = "E77ADD2B0D857EFEB54371567857572B")
        @DSModeled(DSC.SPEC)
        private void enforceWritePermission(Uri uri) {
            dsTaint.addTaint(uri.dsTaint);
            {
                boolean var24C3F28B334AD89BB610904621BC7375_125735505 = (hasWritePermission(uri));
            } //End collapsed parenthetic
            String msg;
            msg = "Permission Denial: writing "
                    + ContentProvider.this.getClass().getName()
                    + " uri " + uri + " from pid=" + Binder.getCallingPid()
                    + ", uid=" + Binder.getCallingUid()
                    + " requires " + getWritePermission();
            throw new SecurityException(msg);
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
    
}


