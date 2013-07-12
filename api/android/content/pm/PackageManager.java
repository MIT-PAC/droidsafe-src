package android.content.pm;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.annotation.SdkConstant;
import android.annotation.SdkConstant.SdkConstantType;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.pm.ManifestDigest;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AndroidException;
import android.util.DisplayMetrics;
import java.io.File;
import java.util.List;

public abstract class PackageManager {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:12.992 -0400", hash_original_method = "5D24F7B229838E6C5BA06DA6570E4474", hash_generated_method = "5D24F7B229838E6C5BA06DA6570E4474")
    public PackageManager ()
    {
        
    }


    public abstract PackageInfo getPackageInfo(String packageName, int flags)
            throws NameNotFoundException;

    
    public abstract String[] currentToCanonicalPackageNames(String[] names);

    
    public abstract String[] canonicalToCurrentPackageNames(String[] names);

    
    public abstract Intent getLaunchIntentForPackage(String packageName);

    
    public abstract int[] getPackageGids(String packageName)
            throws NameNotFoundException;

    
    public abstract PermissionInfo getPermissionInfo(String name, int flags)
            throws NameNotFoundException;

    
    public abstract List<PermissionInfo> queryPermissionsByGroup(String group,
            int flags) throws NameNotFoundException;

    
    public abstract PermissionGroupInfo getPermissionGroupInfo(String name,
            int flags) throws NameNotFoundException;

    
    public abstract List<PermissionGroupInfo> getAllPermissionGroups(int flags);

    
    public abstract ApplicationInfo getApplicationInfo(String packageName,
            int flags) throws NameNotFoundException;

    
    public abstract ActivityInfo getActivityInfo(ComponentName component,
            int flags) throws NameNotFoundException;

    
    public abstract ActivityInfo getReceiverInfo(ComponentName component,
            int flags) throws NameNotFoundException;

    
    public abstract ServiceInfo getServiceInfo(ComponentName component,
            int flags) throws NameNotFoundException;

    
    public abstract ProviderInfo getProviderInfo(ComponentName component,
            int flags) throws NameNotFoundException;

    
    public abstract List<PackageInfo> getInstalledPackages(int flags);

    
    public abstract int checkPermission(String permName, String pkgName);

    
    public abstract boolean addPermission(PermissionInfo info);

    
    public abstract boolean addPermissionAsync(PermissionInfo info);

    
    public abstract void removePermission(String name);

    
    public abstract int checkSignatures(String pkg1, String pkg2);

    
    public abstract int checkSignatures(int uid1, int uid2);

    
    public abstract String[] getPackagesForUid(int uid);

    
    public abstract String getNameForUid(int uid);

    
    public abstract int getUidForSharedUser(String sharedUserName)
            throws NameNotFoundException;

    
    public abstract List<ApplicationInfo> getInstalledApplications(int flags);

    
    public abstract String[] getSystemSharedLibraryNames();

    
    public abstract FeatureInfo[] getSystemAvailableFeatures();

    
    public abstract boolean hasSystemFeature(String name);

    
    public abstract ResolveInfo resolveActivity(Intent intent, int flags);

    
    public abstract List<ResolveInfo> queryIntentActivities(Intent intent,
            int flags);

    
    public abstract List<ResolveInfo> queryIntentActivityOptions(
            ComponentName caller, Intent[] specifics, Intent intent, int flags);

    
    public abstract List<ResolveInfo> queryBroadcastReceivers(Intent intent,
            int flags);

    
    public abstract ResolveInfo resolveService(Intent intent, int flags);

    
    public abstract List<ResolveInfo> queryIntentServices(Intent intent,
            int flags);

    
    public abstract ProviderInfo resolveContentProvider(String name,
            int flags);

    
    public abstract List<ProviderInfo> queryContentProviders(
            String processName, int uid, int flags);

    
    public abstract InstrumentationInfo getInstrumentationInfo(
            ComponentName className, int flags) throws NameNotFoundException;

    
    public abstract List<InstrumentationInfo> queryInstrumentation(
            String targetPackage, int flags);

    
    public abstract Drawable getDrawable(String packageName, int resid,
            ApplicationInfo appInfo);

    
    public abstract Drawable getActivityIcon(ComponentName activityName)
            throws NameNotFoundException;

    
    public abstract Drawable getActivityIcon(Intent intent)
            throws NameNotFoundException;

    
    public abstract Drawable getDefaultActivityIcon();

    
    public abstract Drawable getApplicationIcon(ApplicationInfo info);

    
    public abstract Drawable getApplicationIcon(String packageName)
            throws NameNotFoundException;

    
    public abstract Drawable getActivityLogo(ComponentName activityName)
            throws NameNotFoundException;

    
    public abstract Drawable getActivityLogo(Intent intent)
            throws NameNotFoundException;

    
    public abstract Drawable getApplicationLogo(ApplicationInfo info);

    
    public abstract Drawable getApplicationLogo(String packageName)
            throws NameNotFoundException;

    
    public abstract CharSequence getText(String packageName, int resid,
            ApplicationInfo appInfo);

    
    public abstract XmlResourceParser getXml(String packageName, int resid,
            ApplicationInfo appInfo);

    
    public abstract CharSequence getApplicationLabel(ApplicationInfo info);

    
    public abstract Resources getResourcesForActivity(ComponentName activityName)
            throws NameNotFoundException;

    
    public abstract Resources getResourcesForApplication(ApplicationInfo app)
            throws NameNotFoundException;

    
    public abstract Resources getResourcesForApplication(String appPackageName)
            throws NameNotFoundException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.001 -0400", hash_original_method = "DBC2C646566E0B22A2FF91F44F8D10B2", hash_generated_method = "936E61EDC9619F8B8DB7537CD5AB95C5")
    public PackageInfo getPackageArchiveInfo(String archiveFilePath, int flags) {
        addTaint(flags);
        addTaint(archiveFilePath.getTaint());
        PackageParser packageParser = new PackageParser(archiveFilePath);
        DisplayMetrics metrics = new DisplayMetrics();
        metrics.setToDefaults();
        final File sourceFile = new File(archiveFilePath);
        PackageParser.Package pkg = packageParser.parsePackage(
                sourceFile, archiveFilePath, metrics, 0);
    if(pkg == null)        
        {
PackageInfo var540C13E9E156B687226421B24F2DF178_5707858 =             null;
            var540C13E9E156B687226421B24F2DF178_5707858.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_5707858;
        } 
    if((flags & GET_SIGNATURES) != 0)        
        {
            packageParser.collectCertificates(pkg, 0);
        } 
PackageInfo var5AE978B2B8E8AB8649F1BCEEB6A3CE29_318189940 =         PackageParser.generatePackageInfo(pkg, null, flags, 0, 0);
        var5AE978B2B8E8AB8649F1BCEEB6A3CE29_318189940.addTaint(taint);
        return var5AE978B2B8E8AB8649F1BCEEB6A3CE29_318189940;
        
        
        
        
        
        
                
        
            
        
        
            
        
        
    }

    
    public abstract void installPackage(
            Uri packageURI, IPackageInstallObserver observer, int flags,
            String installerPackageName);

    
    public abstract void installPackageWithVerification(Uri packageURI,
            IPackageInstallObserver observer, int flags, String installerPackageName,
            Uri verificationURI, ManifestDigest manifestDigest);

    
    public abstract void verifyPendingInstall(int id, int verificationCode);

    
    public abstract void setInstallerPackageName(String targetPackage,
            String installerPackageName);

    
    public abstract void deletePackage(
            String packageName, IPackageDeleteObserver observer, int flags);

    
    public abstract String getInstallerPackageName(String packageName);

    
    public abstract void clearApplicationUserData(String packageName,
            IPackageDataObserver observer);

    
    public abstract void deleteApplicationCacheFiles(String packageName,
            IPackageDataObserver observer);

    
    public abstract void freeStorageAndNotify(long freeStorageSize, IPackageDataObserver observer);

    
    public abstract void freeStorage(long freeStorageSize, IntentSender pi);

    
    public abstract void getPackageSizeInfo(String packageName,
            IPackageStatsObserver observer);

    
        @Deprecated
public abstract void addPackageToPreferred(String packageName);

    
        @Deprecated
public abstract void removePackageFromPreferred(String packageName);

    
    public abstract List<PackageInfo> getPreferredPackages(int flags);

    
        @Deprecated
public abstract void addPreferredActivity(IntentFilter filter, int match,
            ComponentName[] set, ComponentName activity);

    
        @Deprecated
public abstract void replacePreferredActivity(IntentFilter filter, int match,
            ComponentName[] set, ComponentName activity);

    
    public abstract void clearPackagePreferredActivities(String packageName);

    
    public abstract int getPreferredActivities(List<IntentFilter> outFilters,
            List<ComponentName> outActivities, String packageName);

    
    public abstract void setComponentEnabledSetting(ComponentName componentName,
            int newState, int flags);

    
    public abstract int getComponentEnabledSetting(ComponentName componentName);

    
    public abstract void setApplicationEnabledSetting(String packageName,
            int newState, int flags);

    
    public abstract int getApplicationEnabledSetting(String packageName);

    
    public abstract boolean isSafeMode();

    
    public abstract void movePackage(
            String packageName, IPackageMoveObserver observer, int flags);

    
    public abstract UserInfo createUser(String name, int flags);

    
    public abstract List<UserInfo> getUsers();

    
    public abstract boolean removeUser(int id);

    
    public abstract void updateUserName(int id, String name);

    
    public abstract void updateUserFlags(int id, int flags);

    
        @DSModeled(DSC.SPEC)
    public static boolean isSameUser(int uid1, int uid2) {
        return getUserId(uid1) == getUserId(uid2);
    }

    
        @DSModeled(DSC.SAFE)
    public static int getUserId(int uid) {
        return uid / PER_USER_RANGE;
    }

    
        @DSModeled(DSC.SAFE)
    public static int getUid(int userId, int appId) {
        return userId * PER_USER_RANGE + (appId % PER_USER_RANGE);
    }

    
        @DSModeled(DSC.SAFE)
    public static int getAppId(int uid) {
        return uid % PER_USER_RANGE;
    }

    
    public abstract VerifierDeviceIdentity getVerifierDeviceIdentity();

    
    public static class NameNotFoundException extends AndroidException {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.006 -0400", hash_original_method = "4C893FF4D2386A2E528254CA81C36065", hash_generated_method = "7DF33A3FC9B55E42DF52448A730F9D8D")
        public  NameNotFoundException() {
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.006 -0400", hash_original_method = "16889A22D22FB47C54F1114D13EC0BEF", hash_generated_method = "524CC9E75E8AA6F398306F9816576EA4")
        public  NameNotFoundException(String name) {
            super(name);
            addTaint(name.getTaint());
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.007 -0400", hash_original_field = "8D651D6FBAD5AE7A7FE31A0885E1EE8E", hash_generated_field = "8835CBE4CE0B754883D72C73052F7340")

    public static final int GET_ACTIVITIES              = 0x00000001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.007 -0400", hash_original_field = "7032D1BB010E906E0F7F37515BC776B4", hash_generated_field = "B56AAA9B031EB606FF7E6C87942F5617")

    public static final int GET_RECEIVERS               = 0x00000002;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.007 -0400", hash_original_field = "3C5A95E952BB8544D6E8409AEBACE872", hash_generated_field = "7749562F77593827C12B144952B7B1D1")

    public static final int GET_SERVICES                = 0x00000004;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.007 -0400", hash_original_field = "4231B39F747A56835AFDEBD8FACC5243", hash_generated_field = "2ADE93E0E1D3795BA5B3CB2C54142808")

    public static final int GET_PROVIDERS               = 0x00000008;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.007 -0400", hash_original_field = "E290D32A8A643581510D25962C88A3B6", hash_generated_field = "8A2E0D6696D0FD634C8E785FA5E75ECA")

    public static final int GET_INSTRUMENTATION         = 0x00000010;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.008 -0400", hash_original_field = "5DB38EE35DB4646EB46657F4EEC25D31", hash_generated_field = "28B8705AF671D4DC8D12514CA019DD0A")

    public static final int GET_INTENT_FILTERS          = 0x00000020;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.008 -0400", hash_original_field = "315C40D38A1D5116A4BEE8E5748EC5F4", hash_generated_field = "AF42ACE4DCC03A4B37A4A567D706A18D")

    public static final int GET_SIGNATURES          = 0x00000040;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.008 -0400", hash_original_field = "D59C73CC54E054A18E5053AAC4948340", hash_generated_field = "6DDF54A31666DE64251AF204B2AA6258")

    public static final int GET_RESOLVED_FILTER         = 0x00000040;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.008 -0400", hash_original_field = "448A1F4ABA4EB95E70FC4C42F4FBABD1", hash_generated_field = "66064721BF12B0315455979FF1300A94")

    public static final int GET_META_DATA               = 0x00000080;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.008 -0400", hash_original_field = "AFB352300348B291D987426A885FEF4A", hash_generated_field = "B1283A740C142DB27865E7F5436847EA")

    public static final int GET_GIDS                    = 0x00000100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.008 -0400", hash_original_field = "4175C79AF4446148D4CB7058E9A496FF", hash_generated_field = "06AF2F3D6CFCE9ECA35522021C2DE22A")

    public static final int GET_DISABLED_COMPONENTS     = 0x00000200;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.008 -0400", hash_original_field = "7CF30DAAE97F826E48F77FC3BF63E64E", hash_generated_field = "7D0EBBA6244EB83212355F98FCAA0F55")

    public static final int GET_SHARED_LIBRARY_FILES    = 0x00000400;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.008 -0400", hash_original_field = "960A269548FCDA282DC711FB072B6877", hash_generated_field = "A7322E230AB00161DC815F03D7A201B0")

    public static final int GET_URI_PERMISSION_PATTERNS  = 0x00000800;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.008 -0400", hash_original_field = "5733CD0AD629D95CBF36805344BB1742", hash_generated_field = "782F84C837524047813E86F68A3CBD94")

    public static final int GET_PERMISSIONS               = 0x00001000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.009 -0400", hash_original_field = "9B62F6EBE96F2EBEB7BF7013EE265DC4", hash_generated_field = "309C0FBBBFA8EF19181AE069151AB441")

    public static final int GET_UNINSTALLED_PACKAGES = 0x00002000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.009 -0400", hash_original_field = "7AF8667D8807CC0C6C91D34D7045E973", hash_generated_field = "5C4F1708189F9DB7CF8C36799A9EB0DC")

    public static final int GET_CONFIGURATIONS = 0x00004000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.009 -0400", hash_original_field = "B1D27D0BA7D0D5D70CB66EE947AC3697", hash_generated_field = "09E41AAC66CFA9D776BBA98350692A92")

    public static final int MATCH_DEFAULT_ONLY   = 0x00010000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.009 -0400", hash_original_field = "2AF2565D59E152CBD290F129F961EBC8", hash_generated_field = "988CB1C84138636A2341ED6D4C04F9CE")

    public static final int PERMISSION_GRANTED = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.009 -0400", hash_original_field = "4694E11EB5B92AB52AAF99C0143F62C2", hash_generated_field = "37A1C5811F9D199DCB56EEFBC8B7C4D2")

    public static final int PERMISSION_DENIED = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.009 -0400", hash_original_field = "91725472BFE0B668E35378E6D71DAAAD", hash_generated_field = "374E488B974AD69BC95B2D0DFDCAE230")

    public static final int SIGNATURE_MATCH = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.009 -0400", hash_original_field = "436FDC3F6172D97F195F00341F2DFE86", hash_generated_field = "30A037B660A5F83E54D18BE8401D85FB")

    public static final int SIGNATURE_NEITHER_SIGNED = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.009 -0400", hash_original_field = "83C0FC2CC940BBDEE51E95B2B7319780", hash_generated_field = "93903F2EE521757BFE482886534B59CB")

    public static final int SIGNATURE_FIRST_NOT_SIGNED = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.009 -0400", hash_original_field = "3B9DDB0280001652A8CC01703E3F717E", hash_generated_field = "FE021ADD6CC79476525AD74C4CDB759E")

    public static final int SIGNATURE_SECOND_NOT_SIGNED = -2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.009 -0400", hash_original_field = "EF36E1F7E5C6694BEEDDE4DE778BCDF1", hash_generated_field = "6E9202516DB101D5B8E2793DC5B76280")

    public static final int SIGNATURE_NO_MATCH = -3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.009 -0400", hash_original_field = "5BB830EC25E75E2C2A7567EE890EAFC6", hash_generated_field = "1B9E62FD34D478215EFCE4AABFB46830")

    public static final int SIGNATURE_UNKNOWN_PACKAGE = -4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.009 -0400", hash_original_field = "F2C955137D1A02DFD1FAD513B4425E7B", hash_generated_field = "72DB62D09405617653662EFE3FEA3110")

    public static final int COMPONENT_ENABLED_STATE_DEFAULT = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.009 -0400", hash_original_field = "2BAC4D275729860CEBAA67D1CDF469AE", hash_generated_field = "76E65EB7818872A36A30E103241A0479")

    public static final int COMPONENT_ENABLED_STATE_ENABLED = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.009 -0400", hash_original_field = "2337712D96CF572D3C86878E4ABAF994", hash_generated_field = "CE4F48389F97C7C47624D919814D1E00")

    public static final int COMPONENT_ENABLED_STATE_DISABLED = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.010 -0400", hash_original_field = "6359512153BBD3F4CCE83F9F4356D9DD", hash_generated_field = "6BB463E712BD6BD23A569CF03E4F870B")

    public static final int COMPONENT_ENABLED_STATE_DISABLED_USER = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.010 -0400", hash_original_field = "10E81E23DA4CD6AA0C77FC6A566750E6", hash_generated_field = "53998F446B97520BCBB4EE0F9378E627")

    public static final int INSTALL_FORWARD_LOCK = 0x00000001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.010 -0400", hash_original_field = "D1BC689A48C7A589010D134775E44EF5", hash_generated_field = "20FDE9811765D69AB2965C00136B8789")

    public static final int INSTALL_REPLACE_EXISTING = 0x00000002;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.010 -0400", hash_original_field = "A0F1ABBBD9CC9955DA941EEE17903F94", hash_generated_field = "7EBFA62E2137E293FB91AA00D096DA03")

    public static final int INSTALL_ALLOW_TEST = 0x00000004;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.010 -0400", hash_original_field = "A505F95415834C329993E29B78C12D7E", hash_generated_field = "E39C569C6D9E6A2F8A237A22B6B11F94")

    public static final int INSTALL_EXTERNAL = 0x00000008;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.010 -0400", hash_original_field = "69A19D0C802CF9F0CA53A48C84EF5A32", hash_generated_field = "5766A98F12F79E80073889BC9A9B89E0")

    public static final int INSTALL_INTERNAL = 0x00000010;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.010 -0400", hash_original_field = "6096C954F144C501CBEC2D89B01C072E", hash_generated_field = "A8D5C996562F61731EC5A89E902A606F")

    public static final int INSTALL_FROM_ADB = 0x00000020;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.010 -0400", hash_original_field = "B3E19BC236E976F6CC0F973093D8490A", hash_generated_field = "017976232B1A2FA8B515853213E669F5")

    public static final int DONT_KILL_APP = 0x00000001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.010 -0400", hash_original_field = "43EFF5EA78F424F13035113BC1655EB4", hash_generated_field = "BB69D3C367BA41FA0137D2D68BB6EDB1")

    public static final int INSTALL_SUCCEEDED = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.010 -0400", hash_original_field = "E0F66E6C45B44BF109277E3BB17DD021", hash_generated_field = "BB002B25BA9F008244A674D5CD097465")

    public static final int INSTALL_FAILED_ALREADY_EXISTS = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.010 -0400", hash_original_field = "A78D6A82D8270FC371E13CCC38AB1EB6", hash_generated_field = "32ADCBE30B6713F77BB7D4CBB3BF9331")

    public static final int INSTALL_FAILED_INVALID_APK = -2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.011 -0400", hash_original_field = "39457C95A081622274BA532836259593", hash_generated_field = "0FB73805AF4C859A2F4D548856CEADF4")

    public static final int INSTALL_FAILED_INVALID_URI = -3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.011 -0400", hash_original_field = "3849FBC0CA8B9961DC5142CBB146153A", hash_generated_field = "783A1EE276B467AFD25E85C442212E8B")

    public static final int INSTALL_FAILED_INSUFFICIENT_STORAGE = -4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.011 -0400", hash_original_field = "E2E1C0B6D442DE6B68D41B113310B90D", hash_generated_field = "DEED5A5820F59FA8CA2B2ECD92FD55D3")

    public static final int INSTALL_FAILED_DUPLICATE_PACKAGE = -5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.011 -0400", hash_original_field = "5E7057C05BCF955DD826A0179AF23504", hash_generated_field = "707BB77C14F03CE7C097E70005742033")

    public static final int INSTALL_FAILED_NO_SHARED_USER = -6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.011 -0400", hash_original_field = "B812A9A494361E811FCABA329B6AE507", hash_generated_field = "60B83E53186015B2A9825FA18656DA92")

    public static final int INSTALL_FAILED_UPDATE_INCOMPATIBLE = -7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.012 -0400", hash_original_field = "9CD5999A5CA9D245210843589CF44BC0", hash_generated_field = "A10BF18CEFC09CCD50B8FC5EDA9D1382")

    public static final int INSTALL_FAILED_SHARED_USER_INCOMPATIBLE = -8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.012 -0400", hash_original_field = "724F080CBBE0D3EE7D73E0B3B508E65A", hash_generated_field = "07096244FD68D8287EDED484DE04A175")

    public static final int INSTALL_FAILED_MISSING_SHARED_LIBRARY = -9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.012 -0400", hash_original_field = "AC4756E1505119C569F9F8621F3CAE1C", hash_generated_field = "C4AB282024E7E7CD3A2100AFE8454CB0")

    public static final int INSTALL_FAILED_REPLACE_COULDNT_DELETE = -10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.012 -0400", hash_original_field = "54937D28C670561B0A55B9EAB88F22A2", hash_generated_field = "8FE02745A657F089401D722E273A9EB1")

    public static final int INSTALL_FAILED_DEXOPT = -11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.012 -0400", hash_original_field = "DE40E109DACD22D91E5C831A04894E6E", hash_generated_field = "296DD98FB4EBE40DF71AAB8363792B1C")

    public static final int INSTALL_FAILED_OLDER_SDK = -12;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.012 -0400", hash_original_field = "2E691445EEC63C9BD2B8E3C2A8DF8FCB", hash_generated_field = "10FD2B841F28F975C4F98674C290F51E")

    public static final int INSTALL_FAILED_CONFLICTING_PROVIDER = -13;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.012 -0400", hash_original_field = "0A580EC044266D0D1E2A833E3F8339A8", hash_generated_field = "77490BB5B251CE3C1A27AF55D0B188D4")

    public static final int INSTALL_FAILED_NEWER_SDK = -14;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.012 -0400", hash_original_field = "DEA301C17F387B5632AC9441D0CA24B8", hash_generated_field = "8D305CE1383E37873D4D1BD5A4B7E8E6")

    public static final int INSTALL_FAILED_TEST_ONLY = -15;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.012 -0400", hash_original_field = "75C86BE12F6B49234F7052FDB776B5CB", hash_generated_field = "96DEA7F6DFB814D87AFCE6EA666BD00A")

    public static final int INSTALL_FAILED_CPU_ABI_INCOMPATIBLE = -16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.013 -0400", hash_original_field = "02A7474C1377A65C183AC767356A0760", hash_generated_field = "5BB31230331D8F3C9D5C02CFEF95722C")

    public static final int INSTALL_FAILED_MISSING_FEATURE = -17;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.013 -0400", hash_original_field = "CFDAD8FB68134AC843B74F1F4F419A26", hash_generated_field = "3D75D78161240CEEF8C35C265D85F46C")

    public static final int INSTALL_FAILED_CONTAINER_ERROR = -18;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.013 -0400", hash_original_field = "B2653E0FDA0B8E34BD7AB5899DD46F7A", hash_generated_field = "4BE142C3D62FB54C919846B431203706")

    public static final int INSTALL_FAILED_INVALID_INSTALL_LOCATION = -19;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.013 -0400", hash_original_field = "C6A753DC2D7408AEFDD0BF8D0CA310FD", hash_generated_field = "AD98C675AA9F8BCA928FD21EECF51815")

    public static final int INSTALL_FAILED_MEDIA_UNAVAILABLE = -20;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.013 -0400", hash_original_field = "FE3BAD780750375441BC4093CA05AA49", hash_generated_field = "D7F60DA01815774353AA878046B6C75C")

    public static final int INSTALL_FAILED_VERIFICATION_TIMEOUT = -21;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.013 -0400", hash_original_field = "C0574D2C57CF314BA971604BB1CC65DC", hash_generated_field = "7CCDB7584449904BF693046A069200BA")

    public static final int INSTALL_FAILED_VERIFICATION_FAILURE = -22;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.013 -0400", hash_original_field = "1A9B74F12C17805BFEFC2BB653139996", hash_generated_field = "E56D811927BC429506BC4E78E921FC57")

    public static final int INSTALL_FAILED_PACKAGE_CHANGED = -23;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.013 -0400", hash_original_field = "FB33F64BD9F776A674C01C1AFA2F860D", hash_generated_field = "6DFA98FEEEC950C10623AE20798D84EA")

    public static final int INSTALL_PARSE_FAILED_NOT_APK = -100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.014 -0400", hash_original_field = "E4495396CA03DB41534D3EED623AA419", hash_generated_field = "B6A3E8C1ACB331579BCBE41909E79354")

    public static final int INSTALL_PARSE_FAILED_BAD_MANIFEST = -101;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.014 -0400", hash_original_field = "73CDE8BD95DFBF58CD5C624C4D3B159A", hash_generated_field = "80CA3A85070074E65A0B64A8C6C69F67")

    public static final int INSTALL_PARSE_FAILED_UNEXPECTED_EXCEPTION = -102;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.014 -0400", hash_original_field = "F41AC8F5F5278DA096AE6E4BB8594B1E", hash_generated_field = "CBD2AA9EB6E1CFF6B67E573A35221C66")

    public static final int INSTALL_PARSE_FAILED_NO_CERTIFICATES = -103;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.014 -0400", hash_original_field = "959F94A45B1AB5C64C44E6DEDA468721", hash_generated_field = "8346AF74F58CE04F687258995BA281EE")

    public static final int INSTALL_PARSE_FAILED_INCONSISTENT_CERTIFICATES = -104;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.014 -0400", hash_original_field = "456AF046AFA4D77163790F43030AA49B", hash_generated_field = "BE348BE8284E1726D7F1AB80DCC2918C")

    public static final int INSTALL_PARSE_FAILED_CERTIFICATE_ENCODING = -105;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.014 -0400", hash_original_field = "ED2E992BBA6AB85E3AFABDDE99E6354A", hash_generated_field = "F10E5708AC29C48BC33EBBF09F712A32")

    public static final int INSTALL_PARSE_FAILED_BAD_PACKAGE_NAME = -106;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.014 -0400", hash_original_field = "208A3A5AA3ACFEED9E18EBB60BE44E63", hash_generated_field = "E6968AD576EC18FB322655D174551AB6")

    public static final int INSTALL_PARSE_FAILED_BAD_SHARED_USER_ID = -107;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.014 -0400", hash_original_field = "E6283BFA722184445233B28550606BBC", hash_generated_field = "BD24EADBCA7980C6DFE0E13CC54A80FC")

    public static final int INSTALL_PARSE_FAILED_MANIFEST_MALFORMED = -108;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.015 -0400", hash_original_field = "DEEC2B24DDF5E9303494A894BEEF134E", hash_generated_field = "B9F24DFB13FCF835F1A03078B5ACBAD3")

    public static final int INSTALL_PARSE_FAILED_MANIFEST_EMPTY = -109;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.015 -0400", hash_original_field = "EE5CA5DB3764330680B4F295D6FED9F6", hash_generated_field = "A60C7F324C871F5772B06A2E6FFC7DA5")

    public static final int INSTALL_FAILED_INTERNAL_ERROR = -110;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.015 -0400", hash_original_field = "3A26535738C7E1984E2D2ACA8226281F", hash_generated_field = "71C388D2290D7462D3B4449437F0426A")

    public static final int DONT_DELETE_DATA = 0x00000001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.015 -0400", hash_original_field = "FB98218931CBFBBC14381B64A4D2CD1F", hash_generated_field = "8E16A0EF46BE9D68C9483C709B30CE43")

    public static final int DELETE_SUCCEEDED = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.015 -0400", hash_original_field = "92E2DD4A0C31140D6B7C7183F50CC430", hash_generated_field = "6DF469509659AC3E527E2FC62F559BC4")

    public static final int DELETE_FAILED_INTERNAL_ERROR = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.015 -0400", hash_original_field = "C8D84DA8B2A84CAFA9ABC1AF18DBC57A", hash_generated_field = "CB8C61D9898E72762977ECE6BB93CFAB")

    public static final int DELETE_FAILED_DEVICE_POLICY_MANAGER = -2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.015 -0400", hash_original_field = "458C01C78833EE05A85B9FCA91502641", hash_generated_field = "460CFF44C0D25B86D8AA467B86A32473")

    public static final int MOVE_SUCCEEDED = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.016 -0400", hash_original_field = "642DA74EF356555ACF51B02854DC454F", hash_generated_field = "339FEBE6E44E2F8C8BDF1A89864C95B7")

    public static final int MOVE_FAILED_INSUFFICIENT_STORAGE = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.016 -0400", hash_original_field = "291E63BAEF17F83DB10A11A11E5DF57C", hash_generated_field = "BE5F3F1F7CD5063D5F1519F2892D74BE")

    public static final int MOVE_FAILED_DOESNT_EXIST = -2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.016 -0400", hash_original_field = "611DC50DA918CB87271638624FA5DF40", hash_generated_field = "73120951BD5FCB046885911A5DFF6513")

    public static final int MOVE_FAILED_SYSTEM_PACKAGE = -3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.016 -0400", hash_original_field = "EE15FD9279E99E9DD7E364A25E43BAD4", hash_generated_field = "72296DA6AACAFCB8200B0736E31BD0D4")

    public static final int MOVE_FAILED_FORWARD_LOCKED = -4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.016 -0400", hash_original_field = "73EA677951EF0AC2629B35342B1D5DA6", hash_generated_field = "783B646465A77C663C30697C00F1383E")

    public static final int MOVE_FAILED_INVALID_LOCATION = -5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.016 -0400", hash_original_field = "265133B6EE06D40D4583CF3C202E5AB9", hash_generated_field = "E7D221D0CF0E9F725AC8E4F4E07D3DDD")

    public static final int MOVE_FAILED_INTERNAL_ERROR = -6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.016 -0400", hash_original_field = "357059074BBF45C5BA405C8EB0D83BC3", hash_generated_field = "3E4D6CFB76A16893C4E0D1E164ABD472")

    public static final int MOVE_FAILED_OPERATION_PENDING = -7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.016 -0400", hash_original_field = "7DC5AF1C5FA5F417A354A58D458DCD15", hash_generated_field = "A2C7D052C499D0CE8F0A041637001867")

    public static final int MOVE_INTERNAL = 0x00000001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.017 -0400", hash_original_field = "0BBA83C172D48388BFE4DB44DBDD4A09", hash_generated_field = "7ADFF79D0D7A5C61C74022EC785CF907")

    public static final int MOVE_EXTERNAL_MEDIA = 0x00000002;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.017 -0400", hash_original_field = "16F0FAE00CCE5F6514278DCA52A6F639", hash_generated_field = "02264E29EDDF21634896C526056CF6FC")

    public static final int VERIFICATION_ALLOW_WITHOUT_SUFFICIENT = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.017 -0400", hash_original_field = "8CDE51468ACA5407A972E21FE80C31A5", hash_generated_field = "AFA7425051348D7B510D3069205362D3")

    public static final int VERIFICATION_ALLOW = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.017 -0400", hash_original_field = "2D03989DBDB46F0F6B9FF283F3618353", hash_generated_field = "34022DE70A515DE4E329D81B6A827921")

    public static final int VERIFICATION_REJECT = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.017 -0400", hash_original_field = "E2D17A9791BE603D935A8A14D5AB42BE", hash_generated_field = "19760B1BECBE8AE0DA1CE2892D69E575")

    public static final int PER_USER_RANGE = 100000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.017 -0400", hash_original_field = "B4E848EC0C96E189DF5BEDEF70D28E38", hash_generated_field = "F40B0809226B8F7AEA4E1DAE11074436")

    @SdkConstant(SdkConstantType.FEATURE)
    public static final String FEATURE_AUDIO_LOW_LATENCY = "android.hardware.audio.low_latency";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.017 -0400", hash_original_field = "DBD094121CFF9DBD595B358FA8935F48", hash_generated_field = "F5A51502F5DB395E72A791DF4F735D96")

    @SdkConstant(SdkConstantType.FEATURE)
    public static final String FEATURE_BLUETOOTH = "android.hardware.bluetooth";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.017 -0400", hash_original_field = "D57CD64890C1C3110FE706D0A58C9DC1", hash_generated_field = "42B0DBE805FF3AC221E9672A762B046B")

    @SdkConstant(SdkConstantType.FEATURE)
    public static final String FEATURE_CAMERA = "android.hardware.camera";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.018 -0400", hash_original_field = "BB5C5EDA5B7EB0FDF88458EAD7308402", hash_generated_field = "BED499DEFED78F4C8FD8943786D054A8")

    @SdkConstant(SdkConstantType.FEATURE)
    public static final String FEATURE_CAMERA_AUTOFOCUS = "android.hardware.camera.autofocus";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.018 -0400", hash_original_field = "83A65A8D908A585BA1BA46A465AD12B8", hash_generated_field = "62631D1D6A02DDFEBB65BB5E9BD73D85")

    @SdkConstant(SdkConstantType.FEATURE)
    public static final String FEATURE_CAMERA_FLASH = "android.hardware.camera.flash";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.018 -0400", hash_original_field = "F1007A42A33844262014E72FEED6E604", hash_generated_field = "784FE6850077DA6773335CAB7A0E760D")

    @SdkConstant(SdkConstantType.FEATURE)
    public static final String FEATURE_CAMERA_FRONT = "android.hardware.camera.front";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.018 -0400", hash_original_field = "85C0CA3ECF4FA1BB370A11D71116F42E", hash_generated_field = "8E53B107D4D4A913E383CB2D0959190A")

    @SdkConstant(SdkConstantType.FEATURE)
    public static final String FEATURE_LOCATION = "android.hardware.location";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.018 -0400", hash_original_field = "94BD51574DDD7AB2D4AF283CBEE9D53B", hash_generated_field = "6C4B204FEAC342C33AD72C7930C23585")

    @SdkConstant(SdkConstantType.FEATURE)
    public static final String FEATURE_LOCATION_GPS = "android.hardware.location.gps";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.018 -0400", hash_original_field = "25B1645E0F284363E1A25F00F8D20D32", hash_generated_field = "DC5C66C537E3A36FCA787E0212D112EF")

    @SdkConstant(SdkConstantType.FEATURE)
    public static final String FEATURE_LOCATION_NETWORK = "android.hardware.location.network";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.018 -0400", hash_original_field = "C8C69EC6225296E6C3C623E9B7A92F66", hash_generated_field = "57F91AEF7408C53E177AE25D9A29ADA5")

    @SdkConstant(SdkConstantType.FEATURE)
    public static final String FEATURE_MICROPHONE = "android.hardware.microphone";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.019 -0400", hash_original_field = "29B245E101D4BB6C84B9C258E548C6F6", hash_generated_field = "33C4CBEC7879D5C75921F891C63CE04D")

    @SdkConstant(SdkConstantType.FEATURE)
    public static final String FEATURE_NFC = "android.hardware.nfc";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.019 -0400", hash_original_field = "1D7B6068F5247A310920FA5D6E5CC25D", hash_generated_field = "09476C5655DA997309C7629BC6D1A0E6")

    @SdkConstant(SdkConstantType.FEATURE)
    public static final String FEATURE_SENSOR_ACCELEROMETER = "android.hardware.sensor.accelerometer";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.019 -0400", hash_original_field = "E306A2A09C35F11903E06555BED13BBE", hash_generated_field = "EABA27C9173195374946E1287734CDA3")

    @SdkConstant(SdkConstantType.FEATURE)
    public static final String FEATURE_SENSOR_BAROMETER = "android.hardware.sensor.barometer";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.019 -0400", hash_original_field = "06A3BDEA19613D6AF104FEC845437BB9", hash_generated_field = "00F40A894817B83CFBF02E6A4E8B4E02")

    @SdkConstant(SdkConstantType.FEATURE)
    public static final String FEATURE_SENSOR_COMPASS = "android.hardware.sensor.compass";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.019 -0400", hash_original_field = "D3536E31D456C260780E62DDFA5F8590", hash_generated_field = "D45DB7C02694E66D636978A92BBB9F62")

    @SdkConstant(SdkConstantType.FEATURE)
    public static final String FEATURE_SENSOR_GYROSCOPE = "android.hardware.sensor.gyroscope";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.019 -0400", hash_original_field = "17A0AB94CD2BEC407D66F6681DF0A2AB", hash_generated_field = "EE2C09358A1A9CF2A5CD70F7C4410659")

    @SdkConstant(SdkConstantType.FEATURE)
    public static final String FEATURE_SENSOR_LIGHT = "android.hardware.sensor.light";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.019 -0400", hash_original_field = "C3449C76E5D37D30460F3B10D8199E47", hash_generated_field = "0986040350A19CDFE3651682ACDFC155")

    @SdkConstant(SdkConstantType.FEATURE)
    public static final String FEATURE_SENSOR_PROXIMITY = "android.hardware.sensor.proximity";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.020 -0400", hash_original_field = "14B1CCF716F67C1382D13ED595913F71", hash_generated_field = "8C7C0DEBAEE0BC7A1541D8E57DA7B677")

    @SdkConstant(SdkConstantType.FEATURE)
    public static final String FEATURE_TELEPHONY = "android.hardware.telephony";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.020 -0400", hash_original_field = "6EE17AC9428CDA266A5118BC571C1439", hash_generated_field = "6FCFF0F1D79DF2AD142C1169F4524C50")

    @SdkConstant(SdkConstantType.FEATURE)
    public static final String FEATURE_TELEPHONY_CDMA = "android.hardware.telephony.cdma";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.020 -0400", hash_original_field = "FCCC9BB74213B85613E209D4C22CFB67", hash_generated_field = "6CA858BFCA7CE3C2D19BD76A4C3DA848")

    @SdkConstant(SdkConstantType.FEATURE)
    public static final String FEATURE_TELEPHONY_GSM = "android.hardware.telephony.gsm";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.020 -0400", hash_original_field = "29C6E4EF7FB48F627804B3EB79544731", hash_generated_field = "1540D489C05587B09BDBD2231F30D55F")

    @SdkConstant(SdkConstantType.FEATURE)
    public static final String FEATURE_USB_HOST = "android.hardware.usb.host";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.020 -0400", hash_original_field = "F6D5FF96E033C0AB0FAE732019489FA1", hash_generated_field = "D29ABD8F1A0DF54A87C1055FB6B26617")

    @SdkConstant(SdkConstantType.FEATURE)
    public static final String FEATURE_USB_ACCESSORY = "android.hardware.usb.accessory";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.020 -0400", hash_original_field = "87D6E0BDF18E4386FE3C883112CF502C", hash_generated_field = "73049EDBF32790E3F15FFD54316557BE")

    @SdkConstant(SdkConstantType.FEATURE)
    public static final String FEATURE_SIP = "android.software.sip";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.020 -0400", hash_original_field = "94F393501A72F6CEC48942669BADBEC8", hash_generated_field = "9CE43AEA56A1EB553D5858563BF8301F")

    @SdkConstant(SdkConstantType.FEATURE)
    public static final String FEATURE_SIP_VOIP = "android.software.sip.voip";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.021 -0400", hash_original_field = "C3146E600361926BFF9BFD7477266C99", hash_generated_field = "B095009CD34BCB3913B8F021EA976502")

    @SdkConstant(SdkConstantType.FEATURE)
    public static final String FEATURE_TOUCHSCREEN = "android.hardware.touchscreen";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.021 -0400", hash_original_field = "7DF89FD5ABE34A6D0D3F8F6DBCA46204", hash_generated_field = "F13B5B25F96611ED5C487ED4442DC358")

    @SdkConstant(SdkConstantType.FEATURE)
    public static final String FEATURE_TOUCHSCREEN_MULTITOUCH = "android.hardware.touchscreen.multitouch";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.021 -0400", hash_original_field = "BA6AB317E4AB6C229602F74C70CF5A0A", hash_generated_field = "49EA9E47D554029311506C87939C6E6A")

    @SdkConstant(SdkConstantType.FEATURE)
    public static final String FEATURE_TOUCHSCREEN_MULTITOUCH_DISTINCT = "android.hardware.touchscreen.multitouch.distinct";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.021 -0400", hash_original_field = "CB3188FB6B47D6F8CDB2672DC7B8715B", hash_generated_field = "2E604502D06002FA0A006E54E38052B1")

    @SdkConstant(SdkConstantType.FEATURE)
    public static final String FEATURE_TOUCHSCREEN_MULTITOUCH_JAZZHAND = "android.hardware.touchscreen.multitouch.jazzhand";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.021 -0400", hash_original_field = "900F3AD35FACF0EC63F4F09F7C9A6029", hash_generated_field = "AB101B8A57280A45FCCC8B3D7FE1F818")

    @SdkConstant(SdkConstantType.FEATURE)
    public static final String FEATURE_FAKETOUCH = "android.hardware.faketouch";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.021 -0400", hash_original_field = "1F85D67A87F592DD04CD03CB60C09520", hash_generated_field = "FA3843B0F5F7B1C8095F7620269AEE88")

    @SdkConstant(SdkConstantType.FEATURE)
    public static final String FEATURE_FAKETOUCH_MULTITOUCH_DISTINCT = "android.hardware.faketouch.multitouch.distinct";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.021 -0400", hash_original_field = "11DDED7AFE0172C82940978090BAF398", hash_generated_field = "AC438248E673B1BC914D9064C9B90FB1")

    @SdkConstant(SdkConstantType.FEATURE)
    public static final String FEATURE_FAKETOUCH_MULTITOUCH_JAZZHAND = "android.hardware.faketouch.multitouch.jazzhand";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.022 -0400", hash_original_field = "7270C5ED7CF5657F15BCF9D50853908E", hash_generated_field = "4A85280867222369BAC4637CFFFE4AA1")

    @SdkConstant(SdkConstantType.FEATURE)
    public static final String FEATURE_SCREEN_PORTRAIT = "android.hardware.screen.portrait";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.022 -0400", hash_original_field = "15ECFBA774EB2FA46821A92DC4087F6F", hash_generated_field = "7B548C708A6F113B02369CFB72671041")

    @SdkConstant(SdkConstantType.FEATURE)
    public static final String FEATURE_SCREEN_LANDSCAPE = "android.hardware.screen.landscape";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.022 -0400", hash_original_field = "2FDC5900E35C8E3DF3D0A3BBC551141C", hash_generated_field = "4E5D7446ED2EEFB03F87289F4E8A59A3")

    @SdkConstant(SdkConstantType.FEATURE)
    public static final String FEATURE_LIVE_WALLPAPER = "android.software.live_wallpaper";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.022 -0400", hash_original_field = "0F19FC924BCE046FBE4B7CCA9701D82A", hash_generated_field = "4A12F73B6CCB099C057FA92A1AA2D3A1")

    @SdkConstant(SdkConstantType.FEATURE)
    public static final String FEATURE_WIFI = "android.hardware.wifi";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.022 -0400", hash_original_field = "8FCBB470169E32F767A8F7AD222D8695", hash_generated_field = "162D9E10FB0EF1F5EFA0DFA74D97C901")

    @SdkConstant(SdkConstantType.FEATURE)
    public static final String FEATURE_WIFI_DIRECT = "android.hardware.wifi.direct";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.022 -0400", hash_original_field = "A98964B176DDBBA47F526AD45F949358", hash_generated_field = "B3378E76ACD49C759DC0A0736DA0650F")

    public static final String ACTION_CLEAN_EXTERNAL_STORAGE
            = "android.content.pm.CLEAN_EXTERNAL_STORAGE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.023 -0400", hash_original_field = "1496B6F33361658584DF735883D68C93", hash_generated_field = "0C2A0E29ECC22F682DDDBE71BA68E9B7")

    public static final String EXTRA_VERIFICATION_URI = "android.content.pm.extra.VERIFICATION_URI";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.023 -0400", hash_original_field = "BD86D0CC529F8210AE909618175D9CD5", hash_generated_field = "B39EF1BF2B6E12B88AB8D3031C594D47")

    public static final String EXTRA_VERIFICATION_ID = "android.content.pm.extra.VERIFICATION_ID";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.023 -0400", hash_original_field = "8A272103AC908AA78C39CF191755073D", hash_generated_field = "C4A1EDF80F08B62CA31478C5A1CF2BA7")

    public static final String EXTRA_VERIFICATION_INSTALLER_PACKAGE
            = "android.content.pm.extra.VERIFICATION_INSTALLER_PACKAGE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.023 -0400", hash_original_field = "159DF723DB4F1395A43C95A2C9268A44", hash_generated_field = "5F2373ECD55441BF328AD51E76A531A6")

    public static final String EXTRA_VERIFICATION_INSTALL_FLAGS
            = "android.content.pm.extra.VERIFICATION_INSTALL_FLAGS";
}

