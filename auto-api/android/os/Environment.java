package android.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.res.Resources;
import android.os.storage.IMountService;
import android.os.storage.StorageVolume;
import android.util.Log;
import java.io.File;

public class Environment {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.494 -0400", hash_original_method = "DD3430916CE6C73020F0FB3D85F647E8", hash_generated_method = "DD3430916CE6C73020F0FB3D85F647E8")
        public Environment ()
    {
    }


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

    
        public static File getRootDirectory() {
        return ROOT_DIRECTORY;
    }

    
        public static File getSystemSecureDirectory() {
        if (isEncryptedFilesystemEnabled()) {
            return new File(SECURE_DATA_DIRECTORY, "system");
        } else {
            return new File(DATA_DIRECTORY, "system");
        }
    }

    
        public static File getSecureDataDirectory() {
        if (isEncryptedFilesystemEnabled()) {
            return SECURE_DATA_DIRECTORY;
        } else {
            return DATA_DIRECTORY;
        }
    }

    
        public static boolean isEncryptedFilesystemEnabled() {
        return SystemProperties.getBoolean(SYSTEM_PROPERTY_EFS_ENABLED, false);
    }

    
        public static File getDataDirectory() {
        return DATA_DIRECTORY;
    }

    
        public static File getExternalStorageDirectory() {
        return EXTERNAL_STORAGE_DIRECTORY;
    }

    
        public static File getExternalStoragePublicDirectory(String type) {
        return new File(getExternalStorageDirectory(), type);
    }

    
        public static File getExternalStorageAndroidDataDir() {
        return EXTERNAL_STORAGE_ANDROID_DATA_DIRECTORY;
    }

    
        public static File getExternalStorageAppDataDirectory(String packageName) {
        return new File(EXTERNAL_STORAGE_ANDROID_DATA_DIRECTORY, packageName);
    }

    
        public static File getExternalStorageAppMediaDirectory(String packageName) {
        return new File(EXTERNAL_STORAGE_ANDROID_MEDIA_DIRECTORY, packageName);
    }

    
        public static File getExternalStorageAppObbDirectory(String packageName) {
        return new File(EXTERNAL_STORAGE_ANDROID_OBB_DIRECTORY, packageName);
    }

    
        public static File getExternalStorageAppFilesDirectory(String packageName) {
        return new File(new File(EXTERNAL_STORAGE_ANDROID_DATA_DIRECTORY,
                packageName), "files");
    }

    
        public static File getExternalStorageAppCacheDirectory(String packageName) {
        return new File(new File(EXTERNAL_STORAGE_ANDROID_DATA_DIRECTORY,
                packageName), "cache");
    }

    
        public static File getDownloadCacheDirectory() {
        return DOWNLOAD_CACHE_DIRECTORY;
    }

    
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

    
        public static boolean isExternalStorageRemovable() {
        StorageVolume volume = getPrimaryVolume();
        return (volume != null && volume.isRemovable());
    }

    
        public static boolean isExternalStorageEmulated() {
        StorageVolume volume = getPrimaryVolume();
        return (volume != null && volume.isEmulated());
    }

    
        static File getDirectory(String variableName, String defaultPath) {
        String path = System.getenv(variableName);
        return path == null ? new File(defaultPath) : new File(path);
    }

    
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
}

