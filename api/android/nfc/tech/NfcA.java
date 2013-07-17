package android.nfc.tech;

// Droidsafe Imports
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.717 -0400", hash_original_field = "24C549BDE566021D468B833DEAD531B5", hash_generated_field = "84C03AB800CA76624FDACC0FE5253451")

    private short mSak;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.717 -0400", hash_original_field = "4EF49BE6708038B4A5F17316299AFECA", hash_generated_field = "C3ED3C2F9CAB5980376F9374631262D3")

    private byte[] mAtqa;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.718 -0400", hash_original_method = "7F7EA5045624074AA33D4555E4EB43B6", hash_generated_method = "7A662CCBC847378059C56231754D098F")
    public  NfcA(Tag tag) throws RemoteException {
        super(tag, TagTechnology.NFC_A);
        addTaint(tag.getTaint());
        Bundle extras = tag.getTechExtras(TagTechnology.NFC_A);
        mSak = extras.getShort(EXTRA_SAK);
        mAtqa = extras.getByteArray(EXTRA_ATQA);
        // ---------- Original Method ----------
        //Bundle extras = tag.getTechExtras(TagTechnology.NFC_A);
        //mSak = extras.getShort(EXTRA_SAK);
        //mAtqa = extras.getByteArray(EXTRA_ATQA);
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.719 -0400", hash_original_method = "0C48EFD3E17B27EC975A7F66A0C95A20", hash_generated_method = "B476FB02BB0565C191380FA2A11EA6E6")
    public byte[] getAtqa() {
        byte[] var4EF49BE6708038B4A5F17316299AFECA_1774730908 = (mAtqa);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1384259792 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1384259792;
        // ---------- Original Method ----------
        //return mAtqa;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.719 -0400", hash_original_method = "82922CBBC94A0186459AA7EC846F5755", hash_generated_method = "88CD638794435F48E39B33C7E7E6FC12")
    public short getSak() {
        short var24C549BDE566021D468B833DEAD531B5_371165115 = (mSak);
                short var4F09DAA9D95BCB166A302407A0E0BABE_1156312165 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_1156312165;
        // ---------- Original Method ----------
        //return mSak;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.719 -0400", hash_original_method = "E43990821CE38E04B46B3E901EFDFA24", hash_generated_method = "D2AA7EA76826A4355EC8D49C8DD33246")
    public byte[] transceive(byte[] data) throws IOException {
        addTaint(data[0]);
        byte[] varEE32C696607EBC614D9A30134ACB1AE3_1127615910 = (transceive(data, true));
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_825347177 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_825347177;
        // ---------- Original Method ----------
        //return transceive(data, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.720 -0400", hash_original_method = "CF96EF3BF3FCE4DA3D9E7FBB541AEB70", hash_generated_method = "935BDFD4F0B8A13A4FF1B403D6E1CADF")
    public int getMaxTransceiveLength() {
        int var534FE261D7083B235B3B010A14A83EE1_845692679 = (getMaxTransceiveLengthInternal());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1469943203 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1469943203;
        // ---------- Original Method ----------
        //return getMaxTransceiveLengthInternal();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.720 -0400", hash_original_method = "63D5F2163C0B5751BB93B998E089091B", hash_generated_method = "6C23619A0B89F3AD913769B88256BF4B")
    public void setTimeout(int timeout) {
        addTaint(timeout);
        try 
        {
            int err = mTag.getTagService().setTimeout(TagTechnology.NFC_A, timeout);
            if(err != ErrorCodes.SUCCESS)            
            {
                IllegalArgumentException varDB68BEF11A046B44BA82450BD6BDD1ED_658402223 = new IllegalArgumentException("The supplied timeout is not valid");
                varDB68BEF11A046B44BA82450BD6BDD1ED_658402223.addTaint(taint);
                throw varDB68BEF11A046B44BA82450BD6BDD1ED_658402223;
            } //End block
        } //End block
        catch (RemoteException e)
        {
        } //End block
        // ---------- Original Method ----------
        //try {
            //int err = mTag.getTagService().setTimeout(TagTechnology.NFC_A, timeout);
            //if (err != ErrorCodes.SUCCESS) {
                //throw new IllegalArgumentException("The supplied timeout is not valid");
            //}
        //} catch (RemoteException e) {
            //Log.e(TAG, "NFC service dead", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.721 -0400", hash_original_method = "BA38E23E1F1B427D7366A44F0802731B", hash_generated_method = "CAD239917E57350B295FCADE64B1DF7A")
    public int getTimeout() {
        try 
        {
            int var1CA2E2BEF68B21ADD9658321AAB5D35A_43828608 = (mTag.getTagService().getTimeout(TagTechnology.NFC_A));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_715297207 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_715297207;
        } //End block
        catch (RemoteException e)
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_1034317578 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_978429467 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_978429467;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mTag.getTagService().getTimeout(TagTechnology.NFC_A);
        //} catch (RemoteException e) {
            //Log.e(TAG, "NFC service dead", e);
            //return 0;
        //}
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.721 -0400", hash_original_field = "839E89798F641D78E99C5732B39CA844", hash_generated_field = "BC8F11E4AEAD11E0412B7B53DF0CA6C8")

    private static final String TAG = "NFC";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.721 -0400", hash_original_field = "686F1904EF613970529BD2D860F18F1C", hash_generated_field = "CDCE0B9F229930126B4A9C3FF1148379")

    public static final String EXTRA_SAK = "sak";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.721 -0400", hash_original_field = "241E6CFB2E009970D00D8EC1E07A22D0", hash_generated_field = "42E2DBE9FAB155A8309DC6253C59B539")

    public static final String EXTRA_ATQA = "atqa";
}

