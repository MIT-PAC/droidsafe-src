package android.app.backup;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.Context;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import java.io.File;
import java.io.FileDescriptor;

class FileBackupHelperBase {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:57.225 -0400", hash_original_field = "34F930F150EAEEFF27D6C0C8E4629911", hash_generated_field = "42C21A18FB5976D4C67962413781C35D")

    int mPtr;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:57.226 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "B997E37019471EC8FC5B98148C7A8AD7")

    Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:57.227 -0400", hash_original_field = "3FB1432F9EED96EAC2A7BA7C8E9F6EAD", hash_generated_field = "F8EEE799FD3188D16B81A657741F0DBD")

    boolean mExceptionLogged;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:57.240 -0400", hash_original_method = "BB23E98A032BF11653E210F5716EBC1E", hash_generated_method = "69FDFADA91C028251590EF05EA12E4F2")
      FileBackupHelperBase(Context context) {
        mPtr = ctor();
        mContext = context;
        // ---------- Original Method ----------
        //mPtr = ctor();
        //mContext = context;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:57.241 -0400", hash_original_method = "E8F55F8C7A408972FDF45764F997EF73", hash_generated_method = "A35D76E8DAA6CE81953BE72EF3031A1E")
    protected void finalize() throws Throwable {
        try 
        {
            dtor(mPtr);
        } //End block
        finally 
        {
            super.finalize();
        } //End block
        // ---------- Original Method ----------
        //try {
            //dtor(mPtr);
        //} finally {
            //super.finalize();
        //}
    }

    
        static void performBackup_checked(ParcelFileDescriptor oldState, BackupDataOutput data,
            ParcelFileDescriptor newState, String[] files, String[] keys) {
        if (files.length == 0) {
            return;
        }
        for (String f: files) {
            if (f.charAt(0) != '/') {
                throw new RuntimeException("files must have all absolute paths: " + f);
            }
        }
        if (files.length != keys.length) {
            throw new RuntimeException("files.length=" + files.length
                    + " keys.length=" + keys.length);
        }
        FileDescriptor oldStateFd = oldState != null ? oldState.getFileDescriptor() : null;
        FileDescriptor newStateFd = newState.getFileDescriptor();
        if (newStateFd == null) {
            throw new NullPointerException();
        }
        int err = performBackup_native(oldStateFd, data.mBackupWriter, newStateFd, files, keys);
        if (err != 0) {
            throw new RuntimeException("Backup failed 0x" + Integer.toHexString(err));
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:57.254 -0400", hash_original_method = "A480CB5B709E68610E22FE65F3C016D5", hash_generated_method = "91B0021C27323FCCE5D1B03DCF97D585")
     boolean writeFile(File f, BackupDataInputStream in) {
        int result;
        result = -1;
        File parent;
        parent = f.getParentFile();
        parent.mkdirs();
        result = writeFile_native(mPtr, f.getAbsolutePath(), in.mData.mBackupReader);
        {
            {
                mExceptionLogged = true;
            } //End block
        } //End block
        addTaint(f.getTaint());
        addTaint(in.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1598702546 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1598702546;
        // ---------- Original Method ----------
        //int result = -1;
        //File parent = f.getParentFile();
        //parent.mkdirs();
        //result = writeFile_native(mPtr, f.getAbsolutePath(), in.mData.mBackupReader);
        //if (result != 0) {
            //if (!mExceptionLogged) {
                //Log.e(TAG, "Failed restoring file '" + f + "' for app '"
                        //+ mContext.getPackageName() + "\' result=0x"
                        //+ Integer.toHexString(result));
                //mExceptionLogged = true;
            //}
        //}
        //return (result == 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:57.255 -0400", hash_original_method = "2A62291A9AE3A671BAC15E3191D32511", hash_generated_method = "69F37AB48188571EE2E340CF6E6E287B")
    public void writeNewStateDescription(ParcelFileDescriptor fd) {
        int result;
        result = writeSnapshot_native(mPtr, fd.getFileDescriptor());
        addTaint(fd.getTaint());
        // ---------- Original Method ----------
        //int result = writeSnapshot_native(mPtr, fd.getFileDescriptor());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:57.455 -0400", hash_original_method = "13360827BDB81EDC3014ECA5973B3541", hash_generated_method = "B38F7C8BD7038ED10BBF827D0C31F42B")
     boolean isKeyInList(String key, String[] list) {
        {
            Iterator<String> var19F7DE56EA48EF311DBB5791A45DFB02_1446578699 = (list).iterator();
            var19F7DE56EA48EF311DBB5791A45DFB02_1446578699.hasNext();
            String s = var19F7DE56EA48EF311DBB5791A45DFB02_1446578699.next();
            {
                {
                    boolean var966DD3C3974AE4250FA4127ECE022D38_911971043 = (s.equals(key));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(key.getTaint());
        addTaint(list[0].getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1109950249 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1109950249;
        // ---------- Original Method ----------
        //for (String s: list) {
            //if (s.equals(key)) {
                //return true;
            //}
        //}
        //return false;
    }

    
        private static int ctor() {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static void dtor(int ptr) {
    }

    
        private static int performBackup_native(FileDescriptor oldState,
            int data, FileDescriptor newState, String[] files, String[] keys) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static int writeFile_native(int ptr, String filename, int backupReader) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static int writeSnapshot_native(int ptr, FileDescriptor fd) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:57.471 -0400", hash_original_field = "BE70FFBFAABFA734E906FA20E32ED004", hash_generated_field = "0ED08805EB9C5835227414157E6281E1")

    private static String TAG = "FileBackupHelperBase";
}

