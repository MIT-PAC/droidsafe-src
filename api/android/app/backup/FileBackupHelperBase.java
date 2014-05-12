package android.app.backup;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import java.io.File;
import java.io.FileDescriptor;

import android.content.Context;
import android.os.ParcelFileDescriptor;

import droidsafe.helpers.DSUtils;

class FileBackupHelperBase {

    /**
     * Check the parameters so the native code doesn't have to throw all the exceptions
     * since it's easier to do that from Java.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:45.041 -0500", hash_original_method = "4DFB8B26593004F05B46C7B55CA3A1AC", hash_generated_method = "CFB6CD05ABDFFC658AA0528C1C95A53B")
    
static void performBackup_checked(ParcelFileDescriptor oldState, BackupDataOutput data,
            ParcelFileDescriptor newState, String[] files, String[] keys) {
        if (files.length == 0) {
            return;
        }
        // files must be all absolute paths
        for (String f: files) {
            if (f.charAt(0) != '/') {
                throw new RuntimeException("files must have all absolute paths: " + f);
            }
        }
        // the length of files and keys must be the same
        if (files.length != keys.length) {
            throw new RuntimeException("files.length=" + files.length
                    + " keys.length=" + keys.length);
        }
        // oldStateFd can be null
        FileDescriptor oldStateFd = oldState != null ? oldState.getFileDescriptor() : null;
        FileDescriptor newStateFd = newState.getFileDescriptor();
        if (newStateFd == null) {
            throw new NullPointerException();
        }

        int err = performBackup_native(oldStateFd, data.mBackupWriter, newStateFd, files, keys);

        if (err != 0) {
            // TODO: more here
            throw new RuntimeException("Backup failed 0x" + Integer.toHexString(err));
        }
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static int ctor() {
        return DSUtils.UNKNOWN_INT;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void dtor(int ptr) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static int performBackup_native(FileDescriptor oldState,
            int data, FileDescriptor newState, String[] files, String[] keys) {

        newState.addTaint(oldState.getTaint());
        newState.addTaint(data);
        newState.addTaint(files[0].getTaint());
        newState.addTaint(files.getTaint());
        newState.addTaint(keys[0].getTaint());
        newState.addTaint(keys.getTaint());

        return newState.getTaintInt();
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static int writeFile_native(int ptr, String filename, int backupReader) {
        return (ptr + filename.getTaintInt() + backupReader);
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static int writeSnapshot_native(int ptr, FileDescriptor fd) {
        fd.addTaint(ptr);
        return fd.getTaintInt();
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:45.028 -0500", hash_original_field = "73DA84C3D73901EAFDC64078A17B6EFD", hash_generated_field = "61E475B8BF147749B9941333719C84D8")

    private static final String TAG = "FileBackupHelperBase";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:45.030 -0500", hash_original_field = "42C21A18FB5976D4C67962413781C35D", hash_generated_field = "42C21A18FB5976D4C67962413781C35D")

    int mPtr;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:45.032 -0500", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "B997E37019471EC8FC5B98148C7A8AD7")

    Context mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:45.034 -0500", hash_original_field = "F8EEE799FD3188D16B81A657741F0DBD", hash_generated_field = "F8EEE799FD3188D16B81A657741F0DBD")

    boolean mExceptionLogged;
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:45.036 -0500", hash_original_method = "BB23E98A032BF11653E210F5716EBC1E", hash_generated_method = "BB23E98A032BF11653E210F5716EBC1E")
    
FileBackupHelperBase(Context context) {
        mPtr = ctor();
        mContext = context;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:45.038 -0500", hash_original_method = "E8F55F8C7A408972FDF45764F997EF73", hash_generated_method = "512AC6E27F8A455866918D89C96F4571")
    
protected void finalize() throws Throwable {
        try {
            dtor(mPtr);
        } finally {
            super.finalize();
        }
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:45.043 -0500", hash_original_method = "A480CB5B709E68610E22FE65F3C016D5", hash_generated_method = "0BB232A35E1C683E8A062AD38D60A20D")
    
boolean writeFile(File f, BackupDataInputStream in) {
        int result = -1;

        // Create the enclosing directory.
        File parent = f.getParentFile();
        parent.mkdirs();

        result = writeFile_native(mPtr, f.getAbsolutePath(), in.mData.mBackupReader);
        if (result != 0) {
            // Bail on this entity.  Only log one failure per helper object.
            if (!mExceptionLogged) {
                Log.e(TAG, "Failed restoring file '" + f + "' for app '"
                        + mContext.getPackageName() + "\' result=0x"
                        + Integer.toHexString(result));
                mExceptionLogged = true;
            }
        }
        return toTaintBoolean(result); 
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:45.045 -0500", hash_original_method = "2A62291A9AE3A671BAC15E3191D32511", hash_generated_method = "28B9531644FE5B2C583FA07E375C1A23")
    
public void writeNewStateDescription(ParcelFileDescriptor fd) {
        int result = writeSnapshot_native(mPtr, fd.getFileDescriptor());
        // TODO: Do something with the error.
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:45.047 -0500", hash_original_method = "13360827BDB81EDC3014ECA5973B3541", hash_generated_method = "13360827BDB81EDC3014ECA5973B3541")
    
boolean isKeyInList(String key, String[] list) {
        for (String s: list) {
            if (s.equals(key)) {
                return true;
            }
        }
        return false;
    }
}

