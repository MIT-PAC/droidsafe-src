package android.nfc;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.content.Context;

public final class NfcManager {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:52.350 -0500", hash_original_field = "278F7851F6317C51C418D85323A63D34", hash_generated_field = "ED79E91C532F555A55D38CC488E317EF")

    private  NfcAdapter mAdapter;

    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:52.352 -0500", hash_original_method = "5612BA010CEBE1CDB104E5EE130CB87B", hash_generated_method = "832009535D5905BC98603D93F5423842")
    
public NfcManager(Context context) {
        NfcAdapter adapter;
        context = context.getApplicationContext();
        try {
            adapter = NfcAdapter.getNfcAdapter(context);
        } catch (UnsupportedOperationException e) {
            adapter = null;
        }
        mAdapter = adapter;
    }

    /**
     * Get the default NFC Adapter for this device.
     *
     * @return the default NFC Adapter
     */
    @DSSource({DSSourceKind.NFC})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:52.355 -0500", hash_original_method = "4CC1396725247CE50C996383E5F907DD", hash_generated_method = "803C3CA85BB70A9D891EDBBF5726E533")
    
public NfcAdapter getDefaultAdapter() {
        return mAdapter;
    }
    
}

