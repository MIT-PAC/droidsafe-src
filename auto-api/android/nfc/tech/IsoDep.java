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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:26.469 -0400", hash_original_field = "F4F4BB2F9EB2DC5DB314559654709FE8", hash_generated_field = "C1B33D9EC979F28624EE472E9265053E")

    private byte[] mHiLayerResponse = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:26.469 -0400", hash_original_field = "22B2164B7144C7AFBD0B67213E9A40D7", hash_generated_field = "7255E07206283D65FDE42F0CB345FA56")

    private byte[] mHistBytes = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:26.470 -0400", hash_original_method = "FFBD1FB2ECDDD8F0799F6AF75CBD6C12", hash_generated_method = "35C2DB01B7B6ACF55D2B7FDBAF8B0F50")
    public  IsoDep(Tag tag) throws RemoteException {
        super(tag, TagTechnology.ISO_DEP);
        Bundle extras;
        extras = tag.getTechExtras(TagTechnology.ISO_DEP);
        {
            mHiLayerResponse = extras.getByteArray(EXTRA_HI_LAYER_RESP);
            mHistBytes = extras.getByteArray(EXTRA_HIST_BYTES);
        } //End block
        addTaint(tag.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:26.476 -0400", hash_original_method = "C12C31601200CC9185BEA621DAA9D522", hash_generated_method = "03CBB0DAB8A89831C739E3037E912ADE")
    public void setTimeout(int timeout) {
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
        addTaint(timeout);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:26.481 -0400", hash_original_method = "DE4D3DFA438B7711A20A8976B1AA544A", hash_generated_method = "40E0110A6185F2847FBC0049CE5E36DB")
    public int getTimeout() {
        try 
        {
            int varC5FF19B810CBF66E7DB7FC8454C4AFCA_1637787639 = (mTag.getTagService().getTimeout(TagTechnology.ISO_DEP));
        } //End block
        catch (RemoteException e)
        { }
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_351573487 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_351573487;
        // ---------- Original Method ----------
        //try {
            //return mTag.getTagService().getTimeout(TagTechnology.ISO_DEP);
        //} catch (RemoteException e) {
            //Log.e(TAG, "NFC service dead", e);
            //return 0;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:26.481 -0400", hash_original_method = "4E22C8A1A17AEE88575C62DC6B93AE32", hash_generated_method = "19AD9EF2667DBA7DA991C4019AF0DCB9")
    public byte[] getHistoricalBytes() {
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1650573113 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1650573113;
        // ---------- Original Method ----------
        //return mHistBytes;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:26.482 -0400", hash_original_method = "7FAA32860355D81337B89B991C6D0641", hash_generated_method = "7C07902BC6F020A468A5A2AFCB61C71C")
    public byte[] getHiLayerResponse() {
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1419285687 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1419285687;
        // ---------- Original Method ----------
        //return mHiLayerResponse;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:26.483 -0400", hash_original_method = "E43990821CE38E04B46B3E901EFDFA24", hash_generated_method = "8EF72F6A9AA56948991DD1B991539A1C")
    public byte[] transceive(byte[] data) throws IOException {
        byte[] var457CAD28AA5A950818B34ED801FB2565_2068728311 = (transceive(data, true));
        addTaint(data[0]);
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_501252244 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_501252244;
        // ---------- Original Method ----------
        //return transceive(data, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:26.483 -0400", hash_original_method = "CF96EF3BF3FCE4DA3D9E7FBB541AEB70", hash_generated_method = "D276FAF1E5D0DC9982AA95B9B0EB0D87")
    public int getMaxTransceiveLength() {
        int varAD50EB2A6987338433A93D587AD15277_839531665 = (getMaxTransceiveLengthInternal());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1445771098 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1445771098;
        // ---------- Original Method ----------
        //return getMaxTransceiveLengthInternal();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:26.483 -0400", hash_original_field = "839E89798F641D78E99C5732B39CA844", hash_generated_field = "75254E4C21911FCCBBD25490236328DA")

    private static String TAG = "NFC";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:26.483 -0400", hash_original_field = "72352BC6B0DC471E2C939FC0BA692C27", hash_generated_field = "0E2E65346F18311034DF7A7BA8ADFB90")

    public static final String EXTRA_HI_LAYER_RESP = "hiresp";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:26.483 -0400", hash_original_field = "1B1E1C168088B9F721F5154BBBEEEA75", hash_generated_field = "21C86F60B2A1F20B574EAB41D200309D")

    public static final String EXTRA_HIST_BYTES = "histbytes";
}

