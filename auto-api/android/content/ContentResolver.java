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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.036 -0400", hash_original_field = "536255EED7E3D46DD70E09FDE814B7C1", hash_generated_field = "C9556CF5DE25C89A85FB17574BD65906")

    private Random mRandom = new Random();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.059 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.060 -0400", hash_original_method = "8EB5ACCD206353DB8493F8AB9F861C85", hash_generated_method = "934BE422B780F73056F691B084F33D1F")
    public  ContentResolver(Context context) {
        mContext = context;
        // ---------- Original Method ----------
        //mContext = context;
    }

    
    protected abstract IContentProvider acquireProvider(Context c, String name);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.062 -0400", hash_original_method = "4AF2A0465BC3B713C9C8E0417552AB76", hash_generated_method = "2DF3A8B9203F5E87CE6E1636C1CBB49F")
    protected IContentProvider acquireExistingProvider(Context c, String name) {
        IContentProvider varB4EAC82CA7396A68D541C85D26508E83_1504040815 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1504040815 = acquireProvider(c, name);
        addTaint(c.getTaint());
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1504040815.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1504040815;
        // ---------- Original Method ----------
        //return acquireProvider(c, name);
    }

    
    public abstract boolean releaseProvider(IContentProvider icp);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.099 -0400", hash_original_method = "045596B6E0367AC7BED26FC054AD1E2B", hash_generated_method = "EA580D4571E4B8A7D0BD3F08F62D3B06")
    public final String getType(Uri url) {
        String varB4EAC82CA7396A68D541C85D26508E83_1175554266 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_531020163 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_1437841468 = null; //Variable for return #3
        String varB4EAC82CA7396A68D541C85D26508E83_534773321 = null; //Variable for return #4
        String varB4EAC82CA7396A68D541C85D26508E83_1112303948 = null; //Variable for return #5
        String varB4EAC82CA7396A68D541C85D26508E83_703897204 = null; //Variable for return #6
        String varB4EAC82CA7396A68D541C85D26508E83_1189637325 = null; //Variable for return #7
        IContentProvider provider;
        provider = acquireExistingProvider(url);
        {
            try 
            {
                varB4EAC82CA7396A68D541C85D26508E83_1175554266 = provider.getType(url);
            } //End block
            catch (RemoteException e)
            {
                varB4EAC82CA7396A68D541C85D26508E83_531020163 = null;
            } //End block
            catch (java.lang.Exception e)
            {
                varB4EAC82CA7396A68D541C85D26508E83_1437841468 = null;
            } //End block
            finally 
            {
                releaseProvider(provider);
            } //End block
        } //End block
        {
            boolean var18721B692F8DF38C1D910B0966D1473B_587989122 = (!SCHEME_CONTENT.equals(url.getScheme()));
            {
                varB4EAC82CA7396A68D541C85D26508E83_534773321 = null;
            } //End block
        } //End collapsed parenthetic
        try 
        {
            String type;
            type = ActivityManagerNative.getDefault().getProviderMimeType(url);
            varB4EAC82CA7396A68D541C85D26508E83_1112303948 = type;
        } //End block
        catch (RemoteException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_703897204 = null;
        } //End block
        catch (java.lang.Exception e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1189637325 = null;
        } //End block
        addTaint(url.getTaint());
        String varA7E53CE21691AB073D9660D615818899_1532349946; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1532349946 = varB4EAC82CA7396A68D541C85D26508E83_1175554266;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1532349946 = varB4EAC82CA7396A68D541C85D26508E83_531020163;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1532349946 = varB4EAC82CA7396A68D541C85D26508E83_1437841468;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_1532349946 = varB4EAC82CA7396A68D541C85D26508E83_534773321;
                break;
            case 5: //Assign result for return ordinal #5
                varA7E53CE21691AB073D9660D615818899_1532349946 = varB4EAC82CA7396A68D541C85D26508E83_1112303948;
                break;
            case 6: //Assign result for return ordinal #6
                varA7E53CE21691AB073D9660D615818899_1532349946 = varB4EAC82CA7396A68D541C85D26508E83_703897204;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1532349946 = varB4EAC82CA7396A68D541C85D26508E83_1189637325;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1532349946.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1532349946;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.108 -0400", hash_original_method = "BFD7301BBEDEF32538E97E3FEFB31C63", hash_generated_method = "4265BD895DB18D45E1DEDBB0CAABBD8B")
    public String[] getStreamTypes(Uri url, String mimeTypeFilter) {
        String[] varB4EAC82CA7396A68D541C85D26508E83_1595591720 = null; //Variable for return #1
        String[] varB4EAC82CA7396A68D541C85D26508E83_258578885 = null; //Variable for return #2
        String[] varB4EAC82CA7396A68D541C85D26508E83_1834032732 = null; //Variable for return #3
        IContentProvider provider;
        provider = acquireProvider(url);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1595591720 = null;
        } //End block
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_258578885 = provider.getStreamTypes(url, mimeTypeFilter);
        } //End block
        catch (RemoteException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1834032732 = null;
        } //End block
        finally 
        {
            releaseProvider(provider);
        } //End block
        addTaint(url.getTaint());
        addTaint(mimeTypeFilter.getTaint());
        String[] varA7E53CE21691AB073D9660D615818899_798773777; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_798773777 = varB4EAC82CA7396A68D541C85D26508E83_1595591720;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_798773777 = varB4EAC82CA7396A68D541C85D26508E83_258578885;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_798773777 = varB4EAC82CA7396A68D541C85D26508E83_1834032732;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_798773777.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_798773777;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.129 -0400", hash_original_method = "505F43360905D398310F020FC85BFA22", hash_generated_method = "2600CDC7E994F6C99B9CCFFFC709F2CD")
    public final Cursor query(Uri uri, String[] projection,
            String selection, String[] selectionArgs, String sortOrder) {
        Cursor varB4EAC82CA7396A68D541C85D26508E83_668348655 = null; //Variable for return #1
        Cursor varB4EAC82CA7396A68D541C85D26508E83_1966078290 = null; //Variable for return #2
        Cursor varB4EAC82CA7396A68D541C85D26508E83_1317707898 = null; //Variable for return #3
        Cursor varB4EAC82CA7396A68D541C85D26508E83_1227669091 = null; //Variable for return #4
        IContentProvider provider;
        provider = acquireProvider(uri);
        {
            varB4EAC82CA7396A68D541C85D26508E83_668348655 = null;
        } //End block
        try 
        {
            long startTime;
            startTime = SystemClock.uptimeMillis();
            Cursor qCursor;
            qCursor = provider.query(uri, projection, selection, selectionArgs, sortOrder);
            {
                releaseProvider(provider);
                varB4EAC82CA7396A68D541C85D26508E83_1966078290 = null;
            } //End block
            qCursor.getCount();
            long durationMillis;
            durationMillis = SystemClock.uptimeMillis() - startTime;
            maybeLogQueryToEventLog(durationMillis, uri, projection, selection, sortOrder);
            varB4EAC82CA7396A68D541C85D26508E83_1317707898 = new CursorWrapperInner(qCursor, provider);
        } //End block
        catch (RemoteException e)
        {
            releaseProvider(provider);
            varB4EAC82CA7396A68D541C85D26508E83_1227669091 = null;
        } //End block
        catch (RuntimeException e)
        {
            releaseProvider(provider);
            if (DroidSafeAndroidRuntime.control) throw e;
        } //End block
        addTaint(uri.getTaint());
        addTaint(projection[0].getTaint());
        addTaint(selection.getTaint());
        addTaint(selectionArgs[0].getTaint());
        addTaint(sortOrder.getTaint());
        Cursor varA7E53CE21691AB073D9660D615818899_1941844422; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1941844422 = varB4EAC82CA7396A68D541C85D26508E83_668348655;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1941844422 = varB4EAC82CA7396A68D541C85D26508E83_1966078290;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1941844422 = varB4EAC82CA7396A68D541C85D26508E83_1317707898;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1941844422 = varB4EAC82CA7396A68D541C85D26508E83_1227669091;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1941844422.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1941844422;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.157 -0400", hash_original_method = "741F25E5E9079F60798D64718B03495A", hash_generated_method = "3529FE7A0B5E1C61A5C353920485FF5A")
    public final InputStream openInputStream(Uri uri) throws FileNotFoundException {
        InputStream varB4EAC82CA7396A68D541C85D26508E83_2097611557 = null; //Variable for return #1
        InputStream varB4EAC82CA7396A68D541C85D26508E83_1320946523 = null; //Variable for return #2
        InputStream varB4EAC82CA7396A68D541C85D26508E83_2126545406 = null; //Variable for return #3
        String scheme;
        scheme = uri.getScheme();
        {
            boolean varDFD9C1D7BE28AB5E473B86FFFB70E350_349835352 = (SCHEME_ANDROID_RESOURCE.equals(scheme));
            {
                OpenResourceIdResult r;
                r = getResourceId(uri);
                try 
                {
                    InputStream stream;
                    stream = r.r.openRawResource(r.id);
                    varB4EAC82CA7396A68D541C85D26508E83_2097611557 = stream;
                } //End block
                catch (Resources.NotFoundException ex)
                {
                    if (DroidSafeAndroidRuntime.control) throw new FileNotFoundException("Resource does not exist: " + uri);
                } //End block
            } //End block
            {
                boolean var7C16B7242FD360F5FCAE86285293D958_1049143454 = (SCHEME_FILE.equals(scheme));
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1320946523 = new FileInputStream(uri.getPath());
                } //End block
                {
                    AssetFileDescriptor fd;
                    fd = openAssetFileDescriptor(uri, "r");
                    try 
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_2126545406 = fd != null ? fd.createInputStream() : null;
                    } //End block
                    catch (IOException e)
                    {
                        if (DroidSafeAndroidRuntime.control) throw new FileNotFoundException("Unable to create stream");
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        addTaint(uri.getTaint());
        InputStream varA7E53CE21691AB073D9660D615818899_912082339; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_912082339 = varB4EAC82CA7396A68D541C85D26508E83_2097611557;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_912082339 = varB4EAC82CA7396A68D541C85D26508E83_1320946523;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_912082339 = varB4EAC82CA7396A68D541C85D26508E83_2126545406;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_912082339.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_912082339;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.160 -0400", hash_original_method = "11A517824302FF0E2A744E48D03F81F2", hash_generated_method = "E2D25F1BC9A37DDADE92B2F14ABB80B6")
    public final OutputStream openOutputStream(Uri uri) throws FileNotFoundException {
        OutputStream varB4EAC82CA7396A68D541C85D26508E83_1759871582 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1759871582 = openOutputStream(uri, "w");
        addTaint(uri.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1759871582.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1759871582;
        // ---------- Original Method ----------
        //return openOutputStream(uri, "w");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.161 -0400", hash_original_method = "99597D87D82436F243497E22352BC980", hash_generated_method = "2D0EC2EA85EB6857E04B72E8A7BC9B21")
    public final OutputStream openOutputStream(Uri uri, String mode) throws FileNotFoundException {
        OutputStream varB4EAC82CA7396A68D541C85D26508E83_1397127098 = null; //Variable for return #1
        AssetFileDescriptor fd;
        fd = openAssetFileDescriptor(uri, mode);
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1397127098 = fd != null ? fd.createOutputStream() : null;
        } //End block
        catch (IOException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new FileNotFoundException("Unable to create stream");
        } //End block
        addTaint(uri.getTaint());
        addTaint(mode.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1397127098.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1397127098;
        // ---------- Original Method ----------
        //AssetFileDescriptor fd = openAssetFileDescriptor(uri, mode);
        //try {
            //return fd != null ? fd.createOutputStream() : null;
        //} catch (IOException e) {
            //throw new FileNotFoundException("Unable to create stream");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.189 -0400", hash_original_method = "8C4F5C0648F37279A7BD3F73F68574C8", hash_generated_method = "35A7BF72ABA9EE07E83D5FE8843AB1E4")
    public final ParcelFileDescriptor openFileDescriptor(Uri uri,
            String mode) throws FileNotFoundException {
        ParcelFileDescriptor varB4EAC82CA7396A68D541C85D26508E83_1098677975 = null; //Variable for return #1
        ParcelFileDescriptor varB4EAC82CA7396A68D541C85D26508E83_1947025650 = null; //Variable for return #2
        AssetFileDescriptor afd;
        afd = openAssetFileDescriptor(uri, mode);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1098677975 = null;
        } //End block
        {
            boolean var8DC5E2F0722D8D5D90D15EC8C0F83F70_1341827048 = (afd.getDeclaredLength() < 0);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1947025650 = afd.getParcelFileDescriptor();
            } //End block
        } //End collapsed parenthetic
        try 
        {
            afd.close();
        } //End block
        catch (IOException e)
        { }
        if (DroidSafeAndroidRuntime.control) throw new FileNotFoundException("Not a whole file");
        addTaint(uri.getTaint());
        addTaint(mode.getTaint());
        ParcelFileDescriptor varA7E53CE21691AB073D9660D615818899_1774556807; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1774556807 = varB4EAC82CA7396A68D541C85D26508E83_1098677975;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1774556807 = varB4EAC82CA7396A68D541C85D26508E83_1947025650;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1774556807.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1774556807;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.218 -0400", hash_original_method = "6D0B2664AB85671E5A18996AE47F9088", hash_generated_method = "41B96BC3378A98065B0C55680983FCCA")
    public final AssetFileDescriptor openAssetFileDescriptor(Uri uri,
            String mode) throws FileNotFoundException {
        AssetFileDescriptor varB4EAC82CA7396A68D541C85D26508E83_1693124732 = null; //Variable for return #1
        AssetFileDescriptor varB4EAC82CA7396A68D541C85D26508E83_1833929012 = null; //Variable for return #2
        AssetFileDescriptor varB4EAC82CA7396A68D541C85D26508E83_1346865735 = null; //Variable for return #3
        AssetFileDescriptor varB4EAC82CA7396A68D541C85D26508E83_864216797 = null; //Variable for return #4
        AssetFileDescriptor varB4EAC82CA7396A68D541C85D26508E83_2048611840 = null; //Variable for return #5
        String scheme;
        scheme = uri.getScheme();
        {
            boolean varDFD9C1D7BE28AB5E473B86FFFB70E350_1096750298 = (SCHEME_ANDROID_RESOURCE.equals(scheme));
            {
                {
                    boolean varC16FAE09F0519703CBD513EC3052DFFD_1909543336 = (!"r".equals(mode));
                    {
                        if (DroidSafeAndroidRuntime.control) throw new FileNotFoundException("Can't write resources: " + uri);
                    } //End block
                } //End collapsed parenthetic
                OpenResourceIdResult r;
                r = getResourceId(uri);
                try 
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1693124732 = r.r.openRawResourceFd(r.id);
                } //End block
                catch (Resources.NotFoundException ex)
                {
                    if (DroidSafeAndroidRuntime.control) throw new FileNotFoundException("Resource does not exist: " + uri);
                } //End block
            } //End block
            {
                boolean var7C16B7242FD360F5FCAE86285293D958_1707087897 = (SCHEME_FILE.equals(scheme));
                {
                    ParcelFileDescriptor pfd;
                    pfd = ParcelFileDescriptor.open(
                    new File(uri.getPath()), modeToMode(uri, mode));
                    varB4EAC82CA7396A68D541C85D26508E83_1833929012 = new AssetFileDescriptor(pfd, 0, -1);
                } //End block
                {
                    {
                        boolean var9E14F7893596A4058297083115E283FF_556548141 = ("r".equals(mode));
                        {
                            varB4EAC82CA7396A68D541C85D26508E83_1346865735 = openTypedAssetFileDescriptor(uri, "*/*", null);
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
                                {
                                    varB4EAC82CA7396A68D541C85D26508E83_864216797 = null;
                                } //End block
                                ParcelFileDescriptor pfd;
                                pfd = new ParcelFileDescriptorInner(
                            fd.getParcelFileDescriptor(), provider);
                                provider = null;
                                varB4EAC82CA7396A68D541C85D26508E83_2048611840 = new AssetFileDescriptor(pfd, fd.getStartOffset(),
                            fd.getDeclaredLength());
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
        addTaint(uri.getTaint());
        addTaint(mode.getTaint());
        AssetFileDescriptor varA7E53CE21691AB073D9660D615818899_354610177; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_354610177 = varB4EAC82CA7396A68D541C85D26508E83_1693124732;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_354610177 = varB4EAC82CA7396A68D541C85D26508E83_1833929012;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_354610177 = varB4EAC82CA7396A68D541C85D26508E83_1346865735;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_354610177 = varB4EAC82CA7396A68D541C85D26508E83_864216797;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_354610177 = varB4EAC82CA7396A68D541C85D26508E83_2048611840;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_354610177.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_354610177;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.246 -0400", hash_original_method = "6625A014E29DF928853C1F0BC5B9E856", hash_generated_method = "185B8964F3B81FFF0A20F7B2DFFDB903")
    public final AssetFileDescriptor openTypedAssetFileDescriptor(Uri uri,
            String mimeType, Bundle opts) throws FileNotFoundException {
        AssetFileDescriptor varB4EAC82CA7396A68D541C85D26508E83_614365075 = null; //Variable for return #1
        AssetFileDescriptor varB4EAC82CA7396A68D541C85D26508E83_1955028657 = null; //Variable for return #2
        IContentProvider provider;
        provider = acquireProvider(uri);
        {
            if (DroidSafeAndroidRuntime.control) throw new FileNotFoundException("No content provider: " + uri);
        } //End block
        try 
        {
            AssetFileDescriptor fd;
            fd = provider.openTypedAssetFile(uri, mimeType, opts);
            {
                varB4EAC82CA7396A68D541C85D26508E83_614365075 = null;
            } //End block
            ParcelFileDescriptor pfd;
            pfd = new ParcelFileDescriptorInner(
                    fd.getParcelFileDescriptor(), provider);
            provider = null;
            varB4EAC82CA7396A68D541C85D26508E83_1955028657 = new AssetFileDescriptor(pfd, fd.getStartOffset(),
                    fd.getDeclaredLength());
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
        addTaint(uri.getTaint());
        addTaint(mimeType.getTaint());
        addTaint(opts.getTaint());
        AssetFileDescriptor varA7E53CE21691AB073D9660D615818899_1668570329; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1668570329 = varB4EAC82CA7396A68D541C85D26508E83_614365075;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1668570329 = varB4EAC82CA7396A68D541C85D26508E83_1955028657;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1668570329.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1668570329;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.253 -0400", hash_original_method = "39DD117C1A4502740FE90592CCDD92D2", hash_generated_method = "258F53816724C0F377E749195C1C0E2C")
    public OpenResourceIdResult getResourceId(Uri uri) throws FileNotFoundException {
        OpenResourceIdResult varB4EAC82CA7396A68D541C85D26508E83_1409789901 = null; //Variable for return #1
        String authority;
        authority = uri.getAuthority();
        Resources r;
        {
            boolean var9779973367485DB1CCDF8689D3EBF254_1300781108 = (TextUtils.isEmpty(authority));
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
        varB4EAC82CA7396A68D541C85D26508E83_1409789901 = res;
        addTaint(uri.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1409789901.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1409789901;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.288 -0400", hash_original_method = "21049B5CF31214AC69662F00A8291DA2", hash_generated_method = "E4CDB8991D27A26F57EC56013FDC672E")
    public final Uri insert(Uri url, ContentValues values) {
        Uri varB4EAC82CA7396A68D541C85D26508E83_924973610 = null; //Variable for return #1
        Uri varB4EAC82CA7396A68D541C85D26508E83_5698444 = null; //Variable for return #2
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
            varB4EAC82CA7396A68D541C85D26508E83_924973610 = createdRow;
        } //End block
        catch (RemoteException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_5698444 = null;
        } //End block
        finally 
        {
            releaseProvider(provider);
        } //End block
        addTaint(url.getTaint());
        addTaint(values.getTaint());
        Uri varA7E53CE21691AB073D9660D615818899_745728515; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_745728515 = varB4EAC82CA7396A68D541C85D26508E83_924973610;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_745728515 = varB4EAC82CA7396A68D541C85D26508E83_5698444;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_745728515.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_745728515;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.301 -0400", hash_original_method = "35DA1841C97E840C3B5123B65D72A2FC", hash_generated_method = "94A36DAFF7E27569A4CC10EF06BD5B6D")
    public ContentProviderResult[] applyBatch(String authority,
            ArrayList<ContentProviderOperation> operations) throws RemoteException, OperationApplicationException {
        ContentProviderResult[] varB4EAC82CA7396A68D541C85D26508E83_1945907590 = null; //Variable for return #1
        ContentProviderClient provider;
        provider = acquireContentProviderClient(authority);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Unknown authority " + authority);
        } //End block
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1945907590 = provider.applyBatch(operations);
        } //End block
        finally 
        {
            provider.release();
        } //End block
        addTaint(authority.getTaint());
        addTaint(operations.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1945907590.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1945907590;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.303 -0400", hash_original_method = "B00B6610FA17409048836C33B1F1B82B", hash_generated_method = "110CF8440C8B4831F5569700CD5DB8B0")
    public final int bulkInsert(Uri url, ContentValues[] values) {
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
        addTaint(url.getTaint());
        addTaint(values[0].getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1191530806 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1191530806;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.314 -0400", hash_original_method = "5F64E7642550035A4284C543DD08EBF1", hash_generated_method = "9F4580164BF24DFB382453BC13D7D047")
    public final int delete(Uri url, String where, String[] selectionArgs) {
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
        addTaint(url.getTaint());
        addTaint(where.getTaint());
        addTaint(selectionArgs[0].getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_753883558 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_753883558;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.340 -0400", hash_original_method = "93173B163A2993B2278E9CE2CA5F5268", hash_generated_method = "AA9DFA3EABDFEF577D172D52D9C9B29A")
    public final int update(Uri uri, ContentValues values, String where,
            String[] selectionArgs) {
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
        addTaint(uri.getTaint());
        addTaint(values.getTaint());
        addTaint(where.getTaint());
        addTaint(selectionArgs[0].getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_622376846 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_622376846;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.342 -0400", hash_original_method = "7B97BF1D704BA5CFE2C56D2F21EF49E5", hash_generated_method = "A0E05BBA98E7A8CD9A74B8F3A3EBF620")
    public final Bundle call(Uri uri, String method, String arg, Bundle extras) {
        Bundle varB4EAC82CA7396A68D541C85D26508E83_408227823 = null; //Variable for return #1
        Bundle varB4EAC82CA7396A68D541C85D26508E83_1906320618 = null; //Variable for return #2
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
            varB4EAC82CA7396A68D541C85D26508E83_408227823 = provider.call(method, arg, extras);
        } //End block
        catch (RemoteException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1906320618 = null;
        } //End block
        finally 
        {
            releaseProvider(provider);
        } //End block
        addTaint(uri.getTaint());
        addTaint(method.getTaint());
        addTaint(arg.getTaint());
        addTaint(extras.getTaint());
        Bundle varA7E53CE21691AB073D9660D615818899_574661799; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_574661799 = varB4EAC82CA7396A68D541C85D26508E83_408227823;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_574661799 = varB4EAC82CA7396A68D541C85D26508E83_1906320618;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_574661799.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_574661799;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.359 -0400", hash_original_method = "337E4492D27C715A525AA87619808C6B", hash_generated_method = "2AD68A5BE3E3E43040634EC4E6A915FD")
    public final IContentProvider acquireProvider(Uri uri) {
        IContentProvider varB4EAC82CA7396A68D541C85D26508E83_767075238 = null; //Variable for return #1
        IContentProvider varB4EAC82CA7396A68D541C85D26508E83_261490973 = null; //Variable for return #2
        IContentProvider varB4EAC82CA7396A68D541C85D26508E83_1664119412 = null; //Variable for return #3
        {
            boolean var9032E7F5B68A598423C5832E98A924D2_386348631 = (!SCHEME_CONTENT.equals(uri.getScheme()));
            {
                varB4EAC82CA7396A68D541C85D26508E83_767075238 = null;
            } //End block
        } //End collapsed parenthetic
        String auth;
        auth = uri.getAuthority();
        {
            varB4EAC82CA7396A68D541C85D26508E83_261490973 = acquireProvider(mContext, uri.getAuthority());
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1664119412 = null;
        addTaint(uri.getTaint());
        IContentProvider varA7E53CE21691AB073D9660D615818899_834918251; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_834918251 = varB4EAC82CA7396A68D541C85D26508E83_767075238;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_834918251 = varB4EAC82CA7396A68D541C85D26508E83_261490973;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_834918251 = varB4EAC82CA7396A68D541C85D26508E83_1664119412;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_834918251.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_834918251;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.362 -0400", hash_original_method = "C657A24801BE240D39C6FCA466A49DFE", hash_generated_method = "E4B6B6A2F88744EB466F2F07D5500B2F")
    public final IContentProvider acquireExistingProvider(Uri uri) {
        IContentProvider varB4EAC82CA7396A68D541C85D26508E83_516519783 = null; //Variable for return #1
        IContentProvider varB4EAC82CA7396A68D541C85D26508E83_1673651256 = null; //Variable for return #2
        IContentProvider varB4EAC82CA7396A68D541C85D26508E83_2105192345 = null; //Variable for return #3
        {
            boolean var9032E7F5B68A598423C5832E98A924D2_1903301281 = (!SCHEME_CONTENT.equals(uri.getScheme()));
            {
                varB4EAC82CA7396A68D541C85D26508E83_516519783 = null;
            } //End block
        } //End collapsed parenthetic
        String auth;
        auth = uri.getAuthority();
        {
            varB4EAC82CA7396A68D541C85D26508E83_1673651256 = acquireExistingProvider(mContext, uri.getAuthority());
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_2105192345 = null;
        addTaint(uri.getTaint());
        IContentProvider varA7E53CE21691AB073D9660D615818899_1308335985; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1308335985 = varB4EAC82CA7396A68D541C85D26508E83_516519783;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1308335985 = varB4EAC82CA7396A68D541C85D26508E83_1673651256;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1308335985 = varB4EAC82CA7396A68D541C85D26508E83_2105192345;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1308335985.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1308335985;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.379 -0400", hash_original_method = "1419B9D62800705D7AC72C916BD8939A", hash_generated_method = "43E6928CF7EEDADBC73C267249B9DAC0")
    public final IContentProvider acquireProvider(String name) {
        IContentProvider varB4EAC82CA7396A68D541C85D26508E83_1480208012 = null; //Variable for return #1
        IContentProvider varB4EAC82CA7396A68D541C85D26508E83_1487744260 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_1480208012 = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1487744260 = acquireProvider(mContext, name);
        addTaint(name.getTaint());
        IContentProvider varA7E53CE21691AB073D9660D615818899_267239413; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_267239413 = varB4EAC82CA7396A68D541C85D26508E83_1480208012;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_267239413 = varB4EAC82CA7396A68D541C85D26508E83_1487744260;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_267239413.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_267239413;
        // ---------- Original Method ----------
        //if (name == null) {
            //return null;
        //}
        //return acquireProvider(mContext, name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.400 -0400", hash_original_method = "5741247DD17162DA82750F730CE6B9A7", hash_generated_method = "C79C50AF4F22BADAC84FB1FD8287FC46")
    public final ContentProviderClient acquireContentProviderClient(Uri uri) {
        ContentProviderClient varB4EAC82CA7396A68D541C85D26508E83_1955997883 = null; //Variable for return #1
        ContentProviderClient varB4EAC82CA7396A68D541C85D26508E83_448533052 = null; //Variable for return #2
        IContentProvider provider;
        provider = acquireProvider(uri);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1955997883 = new ContentProviderClient(this, provider);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_448533052 = null;
        addTaint(uri.getTaint());
        ContentProviderClient varA7E53CE21691AB073D9660D615818899_18185528; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_18185528 = varB4EAC82CA7396A68D541C85D26508E83_1955997883;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_18185528 = varB4EAC82CA7396A68D541C85D26508E83_448533052;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_18185528.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_18185528;
        // ---------- Original Method ----------
        //IContentProvider provider = acquireProvider(uri);
        //if (provider != null) {
            //return new ContentProviderClient(this, provider);
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.417 -0400", hash_original_method = "01901AA9613048A3AC98A39C9DD35CAC", hash_generated_method = "D05851417E7FBE3567944F91E4EC9326")
    public final ContentProviderClient acquireContentProviderClient(String name) {
        ContentProviderClient varB4EAC82CA7396A68D541C85D26508E83_1997631555 = null; //Variable for return #1
        ContentProviderClient varB4EAC82CA7396A68D541C85D26508E83_2056618439 = null; //Variable for return #2
        IContentProvider provider;
        provider = acquireProvider(name);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1997631555 = new ContentProviderClient(this, provider);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_2056618439 = null;
        addTaint(name.getTaint());
        ContentProviderClient varA7E53CE21691AB073D9660D615818899_508545459; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_508545459 = varB4EAC82CA7396A68D541C85D26508E83_1997631555;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_508545459 = varB4EAC82CA7396A68D541C85D26508E83_2056618439;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_508545459.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_508545459;
        // ---------- Original Method ----------
        //IContentProvider provider = acquireProvider(name);
        //if (provider != null) {
            //return new ContentProviderClient(this, provider);
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.419 -0400", hash_original_method = "7AFED95A5C5E44717133ED415B77A63B", hash_generated_method = "418793DF18B94EEC380FC05A36ED79F0")
    public final void registerContentObserver(Uri uri, boolean notifyForDescendents,
            ContentObserver observer) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        try 
        {
            getContentService().registerContentObserver(uri, notifyForDescendents,
                    observer.getContentObserver());
        } //End block
        catch (RemoteException e)
        { }
        addTaint(uri.getTaint());
        addTaint(notifyForDescendents);
        addTaint(observer.getTaint());
        // ---------- Original Method ----------
        //try {
            //getContentService().registerContentObserver(uri, notifyForDescendents,
                    //observer.getContentObserver());
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.420 -0400", hash_original_method = "A19276E2B38D6FC8E7769343C0EFAA57", hash_generated_method = "D057F1285B51A12D8A4A93F3A56CFA20")
    public final void unregisterContentObserver(ContentObserver observer) {
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
        addTaint(observer.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.435 -0400", hash_original_method = "E76834C8ABF23847CEBC5965503FC8D5", hash_generated_method = "721276707545B26042C057743EC44CDD")
    public void notifyChange(Uri uri, ContentObserver observer) {
        notifyChange(uri, observer, true );
        addTaint(uri.getTaint());
        addTaint(observer.getTaint());
        // ---------- Original Method ----------
        //notifyChange(uri, observer, true );
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.436 -0400", hash_original_method = "F301FE1DDD6CC7648C7F98CD4F863542", hash_generated_method = "F06544AA2409D27DE31AE985ED9A27CF")
    public void notifyChange(Uri uri, ContentObserver observer, boolean syncToNetwork) {
        try 
        {
            getContentService().notifyChange(
                    uri, observer == null ? null : observer.getContentObserver(),
                    observer != null && observer.deliverSelfNotifications(), syncToNetwork);
        } //End block
        catch (RemoteException e)
        { }
        addTaint(uri.getTaint());
        addTaint(observer.getTaint());
        addTaint(syncToNetwork);
        // ---------- Original Method ----------
        //try {
            //getContentService().notifyChange(
                    //uri, observer == null ? null : observer.getContentObserver(),
                    //observer != null && observer.deliverSelfNotifications(), syncToNetwork);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.448 -0400", hash_original_method = "2D6405030D787F1D91AFA94E2D425989", hash_generated_method = "81D13BB8B494F7415A65FDF584BC0D2E")
    @Deprecated
    public void startSync(Uri uri, Bundle extras) {
        Account account;
        account = null;
        {
            String accountName;
            accountName = extras.getString(SYNC_EXTRAS_ACCOUNT);
            {
                boolean var21816277CB804514BFAB23F699F0B246_1150105044 = (!TextUtils.isEmpty(accountName));
                {
                    account = new Account(accountName, "com.google");
                } //End block
            } //End collapsed parenthetic
            extras.remove(SYNC_EXTRAS_ACCOUNT);
        } //End block
        requestSync(account, uri != null ? uri.getAuthority() : null, extras);
        addTaint(uri.getTaint());
        addTaint(extras.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.487 -0400", hash_original_method = "B4949CE6FC68B3756629FF654EA4F622", hash_generated_method = "3896274AB60E4DB371F225EC4FB73EDF")
    @Deprecated
    public void cancelSync(Uri uri) {
        cancelSync(null , uri != null ? uri.getAuthority() : null);
        addTaint(uri.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.546 -0400", hash_original_method = "5964C3B3CD446EC6DF12ED3CA7F7D861", hash_generated_method = "08DADFAD82C3438F0950AC07787FF73A")
    private int samplePercentForDuration(long durationMillis) {
        addTaint(durationMillis);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_369656693 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_369656693;
        // ---------- Original Method ----------
        //if (durationMillis >= SLOW_THRESHOLD_MILLIS) {
            //return 100;
        //}
        //return (int) (100 * durationMillis / SLOW_THRESHOLD_MILLIS) + 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.562 -0400", hash_original_method = "339BAFB8AA6EDB4FDC193A187E8B0067", hash_generated_method = "CC626E11270FAF86F97CAE6D8BC2A8A4")
    private void maybeLogQueryToEventLog(long durationMillis,
                                         Uri uri, String[] projection,
                                         String selection, String sortOrder) {
        int samplePercent;
        samplePercent = samplePercentForDuration(durationMillis);
        {
            {
                {
                    boolean var2C548BF82E765EE870985D59E5547BFB_901727377 = (mRandom.nextInt(100) >= samplePercent);
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
        addTaint(durationMillis);
        addTaint(uri.getTaint());
        addTaint(projection[0].getTaint());
        addTaint(selection.getTaint());
        addTaint(sortOrder.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.586 -0400", hash_original_method = "8C4CA0C0E96B47F9D6365343066B43C9", hash_generated_method = "E219928A79F4665C6E251A6E9C55267E")
    private void maybeLogUpdateToEventLog(
        long durationMillis, Uri uri, String operation, String selection) {
        int samplePercent;
        samplePercent = samplePercentForDuration(durationMillis);
        {
            {
                {
                    boolean var2C548BF82E765EE870985D59E5547BFB_606738643 = (mRandom.nextInt(100) >= samplePercent);
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
        addTaint(durationMillis);
        addTaint(uri.getTaint());
        addTaint(operation.getTaint());
        addTaint(selection.getTaint());
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.593 -0400", hash_original_field = "4B43B0AEE35624CD95B910189B3DC231", hash_generated_field = "3D94ED8234243D4DE3F50EF6E646D0E3")

        public Resources r;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.593 -0400", hash_original_field = "B80BB7740288FDA1F201890375A60C8F", hash_generated_field = "FA0A3841DE31A9B4AD2F31B3665056D8")

        public int id;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.594 -0400", hash_original_method = "EC7BB03A160C6C88DBB9DFBF62B48748", hash_generated_method = "EC7BB03A160C6C88DBB9DFBF62B48748")
        public OpenResourceIdResult ()
        {
            //Synthesized constructor
        }


    }


    
    private final class CursorWrapperInner extends CrossProcessCursorWrapper {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.595 -0400", hash_original_field = "4AB176078152082D060487A305BE9F63", hash_generated_field = "B614D226FB5223D135A9D332098A34A4")

        private IContentProvider mContentProvider;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.595 -0400", hash_original_field = "FAB63045DAC8675C1DE9648413C0413D", hash_generated_field = "8ABB9EA4A0BD4BB4F6031F5BD3618F43")

        private CloseGuard mCloseGuard = CloseGuard.get();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.595 -0400", hash_original_field = "73EB2A2C6C3CC1E8C72EB379571EB098", hash_generated_field = "FF245C536DEFD57B2DCDAA00E8BC192F")

        private boolean mProviderReleased;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.670 -0400", hash_original_method = "33833BC2FFA324FE6B3A882C16B09B24", hash_generated_method = "AA3044B9754D326CBF94A564AF2511B1")
          CursorWrapperInner(Cursor cursor, IContentProvider icp) {
            super(cursor);
            mContentProvider = icp;
            mCloseGuard.open("close");
            addTaint(cursor.getTaint());
            // ---------- Original Method ----------
            //mContentProvider = icp;
            //mCloseGuard.open("close");
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.671 -0400", hash_original_method = "CB76115716387DD39854EA1927F29C52", hash_generated_method = "8346DD9120A3FACE871850785D20B4F6")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.676 -0400", hash_original_method = "C6F30BD2AC97CE59E2F19D89687C7506", hash_generated_method = "1D84EB1DF0FAD05E5DD3B68F884B5D6F")
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.676 -0400", hash_original_field = "13FB907F06B05F7137165C185CBCE3C3", hash_generated_field = "EACA88E7B01FC8694B38FD93BBF3A6CA")

        public static final String TAG="CursorWrapperInner";
    }


    
    private final class ParcelFileDescriptorInner extends ParcelFileDescriptor {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.677 -0400", hash_original_field = "4AB176078152082D060487A305BE9F63", hash_generated_field = "B614D226FB5223D135A9D332098A34A4")

        private IContentProvider mContentProvider;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.677 -0400", hash_original_field = "AC321E1C1B8C101F950B583BC403E782", hash_generated_field = "DCC2C4F00C9417AA6FB57200F6F6249D")

        private boolean mReleaseProviderFlag = false;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.678 -0400", hash_original_method = "84882D259A9B741E8CCE8DBD7345B8D5", hash_generated_method = "BDBFD660609211A2E8E1F914A0C59685")
          ParcelFileDescriptorInner(ParcelFileDescriptor pfd, IContentProvider icp) {
            super(pfd);
            mContentProvider = icp;
            addTaint(pfd.getTaint());
            // ---------- Original Method ----------
            //mContentProvider = icp;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.679 -0400", hash_original_method = "88C4FC226DB7C9E08A0225C4D4C037C0", hash_generated_method = "C0DD3FCB29B5C8207E20F17E6CE63C70")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.691 -0400", hash_original_method = "E5C83F24E1B33F16225B47651FBE1E16", hash_generated_method = "0A895962D46081094F888ADADCCE02CC")
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.692 -0400", hash_original_field = "CB7B93CDAC708AECA662EC86F82451BD", hash_generated_field = "853BAF17ACDDF73D9A8E686A803B9543")

        public static final String TAG="ParcelFileDescriptorInner";
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.692 -0400", hash_original_field = "C2EDFC92CCF8B16E3533DCFADC264E23", hash_generated_field = "87B095273B7680C6E8D776FD7BED0443")

    @Deprecated
    public static final String SYNC_EXTRAS_ACCOUNT = "account";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.692 -0400", hash_original_field = "9A7319143C3370C3B9F862CE740B5B75", hash_generated_field = "8B7D39A0706705FDAF94593ED0FACFEA")

    public static final String SYNC_EXTRAS_EXPEDITED = "expedited";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.692 -0400", hash_original_field = "0C5ED6B0AA55903B1B309BC3AE9C1AC5", hash_generated_field = "52C4CBE6F8AFC4D6C338F6272437F588")

    @Deprecated
    public static final String SYNC_EXTRAS_FORCE = "force";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.692 -0400", hash_original_field = "7BF6732A8AD149D6BF72E2CEB933EAEC", hash_generated_field = "9CB83B5127CA25B88446759FC78BB810")

    public static final String SYNC_EXTRAS_IGNORE_SETTINGS = "ignore_settings";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.693 -0400", hash_original_field = "48D105EF39F24B3ED276155D8F366FAD", hash_generated_field = "2460C39D3F3C8C8E9A6CA2DB50888065")

    public static final String SYNC_EXTRAS_IGNORE_BACKOFF = "ignore_backoff";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.693 -0400", hash_original_field = "BD3F4206E2333EE4EC1C44D083DBDDD9", hash_generated_field = "FB3D46B8F0404EBA4D41256EFCE69610")

    public static final String SYNC_EXTRAS_DO_NOT_RETRY = "do_not_retry";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.693 -0400", hash_original_field = "81C2869721D54621C1E9EBBF388E766C", hash_generated_field = "2CB777FABA87110DA15F0AAAA5216B13")

    public static final String SYNC_EXTRAS_MANUAL = "force";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.693 -0400", hash_original_field = "2627674F99971004D823BB1DC0D4AD30", hash_generated_field = "C66AD9A9054789246D88C3CEF49E0FE1")

    public static final String SYNC_EXTRAS_UPLOAD = "upload";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.708 -0400", hash_original_field = "2DB15BFAA122A6E4C8E09D40E27DE3A2", hash_generated_field = "085DFE00F23ABC519407289B800B9330")

    public static final String SYNC_EXTRAS_OVERRIDE_TOO_MANY_DELETIONS = "deletions_override";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.708 -0400", hash_original_field = "C93C475906837EA8C1231337BD9580CD", hash_generated_field = "A3280C9121A39AB92BFE4613E22A9F10")

    public static final String SYNC_EXTRAS_DISCARD_LOCAL_DELETIONS = "discard_deletions";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.709 -0400", hash_original_field = "F7B81FFD29F1E27E81F42B4EAF4745EB", hash_generated_field = "9A51FA040B5EE450933873F1925571E2")

    public static final String SYNC_EXTRAS_INITIALIZE = "initialize";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.709 -0400", hash_original_field = "B9EC534A4D635B10BE9040DF27185A80", hash_generated_field = "2A050A80E7005A896641161E25801F35")

    public static final String SCHEME_CONTENT = "content";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.709 -0400", hash_original_field = "F438C67F57FF4A50EDA09593EBEF286A", hash_generated_field = "7BECC35C4D527BA52EC58C833FB0BB34")

    public static final String SCHEME_ANDROID_RESOURCE = "android.resource";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.710 -0400", hash_original_field = "02F0EE6F8DEEBB0D5DCDD1E064DAC005", hash_generated_field = "D24B6CC01AD3F5B91B2CFC56B92A6E03")

    public static final String SCHEME_FILE = "file";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.710 -0400", hash_original_field = "893D0280FDFF6A2950856B98E73C71C1", hash_generated_field = "A41DFC918AF8E5D466EE8DAB0BF274F3")

    public static final String CURSOR_ITEM_BASE_TYPE = "vnd.android.cursor.item";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.710 -0400", hash_original_field = "95AED60F9A6BBB9F889EF813B7143610", hash_generated_field = "2D7AE2632599144DAA81BD08B4C8870E")

    public static final String CURSOR_DIR_BASE_TYPE = "vnd.android.cursor.dir";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.721 -0400", hash_original_field = "78541B0F3CCE1FAC3BA266FCB7621070", hash_generated_field = "F78FAC8C90BCAD8994706D8A7F584B12")

    public static final int SYNC_ERROR_SYNC_ALREADY_IN_PROGRESS = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.721 -0400", hash_original_field = "B72A154B591BAC40AEEF38C8E42F3335", hash_generated_field = "70645C1513ABFE107B9AF0BCB3F68340")

    public static final int SYNC_ERROR_AUTHENTICATION = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.721 -0400", hash_original_field = "FDA99AB14533C63BBCCA0F64BB7CF769", hash_generated_field = "2B1BA46E87D9EA52416FF82A7E9FC949")

    public static final int SYNC_ERROR_IO = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.721 -0400", hash_original_field = "CCA53EB6D8F9D64BE4EE63C66A08F236", hash_generated_field = "7D02506C7CBA10BD97CA79FB59DD9D15")

    public static final int SYNC_ERROR_PARSE = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.721 -0400", hash_original_field = "296A74F9B6DA67DDD9E8F0428AD3FFE0", hash_generated_field = "A315DAC0C98347D6DCFC6C6B32DA70BD")

    public static final int SYNC_ERROR_CONFLICT = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.722 -0400", hash_original_field = "83F48894C7BA225F7124ABDE5C0665CF", hash_generated_field = "76FE33D22783EC3D4779B2B73BE75DE9")

    public static final int SYNC_ERROR_TOO_MANY_DELETIONS = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.722 -0400", hash_original_field = "80FB09ABFBCC98D6C5E978E238B95658", hash_generated_field = "6E9809F790E5D29754E07F710C703033")

    public static final int SYNC_ERROR_TOO_MANY_RETRIES = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.722 -0400", hash_original_field = "BA70D22939E01C21C5AF2B587BFF152B", hash_generated_field = "9EF2EEC53560FF1A3EC43F81D719B306")

    public static final int SYNC_ERROR_INTERNAL = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.722 -0400", hash_original_field = "8F1E898EBD09004F8E52103FC8644049", hash_generated_field = "EC6D4E9079B435808FB02F42CC269B78")

    public static final int SYNC_OBSERVER_TYPE_SETTINGS = 1<<0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.723 -0400", hash_original_field = "45C5DD980F4A16E404292643A35A6433", hash_generated_field = "1F0C3937881F3FCFBF4E76673AB2169B")

    public static final int SYNC_OBSERVER_TYPE_PENDING = 1<<1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.723 -0400", hash_original_field = "2221A2B9CE572B6E501D97785FB05A8A", hash_generated_field = "0BBCE1310F4889E0CE3EBE1A843B06EC")

    public static final int SYNC_OBSERVER_TYPE_ACTIVE = 1<<2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.723 -0400", hash_original_field = "CBAD71B90CEF719A1DDEE4D9537EE9EF", hash_generated_field = "F118FAF287C6D65262857F494C71AFCE")

    public static final int SYNC_OBSERVER_TYPE_STATUS = 1<<3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.723 -0400", hash_original_field = "07D2AB9D80429D5E6907CE4783188520", hash_generated_field = "4285FF406FEA88E6536E37E5D6191611")

    public static final int SYNC_OBSERVER_TYPE_ALL = 0x7fffffff;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.735 -0400", hash_original_field = "5D2D67A3ADE9055680B54E64B5B18AF7", hash_generated_field = "F89922D567F9CEDC32BFF77AE57E9474")

    private static int SLOW_THRESHOLD_MILLIS = 500;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.736 -0400", hash_original_field = "9664C3A1DEBAEE31270D6C126FBE59B7", hash_generated_field = "061BD03196A426FD4F175A19E9881E10")

    public static final String CONTENT_SERVICE_NAME = "content";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.736 -0400", hash_original_field = "0000B7DC2B7CEFF37F9F07EB8F63EAB2", hash_generated_field = "EBBA89635D26FA830DBE060ABCA948AD")

    private static IContentService sContentService;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.736 -0400", hash_original_field = "28B0C9DBF8E70FA0509AB8A6C9A3F293", hash_generated_field = "EE1471C3D86401CD3A887496E74F7DB2")

    private static String TAG = "ContentResolver";
}

