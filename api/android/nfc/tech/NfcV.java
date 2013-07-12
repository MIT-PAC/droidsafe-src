package android.nfc.tech;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.nfc.Tag;
import android.os.Bundle;
import android.os.RemoteException;
import java.io.IOException;

public final class NfcV extends BasicTagTechnology {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:30.083 -0400", hash_original_field = "3934254C6C714B19DE22D4F58C5042D2", hash_generated_field = "121CAF4F22F2DB7E3FE6590C2E29C484")

    private byte mRespFlags;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:30.083 -0400", hash_original_field = "E9C54BDE6798E1875D8BC87A6FAA80B7", hash_generated_field = "22B4F1B6769CD74A976FDA7EB332E5E3")

    private byte mDsfId;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:30.084 -0400", hash_original_method = "F4045E9985ED2B22A83A671B7ECDE866", hash_generated_method = "0D5AC2FCB4F8F34EB138D8F897A679EC")
    public  NfcV(Tag tag) throws RemoteException {
        super(tag, TagTechnology.NFC_V);
        addTaint(tag.getTaint());
        Bundle extras = tag.getTechExtras(TagTechnology.NFC_V);
        mRespFlags = extras.getByte(EXTRA_RESP_FLAGS);
        mDsfId = extras.getByte(EXTRA_DSFID);
        // ---------- Original Method ----------
        //Bundle extras = tag.getTechExtras(TagTechnology.NFC_V);
        //mRespFlags = extras.getByte(EXTRA_RESP_FLAGS);
        //mDsfId = extras.getByte(EXTRA_DSFID);
    }

    
        public static NfcV get(Tag tag) {
        if (!tag.hasTech(TagTechnology.NFC_V)) return null;
        try {
            return new NfcV(tag);
        } catch (RemoteException e) {
            return null;
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:30.085 -0400", hash_original_method = "19D3A3646C1C2655B316DC5413F4466A", hash_generated_method = "57A780AB7247A57E3ED9AF00CBF2DE42")
    public byte getResponseFlags() {
        byte var3934254C6C714B19DE22D4F58C5042D2_1020788590 = (mRespFlags);
                byte var40EA57D3EE3C07BF1C102B466E1C3091_1037342228 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_1037342228;
        // ---------- Original Method ----------
        //return mRespFlags;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:30.085 -0400", hash_original_method = "9F53E6713A0959247C46979AAE2F100E", hash_generated_method = "08E8D5EC7D98A6EC8D4D03D7A8484F4F")
    public byte getDsfId() {
        byte varE9C54BDE6798E1875D8BC87A6FAA80B7_1596397142 = (mDsfId);
                byte var40EA57D3EE3C07BF1C102B466E1C3091_1921984277 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_1921984277;
        // ---------- Original Method ----------
        //return mDsfId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:30.085 -0400", hash_original_method = "E43990821CE38E04B46B3E901EFDFA24", hash_generated_method = "89DA7153443552C0F5CF18881A3CAC13")
    public byte[] transceive(byte[] data) throws IOException {
        addTaint(data[0]);
        byte[] varEE32C696607EBC614D9A30134ACB1AE3_265096570 = (transceive(data, true));
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_345518645 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_345518645;
        // ---------- Original Method ----------
        //return transceive(data, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:30.086 -0400", hash_original_method = "CF96EF3BF3FCE4DA3D9E7FBB541AEB70", hash_generated_method = "3F0E12AD982553C2A7B230005334021E")
    public int getMaxTransceiveLength() {
        int var534FE261D7083B235B3B010A14A83EE1_746476423 = (getMaxTransceiveLengthInternal());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_465017813 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_465017813;
        // ---------- Original Method ----------
        //return getMaxTransceiveLengthInternal();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:30.086 -0400", hash_original_field = "C99DD94648D9D9F6D7060CF3152F88F2", hash_generated_field = "95711EE7AD682B156CC0B59B8BB1D20B")

    public static final String EXTRA_RESP_FLAGS = "respflags";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:30.086 -0400", hash_original_field = "CCB6A7BF3A94EDCFFED77B4B1FE0A21F", hash_generated_field = "575D53CDD0D0DA8B99F62F7C149BA7A1")

    public static final String EXTRA_DSFID = "dsfid";
}

