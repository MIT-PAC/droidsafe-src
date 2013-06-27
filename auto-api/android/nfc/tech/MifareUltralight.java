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
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import java.io.IOException;

public final class MifareUltralight extends BasicTagTechnology {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:24.963 -0400", hash_original_field = "3462A1A18A0EE070E8953CCF1DD788C0", hash_generated_field = "E6B4AC7A48E0E54E09A504C828AF50C5")

    private int mType;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:24.978 -0400", hash_original_method = "3735B86C07F91E8515EC1CC320AAC040", hash_generated_method = "9FC0569C40379475E8BEC213D547ACFF")
    public  MifareUltralight(Tag tag) throws RemoteException {
        super(tag, TagTechnology.MIFARE_ULTRALIGHT);
        NfcA a;
        a = NfcA.get(tag);
        mType = TYPE_UNKNOWN;
        {
            boolean var6CC478771079DB48F967904DB58DBB96_1504343941 = (a.getSak() == 0x00 && tag.getId()[0] == NXP_MANUFACTURER_ID);
            {
                Bundle extras;
                extras = tag.getTechExtras(TagTechnology.MIFARE_ULTRALIGHT);
                {
                    boolean varEA469A2536A4896C86B6253DEA8C14F6_1482912594 = (extras.getBoolean(EXTRA_IS_UL_C));
                    {
                        mType = TYPE_ULTRALIGHT_C;
                    } //End block
                    {
                        mType = TYPE_ULTRALIGHT;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(tag.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:24.979 -0400", hash_original_method = "E9AD68D49398B2B9D86D12D221B14582", hash_generated_method = "44A81F8FB9650E2EBBE31BA43A840C18")
    public int getType() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_71512813 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_71512813;
        // ---------- Original Method ----------
        //return mType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:24.997 -0400", hash_original_method = "E6849E923D0A9327C443A073C34E8740", hash_generated_method = "1A2DD75C69D9B4243D8DC643DDA8E8B9")
    public byte[] readPages(int pageOffset) throws IOException {
        validatePageIndex(pageOffset);
        checkConnected();
        byte[] cmd;
        byte[] var74A337D194F2176A733474958A472577_1900186081 = (transceive(cmd, false));
        addTaint(pageOffset);
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1152551565 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1152551565;
        // ---------- Original Method ----------
        //validatePageIndex(pageOffset);
        //checkConnected();
        //byte[] cmd = { 0x30, (byte) pageOffset};
        //return transceive(cmd, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:24.999 -0400", hash_original_method = "76B1D0EF2AB1E41E6168EFDF0BF06314", hash_generated_method = "71A5B7D89A751D0B1D5BC9F016215050")
    public void writePage(int pageOffset, byte[] data) throws IOException {
        validatePageIndex(pageOffset);
        checkConnected();
        byte[] cmd;
        cmd = new byte[data.length + 2];
        cmd[0] = (byte) 0xA2;
        cmd[1] = (byte) pageOffset;
        System.arraycopy(data, 0, cmd, 2, data.length);
        transceive(cmd, false);
        addTaint(pageOffset);
        addTaint(data[0]);
        // ---------- Original Method ----------
        //validatePageIndex(pageOffset);
        //checkConnected();
        //byte[] cmd = new byte[data.length + 2];
        //cmd[0] = (byte) 0xA2;
        //cmd[1] = (byte) pageOffset;
        //System.arraycopy(data, 0, cmd, 2, data.length);
        //transceive(cmd, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:25.000 -0400", hash_original_method = "E43990821CE38E04B46B3E901EFDFA24", hash_generated_method = "8A8C52816E5ABAE20234F370C49EE652")
    public byte[] transceive(byte[] data) throws IOException {
        byte[] var457CAD28AA5A950818B34ED801FB2565_38932550 = (transceive(data, true));
        addTaint(data[0]);
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_3934343 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_3934343;
        // ---------- Original Method ----------
        //return transceive(data, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:25.014 -0400", hash_original_method = "CF96EF3BF3FCE4DA3D9E7FBB541AEB70", hash_generated_method = "E28A894C4B4EDB5EAB66A967CF59A3BB")
    public int getMaxTransceiveLength() {
        int varAD50EB2A6987338433A93D587AD15277_546656822 = (getMaxTransceiveLengthInternal());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1562248187 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1562248187;
        // ---------- Original Method ----------
        //return getMaxTransceiveLengthInternal();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:25.023 -0400", hash_original_method = "D282B40A7C0A3209AA4502B842BB4FB3", hash_generated_method = "C322D09F99592A247E626A8684D52BA2")
    public void setTimeout(int timeout) {
        try 
        {
            int err;
            err = mTag.getTagService().setTimeout(
                    TagTechnology.MIFARE_ULTRALIGHT, timeout);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("The supplied timeout is not valid");
            } //End block
        } //End block
        catch (RemoteException e)
        { }
        addTaint(timeout);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:25.046 -0400", hash_original_method = "849E2A68F4F80A968E68483D2D0B1744", hash_generated_method = "23C165B11C72357C7C2687A35340F8F1")
    public int getTimeout() {
        try 
        {
            int var0FDD3A6C9CC4EA5F9E59635B4F31C936_326555063 = (mTag.getTagService().getTimeout(TagTechnology.MIFARE_ULTRALIGHT));
        } //End block
        catch (RemoteException e)
        { }
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1401205974 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1401205974;
        // ---------- Original Method ----------
        //try {
            //return mTag.getTagService().getTimeout(TagTechnology.MIFARE_ULTRALIGHT);
        //} catch (RemoteException e) {
            //Log.e(TAG, "NFC service dead", e);
            //return 0;
        //}
    }

    
        private static void validatePageIndex(int pageIndex) {
        if (pageIndex < 0 || pageIndex >= MAX_PAGE_COUNT) {
            throw new IndexOutOfBoundsException("page out of bounds: " + pageIndex);
        }
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:25.046 -0400", hash_original_field = "839E89798F641D78E99C5732B39CA844", hash_generated_field = "75254E4C21911FCCBBD25490236328DA")

    private static String TAG = "NFC";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:25.046 -0400", hash_original_field = "5034A85BF931B74EFB4900211957B4BB", hash_generated_field = "384725A35AE2048CC01CB14C667E6F8D")

    public static final int TYPE_UNKNOWN = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:25.046 -0400", hash_original_field = "47B4CB8E43E4243984FB1A0BBD60FF47", hash_generated_field = "9BE3F76DF00EB59F29F6A17EB828F767")

    public static final int TYPE_ULTRALIGHT = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:25.047 -0400", hash_original_field = "628F4D3130A60463AA6CE32CEA1963B7", hash_generated_field = "84E7082E6CDB244EAD32A3F8AC3B8CF8")

    public static final int TYPE_ULTRALIGHT_C = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:25.047 -0400", hash_original_field = "62FE3CF583A48879AD81D4FC31C07455", hash_generated_field = "65A194E1705A84CF4A535345BE21CB60")

    public static final int PAGE_SIZE = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:25.047 -0400", hash_original_field = "566CBFF0277A2C026E70DD4FCC21FD3B", hash_generated_field = "FC2FCB3232D71108F7C5B57FDAEB9BF7")

    private static int NXP_MANUFACTURER_ID = 0x04;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:25.047 -0400", hash_original_field = "E058148AA489216EF5EDD6CF5754000D", hash_generated_field = "90A94A5CD4800B634D9444DB479DE501")

    private static int MAX_PAGE_COUNT = 256;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:25.047 -0400", hash_original_field = "ACBDBFAD96A9FB10A1D9E45886B4E84A", hash_generated_field = "4962E30417FE0FA3945478E0C7DB1FD0")

    public static final String EXTRA_IS_UL_C = "isulc";
}

