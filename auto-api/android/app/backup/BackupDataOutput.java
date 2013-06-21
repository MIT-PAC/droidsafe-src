package android.app.backup;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.ParcelFileDescriptor;
import java.io.FileDescriptor;
import java.io.IOException;

public class BackupDataOutput {
    int mBackupWriter;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.739 -0400", hash_original_method = "519CBE74D64F306E29EEFC8CCFEDDE23", hash_generated_method = "F3D6F29601239DB17D608A9BFF636522")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BackupDataOutput(FileDescriptor fd) {
        dsTaint.addTaint(fd.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        mBackupWriter = ctor(fd);
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Native initialization failed with fd=" + fd);
        } //End block
        // ---------- Original Method ----------
        //if (fd == null) throw new NullPointerException();
        //mBackupWriter = ctor(fd);
        //if (mBackupWriter == 0) {
            //throw new RuntimeException("Native initialization failed with fd=" + fd);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.740 -0400", hash_original_method = "64DACF34CA37B4EE5BF2F213E613C915", hash_generated_method = "792DC71C79C8D382117DB4E46453BC4B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int writeEntityHeader(String key, int dataSize) throws IOException {
        dsTaint.addTaint(dataSize);
        dsTaint.addTaint(key);
        int result;
        result = writeEntityHeader_native(mBackupWriter, key, dataSize);
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("result=0x" + Integer.toHexString(result));
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int result = writeEntityHeader_native(mBackupWriter, key, dataSize);
        //if (result >= 0) {
            //return result;
        //} else {
            //throw new IOException("result=0x" + Integer.toHexString(result));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.740 -0400", hash_original_method = "1F7BD9065C295005115986DC5C5FEFFC", hash_generated_method = "0957214B900232B1A21C05B2C29EAC25")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int writeEntityData(byte[] data, int size) throws IOException {
        dsTaint.addTaint(data[0]);
        dsTaint.addTaint(size);
        int result;
        result = writeEntityData_native(mBackupWriter, data, size);
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("result=0x" + Integer.toHexString(result));
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int result = writeEntityData_native(mBackupWriter, data, size);
        //if (result >= 0) {
            //return result;
        //} else {
            //throw new IOException("result=0x" + Integer.toHexString(result));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.741 -0400", hash_original_method = "BD5511530074677855FB5F031E6A0A48", hash_generated_method = "96D036607834050CBC8833059DBD3F58")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setKeyPrefix(String keyPrefix) {
        dsTaint.addTaint(keyPrefix);
        setKeyPrefix_native(mBackupWriter, keyPrefix);
        // ---------- Original Method ----------
        //setKeyPrefix_native(mBackupWriter, keyPrefix);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.741 -0400", hash_original_method = "7380B31B3FE738857D26F18ED18C23C7", hash_generated_method = "9C603892475912CA423BEAEF1B06C23D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void finalize() throws Throwable {
        try 
        {
            dtor(mBackupWriter);
        } //End block
        finally 
        {
            super.finalize();
        } //End block
        // ---------- Original Method ----------
        //try {
            //dtor(mBackupWriter);
        //} finally {
            //super.finalize();
        //}
    }

    
        private static int ctor(FileDescriptor fd) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static void dtor(int mBackupWriter) {
    }

    
        private static int writeEntityHeader_native(int mBackupWriter, String key, int dataSize) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static int writeEntityData_native(int mBackupWriter, byte[] data, int size) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static void setKeyPrefix_native(int mBackupWriter, String keyPrefix) {
    }

    
}

