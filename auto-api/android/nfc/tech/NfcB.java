package android.nfc.tech;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.nfc.Tag;
import android.os.Bundle;
import android.os.RemoteException;
import java.io.IOException;

public final class NfcB extends BasicTagTechnology {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.478 -0400", hash_original_field = "0F481A4041ED699B510E0CBFB75FAB8D", hash_generated_field = "D6AB51D7386B9FB075CD62E11E89CC38")

    private byte[] mAppData;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.478 -0400", hash_original_field = "5E7F6AADBCD8A4D0C90DC43311B64BE1", hash_generated_field = "FF565EDAE4956E1E70949D0CAC4BD68D")

    private byte[] mProtInfo;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.478 -0400", hash_original_method = "2D2D9B1E167FA423D2EE7B2AB12658F9", hash_generated_method = "26F5F1CD8795E6EE62FFA3D396FE93C9")
    public  NfcB(Tag tag) throws RemoteException {
        super(tag, TagTechnology.NFC_B);
        Bundle extras = tag.getTechExtras(TagTechnology.NFC_B);
        mAppData = extras.getByteArray(EXTRA_APPDATA);
        mProtInfo = extras.getByteArray(EXTRA_PROTINFO);
        addTaint(tag.getTaint());
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    public static NfcB get(Tag tag) {
        if (!tag.hasTech(TagTechnology.NFC_B)) return null;
        try {
            return new NfcB(tag);
        } catch (RemoteException e) {
            return null;
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.479 -0400", hash_original_method = "FD7D4BBD84674EF268698E76F3B3C4A1", hash_generated_method = "7CFF634448DDD86AA81D01092167215A")
    public byte[] getApplicationData() {
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1346826330 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1346826330;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.479 -0400", hash_original_method = "4842BF20AFFD1556EAAF44F971F8DB01", hash_generated_method = "A028578E4E20BB79C44A0A0A98D70561")
    public byte[] getProtocolInfo() {
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_2068046993 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_2068046993;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.480 -0400", hash_original_method = "E43990821CE38E04B46B3E901EFDFA24", hash_generated_method = "1DD02E68F06D9278A8AFBD648C66B754")
    public byte[] transceive(byte[] data) throws IOException {
        byte[] var457CAD28AA5A950818B34ED801FB2565_1283745489 = (transceive(data, true));
        addTaint(data[0]);
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_556256324 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_556256324;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.481 -0400", hash_original_method = "CF96EF3BF3FCE4DA3D9E7FBB541AEB70", hash_generated_method = "01A469C8CEE391493F10F68B9C1C696C")
    public int getMaxTransceiveLength() {
        int varAD50EB2A6987338433A93D587AD15277_1088643653 = (getMaxTransceiveLengthInternal());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2139772398 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2139772398;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.481 -0400", hash_original_field = "BAF423D846EDB4881F39D2C008225DDA", hash_generated_field = "BE35031294E892C3E6D8B573B512355A")

    public static final String EXTRA_APPDATA = "appdata";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.481 -0400", hash_original_field = "1FDB01AC7D348A34549DEB4CAFA5798C", hash_generated_field = "165A7657EEF9F0EE08ECCDD00BB0AAF6")

    public static final String EXTRA_PROTINFO = "protinfo";
}

