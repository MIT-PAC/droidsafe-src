package android.content.pm;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

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
    public static final int GET_ACTIVITIES              = 0x00000001;
    public static final int GET_RECEIVERS               = 0x00000002;
    public static final int GET_SERVICES                = 0x00000004;
    public static final int GET_PROVIDERS               = 0x00000008;
    public static final int GET_INSTRUMENTATION         = 0x00000010;
    public static final int GET_INTENT_FILTERS          = 0x00000020;
    public static final int GET_SIGNATURES          = 0x00000040;
    public static final int GET_RESOLVED_FILTER         = 0x00000040;
    public static final int GET_META_DATA               = 0x00000080;
    public static final int GET_GIDS                    = 0x00000100;
    public static final int GET_DISABLED_COMPONENTS     = 0x00000200;
    public static final int GET_SHARED_LIBRARY_FILES    = 0x00000400;
    public static final int GET_URI_PERMISSION_PATTERNS  = 0x00000800;
    public static final int GET_PERMISSIONS               = 0x00001000;
    public static final int GET_UNINSTALLED_PACKAGES = 0x00002000;
    public static final int GET_CONFIGURATIONS = 0x00004000;
    public static final int MATCH_DEFAULT_ONLY   = 0x00010000;
    public static final int PERMISSION_GRANTED = 0;
    public static final int PERMISSION_DENIED = -1;
    public static final int SIGNATURE_MATCH = 0;
    public static final int SIGNATURE_NEITHER_SIGNED = 1;
    public static final int SIGNATURE_FIRST_NOT_SIGNED = -1;
    public static final int SIGNATURE_SECOND_NOT_SIGNED = -2;
    public static final int SIGNATURE_NO_MATCH = -3;
    public static final int SIGNATURE_UNKNOWN_PACKAGE = -4;
    public static final int COMPONENT_ENABLED_STATE_DEFAULT = 0;
    public static final int COMPONENT_ENABLED_STATE_ENABLED = 1;
    public static final int COMPONENT_ENABLED_STATE_DISABLED = 2;
    public static final int COMPONENT_ENABLED_STATE_DISABLED_USER = 3;
    public static final int INSTALL_FORWARD_LOCK = 0x00000001;
    public static final int INSTALL_REPLACE_EXISTING = 0x00000002;
    public static final int INSTALL_ALLOW_TEST = 0x00000004;
    public static final int INSTALL_EXTERNAL = 0x00000008;
    public static final int INSTALL_INTERNAL = 0x00000010;
    public static final int INSTALL_FROM_ADB = 0x00000020;
    public static final int DONT_KILL_APP = 0x00000001;
    public static final int INSTALL_SUCCEEDED = 1;
    public static final int INSTALL_FAILED_ALREADY_EXISTS = -1;
    public static final int INSTALL_FAILED_INVALID_APK = -2;
    public static final int INSTALL_FAILED_INVALID_URI = -3;
    public static final int INSTALL_FAILED_INSUFFICIENT_STORAGE = -4;
    public static final int INSTALL_FAILED_DUPLICATE_PACKAGE = -5;
    public static final int INSTALL_FAILED_NO_SHARED_USER = -6;
    public static final int INSTALL_FAILED_UPDATE_INCOMPATIBLE = -7;
    public static final int INSTALL_FAILED_SHARED_USER_INCOMPATIBLE = -8;
    public static final int INSTALL_FAILED_MISSING_SHARED_LIBRARY = -9;
    public static final int INSTALL_FAILED_REPLACE_COULDNT_DELETE = -10;
    public static final int INSTALL_FAILED_DEXOPT = -11;
    public static final int INSTALL_FAILED_OLDER_SDK = -12;
    public static final int INSTALL_FAILED_CONFLICTING_PROVIDER = -13;
    public static final int INSTALL_FAILED_NEWER_SDK = -14;
    public static final int INSTALL_FAILED_TEST_ONLY = -15;
    public static final int INSTALL_FAILED_CPU_ABI_INCOMPATIBLE = -16;
    public static final int INSTALL_FAILED_MISSING_FEATURE = -17;
    public static final int INSTALL_FAILED_CONTAINER_ERROR = -18;
    public static final int INSTALL_FAILED_INVALID_INSTALL_LOCATION = -19;
    public static final int INSTALL_FAILED_MEDIA_UNAVAILABLE = -20;
    public static final int INSTALL_FAILED_VERIFICATION_TIMEOUT = -21;
    public static final int INSTALL_FAILED_VERIFICATION_FAILURE = -22;
    public static final int INSTALL_FAILED_PACKAGE_CHANGED = -23;
    public static final int INSTALL_PARSE_FAILED_NOT_APK = -100;
    public static final int INSTALL_PARSE_FAILED_BAD_MANIFEST = -101;
    public static final int INSTALL_PARSE_FAILED_UNEXPECTED_EXCEPTION = -102;
    public static final int INSTALL_PARSE_FAILED_NO_CERTIFICATES = -103;
    public static final int INSTALL_PARSE_FAILED_INCONSISTENT_CERTIFICATES = -104;
    public static final int INSTALL_PARSE_FAILED_CERTIFICATE_ENCODING = -105;
    public static final int INSTALL_PARSE_FAILED_BAD_PACKAGE_NAME = -106;
    public static final int INSTALL_PARSE_FAILED_BAD_SHARED_USER_ID = -107;
    public static final int INSTALL_PARSE_FAILED_MANIFEST_MALFORMED = -108;
    public static final int INSTALL_PARSE_FAILED_MANIFEST_EMPTY = -109;
    public static final int INSTALL_FAILED_INTERNAL_ERROR = -110;
    public static final int DONT_DELETE_DATA = 0x00000001;
    public static final int DELETE_SUCCEEDED = 1;
    public static final int DELETE_FAILED_INTERNAL_ERROR = -1;
    public static final int DELETE_FAILED_DEVICE_POLICY_MANAGER = -2;
    public static final int MOVE_SUCCEEDED = 1;
    public static final int MOVE_FAILED_INSUFFICIENT_STORAGE = -1;
    public static final int MOVE_FAILED_DOESNT_EXIST = -2;
    public static final int MOVE_FAILED_SYSTEM_PACKAGE = -3;
    public static final int MOVE_FAILED_FORWARD_LOCKED = -4;
    public static final int MOVE_FAILED_INVALID_LOCATION = -5;
    public static final int MOVE_FAILED_INTERNAL_ERROR = -6;
    public static final int MOVE_FAILED_OPERATION_PENDING = -7;
    public static final int MOVE_INTERNAL = 0x00000001;
    public static final int MOVE_EXTERNAL_MEDIA = 0x00000002;
    public static final int VERIFICATION_ALLOW_WITHOUT_SUFFICIENT = 2;
    public static final int VERIFICATION_ALLOW = 1;
    public static final int VERIFICATION_REJECT = -1;
    public static final int PER_USER_RANGE = 100000;
    @SdkConstant(SdkConstantType.FEATURE)
    public static final String FEATURE_AUDIO_LOW_LATENCY = "android.hardware.audio.low_latency";
    @SdkConstant(SdkConstantType.FEATURE)
    public static final String FEATURE_BLUETOOTH = "android.hardware.bluetooth";
    @SdkConstant(SdkConstantType.FEATURE)
    public static final String FEATURE_CAMERA = "android.hardware.camera";
    @SdkConstant(SdkConstantType.FEATURE)
    public static final String FEATURE_CAMERA_AUTOFOCUS = "android.hardware.camera.autofocus";
    @SdkConstant(SdkConstantType.FEATURE)
    public static final String FEATURE_CAMERA_FLASH = "android.hardware.camera.flash";
    @SdkConstant(SdkConstantType.FEATURE)
    public static final String FEATURE_CAMERA_FRONT = "android.hardware.camera.front";
    @SdkConstant(SdkConstantType.FEATURE)
    public static final String FEATURE_LOCATION = "android.hardware.location";
    @SdkConstant(SdkConstantType.FEATURE)
    public static final String FEATURE_LOCATION_GPS = "android.hardware.location.gps";
    @SdkConstant(SdkConstantType.FEATURE)
    public static final String FEATURE_LOCATION_NETWORK = "android.hardware.location.network";
    @SdkConstant(SdkConstantType.FEATURE)
    public static final String FEATURE_MICROPHONE = "android.hardware.microphone";
    @SdkConstant(SdkConstantType.FEATURE)
    public static final String FEATURE_NFC = "android.hardware.nfc";
    @SdkConstant(SdkConstantType.FEATURE)
    public static final String FEATURE_SENSOR_ACCELEROMETER = "android.hardware.sensor.accelerometer";
    @SdkConstant(SdkConstantType.FEATURE)
    public static final String FEATURE_SENSOR_BAROMETER = "android.hardware.sensor.barometer";
    @SdkConstant(SdkConstantType.FEATURE)
    public static final String FEATURE_SENSOR_COMPASS = "android.hardware.sensor.compass";
    @SdkConstant(SdkConstantType.FEATURE)
    public static final String FEATURE_SENSOR_GYROSCOPE = "android.hardware.sensor.gyroscope";
    @SdkConstant(SdkConstantType.FEATURE)
    public static final String FEATURE_SENSOR_LIGHT = "android.hardware.sensor.light";
    @SdkConstant(SdkConstantType.FEATURE)
    public static final String FEATURE_SENSOR_PROXIMITY = "android.hardware.sensor.proximity";
    @SdkConstant(SdkConstantType.FEATURE)
    public static final String FEATURE_TELEPHONY = "android.hardware.telephony";
    @SdkConstant(SdkConstantType.FEATURE)
    public static final String FEATURE_TELEPHONY_CDMA = "android.hardware.telephony.cdma";
    @SdkConstant(SdkConstantType.FEATURE)
    public static final String FEATURE_TELEPHONY_GSM = "android.hardware.telephony.gsm";
    @SdkConstant(SdkConstantType.FEATURE)
    public static final String FEATURE_USB_HOST = "android.hardware.usb.host";
    @SdkConstant(SdkConstantType.FEATURE)
    public static final String FEATURE_USB_ACCESSORY = "android.hardware.usb.accessory";
    @SdkConstant(SdkConstantType.FEATURE)
    public static final String FEATURE_SIP = "android.software.sip";
    @SdkConstant(SdkConstantType.FEATURE)
    public static final String FEATURE_SIP_VOIP = "android.software.sip.voip";
    @SdkConstant(SdkConstantType.FEATURE)
    public static final String FEATURE_TOUCHSCREEN = "android.hardware.touchscreen";
    @SdkConstant(SdkConstantType.FEATURE)
    public static final String FEATURE_TOUCHSCREEN_MULTITOUCH = "android.hardware.touchscreen.multitouch";
    @SdkConstant(SdkConstantType.FEATURE)
    public static final String FEATURE_TOUCHSCREEN_MULTITOUCH_DISTINCT = "android.hardware.touchscreen.multitouch.distinct";
    @SdkConstant(SdkConstantType.FEATURE)
    public static final String FEATURE_TOUCHSCREEN_MULTITOUCH_JAZZHAND = "android.hardware.touchscreen.multitouch.jazzhand";
    @SdkConstant(SdkConstantType.FEATURE)
    public static final String FEATURE_FAKETOUCH = "android.hardware.faketouch";
    @SdkConstant(SdkConstantType.FEATURE)
    public static final String FEATURE_FAKETOUCH_MULTITOUCH_DISTINCT = "android.hardware.faketouch.multitouch.distinct";
    @SdkConstant(SdkConstantType.FEATURE)
    public static final String FEATURE_FAKETOUCH_MULTITOUCH_JAZZHAND = "android.hardware.faketouch.multitouch.jazzhand";
    @SdkConstant(SdkConstantType.FEATURE)
    public static final String FEATURE_SCREEN_PORTRAIT = "android.hardware.screen.portrait";
    @SdkConstant(SdkConstantType.FEATURE)
    public static final String FEATURE_SCREEN_LANDSCAPE = "android.hardware.screen.landscape";
    @SdkConstant(SdkConstantType.FEATURE)
    public static final String FEATURE_LIVE_WALLPAPER = "android.software.live_wallpaper";
    @SdkConstant(SdkConstantType.FEATURE)
    public static final String FEATURE_WIFI = "android.hardware.wifi";
    @SdkConstant(SdkConstantType.FEATURE)
    public static final String FEATURE_WIFI_DIRECT = "android.hardware.wifi.direct";
    public static final String ACTION_CLEAN_EXTERNAL_STORAGE
            = "android.content.pm.CLEAN_EXTERNAL_STORAGE";
    public static final String EXTRA_VERIFICATION_URI = "android.content.pm.extra.VERIFICATION_URI";
    public static final String EXTRA_VERIFICATION_ID = "android.content.pm.extra.VERIFICATION_ID";
    public static final String EXTRA_VERIFICATION_INSTALLER_PACKAGE
            = "android.content.pm.extra.VERIFICATION_INSTALLER_PACKAGE";
    public static final String EXTRA_VERIFICATION_INSTALL_FLAGS
            = "android.content.pm.extra.VERIFICATION_INSTALL_FLAGS";
    
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.126 -0400", hash_original_method = "DBC2C646566E0B22A2FF91F44F8D10B2", hash_generated_method = "42C2F2E5D1F6D9DAF856F9EB979D40EF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PackageInfo getPackageArchiveInfo(String archiveFilePath, int flags) {
        dsTaint.addTaint(archiveFilePath);
        dsTaint.addTaint(flags);
        PackageParser packageParser;
        packageParser = new PackageParser(archiveFilePath);
        DisplayMetrics metrics;
        metrics = new DisplayMetrics();
        metrics.setToDefaults();
        final File sourceFile;
        sourceFile = new File(archiveFilePath);
        PackageParser.Package pkg;
        pkg = packageParser.parsePackage(
                sourceFile, archiveFilePath, metrics, 0);
        {
            packageParser.collectCertificates(pkg, 0);
        } //End block
        PackageInfo var4D7D962C79FDE670E8C17D8839CD7A67_880104124 = (PackageParser.generatePackageInfo(pkg, null, flags, 0, 0));
        return (PackageInfo)dsTaint.getTaint();
        // ---------- Original Method ----------
        //PackageParser packageParser = new PackageParser(archiveFilePath);
        //DisplayMetrics metrics = new DisplayMetrics();
        //metrics.setToDefaults();
        //final File sourceFile = new File(archiveFilePath);
        //PackageParser.Package pkg = packageParser.parsePackage(
                //sourceFile, archiveFilePath, metrics, 0);
        //if (pkg == null) {
            //return null;
        //}
        //if ((flags & GET_SIGNATURES) != 0) {
            //packageParser.collectCertificates(pkg, 0);
        //}
        //return PackageParser.generatePackageInfo(pkg, null, flags, 0, 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.127 -0400", hash_original_method = "C886A1F4AC1BEA7F445F1AC60A095F6B", hash_generated_method = "747D4FECDA5081F50BA85A7F0D4DE332")
    public static boolean isSameUser(int uid1, int uid2) {
        return getUserId(uid1) == getUserId(uid2);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.128 -0400", hash_original_method = "A84CBDAF203E04C37517B2B049D94324", hash_generated_method = "D2325F46628B29CBA677598D94A5C588")
    public static int getUserId(int uid) {
        return uid / PER_USER_RANGE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.128 -0400", hash_original_method = "4C3A46A3FD3C2F319FC729999FF73ED4", hash_generated_method = "038F21D5B375C0A0BD5391702E1E366F")
    public static int getUid(int userId, int appId) {
        return userId * PER_USER_RANGE + (appId % PER_USER_RANGE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.128 -0400", hash_original_method = "B1083B466D22A889839A58AF9FE9DF65", hash_generated_method = "4634241AF1FCC7FC78418BBA9F8EAE0C")
    public static int getAppId(int uid) {
        return uid % PER_USER_RANGE;
    }

    
    public abstract VerifierDeviceIdentity getVerifierDeviceIdentity();

    
    public static class NameNotFoundException extends AndroidException {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.128 -0400", hash_original_method = "4C893FF4D2386A2E528254CA81C36065", hash_generated_method = "638E48CEC9073BC158D3F913522A4332")
        @DSModeled(DSC.SAFE)
        public NameNotFoundException() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.128 -0400", hash_original_method = "16889A22D22FB47C54F1114D13EC0BEF", hash_generated_method = "CFC250E405DBE5CA12DEC095C25A69E2")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public NameNotFoundException(String name) {
            super(name);
            dsTaint.addTaint(name);
            // ---------- Original Method ----------
        }

        
    }


    
}


