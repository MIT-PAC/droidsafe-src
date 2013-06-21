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
    private short mSak;
    private byte[] mAtqa;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.216 -0400", hash_original_method = "7F7EA5045624074AA33D4555E4EB43B6", hash_generated_method = "547114D063C5757FF21BEC72735B98F2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NfcA(Tag tag) throws RemoteException {
        super(tag, TagTechnology.NFC_A);
        dsTaint.addTaint(tag.dsTaint);
        Bundle extras;
        extras = tag.getTechExtras(TagTechnology.NFC_A);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.217 -0400", hash_original_method = "0C48EFD3E17B27EC975A7F66A0C95A20", hash_generated_method = "2DDA7003C6C8EA50B0E24277989585D9")
    @DSModeled(DSC.SAFE)
    public byte[] getAtqa() {
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //return mAtqa;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.217 -0400", hash_original_method = "82922CBBC94A0186459AA7EC846F5755", hash_generated_method = "473A46C71830529616B40A18C5B7585C")
    @DSModeled(DSC.SAFE)
    public short getSak() {
        return dsTaint.getTaintShort();
        // ---------- Original Method ----------
        //return mSak;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.217 -0400", hash_original_method = "E43990821CE38E04B46B3E901EFDFA24", hash_generated_method = "4122FC2951C0711D699B5F1905B25C96")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public byte[] transceive(byte[] data) throws IOException {
        dsTaint.addTaint(data[0]);
        byte[] var457CAD28AA5A950818B34ED801FB2565_1671306044 = (transceive(data, true));
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //return transceive(data, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.218 -0400", hash_original_method = "CF96EF3BF3FCE4DA3D9E7FBB541AEB70", hash_generated_method = "C1556970BFC395DBE6423CBCD0710CFA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getMaxTransceiveLength() {
        int varAD50EB2A6987338433A93D587AD15277_900208363 = (getMaxTransceiveLengthInternal());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return getMaxTransceiveLengthInternal();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.218 -0400", hash_original_method = "63D5F2163C0B5751BB93B998E089091B", hash_generated_method = "344B9252CC0E9320A2F7C90D0074AEFE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setTimeout(int timeout) {
        dsTaint.addTaint(timeout);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.219 -0400", hash_original_method = "BA38E23E1F1B427D7366A44F0802731B", hash_generated_method = "813DD9245B13BE5D735E1C0BDA5B912F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getTimeout() {
        try 
        {
            int var813639331A2D794D17159D8A9F2E1640_1783549067 = (mTag.getTagService().getTimeout(TagTechnology.NFC_A));
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //try {
            //return mTag.getTagService().getTimeout(TagTechnology.NFC_A);
        //} catch (RemoteException e) {
            //Log.e(TAG, "NFC service dead", e);
            //return 0;
        //}
    }

    
    private static final String TAG = "NFC";
    public static final String EXTRA_SAK = "sak";
    public static final String EXTRA_ATQA = "atqa";
}

