package android.app.backup;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.FileDescriptor;
import java.io.IOException;

public class BackupDataInput {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:56.757 -0400", hash_original_field = "33E0B496245A5A5687805A5418AF3BB2", hash_generated_field = "EDA18C2AC17158AC38AD184085CE67B9")

    int mBackupReader;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:56.770 -0400", hash_original_field = "4144B352323D24B2D2C4C756E34A31FC", hash_generated_field = "09487E77E28DE2A84CA8495B9D491E4C")

    private EntityHeader mHeader = new EntityHeader();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:56.771 -0400", hash_original_field = "30C099076DFCC5E505D3702214C805E4", hash_generated_field = "DDC1B46C787D236D68304697B8C07639")

    private boolean mHeaderReady;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:56.772 -0400", hash_original_method = "582DAD329BBA9C3EE75CD90B1E443D9B", hash_generated_method = "A50F912E8701BD3F930A44238D2F3661")
    public  BackupDataInput(FileDescriptor fd) {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        mBackupReader = ctor(fd);
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Native initialization failed with fd=" + fd);
        } //End block
        // ---------- Original Method ----------
        //if (fd == null) throw new NullPointerException();
        //mBackupReader = ctor(fd);
        //if (mBackupReader == 0) {
            //throw new RuntimeException("Native initialization failed with fd=" + fd);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:56.783 -0400", hash_original_method = "CC531F2C344F6B5BB4BC1EC54E3B5D76", hash_generated_method = "A564916A20D514B6CEBFCF02B6F4CC72")
    protected void finalize() throws Throwable {
        try 
        {
            dtor(mBackupReader);
        } //End block
        finally 
        {
            super.finalize();
        } //End block
        // ---------- Original Method ----------
        //try {
            //dtor(mBackupReader);
        //} finally {
            //super.finalize();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:56.794 -0400", hash_original_method = "8876EC04BE968489185903B1495A889A", hash_generated_method = "BEEF745DF40200E2CF4D0CB9316EB417")
    public boolean readNextHeader() throws IOException {
        int result;
        result = readNextHeader_native(mBackupReader, mHeader);
        {
            mHeaderReady = true;
        } //End block
        {
            mHeaderReady = false;
        } //End block
        {
            mHeaderReady = false;
            if (DroidSafeAndroidRuntime.control) throw new IOException("failed: 0x" + Integer.toHexString(result));
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_119371307 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_119371307;
        // ---------- Original Method ----------
        //int result = readNextHeader_native(mBackupReader, mHeader);
        //if (result == 0) {
            //mHeaderReady = true;
            //return true;
        //} else if (result > 0) {
            //mHeaderReady = false;
            //return false;
        //} else {
            //mHeaderReady = false;
            //throw new IOException("failed: 0x" + Integer.toHexString(result));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:56.811 -0400", hash_original_method = "32914A2DCD27EDE5CD7416010D683812", hash_generated_method = "DF403074F66712110BD09EC01E600AC4")
    public String getKey() {
        String varB4EAC82CA7396A68D541C85D26508E83_614967827 = null; //Variable for return #1
        {
            varB4EAC82CA7396A68D541C85D26508E83_614967827 = mHeader.key;
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Entity header not read");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_614967827.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_614967827;
        // ---------- Original Method ----------
        //if (mHeaderReady) {
            //return mHeader.key;
        //} else {
            //throw new IllegalStateException("Entity header not read");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:56.813 -0400", hash_original_method = "98B39A84BCE4F82002DB111D375A2105", hash_generated_method = "39BF690D46D3BD338E61AA1EEE8DFCA9")
    public int getDataSize() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Entity header not read");
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_263272690 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_263272690;
        // ---------- Original Method ----------
        //if (mHeaderReady) {
            //return mHeader.dataSize;
        //} else {
            //throw new IllegalStateException("Entity header not read");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:56.829 -0400", hash_original_method = "E6FF3430BADFF1BEAFD149782FA6CB07", hash_generated_method = "EA8390D743FF16796C60E58D65D1E54E")
    public int readEntityData(byte[] data, int offset, int size) throws IOException {
        {
            int result;
            result = readEntityData_native(mBackupReader, data, offset, size);
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException("result=0x" + Integer.toHexString(result));
            } //End block
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Entity header not read");
        } //End block
        addTaint(data[0]);
        addTaint(offset);
        addTaint(size);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1393975664 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1393975664;
        // ---------- Original Method ----------
        //if (mHeaderReady) {
            //int result = readEntityData_native(mBackupReader, data, offset, size);
            //if (result >= 0) {
                //return result;
            //} else {
                //throw new IOException("result=0x" + Integer.toHexString(result));
            //}
        //} else {
            //throw new IllegalStateException("Entity header not read");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:56.831 -0400", hash_original_method = "785DF45E42B32B78A3E788F04C2081B3", hash_generated_method = "2DE37E179F5DFBBFCC99691C85BA4EA3")
    public void skipEntityData() throws IOException {
        {
            skipEntityData_native(mBackupReader);
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Entity header not read");
        } //End block
        // ---------- Original Method ----------
        //if (mHeaderReady) {
            //skipEntityData_native(mBackupReader);
        //} else {
            //throw new IllegalStateException("Entity header not read");
        //}
    }

    
        private static int ctor(FileDescriptor fd) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static void dtor(int mBackupReader) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:56.848 -0400", hash_original_method = "067EEAAC3A307CF566E8560CEDE5923E", hash_generated_method = "048DA5049E3A7EB310C2614FAF5A9216")
    private int readNextHeader_native(int mBackupReader, EntityHeader entity) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1178151594 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1178151594;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:56.849 -0400", hash_original_method = "F563013799B99B7F96D96C08DD61A38F", hash_generated_method = "51E8CE475A2975987AABF8F83BE16B02")
    private int readEntityData_native(int mBackupReader, byte[] data, int offset, int size) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_276759904 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_276759904;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:56.850 -0400", hash_original_method = "13C96EB578BECC22D2FF8487AD4702B6", hash_generated_method = "E6BC7F52A569EC30929236C7909B0215")
    private int skipEntityData_native(int mBackupReader) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_37734852 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_37734852;
    }

    
    private static class EntityHeader {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:56.865 -0400", hash_original_field = "3C6E0B8A9C15224A8228B9A98CA1531D", hash_generated_field = "FFE7EE17DFA37A68070A0F0495753B29")

        String key;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:56.865 -0400", hash_original_field = "7E995300D17ABA58ED95A1629BB54EDB", hash_generated_field = "BE50627D89367B94B26C95254370D367")

        int dataSize;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:56.866 -0400", hash_original_method = "0CA45CB3FD81751EFF77E1E1D96ACA74", hash_generated_method = "0CA45CB3FD81751EFF77E1E1D96ACA74")
        public EntityHeader ()
        {
            //Synthesized constructor
        }


    }


    
}

