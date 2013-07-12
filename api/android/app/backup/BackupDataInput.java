package android.app.backup;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.FileDescriptor;
import java.io.IOException;

public class BackupDataInput {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.014 -0400", hash_original_field = "33E0B496245A5A5687805A5418AF3BB2", hash_generated_field = "EDA18C2AC17158AC38AD184085CE67B9")

    int mBackupReader;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.014 -0400", hash_original_field = "4144B352323D24B2D2C4C756E34A31FC", hash_generated_field = "09487E77E28DE2A84CA8495B9D491E4C")

    private EntityHeader mHeader = new EntityHeader();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.014 -0400", hash_original_field = "30C099076DFCC5E505D3702214C805E4", hash_generated_field = "DDC1B46C787D236D68304697B8C07639")

    private boolean mHeaderReady;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.015 -0400", hash_original_method = "582DAD329BBA9C3EE75CD90B1E443D9B", hash_generated_method = "578788DBDC1EF3859E66AB570C1240A4")
    public  BackupDataInput(FileDescriptor fd) {
    if(fd == null)        
        {
        NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_139400733 = new NullPointerException();
        var7338BC9F48D81FE0BBD6183F4014DCC4_139400733.addTaint(taint);
        throw var7338BC9F48D81FE0BBD6183F4014DCC4_139400733;
        }
        mBackupReader = ctor(fd);
    if(mBackupReader == 0)        
        {
            RuntimeException varD18F42038ED5A65B5B920440D9607511_856613915 = new RuntimeException("Native initialization failed with fd=" + fd);
            varD18F42038ED5A65B5B920440D9607511_856613915.addTaint(taint);
            throw varD18F42038ED5A65B5B920440D9607511_856613915;
        } 
        
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.016 -0400", hash_original_method = "CC531F2C344F6B5BB4BC1EC54E3B5D76", hash_generated_method = "A564916A20D514B6CEBFCF02B6F4CC72")
    protected void finalize() throws Throwable {
        try 
        {
            dtor(mBackupReader);
        } 
        finally 
        {
            super.finalize();
        } 
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.018 -0400", hash_original_method = "8876EC04BE968489185903B1495A889A", hash_generated_method = "609646A5AAC9A29D575C8EFF9CB3C227")
    public boolean readNextHeader() throws IOException {
        int result = readNextHeader_native(mBackupReader, mHeader);
    if(result == 0)        
        {
            mHeaderReady = true;
            boolean varB326B5062B2F0E69046810717534CB09_208951059 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1824261911 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1824261911;
        } 
        else
    if(result > 0)        
        {
            mHeaderReady = false;
            boolean var68934A3E9455FA72420237EB05902327_2030997945 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_610182845 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_610182845;
        } 
        else
        {
            mHeaderReady = false;
            IOException varEF8C45D465522B94FE6864037F607949_506135458 = new IOException("failed: 0x" + Integer.toHexString(result));
            varEF8C45D465522B94FE6864037F607949_506135458.addTaint(taint);
            throw varEF8C45D465522B94FE6864037F607949_506135458;
        } 
        
        
        
            
            
        
            
            
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.020 -0400", hash_original_method = "32914A2DCD27EDE5CD7416010D683812", hash_generated_method = "015FA07BA434B1A6DA7B798644164EBC")
    public String getKey() {
    if(mHeaderReady)        
        {
String var689A9ED7E3C9EEACCA83AE7E64B8CA73_1654067874 =             mHeader.key;
            var689A9ED7E3C9EEACCA83AE7E64B8CA73_1654067874.addTaint(taint);
            return var689A9ED7E3C9EEACCA83AE7E64B8CA73_1654067874;
        } 
        else
        {
            IllegalStateException var565AD1780E8DBC8AE274D5EDF5E05522_351924227 = new IllegalStateException("Entity header not read");
            var565AD1780E8DBC8AE274D5EDF5E05522_351924227.addTaint(taint);
            throw var565AD1780E8DBC8AE274D5EDF5E05522_351924227;
        } 
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.021 -0400", hash_original_method = "98B39A84BCE4F82002DB111D375A2105", hash_generated_method = "AA7B550345A8C460C56ED4693BC4BFD3")
    public int getDataSize() {
    if(mHeaderReady)        
        {
            int var1E877F12175A2050E63883FA90C1385F_2008730435 = (mHeader.dataSize);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2143049 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2143049;
        } 
        else
        {
            IllegalStateException var565AD1780E8DBC8AE274D5EDF5E05522_948973217 = new IllegalStateException("Entity header not read");
            var565AD1780E8DBC8AE274D5EDF5E05522_948973217.addTaint(taint);
            throw var565AD1780E8DBC8AE274D5EDF5E05522_948973217;
        } 
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.022 -0400", hash_original_method = "E6FF3430BADFF1BEAFD149782FA6CB07", hash_generated_method = "34909C7D48BF8DF8F4EA66FDDDCF73D1")
    public int readEntityData(byte[] data, int offset, int size) throws IOException {
        addTaint(size);
        addTaint(offset);
        addTaint(data[0]);
    if(mHeaderReady)        
        {
            int result = readEntityData_native(mBackupReader, data, offset, size);
    if(result >= 0)            
            {
                int varB4A88417B3D0170D754C647C30B7216A_1650690574 = (result);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1990029182 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1990029182;
            } 
            else
            {
                IOException var4138A9E13F8C9D20923834ABCA8008BB_528964713 = new IOException("result=0x" + Integer.toHexString(result));
                var4138A9E13F8C9D20923834ABCA8008BB_528964713.addTaint(taint);
                throw var4138A9E13F8C9D20923834ABCA8008BB_528964713;
            } 
        } 
        else
        {
            IllegalStateException var565AD1780E8DBC8AE274D5EDF5E05522_1785896338 = new IllegalStateException("Entity header not read");
            var565AD1780E8DBC8AE274D5EDF5E05522_1785896338.addTaint(taint);
            throw var565AD1780E8DBC8AE274D5EDF5E05522_1785896338;
        } 
        
        
            
            
                
            
                
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.023 -0400", hash_original_method = "785DF45E42B32B78A3E788F04C2081B3", hash_generated_method = "62335F849A40046E0A813376258A983D")
    public void skipEntityData() throws IOException {
    if(mHeaderReady)        
        {
            skipEntityData_native(mBackupReader);
        } 
        else
        {
            IllegalStateException var565AD1780E8DBC8AE274D5EDF5E05522_1671940639 = new IllegalStateException("Entity header not read");
            var565AD1780E8DBC8AE274D5EDF5E05522_1671940639.addTaint(taint);
            throw var565AD1780E8DBC8AE274D5EDF5E05522_1671940639;
        } 
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    private static int ctor(FileDescriptor fd) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    private static void dtor(int mBackupReader) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.028 -0400", hash_original_method = "067EEAAC3A307CF566E8560CEDE5923E", hash_generated_method = "7FAA0D6B4979D5127CCA581E4ABD2DEA")
    private int readNextHeader_native(int mBackupReader, EntityHeader entity) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1882591691 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1882591691;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.028 -0400", hash_original_method = "F563013799B99B7F96D96C08DD61A38F", hash_generated_method = "295B5FE9AF82232248446C6915D21ABB")
    private int readEntityData_native(int mBackupReader, byte[] data, int offset, int size) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1633556903 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1633556903;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.028 -0400", hash_original_method = "13C96EB578BECC22D2FF8487AD4702B6", hash_generated_method = "DC9889478C9DA5CED58E3DAA1656E317")
    private int skipEntityData_native(int mBackupReader) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_351843561 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_351843561;
    }

    
    private static class EntityHeader {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.029 -0400", hash_original_field = "3C6E0B8A9C15224A8228B9A98CA1531D", hash_generated_field = "FFE7EE17DFA37A68070A0F0495753B29")

        String key;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.029 -0400", hash_original_field = "7E995300D17ABA58ED95A1629BB54EDB", hash_generated_field = "BE50627D89367B94B26C95254370D367")

        int dataSize;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.029 -0400", hash_original_method = "0CA45CB3FD81751EFF77E1E1D96ACA74", hash_generated_method = "0CA45CB3FD81751EFF77E1E1D96ACA74")
        public EntityHeader ()
        {
            
        }


    }


    
}

