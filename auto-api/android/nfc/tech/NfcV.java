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
    private byte mRespFlags;
    private byte mDsfId;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.235 -0400", hash_original_method = "F4045E9985ED2B22A83A671B7ECDE866", hash_generated_method = "767FED07BE7F4F0358D092056F9ADF74")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NfcV(Tag tag) throws RemoteException {
        super(tag, TagTechnology.NFC_V);
        dsTaint.addTaint(tag.dsTaint);
        Bundle extras;
        extras = tag.getTechExtras(TagTechnology.NFC_V);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.235 -0400", hash_original_method = "19D3A3646C1C2655B316DC5413F4466A", hash_generated_method = "EBD0CAA40C5609FE7C17369543CBB66A")
    @DSModeled(DSC.SAFE)
    public byte getResponseFlags() {
        return dsTaint.getTaintByte();
        // ---------- Original Method ----------
        //return mRespFlags;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.236 -0400", hash_original_method = "9F53E6713A0959247C46979AAE2F100E", hash_generated_method = "6EEAF4CCFE4C8A03B2A091B6066E0BC7")
    @DSModeled(DSC.SAFE)
    public byte getDsfId() {
        return dsTaint.getTaintByte();
        // ---------- Original Method ----------
        //return mDsfId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.236 -0400", hash_original_method = "E43990821CE38E04B46B3E901EFDFA24", hash_generated_method = "A8986BED06162955A4F51AB6092D7518")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public byte[] transceive(byte[] data) throws IOException {
        dsTaint.addTaint(data[0]);
        byte[] var457CAD28AA5A950818B34ED801FB2565_2040500717 = (transceive(data, true));
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //return transceive(data, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.236 -0400", hash_original_method = "CF96EF3BF3FCE4DA3D9E7FBB541AEB70", hash_generated_method = "F6A3033B634AF25F42F551A4BDF904A4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getMaxTransceiveLength() {
        int varAD50EB2A6987338433A93D587AD15277_923973376 = (getMaxTransceiveLengthInternal());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return getMaxTransceiveLengthInternal();
    }

    
    public static final String EXTRA_RESP_FLAGS = "respflags";
    public static final String EXTRA_DSFID = "dsfid";
}

