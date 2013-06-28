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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.317 -0400", hash_original_field = "F4F4BB2F9EB2DC5DB314559654709FE8", hash_generated_field = "C1B33D9EC979F28624EE472E9265053E")

    private byte[] mHiLayerResponse = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.317 -0400", hash_original_field = "22B2164B7144C7AFBD0B67213E9A40D7", hash_generated_field = "7255E07206283D65FDE42F0CB345FA56")

    private byte[] mHistBytes = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.317 -0400", hash_original_method = "FFBD1FB2ECDDD8F0799F6AF75CBD6C12", hash_generated_method = "DC341F18A00B176E75E65C5410F19F45")
    public  IsoDep(Tag tag) throws RemoteException {
        super(tag, TagTechnology.ISO_DEP);
        Bundle extras = tag.getTechExtras(TagTechnology.ISO_DEP);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.318 -0400", hash_original_method = "C12C31601200CC9185BEA621DAA9D522", hash_generated_method = "F12D7FF24E15ECDE5F81348EE145EB65")
    public void setTimeout(int timeout) {
        try 
        {
            int err = mTag.getTagService().setTimeout(TagTechnology.ISO_DEP, timeout);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.319 -0400", hash_original_method = "DE4D3DFA438B7711A20A8976B1AA544A", hash_generated_method = "6ACB3DBBE249F78DB8606B64E5CDD740")
    public int getTimeout() {
        try 
        {
            int varC5FF19B810CBF66E7DB7FC8454C4AFCA_2050241754 = (mTag.getTagService().getTimeout(TagTechnology.ISO_DEP));
        } //End block
        catch (RemoteException e)
        { }
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_661180736 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_661180736;
        // ---------- Original Method ----------
        //try {
            //return mTag.getTagService().getTimeout(TagTechnology.ISO_DEP);
        //} catch (RemoteException e) {
            //Log.e(TAG, "NFC service dead", e);
            //return 0;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.319 -0400", hash_original_method = "4E22C8A1A17AEE88575C62DC6B93AE32", hash_generated_method = "FD14A9D67EFB7AB67D1CBF28246AA6E8")
    public byte[] getHistoricalBytes() {
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1126075905 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1126075905;
        // ---------- Original Method ----------
        //return mHistBytes;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.320 -0400", hash_original_method = "7FAA32860355D81337B89B991C6D0641", hash_generated_method = "670A6996EA222EDE3B22D5CDE18CC4C6")
    public byte[] getHiLayerResponse() {
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_313221808 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_313221808;
        // ---------- Original Method ----------
        //return mHiLayerResponse;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.320 -0400", hash_original_method = "E43990821CE38E04B46B3E901EFDFA24", hash_generated_method = "37D0D070CA7E5AB30616E5C214E43F3F")
    public byte[] transceive(byte[] data) throws IOException {
        byte[] var457CAD28AA5A950818B34ED801FB2565_493021071 = (transceive(data, true));
        addTaint(data[0]);
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1245194246 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1245194246;
        // ---------- Original Method ----------
        //return transceive(data, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.321 -0400", hash_original_method = "CF96EF3BF3FCE4DA3D9E7FBB541AEB70", hash_generated_method = "7664BAEDE97E69BA87AC06C4D7362877")
    public int getMaxTransceiveLength() {
        int varAD50EB2A6987338433A93D587AD15277_38156299 = (getMaxTransceiveLengthInternal());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1955662941 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1955662941;
        // ---------- Original Method ----------
        //return getMaxTransceiveLengthInternal();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.321 -0400", hash_original_field = "839E89798F641D78E99C5732B39CA844", hash_generated_field = "BC8F11E4AEAD11E0412B7B53DF0CA6C8")

    private static final String TAG = "NFC";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.321 -0400", hash_original_field = "72352BC6B0DC471E2C939FC0BA692C27", hash_generated_field = "0E2E65346F18311034DF7A7BA8ADFB90")

    public static final String EXTRA_HI_LAYER_RESP = "hiresp";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.321 -0400", hash_original_field = "1B1E1C168088B9F721F5154BBBEEEA75", hash_generated_field = "21C86F60B2A1F20B574EAB41D200309D")

    public static final String EXTRA_HIST_BYTES = "histbytes";
}

