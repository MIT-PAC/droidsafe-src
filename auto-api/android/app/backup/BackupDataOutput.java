package android.app.backup;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.os.ParcelFileDescriptor;
import java.io.FileDescriptor;
import java.io.IOException;

public class BackupDataOutput {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.439 -0400", hash_original_field = "99113DA95FFD8908386D2B9606B738F9", hash_generated_field = "B54359389579FCBEAD7641AAB8EECDC6")

    int mBackupWriter;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.440 -0400", hash_original_method = "519CBE74D64F306E29EEFC8CCFEDDE23", hash_generated_method = "F8796C98DA70FFAC92E782E32F46300F")
    public  BackupDataOutput(FileDescriptor fd) {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        mBackupWriter = ctor(fd);
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Native initialization failed with fd=" + fd);
        } 
        
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.441 -0400", hash_original_method = "64DACF34CA37B4EE5BF2F213E613C915", hash_generated_method = "B12108EA072A3B75F01D046C51F06F4E")
    public int writeEntityHeader(String key, int dataSize) throws IOException {
        int result = writeEntityHeader_native(mBackupWriter, key, dataSize);
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("result=0x" + Integer.toHexString(result));
        } 
        addTaint(key.getTaint());
        addTaint(dataSize);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_517676438 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_517676438;
        
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.442 -0400", hash_original_method = "1F7BD9065C295005115986DC5C5FEFFC", hash_generated_method = "6DB1BD668F7C3DD83E638009D690ECFF")
    public int writeEntityData(byte[] data, int size) throws IOException {
        int result = writeEntityData_native(mBackupWriter, data, size);
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("result=0x" + Integer.toHexString(result));
        } 
        addTaint(data[0]);
        addTaint(size);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2039776616 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2039776616;
        
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.443 -0400", hash_original_method = "BD5511530074677855FB5F031E6A0A48", hash_generated_method = "B7BAA6FD7838EF815FAD67FE9A62146A")
    public void setKeyPrefix(String keyPrefix) {
        setKeyPrefix_native(mBackupWriter, keyPrefix);
        addTaint(keyPrefix.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.444 -0400", hash_original_method = "7380B31B3FE738857D26F18ED18C23C7", hash_generated_method = "9C603892475912CA423BEAEF1B06C23D")
    protected void finalize() throws Throwable {
        try 
        {
            dtor(mBackupWriter);
        } 
        finally 
        {
            super.finalize();
        } 
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    private static int ctor(FileDescriptor fd) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    private static void dtor(int mBackupWriter) {
    }

    
    @DSModeled(DSC.SAFE)
    private static int writeEntityHeader_native(int mBackupWriter, String key, int dataSize) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    private static int writeEntityData_native(int mBackupWriter, byte[] data, int size) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    private static void setKeyPrefix_native(int mBackupWriter, String keyPrefix) {
    }

    
}

