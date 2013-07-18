package android.content;

// Droidsafe Imports
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import android.accounts.Account;
import android.app.ActivityManagerNative;
import android.app.AppGlobals;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.database.CrossProcessCursorWrapper;
import android.database.Cursor;
import android.database.IContentObserver;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.EventLog;
import android.util.Log;
import dalvik.system.CloseGuard;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;
import droidsafe.concrete.DSCursor;

public abstract class ContentResolver {
    private final Random mRandom = new Random();
    private final Context mContext;
    
    @DSModeled(DSC.SPEC)
    public ContentResolver(Context context) {
        mContext = context;
    }

    
    protected abstract IContentProvider acquireProvider(Context c, String name);

    
    protected IContentProvider acquireExistingProvider(Context c, String name) {
        return acquireProvider(c, name);
    }

    
    public abstract boolean releaseProvider(IContentProvider icp);

    
    public final String getType(Uri url) {
        IContentProvider provider = acquireExistingProvider(url);
        if (provider != null) {
            try {
                return provider.getType(url);
            } catch (RemoteException e) {
                return null;
            } catch (java.lang.Exception e) {
                Log.w(TAG, "Failed to get type for: " + url + " (" + e.getMessage() + ")");
                return null;
            } finally {
                releaseProvider(provider);
            }
        }
        if (!SCHEME_CONTENT.equals(url.getScheme())) {
            return null;
        }
        try {
            String type = ActivityManagerNative.getDefault().getProviderMimeType(url);
            return type;
        } catch (RemoteException e) {
            // Arbitrary and not worth documenting, as Activity
            // Manager will kill this process shortly anyway.
            return null;
        } catch (java.lang.Exception e) {
            Log.w(TAG, "Failed to get type for: " + url + " (" + e.getMessage() + ")");
            return null;
        }
    }

    
    public String[] getStreamTypes(Uri url, String mimeTypeFilter) {
        IContentProvider provider = acquireProvider(url);
        if (provider == null) {
            return null;
        }
        try {
            return provider.getStreamTypes(url, mimeTypeFilter);
        } catch (RemoteException e) {
            // Arbitrary and not worth documenting, as Activity
            // Manager will kill this process shortly anyway.
            return null;
        } finally {
            releaseProvider(provider);
        }
    }

    
    @DSModeled(DSC.SPEC)
   /**
    * On this query call, we want the information flow taint to flow from the
    * query call to the underlying cursor.  So just create a cursor and return it.
    * The DSCursor will take care of propagating the information flow.
    */
    public final Cursor query(Uri uri, String[] projection,
            String selection, String[] selectionArgs, String sortOrder) {
       Cursor dsCursor = new DSCursor(uri, projection, selection, selectionArgs, sortOrder);
       return dsCursor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.606 -0400", hash_original_method = "741F25E5E9079F60798D64718B03495A", hash_generated_method = "4E1643BE99A45D32994BDBD28F8173F7")
    public final InputStream openInputStream(Uri uri) throws FileNotFoundException {
        addTaint(uri.getTaint());
        String scheme = uri.getScheme();
        if(SCHEME_ANDROID_RESOURCE.equals(scheme))        
        {
            OpenResourceIdResult r = getResourceId(uri);
            try 
            {
                InputStream stream = r.r.openRawResource(r.id);
InputStream varA87CF74140B150613F4203E71875F9A7_17813931 =                 stream;
                varA87CF74140B150613F4203E71875F9A7_17813931.addTaint(taint);
                return varA87CF74140B150613F4203E71875F9A7_17813931;
            } //End block
            catch (Resources.NotFoundException ex)
            {
                FileNotFoundException varE8810E522D8B98FEF67E48EC052E3409_2082595849 = new FileNotFoundException("Resource does not exist: " + uri);
                varE8810E522D8B98FEF67E48EC052E3409_2082595849.addTaint(taint);
                throw varE8810E522D8B98FEF67E48EC052E3409_2082595849;
            } //End block
        } //End block
        else
        if(SCHEME_FILE.equals(scheme))        
        {
InputStream varFC75AD1534DBFE0E739C82AC8780E884_1651607041 =             new FileInputStream(uri.getPath());
            varFC75AD1534DBFE0E739C82AC8780E884_1651607041.addTaint(taint);
            return varFC75AD1534DBFE0E739C82AC8780E884_1651607041;
        } //End block
        else
        {
            AssetFileDescriptor fd = openAssetFileDescriptor(uri, "r");
            try 
            {
InputStream varBE141D4F2C9E7C9CF6C0202CDAF666BA_684667738 =                 fd != null ? fd.createInputStream() : null;
                varBE141D4F2C9E7C9CF6C0202CDAF666BA_684667738.addTaint(taint);
                return varBE141D4F2C9E7C9CF6C0202CDAF666BA_684667738;
            } //End block
            catch (IOException e)
            {
                FileNotFoundException varE14CDFD965413CCD1DE03C3CE3B3937E_106397192 = new FileNotFoundException("Unable to create stream");
                varE14CDFD965413CCD1DE03C3CE3B3937E_106397192.addTaint(taint);
                throw varE14CDFD965413CCD1DE03C3CE3B3937E_106397192;
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.606 -0400", hash_original_method = "11A517824302FF0E2A744E48D03F81F2", hash_generated_method = "3CC586200A58B200AD37848C3B57B334")
    public final OutputStream openOutputStream(Uri uri) throws FileNotFoundException {
        addTaint(uri.getTaint());
OutputStream varDAF18F351C752F1D03791D667017D5CB_804702627 =         openOutputStream(uri, "w");
        varDAF18F351C752F1D03791D667017D5CB_804702627.addTaint(taint);
        return varDAF18F351C752F1D03791D667017D5CB_804702627;
        // ---------- Original Method ----------
        //return openOutputStream(uri, "w");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.606 -0400", hash_original_method = "99597D87D82436F243497E22352BC980", hash_generated_method = "F5D70937D1AD3B81563DE9CDEA2A70DE")
    public final OutputStream openOutputStream(Uri uri, String mode) throws FileNotFoundException {
        addTaint(mode.getTaint());
        addTaint(uri.getTaint());
        AssetFileDescriptor fd = openAssetFileDescriptor(uri, mode);
        try 
        {
OutputStream var9660A12712EE20E561E7EB86CAE36FCA_984048807 =             fd != null ? fd.createOutputStream() : null;
            var9660A12712EE20E561E7EB86CAE36FCA_984048807.addTaint(taint);
            return var9660A12712EE20E561E7EB86CAE36FCA_984048807;
        } //End block
        catch (IOException e)
        {
            FileNotFoundException varE14CDFD965413CCD1DE03C3CE3B3937E_2071302723 = new FileNotFoundException("Unable to create stream");
            varE14CDFD965413CCD1DE03C3CE3B3937E_2071302723.addTaint(taint);
            throw varE14CDFD965413CCD1DE03C3CE3B3937E_2071302723;
        } //End block
        // ---------- Original Method ----------
        //AssetFileDescriptor fd = openAssetFileDescriptor(uri, mode);
        //try {
            //return fd != null ? fd.createOutputStream() : null;
        //} catch (IOException e) {
            //throw new FileNotFoundException("Unable to create stream");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.607 -0400", hash_original_method = "8C4F5C0648F37279A7BD3F73F68574C8", hash_generated_method = "84E688B9266ACF57664A79D74092777E")
    public final ParcelFileDescriptor openFileDescriptor(Uri uri,
            String mode) throws FileNotFoundException {
        addTaint(mode.getTaint());
        addTaint(uri.getTaint());
        AssetFileDescriptor afd = openAssetFileDescriptor(uri, mode);
        if(afd == null)        
        {
ParcelFileDescriptor var540C13E9E156B687226421B24F2DF178_576399840 =             null;
            var540C13E9E156B687226421B24F2DF178_576399840.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_576399840;
        } //End block
        if(afd.getDeclaredLength() < 0)        
        {
ParcelFileDescriptor varA9AB8B7D15238800765F4158408BCDB4_1337050724 =             afd.getParcelFileDescriptor();
            varA9AB8B7D15238800765F4158408BCDB4_1337050724.addTaint(taint);
            return varA9AB8B7D15238800765F4158408BCDB4_1337050724;
        } //End block
        try 
        {
            afd.close();
        } //End block
        catch (IOException e)
        {
        } //End block
        FileNotFoundException varCF2804E98D5BC3EED85EC79FB2F91971_194747907 = new FileNotFoundException("Not a whole file");
        varCF2804E98D5BC3EED85EC79FB2F91971_194747907.addTaint(taint);
        throw varCF2804E98D5BC3EED85EC79FB2F91971_194747907;
        // ---------- Original Method ----------
        //AssetFileDescriptor afd = openAssetFileDescriptor(uri, mode);
        //if (afd == null) {
            //return null;
        //}
        //if (afd.getDeclaredLength() < 0) {
            //return afd.getParcelFileDescriptor();
        //}
        //try {
            //afd.close();
        //} catch (IOException e) {
        //}
        //throw new FileNotFoundException("Not a whole file");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.608 -0400", hash_original_method = "6D0B2664AB85671E5A18996AE47F9088", hash_generated_method = "BC989B6590FE9D3A805B8C58EFA47905")
    public final AssetFileDescriptor openAssetFileDescriptor(Uri uri,
            String mode) throws FileNotFoundException {
        addTaint(mode.getTaint());
        addTaint(uri.getTaint());
        String scheme = uri.getScheme();
        if(SCHEME_ANDROID_RESOURCE.equals(scheme))        
        {
            if(!"r".equals(mode))            
            {
                FileNotFoundException var3E6E4698F2D2B39AC43F6148E6AB4CF6_2079674606 = new FileNotFoundException("Can't write resources: " + uri);
                var3E6E4698F2D2B39AC43F6148E6AB4CF6_2079674606.addTaint(taint);
                throw var3E6E4698F2D2B39AC43F6148E6AB4CF6_2079674606;
            } //End block
            OpenResourceIdResult r = getResourceId(uri);
            try 
            {
AssetFileDescriptor varF3583D388A196F6D98A374DDC1AD0113_547513159 =                 r.r.openRawResourceFd(r.id);
                varF3583D388A196F6D98A374DDC1AD0113_547513159.addTaint(taint);
                return varF3583D388A196F6D98A374DDC1AD0113_547513159;
            } //End block
            catch (Resources.NotFoundException ex)
            {
                FileNotFoundException varE8810E522D8B98FEF67E48EC052E3409_245378548 = new FileNotFoundException("Resource does not exist: " + uri);
                varE8810E522D8B98FEF67E48EC052E3409_245378548.addTaint(taint);
                throw varE8810E522D8B98FEF67E48EC052E3409_245378548;
            } //End block
        } //End block
        else
        if(SCHEME_FILE.equals(scheme))        
        {
            ParcelFileDescriptor pfd = ParcelFileDescriptor.open(
                    new File(uri.getPath()), modeToMode(uri, mode));
AssetFileDescriptor var6BD93397E5DAF0DF17CE1C003D2FCAB6_1974445137 =             new AssetFileDescriptor(pfd, 0, -1);
            var6BD93397E5DAF0DF17CE1C003D2FCAB6_1974445137.addTaint(taint);
            return var6BD93397E5DAF0DF17CE1C003D2FCAB6_1974445137;
        } //End block
        else
        {
            if("r".equals(mode))            
            {
AssetFileDescriptor var728978861F4263FCBEBDB0546FBED7DF_296359027 =                 openTypedAssetFileDescriptor(uri, "*/*", null);
                var728978861F4263FCBEBDB0546FBED7DF_296359027.addTaint(taint);
                return var728978861F4263FCBEBDB0546FBED7DF_296359027;
            } //End block
            else
            {
                IContentProvider provider = acquireProvider(uri);
                if(provider == null)                
                {
                    FileNotFoundException var40E2EE088A44F180C90D99DA40A11B6C_151634252 = new FileNotFoundException("No content provider: " + uri);
                    var40E2EE088A44F180C90D99DA40A11B6C_151634252.addTaint(taint);
                    throw var40E2EE088A44F180C90D99DA40A11B6C_151634252;
                } //End block
                try 
                {
                    AssetFileDescriptor fd = provider.openAssetFile(uri, mode);
                    if(fd == null)                    
                    {
AssetFileDescriptor var540C13E9E156B687226421B24F2DF178_1780867329 =                         null;
                        var540C13E9E156B687226421B24F2DF178_1780867329.addTaint(taint);
                        return var540C13E9E156B687226421B24F2DF178_1780867329;
                    } //End block
                    ParcelFileDescriptor pfd = new ParcelFileDescriptorInner(
                            fd.getParcelFileDescriptor(), provider);
                    provider = null;
AssetFileDescriptor varC3C12411A882751F292369C906132F8B_827792567 =                     new AssetFileDescriptor(pfd, fd.getStartOffset(),
                            fd.getDeclaredLength());
                    varC3C12411A882751F292369C906132F8B_827792567.addTaint(taint);
                    return varC3C12411A882751F292369C906132F8B_827792567;
                } //End block
                catch (RemoteException e)
                {
                    FileNotFoundException varDBFDFCAA6D96C908D7FB1870DDC805CA_975392849 = new FileNotFoundException("Dead content provider: " + uri);
                    varDBFDFCAA6D96C908D7FB1870DDC805CA_975392849.addTaint(taint);
                    throw varDBFDFCAA6D96C908D7FB1870DDC805CA_975392849;
                } //End block
                catch (FileNotFoundException e)
                {
                    e.addTaint(taint);
                    throw e;
                } //End block
                finally 
                {
                    if(provider != null)                    
                    {
                        releaseProvider(provider);
                    } //End block
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    public final AssetFileDescriptor openTypedAssetFileDescriptor(Uri uri,
            String mimeType, Bundle opts) throws FileNotFoundException {
        IContentProvider provider = acquireProvider(uri);
        if (provider == null) {
            throw new FileNotFoundException("No content provider: " + uri);
        }
        try {
            AssetFileDescriptor fd = provider.openTypedAssetFile(uri, mimeType, opts);
            if (fd == null) {
                // The provider will be released by the finally{} clause
                return null;
            }
            ParcelFileDescriptor pfd = new ParcelFileDescriptorInner(
                    fd.getParcelFileDescriptor(), provider);
            // Success!  Don't release the provider when exiting, let
            // ParcelFileDescriptorInner do that when it is closed.
            provider = null;
            return new AssetFileDescriptor(pfd, fd.getStartOffset(),
                    fd.getDeclaredLength());
        } catch (RemoteException e) {
            throw new FileNotFoundException("Dead content provider: " + uri);
        } catch (FileNotFoundException e) {
            throw e;
        } finally {
            if (provider != null) {
                releaseProvider(provider);
            }
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.609 -0400", hash_original_method = "39DD117C1A4502740FE90592CCDD92D2", hash_generated_method = "32B3078D6B11F25190CACF63AB1BE54D")
    public OpenResourceIdResult getResourceId(Uri uri) throws FileNotFoundException {
        addTaint(uri.getTaint());
        String authority = uri.getAuthority();
        Resources r;
        if(TextUtils.isEmpty(authority))        
        {
            FileNotFoundException var0ACC1320D5E87EB8AD60C20862242804_464886954 = new FileNotFoundException("No authority: " + uri);
            var0ACC1320D5E87EB8AD60C20862242804_464886954.addTaint(taint);
            throw var0ACC1320D5E87EB8AD60C20862242804_464886954;
        } //End block
        else
        {
            try 
            {
                r = mContext.getPackageManager().getResourcesForApplication(authority);
            } //End block
            catch (NameNotFoundException ex)
            {
                FileNotFoundException var9514FE02F5A5CA391BAA8E45C47116A7_1470084154 = new FileNotFoundException("No package found for authority: " + uri);
                var9514FE02F5A5CA391BAA8E45C47116A7_1470084154.addTaint(taint);
                throw var9514FE02F5A5CA391BAA8E45C47116A7_1470084154;
            } //End block
        } //End block
        List<String> path = uri.getPathSegments();
        if(path == null)        
        {
            FileNotFoundException varC69DFEC10B02FEAA78D67A2A187A7F19_1745127 = new FileNotFoundException("No path: " + uri);
            varC69DFEC10B02FEAA78D67A2A187A7F19_1745127.addTaint(taint);
            throw varC69DFEC10B02FEAA78D67A2A187A7F19_1745127;
        } //End block
        int len = path.size();
        int id;
        if(len == 1)        
        {
            try 
            {
                id = Integer.parseInt(path.get(0));
            } //End block
            catch (NumberFormatException e)
            {
                FileNotFoundException varC22B934DA93E3FEDAA7C59017512810F_558113216 = new FileNotFoundException("Single path segment is not a resource ID: " + uri);
                varC22B934DA93E3FEDAA7C59017512810F_558113216.addTaint(taint);
                throw varC22B934DA93E3FEDAA7C59017512810F_558113216;
            } //End block
        } //End block
        else
        if(len == 2)        
        {
            id = r.getIdentifier(path.get(1), path.get(0), authority);
        } //End block
        else
        {
            FileNotFoundException var5535C43DBB8176F250E03E36B76F22BA_753184271 = new FileNotFoundException("More than two path segments: " + uri);
            var5535C43DBB8176F250E03E36B76F22BA_753184271.addTaint(taint);
            throw var5535C43DBB8176F250E03E36B76F22BA_753184271;
        } //End block
        if(id == 0)        
        {
            FileNotFoundException var62897123492917248A6A32EE2FAC55C4_48944294 = new FileNotFoundException("No resource found for: " + uri);
            var62897123492917248A6A32EE2FAC55C4_48944294.addTaint(taint);
            throw var62897123492917248A6A32EE2FAC55C4_48944294;
        } //End block
        OpenResourceIdResult res = new OpenResourceIdResult();
        res.r = r;
        res.id = id;
OpenResourceIdResult varB5053E025797B3BF768F5C37934C244D_774328826 =         res;
        varB5053E025797B3BF768F5C37934C244D_774328826.addTaint(taint);
        return varB5053E025797B3BF768F5C37934C244D_774328826;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    static public int modeToMode(Uri uri, String mode) throws FileNotFoundException {
        int modeBits;
        if ("r".equals(mode)) {
            modeBits = ParcelFileDescriptor.MODE_READ_ONLY;
        } else if ("w".equals(mode) || "wt".equals(mode)) {
            modeBits = ParcelFileDescriptor.MODE_WRITE_ONLY
                    | ParcelFileDescriptor.MODE_CREATE
                    | ParcelFileDescriptor.MODE_TRUNCATE;
        } else if ("wa".equals(mode)) {
            modeBits = ParcelFileDescriptor.MODE_WRITE_ONLY
                    | ParcelFileDescriptor.MODE_CREATE
                    | ParcelFileDescriptor.MODE_APPEND;
        } else if ("rw".equals(mode)) {
            modeBits = ParcelFileDescriptor.MODE_READ_WRITE
                    | ParcelFileDescriptor.MODE_CREATE;
        } else if ("rwt".equals(mode)) {
            modeBits = ParcelFileDescriptor.MODE_READ_WRITE
                    | ParcelFileDescriptor.MODE_CREATE
                    | ParcelFileDescriptor.MODE_TRUNCATE;
        } else {
            throw new FileNotFoundException("Bad mode for " + uri + ": "
                    + mode);
        }
        return modeBits;
    }

    
    public final Uri insert(Uri url, ContentValues values)
    {
        IContentProvider provider = acquireProvider(url);
        if (provider == null) {
            throw new IllegalArgumentException("Unknown URL " + url);
        }
        try {
            long startTime = SystemClock.uptimeMillis();
            Uri createdRow = provider.insert(url, values);
            long durationMillis = SystemClock.uptimeMillis() - startTime;
            maybeLogUpdateToEventLog(durationMillis, url, "insert", null /* where */);
            return createdRow;
        } catch (RemoteException e) {
            // Arbitrary and not worth documenting, as Activity
            // Manager will kill this process shortly anyway.
            return null;
        } finally {
            releaseProvider(provider);
        }
    }

    
    public ContentProviderResult[] applyBatch(String authority,
            ArrayList<ContentProviderOperation> operations)
            throws RemoteException, OperationApplicationException {
        ContentProviderClient provider = acquireContentProviderClient(authority);
        if (provider == null) {
            throw new IllegalArgumentException("Unknown authority " + authority);
        }
        try {
            return provider.applyBatch(operations);
        } finally {
            provider.release();
        }
    }

    
    public final int bulkInsert(Uri url, ContentValues[] values)
    {
        IContentProvider provider = acquireProvider(url);
        if (provider == null) {
            throw new IllegalArgumentException("Unknown URL " + url);
        }
        try {
            long startTime = SystemClock.uptimeMillis();
            int rowsCreated = provider.bulkInsert(url, values);
            long durationMillis = SystemClock.uptimeMillis() - startTime;
            maybeLogUpdateToEventLog(durationMillis, url, "bulkinsert", null /* where */);
            return rowsCreated;
        } catch (RemoteException e) {
            // Arbitrary and not worth documenting, as Activity
            // Manager will kill this process shortly anyway.
            return 0;
        } finally {
            releaseProvider(provider);
        }
    }

    
    public final int delete(Uri url, String where, String[] selectionArgs)
    {
        IContentProvider provider = acquireProvider(url);
        if (provider == null) {
            throw new IllegalArgumentException("Unknown URL " + url);
        }
        try {
            long startTime = SystemClock.uptimeMillis();
            int rowsDeleted = provider.delete(url, where, selectionArgs);
            long durationMillis = SystemClock.uptimeMillis() - startTime;
            maybeLogUpdateToEventLog(durationMillis, url, "delete", where);
            return rowsDeleted;
        } catch (RemoteException e) {
            // Arbitrary and not worth documenting, as Activity
            // Manager will kill this process shortly anyway.
            return -1;
        } finally {
            releaseProvider(provider);
        }
    }

    
    public final int update(Uri uri, ContentValues values, String where,
            String[] selectionArgs) {
        IContentProvider provider = acquireProvider(uri);
        if (provider == null) {
            throw new IllegalArgumentException("Unknown URI " + uri);
        }
        try {
            long startTime = SystemClock.uptimeMillis();
            int rowsUpdated = provider.update(uri, values, where, selectionArgs);
            long durationMillis = SystemClock.uptimeMillis() - startTime;
            maybeLogUpdateToEventLog(durationMillis, uri, "update", where);
            return rowsUpdated;
        } catch (RemoteException e) {
            // Arbitrary and not worth documenting, as Activity
            // Manager will kill this process shortly anyway.
            return -1;
        } finally {
            releaseProvider(provider);
        }
    }

    
    public final Bundle call(Uri uri, String method, String arg, Bundle extras) {
        if (uri == null) {
            throw new NullPointerException("uri == null");
        }
        if (method == null) {
            throw new NullPointerException("method == null");
        }
        IContentProvider provider = acquireProvider(uri);
        if (provider == null) {
            throw new IllegalArgumentException("Unknown URI " + uri);
        }
        try {
            return provider.call(method, arg, extras);
        } catch (RemoteException e) {
            // Arbitrary and not worth documenting, as Activity
            // Manager will kill this process shortly anyway.
            return null;
        } finally {
            releaseProvider(provider);
        }
    }

    
    public final IContentProvider acquireProvider(Uri uri) {
        if (!SCHEME_CONTENT.equals(uri.getScheme())) {
            return null;
        }
        String auth = uri.getAuthority();
        if (auth != null) {
            return acquireProvider(mContext, uri.getAuthority());
        }
        return null;
    }

    
    public final IContentProvider acquireExistingProvider(Uri uri) {
        if (!SCHEME_CONTENT.equals(uri.getScheme())) {
            return null;
        }
        String auth = uri.getAuthority();
        if (auth != null) {
            return acquireExistingProvider(mContext, uri.getAuthority());
        }
        return null;
    }

    
    public final IContentProvider acquireProvider(String name) {
        if (name == null) {
            return null;
        }
        return acquireProvider(mContext, name);
    }

    
    public final ContentProviderClient acquireContentProviderClient(Uri uri) {
        IContentProvider provider = acquireProvider(uri);
        if (provider != null) {
            return new ContentProviderClient(this, provider);
        }
        return null;
    }

    
    public final ContentProviderClient acquireContentProviderClient(String name) {
        IContentProvider provider = acquireProvider(name);
        if (provider != null) {
            return new ContentProviderClient(this, provider);
        }
        return null;
    }

    
    public final void registerContentObserver(Uri uri, boolean notifyForDescendents,
            ContentObserver observer)
    {
        try {
            getContentService().registerContentObserver(uri, notifyForDescendents,
                    observer.getContentObserver());
        } catch (RemoteException e) {
        }
    }

    
    public final void unregisterContentObserver(ContentObserver observer) {
        try {
            IContentObserver contentObserver = observer.releaseContentObserver();
            if (contentObserver != null) {
                getContentService().unregisterContentObserver(
                        contentObserver);
            }
        } catch (RemoteException e) {
        }
    }

    
    public void notifyChange(Uri uri, ContentObserver observer) {
        notifyChange(uri, observer, true /* sync to network */);
    }

    
    public void notifyChange(Uri uri, ContentObserver observer, boolean syncToNetwork) {
        try {
            getContentService().notifyChange(
                    uri, observer == null ? null : observer.getContentObserver(),
                    observer != null && observer.deliverSelfNotifications(), syncToNetwork);
        } catch (RemoteException e) {
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.622 -0400", hash_original_method = "2D6405030D787F1D91AFA94E2D425989", hash_generated_method = "8FD49EB480C67F13739811857A7B4F54")
    @Deprecated
    public void startSync(Uri uri, Bundle extras) {
        addTaint(extras.getTaint());
        addTaint(uri.getTaint());
        Account account = null;
        if(extras != null)        
        {
            String accountName = extras.getString(SYNC_EXTRAS_ACCOUNT);
            if(!TextUtils.isEmpty(accountName))            
            {
                account = new Account(accountName, "com.google");
            } //End block
            extras.remove(SYNC_EXTRAS_ACCOUNT);
        } //End block
        requestSync(account, uri != null ? uri.getAuthority() : null, extras);
        // ---------- Original Method ----------
        //Account account = null;
        //if (extras != null) {
            //String accountName = extras.getString(SYNC_EXTRAS_ACCOUNT);
            //if (!TextUtils.isEmpty(accountName)) {
                //account = new Account(accountName, "com.google");
            //}
            //extras.remove(SYNC_EXTRAS_ACCOUNT);
        //}
        //requestSync(account, uri != null ? uri.getAuthority() : null, extras);
    }

    
    public static void requestSync(Account account, String authority, Bundle extras) {
        validateSyncExtrasBundle(extras);
        try {
            getContentService().requestSync(account, authority, extras);
        } catch (RemoteException e) {
        }
    }

    
    public static void validateSyncExtrasBundle(Bundle extras) {
        try {
            for (String key : extras.keySet()) {
                Object value = extras.get(key);
                if (value == null) continue;
                if (value instanceof Long) continue;
                if (value instanceof Integer) continue;
                if (value instanceof Boolean) continue;
                if (value instanceof Float) continue;
                if (value instanceof Double) continue;
                if (value instanceof String) continue;
                if (value instanceof Account) continue;
                throw new IllegalArgumentException("unexpected value type: "
                        + value.getClass().getName());
            }
        } catch (IllegalArgumentException e) {
            throw e;
        } catch (RuntimeException exc) {
            throw new IllegalArgumentException("error unparceling Bundle", exc);
        }
    }

    
    @Deprecated
    public void cancelSync(Uri uri) {
        cancelSync(null /* all accounts */, uri != null ? uri.getAuthority() : null);
    }

    
    public static void cancelSync(Account account, String authority) {
        try {
            getContentService().cancelSync(account, authority);
        } catch (RemoteException e) {
        }
    }

    
    public static SyncAdapterType[] getSyncAdapterTypes() {
        try {
            return getContentService().getSyncAdapterTypes();
        } catch (RemoteException e) {
            throw new RuntimeException("the ContentService should always be reachable", e);
        }
    }

    
    public static boolean getSyncAutomatically(Account account, String authority) {
        try {
            return getContentService().getSyncAutomatically(account, authority);
        } catch (RemoteException e) {
            throw new RuntimeException("the ContentService should always be reachable", e);
        }
    }

    
    public static void setSyncAutomatically(Account account, String authority, boolean sync) {
        try {
            getContentService().setSyncAutomatically(account, authority, sync);
        } catch (RemoteException e) {
            // exception ignored; if this is thrown then it means the runtime is in the midst of
            // being restarted
        }
    }

    
    public static void addPeriodicSync(Account account, String authority, Bundle extras,
            long pollFrequency) {
        validateSyncExtrasBundle(extras);
        if (account == null) {
            throw new IllegalArgumentException("account must not be null");
        }
        if (authority == null) {
            throw new IllegalArgumentException("authority must not be null");
        }
        if (extras.getBoolean(SYNC_EXTRAS_MANUAL, false)
                || extras.getBoolean(SYNC_EXTRAS_DO_NOT_RETRY, false)
                || extras.getBoolean(SYNC_EXTRAS_IGNORE_BACKOFF, false)
                || extras.getBoolean(SYNC_EXTRAS_IGNORE_SETTINGS, false)
                || extras.getBoolean(SYNC_EXTRAS_INITIALIZE, false)
                || extras.getBoolean(SYNC_EXTRAS_FORCE, false)
                || extras.getBoolean(SYNC_EXTRAS_EXPEDITED, false)) {
            throw new IllegalArgumentException("illegal extras were set");
        }
        try {
            getContentService().addPeriodicSync(account, authority, extras, pollFrequency);
        } catch (RemoteException e) {
            // exception ignored; if this is thrown then it means the runtime is in the midst of
            // being restarted
        }
    }

    
    public static void removePeriodicSync(Account account, String authority, Bundle extras) {
        validateSyncExtrasBundle(extras);
        if (account == null) {
            throw new IllegalArgumentException("account must not be null");
        }
        if (authority == null) {
            throw new IllegalArgumentException("authority must not be null");
        }
        try {
            getContentService().removePeriodicSync(account, authority, extras);
        } catch (RemoteException e) {
            throw new RuntimeException("the ContentService should always be reachable", e);
        }
    }

    
    public static List<PeriodicSync> getPeriodicSyncs(Account account, String authority) {
        if (account == null) {
            throw new IllegalArgumentException("account must not be null");
        }
        if (authority == null) {
            throw new IllegalArgumentException("authority must not be null");
        }
        try {
            return getContentService().getPeriodicSyncs(account, authority);
        } catch (RemoteException e) {
            throw new RuntimeException("the ContentService should always be reachable", e);
        }
    }

    
    public static int getIsSyncable(Account account, String authority) {
        try {
            return getContentService().getIsSyncable(account, authority);
        } catch (RemoteException e) {
            throw new RuntimeException("the ContentService should always be reachable", e);
        }
    }

    
    public static void setIsSyncable(Account account, String authority, int syncable) {
        try {
            getContentService().setIsSyncable(account, authority, syncable);
        } catch (RemoteException e) {
            // exception ignored; if this is thrown then it means the runtime is in the midst of
            // being restarted
        }
    }

    
    public static boolean getMasterSyncAutomatically() {
        try {
            return getContentService().getMasterSyncAutomatically();
        } catch (RemoteException e) {
            throw new RuntimeException("the ContentService should always be reachable", e);
        }
    }

    
    public static void setMasterSyncAutomatically(boolean sync) {
        try {
            getContentService().setMasterSyncAutomatically(sync);
        } catch (RemoteException e) {
            // exception ignored; if this is thrown then it means the runtime is in the midst of
            // being restarted
        }
    }

    
    public static boolean isSyncActive(Account account, String authority) {
        try {
            return getContentService().isSyncActive(account, authority);
        } catch (RemoteException e) {
            throw new RuntimeException("the ContentService should always be reachable", e);
        }
    }

    
    @Deprecated
    public static SyncInfo getCurrentSync() {
        try {
            final List<SyncInfo> syncs = getContentService().getCurrentSyncs();
            if (syncs.isEmpty()) {
                return null;
            }
            return syncs.get(0);
        } catch (RemoteException e) {
            throw new RuntimeException("the ContentService should always be reachable", e);
        }
    }

    
    public static List<SyncInfo> getCurrentSyncs() {
        try {
            return getContentService().getCurrentSyncs();
        } catch (RemoteException e) {
            throw new RuntimeException("the ContentService should always be reachable", e);
        }
    }

    
    public static SyncStatusInfo getSyncStatus(Account account, String authority) {
        try {
            return getContentService().getSyncStatus(account, authority);
        } catch (RemoteException e) {
            throw new RuntimeException("the ContentService should always be reachable", e);
        }
    }

    
    public static boolean isSyncPending(Account account, String authority) {
        try {
            return getContentService().isSyncPending(account, authority);
        } catch (RemoteException e) {
            throw new RuntimeException("the ContentService should always be reachable", e);
        }
    }

    
    public static Object addStatusChangeListener(int mask, final SyncStatusObserver callback) {
        if (callback == null) {
            throw new IllegalArgumentException("you passed in a null callback");
        }
        try {
            ISyncStatusObserver.Stub observer = new ISyncStatusObserver.Stub() {
                public void onStatusChanged(int which) throws RemoteException {
                    callback.onStatusChanged(which);
                }
            };
            getContentService().addStatusChangeListener(mask, observer);
            return observer;
        } catch (RemoteException e) {
            throw new RuntimeException("the ContentService should always be reachable", e);
        }
    }

    
    public static void removeStatusChangeListener(Object handle) {
        if (handle == null) {
            throw new IllegalArgumentException("you passed in a null handle");
        }
        try {
            getContentService().removeStatusChangeListener((ISyncStatusObserver.Stub) handle);
        } catch (RemoteException e) {
            // exception ignored; if this is thrown then it means the runtime is in the midst of
            // being restarted
        }
    }

    
    private int samplePercentForDuration(long durationMillis) {
        if (durationMillis >= SLOW_THRESHOLD_MILLIS) {
            return 100;
        }
        return (int) (100 * durationMillis / SLOW_THRESHOLD_MILLIS) + 1;
    }

    
    private void maybeLogQueryToEventLog(long durationMillis,
                                         Uri uri, String[] projection,
                                         String selection, String sortOrder) {
        int samplePercent = samplePercentForDuration(durationMillis);
        if (samplePercent < 100) {
            synchronized (mRandom) {
                if (mRandom.nextInt(100) >= samplePercent) {
                    return;
                }
            }
        }
        StringBuilder projectionBuffer = new StringBuilder(100);
        if (projection != null) {
            for (int i = 0; i < projection.length; ++i) {
                // Note: not using a comma delimiter here, as the
                // multiple arguments to EventLog.writeEvent later
                // stringify with a comma delimiter, which would make
                // parsing uglier later.
                if (i != 0) projectionBuffer.append('/');
                projectionBuffer.append(projection[i]);
            }
        }
        // ActivityThread.currentPackageName() only returns non-null if the
        // current thread is an application main thread.  This parameter tells
        // us whether an event loop is blocked, and if so, which app it is.
        String blockingPackage = AppGlobals.getInitialPackage();
        EventLog.writeEvent(
            EventLogTags.CONTENT_QUERY_SAMPLE,
            uri.toString(),
            projectionBuffer.toString(),
            selection != null ? selection : "",
            sortOrder != null ? sortOrder : "",
            durationMillis,
            blockingPackage != null ? blockingPackage : "",
            samplePercent);
    }

    
    private void maybeLogUpdateToEventLog(
        long durationMillis, Uri uri, String operation, String selection) {
        int samplePercent = samplePercentForDuration(durationMillis);
        if (samplePercent < 100) {
            synchronized (mRandom) {
                if (mRandom.nextInt(100) >= samplePercent) {
                    return;
                }
            }
        }
        String blockingPackage = AppGlobals.getInitialPackage();
        EventLog.writeEvent(
            EventLogTags.CONTENT_UPDATE_SAMPLE,
            uri.toString(),
            operation,
            selection != null ? selection : "",
            durationMillis,
            blockingPackage != null ? blockingPackage : "",
            samplePercent);
    }

    
    public static IContentService getContentService() {
        if (sContentService != null) {
            return sContentService;
        }
        IBinder b = ServiceManager.getService(CONTENT_SERVICE_NAME);
        if (false) Log.v("ContentService", "default service binder = " + b);
        sContentService = IContentService.Stub.asInterface(b);
        if (false) Log.v("ContentService", "default service = " + sContentService);
        return sContentService;
    }

    
    public class OpenResourceIdResult {
        public Resources r;
        public int id;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:38.636 -0400", hash_original_method = "EC7BB03A160C6C88DBB9DFBF62B48748", hash_generated_method = "EC7BB03A160C6C88DBB9DFBF62B48748")
        public OpenResourceIdResult ()
        {
            //Synthesized constructor
        }


    }


    
    private final class CursorWrapperInner extends CrossProcessCursorWrapper {
        private final IContentProvider mContentProvider;
        private final CloseGuard mCloseGuard = CloseGuard.get();
        private boolean mProviderReleased;
        
        CursorWrapperInner(Cursor cursor, IContentProvider icp) {
            super(cursor);
            mContentProvider = icp;
            mCloseGuard.open("close");
        }

        
        @Override
        public void close() {
            super.close();
            ContentResolver.this.releaseProvider(mContentProvider);
            mProviderReleased = true;
            if (mCloseGuard != null) {
                mCloseGuard.close();
            }
        }

        
        @Override
        protected void finalize() throws Throwable {
            try {
                if (mCloseGuard != null) {
                    mCloseGuard.warnIfOpen();
                }
                if (!mProviderReleased && mContentProvider != null) {
                    // Even though we are using CloseGuard, log this anyway so that
                    // application developers always see the message in the log.
                    Log.w(TAG, "Cursor finalized without prior close()");
                    ContentResolver.this.releaseProvider(mContentProvider);
                }
            } finally {
                super.finalize();
            }
        }

        
        public static final String TAG="CursorWrapperInner";
    }


    
    private final class ParcelFileDescriptorInner extends ParcelFileDescriptor {
        private final IContentProvider mContentProvider;
        private boolean mReleaseProviderFlag = false;
        
        ParcelFileDescriptorInner(ParcelFileDescriptor pfd, IContentProvider icp) {
            super(pfd);
            mContentProvider = icp;
        }

        
        @Override
        public void close() throws IOException {
            if(!mReleaseProviderFlag) {
                super.close();
                ContentResolver.this.releaseProvider(mContentProvider);
                mReleaseProviderFlag = true;
            }
        }

        
        @Override
        protected void finalize() throws Throwable {
            if (!mReleaseProviderFlag) {
                close();
            }
        }

        
        public static final String TAG="ParcelFileDescriptorInner";
    }


    
    @Deprecated
    public static final String SYNC_EXTRAS_ACCOUNT = "account";
    public static final String SYNC_EXTRAS_EXPEDITED = "expedited";
    @Deprecated
    public static final String SYNC_EXTRAS_FORCE = "force";
    public static final String SYNC_EXTRAS_IGNORE_SETTINGS = "ignore_settings";
    public static final String SYNC_EXTRAS_IGNORE_BACKOFF = "ignore_backoff";
    public static final String SYNC_EXTRAS_DO_NOT_RETRY = "do_not_retry";
    public static final String SYNC_EXTRAS_MANUAL = "force";
    public static final String SYNC_EXTRAS_UPLOAD = "upload";
    public static final String SYNC_EXTRAS_OVERRIDE_TOO_MANY_DELETIONS = "deletions_override";
    public static final String SYNC_EXTRAS_DISCARD_LOCAL_DELETIONS = "discard_deletions";
    public static final String SYNC_EXTRAS_INITIALIZE = "initialize";
    public static final String SCHEME_CONTENT = "content";
    public static final String SCHEME_ANDROID_RESOURCE = "android.resource";
    public static final String SCHEME_FILE = "file";
    public static final String CURSOR_ITEM_BASE_TYPE = "vnd.android.cursor.item";
    public static final String CURSOR_DIR_BASE_TYPE = "vnd.android.cursor.dir";
    public static final int SYNC_ERROR_SYNC_ALREADY_IN_PROGRESS = 1;
    public static final int SYNC_ERROR_AUTHENTICATION = 2;
    public static final int SYNC_ERROR_IO = 3;
    public static final int SYNC_ERROR_PARSE = 4;
    public static final int SYNC_ERROR_CONFLICT = 5;
    public static final int SYNC_ERROR_TOO_MANY_DELETIONS = 6;
    public static final int SYNC_ERROR_TOO_MANY_RETRIES = 7;
    public static final int SYNC_ERROR_INTERNAL = 8;
    public static final int SYNC_OBSERVER_TYPE_SETTINGS = 1<<0;
    public static final int SYNC_OBSERVER_TYPE_PENDING = 1<<1;
    public static final int SYNC_OBSERVER_TYPE_ACTIVE = 1<<2;
    public static final int SYNC_OBSERVER_TYPE_STATUS = 1<<3;
    public static final int SYNC_OBSERVER_TYPE_ALL = 0x7fffffff;
    private static final int SLOW_THRESHOLD_MILLIS = 500;
    public static final String CONTENT_SERVICE_NAME = "content";
    private static IContentService sContentService;
    private static final String TAG = "ContentResolver";
}

