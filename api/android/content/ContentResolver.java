package android.content;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.232 -0400", hash_original_field = "536255EED7E3D46DD70E09FDE814B7C1", hash_generated_field = "E26D41E197237C24B0E74C0394AEDF83")

    private final Random mRandom = new Random();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.232 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.233 -0400", hash_original_method = "8EB5ACCD206353DB8493F8AB9F861C85", hash_generated_method = "934BE422B780F73056F691B084F33D1F")
    public  ContentResolver(Context context) {
        mContext = context;
        // ---------- Original Method ----------
        //mContext = context;
    }

    
    @DSModeled(DSC.SAFE)
    protected abstract IContentProvider acquireProvider(Context c, String name);

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.233 -0400", hash_original_method = "4AF2A0465BC3B713C9C8E0417552AB76", hash_generated_method = "D3E04BD723E59BF4061A8E3D619025A5")
    protected IContentProvider acquireExistingProvider(Context c, String name) {
        addTaint(name.getTaint());
        addTaint(c.getTaint());
IContentProvider var766C186C84316C5769DE0C3CF08965F1_34216910 =         acquireProvider(c, name);
        var766C186C84316C5769DE0C3CF08965F1_34216910.addTaint(taint);
        return var766C186C84316C5769DE0C3CF08965F1_34216910;
        // ---------- Original Method ----------
        //return acquireProvider(c, name);
    }

    
    @DSModeled(DSC.SAFE)
    public abstract boolean releaseProvider(IContentProvider icp);

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.234 -0400", hash_original_method = "045596B6E0367AC7BED26FC054AD1E2B", hash_generated_method = "9B6BB7308256A2E9B3716A989592630F")
    public final String getType(Uri url) {
        addTaint(url.getTaint());
        IContentProvider provider = acquireExistingProvider(url);
        if(provider != null)        
        {
            try 
            {
String var1A84D08190718109CB2BC27E1A4C03C0_1393503885 =                 provider.getType(url);
                var1A84D08190718109CB2BC27E1A4C03C0_1393503885.addTaint(taint);
                return var1A84D08190718109CB2BC27E1A4C03C0_1393503885;
            } //End block
            catch (RemoteException e)
            {
String var540C13E9E156B687226421B24F2DF178_148295385 =                 null;
                var540C13E9E156B687226421B24F2DF178_148295385.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_148295385;
            } //End block
            catch (java.lang.Exception e)
            {
String var540C13E9E156B687226421B24F2DF178_639937639 =                 null;
                var540C13E9E156B687226421B24F2DF178_639937639.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_639937639;
            } //End block
            finally 
            {
                releaseProvider(provider);
            } //End block
        } //End block
        if(!SCHEME_CONTENT.equals(url.getScheme()))        
        {
String var540C13E9E156B687226421B24F2DF178_148710923 =             null;
            var540C13E9E156B687226421B24F2DF178_148710923.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_148710923;
        } //End block
        try 
        {
            String type = ActivityManagerNative.getDefault().getProviderMimeType(url);
String varC5B9F25B4EEAD3E8E2C33F9429204397_162373831 =             type;
            varC5B9F25B4EEAD3E8E2C33F9429204397_162373831.addTaint(taint);
            return varC5B9F25B4EEAD3E8E2C33F9429204397_162373831;
        } //End block
        catch (RemoteException e)
        {
String var540C13E9E156B687226421B24F2DF178_1755088046 =             null;
            var540C13E9E156B687226421B24F2DF178_1755088046.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1755088046;
        } //End block
        catch (java.lang.Exception e)
        {
String var540C13E9E156B687226421B24F2DF178_1069982956 =             null;
            var540C13E9E156B687226421B24F2DF178_1069982956.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1069982956;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.235 -0400", hash_original_method = "BFD7301BBEDEF32538E97E3FEFB31C63", hash_generated_method = "C2408B10E49C28AF230C86AEC2396E21")
    public String[] getStreamTypes(Uri url, String mimeTypeFilter) {
        addTaint(mimeTypeFilter.getTaint());
        addTaint(url.getTaint());
        IContentProvider provider = acquireProvider(url);
        if(provider == null)        
        {
String[] var540C13E9E156B687226421B24F2DF178_972027410 =             null;
            var540C13E9E156B687226421B24F2DF178_972027410.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_972027410;
        } //End block
        try 
        {
String[] varC36AEBB87CA75D0818120C3B784E0B4F_1522453836 =             provider.getStreamTypes(url, mimeTypeFilter);
            varC36AEBB87CA75D0818120C3B784E0B4F_1522453836.addTaint(taint);
            return varC36AEBB87CA75D0818120C3B784E0B4F_1522453836;
        } //End block
        catch (RemoteException e)
        {
String[] var540C13E9E156B687226421B24F2DF178_2139460975 =             null;
            var540C13E9E156B687226421B24F2DF178_2139460975.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_2139460975;
        } //End block
        finally 
        {
            releaseProvider(provider);
        } //End block
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.236 -0400", hash_original_method = "505F43360905D398310F020FC85BFA22", hash_generated_method = "A68294E39FE1A769915BA30622E28EF7")
    public final Cursor query(Uri uri, String[] projection,
            String selection, String[] selectionArgs, String sortOrder) {
        addTaint(sortOrder.getTaint());
        addTaint(selectionArgs[0].getTaint());
        addTaint(selection.getTaint());
        addTaint(projection[0].getTaint());
        addTaint(uri.getTaint());
        IContentProvider provider = acquireProvider(uri);
        if(provider == null)        
        {
Cursor var540C13E9E156B687226421B24F2DF178_1862587774 =             null;
            var540C13E9E156B687226421B24F2DF178_1862587774.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1862587774;
        } //End block
        try 
        {
            long startTime = SystemClock.uptimeMillis();
            Cursor qCursor = provider.query(uri, projection, selection, selectionArgs, sortOrder);
            if(qCursor == null)            
            {
                releaseProvider(provider);
Cursor var540C13E9E156B687226421B24F2DF178_1824388774 =                 null;
                var540C13E9E156B687226421B24F2DF178_1824388774.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_1824388774;
            } //End block
            qCursor.getCount();
            long durationMillis = SystemClock.uptimeMillis() - startTime;
            maybeLogQueryToEventLog(durationMillis, uri, projection, selection, sortOrder);
Cursor var06283D7CE457C57870987986E88F1A19_916061786 =             new CursorWrapperInner(qCursor, provider);
            var06283D7CE457C57870987986E88F1A19_916061786.addTaint(taint);
            return var06283D7CE457C57870987986E88F1A19_916061786;
        } //End block
        catch (RemoteException e)
        {
            releaseProvider(provider);
Cursor var540C13E9E156B687226421B24F2DF178_897142943 =             null;
            var540C13E9E156B687226421B24F2DF178_897142943.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_897142943;
        } //End block
        catch (RuntimeException e)
        {
            releaseProvider(provider);
            e.addTaint(taint);
            throw e;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.237 -0400", hash_original_method = "741F25E5E9079F60798D64718B03495A", hash_generated_method = "C9D0F461997C9603F7DEF7ACDC0DFE24")
    public final InputStream openInputStream(Uri uri) throws FileNotFoundException {
        addTaint(uri.getTaint());
        String scheme = uri.getScheme();
        if(SCHEME_ANDROID_RESOURCE.equals(scheme))        
        {
            OpenResourceIdResult r = getResourceId(uri);
            try 
            {
                InputStream stream = r.r.openRawResource(r.id);
InputStream varA87CF74140B150613F4203E71875F9A7_530381945 =                 stream;
                varA87CF74140B150613F4203E71875F9A7_530381945.addTaint(taint);
                return varA87CF74140B150613F4203E71875F9A7_530381945;
            } //End block
            catch (Resources.NotFoundException ex)
            {
                FileNotFoundException varE8810E522D8B98FEF67E48EC052E3409_1907833825 = new FileNotFoundException("Resource does not exist: " + uri);
                varE8810E522D8B98FEF67E48EC052E3409_1907833825.addTaint(taint);
                throw varE8810E522D8B98FEF67E48EC052E3409_1907833825;
            } //End block
        } //End block
        else
        if(SCHEME_FILE.equals(scheme))        
        {
InputStream varFC75AD1534DBFE0E739C82AC8780E884_1407075521 =             new FileInputStream(uri.getPath());
            varFC75AD1534DBFE0E739C82AC8780E884_1407075521.addTaint(taint);
            return varFC75AD1534DBFE0E739C82AC8780E884_1407075521;
        } //End block
        else
        {
            AssetFileDescriptor fd = openAssetFileDescriptor(uri, "r");
            try 
            {
InputStream varBE141D4F2C9E7C9CF6C0202CDAF666BA_281667681 =                 fd != null ? fd.createInputStream() : null;
                varBE141D4F2C9E7C9CF6C0202CDAF666BA_281667681.addTaint(taint);
                return varBE141D4F2C9E7C9CF6C0202CDAF666BA_281667681;
            } //End block
            catch (IOException e)
            {
                FileNotFoundException varE14CDFD965413CCD1DE03C3CE3B3937E_994784334 = new FileNotFoundException("Unable to create stream");
                varE14CDFD965413CCD1DE03C3CE3B3937E_994784334.addTaint(taint);
                throw varE14CDFD965413CCD1DE03C3CE3B3937E_994784334;
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.237 -0400", hash_original_method = "11A517824302FF0E2A744E48D03F81F2", hash_generated_method = "B16354D2C1561077417834ECF750F2E2")
    public final OutputStream openOutputStream(Uri uri) throws FileNotFoundException {
        addTaint(uri.getTaint());
OutputStream varDAF18F351C752F1D03791D667017D5CB_470621378 =         openOutputStream(uri, "w");
        varDAF18F351C752F1D03791D667017D5CB_470621378.addTaint(taint);
        return varDAF18F351C752F1D03791D667017D5CB_470621378;
        // ---------- Original Method ----------
        //return openOutputStream(uri, "w");
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.238 -0400", hash_original_method = "99597D87D82436F243497E22352BC980", hash_generated_method = "06AE5CDC1AB22D34BBC60F9E0A1F9009")
    public final OutputStream openOutputStream(Uri uri, String mode) throws FileNotFoundException {
        addTaint(mode.getTaint());
        addTaint(uri.getTaint());
        AssetFileDescriptor fd = openAssetFileDescriptor(uri, mode);
        try 
        {
OutputStream var9660A12712EE20E561E7EB86CAE36FCA_2139257642 =             fd != null ? fd.createOutputStream() : null;
            var9660A12712EE20E561E7EB86CAE36FCA_2139257642.addTaint(taint);
            return var9660A12712EE20E561E7EB86CAE36FCA_2139257642;
        } //End block
        catch (IOException e)
        {
            FileNotFoundException varE14CDFD965413CCD1DE03C3CE3B3937E_50793934 = new FileNotFoundException("Unable to create stream");
            varE14CDFD965413CCD1DE03C3CE3B3937E_50793934.addTaint(taint);
            throw varE14CDFD965413CCD1DE03C3CE3B3937E_50793934;
        } //End block
        // ---------- Original Method ----------
        //AssetFileDescriptor fd = openAssetFileDescriptor(uri, mode);
        //try {
            //return fd != null ? fd.createOutputStream() : null;
        //} catch (IOException e) {
            //throw new FileNotFoundException("Unable to create stream");
        //}
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.239 -0400", hash_original_method = "8C4F5C0648F37279A7BD3F73F68574C8", hash_generated_method = "F760C01E2AFB497C057E28F42D554510")
    public final ParcelFileDescriptor openFileDescriptor(Uri uri,
            String mode) throws FileNotFoundException {
        addTaint(mode.getTaint());
        addTaint(uri.getTaint());
        AssetFileDescriptor afd = openAssetFileDescriptor(uri, mode);
        if(afd == null)        
        {
ParcelFileDescriptor var540C13E9E156B687226421B24F2DF178_273338194 =             null;
            var540C13E9E156B687226421B24F2DF178_273338194.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_273338194;
        } //End block
        if(afd.getDeclaredLength() < 0)        
        {
ParcelFileDescriptor varA9AB8B7D15238800765F4158408BCDB4_1129845057 =             afd.getParcelFileDescriptor();
            varA9AB8B7D15238800765F4158408BCDB4_1129845057.addTaint(taint);
            return varA9AB8B7D15238800765F4158408BCDB4_1129845057;
        } //End block
        try 
        {
            afd.close();
        } //End block
        catch (IOException e)
        {
        } //End block
        FileNotFoundException varCF2804E98D5BC3EED85EC79FB2F91971_1628000177 = new FileNotFoundException("Not a whole file");
        varCF2804E98D5BC3EED85EC79FB2F91971_1628000177.addTaint(taint);
        throw varCF2804E98D5BC3EED85EC79FB2F91971_1628000177;
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.240 -0400", hash_original_method = "6D0B2664AB85671E5A18996AE47F9088", hash_generated_method = "5909EABB1BE5D6D75F4F94319F970714")
    public final AssetFileDescriptor openAssetFileDescriptor(Uri uri,
            String mode) throws FileNotFoundException {
        addTaint(mode.getTaint());
        addTaint(uri.getTaint());
        String scheme = uri.getScheme();
        if(SCHEME_ANDROID_RESOURCE.equals(scheme))        
        {
            if(!"r".equals(mode))            
            {
                FileNotFoundException var3E6E4698F2D2B39AC43F6148E6AB4CF6_1953959893 = new FileNotFoundException("Can't write resources: " + uri);
                var3E6E4698F2D2B39AC43F6148E6AB4CF6_1953959893.addTaint(taint);
                throw var3E6E4698F2D2B39AC43F6148E6AB4CF6_1953959893;
            } //End block
            OpenResourceIdResult r = getResourceId(uri);
            try 
            {
AssetFileDescriptor varF3583D388A196F6D98A374DDC1AD0113_238961648 =                 r.r.openRawResourceFd(r.id);
                varF3583D388A196F6D98A374DDC1AD0113_238961648.addTaint(taint);
                return varF3583D388A196F6D98A374DDC1AD0113_238961648;
            } //End block
            catch (Resources.NotFoundException ex)
            {
                FileNotFoundException varE8810E522D8B98FEF67E48EC052E3409_525756529 = new FileNotFoundException("Resource does not exist: " + uri);
                varE8810E522D8B98FEF67E48EC052E3409_525756529.addTaint(taint);
                throw varE8810E522D8B98FEF67E48EC052E3409_525756529;
            } //End block
        } //End block
        else
        if(SCHEME_FILE.equals(scheme))        
        {
            ParcelFileDescriptor pfd = ParcelFileDescriptor.open(
                    new File(uri.getPath()), modeToMode(uri, mode));
AssetFileDescriptor var6BD93397E5DAF0DF17CE1C003D2FCAB6_51578999 =             new AssetFileDescriptor(pfd, 0, -1);
            var6BD93397E5DAF0DF17CE1C003D2FCAB6_51578999.addTaint(taint);
            return var6BD93397E5DAF0DF17CE1C003D2FCAB6_51578999;
        } //End block
        else
        {
            if("r".equals(mode))            
            {
AssetFileDescriptor var728978861F4263FCBEBDB0546FBED7DF_1929068977 =                 openTypedAssetFileDescriptor(uri, "*/*", null);
                var728978861F4263FCBEBDB0546FBED7DF_1929068977.addTaint(taint);
                return var728978861F4263FCBEBDB0546FBED7DF_1929068977;
            } //End block
            else
            {
                IContentProvider provider = acquireProvider(uri);
                if(provider == null)                
                {
                    FileNotFoundException var40E2EE088A44F180C90D99DA40A11B6C_892636065 = new FileNotFoundException("No content provider: " + uri);
                    var40E2EE088A44F180C90D99DA40A11B6C_892636065.addTaint(taint);
                    throw var40E2EE088A44F180C90D99DA40A11B6C_892636065;
                } //End block
                try 
                {
                    AssetFileDescriptor fd = provider.openAssetFile(uri, mode);
                    if(fd == null)                    
                    {
AssetFileDescriptor var540C13E9E156B687226421B24F2DF178_251877756 =                         null;
                        var540C13E9E156B687226421B24F2DF178_251877756.addTaint(taint);
                        return var540C13E9E156B687226421B24F2DF178_251877756;
                    } //End block
                    ParcelFileDescriptor pfd = new ParcelFileDescriptorInner(
                            fd.getParcelFileDescriptor(), provider);
                    provider = null;
AssetFileDescriptor varC3C12411A882751F292369C906132F8B_232430355 =                     new AssetFileDescriptor(pfd, fd.getStartOffset(),
                            fd.getDeclaredLength());
                    varC3C12411A882751F292369C906132F8B_232430355.addTaint(taint);
                    return varC3C12411A882751F292369C906132F8B_232430355;
                } //End block
                catch (RemoteException e)
                {
                    FileNotFoundException varDBFDFCAA6D96C908D7FB1870DDC805CA_637845579 = new FileNotFoundException("Dead content provider: " + uri);
                    varDBFDFCAA6D96C908D7FB1870DDC805CA_637845579.addTaint(taint);
                    throw varDBFDFCAA6D96C908D7FB1870DDC805CA_637845579;
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.242 -0400", hash_original_method = "6625A014E29DF928853C1F0BC5B9E856", hash_generated_method = "F28F64B37951EAFD4DC2A909F7410A52")
    public final AssetFileDescriptor openTypedAssetFileDescriptor(Uri uri,
            String mimeType, Bundle opts) throws FileNotFoundException {
        addTaint(opts.getTaint());
        addTaint(mimeType.getTaint());
        addTaint(uri.getTaint());
        IContentProvider provider = acquireProvider(uri);
        if(provider == null)        
        {
            FileNotFoundException var40E2EE088A44F180C90D99DA40A11B6C_1521740524 = new FileNotFoundException("No content provider: " + uri);
            var40E2EE088A44F180C90D99DA40A11B6C_1521740524.addTaint(taint);
            throw var40E2EE088A44F180C90D99DA40A11B6C_1521740524;
        } //End block
        try 
        {
            AssetFileDescriptor fd = provider.openTypedAssetFile(uri, mimeType, opts);
            if(fd == null)            
            {
AssetFileDescriptor var540C13E9E156B687226421B24F2DF178_1417354185 =                 null;
                var540C13E9E156B687226421B24F2DF178_1417354185.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_1417354185;
            } //End block
            ParcelFileDescriptor pfd = new ParcelFileDescriptorInner(
                    fd.getParcelFileDescriptor(), provider);
            provider = null;
AssetFileDescriptor varC3C12411A882751F292369C906132F8B_1090437078 =             new AssetFileDescriptor(pfd, fd.getStartOffset(),
                    fd.getDeclaredLength());
            varC3C12411A882751F292369C906132F8B_1090437078.addTaint(taint);
            return varC3C12411A882751F292369C906132F8B_1090437078;
        } //End block
        catch (RemoteException e)
        {
            FileNotFoundException varDBFDFCAA6D96C908D7FB1870DDC805CA_957172816 = new FileNotFoundException("Dead content provider: " + uri);
            varDBFDFCAA6D96C908D7FB1870DDC805CA_957172816.addTaint(taint);
            throw varDBFDFCAA6D96C908D7FB1870DDC805CA_957172816;
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.244 -0400", hash_original_method = "39DD117C1A4502740FE90592CCDD92D2", hash_generated_method = "FE19753FD0F77CA250D52070CE878365")
    public OpenResourceIdResult getResourceId(Uri uri) throws FileNotFoundException {
        addTaint(uri.getTaint());
        String authority = uri.getAuthority();
        Resources r;
        if(TextUtils.isEmpty(authority))        
        {
            FileNotFoundException var0ACC1320D5E87EB8AD60C20862242804_532993811 = new FileNotFoundException("No authority: " + uri);
            var0ACC1320D5E87EB8AD60C20862242804_532993811.addTaint(taint);
            throw var0ACC1320D5E87EB8AD60C20862242804_532993811;
        } //End block
        else
        {
            try 
            {
                r = mContext.getPackageManager().getResourcesForApplication(authority);
            } //End block
            catch (NameNotFoundException ex)
            {
                FileNotFoundException var9514FE02F5A5CA391BAA8E45C47116A7_2028762562 = new FileNotFoundException("No package found for authority: " + uri);
                var9514FE02F5A5CA391BAA8E45C47116A7_2028762562.addTaint(taint);
                throw var9514FE02F5A5CA391BAA8E45C47116A7_2028762562;
            } //End block
        } //End block
        List<String> path = uri.getPathSegments();
        if(path == null)        
        {
            FileNotFoundException varC69DFEC10B02FEAA78D67A2A187A7F19_1314301271 = new FileNotFoundException("No path: " + uri);
            varC69DFEC10B02FEAA78D67A2A187A7F19_1314301271.addTaint(taint);
            throw varC69DFEC10B02FEAA78D67A2A187A7F19_1314301271;
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
                FileNotFoundException varC22B934DA93E3FEDAA7C59017512810F_218396504 = new FileNotFoundException("Single path segment is not a resource ID: " + uri);
                varC22B934DA93E3FEDAA7C59017512810F_218396504.addTaint(taint);
                throw varC22B934DA93E3FEDAA7C59017512810F_218396504;
            } //End block
        } //End block
        else
        if(len == 2)        
        {
            id = r.getIdentifier(path.get(1), path.get(0), authority);
        } //End block
        else
        {
            FileNotFoundException var5535C43DBB8176F250E03E36B76F22BA_1753792251 = new FileNotFoundException("More than two path segments: " + uri);
            var5535C43DBB8176F250E03E36B76F22BA_1753792251.addTaint(taint);
            throw var5535C43DBB8176F250E03E36B76F22BA_1753792251;
        } //End block
        if(id == 0)        
        {
            FileNotFoundException var62897123492917248A6A32EE2FAC55C4_1381458840 = new FileNotFoundException("No resource found for: " + uri);
            var62897123492917248A6A32EE2FAC55C4_1381458840.addTaint(taint);
            throw var62897123492917248A6A32EE2FAC55C4_1381458840;
        } //End block
        OpenResourceIdResult res = new OpenResourceIdResult();
        res.r = r;
        res.id = id;
OpenResourceIdResult varB5053E025797B3BF768F5C37934C244D_1199518351 =         res;
        varB5053E025797B3BF768F5C37934C244D_1199518351.addTaint(taint);
        return varB5053E025797B3BF768F5C37934C244D_1199518351;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.245 -0400", hash_original_method = "21049B5CF31214AC69662F00A8291DA2", hash_generated_method = "A0BD44872513ABED390A9E27A5D60D34")
    public final Uri insert(Uri url, ContentValues values) {
        addTaint(values.getTaint());
        addTaint(url.getTaint());
        IContentProvider provider = acquireProvider(url);
        if(provider == null)        
        {
            IllegalArgumentException varB20D676800D86334D5891F76F3E10503_1991163952 = new IllegalArgumentException("Unknown URL " + url);
            varB20D676800D86334D5891F76F3E10503_1991163952.addTaint(taint);
            throw varB20D676800D86334D5891F76F3E10503_1991163952;
        } //End block
        try 
        {
            long startTime = SystemClock.uptimeMillis();
            Uri createdRow = provider.insert(url, values);
            long durationMillis = SystemClock.uptimeMillis() - startTime;
            maybeLogUpdateToEventLog(durationMillis, url, "insert", null );
Uri var9668A06783A9113EEB45F2F771B856FB_1190693050 =             createdRow;
            var9668A06783A9113EEB45F2F771B856FB_1190693050.addTaint(taint);
            return var9668A06783A9113EEB45F2F771B856FB_1190693050;
        } //End block
        catch (RemoteException e)
        {
Uri var540C13E9E156B687226421B24F2DF178_1537803511 =             null;
            var540C13E9E156B687226421B24F2DF178_1537803511.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1537803511;
        } //End block
        finally 
        {
            releaseProvider(provider);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.246 -0400", hash_original_method = "35DA1841C97E840C3B5123B65D72A2FC", hash_generated_method = "BFE188243087A9DFE20934A1EA4CFA4A")
    public ContentProviderResult[] applyBatch(String authority,
            ArrayList<ContentProviderOperation> operations) throws RemoteException, OperationApplicationException {
        addTaint(operations.getTaint());
        addTaint(authority.getTaint());
        ContentProviderClient provider = acquireContentProviderClient(authority);
        if(provider == null)        
        {
            IllegalArgumentException var00F727789A0A7DE88397D2B2A17A4577_1648739425 = new IllegalArgumentException("Unknown authority " + authority);
            var00F727789A0A7DE88397D2B2A17A4577_1648739425.addTaint(taint);
            throw var00F727789A0A7DE88397D2B2A17A4577_1648739425;
        } //End block
        try 
        {
ContentProviderResult[] var7BE4D9098231AED0DF2F567E54B89316_1030349163 =             provider.applyBatch(operations);
            var7BE4D9098231AED0DF2F567E54B89316_1030349163.addTaint(taint);
            return var7BE4D9098231AED0DF2F567E54B89316_1030349163;
        } //End block
        finally 
        {
            provider.release();
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.247 -0400", hash_original_method = "B00B6610FA17409048836C33B1F1B82B", hash_generated_method = "0140ADCFFF65F9DBD20ECF981C7555C4")
    public final int bulkInsert(Uri url, ContentValues[] values) {
        addTaint(values[0].getTaint());
        addTaint(url.getTaint());
        IContentProvider provider = acquireProvider(url);
        if(provider == null)        
        {
            IllegalArgumentException varB20D676800D86334D5891F76F3E10503_613334393 = new IllegalArgumentException("Unknown URL " + url);
            varB20D676800D86334D5891F76F3E10503_613334393.addTaint(taint);
            throw varB20D676800D86334D5891F76F3E10503_613334393;
        } //End block
        try 
        {
            long startTime = SystemClock.uptimeMillis();
            int rowsCreated = provider.bulkInsert(url, values);
            long durationMillis = SystemClock.uptimeMillis() - startTime;
            maybeLogUpdateToEventLog(durationMillis, url, "bulkinsert", null );
            int var4C909CBC1D72D91EDE3440CE60EF064F_1587155133 = (rowsCreated);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1127978415 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1127978415;
        } //End block
        catch (RemoteException e)
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_2090197231 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1625424293 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1625424293;
        } //End block
        finally 
        {
            releaseProvider(provider);
        } //End block
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.248 -0400", hash_original_method = "5F64E7642550035A4284C543DD08EBF1", hash_generated_method = "69DED4A389D12B710509AB79ED6315A5")
    public final int delete(Uri url, String where, String[] selectionArgs) {
        addTaint(selectionArgs[0].getTaint());
        addTaint(where.getTaint());
        addTaint(url.getTaint());
        IContentProvider provider = acquireProvider(url);
        if(provider == null)        
        {
            IllegalArgumentException varB20D676800D86334D5891F76F3E10503_1658140794 = new IllegalArgumentException("Unknown URL " + url);
            varB20D676800D86334D5891F76F3E10503_1658140794.addTaint(taint);
            throw varB20D676800D86334D5891F76F3E10503_1658140794;
        } //End block
        try 
        {
            long startTime = SystemClock.uptimeMillis();
            int rowsDeleted = provider.delete(url, where, selectionArgs);
            long durationMillis = SystemClock.uptimeMillis() - startTime;
            maybeLogUpdateToEventLog(durationMillis, url, "delete", where);
            int var9FA48E40266055B7DB16BBDBD5D3D301_1197099368 = (rowsDeleted);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1942879162 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1942879162;
        } //End block
        catch (RemoteException e)
        {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_722163981 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1700886793 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1700886793;
        } //End block
        finally 
        {
            releaseProvider(provider);
        } //End block
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.249 -0400", hash_original_method = "93173B163A2993B2278E9CE2CA5F5268", hash_generated_method = "61FB6BE63063E783408D2AA4AC89DED2")
    public final int update(Uri uri, ContentValues values, String where,
            String[] selectionArgs) {
        addTaint(selectionArgs[0].getTaint());
        addTaint(where.getTaint());
        addTaint(values.getTaint());
        addTaint(uri.getTaint());
        IContentProvider provider = acquireProvider(uri);
        if(provider == null)        
        {
            IllegalArgumentException var777AC27F236FED626942221893EC6521_122929460 = new IllegalArgumentException("Unknown URI " + uri);
            var777AC27F236FED626942221893EC6521_122929460.addTaint(taint);
            throw var777AC27F236FED626942221893EC6521_122929460;
        } //End block
        try 
        {
            long startTime = SystemClock.uptimeMillis();
            int rowsUpdated = provider.update(uri, values, where, selectionArgs);
            long durationMillis = SystemClock.uptimeMillis() - startTime;
            maybeLogUpdateToEventLog(durationMillis, uri, "update", where);
            int var83251BA8F1A3D90F0CA5ADFF60F0D3C0_761243993 = (rowsUpdated);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1937143563 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1937143563;
        } //End block
        catch (RemoteException e)
        {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_2035645876 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1746019003 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1746019003;
        } //End block
        finally 
        {
            releaseProvider(provider);
        } //End block
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.250 -0400", hash_original_method = "7B97BF1D704BA5CFE2C56D2F21EF49E5", hash_generated_method = "282C285B82F8A39E8EF683629AC42140")
    public final Bundle call(Uri uri, String method, String arg, Bundle extras) {
        addTaint(extras.getTaint());
        addTaint(arg.getTaint());
        addTaint(method.getTaint());
        addTaint(uri.getTaint());
        if(uri == null)        
        {
            NullPointerException var1D3C31C9903C19A5E960BD20D3C05D23_644320534 = new NullPointerException("uri == null");
            var1D3C31C9903C19A5E960BD20D3C05D23_644320534.addTaint(taint);
            throw var1D3C31C9903C19A5E960BD20D3C05D23_644320534;
        } //End block
        if(method == null)        
        {
            NullPointerException var94DAF527A0B47AA6ECA3C5A76418A86A_289919027 = new NullPointerException("method == null");
            var94DAF527A0B47AA6ECA3C5A76418A86A_289919027.addTaint(taint);
            throw var94DAF527A0B47AA6ECA3C5A76418A86A_289919027;
        } //End block
        IContentProvider provider = acquireProvider(uri);
        if(provider == null)        
        {
            IllegalArgumentException var777AC27F236FED626942221893EC6521_945526567 = new IllegalArgumentException("Unknown URI " + uri);
            var777AC27F236FED626942221893EC6521_945526567.addTaint(taint);
            throw var777AC27F236FED626942221893EC6521_945526567;
        } //End block
        try 
        {
Bundle var5782F784778F2F0CFC89129DC58C9724_813580029 =             provider.call(method, arg, extras);
            var5782F784778F2F0CFC89129DC58C9724_813580029.addTaint(taint);
            return var5782F784778F2F0CFC89129DC58C9724_813580029;
        } //End block
        catch (RemoteException e)
        {
Bundle var540C13E9E156B687226421B24F2DF178_891447109 =             null;
            var540C13E9E156B687226421B24F2DF178_891447109.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_891447109;
        } //End block
        finally 
        {
            releaseProvider(provider);
        } //End block
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.251 -0400", hash_original_method = "337E4492D27C715A525AA87619808C6B", hash_generated_method = "24101B7733F2BC30B904BEBA16D32364")
    public final IContentProvider acquireProvider(Uri uri) {
        addTaint(uri.getTaint());
        if(!SCHEME_CONTENT.equals(uri.getScheme()))        
        {
IContentProvider var540C13E9E156B687226421B24F2DF178_949990472 =             null;
            var540C13E9E156B687226421B24F2DF178_949990472.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_949990472;
        } //End block
        String auth = uri.getAuthority();
        if(auth != null)        
        {
IContentProvider var4780BBFCDBD9BFF14B667AD7D8AB9F81_1437156961 =             acquireProvider(mContext, uri.getAuthority());
            var4780BBFCDBD9BFF14B667AD7D8AB9F81_1437156961.addTaint(taint);
            return var4780BBFCDBD9BFF14B667AD7D8AB9F81_1437156961;
        } //End block
IContentProvider var540C13E9E156B687226421B24F2DF178_450473863 =         null;
        var540C13E9E156B687226421B24F2DF178_450473863.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_450473863;
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.252 -0400", hash_original_method = "C657A24801BE240D39C6FCA466A49DFE", hash_generated_method = "041D14D273B42083365F3D706C809460")
    public final IContentProvider acquireExistingProvider(Uri uri) {
        addTaint(uri.getTaint());
        if(!SCHEME_CONTENT.equals(uri.getScheme()))        
        {
IContentProvider var540C13E9E156B687226421B24F2DF178_1761538565 =             null;
            var540C13E9E156B687226421B24F2DF178_1761538565.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1761538565;
        } //End block
        String auth = uri.getAuthority();
        if(auth != null)        
        {
IContentProvider var35C8142F5E07DC5EB04C3A6752979CAB_241162482 =             acquireExistingProvider(mContext, uri.getAuthority());
            var35C8142F5E07DC5EB04C3A6752979CAB_241162482.addTaint(taint);
            return var35C8142F5E07DC5EB04C3A6752979CAB_241162482;
        } //End block
IContentProvider var540C13E9E156B687226421B24F2DF178_1723271964 =         null;
        var540C13E9E156B687226421B24F2DF178_1723271964.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1723271964;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.253 -0400", hash_original_method = "1419B9D62800705D7AC72C916BD8939A", hash_generated_method = "E2CF02B4BC2AF5C836F2CEC2DBDEB225")
    public final IContentProvider acquireProvider(String name) {
        addTaint(name.getTaint());
        if(name == null)        
        {
IContentProvider var540C13E9E156B687226421B24F2DF178_1466790434 =             null;
            var540C13E9E156B687226421B24F2DF178_1466790434.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1466790434;
        } //End block
IContentProvider varAF2FF65A41417D63A0BC223C355F9263_969016396 =         acquireProvider(mContext, name);
        varAF2FF65A41417D63A0BC223C355F9263_969016396.addTaint(taint);
        return varAF2FF65A41417D63A0BC223C355F9263_969016396;
        // ---------- Original Method ----------
        //if (name == null) {
            //return null;
        //}
        //return acquireProvider(mContext, name);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.253 -0400", hash_original_method = "5741247DD17162DA82750F730CE6B9A7", hash_generated_method = "86A58CA667CFC1DF9C37B68CF6C91135")
    public final ContentProviderClient acquireContentProviderClient(Uri uri) {
        addTaint(uri.getTaint());
        IContentProvider provider = acquireProvider(uri);
        if(provider != null)        
        {
ContentProviderClient var01598678913D3029A3BDD994E3BED651_889319377 =             new ContentProviderClient(this, provider);
            var01598678913D3029A3BDD994E3BED651_889319377.addTaint(taint);
            return var01598678913D3029A3BDD994E3BED651_889319377;
        } //End block
ContentProviderClient var540C13E9E156B687226421B24F2DF178_400961386 =         null;
        var540C13E9E156B687226421B24F2DF178_400961386.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_400961386;
        // ---------- Original Method ----------
        //IContentProvider provider = acquireProvider(uri);
        //if (provider != null) {
            //return new ContentProviderClient(this, provider);
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.254 -0400", hash_original_method = "01901AA9613048A3AC98A39C9DD35CAC", hash_generated_method = "079B7BBD43360B791644FE66D81C9CED")
    public final ContentProviderClient acquireContentProviderClient(String name) {
        addTaint(name.getTaint());
        IContentProvider provider = acquireProvider(name);
        if(provider != null)        
        {
ContentProviderClient var01598678913D3029A3BDD994E3BED651_588568515 =             new ContentProviderClient(this, provider);
            var01598678913D3029A3BDD994E3BED651_588568515.addTaint(taint);
            return var01598678913D3029A3BDD994E3BED651_588568515;
        } //End block
ContentProviderClient var540C13E9E156B687226421B24F2DF178_344325880 =         null;
        var540C13E9E156B687226421B24F2DF178_344325880.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_344325880;
        // ---------- Original Method ----------
        //IContentProvider provider = acquireProvider(name);
        //if (provider != null) {
            //return new ContentProviderClient(this, provider);
        //}
        //return null;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.255 -0400", hash_original_method = "7AFED95A5C5E44717133ED415B77A63B", hash_generated_method = "9DE77D376ACF62E5953DA806A02FAC8A")
    public final void registerContentObserver(Uri uri, boolean notifyForDescendents,
            ContentObserver observer) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(observer.getTaint());
        addTaint(notifyForDescendents);
        addTaint(uri.getTaint());
        try 
        {
            getContentService().registerContentObserver(uri, notifyForDescendents,
                    observer.getContentObserver());
        } //End block
        catch (RemoteException e)
        {
        } //End block
        // ---------- Original Method ----------
        //try {
            //getContentService().registerContentObserver(uri, notifyForDescendents,
                    //observer.getContentObserver());
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.256 -0400", hash_original_method = "A19276E2B38D6FC8E7769343C0EFAA57", hash_generated_method = "426ECF19D7408595EA2CDC278553BBC6")
    public final void unregisterContentObserver(ContentObserver observer) {
        addTaint(observer.getTaint());
        try 
        {
            IContentObserver contentObserver = observer.releaseContentObserver();
            if(contentObserver != null)            
            {
                getContentService().unregisterContentObserver(
                        contentObserver);
            } //End block
        } //End block
        catch (RemoteException e)
        {
        } //End block
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.256 -0400", hash_original_method = "E76834C8ABF23847CEBC5965503FC8D5", hash_generated_method = "841332F3B587E937B98F5F76F4A75E19")
    public void notifyChange(Uri uri, ContentObserver observer) {
        addTaint(observer.getTaint());
        addTaint(uri.getTaint());
        notifyChange(uri, observer, true );
        // ---------- Original Method ----------
        //notifyChange(uri, observer, true );
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.257 -0400", hash_original_method = "F301FE1DDD6CC7648C7F98CD4F863542", hash_generated_method = "4834D3929F315BCA26B25893BA189E3F")
    public void notifyChange(Uri uri, ContentObserver observer, boolean syncToNetwork) {
        addTaint(syncToNetwork);
        addTaint(observer.getTaint());
        addTaint(uri.getTaint());
        try 
        {
            getContentService().notifyChange(
                    uri, observer == null ? null : observer.getContentObserver(),
                    observer != null && observer.deliverSelfNotifications(), syncToNetwork);
        } //End block
        catch (RemoteException e)
        {
        } //End block
        // ---------- Original Method ----------
        //try {
            //getContentService().notifyChange(
                    //uri, observer == null ? null : observer.getContentObserver(),
                    //observer != null && observer.deliverSelfNotifications(), syncToNetwork);
        //} catch (RemoteException e) {
        //}
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.257 -0400", hash_original_method = "2D6405030D787F1D91AFA94E2D425989", hash_generated_method = "8FD49EB480C67F13739811857A7B4F54")
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

    
    @DSModeled(DSC.SPEC)
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.259 -0400", hash_original_method = "B4949CE6FC68B3756629FF654EA4F622", hash_generated_method = "98293DACBF37DC3FB629FF105B0B9357")
    @Deprecated
    public void cancelSync(Uri uri) {
        addTaint(uri.getTaint());
        cancelSync(null , uri != null ? uri.getAuthority() : null);
        // ---------- Original Method ----------
        //cancelSync(null , uri != null ? uri.getAuthority() : null);
    }

    
    @DSModeled(DSC.SPEC)
    public static void cancelSync(Account account, String authority) {
        try {
            getContentService().cancelSync(account, authority);
        } catch (RemoteException e) {
        }
    }

    
    @DSModeled(DSC.SPEC)
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

    
    @DSModeled(DSC.SPEC)
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

    
    @DSModeled(DSC.SPEC)
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.267 -0400", hash_original_method = "5964C3B3CD446EC6DF12ED3CA7F7D861", hash_generated_method = "DD2E233FC3D2F421C067205AFDB4F958")
    private int samplePercentForDuration(long durationMillis) {
        addTaint(durationMillis);
        if(durationMillis >= SLOW_THRESHOLD_MILLIS)        
        {
            int varF899139DF5E1059396431415E770C6DD_592492517 = (100);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_736351088 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_736351088;
        } //End block
        int var5B4DF0029359ED92E7958806B4562BD7_1181901762 = ((int) (100 * durationMillis / SLOW_THRESHOLD_MILLIS) + 1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1319605850 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1319605850;
        // ---------- Original Method ----------
        //if (durationMillis >= SLOW_THRESHOLD_MILLIS) {
            //return 100;
        //}
        //return (int) (100 * durationMillis / SLOW_THRESHOLD_MILLIS) + 1;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.269 -0400", hash_original_method = "339BAFB8AA6EDB4FDC193A187E8B0067", hash_generated_method = "9BD6BF415ED84B3DEA2AD9DAD6E0E3D7")
    private void maybeLogQueryToEventLog(long durationMillis,
                                         Uri uri, String[] projection,
                                         String selection, String sortOrder) {
        addTaint(sortOrder.getTaint());
        addTaint(selection.getTaint());
        addTaint(projection[0].getTaint());
        addTaint(uri.getTaint());
        addTaint(durationMillis);
        int samplePercent = samplePercentForDuration(durationMillis);
        if(samplePercent < 100)        
        {
            synchronized
(mRandom)            {
                if(mRandom.nextInt(100) >= samplePercent)                
                {
                    return;
                } //End block
            } //End block
        } //End block
        StringBuilder projectionBuffer = new StringBuilder(100);
        if(projection != null)        
        {
for(int i = 0;i < projection.length;++i)
            {
                if(i != 0)                
                projectionBuffer.append('/');
                projectionBuffer.append(projection[i]);
            } //End block
        } //End block
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.270 -0400", hash_original_method = "8C4CA0C0E96B47F9D6365343066B43C9", hash_generated_method = "3C5109E1FC653AE1DDDF530D6B2D1689")
    private void maybeLogUpdateToEventLog(
        long durationMillis, Uri uri, String operation, String selection) {
        addTaint(selection.getTaint());
        addTaint(operation.getTaint());
        addTaint(uri.getTaint());
        addTaint(durationMillis);
        int samplePercent = samplePercentForDuration(durationMillis);
        if(samplePercent < 100)        
        {
            synchronized
(mRandom)            {
                if(mRandom.nextInt(100) >= samplePercent)                
                {
                    return;
                } //End block
            } //End block
        } //End block
        String blockingPackage = AppGlobals.getInitialPackage();
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

    
    @DSModeled(DSC.SPEC)
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.271 -0400", hash_original_field = "4B43B0AEE35624CD95B910189B3DC231", hash_generated_field = "3D94ED8234243D4DE3F50EF6E646D0E3")

        public Resources r;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.271 -0400", hash_original_field = "B80BB7740288FDA1F201890375A60C8F", hash_generated_field = "FA0A3841DE31A9B4AD2F31B3665056D8")

        public int id;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.272 -0400", hash_original_method = "EC7BB03A160C6C88DBB9DFBF62B48748", hash_generated_method = "EC7BB03A160C6C88DBB9DFBF62B48748")
        public OpenResourceIdResult ()
        {
            //Synthesized constructor
        }


    }


    
    private final class CursorWrapperInner extends CrossProcessCursorWrapper {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.272 -0400", hash_original_field = "4AB176078152082D060487A305BE9F63", hash_generated_field = "B614D226FB5223D135A9D332098A34A4")

        private IContentProvider mContentProvider;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.272 -0400", hash_original_field = "FAB63045DAC8675C1DE9648413C0413D", hash_generated_field = "91705AACD6DDE42AEA628776AF2A3DC6")

        private final CloseGuard mCloseGuard = CloseGuard.get();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.273 -0400", hash_original_field = "73EB2A2C6C3CC1E8C72EB379571EB098", hash_generated_field = "FF245C536DEFD57B2DCDAA00E8BC192F")

        private boolean mProviderReleased;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.274 -0400", hash_original_method = "33833BC2FFA324FE6B3A882C16B09B24", hash_generated_method = "C6AA7649F1C765F90DC41AF7D2C26B43")
          CursorWrapperInner(Cursor cursor, IContentProvider icp) {
            super(cursor);
            addTaint(cursor.getTaint());
            mContentProvider = icp;
            mCloseGuard.open("close");
            // ---------- Original Method ----------
            //mContentProvider = icp;
            //mCloseGuard.open("close");
        }

        
                @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.275 -0400", hash_original_method = "CB76115716387DD39854EA1927F29C52", hash_generated_method = "461D5BB19C18033D953C4676F5B1721B")
        @Override
        public void close() {
            super.close();
            ContentResolver.this.releaseProvider(mContentProvider);
            mProviderReleased = true;
            if(mCloseGuard != null)            
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.275 -0400", hash_original_method = "C6F30BD2AC97CE59E2F19D89687C7506", hash_generated_method = "F268146468AFC07C9440E2C5CA696212")
        @Override
        protected void finalize() throws Throwable {
            try 
            {
                if(mCloseGuard != null)                
                {
                    mCloseGuard.warnIfOpen();
                } //End block
                if(!mProviderReleased && mContentProvider != null)                
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.276 -0400", hash_original_field = "13FB907F06B05F7137165C185CBCE3C3", hash_generated_field = "EACA88E7B01FC8694B38FD93BBF3A6CA")

        public static final String TAG="CursorWrapperInner";
    }


    
    private final class ParcelFileDescriptorInner extends ParcelFileDescriptor {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.276 -0400", hash_original_field = "4AB176078152082D060487A305BE9F63", hash_generated_field = "B614D226FB5223D135A9D332098A34A4")

        private IContentProvider mContentProvider;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.276 -0400", hash_original_field = "AC321E1C1B8C101F950B583BC403E782", hash_generated_field = "DCC2C4F00C9417AA6FB57200F6F6249D")

        private boolean mReleaseProviderFlag = false;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.277 -0400", hash_original_method = "84882D259A9B741E8CCE8DBD7345B8D5", hash_generated_method = "2F238FD9AF5C3F8E4BF284D0C0C0770E")
          ParcelFileDescriptorInner(ParcelFileDescriptor pfd, IContentProvider icp) {
            super(pfd);
            addTaint(pfd.getTaint());
            mContentProvider = icp;
            // ---------- Original Method ----------
            //mContentProvider = icp;
        }

        
                @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.278 -0400", hash_original_method = "88C4FC226DB7C9E08A0225C4D4C037C0", hash_generated_method = "2931B14EB0C4E940924437ADC26E5475")
        @Override
        public void close() throws IOException {
            if(!mReleaseProviderFlag)            
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

        
                @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.279 -0400", hash_original_method = "E5C83F24E1B33F16225B47651FBE1E16", hash_generated_method = "BB9D5FCD4BE1CF73267E1BB6EFE05F92")
        @Override
        protected void finalize() throws Throwable {
            if(!mReleaseProviderFlag)            
            {
                close();
            } //End block
            // ---------- Original Method ----------
            //if (!mReleaseProviderFlag) {
                //close();
            //}
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.280 -0400", hash_original_field = "CB7B93CDAC708AECA662EC86F82451BD", hash_generated_field = "853BAF17ACDDF73D9A8E686A803B9543")

        public static final String TAG="ParcelFileDescriptorInner";
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.281 -0400", hash_original_field = "C2EDFC92CCF8B16E3533DCFADC264E23", hash_generated_field = "87B095273B7680C6E8D776FD7BED0443")

    @Deprecated
    public static final String SYNC_EXTRAS_ACCOUNT = "account";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.281 -0400", hash_original_field = "9A7319143C3370C3B9F862CE740B5B75", hash_generated_field = "8B7D39A0706705FDAF94593ED0FACFEA")

    public static final String SYNC_EXTRAS_EXPEDITED = "expedited";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.281 -0400", hash_original_field = "0C5ED6B0AA55903B1B309BC3AE9C1AC5", hash_generated_field = "52C4CBE6F8AFC4D6C338F6272437F588")

    @Deprecated
    public static final String SYNC_EXTRAS_FORCE = "force";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.281 -0400", hash_original_field = "7BF6732A8AD149D6BF72E2CEB933EAEC", hash_generated_field = "9CB83B5127CA25B88446759FC78BB810")

    public static final String SYNC_EXTRAS_IGNORE_SETTINGS = "ignore_settings";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.282 -0400", hash_original_field = "48D105EF39F24B3ED276155D8F366FAD", hash_generated_field = "2460C39D3F3C8C8E9A6CA2DB50888065")

    public static final String SYNC_EXTRAS_IGNORE_BACKOFF = "ignore_backoff";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.282 -0400", hash_original_field = "BD3F4206E2333EE4EC1C44D083DBDDD9", hash_generated_field = "FB3D46B8F0404EBA4D41256EFCE69610")

    public static final String SYNC_EXTRAS_DO_NOT_RETRY = "do_not_retry";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.282 -0400", hash_original_field = "81C2869721D54621C1E9EBBF388E766C", hash_generated_field = "2CB777FABA87110DA15F0AAAA5216B13")

    public static final String SYNC_EXTRAS_MANUAL = "force";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.282 -0400", hash_original_field = "2627674F99971004D823BB1DC0D4AD30", hash_generated_field = "C66AD9A9054789246D88C3CEF49E0FE1")

    public static final String SYNC_EXTRAS_UPLOAD = "upload";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.282 -0400", hash_original_field = "2DB15BFAA122A6E4C8E09D40E27DE3A2", hash_generated_field = "085DFE00F23ABC519407289B800B9330")

    public static final String SYNC_EXTRAS_OVERRIDE_TOO_MANY_DELETIONS = "deletions_override";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.282 -0400", hash_original_field = "C93C475906837EA8C1231337BD9580CD", hash_generated_field = "A3280C9121A39AB92BFE4613E22A9F10")

    public static final String SYNC_EXTRAS_DISCARD_LOCAL_DELETIONS = "discard_deletions";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.283 -0400", hash_original_field = "F7B81FFD29F1E27E81F42B4EAF4745EB", hash_generated_field = "9A51FA040B5EE450933873F1925571E2")

    public static final String SYNC_EXTRAS_INITIALIZE = "initialize";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.283 -0400", hash_original_field = "B9EC534A4D635B10BE9040DF27185A80", hash_generated_field = "2A050A80E7005A896641161E25801F35")

    public static final String SCHEME_CONTENT = "content";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.283 -0400", hash_original_field = "F438C67F57FF4A50EDA09593EBEF286A", hash_generated_field = "7BECC35C4D527BA52EC58C833FB0BB34")

    public static final String SCHEME_ANDROID_RESOURCE = "android.resource";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.283 -0400", hash_original_field = "02F0EE6F8DEEBB0D5DCDD1E064DAC005", hash_generated_field = "D24B6CC01AD3F5B91B2CFC56B92A6E03")

    public static final String SCHEME_FILE = "file";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.283 -0400", hash_original_field = "893D0280FDFF6A2950856B98E73C71C1", hash_generated_field = "A41DFC918AF8E5D466EE8DAB0BF274F3")

    public static final String CURSOR_ITEM_BASE_TYPE = "vnd.android.cursor.item";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.284 -0400", hash_original_field = "95AED60F9A6BBB9F889EF813B7143610", hash_generated_field = "2D7AE2632599144DAA81BD08B4C8870E")

    public static final String CURSOR_DIR_BASE_TYPE = "vnd.android.cursor.dir";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.284 -0400", hash_original_field = "78541B0F3CCE1FAC3BA266FCB7621070", hash_generated_field = "F78FAC8C90BCAD8994706D8A7F584B12")

    public static final int SYNC_ERROR_SYNC_ALREADY_IN_PROGRESS = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.284 -0400", hash_original_field = "B72A154B591BAC40AEEF38C8E42F3335", hash_generated_field = "70645C1513ABFE107B9AF0BCB3F68340")

    public static final int SYNC_ERROR_AUTHENTICATION = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.284 -0400", hash_original_field = "FDA99AB14533C63BBCCA0F64BB7CF769", hash_generated_field = "2B1BA46E87D9EA52416FF82A7E9FC949")

    public static final int SYNC_ERROR_IO = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.284 -0400", hash_original_field = "CCA53EB6D8F9D64BE4EE63C66A08F236", hash_generated_field = "7D02506C7CBA10BD97CA79FB59DD9D15")

    public static final int SYNC_ERROR_PARSE = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.284 -0400", hash_original_field = "296A74F9B6DA67DDD9E8F0428AD3FFE0", hash_generated_field = "A315DAC0C98347D6DCFC6C6B32DA70BD")

    public static final int SYNC_ERROR_CONFLICT = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.284 -0400", hash_original_field = "83F48894C7BA225F7124ABDE5C0665CF", hash_generated_field = "76FE33D22783EC3D4779B2B73BE75DE9")

    public static final int SYNC_ERROR_TOO_MANY_DELETIONS = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.285 -0400", hash_original_field = "80FB09ABFBCC98D6C5E978E238B95658", hash_generated_field = "6E9809F790E5D29754E07F710C703033")

    public static final int SYNC_ERROR_TOO_MANY_RETRIES = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.285 -0400", hash_original_field = "BA70D22939E01C21C5AF2B587BFF152B", hash_generated_field = "9EF2EEC53560FF1A3EC43F81D719B306")

    public static final int SYNC_ERROR_INTERNAL = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.285 -0400", hash_original_field = "8F1E898EBD09004F8E52103FC8644049", hash_generated_field = "EC6D4E9079B435808FB02F42CC269B78")

    public static final int SYNC_OBSERVER_TYPE_SETTINGS = 1<<0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.285 -0400", hash_original_field = "45C5DD980F4A16E404292643A35A6433", hash_generated_field = "1F0C3937881F3FCFBF4E76673AB2169B")

    public static final int SYNC_OBSERVER_TYPE_PENDING = 1<<1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.285 -0400", hash_original_field = "2221A2B9CE572B6E501D97785FB05A8A", hash_generated_field = "0BBCE1310F4889E0CE3EBE1A843B06EC")

    public static final int SYNC_OBSERVER_TYPE_ACTIVE = 1<<2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.286 -0400", hash_original_field = "CBAD71B90CEF719A1DDEE4D9537EE9EF", hash_generated_field = "F118FAF287C6D65262857F494C71AFCE")

    public static final int SYNC_OBSERVER_TYPE_STATUS = 1<<3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.286 -0400", hash_original_field = "07D2AB9D80429D5E6907CE4783188520", hash_generated_field = "4285FF406FEA88E6536E37E5D6191611")

    public static final int SYNC_OBSERVER_TYPE_ALL = 0x7fffffff;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.286 -0400", hash_original_field = "5D2D67A3ADE9055680B54E64B5B18AF7", hash_generated_field = "48FEA35E2DFEE1057404A05E365FED9C")

    private static final int SLOW_THRESHOLD_MILLIS = 500;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.286 -0400", hash_original_field = "9664C3A1DEBAEE31270D6C126FBE59B7", hash_generated_field = "061BD03196A426FD4F175A19E9881E10")

    public static final String CONTENT_SERVICE_NAME = "content";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.286 -0400", hash_original_field = "0000B7DC2B7CEFF37F9F07EB8F63EAB2", hash_generated_field = "EBBA89635D26FA830DBE060ABCA948AD")

    private static IContentService sContentService;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.286 -0400", hash_original_field = "28B0C9DBF8E70FA0509AB8A6C9A3F293", hash_generated_field = "2E4D905723B5A2539B6E57BF8A2185DE")

    private static final String TAG = "ContentResolver";
}

