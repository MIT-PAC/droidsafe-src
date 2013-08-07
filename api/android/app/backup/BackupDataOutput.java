package android.app.backup;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.FileDescriptor;
import java.io.IOException;





import droidsafe.helpers.DSUtils;

public class BackupDataOutput {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.201 -0400", hash_original_field = "99113DA95FFD8908386D2B9606B738F9", hash_generated_field = "B54359389579FCBEAD7641AAB8EECDC6")

    int mBackupWriter;
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.202 -0400", hash_original_method = "519CBE74D64F306E29EEFC8CCFEDDE23", hash_generated_method = "34B7E6B56300B0213BB3DFCEDB3ABCE0")
    public  BackupDataOutput(FileDescriptor fd) {
        if(fd == null)        
        {
        NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_5813687 = new NullPointerException();
        var7338BC9F48D81FE0BBD6183F4014DCC4_5813687.addTaint(taint);
        throw var7338BC9F48D81FE0BBD6183F4014DCC4_5813687;
        }
        mBackupWriter = ctor(fd);
        if(mBackupWriter == 0)        
        {
            RuntimeException varD18F42038ED5A65B5B920440D9607511_2056063986 = new RuntimeException("Native initialization failed with fd=" + fd);
            varD18F42038ED5A65B5B920440D9607511_2056063986.addTaint(taint);
            throw varD18F42038ED5A65B5B920440D9607511_2056063986;
        } //End block
        // ---------- Original Method ----------
        //if (fd == null) throw new NullPointerException();
        //mBackupWriter = ctor(fd);
        //if (mBackupWriter == 0) {
            //throw new RuntimeException("Native initialization failed with fd=" + fd);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.203 -0400", hash_original_method = "64DACF34CA37B4EE5BF2F213E613C915", hash_generated_method = "62D2D09FC681D2A8898D04457FE5A6CB")
    public int writeEntityHeader(String key, int dataSize) throws IOException {
        addTaint(dataSize);
        addTaint(key.getTaint());
        int result = writeEntityHeader_native(mBackupWriter, key, dataSize);
        if(result >= 0)        
        {
            int varB4A88417B3D0170D754C647C30B7216A_1909693778 = (result);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_749972190 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_749972190;
        } //End block
        else
        {
            IOException var4138A9E13F8C9D20923834ABCA8008BB_1907638939 = new IOException("result=0x" + Integer.toHexString(result));
            var4138A9E13F8C9D20923834ABCA8008BB_1907638939.addTaint(taint);
            throw var4138A9E13F8C9D20923834ABCA8008BB_1907638939;
        } //End block
        // ---------- Original Method ----------
        //int result = writeEntityHeader_native(mBackupWriter, key, dataSize);
        //if (result >= 0) {
            //return result;
        //} else {
            //throw new IOException("result=0x" + Integer.toHexString(result));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.204 -0400", hash_original_method = "1F7BD9065C295005115986DC5C5FEFFC", hash_generated_method = "7C100825A032547F0D88844E5664FBCA")
    public int writeEntityData(byte[] data, int size) throws IOException {
        addTaint(size);
        addTaint(data[0]);
        int result = writeEntityData_native(mBackupWriter, data, size);
        if(result >= 0)        
        {
            int varB4A88417B3D0170D754C647C30B7216A_2145807974 = (result);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_223416617 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_223416617;
        } //End block
        else
        {
            IOException var4138A9E13F8C9D20923834ABCA8008BB_1926200617 = new IOException("result=0x" + Integer.toHexString(result));
            var4138A9E13F8C9D20923834ABCA8008BB_1926200617.addTaint(taint);
            throw var4138A9E13F8C9D20923834ABCA8008BB_1926200617;
        } //End block
        // ---------- Original Method ----------
        //int result = writeEntityData_native(mBackupWriter, data, size);
        //if (result >= 0) {
            //return result;
        //} else {
            //throw new IOException("result=0x" + Integer.toHexString(result));
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.205 -0400", hash_original_method = "BD5511530074677855FB5F031E6A0A48", hash_generated_method = "E9B02604FE69BADB9B9332ABA82F9F3A")
    public void setKeyPrefix(String keyPrefix) {
        addTaint(keyPrefix.getTaint());
        setKeyPrefix_native(mBackupWriter, keyPrefix);
        // ---------- Original Method ----------
        //setKeyPrefix_native(mBackupWriter, keyPrefix);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.205 -0400", hash_original_method = "7380B31B3FE738857D26F18ED18C23C7", hash_generated_method = "9C603892475912CA423BEAEF1B06C23D")
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

