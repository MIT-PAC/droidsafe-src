package android.app;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:46.833 -0400", hash_original_field = "D582EAEF778B662187C3776F3BC85DE5", hash_generated_field = "BB74ADCE9FCE390733990F175981A8B2")

    int mCachedSafeMode = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:46.833 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "9848C26EA3B1FE04FDB0411428C18F0B")

    private ContextImpl mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:46.834 -0400", hash_original_field = "3D87516393C6B091D0B0E6C38455BD37", hash_generated_field = "7F4B9DC825AA12542DFD4F441E873557")

    private IPackageManager mPM;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:46.894 -0400", hash_original_method = "12FC21630330363415BEFB2BB747FDD4", hash_generated_method = "821E283AA9F20FD120BA751A1DBB238D")
      ApplicationPackageManager(ContextImpl context,
                              IPackageManager pm) {
        mContext = context;
        mPM = pm;
        // ---------- Original Method ----------
        //mContext = context;
        //mPM = pm;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:46.898 -0400", hash_original_method = "B0DADC2DBFEC092F753C36E8DEB385A1", hash_generated_method = "49251FCF4742FC49CDD651C499C8A6FF")
    @Override
    public PackageInfo getPackageInfo(String packageName, int flags) throws NameNotFoundException {
        PackageInfo varB4EAC82CA7396A68D541C85D26508E83_2137258772 = null; //Variable for return #1
        try 
        {
            PackageInfo pi;
            pi = mPM.getPackageInfo(packageName, flags);
            {
                varB4EAC82CA7396A68D541C85D26508E83_2137258772 = pi;
            } //End block
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new NameNotFoundException(packageName);
        addTaint(packageName.getTaint());
        addTaint(flags);
        varB4EAC82CA7396A68D541C85D26508E83_2137258772.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2137258772;
        // ---------- Original Method ----------
        //try {
            //PackageInfo pi = mPM.getPackageInfo(packageName, flags);
            //if (pi != null) {
                //return pi;
            //}
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
        //throw new NameNotFoundException(packageName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:46.919 -0400", hash_original_method = "C5CDEAB4FF073C2ACB7E7915B56F1D0F", hash_generated_method = "20782863E8D787D0B0DFD9DE6D784504")
    @Override
    public String[] currentToCanonicalPackageNames(String[] names) {
        String[] varB4EAC82CA7396A68D541C85D26508E83_1814190291 = null; //Variable for return #1
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1814190291 = mPM.currentToCanonicalPackageNames(names);
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } //End block
        addTaint(names[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1814190291.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1814190291;
        // ---------- Original Method ----------
        //try {
            //return mPM.currentToCanonicalPackageNames(names);
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:46.945 -0400", hash_original_method = "9BD980F14E9EC05077595EA826722236", hash_generated_method = "62224E8C531A156B0FAAFF69F04F228B")
    @Override
    public String[] canonicalToCurrentPackageNames(String[] names) {
        String[] varB4EAC82CA7396A68D541C85D26508E83_1078269757 = null; //Variable for return #1
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1078269757 = mPM.canonicalToCurrentPackageNames(names);
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } //End block
        addTaint(names[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1078269757.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1078269757;
        // ---------- Original Method ----------
        //try {
            //return mPM.canonicalToCurrentPackageNames(names);
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:46.959 -0400", hash_original_method = "A679E3857CF73FF4B9C2EA4F09C7DBB7", hash_generated_method = "A2359920BADB45944D9DE2234B9C41AF")
    @Override
    public Intent getLaunchIntentForPackage(String packageName) {
        Intent varB4EAC82CA7396A68D541C85D26508E83_449630499 = null; //Variable for return #1
        Intent varB4EAC82CA7396A68D541C85D26508E83_620262162 = null; //Variable for return #2
        Intent intentToResolve;
        intentToResolve = new Intent(Intent.ACTION_MAIN);
        intentToResolve.addCategory(Intent.CATEGORY_INFO);
        intentToResolve.setPackage(packageName);
        List<ResolveInfo> ris;
        ris = queryIntentActivities(intentToResolve, 0);
        {
            boolean varBFFD11AFF4B06D0E1D653A2E50FC1BFF_638364458 = (ris == null || ris.size() <= 0);
            {
                intentToResolve.removeCategory(Intent.CATEGORY_INFO);
                intentToResolve.addCategory(Intent.CATEGORY_LAUNCHER);
                intentToResolve.setPackage(packageName);
                ris = queryIntentActivities(intentToResolve, 0);
            } //End block
        } //End collapsed parenthetic
        {
            boolean varBFFD11AFF4B06D0E1D653A2E50FC1BFF_361663246 = (ris == null || ris.size() <= 0);
            {
                varB4EAC82CA7396A68D541C85D26508E83_449630499 = null;
            } //End block
        } //End collapsed parenthetic
        Intent intent;
        intent = new Intent(intentToResolve);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setClassName(ris.get(0).activityInfo.packageName,
                ris.get(0).activityInfo.name);
        varB4EAC82CA7396A68D541C85D26508E83_620262162 = intent;
        addTaint(packageName.getTaint());
        Intent varA7E53CE21691AB073D9660D615818899_1260808235; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1260808235 = varB4EAC82CA7396A68D541C85D26508E83_449630499;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1260808235 = varB4EAC82CA7396A68D541C85D26508E83_620262162;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1260808235.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1260808235;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:46.985 -0400", hash_original_method = "65CBA80193594BC7AC8CBF648823BDBA", hash_generated_method = "7CD819C9BD7E104461F509E517E0570C")
    @Override
    public int[] getPackageGids(String packageName) throws NameNotFoundException {
        try 
        {
            int[] gids;
            gids = mPM.getPackageGids(packageName);
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new NameNotFoundException(packageName);
        addTaint(packageName.getTaint());
        int[] varB4CCCA26F9DB9189C32F33E82D425CFB_1353678795 = {getTaintInt()};
        return varB4CCCA26F9DB9189C32F33E82D425CFB_1353678795;
        // ---------- Original Method ----------
        //try {
            //int[] gids = mPM.getPackageGids(packageName);
            //if (gids == null || gids.length > 0) {
                //return gids;
            //}
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
        //throw new NameNotFoundException(packageName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:46.991 -0400", hash_original_method = "16E2B9223A8B92626D3604D0E58E2278", hash_generated_method = "60146AB859659D72E1EB1377D1B52585")
    @Override
    public PermissionInfo getPermissionInfo(String name, int flags) throws NameNotFoundException {
        PermissionInfo varB4EAC82CA7396A68D541C85D26508E83_1459636110 = null; //Variable for return #1
        try 
        {
            PermissionInfo pi;
            pi = mPM.getPermissionInfo(name, flags);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1459636110 = pi;
            } //End block
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new NameNotFoundException(name);
        addTaint(name.getTaint());
        addTaint(flags);
        varB4EAC82CA7396A68D541C85D26508E83_1459636110.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1459636110;
        // ---------- Original Method ----------
        //try {
            //PermissionInfo pi = mPM.getPermissionInfo(name, flags);
            //if (pi != null) {
                //return pi;
            //}
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
        //throw new NameNotFoundException(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:47.008 -0400", hash_original_method = "2283AA5BDEF3F8B3341260BB74FBE8C3", hash_generated_method = "655CE21462755CA9FFBBFD739528983E")
    @Override
    public List<PermissionInfo> queryPermissionsByGroup(String group, int flags) throws NameNotFoundException {
        List<PermissionInfo> varB4EAC82CA7396A68D541C85D26508E83_93367629 = null; //Variable for return #1
        try 
        {
            List<PermissionInfo> pi;
            pi = mPM.queryPermissionsByGroup(group, flags);
            {
                varB4EAC82CA7396A68D541C85D26508E83_93367629 = pi;
            } //End block
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new NameNotFoundException(group);
        addTaint(group.getTaint());
        addTaint(flags);
        varB4EAC82CA7396A68D541C85D26508E83_93367629.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_93367629;
        // ---------- Original Method ----------
        //try {
            //List<PermissionInfo> pi = mPM.queryPermissionsByGroup(group, flags);
            //if (pi != null) {
                //return pi;
            //}
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
        //throw new NameNotFoundException(group);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:47.032 -0400", hash_original_method = "4E576FD7FE2DDB9674E042581657631F", hash_generated_method = "48D6E80C205A13AC518BFC437CE8AE92")
    @Override
    public PermissionGroupInfo getPermissionGroupInfo(String name,
                                                      int flags) throws NameNotFoundException {
        PermissionGroupInfo varB4EAC82CA7396A68D541C85D26508E83_1340832012 = null; //Variable for return #1
        try 
        {
            PermissionGroupInfo pgi;
            pgi = mPM.getPermissionGroupInfo(name, flags);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1340832012 = pgi;
            } //End block
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new NameNotFoundException(name);
        addTaint(name.getTaint());
        addTaint(flags);
        varB4EAC82CA7396A68D541C85D26508E83_1340832012.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1340832012;
        // ---------- Original Method ----------
        //try {
            //PermissionGroupInfo pgi = mPM.getPermissionGroupInfo(name, flags);
            //if (pgi != null) {
                //return pgi;
            //}
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
        //throw new NameNotFoundException(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:47.050 -0400", hash_original_method = "DD7F1EBA9089D82A0EEA68FDD3DACC66", hash_generated_method = "72441E1875D5A8783FA5ACD1076C7D18")
    @Override
    public List<PermissionGroupInfo> getAllPermissionGroups(int flags) {
        List<PermissionGroupInfo> varB4EAC82CA7396A68D541C85D26508E83_2041597578 = null; //Variable for return #1
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_2041597578 = mPM.getAllPermissionGroups(flags);
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } //End block
        addTaint(flags);
        varB4EAC82CA7396A68D541C85D26508E83_2041597578.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2041597578;
        // ---------- Original Method ----------
        //try {
            //return mPM.getAllPermissionGroups(flags);
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:47.069 -0400", hash_original_method = "8999420BFE5728B346477621EA154ABF", hash_generated_method = "F22C415FAEC936E954BE889E548A189D")
    @Override
    public ApplicationInfo getApplicationInfo(String packageName, int flags) throws NameNotFoundException {
        ApplicationInfo varB4EAC82CA7396A68D541C85D26508E83_415895719 = null; //Variable for return #1
        try 
        {
            ApplicationInfo ai;
            ai = mPM.getApplicationInfo(packageName, flags);
            {
                varB4EAC82CA7396A68D541C85D26508E83_415895719 = ai;
            } //End block
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new NameNotFoundException(packageName);
        addTaint(packageName.getTaint());
        addTaint(flags);
        varB4EAC82CA7396A68D541C85D26508E83_415895719.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_415895719;
        // ---------- Original Method ----------
        //try {
            //ApplicationInfo ai = mPM.getApplicationInfo(packageName, flags);
            //if (ai != null) {
                //return ai;
            //}
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
        //throw new NameNotFoundException(packageName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:47.075 -0400", hash_original_method = "9B4FC7EA40C0BB7AEEEEEF1D86D28DE8", hash_generated_method = "4066B00DCD2C4D42616B71914C31E5A3")
    @Override
    public ActivityInfo getActivityInfo(ComponentName className, int flags) throws NameNotFoundException {
        ActivityInfo varB4EAC82CA7396A68D541C85D26508E83_1095387232 = null; //Variable for return #1
        try 
        {
            ActivityInfo ai;
            ai = mPM.getActivityInfo(className, flags);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1095387232 = ai;
            } //End block
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new NameNotFoundException(className.toString());
        addTaint(className.getTaint());
        addTaint(flags);
        varB4EAC82CA7396A68D541C85D26508E83_1095387232.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1095387232;
        // ---------- Original Method ----------
        //try {
            //ActivityInfo ai = mPM.getActivityInfo(className, flags);
            //if (ai != null) {
                //return ai;
            //}
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
        //throw new NameNotFoundException(className.toString());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:47.093 -0400", hash_original_method = "399255B19735D8EC733B05B14D3B4711", hash_generated_method = "912E987F7B225F2F8E43BA15C61DEE23")
    @Override
    public ActivityInfo getReceiverInfo(ComponentName className, int flags) throws NameNotFoundException {
        ActivityInfo varB4EAC82CA7396A68D541C85D26508E83_1153789643 = null; //Variable for return #1
        try 
        {
            ActivityInfo ai;
            ai = mPM.getReceiverInfo(className, flags);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1153789643 = ai;
            } //End block
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new NameNotFoundException(className.toString());
        addTaint(className.getTaint());
        addTaint(flags);
        varB4EAC82CA7396A68D541C85D26508E83_1153789643.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1153789643;
        // ---------- Original Method ----------
        //try {
            //ActivityInfo ai = mPM.getReceiverInfo(className, flags);
            //if (ai != null) {
                //return ai;
            //}
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
        //throw new NameNotFoundException(className.toString());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:47.115 -0400", hash_original_method = "50C1BC4F3995D229FF03E27E05E5BE36", hash_generated_method = "91B8DEE65B2DF8877953DAB47D5BF740")
    @Override
    public ServiceInfo getServiceInfo(ComponentName className, int flags) throws NameNotFoundException {
        ServiceInfo varB4EAC82CA7396A68D541C85D26508E83_1929922629 = null; //Variable for return #1
        try 
        {
            ServiceInfo si;
            si = mPM.getServiceInfo(className, flags);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1929922629 = si;
            } //End block
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new NameNotFoundException(className.toString());
        addTaint(className.getTaint());
        addTaint(flags);
        varB4EAC82CA7396A68D541C85D26508E83_1929922629.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1929922629;
        // ---------- Original Method ----------
        //try {
            //ServiceInfo si = mPM.getServiceInfo(className, flags);
            //if (si != null) {
                //return si;
            //}
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
        //throw new NameNotFoundException(className.toString());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:47.122 -0400", hash_original_method = "895E4F29ECA72E6836B6F503A466760A", hash_generated_method = "B1BB43FF811FAECEAC7CE9DBA887BB0C")
    @Override
    public ProviderInfo getProviderInfo(ComponentName className, int flags) throws NameNotFoundException {
        ProviderInfo varB4EAC82CA7396A68D541C85D26508E83_1284294483 = null; //Variable for return #1
        try 
        {
            ProviderInfo pi;
            pi = mPM.getProviderInfo(className, flags);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1284294483 = pi;
            } //End block
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new NameNotFoundException(className.toString());
        addTaint(className.getTaint());
        addTaint(flags);
        varB4EAC82CA7396A68D541C85D26508E83_1284294483.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1284294483;
        // ---------- Original Method ----------
        //try {
            //ProviderInfo pi = mPM.getProviderInfo(className, flags);
            //if (pi != null) {
                //return pi;
            //}
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
        //throw new NameNotFoundException(className.toString());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:47.145 -0400", hash_original_method = "E90BE84736723B0914BD9D43484D5AAD", hash_generated_method = "3CEB472A2F19F36DDDD2C663CD848E5B")
    @Override
    public String[] getSystemSharedLibraryNames() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_1139328613 = null; //Variable for return #1
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1139328613 = mPM.getSystemSharedLibraryNames();
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1139328613.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1139328613;
        // ---------- Original Method ----------
        //try {
            //return mPM.getSystemSharedLibraryNames();
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:47.158 -0400", hash_original_method = "887B55B734ED0895C5FA7D7CF721CE58", hash_generated_method = "D576CD1132DEF1784A467FACB4BE46AA")
    @Override
    public FeatureInfo[] getSystemAvailableFeatures() {
        FeatureInfo[] varB4EAC82CA7396A68D541C85D26508E83_691880416 = null; //Variable for return #1
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_691880416 = mPM.getSystemAvailableFeatures();
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_691880416.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_691880416;
        // ---------- Original Method ----------
        //try {
            //return mPM.getSystemAvailableFeatures();
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:47.159 -0400", hash_original_method = "8E2B8D0B6C29BED8B3E866F74247B636", hash_generated_method = "C801487B661C496D45EC40EB00E3110C")
    @Override
    public boolean hasSystemFeature(String name) {
        try 
        {
            boolean varD59F1F4384BD648C5D21225C24B9C301_664085445 = (mPM.hasSystemFeature(name));
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } //End block
        addTaint(name.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1225304182 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1225304182;
        // ---------- Original Method ----------
        //try {
            //return mPM.hasSystemFeature(name);
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:47.181 -0400", hash_original_method = "D191D3716589DABF1290937DD7F4276D", hash_generated_method = "45707AC7FFDCA2C84A49E65097B19149")
    @Override
    public int checkPermission(String permName, String pkgName) {
        try 
        {
            int varC24F180D5E6F6659DC5818809EF3416E_1255761450 = (mPM.checkPermission(permName, pkgName));
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } //End block
        addTaint(permName.getTaint());
        addTaint(pkgName.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_404306805 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_404306805;
        // ---------- Original Method ----------
        //try {
            //return mPM.checkPermission(permName, pkgName);
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:47.202 -0400", hash_original_method = "7DE747A31A0FDE2C95A03117CF8EC1E2", hash_generated_method = "699A1996239E9516E124A57B947E7397")
    @Override
    public boolean addPermission(PermissionInfo info) {
        try 
        {
            boolean var16B313AE31B83011C28287E1893A6A9C_1275840762 = (mPM.addPermission(info));
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } //End block
        addTaint(info.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_221160591 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_221160591;
        // ---------- Original Method ----------
        //try {
            //return mPM.addPermission(info);
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:47.211 -0400", hash_original_method = "BE955F868C92CCDF8275E95FFE2C44B3", hash_generated_method = "CC9BDA3941EAB7F13367E742D9F4F0E7")
    @Override
    public boolean addPermissionAsync(PermissionInfo info) {
        try 
        {
            boolean var3B1BC13408FAB0EED9E6C97798235DF8_1248719264 = (mPM.addPermissionAsync(info));
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } //End block
        addTaint(info.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_552507170 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_552507170;
        // ---------- Original Method ----------
        //try {
            //return mPM.addPermissionAsync(info);
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:47.213 -0400", hash_original_method = "3B9F25E30931EF93125264B719A2E2FF", hash_generated_method = "10FF1DF162216143C55B2A2B5A44D0D4")
    @Override
    public void removePermission(String name) {
        try 
        {
            mPM.removePermission(name);
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } //End block
        addTaint(name.getTaint());
        // ---------- Original Method ----------
        //try {
            //mPM.removePermission(name);
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:47.231 -0400", hash_original_method = "7DC6A4F902E735FA721489587F3384CC", hash_generated_method = "DE272B4641DE29FCB276D2D3F798AB2F")
    @Override
    public int checkSignatures(String pkg1, String pkg2) {
        try 
        {
            int var48FD7299CCE20AFA5ACAC7362163506B_1234778485 = (mPM.checkSignatures(pkg1, pkg2));
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } //End block
        addTaint(pkg1.getTaint());
        addTaint(pkg2.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_525741525 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_525741525;
        // ---------- Original Method ----------
        //try {
            //return mPM.checkSignatures(pkg1, pkg2);
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:47.243 -0400", hash_original_method = "E51AFA66F0FA11E52A6A449B49344AE4", hash_generated_method = "B8E99B91F99804BC19E30C41E4D0B2BB")
    @Override
    public int checkSignatures(int uid1, int uid2) {
        try 
        {
            int varCB0D2D55990C866D4BAF222264E4D604_1861279141 = (mPM.checkUidSignatures(uid1, uid2));
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } //End block
        addTaint(uid1);
        addTaint(uid2);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_108158573 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_108158573;
        // ---------- Original Method ----------
        //try {
            //return mPM.checkUidSignatures(uid1, uid2);
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:47.317 -0400", hash_original_method = "A565AD9EB181443BBE8F338808A2E4B9", hash_generated_method = "6AA3F9C79ACEAF4BFF908B6B8DC0565A")
    @Override
    public String[] getPackagesForUid(int uid) {
        String[] varB4EAC82CA7396A68D541C85D26508E83_1826570148 = null; //Variable for return #1
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1826570148 = mPM.getPackagesForUid(uid);
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } //End block
        addTaint(uid);
        varB4EAC82CA7396A68D541C85D26508E83_1826570148.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1826570148;
        // ---------- Original Method ----------
        //try {
            //return mPM.getPackagesForUid(uid);
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:47.342 -0400", hash_original_method = "107797D329CAA491AA1A678294A11B0E", hash_generated_method = "6AF88A2D31562FD7CA46741990311917")
    @Override
    public String getNameForUid(int uid) {
        String varB4EAC82CA7396A68D541C85D26508E83_903872975 = null; //Variable for return #1
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_903872975 = mPM.getNameForUid(uid);
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } //End block
        addTaint(uid);
        varB4EAC82CA7396A68D541C85D26508E83_903872975.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_903872975;
        // ---------- Original Method ----------
        //try {
            //return mPM.getNameForUid(uid);
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:47.343 -0400", hash_original_method = "BCD62F04CBDED38DF225700C99BB4852", hash_generated_method = "D6A6E2BC575BCC3F599B6097348DEDFF")
    @Override
    public int getUidForSharedUser(String sharedUserName) throws NameNotFoundException {
        try 
        {
            int uid;
            uid = mPM.getUidForSharedUser(sharedUserName);
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new NameNotFoundException("No shared userid for user:"+sharedUserName);
        addTaint(sharedUserName.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_939651628 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_939651628;
        // ---------- Original Method ----------
        //try {
            //int uid = mPM.getUidForSharedUser(sharedUserName);
            //if(uid != -1) {
                //return uid;
            //}
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
        //throw new NameNotFoundException("No shared userid for user:"+sharedUserName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:47.365 -0400", hash_original_method = "2CD6168D318C89447F6184EBDE96189F", hash_generated_method = "D3CC57E81B6F36C8C8A8FB092108BC95")
    @SuppressWarnings("unchecked")
    @Override
    public List<PackageInfo> getInstalledPackages(int flags) {
        List<PackageInfo> varB4EAC82CA7396A68D541C85D26508E83_187256631 = null; //Variable for return #1
        try 
        {
            List<PackageInfo> packageInfos;
            packageInfos = new ArrayList<PackageInfo>();
            PackageInfo lastItem;
            lastItem = null;
            ParceledListSlice<PackageInfo> slice;
            {
                String lastKey;
                lastKey = lastItem.packageName;
                lastKey = null;
                slice = mPM.getInstalledPackages(flags, lastKey);
                lastItem = slice.populateList(packageInfos, PackageInfo.CREATOR);
            } //End block
            {
                boolean varAF04EF32C9AC89657E6048F98D47E5E7_1130318409 = (!slice.isLastSlice());
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_187256631 = packageInfos;
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } //End block
        addTaint(flags);
        varB4EAC82CA7396A68D541C85D26508E83_187256631.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_187256631;
        // ---------- Original Method ----------
        //try {
            //final List<PackageInfo> packageInfos = new ArrayList<PackageInfo>();
            //PackageInfo lastItem = null;
            //ParceledListSlice<PackageInfo> slice;
            //do {
                //final String lastKey = lastItem != null ? lastItem.packageName : null;
                //slice = mPM.getInstalledPackages(flags, lastKey);
                //lastItem = slice.populateList(packageInfos, PackageInfo.CREATOR);
            //} while (!slice.isLastSlice());
            //return packageInfos;
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:47.400 -0400", hash_original_method = "195CA5538214D0B5EDE14A1F47A96E96", hash_generated_method = "6B0F2E2E00BB39480524FFC80BF3AE08")
    @SuppressWarnings("unchecked")
    @Override
    public List<ApplicationInfo> getInstalledApplications(int flags) {
        List<ApplicationInfo> varB4EAC82CA7396A68D541C85D26508E83_1920392225 = null; //Variable for return #1
        try 
        {
            List<ApplicationInfo> applicationInfos;
            applicationInfos = new ArrayList<ApplicationInfo>();
            ApplicationInfo lastItem;
            lastItem = null;
            ParceledListSlice<ApplicationInfo> slice;
            {
                String lastKey;
                lastKey = lastItem.packageName;
                lastKey = null;
                slice = mPM.getInstalledApplications(flags, lastKey);
                lastItem = slice.populateList(applicationInfos, ApplicationInfo.CREATOR);
            } //End block
            {
                boolean varAF04EF32C9AC89657E6048F98D47E5E7_1371732428 = (!slice.isLastSlice());
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_1920392225 = applicationInfos;
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } //End block
        addTaint(flags);
        varB4EAC82CA7396A68D541C85D26508E83_1920392225.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1920392225;
        // ---------- Original Method ----------
        //try {
            //final List<ApplicationInfo> applicationInfos = new ArrayList<ApplicationInfo>();
            //ApplicationInfo lastItem = null;
            //ParceledListSlice<ApplicationInfo> slice;
            //do {
                //final String lastKey = lastItem != null ? lastItem.packageName : null;
                //slice = mPM.getInstalledApplications(flags, lastKey);
                //lastItem = slice.populateList(applicationInfos, ApplicationInfo.CREATOR);
            //} while (!slice.isLastSlice());
            //return applicationInfos;
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:47.431 -0400", hash_original_method = "0CD7CD39AE65A355BC33F2BA54C4DC37", hash_generated_method = "0C6629A45E4DE14B72C448570BD920A6")
    @Override
    public ResolveInfo resolveActivity(Intent intent, int flags) {
        ResolveInfo varB4EAC82CA7396A68D541C85D26508E83_1987508798 = null; //Variable for return #1
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1987508798 = mPM.resolveIntent(
                intent,
                intent.resolveTypeIfNeeded(mContext.getContentResolver()),
                flags);
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } //End block
        addTaint(intent.getTaint());
        addTaint(flags);
        varB4EAC82CA7396A68D541C85D26508E83_1987508798.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1987508798;
        // ---------- Original Method ----------
        //try {
            //return mPM.resolveIntent(
                //intent,
                //intent.resolveTypeIfNeeded(mContext.getContentResolver()),
                //flags);
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:47.446 -0400", hash_original_method = "613ED89A001624360A0EB6B3BD081707", hash_generated_method = "552DD723AE7C5DA0905EA3828DB2C96F")
    @Override
    public List<ResolveInfo> queryIntentActivities(Intent intent,
                                                   int flags) {
        List<ResolveInfo> varB4EAC82CA7396A68D541C85D26508E83_1226793422 = null; //Variable for return #1
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1226793422 = mPM.queryIntentActivities(
                intent,
                intent.resolveTypeIfNeeded(mContext.getContentResolver()),
                flags);
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } //End block
        addTaint(intent.getTaint());
        addTaint(flags);
        varB4EAC82CA7396A68D541C85D26508E83_1226793422.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1226793422;
        // ---------- Original Method ----------
        //try {
            //return mPM.queryIntentActivities(
                //intent,
                //intent.resolveTypeIfNeeded(mContext.getContentResolver()),
                //flags);
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:47.476 -0400", hash_original_method = "9B955FD88A95F7C1CCD0CD1DFE6EC270", hash_generated_method = "AF0F6D832CFEAB4D8C4424A83322C2BA")
    @Override
    public List<ResolveInfo> queryIntentActivityOptions(
        ComponentName caller, Intent[] specifics, Intent intent,
        int flags) {
        List<ResolveInfo> varB4EAC82CA7396A68D541C85D26508E83_1509687665 = null; //Variable for return #1
        ContentResolver resolver;
        resolver = mContext.getContentResolver();
        String[] specificTypes;
        specificTypes = null;
        {
            int N;
            N = specifics.length;
            {
                int i;
                i = 0;
                {
                    Intent sp;
                    sp = specifics[i];
                    {
                        String t;
                        t = sp.resolveTypeIfNeeded(resolver);
                        {
                            {
                                specificTypes = new String[N];
                            } //End block
                            specificTypes[i] = t;
                        } //End block
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1509687665 = mPM.queryIntentActivityOptions(caller, specifics,
                                                  specificTypes, intent, intent.resolveTypeIfNeeded(resolver),
                                                  flags);
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } //End block
        addTaint(caller.getTaint());
        addTaint(specifics[0].getTaint());
        addTaint(intent.getTaint());
        addTaint(flags);
        varB4EAC82CA7396A68D541C85D26508E83_1509687665.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1509687665;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:47.505 -0400", hash_original_method = "2B65A8BDA3BE53DC3296D1F5CA76CDFC", hash_generated_method = "5189E2880A1821A21BE27C36142C678C")
    @Override
    public List<ResolveInfo> queryBroadcastReceivers(Intent intent, int flags) {
        List<ResolveInfo> varB4EAC82CA7396A68D541C85D26508E83_1100145377 = null; //Variable for return #1
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1100145377 = mPM.queryIntentReceivers(
                intent,
                intent.resolveTypeIfNeeded(mContext.getContentResolver()),
                flags);
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } //End block
        addTaint(intent.getTaint());
        addTaint(flags);
        varB4EAC82CA7396A68D541C85D26508E83_1100145377.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1100145377;
        // ---------- Original Method ----------
        //try {
            //return mPM.queryIntentReceivers(
                //intent,
                //intent.resolveTypeIfNeeded(mContext.getContentResolver()),
                //flags);
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:47.523 -0400", hash_original_method = "D7D4C733DB611C9D18D346868F9BD0BD", hash_generated_method = "67E962768C4A706CDFE185FD029CCA02")
    @Override
    public ResolveInfo resolveService(Intent intent, int flags) {
        ResolveInfo varB4EAC82CA7396A68D541C85D26508E83_1274710936 = null; //Variable for return #1
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1274710936 = mPM.resolveService(
                intent,
                intent.resolveTypeIfNeeded(mContext.getContentResolver()),
                flags);
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } //End block
        addTaint(intent.getTaint());
        addTaint(flags);
        varB4EAC82CA7396A68D541C85D26508E83_1274710936.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1274710936;
        // ---------- Original Method ----------
        //try {
            //return mPM.resolveService(
                //intent,
                //intent.resolveTypeIfNeeded(mContext.getContentResolver()),
                //flags);
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:47.562 -0400", hash_original_method = "EEB4EB852740846BAD76CCDE5FC0C613", hash_generated_method = "962F34CF171D8108E563C3E9120CF729")
    @Override
    public List<ResolveInfo> queryIntentServices(Intent intent, int flags) {
        List<ResolveInfo> varB4EAC82CA7396A68D541C85D26508E83_1271619507 = null; //Variable for return #1
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1271619507 = mPM.queryIntentServices(
                intent,
                intent.resolveTypeIfNeeded(mContext.getContentResolver()),
                flags);
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } //End block
        addTaint(intent.getTaint());
        addTaint(flags);
        varB4EAC82CA7396A68D541C85D26508E83_1271619507.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1271619507;
        // ---------- Original Method ----------
        //try {
            //return mPM.queryIntentServices(
                //intent,
                //intent.resolveTypeIfNeeded(mContext.getContentResolver()),
                //flags);
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:47.587 -0400", hash_original_method = "3A6513CB26C2E0AF7DACFC2B8A5D560B", hash_generated_method = "9D5B22B442343C8C5C14616B70E0F991")
    @Override
    public ProviderInfo resolveContentProvider(String name,
                                               int flags) {
        ProviderInfo varB4EAC82CA7396A68D541C85D26508E83_830892641 = null; //Variable for return #1
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_830892641 = mPM.resolveContentProvider(name, flags);
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } //End block
        addTaint(name.getTaint());
        addTaint(flags);
        varB4EAC82CA7396A68D541C85D26508E83_830892641.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_830892641;
        // ---------- Original Method ----------
        //try {
            //return mPM.resolveContentProvider(name, flags);
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:47.604 -0400", hash_original_method = "7B04A4BE8EFECF5209DBE4F77CB67C42", hash_generated_method = "FEC92F729234E5F03DD34A67A44F3930")
    @Override
    public List<ProviderInfo> queryContentProviders(String processName,
                                                    int uid, int flags) {
        List<ProviderInfo> varB4EAC82CA7396A68D541C85D26508E83_385714827 = null; //Variable for return #1
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_385714827 = mPM.queryContentProviders(processName, uid, flags);
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } //End block
        addTaint(processName.getTaint());
        addTaint(uid);
        addTaint(flags);
        varB4EAC82CA7396A68D541C85D26508E83_385714827.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_385714827;
        // ---------- Original Method ----------
        //try {
            //return mPM.queryContentProviders(processName, uid, flags);
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:47.616 -0400", hash_original_method = "3120887453BFC9391A593077A4EB2D8C", hash_generated_method = "488AA0E2CC95D19B5AEFB02658B80E64")
    @Override
    public InstrumentationInfo getInstrumentationInfo(
        ComponentName className, int flags) throws NameNotFoundException {
        InstrumentationInfo varB4EAC82CA7396A68D541C85D26508E83_2143143883 = null; //Variable for return #1
        try 
        {
            InstrumentationInfo ii;
            ii = mPM.getInstrumentationInfo(
                className, flags);
            {
                varB4EAC82CA7396A68D541C85D26508E83_2143143883 = ii;
            } //End block
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new NameNotFoundException(className.toString());
        addTaint(className.getTaint());
        addTaint(flags);
        varB4EAC82CA7396A68D541C85D26508E83_2143143883.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2143143883;
        // ---------- Original Method ----------
        //try {
            //InstrumentationInfo ii = mPM.getInstrumentationInfo(
                //className, flags);
            //if (ii != null) {
                //return ii;
            //}
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
        //throw new NameNotFoundException(className.toString());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:47.647 -0400", hash_original_method = "0CE547FAA1F9EB003838A9DE59E3AC72", hash_generated_method = "F3B6C3A9BDAC19861E9761C1A4981CDD")
    @Override
    public List<InstrumentationInfo> queryInstrumentation(
        String targetPackage, int flags) {
        List<InstrumentationInfo> varB4EAC82CA7396A68D541C85D26508E83_1211418653 = null; //Variable for return #1
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1211418653 = mPM.queryInstrumentation(targetPackage, flags);
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } //End block
        addTaint(targetPackage.getTaint());
        addTaint(flags);
        varB4EAC82CA7396A68D541C85D26508E83_1211418653.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1211418653;
        // ---------- Original Method ----------
        //try {
            //return mPM.queryInstrumentation(targetPackage, flags);
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:47.702 -0400", hash_original_method = "350CC4BDDD2E42419F88F44C033409F6", hash_generated_method = "5118706F38FFD72250379B3E4F037E7B")
    @Override
    public Drawable getDrawable(String packageName, int resid,
                                          ApplicationInfo appInfo) {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_1969135201 = null; //Variable for return #1
        Drawable varB4EAC82CA7396A68D541C85D26508E83_113344348 = null; //Variable for return #2
        Drawable varB4EAC82CA7396A68D541C85D26508E83_1850035767 = null; //Variable for return #3
        Drawable varB4EAC82CA7396A68D541C85D26508E83_1345688264 = null; //Variable for return #4
        ResourceName name;
        name = new ResourceName(packageName, resid);
        Drawable dr;
        dr = getCachedIcon(name);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1969135201 = dr;
        } //End block
        {
            try 
            {
                appInfo = getApplicationInfo(packageName, 0);
            } //End block
            catch (NameNotFoundException e)
            {
                varB4EAC82CA7396A68D541C85D26508E83_113344348 = null;
            } //End block
        } //End block
        try 
        {
            Resources r;
            r = getResourcesForApplication(appInfo);
            dr = r.getDrawable(resid);
            {
                RuntimeException e;
                e = new RuntimeException("here");
                e.fillInStackTrace();
            } //End block
            putCachedIcon(name, dr);
            varB4EAC82CA7396A68D541C85D26508E83_1850035767 = dr;
        } //End block
        catch (NameNotFoundException e)
        { }
        catch (Resources.NotFoundException e)
        { }
        catch (RuntimeException e)
        { }
        varB4EAC82CA7396A68D541C85D26508E83_1345688264 = null;
        addTaint(packageName.getTaint());
        addTaint(resid);
        addTaint(appInfo.getTaint());
        Drawable varA7E53CE21691AB073D9660D615818899_439085686; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_439085686 = varB4EAC82CA7396A68D541C85D26508E83_1969135201;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_439085686 = varB4EAC82CA7396A68D541C85D26508E83_113344348;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_439085686 = varB4EAC82CA7396A68D541C85D26508E83_1850035767;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_439085686 = varB4EAC82CA7396A68D541C85D26508E83_1345688264;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_439085686.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_439085686;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:47.719 -0400", hash_original_method = "E8823DE045849946097DF943F50B58DB", hash_generated_method = "B82B2AF3976C843182C802111287A382")
    @Override
    public Drawable getActivityIcon(ComponentName activityName) throws NameNotFoundException {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_1910902993 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1910902993 = getActivityInfo(activityName, 0).loadIcon(this);
        addTaint(activityName.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1910902993.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1910902993;
        // ---------- Original Method ----------
        //return getActivityInfo(activityName, 0).loadIcon(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:47.734 -0400", hash_original_method = "EF5F409F30F5D50F1964B6AB6B7F75B7", hash_generated_method = "C6D163C7180E927927B2197D21A7FC5A")
    @Override
    public Drawable getActivityIcon(Intent intent) throws NameNotFoundException {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_497200950 = null; //Variable for return #1
        Drawable varB4EAC82CA7396A68D541C85D26508E83_240392767 = null; //Variable for return #2
        {
            boolean var2CB4FD776F3AF8424EA4E2E544217AF5_1476602610 = (intent.getComponent() != null);
            {
                varB4EAC82CA7396A68D541C85D26508E83_497200950 = getActivityIcon(intent.getComponent());
            } //End block
        } //End collapsed parenthetic
        ResolveInfo info;
        info = resolveActivity(
            intent, PackageManager.MATCH_DEFAULT_ONLY);
        {
            varB4EAC82CA7396A68D541C85D26508E83_240392767 = info.activityInfo.loadIcon(this);
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new NameNotFoundException(intent.toUri(0));
        addTaint(intent.getTaint());
        Drawable varA7E53CE21691AB073D9660D615818899_106417457; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_106417457 = varB4EAC82CA7396A68D541C85D26508E83_497200950;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_106417457 = varB4EAC82CA7396A68D541C85D26508E83_240392767;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_106417457.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_106417457;
        // ---------- Original Method ----------
        //if (intent.getComponent() != null) {
            //return getActivityIcon(intent.getComponent());
        //}
        //ResolveInfo info = resolveActivity(
            //intent, PackageManager.MATCH_DEFAULT_ONLY);
        //if (info != null) {
            //return info.activityInfo.loadIcon(this);
        //}
        //throw new NameNotFoundException(intent.toUri(0));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:47.761 -0400", hash_original_method = "27F8B828FEA8943560AD77E4760B6964", hash_generated_method = "60C58399E2598AD0B785F95A209F2379")
    @Override
    public Drawable getDefaultActivityIcon() {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_237743725 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_237743725 = Resources.getSystem().getDrawable(
            com.android.internal.R.drawable.sym_def_app_icon);
        varB4EAC82CA7396A68D541C85D26508E83_237743725.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_237743725;
        // ---------- Original Method ----------
        //return Resources.getSystem().getDrawable(
            //com.android.internal.R.drawable.sym_def_app_icon);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:47.782 -0400", hash_original_method = "C2186A062EDEC18E9DD8F87E8E6291D1", hash_generated_method = "E585D7439ABD8380680126869DA91AB0")
    @Override
    public Drawable getApplicationIcon(ApplicationInfo info) {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_1897956705 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1897956705 = info.loadIcon(this);
        addTaint(info.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1897956705.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1897956705;
        // ---------- Original Method ----------
        //return info.loadIcon(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:47.784 -0400", hash_original_method = "49256B647BD52234F52BC973E3B03E0B", hash_generated_method = "94892F257A97F91DD11B80C977A680EB")
    @Override
    public Drawable getApplicationIcon(String packageName) throws NameNotFoundException {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_1947247365 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1947247365 = getApplicationIcon(getApplicationInfo(packageName, 0));
        addTaint(packageName.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1947247365.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1947247365;
        // ---------- Original Method ----------
        //return getApplicationIcon(getApplicationInfo(packageName, 0));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:47.805 -0400", hash_original_method = "12128D2FB1F753A28280A7EF3E62F4B2", hash_generated_method = "FD28814B0C0E09F1A33914B5FC568A9A")
    @Override
    public Drawable getActivityLogo(ComponentName activityName) throws NameNotFoundException {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_301035001 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_301035001 = getActivityInfo(activityName, 0).loadLogo(this);
        addTaint(activityName.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_301035001.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_301035001;
        // ---------- Original Method ----------
        //return getActivityInfo(activityName, 0).loadLogo(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:47.833 -0400", hash_original_method = "3B1A86BB5E25FB8EFA7A1AD1A88B3B01", hash_generated_method = "457264114B0F48475B54457D2DE519C7")
    @Override
    public Drawable getActivityLogo(Intent intent) throws NameNotFoundException {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_750479239 = null; //Variable for return #1
        Drawable varB4EAC82CA7396A68D541C85D26508E83_815189905 = null; //Variable for return #2
        {
            boolean var2CB4FD776F3AF8424EA4E2E544217AF5_1408718314 = (intent.getComponent() != null);
            {
                varB4EAC82CA7396A68D541C85D26508E83_750479239 = getActivityLogo(intent.getComponent());
            } //End block
        } //End collapsed parenthetic
        ResolveInfo info;
        info = resolveActivity(
            intent, PackageManager.MATCH_DEFAULT_ONLY);
        {
            varB4EAC82CA7396A68D541C85D26508E83_815189905 = info.activityInfo.loadLogo(this);
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new NameNotFoundException(intent.toUri(0));
        addTaint(intent.getTaint());
        Drawable varA7E53CE21691AB073D9660D615818899_1956985552; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1956985552 = varB4EAC82CA7396A68D541C85D26508E83_750479239;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1956985552 = varB4EAC82CA7396A68D541C85D26508E83_815189905;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1956985552.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1956985552;
        // ---------- Original Method ----------
        //if (intent.getComponent() != null) {
            //return getActivityLogo(intent.getComponent());
        //}
        //ResolveInfo info = resolveActivity(
            //intent, PackageManager.MATCH_DEFAULT_ONLY);
        //if (info != null) {
            //return info.activityInfo.loadLogo(this);
        //}
        //throw new NameNotFoundException(intent.toUri(0));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:47.870 -0400", hash_original_method = "586E62978169D56092172114763F9AD3", hash_generated_method = "296C7C6DBDE4915C97E833B9AE689168")
    @Override
    public Drawable getApplicationLogo(ApplicationInfo info) {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_689997949 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_689997949 = info.loadLogo(this);
        addTaint(info.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_689997949.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_689997949;
        // ---------- Original Method ----------
        //return info.loadLogo(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:47.882 -0400", hash_original_method = "6BC85FEDD3936A7851329E2331D0279D", hash_generated_method = "1DC39EC10CBB75F084736E0CC627ABD4")
    @Override
    public Drawable getApplicationLogo(String packageName) throws NameNotFoundException {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_1001956612 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1001956612 = getApplicationLogo(getApplicationInfo(packageName, 0));
        addTaint(packageName.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1001956612.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1001956612;
        // ---------- Original Method ----------
        //return getApplicationLogo(getApplicationInfo(packageName, 0));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:47.884 -0400", hash_original_method = "E07E3E36CD8F79CF4FE12B9F33A40344", hash_generated_method = "5029A340D054DFAB49B626C61810BF75")
    @Override
    public Resources getResourcesForActivity(
        ComponentName activityName) throws NameNotFoundException {
        Resources varB4EAC82CA7396A68D541C85D26508E83_248726552 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_248726552 = getResourcesForApplication(
            getActivityInfo(activityName, 0).applicationInfo);
        addTaint(activityName.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_248726552.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_248726552;
        // ---------- Original Method ----------
        //return getResourcesForApplication(
            //getActivityInfo(activityName, 0).applicationInfo);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:47.909 -0400", hash_original_method = "AC20F77416CABFA638F647DA9F2F230E", hash_generated_method = "CB0A74ABDF50819189137604884088DB")
    @Override
    public Resources getResourcesForApplication(
        ApplicationInfo app) throws NameNotFoundException {
        Resources varB4EAC82CA7396A68D541C85D26508E83_1509953624 = null; //Variable for return #1
        Resources varB4EAC82CA7396A68D541C85D26508E83_658729260 = null; //Variable for return #2
        {
            boolean varF67FB556D575A0DB52E0C311AE1F282F_176826601 = (app.packageName.equals("system"));
            {
                varB4EAC82CA7396A68D541C85D26508E83_1509953624 = mContext.mMainThread.getSystemContext().getResources();
            } //End block
        } //End collapsed parenthetic
        Resources r;
        r = mContext.mMainThread.getTopLevelResources(
            app.uid == Process.myUid() ? app.sourceDir
            : app.publicSourceDir, mContext.mPackageInfo);//DSFIXME:  CODE0008: Nested ternary operator in expression
        {
            varB4EAC82CA7396A68D541C85D26508E83_658729260 = r;
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new NameNotFoundException("Unable to open " + app.publicSourceDir);
        addTaint(app.getTaint());
        Resources varA7E53CE21691AB073D9660D615818899_1354350176; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1354350176 = varB4EAC82CA7396A68D541C85D26508E83_1509953624;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1354350176 = varB4EAC82CA7396A68D541C85D26508E83_658729260;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1354350176.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1354350176;
        // ---------- Original Method ----------
        //if (app.packageName.equals("system")) {
            //return mContext.mMainThread.getSystemContext().getResources();
        //}
        //Resources r = mContext.mMainThread.getTopLevelResources(
            //app.uid == Process.myUid() ? app.sourceDir
            //: app.publicSourceDir, mContext.mPackageInfo);
        //if (r != null) {
            //return r;
        //}
        //throw new NameNotFoundException("Unable to open " + app.publicSourceDir);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:47.941 -0400", hash_original_method = "ACD444E0FC7FCEAEB5D1FF09DD4A5912", hash_generated_method = "0A11BAF3947FB08B6F3EAB4E108882B6")
    @Override
    public Resources getResourcesForApplication(
        String appPackageName) throws NameNotFoundException {
        Resources varB4EAC82CA7396A68D541C85D26508E83_1903281050 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1903281050 = getResourcesForApplication(
            getApplicationInfo(appPackageName, 0));
        addTaint(appPackageName.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1903281050.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1903281050;
        // ---------- Original Method ----------
        //return getResourcesForApplication(
            //getApplicationInfo(appPackageName, 0));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:47.943 -0400", hash_original_method = "6B2AA9A609FE89D703EEC81AF1FC0890", hash_generated_method = "1A40BD939DDF27807E9BF4BDABF3399A")
    @Override
    public boolean isSafeMode() {
        try 
        {
            {
                mCachedSafeMode = mPM.isSafeMode() ? 1 : 0;
            } //End block
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1949102468 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1949102468;
        // ---------- Original Method ----------
        //try {
            //if (mCachedSafeMode < 0) {
                //mCachedSafeMode = mPM.isSafeMode() ? 1 : 0;
            //}
            //return mCachedSafeMode != 0;
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
    }

    
        static void configurationChanged() {
        synchronized (sSync) {
            sIconCache.clear();
            sStringCache.clear();
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:47.977 -0400", hash_original_method = "805BC435FDAE098AFC4F53B40E89D7C1", hash_generated_method = "46B2D8983539A9B05E7582EDD3A3F024")
    private Drawable getCachedIcon(ResourceName name) {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_613380903 = null; //Variable for return #1
        Drawable varB4EAC82CA7396A68D541C85D26508E83_1083979512 = null; //Variable for return #2
        {
            WeakReference<Drawable.ConstantState> wr;
            wr = sIconCache.get(name);
            {
                Drawable.ConstantState state;
                state = wr.get();
                {
                    varB4EAC82CA7396A68D541C85D26508E83_613380903 = state.newDrawable();
                } //End block
                sIconCache.remove(name);
            } //End block
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1083979512 = null;
        addTaint(name.getTaint());
        Drawable varA7E53CE21691AB073D9660D615818899_1914881349; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1914881349 = varB4EAC82CA7396A68D541C85D26508E83_613380903;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1914881349 = varB4EAC82CA7396A68D541C85D26508E83_1083979512;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1914881349.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1914881349;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:47.985 -0400", hash_original_method = "1ADDA1851B7207BD0D6C119E2C63D6A2", hash_generated_method = "4706D414367874136365DA3DBB20C3A5")
    private void putCachedIcon(ResourceName name, Drawable dr) {
        {
            sIconCache.put(name, new WeakReference<Drawable.ConstantState>(dr.getConstantState()));
        } //End block
        addTaint(name.getTaint());
        addTaint(dr.getTaint());
        // ---------- Original Method ----------
        //synchronized (sSync) {
            //sIconCache.put(name, new WeakReference<Drawable.ConstantState>(dr.getConstantState()));
            //if (DEBUG_ICONS) Log.v(TAG, "Added cached drawable state for " + name + ": " + dr);
        //}
    }

    
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.023 -0400", hash_original_method = "B66098C8E55783775B73FA7D73879D41", hash_generated_method = "2409EA6EB1134EFE3101C1AB8A512F50")
    private CharSequence getCachedString(ResourceName name) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_466842945 = null; //Variable for return #1
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_47775176 = null; //Variable for return #2
        {
            WeakReference<CharSequence> wr;
            wr = sStringCache.get(name);
            {
                CharSequence cs;
                cs = wr.get();
                {
                    varB4EAC82CA7396A68D541C85D26508E83_466842945 = cs;
                } //End block
                sStringCache.remove(name);
            } //End block
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_47775176 = null;
        addTaint(name.getTaint());
        CharSequence varA7E53CE21691AB073D9660D615818899_1953278107; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1953278107 = varB4EAC82CA7396A68D541C85D26508E83_466842945;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1953278107 = varB4EAC82CA7396A68D541C85D26508E83_47775176;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1953278107.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1953278107;
        // ---------- Original Method ----------
        //synchronized (sSync) {
            //WeakReference<CharSequence> wr = sStringCache.get(name);
            //if (wr != null) {   
                //CharSequence cs = wr.get();
                //if (cs != null) {
                    //return cs;
                //}
                //sStringCache.remove(name);
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.025 -0400", hash_original_method = "70E4290F1842F0A45B89D50D6CDEDDBB", hash_generated_method = "7D27E17696535E60A1AB1B6049B959C9")
    private void putCachedString(ResourceName name, CharSequence cs) {
        {
            sStringCache.put(name, new WeakReference<CharSequence>(cs));
        } //End block
        addTaint(name.getTaint());
        addTaint(cs.getTaint());
        // ---------- Original Method ----------
        //synchronized (sSync) {
            //sStringCache.put(name, new WeakReference<CharSequence>(cs));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.075 -0400", hash_original_method = "771B010EDE230C24A313E1F6F3869FDB", hash_generated_method = "1C515946996EC7CBEA3E9EDAD8F5EFF1")
    @Override
    public CharSequence getText(String packageName, int resid,
                                ApplicationInfo appInfo) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1159645274 = null; //Variable for return #1
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_776174414 = null; //Variable for return #2
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_2120336379 = null; //Variable for return #3
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_991954666 = null; //Variable for return #4
        ResourceName name;
        name = new ResourceName(packageName, resid);
        CharSequence text;
        text = getCachedString(name);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1159645274 = text;
        } //End block
        {
            try 
            {
                appInfo = getApplicationInfo(packageName, 0);
            } //End block
            catch (NameNotFoundException e)
            {
                varB4EAC82CA7396A68D541C85D26508E83_776174414 = null;
            } //End block
        } //End block
        try 
        {
            Resources r;
            r = getResourcesForApplication(appInfo);
            text = r.getText(resid);
            putCachedString(name, text);
            varB4EAC82CA7396A68D541C85D26508E83_2120336379 = text;
        } //End block
        catch (NameNotFoundException e)
        { }
        catch (RuntimeException e)
        { }
        varB4EAC82CA7396A68D541C85D26508E83_991954666 = null;
        addTaint(packageName.getTaint());
        addTaint(resid);
        addTaint(appInfo.getTaint());
        CharSequence varA7E53CE21691AB073D9660D615818899_1219872178; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1219872178 = varB4EAC82CA7396A68D541C85D26508E83_1159645274;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1219872178 = varB4EAC82CA7396A68D541C85D26508E83_776174414;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1219872178 = varB4EAC82CA7396A68D541C85D26508E83_2120336379;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1219872178 = varB4EAC82CA7396A68D541C85D26508E83_991954666;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1219872178.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1219872178;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.101 -0400", hash_original_method = "F130C54905A9CE16326CF20EF6E93255", hash_generated_method = "A247D09FC5DD9F90D165B15B9774E4E2")
    @Override
    public XmlResourceParser getXml(String packageName, int resid,
                                    ApplicationInfo appInfo) {
        XmlResourceParser varB4EAC82CA7396A68D541C85D26508E83_1311517242 = null; //Variable for return #1
        XmlResourceParser varB4EAC82CA7396A68D541C85D26508E83_1225872957 = null; //Variable for return #2
        XmlResourceParser varB4EAC82CA7396A68D541C85D26508E83_663484501 = null; //Variable for return #3
        {
            try 
            {
                appInfo = getApplicationInfo(packageName, 0);
            } //End block
            catch (NameNotFoundException e)
            {
                varB4EAC82CA7396A68D541C85D26508E83_1311517242 = null;
            } //End block
        } //End block
        try 
        {
            Resources r;
            r = getResourcesForApplication(appInfo);
            varB4EAC82CA7396A68D541C85D26508E83_1225872957 = r.getXml(resid);
        } //End block
        catch (RuntimeException e)
        { }
        catch (NameNotFoundException e)
        { }
        varB4EAC82CA7396A68D541C85D26508E83_663484501 = null;
        addTaint(packageName.getTaint());
        addTaint(resid);
        addTaint(appInfo.getTaint());
        XmlResourceParser varA7E53CE21691AB073D9660D615818899_269689193; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_269689193 = varB4EAC82CA7396A68D541C85D26508E83_1311517242;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_269689193 = varB4EAC82CA7396A68D541C85D26508E83_1225872957;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_269689193 = varB4EAC82CA7396A68D541C85D26508E83_663484501;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_269689193.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_269689193;
        // ---------- Original Method ----------
        //if (appInfo == null) {
            //try {
                //appInfo = getApplicationInfo(packageName, 0);
            //} catch (NameNotFoundException e) {
                //return null;
            //}
        //}
        //try {
            //Resources r = getResourcesForApplication(appInfo);
            //return r.getXml(resid);
        //} catch (RuntimeException e) {
            //Log.w("PackageManager", "Failure retrieving xml 0x"
                  //+ Integer.toHexString(resid) + " in package "
                  //+ packageName, e);
        //} catch (NameNotFoundException e) {
            //Log.w("PackageManager", "Failure retrieving resources for "
                  //+ appInfo.packageName);
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.123 -0400", hash_original_method = "4AFDE050276913F392973B277F54706D", hash_generated_method = "2E2EB9B4EA4444C9DED2D701E77FE5ED")
    @Override
    public CharSequence getApplicationLabel(ApplicationInfo info) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1604626408 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1604626408 = info.loadLabel(this);
        addTaint(info.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1604626408.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1604626408;
        // ---------- Original Method ----------
        //return info.loadLabel(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.125 -0400", hash_original_method = "99610A6DD5E10C01303307EBA6938AA8", hash_generated_method = "400A22F298DF08C5D0E769F3CCD38501")
    @Override
    public void installPackage(Uri packageURI, IPackageInstallObserver observer, int flags,
                               String installerPackageName) {
        try 
        {
            mPM.installPackage(packageURI, observer, flags, installerPackageName);
        } //End block
        catch (RemoteException e)
        { }
        addTaint(packageURI.getTaint());
        addTaint(observer.getTaint());
        addTaint(flags);
        addTaint(installerPackageName.getTaint());
        // ---------- Original Method ----------
        //try {
            //mPM.installPackage(packageURI, observer, flags, installerPackageName);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.152 -0400", hash_original_method = "769145FCC72852B2314845C8A89A2DAD", hash_generated_method = "F3245D05F97B312C267DEC2D9622BA8B")
    @Override
    public void installPackageWithVerification(Uri packageURI, IPackageInstallObserver observer,
            int flags, String installerPackageName, Uri verificationURI,
            ManifestDigest manifestDigest) {
        try 
        {
            mPM.installPackageWithVerification(packageURI, observer, flags, installerPackageName,
                    verificationURI, manifestDigest);
        } //End block
        catch (RemoteException e)
        { }
        addTaint(packageURI.getTaint());
        addTaint(observer.getTaint());
        addTaint(flags);
        addTaint(installerPackageName.getTaint());
        addTaint(verificationURI.getTaint());
        addTaint(manifestDigest.getTaint());
        // ---------- Original Method ----------
        //try {
            //mPM.installPackageWithVerification(packageURI, observer, flags, installerPackageName,
                    //verificationURI, manifestDigest);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.174 -0400", hash_original_method = "E593338881B3E45506EA974F446D2A6B", hash_generated_method = "37756C8FAB2D16E48F6540B81C396231")
    @Override
    public void verifyPendingInstall(int id, int response) {
        try 
        {
            mPM.verifyPendingInstall(id, response);
        } //End block
        catch (RemoteException e)
        { }
        addTaint(id);
        addTaint(response);
        // ---------- Original Method ----------
        //try {
            //mPM.verifyPendingInstall(id, response);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.175 -0400", hash_original_method = "A168A8E169316429D31E261AD639AED4", hash_generated_method = "9C8C38D01201816D92FED5BF837CFF63")
    @Override
    public void setInstallerPackageName(String targetPackage,
            String installerPackageName) {
        try 
        {
            mPM.setInstallerPackageName(targetPackage, installerPackageName);
        } //End block
        catch (RemoteException e)
        { }
        addTaint(targetPackage.getTaint());
        addTaint(installerPackageName.getTaint());
        // ---------- Original Method ----------
        //try {
            //mPM.setInstallerPackageName(targetPackage, installerPackageName);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.185 -0400", hash_original_method = "D8F1CA3B8F90BF876B114DD825F09703", hash_generated_method = "013104B1BDA6E03638BA31CEC045094F")
    @Override
    public void movePackage(String packageName, IPackageMoveObserver observer, int flags) {
        try 
        {
            mPM.movePackage(packageName, observer, flags);
        } //End block
        catch (RemoteException e)
        { }
        addTaint(packageName.getTaint());
        addTaint(observer.getTaint());
        addTaint(flags);
        // ---------- Original Method ----------
        //try {
            //mPM.movePackage(packageName, observer, flags);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.211 -0400", hash_original_method = "13C0F9FC5FF4142BD538C8A3AADB3621", hash_generated_method = "49F6D0E121A10F65486B02496DDD97C8")
    @Override
    public String getInstallerPackageName(String packageName) {
        String varB4EAC82CA7396A68D541C85D26508E83_411129043 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1222086569 = null; //Variable for return #2
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_411129043 = mPM.getInstallerPackageName(packageName);
        } //End block
        catch (RemoteException e)
        { }
        varB4EAC82CA7396A68D541C85D26508E83_1222086569 = null;
        addTaint(packageName.getTaint());
        String varA7E53CE21691AB073D9660D615818899_1541149645; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1541149645 = varB4EAC82CA7396A68D541C85D26508E83_411129043;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1541149645 = varB4EAC82CA7396A68D541C85D26508E83_1222086569;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1541149645.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1541149645;
        // ---------- Original Method ----------
        //try {
            //return mPM.getInstallerPackageName(packageName);
        //} catch (RemoteException e) {
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.213 -0400", hash_original_method = "6B4A8C0BA02325B97A4B696E509E27F1", hash_generated_method = "6A3ED9E8A60057D0DB3AC4995AF0B2E7")
    @Override
    public void deletePackage(String packageName, IPackageDeleteObserver observer, int flags) {
        try 
        {
            mPM.deletePackage(packageName, observer, flags);
        } //End block
        catch (RemoteException e)
        { }
        addTaint(packageName.getTaint());
        addTaint(observer.getTaint());
        addTaint(flags);
        // ---------- Original Method ----------
        //try {
            //mPM.deletePackage(packageName, observer, flags);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.244 -0400", hash_original_method = "41D4F7CDEA8F3FA97A215E5DB5AE3B7F", hash_generated_method = "A1F8ED7652B7387CD0E6421FC7565E8D")
    @Override
    public void clearApplicationUserData(String packageName,
                                         IPackageDataObserver observer) {
        try 
        {
            mPM.clearApplicationUserData(packageName, observer);
        } //End block
        catch (RemoteException e)
        { }
        addTaint(packageName.getTaint());
        addTaint(observer.getTaint());
        // ---------- Original Method ----------
        //try {
            //mPM.clearApplicationUserData(packageName, observer);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.246 -0400", hash_original_method = "9E003FA712762A764BBDA3187B8255C1", hash_generated_method = "A69811C1495E99329928ECA86D124251")
    @Override
    public void deleteApplicationCacheFiles(String packageName,
                                            IPackageDataObserver observer) {
        try 
        {
            mPM.deleteApplicationCacheFiles(packageName, observer);
        } //End block
        catch (RemoteException e)
        { }
        addTaint(packageName.getTaint());
        addTaint(observer.getTaint());
        // ---------- Original Method ----------
        //try {
            //mPM.deleteApplicationCacheFiles(packageName, observer);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.247 -0400", hash_original_method = "E7A7F0006F405C835ECAAE7B969343FA", hash_generated_method = "0B639835B9C7BD19E29CC9E9938962C4")
    @Override
    public void freeStorageAndNotify(long idealStorageSize, IPackageDataObserver observer) {
        try 
        {
            mPM.freeStorageAndNotify(idealStorageSize, observer);
        } //End block
        catch (RemoteException e)
        { }
        addTaint(idealStorageSize);
        addTaint(observer.getTaint());
        // ---------- Original Method ----------
        //try {
            //mPM.freeStorageAndNotify(idealStorageSize, observer);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.276 -0400", hash_original_method = "8531AD2E443F843CDBBD03DDCC5F2882", hash_generated_method = "B0070DACE1C55EC19587AB40DB11BCAF")
    @Override
    public void freeStorage(long freeStorageSize, IntentSender pi) {
        try 
        {
            mPM.freeStorage(freeStorageSize, pi);
        } //End block
        catch (RemoteException e)
        { }
        addTaint(freeStorageSize);
        addTaint(pi.getTaint());
        // ---------- Original Method ----------
        //try {
            //mPM.freeStorage(freeStorageSize, pi);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.280 -0400", hash_original_method = "00314015F36B785D35449EC7724DA4A0", hash_generated_method = "6ECEB12C252949AE71858382236E4A0D")
    @Override
    public void getPackageSizeInfo(String packageName,
                                   IPackageStatsObserver observer) {
        try 
        {
            mPM.getPackageSizeInfo(packageName, observer);
        } //End block
        catch (RemoteException e)
        { }
        addTaint(packageName.getTaint());
        addTaint(observer.getTaint());
        // ---------- Original Method ----------
        //try {
            //mPM.getPackageSizeInfo(packageName, observer);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.365 -0400", hash_original_method = "A9291C102B2FAAEF4C90A57E1B6DE098", hash_generated_method = "0D690A0FE1B62191F94C37814ED9C13E")
    @Override
    public void addPackageToPreferred(String packageName) {
        try 
        {
            mPM.addPackageToPreferred(packageName);
        } //End block
        catch (RemoteException e)
        { }
        addTaint(packageName.getTaint());
        // ---------- Original Method ----------
        //try {
            //mPM.addPackageToPreferred(packageName);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.373 -0400", hash_original_method = "F1B5214867A85B15353BE55995A19BB6", hash_generated_method = "16AE382D6D44614F9CE0F2F1A0174EBF")
    @Override
    public void removePackageFromPreferred(String packageName) {
        try 
        {
            mPM.removePackageFromPreferred(packageName);
        } //End block
        catch (RemoteException e)
        { }
        addTaint(packageName.getTaint());
        // ---------- Original Method ----------
        //try {
            //mPM.removePackageFromPreferred(packageName);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.380 -0400", hash_original_method = "4A08CFB9ACE88EAEABD2D18F083F329D", hash_generated_method = "377CAA6D94EB76D76E3E8DDF515C5BF5")
    @Override
    public List<PackageInfo> getPreferredPackages(int flags) {
        List<PackageInfo> varB4EAC82CA7396A68D541C85D26508E83_361860086 = null; //Variable for return #1
        List<PackageInfo> varB4EAC82CA7396A68D541C85D26508E83_441418380 = null; //Variable for return #2
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_361860086 = mPM.getPreferredPackages(flags);
        } //End block
        catch (RemoteException e)
        { }
        varB4EAC82CA7396A68D541C85D26508E83_441418380 = new ArrayList<PackageInfo>();
        addTaint(flags);
        List<PackageInfo> varA7E53CE21691AB073D9660D615818899_230204037; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_230204037 = varB4EAC82CA7396A68D541C85D26508E83_361860086;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_230204037 = varB4EAC82CA7396A68D541C85D26508E83_441418380;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_230204037.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_230204037;
        // ---------- Original Method ----------
        //try {
            //return mPM.getPreferredPackages(flags);
        //} catch (RemoteException e) {
        //}
        //return new ArrayList<PackageInfo>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.382 -0400", hash_original_method = "E5D2F7A75D600839A582F36FB9BA5425", hash_generated_method = "E4890C1035F01F9D32FCB826AD598DD3")
    @Override
    public void addPreferredActivity(IntentFilter filter,
                                     int match, ComponentName[] set, ComponentName activity) {
        try 
        {
            mPM.addPreferredActivity(filter, match, set, activity);
        } //End block
        catch (RemoteException e)
        { }
        addTaint(filter.getTaint());
        addTaint(match);
        addTaint(set[0].getTaint());
        addTaint(activity.getTaint());
        // ---------- Original Method ----------
        //try {
            //mPM.addPreferredActivity(filter, match, set, activity);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.401 -0400", hash_original_method = "2885B1E40721D55CC13EAA30EB1BAE52", hash_generated_method = "C5FF225D327460B3296A7AFA75368096")
    @Override
    public void replacePreferredActivity(IntentFilter filter,
                                         int match, ComponentName[] set, ComponentName activity) {
        try 
        {
            mPM.replacePreferredActivity(filter, match, set, activity);
        } //End block
        catch (RemoteException e)
        { }
        addTaint(filter.getTaint());
        addTaint(match);
        addTaint(set[0].getTaint());
        addTaint(activity.getTaint());
        // ---------- Original Method ----------
        //try {
            //mPM.replacePreferredActivity(filter, match, set, activity);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.402 -0400", hash_original_method = "818084167B76F544DAE31D40EA850683", hash_generated_method = "C9C1FB3440196C8943FD1E9972510DCD")
    @Override
    public void clearPackagePreferredActivities(String packageName) {
        try 
        {
            mPM.clearPackagePreferredActivities(packageName);
        } //End block
        catch (RemoteException e)
        { }
        addTaint(packageName.getTaint());
        // ---------- Original Method ----------
        //try {
            //mPM.clearPackagePreferredActivities(packageName);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.404 -0400", hash_original_method = "9A1408660FD10D92BECBE2BE18AA9510", hash_generated_method = "637846BB0CE10F8A32C907F42F04DFFD")
    @Override
    public int getPreferredActivities(List<IntentFilter> outFilters,
                                      List<ComponentName> outActivities, String packageName) {
        try 
        {
            int varAAA2984E5864A69FBA0F19FD84D394A5_65342344 = (mPM.getPreferredActivities(outFilters, outActivities, packageName));
        } //End block
        catch (RemoteException e)
        { }
        addTaint(outFilters.getTaint());
        addTaint(outActivities.getTaint());
        addTaint(packageName.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_716229144 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_716229144;
        // ---------- Original Method ----------
        //try {
            //return mPM.getPreferredActivities(outFilters, outActivities, packageName);
        //} catch (RemoteException e) {
        //}
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.419 -0400", hash_original_method = "324289EEBFA692363CEA9B4C548C82A7", hash_generated_method = "A0BA00110F6663F102A5964560E3C0E9")
    @Override
    public void setComponentEnabledSetting(ComponentName componentName,
                                           int newState, int flags) {
        try 
        {
            mPM.setComponentEnabledSetting(componentName, newState, flags);
        } //End block
        catch (RemoteException e)
        { }
        addTaint(componentName.getTaint());
        addTaint(newState);
        addTaint(flags);
        // ---------- Original Method ----------
        //try {
            //mPM.setComponentEnabledSetting(componentName, newState, flags);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.428 -0400", hash_original_method = "214E6E4C94F679DC0FE6A4159B821EAF", hash_generated_method = "2FC3D9A5778325BB29C5912A50D14305")
    @Override
    public int getComponentEnabledSetting(ComponentName componentName) {
        try 
        {
            int var1528F93F8B5599DBD2DEEBFDF40122F0_1708394442 = (mPM.getComponentEnabledSetting(componentName));
        } //End block
        catch (RemoteException e)
        { }
        addTaint(componentName.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1171540708 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1171540708;
        // ---------- Original Method ----------
        //try {
            //return mPM.getComponentEnabledSetting(componentName);
        //} catch (RemoteException e) {
        //}
        //return PackageManager.COMPONENT_ENABLED_STATE_DEFAULT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.444 -0400", hash_original_method = "893989AE0F295A10184FE7AD874B7991", hash_generated_method = "C30D96FC52BAA3663F8231ABB8ABA6D1")
    @Override
    public void setApplicationEnabledSetting(String packageName,
                                             int newState, int flags) {
        try 
        {
            mPM.setApplicationEnabledSetting(packageName, newState, flags);
        } //End block
        catch (RemoteException e)
        { }
        addTaint(packageName.getTaint());
        addTaint(newState);
        addTaint(flags);
        // ---------- Original Method ----------
        //try {
            //mPM.setApplicationEnabledSetting(packageName, newState, flags);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.446 -0400", hash_original_method = "786754E395F784476E8D899ABD01121D", hash_generated_method = "802A0BAA164BE60626314AC70B61F0BC")
    @Override
    public int getApplicationEnabledSetting(String packageName) {
        try 
        {
            int varF2CA84C656A1ECB5C0715BD15E6F333E_806307628 = (mPM.getApplicationEnabledSetting(packageName));
        } //End block
        catch (RemoteException e)
        { }
        addTaint(packageName.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1993022383 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1993022383;
        // ---------- Original Method ----------
        //try {
            //return mPM.getApplicationEnabledSetting(packageName);
        //} catch (RemoteException e) {
        //}
        //return PackageManager.COMPONENT_ENABLED_STATE_DEFAULT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.456 -0400", hash_original_method = "26D19368C79A5889D2D25A72A45789A8", hash_generated_method = "DCEB6A951B4EE2E621811C341FACCB47")
    @Override
    public UserInfo createUser(String name, int flags) {
        UserInfo varB4EAC82CA7396A68D541C85D26508E83_1197044607 = null; //Variable for return #1
        UserInfo varB4EAC82CA7396A68D541C85D26508E83_827453307 = null; //Variable for return #2
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1197044607 = mPM.createUser(name, flags);
        } //End block
        catch (RemoteException e)
        { }
        varB4EAC82CA7396A68D541C85D26508E83_827453307 = null;
        addTaint(name.getTaint());
        addTaint(flags);
        UserInfo varA7E53CE21691AB073D9660D615818899_1336519423; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1336519423 = varB4EAC82CA7396A68D541C85D26508E83_1197044607;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1336519423 = varB4EAC82CA7396A68D541C85D26508E83_827453307;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1336519423.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1336519423;
        // ---------- Original Method ----------
        //try {
            //return mPM.createUser(name, flags);
        //} catch (RemoteException e) {
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.472 -0400", hash_original_method = "D3989192690585F23E6C25734E0C3BDB", hash_generated_method = "125EEC685B05FA240583DA4093FBF2E7")
    @Override
    public List<UserInfo> getUsers() {
        List<UserInfo> varB4EAC82CA7396A68D541C85D26508E83_650629282 = null; //Variable for return #1
        ArrayList<UserInfo> users;
        users = new ArrayList<UserInfo>();
        UserInfo primary;
        primary = new UserInfo(0, "Root!",
                UserInfo.FLAG_ADMIN | UserInfo.FLAG_PRIMARY);
        users.add(primary);
        varB4EAC82CA7396A68D541C85D26508E83_650629282 = users;
        varB4EAC82CA7396A68D541C85D26508E83_650629282.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_650629282;
        // ---------- Original Method ----------
        //ArrayList<UserInfo> users = new ArrayList<UserInfo>();
        //UserInfo primary = new UserInfo(0, "Root!",
                //UserInfo.FLAG_ADMIN | UserInfo.FLAG_PRIMARY);
        //users.add(primary);
        //return users;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.475 -0400", hash_original_method = "7D391C716B6EBFD3B4233647A1DCBC34", hash_generated_method = "67028E306F66295F64F97534D379F7E1")
    @Override
    public boolean removeUser(int id) {
        try 
        {
            boolean varF0857FEEEFECDA71C81CF89A6CEBBA1A_1655140165 = (mPM.removeUser(id));
        } //End block
        catch (RemoteException e)
        { }
        addTaint(id);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_157126739 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_157126739;
        // ---------- Original Method ----------
        //try {
            //return mPM.removeUser(id);
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.483 -0400", hash_original_method = "C52981B6B26B608864F1952FFD2E785F", hash_generated_method = "4417EB3E02E6716448462D97478FC1FC")
    @Override
    public void updateUserName(int id, String name) {
        addTaint(id);
        addTaint(name.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.498 -0400", hash_original_method = "B193A8F9463928060D13777D952477CD", hash_generated_method = "D32F8A11D82F3C142EEC3FF4520279CC")
    @Override
    public void updateUserFlags(int id, int flags) {
        addTaint(id);
        addTaint(flags);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.501 -0400", hash_original_method = "05FAEEF75E7B74D35A0F0687A4ACD32C", hash_generated_method = "726314BB008E7951682ADD8ADF8E0750")
    @Override
    public VerifierDeviceIdentity getVerifierDeviceIdentity() {
        VerifierDeviceIdentity varB4EAC82CA7396A68D541C85D26508E83_1628091095 = null; //Variable for return #1
        VerifierDeviceIdentity varB4EAC82CA7396A68D541C85D26508E83_518430448 = null; //Variable for return #2
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1628091095 = mPM.getVerifierDeviceIdentity();
        } //End block
        catch (RemoteException e)
        { }
        varB4EAC82CA7396A68D541C85D26508E83_518430448 = null;
        VerifierDeviceIdentity varA7E53CE21691AB073D9660D615818899_1615715018; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1615715018 = varB4EAC82CA7396A68D541C85D26508E83_1628091095;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1615715018 = varB4EAC82CA7396A68D541C85D26508E83_518430448;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1615715018.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1615715018;
        // ---------- Original Method ----------
        //try {
            //return mPM.getVerifierDeviceIdentity();
        //} catch (RemoteException e) {
        //}
        //return null;
    }

    
    private static final class ResourceName {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.504 -0400", hash_original_field = "387F1FA6FC99B8AE187C010A06120611", hash_generated_field = "6F92EE1B3BCDC0C4179CF5FD998BE046")

        String packageName;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.505 -0400", hash_original_field = "D4DDD8F15E145D654808CFEB3504E8E3", hash_generated_field = "5FB1FE173593F2C1352A3849ECD329FE")

        int iconId;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.524 -0400", hash_original_method = "00C0083FA3192C6FB2E9C58DC21ABF99", hash_generated_method = "1E60D2B25AB72FD493F4CCEBE8E14228")
          ResourceName(String _packageName, int _iconId) {
            packageName = _packageName;
            iconId = _iconId;
            // ---------- Original Method ----------
            //packageName = _packageName;
            //iconId = _iconId;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.525 -0400", hash_original_method = "1D7CABC5D0E2E4029539D2105E7113C1", hash_generated_method = "F4B0DF37D4D0AD07245EBE22412943F8")
          ResourceName(ApplicationInfo aInfo, int _iconId) {
            this(aInfo.packageName, _iconId);
            addTaint(aInfo.getTaint());
            addTaint(_iconId);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.537 -0400", hash_original_method = "316DD832F87E78ED23C1ED370845ED19", hash_generated_method = "CD60A1612BA3B74B93A271C021B4D340")
          ResourceName(ComponentInfo cInfo, int _iconId) {
            this(cInfo.applicationInfo.packageName, _iconId);
            addTaint(cInfo.getTaint());
            addTaint(_iconId);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.538 -0400", hash_original_method = "B7E8883725512A2439D57072801DA2BC", hash_generated_method = "DF21CBF5040D1AA4EFF30C198363476D")
          ResourceName(ResolveInfo rInfo, int _iconId) {
            this(rInfo.activityInfo.applicationInfo.packageName, _iconId);
            addTaint(rInfo.getTaint());
            addTaint(_iconId);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.562 -0400", hash_original_method = "77EA94B0E7A0581CD73B79023B92E268", hash_generated_method = "BD8B02F5858D364C01918D21C20D05B8")
        @Override
        public boolean equals(Object o) {
            {
                boolean var1DE06DCDBE8CB2577D8B96631D951907_1377438552 = (o == null || getClass() != o.getClass());
            } //End collapsed parenthetic
            ResourceName that;
            that = (ResourceName) o;
            boolean var2CF4425DEC96D908C0E598EDFC75DDA1_887260375 = (!(packageName != null ?
                     !packageName.equals(that.packageName) : that.packageName != null)); //DSFIXME:  CODE0008: Nested ternary operator in expression
            addTaint(o.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1820991926 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1820991926;
            // ---------- Original Method ----------
            //if (this == o) return true;
            //if (o == null || getClass() != o.getClass()) return false;
            //ResourceName that = (ResourceName) o;
            //if (iconId != that.iconId) return false;
            //return !(packageName != null ?
                     //!packageName.equals(that.packageName) : that.packageName != null);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.565 -0400", hash_original_method = "FE96AD3461E654FCE4E8B88F254AC3EE", hash_generated_method = "24C13C886ACF2D44B521F0EB5F86EE22")
        @Override
        public int hashCode() {
            int result;
            result = packageName.hashCode();
            result = 31 * result + iconId;
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1116293726 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1116293726;
            // ---------- Original Method ----------
            //int result;
            //result = packageName.hashCode();
            //result = 31 * result + iconId;
            //return result;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.576 -0400", hash_original_method = "19C1C9668D8A7EEF540F3D9429936D14", hash_generated_method = "B6A4CD3C400E7FF4D4B2DB5404198317")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_1456699090 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1456699090 = "{ResourceName " + packageName + " / " + iconId + "}";
            varB4EAC82CA7396A68D541C85D26508E83_1456699090.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1456699090;
            // ---------- Original Method ----------
            //return "{ResourceName " + packageName + " / " + iconId + "}";
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.584 -0400", hash_original_field = "6567C925641831CFA00E9DD4884FA1D6", hash_generated_field = "318BD6D0D7A5EECD7BBDF9682BC03BEA")

    private static String TAG = "ApplicationPackageManager";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.585 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "E83DF1E2E661A92B1AFDA8C473D190B2")

    private static boolean DEBUG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.586 -0400", hash_original_field = "C3489935DD7AFC611D460C12208E5765", hash_generated_field = "EAB7DEAF050DD92292423D2672847096")

    private static boolean DEBUG_ICONS = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.586 -0400", hash_original_field = "2F49D49D71E16DE6B9E03ABB51788CD5", hash_generated_field = "C134B13DBDEF193093808FEE63AE2EEC")

    private static Object sSync = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.586 -0400", hash_original_field = "86949C5674DAE04FF598125EDFB9A09B", hash_generated_field = "4B02A68E27DCF1DC814B05F533A46F39")

    private static HashMap<ResourceName, WeakReference<Drawable.ConstantState>> sIconCache = new HashMap<ResourceName, WeakReference<Drawable.ConstantState>>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.598 -0400", hash_original_field = "C59A7EE72451F56F2C82359DD275010F", hash_generated_field = "F43C1D13F1C693E3CC3452E528CF10D8")

    private static HashMap<ResourceName, WeakReference<CharSequence>> sStringCache = new HashMap<ResourceName, WeakReference<CharSequence>>();
}

