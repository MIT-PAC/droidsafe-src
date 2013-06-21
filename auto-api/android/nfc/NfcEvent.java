package android.nfc;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public final class NfcEvent {
    public NfcAdapter nfcAdapter;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.061 -0400", hash_original_method = "EC9DC1FF5D63DBE437BD3C224D5FA5E1", hash_generated_method = "B17C5D448510D7C1989542C0C2D22088")
    @DSModeled(DSC.SAFE)
     NfcEvent(NfcAdapter nfcAdapter) {
        dsTaint.addTaint(nfcAdapter.dsTaint);
        // ---------- Original Method ----------
        //this.nfcAdapter = nfcAdapter;
    }

    
}

