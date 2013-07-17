package android.nfc.tech;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.nfc.ErrorCodes;
import android.nfc.Tag;
import android.nfc.TagLostException;
import android.os.RemoteException;
import android.util.Log;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class MifareClassic extends BasicTagTechnology {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.551 -0400", hash_original_field = "70A0825F7C8424D762F96A4610B5A4E1", hash_generated_field = "A5FF4684C8ADE9FC7594EE2E1226C64D")

    private boolean mIsEmulated;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.551 -0400", hash_original_field = "3462A1A18A0EE070E8953CCF1DD788C0", hash_generated_field = "E6B4AC7A48E0E54E09A504C828AF50C5")

    private int mType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.551 -0400", hash_original_field = "27DFA0EFE73BCB065533443A05E9DEE4", hash_generated_field = "1ADF00AF1A5D84662F00519BAA6EB9C0")

    private int mSize;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.554 -0400", hash_original_method = "05B1EEC895D259A0FF8852CB7B561E5D", hash_generated_method = "D4D0EE0A8E2D2D5BBE77C39DCCDBE127")
    public  MifareClassic(Tag tag) throws RemoteException {
        super(tag, TagTechnology.MIFARE_CLASSIC);
        addTaint(tag.getTaint());
        NfcA a = NfcA.get(tag);
        mIsEmulated = false;
switch(a.getSak()){
        case 0x08:
        mType = TYPE_CLASSIC;
        mSize = SIZE_1K;
        break;
        case 0x09:
        mType = TYPE_CLASSIC;
        mSize = SIZE_MINI;
        break;
        case 0x10:
        mType = TYPE_PLUS;
        mSize = SIZE_2K;
        break;
        case 0x11:
        mType = TYPE_PLUS;
        mSize = SIZE_4K;
        break;
        case 0x18:
        mType = TYPE_CLASSIC;
        mSize = SIZE_4K;
        break;
        case 0x28:
        mType = TYPE_CLASSIC;
        mSize = SIZE_1K;
        mIsEmulated = true;
        break;
        case 0x38:
        mType = TYPE_CLASSIC;
        mSize = SIZE_4K;
        mIsEmulated = true;
        break;
        case 0x88:
        mType = TYPE_CLASSIC;
        mSize = SIZE_1K;
        break;
        case 0x98:
        case 0xB8:
        mType = TYPE_PRO;
        mSize = SIZE_4K;
        break;
        default:
        RuntimeException varFFE52C29C2E8B2FABC3C722855C1BF37_1453873985 = new RuntimeException(
                    "Tag incorrectly enumerated as MIFARE Classic, SAK = " + a.getSak());
        varFFE52C29C2E8B2FABC3C722855C1BF37_1453873985.addTaint(taint);
        throw varFFE52C29C2E8B2FABC3C722855C1BF37_1453873985;
}
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    public static MifareClassic get(Tag tag) {
        if (!tag.hasTech(TagTechnology.MIFARE_CLASSIC)) return null;
        try {
            return new MifareClassic(tag);
        } catch (RemoteException e) {
            return null;
        }
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.556 -0400", hash_original_method = "E9AD68D49398B2B9D86D12D221B14582", hash_generated_method = "0405737CA7133554AC4E17962616CB74")
    public int getType() {
        int var3462A1A18A0EE070E8953CCF1DD788C0_701824047 = (mType);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2025432750 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2025432750;
        // ---------- Original Method ----------
        //return mType;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.557 -0400", hash_original_method = "2098B918320D3D5229820CAB47C60E59", hash_generated_method = "2D83BEB09EF2CB762DCEF114E8AD6A59")
    public int getSize() {
        int var27DFA0EFE73BCB065533443A05E9DEE4_1410359394 = (mSize);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_224850777 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_224850777;
        // ---------- Original Method ----------
        //return mSize;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.557 -0400", hash_original_method = "571F1D61EE68738D4B1083BD48C02876", hash_generated_method = "29E4275E64C287A2E8EB9C51B40B02E4")
    public boolean isEmulated() {
        boolean var70A0825F7C8424D762F96A4610B5A4E1_921489645 = (mIsEmulated);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_930352728 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_930352728;
        // ---------- Original Method ----------
        //return mIsEmulated;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.558 -0400", hash_original_method = "4AAA3C3D329C939FDD63EF1F58378EDA", hash_generated_method = "D26B00840B2A99854D11BCC18D9A1C8D")
    public int getSectorCount() {
switch(mSize){
        case SIZE_1K:
        int varC74D97B01EAE257E44AA9D5BADE97BAF_286287406 = (16);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_475365890 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_475365890;
        case SIZE_2K:
        int var6364D3F0F495B6AB9DCF8D3B5C6E0B01_1799281336 = (32);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1306492872 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1306492872;
        case SIZE_4K:
        int varD645920E395FEDAD7BBBED0ECA3FE2E0_899423034 = (40);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_571630435 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_571630435;
        case SIZE_MINI:
        int varE4DA3B7FBBCE2345D7772B0674A318D5_735034960 = (5);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1020951080 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1020951080;
        default:
        int varCFCD208495D565EF66E7DFF9F98764DA_1625971087 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1924729749 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1924729749;
}
        // ---------- Original Method ----------
        //switch (mSize) {
        //case SIZE_1K:
            //return 16;
        //case SIZE_2K:
            //return 32;
        //case SIZE_4K:
            //return 40;
        //case SIZE_MINI:
            //return 5;
        //default:
            //return 0;
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.558 -0400", hash_original_method = "94025DFC316C8F4CE80BFCF15B00E224", hash_generated_method = "6BBFDC38C91511848DB99F8FE0559CC9")
    public int getBlockCount() {
        int var113D873C42A5D92E1679C450278154BF_324801039 = (mSize / BLOCK_SIZE);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2095230521 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2095230521;
        // ---------- Original Method ----------
        //return mSize / BLOCK_SIZE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.559 -0400", hash_original_method = "4046C9F5F79A621BBA2F7BE2C9D1103D", hash_generated_method = "36B527F6B452FF4B44043D252894FD78")
    public int getBlockCountInSector(int sectorIndex) {
        addTaint(sectorIndex);
        validateSector(sectorIndex);
        if(sectorIndex < 32)        
        {
            int varA87FF679A2F3E71D9181A67B7542122C_492170171 = (4);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1887874516 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1887874516;
        } //End block
        else
        {
            int varC74D97B01EAE257E44AA9D5BADE97BAF_259922494 = (16);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1359376953 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1359376953;
        } //End block
        // ---------- Original Method ----------
        //validateSector(sectorIndex);
        //if (sectorIndex < 32) {
            //return 4;
        //} else {
            //return 16;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.560 -0400", hash_original_method = "54173D46B73CE605A7C420967C72CF9C", hash_generated_method = "8A57AAC7329BDB6288FB81D221567748")
    public int blockToSector(int blockIndex) {
        addTaint(blockIndex);
        validateBlock(blockIndex);
        if(blockIndex < 32 * 4)        
        {
            int var0015FE85A31D4CBD4804C5ED179A7867_1207582972 = (blockIndex / 4);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_345242009 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_345242009;
        } //End block
        else
        {
            int varB23432549961640CAF87951035F1E1F0_341721670 = (32 + (blockIndex - 32 * 4) / 16);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1500016293 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1500016293;
        } //End block
        // ---------- Original Method ----------
        //validateBlock(blockIndex);
        //if (blockIndex < 32 * 4) {
            //return blockIndex / 4;
        //} else {
            //return 32 + (blockIndex - 32 * 4) / 16;
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.561 -0400", hash_original_method = "9D4F0360D229F71B4914DA14E59850F0", hash_generated_method = "BBC4A5D0339F2ECC0837B56E76DF1970")
    public int sectorToBlock(int sectorIndex) {
        addTaint(sectorIndex);
        if(sectorIndex < 32)        
        {
            int var136421ED6951E9BB95FB381D03527187_501766595 = (sectorIndex * 4);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1358092062 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1358092062;
        } //End block
        else
        {
            int varA4B180D9D27D6B3BCAF06B1197A9E8BF_2104570217 = (32 * 4 + (sectorIndex - 32) * 16);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_436297592 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_436297592;
        } //End block
        // ---------- Original Method ----------
        //if (sectorIndex < 32) {
            //return sectorIndex * 4;
        //} else {
            //return 32 * 4 + (sectorIndex - 32) * 16;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.561 -0400", hash_original_method = "88C199BE0D888C3B911ED6B5CDCE45B3", hash_generated_method = "65431B118B521C1802994084C7AC8E11")
    public boolean authenticateSectorWithKeyA(int sectorIndex, byte[] key) throws IOException {
        addTaint(key[0]);
        addTaint(sectorIndex);
        boolean var5BF5E05162BABE5DBE45048BE905ABBA_1034539090 = (authenticate(sectorIndex, key, true));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_488994534 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_488994534;
        // ---------- Original Method ----------
        //return authenticate(sectorIndex, key, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.562 -0400", hash_original_method = "18C51006B4E85BDBA44E7C237EA48ACA", hash_generated_method = "C6FE9A7190EC367C4BED4B4361B35C12")
    public boolean authenticateSectorWithKeyB(int sectorIndex, byte[] key) throws IOException {
        addTaint(key[0]);
        addTaint(sectorIndex);
        boolean var66A4C56497054A57701BBBB567B4841D_530999372 = (authenticate(sectorIndex, key, false));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1300266291 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1300266291;
        // ---------- Original Method ----------
        //return authenticate(sectorIndex, key, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.563 -0400", hash_original_method = "A4BE9C6E30E6595D3E1AAF1825AE0C43", hash_generated_method = "3A52CAAC64501F1AB35C44AD36AF6871")
    private boolean authenticate(int sector, byte[] key, boolean keyA) throws IOException {
        addTaint(keyA);
        addTaint(key[0]);
        addTaint(sector);
        validateSector(sector);
        checkConnected();
        byte[] cmd = new byte[12];
        if(keyA)        
        {
            cmd[0] = 0x60;
        } //End block
        else
        {
            cmd[0] = 0x61;
        } //End block
        cmd[1] = (byte) sectorToBlock(sector);
        byte[] uid = getTag().getId();
        System.arraycopy(uid, uid.length - 4, cmd, 2, 4);
        System.arraycopy(key, 0, cmd, 6, 6);
        try 
        {
            if(transceive(cmd, false) != null)            
            {
                boolean varB326B5062B2F0E69046810717534CB09_356412868 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_104087201 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_104087201;
            } //End block
        } //End block
        catch (TagLostException e)
        {
            e.addTaint(taint);
            throw e;
        } //End block
        catch (IOException e)
        {
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_859100884 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_462807431 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_462807431;
        // ---------- Original Method ----------
        //validateSector(sector);
        //checkConnected();
        //byte[] cmd = new byte[12];
        //if (keyA) {
            //cmd[0] = 0x60; 
        //} else {
            //cmd[0] = 0x61; 
        //}
        //cmd[1] = (byte) sectorToBlock(sector);
        //byte[] uid = getTag().getId();
        //System.arraycopy(uid, uid.length - 4, cmd, 2, 4);
        //System.arraycopy(key, 0, cmd, 6, 6);
        //try {
            //if (transceive(cmd, false) != null) {
                //return true;
            //}
        //} catch (TagLostException e) {
            //throw e;
        //} catch (IOException e) {
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.564 -0400", hash_original_method = "540E686F2680F6F111FB5FE029F249C7", hash_generated_method = "23BE0C4CE488FB69A7503EB3C3F4FAC2")
    public byte[] readBlock(int blockIndex) throws IOException {
        addTaint(blockIndex);
        validateBlock(blockIndex);
        checkConnected();
        byte[] cmd = { 0x30, (byte) blockIndex };
        byte[] var8E202568BEDD06F864FDA8E60E6C3088_1195197920 = (transceive(cmd, false));
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1060460059 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1060460059;
        // ---------- Original Method ----------
        //validateBlock(blockIndex);
        //checkConnected();
        //byte[] cmd = { 0x30, (byte) blockIndex };
        //return transceive(cmd, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.565 -0400", hash_original_method = "6EB213EA4DA32B7A4304947C71CED66E", hash_generated_method = "CBEC081C3191C5D4F733B3B3D8E79A3A")
    public void writeBlock(int blockIndex, byte[] data) throws IOException {
        addTaint(data[0]);
        addTaint(blockIndex);
        validateBlock(blockIndex);
        checkConnected();
        if(data.length != 16)        
        {
            IllegalArgumentException var07B10BE9B977BFFA5B3348AF3692E843_1435473747 = new IllegalArgumentException("must write 16-bytes");
            var07B10BE9B977BFFA5B3348AF3692E843_1435473747.addTaint(taint);
            throw var07B10BE9B977BFFA5B3348AF3692E843_1435473747;
        } //End block
        byte[] cmd = new byte[data.length + 2];
        cmd[0] = (byte) 0xA0;
        cmd[1] = (byte) blockIndex;
        System.arraycopy(data, 0, cmd, 2, data.length);
        transceive(cmd, false);
        // ---------- Original Method ----------
        //validateBlock(blockIndex);
        //checkConnected();
        //if (data.length != 16) {
            //throw new IllegalArgumentException("must write 16-bytes");
        //}
        //byte[] cmd = new byte[data.length + 2];
        //cmd[0] = (byte) 0xA0;
        //cmd[1] = (byte) blockIndex;
        //System.arraycopy(data, 0, cmd, 2, data.length);
        //transceive(cmd, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.566 -0400", hash_original_method = "B8563CE393F659B55E0B9D3772EFE7A6", hash_generated_method = "14DC8825D4A008830017DD5E3C6EBDDA")
    public void increment(int blockIndex, int value) throws IOException {
        addTaint(value);
        addTaint(blockIndex);
        validateBlock(blockIndex);
        validateValueOperand(value);
        checkConnected();
        ByteBuffer cmd = ByteBuffer.allocate(6);
        cmd.order(ByteOrder.LITTLE_ENDIAN);
        cmd.put( (byte) 0xC1 );
        cmd.put( (byte) blockIndex );
        cmd.putInt(value);
        transceive(cmd.array(), false);
        // ---------- Original Method ----------
        //validateBlock(blockIndex);
        //validateValueOperand(value);
        //checkConnected();
        //ByteBuffer cmd = ByteBuffer.allocate(6);
        //cmd.order(ByteOrder.LITTLE_ENDIAN);
        //cmd.put( (byte) 0xC1 );
        //cmd.put( (byte) blockIndex );
        //cmd.putInt(value);
        //transceive(cmd.array(), false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.568 -0400", hash_original_method = "FAA38C9F5E4C186E0FA530C9A1909DAD", hash_generated_method = "865ADA2554C62F7D68EFD0A04A86AE35")
    public void decrement(int blockIndex, int value) throws IOException {
        addTaint(value);
        addTaint(blockIndex);
        validateBlock(blockIndex);
        validateValueOperand(value);
        checkConnected();
        ByteBuffer cmd = ByteBuffer.allocate(6);
        cmd.order(ByteOrder.LITTLE_ENDIAN);
        cmd.put( (byte) 0xC0 );
        cmd.put( (byte) blockIndex );
        cmd.putInt(value);
        transceive(cmd.array(), false);
        // ---------- Original Method ----------
        //validateBlock(blockIndex);
        //validateValueOperand(value);
        //checkConnected();
        //ByteBuffer cmd = ByteBuffer.allocate(6);
        //cmd.order(ByteOrder.LITTLE_ENDIAN);
        //cmd.put( (byte) 0xC0 );
        //cmd.put( (byte) blockIndex );
        //cmd.putInt(value);
        //transceive(cmd.array(), false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.568 -0400", hash_original_method = "25F048093BEC30F816A6E356A5759AAE", hash_generated_method = "FDFD3069D79BEAF0B3B3816A69516298")
    public void transfer(int blockIndex) throws IOException {
        addTaint(blockIndex);
        validateBlock(blockIndex);
        checkConnected();
        byte[] cmd = { (byte) 0xB0, (byte) blockIndex };
        transceive(cmd, false);
        // ---------- Original Method ----------
        //validateBlock(blockIndex);
        //checkConnected();
        //byte[] cmd = { (byte) 0xB0, (byte) blockIndex };
        //transceive(cmd, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.569 -0400", hash_original_method = "CA1FBC952F4C8F3DF96DFF31BC2893A2", hash_generated_method = "543532807DF5ECC1DB1D1BF1E2CD8C19")
    public void restore(int blockIndex) throws IOException {
        addTaint(blockIndex);
        validateBlock(blockIndex);
        checkConnected();
        byte[] cmd = { (byte) 0xC2, (byte) blockIndex };
        transceive(cmd, false);
        // ---------- Original Method ----------
        //validateBlock(blockIndex);
        //checkConnected();
        //byte[] cmd = { (byte) 0xC2, (byte) blockIndex };
        //transceive(cmd, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.570 -0400", hash_original_method = "E43990821CE38E04B46B3E901EFDFA24", hash_generated_method = "8CD59A27F84D265E34A6C9A08FA6F918")
    public byte[] transceive(byte[] data) throws IOException {
        addTaint(data[0]);
        byte[] varEE32C696607EBC614D9A30134ACB1AE3_332225921 = (transceive(data, true));
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_578347709 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_578347709;
        // ---------- Original Method ----------
        //return transceive(data, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.570 -0400", hash_original_method = "CF96EF3BF3FCE4DA3D9E7FBB541AEB70", hash_generated_method = "1EE8D5191D2D75FCC220BB1B62FCC20E")
    public int getMaxTransceiveLength() {
        int var534FE261D7083B235B3B010A14A83EE1_769533552 = (getMaxTransceiveLengthInternal());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1412092425 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1412092425;
        // ---------- Original Method ----------
        //return getMaxTransceiveLengthInternal();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.571 -0400", hash_original_method = "F9EC6D04AED06B3DFE22DC9A2A8AC0C3", hash_generated_method = "20DAA7AE25EB326F1404DAF540866468")
    public void setTimeout(int timeout) {
        addTaint(timeout);
        try 
        {
            int err = mTag.getTagService().setTimeout(TagTechnology.MIFARE_CLASSIC, timeout);
            if(err != ErrorCodes.SUCCESS)            
            {
                IllegalArgumentException varDB68BEF11A046B44BA82450BD6BDD1ED_1149383367 = new IllegalArgumentException("The supplied timeout is not valid");
                varDB68BEF11A046B44BA82450BD6BDD1ED_1149383367.addTaint(taint);
                throw varDB68BEF11A046B44BA82450BD6BDD1ED_1149383367;
            } //End block
        } //End block
        catch (RemoteException e)
        {
        } //End block
        // ---------- Original Method ----------
        //try {
            //int err = mTag.getTagService().setTimeout(TagTechnology.MIFARE_CLASSIC, timeout);
            //if (err != ErrorCodes.SUCCESS) {
                //throw new IllegalArgumentException("The supplied timeout is not valid");
            //}
        //} catch (RemoteException e) {
            //Log.e(TAG, "NFC service dead", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.572 -0400", hash_original_method = "59718E6CF1FABD433F7C060A44E5C453", hash_generated_method = "CAE6B6FB9F61648A1713599E6718A15B")
    public int getTimeout() {
        try 
        {
            int varBD614B0B67E6D92251E0598487623CAE_620474165 = (mTag.getTagService().getTimeout(TagTechnology.MIFARE_CLASSIC));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1006135230 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1006135230;
        } //End block
        catch (RemoteException e)
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_1257620226 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1028922800 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1028922800;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mTag.getTagService().getTimeout(TagTechnology.MIFARE_CLASSIC);
        //} catch (RemoteException e) {
            //Log.e(TAG, "NFC service dead", e);
            //return 0;
        //}
    }

    
    private static void validateSector(int sector) {
        if (sector < 0 || sector >= MAX_SECTOR_COUNT) {
            throw new IndexOutOfBoundsException("sector out of bounds: " + sector);
        }
    }

    
    private static void validateBlock(int block) {
        if (block < 0 || block >= MAX_BLOCK_COUNT) {
            throw new IndexOutOfBoundsException("block out of bounds: " + block);
        }
    }

    
    private static void validateValueOperand(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("value operand negative");
        }
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.573 -0400", hash_original_field = "839E89798F641D78E99C5732B39CA844", hash_generated_field = "BC8F11E4AEAD11E0412B7B53DF0CA6C8")

    private static final String TAG = "NFC";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.573 -0400", hash_original_field = "F43B62ACBEF62955A892A0125C4E97AC", hash_generated_field = "54FD0024ABE4EEEC2428AB757D9F3016")

    public static final byte[] KEY_DEFAULT =
            {(byte)0xFF,(byte)0xFF,(byte)0xFF,(byte)0xFF,(byte)0xFF,(byte)0xFF};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.574 -0400", hash_original_field = "21F9D525110FC9DDAD2D96449A9406BF", hash_generated_field = "15DB5DCB955364C48035DA5E4E953740")

    public static final byte[] KEY_MIFARE_APPLICATION_DIRECTORY =
            {(byte)0xA0,(byte)0xA1,(byte)0xA2,(byte)0xA3,(byte)0xA4,(byte)0xA5};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.574 -0400", hash_original_field = "E003BDDE321126A7175909200065CC96", hash_generated_field = "12E87E1D5AC9EA588363E4D80F1B1001")

    public static final byte[] KEY_NFC_FORUM =
            {(byte)0xD3,(byte)0xF7,(byte)0xD3,(byte)0xF7,(byte)0xD3,(byte)0xF7};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.574 -0400", hash_original_field = "5034A85BF931B74EFB4900211957B4BB", hash_generated_field = "384725A35AE2048CC01CB14C667E6F8D")

    public static final int TYPE_UNKNOWN = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.574 -0400", hash_original_field = "296852A8BBEF25A87785985C2BC0DFC5", hash_generated_field = "7061FCCEF7055B824FD2AA480431DCC6")

    public static final int TYPE_CLASSIC = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.574 -0400", hash_original_field = "ECD0E35FE52D2DE30F387A5A130B6976", hash_generated_field = "4E9412DEFDF67F37DBAB413F0A64A35E")

    public static final int TYPE_PLUS = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.574 -0400", hash_original_field = "6712F118318BDDE896831243EAB79997", hash_generated_field = "E54C8D8F5C6AB4014CB13C1AA7F26768")

    public static final int TYPE_PRO = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.574 -0400", hash_original_field = "44E5C75C5C9E25B08F5E8DAB7426A47C", hash_generated_field = "1768559A5BB2B8E1D785D5C51528A7E2")

    public static final int SIZE_1K = 1024;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.574 -0400", hash_original_field = "38245792A1CA3B41429F8B68D818111D", hash_generated_field = "29839D581DC916610DC52670577D996D")

    public static final int SIZE_2K = 2048;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.574 -0400", hash_original_field = "CAB6DD92345B3C8AFAF46DAB9D8D88A7", hash_generated_field = "901EEE828F9926FE0467F5BB2C7B7D08")

    public static final int SIZE_4K = 4096;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.575 -0400", hash_original_field = "2DBC1251377F3758534631A170319E57", hash_generated_field = "042D532175870A55F83E79C5988117F4")

    public static final int SIZE_MINI = 320;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.575 -0400", hash_original_field = "B38149A434660ADA03E33C84BD3F6CED", hash_generated_field = "195B8DA56AF39DED77508EB085D1B2A5")

    public static final int BLOCK_SIZE = 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.575 -0400", hash_original_field = "BD15FD57804DE3BC7D61C9ABF03CBDC3", hash_generated_field = "BC260A9D029BA6EDF18C45D0AF8942E9")

    private static final int MAX_BLOCK_COUNT = 256;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.575 -0400", hash_original_field = "B6DBE45B32DD2B5C973502062E9E9DAD", hash_generated_field = "D29CA245349D4EF940C9F42785B91E3A")

    private static final int MAX_SECTOR_COUNT = 40;
}

