package android.nfc.tech;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.nfc.ErrorCodes;
import android.nfc.Tag;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import java.io.IOException;

public final class NfcA extends BasicTagTechnology {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:30.022 -0400", hash_original_field = "24C549BDE566021D468B833DEAD531B5", hash_generated_field = "84C03AB800CA76624FDACC0FE5253451")

    private short mSak;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:30.022 -0400", hash_original_field = "4EF49BE6708038B4A5F17316299AFECA", hash_generated_field = "C3ED3C2F9CAB5980376F9374631262D3")

    private byte[] mAtqa;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:30.022 -0400", hash_original_method = "7F7EA5045624074AA33D4555E4EB43B6", hash_generated_method = "7A662CCBC847378059C56231754D098F")
    public  NfcA(Tag tag) throws RemoteException {
        super(tag, TagTechnology.NFC_A);
        addTaint(tag.getTaint());
        Bundle extras = tag.getTechExtras(TagTechnology.NFC_A);
        mSak = extras.getShort(EXTRA_SAK);
        mAtqa = extras.getByteArray(EXTRA_ATQA);
        
        
        
        
    }

    
        public static NfcA get(Tag tag) {
        if (!tag.hasTech(TagTechnology.NFC_A)) return null;
        try {
            return new NfcA(tag);
        } catch (RemoteException e) {
            return null;
        }
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:30.023 -0400", hash_original_method = "0C48EFD3E17B27EC975A7F66A0C95A20", hash_generated_method = "F08FF1999AE761B5FD7815119F263680")
    public byte[] getAtqa() {
        byte[] var4EF49BE6708038B4A5F17316299AFECA_1253793270 = (mAtqa);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1873522143 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1873522143;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:30.023 -0400", hash_original_method = "82922CBBC94A0186459AA7EC846F5755", hash_generated_method = "98FDE62431CDBC7B7D136DB2F3F34C1A")
    public short getSak() {
        short var24C549BDE566021D468B833DEAD531B5_962468347 = (mSak);
                short var4F09DAA9D95BCB166A302407A0E0BABE_1191938175 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_1191938175;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:30.023 -0400", hash_original_method = "E43990821CE38E04B46B3E901EFDFA24", hash_generated_method = "F8F30674816B9E54A8A437A97BFF8664")
    public byte[] transceive(byte[] data) throws IOException {
        addTaint(data[0]);
        byte[] varEE32C696607EBC614D9A30134ACB1AE3_1416265337 = (transceive(data, true));
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1354553857 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1354553857;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:30.024 -0400", hash_original_method = "CF96EF3BF3FCE4DA3D9E7FBB541AEB70", hash_generated_method = "76C11E9D0A0CCD348538F34AC5277C36")
    public int getMaxTransceiveLength() {
        int var534FE261D7083B235B3B010A14A83EE1_645172412 = (getMaxTransceiveLengthInternal());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1419382572 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1419382572;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:30.024 -0400", hash_original_method = "63D5F2163C0B5751BB93B998E089091B", hash_generated_method = "84299CCC3D6D6487FA346B6DC9F7C5A1")
    public void setTimeout(int timeout) {
        addTaint(timeout);
        try 
        {
            int err = mTag.getTagService().setTimeout(TagTechnology.NFC_A, timeout);
    if(err != ErrorCodes.SUCCESS)            
            {
                IllegalArgumentException varDB68BEF11A046B44BA82450BD6BDD1ED_306863090 = new IllegalArgumentException("The supplied timeout is not valid");
                varDB68BEF11A046B44BA82450BD6BDD1ED_306863090.addTaint(taint);
                throw varDB68BEF11A046B44BA82450BD6BDD1ED_306863090;
            } 
        } 
        catch (RemoteException e)
        {
        } 
        
        
            
            
                
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:30.025 -0400", hash_original_method = "BA38E23E1F1B427D7366A44F0802731B", hash_generated_method = "1929A81098880FC4091CFB6C9773CD24")
    public int getTimeout() {
        try 
        {
            int var1CA2E2BEF68B21ADD9658321AAB5D35A_1395083272 = (mTag.getTagService().getTimeout(TagTechnology.NFC_A));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1530510547 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1530510547;
        } 
        catch (RemoteException e)
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_857380078 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2137548393 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2137548393;
        } 
        
        
            
        
            
            
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:30.025 -0400", hash_original_field = "839E89798F641D78E99C5732B39CA844", hash_generated_field = "BC8F11E4AEAD11E0412B7B53DF0CA6C8")

    private static final String TAG = "NFC";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:30.025 -0400", hash_original_field = "686F1904EF613970529BD2D860F18F1C", hash_generated_field = "CDCE0B9F229930126B4A9C3FF1148379")

    public static final String EXTRA_SAK = "sak";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:30.025 -0400", hash_original_field = "241E6CFB2E009970D00D8EC1E07A22D0", hash_generated_field = "42E2DBE9FAB155A8309DC6253C59B539")

    public static final String EXTRA_ATQA = "atqa";
}

