package android.nfc.tech;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.IOException;

import android.nfc.Tag;
import android.os.Bundle;
import android.os.RemoteException;





public final class NfcB extends BasicTagTechnology {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.740 -0400", hash_original_field = "0F481A4041ED699B510E0CBFB75FAB8D", hash_generated_field = "D6AB51D7386B9FB075CD62E11E89CC38")

    private byte[] mAppData;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.741 -0400", hash_original_field = "5E7F6AADBCD8A4D0C90DC43311B64BE1", hash_generated_field = "FF565EDAE4956E1E70949D0CAC4BD68D")

    private byte[] mProtInfo;
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.742 -0400", hash_original_method = "2D2D9B1E167FA423D2EE7B2AB12658F9", hash_generated_method = "61EA097C87A173CC6C0ECA3F531B1EDF")
    public  NfcB(Tag tag) throws RemoteException {
        super(tag, TagTechnology.NFC_B);
        addTaint(tag.getTaint());
        Bundle extras = tag.getTechExtras(TagTechnology.NFC_B);
        mAppData = extras.getByteArray(EXTRA_APPDATA);
        mProtInfo = extras.getByteArray(EXTRA_PROTINFO);
        // ---------- Original Method ----------
        //Bundle extras = tag.getTechExtras(TagTechnology.NFC_B);
        //mAppData = extras.getByteArray(EXTRA_APPDATA);
        //mProtInfo = extras.getByteArray(EXTRA_PROTINFO);
    }

    
    public static NfcB get(Tag tag) {
        if (!tag.hasTech(TagTechnology.NFC_B)) return null;
        try {
            return new NfcB(tag);
        } catch (RemoteException e) {
            return null;
        }
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.744 -0400", hash_original_method = "FD7D4BBD84674EF268698E76F3B3C4A1", hash_generated_method = "09F4D07B5E3D1547589805AA23DAE69C")
    public byte[] getApplicationData() {
        byte[] var0F481A4041ED699B510E0CBFB75FAB8D_2107408197 = (mAppData);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1639178106 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1639178106;
        // ---------- Original Method ----------
        //return mAppData;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.746 -0400", hash_original_method = "4842BF20AFFD1556EAAF44F971F8DB01", hash_generated_method = "34BD39ED8A49F32DC25097AF8D779ABF")
    public byte[] getProtocolInfo() {
        byte[] var5E7F6AADBCD8A4D0C90DC43311B64BE1_1545215662 = (mProtInfo);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_503411951 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_503411951;
        // ---------- Original Method ----------
        //return mProtInfo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.747 -0400", hash_original_method = "E43990821CE38E04B46B3E901EFDFA24", hash_generated_method = "9D2DFD4ADC361CF843F8E433066E6110")
    public byte[] transceive(byte[] data) throws IOException {
        addTaint(data[0]);
        byte[] varEE32C696607EBC614D9A30134ACB1AE3_929606694 = (transceive(data, true));
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1756293040 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1756293040;
        // ---------- Original Method ----------
        //return transceive(data, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.748 -0400", hash_original_method = "CF96EF3BF3FCE4DA3D9E7FBB541AEB70", hash_generated_method = "6FE7384AA18BD130D42AB6CCBF89D0B5")
    public int getMaxTransceiveLength() {
        int var534FE261D7083B235B3B010A14A83EE1_310764140 = (getMaxTransceiveLengthInternal());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_110075154 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_110075154;
        // ---------- Original Method ----------
        //return getMaxTransceiveLengthInternal();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.749 -0400", hash_original_field = "BAF423D846EDB4881F39D2C008225DDA", hash_generated_field = "BE35031294E892C3E6D8B573B512355A")

    public static final String EXTRA_APPDATA = "appdata";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.749 -0400", hash_original_field = "1FDB01AC7D348A34549DEB4CAFA5798C", hash_generated_field = "165A7657EEF9F0EE08ECCDD00BB0AAF6")

    public static final String EXTRA_PROTINFO = "protinfo";
}

