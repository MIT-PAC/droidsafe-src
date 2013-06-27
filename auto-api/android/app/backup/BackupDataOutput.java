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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:56.870 -0400", hash_original_field = "99113DA95FFD8908386D2B9606B738F9", hash_generated_field = "B54359389579FCBEAD7641AAB8EECDC6")

    int mBackupWriter;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:56.872 -0400", hash_original_method = "519CBE74D64F306E29EEFC8CCFEDDE23", hash_generated_method = "F8796C98DA70FFAC92E782E32F46300F")
    public  BackupDataOutput(FileDescriptor fd) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:56.882 -0400", hash_original_method = "64DACF34CA37B4EE5BF2F213E613C915", hash_generated_method = "083AE925720D28ABDAD86DB5C5902474")
    public int writeEntityHeader(String key, int dataSize) throws IOException {
        int result;
        result = writeEntityHeader_native(mBackupWriter, key, dataSize);
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("result=0x" + Integer.toHexString(result));
        } //End block
        addTaint(key.getTaint());
        addTaint(dataSize);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_570850630 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_570850630;
        // ---------- Original Method ----------
        //int result = writeEntityHeader_native(mBackupWriter, key, dataSize);
        //if (result >= 0) {
            //return result;
        //} else {
            //throw new IOException("result=0x" + Integer.toHexString(result));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:56.890 -0400", hash_original_method = "1F7BD9065C295005115986DC5C5FEFFC", hash_generated_method = "EA5E7EEB106A841FB4C3765B30E94C8B")
    public int writeEntityData(byte[] data, int size) throws IOException {
        int result;
        result = writeEntityData_native(mBackupWriter, data, size);
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("result=0x" + Integer.toHexString(result));
        } //End block
        addTaint(data[0]);
        addTaint(size);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2079535902 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2079535902;
        // ---------- Original Method ----------
        //int result = writeEntityData_native(mBackupWriter, data, size);
        //if (result >= 0) {
            //return result;
        //} else {
            //throw new IOException("result=0x" + Integer.toHexString(result));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:56.892 -0400", hash_original_method = "BD5511530074677855FB5F031E6A0A48", hash_generated_method = "B7BAA6FD7838EF815FAD67FE9A62146A")
    public void setKeyPrefix(String keyPrefix) {
        setKeyPrefix_native(mBackupWriter, keyPrefix);
        addTaint(keyPrefix.getTaint());
        // ---------- Original Method ----------
        //setKeyPrefix_native(mBackupWriter, keyPrefix);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:56.916 -0400", hash_original_method = "7380B31B3FE738857D26F18ED18C23C7", hash_generated_method = "9C603892475912CA423BEAEF1B06C23D")
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

