package android.nfc;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.Context;

public final class NfcManager {
    private NfcAdapter mAdapter;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.066 -0400", hash_original_method = "5612BA010CEBE1CDB104E5EE130CB87B", hash_generated_method = "10D1AC5D7CB55058B442A4F4B74720BD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NfcManager(Context context) {
        dsTaint.addTaint(context.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.066 -0400", hash_original_method = "4CC1396725247CE50C996383E5F907DD", hash_generated_method = "0B89BC8505EAB9DA33B55AC3CC047791")
    @DSModeled(DSC.SAFE)
    public NfcAdapter getDefaultAdapter() {
        return (NfcAdapter)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mAdapter;
    }

    
}

