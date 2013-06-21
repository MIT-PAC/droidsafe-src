package android.content;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import dalvik.system.CloseGuard;
import android.accounts.Account;
import android.app.ActivityManagerNative;
import android.app.ActivityThread;
import android.app.AppGlobals;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.database.CrossProcessCursorWrapper;
import android.database.Cursor;
import android.database.CursorWrapper;
import android.database.IContentObserver;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.StrictMode;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.EventLog;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class ContentResolver {
    private Random mRandom = new Random();
    private Context mContext;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.718 -0400", hash_original_method = "8EB5ACCD206353DB8493F8AB9F861C85", hash_generated_method = "07DFBCF24085800F2E1D83972E722F61")
    @DSModeled(DSC.SAFE)
    public ContentResolver(Context context) {
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
        //mContext = context;
    }

    
    protected abstract IContentProvider acquireProvider(Context c, String name);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.719 -0400", hash_original_method = "4AF2A0465BC3B713C9C8E0417552AB76", hash_generated_method = "13E2492EDC9B3C3AC620EF2B31548867")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected IContentProvider acquireExistingProvider(Context c, String name) {
        dsTaint.addTaint(c.dsTaint);
        dsTaint.addTaint(name);
        IContentProvider var7616A789170D2AA3DACC7173F7CCEEDA_926220590 = (acquireProvider(c, name));
        return (IContentProvider)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return acquireProvider(c, name);
    }

    
    public abstract boolean releaseProvider(IContentProvider icp);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.720 -0400", hash_original_method = "045596B6E0367AC7BED26FC054AD1E2B", hash_generated_method = "A4D812D5D17F3D5DD223223983F8D063")
    @DSModeled(DSC.SPEC)
    public final String getType(Uri url) {
        dsTaint.addTaint(url.dsTaint);
        IContentProvider provider;
        provider = acquireExistingProvider(url);
        {
            try 
            {
                String var62F8BABA280AC539A38982353657E818_387694859 = (provider.getType(url));
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
            boolean var18721B692F8DF38C1D910B0966D1473B_2029000546 = (!SCHEME_CONTENT.equals(url.getScheme()));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.720 -0400", hash_original_method = "BFD7301BBEDEF32538E97E3FEFB31C63", hash_generated_method = "B4760D9F2EFB72F54C07CD6A5E95044C")
    @DSModeled(DSC.SPEC)
    public String[] getStreamTypes(Uri url, String mimeTypeFilter) {
        dsTaint.addTaint(mimeTypeFilter);
        dsTaint.addTaint(url.dsTaint);
        IContentProvider provider;
        provider = acquireProvider(url);
        try 
        {
            String[] varC0880DAA9133D73EEA535AF1A3760FB5_1997049232 = (provider.getStreamTypes(url, mimeTypeFilter));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.723 -0400", hash_original_method = "505F43360905D398310F020FC85BFA22", hash_generated_method = "0E8BB6801017F937251B27BE20B01E8D")
    @DSModeled(DSC.SPEC)
    public final Cursor query(Uri uri, String[] projection,
            String selection, String[] selectionArgs, String sortOrder) {
        dsTaint.addTaint(selectionArgs[0]);
        dsTaint.addTaint(sortOrder);
        dsTaint.addTaint(projection[0]);
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
            Cursor var08C0A7D23B8C77039FD21F436E982F32_38204838 = (new CursorWrapperInner(qCursor, provider));
        } //End block
        catch (RemoteException e)
        {
            releaseProvider(provider);
        } //End block
        catch (RuntimeException e)
        {
            releaseProvider(provider);
            if (DroidSafeAndroidRuntime.control) throw e;
        } //End block
        return (Cursor)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.731 -0400", hash_original_method = "741F25E5E9079F60798D64718B03495A", hash_generated_method = "1318867B1E6D4894B88B240A120E107F")
    @DSModeled(DSC.SPEC)
    public final InputStream openInputStream(Uri uri) throws FileNotFoundException {
        dsTaint.addTaint(uri.dsTaint);
        String scheme;
        scheme = uri.getScheme();
        {
            boolean varDFD9C1D7BE28AB5E473B86FFFB70E350_308475991 = (SCHEME_ANDROID_RESOURCE.equals(scheme));
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
                boolean var7C16B7242FD360F5FCAE86285293D958_487057152 = (SCHEME_FILE.equals(scheme));
                {
                    InputStream var56197DB113071FD77EC52DA51FA62E26_840353524 = (new FileInputStream(uri.getPath()));
                } //End block
                {
                    AssetFileDescriptor fd;
                    fd = openAssetFileDescriptor(uri, "r");
                    try 
                    {
                        {
                            Object varE5A1CC48B7036EFCB483446D46C36AA2_118418703 = (fd.createInputStream());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.731 -0400", hash_original_method = "11A517824302FF0E2A744E48D03F81F2", hash_generated_method = "0F45A6FFADAB27CB13CFD4AB50BCDAC8")
    @DSModeled(DSC.SPEC)
    public final OutputStream openOutputStream(Uri uri) throws FileNotFoundException {
        dsTaint.addTaint(uri.dsTaint);
        OutputStream varDAFEAE4B62C0FA570C709E3071AAF2D5_1656279405 = (openOutputStream(uri, "w"));
        return (OutputStream)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return openOutputStream(uri, "w");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.732 -0400", hash_original_method = "99597D87D82436F243497E22352BC980", hash_generated_method = "6B80BFBDDB9E42EF529FD892AF948920")
    @DSModeled(DSC.SPEC)
    public final OutputStream openOutputStream(Uri uri, String mode) throws FileNotFoundException {
        dsTaint.addTaint(uri.dsTaint);
        dsTaint.addTaint(mode);
        AssetFileDescriptor fd;
        fd = openAssetFileDescriptor(uri, mode);
        try 
        {
            {
                Object var441F640F4CCE433C78EA3355A62061B7_1332330788 = (fd.createOutputStream());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.732 -0400", hash_original_method = "8C4F5C0648F37279A7BD3F73F68574C8", hash_generated_method = "B06336EEC3974653EAF73B1F9850CF17")
    @DSModeled(DSC.SPEC)
    public final ParcelFileDescriptor openFileDescriptor(Uri uri,
            String mode) throws FileNotFoundException {
        dsTaint.addTaint(uri.dsTaint);
        dsTaint.addTaint(mode);
        AssetFileDescriptor afd;
        afd = openAssetFileDescriptor(uri, mode);
        {
            boolean var8DC5E2F0722D8D5D90D15EC8C0F83F70_580088765 = (afd.getDeclaredLength() < 0);
            {
                ParcelFileDescriptor var5C92900FF6EF260B9BC07111424F278C_1757839509 = (afd.getParcelFileDescriptor());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.733 -0400", hash_original_method = "6D0B2664AB85671E5A18996AE47F9088", hash_generated_method = "4A03638B362D4E9D5DC119CC2814B19D")
    @DSModeled(DSC.SPEC)
    public final AssetFileDescriptor openAssetFileDescriptor(Uri uri,
            String mode) throws FileNotFoundException {
        dsTaint.addTaint(uri.dsTaint);
        dsTaint.addTaint(mode);
        String scheme;
        scheme = uri.getScheme();
        {
            boolean varDFD9C1D7BE28AB5E473B86FFFB70E350_1403253892 = (SCHEME_ANDROID_RESOURCE.equals(scheme));
            {
                {
                    boolean varC16FAE09F0519703CBD513EC3052DFFD_426912772 = (!"r".equals(mode));
                    {
                        if (DroidSafeAndroidRuntime.control) throw new FileNotFoundException("Can't write resources: " + uri);
                    } //End block
                } //End collapsed parenthetic
                OpenResourceIdResult r;
                r = getResourceId(uri);
                try 
                {
                    AssetFileDescriptor varE744077AEB2B3CB026C97EFE683A8AC3_1923751348 = (r.r.openRawResourceFd(r.id));
                } //End block
                catch (Resources.NotFoundException ex)
                {
                    if (DroidSafeAndroidRuntime.control) throw new FileNotFoundException("Resource does not exist: " + uri);
                } //End block
            } //End block
            {
                boolean var7C16B7242FD360F5FCAE86285293D958_2045770313 = (SCHEME_FILE.equals(scheme));
                {
                    ParcelFileDescriptor pfd;
                    pfd = ParcelFileDescriptor.open(
                    new File(uri.getPath()), modeToMode(uri, mode));
                    AssetFileDescriptor var85F10A5855921906B4A67C2077C38731_874007251 = (new AssetFileDescriptor(pfd, 0, -1));
                } //End block
                {
                    {
                        boolean var9E14F7893596A4058297083115E283FF_632078128 = ("r".equals(mode));
                        {
                            AssetFileDescriptor var6124B3414B13A0E5AF2C1A6736CB127C_1153412754 = (openTypedAssetFileDescriptor(uri, "*/*", null));
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
                                AssetFileDescriptor varD8E188F987F4BA27290D58DB21C1C9F2_128764365 = (new AssetFileDescriptor(pfd, fd.getStartOffset(),
                            fd.getDeclaredLength()));
                            } //End block
                            catch (RemoteException e)
                            {
                                if (DroidSafeAndroidRuntime.control) throw new FileNotFoundException("Dead content provider: " + uri);
                            } //End block
                            catch (FileNotFoundException e)
                            {
                                if (DroidSafeAndroidRuntime.control) throw e;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.734 -0400", hash_original_method = "6625A014E29DF928853C1F0BC5B9E856", hash_generated_method = "AC6FCA06BD3D10BADB7B7D04D3116A44")
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
            AssetFileDescriptor varF1569A55F19C591826FC871D7444B2F8_1367728411 = (new AssetFileDescriptor(pfd, fd.getStartOffset(),
                    fd.getDeclaredLength()));
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new FileNotFoundException("Dead content provider: " + uri);
        } //End block
        catch (FileNotFoundException e)
        {
            if (DroidSafeAndroidRuntime.control) throw e;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.735 -0400", hash_original_method = "39DD117C1A4502740FE90592CCDD92D2", hash_generated_method = "1CE5BDE40CA8E8F50367FF6C110BABB9")
    @DSModeled(DSC.SPEC)
    public OpenResourceIdResult getResourceId(Uri uri) throws FileNotFoundException {
        dsTaint.addTaint(uri.dsTaint);
        String authority;
        authority = uri.getAuthority();
        Resources r;
        {
            boolean var9779973367485DB1CCDF8689D3EBF254_1018935574 = (TextUtils.isEmpty(authority));
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
                    if (DroidSafeAndroidRuntime.control) throw new FileNotFoundException("No package found for authority: " + uri);
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
                if (DroidSafeAndroidRuntime.control) throw new FileNotFoundException("Single path segment is not a resource ID: " + uri);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.746 -0400", hash_original_method = "21049B5CF31214AC69662F00A8291DA2", hash_generated_method = "8F3353B29D26B3119D18EF18790C4518")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.747 -0400", hash_original_method = "35DA1841C97E840C3B5123B65D72A2FC", hash_generated_method = "4483C4FE2BBEA9D5F94B5E35804CBFDA")
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
            ContentProviderResult[] var0BC624ED14CD6CF036AD523265149BCD_1843918853 = (provider.applyBatch(operations));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.755 -0400", hash_original_method = "B00B6610FA17409048836C33B1F1B82B", hash_generated_method = "0E2E0A554BE3070CAA1399FFFDC8E10F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.756 -0400", hash_original_method = "5F64E7642550035A4284C543DD08EBF1", hash_generated_method = "8100F775AE186D21DF5F41C5ABD1C629")
    @DSModeled(DSC.SPEC)
    public final int delete(Uri url, String where, String[] selectionArgs) {
        dsTaint.addTaint(selectionArgs[0]);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.757 -0400", hash_original_method = "93173B163A2993B2278E9CE2CA5F5268", hash_generated_method = "2986277AC0CA87F96ADEA37D71424416")
    @DSModeled(DSC.SPEC)
    public final int update(Uri uri, ContentValues values, String where,
            String[] selectionArgs) {
        dsTaint.addTaint(values.dsTaint);
        dsTaint.addTaint(selectionArgs[0]);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.758 -0400", hash_original_method = "7B97BF1D704BA5CFE2C56D2F21EF49E5", hash_generated_method = "1E8A1BF90D1E24072F323FE6404F4F95")
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
            Bundle var69621EC32EA3A62BD98468A030EBFA82_326148188 = (provider.call(method, arg, extras));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.758 -0400", hash_original_method = "337E4492D27C715A525AA87619808C6B", hash_generated_method = "691CDF35EB7A7939F205B6F1D6503823")
    @DSModeled(DSC.SPEC)
    public final IContentProvider acquireProvider(Uri uri) {
        dsTaint.addTaint(uri.dsTaint);
        {
            boolean var9032E7F5B68A598423C5832E98A924D2_1882500482 = (!SCHEME_CONTENT.equals(uri.getScheme()));
        } //End collapsed parenthetic
        String auth;
        auth = uri.getAuthority();
        {
            IContentProvider varB3C1A90AC7C01B67E9F7822F811EE9C1_1310125671 = (acquireProvider(mContext, uri.getAuthority()));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.759 -0400", hash_original_method = "C657A24801BE240D39C6FCA466A49DFE", hash_generated_method = "ED7EE59D1854EA2842C6333D5D08EF4A")
    @DSModeled(DSC.SPEC)
    public final IContentProvider acquireExistingProvider(Uri uri) {
        dsTaint.addTaint(uri.dsTaint);
        {
            boolean var9032E7F5B68A598423C5832E98A924D2_1703609493 = (!SCHEME_CONTENT.equals(uri.getScheme()));
        } //End collapsed parenthetic
        String auth;
        auth = uri.getAuthority();
        {
            IContentProvider var02F0A2D248998F273183B8D812163467_759604907 = (acquireExistingProvider(mContext, uri.getAuthority()));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.760 -0400", hash_original_method = "1419B9D62800705D7AC72C916BD8939A", hash_generated_method = "F5D38D9D5F2F25E760FDDD776D792F43")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final IContentProvider acquireProvider(String name) {
        dsTaint.addTaint(name);
        IContentProvider var753FD03D5004485F264F78BD48371BB4_2116522806 = (acquireProvider(mContext, name));
        return (IContentProvider)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (name == null) {
            //return null;
        //}
        //return acquireProvider(mContext, name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.761 -0400", hash_original_method = "5741247DD17162DA82750F730CE6B9A7", hash_generated_method = "D1736BF121B553FAC6A4C53AF538B17D")
    @DSModeled(DSC.SPEC)
    public final ContentProviderClient acquireContentProviderClient(Uri uri) {
        dsTaint.addTaint(uri.dsTaint);
        IContentProvider provider;
        provider = acquireProvider(uri);
        {
            ContentProviderClient var2E01CE481737C748534B001501953BEB_170217413 = (new ContentProviderClient(this, provider));
        } //End block
        return (ContentProviderClient)dsTaint.getTaint();
        // ---------- Original Method ----------
        //IContentProvider provider = acquireProvider(uri);
        //if (provider != null) {
            //return new ContentProviderClient(this, provider);
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.771 -0400", hash_original_method = "01901AA9613048A3AC98A39C9DD35CAC", hash_generated_method = "33642A7BBE69ACD26269DFB4CA8873C7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final ContentProviderClient acquireContentProviderClient(String name) {
        dsTaint.addTaint(name);
        IContentProvider provider;
        provider = acquireProvider(name);
        {
            ContentProviderClient var2E01CE481737C748534B001501953BEB_1619602104 = (new ContentProviderClient(this, provider));
        } //End block
        return (ContentProviderClient)dsTaint.getTaint();
        // ---------- Original Method ----------
        //IContentProvider provider = acquireProvider(name);
        //if (provider != null) {
            //return new ContentProviderClient(this, provider);
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.771 -0400", hash_original_method = "7AFED95A5C5E44717133ED415B77A63B", hash_generated_method = "7AD7DC377F2B7F5A3BF30268969300D3")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.772 -0400", hash_original_method = "A19276E2B38D6FC8E7769343C0EFAA57", hash_generated_method = "3AEA9C6B37B8AC76664B2408DF133C2F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void unregisterContentObserver(ContentObserver observer) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.772 -0400", hash_original_method = "E76834C8ABF23847CEBC5965503FC8D5", hash_generated_method = "91263CEF77BA1159961F6EE6BCAD3F32")
    @DSModeled(DSC.SPEC)
    public void notifyChange(Uri uri, ContentObserver observer) {
        dsTaint.addTaint(uri.dsTaint);
        dsTaint.addTaint(observer.dsTaint);
        notifyChange(uri, observer, true );
        // ---------- Original Method ----------
        //notifyChange(uri, observer, true );
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.773 -0400", hash_original_method = "F301FE1DDD6CC7648C7F98CD4F863542", hash_generated_method = "C5B88304D3E2AC1CA0253044F426CAE8")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.773 -0400", hash_original_method = "2D6405030D787F1D91AFA94E2D425989", hash_generated_method = "119A0E195A04BFA769D21A002C15D02C")
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
                boolean var21816277CB804514BFAB23F699F0B246_421748723 = (!TextUtils.isEmpty(accountName));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.774 -0400", hash_original_method = "B4949CE6FC68B3756629FF654EA4F622", hash_generated_method = "0A55F048A873FFB4ACC69DE665C1A5E9")
    @DSModeled(DSC.SPEC)
    @Deprecated
    public void cancelSync(Uri uri) {
        dsTaint.addTaint(uri.dsTaint);
        cancelSync(null , uri != null ? uri.getAuthority() : null);
        // ---------- Original Method ----------
        //cancelSync(null , uri != null ? uri.getAuthority() : null);
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
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.787 -0400", hash_original_method = "5964C3B3CD446EC6DF12ED3CA7F7D861", hash_generated_method = "5B9E29B2FE0D3FD765DF5EFF4F2FCB5F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.790 -0400", hash_original_method = "339BAFB8AA6EDB4FDC193A187E8B0067", hash_generated_method = "D793FA5299E15A231E13766FAE7CB575")
    @DSModeled(DSC.SPEC)
    private void maybeLogQueryToEventLog(long durationMillis,
                                         Uri uri, String[] projection,
                                         String selection, String sortOrder) {
        dsTaint.addTaint(sortOrder);
        dsTaint.addTaint(projection[0]);
        dsTaint.addTaint(durationMillis);
        dsTaint.addTaint(uri.dsTaint);
        dsTaint.addTaint(selection);
        int samplePercent;
        samplePercent = samplePercentForDuration(durationMillis);
        {
            {
                {
                    boolean var2C548BF82E765EE870985D59E5547BFB_1787154475 = (mRandom.nextInt(100) >= samplePercent);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.792 -0400", hash_original_method = "8C4CA0C0E96B47F9D6365343066B43C9", hash_generated_method = "85452DFEB58F2684688C2655F02FF333")
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
                    boolean var2C548BF82E765EE870985D59E5547BFB_2092821487 = (mRandom.nextInt(100) >= samplePercent);
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.793 -0400", hash_original_method = "8B7EFD16209288502E24468DA042712B", hash_generated_method = "8B7EFD16209288502E24468DA042712B")
                public OpenResourceIdResult ()
        {
        }


    }


    
    private final class CursorWrapperInner extends CrossProcessCursorWrapper {
        private IContentProvider mContentProvider;
        private CloseGuard mCloseGuard = CloseGuard.get();
        private boolean mProviderReleased;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.793 -0400", hash_original_method = "33833BC2FFA324FE6B3A882C16B09B24", hash_generated_method = "D18E26A4D4DA33BAAC6DC0EE674D5F0F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         CursorWrapperInner(Cursor cursor, IContentProvider icp) {
            super(cursor);
            dsTaint.addTaint(cursor.dsTaint);
            dsTaint.addTaint(icp.dsTaint);
            mCloseGuard.open("close");
            // ---------- Original Method ----------
            //mContentProvider = icp;
            //mCloseGuard.open("close");
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.806 -0400", hash_original_method = "CB76115716387DD39854EA1927F29C52", hash_generated_method = "8346DD9120A3FACE871850785D20B4F6")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.811 -0400", hash_original_method = "C6F30BD2AC97CE59E2F19D89687C7506", hash_generated_method = "1D84EB1DF0FAD05E5DD3B68F884B5D6F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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

        
        public static final String TAG="CursorWrapperInner";
    }


    
    private final class ParcelFileDescriptorInner extends ParcelFileDescriptor {
        private IContentProvider mContentProvider;
        private boolean mReleaseProviderFlag = false;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.812 -0400", hash_original_method = "84882D259A9B741E8CCE8DBD7345B8D5", hash_generated_method = "028C43AE820F23FA17A5B13FF502661C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         ParcelFileDescriptorInner(ParcelFileDescriptor pfd, IContentProvider icp) {
            super(pfd);
            dsTaint.addTaint(pfd.dsTaint);
            dsTaint.addTaint(icp.dsTaint);
            // ---------- Original Method ----------
            //mContentProvider = icp;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.812 -0400", hash_original_method = "88C4FC226DB7C9E08A0225C4D4C037C0", hash_generated_method = "C0DD3FCB29B5C8207E20F17E6CE63C70")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.813 -0400", hash_original_method = "E5C83F24E1B33F16225B47651FBE1E16", hash_generated_method = "0A895962D46081094F888ADADCCE02CC")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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

        
        public static final String TAG="ParcelFileDescriptorInner";
    }


    
    @Deprecated public static final String SYNC_EXTRAS_ACCOUNT = "account";
    public static final String SYNC_EXTRAS_EXPEDITED = "expedited";
    @Deprecated public static final String SYNC_EXTRAS_FORCE = "force";
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

