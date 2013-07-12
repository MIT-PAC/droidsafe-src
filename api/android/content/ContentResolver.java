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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.844 -0400", hash_original_field = "536255EED7E3D46DD70E09FDE814B7C1", hash_generated_field = "E26D41E197237C24B0E74C0394AEDF83")

    private final Random mRandom = new Random();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.845 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.846 -0400", hash_original_method = "8EB5ACCD206353DB8493F8AB9F861C85", hash_generated_method = "934BE422B780F73056F691B084F33D1F")
    public  ContentResolver(Context context) {
        mContext = context;
        // ---------- Original Method ----------
        //mContext = context;
    }

    
    protected abstract IContentProvider acquireProvider(Context c, String name);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.847 -0400", hash_original_method = "4AF2A0465BC3B713C9C8E0417552AB76", hash_generated_method = "9006F49CC9F8C34999AD7F3FB04E7E22")
    protected IContentProvider acquireExistingProvider(Context c, String name) {
        addTaint(name.getTaint());
        addTaint(c.getTaint());
IContentProvider var766C186C84316C5769DE0C3CF08965F1_1548898768 =         acquireProvider(c, name);
        var766C186C84316C5769DE0C3CF08965F1_1548898768.addTaint(taint);
        return var766C186C84316C5769DE0C3CF08965F1_1548898768;
        // ---------- Original Method ----------
        //return acquireProvider(c, name);
    }

    
    public abstract boolean releaseProvider(IContentProvider icp);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.848 -0400", hash_original_method = "045596B6E0367AC7BED26FC054AD1E2B", hash_generated_method = "A68A1A1DC18F7A7A0819242024FA5DEF")
    public final String getType(Uri url) {
        addTaint(url.getTaint());
        IContentProvider provider = acquireExistingProvider(url);
    if(provider != null)        
        {
            try 
            {
String var1A84D08190718109CB2BC27E1A4C03C0_670984369 =                 provider.getType(url);
                var1A84D08190718109CB2BC27E1A4C03C0_670984369.addTaint(taint);
                return var1A84D08190718109CB2BC27E1A4C03C0_670984369;
            } //End block
            catch (RemoteException e)
            {
String var540C13E9E156B687226421B24F2DF178_449269101 =                 null;
                var540C13E9E156B687226421B24F2DF178_449269101.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_449269101;
            } //End block
            catch (java.lang.Exception e)
            {
String var540C13E9E156B687226421B24F2DF178_518001615 =                 null;
                var540C13E9E156B687226421B24F2DF178_518001615.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_518001615;
            } //End block
            finally 
            {
                releaseProvider(provider);
            } //End block
        } //End block
    if(!SCHEME_CONTENT.equals(url.getScheme()))        
        {
String var540C13E9E156B687226421B24F2DF178_880378616 =             null;
            var540C13E9E156B687226421B24F2DF178_880378616.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_880378616;
        } //End block
        try 
        {
            String type = ActivityManagerNative.getDefault().getProviderMimeType(url);
String varC5B9F25B4EEAD3E8E2C33F9429204397_2016645452 =             type;
            varC5B9F25B4EEAD3E8E2C33F9429204397_2016645452.addTaint(taint);
            return varC5B9F25B4EEAD3E8E2C33F9429204397_2016645452;
        } //End block
        catch (RemoteException e)
        {
String var540C13E9E156B687226421B24F2DF178_1521751072 =             null;
            var540C13E9E156B687226421B24F2DF178_1521751072.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1521751072;
        } //End block
        catch (java.lang.Exception e)
        {
String var540C13E9E156B687226421B24F2DF178_1904687567 =             null;
            var540C13E9E156B687226421B24F2DF178_1904687567.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1904687567;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.849 -0400", hash_original_method = "BFD7301BBEDEF32538E97E3FEFB31C63", hash_generated_method = "5DC0510205DB50DDE0DC03F6D5F1916D")
    public String[] getStreamTypes(Uri url, String mimeTypeFilter) {
        addTaint(mimeTypeFilter.getTaint());
        addTaint(url.getTaint());
        IContentProvider provider = acquireProvider(url);
    if(provider == null)        
        {
String[] var540C13E9E156B687226421B24F2DF178_825834727 =             null;
            var540C13E9E156B687226421B24F2DF178_825834727.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_825834727;
        } //End block
        try 
        {
String[] varC36AEBB87CA75D0818120C3B784E0B4F_1585674643 =             provider.getStreamTypes(url, mimeTypeFilter);
            varC36AEBB87CA75D0818120C3B784E0B4F_1585674643.addTaint(taint);
            return varC36AEBB87CA75D0818120C3B784E0B4F_1585674643;
        } //End block
        catch (RemoteException e)
        {
String[] var540C13E9E156B687226421B24F2DF178_1101413273 =             null;
            var540C13E9E156B687226421B24F2DF178_1101413273.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1101413273;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.850 -0400", hash_original_method = "505F43360905D398310F020FC85BFA22", hash_generated_method = "C103096F0A4EE2737E666EC044B13E3C")
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
Cursor var540C13E9E156B687226421B24F2DF178_1089684887 =             null;
            var540C13E9E156B687226421B24F2DF178_1089684887.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1089684887;
        } //End block
        try 
        {
            long startTime = SystemClock.uptimeMillis();
            Cursor qCursor = provider.query(uri, projection, selection, selectionArgs, sortOrder);
    if(qCursor == null)            
            {
                releaseProvider(provider);
Cursor var540C13E9E156B687226421B24F2DF178_1219835390 =                 null;
                var540C13E9E156B687226421B24F2DF178_1219835390.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_1219835390;
            } //End block
            qCursor.getCount();
            long durationMillis = SystemClock.uptimeMillis() - startTime;
            maybeLogQueryToEventLog(durationMillis, uri, projection, selection, sortOrder);
Cursor var06283D7CE457C57870987986E88F1A19_1245449146 =             new CursorWrapperInner(qCursor, provider);
            var06283D7CE457C57870987986E88F1A19_1245449146.addTaint(taint);
            return var06283D7CE457C57870987986E88F1A19_1245449146;
        } //End block
        catch (RemoteException e)
        {
            releaseProvider(provider);
Cursor var540C13E9E156B687226421B24F2DF178_693241744 =             null;
            var540C13E9E156B687226421B24F2DF178_693241744.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_693241744;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.851 -0400", hash_original_method = "741F25E5E9079F60798D64718B03495A", hash_generated_method = "D388F6C1BAE20D274AA72092F365AA19")
    public final InputStream openInputStream(Uri uri) throws FileNotFoundException {
        addTaint(uri.getTaint());
        String scheme = uri.getScheme();
    if(SCHEME_ANDROID_RESOURCE.equals(scheme))        
        {
            OpenResourceIdResult r = getResourceId(uri);
            try 
            {
                InputStream stream = r.r.openRawResource(r.id);
InputStream varA87CF74140B150613F4203E71875F9A7_923825011 =                 stream;
                varA87CF74140B150613F4203E71875F9A7_923825011.addTaint(taint);
                return varA87CF74140B150613F4203E71875F9A7_923825011;
            } //End block
            catch (Resources.NotFoundException ex)
            {
                FileNotFoundException varE8810E522D8B98FEF67E48EC052E3409_482340621 = new FileNotFoundException("Resource does not exist: " + uri);
                varE8810E522D8B98FEF67E48EC052E3409_482340621.addTaint(taint);
                throw varE8810E522D8B98FEF67E48EC052E3409_482340621;
            } //End block
        } //End block
        else
    if(SCHEME_FILE.equals(scheme))        
        {
InputStream varFC75AD1534DBFE0E739C82AC8780E884_806182662 =             new FileInputStream(uri.getPath());
            varFC75AD1534DBFE0E739C82AC8780E884_806182662.addTaint(taint);
            return varFC75AD1534DBFE0E739C82AC8780E884_806182662;
        } //End block
        else
        {
            AssetFileDescriptor fd = openAssetFileDescriptor(uri, "r");
            try 
            {
InputStream varBE141D4F2C9E7C9CF6C0202CDAF666BA_1713045059 =                 fd != null ? fd.createInputStream() : null;
                varBE141D4F2C9E7C9CF6C0202CDAF666BA_1713045059.addTaint(taint);
                return varBE141D4F2C9E7C9CF6C0202CDAF666BA_1713045059;
            } //End block
            catch (IOException e)
            {
                FileNotFoundException varE14CDFD965413CCD1DE03C3CE3B3937E_848864377 = new FileNotFoundException("Unable to create stream");
                varE14CDFD965413CCD1DE03C3CE3B3937E_848864377.addTaint(taint);
                throw varE14CDFD965413CCD1DE03C3CE3B3937E_848864377;
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.851 -0400", hash_original_method = "11A517824302FF0E2A744E48D03F81F2", hash_generated_method = "6AD567B2D9F81AF3935D39B76C1AA31B")
    public final OutputStream openOutputStream(Uri uri) throws FileNotFoundException {
        addTaint(uri.getTaint());
OutputStream varDAF18F351C752F1D03791D667017D5CB_1163845722 =         openOutputStream(uri, "w");
        varDAF18F351C752F1D03791D667017D5CB_1163845722.addTaint(taint);
        return varDAF18F351C752F1D03791D667017D5CB_1163845722;
        // ---------- Original Method ----------
        //return openOutputStream(uri, "w");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.852 -0400", hash_original_method = "99597D87D82436F243497E22352BC980", hash_generated_method = "573232C2A7B56CBA3316300681397786")
    public final OutputStream openOutputStream(Uri uri, String mode) throws FileNotFoundException {
        addTaint(mode.getTaint());
        addTaint(uri.getTaint());
        AssetFileDescriptor fd = openAssetFileDescriptor(uri, mode);
        try 
        {
OutputStream var9660A12712EE20E561E7EB86CAE36FCA_1008677926 =             fd != null ? fd.createOutputStream() : null;
            var9660A12712EE20E561E7EB86CAE36FCA_1008677926.addTaint(taint);
            return var9660A12712EE20E561E7EB86CAE36FCA_1008677926;
        } //End block
        catch (IOException e)
        {
            FileNotFoundException varE14CDFD965413CCD1DE03C3CE3B3937E_2123501041 = new FileNotFoundException("Unable to create stream");
            varE14CDFD965413CCD1DE03C3CE3B3937E_2123501041.addTaint(taint);
            throw varE14CDFD965413CCD1DE03C3CE3B3937E_2123501041;
        } //End block
        // ---------- Original Method ----------
        //AssetFileDescriptor fd = openAssetFileDescriptor(uri, mode);
        //try {
            //return fd != null ? fd.createOutputStream() : null;
        //} catch (IOException e) {
            //throw new FileNotFoundException("Unable to create stream");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.853 -0400", hash_original_method = "8C4F5C0648F37279A7BD3F73F68574C8", hash_generated_method = "1205589B100660EE94E53FA18A7B3106")
    public final ParcelFileDescriptor openFileDescriptor(Uri uri,
            String mode) throws FileNotFoundException {
        addTaint(mode.getTaint());
        addTaint(uri.getTaint());
        AssetFileDescriptor afd = openAssetFileDescriptor(uri, mode);
    if(afd == null)        
        {
ParcelFileDescriptor var540C13E9E156B687226421B24F2DF178_19150224 =             null;
            var540C13E9E156B687226421B24F2DF178_19150224.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_19150224;
        } //End block
    if(afd.getDeclaredLength() < 0)        
        {
ParcelFileDescriptor varA9AB8B7D15238800765F4158408BCDB4_606542588 =             afd.getParcelFileDescriptor();
            varA9AB8B7D15238800765F4158408BCDB4_606542588.addTaint(taint);
            return varA9AB8B7D15238800765F4158408BCDB4_606542588;
        } //End block
        try 
        {
            afd.close();
        } //End block
        catch (IOException e)
        {
        } //End block
        FileNotFoundException varCF2804E98D5BC3EED85EC79FB2F91971_754813410 = new FileNotFoundException("Not a whole file");
        varCF2804E98D5BC3EED85EC79FB2F91971_754813410.addTaint(taint);
        throw varCF2804E98D5BC3EED85EC79FB2F91971_754813410;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.854 -0400", hash_original_method = "6D0B2664AB85671E5A18996AE47F9088", hash_generated_method = "6DC7371F8680A0D74972EBB3EC02A7DA")
    public final AssetFileDescriptor openAssetFileDescriptor(Uri uri,
            String mode) throws FileNotFoundException {
        addTaint(mode.getTaint());
        addTaint(uri.getTaint());
        String scheme = uri.getScheme();
    if(SCHEME_ANDROID_RESOURCE.equals(scheme))        
        {
    if(!"r".equals(mode))            
            {
                FileNotFoundException var3E6E4698F2D2B39AC43F6148E6AB4CF6_2110425046 = new FileNotFoundException("Can't write resources: " + uri);
                var3E6E4698F2D2B39AC43F6148E6AB4CF6_2110425046.addTaint(taint);
                throw var3E6E4698F2D2B39AC43F6148E6AB4CF6_2110425046;
            } //End block
            OpenResourceIdResult r = getResourceId(uri);
            try 
            {
AssetFileDescriptor varF3583D388A196F6D98A374DDC1AD0113_1373486718 =                 r.r.openRawResourceFd(r.id);
                varF3583D388A196F6D98A374DDC1AD0113_1373486718.addTaint(taint);
                return varF3583D388A196F6D98A374DDC1AD0113_1373486718;
            } //End block
            catch (Resources.NotFoundException ex)
            {
                FileNotFoundException varE8810E522D8B98FEF67E48EC052E3409_953885800 = new FileNotFoundException("Resource does not exist: " + uri);
                varE8810E522D8B98FEF67E48EC052E3409_953885800.addTaint(taint);
                throw varE8810E522D8B98FEF67E48EC052E3409_953885800;
            } //End block
        } //End block
        else
    if(SCHEME_FILE.equals(scheme))        
        {
            ParcelFileDescriptor pfd = ParcelFileDescriptor.open(
                    new File(uri.getPath()), modeToMode(uri, mode));
AssetFileDescriptor var6BD93397E5DAF0DF17CE1C003D2FCAB6_846507032 =             new AssetFileDescriptor(pfd, 0, -1);
            var6BD93397E5DAF0DF17CE1C003D2FCAB6_846507032.addTaint(taint);
            return var6BD93397E5DAF0DF17CE1C003D2FCAB6_846507032;
        } //End block
        else
        {
    if("r".equals(mode))            
            {
AssetFileDescriptor var728978861F4263FCBEBDB0546FBED7DF_321288291 =                 openTypedAssetFileDescriptor(uri, "*/*", null);
                var728978861F4263FCBEBDB0546FBED7DF_321288291.addTaint(taint);
                return var728978861F4263FCBEBDB0546FBED7DF_321288291;
            } //End block
            else
            {
                IContentProvider provider = acquireProvider(uri);
    if(provider == null)                
                {
                    FileNotFoundException var40E2EE088A44F180C90D99DA40A11B6C_459740697 = new FileNotFoundException("No content provider: " + uri);
                    var40E2EE088A44F180C90D99DA40A11B6C_459740697.addTaint(taint);
                    throw var40E2EE088A44F180C90D99DA40A11B6C_459740697;
                } //End block
                try 
                {
                    AssetFileDescriptor fd = provider.openAssetFile(uri, mode);
    if(fd == null)                    
                    {
AssetFileDescriptor var540C13E9E156B687226421B24F2DF178_2040428357 =                         null;
                        var540C13E9E156B687226421B24F2DF178_2040428357.addTaint(taint);
                        return var540C13E9E156B687226421B24F2DF178_2040428357;
                    } //End block
                    ParcelFileDescriptor pfd = new ParcelFileDescriptorInner(
                            fd.getParcelFileDescriptor(), provider);
                    provider = null;
AssetFileDescriptor varC3C12411A882751F292369C906132F8B_607713455 =                     new AssetFileDescriptor(pfd, fd.getStartOffset(),
                            fd.getDeclaredLength());
                    varC3C12411A882751F292369C906132F8B_607713455.addTaint(taint);
                    return varC3C12411A882751F292369C906132F8B_607713455;
                } //End block
                catch (RemoteException e)
                {
                    FileNotFoundException varDBFDFCAA6D96C908D7FB1870DDC805CA_2125285302 = new FileNotFoundException("Dead content provider: " + uri);
                    varDBFDFCAA6D96C908D7FB1870DDC805CA_2125285302.addTaint(taint);
                    throw varDBFDFCAA6D96C908D7FB1870DDC805CA_2125285302;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.856 -0400", hash_original_method = "6625A014E29DF928853C1F0BC5B9E856", hash_generated_method = "D4993377D3FE827B22AC4FB8B28352C0")
    public final AssetFileDescriptor openTypedAssetFileDescriptor(Uri uri,
            String mimeType, Bundle opts) throws FileNotFoundException {
        addTaint(opts.getTaint());
        addTaint(mimeType.getTaint());
        addTaint(uri.getTaint());
        IContentProvider provider = acquireProvider(uri);
    if(provider == null)        
        {
            FileNotFoundException var40E2EE088A44F180C90D99DA40A11B6C_681199134 = new FileNotFoundException("No content provider: " + uri);
            var40E2EE088A44F180C90D99DA40A11B6C_681199134.addTaint(taint);
            throw var40E2EE088A44F180C90D99DA40A11B6C_681199134;
        } //End block
        try 
        {
            AssetFileDescriptor fd = provider.openTypedAssetFile(uri, mimeType, opts);
    if(fd == null)            
            {
AssetFileDescriptor var540C13E9E156B687226421B24F2DF178_17210999 =                 null;
                var540C13E9E156B687226421B24F2DF178_17210999.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_17210999;
            } //End block
            ParcelFileDescriptor pfd = new ParcelFileDescriptorInner(
                    fd.getParcelFileDescriptor(), provider);
            provider = null;
AssetFileDescriptor varC3C12411A882751F292369C906132F8B_1132828530 =             new AssetFileDescriptor(pfd, fd.getStartOffset(),
                    fd.getDeclaredLength());
            varC3C12411A882751F292369C906132F8B_1132828530.addTaint(taint);
            return varC3C12411A882751F292369C906132F8B_1132828530;
        } //End block
        catch (RemoteException e)
        {
            FileNotFoundException varDBFDFCAA6D96C908D7FB1870DDC805CA_634066464 = new FileNotFoundException("Dead content provider: " + uri);
            varDBFDFCAA6D96C908D7FB1870DDC805CA_634066464.addTaint(taint);
            throw varDBFDFCAA6D96C908D7FB1870DDC805CA_634066464;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.858 -0400", hash_original_method = "39DD117C1A4502740FE90592CCDD92D2", hash_generated_method = "7BE96DEBF0253B94A83A99ED1B50F977")
    public OpenResourceIdResult getResourceId(Uri uri) throws FileNotFoundException {
        addTaint(uri.getTaint());
        String authority = uri.getAuthority();
        Resources r;
    if(TextUtils.isEmpty(authority))        
        {
            FileNotFoundException var0ACC1320D5E87EB8AD60C20862242804_962653630 = new FileNotFoundException("No authority: " + uri);
            var0ACC1320D5E87EB8AD60C20862242804_962653630.addTaint(taint);
            throw var0ACC1320D5E87EB8AD60C20862242804_962653630;
        } //End block
        else
        {
            try 
            {
                r = mContext.getPackageManager().getResourcesForApplication(authority);
            } //End block
            catch (NameNotFoundException ex)
            {
                FileNotFoundException var9514FE02F5A5CA391BAA8E45C47116A7_1651240867 = new FileNotFoundException("No package found for authority: " + uri);
                var9514FE02F5A5CA391BAA8E45C47116A7_1651240867.addTaint(taint);
                throw var9514FE02F5A5CA391BAA8E45C47116A7_1651240867;
            } //End block
        } //End block
        List<String> path = uri.getPathSegments();
    if(path == null)        
        {
            FileNotFoundException varC69DFEC10B02FEAA78D67A2A187A7F19_1113164631 = new FileNotFoundException("No path: " + uri);
            varC69DFEC10B02FEAA78D67A2A187A7F19_1113164631.addTaint(taint);
            throw varC69DFEC10B02FEAA78D67A2A187A7F19_1113164631;
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
                FileNotFoundException varC22B934DA93E3FEDAA7C59017512810F_1273237365 = new FileNotFoundException("Single path segment is not a resource ID: " + uri);
                varC22B934DA93E3FEDAA7C59017512810F_1273237365.addTaint(taint);
                throw varC22B934DA93E3FEDAA7C59017512810F_1273237365;
            } //End block
        } //End block
        else
    if(len == 2)        
        {
            id = r.getIdentifier(path.get(1), path.get(0), authority);
        } //End block
        else
        {
            FileNotFoundException var5535C43DBB8176F250E03E36B76F22BA_67147442 = new FileNotFoundException("More than two path segments: " + uri);
            var5535C43DBB8176F250E03E36B76F22BA_67147442.addTaint(taint);
            throw var5535C43DBB8176F250E03E36B76F22BA_67147442;
        } //End block
    if(id == 0)        
        {
            FileNotFoundException var62897123492917248A6A32EE2FAC55C4_1578834877 = new FileNotFoundException("No resource found for: " + uri);
            var62897123492917248A6A32EE2FAC55C4_1578834877.addTaint(taint);
            throw var62897123492917248A6A32EE2FAC55C4_1578834877;
        } //End block
        OpenResourceIdResult res = new OpenResourceIdResult();
        res.r = r;
        res.id = id;
OpenResourceIdResult varB5053E025797B3BF768F5C37934C244D_743616632 =         res;
        varB5053E025797B3BF768F5C37934C244D_743616632.addTaint(taint);
        return varB5053E025797B3BF768F5C37934C244D_743616632;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.860 -0400", hash_original_method = "21049B5CF31214AC69662F00A8291DA2", hash_generated_method = "33C67E024B056CD97A7DFAC2D086BFA6")
    public final Uri insert(Uri url, ContentValues values) {
        addTaint(values.getTaint());
        addTaint(url.getTaint());
        IContentProvider provider = acquireProvider(url);
    if(provider == null)        
        {
            IllegalArgumentException varB20D676800D86334D5891F76F3E10503_1979170862 = new IllegalArgumentException("Unknown URL " + url);
            varB20D676800D86334D5891F76F3E10503_1979170862.addTaint(taint);
            throw varB20D676800D86334D5891F76F3E10503_1979170862;
        } //End block
        try 
        {
            long startTime = SystemClock.uptimeMillis();
            Uri createdRow = provider.insert(url, values);
            long durationMillis = SystemClock.uptimeMillis() - startTime;
            maybeLogUpdateToEventLog(durationMillis, url, "insert", null );
Uri var9668A06783A9113EEB45F2F771B856FB_1578758522 =             createdRow;
            var9668A06783A9113EEB45F2F771B856FB_1578758522.addTaint(taint);
            return var9668A06783A9113EEB45F2F771B856FB_1578758522;
        } //End block
        catch (RemoteException e)
        {
Uri var540C13E9E156B687226421B24F2DF178_1832718049 =             null;
            var540C13E9E156B687226421B24F2DF178_1832718049.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1832718049;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.872 -0400", hash_original_method = "35DA1841C97E840C3B5123B65D72A2FC", hash_generated_method = "7D26BF781D1ADAB096194EDDFB94933C")
    public ContentProviderResult[] applyBatch(String authority,
            ArrayList<ContentProviderOperation> operations) throws RemoteException, OperationApplicationException {
        addTaint(operations.getTaint());
        addTaint(authority.getTaint());
        ContentProviderClient provider = acquireContentProviderClient(authority);
    if(provider == null)        
        {
            IllegalArgumentException var00F727789A0A7DE88397D2B2A17A4577_671435610 = new IllegalArgumentException("Unknown authority " + authority);
            var00F727789A0A7DE88397D2B2A17A4577_671435610.addTaint(taint);
            throw var00F727789A0A7DE88397D2B2A17A4577_671435610;
        } //End block
        try 
        {
ContentProviderResult[] var7BE4D9098231AED0DF2F567E54B89316_1830177843 =             provider.applyBatch(operations);
            var7BE4D9098231AED0DF2F567E54B89316_1830177843.addTaint(taint);
            return var7BE4D9098231AED0DF2F567E54B89316_1830177843;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.872 -0400", hash_original_method = "B00B6610FA17409048836C33B1F1B82B", hash_generated_method = "DDF3693782D28B5911D9340EC94ACA65")
    public final int bulkInsert(Uri url, ContentValues[] values) {
        addTaint(values[0].getTaint());
        addTaint(url.getTaint());
        IContentProvider provider = acquireProvider(url);
    if(provider == null)        
        {
            IllegalArgumentException varB20D676800D86334D5891F76F3E10503_1919276014 = new IllegalArgumentException("Unknown URL " + url);
            varB20D676800D86334D5891F76F3E10503_1919276014.addTaint(taint);
            throw varB20D676800D86334D5891F76F3E10503_1919276014;
        } //End block
        try 
        {
            long startTime = SystemClock.uptimeMillis();
            int rowsCreated = provider.bulkInsert(url, values);
            long durationMillis = SystemClock.uptimeMillis() - startTime;
            maybeLogUpdateToEventLog(durationMillis, url, "bulkinsert", null );
            int var4C909CBC1D72D91EDE3440CE60EF064F_171354250 = (rowsCreated);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1058548434 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1058548434;
        } //End block
        catch (RemoteException e)
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_1400072122 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1593050646 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1593050646;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.873 -0400", hash_original_method = "5F64E7642550035A4284C543DD08EBF1", hash_generated_method = "969F0C7CC1AC622435C09D0457755AC3")
    public final int delete(Uri url, String where, String[] selectionArgs) {
        addTaint(selectionArgs[0].getTaint());
        addTaint(where.getTaint());
        addTaint(url.getTaint());
        IContentProvider provider = acquireProvider(url);
    if(provider == null)        
        {
            IllegalArgumentException varB20D676800D86334D5891F76F3E10503_935567557 = new IllegalArgumentException("Unknown URL " + url);
            varB20D676800D86334D5891F76F3E10503_935567557.addTaint(taint);
            throw varB20D676800D86334D5891F76F3E10503_935567557;
        } //End block
        try 
        {
            long startTime = SystemClock.uptimeMillis();
            int rowsDeleted = provider.delete(url, where, selectionArgs);
            long durationMillis = SystemClock.uptimeMillis() - startTime;
            maybeLogUpdateToEventLog(durationMillis, url, "delete", where);
            int var9FA48E40266055B7DB16BBDBD5D3D301_668304250 = (rowsDeleted);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_302074008 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_302074008;
        } //End block
        catch (RemoteException e)
        {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_2109874494 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_19876905 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_19876905;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.873 -0400", hash_original_method = "93173B163A2993B2278E9CE2CA5F5268", hash_generated_method = "F384023A936CCF622A13A550AE4E9BE4")
    public final int update(Uri uri, ContentValues values, String where,
            String[] selectionArgs) {
        addTaint(selectionArgs[0].getTaint());
        addTaint(where.getTaint());
        addTaint(values.getTaint());
        addTaint(uri.getTaint());
        IContentProvider provider = acquireProvider(uri);
    if(provider == null)        
        {
            IllegalArgumentException var777AC27F236FED626942221893EC6521_1345923831 = new IllegalArgumentException("Unknown URI " + uri);
            var777AC27F236FED626942221893EC6521_1345923831.addTaint(taint);
            throw var777AC27F236FED626942221893EC6521_1345923831;
        } //End block
        try 
        {
            long startTime = SystemClock.uptimeMillis();
            int rowsUpdated = provider.update(uri, values, where, selectionArgs);
            long durationMillis = SystemClock.uptimeMillis() - startTime;
            maybeLogUpdateToEventLog(durationMillis, uri, "update", where);
            int var83251BA8F1A3D90F0CA5ADFF60F0D3C0_1370738085 = (rowsUpdated);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1427111373 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1427111373;
        } //End block
        catch (RemoteException e)
        {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_1529194522 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_395004784 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_395004784;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.874 -0400", hash_original_method = "7B97BF1D704BA5CFE2C56D2F21EF49E5", hash_generated_method = "C2FDF609B1C97C11303C0BCF71603FAA")
    public final Bundle call(Uri uri, String method, String arg, Bundle extras) {
        addTaint(extras.getTaint());
        addTaint(arg.getTaint());
        addTaint(method.getTaint());
        addTaint(uri.getTaint());
    if(uri == null)        
        {
            NullPointerException var1D3C31C9903C19A5E960BD20D3C05D23_91560179 = new NullPointerException("uri == null");
            var1D3C31C9903C19A5E960BD20D3C05D23_91560179.addTaint(taint);
            throw var1D3C31C9903C19A5E960BD20D3C05D23_91560179;
        } //End block
    if(method == null)        
        {
            NullPointerException var94DAF527A0B47AA6ECA3C5A76418A86A_624817079 = new NullPointerException("method == null");
            var94DAF527A0B47AA6ECA3C5A76418A86A_624817079.addTaint(taint);
            throw var94DAF527A0B47AA6ECA3C5A76418A86A_624817079;
        } //End block
        IContentProvider provider = acquireProvider(uri);
    if(provider == null)        
        {
            IllegalArgumentException var777AC27F236FED626942221893EC6521_228748972 = new IllegalArgumentException("Unknown URI " + uri);
            var777AC27F236FED626942221893EC6521_228748972.addTaint(taint);
            throw var777AC27F236FED626942221893EC6521_228748972;
        } //End block
        try 
        {
Bundle var5782F784778F2F0CFC89129DC58C9724_856374543 =             provider.call(method, arg, extras);
            var5782F784778F2F0CFC89129DC58C9724_856374543.addTaint(taint);
            return var5782F784778F2F0CFC89129DC58C9724_856374543;
        } //End block
        catch (RemoteException e)
        {
Bundle var540C13E9E156B687226421B24F2DF178_1615983515 =             null;
            var540C13E9E156B687226421B24F2DF178_1615983515.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1615983515;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.874 -0400", hash_original_method = "337E4492D27C715A525AA87619808C6B", hash_generated_method = "D7F468D6E17FCD2CD6978836D1B8D88B")
    public final IContentProvider acquireProvider(Uri uri) {
        addTaint(uri.getTaint());
    if(!SCHEME_CONTENT.equals(uri.getScheme()))        
        {
IContentProvider var540C13E9E156B687226421B24F2DF178_1276571115 =             null;
            var540C13E9E156B687226421B24F2DF178_1276571115.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1276571115;
        } //End block
        String auth = uri.getAuthority();
    if(auth != null)        
        {
IContentProvider var4780BBFCDBD9BFF14B667AD7D8AB9F81_1173108498 =             acquireProvider(mContext, uri.getAuthority());
            var4780BBFCDBD9BFF14B667AD7D8AB9F81_1173108498.addTaint(taint);
            return var4780BBFCDBD9BFF14B667AD7D8AB9F81_1173108498;
        } //End block
IContentProvider var540C13E9E156B687226421B24F2DF178_868430379 =         null;
        var540C13E9E156B687226421B24F2DF178_868430379.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_868430379;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.874 -0400", hash_original_method = "C657A24801BE240D39C6FCA466A49DFE", hash_generated_method = "9E128D4C7B896506D6E26FD195670FDB")
    public final IContentProvider acquireExistingProvider(Uri uri) {
        addTaint(uri.getTaint());
    if(!SCHEME_CONTENT.equals(uri.getScheme()))        
        {
IContentProvider var540C13E9E156B687226421B24F2DF178_738956029 =             null;
            var540C13E9E156B687226421B24F2DF178_738956029.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_738956029;
        } //End block
        String auth = uri.getAuthority();
    if(auth != null)        
        {
IContentProvider var35C8142F5E07DC5EB04C3A6752979CAB_1683741530 =             acquireExistingProvider(mContext, uri.getAuthority());
            var35C8142F5E07DC5EB04C3A6752979CAB_1683741530.addTaint(taint);
            return var35C8142F5E07DC5EB04C3A6752979CAB_1683741530;
        } //End block
IContentProvider var540C13E9E156B687226421B24F2DF178_1071231178 =         null;
        var540C13E9E156B687226421B24F2DF178_1071231178.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1071231178;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.875 -0400", hash_original_method = "1419B9D62800705D7AC72C916BD8939A", hash_generated_method = "07A9FFA778BE737D9C322662BFBB28EC")
    public final IContentProvider acquireProvider(String name) {
        addTaint(name.getTaint());
    if(name == null)        
        {
IContentProvider var540C13E9E156B687226421B24F2DF178_1303159298 =             null;
            var540C13E9E156B687226421B24F2DF178_1303159298.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1303159298;
        } //End block
IContentProvider varAF2FF65A41417D63A0BC223C355F9263_1632168650 =         acquireProvider(mContext, name);
        varAF2FF65A41417D63A0BC223C355F9263_1632168650.addTaint(taint);
        return varAF2FF65A41417D63A0BC223C355F9263_1632168650;
        // ---------- Original Method ----------
        //if (name == null) {
            //return null;
        //}
        //return acquireProvider(mContext, name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.875 -0400", hash_original_method = "5741247DD17162DA82750F730CE6B9A7", hash_generated_method = "5EE0E4AE37F1A1319083133E70BDB7C9")
    public final ContentProviderClient acquireContentProviderClient(Uri uri) {
        addTaint(uri.getTaint());
        IContentProvider provider = acquireProvider(uri);
    if(provider != null)        
        {
ContentProviderClient var01598678913D3029A3BDD994E3BED651_86422891 =             new ContentProviderClient(this, provider);
            var01598678913D3029A3BDD994E3BED651_86422891.addTaint(taint);
            return var01598678913D3029A3BDD994E3BED651_86422891;
        } //End block
ContentProviderClient var540C13E9E156B687226421B24F2DF178_739252854 =         null;
        var540C13E9E156B687226421B24F2DF178_739252854.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_739252854;
        // ---------- Original Method ----------
        //IContentProvider provider = acquireProvider(uri);
        //if (provider != null) {
            //return new ContentProviderClient(this, provider);
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.876 -0400", hash_original_method = "01901AA9613048A3AC98A39C9DD35CAC", hash_generated_method = "EFF2B86EDE7B0F0B674FBA2EAC3DAA97")
    public final ContentProviderClient acquireContentProviderClient(String name) {
        addTaint(name.getTaint());
        IContentProvider provider = acquireProvider(name);
    if(provider != null)        
        {
ContentProviderClient var01598678913D3029A3BDD994E3BED651_500566107 =             new ContentProviderClient(this, provider);
            var01598678913D3029A3BDD994E3BED651_500566107.addTaint(taint);
            return var01598678913D3029A3BDD994E3BED651_500566107;
        } //End block
ContentProviderClient var540C13E9E156B687226421B24F2DF178_1382752123 =         null;
        var540C13E9E156B687226421B24F2DF178_1382752123.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1382752123;
        // ---------- Original Method ----------
        //IContentProvider provider = acquireProvider(name);
        //if (provider != null) {
            //return new ContentProviderClient(this, provider);
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.876 -0400", hash_original_method = "7AFED95A5C5E44717133ED415B77A63B", hash_generated_method = "9DE77D376ACF62E5953DA806A02FAC8A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.876 -0400", hash_original_method = "A19276E2B38D6FC8E7769343C0EFAA57", hash_generated_method = "426ECF19D7408595EA2CDC278553BBC6")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.876 -0400", hash_original_method = "E76834C8ABF23847CEBC5965503FC8D5", hash_generated_method = "841332F3B587E937B98F5F76F4A75E19")
    public void notifyChange(Uri uri, ContentObserver observer) {
        addTaint(observer.getTaint());
        addTaint(uri.getTaint());
        notifyChange(uri, observer, true );
        // ---------- Original Method ----------
        //notifyChange(uri, observer, true );
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.877 -0400", hash_original_method = "F301FE1DDD6CC7648C7F98CD4F863542", hash_generated_method = "4834D3929F315BCA26B25893BA189E3F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.877 -0400", hash_original_method = "2D6405030D787F1D91AFA94E2D425989", hash_generated_method = "8FD49EB480C67F13739811857A7B4F54")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.877 -0400", hash_original_method = "B4949CE6FC68B3756629FF654EA4F622", hash_generated_method = "98293DACBF37DC3FB629FF105B0B9357")
    @Deprecated
    public void cancelSync(Uri uri) {
        addTaint(uri.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.884 -0400", hash_original_method = "5964C3B3CD446EC6DF12ED3CA7F7D861", hash_generated_method = "C659274096F9AC7272B2DBC099B49078")
    private int samplePercentForDuration(long durationMillis) {
        addTaint(durationMillis);
    if(durationMillis >= SLOW_THRESHOLD_MILLIS)        
        {
            int varF899139DF5E1059396431415E770C6DD_1693107741 = (100);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_711667177 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_711667177;
        } //End block
        int var5B4DF0029359ED92E7958806B4562BD7_1912167389 = ((int) (100 * durationMillis / SLOW_THRESHOLD_MILLIS) + 1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2127661893 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2127661893;
        // ---------- Original Method ----------
        //if (durationMillis >= SLOW_THRESHOLD_MILLIS) {
            //return 100;
        //}
        //return (int) (100 * durationMillis / SLOW_THRESHOLD_MILLIS) + 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.885 -0400", hash_original_method = "339BAFB8AA6EDB4FDC193A187E8B0067", hash_generated_method = "9BD6BF415ED84B3DEA2AD9DAD6E0E3D7")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.885 -0400", hash_original_method = "8C4CA0C0E96B47F9D6365343066B43C9", hash_generated_method = "3C5109E1FC653AE1DDDF530D6B2D1689")
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.885 -0400", hash_original_field = "4B43B0AEE35624CD95B910189B3DC231", hash_generated_field = "3D94ED8234243D4DE3F50EF6E646D0E3")

        public Resources r;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.885 -0400", hash_original_field = "B80BB7740288FDA1F201890375A60C8F", hash_generated_field = "FA0A3841DE31A9B4AD2F31B3665056D8")

        public int id;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.886 -0400", hash_original_method = "EC7BB03A160C6C88DBB9DFBF62B48748", hash_generated_method = "EC7BB03A160C6C88DBB9DFBF62B48748")
        public OpenResourceIdResult ()
        {
            //Synthesized constructor
        }


    }


    
    private final class CursorWrapperInner extends CrossProcessCursorWrapper {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.886 -0400", hash_original_field = "4AB176078152082D060487A305BE9F63", hash_generated_field = "B614D226FB5223D135A9D332098A34A4")

        private IContentProvider mContentProvider;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.886 -0400", hash_original_field = "FAB63045DAC8675C1DE9648413C0413D", hash_generated_field = "91705AACD6DDE42AEA628776AF2A3DC6")

        private final CloseGuard mCloseGuard = CloseGuard.get();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.886 -0400", hash_original_field = "73EB2A2C6C3CC1E8C72EB379571EB098", hash_generated_field = "FF245C536DEFD57B2DCDAA00E8BC192F")

        private boolean mProviderReleased;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.886 -0400", hash_original_method = "33833BC2FFA324FE6B3A882C16B09B24", hash_generated_method = "C6AA7649F1C765F90DC41AF7D2C26B43")
          CursorWrapperInner(Cursor cursor, IContentProvider icp) {
            super(cursor);
            addTaint(cursor.getTaint());
            mContentProvider = icp;
            mCloseGuard.open("close");
            // ---------- Original Method ----------
            //mContentProvider = icp;
            //mCloseGuard.open("close");
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.886 -0400", hash_original_method = "CB76115716387DD39854EA1927F29C52", hash_generated_method = "461D5BB19C18033D953C4676F5B1721B")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.887 -0400", hash_original_method = "C6F30BD2AC97CE59E2F19D89687C7506", hash_generated_method = "F268146468AFC07C9440E2C5CA696212")
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.887 -0400", hash_original_field = "13FB907F06B05F7137165C185CBCE3C3", hash_generated_field = "EACA88E7B01FC8694B38FD93BBF3A6CA")

        public static final String TAG="CursorWrapperInner";
    }


    
    private final class ParcelFileDescriptorInner extends ParcelFileDescriptor {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.887 -0400", hash_original_field = "4AB176078152082D060487A305BE9F63", hash_generated_field = "B614D226FB5223D135A9D332098A34A4")

        private IContentProvider mContentProvider;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.887 -0400", hash_original_field = "AC321E1C1B8C101F950B583BC403E782", hash_generated_field = "DCC2C4F00C9417AA6FB57200F6F6249D")

        private boolean mReleaseProviderFlag = false;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.887 -0400", hash_original_method = "84882D259A9B741E8CCE8DBD7345B8D5", hash_generated_method = "2F238FD9AF5C3F8E4BF284D0C0C0770E")
          ParcelFileDescriptorInner(ParcelFileDescriptor pfd, IContentProvider icp) {
            super(pfd);
            addTaint(pfd.getTaint());
            mContentProvider = icp;
            // ---------- Original Method ----------
            //mContentProvider = icp;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.887 -0400", hash_original_method = "88C4FC226DB7C9E08A0225C4D4C037C0", hash_generated_method = "2931B14EB0C4E940924437ADC26E5475")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.888 -0400", hash_original_method = "E5C83F24E1B33F16225B47651FBE1E16", hash_generated_method = "BB9D5FCD4BE1CF73267E1BB6EFE05F92")
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.888 -0400", hash_original_field = "CB7B93CDAC708AECA662EC86F82451BD", hash_generated_field = "853BAF17ACDDF73D9A8E686A803B9543")

        public static final String TAG="ParcelFileDescriptorInner";
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.888 -0400", hash_original_field = "C2EDFC92CCF8B16E3533DCFADC264E23", hash_generated_field = "87B095273B7680C6E8D776FD7BED0443")

    @Deprecated
    public static final String SYNC_EXTRAS_ACCOUNT = "account";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.888 -0400", hash_original_field = "9A7319143C3370C3B9F862CE740B5B75", hash_generated_field = "8B7D39A0706705FDAF94593ED0FACFEA")

    public static final String SYNC_EXTRAS_EXPEDITED = "expedited";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.888 -0400", hash_original_field = "0C5ED6B0AA55903B1B309BC3AE9C1AC5", hash_generated_field = "52C4CBE6F8AFC4D6C338F6272437F588")

    @Deprecated
    public static final String SYNC_EXTRAS_FORCE = "force";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.888 -0400", hash_original_field = "7BF6732A8AD149D6BF72E2CEB933EAEC", hash_generated_field = "9CB83B5127CA25B88446759FC78BB810")

    public static final String SYNC_EXTRAS_IGNORE_SETTINGS = "ignore_settings";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.888 -0400", hash_original_field = "48D105EF39F24B3ED276155D8F366FAD", hash_generated_field = "2460C39D3F3C8C8E9A6CA2DB50888065")

    public static final String SYNC_EXTRAS_IGNORE_BACKOFF = "ignore_backoff";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.888 -0400", hash_original_field = "BD3F4206E2333EE4EC1C44D083DBDDD9", hash_generated_field = "FB3D46B8F0404EBA4D41256EFCE69610")

    public static final String SYNC_EXTRAS_DO_NOT_RETRY = "do_not_retry";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.888 -0400", hash_original_field = "81C2869721D54621C1E9EBBF388E766C", hash_generated_field = "2CB777FABA87110DA15F0AAAA5216B13")

    public static final String SYNC_EXTRAS_MANUAL = "force";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.888 -0400", hash_original_field = "2627674F99971004D823BB1DC0D4AD30", hash_generated_field = "C66AD9A9054789246D88C3CEF49E0FE1")

    public static final String SYNC_EXTRAS_UPLOAD = "upload";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.888 -0400", hash_original_field = "2DB15BFAA122A6E4C8E09D40E27DE3A2", hash_generated_field = "085DFE00F23ABC519407289B800B9330")

    public static final String SYNC_EXTRAS_OVERRIDE_TOO_MANY_DELETIONS = "deletions_override";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.889 -0400", hash_original_field = "C93C475906837EA8C1231337BD9580CD", hash_generated_field = "A3280C9121A39AB92BFE4613E22A9F10")

    public static final String SYNC_EXTRAS_DISCARD_LOCAL_DELETIONS = "discard_deletions";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.889 -0400", hash_original_field = "F7B81FFD29F1E27E81F42B4EAF4745EB", hash_generated_field = "9A51FA040B5EE450933873F1925571E2")

    public static final String SYNC_EXTRAS_INITIALIZE = "initialize";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.889 -0400", hash_original_field = "B9EC534A4D635B10BE9040DF27185A80", hash_generated_field = "2A050A80E7005A896641161E25801F35")

    public static final String SCHEME_CONTENT = "content";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.889 -0400", hash_original_field = "F438C67F57FF4A50EDA09593EBEF286A", hash_generated_field = "7BECC35C4D527BA52EC58C833FB0BB34")

    public static final String SCHEME_ANDROID_RESOURCE = "android.resource";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.889 -0400", hash_original_field = "02F0EE6F8DEEBB0D5DCDD1E064DAC005", hash_generated_field = "D24B6CC01AD3F5B91B2CFC56B92A6E03")

    public static final String SCHEME_FILE = "file";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.889 -0400", hash_original_field = "893D0280FDFF6A2950856B98E73C71C1", hash_generated_field = "A41DFC918AF8E5D466EE8DAB0BF274F3")

    public static final String CURSOR_ITEM_BASE_TYPE = "vnd.android.cursor.item";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.889 -0400", hash_original_field = "95AED60F9A6BBB9F889EF813B7143610", hash_generated_field = "2D7AE2632599144DAA81BD08B4C8870E")

    public static final String CURSOR_DIR_BASE_TYPE = "vnd.android.cursor.dir";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.889 -0400", hash_original_field = "78541B0F3CCE1FAC3BA266FCB7621070", hash_generated_field = "F78FAC8C90BCAD8994706D8A7F584B12")

    public static final int SYNC_ERROR_SYNC_ALREADY_IN_PROGRESS = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.889 -0400", hash_original_field = "B72A154B591BAC40AEEF38C8E42F3335", hash_generated_field = "70645C1513ABFE107B9AF0BCB3F68340")

    public static final int SYNC_ERROR_AUTHENTICATION = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.889 -0400", hash_original_field = "FDA99AB14533C63BBCCA0F64BB7CF769", hash_generated_field = "2B1BA46E87D9EA52416FF82A7E9FC949")

    public static final int SYNC_ERROR_IO = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.889 -0400", hash_original_field = "CCA53EB6D8F9D64BE4EE63C66A08F236", hash_generated_field = "7D02506C7CBA10BD97CA79FB59DD9D15")

    public static final int SYNC_ERROR_PARSE = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.889 -0400", hash_original_field = "296A74F9B6DA67DDD9E8F0428AD3FFE0", hash_generated_field = "A315DAC0C98347D6DCFC6C6B32DA70BD")

    public static final int SYNC_ERROR_CONFLICT = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.889 -0400", hash_original_field = "83F48894C7BA225F7124ABDE5C0665CF", hash_generated_field = "76FE33D22783EC3D4779B2B73BE75DE9")

    public static final int SYNC_ERROR_TOO_MANY_DELETIONS = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.889 -0400", hash_original_field = "80FB09ABFBCC98D6C5E978E238B95658", hash_generated_field = "6E9809F790E5D29754E07F710C703033")

    public static final int SYNC_ERROR_TOO_MANY_RETRIES = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.890 -0400", hash_original_field = "BA70D22939E01C21C5AF2B587BFF152B", hash_generated_field = "9EF2EEC53560FF1A3EC43F81D719B306")

    public static final int SYNC_ERROR_INTERNAL = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.890 -0400", hash_original_field = "8F1E898EBD09004F8E52103FC8644049", hash_generated_field = "EC6D4E9079B435808FB02F42CC269B78")

    public static final int SYNC_OBSERVER_TYPE_SETTINGS = 1<<0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.890 -0400", hash_original_field = "45C5DD980F4A16E404292643A35A6433", hash_generated_field = "1F0C3937881F3FCFBF4E76673AB2169B")

    public static final int SYNC_OBSERVER_TYPE_PENDING = 1<<1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.890 -0400", hash_original_field = "2221A2B9CE572B6E501D97785FB05A8A", hash_generated_field = "0BBCE1310F4889E0CE3EBE1A843B06EC")

    public static final int SYNC_OBSERVER_TYPE_ACTIVE = 1<<2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.890 -0400", hash_original_field = "CBAD71B90CEF719A1DDEE4D9537EE9EF", hash_generated_field = "F118FAF287C6D65262857F494C71AFCE")

    public static final int SYNC_OBSERVER_TYPE_STATUS = 1<<3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.890 -0400", hash_original_field = "07D2AB9D80429D5E6907CE4783188520", hash_generated_field = "4285FF406FEA88E6536E37E5D6191611")

    public static final int SYNC_OBSERVER_TYPE_ALL = 0x7fffffff;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.890 -0400", hash_original_field = "5D2D67A3ADE9055680B54E64B5B18AF7", hash_generated_field = "48FEA35E2DFEE1057404A05E365FED9C")

    private static final int SLOW_THRESHOLD_MILLIS = 500;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.890 -0400", hash_original_field = "9664C3A1DEBAEE31270D6C126FBE59B7", hash_generated_field = "061BD03196A426FD4F175A19E9881E10")

    public static final String CONTENT_SERVICE_NAME = "content";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.890 -0400", hash_original_field = "0000B7DC2B7CEFF37F9F07EB8F63EAB2", hash_generated_field = "EBBA89635D26FA830DBE060ABCA948AD")

    private static IContentService sContentService;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.890 -0400", hash_original_field = "28B0C9DBF8E70FA0509AB8A6C9A3F293", hash_generated_field = "2E4D905723B5A2539B6E57BF8A2185DE")

    private static final String TAG = "ContentResolver";
}

