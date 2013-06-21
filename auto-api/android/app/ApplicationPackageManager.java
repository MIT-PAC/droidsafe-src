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
    int mCachedSafeMode = -1;
    private ContextImpl mContext;
    private IPackageManager mPM;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.649 -0400", hash_original_method = "12FC21630330363415BEFB2BB747FDD4", hash_generated_method = "4BAB4870EB1E14B13F0E81749F27E42B")
    @DSModeled(DSC.SAFE)
     ApplicationPackageManager(ContextImpl context,
                              IPackageManager pm) {
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(pm.dsTaint);
        // ---------- Original Method ----------
        //mContext = context;
        //mPM = pm;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.649 -0400", hash_original_method = "B0DADC2DBFEC092F753C36E8DEB385A1", hash_generated_method = "9D5CC2607AF817D24972782EDEF8FCC9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public PackageInfo getPackageInfo(String packageName, int flags) throws NameNotFoundException {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(packageName);
        try 
        {
            PackageInfo pi;
            pi = mPM.getPackageInfo(packageName, flags);
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new NameNotFoundException(packageName);
        return (PackageInfo)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.650 -0400", hash_original_method = "C5CDEAB4FF073C2ACB7E7915B56F1D0F", hash_generated_method = "4AF84DE72EA888CC233F5FC4566C5939")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String[] currentToCanonicalPackageNames(String[] names) {
        dsTaint.addTaint(names[0]);
        try 
        {
            String[] var218BFE78A0B5E30DDDC56D8B75C7097C_1788168350 = (mPM.currentToCanonicalPackageNames(names));
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } //End block
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //try {
            //return mPM.currentToCanonicalPackageNames(names);
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.650 -0400", hash_original_method = "9BD980F14E9EC05077595EA826722236", hash_generated_method = "221B2B0670CE9C253191EF7BC658ADDC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String[] canonicalToCurrentPackageNames(String[] names) {
        dsTaint.addTaint(names[0]);
        try 
        {
            String[] varD8C2B0DECD4F363BB0CB340D0CE67B40_794313514 = (mPM.canonicalToCurrentPackageNames(names));
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } //End block
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //try {
            //return mPM.canonicalToCurrentPackageNames(names);
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.651 -0400", hash_original_method = "A679E3857CF73FF4B9C2EA4F09C7DBB7", hash_generated_method = "EDB9893F902676462E6373E8DA20D369")
    @DSModeled(DSC.SPEC)
    @Override
    public Intent getLaunchIntentForPackage(String packageName) {
        dsTaint.addTaint(packageName);
        Intent intentToResolve;
        intentToResolve = new Intent(Intent.ACTION_MAIN);
        intentToResolve.addCategory(Intent.CATEGORY_INFO);
        intentToResolve.setPackage(packageName);
        List<ResolveInfo> ris;
        ris = queryIntentActivities(intentToResolve, 0);
        {
            boolean varBFFD11AFF4B06D0E1D653A2E50FC1BFF_989548421 = (ris == null || ris.size() <= 0);
            {
                intentToResolve.removeCategory(Intent.CATEGORY_INFO);
                intentToResolve.addCategory(Intent.CATEGORY_LAUNCHER);
                intentToResolve.setPackage(packageName);
                ris = queryIntentActivities(intentToResolve, 0);
            } //End block
        } //End collapsed parenthetic
        {
            boolean varBFFD11AFF4B06D0E1D653A2E50FC1BFF_1552544372 = (ris == null || ris.size() <= 0);
        } //End collapsed parenthetic
        Intent intent;
        intent = new Intent(intentToResolve);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setClassName(ris.get(0).activityInfo.packageName,
                ris.get(0).activityInfo.name);
        return (Intent)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.652 -0400", hash_original_method = "65CBA80193594BC7AC8CBF648823BDBA", hash_generated_method = "91AF4E3C8C539C5BE17AA911279D8989")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int[] getPackageGids(String packageName) throws NameNotFoundException {
        dsTaint.addTaint(packageName);
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
        int[] retVal = new int[1];
        retVal[0] = dsTaint.getTaintInt();
        return retVal;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.653 -0400", hash_original_method = "16E2B9223A8B92626D3604D0E58E2278", hash_generated_method = "5A30F0E74D15A397014CEEA5232649E4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public PermissionInfo getPermissionInfo(String name, int flags) throws NameNotFoundException {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(name);
        try 
        {
            PermissionInfo pi;
            pi = mPM.getPermissionInfo(name, flags);
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new NameNotFoundException(name);
        return (PermissionInfo)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.654 -0400", hash_original_method = "2283AA5BDEF3F8B3341260BB74FBE8C3", hash_generated_method = "948A5B02E77D7B81B89489F62AD88F75")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public List<PermissionInfo> queryPermissionsByGroup(String group, int flags) throws NameNotFoundException {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(group);
        try 
        {
            List<PermissionInfo> pi;
            pi = mPM.queryPermissionsByGroup(group, flags);
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new NameNotFoundException(group);
        return (List<PermissionInfo>)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.655 -0400", hash_original_method = "4E576FD7FE2DDB9674E042581657631F", hash_generated_method = "5C24B494B3A74574A25F9C2F1B7B0010")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public PermissionGroupInfo getPermissionGroupInfo(String name,
                                                      int flags) throws NameNotFoundException {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(name);
        try 
        {
            PermissionGroupInfo pgi;
            pgi = mPM.getPermissionGroupInfo(name, flags);
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new NameNotFoundException(name);
        return (PermissionGroupInfo)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.655 -0400", hash_original_method = "DD7F1EBA9089D82A0EEA68FDD3DACC66", hash_generated_method = "0F9EB08D36DB24311285C9DE2098FDC0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public List<PermissionGroupInfo> getAllPermissionGroups(int flags) {
        dsTaint.addTaint(flags);
        try 
        {
            List<PermissionGroupInfo> varDC758C768BE229904FB5C4452CAEBE10_540881677 = (mPM.getAllPermissionGroups(flags));
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } //End block
        return (List<PermissionGroupInfo>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //try {
            //return mPM.getAllPermissionGroups(flags);
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.656 -0400", hash_original_method = "8999420BFE5728B346477621EA154ABF", hash_generated_method = "1A776DC64111FDE269743FD3282B4942")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ApplicationInfo getApplicationInfo(String packageName, int flags) throws NameNotFoundException {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(packageName);
        try 
        {
            ApplicationInfo ai;
            ai = mPM.getApplicationInfo(packageName, flags);
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new NameNotFoundException(packageName);
        return (ApplicationInfo)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.656 -0400", hash_original_method = "9B4FC7EA40C0BB7AEEEEEF1D86D28DE8", hash_generated_method = "726F533EDFF144AC60E7294B45A7FA5B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ActivityInfo getActivityInfo(ComponentName className, int flags) throws NameNotFoundException {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(className.dsTaint);
        try 
        {
            ActivityInfo ai;
            ai = mPM.getActivityInfo(className, flags);
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new NameNotFoundException(className.toString());
        return (ActivityInfo)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.657 -0400", hash_original_method = "399255B19735D8EC733B05B14D3B4711", hash_generated_method = "559BB535A1C6CFADB4FA7EDBF806453A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ActivityInfo getReceiverInfo(ComponentName className, int flags) throws NameNotFoundException {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(className.dsTaint);
        try 
        {
            ActivityInfo ai;
            ai = mPM.getReceiverInfo(className, flags);
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new NameNotFoundException(className.toString());
        return (ActivityInfo)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.657 -0400", hash_original_method = "50C1BC4F3995D229FF03E27E05E5BE36", hash_generated_method = "EC50B51ACEAABADD9002D039D64817F9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ServiceInfo getServiceInfo(ComponentName className, int flags) throws NameNotFoundException {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(className.dsTaint);
        try 
        {
            ServiceInfo si;
            si = mPM.getServiceInfo(className, flags);
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new NameNotFoundException(className.toString());
        return (ServiceInfo)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.658 -0400", hash_original_method = "895E4F29ECA72E6836B6F503A466760A", hash_generated_method = "63ACA70EB0239350301B2FF3B67AB294")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ProviderInfo getProviderInfo(ComponentName className, int flags) throws NameNotFoundException {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(className.dsTaint);
        try 
        {
            ProviderInfo pi;
            pi = mPM.getProviderInfo(className, flags);
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new NameNotFoundException(className.toString());
        return (ProviderInfo)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.658 -0400", hash_original_method = "E90BE84736723B0914BD9D43484D5AAD", hash_generated_method = "4E34839D56044C31CF159E82F99C812E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String[] getSystemSharedLibraryNames() {
        try 
        {
            String[] varF78B9415DCB1CC77E8F92467AD6AFA69_398726831 = (mPM.getSystemSharedLibraryNames());
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } //End block
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //try {
            //return mPM.getSystemSharedLibraryNames();
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.659 -0400", hash_original_method = "887B55B734ED0895C5FA7D7CF721CE58", hash_generated_method = "2A4E21880B9D319D3E80A56A878DD216")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public FeatureInfo[] getSystemAvailableFeatures() {
        try 
        {
            FeatureInfo[] varC56DEDF438B5E844500276D970DC11AC_949056593 = (mPM.getSystemAvailableFeatures());
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } //End block
        return (FeatureInfo[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //try {
            //return mPM.getSystemAvailableFeatures();
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.659 -0400", hash_original_method = "8E2B8D0B6C29BED8B3E866F74247B636", hash_generated_method = "A0679F80A4AB2121E9B93694B7B3EB42")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean hasSystemFeature(String name) {
        dsTaint.addTaint(name);
        try 
        {
            boolean varD59F1F4384BD648C5D21225C24B9C301_885787261 = (mPM.hasSystemFeature(name));
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //return mPM.hasSystemFeature(name);
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.660 -0400", hash_original_method = "D191D3716589DABF1290937DD7F4276D", hash_generated_method = "11C40F2650AE4B0597CB341181EB9DEF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int checkPermission(String permName, String pkgName) {
        dsTaint.addTaint(pkgName);
        dsTaint.addTaint(permName);
        try 
        {
            int varC24F180D5E6F6659DC5818809EF3416E_1872611318 = (mPM.checkPermission(permName, pkgName));
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //try {
            //return mPM.checkPermission(permName, pkgName);
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.661 -0400", hash_original_method = "7DE747A31A0FDE2C95A03117CF8EC1E2", hash_generated_method = "CA18E3B46F7FA53DD17362F0FD5B243A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean addPermission(PermissionInfo info) {
        dsTaint.addTaint(info.dsTaint);
        try 
        {
            boolean var16B313AE31B83011C28287E1893A6A9C_1224605387 = (mPM.addPermission(info));
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //return mPM.addPermission(info);
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.661 -0400", hash_original_method = "BE955F868C92CCDF8275E95FFE2C44B3", hash_generated_method = "6F7F3C189BFF8FD9A29284DCA938C666")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean addPermissionAsync(PermissionInfo info) {
        dsTaint.addTaint(info.dsTaint);
        try 
        {
            boolean var3B1BC13408FAB0EED9E6C97798235DF8_1231378593 = (mPM.addPermissionAsync(info));
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //return mPM.addPermissionAsync(info);
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.662 -0400", hash_original_method = "3B9F25E30931EF93125264B719A2E2FF", hash_generated_method = "72D7329A0EA5ACBB5ECC7C9A80ECBDDB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void removePermission(String name) {
        dsTaint.addTaint(name);
        try 
        {
            mPM.removePermission(name);
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } //End block
        // ---------- Original Method ----------
        //try {
            //mPM.removePermission(name);
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.662 -0400", hash_original_method = "7DC6A4F902E735FA721489587F3384CC", hash_generated_method = "BBE87D1C53E71F12CC2BA9900FE9D8A1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int checkSignatures(String pkg1, String pkg2) {
        dsTaint.addTaint(pkg1);
        dsTaint.addTaint(pkg2);
        try 
        {
            int var48FD7299CCE20AFA5ACAC7362163506B_1446045479 = (mPM.checkSignatures(pkg1, pkg2));
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //try {
            //return mPM.checkSignatures(pkg1, pkg2);
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.663 -0400", hash_original_method = "E51AFA66F0FA11E52A6A449B49344AE4", hash_generated_method = "D259493F82507E8CFA4D88B5AE86E1FF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int checkSignatures(int uid1, int uid2) {
        dsTaint.addTaint(uid2);
        dsTaint.addTaint(uid1);
        try 
        {
            int varCB0D2D55990C866D4BAF222264E4D604_1845399799 = (mPM.checkUidSignatures(uid1, uid2));
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //try {
            //return mPM.checkUidSignatures(uid1, uid2);
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.663 -0400", hash_original_method = "A565AD9EB181443BBE8F338808A2E4B9", hash_generated_method = "872AE9E333B10D81CCD96E8B15631776")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String[] getPackagesForUid(int uid) {
        dsTaint.addTaint(uid);
        try 
        {
            String[] varCF05C9980DEDC42FCFDDF150CFBD0760_981591746 = (mPM.getPackagesForUid(uid));
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } //End block
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //try {
            //return mPM.getPackagesForUid(uid);
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.664 -0400", hash_original_method = "107797D329CAA491AA1A678294A11B0E", hash_generated_method = "2574BC894F5188E1B8604E4C9BBB5E8B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String getNameForUid(int uid) {
        dsTaint.addTaint(uid);
        try 
        {
            String varFD00A55A1A19B085C370948CBDD273F5_652050467 = (mPM.getNameForUid(uid));
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //try {
            //return mPM.getNameForUid(uid);
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.665 -0400", hash_original_method = "BCD62F04CBDED38DF225700C99BB4852", hash_generated_method = "F8DE99ABF2024E69E6E860E0A195E5BA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getUidForSharedUser(String sharedUserName) throws NameNotFoundException {
        dsTaint.addTaint(sharedUserName);
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
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.666 -0400", hash_original_method = "2CD6168D318C89447F6184EBDE96189F", hash_generated_method = "CFCCB7480FABA47048E0130CF834885D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings("unchecked")
    @Override
    public List<PackageInfo> getInstalledPackages(int flags) {
        dsTaint.addTaint(flags);
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
                boolean varAF04EF32C9AC89657E6048F98D47E5E7_2052831271 = (!slice.isLastSlice());
            } //End collapsed parenthetic
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } //End block
        return (List<PackageInfo>)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.668 -0400", hash_original_method = "195CA5538214D0B5EDE14A1F47A96E96", hash_generated_method = "B74358D0825FACDE6C2FA54B45D71E5B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings("unchecked")
    @Override
    public List<ApplicationInfo> getInstalledApplications(int flags) {
        dsTaint.addTaint(flags);
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
                boolean varAF04EF32C9AC89657E6048F98D47E5E7_1302866843 = (!slice.isLastSlice());
            } //End collapsed parenthetic
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } //End block
        return (List<ApplicationInfo>)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.669 -0400", hash_original_method = "0CD7CD39AE65A355BC33F2BA54C4DC37", hash_generated_method = "6354D668806C1B5DCC8B2943C6F09934")
    @DSModeled(DSC.SPEC)
    @Override
    public ResolveInfo resolveActivity(Intent intent, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(intent.dsTaint);
        try 
        {
            ResolveInfo var8AA80A69F8DC344D4CC01A02327F3922_1315136802 = (mPM.resolveIntent(
                intent,
                intent.resolveTypeIfNeeded(mContext.getContentResolver()),
                flags));
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } //End block
        return (ResolveInfo)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.671 -0400", hash_original_method = "613ED89A001624360A0EB6B3BD081707", hash_generated_method = "564CB22A30E4068DB94237863E685CB1")
    @DSModeled(DSC.SPEC)
    @Override
    public List<ResolveInfo> queryIntentActivities(Intent intent,
                                                   int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(intent.dsTaint);
        try 
        {
            List<ResolveInfo> var91FEE2F3C3F73E0273D05CB18EDA919B_1964793302 = (mPM.queryIntentActivities(
                intent,
                intent.resolveTypeIfNeeded(mContext.getContentResolver()),
                flags));
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } //End block
        return (List<ResolveInfo>)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.672 -0400", hash_original_method = "9B955FD88A95F7C1CCD0CD1DFE6EC270", hash_generated_method = "0B555A28060A1173A559E5E64469F3C9")
    @DSModeled(DSC.SPEC)
    @Override
    public List<ResolveInfo> queryIntentActivityOptions(
        ComponentName caller, Intent[] specifics, Intent intent,
        int flags) {
        dsTaint.addTaint(caller.dsTaint);
        dsTaint.addTaint(flags);
        dsTaint.addTaint(specifics[0].dsTaint);
        dsTaint.addTaint(intent.dsTaint);
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
            List<ResolveInfo> var6BED77E571B62210459A007AE7E06A01_1662381700 = (mPM.queryIntentActivityOptions(caller, specifics,
                                                  specificTypes, intent, intent.resolveTypeIfNeeded(resolver),
                                                  flags));
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } //End block
        return (List<ResolveInfo>)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.673 -0400", hash_original_method = "2B65A8BDA3BE53DC3296D1F5CA76CDFC", hash_generated_method = "131143939DBF4698E9634FAE8BF7F91A")
    @DSModeled(DSC.SPEC)
    @Override
    public List<ResolveInfo> queryBroadcastReceivers(Intent intent, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(intent.dsTaint);
        try 
        {
            List<ResolveInfo> varEB13BBEF79822AFC2D4F79C13ED97733_311804760 = (mPM.queryIntentReceivers(
                intent,
                intent.resolveTypeIfNeeded(mContext.getContentResolver()),
                flags));
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } //End block
        return (List<ResolveInfo>)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.673 -0400", hash_original_method = "D7D4C733DB611C9D18D346868F9BD0BD", hash_generated_method = "C7F10260ABD172435A54F409A283F77D")
    @DSModeled(DSC.SPEC)
    @Override
    public ResolveInfo resolveService(Intent intent, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(intent.dsTaint);
        try 
        {
            ResolveInfo var9496CD364396C73CE3F4E93B8D100463_14051491 = (mPM.resolveService(
                intent,
                intent.resolveTypeIfNeeded(mContext.getContentResolver()),
                flags));
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } //End block
        return (ResolveInfo)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.674 -0400", hash_original_method = "EEB4EB852740846BAD76CCDE5FC0C613", hash_generated_method = "C7461A81BCE1350DF474F919616E29EF")
    @DSModeled(DSC.SPEC)
    @Override
    public List<ResolveInfo> queryIntentServices(Intent intent, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(intent.dsTaint);
        try 
        {
            List<ResolveInfo> var3C85521060A59DF2C1AD2D896CDE4884_2053446849 = (mPM.queryIntentServices(
                intent,
                intent.resolveTypeIfNeeded(mContext.getContentResolver()),
                flags));
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } //End block
        return (List<ResolveInfo>)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.677 -0400", hash_original_method = "3A6513CB26C2E0AF7DACFC2B8A5D560B", hash_generated_method = "FCDAA2F76D8507A6DE2C8A30DC569217")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ProviderInfo resolveContentProvider(String name,
                                               int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(name);
        try 
        {
            ProviderInfo var9EEB697D5CEE48BA79FA6F29904085FB_869335970 = (mPM.resolveContentProvider(name, flags));
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } //End block
        return (ProviderInfo)dsTaint.getTaint();
        // ---------- Original Method ----------
        //try {
            //return mPM.resolveContentProvider(name, flags);
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.678 -0400", hash_original_method = "7B04A4BE8EFECF5209DBE4F77CB67C42", hash_generated_method = "20BEFE0B26FE5187271BFA0538206DC5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public List<ProviderInfo> queryContentProviders(String processName,
                                                    int uid, int flags) {
        dsTaint.addTaint(uid);
        dsTaint.addTaint(flags);
        dsTaint.addTaint(processName);
        try 
        {
            List<ProviderInfo> var0194D60DEFFF78A45A69AB8F9A867821_1773579219 = (mPM.queryContentProviders(processName, uid, flags));
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } //End block
        return (List<ProviderInfo>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //try {
            //return mPM.queryContentProviders(processName, uid, flags);
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.678 -0400", hash_original_method = "3120887453BFC9391A593077A4EB2D8C", hash_generated_method = "CDE19C115AC66DF9362D0AC67A2F83BF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public InstrumentationInfo getInstrumentationInfo(
        ComponentName className, int flags) throws NameNotFoundException {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(className.dsTaint);
        try 
        {
            InstrumentationInfo ii;
            ii = mPM.getInstrumentationInfo(
                className, flags);
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new NameNotFoundException(className.toString());
        return (InstrumentationInfo)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.679 -0400", hash_original_method = "0CE547FAA1F9EB003838A9DE59E3AC72", hash_generated_method = "893AD8D48871E9746C9925701590B286")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public List<InstrumentationInfo> queryInstrumentation(
        String targetPackage, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(targetPackage);
        try 
        {
            List<InstrumentationInfo> var630C42087DE245AE3FD60D69A0301DC2_1164375679 = (mPM.queryInstrumentation(targetPackage, flags));
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Package manager has died", e);
        } //End block
        return (List<InstrumentationInfo>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //try {
            //return mPM.queryInstrumentation(targetPackage, flags);
        //} catch (RemoteException e) {
            //throw new RuntimeException("Package manager has died", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.680 -0400", hash_original_method = "350CC4BDDD2E42419F88F44C033409F6", hash_generated_method = "58EC56EADEF39FAA90AB324376A9FB18")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Drawable getDrawable(String packageName, int resid,
                                          ApplicationInfo appInfo) {
        dsTaint.addTaint(resid);
        dsTaint.addTaint(packageName);
        dsTaint.addTaint(appInfo.dsTaint);
        ResourceName name;
        name = new ResourceName(packageName, resid);
        Drawable dr;
        dr = getCachedIcon(name);
        {
            try 
            {
                appInfo = getApplicationInfo(packageName, 0);
            } //End block
            catch (NameNotFoundException e)
            { }
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
        } //End block
        catch (NameNotFoundException e)
        { }
        catch (Resources.NotFoundException e)
        { }
        catch (RuntimeException e)
        { }
        return (Drawable)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.681 -0400", hash_original_method = "E8823DE045849946097DF943F50B58DB", hash_generated_method = "DF25865E5D2BE5DA2B4468D252FB0EF1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Drawable getActivityIcon(ComponentName activityName) throws NameNotFoundException {
        dsTaint.addTaint(activityName.dsTaint);
        Drawable var9F81FF9FA6F2B0078A0F26916FCE6A32_327519807 = (getActivityInfo(activityName, 0).loadIcon(this));
        return (Drawable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return getActivityInfo(activityName, 0).loadIcon(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.682 -0400", hash_original_method = "EF5F409F30F5D50F1964B6AB6B7F75B7", hash_generated_method = "D75A2A1EB535509E02E5170CACAFC97E")
    @DSModeled(DSC.SPEC)
    @Override
    public Drawable getActivityIcon(Intent intent) throws NameNotFoundException {
        dsTaint.addTaint(intent.dsTaint);
        {
            boolean var2CB4FD776F3AF8424EA4E2E544217AF5_2074362791 = (intent.getComponent() != null);
            {
                Drawable var9D384A643FDB000952FE1311EEE03020_1627130687 = (getActivityIcon(intent.getComponent()));
            } //End block
        } //End collapsed parenthetic
        ResolveInfo info;
        info = resolveActivity(
            intent, PackageManager.MATCH_DEFAULT_ONLY);
        {
            Drawable var35D06333441A21DCDCAA00752CF793E4_383733564 = (info.activityInfo.loadIcon(this));
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new NameNotFoundException(intent.toUri(0));
        return (Drawable)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.682 -0400", hash_original_method = "27F8B828FEA8943560AD77E4760B6964", hash_generated_method = "AD0A08AEB6ADCFC3BEF273A31CC8832A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Drawable getDefaultActivityIcon() {
        Drawable varD24F096047897427E418401E316F6328_177063612 = (Resources.getSystem().getDrawable(
            com.android.internal.R.drawable.sym_def_app_icon));
        return (Drawable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return Resources.getSystem().getDrawable(
            //com.android.internal.R.drawable.sym_def_app_icon);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.684 -0400", hash_original_method = "C2186A062EDEC18E9DD8F87E8E6291D1", hash_generated_method = "F7E9C4561DA6BE65DDEE13C48AE969C1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Drawable getApplicationIcon(ApplicationInfo info) {
        dsTaint.addTaint(info.dsTaint);
        Drawable var540BD38BEDC4FF4F884E452A58B42DD0_2068838605 = (info.loadIcon(this));
        return (Drawable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return info.loadIcon(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.685 -0400", hash_original_method = "49256B647BD52234F52BC973E3B03E0B", hash_generated_method = "827A68773B6B13E83F1D428D7A8B2EAA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Drawable getApplicationIcon(String packageName) throws NameNotFoundException {
        dsTaint.addTaint(packageName);
        Drawable varB8C11C72D904F907973DBA9265B25913_596891683 = (getApplicationIcon(getApplicationInfo(packageName, 0)));
        return (Drawable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return getApplicationIcon(getApplicationInfo(packageName, 0));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.687 -0400", hash_original_method = "12128D2FB1F753A28280A7EF3E62F4B2", hash_generated_method = "706B214DC9F4C3ABF5A9B38D6EDF30E4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Drawable getActivityLogo(ComponentName activityName) throws NameNotFoundException {
        dsTaint.addTaint(activityName.dsTaint);
        Drawable var291C8B4C1B5011DAF57FEFE3BEDCAB61_1443980756 = (getActivityInfo(activityName, 0).loadLogo(this));
        return (Drawable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return getActivityInfo(activityName, 0).loadLogo(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.689 -0400", hash_original_method = "3B1A86BB5E25FB8EFA7A1AD1A88B3B01", hash_generated_method = "7261EB0E56481C6CCBEA4D9C52317A31")
    @DSModeled(DSC.SPEC)
    @Override
    public Drawable getActivityLogo(Intent intent) throws NameNotFoundException {
        dsTaint.addTaint(intent.dsTaint);
        {
            boolean var2CB4FD776F3AF8424EA4E2E544217AF5_223599808 = (intent.getComponent() != null);
            {
                Drawable var11DF4EFAAB5798E6E1085A98E471240A_560128696 = (getActivityLogo(intent.getComponent()));
            } //End block
        } //End collapsed parenthetic
        ResolveInfo info;
        info = resolveActivity(
            intent, PackageManager.MATCH_DEFAULT_ONLY);
        {
            Drawable var2B08E707C33E4468CEF5E77AF029F77B_1814225453 = (info.activityInfo.loadLogo(this));
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new NameNotFoundException(intent.toUri(0));
        return (Drawable)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.689 -0400", hash_original_method = "586E62978169D56092172114763F9AD3", hash_generated_method = "4B905880B8306136D126C2E2A2E42199")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Drawable getApplicationLogo(ApplicationInfo info) {
        dsTaint.addTaint(info.dsTaint);
        Drawable var3E9916C171CB00A56F83AE00E58B987A_1045401054 = (info.loadLogo(this));
        return (Drawable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return info.loadLogo(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.690 -0400", hash_original_method = "6BC85FEDD3936A7851329E2331D0279D", hash_generated_method = "52651A41F0DF2DEDA73DAA72281E31B2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Drawable getApplicationLogo(String packageName) throws NameNotFoundException {
        dsTaint.addTaint(packageName);
        Drawable var11D5C2495BB515B083548952D213070A_935549245 = (getApplicationLogo(getApplicationInfo(packageName, 0)));
        return (Drawable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return getApplicationLogo(getApplicationInfo(packageName, 0));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.691 -0400", hash_original_method = "E07E3E36CD8F79CF4FE12B9F33A40344", hash_generated_method = "82F127F95058A68A17C02FE8A9231BFF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Resources getResourcesForActivity(
        ComponentName activityName) throws NameNotFoundException {
        dsTaint.addTaint(activityName.dsTaint);
        Resources var05637B2AE91CE74FB641C9C5670BF96F_137214054 = (getResourcesForApplication(
            getActivityInfo(activityName, 0).applicationInfo));
        return (Resources)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return getResourcesForApplication(
            //getActivityInfo(activityName, 0).applicationInfo);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.692 -0400", hash_original_method = "AC20F77416CABFA638F647DA9F2F230E", hash_generated_method = "712697BDE47DA8B2D08F1CDFE7E80A43")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Resources getResourcesForApplication(
        ApplicationInfo app) throws NameNotFoundException {
        dsTaint.addTaint(app.dsTaint);
        {
            boolean varF67FB556D575A0DB52E0C311AE1F282F_591406544 = (app.packageName.equals("system"));
            {
                Resources varA6CBE4CA04A121F38D430D5313376A96_775356913 = (mContext.mMainThread.getSystemContext().getResources());
            } //End block
        } //End collapsed parenthetic
        Resources r;
        r = mContext.mMainThread.getTopLevelResources(
            app.uid == Process.myUid() ? app.sourceDir
            : app.publicSourceDir, mContext.mPackageInfo);//DSFIXME:  CODE0008: Nested ternary operator in expression
        if (DroidSafeAndroidRuntime.control) throw new NameNotFoundException("Unable to open " + app.publicSourceDir);
        return (Resources)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.694 -0400", hash_original_method = "ACD444E0FC7FCEAEB5D1FF09DD4A5912", hash_generated_method = "B202877D62D26295EAC853BE0CE49862")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Resources getResourcesForApplication(
        String appPackageName) throws NameNotFoundException {
        dsTaint.addTaint(appPackageName);
        Resources varE161C8ADC8B0F3C8DF61E55A0F30AEF0_1395109567 = (getResourcesForApplication(
            getApplicationInfo(appPackageName, 0)));
        return (Resources)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return getResourcesForApplication(
            //getApplicationInfo(appPackageName, 0));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.695 -0400", hash_original_method = "6B2AA9A609FE89D703EEC81AF1FC0890", hash_generated_method = "82F947CB2A7710D95372CDBAEE4AC0AD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.696 -0400", hash_original_method = "805BC435FDAE098AFC4F53B40E89D7C1", hash_generated_method = "B1BD9BA37D1B40CA31FF21B9599FB08D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Drawable getCachedIcon(ResourceName name) {
        dsTaint.addTaint(name.dsTaint);
        {
            WeakReference<Drawable.ConstantState> wr;
            wr = sIconCache.get(name);
            {
                Drawable.ConstantState state;
                state = wr.get();
                {
                    Drawable var6F18C8FA5FC53332E5DC6787EE02DEEF_1312586505 = (state.newDrawable());
                } //End block
                sIconCache.remove(name);
            } //End block
        } //End block
        return (Drawable)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.696 -0400", hash_original_method = "1ADDA1851B7207BD0D6C119E2C63D6A2", hash_generated_method = "8D72D9B0F51A3A1E8E51D42F10329ED7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void putCachedIcon(ResourceName name, Drawable dr) {
        dsTaint.addTaint(name.dsTaint);
        dsTaint.addTaint(dr.dsTaint);
        {
            sIconCache.put(name, new WeakReference<Drawable.ConstantState>(dr.getConstantState()));
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.697 -0400", hash_original_method = "B66098C8E55783775B73FA7D73879D41", hash_generated_method = "0783E1E86E048FF15D58F909A233C064")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private CharSequence getCachedString(ResourceName name) {
        dsTaint.addTaint(name.dsTaint);
        {
            WeakReference<CharSequence> wr;
            wr = sStringCache.get(name);
            {
                CharSequence cs;
                cs = wr.get();
                sStringCache.remove(name);
            } //End block
        } //End block
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.698 -0400", hash_original_method = "70E4290F1842F0A45B89D50D6CDEDDBB", hash_generated_method = "93C6EAA52FE17CBC72FC78ECF8E6A5ED")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void putCachedString(ResourceName name, CharSequence cs) {
        dsTaint.addTaint(name.dsTaint);
        dsTaint.addTaint(cs);
        {
            sStringCache.put(name, new WeakReference<CharSequence>(cs));
        } //End block
        // ---------- Original Method ----------
        //synchronized (sSync) {
            //sStringCache.put(name, new WeakReference<CharSequence>(cs));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.698 -0400", hash_original_method = "771B010EDE230C24A313E1F6F3869FDB", hash_generated_method = "82E8CE9AC0120DAC0C5C7FD5539E0BCD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public CharSequence getText(String packageName, int resid,
                                ApplicationInfo appInfo) {
        dsTaint.addTaint(resid);
        dsTaint.addTaint(packageName);
        dsTaint.addTaint(appInfo.dsTaint);
        ResourceName name;
        name = new ResourceName(packageName, resid);
        CharSequence text;
        text = getCachedString(name);
        {
            try 
            {
                appInfo = getApplicationInfo(packageName, 0);
            } //End block
            catch (NameNotFoundException e)
            { }
        } //End block
        try 
        {
            Resources r;
            r = getResourcesForApplication(appInfo);
            text = r.getText(resid);
            putCachedString(name, text);
        } //End block
        catch (NameNotFoundException e)
        { }
        catch (RuntimeException e)
        { }
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.699 -0400", hash_original_method = "F130C54905A9CE16326CF20EF6E93255", hash_generated_method = "26A964B9013AD6850C4BBACD5E164BF0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public XmlResourceParser getXml(String packageName, int resid,
                                    ApplicationInfo appInfo) {
        dsTaint.addTaint(resid);
        dsTaint.addTaint(packageName);
        dsTaint.addTaint(appInfo.dsTaint);
        {
            try 
            {
                appInfo = getApplicationInfo(packageName, 0);
            } //End block
            catch (NameNotFoundException e)
            { }
        } //End block
        try 
        {
            Resources r;
            r = getResourcesForApplication(appInfo);
            XmlResourceParser varDFBC73846495B5065A25FFEC3C0FC3BB_1983184191 = (r.getXml(resid));
        } //End block
        catch (RuntimeException e)
        { }
        catch (NameNotFoundException e)
        { }
        return (XmlResourceParser)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.700 -0400", hash_original_method = "4AFDE050276913F392973B277F54706D", hash_generated_method = "2725D9830FC736FCBD6480CCB1326C2E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public CharSequence getApplicationLabel(ApplicationInfo info) {
        dsTaint.addTaint(info.dsTaint);
        CharSequence var30BCCD5E821FA44835199919BC17E76D_40309591 = (info.loadLabel(this));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return info.loadLabel(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.700 -0400", hash_original_method = "99610A6DD5E10C01303307EBA6938AA8", hash_generated_method = "6D74FA84512B5B54DF2FFAFBC971BADD")
    @DSModeled(DSC.SPEC)
    @Override
    public void installPackage(Uri packageURI, IPackageInstallObserver observer, int flags,
                               String installerPackageName) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(packageURI.dsTaint);
        dsTaint.addTaint(installerPackageName);
        dsTaint.addTaint(observer.dsTaint);
        try 
        {
            mPM.installPackage(packageURI, observer, flags, installerPackageName);
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        //try {
            //mPM.installPackage(packageURI, observer, flags, installerPackageName);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.701 -0400", hash_original_method = "769145FCC72852B2314845C8A89A2DAD", hash_generated_method = "BA88BD1E62F7FF92FF32CE6347B64CBC")
    @DSModeled(DSC.SPEC)
    @Override
    public void installPackageWithVerification(Uri packageURI, IPackageInstallObserver observer,
            int flags, String installerPackageName, Uri verificationURI,
            ManifestDigest manifestDigest) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(packageURI.dsTaint);
        dsTaint.addTaint(manifestDigest.dsTaint);
        dsTaint.addTaint(installerPackageName);
        dsTaint.addTaint(observer.dsTaint);
        dsTaint.addTaint(verificationURI.dsTaint);
        try 
        {
            mPM.installPackageWithVerification(packageURI, observer, flags, installerPackageName,
                    verificationURI, manifestDigest);
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        //try {
            //mPM.installPackageWithVerification(packageURI, observer, flags, installerPackageName,
                    //verificationURI, manifestDigest);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.702 -0400", hash_original_method = "E593338881B3E45506EA974F446D2A6B", hash_generated_method = "09D62F36D367B4980D8672F9EC25B226")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void verifyPendingInstall(int id, int response) {
        dsTaint.addTaint(response);
        dsTaint.addTaint(id);
        try 
        {
            mPM.verifyPendingInstall(id, response);
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        //try {
            //mPM.verifyPendingInstall(id, response);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.702 -0400", hash_original_method = "A168A8E169316429D31E261AD639AED4", hash_generated_method = "C6DD2FEB973C5F61A909E0EE78B18703")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setInstallerPackageName(String targetPackage,
            String installerPackageName) {
        dsTaint.addTaint(installerPackageName);
        dsTaint.addTaint(targetPackage);
        try 
        {
            mPM.setInstallerPackageName(targetPackage, installerPackageName);
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        //try {
            //mPM.setInstallerPackageName(targetPackage, installerPackageName);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.703 -0400", hash_original_method = "D8F1CA3B8F90BF876B114DD825F09703", hash_generated_method = "F21156A83DA08932FA2C0ACE19C3B82B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void movePackage(String packageName, IPackageMoveObserver observer, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(packageName);
        dsTaint.addTaint(observer.dsTaint);
        try 
        {
            mPM.movePackage(packageName, observer, flags);
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        //try {
            //mPM.movePackage(packageName, observer, flags);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.703 -0400", hash_original_method = "13C0F9FC5FF4142BD538C8A3AADB3621", hash_generated_method = "B678A4B595FADD3CF0B8EA0F2EC2ECDF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String getInstallerPackageName(String packageName) {
        dsTaint.addTaint(packageName);
        try 
        {
            String var8C3F0FB255EB61D09B8F74D0991B12DD_1430941665 = (mPM.getInstallerPackageName(packageName));
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //try {
            //return mPM.getInstallerPackageName(packageName);
        //} catch (RemoteException e) {
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.704 -0400", hash_original_method = "6B4A8C0BA02325B97A4B696E509E27F1", hash_generated_method = "F63EA1930ECF9B2741E450B1FCE90E8A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void deletePackage(String packageName, IPackageDeleteObserver observer, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(packageName);
        dsTaint.addTaint(observer.dsTaint);
        try 
        {
            mPM.deletePackage(packageName, observer, flags);
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        //try {
            //mPM.deletePackage(packageName, observer, flags);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.704 -0400", hash_original_method = "41D4F7CDEA8F3FA97A215E5DB5AE3B7F", hash_generated_method = "07470A96684C535E84DCA994FA0BAA8A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void clearApplicationUserData(String packageName,
                                         IPackageDataObserver observer) {
        dsTaint.addTaint(packageName);
        dsTaint.addTaint(observer.dsTaint);
        try 
        {
            mPM.clearApplicationUserData(packageName, observer);
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        //try {
            //mPM.clearApplicationUserData(packageName, observer);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.705 -0400", hash_original_method = "9E003FA712762A764BBDA3187B8255C1", hash_generated_method = "16D00ABA292C5CB0C73630ED8C773538")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void deleteApplicationCacheFiles(String packageName,
                                            IPackageDataObserver observer) {
        dsTaint.addTaint(packageName);
        dsTaint.addTaint(observer.dsTaint);
        try 
        {
            mPM.deleteApplicationCacheFiles(packageName, observer);
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        //try {
            //mPM.deleteApplicationCacheFiles(packageName, observer);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.705 -0400", hash_original_method = "E7A7F0006F405C835ECAAE7B969343FA", hash_generated_method = "8218C8A32C83654920CE9B1BAD9774C7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void freeStorageAndNotify(long idealStorageSize, IPackageDataObserver observer) {
        dsTaint.addTaint(idealStorageSize);
        dsTaint.addTaint(observer.dsTaint);
        try 
        {
            mPM.freeStorageAndNotify(idealStorageSize, observer);
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        //try {
            //mPM.freeStorageAndNotify(idealStorageSize, observer);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.714 -0400", hash_original_method = "8531AD2E443F843CDBBD03DDCC5F2882", hash_generated_method = "9DFEE2645AC2599FA35D337072BA4410")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void freeStorage(long freeStorageSize, IntentSender pi) {
        dsTaint.addTaint(freeStorageSize);
        dsTaint.addTaint(pi.dsTaint);
        try 
        {
            mPM.freeStorage(freeStorageSize, pi);
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        //try {
            //mPM.freeStorage(freeStorageSize, pi);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.717 -0400", hash_original_method = "00314015F36B785D35449EC7724DA4A0", hash_generated_method = "52674286409FB640D45023597A7DAE49")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void getPackageSizeInfo(String packageName,
                                   IPackageStatsObserver observer) {
        dsTaint.addTaint(packageName);
        dsTaint.addTaint(observer.dsTaint);
        try 
        {
            mPM.getPackageSizeInfo(packageName, observer);
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        //try {
            //mPM.getPackageSizeInfo(packageName, observer);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.721 -0400", hash_original_method = "A9291C102B2FAAEF4C90A57E1B6DE098", hash_generated_method = "C4418D8E9CF645E98C92B91750BA082F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void addPackageToPreferred(String packageName) {
        dsTaint.addTaint(packageName);
        try 
        {
            mPM.addPackageToPreferred(packageName);
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        //try {
            //mPM.addPackageToPreferred(packageName);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.722 -0400", hash_original_method = "F1B5214867A85B15353BE55995A19BB6", hash_generated_method = "5EA3BBCDD5FB6D8FC5CA895B07B40C09")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void removePackageFromPreferred(String packageName) {
        dsTaint.addTaint(packageName);
        try 
        {
            mPM.removePackageFromPreferred(packageName);
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        //try {
            //mPM.removePackageFromPreferred(packageName);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.723 -0400", hash_original_method = "4A08CFB9ACE88EAEABD2D18F083F329D", hash_generated_method = "A6C072F452B405961191FA65334B0987")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public List<PackageInfo> getPreferredPackages(int flags) {
        dsTaint.addTaint(flags);
        try 
        {
            List<PackageInfo> varD12A8C02EC95D8F367F30F0379EFD039_707753627 = (mPM.getPreferredPackages(flags));
        } //End block
        catch (RemoteException e)
        { }
        List<PackageInfo> var216BD42F65CB4A69CBD4B231DF245CA0_306269138 = (new ArrayList<PackageInfo>());
        return (List<PackageInfo>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //try {
            //return mPM.getPreferredPackages(flags);
        //} catch (RemoteException e) {
        //}
        //return new ArrayList<PackageInfo>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.724 -0400", hash_original_method = "E5D2F7A75D600839A582F36FB9BA5425", hash_generated_method = "9D6A8A43076B6B22ADE926AB7322873B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void addPreferredActivity(IntentFilter filter,
                                     int match, ComponentName[] set, ComponentName activity) {
        dsTaint.addTaint(set[0].dsTaint);
        dsTaint.addTaint(match);
        dsTaint.addTaint(activity.dsTaint);
        dsTaint.addTaint(filter.dsTaint);
        try 
        {
            mPM.addPreferredActivity(filter, match, set, activity);
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        //try {
            //mPM.addPreferredActivity(filter, match, set, activity);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.726 -0400", hash_original_method = "2885B1E40721D55CC13EAA30EB1BAE52", hash_generated_method = "9EC0DE3FA97144515FEF1F671737F73A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void replacePreferredActivity(IntentFilter filter,
                                         int match, ComponentName[] set, ComponentName activity) {
        dsTaint.addTaint(set[0].dsTaint);
        dsTaint.addTaint(match);
        dsTaint.addTaint(activity.dsTaint);
        dsTaint.addTaint(filter.dsTaint);
        try 
        {
            mPM.replacePreferredActivity(filter, match, set, activity);
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        //try {
            //mPM.replacePreferredActivity(filter, match, set, activity);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.727 -0400", hash_original_method = "818084167B76F544DAE31D40EA850683", hash_generated_method = "424B909109A449CAC4036FED17818967")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void clearPackagePreferredActivities(String packageName) {
        dsTaint.addTaint(packageName);
        try 
        {
            mPM.clearPackagePreferredActivities(packageName);
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        //try {
            //mPM.clearPackagePreferredActivities(packageName);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.728 -0400", hash_original_method = "9A1408660FD10D92BECBE2BE18AA9510", hash_generated_method = "C64C912F8DBB1F374AB24746DC2511C9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getPreferredActivities(List<IntentFilter> outFilters,
                                      List<ComponentName> outActivities, String packageName) {
        dsTaint.addTaint(outActivities.dsTaint);
        dsTaint.addTaint(outFilters.dsTaint);
        dsTaint.addTaint(packageName);
        try 
        {
            int varAAA2984E5864A69FBA0F19FD84D394A5_1252262511 = (mPM.getPreferredActivities(outFilters, outActivities, packageName));
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //try {
            //return mPM.getPreferredActivities(outFilters, outActivities, packageName);
        //} catch (RemoteException e) {
        //}
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.728 -0400", hash_original_method = "324289EEBFA692363CEA9B4C548C82A7", hash_generated_method = "4655B3380A654EC7C8FF36627D4C39C6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setComponentEnabledSetting(ComponentName componentName,
                                           int newState, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(componentName.dsTaint);
        dsTaint.addTaint(newState);
        try 
        {
            mPM.setComponentEnabledSetting(componentName, newState, flags);
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        //try {
            //mPM.setComponentEnabledSetting(componentName, newState, flags);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.729 -0400", hash_original_method = "214E6E4C94F679DC0FE6A4159B821EAF", hash_generated_method = "EE19BB4BDCA45D74EE442361D97A750E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getComponentEnabledSetting(ComponentName componentName) {
        dsTaint.addTaint(componentName.dsTaint);
        try 
        {
            int var1528F93F8B5599DBD2DEEBFDF40122F0_1335490818 = (mPM.getComponentEnabledSetting(componentName));
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //try {
            //return mPM.getComponentEnabledSetting(componentName);
        //} catch (RemoteException e) {
        //}
        //return PackageManager.COMPONENT_ENABLED_STATE_DEFAULT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.729 -0400", hash_original_method = "893989AE0F295A10184FE7AD874B7991", hash_generated_method = "C7469F3E13222ADF45B33F1DB5A78EEF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setApplicationEnabledSetting(String packageName,
                                             int newState, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(packageName);
        dsTaint.addTaint(newState);
        try 
        {
            mPM.setApplicationEnabledSetting(packageName, newState, flags);
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        //try {
            //mPM.setApplicationEnabledSetting(packageName, newState, flags);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.730 -0400", hash_original_method = "786754E395F784476E8D899ABD01121D", hash_generated_method = "863EA100EE6E0603E7519FD1B763C945")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getApplicationEnabledSetting(String packageName) {
        dsTaint.addTaint(packageName);
        try 
        {
            int varF2CA84C656A1ECB5C0715BD15E6F333E_759881799 = (mPM.getApplicationEnabledSetting(packageName));
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //try {
            //return mPM.getApplicationEnabledSetting(packageName);
        //} catch (RemoteException e) {
        //}
        //return PackageManager.COMPONENT_ENABLED_STATE_DEFAULT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.730 -0400", hash_original_method = "26D19368C79A5889D2D25A72A45789A8", hash_generated_method = "BAF93E78E361A7343023813191841130")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public UserInfo createUser(String name, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(name);
        try 
        {
            UserInfo varE846571E3851CEAB3FF4623705D35EB4_1508521149 = (mPM.createUser(name, flags));
        } //End block
        catch (RemoteException e)
        { }
        return (UserInfo)dsTaint.getTaint();
        // ---------- Original Method ----------
        //try {
            //return mPM.createUser(name, flags);
        //} catch (RemoteException e) {
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.731 -0400", hash_original_method = "D3989192690585F23E6C25734E0C3BDB", hash_generated_method = "5460D052F5ECD4FB90ED48828344830C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public List<UserInfo> getUsers() {
        ArrayList<UserInfo> users;
        users = new ArrayList<UserInfo>();
        UserInfo primary;
        primary = new UserInfo(0, "Root!",
                UserInfo.FLAG_ADMIN | UserInfo.FLAG_PRIMARY);
        users.add(primary);
        return (List<UserInfo>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //ArrayList<UserInfo> users = new ArrayList<UserInfo>();
        //UserInfo primary = new UserInfo(0, "Root!",
                //UserInfo.FLAG_ADMIN | UserInfo.FLAG_PRIMARY);
        //users.add(primary);
        //return users;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.732 -0400", hash_original_method = "7D391C716B6EBFD3B4233647A1DCBC34", hash_generated_method = "4E959E2F38C6E089B8E91D3ECB18217D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean removeUser(int id) {
        dsTaint.addTaint(id);
        try 
        {
            boolean varF0857FEEEFECDA71C81CF89A6CEBBA1A_489249763 = (mPM.removeUser(id));
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //return mPM.removeUser(id);
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.732 -0400", hash_original_method = "C52981B6B26B608864F1952FFD2E785F", hash_generated_method = "3207FEB9C81BFC163812A4782D5F1F5D")
    @DSModeled(DSC.SAFE)
    @Override
    public void updateUserName(int id, String name) {
        dsTaint.addTaint(id);
        dsTaint.addTaint(name);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.732 -0400", hash_original_method = "B193A8F9463928060D13777D952477CD", hash_generated_method = "D142CD8D05EADD20710E75B06B6BE975")
    @DSModeled(DSC.SAFE)
    @Override
    public void updateUserFlags(int id, int flags) {
        dsTaint.addTaint(id);
        dsTaint.addTaint(flags);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.733 -0400", hash_original_method = "05FAEEF75E7B74D35A0F0687A4ACD32C", hash_generated_method = "30BE9F62437F716D41103DE62C04A195")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public VerifierDeviceIdentity getVerifierDeviceIdentity() {
        try 
        {
            VerifierDeviceIdentity varC8EBF0CA6CEF3A315A08390D61B13062_2136702663 = (mPM.getVerifierDeviceIdentity());
        } //End block
        catch (RemoteException e)
        { }
        return (VerifierDeviceIdentity)dsTaint.getTaint();
        // ---------- Original Method ----------
        //try {
            //return mPM.getVerifierDeviceIdentity();
        //} catch (RemoteException e) {
        //}
        //return null;
    }

    
    private static final class ResourceName {
        String packageName;
        int iconId;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.734 -0400", hash_original_method = "00C0083FA3192C6FB2E9C58DC21ABF99", hash_generated_method = "2354EEC5CC1A3DAB28925D44EDC7DDBF")
        @DSModeled(DSC.SAFE)
         ResourceName(String _packageName, int _iconId) {
            dsTaint.addTaint(_iconId);
            dsTaint.addTaint(_packageName);
            // ---------- Original Method ----------
            //packageName = _packageName;
            //iconId = _iconId;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.734 -0400", hash_original_method = "1D7CABC5D0E2E4029539D2105E7113C1", hash_generated_method = "5A16EE2BC636F7276118EFDE37C53C8D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         ResourceName(ApplicationInfo aInfo, int _iconId) {
            this(aInfo.packageName, _iconId);
            dsTaint.addTaint(_iconId);
            dsTaint.addTaint(aInfo.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.734 -0400", hash_original_method = "316DD832F87E78ED23C1ED370845ED19", hash_generated_method = "38CC37F5757404A4EA60B3B0F93EF5E2")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         ResourceName(ComponentInfo cInfo, int _iconId) {
            this(cInfo.applicationInfo.packageName, _iconId);
            dsTaint.addTaint(cInfo.dsTaint);
            dsTaint.addTaint(_iconId);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.735 -0400", hash_original_method = "B7E8883725512A2439D57072801DA2BC", hash_generated_method = "D340C0F1A5BFBF4E24A5DFFED66DFB98")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         ResourceName(ResolveInfo rInfo, int _iconId) {
            this(rInfo.activityInfo.applicationInfo.packageName, _iconId);
            dsTaint.addTaint(_iconId);
            dsTaint.addTaint(rInfo.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.736 -0400", hash_original_method = "77EA94B0E7A0581CD73B79023B92E268", hash_generated_method = "A7BB120C501A84FB43A3A336A87E97F0")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean equals(Object o) {
            dsTaint.addTaint(o.dsTaint);
            {
                boolean var1DE06DCDBE8CB2577D8B96631D951907_1504615035 = (o == null || getClass() != o.getClass());
            } //End collapsed parenthetic
            ResourceName that;
            that = (ResourceName) o;
            boolean var2CF4425DEC96D908C0E598EDFC75DDA1_328168603 = (!(packageName != null ?
                     !packageName.equals(that.packageName) : that.packageName != null)); //DSFIXME:  CODE0008: Nested ternary operator in expression
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //if (this == o) return true;
            //if (o == null || getClass() != o.getClass()) return false;
            //ResourceName that = (ResourceName) o;
            //if (iconId != that.iconId) return false;
            //return !(packageName != null ?
                     //!packageName.equals(that.packageName) : that.packageName != null);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.745 -0400", hash_original_method = "FE96AD3461E654FCE4E8B88F254AC3EE", hash_generated_method = "AB280ABFC47E9685186FCE2B6E4AA34A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int hashCode() {
            int result;
            result = packageName.hashCode();
            result = 31 * result + iconId;
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //int result;
            //result = packageName.hashCode();
            //result = 31 * result + iconId;
            //return result;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.747 -0400", hash_original_method = "19C1C9668D8A7EEF540F3D9429936D14", hash_generated_method = "8E42A249D113ADF3D660901C0B99FF57")
        @DSModeled(DSC.SAFE)
        @Override
        public String toString() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return "{ResourceName " + packageName + " / " + iconId + "}";
        }

        
    }


    
    private static final String TAG = "ApplicationPackageManager";
    private final static boolean DEBUG = false;
    private final static boolean DEBUG_ICONS = false;
    private static final Object sSync = new Object();
    private static HashMap<ResourceName, WeakReference<Drawable.ConstantState>> sIconCache
            = new HashMap<ResourceName, WeakReference<Drawable.ConstantState>>();
    private static HashMap<ResourceName, WeakReference<CharSequence>> sStringCache
            = new HashMap<ResourceName, WeakReference<CharSequence>>();
}

