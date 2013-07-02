package android.app;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ComponentInfo;
import android.content.pm.FeatureInfo;
import android.content.pm.IPackageDataObserver;
import android.content.pm.IPackageDeleteObserver;
import android.content.pm.IPackageInstallObserver;
import android.content.pm.IPackageManager;
import android.content.pm.IPackageMoveObserver;
import android.content.pm.IPackageStatsObserver;
import android.content.pm.InstrumentationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ParceledListSlice;
import android.content.pm.PermissionGroupInfo;
import android.content.pm.PermissionInfo;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.pm.UserInfo;
import android.content.pm.ManifestDigest;
import android.content.pm.VerifierDeviceIdentity;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Process;
import android.os.RemoteException;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

final class ApplicationPackageManager extends PackageManager {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.478 -0400", hash_original_field = "D582EAEF778B662187C3776F3BC85DE5", hash_generated_field = "BB74ADCE9FCE390733990F175981A8B2")

    int mCachedSafeMode = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.479 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "9848C26EA3B1FE04FDB0411428C18F0B")

    private ContextImpl mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.479 -0400", hash_original_field = "3D87516393C6B091D0B0E6C38455BD37", hash_generated_field = "7F4B9DC825AA12542DFD4F441E873557")

    private IPackageManager mPM;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.479 -0400", hash_original_method = "12FC21630330363415BEFB2BB747FDD4", hash_generated_method = "821E283AA9F20FD120BA751A1DBB238D")
      ApplicationPackageManager(ContextImpl context,
                              IPackageManager pm) {
        mContext = context;
        mPM = pm;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.481 -0400", hash_original_method = "B0DADC2DBFEC092F753C36E8DEB385A1", hash_generated_method = "BD7241B1894D7940C5B5899F7A5E7385")
    @Override
    public PackageInfo getPackageInfo(String packageName, int flags) throws NameNotFoundException {
        PackageInfo varB4EAC82CA7396A68D541C85D26508E83_1309188198 = null; 
        try 
        {
            PackageInfo pi = mPM.getPackageInfo(packageName, flags);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1309188198 = pi;
            } 
        } 
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } 
        if (DroidSafeAndroidRuntime.control) throw new NameNotFoundException(packageName);
        addTaint(packageName.getTaint());
        addTaint(flags);
        varB4EAC82CA7396A68D541C85D26508E83_1309188198.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1309188198;
        
        
            
            
                
            
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.482 -0400", hash_original_method = "C5CDEAB4FF073C2ACB7E7915B56F1D0F", hash_generated_method = "4C8E946F2BF467CFCBB822B270E9C311")
    @Override
    public String[] currentToCanonicalPackageNames(String[] names) {
        String[] varB4EAC82CA7396A68D541C85D26508E83_497464883 = null; 
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_497464883 = mPM.currentToCanonicalPackageNames(names);
        } 
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } 
        addTaint(names[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_497464883.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_497464883;
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.484 -0400", hash_original_method = "9BD980F14E9EC05077595EA826722236", hash_generated_method = "72035CFD7061A25C56007FEBDEA46D92")
    @Override
    public String[] canonicalToCurrentPackageNames(String[] names) {
        String[] varB4EAC82CA7396A68D541C85D26508E83_1683411653 = null; 
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1683411653 = mPM.canonicalToCurrentPackageNames(names);
        } 
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } 
        addTaint(names[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1683411653.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1683411653;
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.486 -0400", hash_original_method = "A679E3857CF73FF4B9C2EA4F09C7DBB7", hash_generated_method = "5AC91BBF6A67A69FA67BAF31CB72E5DB")
    @Override
    public Intent getLaunchIntentForPackage(String packageName) {
        Intent varB4EAC82CA7396A68D541C85D26508E83_2021843061 = null; 
        Intent varB4EAC82CA7396A68D541C85D26508E83_1507909222 = null; 
        Intent intentToResolve = new Intent(Intent.ACTION_MAIN);
        intentToResolve.addCategory(Intent.CATEGORY_INFO);
        intentToResolve.setPackage(packageName);
        List<ResolveInfo> ris = queryIntentActivities(intentToResolve, 0);
        {
            boolean varBFFD11AFF4B06D0E1D653A2E50FC1BFF_785411520 = (ris == null || ris.size() <= 0);
            {
                intentToResolve.removeCategory(Intent.CATEGORY_INFO);
                intentToResolve.addCategory(Intent.CATEGORY_LAUNCHER);
                intentToResolve.setPackage(packageName);
                ris = queryIntentActivities(intentToResolve, 0);
            } 
        } 
        {
            boolean varBFFD11AFF4B06D0E1D653A2E50FC1BFF_1700408526 = (ris == null || ris.size() <= 0);
            {
                varB4EAC82CA7396A68D541C85D26508E83_2021843061 = null;
            } 
        } 
        Intent intent = new Intent(intentToResolve);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setClassName(ris.get(0).activityInfo.packageName,
                ris.get(0).activityInfo.name);
        varB4EAC82CA7396A68D541C85D26508E83_1507909222 = intent;
        addTaint(packageName.getTaint());
        Intent varA7E53CE21691AB073D9660D615818899_1263383625; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1263383625 = varB4EAC82CA7396A68D541C85D26508E83_2021843061;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1263383625 = varB4EAC82CA7396A68D541C85D26508E83_1507909222;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1263383625.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1263383625;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.487 -0400", hash_original_method = "65CBA80193594BC7AC8CBF648823BDBA", hash_generated_method = "3353B64B17ADE65226808B2CD4BDCE69")
    @Override
    public int[] getPackageGids(String packageName) throws NameNotFoundException {
        try 
        {
            int[] gids = mPM.getPackageGids(packageName);
        } 
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } 
        if (DroidSafeAndroidRuntime.control) throw new NameNotFoundException(packageName);
        addTaint(packageName.getTaint());
        int[] varB4CCCA26F9DB9189C32F33E82D425CFB_1718005966 = {getTaintInt()};
        return varB4CCCA26F9DB9189C32F33E82D425CFB_1718005966;
        
        
            
            
                
            
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.488 -0400", hash_original_method = "16E2B9223A8B92626D3604D0E58E2278", hash_generated_method = "235D6D1D3DB7CD731365218439535C11")
    @Override
    public PermissionInfo getPermissionInfo(String name, int flags) throws NameNotFoundException {
        PermissionInfo varB4EAC82CA7396A68D541C85D26508E83_1992211085 = null; 
        try 
        {
            PermissionInfo pi = mPM.getPermissionInfo(name, flags);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1992211085 = pi;
            } 
        } 
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } 
        if (DroidSafeAndroidRuntime.control) throw new NameNotFoundException(name);
        addTaint(name.getTaint());
        addTaint(flags);
        varB4EAC82CA7396A68D541C85D26508E83_1992211085.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1992211085;
        
        
            
            
                
            
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.489 -0400", hash_original_method = "2283AA5BDEF3F8B3341260BB74FBE8C3", hash_generated_method = "B61C59E6153FCD04549D1DC69D2364FB")
    @Override
    public List<PermissionInfo> queryPermissionsByGroup(String group, int flags) throws NameNotFoundException {
        List<PermissionInfo> varB4EAC82CA7396A68D541C85D26508E83_906466885 = null; 
        try 
        {
            List<PermissionInfo> pi = mPM.queryPermissionsByGroup(group, flags);
            {
                varB4EAC82CA7396A68D541C85D26508E83_906466885 = pi;
            } 
        } 
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } 
        if (DroidSafeAndroidRuntime.control) throw new NameNotFoundException(group);
        addTaint(group.getTaint());
        addTaint(flags);
        varB4EAC82CA7396A68D541C85D26508E83_906466885.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_906466885;
        
        
            
            
                
            
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.490 -0400", hash_original_method = "4E576FD7FE2DDB9674E042581657631F", hash_generated_method = "AA7FE72EA5BD76676793B39CE355BE6C")
    @Override
    public PermissionGroupInfo getPermissionGroupInfo(String name,
                                                      int flags) throws NameNotFoundException {
        PermissionGroupInfo varB4EAC82CA7396A68D541C85D26508E83_314870164 = null; 
        try 
        {
            PermissionGroupInfo pgi = mPM.getPermissionGroupInfo(name, flags);
            {
                varB4EAC82CA7396A68D541C85D26508E83_314870164 = pgi;
            } 
        } 
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } 
        if (DroidSafeAndroidRuntime.control) throw new NameNotFoundException(name);
        addTaint(name.getTaint());
        addTaint(flags);
        varB4EAC82CA7396A68D541C85D26508E83_314870164.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_314870164;
        
        
            
            
                
            
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.492 -0400", hash_original_method = "DD7F1EBA9089D82A0EEA68FDD3DACC66", hash_generated_method = "A5542289AE4DD70598FC0CC45441E5DE")
    @Override
    public List<PermissionGroupInfo> getAllPermissionGroups(int flags) {
        List<PermissionGroupInfo> varB4EAC82CA7396A68D541C85D26508E83_453168436 = null; 
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_453168436 = mPM.getAllPermissionGroups(flags);
        } 
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } 
        addTaint(flags);
        varB4EAC82CA7396A68D541C85D26508E83_453168436.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_453168436;
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.496 -0400", hash_original_method = "8999420BFE5728B346477621EA154ABF", hash_generated_method = "B96904CEE0F02B72DDBDBE65114E6DA9")
    @Override
    public ApplicationInfo getApplicationInfo(String packageName, int flags) throws NameNotFoundException {
        ApplicationInfo varB4EAC82CA7396A68D541C85D26508E83_1829910651 = null; 
        try 
        {
            ApplicationInfo ai = mPM.getApplicationInfo(packageName, flags);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1829910651 = ai;
            } 
        } 
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } 
        if (DroidSafeAndroidRuntime.control) throw new NameNotFoundException(packageName);
        addTaint(packageName.getTaint());
        addTaint(flags);
        varB4EAC82CA7396A68D541C85D26508E83_1829910651.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1829910651;
        
        
            
            
                
            
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.497 -0400", hash_original_method = "9B4FC7EA40C0BB7AEEEEEF1D86D28DE8", hash_generated_method = "E6716D56ABC5220C7896BC239CA98FB4")
    @Override
    public ActivityInfo getActivityInfo(ComponentName className, int flags) throws NameNotFoundException {
        ActivityInfo varB4EAC82CA7396A68D541C85D26508E83_1728102435 = null; 
        try 
        {
            ActivityInfo ai = mPM.getActivityInfo(className, flags);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1728102435 = ai;
            } 
        } 
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } 
        if (DroidSafeAndroidRuntime.control) throw new NameNotFoundException(className.toString());
        addTaint(className.getTaint());
        addTaint(flags);
        varB4EAC82CA7396A68D541C85D26508E83_1728102435.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1728102435;
        
        
            
            
                
            
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.499 -0400", hash_original_method = "399255B19735D8EC733B05B14D3B4711", hash_generated_method = "3A458FE94036CAAAED09BB09D9CFFDD6")
    @Override
    public ActivityInfo getReceiverInfo(ComponentName className, int flags) throws NameNotFoundException {
        ActivityInfo varB4EAC82CA7396A68D541C85D26508E83_631158054 = null; 
        try 
        {
            ActivityInfo ai = mPM.getReceiverInfo(className, flags);
            {
                varB4EAC82CA7396A68D541C85D26508E83_631158054 = ai;
            } 
        } 
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } 
        if (DroidSafeAndroidRuntime.control) throw new NameNotFoundException(className.toString());
        addTaint(className.getTaint());
        addTaint(flags);
        varB4EAC82CA7396A68D541C85D26508E83_631158054.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_631158054;
        
        
            
            
                
            
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.500 -0400", hash_original_method = "50C1BC4F3995D229FF03E27E05E5BE36", hash_generated_method = "619095B4B9CBAF62C64225C9D41628C0")
    @Override
    public ServiceInfo getServiceInfo(ComponentName className, int flags) throws NameNotFoundException {
        ServiceInfo varB4EAC82CA7396A68D541C85D26508E83_1619663829 = null; 
        try 
        {
            ServiceInfo si = mPM.getServiceInfo(className, flags);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1619663829 = si;
            } 
        } 
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } 
        if (DroidSafeAndroidRuntime.control) throw new NameNotFoundException(className.toString());
        addTaint(className.getTaint());
        addTaint(flags);
        varB4EAC82CA7396A68D541C85D26508E83_1619663829.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1619663829;
        
        
            
            
                
            
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.502 -0400", hash_original_method = "895E4F29ECA72E6836B6F503A466760A", hash_generated_method = "CCDCD5D6D070272E61CAD49D092A8518")
    @Override
    public ProviderInfo getProviderInfo(ComponentName className, int flags) throws NameNotFoundException {
        ProviderInfo varB4EAC82CA7396A68D541C85D26508E83_1822385958 = null; 
        try 
        {
            ProviderInfo pi = mPM.getProviderInfo(className, flags);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1822385958 = pi;
            } 
        } 
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } 
        if (DroidSafeAndroidRuntime.control) throw new NameNotFoundException(className.toString());
        addTaint(className.getTaint());
        addTaint(flags);
        varB4EAC82CA7396A68D541C85D26508E83_1822385958.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1822385958;
        
        
            
            
                
            
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.503 -0400", hash_original_method = "E90BE84736723B0914BD9D43484D5AAD", hash_generated_method = "373DFBB3B49B7A1C435125E3A5C4BC35")
    @Override
    public String[] getSystemSharedLibraryNames() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_772431914 = null; 
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_772431914 = mPM.getSystemSharedLibraryNames();
        } 
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_772431914.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_772431914;
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.506 -0400", hash_original_method = "887B55B734ED0895C5FA7D7CF721CE58", hash_generated_method = "D27A966E36D9119B121BC2A8980ADDAD")
    @Override
    public FeatureInfo[] getSystemAvailableFeatures() {
        FeatureInfo[] varB4EAC82CA7396A68D541C85D26508E83_1972747763 = null; 
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1972747763 = mPM.getSystemAvailableFeatures();
        } 
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1972747763.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1972747763;
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.507 -0400", hash_original_method = "8E2B8D0B6C29BED8B3E866F74247B636", hash_generated_method = "4D0433A5C6081A5F9B4DFA96D51F2480")
    @Override
    public boolean hasSystemFeature(String name) {
        try 
        {
            boolean varD59F1F4384BD648C5D21225C24B9C301_1615943330 = (mPM.hasSystemFeature(name));
        } 
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } 
        addTaint(name.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1971683139 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1971683139;
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.507 -0400", hash_original_method = "D191D3716589DABF1290937DD7F4276D", hash_generated_method = "5CAFDDAA760603FDAB14494D0707C03D")
    @Override
    public int checkPermission(String permName, String pkgName) {
        try 
        {
            int varC24F180D5E6F6659DC5818809EF3416E_1257529801 = (mPM.checkPermission(permName, pkgName));
        } 
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } 
        addTaint(permName.getTaint());
        addTaint(pkgName.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1177120986 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1177120986;
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.508 -0400", hash_original_method = "7DE747A31A0FDE2C95A03117CF8EC1E2", hash_generated_method = "684C69FA4A42235102EE3261BAA4329E")
    @Override
    public boolean addPermission(PermissionInfo info) {
        try 
        {
            boolean var16B313AE31B83011C28287E1893A6A9C_1096959663 = (mPM.addPermission(info));
        } 
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } 
        addTaint(info.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1938455976 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1938455976;
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.509 -0400", hash_original_method = "BE955F868C92CCDF8275E95FFE2C44B3", hash_generated_method = "CA7E611520FF0F1987470D47C09EFF04")
    @Override
    public boolean addPermissionAsync(PermissionInfo info) {
        try 
        {
            boolean var3B1BC13408FAB0EED9E6C97798235DF8_1473352193 = (mPM.addPermissionAsync(info));
        } 
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } 
        addTaint(info.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_599422688 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_599422688;
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.509 -0400", hash_original_method = "3B9F25E30931EF93125264B719A2E2FF", hash_generated_method = "10FF1DF162216143C55B2A2B5A44D0D4")
    @Override
    public void removePermission(String name) {
        try 
        {
            mPM.removePermission(name);
        } 
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } 
        addTaint(name.getTaint());
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.510 -0400", hash_original_method = "7DC6A4F902E735FA721489587F3384CC", hash_generated_method = "3B42F3B66F575EF687B90F9476ADDAD2")
    @Override
    public int checkSignatures(String pkg1, String pkg2) {
        try 
        {
            int var48FD7299CCE20AFA5ACAC7362163506B_1944691293 = (mPM.checkSignatures(pkg1, pkg2));
        } 
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } 
        addTaint(pkg1.getTaint());
        addTaint(pkg2.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2088610296 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2088610296;
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.510 -0400", hash_original_method = "E51AFA66F0FA11E52A6A449B49344AE4", hash_generated_method = "C34A7C608ED631A042AAB6E949D622CD")
    @Override
    public int checkSignatures(int uid1, int uid2) {
        try 
        {
            int varCB0D2D55990C866D4BAF222264E4D604_598741481 = (mPM.checkUidSignatures(uid1, uid2));
        } 
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } 
        addTaint(uid1);
        addTaint(uid2);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_523405153 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_523405153;
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.512 -0400", hash_original_method = "A565AD9EB181443BBE8F338808A2E4B9", hash_generated_method = "96B30B1FAE0E95E9D8809E1097D79CF6")
    @Override
    public String[] getPackagesForUid(int uid) {
        String[] varB4EAC82CA7396A68D541C85D26508E83_1048626436 = null; 
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1048626436 = mPM.getPackagesForUid(uid);
        } 
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } 
        addTaint(uid);
        varB4EAC82CA7396A68D541C85D26508E83_1048626436.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1048626436;
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.513 -0400", hash_original_method = "107797D329CAA491AA1A678294A11B0E", hash_generated_method = "F0D664D9ED5CBFDDBEC4AC9FDA07B480")
    @Override
    public String getNameForUid(int uid) {
        String varB4EAC82CA7396A68D541C85D26508E83_462459070 = null; 
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_462459070 = mPM.getNameForUid(uid);
        } 
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } 
        addTaint(uid);
        varB4EAC82CA7396A68D541C85D26508E83_462459070.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_462459070;
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.515 -0400", hash_original_method = "BCD62F04CBDED38DF225700C99BB4852", hash_generated_method = "3EC2124630C43650C50EE98C26B4922D")
    @Override
    public int getUidForSharedUser(String sharedUserName) throws NameNotFoundException {
        try 
        {
            int uid = mPM.getUidForSharedUser(sharedUserName);
        } 
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } 
        if (DroidSafeAndroidRuntime.control) throw new NameNotFoundException("No shared userid for user:"+sharedUserName);
        addTaint(sharedUserName.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1549285120 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1549285120;
        
        
            
            
                
            
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.517 -0400", hash_original_method = "2CD6168D318C89447F6184EBDE96189F", hash_generated_method = "755361DF432DF7AF4D302C8D1DD98B05")
    @SuppressWarnings("unchecked")
    @Override
    public List<PackageInfo> getInstalledPackages(int flags) {
        List<PackageInfo> varB4EAC82CA7396A68D541C85D26508E83_1606712304 = null; 
        try 
        {
            final List<PackageInfo> packageInfos = new ArrayList<PackageInfo>();
            PackageInfo lastItem = null;
            ParceledListSlice<PackageInfo> slice;
            {
                String lastKey;
                lastKey = lastItem.packageName;
                lastKey = null;
                slice = mPM.getInstalledPackages(flags, lastKey);
                lastItem = slice.populateList(packageInfos, PackageInfo.CREATOR);
            } 
            {
                boolean varAF04EF32C9AC89657E6048F98D47E5E7_1293623463 = (!slice.isLastSlice());
            } 
            varB4EAC82CA7396A68D541C85D26508E83_1606712304 = packageInfos;
        } 
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } 
        addTaint(flags);
        varB4EAC82CA7396A68D541C85D26508E83_1606712304.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1606712304;
        
        
            
            
            
            
                
                
                
            
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.518 -0400", hash_original_method = "195CA5538214D0B5EDE14A1F47A96E96", hash_generated_method = "171A3095BFFD21CE6D42E3A2F6D1D46C")
    @SuppressWarnings("unchecked")
    @Override
    public List<ApplicationInfo> getInstalledApplications(int flags) {
        List<ApplicationInfo> varB4EAC82CA7396A68D541C85D26508E83_1862302677 = null; 
        try 
        {
            final List<ApplicationInfo> applicationInfos = new ArrayList<ApplicationInfo>();
            ApplicationInfo lastItem = null;
            ParceledListSlice<ApplicationInfo> slice;
            {
                String lastKey;
                lastKey = lastItem.packageName;
                lastKey = null;
                slice = mPM.getInstalledApplications(flags, lastKey);
                lastItem = slice.populateList(applicationInfos, ApplicationInfo.CREATOR);
            } 
            {
                boolean varAF04EF32C9AC89657E6048F98D47E5E7_1031433605 = (!slice.isLastSlice());
            } 
            varB4EAC82CA7396A68D541C85D26508E83_1862302677 = applicationInfos;
        } 
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } 
        addTaint(flags);
        varB4EAC82CA7396A68D541C85D26508E83_1862302677.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1862302677;
        
        
            
            
            
            
                
                
                
            
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.519 -0400", hash_original_method = "0CD7CD39AE65A355BC33F2BA54C4DC37", hash_generated_method = "518BE1589F5FF8D06B10E4B46FF03294")
    @Override
    public ResolveInfo resolveActivity(Intent intent, int flags) {
        ResolveInfo varB4EAC82CA7396A68D541C85D26508E83_1634200756 = null; 
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1634200756 = mPM.resolveIntent(
                intent,
                intent.resolveTypeIfNeeded(mContext.getContentResolver()),
                flags);
        } 
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } 
        addTaint(intent.getTaint());
        addTaint(flags);
        varB4EAC82CA7396A68D541C85D26508E83_1634200756.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1634200756;
        
        
            
                
                
                
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.520 -0400", hash_original_method = "613ED89A001624360A0EB6B3BD081707", hash_generated_method = "3AF973977D567F585119EAFA0171DE4A")
    @Override
    public List<ResolveInfo> queryIntentActivities(Intent intent,
                                                   int flags) {
        List<ResolveInfo> varB4EAC82CA7396A68D541C85D26508E83_48379432 = null; 
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_48379432 = mPM.queryIntentActivities(
                intent,
                intent.resolveTypeIfNeeded(mContext.getContentResolver()),
                flags);
        } 
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } 
        addTaint(intent.getTaint());
        addTaint(flags);
        varB4EAC82CA7396A68D541C85D26508E83_48379432.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_48379432;
        
        
            
                
                
                
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.522 -0400", hash_original_method = "9B955FD88A95F7C1CCD0CD1DFE6EC270", hash_generated_method = "D84549ECC11A60D8ED3E8762C902054E")
    @Override
    public List<ResolveInfo> queryIntentActivityOptions(
        ComponentName caller, Intent[] specifics, Intent intent,
        int flags) {
        List<ResolveInfo> varB4EAC82CA7396A68D541C85D26508E83_456855351 = null; 
        final ContentResolver resolver = mContext.getContentResolver();
        String[] specificTypes = null;
        {
            final int N = specifics.length;
            {
                int i = 0;
                {
                    Intent sp = specifics[i];
                    {
                        String t = sp.resolveTypeIfNeeded(resolver);
                        {
                            {
                                specificTypes = new String[N];
                            } 
                            specificTypes[i] = t;
                        } 
                    } 
                } 
            } 
        } 
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_456855351 = mPM.queryIntentActivityOptions(caller, specifics,
                                                  specificTypes, intent, intent.resolveTypeIfNeeded(resolver),
                                                  flags);
        } 
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } 
        addTaint(caller.getTaint());
        addTaint(specifics[0].getTaint());
        addTaint(intent.getTaint());
        addTaint(flags);
        varB4EAC82CA7396A68D541C85D26508E83_456855351.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_456855351;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.525 -0400", hash_original_method = "2B65A8BDA3BE53DC3296D1F5CA76CDFC", hash_generated_method = "53ED056B02EF10BB85FC89A2D1E96E91")
    @Override
    public List<ResolveInfo> queryBroadcastReceivers(Intent intent, int flags) {
        List<ResolveInfo> varB4EAC82CA7396A68D541C85D26508E83_1695720533 = null; 
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1695720533 = mPM.queryIntentReceivers(
                intent,
                intent.resolveTypeIfNeeded(mContext.getContentResolver()),
                flags);
        } 
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } 
        addTaint(intent.getTaint());
        addTaint(flags);
        varB4EAC82CA7396A68D541C85D26508E83_1695720533.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1695720533;
        
        
            
                
                
                
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.527 -0400", hash_original_method = "D7D4C733DB611C9D18D346868F9BD0BD", hash_generated_method = "50D29F214768B6AB6CE955E5CCCFA709")
    @Override
    public ResolveInfo resolveService(Intent intent, int flags) {
        ResolveInfo varB4EAC82CA7396A68D541C85D26508E83_927416080 = null; 
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_927416080 = mPM.resolveService(
                intent,
                intent.resolveTypeIfNeeded(mContext.getContentResolver()),
                flags);
        } 
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } 
        addTaint(intent.getTaint());
        addTaint(flags);
        varB4EAC82CA7396A68D541C85D26508E83_927416080.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_927416080;
        
        
            
                
                
                
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.528 -0400", hash_original_method = "EEB4EB852740846BAD76CCDE5FC0C613", hash_generated_method = "42463ADAA8B7EEE80F02983DA97381A7")
    @Override
    public List<ResolveInfo> queryIntentServices(Intent intent, int flags) {
        List<ResolveInfo> varB4EAC82CA7396A68D541C85D26508E83_1571975821 = null; 
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1571975821 = mPM.queryIntentServices(
                intent,
                intent.resolveTypeIfNeeded(mContext.getContentResolver()),
                flags);
        } 
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } 
        addTaint(intent.getTaint());
        addTaint(flags);
        varB4EAC82CA7396A68D541C85D26508E83_1571975821.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1571975821;
        
        
            
                
                
                
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.529 -0400", hash_original_method = "3A6513CB26C2E0AF7DACFC2B8A5D560B", hash_generated_method = "264D903EEB276E78EC6A3B27B01B9352")
    @Override
    public ProviderInfo resolveContentProvider(String name,
                                               int flags) {
        ProviderInfo varB4EAC82CA7396A68D541C85D26508E83_1964754316 = null; 
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1964754316 = mPM.resolveContentProvider(name, flags);
        } 
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } 
        addTaint(name.getTaint());
        addTaint(flags);
        varB4EAC82CA7396A68D541C85D26508E83_1964754316.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1964754316;
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.531 -0400", hash_original_method = "7B04A4BE8EFECF5209DBE4F77CB67C42", hash_generated_method = "F828AE9F80536F8425C34681A69D8A71")
    @Override
    public List<ProviderInfo> queryContentProviders(String processName,
                                                    int uid, int flags) {
        List<ProviderInfo> varB4EAC82CA7396A68D541C85D26508E83_341088414 = null; 
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_341088414 = mPM.queryContentProviders(processName, uid, flags);
        } 
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } 
        addTaint(processName.getTaint());
        addTaint(uid);
        addTaint(flags);
        varB4EAC82CA7396A68D541C85D26508E83_341088414.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_341088414;
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.532 -0400", hash_original_method = "3120887453BFC9391A593077A4EB2D8C", hash_generated_method = "9E694F89AD893C6668C5F2F291295871")
    @Override
    public InstrumentationInfo getInstrumentationInfo(
        ComponentName className, int flags) throws NameNotFoundException {
        InstrumentationInfo varB4EAC82CA7396A68D541C85D26508E83_36052392 = null; 
        try 
        {
            InstrumentationInfo ii = mPM.getInstrumentationInfo(
                className, flags);
            {
                varB4EAC82CA7396A68D541C85D26508E83_36052392 = ii;
            } 
        } 
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } 
        if (DroidSafeAndroidRuntime.control) throw new NameNotFoundException(className.toString());
        addTaint(className.getTaint());
        addTaint(flags);
        varB4EAC82CA7396A68D541C85D26508E83_36052392.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_36052392;
        
        
            
                
            
                
            
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.535 -0400", hash_original_method = "0CE547FAA1F9EB003838A9DE59E3AC72", hash_generated_method = "E9C90F9E5F49611FB8CA1B099DE4056C")
    @Override
    public List<InstrumentationInfo> queryInstrumentation(
        String targetPackage, int flags) {
        List<InstrumentationInfo> varB4EAC82CA7396A68D541C85D26508E83_581288621 = null; 
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_581288621 = mPM.queryInstrumentation(targetPackage, flags);
        } 
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } 
        addTaint(targetPackage.getTaint());
        addTaint(flags);
        varB4EAC82CA7396A68D541C85D26508E83_581288621.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_581288621;
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.538 -0400", hash_original_method = "350CC4BDDD2E42419F88F44C033409F6", hash_generated_method = "A0887470A7B07B011A1A7466FFC9F255")
    @Override
    public Drawable getDrawable(String packageName, int resid,
                                          ApplicationInfo appInfo) {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_1454121475 = null; 
        Drawable varB4EAC82CA7396A68D541C85D26508E83_1164148280 = null; 
        Drawable varB4EAC82CA7396A68D541C85D26508E83_549845257 = null; 
        Drawable varB4EAC82CA7396A68D541C85D26508E83_2119676941 = null; 
        ResourceName name = new ResourceName(packageName, resid);
        Drawable dr = getCachedIcon(name);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1454121475 = dr;
        } 
        {
            try 
            {
                appInfo = getApplicationInfo(packageName, 0);
            } 
            catch (NameNotFoundException e)
            {
                varB4EAC82CA7396A68D541C85D26508E83_1164148280 = null;
            } 
        } 
        try 
        {
            Resources r = getResourcesForApplication(appInfo);
            dr = r.getDrawable(resid);
            {
                RuntimeException e = new RuntimeException("here");
                e.fillInStackTrace();
            } 
            putCachedIcon(name, dr);
            varB4EAC82CA7396A68D541C85D26508E83_549845257 = dr;
        } 
        catch (NameNotFoundException e)
        { }
        catch (Resources.NotFoundException e)
        { }
        catch (RuntimeException e)
        { }
        varB4EAC82CA7396A68D541C85D26508E83_2119676941 = null;
        addTaint(packageName.getTaint());
        addTaint(resid);
        addTaint(appInfo.getTaint());
        Drawable varA7E53CE21691AB073D9660D615818899_1361794203; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1361794203 = varB4EAC82CA7396A68D541C85D26508E83_1454121475;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1361794203 = varB4EAC82CA7396A68D541C85D26508E83_1164148280;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_1361794203 = varB4EAC82CA7396A68D541C85D26508E83_549845257;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1361794203 = varB4EAC82CA7396A68D541C85D26508E83_2119676941;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1361794203.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1361794203;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.539 -0400", hash_original_method = "E8823DE045849946097DF943F50B58DB", hash_generated_method = "463821C3BB77481E0A400CF240B6CF96")
    @Override
    public Drawable getActivityIcon(ComponentName activityName) throws NameNotFoundException {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_1437117519 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1437117519 = getActivityInfo(activityName, 0).loadIcon(this);
        addTaint(activityName.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1437117519.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1437117519;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.540 -0400", hash_original_method = "EF5F409F30F5D50F1964B6AB6B7F75B7", hash_generated_method = "F325DF407B9A32913C308B537318FDE5")
    @Override
    public Drawable getActivityIcon(Intent intent) throws NameNotFoundException {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_1808145405 = null; 
        Drawable varB4EAC82CA7396A68D541C85D26508E83_1954386934 = null; 
        {
            boolean var2CB4FD776F3AF8424EA4E2E544217AF5_750388327 = (intent.getComponent() != null);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1808145405 = getActivityIcon(intent.getComponent());
            } 
        } 
        ResolveInfo info = resolveActivity(
            intent, PackageManager.MATCH_DEFAULT_ONLY);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1954386934 = info.activityInfo.loadIcon(this);
        } 
        if (DroidSafeAndroidRuntime.control) throw new NameNotFoundException(intent.toUri(0));
        addTaint(intent.getTaint());
        Drawable varA7E53CE21691AB073D9660D615818899_1145223394; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1145223394 = varB4EAC82CA7396A68D541C85D26508E83_1808145405;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1145223394 = varB4EAC82CA7396A68D541C85D26508E83_1954386934;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1145223394.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1145223394;
        
        
            
        
        
            
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.541 -0400", hash_original_method = "27F8B828FEA8943560AD77E4760B6964", hash_generated_method = "578639F384885FB98F99040CD4A04EA1")
    @Override
    public Drawable getDefaultActivityIcon() {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_642489561 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_642489561 = Resources.getSystem().getDrawable(
            com.android.internal.R.drawable.sym_def_app_icon);
        varB4EAC82CA7396A68D541C85D26508E83_642489561.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_642489561;
        
        
            
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.543 -0400", hash_original_method = "C2186A062EDEC18E9DD8F87E8E6291D1", hash_generated_method = "7C8437D706AD59CC4C9343BA8328BEC7")
    @Override
    public Drawable getApplicationIcon(ApplicationInfo info) {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_1002916214 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1002916214 = info.loadIcon(this);
        addTaint(info.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1002916214.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1002916214;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.545 -0400", hash_original_method = "49256B647BD52234F52BC973E3B03E0B", hash_generated_method = "9E7B6BDFA2B7D775DDA5A7C8FC2F382D")
    @Override
    public Drawable getApplicationIcon(String packageName) throws NameNotFoundException {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_1734522175 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1734522175 = getApplicationIcon(getApplicationInfo(packageName, 0));
        addTaint(packageName.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1734522175.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1734522175;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.547 -0400", hash_original_method = "12128D2FB1F753A28280A7EF3E62F4B2", hash_generated_method = "0E57064C0E6699810F45C96ACC9D731E")
    @Override
    public Drawable getActivityLogo(ComponentName activityName) throws NameNotFoundException {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_2101092277 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2101092277 = getActivityInfo(activityName, 0).loadLogo(this);
        addTaint(activityName.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2101092277.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2101092277;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.548 -0400", hash_original_method = "3B1A86BB5E25FB8EFA7A1AD1A88B3B01", hash_generated_method = "B733A1F5AA2B5FCCAD223EF54F855C92")
    @Override
    public Drawable getActivityLogo(Intent intent) throws NameNotFoundException {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_2011036617 = null; 
        Drawable varB4EAC82CA7396A68D541C85D26508E83_674970592 = null; 
        {
            boolean var2CB4FD776F3AF8424EA4E2E544217AF5_1995930233 = (intent.getComponent() != null);
            {
                varB4EAC82CA7396A68D541C85D26508E83_2011036617 = getActivityLogo(intent.getComponent());
            } 
        } 
        ResolveInfo info = resolveActivity(
            intent, PackageManager.MATCH_DEFAULT_ONLY);
        {
            varB4EAC82CA7396A68D541C85D26508E83_674970592 = info.activityInfo.loadLogo(this);
        } 
        if (DroidSafeAndroidRuntime.control) throw new NameNotFoundException(intent.toUri(0));
        addTaint(intent.getTaint());
        Drawable varA7E53CE21691AB073D9660D615818899_437401801; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_437401801 = varB4EAC82CA7396A68D541C85D26508E83_2011036617;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_437401801 = varB4EAC82CA7396A68D541C85D26508E83_674970592;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_437401801.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_437401801;
        
        
            
        
        
            
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.549 -0400", hash_original_method = "586E62978169D56092172114763F9AD3", hash_generated_method = "22D87DAB36BE53E0EEAA1BBEA86D1755")
    @Override
    public Drawable getApplicationLogo(ApplicationInfo info) {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_1712292975 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1712292975 = info.loadLogo(this);
        addTaint(info.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1712292975.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1712292975;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.550 -0400", hash_original_method = "6BC85FEDD3936A7851329E2331D0279D", hash_generated_method = "E67AA2C6B712FB9BA43281130EFF1A4F")
    @Override
    public Drawable getApplicationLogo(String packageName) throws NameNotFoundException {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_496861490 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_496861490 = getApplicationLogo(getApplicationInfo(packageName, 0));
        addTaint(packageName.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_496861490.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_496861490;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.551 -0400", hash_original_method = "E07E3E36CD8F79CF4FE12B9F33A40344", hash_generated_method = "9E060465184491E6EC30E48E28AA88A2")
    @Override
    public Resources getResourcesForActivity(
        ComponentName activityName) throws NameNotFoundException {
        Resources varB4EAC82CA7396A68D541C85D26508E83_398011658 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_398011658 = getResourcesForApplication(
            getActivityInfo(activityName, 0).applicationInfo);
        addTaint(activityName.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_398011658.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_398011658;
        
        
            
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.553 -0400", hash_original_method = "AC20F77416CABFA638F647DA9F2F230E", hash_generated_method = "B04A3F347103D4B2418C91A8316CBB7C")
    @Override
    public Resources getResourcesForApplication(
        ApplicationInfo app) throws NameNotFoundException {
        Resources varB4EAC82CA7396A68D541C85D26508E83_1922303088 = null; 
        Resources varB4EAC82CA7396A68D541C85D26508E83_571849192 = null; 
        {
            boolean varF67FB556D575A0DB52E0C311AE1F282F_379408709 = (app.packageName.equals("system"));
            {
                varB4EAC82CA7396A68D541C85D26508E83_1922303088 = mContext.mMainThread.getSystemContext().getResources();
            } 
        } 
        Resources r = mContext.mMainThread.getTopLevelResources(
            app.uid == Process.myUid() ? app.sourceDir
            : app.publicSourceDir, mContext.mPackageInfo);
        {
            varB4EAC82CA7396A68D541C85D26508E83_571849192 = r;
        } 
        if (DroidSafeAndroidRuntime.control) throw new NameNotFoundException("Unable to open " + app.publicSourceDir);
        addTaint(app.getTaint());
        Resources varA7E53CE21691AB073D9660D615818899_1826920357; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1826920357 = varB4EAC82CA7396A68D541C85D26508E83_1922303088;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1826920357 = varB4EAC82CA7396A68D541C85D26508E83_571849192;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1826920357.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1826920357;
        
        
            
        
        
            
            
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.556 -0400", hash_original_method = "ACD444E0FC7FCEAEB5D1FF09DD4A5912", hash_generated_method = "4FE6865CD080A042801BFCB23A3DDF11")
    @Override
    public Resources getResourcesForApplication(
        String appPackageName) throws NameNotFoundException {
        Resources varB4EAC82CA7396A68D541C85D26508E83_1258125328 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1258125328 = getResourcesForApplication(
            getApplicationInfo(appPackageName, 0));
        addTaint(appPackageName.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1258125328.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1258125328;
        
        
            
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.557 -0400", hash_original_method = "6B2AA9A609FE89D703EEC81AF1FC0890", hash_generated_method = "10B17B90A1CC18A3165D5AB9D261E7E8")
    @Override
    public boolean isSafeMode() {
        try 
        {
            {
                mCachedSafeMode = mPM.isSafeMode() ? 1 : 0;
            } 
        } 
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1724392656 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1724392656;
        
        
            
                
            
            
        
            
        
    }

    
    static void configurationChanged() {
        synchronized (sSync) {
            sIconCache.clear();
            sStringCache.clear();
        }
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.559 -0400", hash_original_method = "805BC435FDAE098AFC4F53B40E89D7C1", hash_generated_method = "1EF323F62B8C726355161AAF209FF88B")
    private Drawable getCachedIcon(ResourceName name) {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_1427417922 = null; 
        Drawable varB4EAC82CA7396A68D541C85D26508E83_879611213 = null; 
        {
            WeakReference<Drawable.ConstantState> wr = sIconCache.get(name);
            {
                Drawable.ConstantState state = wr.get();
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1427417922 = state.newDrawable();
                } 
                sIconCache.remove(name);
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_879611213 = null;
        addTaint(name.getTaint());
        Drawable varA7E53CE21691AB073D9660D615818899_1391743782; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1391743782 = varB4EAC82CA7396A68D541C85D26508E83_1427417922;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1391743782 = varB4EAC82CA7396A68D541C85D26508E83_879611213;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1391743782.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1391743782;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.559 -0400", hash_original_method = "1ADDA1851B7207BD0D6C119E2C63D6A2", hash_generated_method = "4706D414367874136365DA3DBB20C3A5")
    private void putCachedIcon(ResourceName name, Drawable dr) {
        {
            sIconCache.put(name, new WeakReference<Drawable.ConstantState>(dr.getConstantState()));
        } 
        addTaint(name.getTaint());
        addTaint(dr.getTaint());
        
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    static void handlePackageBroadcast(int cmd, String[] pkgList, boolean hasPkgInfo) {
        boolean immediateGc = false;
        if (cmd == IApplicationThread.EXTERNAL_STORAGE_UNAVAILABLE) {
            immediateGc = true;
        }
        if (pkgList != null && (pkgList.length > 0)) {
            boolean needCleanup = false;
            for (String ssp : pkgList) {
                synchronized (sSync) {
                    if (sIconCache.size() > 0) {
                        Iterator<ResourceName> it = sIconCache.keySet().iterator();
                        while (it.hasNext()) {
                            ResourceName nm = it.next();
                            if (nm.packageName.equals(ssp)) {
                                it.remove();
                                needCleanup = true;
                            }
                        }
                    }
                    if (sStringCache.size() > 0) {
                        Iterator<ResourceName> it = sStringCache.keySet().iterator();
                        while (it.hasNext()) {
                            ResourceName nm = it.next();
                            if (nm.packageName.equals(ssp)) {
                                it.remove();
                                needCleanup = true;
                            }
                        }
                    }
                }
            }
            if (needCleanup || hasPkgInfo) {
                if (immediateGc) {
                    Runtime.getRuntime().gc();
                } else {
                    ActivityThread.currentActivityThread().scheduleGcIdler();
                }
            }
        }
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.584 -0400", hash_original_method = "B66098C8E55783775B73FA7D73879D41", hash_generated_method = "067A53C68DABBFA85EE9EF9914302271")
    private CharSequence getCachedString(ResourceName name) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_792310776 = null; 
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1225753205 = null; 
        {
            WeakReference<CharSequence> wr = sStringCache.get(name);
            {
                CharSequence cs = wr.get();
                {
                    varB4EAC82CA7396A68D541C85D26508E83_792310776 = cs;
                } 
                sStringCache.remove(name);
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1225753205 = null;
        addTaint(name.getTaint());
        CharSequence varA7E53CE21691AB073D9660D615818899_1761727787; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1761727787 = varB4EAC82CA7396A68D541C85D26508E83_792310776;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1761727787 = varB4EAC82CA7396A68D541C85D26508E83_1225753205;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1761727787.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1761727787;
        
        
            
            
                
                
                    
                
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.584 -0400", hash_original_method = "70E4290F1842F0A45B89D50D6CDEDDBB", hash_generated_method = "7D27E17696535E60A1AB1B6049B959C9")
    private void putCachedString(ResourceName name, CharSequence cs) {
        {
            sStringCache.put(name, new WeakReference<CharSequence>(cs));
        } 
        addTaint(name.getTaint());
        addTaint(cs.getTaint());
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.587 -0400", hash_original_method = "771B010EDE230C24A313E1F6F3869FDB", hash_generated_method = "65CFC348D87F54A9252D6B3B3CB3A065")
    @Override
    public CharSequence getText(String packageName, int resid,
                                ApplicationInfo appInfo) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_535904114 = null; 
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_395237493 = null; 
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_218663786 = null; 
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1219051615 = null; 
        ResourceName name = new ResourceName(packageName, resid);
        CharSequence text = getCachedString(name);
        {
            varB4EAC82CA7396A68D541C85D26508E83_535904114 = text;
        } 
        {
            try 
            {
                appInfo = getApplicationInfo(packageName, 0);
            } 
            catch (NameNotFoundException e)
            {
                varB4EAC82CA7396A68D541C85D26508E83_395237493 = null;
            } 
        } 
        try 
        {
            Resources r = getResourcesForApplication(appInfo);
            text = r.getText(resid);
            putCachedString(name, text);
            varB4EAC82CA7396A68D541C85D26508E83_218663786 = text;
        } 
        catch (NameNotFoundException e)
        { }
        catch (RuntimeException e)
        { }
        varB4EAC82CA7396A68D541C85D26508E83_1219051615 = null;
        addTaint(packageName.getTaint());
        addTaint(resid);
        addTaint(appInfo.getTaint());
        CharSequence varA7E53CE21691AB073D9660D615818899_1706276863; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1706276863 = varB4EAC82CA7396A68D541C85D26508E83_535904114;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1706276863 = varB4EAC82CA7396A68D541C85D26508E83_395237493;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_1706276863 = varB4EAC82CA7396A68D541C85D26508E83_218663786;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1706276863 = varB4EAC82CA7396A68D541C85D26508E83_1219051615;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1706276863.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1706276863;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.588 -0400", hash_original_method = "F130C54905A9CE16326CF20EF6E93255", hash_generated_method = "5C01980BA29CFF0401923B0552274B8B")
    @Override
    public XmlResourceParser getXml(String packageName, int resid,
                                    ApplicationInfo appInfo) {
        XmlResourceParser varB4EAC82CA7396A68D541C85D26508E83_530623061 = null; 
        XmlResourceParser varB4EAC82CA7396A68D541C85D26508E83_377528268 = null; 
        XmlResourceParser varB4EAC82CA7396A68D541C85D26508E83_339773282 = null; 
        {
            try 
            {
                appInfo = getApplicationInfo(packageName, 0);
            } 
            catch (NameNotFoundException e)
            {
                varB4EAC82CA7396A68D541C85D26508E83_530623061 = null;
            } 
        } 
        try 
        {
            Resources r = getResourcesForApplication(appInfo);
            varB4EAC82CA7396A68D541C85D26508E83_377528268 = r.getXml(resid);
        } 
        catch (RuntimeException e)
        { }
        catch (NameNotFoundException e)
        { }
        varB4EAC82CA7396A68D541C85D26508E83_339773282 = null;
        addTaint(packageName.getTaint());
        addTaint(resid);
        addTaint(appInfo.getTaint());
        XmlResourceParser varA7E53CE21691AB073D9660D615818899_1334979618; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1334979618 = varB4EAC82CA7396A68D541C85D26508E83_530623061;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1334979618 = varB4EAC82CA7396A68D541C85D26508E83_377528268;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1334979618 = varB4EAC82CA7396A68D541C85D26508E83_339773282;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1334979618.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1334979618;
        
        
            
                
            
                
            
        
        
            
            
        
            
                  
                  
        
            
                  
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.590 -0400", hash_original_method = "4AFDE050276913F392973B277F54706D", hash_generated_method = "374280FF5245844AB86AB36541C80C6F")
    @Override
    public CharSequence getApplicationLabel(ApplicationInfo info) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_709572085 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_709572085 = info.loadLabel(this);
        addTaint(info.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_709572085.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_709572085;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.590 -0400", hash_original_method = "99610A6DD5E10C01303307EBA6938AA8", hash_generated_method = "400A22F298DF08C5D0E769F3CCD38501")
    @Override
    public void installPackage(Uri packageURI, IPackageInstallObserver observer, int flags,
                               String installerPackageName) {
        try 
        {
            mPM.installPackage(packageURI, observer, flags, installerPackageName);
        } 
        catch (RemoteException e)
        { }
        addTaint(packageURI.getTaint());
        addTaint(observer.getTaint());
        addTaint(flags);
        addTaint(installerPackageName.getTaint());
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.591 -0400", hash_original_method = "769145FCC72852B2314845C8A89A2DAD", hash_generated_method = "F3245D05F97B312C267DEC2D9622BA8B")
    @Override
    public void installPackageWithVerification(Uri packageURI, IPackageInstallObserver observer,
            int flags, String installerPackageName, Uri verificationURI,
            ManifestDigest manifestDigest) {
        try 
        {
            mPM.installPackageWithVerification(packageURI, observer, flags, installerPackageName,
                    verificationURI, manifestDigest);
        } 
        catch (RemoteException e)
        { }
        addTaint(packageURI.getTaint());
        addTaint(observer.getTaint());
        addTaint(flags);
        addTaint(installerPackageName.getTaint());
        addTaint(verificationURI.getTaint());
        addTaint(manifestDigest.getTaint());
        
        
            
                    
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.592 -0400", hash_original_method = "E593338881B3E45506EA974F446D2A6B", hash_generated_method = "37756C8FAB2D16E48F6540B81C396231")
    @Override
    public void verifyPendingInstall(int id, int response) {
        try 
        {
            mPM.verifyPendingInstall(id, response);
        } 
        catch (RemoteException e)
        { }
        addTaint(id);
        addTaint(response);
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.592 -0400", hash_original_method = "A168A8E169316429D31E261AD639AED4", hash_generated_method = "9C8C38D01201816D92FED5BF837CFF63")
    @Override
    public void setInstallerPackageName(String targetPackage,
            String installerPackageName) {
        try 
        {
            mPM.setInstallerPackageName(targetPackage, installerPackageName);
        } 
        catch (RemoteException e)
        { }
        addTaint(targetPackage.getTaint());
        addTaint(installerPackageName.getTaint());
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.593 -0400", hash_original_method = "D8F1CA3B8F90BF876B114DD825F09703", hash_generated_method = "013104B1BDA6E03638BA31CEC045094F")
    @Override
    public void movePackage(String packageName, IPackageMoveObserver observer, int flags) {
        try 
        {
            mPM.movePackage(packageName, observer, flags);
        } 
        catch (RemoteException e)
        { }
        addTaint(packageName.getTaint());
        addTaint(observer.getTaint());
        addTaint(flags);
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.594 -0400", hash_original_method = "13C0F9FC5FF4142BD538C8A3AADB3621", hash_generated_method = "578F50F79ADA6DE65522A42D6BEC5E18")
    @Override
    public String getInstallerPackageName(String packageName) {
        String varB4EAC82CA7396A68D541C85D26508E83_1867274395 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1182395187 = null; 
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1867274395 = mPM.getInstallerPackageName(packageName);
        } 
        catch (RemoteException e)
        { }
        varB4EAC82CA7396A68D541C85D26508E83_1182395187 = null;
        addTaint(packageName.getTaint());
        String varA7E53CE21691AB073D9660D615818899_362925868; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_362925868 = varB4EAC82CA7396A68D541C85D26508E83_1867274395;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_362925868 = varB4EAC82CA7396A68D541C85D26508E83_1182395187;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_362925868.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_362925868;
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.595 -0400", hash_original_method = "6B4A8C0BA02325B97A4B696E509E27F1", hash_generated_method = "6A3ED9E8A60057D0DB3AC4995AF0B2E7")
    @Override
    public void deletePackage(String packageName, IPackageDeleteObserver observer, int flags) {
        try 
        {
            mPM.deletePackage(packageName, observer, flags);
        } 
        catch (RemoteException e)
        { }
        addTaint(packageName.getTaint());
        addTaint(observer.getTaint());
        addTaint(flags);
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.595 -0400", hash_original_method = "41D4F7CDEA8F3FA97A215E5DB5AE3B7F", hash_generated_method = "A1F8ED7652B7387CD0E6421FC7565E8D")
    @Override
    public void clearApplicationUserData(String packageName,
                                         IPackageDataObserver observer) {
        try 
        {
            mPM.clearApplicationUserData(packageName, observer);
        } 
        catch (RemoteException e)
        { }
        addTaint(packageName.getTaint());
        addTaint(observer.getTaint());
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.598 -0400", hash_original_method = "9E003FA712762A764BBDA3187B8255C1", hash_generated_method = "A69811C1495E99329928ECA86D124251")
    @Override
    public void deleteApplicationCacheFiles(String packageName,
                                            IPackageDataObserver observer) {
        try 
        {
            mPM.deleteApplicationCacheFiles(packageName, observer);
        } 
        catch (RemoteException e)
        { }
        addTaint(packageName.getTaint());
        addTaint(observer.getTaint());
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.599 -0400", hash_original_method = "E7A7F0006F405C835ECAAE7B969343FA", hash_generated_method = "0B639835B9C7BD19E29CC9E9938962C4")
    @Override
    public void freeStorageAndNotify(long idealStorageSize, IPackageDataObserver observer) {
        try 
        {
            mPM.freeStorageAndNotify(idealStorageSize, observer);
        } 
        catch (RemoteException e)
        { }
        addTaint(idealStorageSize);
        addTaint(observer.getTaint());
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.599 -0400", hash_original_method = "8531AD2E443F843CDBBD03DDCC5F2882", hash_generated_method = "B0070DACE1C55EC19587AB40DB11BCAF")
    @Override
    public void freeStorage(long freeStorageSize, IntentSender pi) {
        try 
        {
            mPM.freeStorage(freeStorageSize, pi);
        } 
        catch (RemoteException e)
        { }
        addTaint(freeStorageSize);
        addTaint(pi.getTaint());
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.600 -0400", hash_original_method = "00314015F36B785D35449EC7724DA4A0", hash_generated_method = "6ECEB12C252949AE71858382236E4A0D")
    @Override
    public void getPackageSizeInfo(String packageName,
                                   IPackageStatsObserver observer) {
        try 
        {
            mPM.getPackageSizeInfo(packageName, observer);
        } 
        catch (RemoteException e)
        { }
        addTaint(packageName.getTaint());
        addTaint(observer.getTaint());
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.600 -0400", hash_original_method = "A9291C102B2FAAEF4C90A57E1B6DE098", hash_generated_method = "0D690A0FE1B62191F94C37814ED9C13E")
    @Override
    public void addPackageToPreferred(String packageName) {
        try 
        {
            mPM.addPackageToPreferred(packageName);
        } 
        catch (RemoteException e)
        { }
        addTaint(packageName.getTaint());
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.601 -0400", hash_original_method = "F1B5214867A85B15353BE55995A19BB6", hash_generated_method = "16AE382D6D44614F9CE0F2F1A0174EBF")
    @Override
    public void removePackageFromPreferred(String packageName) {
        try 
        {
            mPM.removePackageFromPreferred(packageName);
        } 
        catch (RemoteException e)
        { }
        addTaint(packageName.getTaint());
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.602 -0400", hash_original_method = "4A08CFB9ACE88EAEABD2D18F083F329D", hash_generated_method = "5A4C2FE7DE94336F99AE0FD9E3010264")
    @Override
    public List<PackageInfo> getPreferredPackages(int flags) {
        List<PackageInfo> varB4EAC82CA7396A68D541C85D26508E83_174769449 = null; 
        List<PackageInfo> varB4EAC82CA7396A68D541C85D26508E83_486820621 = null; 
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_174769449 = mPM.getPreferredPackages(flags);
        } 
        catch (RemoteException e)
        { }
        varB4EAC82CA7396A68D541C85D26508E83_486820621 = new ArrayList<PackageInfo>();
        addTaint(flags);
        List<PackageInfo> varA7E53CE21691AB073D9660D615818899_41727386; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_41727386 = varB4EAC82CA7396A68D541C85D26508E83_174769449;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_41727386 = varB4EAC82CA7396A68D541C85D26508E83_486820621;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_41727386.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_41727386;
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.603 -0400", hash_original_method = "E5D2F7A75D600839A582F36FB9BA5425", hash_generated_method = "E4890C1035F01F9D32FCB826AD598DD3")
    @Override
    public void addPreferredActivity(IntentFilter filter,
                                     int match, ComponentName[] set, ComponentName activity) {
        try 
        {
            mPM.addPreferredActivity(filter, match, set, activity);
        } 
        catch (RemoteException e)
        { }
        addTaint(filter.getTaint());
        addTaint(match);
        addTaint(set[0].getTaint());
        addTaint(activity.getTaint());
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.603 -0400", hash_original_method = "2885B1E40721D55CC13EAA30EB1BAE52", hash_generated_method = "C5FF225D327460B3296A7AFA75368096")
    @Override
    public void replacePreferredActivity(IntentFilter filter,
                                         int match, ComponentName[] set, ComponentName activity) {
        try 
        {
            mPM.replacePreferredActivity(filter, match, set, activity);
        } 
        catch (RemoteException e)
        { }
        addTaint(filter.getTaint());
        addTaint(match);
        addTaint(set[0].getTaint());
        addTaint(activity.getTaint());
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.604 -0400", hash_original_method = "818084167B76F544DAE31D40EA850683", hash_generated_method = "C9C1FB3440196C8943FD1E9972510DCD")
    @Override
    public void clearPackagePreferredActivities(String packageName) {
        try 
        {
            mPM.clearPackagePreferredActivities(packageName);
        } 
        catch (RemoteException e)
        { }
        addTaint(packageName.getTaint());
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.604 -0400", hash_original_method = "9A1408660FD10D92BECBE2BE18AA9510", hash_generated_method = "F86AC4DBF9B1F0D6CD2371BC2F3F6B47")
    @Override
    public int getPreferredActivities(List<IntentFilter> outFilters,
                                      List<ComponentName> outActivities, String packageName) {
        try 
        {
            int varAAA2984E5864A69FBA0F19FD84D394A5_2110103518 = (mPM.getPreferredActivities(outFilters, outActivities, packageName));
        } 
        catch (RemoteException e)
        { }
        addTaint(outFilters.getTaint());
        addTaint(outActivities.getTaint());
        addTaint(packageName.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1117318833 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1117318833;
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.605 -0400", hash_original_method = "324289EEBFA692363CEA9B4C548C82A7", hash_generated_method = "A0BA00110F6663F102A5964560E3C0E9")
    @Override
    public void setComponentEnabledSetting(ComponentName componentName,
                                           int newState, int flags) {
        try 
        {
            mPM.setComponentEnabledSetting(componentName, newState, flags);
        } 
        catch (RemoteException e)
        { }
        addTaint(componentName.getTaint());
        addTaint(newState);
        addTaint(flags);
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.606 -0400", hash_original_method = "214E6E4C94F679DC0FE6A4159B821EAF", hash_generated_method = "2083D15A964387B75CEF5D8363300FFF")
    @Override
    public int getComponentEnabledSetting(ComponentName componentName) {
        try 
        {
            int var1528F93F8B5599DBD2DEEBFDF40122F0_1383876752 = (mPM.getComponentEnabledSetting(componentName));
        } 
        catch (RemoteException e)
        { }
        addTaint(componentName.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1289252026 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1289252026;
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.607 -0400", hash_original_method = "893989AE0F295A10184FE7AD874B7991", hash_generated_method = "C30D96FC52BAA3663F8231ABB8ABA6D1")
    @Override
    public void setApplicationEnabledSetting(String packageName,
                                             int newState, int flags) {
        try 
        {
            mPM.setApplicationEnabledSetting(packageName, newState, flags);
        } 
        catch (RemoteException e)
        { }
        addTaint(packageName.getTaint());
        addTaint(newState);
        addTaint(flags);
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.608 -0400", hash_original_method = "786754E395F784476E8D899ABD01121D", hash_generated_method = "47BF4B42FAEDD3F4B00D3A00D935318D")
    @Override
    public int getApplicationEnabledSetting(String packageName) {
        try 
        {
            int varF2CA84C656A1ECB5C0715BD15E6F333E_164495705 = (mPM.getApplicationEnabledSetting(packageName));
        } 
        catch (RemoteException e)
        { }
        addTaint(packageName.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_117713051 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_117713051;
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.609 -0400", hash_original_method = "26D19368C79A5889D2D25A72A45789A8", hash_generated_method = "38AB007A2DCCAFAD7FB8E080841E8C8A")
    @Override
    public UserInfo createUser(String name, int flags) {
        UserInfo varB4EAC82CA7396A68D541C85D26508E83_511143906 = null; 
        UserInfo varB4EAC82CA7396A68D541C85D26508E83_1044290623 = null; 
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_511143906 = mPM.createUser(name, flags);
        } 
        catch (RemoteException e)
        { }
        varB4EAC82CA7396A68D541C85D26508E83_1044290623 = null;
        addTaint(name.getTaint());
        addTaint(flags);
        UserInfo varA7E53CE21691AB073D9660D615818899_1593574196; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1593574196 = varB4EAC82CA7396A68D541C85D26508E83_511143906;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1593574196 = varB4EAC82CA7396A68D541C85D26508E83_1044290623;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1593574196.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1593574196;
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.611 -0400", hash_original_method = "D3989192690585F23E6C25734E0C3BDB", hash_generated_method = "71AAFC709D333E5BB5BE9BD81C0D7000")
    @Override
    public List<UserInfo> getUsers() {
        List<UserInfo> varB4EAC82CA7396A68D541C85D26508E83_129818467 = null; 
        ArrayList<UserInfo> users = new ArrayList<UserInfo>();
        UserInfo primary = new UserInfo(0, "Root!",
                UserInfo.FLAG_ADMIN | UserInfo.FLAG_PRIMARY);
        users.add(primary);
        varB4EAC82CA7396A68D541C85D26508E83_129818467 = users;
        varB4EAC82CA7396A68D541C85D26508E83_129818467.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_129818467;
        
        
        
                
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.611 -0400", hash_original_method = "7D391C716B6EBFD3B4233647A1DCBC34", hash_generated_method = "D5404D09F669BE1AB85052F182846D51")
    @Override
    public boolean removeUser(int id) {
        try 
        {
            boolean varF0857FEEEFECDA71C81CF89A6CEBBA1A_724432030 = (mPM.removeUser(id));
        } 
        catch (RemoteException e)
        { }
        addTaint(id);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1297761711 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1297761711;
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.612 -0400", hash_original_method = "C52981B6B26B608864F1952FFD2E785F", hash_generated_method = "4417EB3E02E6716448462D97478FC1FC")
    @Override
    public void updateUserName(int id, String name) {
        addTaint(id);
        addTaint(name.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.612 -0400", hash_original_method = "B193A8F9463928060D13777D952477CD", hash_generated_method = "D32F8A11D82F3C142EEC3FF4520279CC")
    @Override
    public void updateUserFlags(int id, int flags) {
        addTaint(id);
        addTaint(flags);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.613 -0400", hash_original_method = "05FAEEF75E7B74D35A0F0687A4ACD32C", hash_generated_method = "6446769FC2C5F8D8F986E1C2BFDC03AF")
    @Override
    public VerifierDeviceIdentity getVerifierDeviceIdentity() {
        VerifierDeviceIdentity varB4EAC82CA7396A68D541C85D26508E83_1046695874 = null; 
        VerifierDeviceIdentity varB4EAC82CA7396A68D541C85D26508E83_770308895 = null; 
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1046695874 = mPM.getVerifierDeviceIdentity();
        } 
        catch (RemoteException e)
        { }
        varB4EAC82CA7396A68D541C85D26508E83_770308895 = null;
        VerifierDeviceIdentity varA7E53CE21691AB073D9660D615818899_105088394; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_105088394 = varB4EAC82CA7396A68D541C85D26508E83_1046695874;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_105088394 = varB4EAC82CA7396A68D541C85D26508E83_770308895;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_105088394.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_105088394;
        
        
            
        
        
        
    }

    
    private static final class ResourceName {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.614 -0400", hash_original_field = "387F1FA6FC99B8AE187C010A06120611", hash_generated_field = "6F92EE1B3BCDC0C4179CF5FD998BE046")

        String packageName;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.614 -0400", hash_original_field = "D4DDD8F15E145D654808CFEB3504E8E3", hash_generated_field = "5FB1FE173593F2C1352A3849ECD329FE")

        int iconId;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.614 -0400", hash_original_method = "00C0083FA3192C6FB2E9C58DC21ABF99", hash_generated_method = "1E60D2B25AB72FD493F4CCEBE8E14228")
          ResourceName(String _packageName, int _iconId) {
            packageName = _packageName;
            iconId = _iconId;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.615 -0400", hash_original_method = "1D7CABC5D0E2E4029539D2105E7113C1", hash_generated_method = "F4B0DF37D4D0AD07245EBE22412943F8")
          ResourceName(ApplicationInfo aInfo, int _iconId) {
            this(aInfo.packageName, _iconId);
            addTaint(aInfo.getTaint());
            addTaint(_iconId);
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.615 -0400", hash_original_method = "316DD832F87E78ED23C1ED370845ED19", hash_generated_method = "CD60A1612BA3B74B93A271C021B4D340")
          ResourceName(ComponentInfo cInfo, int _iconId) {
            this(cInfo.applicationInfo.packageName, _iconId);
            addTaint(cInfo.getTaint());
            addTaint(_iconId);
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.616 -0400", hash_original_method = "B7E8883725512A2439D57072801DA2BC", hash_generated_method = "DF21CBF5040D1AA4EFF30C198363476D")
          ResourceName(ResolveInfo rInfo, int _iconId) {
            this(rInfo.activityInfo.applicationInfo.packageName, _iconId);
            addTaint(rInfo.getTaint());
            addTaint(_iconId);
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.617 -0400", hash_original_method = "77EA94B0E7A0581CD73B79023B92E268", hash_generated_method = "CD6998848E62AB13797E19C5A863CFB6")
        @Override
        public boolean equals(Object o) {
            {
                boolean var1DE06DCDBE8CB2577D8B96631D951907_2041667656 = (o == null || getClass() != o.getClass());
            } 
            ResourceName that = (ResourceName) o;
            boolean var2CF4425DEC96D908C0E598EDFC75DDA1_1955749436 = (!(packageName != null ?
                     !packageName.equals(that.packageName) : that.packageName != null)); 
            addTaint(o.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_348631048 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_348631048;
            
            
            
            
            
            
                     
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.619 -0400", hash_original_method = "FE96AD3461E654FCE4E8B88F254AC3EE", hash_generated_method = "996C673C74971558FE4DEC04D92ADD1F")
        @Override
        public int hashCode() {
            int result;
            result = packageName.hashCode();
            result = 31 * result + iconId;
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1173593553 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1173593553;
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.620 -0400", hash_original_method = "19C1C9668D8A7EEF540F3D9429936D14", hash_generated_method = "764C0317191FFFC0FFB3AA245E89BE90")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_817240407 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_817240407 = "{ResourceName " + packageName + " / " + iconId + "}";
            varB4EAC82CA7396A68D541C85D26508E83_817240407.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_817240407;
            
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.621 -0400", hash_original_field = "6567C925641831CFA00E9DD4884FA1D6", hash_generated_field = "9103478CE6502665DE73DD4F276104D2")

    private static final String TAG = "ApplicationPackageManager";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.621 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "7841AA055B417A7E8C3D727A4ADDD91D")

    private final static boolean DEBUG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.621 -0400", hash_original_field = "C3489935DD7AFC611D460C12208E5765", hash_generated_field = "D9A207E7F6832116E237531F8566E278")

    private final static boolean DEBUG_ICONS = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.621 -0400", hash_original_field = "2F49D49D71E16DE6B9E03ABB51788CD5", hash_generated_field = "589A8BDF0C7416090F474EA4E832C9BC")

    private static final Object sSync = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.621 -0400", hash_original_field = "86949C5674DAE04FF598125EDFB9A09B", hash_generated_field = "4B02A68E27DCF1DC814B05F533A46F39")

    private static HashMap<ResourceName, WeakReference<Drawable.ConstantState>> sIconCache = new HashMap<ResourceName, WeakReference<Drawable.ConstantState>>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.622 -0400", hash_original_field = "C59A7EE72451F56F2C82359DD275010F", hash_generated_field = "F43C1D13F1C693E3CC3452E528CF10D8")

    private static HashMap<ResourceName, WeakReference<CharSequence>> sStringCache = new HashMap<ResourceName, WeakReference<CharSequence>>();
}

