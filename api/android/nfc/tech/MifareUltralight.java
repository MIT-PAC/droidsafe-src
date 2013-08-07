package android.nfc.tech;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.IOException;

import android.nfc.ErrorCodes;
import android.nfc.Tag;
import android.os.Bundle;
import android.os.RemoteException;





public final class MifareUltralight extends BasicTagTechnology {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.592 -0400", hash_original_field = "3462A1A18A0EE070E8953CCF1DD788C0", hash_generated_field = "E6B4AC7A48E0E54E09A504C828AF50C5")

    private int mType;
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.595 -0400", hash_original_method = "3735B86C07F91E8515EC1CC320AAC040", hash_generated_method = "3C72592533B102A1DF1BFDAACD562651")
    public  MifareUltralight(Tag tag) throws RemoteException {
        super(tag, TagTechnology.MIFARE_ULTRALIGHT);
        addTaint(tag.getTaint());
        NfcA a = NfcA.get(tag);
        mType = TYPE_UNKNOWN;
        if(a.getSak() == 0x00 && tag.getId()[0] == NXP_MANUFACTURER_ID)        
        {
            Bundle extras = tag.getTechExtras(TagTechnology.MIFARE_ULTRALIGHT);
            if(extras.getBoolean(EXTRA_IS_UL_C))            
            {
                mType = TYPE_ULTRALIGHT_C;
            } //End block
            else
            {
                mType = TYPE_ULTRALIGHT;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //NfcA a = NfcA.get(tag);
        //mType = TYPE_UNKNOWN;
        //if (a.getSak() == 0x00 && tag.getId()[0] == NXP_MANUFACTURER_ID) {
            //Bundle extras = tag.getTechExtras(TagTechnology.MIFARE_ULTRALIGHT);
            //if (extras.getBoolean(EXTRA_IS_UL_C)) {
                //mType = TYPE_ULTRALIGHT_C;
            //} else {
                //mType = TYPE_ULTRALIGHT;
            //}
        //}
    }

    
    public static MifareUltralight get(Tag tag) {
        if (!tag.hasTech(TagTechnology.MIFARE_ULTRALIGHT)) return null;
        try {
            return new MifareUltralight(tag);
        } catch (RemoteException e) {
            return null;
        }
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.598 -0400", hash_original_method = "E9AD68D49398B2B9D86D12D221B14582", hash_generated_method = "C734F436F64F67A64DBF035F941AB075")
    public int getType() {
        int var3462A1A18A0EE070E8953CCF1DD788C0_305816356 = (mType);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_936541494 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_936541494;
        // ---------- Original Method ----------
        //return mType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.599 -0400", hash_original_method = "E6849E923D0A9327C443A073C34E8740", hash_generated_method = "7697E44012F199CD46A9B6511C81BFD7")
    public byte[] readPages(int pageOffset) throws IOException {
        addTaint(pageOffset);
        validatePageIndex(pageOffset);
        checkConnected();
        byte[] cmd = { 0x30, (byte) pageOffset};
        byte[] var8E202568BEDD06F864FDA8E60E6C3088_1433089184 = (transceive(cmd, false));
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1563050445 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1563050445;
        // ---------- Original Method ----------
        //validatePageIndex(pageOffset);
        //checkConnected();
        //byte[] cmd = { 0x30, (byte) pageOffset};
        //return transceive(cmd, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.601 -0400", hash_original_method = "76B1D0EF2AB1E41E6168EFDF0BF06314", hash_generated_method = "40BB5D67D891F92DB783A462F6CD6CA0")
    public void writePage(int pageOffset, byte[] data) throws IOException {
        addTaint(data[0]);
        addTaint(pageOffset);
        validatePageIndex(pageOffset);
        checkConnected();
        byte[] cmd = new byte[data.length + 2];
        cmd[0] = (byte) 0xA2;
        cmd[1] = (byte) pageOffset;
        System.arraycopy(data, 0, cmd, 2, data.length);
        transceive(cmd, false);
        // ---------- Original Method ----------
        //validatePageIndex(pageOffset);
        //checkConnected();
        //byte[] cmd = new byte[data.length + 2];
        //cmd[0] = (byte) 0xA2;
        //cmd[1] = (byte) pageOffset;
        //System.arraycopy(data, 0, cmd, 2, data.length);
        //transceive(cmd, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.605 -0400", hash_original_method = "E43990821CE38E04B46B3E901EFDFA24", hash_generated_method = "4DDA0288293ECACA4574848484AF2019")
    public byte[] transceive(byte[] data) throws IOException {
        addTaint(data[0]);
        byte[] varEE32C696607EBC614D9A30134ACB1AE3_355008729 = (transceive(data, true));
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_834905808 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_834905808;
        // ---------- Original Method ----------
        //return transceive(data, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.606 -0400", hash_original_method = "CF96EF3BF3FCE4DA3D9E7FBB541AEB70", hash_generated_method = "997C03FD58B3D726541C73D98B06BDAB")
    public int getMaxTransceiveLength() {
        int var534FE261D7083B235B3B010A14A83EE1_476963268 = (getMaxTransceiveLengthInternal());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_70925254 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_70925254;
        // ---------- Original Method ----------
        //return getMaxTransceiveLengthInternal();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.607 -0400", hash_original_method = "D282B40A7C0A3209AA4502B842BB4FB3", hash_generated_method = "3810B68B5DDD147E93B187D50BBB4A7A")
    public void setTimeout(int timeout) {
        addTaint(timeout);
        try 
        {
            int err = mTag.getTagService().setTimeout(
                    TagTechnology.MIFARE_ULTRALIGHT, timeout);
            if(err != ErrorCodes.SUCCESS)            
            {
                IllegalArgumentException varDB68BEF11A046B44BA82450BD6BDD1ED_1627647806 = new IllegalArgumentException("The supplied timeout is not valid");
                varDB68BEF11A046B44BA82450BD6BDD1ED_1627647806.addTaint(taint);
                throw varDB68BEF11A046B44BA82450BD6BDD1ED_1627647806;
            } //End block
        } //End block
        catch (RemoteException e)
        {
        } //End block
        // ---------- Original Method ----------
        //try {
            //int err = mTag.getTagService().setTimeout(
                    //TagTechnology.MIFARE_ULTRALIGHT, timeout);
            //if (err != ErrorCodes.SUCCESS) {
                //throw new IllegalArgumentException("The supplied timeout is not valid");
            //}
        //} catch (RemoteException e) {
            //Log.e(TAG, "NFC service dead", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.608 -0400", hash_original_method = "849E2A68F4F80A968E68483D2D0B1744", hash_generated_method = "5B1651843AF2F4BDAF6C88C1FCC1303E")
    public int getTimeout() {
        try 
        {
            int var714BFC2CAF19A2E2B5C524B9434C7348_1432386385 = (mTag.getTagService().getTimeout(TagTechnology.MIFARE_ULTRALIGHT));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1746381979 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1746381979;
        } //End block
        catch (RemoteException e)
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_127543916 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_455409933 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_455409933;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mTag.getTagService().getTimeout(TagTechnology.MIFARE_ULTRALIGHT);
        //} catch (RemoteException e) {
            //Log.e(TAG, "NFC service dead", e);
            //return 0;
        //}
    }

    
    @DSModeled(DSC.BAN)
    private static void validatePageIndex(int pageIndex) {
        if (pageIndex < 0 || pageIndex >= MAX_PAGE_COUNT) {
            throw new IndexOutOfBoundsException("page out of bounds: " + pageIndex);
        }
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.609 -0400", hash_original_field = "839E89798F641D78E99C5732B39CA844", hash_generated_field = "BC8F11E4AEAD11E0412B7B53DF0CA6C8")

    private static final String TAG = "NFC";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.610 -0400", hash_original_field = "5034A85BF931B74EFB4900211957B4BB", hash_generated_field = "384725A35AE2048CC01CB14C667E6F8D")

    public static final int TYPE_UNKNOWN = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.610 -0400", hash_original_field = "47B4CB8E43E4243984FB1A0BBD60FF47", hash_generated_field = "9BE3F76DF00EB59F29F6A17EB828F767")

    public static final int TYPE_ULTRALIGHT = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.610 -0400", hash_original_field = "628F4D3130A60463AA6CE32CEA1963B7", hash_generated_field = "84E7082E6CDB244EAD32A3F8AC3B8CF8")

    public static final int TYPE_ULTRALIGHT_C = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.610 -0400", hash_original_field = "62FE3CF583A48879AD81D4FC31C07455", hash_generated_field = "65A194E1705A84CF4A535345BE21CB60")

    public static final int PAGE_SIZE = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.611 -0400", hash_original_field = "566CBFF0277A2C026E70DD4FCC21FD3B", hash_generated_field = "06570E4E13E0E5C4F5DAEA0BCB6353F6")

    private static final int NXP_MANUFACTURER_ID = 0x04;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.611 -0400", hash_original_field = "E058148AA489216EF5EDD6CF5754000D", hash_generated_field = "712A7209011F6BE783946B2F4E26F18C")

    private static final int MAX_PAGE_COUNT = 256;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.611 -0400", hash_original_field = "ACBDBFAD96A9FB10A1D9E45886B4E84A", hash_generated_field = "4962E30417FE0FA3945478E0C7DB1FD0")

    public static final String EXTRA_IS_UL_C = "isulc";
}

