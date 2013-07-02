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

public final class NfcA extends BasicTagTechnology {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.463 -0400", hash_original_field = "24C549BDE566021D468B833DEAD531B5", hash_generated_field = "84C03AB800CA76624FDACC0FE5253451")

    private short mSak;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.463 -0400", hash_original_field = "4EF49BE6708038B4A5F17316299AFECA", hash_generated_field = "C3ED3C2F9CAB5980376F9374631262D3")

    private byte[] mAtqa;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.464 -0400", hash_original_method = "7F7EA5045624074AA33D4555E4EB43B6", hash_generated_method = "1D1E26660828AE02CF28EFEFA1C9A6EF")
    public  NfcA(Tag tag) throws RemoteException {
        super(tag, TagTechnology.NFC_A);
        Bundle extras = tag.getTechExtras(TagTechnology.NFC_A);
        mSak = extras.getShort(EXTRA_SAK);
        mAtqa = extras.getByteArray(EXTRA_ATQA);
        addTaint(tag.getTaint());
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    public static NfcA get(Tag tag) {
        if (!tag.hasTech(TagTechnology.NFC_A)) return null;
        try {
            return new NfcA(tag);
        } catch (RemoteException e) {
            return null;
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.464 -0400", hash_original_method = "0C48EFD3E17B27EC975A7F66A0C95A20", hash_generated_method = "9454450E59913A8BB0D4A8A74D15C8E4")
    public byte[] getAtqa() {
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1604952536 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1604952536;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.465 -0400", hash_original_method = "82922CBBC94A0186459AA7EC846F5755", hash_generated_method = "22E1FF8B7888F4E4F5C1542118AA6FFF")
    public short getSak() {
        short var4F09DAA9D95BCB166A302407A0E0BABE_156220279 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_156220279;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.465 -0400", hash_original_method = "E43990821CE38E04B46B3E901EFDFA24", hash_generated_method = "3C8B24D4CF4C35D8B552A4EE9F542145")
    public byte[] transceive(byte[] data) throws IOException {
        byte[] var457CAD28AA5A950818B34ED801FB2565_945972596 = (transceive(data, true));
        addTaint(data[0]);
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1880412596 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1880412596;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.465 -0400", hash_original_method = "CF96EF3BF3FCE4DA3D9E7FBB541AEB70", hash_generated_method = "FEEE4FB9E08521251D5E2BF1E24CDAF5")
    public int getMaxTransceiveLength() {
        int varAD50EB2A6987338433A93D587AD15277_409818519 = (getMaxTransceiveLengthInternal());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1494691365 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1494691365;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.466 -0400", hash_original_method = "63D5F2163C0B5751BB93B998E089091B", hash_generated_method = "4C28E97EC1E6BF82A8BF8F24BD9C5CB2")
    public void setTimeout(int timeout) {
        try 
        {
            int err = mTag.getTagService().setTimeout(TagTechnology.NFC_A, timeout);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("The supplied timeout is not valid");
            } 
        } 
        catch (RemoteException e)
        { }
        addTaint(timeout);
        
        
            
            
                
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.467 -0400", hash_original_method = "BA38E23E1F1B427D7366A44F0802731B", hash_generated_method = "EA5643546FC4380F4B1F0972BAC03F51")
    public int getTimeout() {
        try 
        {
            int var813639331A2D794D17159D8A9F2E1640_2147102525 = (mTag.getTagService().getTimeout(TagTechnology.NFC_A));
        } 
        catch (RemoteException e)
        { }
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_550615422 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_550615422;
        
        
            
        
            
            
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.467 -0400", hash_original_field = "839E89798F641D78E99C5732B39CA844", hash_generated_field = "BC8F11E4AEAD11E0412B7B53DF0CA6C8")

    private static final String TAG = "NFC";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.467 -0400", hash_original_field = "686F1904EF613970529BD2D860F18F1C", hash_generated_field = "CDCE0B9F229930126B4A9C3FF1148379")

    public static final String EXTRA_SAK = "sak";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.467 -0400", hash_original_field = "241E6CFB2E009970D00D8EC1E07A22D0", hash_generated_field = "42E2DBE9FAB155A8309DC6253C59B539")

    public static final String EXTRA_ATQA = "atqa";
}

