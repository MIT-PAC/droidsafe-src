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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.271 -0400", hash_original_field = "D582EAEF778B662187C3776F3BC85DE5", hash_generated_field = "BB74ADCE9FCE390733990F175981A8B2")

    int mCachedSafeMode = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.272 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "9848C26EA3B1FE04FDB0411428C18F0B")

    private ContextImpl mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.273 -0400", hash_original_field = "3D87516393C6B091D0B0E6C38455BD37", hash_generated_field = "7F4B9DC825AA12542DFD4F441E873557")

    private IPackageManager mPM;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.301 -0400", hash_original_method = "12FC21630330363415BEFB2BB747FDD4", hash_generated_method = "821E283AA9F20FD120BA751A1DBB238D")
      ApplicationPackageManager(ContextImpl context,
                              IPackageManager pm) {
        mContext = context;
        mPM = pm;
        // ---------- Original Method ----------
        //mContext = context;
        //mPM = pm;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.304 -0400", hash_original_method = "B0DADC2DBFEC092F753C36E8DEB385A1", hash_generated_method = "5DA998E06E3E78410C0E4AD0E477881F")
    @Override
    public PackageInfo getPackageInfo(String packageName, int flags) throws NameNotFoundException {
        PackageInfo varB4EAC82CA7396A68D541C85D26508E83_1174439651 = null; //Variable for return #1
        try 
        {
            PackageInfo pi;
            pi = mPM.getPackageInfo(packageName, flags);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1174439651 = pi;
            } //End block
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new NameNotFoundException(packageName);
        addTaint(packageName.getTaint());
        addTaint(flags);
        varB4EAC82CA7396A68D541C85D26508E83_1174439651.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1174439651;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.316 -0400", hash_original_method = "C5CDEAB4FF073C2ACB7E7915B56F1D0F", hash_generated_method = "2F1CF38D2A7C61496C8547DE67062CD1")
    @Override
    public String[] currentToCanonicalPackageNames(String[] names) {
        String[] varB4EAC82CA7396A68D541C85D26508E83_810472789 = null; //Variable for return #1
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_810472789 = mPM.currentToCanonicalPackageNames(names);
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } //End block
        addTaint(names[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_810472789.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_810472789;
        // ---------- Original Method ----------
        //try {
            //return mPM.currentToCanonicalPackageNames(names);
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.333 -0400", hash_original_method = "9BD980F14E9EC05077595EA826722236", hash_generated_method = "B598B3B9362E7026AC90BFF4963A69CC")
    @Override
    public String[] canonicalToCurrentPackageNames(String[] names) {
        String[] varB4EAC82CA7396A68D541C85D26508E83_1898391668 = null; //Variable for return #1
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1898391668 = mPM.canonicalToCurrentPackageNames(names);
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } //End block
        addTaint(names[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1898391668.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1898391668;
        // ---------- Original Method ----------
        //try {
            //return mPM.canonicalToCurrentPackageNames(names);
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.354 -0400", hash_original_method = "A679E3857CF73FF4B9C2EA4F09C7DBB7", hash_generated_method = "1AEAD6189379DEEF8E63C72AFEE51E05")
    @Override
    public Intent getLaunchIntentForPackage(String packageName) {
        Intent varB4EAC82CA7396A68D541C85D26508E83_1275847825 = null; //Variable for return #1
        Intent varB4EAC82CA7396A68D541C85D26508E83_162413903 = null; //Variable for return #2
        Intent intentToResolve;
        intentToResolve = new Intent(Intent.ACTION_MAIN);
        intentToResolve.addCategory(Intent.CATEGORY_INFO);
        intentToResolve.setPackage(packageName);
        List<ResolveInfo> ris;
        ris = queryIntentActivities(intentToResolve, 0);
        {
            boolean varBFFD11AFF4B06D0E1D653A2E50FC1BFF_470327740 = (ris == null || ris.size() <= 0);
            {
                intentToResolve.removeCategory(Intent.CATEGORY_INFO);
                intentToResolve.addCategory(Intent.CATEGORY_LAUNCHER);
                intentToResolve.setPackage(packageName);
                ris = queryIntentActivities(intentToResolve, 0);
            } //End block
        } //End collapsed parenthetic
        {
            boolean varBFFD11AFF4B06D0E1D653A2E50FC1BFF_1811646542 = (ris == null || ris.size() <= 0);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1275847825 = null;
            } //End block
        } //End collapsed parenthetic
        Intent intent;
        intent = new Intent(intentToResolve);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setClassName(ris.get(0).activityInfo.packageName,
                ris.get(0).activityInfo.name);
        varB4EAC82CA7396A68D541C85D26508E83_162413903 = intent;
        addTaint(packageName.getTaint());
        Intent varA7E53CE21691AB073D9660D615818899_1008111675; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1008111675 = varB4EAC82CA7396A68D541C85D26508E83_1275847825;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1008111675 = varB4EAC82CA7396A68D541C85D26508E83_162413903;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1008111675.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1008111675;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.452 -0400", hash_original_method = "65CBA80193594BC7AC8CBF648823BDBA", hash_generated_method = "75D8797583415ECA3419453D78B0D531")
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
        int[] varB4CCCA26F9DB9189C32F33E82D425CFB_1940740012 = {getTaintInt()};
        return varB4CCCA26F9DB9189C32F33E82D425CFB_1940740012;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.459 -0400", hash_original_method = "16E2B9223A8B92626D3604D0E58E2278", hash_generated_method = "D9006D3D3F5637D93AC31711F8F53800")
    @Override
    public PermissionInfo getPermissionInfo(String name, int flags) throws NameNotFoundException {
        PermissionInfo varB4EAC82CA7396A68D541C85D26508E83_796529423 = null; //Variable for return #1
        try 
        {
            PermissionInfo pi;
            pi = mPM.getPermissionInfo(name, flags);
            {
                varB4EAC82CA7396A68D541C85D26508E83_796529423 = pi;
            } //End block
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new NameNotFoundException(name);
        addTaint(name.getTaint());
        addTaint(flags);
        varB4EAC82CA7396A68D541C85D26508E83_796529423.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_796529423;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.483 -0400", hash_original_method = "2283AA5BDEF3F8B3341260BB74FBE8C3", hash_generated_method = "0919C5C7A3D51A83173603576E6BA7A4")
    @Override
    public List<PermissionInfo> queryPermissionsByGroup(String group, int flags) throws NameNotFoundException {
        List<PermissionInfo> varB4EAC82CA7396A68D541C85D26508E83_592736536 = null; //Variable for return #1
        try 
        {
            List<PermissionInfo> pi;
            pi = mPM.queryPermissionsByGroup(group, flags);
            {
                varB4EAC82CA7396A68D541C85D26508E83_592736536 = pi;
            } //End block
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new NameNotFoundException(group);
        addTaint(group.getTaint());
        addTaint(flags);
        varB4EAC82CA7396A68D541C85D26508E83_592736536.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_592736536;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.492 -0400", hash_original_method = "4E576FD7FE2DDB9674E042581657631F", hash_generated_method = "7CC2AC36421208E475A18C7F35CDCB88")
    @Override
    public PermissionGroupInfo getPermissionGroupInfo(String name,
                                                      int flags) throws NameNotFoundException {
        PermissionGroupInfo varB4EAC82CA7396A68D541C85D26508E83_1441075405 = null; //Variable for return #1
        try 
        {
            PermissionGroupInfo pgi;
            pgi = mPM.getPermissionGroupInfo(name, flags);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1441075405 = pgi;
            } //End block
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new NameNotFoundException(name);
        addTaint(name.getTaint());
        addTaint(flags);
        varB4EAC82CA7396A68D541C85D26508E83_1441075405.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1441075405;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.498 -0400", hash_original_method = "DD7F1EBA9089D82A0EEA68FDD3DACC66", hash_generated_method = "FD1B439E8FC032D882FD825866308DC3")
    @Override
    public List<PermissionGroupInfo> getAllPermissionGroups(int flags) {
        List<PermissionGroupInfo> varB4EAC82CA7396A68D541C85D26508E83_710946607 = null; //Variable for return #1
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_710946607 = mPM.getAllPermissionGroups(flags);
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } //End block
        addTaint(flags);
        varB4EAC82CA7396A68D541C85D26508E83_710946607.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_710946607;
        // ---------- Original Method ----------
        //try {
            //return mPM.getAllPermissionGroups(flags);
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.525 -0400", hash_original_method = "8999420BFE5728B346477621EA154ABF", hash_generated_method = "A00805E2628C62906242FF346DB1A63E")
    @Override
    public ApplicationInfo getApplicationInfo(String packageName, int flags) throws NameNotFoundException {
        ApplicationInfo varB4EAC82CA7396A68D541C85D26508E83_1032670201 = null; //Variable for return #1
        try 
        {
            ApplicationInfo ai;
            ai = mPM.getApplicationInfo(packageName, flags);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1032670201 = ai;
            } //End block
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new NameNotFoundException(packageName);
        addTaint(packageName.getTaint());
        addTaint(flags);
        varB4EAC82CA7396A68D541C85D26508E83_1032670201.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1032670201;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.549 -0400", hash_original_method = "9B4FC7EA40C0BB7AEEEEEF1D86D28DE8", hash_generated_method = "BD6AA295436A7DD0BEDBF0A29E393748")
    @Override
    public ActivityInfo getActivityInfo(ComponentName className, int flags) throws NameNotFoundException {
        ActivityInfo varB4EAC82CA7396A68D541C85D26508E83_383306607 = null; //Variable for return #1
        try 
        {
            ActivityInfo ai;
            ai = mPM.getActivityInfo(className, flags);
            {
                varB4EAC82CA7396A68D541C85D26508E83_383306607 = ai;
            } //End block
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new NameNotFoundException(className.toString());
        addTaint(className.getTaint());
        addTaint(flags);
        varB4EAC82CA7396A68D541C85D26508E83_383306607.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_383306607;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.577 -0400", hash_original_method = "399255B19735D8EC733B05B14D3B4711", hash_generated_method = "881E274520F08F4010FAFFB33725CEB1")
    @Override
    public ActivityInfo getReceiverInfo(ComponentName className, int flags) throws NameNotFoundException {
        ActivityInfo varB4EAC82CA7396A68D541C85D26508E83_1848516059 = null; //Variable for return #1
        try 
        {
            ActivityInfo ai;
            ai = mPM.getReceiverInfo(className, flags);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1848516059 = ai;
            } //End block
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new NameNotFoundException(className.toString());
        addTaint(className.getTaint());
        addTaint(flags);
        varB4EAC82CA7396A68D541C85D26508E83_1848516059.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1848516059;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.594 -0400", hash_original_method = "50C1BC4F3995D229FF03E27E05E5BE36", hash_generated_method = "BC8E45615737B3E0118BA262B16CF329")
    @Override
    public ServiceInfo getServiceInfo(ComponentName className, int flags) throws NameNotFoundException {
        ServiceInfo varB4EAC82CA7396A68D541C85D26508E83_2045615579 = null; //Variable for return #1
        try 
        {
            ServiceInfo si;
            si = mPM.getServiceInfo(className, flags);
            {
                varB4EAC82CA7396A68D541C85D26508E83_2045615579 = si;
            } //End block
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new NameNotFoundException(className.toString());
        addTaint(className.getTaint());
        addTaint(flags);
        varB4EAC82CA7396A68D541C85D26508E83_2045615579.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2045615579;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.606 -0400", hash_original_method = "895E4F29ECA72E6836B6F503A466760A", hash_generated_method = "360D5EFD03136B5C4EB08CB13C901F14")
    @Override
    public ProviderInfo getProviderInfo(ComponentName className, int flags) throws NameNotFoundException {
        ProviderInfo varB4EAC82CA7396A68D541C85D26508E83_706901581 = null; //Variable for return #1
        try 
        {
            ProviderInfo pi;
            pi = mPM.getProviderInfo(className, flags);
            {
                varB4EAC82CA7396A68D541C85D26508E83_706901581 = pi;
            } //End block
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new NameNotFoundException(className.toString());
        addTaint(className.getTaint());
        addTaint(flags);
        varB4EAC82CA7396A68D541C85D26508E83_706901581.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_706901581;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.628 -0400", hash_original_method = "E90BE84736723B0914BD9D43484D5AAD", hash_generated_method = "4DA6D495C7AFE6A78157B93BB784B268")
    @Override
    public String[] getSystemSharedLibraryNames() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_1472390279 = null; //Variable for return #1
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1472390279 = mPM.getSystemSharedLibraryNames();
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1472390279.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1472390279;
        // ---------- Original Method ----------
        //try {
            //return mPM.getSystemSharedLibraryNames();
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.650 -0400", hash_original_method = "887B55B734ED0895C5FA7D7CF721CE58", hash_generated_method = "5E3283F0F103CDAB890FE67623FCC6AC")
    @Override
    public FeatureInfo[] getSystemAvailableFeatures() {
        FeatureInfo[] varB4EAC82CA7396A68D541C85D26508E83_1040490254 = null; //Variable for return #1
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1040490254 = mPM.getSystemAvailableFeatures();
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1040490254.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1040490254;
        // ---------- Original Method ----------
        //try {
            //return mPM.getSystemAvailableFeatures();
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.667 -0400", hash_original_method = "8E2B8D0B6C29BED8B3E866F74247B636", hash_generated_method = "26D5A36C0F12F953E10DBE179B8CB202")
    @Override
    public boolean hasSystemFeature(String name) {
        try 
        {
            boolean varD59F1F4384BD648C5D21225C24B9C301_71643847 = (mPM.hasSystemFeature(name));
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } //End block
        addTaint(name.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1835569719 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1835569719;
        // ---------- Original Method ----------
        //try {
            //return mPM.hasSystemFeature(name);
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.669 -0400", hash_original_method = "D191D3716589DABF1290937DD7F4276D", hash_generated_method = "801AB1E569827E12043AD202F30E75AD")
    @Override
    public int checkPermission(String permName, String pkgName) {
        try 
        {
            int varC24F180D5E6F6659DC5818809EF3416E_877242924 = (mPM.checkPermission(permName, pkgName));
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } //End block
        addTaint(permName.getTaint());
        addTaint(pkgName.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_126368495 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_126368495;
        // ---------- Original Method ----------
        //try {
            //return mPM.checkPermission(permName, pkgName);
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.682 -0400", hash_original_method = "7DE747A31A0FDE2C95A03117CF8EC1E2", hash_generated_method = "266B710BD178D6AAC3BF2422486AA5A7")
    @Override
    public boolean addPermission(PermissionInfo info) {
        try 
        {
            boolean var16B313AE31B83011C28287E1893A6A9C_1266710067 = (mPM.addPermission(info));
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } //End block
        addTaint(info.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_934440837 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_934440837;
        // ---------- Original Method ----------
        //try {
            //return mPM.addPermission(info);
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.704 -0400", hash_original_method = "BE955F868C92CCDF8275E95FFE2C44B3", hash_generated_method = "3434A63E1E8E263E5B323FFF2B6C2756")
    @Override
    public boolean addPermissionAsync(PermissionInfo info) {
        try 
        {
            boolean var3B1BC13408FAB0EED9E6C97798235DF8_732136503 = (mPM.addPermissionAsync(info));
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } //End block
        addTaint(info.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1895784096 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1895784096;
        // ---------- Original Method ----------
        //try {
            //return mPM.addPermissionAsync(info);
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.713 -0400", hash_original_method = "3B9F25E30931EF93125264B719A2E2FF", hash_generated_method = "10FF1DF162216143C55B2A2B5A44D0D4")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.725 -0400", hash_original_method = "7DC6A4F902E735FA721489587F3384CC", hash_generated_method = "116D9DC282164F8B47CD10CD46D12229")
    @Override
    public int checkSignatures(String pkg1, String pkg2) {
        try 
        {
            int var48FD7299CCE20AFA5ACAC7362163506B_1163986788 = (mPM.checkSignatures(pkg1, pkg2));
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } //End block
        addTaint(pkg1.getTaint());
        addTaint(pkg2.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_200087045 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_200087045;
        // ---------- Original Method ----------
        //try {
            //return mPM.checkSignatures(pkg1, pkg2);
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.757 -0400", hash_original_method = "E51AFA66F0FA11E52A6A449B49344AE4", hash_generated_method = "3A6D0D7D9C9165E3FF5D9C4524C48852")
    @Override
    public int checkSignatures(int uid1, int uid2) {
        try 
        {
            int varCB0D2D55990C866D4BAF222264E4D604_513429233 = (mPM.checkUidSignatures(uid1, uid2));
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } //End block
        addTaint(uid1);
        addTaint(uid2);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1588093431 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1588093431;
        // ---------- Original Method ----------
        //try {
            //return mPM.checkUidSignatures(uid1, uid2);
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.771 -0400", hash_original_method = "A565AD9EB181443BBE8F338808A2E4B9", hash_generated_method = "A531180A2588E11AEEC9F45D216E90BC")
    @Override
    public String[] getPackagesForUid(int uid) {
        String[] varB4EAC82CA7396A68D541C85D26508E83_453588577 = null; //Variable for return #1
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_453588577 = mPM.getPackagesForUid(uid);
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } //End block
        addTaint(uid);
        varB4EAC82CA7396A68D541C85D26508E83_453588577.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_453588577;
        // ---------- Original Method ----------
        //try {
            //return mPM.getPackagesForUid(uid);
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.785 -0400", hash_original_method = "107797D329CAA491AA1A678294A11B0E", hash_generated_method = "A49EE9989790E53BAE53B81B5EC5B1EB")
    @Override
    public String getNameForUid(int uid) {
        String varB4EAC82CA7396A68D541C85D26508E83_1307818947 = null; //Variable for return #1
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1307818947 = mPM.getNameForUid(uid);
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } //End block
        addTaint(uid);
        varB4EAC82CA7396A68D541C85D26508E83_1307818947.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1307818947;
        // ---------- Original Method ----------
        //try {
            //return mPM.getNameForUid(uid);
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.795 -0400", hash_original_method = "BCD62F04CBDED38DF225700C99BB4852", hash_generated_method = "C26911FB3BC70DD19AAA10C9738F31F9")
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
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_126430094 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_126430094;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.822 -0400", hash_original_method = "2CD6168D318C89447F6184EBDE96189F", hash_generated_method = "0C51F2B67ABD1295B6E574A77A084A60")
    @SuppressWarnings("unchecked")
    @Override
    public List<PackageInfo> getInstalledPackages(int flags) {
        List<PackageInfo> varB4EAC82CA7396A68D541C85D26508E83_475265820 = null; //Variable for return #1
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
                boolean varAF04EF32C9AC89657E6048F98D47E5E7_343076389 = (!slice.isLastSlice());
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_475265820 = packageInfos;
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } //End block
        addTaint(flags);
        varB4EAC82CA7396A68D541C85D26508E83_475265820.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_475265820;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.834 -0400", hash_original_method = "195CA5538214D0B5EDE14A1F47A96E96", hash_generated_method = "48BD68F45DC64898C1D15973EF1B2DA6")
    @SuppressWarnings("unchecked")
    @Override
    public List<ApplicationInfo> getInstalledApplications(int flags) {
        List<ApplicationInfo> varB4EAC82CA7396A68D541C85D26508E83_969705386 = null; //Variable for return #1
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
                boolean varAF04EF32C9AC89657E6048F98D47E5E7_562157057 = (!slice.isLastSlice());
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_969705386 = applicationInfos;
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } //End block
        addTaint(flags);
        varB4EAC82CA7396A68D541C85D26508E83_969705386.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_969705386;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.854 -0400", hash_original_method = "0CD7CD39AE65A355BC33F2BA54C4DC37", hash_generated_method = "5FD793126738CB37FDA68547F045BBF4")
    @Override
    public ResolveInfo resolveActivity(Intent intent, int flags) {
        ResolveInfo varB4EAC82CA7396A68D541C85D26508E83_1165738280 = null; //Variable for return #1
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1165738280 = mPM.resolveIntent(
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
        varB4EAC82CA7396A68D541C85D26508E83_1165738280.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1165738280;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.864 -0400", hash_original_method = "613ED89A001624360A0EB6B3BD081707", hash_generated_method = "1356F7CB8B734F68AB94C24ACCE8A488")
    @Override
    public List<ResolveInfo> queryIntentActivities(Intent intent,
                                                   int flags) {
        List<ResolveInfo> varB4EAC82CA7396A68D541C85D26508E83_326164651 = null; //Variable for return #1
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_326164651 = mPM.queryIntentActivities(
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
        varB4EAC82CA7396A68D541C85D26508E83_326164651.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_326164651;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.899 -0400", hash_original_method = "9B955FD88A95F7C1CCD0CD1DFE6EC270", hash_generated_method = "3668A72364758FFC838AA1E86865594F")
    @Override
    public List<ResolveInfo> queryIntentActivityOptions(
        ComponentName caller, Intent[] specifics, Intent intent,
        int flags) {
        List<ResolveInfo> varB4EAC82CA7396A68D541C85D26508E83_2113164242 = null; //Variable for return #1
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
            varB4EAC82CA7396A68D541C85D26508E83_2113164242 = mPM.queryIntentActivityOptions(caller, specifics,
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
        varB4EAC82CA7396A68D541C85D26508E83_2113164242.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2113164242;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.905 -0400", hash_original_method = "2B65A8BDA3BE53DC3296D1F5CA76CDFC", hash_generated_method = "E8AAB4A39E3EB666A5ABE592A29EF617")
    @Override
    public List<ResolveInfo> queryBroadcastReceivers(Intent intent, int flags) {
        List<ResolveInfo> varB4EAC82CA7396A68D541C85D26508E83_2072941542 = null; //Variable for return #1
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_2072941542 = mPM.queryIntentReceivers(
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
        varB4EAC82CA7396A68D541C85D26508E83_2072941542.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2072941542;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.927 -0400", hash_original_method = "D7D4C733DB611C9D18D346868F9BD0BD", hash_generated_method = "8B56519CE4CB32F6496BED31C1A51955")
    @Override
    public ResolveInfo resolveService(Intent intent, int flags) {
        ResolveInfo varB4EAC82CA7396A68D541C85D26508E83_1580053239 = null; //Variable for return #1
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1580053239 = mPM.resolveService(
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
        varB4EAC82CA7396A68D541C85D26508E83_1580053239.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1580053239;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.934 -0400", hash_original_method = "EEB4EB852740846BAD76CCDE5FC0C613", hash_generated_method = "4E968A3CEF54EA9635C32160AB86BA9D")
    @Override
    public List<ResolveInfo> queryIntentServices(Intent intent, int flags) {
        List<ResolveInfo> varB4EAC82CA7396A68D541C85D26508E83_90156125 = null; //Variable for return #1
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_90156125 = mPM.queryIntentServices(
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
        varB4EAC82CA7396A68D541C85D26508E83_90156125.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_90156125;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.953 -0400", hash_original_method = "3A6513CB26C2E0AF7DACFC2B8A5D560B", hash_generated_method = "2077C69EC32843C66CCC8C88E5ADAECE")
    @Override
    public ProviderInfo resolveContentProvider(String name,
                                               int flags) {
        ProviderInfo varB4EAC82CA7396A68D541C85D26508E83_1460201355 = null; //Variable for return #1
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1460201355 = mPM.resolveContentProvider(name, flags);
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } //End block
        addTaint(name.getTaint());
        addTaint(flags);
        varB4EAC82CA7396A68D541C85D26508E83_1460201355.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1460201355;
        // ---------- Original Method ----------
        //try {
            //return mPM.resolveContentProvider(name, flags);
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.960 -0400", hash_original_method = "7B04A4BE8EFECF5209DBE4F77CB67C42", hash_generated_method = "E9911F0A28B8A05F69231F26607D8EFE")
    @Override
    public List<ProviderInfo> queryContentProviders(String processName,
                                                    int uid, int flags) {
        List<ProviderInfo> varB4EAC82CA7396A68D541C85D26508E83_1899551391 = null; //Variable for return #1
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1899551391 = mPM.queryContentProviders(processName, uid, flags);
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } //End block
        addTaint(processName.getTaint());
        addTaint(uid);
        addTaint(flags);
        varB4EAC82CA7396A68D541C85D26508E83_1899551391.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1899551391;
        // ---------- Original Method ----------
        //try {
            //return mPM.queryContentProviders(processName, uid, flags);
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.007 -0400", hash_original_method = "3120887453BFC9391A593077A4EB2D8C", hash_generated_method = "BFAB4D24F4A75F4ACE6B9B63EACD9775")
    @Override
    public InstrumentationInfo getInstrumentationInfo(
        ComponentName className, int flags) throws NameNotFoundException {
        InstrumentationInfo varB4EAC82CA7396A68D541C85D26508E83_1741008992 = null; //Variable for return #1
        try 
        {
            InstrumentationInfo ii;
            ii = mPM.getInstrumentationInfo(
                className, flags);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1741008992 = ii;
            } //End block
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new NameNotFoundException(className.toString());
        addTaint(className.getTaint());
        addTaint(flags);
        varB4EAC82CA7396A68D541C85D26508E83_1741008992.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1741008992;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.011 -0400", hash_original_method = "0CE547FAA1F9EB003838A9DE59E3AC72", hash_generated_method = "0CA6F04C7A373F65F03617D718777836")
    @Override
    public List<InstrumentationInfo> queryInstrumentation(
        String targetPackage, int flags) {
        List<InstrumentationInfo> varB4EAC82CA7396A68D541C85D26508E83_810102516 = null; //Variable for return #1
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_810102516 = mPM.queryInstrumentation(targetPackage, flags);
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } //End block
        addTaint(targetPackage.getTaint());
        addTaint(flags);
        varB4EAC82CA7396A68D541C85D26508E83_810102516.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_810102516;
        // ---------- Original Method ----------
        //try {
            //return mPM.queryInstrumentation(targetPackage, flags);
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.068 -0400", hash_original_method = "350CC4BDDD2E42419F88F44C033409F6", hash_generated_method = "10C5F410C3167BD05E160A6EE8781E1F")
    @Override
    public Drawable getDrawable(String packageName, int resid,
                                          ApplicationInfo appInfo) {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_772824549 = null; //Variable for return #1
        Drawable varB4EAC82CA7396A68D541C85D26508E83_646942428 = null; //Variable for return #2
        Drawable varB4EAC82CA7396A68D541C85D26508E83_1034950525 = null; //Variable for return #3
        Drawable varB4EAC82CA7396A68D541C85D26508E83_502577171 = null; //Variable for return #4
        ResourceName name;
        name = new ResourceName(packageName, resid);
        Drawable dr;
        dr = getCachedIcon(name);
        {
            varB4EAC82CA7396A68D541C85D26508E83_772824549 = dr;
        } //End block
        {
            try 
            {
                appInfo = getApplicationInfo(packageName, 0);
            } //End block
            catch (NameNotFoundException e)
            {
                varB4EAC82CA7396A68D541C85D26508E83_646942428 = null;
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
            varB4EAC82CA7396A68D541C85D26508E83_1034950525 = dr;
        } //End block
        catch (NameNotFoundException e)
        { }
        catch (Resources.NotFoundException e)
        { }
        catch (RuntimeException e)
        { }
        varB4EAC82CA7396A68D541C85D26508E83_502577171 = null;
        addTaint(packageName.getTaint());
        addTaint(resid);
        addTaint(appInfo.getTaint());
        Drawable varA7E53CE21691AB073D9660D615818899_1686157296; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1686157296 = varB4EAC82CA7396A68D541C85D26508E83_772824549;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1686157296 = varB4EAC82CA7396A68D541C85D26508E83_646942428;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1686157296 = varB4EAC82CA7396A68D541C85D26508E83_1034950525;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1686157296 = varB4EAC82CA7396A68D541C85D26508E83_502577171;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1686157296.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1686157296;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.083 -0400", hash_original_method = "E8823DE045849946097DF943F50B58DB", hash_generated_method = "6A6DA25820F7E100DC850582DB5D29A9")
    @Override
    public Drawable getActivityIcon(ComponentName activityName) throws NameNotFoundException {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_1813843134 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1813843134 = getActivityInfo(activityName, 0).loadIcon(this);
        addTaint(activityName.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1813843134.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1813843134;
        // ---------- Original Method ----------
        //return getActivityInfo(activityName, 0).loadIcon(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.111 -0400", hash_original_method = "EF5F409F30F5D50F1964B6AB6B7F75B7", hash_generated_method = "7A2F489E7881205B93EBA3997DE64F19")
    @Override
    public Drawable getActivityIcon(Intent intent) throws NameNotFoundException {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_491712974 = null; //Variable for return #1
        Drawable varB4EAC82CA7396A68D541C85D26508E83_38294188 = null; //Variable for return #2
        {
            boolean var2CB4FD776F3AF8424EA4E2E544217AF5_1282196993 = (intent.getComponent() != null);
            {
                varB4EAC82CA7396A68D541C85D26508E83_491712974 = getActivityIcon(intent.getComponent());
            } //End block
        } //End collapsed parenthetic
        ResolveInfo info;
        info = resolveActivity(
            intent, PackageManager.MATCH_DEFAULT_ONLY);
        {
            varB4EAC82CA7396A68D541C85D26508E83_38294188 = info.activityInfo.loadIcon(this);
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new NameNotFoundException(intent.toUri(0));
        addTaint(intent.getTaint());
        Drawable varA7E53CE21691AB073D9660D615818899_1401640620; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1401640620 = varB4EAC82CA7396A68D541C85D26508E83_491712974;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1401640620 = varB4EAC82CA7396A68D541C85D26508E83_38294188;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1401640620.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1401640620;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.130 -0400", hash_original_method = "27F8B828FEA8943560AD77E4760B6964", hash_generated_method = "C21A0EABA603DA4EFE0882ABE1CAF101")
    @Override
    public Drawable getDefaultActivityIcon() {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_1940949037 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1940949037 = Resources.getSystem().getDrawable(
            com.android.internal.R.drawable.sym_def_app_icon);
        varB4EAC82CA7396A68D541C85D26508E83_1940949037.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1940949037;
        // ---------- Original Method ----------
        //return Resources.getSystem().getDrawable(
            //com.android.internal.R.drawable.sym_def_app_icon);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.131 -0400", hash_original_method = "C2186A062EDEC18E9DD8F87E8E6291D1", hash_generated_method = "027C1ECB83DF1AAEC9DA664E6DFD1B5B")
    @Override
    public Drawable getApplicationIcon(ApplicationInfo info) {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_1501004039 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1501004039 = info.loadIcon(this);
        addTaint(info.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1501004039.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1501004039;
        // ---------- Original Method ----------
        //return info.loadIcon(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.146 -0400", hash_original_method = "49256B647BD52234F52BC973E3B03E0B", hash_generated_method = "9B06B5B1DD5B8FF9D665DB498F85EA59")
    @Override
    public Drawable getApplicationIcon(String packageName) throws NameNotFoundException {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_1864129750 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1864129750 = getApplicationIcon(getApplicationInfo(packageName, 0));
        addTaint(packageName.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1864129750.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1864129750;
        // ---------- Original Method ----------
        //return getApplicationIcon(getApplicationInfo(packageName, 0));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.166 -0400", hash_original_method = "12128D2FB1F753A28280A7EF3E62F4B2", hash_generated_method = "F56E6FB4F78C94C2B381C307A9910429")
    @Override
    public Drawable getActivityLogo(ComponentName activityName) throws NameNotFoundException {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_793667323 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_793667323 = getActivityInfo(activityName, 0).loadLogo(this);
        addTaint(activityName.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_793667323.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_793667323;
        // ---------- Original Method ----------
        //return getActivityInfo(activityName, 0).loadLogo(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.169 -0400", hash_original_method = "3B1A86BB5E25FB8EFA7A1AD1A88B3B01", hash_generated_method = "8C2AC0779D226EBA54EF253387CB8FB5")
    @Override
    public Drawable getActivityLogo(Intent intent) throws NameNotFoundException {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_1686761924 = null; //Variable for return #1
        Drawable varB4EAC82CA7396A68D541C85D26508E83_1313792847 = null; //Variable for return #2
        {
            boolean var2CB4FD776F3AF8424EA4E2E544217AF5_985169933 = (intent.getComponent() != null);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1686761924 = getActivityLogo(intent.getComponent());
            } //End block
        } //End collapsed parenthetic
        ResolveInfo info;
        info = resolveActivity(
            intent, PackageManager.MATCH_DEFAULT_ONLY);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1313792847 = info.activityInfo.loadLogo(this);
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new NameNotFoundException(intent.toUri(0));
        addTaint(intent.getTaint());
        Drawable varA7E53CE21691AB073D9660D615818899_1821361500; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1821361500 = varB4EAC82CA7396A68D541C85D26508E83_1686761924;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1821361500 = varB4EAC82CA7396A68D541C85D26508E83_1313792847;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1821361500.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1821361500;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.176 -0400", hash_original_method = "586E62978169D56092172114763F9AD3", hash_generated_method = "DDED7B1960C4898905949302C4C0FB6B")
    @Override
    public Drawable getApplicationLogo(ApplicationInfo info) {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_1235550675 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1235550675 = info.loadLogo(this);
        addTaint(info.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1235550675.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1235550675;
        // ---------- Original Method ----------
        //return info.loadLogo(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.208 -0400", hash_original_method = "6BC85FEDD3936A7851329E2331D0279D", hash_generated_method = "1603D432236B9784C5C90B1AD4BAD7B6")
    @Override
    public Drawable getApplicationLogo(String packageName) throws NameNotFoundException {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_961464551 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_961464551 = getApplicationLogo(getApplicationInfo(packageName, 0));
        addTaint(packageName.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_961464551.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_961464551;
        // ---------- Original Method ----------
        //return getApplicationLogo(getApplicationInfo(packageName, 0));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.284 -0400", hash_original_method = "E07E3E36CD8F79CF4FE12B9F33A40344", hash_generated_method = "4B72BC1D39468D3CA954235527AEBBD8")
    @Override
    public Resources getResourcesForActivity(
        ComponentName activityName) throws NameNotFoundException {
        Resources varB4EAC82CA7396A68D541C85D26508E83_703188024 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_703188024 = getResourcesForApplication(
            getActivityInfo(activityName, 0).applicationInfo);
        addTaint(activityName.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_703188024.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_703188024;
        // ---------- Original Method ----------
        //return getResourcesForApplication(
            //getActivityInfo(activityName, 0).applicationInfo);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.330 -0400", hash_original_method = "AC20F77416CABFA638F647DA9F2F230E", hash_generated_method = "D0A96BFE93B0AD29AFEEC249AA9FFFF1")
    @Override
    public Resources getResourcesForApplication(
        ApplicationInfo app) throws NameNotFoundException {
        Resources varB4EAC82CA7396A68D541C85D26508E83_384310351 = null; //Variable for return #1
        Resources varB4EAC82CA7396A68D541C85D26508E83_1354551113 = null; //Variable for return #2
        {
            boolean varF67FB556D575A0DB52E0C311AE1F282F_29352109 = (app.packageName.equals("system"));
            {
                varB4EAC82CA7396A68D541C85D26508E83_384310351 = mContext.mMainThread.getSystemContext().getResources();
            } //End block
        } //End collapsed parenthetic
        Resources r;
        r = mContext.mMainThread.getTopLevelResources(
            app.uid == Process.myUid() ? app.sourceDir
            : app.publicSourceDir, mContext.mPackageInfo);//DSFIXME:  CODE0008: Nested ternary operator in expression
        {
            varB4EAC82CA7396A68D541C85D26508E83_1354551113 = r;
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new NameNotFoundException("Unable to open " + app.publicSourceDir);
        addTaint(app.getTaint());
        Resources varA7E53CE21691AB073D9660D615818899_353624294; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_353624294 = varB4EAC82CA7396A68D541C85D26508E83_384310351;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_353624294 = varB4EAC82CA7396A68D541C85D26508E83_1354551113;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_353624294.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_353624294;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.334 -0400", hash_original_method = "ACD444E0FC7FCEAEB5D1FF09DD4A5912", hash_generated_method = "5C3740E05D582C257925E42D64060E68")
    @Override
    public Resources getResourcesForApplication(
        String appPackageName) throws NameNotFoundException {
        Resources varB4EAC82CA7396A68D541C85D26508E83_856871208 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_856871208 = getResourcesForApplication(
            getApplicationInfo(appPackageName, 0));
        addTaint(appPackageName.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_856871208.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_856871208;
        // ---------- Original Method ----------
        //return getResourcesForApplication(
            //getApplicationInfo(appPackageName, 0));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.359 -0400", hash_original_method = "6B2AA9A609FE89D703EEC81AF1FC0890", hash_generated_method = "4435685D3908563ED964BE4F9E28D674")
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_533054308 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_533054308;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.386 -0400", hash_original_method = "805BC435FDAE098AFC4F53B40E89D7C1", hash_generated_method = "D2A7B0E28FD2575E73BD991A539E136B")
    private Drawable getCachedIcon(ResourceName name) {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_1681790366 = null; //Variable for return #1
        Drawable varB4EAC82CA7396A68D541C85D26508E83_2014653001 = null; //Variable for return #2
        {
            WeakReference<Drawable.ConstantState> wr;
            wr = sIconCache.get(name);
            {
                Drawable.ConstantState state;
                state = wr.get();
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1681790366 = state.newDrawable();
                } //End block
                sIconCache.remove(name);
            } //End block
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_2014653001 = null;
        addTaint(name.getTaint());
        Drawable varA7E53CE21691AB073D9660D615818899_843533356; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_843533356 = varB4EAC82CA7396A68D541C85D26508E83_1681790366;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_843533356 = varB4EAC82CA7396A68D541C85D26508E83_2014653001;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_843533356.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_843533356;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.401 -0400", hash_original_method = "1ADDA1851B7207BD0D6C119E2C63D6A2", hash_generated_method = "4706D414367874136365DA3DBB20C3A5")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.424 -0400", hash_original_method = "B66098C8E55783775B73FA7D73879D41", hash_generated_method = "A1F7F06AEDFD9AF1162FE1E45FA25517")
    private CharSequence getCachedString(ResourceName name) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_291178441 = null; //Variable for return #1
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_258837197 = null; //Variable for return #2
        {
            WeakReference<CharSequence> wr;
            wr = sStringCache.get(name);
            {
                CharSequence cs;
                cs = wr.get();
                {
                    varB4EAC82CA7396A68D541C85D26508E83_291178441 = cs;
                } //End block
                sStringCache.remove(name);
            } //End block
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_258837197 = null;
        addTaint(name.getTaint());
        CharSequence varA7E53CE21691AB073D9660D615818899_1284655725; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1284655725 = varB4EAC82CA7396A68D541C85D26508E83_291178441;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1284655725 = varB4EAC82CA7396A68D541C85D26508E83_258837197;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1284655725.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1284655725;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.452 -0400", hash_original_method = "70E4290F1842F0A45B89D50D6CDEDDBB", hash_generated_method = "7D27E17696535E60A1AB1B6049B959C9")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.475 -0400", hash_original_method = "771B010EDE230C24A313E1F6F3869FDB", hash_generated_method = "E92A1F3DE6CFF929DE83E312D1FF35D7")
    @Override
    public CharSequence getText(String packageName, int resid,
                                ApplicationInfo appInfo) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1646421389 = null; //Variable for return #1
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1518476081 = null; //Variable for return #2
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_686363052 = null; //Variable for return #3
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1543130377 = null; //Variable for return #4
        ResourceName name;
        name = new ResourceName(packageName, resid);
        CharSequence text;
        text = getCachedString(name);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1646421389 = text;
        } //End block
        {
            try 
            {
                appInfo = getApplicationInfo(packageName, 0);
            } //End block
            catch (NameNotFoundException e)
            {
                varB4EAC82CA7396A68D541C85D26508E83_1518476081 = null;
            } //End block
        } //End block
        try 
        {
            Resources r;
            r = getResourcesForApplication(appInfo);
            text = r.getText(resid);
            putCachedString(name, text);
            varB4EAC82CA7396A68D541C85D26508E83_686363052 = text;
        } //End block
        catch (NameNotFoundException e)
        { }
        catch (RuntimeException e)
        { }
        varB4EAC82CA7396A68D541C85D26508E83_1543130377 = null;
        addTaint(packageName.getTaint());
        addTaint(resid);
        addTaint(appInfo.getTaint());
        CharSequence varA7E53CE21691AB073D9660D615818899_2074103814; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2074103814 = varB4EAC82CA7396A68D541C85D26508E83_1646421389;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_2074103814 = varB4EAC82CA7396A68D541C85D26508E83_1518476081;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_2074103814 = varB4EAC82CA7396A68D541C85D26508E83_686363052;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2074103814 = varB4EAC82CA7396A68D541C85D26508E83_1543130377;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2074103814.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2074103814;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.493 -0400", hash_original_method = "F130C54905A9CE16326CF20EF6E93255", hash_generated_method = "E87E01EF610A9054580C363978209BC4")
    @Override
    public XmlResourceParser getXml(String packageName, int resid,
                                    ApplicationInfo appInfo) {
        XmlResourceParser varB4EAC82CA7396A68D541C85D26508E83_1441107147 = null; //Variable for return #1
        XmlResourceParser varB4EAC82CA7396A68D541C85D26508E83_1064061625 = null; //Variable for return #2
        XmlResourceParser varB4EAC82CA7396A68D541C85D26508E83_923739581 = null; //Variable for return #3
        {
            try 
            {
                appInfo = getApplicationInfo(packageName, 0);
            } //End block
            catch (NameNotFoundException e)
            {
                varB4EAC82CA7396A68D541C85D26508E83_1441107147 = null;
            } //End block
        } //End block
        try 
        {
            Resources r;
            r = getResourcesForApplication(appInfo);
            varB4EAC82CA7396A68D541C85D26508E83_1064061625 = r.getXml(resid);
        } //End block
        catch (RuntimeException e)
        { }
        catch (NameNotFoundException e)
        { }
        varB4EAC82CA7396A68D541C85D26508E83_923739581 = null;
        addTaint(packageName.getTaint());
        addTaint(resid);
        addTaint(appInfo.getTaint());
        XmlResourceParser varA7E53CE21691AB073D9660D615818899_1219355483; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1219355483 = varB4EAC82CA7396A68D541C85D26508E83_1441107147;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1219355483 = varB4EAC82CA7396A68D541C85D26508E83_1064061625;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1219355483 = varB4EAC82CA7396A68D541C85D26508E83_923739581;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1219355483.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1219355483;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.502 -0400", hash_original_method = "4AFDE050276913F392973B277F54706D", hash_generated_method = "0A3199EB05806B986D0556F8929B6470")
    @Override
    public CharSequence getApplicationLabel(ApplicationInfo info) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_371778359 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_371778359 = info.loadLabel(this);
        addTaint(info.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_371778359.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_371778359;
        // ---------- Original Method ----------
        //return info.loadLabel(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.523 -0400", hash_original_method = "99610A6DD5E10C01303307EBA6938AA8", hash_generated_method = "400A22F298DF08C5D0E769F3CCD38501")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.525 -0400", hash_original_method = "769145FCC72852B2314845C8A89A2DAD", hash_generated_method = "F3245D05F97B312C267DEC2D9622BA8B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.552 -0400", hash_original_method = "E593338881B3E45506EA974F446D2A6B", hash_generated_method = "37756C8FAB2D16E48F6540B81C396231")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.557 -0400", hash_original_method = "A168A8E169316429D31E261AD639AED4", hash_generated_method = "9C8C38D01201816D92FED5BF837CFF63")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.559 -0400", hash_original_method = "D8F1CA3B8F90BF876B114DD825F09703", hash_generated_method = "013104B1BDA6E03638BA31CEC045094F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.584 -0400", hash_original_method = "13C0F9FC5FF4142BD538C8A3AADB3621", hash_generated_method = "80A6A0022181DA5E041D8D0BCA649C0C")
    @Override
    public String getInstallerPackageName(String packageName) {
        String varB4EAC82CA7396A68D541C85D26508E83_1647451300 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1220275389 = null; //Variable for return #2
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1647451300 = mPM.getInstallerPackageName(packageName);
        } //End block
        catch (RemoteException e)
        { }
        varB4EAC82CA7396A68D541C85D26508E83_1220275389 = null;
        addTaint(packageName.getTaint());
        String varA7E53CE21691AB073D9660D615818899_252474484; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_252474484 = varB4EAC82CA7396A68D541C85D26508E83_1647451300;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_252474484 = varB4EAC82CA7396A68D541C85D26508E83_1220275389;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_252474484.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_252474484;
        // ---------- Original Method ----------
        //try {
            //return mPM.getInstallerPackageName(packageName);
        //} catch (RemoteException e) {
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.594 -0400", hash_original_method = "6B4A8C0BA02325B97A4B696E509E27F1", hash_generated_method = "6A3ED9E8A60057D0DB3AC4995AF0B2E7")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.596 -0400", hash_original_method = "41D4F7CDEA8F3FA97A215E5DB5AE3B7F", hash_generated_method = "A1F8ED7652B7387CD0E6421FC7565E8D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.602 -0400", hash_original_method = "9E003FA712762A764BBDA3187B8255C1", hash_generated_method = "A69811C1495E99329928ECA86D124251")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.615 -0400", hash_original_method = "E7A7F0006F405C835ECAAE7B969343FA", hash_generated_method = "0B639835B9C7BD19E29CC9E9938962C4")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.620 -0400", hash_original_method = "8531AD2E443F843CDBBD03DDCC5F2882", hash_generated_method = "B0070DACE1C55EC19587AB40DB11BCAF")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.627 -0400", hash_original_method = "00314015F36B785D35449EC7724DA4A0", hash_generated_method = "6ECEB12C252949AE71858382236E4A0D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.629 -0400", hash_original_method = "A9291C102B2FAAEF4C90A57E1B6DE098", hash_generated_method = "0D690A0FE1B62191F94C37814ED9C13E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.659 -0400", hash_original_method = "F1B5214867A85B15353BE55995A19BB6", hash_generated_method = "16AE382D6D44614F9CE0F2F1A0174EBF")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.662 -0400", hash_original_method = "4A08CFB9ACE88EAEABD2D18F083F329D", hash_generated_method = "B26A934DCDDD6C84E81AFE80C4C3B66B")
    @Override
    public List<PackageInfo> getPreferredPackages(int flags) {
        List<PackageInfo> varB4EAC82CA7396A68D541C85D26508E83_2066122667 = null; //Variable for return #1
        List<PackageInfo> varB4EAC82CA7396A68D541C85D26508E83_1259530590 = null; //Variable for return #2
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_2066122667 = mPM.getPreferredPackages(flags);
        } //End block
        catch (RemoteException e)
        { }
        varB4EAC82CA7396A68D541C85D26508E83_1259530590 = new ArrayList<PackageInfo>();
        addTaint(flags);
        List<PackageInfo> varA7E53CE21691AB073D9660D615818899_915304819; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_915304819 = varB4EAC82CA7396A68D541C85D26508E83_2066122667;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_915304819 = varB4EAC82CA7396A68D541C85D26508E83_1259530590;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_915304819.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_915304819;
        // ---------- Original Method ----------
        //try {
            //return mPM.getPreferredPackages(flags);
        //} catch (RemoteException e) {
        //}
        //return new ArrayList<PackageInfo>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.670 -0400", hash_original_method = "E5D2F7A75D600839A582F36FB9BA5425", hash_generated_method = "E4890C1035F01F9D32FCB826AD598DD3")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.671 -0400", hash_original_method = "2885B1E40721D55CC13EAA30EB1BAE52", hash_generated_method = "C5FF225D327460B3296A7AFA75368096")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.685 -0400", hash_original_method = "818084167B76F544DAE31D40EA850683", hash_generated_method = "C9C1FB3440196C8943FD1E9972510DCD")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.697 -0400", hash_original_method = "9A1408660FD10D92BECBE2BE18AA9510", hash_generated_method = "A3506EF3082B48CFE4B4E84367D1EE19")
    @Override
    public int getPreferredActivities(List<IntentFilter> outFilters,
                                      List<ComponentName> outActivities, String packageName) {
        try 
        {
            int varAAA2984E5864A69FBA0F19FD84D394A5_1030591956 = (mPM.getPreferredActivities(outFilters, outActivities, packageName));
        } //End block
        catch (RemoteException e)
        { }
        addTaint(outFilters.getTaint());
        addTaint(outActivities.getTaint());
        addTaint(packageName.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_230011516 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_230011516;
        // ---------- Original Method ----------
        //try {
            //return mPM.getPreferredActivities(outFilters, outActivities, packageName);
        //} catch (RemoteException e) {
        //}
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.699 -0400", hash_original_method = "324289EEBFA692363CEA9B4C548C82A7", hash_generated_method = "A0BA00110F6663F102A5964560E3C0E9")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.717 -0400", hash_original_method = "214E6E4C94F679DC0FE6A4159B821EAF", hash_generated_method = "25FCC689DD3693E9DAEE4655F1319897")
    @Override
    public int getComponentEnabledSetting(ComponentName componentName) {
        try 
        {
            int var1528F93F8B5599DBD2DEEBFDF40122F0_1145770976 = (mPM.getComponentEnabledSetting(componentName));
        } //End block
        catch (RemoteException e)
        { }
        addTaint(componentName.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1765164054 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1765164054;
        // ---------- Original Method ----------
        //try {
            //return mPM.getComponentEnabledSetting(componentName);
        //} catch (RemoteException e) {
        //}
        //return PackageManager.COMPONENT_ENABLED_STATE_DEFAULT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.719 -0400", hash_original_method = "893989AE0F295A10184FE7AD874B7991", hash_generated_method = "C30D96FC52BAA3663F8231ABB8ABA6D1")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.731 -0400", hash_original_method = "786754E395F784476E8D899ABD01121D", hash_generated_method = "4BA6BC6DB1261DC519933BE67D68A877")
    @Override
    public int getApplicationEnabledSetting(String packageName) {
        try 
        {
            int varF2CA84C656A1ECB5C0715BD15E6F333E_2043557060 = (mPM.getApplicationEnabledSetting(packageName));
        } //End block
        catch (RemoteException e)
        { }
        addTaint(packageName.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1315714115 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1315714115;
        // ---------- Original Method ----------
        //try {
            //return mPM.getApplicationEnabledSetting(packageName);
        //} catch (RemoteException e) {
        //}
        //return PackageManager.COMPONENT_ENABLED_STATE_DEFAULT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.753 -0400", hash_original_method = "26D19368C79A5889D2D25A72A45789A8", hash_generated_method = "4D3086B710AF2F44994BB1C332CFF10E")
    @Override
    public UserInfo createUser(String name, int flags) {
        UserInfo varB4EAC82CA7396A68D541C85D26508E83_1607046927 = null; //Variable for return #1
        UserInfo varB4EAC82CA7396A68D541C85D26508E83_78505376 = null; //Variable for return #2
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1607046927 = mPM.createUser(name, flags);
        } //End block
        catch (RemoteException e)
        { }
        varB4EAC82CA7396A68D541C85D26508E83_78505376 = null;
        addTaint(name.getTaint());
        addTaint(flags);
        UserInfo varA7E53CE21691AB073D9660D615818899_1702025609; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1702025609 = varB4EAC82CA7396A68D541C85D26508E83_1607046927;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1702025609 = varB4EAC82CA7396A68D541C85D26508E83_78505376;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1702025609.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1702025609;
        // ---------- Original Method ----------
        //try {
            //return mPM.createUser(name, flags);
        //} catch (RemoteException e) {
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.771 -0400", hash_original_method = "D3989192690585F23E6C25734E0C3BDB", hash_generated_method = "F5034C0EE7E136F5AB448776373AB6BD")
    @Override
    public List<UserInfo> getUsers() {
        List<UserInfo> varB4EAC82CA7396A68D541C85D26508E83_924122936 = null; //Variable for return #1
        ArrayList<UserInfo> users;
        users = new ArrayList<UserInfo>();
        UserInfo primary;
        primary = new UserInfo(0, "Root!",
                UserInfo.FLAG_ADMIN | UserInfo.FLAG_PRIMARY);
        users.add(primary);
        varB4EAC82CA7396A68D541C85D26508E83_924122936 = users;
        varB4EAC82CA7396A68D541C85D26508E83_924122936.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_924122936;
        // ---------- Original Method ----------
        //ArrayList<UserInfo> users = new ArrayList<UserInfo>();
        //UserInfo primary = new UserInfo(0, "Root!",
                //UserInfo.FLAG_ADMIN | UserInfo.FLAG_PRIMARY);
        //users.add(primary);
        //return users;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.776 -0400", hash_original_method = "7D391C716B6EBFD3B4233647A1DCBC34", hash_generated_method = "90BA58B02A235A96710F590E6BE02B45")
    @Override
    public boolean removeUser(int id) {
        try 
        {
            boolean varF0857FEEEFECDA71C81CF89A6CEBBA1A_279293374 = (mPM.removeUser(id));
        } //End block
        catch (RemoteException e)
        { }
        addTaint(id);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1638194443 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1638194443;
        // ---------- Original Method ----------
        //try {
            //return mPM.removeUser(id);
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.777 -0400", hash_original_method = "C52981B6B26B608864F1952FFD2E785F", hash_generated_method = "4417EB3E02E6716448462D97478FC1FC")
    @Override
    public void updateUserName(int id, String name) {
        addTaint(id);
        addTaint(name.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.787 -0400", hash_original_method = "B193A8F9463928060D13777D952477CD", hash_generated_method = "D32F8A11D82F3C142EEC3FF4520279CC")
    @Override
    public void updateUserFlags(int id, int flags) {
        addTaint(id);
        addTaint(flags);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.811 -0400", hash_original_method = "05FAEEF75E7B74D35A0F0687A4ACD32C", hash_generated_method = "2C73ADE98A13FA0E03A0CE07ABECA5C0")
    @Override
    public VerifierDeviceIdentity getVerifierDeviceIdentity() {
        VerifierDeviceIdentity varB4EAC82CA7396A68D541C85D26508E83_1939848828 = null; //Variable for return #1
        VerifierDeviceIdentity varB4EAC82CA7396A68D541C85D26508E83_1493267528 = null; //Variable for return #2
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1939848828 = mPM.getVerifierDeviceIdentity();
        } //End block
        catch (RemoteException e)
        { }
        varB4EAC82CA7396A68D541C85D26508E83_1493267528 = null;
        VerifierDeviceIdentity varA7E53CE21691AB073D9660D615818899_152370291; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_152370291 = varB4EAC82CA7396A68D541C85D26508E83_1939848828;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_152370291 = varB4EAC82CA7396A68D541C85D26508E83_1493267528;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_152370291.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_152370291;
        // ---------- Original Method ----------
        //try {
            //return mPM.getVerifierDeviceIdentity();
        //} catch (RemoteException e) {
        //}
        //return null;
    }

    
    private static final class ResourceName {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.812 -0400", hash_original_field = "387F1FA6FC99B8AE187C010A06120611", hash_generated_field = "6F92EE1B3BCDC0C4179CF5FD998BE046")

        String packageName;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.813 -0400", hash_original_field = "D4DDD8F15E145D654808CFEB3504E8E3", hash_generated_field = "5FB1FE173593F2C1352A3849ECD329FE")

        int iconId;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.815 -0400", hash_original_method = "00C0083FA3192C6FB2E9C58DC21ABF99", hash_generated_method = "1E60D2B25AB72FD493F4CCEBE8E14228")
          ResourceName(String _packageName, int _iconId) {
            packageName = _packageName;
            iconId = _iconId;
            // ---------- Original Method ----------
            //packageName = _packageName;
            //iconId = _iconId;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.834 -0400", hash_original_method = "1D7CABC5D0E2E4029539D2105E7113C1", hash_generated_method = "F4B0DF37D4D0AD07245EBE22412943F8")
          ResourceName(ApplicationInfo aInfo, int _iconId) {
            this(aInfo.packageName, _iconId);
            addTaint(aInfo.getTaint());
            addTaint(_iconId);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.836 -0400", hash_original_method = "316DD832F87E78ED23C1ED370845ED19", hash_generated_method = "CD60A1612BA3B74B93A271C021B4D340")
          ResourceName(ComponentInfo cInfo, int _iconId) {
            this(cInfo.applicationInfo.packageName, _iconId);
            addTaint(cInfo.getTaint());
            addTaint(_iconId);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.837 -0400", hash_original_method = "B7E8883725512A2439D57072801DA2BC", hash_generated_method = "DF21CBF5040D1AA4EFF30C198363476D")
          ResourceName(ResolveInfo rInfo, int _iconId) {
            this(rInfo.activityInfo.applicationInfo.packageName, _iconId);
            addTaint(rInfo.getTaint());
            addTaint(_iconId);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.860 -0400", hash_original_method = "77EA94B0E7A0581CD73B79023B92E268", hash_generated_method = "8CA787EB14AB3145ACD6416B013256A3")
        @Override
        public boolean equals(Object o) {
            {
                boolean var1DE06DCDBE8CB2577D8B96631D951907_432238958 = (o == null || getClass() != o.getClass());
            } //End collapsed parenthetic
            ResourceName that;
            that = (ResourceName) o;
            boolean var2CF4425DEC96D908C0E598EDFC75DDA1_834591787 = (!(packageName != null ?
                     !packageName.equals(that.packageName) : that.packageName != null)); //DSFIXME:  CODE0008: Nested ternary operator in expression
            addTaint(o.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1721403424 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1721403424;
            // ---------- Original Method ----------
            //if (this == o) return true;
            //if (o == null || getClass() != o.getClass()) return false;
            //ResourceName that = (ResourceName) o;
            //if (iconId != that.iconId) return false;
            //return !(packageName != null ?
                     //!packageName.equals(that.packageName) : that.packageName != null);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.862 -0400", hash_original_method = "FE96AD3461E654FCE4E8B88F254AC3EE", hash_generated_method = "69A992BCCADF107DE0B3D6FDC5C2EDD5")
        @Override
        public int hashCode() {
            int result;
            result = packageName.hashCode();
            result = 31 * result + iconId;
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1185299879 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1185299879;
            // ---------- Original Method ----------
            //int result;
            //result = packageName.hashCode();
            //result = 31 * result + iconId;
            //return result;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.886 -0400", hash_original_method = "19C1C9668D8A7EEF540F3D9429936D14", hash_generated_method = "A0B0B93814901322689E959FC1219D66")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_1044652701 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1044652701 = "{ResourceName " + packageName + " / " + iconId + "}";
            varB4EAC82CA7396A68D541C85D26508E83_1044652701.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1044652701;
            // ---------- Original Method ----------
            //return "{ResourceName " + packageName + " / " + iconId + "}";
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.886 -0400", hash_original_field = "6567C925641831CFA00E9DD4884FA1D6", hash_generated_field = "318BD6D0D7A5EECD7BBDF9682BC03BEA")

    private static String TAG = "ApplicationPackageManager";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.887 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "E83DF1E2E661A92B1AFDA8C473D190B2")

    private static boolean DEBUG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.888 -0400", hash_original_field = "C3489935DD7AFC611D460C12208E5765", hash_generated_field = "EAB7DEAF050DD92292423D2672847096")

    private static boolean DEBUG_ICONS = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.888 -0400", hash_original_field = "2F49D49D71E16DE6B9E03ABB51788CD5", hash_generated_field = "C134B13DBDEF193093808FEE63AE2EEC")

    private static Object sSync = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.889 -0400", hash_original_field = "86949C5674DAE04FF598125EDFB9A09B", hash_generated_field = "4B02A68E27DCF1DC814B05F533A46F39")

    private static HashMap<ResourceName, WeakReference<Drawable.ConstantState>> sIconCache = new HashMap<ResourceName, WeakReference<Drawable.ConstantState>>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.889 -0400", hash_original_field = "C59A7EE72451F56F2C82359DD275010F", hash_generated_field = "F43C1D13F1C693E3CC3452E528CF10D8")

    private static HashMap<ResourceName, WeakReference<CharSequence>> sStringCache = new HashMap<ResourceName, WeakReference<CharSequence>>();
}

