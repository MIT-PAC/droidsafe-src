package android.nfc.tech;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.nfc.Tag;
import android.os.Bundle;
import android.os.RemoteException;
import java.io.IOException;

public final class NfcV extends BasicTagTechnology {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:26.690 -0400", hash_original_field = "3934254C6C714B19DE22D4F58C5042D2", hash_generated_field = "121CAF4F22F2DB7E3FE6590C2E29C484")

    private byte mRespFlags;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:26.690 -0400", hash_original_field = "E9C54BDE6798E1875D8BC87A6FAA80B7", hash_generated_field = "22B4F1B6769CD74A976FDA7EB332E5E3")

    private byte mDsfId;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:26.695 -0400", hash_original_method = "F4045E9985ED2B22A83A671B7ECDE866", hash_generated_method = "0077E3629C56FB4BB5474BEF58D7BA41")
    public  NfcV(Tag tag) throws RemoteException {
        super(tag, TagTechnology.NFC_V);
        Bundle extras;
        extras = tag.getTechExtras(TagTechnology.NFC_V);
        mRespFlags = extras.getByte(EXTRA_RESP_FLAGS);
        mDsfId = extras.getByte(EXTRA_DSFID);
        addTaint(tag.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:26.696 -0400", hash_original_method = "19D3A3646C1C2655B316DC5413F4466A", hash_generated_method = "74EFC72727368C03302C4A55B51FDF35")
    public byte getResponseFlags() {
        byte var40EA57D3EE3C07BF1C102B466E1C3091_1947644406 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_1947644406;
        // ---------- Original Method ----------
        //return mRespFlags;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:26.697 -0400", hash_original_method = "9F53E6713A0959247C46979AAE2F100E", hash_generated_method = "888FBCE0CFD3CCD2B886C24C28C09EAF")
    public byte getDsfId() {
        byte var40EA57D3EE3C07BF1C102B466E1C3091_1824504372 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_1824504372;
        // ---------- Original Method ----------
        //return mDsfId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:26.711 -0400", hash_original_method = "E43990821CE38E04B46B3E901EFDFA24", hash_generated_method = "87FA88590469E08BD27B078E627F5629")
    public byte[] transceive(byte[] data) throws IOException {
        byte[] var457CAD28AA5A950818B34ED801FB2565_487785829 = (transceive(data, true));
        addTaint(data[0]);
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_595787989 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_595787989;
        // ---------- Original Method ----------
        //return transceive(data, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:26.713 -0400", hash_original_method = "CF96EF3BF3FCE4DA3D9E7FBB541AEB70", hash_generated_method = "FCCAFFEEA43649F9329F2F31E0139310")
    public int getMaxTransceiveLength() {
        int varAD50EB2A6987338433A93D587AD15277_939141599 = (getMaxTransceiveLengthInternal());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1454592103 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1454592103;
        // ---------- Original Method ----------
        //return getMaxTransceiveLengthInternal();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:26.723 -0400", hash_original_field = "C99DD94648D9D9F6D7060CF3152F88F2", hash_generated_field = "95711EE7AD682B156CC0B59B8BB1D20B")

    public static final String EXTRA_RESP_FLAGS = "respflags";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:26.723 -0400", hash_original_field = "CCB6A7BF3A94EDCFFED77B4B1FE0A21F", hash_generated_field = "575D53CDD0D0DA8B99F62F7C149BA7A1")

    public static final String EXTRA_DSFID = "dsfid";
}

