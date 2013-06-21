package android.app.backup;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import libcore.io.ErrnoException;
import libcore.io.Libcore;

public class FullBackup {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.764 -0400", hash_original_method = "08F473C503B4B43A9C57EA15C26D81E6", hash_generated_method = "08F473C503B4B43A9C57EA15C26D81E6")
        public FullBackup ()
    {
    }


        static public int backupToTar(String packageName, String domain,
            String linkdomain, String rootpath, String path, BackupDataOutput output) {
        return DSUtils.UNKNOWN_INT;
    }

    
        static public void restoreFile(ParcelFileDescriptor data,
            long size, int type, long mode, long mtime, File outFile) throws IOException {
        if (type == BackupAgent.TYPE_DIRECTORY) {
            if (outFile != null) outFile.mkdirs();
        } else {
            FileOutputStream out = null;
            try {
                if (outFile != null) {
                    File parent = outFile.getParentFile();
                    if (!parent.exists()) {
                        parent.mkdirs();
                    }
                    out = new FileOutputStream(outFile);
                }
            } catch (IOException e) {
                Log.e(TAG, "Unable to create/open file " + outFile.getPath(), e);
            }
            byte[] buffer = new byte[32 * 1024];
            final long origSize = size;
            FileInputStream in = new FileInputStream(data.getFileDescriptor());
            while (size > 0) {
                int toRead = (size > buffer.length) ? buffer.length : (int)size;
                int got = in.read(buffer, 0, toRead);
                if (got <= 0) {
                    Log.w(TAG, "Incomplete read: expected " + size + " but got "
                            + (origSize - size));
                    break;
                }
                if (out != null) {
                    try {
                        out.write(buffer, 0, got);
                    } catch (IOException e) {
                        Log.e(TAG, "Unable to write to file " + outFile.getPath(), e);
                        out.close();
                        out = null;
                        outFile.delete();
                    }
                }
                size -= got;
            }
            if (out != null) out.close();
        }
        if (mode >= 0 && outFile != null) {
            try {
                Libcore.os.chmod(outFile.getPath(), (int)mode);
            } catch (ErrnoException e) {
                e.rethrowAsIOException();
            }
            outFile.setLastModified(mtime);
        }
    }

    
    static final String TAG = "FullBackup";
    public static final String APK_TREE_TOKEN = "a";
    public static final String OBB_TREE_TOKEN = "obb";
    public static final String ROOT_TREE_TOKEN = "r";
    public static final String DATA_TREE_TOKEN = "f";
    public static final String DATABASE_TREE_TOKEN = "db";
    public static final String SHAREDPREFS_TREE_TOKEN = "sp";
    public static final String CACHE_TREE_TOKEN = "c";
    public static final String SHARED_STORAGE_TOKEN = "shared";
    public static final String APPS_PREFIX = "apps/";
    public static final String SHARED_PREFIX = SHARED_STORAGE_TOKEN + "/";
    public static final String FULL_BACKUP_INTENT_ACTION = "fullback";
    public static final String FULL_RESTORE_INTENT_ACTION = "fullrest";
    public static final String CONF_TOKEN_INTENT_EXTRA = "conftoken";
}

