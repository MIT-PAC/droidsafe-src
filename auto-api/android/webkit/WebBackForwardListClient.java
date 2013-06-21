package android.webkit;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public abstract class WebBackForwardListClient {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.967 -0400", hash_original_method = "74789BB6335E2FF94B87CE90E522AE17", hash_generated_method = "74789BB6335E2FF94B87CE90E522AE17")
        public WebBackForwardListClient ()
    {
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.967 -0400", hash_original_method = "1F6D8177500DFC3D1F576E07196A0774", hash_generated_method = "5895FCC0187A30DFD8837C5922C996D6")
    @DSModeled(DSC.SAFE)
    public void onNewHistoryItem(WebHistoryItem item) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(item.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.968 -0400", hash_original_method = "DA8164C67D7B3779FDED447EEF1649BA", hash_generated_method = "E0D49FB56D59A0D34D9F508AD15BA5E4")
    @DSModeled(DSC.SAFE)
    public void onIndexChanged(WebHistoryItem item, int index) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(index);
        dsTaint.addTaint(item.dsTaint);
        // ---------- Original Method ----------
    }

    
}

