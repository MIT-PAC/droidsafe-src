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
    private boolean mIsEmulated;
    private int mType;
    private int mSize;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.167 -0400", hash_original_method = "05B1EEC895D259A0FF8852CB7B561E5D", hash_generated_method = "255AB1F1AAFD78C13997E6D61B6722F8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public MifareClassic(Tag tag) throws RemoteException {
        super(tag, TagTechnology.MIFARE_CLASSIC);
        dsTaint.addTaint(tag.dsTaint);
        NfcA a;
        a = NfcA.get(tag);
        mIsEmulated = false;
        {
            Object var93ACA3F0B48D9F602F8D7CF917D09E5E_1681438158 = (a.getSak());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.168 -0400", hash_original_method = "E9AD68D49398B2B9D86D12D221B14582", hash_generated_method = "66DFEA4B0062EB4492784966BCFD516E")
    @DSModeled(DSC.SAFE)
    public int getType() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.169 -0400", hash_original_method = "2098B918320D3D5229820CAB47C60E59", hash_generated_method = "207A3638E898A3E1BCC3A8ED35B62B90")
    @DSModeled(DSC.SAFE)
    public int getSize() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mSize;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.170 -0400", hash_original_method = "571F1D61EE68738D4B1083BD48C02876", hash_generated_method = "F89BDA307717C3715F9C00DA4F7C31F5")
    @DSModeled(DSC.SAFE)
    public boolean isEmulated() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mIsEmulated;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.171 -0400", hash_original_method = "4AAA3C3D329C939FDD63EF1F58378EDA", hash_generated_method = "24D8E2750D38C00BB17B54D8BB2B68EE")
    @DSModeled(DSC.SAFE)
    public int getSectorCount() {
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.171 -0400", hash_original_method = "94025DFC316C8F4CE80BFCF15B00E224", hash_generated_method = "93E75D0CAA563BE71BA2691A3E123B63")
    @DSModeled(DSC.SAFE)
    public int getBlockCount() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mSize / BLOCK_SIZE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.171 -0400", hash_original_method = "4046C9F5F79A621BBA2F7BE2C9D1103D", hash_generated_method = "CCA714C4463B938163E1461A37E258D0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getBlockCountInSector(int sectorIndex) {
        dsTaint.addTaint(sectorIndex);
        validateSector(sectorIndex);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //validateSector(sectorIndex);
        //if (sectorIndex < 32) {
            //return 4;
        //} else {
            //return 16;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.171 -0400", hash_original_method = "54173D46B73CE605A7C420967C72CF9C", hash_generated_method = "4590908C3D11CF36B3B59ABF3EE6FBFF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int blockToSector(int blockIndex) {
        dsTaint.addTaint(blockIndex);
        validateBlock(blockIndex);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //validateBlock(blockIndex);
        //if (blockIndex < 32 * 4) {
            //return blockIndex / 4;
        //} else {
            //return 32 + (blockIndex - 32 * 4) / 16;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.172 -0400", hash_original_method = "9D4F0360D229F71B4914DA14E59850F0", hash_generated_method = "AE1B43137D260DBA108B39C07672644D")
    @DSModeled(DSC.SAFE)
    public int sectorToBlock(int sectorIndex) {
        dsTaint.addTaint(sectorIndex);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (sectorIndex < 32) {
            //return sectorIndex * 4;
        //} else {
            //return 32 * 4 + (sectorIndex - 32) * 16;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.172 -0400", hash_original_method = "88C199BE0D888C3B911ED6B5CDCE45B3", hash_generated_method = "D4CDDEF8080A0BE7794B7279F47A9403")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean authenticateSectorWithKeyA(int sectorIndex, byte[] key) throws IOException {
        dsTaint.addTaint(sectorIndex);
        dsTaint.addTaint(key[0]);
        boolean var67D2AC1426E5D4EAA35E8B99318A4DB5_244284607 = (authenticate(sectorIndex, key, true));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return authenticate(sectorIndex, key, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.172 -0400", hash_original_method = "18C51006B4E85BDBA44E7C237EA48ACA", hash_generated_method = "4B6D37AB2493CEDA65BA826DFB399E6E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean authenticateSectorWithKeyB(int sectorIndex, byte[] key) throws IOException {
        dsTaint.addTaint(sectorIndex);
        dsTaint.addTaint(key[0]);
        boolean varDB5EB89BC26E94298B5CAAB9335E343E_1983654397 = (authenticate(sectorIndex, key, false));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return authenticate(sectorIndex, key, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.173 -0400", hash_original_method = "A4BE9C6E30E6595D3E1AAF1825AE0C43", hash_generated_method = "1C20A00A75E16D7CD4C063027A1EFF76")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean authenticate(int sector, byte[] key, boolean keyA) throws IOException {
        dsTaint.addTaint(keyA);
        dsTaint.addTaint(sector);
        dsTaint.addTaint(key[0]);
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
                boolean var5370808FB2F9D1ED4068896E6CB2FBD7_19779875 = (transceive(cmd, false) != null);
            } //End collapsed parenthetic
        } //End block
        catch (TagLostException e)
        {
            if (DroidSafeAndroidRuntime.control) throw e;
        } //End block
        catch (IOException e)
        { }
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.173 -0400", hash_original_method = "540E686F2680F6F111FB5FE029F249C7", hash_generated_method = "A76D0A76C70D1931AF7D6F53209937EC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public byte[] readBlock(int blockIndex) throws IOException {
        dsTaint.addTaint(blockIndex);
        validateBlock(blockIndex);
        checkConnected();
        byte[] cmd;
        byte[] var74A337D194F2176A733474958A472577_1440877582 = (transceive(cmd, false));
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //validateBlock(blockIndex);
        //checkConnected();
        //byte[] cmd = { 0x30, (byte) blockIndex };
        //return transceive(cmd, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.173 -0400", hash_original_method = "6EB213EA4DA32B7A4304947C71CED66E", hash_generated_method = "301FA8EE40626F49FE6D9F18952AC0D2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeBlock(int blockIndex, byte[] data) throws IOException {
        dsTaint.addTaint(blockIndex);
        dsTaint.addTaint(data[0]);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.174 -0400", hash_original_method = "B8563CE393F659B55E0B9D3772EFE7A6", hash_generated_method = "48E9EB70CDC34D176C80CDCE0319657E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void increment(int blockIndex, int value) throws IOException {
        dsTaint.addTaint(blockIndex);
        dsTaint.addTaint(value);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.174 -0400", hash_original_method = "FAA38C9F5E4C186E0FA530C9A1909DAD", hash_generated_method = "AF637A3F64C2EB7426181B19E6A6B078")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void decrement(int blockIndex, int value) throws IOException {
        dsTaint.addTaint(blockIndex);
        dsTaint.addTaint(value);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.175 -0400", hash_original_method = "25F048093BEC30F816A6E356A5759AAE", hash_generated_method = "5764BAAC7D6593B40324F405DDA155B1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void transfer(int blockIndex) throws IOException {
        dsTaint.addTaint(blockIndex);
        validateBlock(blockIndex);
        checkConnected();
        byte[] cmd;
        transceive(cmd, false);
        // ---------- Original Method ----------
        //validateBlock(blockIndex);
        //checkConnected();
        //byte[] cmd = { (byte) 0xB0, (byte) blockIndex };
        //transceive(cmd, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.175 -0400", hash_original_method = "CA1FBC952F4C8F3DF96DFF31BC2893A2", hash_generated_method = "136490CC4678AF4A0CE2347C2A6B81F1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void restore(int blockIndex) throws IOException {
        dsTaint.addTaint(blockIndex);
        validateBlock(blockIndex);
        checkConnected();
        byte[] cmd;
        transceive(cmd, false);
        // ---------- Original Method ----------
        //validateBlock(blockIndex);
        //checkConnected();
        //byte[] cmd = { (byte) 0xC2, (byte) blockIndex };
        //transceive(cmd, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.175 -0400", hash_original_method = "E43990821CE38E04B46B3E901EFDFA24", hash_generated_method = "5668DEB4198383C620B067AE78D244A0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public byte[] transceive(byte[] data) throws IOException {
        dsTaint.addTaint(data[0]);
        byte[] var457CAD28AA5A950818B34ED801FB2565_1395060628 = (transceive(data, true));
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //return transceive(data, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.175 -0400", hash_original_method = "CF96EF3BF3FCE4DA3D9E7FBB541AEB70", hash_generated_method = "3F698369EC62712D29B65F8036594C22")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getMaxTransceiveLength() {
        int varAD50EB2A6987338433A93D587AD15277_1789873756 = (getMaxTransceiveLengthInternal());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return getMaxTransceiveLengthInternal();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.176 -0400", hash_original_method = "F9EC6D04AED06B3DFE22DC9A2A8AC0C3", hash_generated_method = "B96391F73317C250D4F699669C99D806")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setTimeout(int timeout) {
        dsTaint.addTaint(timeout);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.176 -0400", hash_original_method = "59718E6CF1FABD433F7C060A44E5C453", hash_generated_method = "1B79D7D1179291191B9F5C6D68BC5DD0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getTimeout() {
        try 
        {
            int var5DDA3B385C812217F69F954990357FF1_1883568454 = (mTag.getTagService().getTimeout(TagTechnology.MIFARE_CLASSIC));
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintInt();
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

    
    private static final String TAG = "NFC";
    public static final byte[] KEY_DEFAULT =
            {(byte)0xFF,(byte)0xFF,(byte)0xFF,(byte)0xFF,(byte)0xFF,(byte)0xFF};
    public static final byte[] KEY_MIFARE_APPLICATION_DIRECTORY =
            {(byte)0xA0,(byte)0xA1,(byte)0xA2,(byte)0xA3,(byte)0xA4,(byte)0xA5};
    public static final byte[] KEY_NFC_FORUM =
            {(byte)0xD3,(byte)0xF7,(byte)0xD3,(byte)0xF7,(byte)0xD3,(byte)0xF7};
    public static final int TYPE_UNKNOWN = -1;
    public static final int TYPE_CLASSIC = 0;
    public static final int TYPE_PLUS = 1;
    public static final int TYPE_PRO = 2;
    public static final int SIZE_1K = 1024;
    public static final int SIZE_2K = 2048;
    public static final int SIZE_4K = 4096;
    public static final int SIZE_MINI = 320;
    public static final int BLOCK_SIZE = 16;
    private static final int MAX_BLOCK_COUNT = 256;
    private static final int MAX_SECTOR_COUNT = 40;
}

