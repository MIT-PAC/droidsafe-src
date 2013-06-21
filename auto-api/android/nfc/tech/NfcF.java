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
    private byte[] mSystemCode = null;
    private byte[] mManufacturer = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.228 -0400", hash_original_method = "0D9BC91BC56C91CB4B73C77A46406834", hash_generated_method = "10912F85FE385E8C8D01A554329C4FE9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NfcF(Tag tag) throws RemoteException {
        super(tag, TagTechnology.NFC_F);
        dsTaint.addTaint(tag.dsTaint);
        Bundle extras;
        extras = tag.getTechExtras(TagTechnology.NFC_F);
        {
            mSystemCode = extras.getByteArray(EXTRA_SC);
            mManufacturer = extras.getByteArray(EXTRA_PMM);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.229 -0400", hash_original_method = "5593A08645ACC7B6D3C7AFEF98D893C4", hash_generated_method = "6550527F99ED2790D4AF1333DA291746")
    @DSModeled(DSC.SAFE)
    public byte[] getSystemCode() {
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //return mSystemCode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.230 -0400", hash_original_method = "674E72909806E7E1411B5B9E47606852", hash_generated_method = "5EFAF2661DCE7DB757AFD33AA1B4B1B1")
    @DSModeled(DSC.SAFE)
    public byte[] getManufacturer() {
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //return mManufacturer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.231 -0400", hash_original_method = "E43990821CE38E04B46B3E901EFDFA24", hash_generated_method = "7CA9DA5F4927AA12A996AB3ECCF94B2D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public byte[] transceive(byte[] data) throws IOException {
        dsTaint.addTaint(data[0]);
        byte[] var457CAD28AA5A950818B34ED801FB2565_418467334 = (transceive(data, true));
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //return transceive(data, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.231 -0400", hash_original_method = "CF96EF3BF3FCE4DA3D9E7FBB541AEB70", hash_generated_method = "20E29266832A6FFECD3AEC61891BA81E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getMaxTransceiveLength() {
        int varAD50EB2A6987338433A93D587AD15277_1548334416 = (getMaxTransceiveLengthInternal());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return getMaxTransceiveLengthInternal();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.232 -0400", hash_original_method = "D0C1DC7ECC9E082014D504E80FD68DDB", hash_generated_method = "969737ADFDC28BBD8FAC6A39D0FD9B2B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setTimeout(int timeout) {
        dsTaint.addTaint(timeout);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.232 -0400", hash_original_method = "BA26E553829B17341BEC1294BC995A3C", hash_generated_method = "376A94A73DCF43D26045DB577AD698A3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getTimeout() {
        try 
        {
            int var49C08BE73C927C35F6D435ADE00A7269_1403021846 = (mTag.getTagService().getTimeout(TagTechnology.NFC_F));
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //try {
            //return mTag.getTagService().getTimeout(TagTechnology.NFC_F);
        //} catch (RemoteException e) {
            //Log.e(TAG, "NFC service dead", e);
            //return 0;
        //}
    }

    
    private static final String TAG = "NFC";
    public static final String EXTRA_SC = "systemcode";
    public static final String EXTRA_PMM = "pmm";
}

