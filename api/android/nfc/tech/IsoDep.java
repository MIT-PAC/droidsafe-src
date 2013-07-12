package android.nfc.tech;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.nfc.ErrorCodes;
import android.nfc.Tag;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import java.io.IOException;

public final class IsoDep extends BasicTagTechnology {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.839 -0400", hash_original_field = "F4F4BB2F9EB2DC5DB314559654709FE8", hash_generated_field = "C1B33D9EC979F28624EE472E9265053E")

    private byte[] mHiLayerResponse = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.839 -0400", hash_original_field = "22B2164B7144C7AFBD0B67213E9A40D7", hash_generated_field = "7255E07206283D65FDE42F0CB345FA56")

    private byte[] mHistBytes = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.839 -0400", hash_original_method = "FFBD1FB2ECDDD8F0799F6AF75CBD6C12", hash_generated_method = "58E05187FF1F01CFC18110B640E2842C")
    public  IsoDep(Tag tag) throws RemoteException {
        super(tag, TagTechnology.ISO_DEP);
        addTaint(tag.getTaint());
        Bundle extras = tag.getTechExtras(TagTechnology.ISO_DEP);
    if(extras != null)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.839 -0400", hash_original_method = "C12C31601200CC9185BEA621DAA9D522", hash_generated_method = "8BDC52824B2D4B39679E3D4C926272B2")
    public void setTimeout(int timeout) {
        addTaint(timeout);
        try 
        {
            int err = mTag.getTagService().setTimeout(TagTechnology.ISO_DEP, timeout);
    if(err != ErrorCodes.SUCCESS)            
            {
                IllegalArgumentException varDB68BEF11A046B44BA82450BD6BDD1ED_702085269 = new IllegalArgumentException("The supplied timeout is not valid");
                varDB68BEF11A046B44BA82450BD6BDD1ED_702085269.addTaint(taint);
                throw varDB68BEF11A046B44BA82450BD6BDD1ED_702085269;
            } //End block
        } //End block
        catch (RemoteException e)
        {
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.840 -0400", hash_original_method = "DE4D3DFA438B7711A20A8976B1AA544A", hash_generated_method = "ED438DE91EDF44E9518BC4BE988EEB0A")
    public int getTimeout() {
        try 
        {
            int var7707AF15D88DB268C2473ABA2228BEBE_2129960690 = (mTag.getTagService().getTimeout(TagTechnology.ISO_DEP));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_532805740 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_532805740;
        } //End block
        catch (RemoteException e)
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_1211705165 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1330475476 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1330475476;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mTag.getTagService().getTimeout(TagTechnology.ISO_DEP);
        //} catch (RemoteException e) {
            //Log.e(TAG, "NFC service dead", e);
            //return 0;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.840 -0400", hash_original_method = "4E22C8A1A17AEE88575C62DC6B93AE32", hash_generated_method = "133D3927E7BEFBB017E9075603D3BB11")
    public byte[] getHistoricalBytes() {
        byte[] varBF634AE655B38CA4FE182A84D6FB31B4_634990130 = (mHistBytes);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_296479476 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_296479476;
        // ---------- Original Method ----------
        //return mHistBytes;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.840 -0400", hash_original_method = "7FAA32860355D81337B89B991C6D0641", hash_generated_method = "A1E586598E74B1BA8060374ABBA199B9")
    public byte[] getHiLayerResponse() {
        byte[] var3FCC1F1F25547D9C92055C962923F437_1034501245 = (mHiLayerResponse);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_864622472 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_864622472;
        // ---------- Original Method ----------
        //return mHiLayerResponse;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.840 -0400", hash_original_method = "E43990821CE38E04B46B3E901EFDFA24", hash_generated_method = "D3D1D1916D3EAABF10BBC77ACC5266E9")
    public byte[] transceive(byte[] data) throws IOException {
        addTaint(data[0]);
        byte[] varEE32C696607EBC614D9A30134ACB1AE3_1449624735 = (transceive(data, true));
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_596610305 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_596610305;
        // ---------- Original Method ----------
        //return transceive(data, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.840 -0400", hash_original_method = "CF96EF3BF3FCE4DA3D9E7FBB541AEB70", hash_generated_method = "E0D9CCE033A3CE5D3B90ED82BAE96F00")
    public int getMaxTransceiveLength() {
        int var534FE261D7083B235B3B010A14A83EE1_967235170 = (getMaxTransceiveLengthInternal());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_744216439 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_744216439;
        // ---------- Original Method ----------
        //return getMaxTransceiveLengthInternal();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.840 -0400", hash_original_field = "839E89798F641D78E99C5732B39CA844", hash_generated_field = "BC8F11E4AEAD11E0412B7B53DF0CA6C8")

    private static final String TAG = "NFC";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.840 -0400", hash_original_field = "72352BC6B0DC471E2C939FC0BA692C27", hash_generated_field = "0E2E65346F18311034DF7A7BA8ADFB90")

    public static final String EXTRA_HI_LAYER_RESP = "hiresp";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.840 -0400", hash_original_field = "1B1E1C168088B9F721F5154BBBEEEA75", hash_generated_field = "21C86F60B2A1F20B574EAB41D200309D")

    public static final String EXTRA_HIST_BYTES = "histbytes";
}

