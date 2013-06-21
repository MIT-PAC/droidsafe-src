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

public final class NfcB extends BasicTagTechnology {
    private byte[] mAppData;
    private byte[] mProtInfo;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.223 -0400", hash_original_method = "2D2D9B1E167FA423D2EE7B2AB12658F9", hash_generated_method = "7DED21142DBFFC2B2D208A881ED37A06")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NfcB(Tag tag) throws RemoteException {
        super(tag, TagTechnology.NFC_B);
        dsTaint.addTaint(tag.dsTaint);
        Bundle extras;
        extras = tag.getTechExtras(TagTechnology.NFC_B);
        mAppData = extras.getByteArray(EXTRA_APPDATA);
        mProtInfo = extras.getByteArray(EXTRA_PROTINFO);
        // ---------- Original Method ----------
        //Bundle extras = tag.getTechExtras(TagTechnology.NFC_B);
        //mAppData = extras.getByteArray(EXTRA_APPDATA);
        //mProtInfo = extras.getByteArray(EXTRA_PROTINFO);
    }

    
        public static NfcB get(Tag tag) {
        if (!tag.hasTech(TagTechnology.NFC_B)) return null;
        try {
            return new NfcB(tag);
        } catch (RemoteException e) {
            return null;
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.223 -0400", hash_original_method = "FD7D4BBD84674EF268698E76F3B3C4A1", hash_generated_method = "3016A371C1685A73CF5832940D14A21F")
    @DSModeled(DSC.SAFE)
    public byte[] getApplicationData() {
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //return mAppData;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.224 -0400", hash_original_method = "4842BF20AFFD1556EAAF44F971F8DB01", hash_generated_method = "8599E1498F10E104A38BAB16BA9900BC")
    @DSModeled(DSC.SAFE)
    public byte[] getProtocolInfo() {
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //return mProtInfo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.224 -0400", hash_original_method = "E43990821CE38E04B46B3E901EFDFA24", hash_generated_method = "4BE7D58A3620D40B4E483305D4C4ACAA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public byte[] transceive(byte[] data) throws IOException {
        dsTaint.addTaint(data[0]);
        byte[] var457CAD28AA5A950818B34ED801FB2565_1197386546 = (transceive(data, true));
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //return transceive(data, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.224 -0400", hash_original_method = "CF96EF3BF3FCE4DA3D9E7FBB541AEB70", hash_generated_method = "4B164A33D67795450F03CF08ABC9515A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getMaxTransceiveLength() {
        int varAD50EB2A6987338433A93D587AD15277_1430704269 = (getMaxTransceiveLengthInternal());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return getMaxTransceiveLengthInternal();
    }

    
    public static final String EXTRA_APPDATA = "appdata";
    public static final String EXTRA_PROTINFO = "protinfo";
}

