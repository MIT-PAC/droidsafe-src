package android.app.backup;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.File;
import java.io.FileDescriptor;

import android.content.Context;
import android.os.ParcelFileDescriptor;




import droidsafe.helpers.DSUtils;

class FileBackupHelperBase {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.314 -0400", hash_original_field = "34F930F150EAEEFF27D6C0C8E4629911", hash_generated_field = "42C21A18FB5976D4C67962413781C35D")

    int mPtr;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.315 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "B997E37019471EC8FC5B98148C7A8AD7")

    Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.315 -0400", hash_original_field = "3FB1432F9EED96EAC2A7BA7C8E9F6EAD", hash_generated_field = "F8EEE799FD3188D16B81A657741F0DBD")

    boolean mExceptionLogged;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.316 -0400", hash_original_method = "BB23E98A032BF11653E210F5716EBC1E", hash_generated_method = "69FDFADA91C028251590EF05EA12E4F2")
      FileBackupHelperBase(Context context) {
        mPtr = ctor();
        mContext = context;
        // ---------- Original Method ----------
        //mPtr = ctor();
        //mContext = context;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.316 -0400", hash_original_method = "E8F55F8C7A408972FDF45764F997EF73", hash_generated_method = "A35D76E8DAA6CE81953BE72EF3031A1E")
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.318 -0400", hash_original_method = "A480CB5B709E68610E22FE65F3C016D5", hash_generated_method = "DF2095538FC9A4B2D4C58242D1187333")
     boolean writeFile(File f, BackupDataInputStream in) {
        addTaint(in.getTaint());
        addTaint(f.getTaint());
        int result = -1;
        File parent = f.getParentFile();
        parent.mkdirs();
        result = writeFile_native(mPtr, f.getAbsolutePath(), in.mData.mBackupReader);
        if(result != 0)        
        {
            if(!mExceptionLogged)            
            {
                mExceptionLogged = true;
            } //End block
        } //End block
        boolean var5B974C024B7AC2ED9560620242496414_1497874235 = ((result == 0));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2034052226 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2034052226;
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.319 -0400", hash_original_method = "2A62291A9AE3A671BAC15E3191D32511", hash_generated_method = "1724FA7548594C7A79F88CD13CBDDDD8")
    public void writeNewStateDescription(ParcelFileDescriptor fd) {
        addTaint(fd.getTaint());
        int result = writeSnapshot_native(mPtr, fd.getFileDescriptor());
        // ---------- Original Method ----------
        //int result = writeSnapshot_native(mPtr, fd.getFileDescriptor());
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.320 -0400", hash_original_method = "13360827BDB81EDC3014ECA5973B3541", hash_generated_method = "BD99255811A7FAE29E4E7BB29BEE7A8A")
     boolean isKeyInList(String key, String[] list) {
        addTaint(list[0].getTaint());
        addTaint(key.getTaint());
for(String s : list)
        {
            if(s.equals(key))            
            {
                boolean varB326B5062B2F0E69046810717534CB09_544595791 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1776002637 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1776002637;
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_2062971284 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_667399291 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_667399291;
        // ---------- Original Method ----------
        //for (String s: list) {
            //if (s.equals(key)) {
                //return true;
            //}
        //}
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    private static int ctor() {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    private static void dtor(int ptr) {
    }

    
    @DSModeled(DSC.SAFE)
    private static int performBackup_native(FileDescriptor oldState,
            int data, FileDescriptor newState, String[] files, String[] keys) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    private static int writeFile_native(int ptr, String filename, int backupReader) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    private static int writeSnapshot_native(int ptr, FileDescriptor fd) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.323 -0400", hash_original_field = "BE70FFBFAABFA734E906FA20E32ED004", hash_generated_field = "61E475B8BF147749B9941333719C84D8")

    private static final String TAG = "FileBackupHelperBase";
}

