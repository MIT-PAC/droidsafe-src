package android.app;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

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
import android.content.pm.ManifestDigest;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ParceledListSlice;
import android.content.pm.PermissionGroupInfo;
import android.content.pm.PermissionInfo;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.pm.UserInfo;
import android.content.pm.VerifierDeviceIdentity;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Process;
import android.os.RemoteException;

final class ApplicationPackageManager extends PackageManager {

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.953 -0500", hash_original_method = "CAEBB17CBA604CB35D365427B4123BDD", hash_generated_method = "9AE8A061D889EA13448450E238E2CB9A")
    
static void configurationChanged() {
        synchronized (sSync) {
            sIconCache.clear();
            sStringCache.clear();
        }
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.964 -0500", hash_original_method = "496188F41701FF8F991B0EDFD7F978B1", hash_generated_method = "84DD1948CD7072BC97B2A77154476D74")
    
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
                                //Log.i(TAG, "Removing cached drawable for " + nm);
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
                                //Log.i(TAG, "Removing cached string for " + nm);
                                it.remove();
                                needCleanup = true;
                            }
                        }
                    }
                }
            }
            if (needCleanup || hasPkgInfo) {
                if (immediateGc) {
                    // Schedule an immediate gc.
                    Runtime.getRuntime().gc();
                } else {
                    ActivityThread.currentActivityThread().scheduleGcIdler();
                }
            }
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.808 -0500", hash_original_field = "1D7FAEA291A70FE1AF7BAA0477BA92E2", hash_generated_field = "9103478CE6502665DE73DD4F276104D2")

    private static final String TAG = "ApplicationPackageManager";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.810 -0500", hash_original_field = "81DD852ECBE07BA98A61C8F3D0C85F01", hash_generated_field = "7841AA055B417A7E8C3D727A4ADDD91D")

    private final static boolean DEBUG = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.813 -0500", hash_original_field = "CBFE56CF1932D94491044C5C2A581AB2", hash_generated_field = "D9A207E7F6832116E237531F8566E278")

    private final static boolean DEBUG_ICONS = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:23.078 -0500", hash_original_field = "C9A89FF9952633C3C99E6CECFFFB823C", hash_generated_field = "589A8BDF0C7416090F474EA4E832C9BC")

    private static final Object sSync = new Object();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:23.080 -0500", hash_original_field = "2C092D064C487286968C29223F0F5DE7", hash_generated_field = "4B02A68E27DCF1DC814B05F533A46F39")

    private static HashMap<ResourceName, WeakReference<Drawable.ConstantState>> sIconCache
            = new HashMap<ResourceName, WeakReference<Drawable.ConstantState>>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:23.083 -0500", hash_original_field = "C36A990C5ABDB58B72280A6825407EBE", hash_generated_field = "F43C1D13F1C693E3CC3452E528CF10D8")

    private static HashMap<ResourceName, WeakReference<CharSequence>> sStringCache
            = new HashMap<ResourceName, WeakReference<CharSequence>>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.949 -0500", hash_original_field = "BB74ADCE9FCE390733990F175981A8B2", hash_generated_field = "BB74ADCE9FCE390733990F175981A8B2")

    int mCachedSafeMode = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:23.073 -0500", hash_original_field = "C67ABEFF4281FAC71DDED1D793D767D7", hash_generated_field = "9848C26EA3B1FE04FDB0411428C18F0B")

    private  ContextImpl mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:23.076 -0500", hash_original_field = "4239121FA32DDE5798881A4F98EFD0C1", hash_generated_field = "7F4B9DC825AA12542DFD4F441E873557")

    private  IPackageManager mPM;

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.956 -0500", hash_original_method = "12FC21630330363415BEFB2BB747FDD4", hash_generated_method = "12FC21630330363415BEFB2BB747FDD4")
    
ApplicationPackageManager(ContextImpl context,
                              IPackageManager pm) {
        mContext = context;
        mPM = pm;
    }

    @DSSource({DSSourceKind.SYSTEM_SETTINGS})
    @DSSpec(DSCat.IPC)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.815 -0500", hash_original_method = "B0DADC2DBFEC092F753C36E8DEB385A1", hash_generated_method = "429D1BC09D6C96E00B2D6C8FF80CBED6")
    
@Override
    public PackageInfo getPackageInfo(String packageName, int flags)
            throws NameNotFoundException {
        try {
            PackageInfo pi = mPM.getPackageInfo(packageName, flags);
            if (pi != null) {
                return pi;
            }
        } catch (RemoteException e) {
            throw new RuntimeException("Package manager has died", e);
        }

        throw new NameNotFoundException(packageName);
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.817 -0500", hash_original_method = "C5CDEAB4FF073C2ACB7E7915B56F1D0F", hash_generated_method = "643BD320ED59BB7E861718CC1C1B4B34")
    
@Override
    public String[] currentToCanonicalPackageNames(String[] names) {
        try {
            return mPM.currentToCanonicalPackageNames(names);
        } catch (RemoteException e) {
            throw new RuntimeException("Package manager has died", e);
        }
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.820 -0500", hash_original_method = "9BD980F14E9EC05077595EA826722236", hash_generated_method = "40C1E859834C69340CFEC40EFD3EFB3C")
    
@Override
    public String[] canonicalToCurrentPackageNames(String[] names) {
        try {
            return mPM.canonicalToCurrentPackageNames(names);
        } catch (RemoteException e) {
            throw new RuntimeException("Package manager has died", e);
        }
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.823 -0500", hash_original_method = "A679E3857CF73FF4B9C2EA4F09C7DBB7", hash_generated_method = "B01BB6B6631EE6A1D85C88CFEE32CDAA")
    
@Override
    public Intent getLaunchIntentForPackage(String packageName) {
        // First see if the package has an INFO activity; the existence of
        // such an activity is implied to be the desired front-door for the
        // overall package (such as if it has multiple launcher entries).
        Intent intentToResolve = new Intent(Intent.ACTION_MAIN);
        intentToResolve.addCategory(Intent.CATEGORY_INFO);
        intentToResolve.setPackage(packageName);
        List<ResolveInfo> ris = queryIntentActivities(intentToResolve, 0);

        // Otherwise, try to find a main launcher activity.
        if (ris == null || ris.size() <= 0) {
            // reuse the intent instance
            intentToResolve.removeCategory(Intent.CATEGORY_INFO);
            intentToResolve.addCategory(Intent.CATEGORY_LAUNCHER);
            intentToResolve.setPackage(packageName);
            ris = queryIntentActivities(intentToResolve, 0);
        }
        if (ris == null || ris.size() <= 0) {
            return null;
        }
        Intent intent = new Intent(intentToResolve);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setClassName(ris.get(0).activityInfo.packageName,
                ris.get(0).activityInfo.name);
        return intent;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.826 -0500", hash_original_method = "65CBA80193594BC7AC8CBF648823BDBA", hash_generated_method = "0F272E292E7C40B5A0468005B01B784E")
    
@Override
    public int[] getPackageGids(String packageName)
            throws NameNotFoundException {
        try {
            int[] gids = mPM.getPackageGids(packageName);
            if (gids == null || gids.length > 0) {
                return gids;
            }
        } catch (RemoteException e) {
            throw new RuntimeException("Package manager has died", e);
        }

        throw new NameNotFoundException(packageName);
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.829 -0500", hash_original_method = "16E2B9223A8B92626D3604D0E58E2278", hash_generated_method = "19B3177B3FEDF060F33238286D3488A9")
    
@Override
    public PermissionInfo getPermissionInfo(String name, int flags)
            throws NameNotFoundException {
        try {
            PermissionInfo pi = mPM.getPermissionInfo(name, flags);
            if (pi != null) {
                return pi;
            }
        } catch (RemoteException e) {
            throw new RuntimeException("Package manager has died", e);
        }

        throw new NameNotFoundException(name);
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.831 -0500", hash_original_method = "2283AA5BDEF3F8B3341260BB74FBE8C3", hash_generated_method = "2F7B44F8C6375B15106F3E435BAD9929")
    
@Override
    public List<PermissionInfo> queryPermissionsByGroup(String group, int flags)
            throws NameNotFoundException {
        try {
            List<PermissionInfo> pi = mPM.queryPermissionsByGroup(group, flags);
            if (pi != null) {
                return pi;
            }
        } catch (RemoteException e) {
            throw new RuntimeException("Package manager has died", e);
        }

        throw new NameNotFoundException(group);
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.833 -0500", hash_original_method = "4E576FD7FE2DDB9674E042581657631F", hash_generated_method = "6810EE6C242562FF0EE5C82467A53636")
    
@Override
    public PermissionGroupInfo getPermissionGroupInfo(String name,
                                                      int flags) throws NameNotFoundException {
        try {
            PermissionGroupInfo pgi = mPM.getPermissionGroupInfo(name, flags);
            if (pgi != null) {
                return pgi;
            }
        } catch (RemoteException e) {
            throw new RuntimeException("Package manager has died", e);
        }

        throw new NameNotFoundException(name);
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.836 -0500", hash_original_method = "DD7F1EBA9089D82A0EEA68FDD3DACC66", hash_generated_method = "BD8880EAC086FCED902004DF9A0A2E50")
    
@Override
    public List<PermissionGroupInfo> getAllPermissionGroups(int flags) {
        try {
            return mPM.getAllPermissionGroups(flags);
        } catch (RemoteException e) {
            throw new RuntimeException("Package manager has died", e);
        }
    }

    @DSSpec(DSCat.IPC)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.838 -0500", hash_original_method = "8999420BFE5728B346477621EA154ABF", hash_generated_method = "28CDA3F8FDA37851E62A8AF5FDB0583F")
    
@Override
    public ApplicationInfo getApplicationInfo(String packageName, int flags)
            throws NameNotFoundException {
        try {
            ApplicationInfo ai = mPM.getApplicationInfo(packageName, flags);
            if (ai != null) {
                return ai;
            }
        } catch (RemoteException e) {
            throw new RuntimeException("Package manager has died", e);
        }

        throw new NameNotFoundException(packageName);
    }

    @DSSpec(DSCat.IPC)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.841 -0500", hash_original_method = "9B4FC7EA40C0BB7AEEEEEF1D86D28DE8", hash_generated_method = "EF6DFEB0D241F5E7703A22910B5FF935")
    
@Override
    public ActivityInfo getActivityInfo(ComponentName className, int flags)
            throws NameNotFoundException {
        try {
            ActivityInfo ai = mPM.getActivityInfo(className, flags);
            if (ai != null) {
                return ai;
            }
        } catch (RemoteException e) {
            throw new RuntimeException("Package manager has died", e);
        }

        throw new NameNotFoundException(className.toString());
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.843 -0500", hash_original_method = "399255B19735D8EC733B05B14D3B4711", hash_generated_method = "275492280765AF2B23525A74277A1961")
    
@Override
    public ActivityInfo getReceiverInfo(ComponentName className, int flags)
            throws NameNotFoundException {
        try {
            ActivityInfo ai = mPM.getReceiverInfo(className, flags);
            if (ai != null) {
                return ai;
            }
        } catch (RemoteException e) {
            throw new RuntimeException("Package manager has died", e);
        }

        throw new NameNotFoundException(className.toString());
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.845 -0500", hash_original_method = "50C1BC4F3995D229FF03E27E05E5BE36", hash_generated_method = "4C84035F3B9568676F717AD932363DE2")
    
@Override
    public ServiceInfo getServiceInfo(ComponentName className, int flags)
            throws NameNotFoundException {
        try {
            ServiceInfo si = mPM.getServiceInfo(className, flags);
            if (si != null) {
                return si;
            }
        } catch (RemoteException e) {
            throw new RuntimeException("Package manager has died", e);
        }

        throw new NameNotFoundException(className.toString());
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.848 -0500", hash_original_method = "895E4F29ECA72E6836B6F503A466760A", hash_generated_method = "E7EA74AF4732E6CD387928F614BB196B")
    
@Override
    public ProviderInfo getProviderInfo(ComponentName className, int flags)
            throws NameNotFoundException {
        try {
            ProviderInfo pi = mPM.getProviderInfo(className, flags);
            if (pi != null) {
                return pi;
            }
        } catch (RemoteException e) {
            throw new RuntimeException("Package manager has died", e);
        }

        throw new NameNotFoundException(className.toString());
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.850 -0500", hash_original_method = "E90BE84736723B0914BD9D43484D5AAD", hash_generated_method = "6A022573E5DB8D8134A69788CAB965AA")
    
@Override
    public String[] getSystemSharedLibraryNames() {
        try {
            return mPM.getSystemSharedLibraryNames();
        } catch (RemoteException e) {
            throw new RuntimeException("Package manager has died", e);
        }
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.853 -0500", hash_original_method = "887B55B734ED0895C5FA7D7CF721CE58", hash_generated_method = "068E0D66816DC3F0E6A34FFCBEE2ADE1")
    
@Override
    public FeatureInfo[] getSystemAvailableFeatures() {
        try {
            return mPM.getSystemAvailableFeatures();
        } catch (RemoteException e) {
            throw new RuntimeException("Package manager has died", e);
        }
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.855 -0500", hash_original_method = "8E2B8D0B6C29BED8B3E866F74247B636", hash_generated_method = "CC33BF759FE731ABB18CEC609CA75C91")
    
@Override
    public boolean hasSystemFeature(String name) {
        try {
            return mPM.hasSystemFeature(name);
        } catch (RemoteException e) {
            throw new RuntimeException("Package manager has died", e);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.857 -0500", hash_original_method = "D191D3716589DABF1290937DD7F4276D", hash_generated_method = "1AA183D7E4E118B87C02046D004A6204")
    
@Override
    public int checkPermission(String permName, String pkgName) {
        try {
            return mPM.checkPermission(permName, pkgName);
        } catch (RemoteException e) {
            throw new RuntimeException("Package manager has died", e);
        }
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.859 -0500", hash_original_method = "7DE747A31A0FDE2C95A03117CF8EC1E2", hash_generated_method = "53CF0ECC0A5A4312544A6B02F4DDAD73")
    
@Override
    public boolean addPermission(PermissionInfo info) {
        try {
            return mPM.addPermission(info);
        } catch (RemoteException e) {
            throw new RuntimeException("Package manager has died", e);
        }
    }

    @DSSink({DSSinkKind.SYNCHRONIZATION_DATA})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.861 -0500", hash_original_method = "BE955F868C92CCDF8275E95FFE2C44B3", hash_generated_method = "63E0759278BCA2935C34D2B0DB2DBB1F")
    
@Override
    public boolean addPermissionAsync(PermissionInfo info) {
        try {
            return mPM.addPermissionAsync(info);
        } catch (RemoteException e) {
            throw new RuntimeException("Package manager has died", e);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.863 -0500", hash_original_method = "3B9F25E30931EF93125264B719A2E2FF", hash_generated_method = "001D052D91910283328D6A4A9DB969A4")
    
@Override
    public void removePermission(String name) {
        try {
            mPM.removePermission(name);
        } catch (RemoteException e) {
            throw new RuntimeException("Package manager has died", e);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.866 -0500", hash_original_method = "7DC6A4F902E735FA721489587F3384CC", hash_generated_method = "F1C099445700977116AD0D3C098917C9")
    
@Override
    public int checkSignatures(String pkg1, String pkg2) {
        try {
            return mPM.checkSignatures(pkg1, pkg2);
        } catch (RemoteException e) {
            throw new RuntimeException("Package manager has died", e);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.868 -0500", hash_original_method = "E51AFA66F0FA11E52A6A449B49344AE4", hash_generated_method = "75BF2F522BF3F9D2B8399673E18708D1")
    
@Override
    public int checkSignatures(int uid1, int uid2) {
        try {
            return mPM.checkUidSignatures(uid1, uid2);
        } catch (RemoteException e) {
            throw new RuntimeException("Package manager has died", e);
        }
    }

    @DSSpec(DSCat.IPC)
    @DSSource({DSSourceKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.871 -0500", hash_original_method = "A565AD9EB181443BBE8F338808A2E4B9", hash_generated_method = "8C14E4C1D9047E2AC83580FBC7C1BE33")
    
@Override
    public String[] getPackagesForUid(int uid) {
        try {
            return mPM.getPackagesForUid(uid);
        } catch (RemoteException e) {
            throw new RuntimeException("Package manager has died", e);
        }
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.873 -0500", hash_original_method = "107797D329CAA491AA1A678294A11B0E", hash_generated_method = "EDFEC74B1CCB5D8BB60CB53009F2805F")
    
@Override
    public String getNameForUid(int uid) {
        try {
            return mPM.getNameForUid(uid);
        } catch (RemoteException e) {
            throw new RuntimeException("Package manager has died", e);
        }
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.876 -0500", hash_original_method = "BCD62F04CBDED38DF225700C99BB4852", hash_generated_method = "D1EE8D0F2D56AB37593C47E652842282")
    
@Override
    public int getUidForSharedUser(String sharedUserName)
            throws NameNotFoundException {
        try {
            int uid = mPM.getUidForSharedUser(sharedUserName);
            if(uid != -1) {
                return uid;
            }
        } catch (RemoteException e) {
            throw new RuntimeException("Package manager has died", e);
        }
        throw new NameNotFoundException("No shared userid for user:"+sharedUserName);
    }

    @DSSpec(DSCat.IPC)
    @DSSource({DSSourceKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.878 -0500", hash_original_method = "2CD6168D318C89447F6184EBDE96189F", hash_generated_method = "6B80AE11CE903FF00AA20B898A12A11A")
    
@SuppressWarnings("unchecked")
    @Override
    public List<PackageInfo> getInstalledPackages(int flags) {
        try {
            final List<PackageInfo> packageInfos = new ArrayList<PackageInfo>();
            PackageInfo lastItem = null;
            ParceledListSlice<PackageInfo> slice;

            do {
                final String lastKey = lastItem != null ? lastItem.packageName : null;
                slice = mPM.getInstalledPackages(flags, lastKey);
                lastItem = slice.populateList(packageInfos, PackageInfo.CREATOR);
            } while (!slice.isLastSlice());

            return packageInfos;
        } catch (RemoteException e) {
            throw new RuntimeException("Package manager has died", e);
        }
    }

    @DSSpec(DSCat.IPC)
    @DSSource({DSSourceKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.881 -0500", hash_original_method = "195CA5538214D0B5EDE14A1F47A96E96", hash_generated_method = "C315BAFA2A0A8D0D93CBD7E4BC520D33")
    
@SuppressWarnings("unchecked")
    @Override
    public List<ApplicationInfo> getInstalledApplications(int flags) {
        try {
            final List<ApplicationInfo> applicationInfos = new ArrayList<ApplicationInfo>();
            ApplicationInfo lastItem = null;
            ParceledListSlice<ApplicationInfo> slice;

            do {
                final String lastKey = lastItem != null ? lastItem.packageName : null;
                slice = mPM.getInstalledApplications(flags, lastKey);
                lastItem = slice.populateList(applicationInfos, ApplicationInfo.CREATOR);
            } while (!slice.isLastSlice());

            return applicationInfos;
        } catch (RemoteException e) {
            throw new RuntimeException("Package manager has died", e);
        }
    }

    @DSSpec(DSCat.IPC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.884 -0500", hash_original_method = "0CD7CD39AE65A355BC33F2BA54C4DC37", hash_generated_method = "E92F5F02ACE5579692E712CFB0B8A5C5")
    
@Override
    public ResolveInfo resolveActivity(Intent intent, int flags) {
        try {
            return mPM.resolveIntent(
                intent,
                intent.resolveTypeIfNeeded(mContext.getContentResolver()),
                flags);
        } catch (RemoteException e) {
            throw new RuntimeException("Package manager has died", e);
        }
    }

    @DSSpec(DSCat.IPC)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.886 -0500", hash_original_method = "613ED89A001624360A0EB6B3BD081707", hash_generated_method = "E6D27C03B3B30501BEBA784C89734ADD")
    
@Override
    public List<ResolveInfo> queryIntentActivities(Intent intent,
                                                   int flags) {
        try {
            return mPM.queryIntentActivities(
                intent,
                intent.resolveTypeIfNeeded(mContext.getContentResolver()),
                flags);
        } catch (RemoteException e) {
            throw new RuntimeException("Package manager has died", e);
        }
    }

    @DSSpec(DSCat.IPC)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.889 -0500", hash_original_method = "9B955FD88A95F7C1CCD0CD1DFE6EC270", hash_generated_method = "D36C3B7D2551BE8C07B69642FEFE26D5")
    
@Override
    public List<ResolveInfo> queryIntentActivityOptions(
        ComponentName caller, Intent[] specifics, Intent intent,
        int flags) {
        final ContentResolver resolver = mContext.getContentResolver();

        String[] specificTypes = null;
        if (specifics != null) {
            final int N = specifics.length;
            for (int i=0; i<N; i++) {
                Intent sp = specifics[i];
                if (sp != null) {
                    String t = sp.resolveTypeIfNeeded(resolver);
                    if (t != null) {
                        if (specificTypes == null) {
                            specificTypes = new String[N];
                        }
                        specificTypes[i] = t;
                    }
                }
            }
        }

        try {
            return mPM.queryIntentActivityOptions(caller, specifics,
                                                  specificTypes, intent, intent.resolveTypeIfNeeded(resolver),
                                                  flags);
        } catch (RemoteException e) {
            throw new RuntimeException("Package manager has died", e);
        }
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.891 -0500", hash_original_method = "2B65A8BDA3BE53DC3296D1F5CA76CDFC", hash_generated_method = "DEB52F509FA8AAC88EFE7085313AEFDB")
    
@Override
    public List<ResolveInfo> queryBroadcastReceivers(Intent intent, int flags) {
        try {
            return mPM.queryIntentReceivers(
                intent,
                intent.resolveTypeIfNeeded(mContext.getContentResolver()),
                flags);
        } catch (RemoteException e) {
            throw new RuntimeException("Package manager has died", e);
        }
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.894 -0500", hash_original_method = "D7D4C733DB611C9D18D346868F9BD0BD", hash_generated_method = "9F948CBC2D71DC9F6C84BF1B63866E22")
    
@Override
    public ResolveInfo resolveService(Intent intent, int flags) {
        try {
            return mPM.resolveService(
                intent,
                intent.resolveTypeIfNeeded(mContext.getContentResolver()),
                flags);
        } catch (RemoteException e) {
            throw new RuntimeException("Package manager has died", e);
        }
    }

    @DSSpec(DSCat.IPC)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.896 -0500", hash_original_method = "EEB4EB852740846BAD76CCDE5FC0C613", hash_generated_method = "839A2E77FB30D1D206A7AC358111BEF2")
    
@Override
    public List<ResolveInfo> queryIntentServices(Intent intent, int flags) {
        try {
            return mPM.queryIntentServices(
                intent,
                intent.resolveTypeIfNeeded(mContext.getContentResolver()),
                flags);
        } catch (RemoteException e) {
            throw new RuntimeException("Package manager has died", e);
        }
    }

    @DSSpec(DSCat.IPC)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.907 -0500", hash_original_method = "3A6513CB26C2E0AF7DACFC2B8A5D560B", hash_generated_method = "F53A7551C4AA05FB097DA099CB348C9E")
    
@Override
    public ProviderInfo resolveContentProvider(String name,
                                               int flags) {
        try {
            return mPM.resolveContentProvider(name, flags);
        } catch (RemoteException e) {
            throw new RuntimeException("Package manager has died", e);
        }
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.910 -0500", hash_original_method = "7B04A4BE8EFECF5209DBE4F77CB67C42", hash_generated_method = "FB2F54F78EFAE668D3377D456FD4CA9A")
    
@Override
    public List<ProviderInfo> queryContentProviders(String processName,
                                                    int uid, int flags) {
        try {
            return mPM.queryContentProviders(processName, uid, flags);
        } catch (RemoteException e) {
            throw new RuntimeException("Package manager has died", e);
        }
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.912 -0500", hash_original_method = "3120887453BFC9391A593077A4EB2D8C", hash_generated_method = "1C2FF161BFF9CCC975104819EBD54B10")
    
@Override
    public InstrumentationInfo getInstrumentationInfo(
        ComponentName className, int flags)
            throws NameNotFoundException {
        try {
            InstrumentationInfo ii = mPM.getInstrumentationInfo(
                className, flags);
            if (ii != null) {
                return ii;
            }
        } catch (RemoteException e) {
            throw new RuntimeException("Package manager has died", e);
        }

        throw new NameNotFoundException(className.toString());
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.915 -0500", hash_original_method = "0CE547FAA1F9EB003838A9DE59E3AC72", hash_generated_method = "CAAF8D134A63728980C56778B9312EB3")
    
@Override
    public List<InstrumentationInfo> queryInstrumentation(
        String targetPackage, int flags) {
        try {
            return mPM.queryInstrumentation(targetPackage, flags);
        } catch (RemoteException e) {
            throw new RuntimeException("Package manager has died", e);
        }
    }

    @DSSpec(DSCat.IPC)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.918 -0500", hash_original_method = "350CC4BDDD2E42419F88F44C033409F6", hash_generated_method = "D7EE552257AFCB3884052F65BE9EEE93")
    
@Override public Drawable getDrawable(String packageName, int resid,
                                          ApplicationInfo appInfo) {
        ResourceName name = new ResourceName(packageName, resid);
        Drawable dr = getCachedIcon(name);
        if (dr != null) {
            return dr;
        }
        if (appInfo == null) {
            try {
                appInfo = getApplicationInfo(packageName, 0);
            } catch (NameNotFoundException e) {
                return null;
            }
        }
        try {
            Resources r = getResourcesForApplication(appInfo);
            dr = r.getDrawable(resid);
            if (false) {
                RuntimeException e = new RuntimeException("here");
                e.fillInStackTrace();
                Log.w(TAG, "Getting drawable 0x" + Integer.toHexString(resid)
                      + " from package " + packageName
                      + ": app scale=" + r.getCompatibilityInfo().applicationScale
                      + ", caller scale=" + mContext.getResources().getCompatibilityInfo().applicationScale,
                      e);
            }
            if (DEBUG_ICONS) Log.v(TAG, "Getting drawable 0x"
                                   + Integer.toHexString(resid) + " from " + r
                                   + ": " + dr);
            putCachedIcon(name, dr);
            return dr;
        } catch (NameNotFoundException e) {
            Log.w("PackageManager", "Failure retrieving resources for"
                  + appInfo.packageName);
        } catch (Resources.NotFoundException e) {
            Log.w("PackageManager", "Failure retrieving resources for"
                  + appInfo.packageName + ": " + e.getMessage());
        } catch (RuntimeException e) {
            // If an exception was thrown, fall through to return
            // default icon.
            Log.w("PackageManager", "Failure retrieving icon 0x"
                  + Integer.toHexString(resid) + " in package "
                  + packageName, e);
        }
        return null;
    }

    @DSSpec(DSCat.IPC)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.921 -0500", hash_original_method = "E8823DE045849946097DF943F50B58DB", hash_generated_method = "04E5C7A2AE8474A337A5572B23A268A8")
    
@Override public Drawable getActivityIcon(ComponentName activityName)
            throws NameNotFoundException {
        return getActivityInfo(activityName, 0).loadIcon(this);
    }

    @DSSpec(DSCat.IPC)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.923 -0500", hash_original_method = "EF5F409F30F5D50F1964B6AB6B7F75B7", hash_generated_method = "C75839D6E1579E8FC96CA43A864F25D8")
    
@Override public Drawable getActivityIcon(Intent intent)
            throws NameNotFoundException {
        if (intent.getComponent() != null) {
            return getActivityIcon(intent.getComponent());
        }

        ResolveInfo info = resolveActivity(
            intent, PackageManager.MATCH_DEFAULT_ONLY);
        if (info != null) {
            return info.activityInfo.loadIcon(this);
        }

        throw new NameNotFoundException(intent.toUri(0));
    }

    @DSSpec(DSCat.IPC)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.926 -0500", hash_original_method = "27F8B828FEA8943560AD77E4760B6964", hash_generated_method = "D59B2387CD92FBB6B3593581086D26BD")
    
@Override public Drawable getDefaultActivityIcon() {
        return Resources.getSystem().getDrawable(
            com.android.internal.R.drawable.sym_def_app_icon);
    }

    @DSSpec(DSCat.IPC)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.928 -0500", hash_original_method = "C2186A062EDEC18E9DD8F87E8E6291D1", hash_generated_method = "CB3A075E196795909980D831E6793C11")
    
@Override public Drawable getApplicationIcon(ApplicationInfo info) {
        return info.loadIcon(this);
    }

    @DSSpec(DSCat.IPC)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.931 -0500", hash_original_method = "49256B647BD52234F52BC973E3B03E0B", hash_generated_method = "E0CB6A2F18DB4FEEC1933E37BC8C24EE")
    
@Override public Drawable getApplicationIcon(String packageName)
            throws NameNotFoundException {
        return getApplicationIcon(getApplicationInfo(packageName, 0));
    }

    @DSSpec(DSCat.IPC)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.933 -0500", hash_original_method = "12128D2FB1F753A28280A7EF3E62F4B2", hash_generated_method = "A96E93CE32257AB8AAB3E397C49DCBBE")
    
@Override
    public Drawable getActivityLogo(ComponentName activityName)
            throws NameNotFoundException {
        return getActivityInfo(activityName, 0).loadLogo(this);
    }

    @DSSpec(DSCat.IPC)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.935 -0500", hash_original_method = "3B1A86BB5E25FB8EFA7A1AD1A88B3B01", hash_generated_method = "4C84168A232DB11DF78AF3C920822EB8")
    
@Override
    public Drawable getActivityLogo(Intent intent)
            throws NameNotFoundException {
        if (intent.getComponent() != null) {
            return getActivityLogo(intent.getComponent());
        }

        ResolveInfo info = resolveActivity(
            intent, PackageManager.MATCH_DEFAULT_ONLY);
        if (info != null) {
            return info.activityInfo.loadLogo(this);
        }

        throw new NameNotFoundException(intent.toUri(0));
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.938 -0500", hash_original_method = "586E62978169D56092172114763F9AD3", hash_generated_method = "3A3A243553D6803DB404BE5963527B50")
    
@Override
    public Drawable getApplicationLogo(ApplicationInfo info) {
        return info.loadLogo(this);
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.940 -0500", hash_original_method = "6BC85FEDD3936A7851329E2331D0279D", hash_generated_method = "C707B30451200E2116ADE91072AEB254")
    
@Override
    public Drawable getApplicationLogo(String packageName)
            throws NameNotFoundException {
        return getApplicationLogo(getApplicationInfo(packageName, 0));
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.943 -0500", hash_original_method = "E07E3E36CD8F79CF4FE12B9F33A40344", hash_generated_method = "9DE06760DFADDC6BE6183CC3F8478B7A")
    
@Override public Resources getResourcesForActivity(
        ComponentName activityName) throws NameNotFoundException {
        return getResourcesForApplication(
            getActivityInfo(activityName, 0).applicationInfo);
    }

    @DSSpec(DSCat.IPC)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.945 -0500", hash_original_method = "AC20F77416CABFA638F647DA9F2F230E", hash_generated_method = "42CF644584A8E29C908F22189F5F2CB9")
    
@Override public Resources getResourcesForApplication(
        ApplicationInfo app) throws NameNotFoundException {
        if (app.packageName.equals("system")) {
            return mContext.mMainThread.getSystemContext().getResources();
        }
        Resources r = mContext.mMainThread.getTopLevelResources(
            app.uid == Process.myUid() ? app.sourceDir
            : app.publicSourceDir, mContext.mPackageInfo);
        if (r != null) {
            return r;
        }
        throw new NameNotFoundException("Unable to open " + app.publicSourceDir);
    }

    @DSSpec(DSCat.IPC)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.947 -0500", hash_original_method = "ACD444E0FC7FCEAEB5D1FF09DD4A5912", hash_generated_method = "2A143560C5CABE612F980C34B3D25741")
    
@Override public Resources getResourcesForApplication(
        String appPackageName) throws NameNotFoundException {
        return getResourcesForApplication(
            getApplicationInfo(appPackageName, 0));
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.951 -0500", hash_original_method = "6B2AA9A609FE89D703EEC81AF1FC0890", hash_generated_method = "D6D3AD4A7ECE50284D5F8E45D980113A")
    
@Override public boolean isSafeMode() {
        try {
            if (mCachedSafeMode < 0) {
                mCachedSafeMode = mPM.isSafeMode() ? 1 : 0;
            }
            return 1 == (mCachedSafeMode + (((mPM.isSafeMode())) ? 1 : 0)); 
        } catch (RemoteException e) {
            throw new RuntimeException("Package manager has died", e);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.959 -0500", hash_original_method = "805BC435FDAE098AFC4F53B40E89D7C1", hash_generated_method = "50E538939BB725E5437F6B6D22D4CAD7")
    
private Drawable getCachedIcon(ResourceName name) {
        synchronized (sSync) {
            WeakReference<Drawable.ConstantState> wr = sIconCache.get(name);
            if (DEBUG_ICONS) Log.v(TAG, "Get cached weak drawable ref for "
                                   + name + ": " + wr);
            if (wr != null) {   // we have the activity
                Drawable.ConstantState state = wr.get();
                if (state != null) {
                    if (DEBUG_ICONS) {
                        Log.v(TAG, "Get cached drawable state for " + name + ": " + state);
                    }
                    // Note: It's okay here to not use the newDrawable(Resources) variant
                    //       of the API. The ConstantState comes from a drawable that was
                    //       originally created by passing the proper app Resources instance
                    //       which means the state should already contain the proper
                    //       resources specific information (like density.) See
                    //       BitmapDrawable.BitmapState for instance.
                    return state.newDrawable();
                }
                // our entry has been purged
                sIconCache.remove(name);
            }
        }
        return null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.961 -0500", hash_original_method = "1ADDA1851B7207BD0D6C119E2C63D6A2", hash_generated_method = "0284131E8AFCF233157E0F2073F1F669")
    
private void putCachedIcon(ResourceName name, Drawable dr) {
        synchronized (sSync) {
            sIconCache.put(name, new WeakReference<Drawable.ConstantState>(dr.getConstantState()));
            if (DEBUG_ICONS) Log.v(TAG, "Added cached drawable state for " + name + ": " + dr);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.991 -0500", hash_original_method = "B66098C8E55783775B73FA7D73879D41", hash_generated_method = "AC115818B61599D3466DBC5CF6AD35FC")
    
private CharSequence getCachedString(ResourceName name) {
        synchronized (sSync) {
            WeakReference<CharSequence> wr = sStringCache.get(name);
            if (wr != null) {   // we have the activity
                CharSequence cs = wr.get();
                if (cs != null) {
                    return cs;
                }
                // our entry has been purged
                sStringCache.remove(name);
            }
        }
        return null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.993 -0500", hash_original_method = "70E4290F1842F0A45B89D50D6CDEDDBB", hash_generated_method = "6EBB8115BCB6E4A21E8C1BDF68FF3F22")
    
private void putCachedString(ResourceName name, CharSequence cs) {
        synchronized (sSync) {
            sStringCache.put(name, new WeakReference<CharSequence>(cs));
        }
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.996 -0500", hash_original_method = "771B010EDE230C24A313E1F6F3869FDB", hash_generated_method = "DA90A79BD2365F3D53B4B86A2343E382")
    
@Override
    public CharSequence getText(String packageName, int resid,
                                ApplicationInfo appInfo) {
        ResourceName name = new ResourceName(packageName, resid);
        CharSequence text = getCachedString(name);
        if (text != null) {
            return text;
        }
        if (appInfo == null) {
            try {
                appInfo = getApplicationInfo(packageName, 0);
            } catch (NameNotFoundException e) {
                return null;
            }
        }
        try {
            Resources r = getResourcesForApplication(appInfo);
            text = r.getText(resid);
            putCachedString(name, text);
            return text;
        } catch (NameNotFoundException e) {
            Log.w("PackageManager", "Failure retrieving resources for"
                  + appInfo.packageName);
        } catch (RuntimeException e) {
            // If an exception was thrown, fall through to return
            // default icon.
            Log.w("PackageManager", "Failure retrieving text 0x"
                  + Integer.toHexString(resid) + " in package "
                  + packageName, e);
        }
        return null;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.999 -0500", hash_original_method = "F130C54905A9CE16326CF20EF6E93255", hash_generated_method = "732D1F65E84D1E830E17DCF1032586FD")
    
@Override
    public XmlResourceParser getXml(String packageName, int resid,
                                    ApplicationInfo appInfo) {
        if (appInfo == null) {
            try {
                appInfo = getApplicationInfo(packageName, 0);
            } catch (NameNotFoundException e) {
                return null;
            }
        }
        try {
            Resources r = getResourcesForApplication(appInfo);
            return r.getXml(resid);
        } catch (RuntimeException e) {
            // If an exception was thrown, fall through to return
            // default icon.
            Log.w("PackageManager", "Failure retrieving xml 0x"
                  + Integer.toHexString(resid) + " in package "
                  + packageName, e);
        } catch (NameNotFoundException e) {
            Log.w("PackageManager", "Failure retrieving resources for "
                  + appInfo.packageName);
        }
        return null;
    }

    @DSSpec(DSCat.IPC)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:23.002 -0500", hash_original_method = "4AFDE050276913F392973B277F54706D", hash_generated_method = "6F92466A776DBA6739B13B32017ADBC6")
    
@Override
    public CharSequence getApplicationLabel(ApplicationInfo info) {
        return info.loadLabel(this);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:23.005 -0500", hash_original_method = "99610A6DD5E10C01303307EBA6938AA8", hash_generated_method = "997DDB92BA15DF8830B30F55A438AEC8")
    
@Override
    public void installPackage(Uri packageURI, IPackageInstallObserver observer, int flags,
                               String installerPackageName) {
        try {
            mPM.installPackage(packageURI, observer, flags, installerPackageName);
        } catch (RemoteException e) {
            // Should never happen!
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:23.007 -0500", hash_original_method = "769145FCC72852B2314845C8A89A2DAD", hash_generated_method = "19BAA6631D99C8A14AF66FFEB1B82C01")
    
@Override
    public void installPackageWithVerification(Uri packageURI, IPackageInstallObserver observer,
            int flags, String installerPackageName, Uri verificationURI,
            ManifestDigest manifestDigest) {
        try {
            mPM.installPackageWithVerification(packageURI, observer, flags, installerPackageName,
                    verificationURI, manifestDigest);
        } catch (RemoteException e) {
            // Should never happen!
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:23.010 -0500", hash_original_method = "E593338881B3E45506EA974F446D2A6B", hash_generated_method = "95FCD74D7E30AE6DCBB14E4A8698CA0E")
    
@Override
    public void verifyPendingInstall(int id, int response) {
        try {
            mPM.verifyPendingInstall(id, response);
        } catch (RemoteException e) {
            // Should never happen!
        }
    }

    @DSSpec(DSCat.IPC)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:23.012 -0500", hash_original_method = "A168A8E169316429D31E261AD639AED4", hash_generated_method = "3F7C412AAA1A062643D750EAC32C2DBC")
    
@Override
    public void setInstallerPackageName(String targetPackage,
            String installerPackageName) {
        try {
            mPM.setInstallerPackageName(targetPackage, installerPackageName);
        } catch (RemoteException e) {
            // Should never happen!
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:23.014 -0500", hash_original_method = "D8F1CA3B8F90BF876B114DD825F09703", hash_generated_method = "6EF66894D1EA6F1B771989A7D085970B")
    
@Override
    public void movePackage(String packageName, IPackageMoveObserver observer, int flags) {
        try {
            mPM.movePackage(packageName, observer, flags);
        } catch (RemoteException e) {
            // Should never happen!
        }
    }

    @DSSpec(DSCat.IPC)
    @DSSource({DSSourceKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:23.016 -0500", hash_original_method = "13C0F9FC5FF4142BD538C8A3AADB3621", hash_generated_method = "DD437D44318BC382B9EE50809801B5B8")
    
@Override
    public String getInstallerPackageName(String packageName) {
        try {
            return mPM.getInstallerPackageName(packageName);
        } catch (RemoteException e) {
            // Should never happen!
        }
        return null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:23.019 -0500", hash_original_method = "6B4A8C0BA02325B97A4B696E509E27F1", hash_generated_method = "6CB31FFAB8C081983F7ACFFFD5D738AE")
    
@Override
    public void deletePackage(String packageName, IPackageDeleteObserver observer, int flags) {
        try {
            mPM.deletePackage(packageName, observer, flags);
        } catch (RemoteException e) {
            // Should never happen!
        }
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:23.021 -0500", hash_original_method = "41D4F7CDEA8F3FA97A215E5DB5AE3B7F", hash_generated_method = "77A8D54789E7B4299F740ADE767BA7B3")
    
@Override
    public void clearApplicationUserData(String packageName,
                                         IPackageDataObserver observer) {
        try {
            mPM.clearApplicationUserData(packageName, observer);
        } catch (RemoteException e) {
            // Should never happen!
        }
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:23.023 -0500", hash_original_method = "9E003FA712762A764BBDA3187B8255C1", hash_generated_method = "CC211B8B19EC8D910552F6879BF8B654")
    
@Override
    public void deleteApplicationCacheFiles(String packageName,
                                            IPackageDataObserver observer) {
        try {
            mPM.deleteApplicationCacheFiles(packageName, observer);
        } catch (RemoteException e) {
            // Should never happen!
        }
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:23.026 -0500", hash_original_method = "E7A7F0006F405C835ECAAE7B969343FA", hash_generated_method = "4C9858E1CFB8DCCA74E802D0A828190C")
    
@Override
    public void freeStorageAndNotify(long idealStorageSize, IPackageDataObserver observer) {
        try {
            mPM.freeStorageAndNotify(idealStorageSize, observer);
        } catch (RemoteException e) {
            // Should never happen!
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:23.028 -0500", hash_original_method = "8531AD2E443F843CDBBD03DDCC5F2882", hash_generated_method = "E0FA44A54C4D3A70B4000FCBE34BEB7A")
    
@Override
    public void freeStorage(long freeStorageSize, IntentSender pi) {
        try {
            mPM.freeStorage(freeStorageSize, pi);
        } catch (RemoteException e) {
            // Should never happen!
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:23.031 -0500", hash_original_method = "00314015F36B785D35449EC7724DA4A0", hash_generated_method = "CB0DD2AD10FF18999E850D5E237612EC")
    
@Override
    public void getPackageSizeInfo(String packageName,
                                   IPackageStatsObserver observer) {
        try {
            mPM.getPackageSizeInfo(packageName, observer);
        } catch (RemoteException e) {
            // Should never happen!
        }
    }
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:23.033 -0500", hash_original_method = "A9291C102B2FAAEF4C90A57E1B6DE098", hash_generated_method = "D62EBB54E3FC927C0386831AD69D9B62")
    
@Override
    public void addPackageToPreferred(String packageName) {
        try {
            mPM.addPackageToPreferred(packageName);
        } catch (RemoteException e) {
            // Should never happen!
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:23.036 -0500", hash_original_method = "F1B5214867A85B15353BE55995A19BB6", hash_generated_method = "6AD7300CE51DC4530FBDF6985F8BBFE1")
    
@Override
    public void removePackageFromPreferred(String packageName) {
        try {
            mPM.removePackageFromPreferred(packageName);
        } catch (RemoteException e) {
            // Should never happen!
        }
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:23.038 -0500", hash_original_method = "4A08CFB9ACE88EAEABD2D18F083F329D", hash_generated_method = "1DCAD4E5E43C7FB91E870457685E77CF")
    
@Override
    public List<PackageInfo> getPreferredPackages(int flags) {
        try {
            return mPM.getPreferredPackages(flags);
        } catch (RemoteException e) {
            // Should never happen!
        }
        return new ArrayList<PackageInfo>();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:23.040 -0500", hash_original_method = "E5D2F7A75D600839A582F36FB9BA5425", hash_generated_method = "5CDAC88BCF81D71BA99D8A9AF496AB4E")
    
@Override
    public void addPreferredActivity(IntentFilter filter,
                                     int match, ComponentName[] set, ComponentName activity) {
        try {
            mPM.addPreferredActivity(filter, match, set, activity);
        } catch (RemoteException e) {
            // Should never happen!
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:23.042 -0500", hash_original_method = "2885B1E40721D55CC13EAA30EB1BAE52", hash_generated_method = "4C05F5E364E4D28E8C4DB17E4D6DFE98")
    
@Override
    public void replacePreferredActivity(IntentFilter filter,
                                         int match, ComponentName[] set, ComponentName activity) {
        try {
            mPM.replacePreferredActivity(filter, match, set, activity);
        } catch (RemoteException e) {
            // Should never happen!
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:23.044 -0500", hash_original_method = "818084167B76F544DAE31D40EA850683", hash_generated_method = "DAC7E897430841A0F1885A5549EA308B")
    
@Override
    public void clearPackagePreferredActivities(String packageName) {
        try {
            mPM.clearPackagePreferredActivities(packageName);
        } catch (RemoteException e) {
            // Should never happen!
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:23.047 -0500", hash_original_method = "9A1408660FD10D92BECBE2BE18AA9510", hash_generated_method = "D37FA5D7DC0CCC2DD608041A5733776C")
    
@Override
    public int getPreferredActivities(List<IntentFilter> outFilters,
                                      List<ComponentName> outActivities, String packageName) {
        try {
            return mPM.getPreferredActivities(outFilters, outActivities, packageName);
        } catch (RemoteException e) {
            // Should never happen!
        }
        return 0;
    }

    @DSSpec(DSCat.IPC)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:23.050 -0500", hash_original_method = "324289EEBFA692363CEA9B4C548C82A7", hash_generated_method = "34EBF4153AE405446EB1EAF65F614875")
    
@Override
    public void setComponentEnabledSetting(ComponentName componentName,
                                           int newState, int flags) {
        try {
            mPM.setComponentEnabledSetting(componentName, newState, flags);
        } catch (RemoteException e) {
            // Should never happen!
        }
    }

    @DSSpec(DSCat.IPC)
    @DSSource({DSSourceKind.IPC})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:23.052 -0500", hash_original_method = "214E6E4C94F679DC0FE6A4159B821EAF", hash_generated_method = "968EA54F0CDFAAF81D392F1B25B69C7E")
    
@Override
    public int getComponentEnabledSetting(ComponentName componentName) {
        try {
            return mPM.getComponentEnabledSetting(componentName);
        } catch (RemoteException e) {
            // Should never happen!
        }
        return PackageManager.COMPONENT_ENABLED_STATE_DEFAULT;
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:23.054 -0500", hash_original_method = "893989AE0F295A10184FE7AD874B7991", hash_generated_method = "2EB016FFA899F3C51681142789C41B3A")
    
@Override
    public void setApplicationEnabledSetting(String packageName,
                                             int newState, int flags) {
        try {
            mPM.setApplicationEnabledSetting(packageName, newState, flags);
        } catch (RemoteException e) {
            // Should never happen!
        }
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:23.057 -0500", hash_original_method = "786754E395F784476E8D899ABD01121D", hash_generated_method = "2B2BCB023AFB6AEB87E2559829E3D767")
    
@Override
    public int getApplicationEnabledSetting(String packageName) {
        try {
            return mPM.getApplicationEnabledSetting(packageName);
        } catch (RemoteException e) {
            // Should never happen!
        }
        return PackageManager.COMPONENT_ENABLED_STATE_DEFAULT;
    }
    
    private static final class ResourceName {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.968 -0500", hash_original_field = "6F92EE1B3BCDC0C4179CF5FD998BE046", hash_generated_field = "6F92EE1B3BCDC0C4179CF5FD998BE046")

         String packageName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.970 -0500", hash_original_field = "5FB1FE173593F2C1352A3849ECD329FE", hash_generated_field = "5FB1FE173593F2C1352A3849ECD329FE")

         int iconId;

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.972 -0500", hash_original_method = "00C0083FA3192C6FB2E9C58DC21ABF99", hash_generated_method = "00C0083FA3192C6FB2E9C58DC21ABF99")
        
ResourceName(String _packageName, int _iconId) {
            packageName = _packageName;
            iconId = _iconId;
        }

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.975 -0500", hash_original_method = "1D7CABC5D0E2E4029539D2105E7113C1", hash_generated_method = "1D7CABC5D0E2E4029539D2105E7113C1")
        
ResourceName(ApplicationInfo aInfo, int _iconId) {
            this(aInfo.packageName, _iconId);
        }

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.977 -0500", hash_original_method = "316DD832F87E78ED23C1ED370845ED19", hash_generated_method = "316DD832F87E78ED23C1ED370845ED19")
        
ResourceName(ComponentInfo cInfo, int _iconId) {
            this(cInfo.applicationInfo.packageName, _iconId);
        }

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.980 -0500", hash_original_method = "B7E8883725512A2439D57072801DA2BC", hash_generated_method = "B7E8883725512A2439D57072801DA2BC")
        
ResourceName(ResolveInfo rInfo, int _iconId) {
            this(rInfo.activityInfo.applicationInfo.packageName, _iconId);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.982 -0500", hash_original_method = "77EA94B0E7A0581CD73B79023B92E268", hash_generated_method = "77B3F939F06FEF52185FCA37A12A7BBC")
        
@Override
        public boolean equals(Object o) {

            Object ret = new Object();
            ret.addTaint(o.getTaintInt() + getTaintInt());

            if (packageName != null)
                ret.addTaint(packageName.getTaint());

            ret.addTaint(o.getClass().getTaint());

            if (o != null && getClass() == o.getClass()) {
                ResourceName that = (ResourceName) o;
                ret.addTaint(that.packageName.getTaint());
            }

            return ret.getTaintBoolean();

/*
            if (o == null || getClass() != o.getClass()) return false;

            ResourceName that = (ResourceName) o;

            if (iconId != that.iconId) return false;
            return !(packageName != null ?
                     !packageName.equals(that.packageName) : that.packageName != null);
*/
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.985 -0500", hash_original_method = "FE96AD3461E654FCE4E8B88F254AC3EE", hash_generated_method = "762AFF0BD766AF93D60EF5AA43B0A594")
        
@Override
        public int hashCode() {
            int result;
            result = packageName.hashCode();
            result = 31 * result + iconId;
            return result;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.988 -0500", hash_original_method = "19C1C9668D8A7EEF540F3D9429936D14", hash_generated_method = "03FAF0B089B6194931E4305874DC2344")
        
@Override
        public String toString() {
            return "{ResourceName " + packageName + " / " + iconId + "}";
        }
        
    }

    // Multi-user support

    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:23.059 -0500", hash_original_method = "26D19368C79A5889D2D25A72A45789A8", hash_generated_method = "700E250E000123C6DA673BCBF4FEFB5F")
    
@Override
    public UserInfo createUser(String name, int flags) {
        try {
            return mPM.createUser(name, flags);
        } catch (RemoteException e) {
            // Should never happen!
        }
        return null;
    }

    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:23.061 -0500", hash_original_method = "D3989192690585F23E6C25734E0C3BDB", hash_generated_method = "84BF5864345A3F8C92935068C8315B11")
    
@Override
    public List<UserInfo> getUsers() {
        // TODO:
        // Dummy code, always returns just the primary user
        ArrayList<UserInfo> users = new ArrayList<UserInfo>();
        UserInfo primary = new UserInfo(0, "Root!",
                UserInfo.FLAG_ADMIN | UserInfo.FLAG_PRIMARY);
        users.add(primary);
        return users;
    }

    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:23.064 -0500", hash_original_method = "7D391C716B6EBFD3B4233647A1DCBC34", hash_generated_method = "39EBF25DA920FA0DB7158EEA2640C1BE")
    
@Override
    public boolean removeUser(int id) {
        try {
            return mPM.removeUser(id);
        } catch (RemoteException e) {
            return false;
        }
    }

    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:23.066 -0500", hash_original_method = "C52981B6B26B608864F1952FFD2E785F", hash_generated_method = "0D68B8D177A8D5C681AD5A74CB748510")
    
@Override
    public void updateUserName(int id, String name) {
        // TODO:
    }

    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:23.068 -0500", hash_original_method = "B193A8F9463928060D13777D952477CD", hash_generated_method = "E11B762253D52357FD2B5BCD9E1FD93F")
    
@Override
    public void updateUserFlags(int id, int flags) {
        // TODO:
    }

    /**
     * @hide
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:23.071 -0500", hash_original_method = "05FAEEF75E7B74D35A0F0687A4ACD32C", hash_generated_method = "B9CA90C451A4220706DF20C327605D4E")
    
@Override
    public VerifierDeviceIdentity getVerifierDeviceIdentity() {
        try {
            return mPM.getVerifierDeviceIdentity();
        } catch (RemoteException e) {
            // Should never happen!
        }
        return null;
    }
}

