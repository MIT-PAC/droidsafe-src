package android.app.backup;

// Droidsafe Imports
import java.io.FileDescriptor;
import java.io.IOException;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;
import droidsafe.helpers.DSUtils;

public class BackupDataInput {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.164 -0400", hash_original_field = "33E0B496245A5A5687805A5418AF3BB2", hash_generated_field = "EDA18C2AC17158AC38AD184085CE67B9")

    int mBackupReader;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.164 -0400", hash_original_field = "4144B352323D24B2D2C4C756E34A31FC", hash_generated_field = "09487E77E28DE2A84CA8495B9D491E4C")

    private EntityHeader mHeader = new EntityHeader();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.164 -0400", hash_original_field = "30C099076DFCC5E505D3702214C805E4", hash_generated_field = "DDC1B46C787D236D68304697B8C07639")

    private boolean mHeaderReady;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.165 -0400", hash_original_method = "582DAD329BBA9C3EE75CD90B1E443D9B", hash_generated_method = "35DBEE9EA1E57BF8E4B4887723596A16")
    public  BackupDataInput(FileDescriptor fd) {
        if(fd == null)        
        {
        NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_964250624 = new NullPointerException();
        var7338BC9F48D81FE0BBD6183F4014DCC4_964250624.addTaint(taint);
        throw var7338BC9F48D81FE0BBD6183F4014DCC4_964250624;
        }
        mBackupReader = ctor(fd);
        if(mBackupReader == 0)        
        {
            RuntimeException varD18F42038ED5A65B5B920440D9607511_717833281 = new RuntimeException("Native initialization failed with fd=" + fd);
            varD18F42038ED5A65B5B920440D9607511_717833281.addTaint(taint);
            throw varD18F42038ED5A65B5B920440D9607511_717833281;
        } //End block
        // ---------- Original Method ----------
        //if (fd == null) throw new NullPointerException();
        //mBackupReader = ctor(fd);
        //if (mBackupReader == 0) {
            //throw new RuntimeException("Native initialization failed with fd=" + fd);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.166 -0400", hash_original_method = "CC531F2C344F6B5BB4BC1EC54E3B5D76", hash_generated_method = "A564916A20D514B6CEBFCF02B6F4CC72")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.167 -0400", hash_original_method = "8876EC04BE968489185903B1495A889A", hash_generated_method = "517061D70810CA5656D47D3CBEA62181")
    public boolean readNextHeader() throws IOException {
        int result = readNextHeader_native(mBackupReader, mHeader);
        if(result == 0)        
        {
            mHeaderReady = true;
            boolean varB326B5062B2F0E69046810717534CB09_1500662349 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1709776799 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1709776799;
        } //End block
        else
        if(result > 0)        
        {
            mHeaderReady = false;
            boolean var68934A3E9455FA72420237EB05902327_588942646 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_351425609 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_351425609;
        } //End block
        else
        {
            mHeaderReady = false;
            IOException varEF8C45D465522B94FE6864037F607949_1171194960 = new IOException("failed: 0x" + Integer.toHexString(result));
            varEF8C45D465522B94FE6864037F607949_1171194960.addTaint(taint);
            throw varEF8C45D465522B94FE6864037F607949_1171194960;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.167 -0400", hash_original_method = "32914A2DCD27EDE5CD7416010D683812", hash_generated_method = "B3BF2F3B0CC326BCF28D3EAE09027F67")
    public String getKey() {
        if(mHeaderReady)        
        {
String var689A9ED7E3C9EEACCA83AE7E64B8CA73_529874909 =             mHeader.key;
            var689A9ED7E3C9EEACCA83AE7E64B8CA73_529874909.addTaint(taint);
            return var689A9ED7E3C9EEACCA83AE7E64B8CA73_529874909;
        } //End block
        else
        {
            IllegalStateException var565AD1780E8DBC8AE274D5EDF5E05522_891575464 = new IllegalStateException("Entity header not read");
            var565AD1780E8DBC8AE274D5EDF5E05522_891575464.addTaint(taint);
            throw var565AD1780E8DBC8AE274D5EDF5E05522_891575464;
        } //End block
        // ---------- Original Method ----------
        //if (mHeaderReady) {
            //return mHeader.key;
        //} else {
            //throw new IllegalStateException("Entity header not read");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.168 -0400", hash_original_method = "98B39A84BCE4F82002DB111D375A2105", hash_generated_method = "C8095B1BD8DD4AD9C854A1DE35913017")
    public int getDataSize() {
        if(mHeaderReady)        
        {
            int var1E877F12175A2050E63883FA90C1385F_1713329654 = (mHeader.dataSize);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_243279628 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_243279628;
        } //End block
        else
        {
            IllegalStateException var565AD1780E8DBC8AE274D5EDF5E05522_885721097 = new IllegalStateException("Entity header not read");
            var565AD1780E8DBC8AE274D5EDF5E05522_885721097.addTaint(taint);
            throw var565AD1780E8DBC8AE274D5EDF5E05522_885721097;
        } //End block
        // ---------- Original Method ----------
        //if (mHeaderReady) {
            //return mHeader.dataSize;
        //} else {
            //throw new IllegalStateException("Entity header not read");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.169 -0400", hash_original_method = "E6FF3430BADFF1BEAFD149782FA6CB07", hash_generated_method = "9E740461D31A243BB790E05381065A97")
    public int readEntityData(byte[] data, int offset, int size) throws IOException {
        addTaint(size);
        addTaint(offset);
        addTaint(data[0]);
        if(mHeaderReady)        
        {
            int result = readEntityData_native(mBackupReader, data, offset, size);
            if(result >= 0)            
            {
                int varB4A88417B3D0170D754C647C30B7216A_1317906666 = (result);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1175298653 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1175298653;
            } //End block
            else
            {
                IOException var4138A9E13F8C9D20923834ABCA8008BB_1424563162 = new IOException("result=0x" + Integer.toHexString(result));
                var4138A9E13F8C9D20923834ABCA8008BB_1424563162.addTaint(taint);
                throw var4138A9E13F8C9D20923834ABCA8008BB_1424563162;
            } //End block
        } //End block
        else
        {
            IllegalStateException var565AD1780E8DBC8AE274D5EDF5E05522_173749572 = new IllegalStateException("Entity header not read");
            var565AD1780E8DBC8AE274D5EDF5E05522_173749572.addTaint(taint);
            throw var565AD1780E8DBC8AE274D5EDF5E05522_173749572;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.169 -0400", hash_original_method = "785DF45E42B32B78A3E788F04C2081B3", hash_generated_method = "7C36F3848517944EE455249F9D6B776D")
    public void skipEntityData() throws IOException {
        if(mHeaderReady)        
        {
            skipEntityData_native(mBackupReader);
        } //End block
        else
        {
            IllegalStateException var565AD1780E8DBC8AE274D5EDF5E05522_635352714 = new IllegalStateException("Entity header not read");
            var565AD1780E8DBC8AE274D5EDF5E05522_635352714.addTaint(taint);
            throw var565AD1780E8DBC8AE274D5EDF5E05522_635352714;
        } //End block
        // ---------- Original Method ----------
        //if (mHeaderReady) {
            //skipEntityData_native(mBackupReader);
        //} else {
            //throw new IllegalStateException("Entity header not read");
        //}
    }

    
    @DSModeled(DSC.SAFE)
    private static int ctor(FileDescriptor fd) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    private static void dtor(int mBackupReader) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.171 -0400", hash_original_method = "067EEAAC3A307CF566E8560CEDE5923E", hash_generated_method = "CFC19A01F46CD52E8FC1250538DE6876")
    private int readNextHeader_native(int mBackupReader, EntityHeader entity) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1990605968 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1990605968;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.171 -0400", hash_original_method = "F563013799B99B7F96D96C08DD61A38F", hash_generated_method = "CC768E32DC5740F2403EA5F1922B85E4")
    private int readEntityData_native(int mBackupReader, byte[] data, int offset, int size) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1828701822 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1828701822;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.172 -0400", hash_original_method = "13C96EB578BECC22D2FF8487AD4702B6", hash_generated_method = "BC6F8B1D98F97A5B332B9F40A83C7CBF")
    private int skipEntityData_native(int mBackupReader) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_240549950 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_240549950;
    }

    
    private static class EntityHeader {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.172 -0400", hash_original_field = "3C6E0B8A9C15224A8228B9A98CA1531D", hash_generated_field = "FFE7EE17DFA37A68070A0F0495753B29")

        String key;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.173 -0400", hash_original_field = "7E995300D17ABA58ED95A1629BB54EDB", hash_generated_field = "BE50627D89367B94B26C95254370D367")

        int dataSize;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.173 -0400", hash_original_method = "0CA45CB3FD81751EFF77E1E1D96ACA74", hash_generated_method = "0CA45CB3FD81751EFF77E1E1D96ACA74")
        public EntityHeader ()
        {
            //Synthesized constructor
        }


    }


    
}

