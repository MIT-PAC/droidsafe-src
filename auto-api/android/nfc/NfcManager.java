package android.nfc;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.Context;

public final class NfcManager {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:24.673 -0400", hash_original_field = "59E9F255F2F17EC006AE601269EA8540", hash_generated_field = "ED79E91C532F555A55D38CC488E317EF")

    private NfcAdapter mAdapter;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:24.682 -0400", hash_original_method = "5612BA010CEBE1CDB104E5EE130CB87B", hash_generated_method = "C814310DA6C1045426BA808D96D99D59")
    public  NfcManager(Context context) {
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
        addTaint(context.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:24.682 -0400", hash_original_method = "4CC1396725247CE50C996383E5F907DD", hash_generated_method = "31C07D1CE4EC27575EEE323D22A3E58B")
    public NfcAdapter getDefaultAdapter() {
        NfcAdapter varB4EAC82CA7396A68D541C85D26508E83_708133457 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_708133457 = mAdapter;
        varB4EAC82CA7396A68D541C85D26508E83_708133457.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_708133457;
        // ---------- Original Method ----------
        //return mAdapter;
    }

    
}

