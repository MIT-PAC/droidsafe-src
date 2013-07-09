package android.content;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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

public class ContentResolver {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.871 -0400", hash_original_field = "536255EED7E3D46DD70E09FDE814B7C1", hash_generated_field = "E26D41E197237C24B0E74C0394AEDF83")

    private final Random mRandom = new Random();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.871 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.872 -0400", hash_original_method = "8EB5ACCD206353DB8493F8AB9F861C85", hash_generated_method = "934BE422B780F73056F691B084F33D1F")
    public  ContentResolver(Context context) {
        mContext = context;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    protected IContentProvider acquireProvider(Context c, String name) {
    	return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.873 -0400", hash_original_method = "4AF2A0465BC3B713C9C8E0417552AB76", hash_generated_method = "D9520228B624E1C4B2E50287BF4E12CB")
    protected IContentProvider acquireExistingProvider(Context c, String name) {
        IContentProvider varB4EAC82CA7396A68D541C85D26508E83_1234056711 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1234056711 = acquireProvider(c, name);
        addTaint(c.getTaint());
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1234056711.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1234056711;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    public boolean releaseProvider(IContentProvider icp) {
    	return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.875 -0400", hash_original_method = "045596B6E0367AC7BED26FC054AD1E2B", hash_generated_method = "EAE7FC2F7F84818D202CEA4580D6E2A8")
    public final String getType(Uri url) {
        String varB4EAC82CA7396A68D541C85D26508E83_2144732608 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1911898720 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_985707346 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_26163804 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1565012773 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_2062062801 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1691198770 = null; 
        IContentProvider provider = acquireExistingProvider(url);
        {
            try 
            {
                varB4EAC82CA7396A68D541C85D26508E83_2144732608 = provider.getType(url);
            } 
            catch (RemoteException e)
            {
                varB4EAC82CA7396A68D541C85D26508E83_1911898720 = null;
            } 
            catch (java.lang.Exception e)
            {
                varB4EAC82CA7396A68D541C85D26508E83_985707346 = null;
            } 
            finally 
            {
                releaseProvider(provider);
            } 
        } 
        {
            boolean var18721B692F8DF38C1D910B0966D1473B_1090833047 = (!SCHEME_CONTENT.equals(url.getScheme()));
            {
                varB4EAC82CA7396A68D541C85D26508E83_26163804 = null;
            } 
        } 
        try 
        {
            String type = ActivityManagerNative.getDefault().getProviderMimeType(url);
            varB4EAC82CA7396A68D541C85D26508E83_1565012773 = type;
        } 
        catch (RemoteException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_2062062801 = null;
        } 
        catch (java.lang.Exception e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1691198770 = null;
        } 
        addTaint(url.getTaint());
        String varA7E53CE21691AB073D9660D615818899_346285589; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_346285589 = varB4EAC82CA7396A68D541C85D26508E83_2144732608;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_346285589 = varB4EAC82CA7396A68D541C85D26508E83_1911898720;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_346285589 = varB4EAC82CA7396A68D541C85D26508E83_985707346;
                break;
            case 4: 
                varA7E53CE21691AB073D9660D615818899_346285589 = varB4EAC82CA7396A68D541C85D26508E83_26163804;
                break;
            case 5: 
                varA7E53CE21691AB073D9660D615818899_346285589 = varB4EAC82CA7396A68D541C85D26508E83_1565012773;
                break;
            case 6: 
                varA7E53CE21691AB073D9660D615818899_346285589 = varB4EAC82CA7396A68D541C85D26508E83_2062062801;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_346285589 = varB4EAC82CA7396A68D541C85D26508E83_1691198770;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_346285589.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_346285589;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.876 -0400", hash_original_method = "BFD7301BBEDEF32538E97E3FEFB31C63", hash_generated_method = "53842157B8C48542CFD4D15EDF8D4558")
    public String[] getStreamTypes(Uri url, String mimeTypeFilter) {
        String[] varB4EAC82CA7396A68D541C85D26508E83_238404426 = null; 
        String[] varB4EAC82CA7396A68D541C85D26508E83_1158753882 = null; 
        String[] varB4EAC82CA7396A68D541C85D26508E83_628587778 = null; 
        IContentProvider provider = acquireProvider(url);
        {
            varB4EAC82CA7396A68D541C85D26508E83_238404426 = null;
        } 
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1158753882 = provider.getStreamTypes(url, mimeTypeFilter);
        } 
        catch (RemoteException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_628587778 = null;
        } 
        finally 
        {
            releaseProvider(provider);
        } 
        addTaint(url.getTaint());
        addTaint(mimeTypeFilter.getTaint());
        String[] varA7E53CE21691AB073D9660D615818899_286664212; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_286664212 = varB4EAC82CA7396A68D541C85D26508E83_238404426;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_286664212 = varB4EAC82CA7396A68D541C85D26508E83_1158753882;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_286664212 = varB4EAC82CA7396A68D541C85D26508E83_628587778;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_286664212.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_286664212;
        
        
        
            
        
        
            
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.878 -0400", hash_original_method = "505F43360905D398310F020FC85BFA22", hash_generated_method = "F5676AF29DAC91FDC0AD9045CCDADD2F")
    public final Cursor query(Uri uri, String[] projection,
            String selection, String[] selectionArgs, String sortOrder) {
        Cursor varB4EAC82CA7396A68D541C85D26508E83_1836303353 = null; 
        Cursor varB4EAC82CA7396A68D541C85D26508E83_1717376559 = null; 
        Cursor varB4EAC82CA7396A68D541C85D26508E83_617736399 = null; 
        Cursor varB4EAC82CA7396A68D541C85D26508E83_1771692932 = null; 
        IContentProvider provider = acquireProvider(uri);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1836303353 = null;
        } 
        try 
        {
            long startTime = SystemClock.uptimeMillis();
            Cursor qCursor = provider.query(uri, projection, selection, selectionArgs, sortOrder);
            {
                releaseProvider(provider);
                varB4EAC82CA7396A68D541C85D26508E83_1717376559 = null;
            } 
            qCursor.getCount();
            long durationMillis = SystemClock.uptimeMillis() - startTime;
            maybeLogQueryToEventLog(durationMillis, uri, projection, selection, sortOrder);
            varB4EAC82CA7396A68D541C85D26508E83_617736399 = new CursorWrapperInner(qCursor, provider);
        } 
        catch (RemoteException e)
        {
            releaseProvider(provider);
            varB4EAC82CA7396A68D541C85D26508E83_1771692932 = null;
        } 
        catch (RuntimeException e)
        {
            releaseProvider(provider);
            if (DroidSafeAndroidRuntime.control) throw e;
        } 
        addTaint(uri.getTaint());
        addTaint(projection[0].getTaint());
        addTaint(selection.getTaint());
        addTaint(selectionArgs[0].getTaint());
        addTaint(sortOrder.getTaint());
        Cursor varA7E53CE21691AB073D9660D615818899_714674411; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_714674411 = varB4EAC82CA7396A68D541C85D26508E83_1836303353;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_714674411 = varB4EAC82CA7396A68D541C85D26508E83_1717376559;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_714674411 = varB4EAC82CA7396A68D541C85D26508E83_617736399;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_714674411 = varB4EAC82CA7396A68D541C85D26508E83_1771692932;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_714674411.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_714674411;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.888 -0400", hash_original_method = "741F25E5E9079F60798D64718B03495A", hash_generated_method = "41FF9BAF8325612604D530E29B40A57A")
    public final InputStream openInputStream(Uri uri) throws FileNotFoundException {
        InputStream varB4EAC82CA7396A68D541C85D26508E83_1032500884 = null; 
        InputStream varB4EAC82CA7396A68D541C85D26508E83_1201438647 = null; 
        InputStream varB4EAC82CA7396A68D541C85D26508E83_70662668 = null; 
        String scheme = uri.getScheme();
        {
            boolean varDFD9C1D7BE28AB5E473B86FFFB70E350_1534848325 = (SCHEME_ANDROID_RESOURCE.equals(scheme));
            {
                OpenResourceIdResult r = getResourceId(uri);
                try 
                {
                    InputStream stream = r.r.openRawResource(r.id);
                    varB4EAC82CA7396A68D541C85D26508E83_1032500884 = stream;
                } 
                catch (Resources.NotFoundException ex)
                {
                    if (DroidSafeAndroidRuntime.control) throw new FileNotFoundException("Resource does not exist: " + uri);
                } 
            } 
            {
                boolean var7C16B7242FD360F5FCAE86285293D958_256147962 = (SCHEME_FILE.equals(scheme));
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1201438647 = new FileInputStream(uri.getPath());
                } 
                {
                    AssetFileDescriptor fd = openAssetFileDescriptor(uri, "r");
                    try 
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_70662668 = fd != null ? fd.createInputStream() : null;
                    } 
                    catch (IOException e)
                    {
                        if (DroidSafeAndroidRuntime.control) throw new FileNotFoundException("Unable to create stream");
                    } 
                } 
            } 
        } 
        addTaint(uri.getTaint());
        InputStream varA7E53CE21691AB073D9660D615818899_598065606; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_598065606 = varB4EAC82CA7396A68D541C85D26508E83_1032500884;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_598065606 = varB4EAC82CA7396A68D541C85D26508E83_1201438647;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_598065606 = varB4EAC82CA7396A68D541C85D26508E83_70662668;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_598065606.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_598065606;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.892 -0400", hash_original_method = "11A517824302FF0E2A744E48D03F81F2", hash_generated_method = "2F3E5191B458DDD09EA89D86241640B2")
    public final OutputStream openOutputStream(Uri uri) throws FileNotFoundException {
        OutputStream varB4EAC82CA7396A68D541C85D26508E83_1489846350 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1489846350 = openOutputStream(uri, "w");
        addTaint(uri.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1489846350.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1489846350;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.897 -0400", hash_original_method = "99597D87D82436F243497E22352BC980", hash_generated_method = "627E3BCB1424E5AE1387BC6218F6DED3")
    public final OutputStream openOutputStream(Uri uri, String mode) throws FileNotFoundException {
        OutputStream varB4EAC82CA7396A68D541C85D26508E83_546798036 = null; 
        AssetFileDescriptor fd = openAssetFileDescriptor(uri, mode);
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_546798036 = fd != null ? fd.createOutputStream() : null;
        } 
        catch (IOException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new FileNotFoundException("Unable to create stream");
        } 
        addTaint(uri.getTaint());
        addTaint(mode.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_546798036.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_546798036;
        
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.904 -0400", hash_original_method = "8C4F5C0648F37279A7BD3F73F68574C8", hash_generated_method = "5D2E65714800ECEEF23B9002A689F4A1")
    public final ParcelFileDescriptor openFileDescriptor(Uri uri,
            String mode) throws FileNotFoundException {
        ParcelFileDescriptor varB4EAC82CA7396A68D541C85D26508E83_1597225153 = null; 
        ParcelFileDescriptor varB4EAC82CA7396A68D541C85D26508E83_494152409 = null; 
        AssetFileDescriptor afd = openAssetFileDescriptor(uri, mode);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1597225153 = null;
        } 
        {
            boolean var8DC5E2F0722D8D5D90D15EC8C0F83F70_1742810224 = (afd.getDeclaredLength() < 0);
            {
                varB4EAC82CA7396A68D541C85D26508E83_494152409 = afd.getParcelFileDescriptor();
            } 
        } 
        try 
        {
            afd.close();
        } 
        catch (IOException e)
        { }
        if (DroidSafeAndroidRuntime.control) throw new FileNotFoundException("Not a whole file");
        addTaint(uri.getTaint());
        addTaint(mode.getTaint());
        ParcelFileDescriptor varA7E53CE21691AB073D9660D615818899_1984505324; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1984505324 = varB4EAC82CA7396A68D541C85D26508E83_1597225153;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1984505324 = varB4EAC82CA7396A68D541C85D26508E83_494152409;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1984505324.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1984505324;
        
        
        
            
        
        
            
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.915 -0400", hash_original_method = "6D0B2664AB85671E5A18996AE47F9088", hash_generated_method = "6FBC2488284F80C641559572A24ADDC5")
    public final AssetFileDescriptor openAssetFileDescriptor(Uri uri,
            String mode) throws FileNotFoundException {
        AssetFileDescriptor varB4EAC82CA7396A68D541C85D26508E83_1144393871 = null; 
        AssetFileDescriptor varB4EAC82CA7396A68D541C85D26508E83_1671688501 = null; 
        AssetFileDescriptor varB4EAC82CA7396A68D541C85D26508E83_2087611695 = null; 
        AssetFileDescriptor varB4EAC82CA7396A68D541C85D26508E83_1415296825 = null; 
        AssetFileDescriptor varB4EAC82CA7396A68D541C85D26508E83_91501652 = null; 
        String scheme = uri.getScheme();
        {
            boolean varDFD9C1D7BE28AB5E473B86FFFB70E350_1998838182 = (SCHEME_ANDROID_RESOURCE.equals(scheme));
            {
                {
                    boolean varC16FAE09F0519703CBD513EC3052DFFD_409020846 = (!"r".equals(mode));
                    {
                        if (DroidSafeAndroidRuntime.control) throw new FileNotFoundException("Can't write resources: " + uri);
                    } 
                } 
                OpenResourceIdResult r = getResourceId(uri);
                try 
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1144393871 = r.r.openRawResourceFd(r.id);
                } 
                catch (Resources.NotFoundException ex)
                {
                    if (DroidSafeAndroidRuntime.control) throw new FileNotFoundException("Resource does not exist: " + uri);
                } 
            } 
            {
                boolean var7C16B7242FD360F5FCAE86285293D958_1313511477 = (SCHEME_FILE.equals(scheme));
                {
                    ParcelFileDescriptor pfd = ParcelFileDescriptor.open(
                    new File(uri.getPath()), modeToMode(uri, mode));
                    varB4EAC82CA7396A68D541C85D26508E83_1671688501 = new AssetFileDescriptor(pfd, 0, -1);
                } 
                {
                    {
                        boolean var9E14F7893596A4058297083115E283FF_235163014 = ("r".equals(mode));
                        {
                            varB4EAC82CA7396A68D541C85D26508E83_2087611695 = openTypedAssetFileDescriptor(uri, "*/*", null);
                        } 
                        {
                            IContentProvider provider = acquireProvider(uri);
                            {
                                if (DroidSafeAndroidRuntime.control) throw new FileNotFoundException("No content provider: " + uri);
                            } 
                            try 
                            {
                                AssetFileDescriptor fd = provider.openAssetFile(uri, mode);
                                {
                                    varB4EAC82CA7396A68D541C85D26508E83_1415296825 = null;
                                } 
                                ParcelFileDescriptor pfd = new ParcelFileDescriptorInner(
                            fd.getParcelFileDescriptor(), provider);
                                provider = null;
                                varB4EAC82CA7396A68D541C85D26508E83_91501652 = new AssetFileDescriptor(pfd, fd.getStartOffset(),
                            fd.getDeclaredLength());
                            } 
                            catch (RemoteException e)
                            {
                                if (DroidSafeAndroidRuntime.control) throw new FileNotFoundException("Dead content provider: " + uri);
                            } 
                            catch (FileNotFoundException e)
                            {
                                if (DroidSafeAndroidRuntime.control) throw e;
                            } 
                            finally 
                            {
                                {
                                    releaseProvider(provider);
                                } 
                            } 
                        } 
                    } 
                } 
            } 
        } 
        addTaint(uri.getTaint());
        addTaint(mode.getTaint());
        AssetFileDescriptor varA7E53CE21691AB073D9660D615818899_174162213; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_174162213 = varB4EAC82CA7396A68D541C85D26508E83_1144393871;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_174162213 = varB4EAC82CA7396A68D541C85D26508E83_1671688501;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_174162213 = varB4EAC82CA7396A68D541C85D26508E83_2087611695;
                break;
            case 4: 
                varA7E53CE21691AB073D9660D615818899_174162213 = varB4EAC82CA7396A68D541C85D26508E83_1415296825;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_174162213 = varB4EAC82CA7396A68D541C85D26508E83_91501652;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_174162213.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_174162213;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.921 -0400", hash_original_method = "6625A014E29DF928853C1F0BC5B9E856", hash_generated_method = "F8CFD307F4D9731FADD47FB4E8319126")
    public final AssetFileDescriptor openTypedAssetFileDescriptor(Uri uri,
            String mimeType, Bundle opts) throws FileNotFoundException {
        AssetFileDescriptor varB4EAC82CA7396A68D541C85D26508E83_1266148521 = null; 
        AssetFileDescriptor varB4EAC82CA7396A68D541C85D26508E83_1574894078 = null; 
        IContentProvider provider = acquireProvider(uri);
        {
            if (DroidSafeAndroidRuntime.control) throw new FileNotFoundException("No content provider: " + uri);
        } 
        try 
        {
            AssetFileDescriptor fd = provider.openTypedAssetFile(uri, mimeType, opts);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1266148521 = null;
            } 
            ParcelFileDescriptor pfd = new ParcelFileDescriptorInner(
                    fd.getParcelFileDescriptor(), provider);
            provider = null;
            varB4EAC82CA7396A68D541C85D26508E83_1574894078 = new AssetFileDescriptor(pfd, fd.getStartOffset(),
                    fd.getDeclaredLength());
        } 
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new FileNotFoundException("Dead content provider: " + uri);
        } 
        catch (FileNotFoundException e)
        {
            if (DroidSafeAndroidRuntime.control) throw e;
        } 
        finally 
        {
            {
                releaseProvider(provider);
            } 
        } 
        addTaint(uri.getTaint());
        addTaint(mimeType.getTaint());
        addTaint(opts.getTaint());
        AssetFileDescriptor varA7E53CE21691AB073D9660D615818899_1026241565; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1026241565 = varB4EAC82CA7396A68D541C85D26508E83_1266148521;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1026241565 = varB4EAC82CA7396A68D541C85D26508E83_1574894078;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1026241565.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1026241565;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.253 -0400", hash_original_method = "39DD117C1A4502740FE90592CCDD92D2", hash_generated_method = "258F53816724C0F377E749195C1C0E2C")
    public OpenResourceIdResult getResourceId(Uri uri) throws FileNotFoundException {
        OpenResourceIdResult varB4EAC82CA7396A68D541C85D26508E83_1409789901 = null; 
        String authority;
        authority = uri.getAuthority();
        Resources r;
        {
            boolean var9779973367485DB1CCDF8689D3EBF254_1300781108 = (TextUtils.isEmpty(authority));
            {
                if (DroidSafeAndroidRuntime.control) throw new FileNotFoundException("No authority: " + uri);
            } 
            {
                try 
                {
                    r = mContext.getPackageManager().getResourcesForApplication(authority);
                } 
                catch (NameNotFoundException ex)
                {
                	throw new FileNotFoundException("No package found for authority: " + uri);
                } 
            } 
        } 
        List<String> path;
        path = uri.getPathSegments();
        {
            if (DroidSafeAndroidRuntime.control) throw new FileNotFoundException("No path: " + uri);
        } 
        int len;
        len = path.size();
        int id;
        {
            try 
            {
                id = Integer.parseInt(path.get(0));
            } 
            catch (NumberFormatException e)
            {
                if (DroidSafeAndroidRuntime.control) throw new FileNotFoundException("Single path segment is not a resource ID: " + uri);
            } 
        } 
        {
            id = r.getIdentifier(path.get(1), path.get(0), authority);
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new FileNotFoundException("More than two path segments: " + uri);
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new FileNotFoundException("No resource found for: " + uri);
        } 
        OpenResourceIdResult res;
        res = new OpenResourceIdResult();
        res.r = r;
        res.id = id;
        varB4EAC82CA7396A68D541C85D26508E83_1409789901 = res;
        addTaint(uri.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1409789901.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1409789901;
        
        
    }

    
    @DSModeled(DSC.SPEC)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.932 -0400", hash_original_method = "21049B5CF31214AC69662F00A8291DA2", hash_generated_method = "D555431A5EA9278FBB4094C20B5C8A8F")
    public final Uri insert(Uri url, ContentValues values) {
        Uri varB4EAC82CA7396A68D541C85D26508E83_687261538 = null; 
        Uri varB4EAC82CA7396A68D541C85D26508E83_1760499666 = null; 
        IContentProvider provider = acquireProvider(url);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Unknown URL " + url);
        } 
        try 
        {
            long startTime = SystemClock.uptimeMillis();
            Uri createdRow = provider.insert(url, values);
            long durationMillis = SystemClock.uptimeMillis() - startTime;
            maybeLogUpdateToEventLog(durationMillis, url, "insert", null );
            varB4EAC82CA7396A68D541C85D26508E83_687261538 = createdRow;
        } 
        catch (RemoteException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1760499666 = null;
        } 
        finally 
        {
            releaseProvider(provider);
        } 
        addTaint(url.getTaint());
        addTaint(values.getTaint());
        Uri varA7E53CE21691AB073D9660D615818899_201302593; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_201302593 = varB4EAC82CA7396A68D541C85D26508E83_687261538;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_201302593 = varB4EAC82CA7396A68D541C85D26508E83_1760499666;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_201302593.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_201302593;
        
        
        
            
        
        
            
            
            
            
            
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.935 -0400", hash_original_method = "35DA1841C97E840C3B5123B65D72A2FC", hash_generated_method = "702A8A1B5BF93529292D69971A8CDEE1")
    public ContentProviderResult[] applyBatch(String authority,
            ArrayList<ContentProviderOperation> operations) throws RemoteException, OperationApplicationException {
        ContentProviderResult[] varB4EAC82CA7396A68D541C85D26508E83_1492629718 = null; 
        ContentProviderClient provider = acquireContentProviderClient(authority);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Unknown authority " + authority);
        } 
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1492629718 = provider.applyBatch(operations);
        } 
        finally 
        {
            provider.release();
        } 
        addTaint(authority.getTaint());
        addTaint(operations.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1492629718.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1492629718;
        
        
        
            
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.939 -0400", hash_original_method = "B00B6610FA17409048836C33B1F1B82B", hash_generated_method = "B30C8034D4847AF0987F72422004F733")
    public final int bulkInsert(Uri url, ContentValues[] values) {
        IContentProvider provider = acquireProvider(url);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Unknown URL " + url);
        } 
        try 
        {
            long startTime = SystemClock.uptimeMillis();
            int rowsCreated = provider.bulkInsert(url, values);
            long durationMillis = SystemClock.uptimeMillis() - startTime;
            maybeLogUpdateToEventLog(durationMillis, url, "bulkinsert", null );
        } 
        catch (RemoteException e)
        { }
        finally 
        {
            releaseProvider(provider);
        } 
        addTaint(url.getTaint());
        addTaint(values[0].getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_652918753 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_652918753;
        
        
        
            
        
        
            
            
            
            
            
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.941 -0400", hash_original_method = "5F64E7642550035A4284C543DD08EBF1", hash_generated_method = "F4D0C39221F9E77F4FA59D1BE4613D08")
    public final int delete(Uri url, String where, String[] selectionArgs) {
        IContentProvider provider = acquireProvider(url);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Unknown URL " + url);
        } 
        try 
        {
            long startTime = SystemClock.uptimeMillis();
            int rowsDeleted = provider.delete(url, where, selectionArgs);
            long durationMillis = SystemClock.uptimeMillis() - startTime;
            maybeLogUpdateToEventLog(durationMillis, url, "delete", where);
        } 
        catch (RemoteException e)
        { }
        finally 
        {
            releaseProvider(provider);
        } 
        addTaint(url.getTaint());
        addTaint(where.getTaint());
        addTaint(selectionArgs[0].getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_623144048 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_623144048;
        
        
        
            
        
        
            
            
            
            
            
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.943 -0400", hash_original_method = "93173B163A2993B2278E9CE2CA5F5268", hash_generated_method = "C7D2E850093AEB2E7547FD766B2BD0CE")
    public final int update(Uri uri, ContentValues values, String where,
            String[] selectionArgs) {
        IContentProvider provider = acquireProvider(uri);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Unknown URI " + uri);
        } 
        try 
        {
            long startTime = SystemClock.uptimeMillis();
            int rowsUpdated = provider.update(uri, values, where, selectionArgs);
            long durationMillis = SystemClock.uptimeMillis() - startTime;
            maybeLogUpdateToEventLog(durationMillis, uri, "update", where);
        } 
        catch (RemoteException e)
        { }
        finally 
        {
            releaseProvider(provider);
        } 
        addTaint(uri.getTaint());
        addTaint(values.getTaint());
        addTaint(where.getTaint());
        addTaint(selectionArgs[0].getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_796582880 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_796582880;
        
        
        
            
        
        
            
            
            
            
            
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.951 -0400", hash_original_method = "7B97BF1D704BA5CFE2C56D2F21EF49E5", hash_generated_method = "2402ED2D2F9139F2DD2775B7956796A7")
    public final Bundle call(Uri uri, String method, String arg, Bundle extras) {
        Bundle varB4EAC82CA7396A68D541C85D26508E83_2059746848 = null; 
        Bundle varB4EAC82CA7396A68D541C85D26508E83_1999114767 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("uri == null");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("method == null");
        } 
        IContentProvider provider = acquireProvider(uri);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Unknown URI " + uri);
        } 
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_2059746848 = provider.call(method, arg, extras);
        } 
        catch (RemoteException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1999114767 = null;
        } 
        finally 
        {
            releaseProvider(provider);
        } 
        addTaint(uri.getTaint());
        addTaint(method.getTaint());
        addTaint(arg.getTaint());
        addTaint(extras.getTaint());
        Bundle varA7E53CE21691AB073D9660D615818899_1929273734; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1929273734 = varB4EAC82CA7396A68D541C85D26508E83_2059746848;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1929273734 = varB4EAC82CA7396A68D541C85D26508E83_1999114767;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1929273734.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1929273734;
        
        
            
        
        
            
        
        
        
            
        
        
            
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.960 -0400", hash_original_method = "337E4492D27C715A525AA87619808C6B", hash_generated_method = "11003577BC26454CD61AB995C253FD80")
    public final IContentProvider acquireProvider(Uri uri) {
        IContentProvider varB4EAC82CA7396A68D541C85D26508E83_1414740327 = null; 
        IContentProvider varB4EAC82CA7396A68D541C85D26508E83_931850100 = null; 
        IContentProvider varB4EAC82CA7396A68D541C85D26508E83_1502558570 = null; 
        {
            boolean var9032E7F5B68A598423C5832E98A924D2_417525614 = (!SCHEME_CONTENT.equals(uri.getScheme()));
            {
                varB4EAC82CA7396A68D541C85D26508E83_1414740327 = null;
            } 
        } 
        String auth = uri.getAuthority();
        {
            varB4EAC82CA7396A68D541C85D26508E83_931850100 = acquireProvider(mContext, uri.getAuthority());
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1502558570 = null;
        addTaint(uri.getTaint());
        IContentProvider varA7E53CE21691AB073D9660D615818899_1298421752; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1298421752 = varB4EAC82CA7396A68D541C85D26508E83_1414740327;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1298421752 = varB4EAC82CA7396A68D541C85D26508E83_931850100;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1298421752 = varB4EAC82CA7396A68D541C85D26508E83_1502558570;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1298421752.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1298421752;
        
        
            
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.966 -0400", hash_original_method = "C657A24801BE240D39C6FCA466A49DFE", hash_generated_method = "145C493D7D4985CF8570DE826720C96C")
    public final IContentProvider acquireExistingProvider(Uri uri) {
        IContentProvider varB4EAC82CA7396A68D541C85D26508E83_931755869 = null; 
        IContentProvider varB4EAC82CA7396A68D541C85D26508E83_718203407 = null; 
        IContentProvider varB4EAC82CA7396A68D541C85D26508E83_1072273855 = null; 
        {
            boolean var9032E7F5B68A598423C5832E98A924D2_867024395 = (!SCHEME_CONTENT.equals(uri.getScheme()));
            {
                varB4EAC82CA7396A68D541C85D26508E83_931755869 = null;
            } 
        } 
        String auth = uri.getAuthority();
        {
            varB4EAC82CA7396A68D541C85D26508E83_718203407 = acquireExistingProvider(mContext, uri.getAuthority());
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1072273855 = null;
        addTaint(uri.getTaint());
        IContentProvider varA7E53CE21691AB073D9660D615818899_1356331549; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1356331549 = varB4EAC82CA7396A68D541C85D26508E83_931755869;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1356331549 = varB4EAC82CA7396A68D541C85D26508E83_718203407;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1356331549 = varB4EAC82CA7396A68D541C85D26508E83_1072273855;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1356331549.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1356331549;
        
        
            
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.972 -0400", hash_original_method = "1419B9D62800705D7AC72C916BD8939A", hash_generated_method = "4A31AA6386C9903A0947BBE41899845C")
    public final IContentProvider acquireProvider(String name) {
        IContentProvider varB4EAC82CA7396A68D541C85D26508E83_1452805186 = null; 
        IContentProvider varB4EAC82CA7396A68D541C85D26508E83_1645967594 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1452805186 = null;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1645967594 = acquireProvider(mContext, name);
        addTaint(name.getTaint());
        IContentProvider varA7E53CE21691AB073D9660D615818899_492055905; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_492055905 = varB4EAC82CA7396A68D541C85D26508E83_1452805186;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_492055905 = varB4EAC82CA7396A68D541C85D26508E83_1645967594;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_492055905.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_492055905;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.977 -0400", hash_original_method = "5741247DD17162DA82750F730CE6B9A7", hash_generated_method = "2FB5D52F025BB7A32097CA9EAC01FBB7")
    public final ContentProviderClient acquireContentProviderClient(Uri uri) {
        ContentProviderClient varB4EAC82CA7396A68D541C85D26508E83_1007171944 = null; 
        ContentProviderClient varB4EAC82CA7396A68D541C85D26508E83_443946595 = null; 
        IContentProvider provider = acquireProvider(uri);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1007171944 = new ContentProviderClient(this, provider);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_443946595 = null;
        addTaint(uri.getTaint());
        ContentProviderClient varA7E53CE21691AB073D9660D615818899_1218100286; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1218100286 = varB4EAC82CA7396A68D541C85D26508E83_1007171944;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1218100286 = varB4EAC82CA7396A68D541C85D26508E83_443946595;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1218100286.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1218100286;
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.984 -0400", hash_original_method = "01901AA9613048A3AC98A39C9DD35CAC", hash_generated_method = "3768517275350E3A727A1FF63E331E91")
    public final ContentProviderClient acquireContentProviderClient(String name) {
        ContentProviderClient varB4EAC82CA7396A68D541C85D26508E83_854347826 = null; 
        ContentProviderClient varB4EAC82CA7396A68D541C85D26508E83_855376892 = null; 
        IContentProvider provider = acquireProvider(name);
        {
            varB4EAC82CA7396A68D541C85D26508E83_854347826 = new ContentProviderClient(this, provider);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_855376892 = null;
        addTaint(name.getTaint());
        ContentProviderClient varA7E53CE21691AB073D9660D615818899_691090374; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_691090374 = varB4EAC82CA7396A68D541C85D26508E83_854347826;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_691090374 = varB4EAC82CA7396A68D541C85D26508E83_855376892;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_691090374.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_691090374;
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.985 -0400", hash_original_method = "7AFED95A5C5E44717133ED415B77A63B", hash_generated_method = "418793DF18B94EEC380FC05A36ED79F0")
    public final void registerContentObserver(Uri uri, boolean notifyForDescendents,
            ContentObserver observer) {
        
        try 
        {
            getContentService().registerContentObserver(uri, notifyForDescendents,
                    observer.getContentObserver());
        } 
        catch (RemoteException e)
        { }
        addTaint(uri.getTaint());
        addTaint(notifyForDescendents);
        addTaint(observer.getTaint());
        
        
            
                    
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.987 -0400", hash_original_method = "A19276E2B38D6FC8E7769343C0EFAA57", hash_generated_method = "7A53EC1F96B71586105739960FC28931")
    public final void unregisterContentObserver(ContentObserver observer) {
        try 
        {
            IContentObserver contentObserver = observer.releaseContentObserver();
            {
                getContentService().unregisterContentObserver(
                        contentObserver);
            } 
        } 
        catch (RemoteException e)
        { }
        addTaint(observer.getTaint());
        
        
            
            
                
                        
            
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.990 -0400", hash_original_method = "E76834C8ABF23847CEBC5965503FC8D5", hash_generated_method = "721276707545B26042C057743EC44CDD")
    public void notifyChange(Uri uri, ContentObserver observer) {
        notifyChange(uri, observer, true );
        addTaint(uri.getTaint());
        addTaint(observer.getTaint());
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.991 -0400", hash_original_method = "F301FE1DDD6CC7648C7F98CD4F863542", hash_generated_method = "F06544AA2409D27DE31AE985ED9A27CF")
    public void notifyChange(Uri uri, ContentObserver observer, boolean syncToNetwork) {
        try 
        {
            getContentService().notifyChange(
                    uri, observer == null ? null : observer.getContentObserver(),
                    observer != null && observer.deliverSelfNotifications(), syncToNetwork);
        } 
        catch (RemoteException e)
        { }
        addTaint(uri.getTaint());
        addTaint(observer.getTaint());
        addTaint(syncToNetwork);
        
        
            
                    
                    
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.994 -0400", hash_original_method = "2D6405030D787F1D91AFA94E2D425989", hash_generated_method = "38742134F70390713A6766278148A548")
    @Deprecated
    public void startSync(Uri uri, Bundle extras) {
        Account account = null;
        {
            String accountName = extras.getString(SYNC_EXTRAS_ACCOUNT);
            {
                boolean var21816277CB804514BFAB23F699F0B246_1105325373 = (!TextUtils.isEmpty(accountName));
                {
                    account = new Account(accountName, "com.google");
                } 
            } 
            extras.remove(SYNC_EXTRAS_ACCOUNT);
        } 
        requestSync(account, uri != null ? uri.getAuthority() : null, extras);
        addTaint(uri.getTaint());
        addTaint(extras.getTaint());
        
        
        
            
            
                
            
            
        
        
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.000 -0400", hash_original_method = "B4949CE6FC68B3756629FF654EA4F622", hash_generated_method = "3896274AB60E4DB371F225EC4FB73EDF")
    @Deprecated
    public void cancelSync(Uri uri) {
        cancelSync(null , uri != null ? uri.getAuthority() : null);
        addTaint(uri.getTaint());
        
        
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.024 -0400", hash_original_method = "5964C3B3CD446EC6DF12ED3CA7F7D861", hash_generated_method = "301F73758F9B20E86ED46C245A4BB941")
    private int samplePercentForDuration(long durationMillis) {
        addTaint(durationMillis);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1571683752 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1571683752;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.026 -0400", hash_original_method = "339BAFB8AA6EDB4FDC193A187E8B0067", hash_generated_method = "26E2E654ADD497ABDE904C177FCF196D")
    private void maybeLogQueryToEventLog(long durationMillis,
                                         Uri uri, String[] projection,
                                         String selection, String sortOrder) {
        int samplePercent = samplePercentForDuration(durationMillis);
        {
            {
                {
                    boolean var2C548BF82E765EE870985D59E5547BFB_212864208 = (mRandom.nextInt(100) >= samplePercent);
                } 
            } 
        } 
        StringBuilder projectionBuffer = new StringBuilder(100);
        {
            {
                int i = 0;
                {
                    projectionBuffer.append('/');
                    projectionBuffer.append(projection[i]);
                } 
            } 
        } 
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
        addTaint(durationMillis);
        addTaint(uri.getTaint());
        addTaint(projection[0].getTaint());
        addTaint(selection.getTaint());
        addTaint(sortOrder.getTaint());
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.028 -0400", hash_original_method = "8C4CA0C0E96B47F9D6365343066B43C9", hash_generated_method = "C0C026E6DB83CA05F6EC3557957AAF09")
    private void maybeLogUpdateToEventLog(
        long durationMillis, Uri uri, String operation, String selection) {
        int samplePercent = samplePercentForDuration(durationMillis);
        {
            {
                {
                    boolean var2C548BF82E765EE870985D59E5547BFB_1223914415 = (mRandom.nextInt(100) >= samplePercent);
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
        addTaint(durationMillis);
        addTaint(uri.getTaint());
        addTaint(operation.getTaint());
        addTaint(selection.getTaint());
        
        
        
            
                
                    
                
            
        
        
        
            
            
            
            
            
            
            
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.031 -0400", hash_original_field = "4B43B0AEE35624CD95B910189B3DC231", hash_generated_field = "3D94ED8234243D4DE3F50EF6E646D0E3")

        public Resources r;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.031 -0400", hash_original_field = "B80BB7740288FDA1F201890375A60C8F", hash_generated_field = "FA0A3841DE31A9B4AD2F31B3665056D8")

        public int id;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.031 -0400", hash_original_method = "EC7BB03A160C6C88DBB9DFBF62B48748", hash_generated_method = "EC7BB03A160C6C88DBB9DFBF62B48748")
        public OpenResourceIdResult ()
        {
            
        }


    }


    
    private final class CursorWrapperInner extends CrossProcessCursorWrapper {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.031 -0400", hash_original_field = "4AB176078152082D060487A305BE9F63", hash_generated_field = "B614D226FB5223D135A9D332098A34A4")

        private IContentProvider mContentProvider;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.031 -0400", hash_original_field = "FAB63045DAC8675C1DE9648413C0413D", hash_generated_field = "91705AACD6DDE42AEA628776AF2A3DC6")

        private final CloseGuard mCloseGuard = CloseGuard.get();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.031 -0400", hash_original_field = "73EB2A2C6C3CC1E8C72EB379571EB098", hash_generated_field = "FF245C536DEFD57B2DCDAA00E8BC192F")

        private boolean mProviderReleased;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.033 -0400", hash_original_method = "33833BC2FFA324FE6B3A882C16B09B24", hash_generated_method = "AA3044B9754D326CBF94A564AF2511B1")
          CursorWrapperInner(Cursor cursor, IContentProvider icp) {
            super(cursor);
            mContentProvider = icp;
            mCloseGuard.open("close");
            addTaint(cursor.getTaint());
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.034 -0400", hash_original_method = "CB76115716387DD39854EA1927F29C52", hash_generated_method = "8346DD9120A3FACE871850785D20B4F6")
        @Override
        public void close() {
            super.close();
            ContentResolver.this.releaseProvider(mContentProvider);
            mProviderReleased = true;
            {
                mCloseGuard.close();
            } 
            
            
            
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.035 -0400", hash_original_method = "C6F30BD2AC97CE59E2F19D89687C7506", hash_generated_method = "1D84EB1DF0FAD05E5DD3B68F884B5D6F")
        @Override
        protected void finalize() throws Throwable {
            try 
            {
                {
                    mCloseGuard.warnIfOpen();
                } 
                {
                    ContentResolver.this.releaseProvider(mContentProvider);
                } 
            } 
            finally 
            {
                super.finalize();
            } 
            
            
                
                    
                
                
                    
                    
                
            
                
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.036 -0400", hash_original_field = "13FB907F06B05F7137165C185CBCE3C3", hash_generated_field = "EACA88E7B01FC8694B38FD93BBF3A6CA")

        public static final String TAG="CursorWrapperInner";
    }


    
    private final class ParcelFileDescriptorInner extends ParcelFileDescriptor {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.036 -0400", hash_original_field = "4AB176078152082D060487A305BE9F63", hash_generated_field = "B614D226FB5223D135A9D332098A34A4")

        private IContentProvider mContentProvider;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.036 -0400", hash_original_field = "AC321E1C1B8C101F950B583BC403E782", hash_generated_field = "DCC2C4F00C9417AA6FB57200F6F6249D")

        private boolean mReleaseProviderFlag = false;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.037 -0400", hash_original_method = "84882D259A9B741E8CCE8DBD7345B8D5", hash_generated_method = "BDBFD660609211A2E8E1F914A0C59685")
          ParcelFileDescriptorInner(ParcelFileDescriptor pfd, IContentProvider icp) {
            super(pfd);
            mContentProvider = icp;
            addTaint(pfd.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.039 -0400", hash_original_method = "88C4FC226DB7C9E08A0225C4D4C037C0", hash_generated_method = "C0DD3FCB29B5C8207E20F17E6CE63C70")
        @Override
        public void close() throws IOException {
            {
                super.close();
                ContentResolver.this.releaseProvider(mContentProvider);
                mReleaseProviderFlag = true;
            } 
            
            
                
                
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.042 -0400", hash_original_method = "E5C83F24E1B33F16225B47651FBE1E16", hash_generated_method = "0A895962D46081094F888ADADCCE02CC")
        @Override
        protected void finalize() throws Throwable {
            {
                close();
            } 
            
            
                
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.042 -0400", hash_original_field = "CB7B93CDAC708AECA662EC86F82451BD", hash_generated_field = "853BAF17ACDDF73D9A8E686A803B9543")

        public static final String TAG="ParcelFileDescriptorInner";
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.042 -0400", hash_original_field = "C2EDFC92CCF8B16E3533DCFADC264E23", hash_generated_field = "87B095273B7680C6E8D776FD7BED0443")

    @Deprecated
    public static final String SYNC_EXTRAS_ACCOUNT = "account";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.042 -0400", hash_original_field = "9A7319143C3370C3B9F862CE740B5B75", hash_generated_field = "8B7D39A0706705FDAF94593ED0FACFEA")

    public static final String SYNC_EXTRAS_EXPEDITED = "expedited";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.042 -0400", hash_original_field = "0C5ED6B0AA55903B1B309BC3AE9C1AC5", hash_generated_field = "52C4CBE6F8AFC4D6C338F6272437F588")

    @Deprecated
    public static final String SYNC_EXTRAS_FORCE = "force";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.042 -0400", hash_original_field = "7BF6732A8AD149D6BF72E2CEB933EAEC", hash_generated_field = "9CB83B5127CA25B88446759FC78BB810")

    public static final String SYNC_EXTRAS_IGNORE_SETTINGS = "ignore_settings";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.042 -0400", hash_original_field = "48D105EF39F24B3ED276155D8F366FAD", hash_generated_field = "2460C39D3F3C8C8E9A6CA2DB50888065")

    public static final String SYNC_EXTRAS_IGNORE_BACKOFF = "ignore_backoff";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.042 -0400", hash_original_field = "BD3F4206E2333EE4EC1C44D083DBDDD9", hash_generated_field = "FB3D46B8F0404EBA4D41256EFCE69610")

    public static final String SYNC_EXTRAS_DO_NOT_RETRY = "do_not_retry";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.042 -0400", hash_original_field = "81C2869721D54621C1E9EBBF388E766C", hash_generated_field = "2CB777FABA87110DA15F0AAAA5216B13")

    public static final String SYNC_EXTRAS_MANUAL = "force";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.042 -0400", hash_original_field = "2627674F99971004D823BB1DC0D4AD30", hash_generated_field = "C66AD9A9054789246D88C3CEF49E0FE1")

    public static final String SYNC_EXTRAS_UPLOAD = "upload";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.042 -0400", hash_original_field = "2DB15BFAA122A6E4C8E09D40E27DE3A2", hash_generated_field = "085DFE00F23ABC519407289B800B9330")

    public static final String SYNC_EXTRAS_OVERRIDE_TOO_MANY_DELETIONS = "deletions_override";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.042 -0400", hash_original_field = "C93C475906837EA8C1231337BD9580CD", hash_generated_field = "A3280C9121A39AB92BFE4613E22A9F10")

    public static final String SYNC_EXTRAS_DISCARD_LOCAL_DELETIONS = "discard_deletions";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.042 -0400", hash_original_field = "F7B81FFD29F1E27E81F42B4EAF4745EB", hash_generated_field = "9A51FA040B5EE450933873F1925571E2")

    public static final String SYNC_EXTRAS_INITIALIZE = "initialize";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.043 -0400", hash_original_field = "B9EC534A4D635B10BE9040DF27185A80", hash_generated_field = "2A050A80E7005A896641161E25801F35")

    public static final String SCHEME_CONTENT = "content";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.043 -0400", hash_original_field = "F438C67F57FF4A50EDA09593EBEF286A", hash_generated_field = "7BECC35C4D527BA52EC58C833FB0BB34")

    public static final String SCHEME_ANDROID_RESOURCE = "android.resource";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.043 -0400", hash_original_field = "02F0EE6F8DEEBB0D5DCDD1E064DAC005", hash_generated_field = "D24B6CC01AD3F5B91B2CFC56B92A6E03")

    public static final String SCHEME_FILE = "file";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.043 -0400", hash_original_field = "893D0280FDFF6A2950856B98E73C71C1", hash_generated_field = "A41DFC918AF8E5D466EE8DAB0BF274F3")

    public static final String CURSOR_ITEM_BASE_TYPE = "vnd.android.cursor.item";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.043 -0400", hash_original_field = "95AED60F9A6BBB9F889EF813B7143610", hash_generated_field = "2D7AE2632599144DAA81BD08B4C8870E")

    public static final String CURSOR_DIR_BASE_TYPE = "vnd.android.cursor.dir";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.043 -0400", hash_original_field = "78541B0F3CCE1FAC3BA266FCB7621070", hash_generated_field = "F78FAC8C90BCAD8994706D8A7F584B12")

    public static final int SYNC_ERROR_SYNC_ALREADY_IN_PROGRESS = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.043 -0400", hash_original_field = "B72A154B591BAC40AEEF38C8E42F3335", hash_generated_field = "70645C1513ABFE107B9AF0BCB3F68340")

    public static final int SYNC_ERROR_AUTHENTICATION = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.043 -0400", hash_original_field = "FDA99AB14533C63BBCCA0F64BB7CF769", hash_generated_field = "2B1BA46E87D9EA52416FF82A7E9FC949")

    public static final int SYNC_ERROR_IO = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.043 -0400", hash_original_field = "CCA53EB6D8F9D64BE4EE63C66A08F236", hash_generated_field = "7D02506C7CBA10BD97CA79FB59DD9D15")

    public static final int SYNC_ERROR_PARSE = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.043 -0400", hash_original_field = "296A74F9B6DA67DDD9E8F0428AD3FFE0", hash_generated_field = "A315DAC0C98347D6DCFC6C6B32DA70BD")

    public static final int SYNC_ERROR_CONFLICT = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.043 -0400", hash_original_field = "83F48894C7BA225F7124ABDE5C0665CF", hash_generated_field = "76FE33D22783EC3D4779B2B73BE75DE9")

    public static final int SYNC_ERROR_TOO_MANY_DELETIONS = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.043 -0400", hash_original_field = "80FB09ABFBCC98D6C5E978E238B95658", hash_generated_field = "6E9809F790E5D29754E07F710C703033")

    public static final int SYNC_ERROR_TOO_MANY_RETRIES = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.043 -0400", hash_original_field = "BA70D22939E01C21C5AF2B587BFF152B", hash_generated_field = "9EF2EEC53560FF1A3EC43F81D719B306")

    public static final int SYNC_ERROR_INTERNAL = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.043 -0400", hash_original_field = "8F1E898EBD09004F8E52103FC8644049", hash_generated_field = "EC6D4E9079B435808FB02F42CC269B78")

    public static final int SYNC_OBSERVER_TYPE_SETTINGS = 1<<0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.043 -0400", hash_original_field = "45C5DD980F4A16E404292643A35A6433", hash_generated_field = "1F0C3937881F3FCFBF4E76673AB2169B")

    public static final int SYNC_OBSERVER_TYPE_PENDING = 1<<1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.043 -0400", hash_original_field = "2221A2B9CE572B6E501D97785FB05A8A", hash_generated_field = "0BBCE1310F4889E0CE3EBE1A843B06EC")

    public static final int SYNC_OBSERVER_TYPE_ACTIVE = 1<<2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.043 -0400", hash_original_field = "CBAD71B90CEF719A1DDEE4D9537EE9EF", hash_generated_field = "F118FAF287C6D65262857F494C71AFCE")

    public static final int SYNC_OBSERVER_TYPE_STATUS = 1<<3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.043 -0400", hash_original_field = "07D2AB9D80429D5E6907CE4783188520", hash_generated_field = "4285FF406FEA88E6536E37E5D6191611")

    public static final int SYNC_OBSERVER_TYPE_ALL = 0x7fffffff;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.043 -0400", hash_original_field = "5D2D67A3ADE9055680B54E64B5B18AF7", hash_generated_field = "48FEA35E2DFEE1057404A05E365FED9C")

    private static final int SLOW_THRESHOLD_MILLIS = 500;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.044 -0400", hash_original_field = "9664C3A1DEBAEE31270D6C126FBE59B7", hash_generated_field = "061BD03196A426FD4F175A19E9881E10")

    public static final String CONTENT_SERVICE_NAME = "content";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.044 -0400", hash_original_field = "0000B7DC2B7CEFF37F9F07EB8F63EAB2", hash_generated_field = "EBBA89635D26FA830DBE060ABCA948AD")

    private static IContentService sContentService;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.044 -0400", hash_original_field = "28B0C9DBF8E70FA0509AB8A6C9A3F293", hash_generated_field = "2E4D905723B5A2539B6E57BF8A2185DE")

    private static final String TAG = "ContentResolver";
    
        
}

