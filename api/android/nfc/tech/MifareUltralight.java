package android.nfc.tech;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.nfc.ErrorCodes;
import android.nfc.Tag;
import android.nfc.TagLostException;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import java.io.IOException;

public final class MifareUltralight extends BasicTagTechnology {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.919 -0400", hash_original_field = "3462A1A18A0EE070E8953CCF1DD788C0", hash_generated_field = "E6B4AC7A48E0E54E09A504C828AF50C5")

    private int mType;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.920 -0400", hash_original_method = "3735B86C07F91E8515EC1CC320AAC040", hash_generated_method = "3C72592533B102A1DF1BFDAACD562651")
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
            } 
            else
            {
                mType = TYPE_ULTRALIGHT;
            } 
        } 
        
        
        
        
            
            
                
            
                
            
        
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.921 -0400", hash_original_method = "E9AD68D49398B2B9D86D12D221B14582", hash_generated_method = "51B4205BDA63620D767B878582FDE331")
    public int getType() {
        int var3462A1A18A0EE070E8953CCF1DD788C0_558013965 = (mType);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2083991614 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2083991614;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.921 -0400", hash_original_method = "E6849E923D0A9327C443A073C34E8740", hash_generated_method = "FAD50744A86C40E6E41344491ED65AF8")
    public byte[] readPages(int pageOffset) throws IOException {
        addTaint(pageOffset);
        validatePageIndex(pageOffset);
        checkConnected();
        byte[] cmd = { 0x30, (byte) pageOffset};
        byte[] var8E202568BEDD06F864FDA8E60E6C3088_829631729 = (transceive(cmd, false));
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_744660648 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_744660648;
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.922 -0400", hash_original_method = "76B1D0EF2AB1E41E6168EFDF0BF06314", hash_generated_method = "40BB5D67D891F92DB783A462F6CD6CA0")
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
        
        
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.922 -0400", hash_original_method = "E43990821CE38E04B46B3E901EFDFA24", hash_generated_method = "E00FBA19F970DD88ED8C8935B34EA4A8")
    public byte[] transceive(byte[] data) throws IOException {
        addTaint(data[0]);
        byte[] varEE32C696607EBC614D9A30134ACB1AE3_939282023 = (transceive(data, true));
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_364249436 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_364249436;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.922 -0400", hash_original_method = "CF96EF3BF3FCE4DA3D9E7FBB541AEB70", hash_generated_method = "F8735C3E076C9C48A560F3B9FF601E97")
    public int getMaxTransceiveLength() {
        int var534FE261D7083B235B3B010A14A83EE1_210312361 = (getMaxTransceiveLengthInternal());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1051761196 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1051761196;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.922 -0400", hash_original_method = "D282B40A7C0A3209AA4502B842BB4FB3", hash_generated_method = "46D758F8F7741D398E4241D0422082D6")
    public void setTimeout(int timeout) {
        addTaint(timeout);
        try 
        {
            int err = mTag.getTagService().setTimeout(
                    TagTechnology.MIFARE_ULTRALIGHT, timeout);
    if(err != ErrorCodes.SUCCESS)            
            {
                IllegalArgumentException varDB68BEF11A046B44BA82450BD6BDD1ED_1368946426 = new IllegalArgumentException("The supplied timeout is not valid");
                varDB68BEF11A046B44BA82450BD6BDD1ED_1368946426.addTaint(taint);
                throw varDB68BEF11A046B44BA82450BD6BDD1ED_1368946426;
            } 
        } 
        catch (RemoteException e)
        {
        } 
        
        
            
                    
            
                
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.923 -0400", hash_original_method = "849E2A68F4F80A968E68483D2D0B1744", hash_generated_method = "F2E5E92790E68880FECF103B2D34603A")
    public int getTimeout() {
        try 
        {
            int var714BFC2CAF19A2E2B5C524B9434C7348_807654509 = (mTag.getTagService().getTimeout(TagTechnology.MIFARE_ULTRALIGHT));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_182416869 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_182416869;
        } 
        catch (RemoteException e)
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_1995503484 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2082218796 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2082218796;
        } 
        
        
            
        
            
            
        
    }

    
        private static void validatePageIndex(int pageIndex) {
        if (pageIndex < 0 || pageIndex >= MAX_PAGE_COUNT) {
            throw new IndexOutOfBoundsException("page out of bounds: " + pageIndex);
        }
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.923 -0400", hash_original_field = "839E89798F641D78E99C5732B39CA844", hash_generated_field = "BC8F11E4AEAD11E0412B7B53DF0CA6C8")

    private static final String TAG = "NFC";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.923 -0400", hash_original_field = "5034A85BF931B74EFB4900211957B4BB", hash_generated_field = "384725A35AE2048CC01CB14C667E6F8D")

    public static final int TYPE_UNKNOWN = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.923 -0400", hash_original_field = "47B4CB8E43E4243984FB1A0BBD60FF47", hash_generated_field = "9BE3F76DF00EB59F29F6A17EB828F767")

    public static final int TYPE_ULTRALIGHT = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.923 -0400", hash_original_field = "628F4D3130A60463AA6CE32CEA1963B7", hash_generated_field = "84E7082E6CDB244EAD32A3F8AC3B8CF8")

    public static final int TYPE_ULTRALIGHT_C = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.923 -0400", hash_original_field = "62FE3CF583A48879AD81D4FC31C07455", hash_generated_field = "65A194E1705A84CF4A535345BE21CB60")

    public static final int PAGE_SIZE = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.924 -0400", hash_original_field = "566CBFF0277A2C026E70DD4FCC21FD3B", hash_generated_field = "06570E4E13E0E5C4F5DAEA0BCB6353F6")

    private static final int NXP_MANUFACTURER_ID = 0x04;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.924 -0400", hash_original_field = "E058148AA489216EF5EDD6CF5754000D", hash_generated_field = "712A7209011F6BE783946B2F4E26F18C")

    private static final int MAX_PAGE_COUNT = 256;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.924 -0400", hash_original_field = "ACBDBFAD96A9FB10A1D9E45886B4E84A", hash_generated_field = "4962E30417FE0FA3945478E0C7DB1FD0")

    public static final String EXTRA_IS_UL_C = "isulc";
}

