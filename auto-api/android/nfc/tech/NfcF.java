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

public final class NfcF extends BasicTagTechnology {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:26.655 -0400", hash_original_field = "0BF6864C5F4227002F2CA21BE8F000AE", hash_generated_field = "8144AE907BE5B2181516DBD1D62E97D6")

    private byte[] mSystemCode = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:26.655 -0400", hash_original_field = "1C3CC1076CEE4FEE0EE127964B8977D0", hash_generated_field = "D7A1C8F789011716682DAB2FCD913220")

    private byte[] mManufacturer = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:26.656 -0400", hash_original_method = "0D9BC91BC56C91CB4B73C77A46406834", hash_generated_method = "C3731920B6159AC4BBA140AEB7BE14AF")
    public  NfcF(Tag tag) throws RemoteException {
        super(tag, TagTechnology.NFC_F);
        Bundle extras;
        extras = tag.getTechExtras(TagTechnology.NFC_F);
        {
            mSystemCode = extras.getByteArray(EXTRA_SC);
            mManufacturer = extras.getByteArray(EXTRA_PMM);
        } //End block
        addTaint(tag.getTaint());
        // ---------- Original Method ----------
        //Bundle extras = tag.getTechExtras(TagTechnology.NFC_F);
        //if (extras != null) {
            //mSystemCode = extras.getByteArray(EXTRA_SC);
            //mManufacturer = extras.getByteArray(EXTRA_PMM);
        //}
    }

    
        public static NfcF get(Tag tag) {
        if (!tag.hasTech(TagTechnology.NFC_F)) return null;
        try {
            return new NfcF(tag);
        } catch (RemoteException e) {
            return null;
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:26.658 -0400", hash_original_method = "5593A08645ACC7B6D3C7AFEF98D893C4", hash_generated_method = "309F6A65127775A076940E2CF0424D2D")
    public byte[] getSystemCode() {
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_323199524 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_323199524;
        // ---------- Original Method ----------
        //return mSystemCode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:26.668 -0400", hash_original_method = "674E72909806E7E1411B5B9E47606852", hash_generated_method = "F0952999C09A79529FC75EA31A4D90FC")
    public byte[] getManufacturer() {
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_566441861 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_566441861;
        // ---------- Original Method ----------
        //return mManufacturer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:26.668 -0400", hash_original_method = "E43990821CE38E04B46B3E901EFDFA24", hash_generated_method = "CBAEE3E5D270A5DB6A9912EC78233A2F")
    public byte[] transceive(byte[] data) throws IOException {
        byte[] var457CAD28AA5A950818B34ED801FB2565_1125113192 = (transceive(data, true));
        addTaint(data[0]);
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1405038794 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1405038794;
        // ---------- Original Method ----------
        //return transceive(data, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:26.669 -0400", hash_original_method = "CF96EF3BF3FCE4DA3D9E7FBB541AEB70", hash_generated_method = "1815218427C58477DCF7A9DD04093A75")
    public int getMaxTransceiveLength() {
        int varAD50EB2A6987338433A93D587AD15277_298286226 = (getMaxTransceiveLengthInternal());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_93145228 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_93145228;
        // ---------- Original Method ----------
        //return getMaxTransceiveLengthInternal();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:26.670 -0400", hash_original_method = "D0C1DC7ECC9E082014D504E80FD68DDB", hash_generated_method = "3A2324741678E81FAB7B45123A83D07E")
    public void setTimeout(int timeout) {
        try 
        {
            int err;
            err = mTag.getTagService().setTimeout(TagTechnology.NFC_F, timeout);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("The supplied timeout is not valid");
            } //End block
        } //End block
        catch (RemoteException e)
        { }
        addTaint(timeout);
        // ---------- Original Method ----------
        //try {
            //int err = mTag.getTagService().setTimeout(TagTechnology.NFC_F, timeout);
            //if (err != ErrorCodes.SUCCESS) {
                //throw new IllegalArgumentException("The supplied timeout is not valid");
            //}
        //} catch (RemoteException e) {
            //Log.e(TAG, "NFC service dead", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:26.678 -0400", hash_original_method = "BA26E553829B17341BEC1294BC995A3C", hash_generated_method = "03C3509B5189B921D1719C2431C56378")
    public int getTimeout() {
        try 
        {
            int var49C08BE73C927C35F6D435ADE00A7269_1677566794 = (mTag.getTagService().getTimeout(TagTechnology.NFC_F));
        } //End block
        catch (RemoteException e)
        { }
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_252237284 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_252237284;
        // ---------- Original Method ----------
        //try {
            //return mTag.getTagService().getTimeout(TagTechnology.NFC_F);
        //} catch (RemoteException e) {
            //Log.e(TAG, "NFC service dead", e);
            //return 0;
        //}
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:26.678 -0400", hash_original_field = "839E89798F641D78E99C5732B39CA844", hash_generated_field = "75254E4C21911FCCBBD25490236328DA")

    private static String TAG = "NFC";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:26.678 -0400", hash_original_field = "6DC1026D9CF472FF6DEB0FDF35BBF457", hash_generated_field = "5704B992AD33B718B3C71C8EF40A32EC")

    public static final String EXTRA_SC = "systemcode";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:26.678 -0400", hash_original_field = "F07087DA7C73A8E424C9B4A8D43B104D", hash_generated_field = "34E329AB64B6D1770F31F0C3818A0179")

    public static final String EXTRA_PMM = "pmm";
}

