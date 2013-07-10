package android.nfc.tech;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.nfc.ErrorCodes;
import android.nfc.Tag;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import java.io.IOException;

public final class NfcF extends BasicTagTechnology {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.492 -0400", hash_original_field = "0BF6864C5F4227002F2CA21BE8F000AE", hash_generated_field = "8144AE907BE5B2181516DBD1D62E97D6")

    private byte[] mSystemCode = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.492 -0400", hash_original_field = "1C3CC1076CEE4FEE0EE127964B8977D0", hash_generated_field = "D7A1C8F789011716682DAB2FCD913220")

    private byte[] mManufacturer = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.493 -0400", hash_original_method = "0D9BC91BC56C91CB4B73C77A46406834", hash_generated_method = "603D87F1D200F75A1F3737DD5311126A")
    public  NfcF(Tag tag) throws RemoteException {
        super(tag, TagTechnology.NFC_F);
        Bundle extras = tag.getTechExtras(TagTechnology.NFC_F);
        {
            mSystemCode = extras.getByteArray(EXTRA_SC);
            mManufacturer = extras.getByteArray(EXTRA_PMM);
        } 
        addTaint(tag.getTaint());
        
        
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    public static NfcF get(Tag tag) {
        if (!tag.hasTech(TagTechnology.NFC_F)) return null;
        try {
            return new NfcF(tag);
        } catch (RemoteException e) {
            return null;
        }
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.494 -0400", hash_original_method = "5593A08645ACC7B6D3C7AFEF98D893C4", hash_generated_method = "190BB162C42B6FCF7E2D6D0703FC8E88")
    public byte[] getSystemCode() {
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1729563809 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1729563809;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.495 -0400", hash_original_method = "674E72909806E7E1411B5B9E47606852", hash_generated_method = "C96FD75D18AE527AAB8E45FA0F64F796")
    public byte[] getManufacturer() {
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1256842787 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1256842787;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.497 -0400", hash_original_method = "E43990821CE38E04B46B3E901EFDFA24", hash_generated_method = "D7C4CFCCE9FF5519CF189AF07F9E2E0A")
    public byte[] transceive(byte[] data) throws IOException {
        byte[] var457CAD28AA5A950818B34ED801FB2565_674090388 = (transceive(data, true));
        addTaint(data[0]);
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_619022097 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_619022097;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.497 -0400", hash_original_method = "CF96EF3BF3FCE4DA3D9E7FBB541AEB70", hash_generated_method = "0FB20E676997FFEA1445D5D7A63CEDDB")
    public int getMaxTransceiveLength() {
        int varAD50EB2A6987338433A93D587AD15277_1539182590 = (getMaxTransceiveLengthInternal());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1479842788 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1479842788;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.497 -0400", hash_original_method = "D0C1DC7ECC9E082014D504E80FD68DDB", hash_generated_method = "BA4BF509A188231FCC0E0ABC609DE13C")
    public void setTimeout(int timeout) {
        try 
        {
            int err = mTag.getTagService().setTimeout(TagTechnology.NFC_F, timeout);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("The supplied timeout is not valid");
            } 
        } 
        catch (RemoteException e)
        { }
        addTaint(timeout);
        
        
            
            
                
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.498 -0400", hash_original_method = "BA26E553829B17341BEC1294BC995A3C", hash_generated_method = "F9B9CEFB3222639B3EC87700AFD114E5")
    public int getTimeout() {
        try 
        {
            int var49C08BE73C927C35F6D435ADE00A7269_1792536682 = (mTag.getTagService().getTimeout(TagTechnology.NFC_F));
        } 
        catch (RemoteException e)
        { }
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1917407029 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1917407029;
        
        
            
        
            
            
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.498 -0400", hash_original_field = "839E89798F641D78E99C5732B39CA844", hash_generated_field = "BC8F11E4AEAD11E0412B7B53DF0CA6C8")

    private static final String TAG = "NFC";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.498 -0400", hash_original_field = "6DC1026D9CF472FF6DEB0FDF35BBF457", hash_generated_field = "5704B992AD33B718B3C71C8EF40A32EC")

    public static final String EXTRA_SC = "systemcode";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.498 -0400", hash_original_field = "F07087DA7C73A8E424C9B4A8D43B104D", hash_generated_field = "34E329AB64B6D1770F31F0C3818A0179")

    public static final String EXTRA_PMM = "pmm";
}

