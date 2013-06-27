package android.nfc.tech;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.nfc.ErrorCodes;
import android.nfc.Tag;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import java.io.IOException;

public final class NfcA extends BasicTagTechnology {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:26.641 -0400", hash_original_field = "24C549BDE566021D468B833DEAD531B5", hash_generated_field = "84C03AB800CA76624FDACC0FE5253451")

    private short mSak;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:26.641 -0400", hash_original_field = "4EF49BE6708038B4A5F17316299AFECA", hash_generated_field = "C3ED3C2F9CAB5980376F9374631262D3")

    private byte[] mAtqa;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:26.643 -0400", hash_original_method = "7F7EA5045624074AA33D4555E4EB43B6", hash_generated_method = "9A23C06AD63A85FDD2F63972789DBD7B")
    public  NfcA(Tag tag) throws RemoteException {
        super(tag, TagTechnology.NFC_A);
        Bundle extras;
        extras = tag.getTechExtras(TagTechnology.NFC_A);
        mSak = extras.getShort(EXTRA_SAK);
        mAtqa = extras.getByteArray(EXTRA_ATQA);
        addTaint(tag.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:26.643 -0400", hash_original_method = "0C48EFD3E17B27EC975A7F66A0C95A20", hash_generated_method = "5345694C9C6BD53A596CACC9C033B771")
    public byte[] getAtqa() {
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1002655206 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1002655206;
        // ---------- Original Method ----------
        //return mAtqa;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:26.659 -0400", hash_original_method = "82922CBBC94A0186459AA7EC846F5755", hash_generated_method = "316B2A3FDBB200EDAB0A71FF7B8C1E2B")
    public short getSak() {
        short var4F09DAA9D95BCB166A302407A0E0BABE_66428368 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_66428368;
        // ---------- Original Method ----------
        //return mSak;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:26.660 -0400", hash_original_method = "E43990821CE38E04B46B3E901EFDFA24", hash_generated_method = "DF35D2E597DB4666A4E6668F25DB6C67")
    public byte[] transceive(byte[] data) throws IOException {
        byte[] var457CAD28AA5A950818B34ED801FB2565_1080998123 = (transceive(data, true));
        addTaint(data[0]);
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1151191363 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1151191363;
        // ---------- Original Method ----------
        //return transceive(data, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:26.660 -0400", hash_original_method = "CF96EF3BF3FCE4DA3D9E7FBB541AEB70", hash_generated_method = "0B57ABD616C6130B1775D7B038B333A6")
    public int getMaxTransceiveLength() {
        int varAD50EB2A6987338433A93D587AD15277_1040199116 = (getMaxTransceiveLengthInternal());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_30187776 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_30187776;
        // ---------- Original Method ----------
        //return getMaxTransceiveLengthInternal();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:26.663 -0400", hash_original_method = "63D5F2163C0B5751BB93B998E089091B", hash_generated_method = "97D8B534C3ADDD65141D25B52F00C21D")
    public void setTimeout(int timeout) {
        try 
        {
            int err;
            err = mTag.getTagService().setTimeout(TagTechnology.NFC_A, timeout);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("The supplied timeout is not valid");
            } //End block
        } //End block
        catch (RemoteException e)
        { }
        addTaint(timeout);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:26.671 -0400", hash_original_method = "BA38E23E1F1B427D7366A44F0802731B", hash_generated_method = "27AE84D4F8B7C85DC98D3BAB9CB36C49")
    public int getTimeout() {
        try 
        {
            int var813639331A2D794D17159D8A9F2E1640_2145038541 = (mTag.getTagService().getTimeout(TagTechnology.NFC_A));
        } //End block
        catch (RemoteException e)
        { }
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2098267882 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2098267882;
        // ---------- Original Method ----------
        //try {
            //return mTag.getTagService().getTimeout(TagTechnology.NFC_A);
        //} catch (RemoteException e) {
            //Log.e(TAG, "NFC service dead", e);
            //return 0;
        //}
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:26.671 -0400", hash_original_field = "839E89798F641D78E99C5732B39CA844", hash_generated_field = "75254E4C21911FCCBBD25490236328DA")

    private static String TAG = "NFC";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:26.671 -0400", hash_original_field = "686F1904EF613970529BD2D860F18F1C", hash_generated_field = "CDCE0B9F229930126B4A9C3FF1148379")

    public static final String EXTRA_SAK = "sak";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:26.671 -0400", hash_original_field = "241E6CFB2E009970D00D8EC1E07A22D0", hash_generated_field = "42E2DBE9FAB155A8309DC6253C59B539")

    public static final String EXTRA_ATQA = "atqa";
}

