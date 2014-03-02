package android.os;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.File;

import android.os.storage.IMountService;
import android.os.storage.StorageVolume;
import android.util.Log;

public class Environment {

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:43.740 -0500", hash_original_method = "49D276246FC7889A9B561CCBB290F80E", hash_generated_method = "75573CFB29C81F706693B5B5C0544A51")
    
private static StorageVolume getPrimaryVolume() {
        if (mPrimaryVolume == null) {
            synchronized (mLock) {
                if (mPrimaryVolume == null) {
                    try {
                        IMountService mountService = IMountService.Stub.asInterface(ServiceManager
                                .getService("mount"));
                        Parcelable[] volumes = mountService.getVolumeList();
                        mPrimaryVolume = (StorageVolume)volumes[0];
                    } catch (Exception e) {
                        Log.e(TAG, "couldn't talk to MountService", e);
                    }
                }
            }
        }
        return mPrimaryVolume;
    }

    /**
     * Gets the Android root directory.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:43.742 -0500", hash_original_method = "23501762B1C83E6EA646AAE54FEFC03E", hash_generated_method = "E43BC8BEDB5505F06F4FFC2211137866")
    
public static File getRootDirectory() {
        return ROOT_DIRECTORY;
    }

    /**
     * Gets the system directory available for secure storage.
     * If Encrypted File system is enabled, it returns an encrypted directory (/data/secure/system).
     * Otherwise, it returns the unencrypted /data/system directory.
     * @return File object representing the secure storage system directory.
     * @hide
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:43.744 -0500", hash_original_method = "A1EAA5ECD195432112B5EB9DA9261C3B", hash_generated_method = "E43A118490065B4DD32E72296F941023")
    
public static File getSystemSecureDirectory() {
        if (isEncryptedFilesystemEnabled()) {
            return new File(SECURE_DATA_DIRECTORY, "system");
        } else {
            return new File(DATA_DIRECTORY, "system");
        }
    }

    /**
     * Gets the data directory for secure storage.
     * If Encrypted File system is enabled, it returns an encrypted directory (/data/secure).
     * Otherwise, it returns the unencrypted /data directory.
     * @return File object representing the data directory for secure storage.
     * @hide
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:43.747 -0500", hash_original_method = "93F27DEF70C79E666A71BBC6D537D555", hash_generated_method = "5C7410E3F0E06A45F082834F41C2C79E")
    
public static File getSecureDataDirectory() {
        if (isEncryptedFilesystemEnabled()) {
            return SECURE_DATA_DIRECTORY;
        } else {
            return DATA_DIRECTORY;
        }
    }

    @DSVerified
    @DSSafe(DSCat.SAFE_OTHERS)
    public static String  getStorageState(String path) {
        return "<storage-state-of{" + path + "}>";
    }

    /**
     * Returns whether the Encrypted File System feature is enabled on the device or not.
     * @return <code>true</code> if Encrypted File System feature is enabled, <code>false</code>
     * if disabled.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:43.749 -0500", hash_original_method = "11B95004E66CA25E019ACFB4385C511B", hash_generated_method = "11F57C26AF426CB557A303F7133CD963")
    
public static boolean isEncryptedFilesystemEnabled() {
        return SystemProperties.getBoolean(SYSTEM_PROPERTY_EFS_ENABLED, false);
    }

    /**
     * Gets the Android data directory.
     */
    @DSComment("Method returns IO Object")
    @DSSpec(DSCat.IO)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:43.769 -0500", hash_original_method = "410798574B14A1C7B2300F72C09D29B0", hash_generated_method = "2BC6B0A3FA5E9006E8139DE601FB8544")
    
public static File getDataDirectory() {
        return DATA_DIRECTORY;
    }

    /**
     * Gets the Android external storage directory.  This directory may not
     * currently be accessible if it has been mounted by the user on their
     * computer, has been removed from the device, or some other problem has
     * happened.  You can determine its current state with
     * {@link #getExternalStorageState()}.
     * 
     * <p><em>Note: don't be confused by the word "external" here.  This
     * directory can better be thought as media/shared storage.  It is a
     * filesystem that can hold a relatively large amount of data and that
     * is shared across all applications (does not enforce permissions).
     * Traditionally this is an SD card, but it may also be implemented as
     * built-in storage in a device that is distinct from the protected
     * internal storage and can be mounted as a filesystem on a computer.</em></p>
     *
     * <p>In devices with multiple "external" storage directories (such as
     * both secure app storage and mountable shared storage), this directory
     * represents the "primary" external storage that the user will interact
     * with.</p>
     *
     * <p>Applications should not directly use this top-level directory, in
     * order to avoid polluting the user's root namespace.  Any files that are
     * private to the application should be placed in a directory returned
     * by {@link android.content.Context#getExternalFilesDir
     * Context.getExternalFilesDir}, which the system will take care of deleting
     * if the application is uninstalled.  Other shared files should be placed
     * in one of the directories returned by
     * {@link #getExternalStoragePublicDirectory}.
     * 
     * <p>Here is an example of typical code to monitor the state of
     * external storage:</p>
     * 
     * {@sample development/samples/ApiDemos/src/com/example/android/apis/content/ExternalStorage.java
     * monitor_storage}
     *
     * @see #getExternalStorageState()
     * @see #isExternalStorageRemovable()
     */
    @DSComment("Method returns IO Object")
    @DSSafe(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:43.771 -0500", hash_original_method = "5C670B147F567F755C94F9F92181BB98", hash_generated_method = "B877242D587754ED3BC1634CE142E9AB")    
public static File getExternalStorageDirectory() {
        return EXTERNAL_STORAGE_DIRECTORY;
    }
    
    @DSComment("Method returns IO Object")
    @DSSafe(DSCat.IO)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public static File getExternalStoragePublicDirectory(String type) {
        return new File("mnt/sdcard");
    }

    /**
     * Returns the path for android-specific data on the SD card.
     * @hide
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:43.795 -0500", hash_original_method = "1DD329D955C5FBEF29FAACA1E44D1180", hash_generated_method = "93E5C19880DFB62649D3056ED9CB44FF")
    
public static File getExternalStorageAndroidDataDir() {
        return EXTERNAL_STORAGE_ANDROID_DATA_DIRECTORY;
    }
    
    /**
     * Generates the raw path to an application's data
     * @hide
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:43.798 -0500", hash_original_method = "40277F291B5A8E4B36A828D8C3A376B5", hash_generated_method = "B2093C2CE72C762DD80A4DF1A3C1EE0E")
    
public static File getExternalStorageAppDataDirectory(String packageName) {
        return new File(EXTERNAL_STORAGE_ANDROID_DATA_DIRECTORY, packageName);
    }
    
    /**
     * Generates the raw path to an application's media
     * @hide
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:43.801 -0500", hash_original_method = "55172197BB94D25451E63EEA35B16A56", hash_generated_method = "A2210D47B6756B51837CF8733C831890")
    
public static File getExternalStorageAppMediaDirectory(String packageName) {
        return new File(EXTERNAL_STORAGE_ANDROID_MEDIA_DIRECTORY, packageName);
    }
    
    /**
     * Generates the raw path to an application's OBB files
     * @hide
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:43.803 -0500", hash_original_method = "133F5560A13C528822A145DDB5A18A92", hash_generated_method = "CF335B360D815D46F5C1D95E46D097B6")
    
public static File getExternalStorageAppObbDirectory(String packageName) {
        return new File(EXTERNAL_STORAGE_ANDROID_OBB_DIRECTORY, packageName);
    }
    
    /**
     * Generates the path to an application's files.
     * @hide
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:43.805 -0500", hash_original_method = "050DBA7CC8565F34A0E9A00648CA002C", hash_generated_method = "54C17CF5A140720711F3A61262ACCD6F")
    
public static File getExternalStorageAppFilesDirectory(String packageName) {
        return new File(new File(EXTERNAL_STORAGE_ANDROID_DATA_DIRECTORY,
                packageName), "files");
    }
    
    /**
     * Generates the path to an application's cache.
     * @hide
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:43.807 -0500", hash_original_method = "C91E73381DEC6DAFD22AD517D132DDB1", hash_generated_method = "D07178151FABF1234633D29ADC19979E")
    
public static File getExternalStorageAppCacheDirectory(String packageName) {
        return new File(new File(EXTERNAL_STORAGE_ANDROID_DATA_DIRECTORY,
                packageName), "cache");
    }
    
    /**
     * Gets the Android Download/Cache content directory.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:43.809 -0500", hash_original_method = "6C75CA3DA6425F473E9521EDF00E3AB4", hash_generated_method = "9E0FC6ADABAC3C59AE1F8E07A09E45A4")
    
public static File getDownloadCacheDirectory() {
        return DOWNLOAD_CACHE_DIRECTORY;
    }

    /**
     * Gets the current state of the primary "external" storage device.
     * 
     * <p>See {@link #getExternalStorageDirectory()} for more information.
     */
    @DSSpec(DSCat.STORAGE_STATE)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:43.832 -0500", hash_original_method = "BEB54D71784BB9886D2BD75DEB648BB3", hash_generated_method = "35AF323F642F3C48729D391565433D5F")
    
public static String getExternalStorageState() {
        try {
            IMountService mountService = IMountService.Stub.asInterface(ServiceManager
                    .getService("mount"));
            return mountService.getVolumeState(getExternalStorageDirectory()
                    .toString());
        } catch (Exception rex) {
            return Environment.MEDIA_REMOVED;
        }
    }

    /**
     * Returns whether the primary "external" storage device is removable.
     * If true is returned, this device is for example an SD card that the
     * user can remove.  If false is returned, the storage is built into
     * the device and can not be physically removed.
     *
     * <p>See {@link #getExternalStorageDirectory()} for more information.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:43.835 -0500", hash_original_method = "D9D125D0D896B97B282353A8522D6FA4", hash_generated_method = "B2C890FEF08EC181B35007569CFAA9B1")
    
public static boolean isExternalStorageRemovable() {
        StorageVolume volume = getPrimaryVolume();
        return (volume != null && volume.isRemovable());
    }

    /**
     * Returns whether the device has an external storage device which is
     * emulated. If true, the device does not have real external storage, and the directory
     * returned by {@link #getExternalStorageDirectory()} will be allocated using a portion of
     * the internal storage system.
     *
     * <p>Certain system services, such as the package manager, use this
     * to determine where to install an application.
     *
     * <p>Emulated external storage may also be encrypted - see
     * {@link android.app.admin.DevicePolicyManager#setStorageEncryption(
     * android.content.ComponentName, boolean)} for additional details.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:43.837 -0500", hash_original_method = "A3DF8384968B84A72A4806B896C940F5", hash_generated_method = "0061A94CD6FA894913DF2C9BCC4C9F67")
    
public static boolean isExternalStorageEmulated() {
        StorageVolume volume = getPrimaryVolume();
        return (volume != null && volume.isEmulated());
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:43.840 -0500", hash_original_method = "9C53479BCA8A1AAF4BCF134D9ED07471", hash_generated_method = "966E08026B8F34CEDCCDC647ABF4FCA3")
    
static File getDirectory(String variableName, String defaultPath) {
        String path = System.getenv(variableName);
        return path == null ? new File(defaultPath) : new File(path);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:43.728 -0500", hash_original_field = "19DFD0BD906618E3FD0427B9A5833E7C", hash_generated_field = "F91F1982BA049077D1EE09AA2045B613")

    private static final String TAG = "Environment";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:43.731 -0500", hash_original_field = "85AB27342DCABB6BA155402D18B2289D", hash_generated_field = "FE08AA822266DAF98C9F2274AD45AF9E")

    private static final File ROOT_DIRECTORY
            = getDirectory("ANDROID_ROOT", "/system");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:43.733 -0500", hash_original_field = "F8F01D8EA17D83A2B038EE9E2DF5D3DE", hash_generated_field = "EE3FE0CAF4E93AB133014AF996B70CCE")

    private static final String SYSTEM_PROPERTY_EFS_ENABLED = "persist.security.efs.enabled";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:43.735 -0500", hash_original_field = "83DB9DCBBD2D99A708D9A1934D5CD5AB", hash_generated_field = "CA3747CC2EC4B1C7DB6ABC7879C88A34")

    private static final Object mLock = new Object();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:43.737 -0500", hash_original_field = "07CD2CFF9309E5BF864753B6E6F8D7BD", hash_generated_field = "BE2642BFD28BEEB7B21B6346504CF160")

    private volatile static StorageVolume mPrimaryVolume = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:43.943 -0400", hash_original_field = "ABD2DC3A68E7E273F00286BB6E564846", hash_generated_field = "4859F8047AF82464AD430C6BD0B6CE29")

    private static final File DATA_DIRECTORY = new File("/data");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:43.943 -0400", hash_original_field = "3F61A3C438E0DF8566DCC4F749E369A4", hash_generated_field = "C6ADCEB630E1DE7BE8C3111429988817")

    private static final File SECURE_DATA_DIRECTORY = new File("/data/secure");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:43.943 -0400", hash_original_field = "F6750F49ABC2B48E79913450F0FBEB71", hash_generated_field = "265692B8C815542986C5D1C47C8A516C")

    private static final File EXTERNAL_STORAGE_DIRECTORY = new File("/mnt/sdcard");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:43.943 -0400", hash_original_field = "CEC4B98703B1F5079D7526CB8C9836A1", hash_generated_field = "43621C6B88A374CEBF6446E7926E8652")

    private static final File EXTERNAL_STORAGE_ANDROID_DATA_DIRECTORY = new File ("/mnt/sdcard/Android/data");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:43.943 -0400", hash_original_field = "3BA9A346DFEE82C8778D8240922DE757", hash_generated_field = "AD65A5FB28B34137240B3B2C48DF6C20")

    private static final File EXTERNAL_STORAGE_ANDROID_MEDIA_DIRECTORY = new File ("/mnt/sdcard/Android/media");
                    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:43.944 -0400", hash_original_field = "F2DEA7505FDFA748D1FACEDA5EE74EE2", hash_generated_field = "ED045C15D4C606594CB4CE468299A66D")

    private static final File EXTERNAL_STORAGE_ANDROID_OBB_DIRECTORY = new File ("/mnt/sdcard/Android/obb");  
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:43.944 -0400", hash_original_field = "C014CD980A9B8BE92DC94186EA778D96", hash_generated_field = "4667E2C8EB83B2183E1EAA45E9576E1D")

    private static final File DOWNLOAD_CACHE_DIRECTORY = new File("/cache");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:43.773 -0500", hash_original_field = "22C7F1432F3DB7A0CDDD1B0B2FA1DCBE", hash_generated_field = "EE29BEDB52B1554E0771529A5D3A8E48")

    public static String DIRECTORY_MUSIC = "Music";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:43.776 -0500", hash_original_field = "E53D77597E32E73CBE1C4324F65BB06E", hash_generated_field = "0685015847EB4A3D4AD8E7993748B6E8")

    public static String DIRECTORY_PODCASTS = "Podcasts";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:43.778 -0500", hash_original_field = "6785F0B5846CD307101324CE45BCBD21", hash_generated_field = "9CB97771535D9E25A3A0FDA673548158")

    public static String DIRECTORY_RINGTONES = "Ringtones";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:43.780 -0500", hash_original_field = "103266997825F683E0D80C38C1C57AA1", hash_generated_field = "F057EDF5681571C9DBB44E0A0AA83E97")

    public static String DIRECTORY_ALARMS = "Alarms";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:43.782 -0500", hash_original_field = "C74B63EF9908FEA5D03E3C1BC67C6DDD", hash_generated_field = "19309F433A2615F682F53C35E8A631A5")

    public static String DIRECTORY_NOTIFICATIONS = "Notifications";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:43.784 -0500", hash_original_field = "F8DAC741445904D601F007669BC002F2", hash_generated_field = "FFC46A6EB1C0E6B1164AD7F94DB895B8")

    public static String DIRECTORY_PICTURES = "Pictures";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:43.786 -0500", hash_original_field = "8930AB88AA48A95A78577636AFB5BAE3", hash_generated_field = "8F92BD677CADD21CFD388A2803DB452F")

    public static String DIRECTORY_MOVIES = "Movies";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:43.788 -0500", hash_original_field = "70D510E93669E1EE8AFAF3A349CD9BE6", hash_generated_field = "C8759A2F9F0F9F8FCC08291D89701E33")

    public static String DIRECTORY_DOWNLOADS = "Download";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:43.791 -0500", hash_original_field = "F84E5AC276E615B97334363B16C2CBAD", hash_generated_field = "206F92563619BD2D186D2544136D04C8")

    public static String DIRECTORY_DCIM = "DCIM";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:43.812 -0500", hash_original_field = "C59CC6840299CDB59B97D8C1F68B51DF", hash_generated_field = "37113F74E8E054A63E405E0ADA834CEB")

    public static final String MEDIA_REMOVED = "removed";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:43.814 -0500", hash_original_field = "00D3B11911D768BD16CCD8B597F4024C", hash_generated_field = "E9FAA44C9791BA7D741A575FFB45F032")

    public static final String MEDIA_UNMOUNTED = "unmounted";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:43.816 -0500", hash_original_field = "10C20A7662A9AF326B432DE20C9D5A5E", hash_generated_field = "042438C52ECFA2824AAF3CA9CDE37D50")

    public static final String MEDIA_CHECKING = "checking";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:43.819 -0500", hash_original_field = "CC91638F309030ADF16D9535B2EB5C11", hash_generated_field = "38AA20E914B9AAD98CFC8C46F05BA2A5")

    public static final String MEDIA_NOFS = "nofs";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:43.821 -0500", hash_original_field = "83C36330A8660B72EA11849050AB579F", hash_generated_field = "1F6D368F0292E0B8A9F91D45F8D566B0")

    public static final String MEDIA_MOUNTED = "mounted";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:43.824 -0500", hash_original_field = "6609FC04612A01AE43B5BA2E6944F726", hash_generated_field = "8CB035758AAC9D9B4FFDCDA773CC93F5")

    public static final String MEDIA_MOUNTED_READ_ONLY = "mounted_ro";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:43.826 -0500", hash_original_field = "4898A615225DA03923BBC5D916116C3C", hash_generated_field = "13A8DF508A9AA9E8BC667C5B778EBDE8")

    public static final String MEDIA_SHARED = "shared";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:43.828 -0500", hash_original_field = "ABBA7038D6CF071B97AA422478434828", hash_generated_field = "31324D4BCFDD7B522D73E10831EBFFC7")

    public static final String MEDIA_BAD_REMOVAL = "bad_removal";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:43.830 -0500", hash_original_field = "7A27F5E3E9BE45F156E2CCB7A48D5B40", hash_generated_field = "00F588D9D8843A2FCFEE67842241EF18")

    public static final String MEDIA_UNMOUNTABLE = "unmountable";
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:43.936 -0400", hash_original_method = "241E3402842314122858FA6ADB8EF111", hash_generated_method = "241E3402842314122858FA6ADB8EF111")
    public Environment ()
    {
        //Synthesized constructor
    }
}

