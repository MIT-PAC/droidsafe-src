package android.nfc;

// Droidsafe Imports
import droidsafe.annotations.*;
import android.content.Context;





public final class NfcManager {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.311 -0400", hash_original_field = "59E9F255F2F17EC006AE601269EA8540", hash_generated_field = "ED79E91C532F555A55D38CC488E317EF")

    private NfcAdapter mAdapter;
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.312 -0400", hash_original_method = "5612BA010CEBE1CDB104E5EE130CB87B", hash_generated_method = "F66E5EB895C65AEF98AEB29DE59572AC")
    public  NfcManager(Context context) {
        addTaint(context.getTaint());
        NfcAdapter adapter;
        context = context.getApplicationContext();
        try 
        {
            adapter = NfcAdapter.getNfcAdapter(context);
        } //End block
        catch (UnsupportedOperationException e)
        {
            adapter = null;
        } //End block
        mAdapter = adapter;
        // ---------- Original Method ----------
        //NfcAdapter adapter;
        //context = context.getApplicationContext();
        //try {
            //adapter = NfcAdapter.getNfcAdapter(context);
        //} catch (UnsupportedOperationException e) {
            //adapter = null;
        //}
        //mAdapter = adapter;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.313 -0400", hash_original_method = "4CC1396725247CE50C996383E5F907DD", hash_generated_method = "DF743D6349CF0BD64D48342D1CCEA649")
    public NfcAdapter getDefaultAdapter() {
NfcAdapter varD72668EDE5E63ADF9340F3D8A19FD205_849386327 =         mAdapter;
        varD72668EDE5E63ADF9340F3D8A19FD205_849386327.addTaint(taint);
        return varD72668EDE5E63ADF9340F3D8A19FD205_849386327;
        // ---------- Original Method ----------
        //return mAdapter;
    }

    
}

