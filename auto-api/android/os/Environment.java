package android.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.content.res.Resources;
import android.os.storage.IMountService;
import android.os.storage.StorageVolume;
import android.util.Log;
import java.io.File;

public class Environment {
    private static final String TAG = "Environment";
    private static final File ROOT_DIRECTORY
            = getDirectory("ANDROID_ROOT", "/system");
    private static final String SYSTEM_PROPERTY_EFS_ENABLED = "persist.security.efs.enabled";
    private static final Object mLock = new Object();
    private volatile static StorageVolume mPrimaryVolume = null;
    private static final File DATA_DIRECTORY
            = getDirectory("ANDROID_DATA", "/data");
    private static final File SECURE_DATA_DIRECTORY
            = getDirectory("ANDROID_SECURE_DATA", "/data/secure");
    private static final File EXTERNAL_STORAGE_DIRECTORY
            = getDirectory("EXTERNAL_STORAGE", "/mnt/sdcard");
    private static final File EXTERNAL_STORAGE_ANDROID_DATA_DIRECTORY
            = new File (new File(getDirectory("EXTERNAL_STORAGE", "/mnt/sdcard"),
                    "Android"), "data");
    private static final File EXTERNAL_STORAGE_ANDROID_MEDIA_DIRECTORY
            = new File (new File(getDirectory("EXTERNAL_STORAGE", "/mnt/sdcard"),
                    "Android"), "media");
    private static final File EXTERNAL_STORAGE_ANDROID_OBB_DIRECTORY
            = new File (new File(getDirectory("EXTERNAL_STORAGE", "/mnt/sdcard"),
                    "Android"), "obb");
    private static final File DOWNLOAD_CACHE_DIRECTORY
            = getDirectory("DOWNLOAD_CACHE", "/cache");
    public static String DIRECTORY_MUSIC = "Music";
    public static String DIRECTORY_PODCASTS = "Podcasts";
    public static String DIRECTORY_RINGTONES = "Ringtones";
    public static String DIRECTORY_ALARMS = "Alarms";
    public static String DIRECTORY_NOTIFICATIONS = "Notifications";
    public static String DIRECTORY_PICTURES = "Pictures";
    public static String DIRECTORY_MOVIES = "Movies";
    public static String DIRECTORY_DOWNLOADS = "Download";
    public static String DIRECTORY_DCIM = "DCIM";
    public static final String MEDIA_REMOVED = "removed";
    public static final String MEDIA_UNMOUNTED = "unmounted";
    public static final String MEDIA_CHECKING = "checking";
    public static final String MEDIA_NOFS = "nofs";
    public static final String MEDIA_MOUNTED = "mounted";
    public static final String MEDIA_MOUNTED_READ_ONLY = "mounted_ro";
    public static final String MEDIA_SHARED = "shared";
    public static final String MEDIA_BAD_REMOVAL = "bad_removal";
    public static final String MEDIA_UNMOUNTABLE = "unmountable";
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.611 -0400", hash_original_method = "49D276246FC7889A9B561CCBB290F80E", hash_generated_method = "75573CFB29C81F706693B5B5C0544A51")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.611 -0400", hash_original_method = "23501762B1C83E6EA646AAE54FEFC03E", hash_generated_method = "E43BC8BEDB5505F06F4FFC2211137866")
    public static File getRootDirectory() {
        return ROOT_DIRECTORY;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.611 -0400", hash_original_method = "A1EAA5ECD195432112B5EB9DA9261C3B", hash_generated_method = "E43A118490065B4DD32E72296F941023")
    public static File getSystemSecureDirectory() {
        if (isEncryptedFilesystemEnabled()) {
            return new File(SECURE_DATA_DIRECTORY, "system");
        } else {
            return new File(DATA_DIRECTORY, "system");
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.612 -0400", hash_original_method = "93F27DEF70C79E666A71BBC6D537D555", hash_generated_method = "5C7410E3F0E06A45F082834F41C2C79E")
    public static File getSecureDataDirectory() {
        if (isEncryptedFilesystemEnabled()) {
            return SECURE_DATA_DIRECTORY;
        } else {
            return DATA_DIRECTORY;
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.612 -0400", hash_original_method = "11B95004E66CA25E019ACFB4385C511B", hash_generated_method = "11F57C26AF426CB557A303F7133CD963")
    public static boolean isEncryptedFilesystemEnabled() {
        return SystemProperties.getBoolean(SYSTEM_PROPERTY_EFS_ENABLED, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.612 -0400", hash_original_method = "410798574B14A1C7B2300F72C09D29B0", hash_generated_method = "2BC6B0A3FA5E9006E8139DE601FB8544")
    public static File getDataDirectory() {
        return DATA_DIRECTORY;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.612 -0400", hash_original_method = "5C670B147F567F755C94F9F92181BB98", hash_generated_method = "B877242D587754ED3BC1634CE142E9AB")
    public static File getExternalStorageDirectory() {
        return EXTERNAL_STORAGE_DIRECTORY;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.612 -0400", hash_original_method = "27258A2DA0B180EBA508FB2F515265DC", hash_generated_method = "7E0D28A14D81ADF72C2BEDAB781349CB")
    public static File getExternalStoragePublicDirectory(String type) {
        return new File(getExternalStorageDirectory(), type);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.612 -0400", hash_original_method = "1DD329D955C5FBEF29FAACA1E44D1180", hash_generated_method = "93E5C19880DFB62649D3056ED9CB44FF")
    public static File getExternalStorageAndroidDataDir() {
        return EXTERNAL_STORAGE_ANDROID_DATA_DIRECTORY;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.612 -0400", hash_original_method = "40277F291B5A8E4B36A828D8C3A376B5", hash_generated_method = "B2093C2CE72C762DD80A4DF1A3C1EE0E")
    public static File getExternalStorageAppDataDirectory(String packageName) {
        return new File(EXTERNAL_STORAGE_ANDROID_DATA_DIRECTORY, packageName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.612 -0400", hash_original_method = "55172197BB94D25451E63EEA35B16A56", hash_generated_method = "A2210D47B6756B51837CF8733C831890")
    public static File getExternalStorageAppMediaDirectory(String packageName) {
        return new File(EXTERNAL_STORAGE_ANDROID_MEDIA_DIRECTORY, packageName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.613 -0400", hash_original_method = "133F5560A13C528822A145DDB5A18A92", hash_generated_method = "CF335B360D815D46F5C1D95E46D097B6")
    public static File getExternalStorageAppObbDirectory(String packageName) {
        return new File(EXTERNAL_STORAGE_ANDROID_OBB_DIRECTORY, packageName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.613 -0400", hash_original_method = "050DBA7CC8565F34A0E9A00648CA002C", hash_generated_method = "54C17CF5A140720711F3A61262ACCD6F")
    public static File getExternalStorageAppFilesDirectory(String packageName) {
        return new File(new File(EXTERNAL_STORAGE_ANDROID_DATA_DIRECTORY,
                packageName), "files");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.613 -0400", hash_original_method = "C91E73381DEC6DAFD22AD517D132DDB1", hash_generated_method = "D07178151FABF1234633D29ADC19979E")
    public static File getExternalStorageAppCacheDirectory(String packageName) {
        return new File(new File(EXTERNAL_STORAGE_ANDROID_DATA_DIRECTORY,
                packageName), "cache");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.613 -0400", hash_original_method = "6C75CA3DA6425F473E9521EDF00E3AB4", hash_generated_method = "9E0FC6ADABAC3C59AE1F8E07A09E45A4")
    public static File getDownloadCacheDirectory() {
        return DOWNLOAD_CACHE_DIRECTORY;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.613 -0400", hash_original_method = "BEB54D71784BB9886D2BD75DEB648BB3", hash_generated_method = "35AF323F642F3C48729D391565433D5F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.613 -0400", hash_original_method = "D9D125D0D896B97B282353A8522D6FA4", hash_generated_method = "B2C890FEF08EC181B35007569CFAA9B1")
    public static boolean isExternalStorageRemovable() {
        StorageVolume volume = getPrimaryVolume();
        return (volume != null && volume.isRemovable());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.613 -0400", hash_original_method = "A3DF8384968B84A72A4806B896C940F5", hash_generated_method = "0061A94CD6FA894913DF2C9BCC4C9F67")
    public static boolean isExternalStorageEmulated() {
        StorageVolume volume = getPrimaryVolume();
        return (volume != null && volume.isEmulated());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.613 -0400", hash_original_method = "9C53479BCA8A1AAF4BCF134D9ED07471", hash_generated_method = "966E08026B8F34CEDCCDC647ABF4FCA3")
    static File getDirectory(String variableName, String defaultPath) {
        String path = System.getenv(variableName);
        return path == null ? new File(defaultPath) : new File(path);
    }

    
}


