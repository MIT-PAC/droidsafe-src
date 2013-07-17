package android.webkit;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public abstract class WebBackForwardListClient {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.340 -0400", hash_original_method = "3EE15C74E8939A7E4FFBB261B684E6CA", hash_generated_method = "3EE15C74E8939A7E4FFBB261B684E6CA")
    public WebBackForwardListClient ()
    {
        //Synthesized constructor
    }


        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.340 -0400", hash_original_method = "1F6D8177500DFC3D1F576E07196A0774", hash_generated_method = "7C0B18AA8E10573E65AF5537966325F2")
    public void onNewHistoryItem(WebHistoryItem item) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(item.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.341 -0400", hash_original_method = "DA8164C67D7B3779FDED447EEF1649BA", hash_generated_method = "5A2ABCD908B21A43DB1DAECD3CBD7864")
    public void onIndexChanged(WebHistoryItem item, int index) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(index);
        addTaint(item.getTaint());
        // ---------- Original Method ----------
    }

    
}

