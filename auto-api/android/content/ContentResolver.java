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
import droidsafe.runtime.DroidSafeAndroidRuntime;
// import Iterator to deal with enhanced for loop translation

public abstract class ContentResolver {
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
    private final Random mRandom = new Random();
    public static final String CONTENT_SERVICE_NAME = "content";
    private static IContentService sContentService;
    private final Context mContext;
    private static final String TAG = "ContentResolver";
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.429 -0400", hash_original_method = "8EB5ACCD206353DB8493F8AB9F861C85", hash_generated_method = "D10755250B889CCCCB710169CBEAA4C9")
    @DSModeled(DSC.SAFE)
    public ContentResolver(Context context) {
        dsTaint.addTaint(context.dsTaint);
        mContext = context;
        // ---------- Original Method ----------
        //mContext = context;
    }

    
    protected abstract IContentProvider acquireProvider(Context c, String name);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.429 -0400", hash_original_method = "4AF2A0465BC3B713C9C8E0417552AB76", hash_generated_method = "0F722510F69F635BA175092A02B9311F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected IContentProvider acquireExistingProvider(Context c, String name) {
        dsTaint.addTaint(c.dsTaint);
        dsTaint.addTaint(name);
        IContentProvider var7616A789170D2AA3DACC7173F7CCEEDA_984119547 = (acquireProvider(c, name));
        return (IContentProvider)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return acquireProvider(c, name);
    }

    
    public abstract boolean releaseProvider(IContentProvider icp);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.430 -0400", hash_original_method = "045596B6E0367AC7BED26FC054AD1E2B", hash_generated_method = "3BCE6A14CA8B4EA3459F9D6B6672C0F0")
    @DSModeled(DSC.SPEC)
    public final String getType(Uri url) {
        dsTaint.addTaint(url.dsTaint);
        IContentProvider provider;
        provider = acquireExistingProvider(url);
        {
            try 
            {
                String var62F8BABA280AC539A38982353657E818_462652185 = (provider.getType(url));
            } //End block
            catch (RemoteException e)
            { }
            catch (java.lang.Exception e)
            { }
            finally 
            {
                releaseProvider(provider);
            } //End block
        } //End block
        {
            boolean var18721B692F8DF38C1D910B0966D1473B_739329068 = (!SCHEME_CONTENT.equals(url.getScheme()));
        } //End collapsed parenthetic
        try 
        {
            String type;
            type = ActivityManagerNative.getDefault().getProviderMimeType(url);
        } //End block
        catch (RemoteException e)
        { }
        catch (java.lang.Exception e)
        { }
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.430 -0400", hash_original_method = "BFD7301BBEDEF32538E97E3FEFB31C63", hash_generated_method = "B93A2B74BBBEB0B56A24080F6E7596E4")
    @DSModeled(DSC.SPEC)
    public String[] getStreamTypes(Uri url, String mimeTypeFilter) {
        dsTaint.addTaint(mimeTypeFilter);
        dsTaint.addTaint(url.dsTaint);
        IContentProvider provider;
        provider = acquireProvider(url);
        try 
        {
            String[] varC0880DAA9133D73EEA535AF1A3760FB5_202317258 = (provider.getStreamTypes(url, mimeTypeFilter));
        } //End block
        catch (RemoteException e)
        { }
        finally 
        {
            releaseProvider(provider);
        } //End block
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //IContentProvider provider = acquireProvider(url);
        //if (provider == null) {
            //return null;
        //}
        //try {
            //return provider.getStreamTypes(url, mimeTypeFilter);
        //} catch (RemoteException e) {
            //return null;
        //} finally {
            //releaseProvider(provider);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.430 -0400", hash_original_method = "505F43360905D398310F020FC85BFA22", hash_generated_method = "574DA01CF6943A5A0FA936839DACBDC3")
    @DSModeled(DSC.SPEC)
    public final Cursor query(Uri uri, String[] projection,
            String selection, String[] selectionArgs, String sortOrder) {
        dsTaint.addTaint(selectionArgs);
        dsTaint.addTaint(sortOrder);
        dsTaint.addTaint(projection);
        dsTaint.addTaint(uri.dsTaint);
        dsTaint.addTaint(selection);
        IContentProvider provider;
        provider = acquireProvider(uri);
        try 
        {
            long startTime;
            startTime = SystemClock.uptimeMillis();
            Cursor qCursor;
            qCursor = provider.query(uri, projection, selection, selectionArgs, sortOrder);
            {
                releaseProvider(provider);
            } //End block
            qCursor.getCount();
            long durationMillis;
            durationMillis = SystemClock.uptimeMillis() - startTime;
            maybeLogQueryToEventLog(durationMillis, uri, projection, selection, sortOrder);
        } //End block
        catch (RemoteException e)
        {
            releaseProvider(provider);
        } //End block
        catch (RuntimeException e)
        {
            releaseProvider(provider);
            throw e;
        } //End block
        return (Cursor)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.431 -0400", hash_original_method = "741F25E5E9079F60798D64718B03495A", hash_generated_method = "A1652D5E4691D5A3D4BFD3F892F859B1")
    @DSModeled(DSC.SPEC)
    public final InputStream openInputStream(Uri uri) throws FileNotFoundException {
        dsTaint.addTaint(uri.dsTaint);
        String scheme;
        scheme = uri.getScheme();
        {
            boolean varDFD9C1D7BE28AB5E473B86FFFB70E350_80841569 = (SCHEME_ANDROID_RESOURCE.equals(scheme));
            {
                OpenResourceIdResult r;
                r = getResourceId(uri);
                try 
                {
                    InputStream stream;
                    stream = r.r.openRawResource(r.id);
                } //End block
                catch (Resources.NotFoundException ex)
                {
                    if (DroidSafeAndroidRuntime.control) throw new FileNotFoundException("Resource does not exist: " + uri);
                } //End block
            } //End block
            {
                boolean var7C16B7242FD360F5FCAE86285293D958_30422025 = (SCHEME_FILE.equals(scheme));
                {
                    InputStream var56197DB113071FD77EC52DA51FA62E26_1128935555 = (new FileInputStream(uri.getPath()));
                } //End block
                {
                    AssetFileDescriptor fd;
                    fd = openAssetFileDescriptor(uri, "r");
                    try 
                    {
                        {
                            Object varE5A1CC48B7036EFCB483446D46C36AA2_964473246 = (fd.createInputStream());
                        } //End flattened ternary
                    } //End block
                    catch (IOException e)
                    {
                        if (DroidSafeAndroidRuntime.control) throw new FileNotFoundException("Unable to create stream");
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        return (InputStream)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.431 -0400", hash_original_method = "11A517824302FF0E2A744E48D03F81F2", hash_generated_method = "0527C619071A5E7ED7FA1138C120254F")
    @DSModeled(DSC.SPEC)
    public final OutputStream openOutputStream(Uri uri) throws FileNotFoundException {
        dsTaint.addTaint(uri.dsTaint);
        OutputStream varDAFEAE4B62C0FA570C709E3071AAF2D5_40116387 = (openOutputStream(uri, "w"));
        return (OutputStream)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return openOutputStream(uri, "w");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.432 -0400", hash_original_method = "99597D87D82436F243497E22352BC980", hash_generated_method = "EA70337B4A79851589B0C75BD8E86989")
    @DSModeled(DSC.SPEC)
    public final OutputStream openOutputStream(Uri uri, String mode) throws FileNotFoundException {
        dsTaint.addTaint(uri.dsTaint);
        dsTaint.addTaint(mode);
        AssetFileDescriptor fd;
        fd = openAssetFileDescriptor(uri, mode);
        try 
        {
            {
                Object var441F640F4CCE433C78EA3355A62061B7_1737861812 = (fd.createOutputStream());
            } //End flattened ternary
        } //End block
        catch (IOException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new FileNotFoundException("Unable to create stream");
        } //End block
        return (OutputStream)dsTaint.getTaint();
        // ---------- Original Method ----------
        //AssetFileDescriptor fd = openAssetFileDescriptor(uri, mode);
        //try {
            //return fd != null ? fd.createOutputStream() : null;
        //} catch (IOException e) {
            //throw new FileNotFoundException("Unable to create stream");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.432 -0400", hash_original_method = "8C4F5C0648F37279A7BD3F73F68574C8", hash_generated_method = "6FC57CC71FB809D8E599B906ECC4FCBE")
    @DSModeled(DSC.SPEC)
    public final ParcelFileDescriptor openFileDescriptor(Uri uri,
            String mode) throws FileNotFoundException {
        dsTaint.addTaint(uri.dsTaint);
        dsTaint.addTaint(mode);
        AssetFileDescriptor afd;
        afd = openAssetFileDescriptor(uri, mode);
        {
            boolean var8DC5E2F0722D8D5D90D15EC8C0F83F70_391345597 = (afd.getDeclaredLength() < 0);
            {
                ParcelFileDescriptor var5C92900FF6EF260B9BC07111424F278C_1419110916 = (afd.getParcelFileDescriptor());
            } //End block
        } //End collapsed parenthetic
        try 
        {
            afd.close();
        } //End block
        catch (IOException e)
        { }
        if (DroidSafeAndroidRuntime.control) throw new FileNotFoundException("Not a whole file");
        return (ParcelFileDescriptor)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.433 -0400", hash_original_method = "6D0B2664AB85671E5A18996AE47F9088", hash_generated_method = "5D9B37D92B472696AA26E69308ACA5A6")
    @DSModeled(DSC.SPEC)
    public final AssetFileDescriptor openAssetFileDescriptor(Uri uri,
            String mode) throws FileNotFoundException {
        dsTaint.addTaint(uri.dsTaint);
        dsTaint.addTaint(mode);
        String scheme;
        scheme = uri.getScheme();
        {
            boolean varDFD9C1D7BE28AB5E473B86FFFB70E350_509840523 = (SCHEME_ANDROID_RESOURCE.equals(scheme));
            {
                {
                    boolean varC16FAE09F0519703CBD513EC3052DFFD_1964338442 = (!"r".equals(mode));
                    {
                        if (DroidSafeAndroidRuntime.control) throw new FileNotFoundException("Can't write resources: " + uri);
                    } //End block
                } //End collapsed parenthetic
                OpenResourceIdResult r;
                r = getResourceId(uri);
                try 
                {
                    AssetFileDescriptor varE744077AEB2B3CB026C97EFE683A8AC3_1578493330 = (r.r.openRawResourceFd(r.id));
                } //End block
                catch (Resources.NotFoundException ex)
                {
                    if (DroidSafeAndroidRuntime.control) throw new FileNotFoundException("Resource does not exist: " + uri);
                } //End block
            } //End block
            {
                boolean var7C16B7242FD360F5FCAE86285293D958_755382213 = (SCHEME_FILE.equals(scheme));
                {
                    ParcelFileDescriptor pfd;
                    pfd = ParcelFileDescriptor.open(
                    new File(uri.getPath()), modeToMode(uri, mode));
                } //End block
                {
                    {
                        boolean var9E14F7893596A4058297083115E283FF_604285826 = ("r".equals(mode));
                        {
                            AssetFileDescriptor var6124B3414B13A0E5AF2C1A6736CB127C_1457683939 = (openTypedAssetFileDescriptor(uri, "*/*", null));
                        } //End block
                        {
                            IContentProvider provider;
                            provider = acquireProvider(uri);
                            {
                                if (DroidSafeAndroidRuntime.control) throw new FileNotFoundException("No content provider: " + uri);
                            } //End block
                            try 
                            {
                                AssetFileDescriptor fd;
                                fd = provider.openAssetFile(uri, mode);
                                ParcelFileDescriptor pfd;
                                pfd = new ParcelFileDescriptorInner(
                            fd.getParcelFileDescriptor(), provider);
                                provider = null;
                                AssetFileDescriptor varD8E188F987F4BA27290D58DB21C1C9F2_2019671189 = (new AssetFileDescriptor(pfd, fd.getStartOffset(),
                            fd.getDeclaredLength()));
                            } //End block
                            catch (RemoteException e)
                            {
                                if (DroidSafeAndroidRuntime.control) throw new FileNotFoundException("Dead content provider: " + uri);
                            } //End block
                            catch (FileNotFoundException e)
                            {
                                throw e;
                            } //End block
                            finally 
                            {
                                {
                                    releaseProvider(provider);
                                } //End block
                            } //End block
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        return (AssetFileDescriptor)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.433 -0400", hash_original_method = "6625A014E29DF928853C1F0BC5B9E856", hash_generated_method = "1DB3A561C2C86017CE7F151677A93D7A")
    @DSModeled(DSC.SPEC)
    public final AssetFileDescriptor openTypedAssetFileDescriptor(Uri uri,
            String mimeType, Bundle opts) throws FileNotFoundException {
        dsTaint.addTaint(opts.dsTaint);
        dsTaint.addTaint(uri.dsTaint);
        dsTaint.addTaint(mimeType);
        IContentProvider provider;
        provider = acquireProvider(uri);
        {
            if (DroidSafeAndroidRuntime.control) throw new FileNotFoundException("No content provider: " + uri);
        } //End block
        try 
        {
            AssetFileDescriptor fd;
            fd = provider.openTypedAssetFile(uri, mimeType, opts);
            ParcelFileDescriptor pfd;
            pfd = new ParcelFileDescriptorInner(
                    fd.getParcelFileDescriptor(), provider);
            provider = null;
            AssetFileDescriptor varF1569A55F19C591826FC871D7444B2F8_276729547 = (new AssetFileDescriptor(pfd, fd.getStartOffset(),
                    fd.getDeclaredLength()));
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new FileNotFoundException("Dead content provider: " + uri);
        } //End block
        catch (FileNotFoundException e)
        {
            throw e;
        } //End block
        finally 
        {
            {
                releaseProvider(provider);
            } //End block
        } //End block
        return (AssetFileDescriptor)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.434 -0400", hash_original_method = "39DD117C1A4502740FE90592CCDD92D2", hash_generated_method = "2A0D1F267F6344B438BD007B20029662")
    @DSModeled(DSC.SPEC)
    public OpenResourceIdResult getResourceId(Uri uri) throws FileNotFoundException {
        dsTaint.addTaint(uri.dsTaint);
        String authority;
        authority = uri.getAuthority();
        Resources r;
        {
            boolean var9779973367485DB1CCDF8689D3EBF254_951404273 = (TextUtils.isEmpty(authority));
            {
                if (DroidSafeAndroidRuntime.control) throw new FileNotFoundException("No authority: " + uri);
            } //End block
            {
                try 
                {
                    r = mContext.getPackageManager().getResourcesForApplication(authority);
                } //End block
                catch (NameNotFoundException ex)
                {
                    throw new FileNotFoundException("No package found for authority: " + uri);
                } //End block
            } //End block
        } //End collapsed parenthetic
        List<String> path;
        path = uri.getPathSegments();
        {
            if (DroidSafeAndroidRuntime.control) throw new FileNotFoundException("No path: " + uri);
        } //End block
        int len;
        len = path.size();
        int id;
        {
            try 
            {
                id = Integer.parseInt(path.get(0));
            } //End block
            catch (NumberFormatException e)
            {
                throw new FileNotFoundException("Single path segment is not a resource ID: " + uri);
            } //End block
        } //End block
        {
            id = r.getIdentifier(path.get(1), path.get(0), authority);
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new FileNotFoundException("More than two path segments: " + uri);
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new FileNotFoundException("No resource found for: " + uri);
        } //End block
        OpenResourceIdResult res;
        res = new OpenResourceIdResult();
        res.r = r;
        res.id = id;
        return (OpenResourceIdResult)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.434 -0400", hash_original_method = "C9CAD5745326A7C59519E3986DE53435", hash_generated_method = "C193278971C1C20DD790672BC1B44B6E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.434 -0400", hash_original_method = "21049B5CF31214AC69662F00A8291DA2", hash_generated_method = "62E35370C65CDCD05F4D5FCFA4C3FEA4")
    @DSModeled(DSC.SPEC)
    public final Uri insert(Uri url, ContentValues values) {
        dsTaint.addTaint(values.dsTaint);
        dsTaint.addTaint(url.dsTaint);
        IContentProvider provider;
        provider = acquireProvider(url);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Unknown URL " + url);
        } //End block
        try 
        {
            long startTime;
            startTime = SystemClock.uptimeMillis();
            Uri createdRow;
            createdRow = provider.insert(url, values);
            long durationMillis;
            durationMillis = SystemClock.uptimeMillis() - startTime;
            maybeLogUpdateToEventLog(durationMillis, url, "insert", null );
        } //End block
        catch (RemoteException e)
        { }
        finally 
        {
            releaseProvider(provider);
        } //End block
        return (Uri)dsTaint.getTaint();
        // ---------- Original Method ----------
        //IContentProvider provider = acquireProvider(url);
        //if (provider == null) {
            //throw new IllegalArgumentException("Unknown URL " + url);
        //}
        //try {
            //long startTime = SystemClock.uptimeMillis();
            //Uri createdRow = provider.insert(url, values);
            //long durationMillis = SystemClock.uptimeMillis() - startTime;
            //maybeLogUpdateToEventLog(durationMillis, url, "insert", null );
            //return createdRow;
        //} catch (RemoteException e) {
            //return null;
        //} finally {
            //releaseProvider(provider);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.435 -0400", hash_original_method = "35DA1841C97E840C3B5123B65D72A2FC", hash_generated_method = "5367BBC65C4ABCA4E9D5278C8266F556")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ContentProviderResult[] applyBatch(String authority,
            ArrayList<ContentProviderOperation> operations) throws RemoteException, OperationApplicationException {
        dsTaint.addTaint(authority);
        dsTaint.addTaint(operations.dsTaint);
        ContentProviderClient provider;
        provider = acquireContentProviderClient(authority);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Unknown authority " + authority);
        } //End block
        try 
        {
            ContentProviderResult[] var0BC624ED14CD6CF036AD523265149BCD_1273448762 = (provider.applyBatch(operations));
        } //End block
        finally 
        {
            provider.release();
        } //End block
        return (ContentProviderResult[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //ContentProviderClient provider = acquireContentProviderClient(authority);
        //if (provider == null) {
            //throw new IllegalArgumentException("Unknown authority " + authority);
        //}
        //try {
            //return provider.applyBatch(operations);
        //} finally {
            //provider.release();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.435 -0400", hash_original_method = "B00B6610FA17409048836C33B1F1B82B", hash_generated_method = "2BB7370C941C3CD180AF0CB2C56ECF41")
    @DSModeled(DSC.SPEC)
    public final int bulkInsert(Uri url, ContentValues[] values) {
        dsTaint.addTaint(values[0].dsTaint);
        dsTaint.addTaint(url.dsTaint);
        IContentProvider provider;
        provider = acquireProvider(url);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Unknown URL " + url);
        } //End block
        try 
        {
            long startTime;
            startTime = SystemClock.uptimeMillis();
            int rowsCreated;
            rowsCreated = provider.bulkInsert(url, values);
            long durationMillis;
            durationMillis = SystemClock.uptimeMillis() - startTime;
            maybeLogUpdateToEventLog(durationMillis, url, "bulkinsert", null );
        } //End block
        catch (RemoteException e)
        { }
        finally 
        {
            releaseProvider(provider);
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //IContentProvider provider = acquireProvider(url);
        //if (provider == null) {
            //throw new IllegalArgumentException("Unknown URL " + url);
        //}
        //try {
            //long startTime = SystemClock.uptimeMillis();
            //int rowsCreated = provider.bulkInsert(url, values);
            //long durationMillis = SystemClock.uptimeMillis() - startTime;
            //maybeLogUpdateToEventLog(durationMillis, url, "bulkinsert", null );
            //return rowsCreated;
        //} catch (RemoteException e) {
            //return 0;
        //} finally {
            //releaseProvider(provider);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.435 -0400", hash_original_method = "5F64E7642550035A4284C543DD08EBF1", hash_generated_method = "30A5EAB02DDDBA7402EA830304585F2C")
    @DSModeled(DSC.SPEC)
    public final int delete(Uri url, String where, String[] selectionArgs) {
        dsTaint.addTaint(selectionArgs);
        dsTaint.addTaint(where);
        dsTaint.addTaint(url.dsTaint);
        IContentProvider provider;
        provider = acquireProvider(url);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Unknown URL " + url);
        } //End block
        try 
        {
            long startTime;
            startTime = SystemClock.uptimeMillis();
            int rowsDeleted;
            rowsDeleted = provider.delete(url, where, selectionArgs);
            long durationMillis;
            durationMillis = SystemClock.uptimeMillis() - startTime;
            maybeLogUpdateToEventLog(durationMillis, url, "delete", where);
        } //End block
        catch (RemoteException e)
        { }
        finally 
        {
            releaseProvider(provider);
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //IContentProvider provider = acquireProvider(url);
        //if (provider == null) {
            //throw new IllegalArgumentException("Unknown URL " + url);
        //}
        //try {
            //long startTime = SystemClock.uptimeMillis();
            //int rowsDeleted = provider.delete(url, where, selectionArgs);
            //long durationMillis = SystemClock.uptimeMillis() - startTime;
            //maybeLogUpdateToEventLog(durationMillis, url, "delete", where);
            //return rowsDeleted;
        //} catch (RemoteException e) {
            //return -1;
        //} finally {
            //releaseProvider(provider);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.436 -0400", hash_original_method = "93173B163A2993B2278E9CE2CA5F5268", hash_generated_method = "E2BCD5FD4A29F5A8F93126B734464698")
    @DSModeled(DSC.SPEC)
    public final int update(Uri uri, ContentValues values, String where,
            String[] selectionArgs) {
        dsTaint.addTaint(values.dsTaint);
        dsTaint.addTaint(selectionArgs);
        dsTaint.addTaint(where);
        dsTaint.addTaint(uri.dsTaint);
        IContentProvider provider;
        provider = acquireProvider(uri);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Unknown URI " + uri);
        } //End block
        try 
        {
            long startTime;
            startTime = SystemClock.uptimeMillis();
            int rowsUpdated;
            rowsUpdated = provider.update(uri, values, where, selectionArgs);
            long durationMillis;
            durationMillis = SystemClock.uptimeMillis() - startTime;
            maybeLogUpdateToEventLog(durationMillis, uri, "update", where);
        } //End block
        catch (RemoteException e)
        { }
        finally 
        {
            releaseProvider(provider);
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //IContentProvider provider = acquireProvider(uri);
        //if (provider == null) {
            //throw new IllegalArgumentException("Unknown URI " + uri);
        //}
        //try {
            //long startTime = SystemClock.uptimeMillis();
            //int rowsUpdated = provider.update(uri, values, where, selectionArgs);
            //long durationMillis = SystemClock.uptimeMillis() - startTime;
            //maybeLogUpdateToEventLog(durationMillis, uri, "update", where);
            //return rowsUpdated;
        //} catch (RemoteException e) {
            //return -1;
        //} finally {
            //releaseProvider(provider);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.436 -0400", hash_original_method = "7B97BF1D704BA5CFE2C56D2F21EF49E5", hash_generated_method = "0189F9AF54696B79102F9E4B32A146D2")
    @DSModeled(DSC.SPEC)
    public final Bundle call(Uri uri, String method, String arg, Bundle extras) {
        dsTaint.addTaint(arg);
        dsTaint.addTaint(method);
        dsTaint.addTaint(uri.dsTaint);
        dsTaint.addTaint(extras.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("uri == null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("method == null");
        } //End block
        IContentProvider provider;
        provider = acquireProvider(uri);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Unknown URI " + uri);
        } //End block
        try 
        {
            Bundle var69621EC32EA3A62BD98468A030EBFA82_197340595 = (provider.call(method, arg, extras));
        } //End block
        catch (RemoteException e)
        { }
        finally 
        {
            releaseProvider(provider);
        } //End block
        return (Bundle)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (uri == null) {
            //throw new NullPointerException("uri == null");
        //}
        //if (method == null) {
            //throw new NullPointerException("method == null");
        //}
        //IContentProvider provider = acquireProvider(uri);
        //if (provider == null) {
            //throw new IllegalArgumentException("Unknown URI " + uri);
        //}
        //try {
            //return provider.call(method, arg, extras);
        //} catch (RemoteException e) {
            //return null;
        //} finally {
            //releaseProvider(provider);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.437 -0400", hash_original_method = "337E4492D27C715A525AA87619808C6B", hash_generated_method = "099C481B88B57B70FAF6847BF58263C1")
    @DSModeled(DSC.SPEC)
    public final IContentProvider acquireProvider(Uri uri) {
        dsTaint.addTaint(uri.dsTaint);
        {
            boolean var9032E7F5B68A598423C5832E98A924D2_741739201 = (!SCHEME_CONTENT.equals(uri.getScheme()));
        } //End collapsed parenthetic
        String auth;
        auth = uri.getAuthority();
        {
            IContentProvider varB3C1A90AC7C01B67E9F7822F811EE9C1_1133698039 = (acquireProvider(mContext, uri.getAuthority()));
        } //End block
        return (IContentProvider)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (!SCHEME_CONTENT.equals(uri.getScheme())) {
            //return null;
        //}
        //String auth = uri.getAuthority();
        //if (auth != null) {
            //return acquireProvider(mContext, uri.getAuthority());
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.437 -0400", hash_original_method = "C657A24801BE240D39C6FCA466A49DFE", hash_generated_method = "5F030E664BB3A878052F07F2D7158854")
    @DSModeled(DSC.SPEC)
    public final IContentProvider acquireExistingProvider(Uri uri) {
        dsTaint.addTaint(uri.dsTaint);
        {
            boolean var9032E7F5B68A598423C5832E98A924D2_594532695 = (!SCHEME_CONTENT.equals(uri.getScheme()));
        } //End collapsed parenthetic
        String auth;
        auth = uri.getAuthority();
        {
            IContentProvider var02F0A2D248998F273183B8D812163467_843965176 = (acquireExistingProvider(mContext, uri.getAuthority()));
        } //End block
        return (IContentProvider)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (!SCHEME_CONTENT.equals(uri.getScheme())) {
            //return null;
        //}
        //String auth = uri.getAuthority();
        //if (auth != null) {
            //return acquireExistingProvider(mContext, uri.getAuthority());
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.437 -0400", hash_original_method = "1419B9D62800705D7AC72C916BD8939A", hash_generated_method = "09611CE2A87C0B452BC4650032DABF53")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final IContentProvider acquireProvider(String name) {
        dsTaint.addTaint(name);
        IContentProvider var753FD03D5004485F264F78BD48371BB4_286996757 = (acquireProvider(mContext, name));
        return (IContentProvider)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (name == null) {
            //return null;
        //}
        //return acquireProvider(mContext, name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.438 -0400", hash_original_method = "5741247DD17162DA82750F730CE6B9A7", hash_generated_method = "B044C3E84D242AD36D2C75CB32442DE9")
    @DSModeled(DSC.SPEC)
    public final ContentProviderClient acquireContentProviderClient(Uri uri) {
        dsTaint.addTaint(uri.dsTaint);
        IContentProvider provider;
        provider = acquireProvider(uri);
        return (ContentProviderClient)dsTaint.getTaint();
        // ---------- Original Method ----------
        //IContentProvider provider = acquireProvider(uri);
        //if (provider != null) {
            //return new ContentProviderClient(this, provider);
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.438 -0400", hash_original_method = "01901AA9613048A3AC98A39C9DD35CAC", hash_generated_method = "16D393346B5360CFAD9133493AA8F01B")
    @DSModeled(DSC.SAFE)
    public final ContentProviderClient acquireContentProviderClient(String name) {
        dsTaint.addTaint(name);
        IContentProvider provider;
        provider = acquireProvider(name);
        return (ContentProviderClient)dsTaint.getTaint();
        // ---------- Original Method ----------
        //IContentProvider provider = acquireProvider(name);
        //if (provider != null) {
            //return new ContentProviderClient(this, provider);
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.438 -0400", hash_original_method = "7AFED95A5C5E44717133ED415B77A63B", hash_generated_method = "E65E96B4E89B22B502C6515C5E9A3E87")
    @DSModeled(DSC.SPEC)
    public final void registerContentObserver(Uri uri, boolean notifyForDescendents,
            ContentObserver observer) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(uri.dsTaint);
        dsTaint.addTaint(observer.dsTaint);
        dsTaint.addTaint(notifyForDescendents);
        try 
        {
            getContentService().registerContentObserver(uri, notifyForDescendents,
                    observer.getContentObserver());
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        //try {
            //getContentService().registerContentObserver(uri, notifyForDescendents,
                    //observer.getContentObserver());
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.439 -0400", hash_original_method = "A19276E2B38D6FC8E7769343C0EFAA57", hash_generated_method = "CD71736394FC63699BDBCC7B35CA45BF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void unregisterContentObserver(ContentObserver observer) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(observer.dsTaint);
        try 
        {
            IContentObserver contentObserver;
            contentObserver = observer.releaseContentObserver();
            {
                getContentService().unregisterContentObserver(
                        contentObserver);
            } //End block
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        //try {
            //IContentObserver contentObserver = observer.releaseContentObserver();
            //if (contentObserver != null) {
                //getContentService().unregisterContentObserver(
                        //contentObserver);
            //}
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.439 -0400", hash_original_method = "E76834C8ABF23847CEBC5965503FC8D5", hash_generated_method = "E0CC1C9BF508E4D0772C407CF07D9609")
    @DSModeled(DSC.SPEC)
    public void notifyChange(Uri uri, ContentObserver observer) {
        dsTaint.addTaint(uri.dsTaint);
        dsTaint.addTaint(observer.dsTaint);
        notifyChange(uri, observer, true );
        // ---------- Original Method ----------
        //notifyChange(uri, observer, true );
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.439 -0400", hash_original_method = "F301FE1DDD6CC7648C7F98CD4F863542", hash_generated_method = "8B35CC457CF2DDAEC257842AB3FFE674")
    @DSModeled(DSC.SPEC)
    public void notifyChange(Uri uri, ContentObserver observer, boolean syncToNetwork) {
        dsTaint.addTaint(syncToNetwork);
        dsTaint.addTaint(uri.dsTaint);
        dsTaint.addTaint(observer.dsTaint);
        try 
        {
            getContentService().notifyChange(
                    uri, observer == null ? null : observer.getContentObserver(),
                    observer != null && observer.deliverSelfNotifications(), syncToNetwork);
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        //try {
            //getContentService().notifyChange(
                    //uri, observer == null ? null : observer.getContentObserver(),
                    //observer != null && observer.deliverSelfNotifications(), syncToNetwork);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.439 -0400", hash_original_method = "2D6405030D787F1D91AFA94E2D425989", hash_generated_method = "746E1125FDBA3E46FCE286DFCE2AD0B6")
    @DSModeled(DSC.SPEC)
    @Deprecated
    public void startSync(Uri uri, Bundle extras) {
        dsTaint.addTaint(uri.dsTaint);
        dsTaint.addTaint(extras.dsTaint);
        Account account;
        account = null;
        {
            String accountName;
            accountName = extras.getString(SYNC_EXTRAS_ACCOUNT);
            {
                boolean var21816277CB804514BFAB23F699F0B246_837350478 = (!TextUtils.isEmpty(accountName));
                {
                    account = new Account(accountName, "com.google");
                } //End block
            } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.440 -0400", hash_original_method = "74F2F1DFCCDCB635DED0436014565E52", hash_generated_method = "17A4C14C86165C9B307A200F3CDA3720")
    public static void requestSync(Account account, String authority, Bundle extras) {
        validateSyncExtrasBundle(extras);
        try {
            getContentService().requestSync(account, authority, extras);
        } catch (RemoteException e) {
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.440 -0400", hash_original_method = "2E7D47AE074C06003B60058041EBE60E", hash_generated_method = "4B84445C19C9931C53E98DD70508C5A2")
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
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("unexpected value type: "
                        + value.getClass().getName());
            }
        } catch (IllegalArgumentException e) {
            throw e;
        } catch (RuntimeException exc) {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("error unparceling Bundle", exc);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.440 -0400", hash_original_method = "B4949CE6FC68B3756629FF654EA4F622", hash_generated_method = "319FFEDCE000E6A59B21559AA4512B23")
    @DSModeled(DSC.SPEC)
    @Deprecated
    public void cancelSync(Uri uri) {
        dsTaint.addTaint(uri.dsTaint);
        cancelSync(null , uri != null ? uri.getAuthority() : null);
        // ---------- Original Method ----------
        //cancelSync(null , uri != null ? uri.getAuthority() : null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.440 -0400", hash_original_method = "0579E98D269BB76E67DB1EF7482221ED", hash_generated_method = "46FB2260AB9BF26025F8E4F6CF9AA8A2")
    public static void cancelSync(Account account, String authority) {
        try {
            getContentService().cancelSync(account, authority);
        } catch (RemoteException e) {
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.441 -0400", hash_original_method = "73E621DB5CBC41567953829AD086C09E", hash_generated_method = "6CB02123789FCFB0C1AA6EADC4A389C1")
    public static SyncAdapterType[] getSyncAdapterTypes() {
        try {
            return getContentService().getSyncAdapterTypes();
        } catch (RemoteException e) {
            throw new RuntimeException("the ContentService should always be reachable", e);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.441 -0400", hash_original_method = "40F680882F51B8DF93B91B007EA34DFA", hash_generated_method = "6D4A4B5F83D81A6EAACA1A139F403C60")
    public static boolean getSyncAutomatically(Account account, String authority) {
        try {
            return getContentService().getSyncAutomatically(account, authority);
        } catch (RemoteException e) {
           throw new RuntimeException("the ContentService should always be reachable", e);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.441 -0400", hash_original_method = "C45393365DF55DBBF34D87F9DFB07A0E", hash_generated_method = "746084779CC6F75CCE295965C07A1190")
    public static void setSyncAutomatically(Account account, String authority, boolean sync) {
        try {
            getContentService().setSyncAutomatically(account, authority, sync);
        } catch (RemoteException e) {
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.441 -0400", hash_original_method = "8992802F92BFCE1FEFF92FC805CEE29B", hash_generated_method = "C3F66A636B2DD04CB95FA4039197A573")
    public static void addPeriodicSync(Account account, String authority, Bundle extras,
            long pollFrequency) {
        validateSyncExtrasBundle(extras);
        if (account == null) {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("account must not be null");
        }
        if (authority == null) {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("authority must not be null");
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
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.441 -0400", hash_original_method = "91ED788510ACA5C1DC9947F69B90FEB9", hash_generated_method = "E37E2ABEB6775B23AC7C9C49CCCE6956")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.442 -0400", hash_original_method = "342780EDBB61BA70D8F5407D611A17AB", hash_generated_method = "4ED998824EC22AEC37082CE05FFB7907")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.442 -0400", hash_original_method = "12469DB36272456EC96DBBF2A0C7F6DB", hash_generated_method = "0F2DD104B1307481A16FF088FB86B16E")
    public static int getIsSyncable(Account account, String authority) {
        try {
            return getContentService().getIsSyncable(account, authority);
        } catch (RemoteException e) {
            throw new RuntimeException("the ContentService should always be reachable", e);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.442 -0400", hash_original_method = "0A00860601B883D5D57C7B4B58CC648B", hash_generated_method = "40744B8521D2A9B1A87AA2A2E60586FE")
    public static void setIsSyncable(Account account, String authority, int syncable) {
        try {
            getContentService().setIsSyncable(account, authority, syncable);
        } catch (RemoteException e) {
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.442 -0400", hash_original_method = "F5DC6077E8ABFBA26E9E893D6D658007", hash_generated_method = "F300E4A610B638EB61AB4C30D7029CC2")
    public static boolean getMasterSyncAutomatically() {
        try {
            return getContentService().getMasterSyncAutomatically();
        } catch (RemoteException e) {
            throw new RuntimeException("the ContentService should always be reachable", e);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.442 -0400", hash_original_method = "E617C3DAEABAF8BF63961F3B5075EF6F", hash_generated_method = "1308B45B95A78EF4F0D4A9CC705E897F")
    public static void setMasterSyncAutomatically(boolean sync) {
        try {
            getContentService().setMasterSyncAutomatically(sync);
        } catch (RemoteException e) {
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.443 -0400", hash_original_method = "14DB6E1B33F5033B88DD561A119ACEE1", hash_generated_method = "ECC24B419A569ED6BC69E4161E2272B0")
    public static boolean isSyncActive(Account account, String authority) {
        try {
            return getContentService().isSyncActive(account, authority);
        } catch (RemoteException e) {
            throw new RuntimeException("the ContentService should always be reachable", e);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.443 -0400", hash_original_method = "F46B20DF4060F21E0B5F9B4A6CDDD1B7", hash_generated_method = "438C07BD1AB0B1A7E7F9DA735814947B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.443 -0400", hash_original_method = "B8247507BA2F9E261470E53F362E3C80", hash_generated_method = "91FE7808D34F770BA2D170DA428F9642")
    public static List<SyncInfo> getCurrentSyncs() {
        try {
            return getContentService().getCurrentSyncs();
        } catch (RemoteException e) {
            throw new RuntimeException("the ContentService should always be reachable", e);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.443 -0400", hash_original_method = "3CA3ACEA0F64C037745D2946B86898D9", hash_generated_method = "29F098BA53F2425AC9A06059ABC44C85")
    public static SyncStatusInfo getSyncStatus(Account account, String authority) {
        try {
            return getContentService().getSyncStatus(account, authority);
        } catch (RemoteException e) {
            throw new RuntimeException("the ContentService should always be reachable", e);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.443 -0400", hash_original_method = "6E26412AE39B82DA0658026BDB46955D", hash_generated_method = "37FC511BBA30F02A2A6F58726D81C6C1")
    public static boolean isSyncPending(Account account, String authority) {
        try {
            return getContentService().isSyncPending(account, authority);
        } catch (RemoteException e) {
            throw new RuntimeException("the ContentService should always be reachable", e);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.444 -0400", hash_original_method = "7A0C1068417A87F6CA2637AD64924867", hash_generated_method = "F5B4553A7A3FFEB7B00DC4021ABA9157")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.444 -0400", hash_original_method = "282C0904E19B2398B08E4044AA689CFC", hash_generated_method = "D59EE97E8E4AABCAD601D61D35616F6B")
    public static void removeStatusChangeListener(Object handle) {
        if (handle == null) {
            throw new IllegalArgumentException("you passed in a null handle");
        }
        try {
            getContentService().removeStatusChangeListener((ISyncStatusObserver.Stub) handle);
        } catch (RemoteException e) {
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.444 -0400", hash_original_method = "5964C3B3CD446EC6DF12ED3CA7F7D861", hash_generated_method = "F4040F286103C86DE223BB8BFE154D14")
    @DSModeled(DSC.SAFE)
    private int samplePercentForDuration(long durationMillis) {
        dsTaint.addTaint(durationMillis);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (durationMillis >= SLOW_THRESHOLD_MILLIS) {
            //return 100;
        //}
        //return (int) (100 * durationMillis / SLOW_THRESHOLD_MILLIS) + 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.444 -0400", hash_original_method = "339BAFB8AA6EDB4FDC193A187E8B0067", hash_generated_method = "65FF761906D4F66330D4C4F708AE7AB3")
    @DSModeled(DSC.SPEC)
    private void maybeLogQueryToEventLog(long durationMillis,
                                         Uri uri, String[] projection,
                                         String selection, String sortOrder) {
        dsTaint.addTaint(sortOrder);
        dsTaint.addTaint(projection);
        dsTaint.addTaint(durationMillis);
        dsTaint.addTaint(uri.dsTaint);
        dsTaint.addTaint(selection);
        int samplePercent;
        samplePercent = samplePercentForDuration(durationMillis);
        {
            {
                {
                    boolean var2C548BF82E765EE870985D59E5547BFB_1872998263 = (mRandom.nextInt(100) >= samplePercent);
                } //End collapsed parenthetic
            } //End block
        } //End block
        StringBuilder projectionBuffer;
        projectionBuffer = new StringBuilder(100);
        {
            {
                int i;
                i = 0;
                {
                    projectionBuffer.append('/');
                    projectionBuffer.append(projection[i]);
                } //End block
            } //End collapsed parenthetic
        } //End block
        String blockingPackage;
        blockingPackage = AppGlobals.getInitialPackage();
        EventLog.writeEvent(
            EventLogTags.CONTENT_QUERY_SAMPLE,
            uri.toString(),
            projectionBuffer.toString(),
            selection != null ? selection : "",
            sortOrder != null ? sortOrder : "",
            durationMillis,
            blockingPackage != null ? blockingPackage : "",
            samplePercent);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.445 -0400", hash_original_method = "8C4CA0C0E96B47F9D6365343066B43C9", hash_generated_method = "9B552CAFCC1F53BCE0C3FE1DC61F6643")
    @DSModeled(DSC.SPEC)
    private void maybeLogUpdateToEventLog(
        long durationMillis, Uri uri, String operation, String selection) {
        dsTaint.addTaint(operation);
        dsTaint.addTaint(durationMillis);
        dsTaint.addTaint(uri.dsTaint);
        dsTaint.addTaint(selection);
        int samplePercent;
        samplePercent = samplePercentForDuration(durationMillis);
        {
            {
                {
                    boolean var2C548BF82E765EE870985D59E5547BFB_1820892135 = (mRandom.nextInt(100) >= samplePercent);
                } //End collapsed parenthetic
            } //End block
        } //End block
        String blockingPackage;
        blockingPackage = AppGlobals.getInitialPackage();
        EventLog.writeEvent(
            EventLogTags.CONTENT_UPDATE_SAMPLE,
            uri.toString(),
            operation,
            selection != null ? selection : "",
            durationMillis,
            blockingPackage != null ? blockingPackage : "",
            samplePercent);
        // ---------- Original Method ----------
        //int samplePercent = samplePercentForDuration(durationMillis);
        //if (samplePercent < 100) {
            //synchronized (mRandom) {
                //if (mRandom.nextInt(100) >= samplePercent) {
                    //return;
                //}
            //}
        //}
        //String blockingPackage = AppGlobals.getInitialPackage();
        //EventLog.writeEvent(
            //EventLogTags.CONTENT_UPDATE_SAMPLE,
            //uri.toString(),
            //operation,
            //selection != null ? selection : "",
            //durationMillis,
            //blockingPackage != null ? blockingPackage : "",
            //samplePercent);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.445 -0400", hash_original_method = "B848004A8469BC74A9D0115209F67BC2", hash_generated_method = "94DF7311AC3C0B57DE0F1EDB7F4E1C27")
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
        
    }


    
    private final class CursorWrapperInner extends CrossProcessCursorWrapper {
        private final IContentProvider mContentProvider;
        public static final String TAG="CursorWrapperInner";
        private final CloseGuard mCloseGuard = CloseGuard.get();
        private boolean mProviderReleased;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.445 -0400", hash_original_method = "33833BC2FFA324FE6B3A882C16B09B24", hash_generated_method = "FD335BCB2ACF536405839D20FE769FB5")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         CursorWrapperInner(Cursor cursor, IContentProvider icp) {
            super(cursor);
            dsTaint.addTaint(cursor.dsTaint);
            dsTaint.addTaint(icp.dsTaint);
            mCloseGuard.open("close");
            mContentProvider = icp;
            // ---------- Original Method ----------
            //mContentProvider = icp;
            //mCloseGuard.open("close");
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.446 -0400", hash_original_method = "CB76115716387DD39854EA1927F29C52", hash_generated_method = "33E1545E7B6524CECD0FC63FF2168462")
        @DSModeled(DSC.SAFE)
        @Override
        public void close() {
            super.close();
            ContentResolver.this.releaseProvider(mContentProvider);
            mProviderReleased = true;
            {
                mCloseGuard.close();
            } //End block
            // ---------- Original Method ----------
            //super.close();
            //ContentResolver.this.releaseProvider(mContentProvider);
            //mProviderReleased = true;
            //if (mCloseGuard != null) {
                //mCloseGuard.close();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.446 -0400", hash_original_method = "C6F30BD2AC97CE59E2F19D89687C7506", hash_generated_method = "E4D358344B8044E6C1E8C873F0068DFC")
        @DSModeled(DSC.SAFE)
        @Override
        protected void finalize() throws Throwable {
            try 
            {
                {
                    mCloseGuard.warnIfOpen();
                } //End block
                {
                    ContentResolver.this.releaseProvider(mContentProvider);
                } //End block
            } //End block
            finally 
            {
                super.finalize();
            } //End block
            // ---------- Original Method ----------
            //try {
                //if (mCloseGuard != null) {
                    //mCloseGuard.warnIfOpen();
                //}
                //if (!mProviderReleased && mContentProvider != null) {
                    //Log.w(TAG, "Cursor finalized without prior close()");
                    //ContentResolver.this.releaseProvider(mContentProvider);
                //}
            //} finally {
                //super.finalize();
            //}
        }

        
    }


    
    private final class ParcelFileDescriptorInner extends ParcelFileDescriptor {
        private final IContentProvider mContentProvider;
        public static final String TAG="ParcelFileDescriptorInner";
        private boolean mReleaseProviderFlag = false;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.446 -0400", hash_original_method = "84882D259A9B741E8CCE8DBD7345B8D5", hash_generated_method = "C47ED10D47065031CA2E4185CAFD5C55")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         ParcelFileDescriptorInner(ParcelFileDescriptor pfd, IContentProvider icp) {
            super(pfd);
            dsTaint.addTaint(pfd.dsTaint);
            dsTaint.addTaint(icp.dsTaint);
            mContentProvider = icp;
            // ---------- Original Method ----------
            //mContentProvider = icp;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.446 -0400", hash_original_method = "88C4FC226DB7C9E08A0225C4D4C037C0", hash_generated_method = "D6E5E9BF0A861DA3FB868AD0CD5DD15C")
        @DSModeled(DSC.SAFE)
        @Override
        public void close() throws IOException {
            {
                super.close();
                ContentResolver.this.releaseProvider(mContentProvider);
                mReleaseProviderFlag = true;
            } //End block
            // ---------- Original Method ----------
            //if(!mReleaseProviderFlag) {
                //super.close();
                //ContentResolver.this.releaseProvider(mContentProvider);
                //mReleaseProviderFlag = true;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.447 -0400", hash_original_method = "E5C83F24E1B33F16225B47651FBE1E16", hash_generated_method = "A09F581E7F174558A519117064B9B0E3")
        @DSModeled(DSC.SAFE)
        @Override
        protected void finalize() throws Throwable {
            {
                close();
            } //End block
            // ---------- Original Method ----------
            //if (!mReleaseProviderFlag) {
                //close();
            //}
        }

        
    }


    
}


