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

public final class IsoDep extends BasicTagTechnology {
    private byte[] mHiLayerResponse = null;
    private byte[] mHistBytes = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.151 -0400", hash_original_method = "FFBD1FB2ECDDD8F0799F6AF75CBD6C12", hash_generated_method = "30B6F7A6A753E498047482CDD0986FB6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public IsoDep(Tag tag) throws RemoteException {
        super(tag, TagTechnology.ISO_DEP);
        dsTaint.addTaint(tag.dsTaint);
        Bundle extras;
        extras = tag.getTechExtras(TagTechnology.ISO_DEP);
        {
            mHiLayerResponse = extras.getByteArray(EXTRA_HI_LAYER_RESP);
            mHistBytes = extras.getByteArray(EXTRA_HIST_BYTES);
        } //End block
        // ---------- Original Method ----------
        //Bundle extras = tag.getTechExtras(TagTechnology.ISO_DEP);
        //if (extras != null) {
            //mHiLayerResponse = extras.getByteArray(EXTRA_HI_LAYER_RESP);
            //mHistBytes = extras.getByteArray(EXTRA_HIST_BYTES);
        //}
    }

    
        public static IsoDep get(Tag tag) {
        if (!tag.hasTech(TagTechnology.ISO_DEP)) return null;
        try {
            return new IsoDep(tag);
        } catch (RemoteException e) {
            return null;
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.152 -0400", hash_original_method = "C12C31601200CC9185BEA621DAA9D522", hash_generated_method = "AE5E9BCAFF8135C2D8102EB6436E045B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setTimeout(int timeout) {
        dsTaint.addTaint(timeout);
        try 
        {
            int err;
            err = mTag.getTagService().setTimeout(TagTechnology.ISO_DEP, timeout);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("The supplied timeout is not valid");
            } //End block
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        //try {
            //int err = mTag.getTagService().setTimeout(TagTechnology.ISO_DEP, timeout);
            //if (err != ErrorCodes.SUCCESS) {
                //throw new IllegalArgumentException("The supplied timeout is not valid");
            //}
        //} catch (RemoteException e) {
            //Log.e(TAG, "NFC service dead", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.152 -0400", hash_original_method = "DE4D3DFA438B7711A20A8976B1AA544A", hash_generated_method = "4B0B3223FF6BFAEB7BD6897374AEC54F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getTimeout() {
        try 
        {
            int varC5FF19B810CBF66E7DB7FC8454C4AFCA_960048035 = (mTag.getTagService().getTimeout(TagTechnology.ISO_DEP));
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //try {
            //return mTag.getTagService().getTimeout(TagTechnology.ISO_DEP);
        //} catch (RemoteException e) {
            //Log.e(TAG, "NFC service dead", e);
            //return 0;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.153 -0400", hash_original_method = "4E22C8A1A17AEE88575C62DC6B93AE32", hash_generated_method = "7251CEED416610F31EA0C0BA1C8CB340")
    @DSModeled(DSC.SAFE)
    public byte[] getHistoricalBytes() {
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //return mHistBytes;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.155 -0400", hash_original_method = "7FAA32860355D81337B89B991C6D0641", hash_generated_method = "E404404C1619BF5B6C4E1D797269E9C7")
    @DSModeled(DSC.SAFE)
    public byte[] getHiLayerResponse() {
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //return mHiLayerResponse;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.155 -0400", hash_original_method = "E43990821CE38E04B46B3E901EFDFA24", hash_generated_method = "D327AA43EDA07417576173B36F2919CE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public byte[] transceive(byte[] data) throws IOException {
        dsTaint.addTaint(data[0]);
        byte[] var457CAD28AA5A950818B34ED801FB2565_242974013 = (transceive(data, true));
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //return transceive(data, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.155 -0400", hash_original_method = "CF96EF3BF3FCE4DA3D9E7FBB541AEB70", hash_generated_method = "D5543300ABE90FB338C56E061E83C3C5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getMaxTransceiveLength() {
        int varAD50EB2A6987338433A93D587AD15277_2090129230 = (getMaxTransceiveLengthInternal());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return getMaxTransceiveLengthInternal();
    }

    
    private static final String TAG = "NFC";
    public static final String EXTRA_HI_LAYER_RESP = "hiresp";
    public static final String EXTRA_HIST_BYTES = "histbytes";
}

