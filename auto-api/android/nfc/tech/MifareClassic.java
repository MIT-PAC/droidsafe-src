package android.nfc.tech;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.nfc.ErrorCodes;
import android.nfc.Tag;
import android.nfc.TagLostException;
import android.os.RemoteException;
import android.util.Log;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class MifareClassic extends BasicTagTechnology {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:24.976 -0400", hash_original_field = "70A0825F7C8424D762F96A4610B5A4E1", hash_generated_field = "A5FF4684C8ADE9FC7594EE2E1226C64D")

    private boolean mIsEmulated;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:24.976 -0400", hash_original_field = "3462A1A18A0EE070E8953CCF1DD788C0", hash_generated_field = "E6B4AC7A48E0E54E09A504C828AF50C5")

    private int mType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:24.976 -0400", hash_original_field = "27DFA0EFE73BCB065533443A05E9DEE4", hash_generated_field = "1ADF00AF1A5D84662F00519BAA6EB9C0")

    private int mSize;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:24.992 -0400", hash_original_method = "05B1EEC895D259A0FF8852CB7B561E5D", hash_generated_method = "257E2E15064CE40D02D3762E60F2E86F")
    public  MifareClassic(Tag tag) throws RemoteException {
        super(tag, TagTechnology.MIFARE_CLASSIC);
        NfcA a;
        a = NfcA.get(tag);
        mIsEmulated = false;
        {
            Object var93ACA3F0B48D9F602F8D7CF917D09E5E_1671307737 = (a.getSak());
            //Begin case 0x08 
            mType = TYPE_CLASSIC;
            //End case 0x08 
            //Begin case 0x08 
            mSize = SIZE_1K;
            //End case 0x08 
            //Begin case 0x09 
            mType = TYPE_CLASSIC;
            //End case 0x09 
            //Begin case 0x09 
            mSize = SIZE_MINI;
            //End case 0x09 
            //Begin case 0x10 
            mType = TYPE_PLUS;
            //End case 0x10 
            //Begin case 0x10 
            mSize = SIZE_2K;
            //End case 0x10 
            //Begin case 0x11 
            mType = TYPE_PLUS;
            //End case 0x11 
            //Begin case 0x11 
            mSize = SIZE_4K;
            //End case 0x11 
            //Begin case 0x18 
            mType = TYPE_CLASSIC;
            //End case 0x18 
            //Begin case 0x18 
            mSize = SIZE_4K;
            //End case 0x18 
            //Begin case 0x28 
            mType = TYPE_CLASSIC;
            //End case 0x28 
            //Begin case 0x28 
            mSize = SIZE_1K;
            //End case 0x28 
            //Begin case 0x28 
            mIsEmulated = true;
            //End case 0x28 
            //Begin case 0x38 
            mType = TYPE_CLASSIC;
            //End case 0x38 
            //Begin case 0x38 
            mSize = SIZE_4K;
            //End case 0x38 
            //Begin case 0x38 
            mIsEmulated = true;
            //End case 0x38 
            //Begin case 0x88 
            mType = TYPE_CLASSIC;
            //End case 0x88 
            //Begin case 0x88 
            mSize = SIZE_1K;
            //End case 0x88 
            //Begin case 0x98 0xB8 
            mType = TYPE_PRO;
            //End case 0x98 0xB8 
            //Begin case 0x98 0xB8 
            mSize = SIZE_4K;
            //End case 0x98 0xB8 
            //Begin case default 
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                    "Tag incorrectly enumerated as MIFARE Classic, SAK = " + a.getSak());
            //End case default 
        } //End collapsed parenthetic
        addTaint(tag.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:25.004 -0400", hash_original_method = "E9AD68D49398B2B9D86D12D221B14582", hash_generated_method = "906BA3C466CB9CA0E53AA906FA911EB8")
    public int getType() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2140298216 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2140298216;
        // ---------- Original Method ----------
        //return mType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:25.005 -0400", hash_original_method = "2098B918320D3D5229820CAB47C60E59", hash_generated_method = "A85EDEF1E20060D4653C84BA6C083EA2")
    public int getSize() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1934237781 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1934237781;
        // ---------- Original Method ----------
        //return mSize;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:25.005 -0400", hash_original_method = "571F1D61EE68738D4B1083BD48C02876", hash_generated_method = "6096310C012522ACFD1F5E5A5C5C3D20")
    public boolean isEmulated() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_193146556 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_193146556;
        // ---------- Original Method ----------
        //return mIsEmulated;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:25.017 -0400", hash_original_method = "4AAA3C3D329C939FDD63EF1F58378EDA", hash_generated_method = "D98E57AF9416332A0658B8E169BA6D86")
    public int getSectorCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_916075653 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_916075653;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:25.020 -0400", hash_original_method = "94025DFC316C8F4CE80BFCF15B00E224", hash_generated_method = "4A54E849738D2833173FD767F69D0ECF")
    public int getBlockCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1473712661 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1473712661;
        // ---------- Original Method ----------
        //return mSize / BLOCK_SIZE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:25.021 -0400", hash_original_method = "4046C9F5F79A621BBA2F7BE2C9D1103D", hash_generated_method = "96F62B75E6DFBADC70D09C61F8D106D6")
    public int getBlockCountInSector(int sectorIndex) {
        validateSector(sectorIndex);
        addTaint(sectorIndex);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_992072213 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_992072213;
        // ---------- Original Method ----------
        //validateSector(sectorIndex);
        //if (sectorIndex < 32) {
            //return 4;
        //} else {
            //return 16;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:25.022 -0400", hash_original_method = "54173D46B73CE605A7C420967C72CF9C", hash_generated_method = "B637750A1C4F06E89E8E35E97415889C")
    public int blockToSector(int blockIndex) {
        validateBlock(blockIndex);
        addTaint(blockIndex);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1875105330 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1875105330;
        // ---------- Original Method ----------
        //validateBlock(blockIndex);
        //if (blockIndex < 32 * 4) {
            //return blockIndex / 4;
        //} else {
            //return 32 + (blockIndex - 32 * 4) / 16;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:25.022 -0400", hash_original_method = "9D4F0360D229F71B4914DA14E59850F0", hash_generated_method = "42FF955D71EAE9008AD4C29F920D5E12")
    public int sectorToBlock(int sectorIndex) {
        addTaint(sectorIndex);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_800183355 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_800183355;
        // ---------- Original Method ----------
        //if (sectorIndex < 32) {
            //return sectorIndex * 4;
        //} else {
            //return 32 * 4 + (sectorIndex - 32) * 16;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:25.034 -0400", hash_original_method = "88C199BE0D888C3B911ED6B5CDCE45B3", hash_generated_method = "4C3933D4CDB4656D560CC53EEC9CD826")
    public boolean authenticateSectorWithKeyA(int sectorIndex, byte[] key) throws IOException {
        boolean var67D2AC1426E5D4EAA35E8B99318A4DB5_551639978 = (authenticate(sectorIndex, key, true));
        addTaint(sectorIndex);
        addTaint(key[0]);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_572835499 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_572835499;
        // ---------- Original Method ----------
        //return authenticate(sectorIndex, key, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:25.036 -0400", hash_original_method = "18C51006B4E85BDBA44E7C237EA48ACA", hash_generated_method = "05AC9941EE6F58B1EE2DEE9BCFA8BA8B")
    public boolean authenticateSectorWithKeyB(int sectorIndex, byte[] key) throws IOException {
        boolean varDB5EB89BC26E94298B5CAAB9335E343E_589257799 = (authenticate(sectorIndex, key, false));
        addTaint(sectorIndex);
        addTaint(key[0]);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1049809453 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1049809453;
        // ---------- Original Method ----------
        //return authenticate(sectorIndex, key, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:25.055 -0400", hash_original_method = "A4BE9C6E30E6595D3E1AAF1825AE0C43", hash_generated_method = "C468ED0D7A73F9912B5A0C046AF027C2")
    private boolean authenticate(int sector, byte[] key, boolean keyA) throws IOException {
        validateSector(sector);
        checkConnected();
        byte[] cmd;
        cmd = new byte[12];
        {
            cmd[0] = 0x60;
        } //End block
        {
            cmd[0] = 0x61;
        } //End block
        cmd[1] = (byte) sectorToBlock(sector);
        byte[] uid;
        uid = getTag().getId();
        System.arraycopy(uid, uid.length - 4, cmd, 2, 4);
        System.arraycopy(key, 0, cmd, 6, 6);
        try 
        {
            {
                boolean var5370808FB2F9D1ED4068896E6CB2FBD7_591431689 = (transceive(cmd, false) != null);
            } //End collapsed parenthetic
        } //End block
        catch (TagLostException e)
        {
            if (DroidSafeAndroidRuntime.control) throw e;
        } //End block
        catch (IOException e)
        { }
        addTaint(sector);
        addTaint(key[0]);
        addTaint(keyA);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1224143600 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1224143600;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:25.056 -0400", hash_original_method = "540E686F2680F6F111FB5FE029F249C7", hash_generated_method = "17AB98BA1921CD8BD2C9AC6E50CC05E7")
    public byte[] readBlock(int blockIndex) throws IOException {
        validateBlock(blockIndex);
        checkConnected();
        byte[] cmd;
        byte[] var74A337D194F2176A733474958A472577_1042230854 = (transceive(cmd, false));
        addTaint(blockIndex);
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1865843699 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1865843699;
        // ---------- Original Method ----------
        //validateBlock(blockIndex);
        //checkConnected();
        //byte[] cmd = { 0x30, (byte) blockIndex };
        //return transceive(cmd, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:25.061 -0400", hash_original_method = "6EB213EA4DA32B7A4304947C71CED66E", hash_generated_method = "3045E78DD753DDB0CFD3AEA4FC1635FD")
    public void writeBlock(int blockIndex, byte[] data) throws IOException {
        validateBlock(blockIndex);
        checkConnected();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("must write 16-bytes");
        } //End block
        byte[] cmd;
        cmd = new byte[data.length + 2];
        cmd[0] = (byte) 0xA0;
        cmd[1] = (byte) blockIndex;
        System.arraycopy(data, 0, cmd, 2, data.length);
        transceive(cmd, false);
        addTaint(blockIndex);
        addTaint(data[0]);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:25.072 -0400", hash_original_method = "B8563CE393F659B55E0B9D3772EFE7A6", hash_generated_method = "CF0BBFF240F6CF097CD899963DAF69FF")
    public void increment(int blockIndex, int value) throws IOException {
        validateBlock(blockIndex);
        validateValueOperand(value);
        checkConnected();
        ByteBuffer cmd;
        cmd = ByteBuffer.allocate(6);
        cmd.order(ByteOrder.LITTLE_ENDIAN);
        cmd.put( (byte) 0xC1 );
        cmd.put( (byte) blockIndex );
        cmd.putInt(value);
        transceive(cmd.array(), false);
        addTaint(blockIndex);
        addTaint(value);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:25.075 -0400", hash_original_method = "FAA38C9F5E4C186E0FA530C9A1909DAD", hash_generated_method = "D20762ACCE14EDDE90E6D9840E3D89E1")
    public void decrement(int blockIndex, int value) throws IOException {
        validateBlock(blockIndex);
        validateValueOperand(value);
        checkConnected();
        ByteBuffer cmd;
        cmd = ByteBuffer.allocate(6);
        cmd.order(ByteOrder.LITTLE_ENDIAN);
        cmd.put( (byte) 0xC0 );
        cmd.put( (byte) blockIndex );
        cmd.putInt(value);
        transceive(cmd.array(), false);
        addTaint(blockIndex);
        addTaint(value);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:25.076 -0400", hash_original_method = "25F048093BEC30F816A6E356A5759AAE", hash_generated_method = "A6CAF9EBFF4C7631938B99A13FC94F2F")
    public void transfer(int blockIndex) throws IOException {
        validateBlock(blockIndex);
        checkConnected();
        byte[] cmd;
        transceive(cmd, false);
        addTaint(blockIndex);
        // ---------- Original Method ----------
        //validateBlock(blockIndex);
        //checkConnected();
        //byte[] cmd = { (byte) 0xB0, (byte) blockIndex };
        //transceive(cmd, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:25.094 -0400", hash_original_method = "CA1FBC952F4C8F3DF96DFF31BC2893A2", hash_generated_method = "5A58842E4F9DEA29D36A90C079EF4AD0")
    public void restore(int blockIndex) throws IOException {
        validateBlock(blockIndex);
        checkConnected();
        byte[] cmd;
        transceive(cmd, false);
        addTaint(blockIndex);
        // ---------- Original Method ----------
        //validateBlock(blockIndex);
        //checkConnected();
        //byte[] cmd = { (byte) 0xC2, (byte) blockIndex };
        //transceive(cmd, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:25.095 -0400", hash_original_method = "E43990821CE38E04B46B3E901EFDFA24", hash_generated_method = "BCE65F858C5355D5AFD298213661BF03")
    public byte[] transceive(byte[] data) throws IOException {
        byte[] var457CAD28AA5A950818B34ED801FB2565_1475708086 = (transceive(data, true));
        addTaint(data[0]);
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1015565156 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1015565156;
        // ---------- Original Method ----------
        //return transceive(data, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:25.095 -0400", hash_original_method = "CF96EF3BF3FCE4DA3D9E7FBB541AEB70", hash_generated_method = "0B1ACC923AA67E1B46EFFE5719CBB2D0")
    public int getMaxTransceiveLength() {
        int varAD50EB2A6987338433A93D587AD15277_63057631 = (getMaxTransceiveLengthInternal());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1275825780 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1275825780;
        // ---------- Original Method ----------
        //return getMaxTransceiveLengthInternal();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:25.096 -0400", hash_original_method = "F9EC6D04AED06B3DFE22DC9A2A8AC0C3", hash_generated_method = "EF5C57DD49222545E19E7DD873FE4180")
    public void setTimeout(int timeout) {
        try 
        {
            int err;
            err = mTag.getTagService().setTimeout(TagTechnology.MIFARE_CLASSIC, timeout);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("The supplied timeout is not valid");
            } //End block
        } //End block
        catch (RemoteException e)
        { }
        addTaint(timeout);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:25.126 -0400", hash_original_method = "59718E6CF1FABD433F7C060A44E5C453", hash_generated_method = "BEBE0A6D8C05B2C9CD7FA3DFB84A24D9")
    public int getTimeout() {
        try 
        {
            int var5DDA3B385C812217F69F954990357FF1_710657321 = (mTag.getTagService().getTimeout(TagTechnology.MIFARE_CLASSIC));
        } //End block
        catch (RemoteException e)
        { }
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_798011192 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_798011192;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:25.131 -0400", hash_original_field = "839E89798F641D78E99C5732B39CA844", hash_generated_field = "75254E4C21911FCCBBD25490236328DA")

    private static String TAG = "NFC";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:25.132 -0400", hash_original_field = "F43B62ACBEF62955A892A0125C4E97AC", hash_generated_field = "54FD0024ABE4EEEC2428AB757D9F3016")

    public static final byte[] KEY_DEFAULT =
            {(byte)0xFF,(byte)0xFF,(byte)0xFF,(byte)0xFF,(byte)0xFF,(byte)0xFF};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:25.132 -0400", hash_original_field = "21F9D525110FC9DDAD2D96449A9406BF", hash_generated_field = "15DB5DCB955364C48035DA5E4E953740")

    public static final byte[] KEY_MIFARE_APPLICATION_DIRECTORY =
            {(byte)0xA0,(byte)0xA1,(byte)0xA2,(byte)0xA3,(byte)0xA4,(byte)0xA5};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:25.132 -0400", hash_original_field = "E003BDDE321126A7175909200065CC96", hash_generated_field = "12E87E1D5AC9EA588363E4D80F1B1001")

    public static final byte[] KEY_NFC_FORUM =
            {(byte)0xD3,(byte)0xF7,(byte)0xD3,(byte)0xF7,(byte)0xD3,(byte)0xF7};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:25.132 -0400", hash_original_field = "5034A85BF931B74EFB4900211957B4BB", hash_generated_field = "384725A35AE2048CC01CB14C667E6F8D")

    public static final int TYPE_UNKNOWN = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:25.132 -0400", hash_original_field = "296852A8BBEF25A87785985C2BC0DFC5", hash_generated_field = "7061FCCEF7055B824FD2AA480431DCC6")

    public static final int TYPE_CLASSIC = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:25.132 -0400", hash_original_field = "ECD0E35FE52D2DE30F387A5A130B6976", hash_generated_field = "4E9412DEFDF67F37DBAB413F0A64A35E")

    public static final int TYPE_PLUS = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:25.132 -0400", hash_original_field = "6712F118318BDDE896831243EAB79997", hash_generated_field = "E54C8D8F5C6AB4014CB13C1AA7F26768")

    public static final int TYPE_PRO = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:25.132 -0400", hash_original_field = "44E5C75C5C9E25B08F5E8DAB7426A47C", hash_generated_field = "1768559A5BB2B8E1D785D5C51528A7E2")

    public static final int SIZE_1K = 1024;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:25.132 -0400", hash_original_field = "38245792A1CA3B41429F8B68D818111D", hash_generated_field = "29839D581DC916610DC52670577D996D")

    public static final int SIZE_2K = 2048;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:25.132 -0400", hash_original_field = "CAB6DD92345B3C8AFAF46DAB9D8D88A7", hash_generated_field = "901EEE828F9926FE0467F5BB2C7B7D08")

    public static final int SIZE_4K = 4096;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:25.132 -0400", hash_original_field = "2DBC1251377F3758534631A170319E57", hash_generated_field = "042D532175870A55F83E79C5988117F4")

    public static final int SIZE_MINI = 320;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:25.132 -0400", hash_original_field = "B38149A434660ADA03E33C84BD3F6CED", hash_generated_field = "195B8DA56AF39DED77508EB085D1B2A5")

    public static final int BLOCK_SIZE = 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:25.132 -0400", hash_original_field = "BD15FD57804DE3BC7D61C9ABF03CBDC3", hash_generated_field = "98B4C398CCF76EC16F2BF0FCFBEE4774")

    private static int MAX_BLOCK_COUNT = 256;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:25.132 -0400", hash_original_field = "B6DBE45B32DD2B5C973502062E9E9DAD", hash_generated_field = "1B1E760F5090D5ADDF66585E83C497A2")

    private static int MAX_SECTOR_COUNT = 40;
}

