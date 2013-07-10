package android.webkit;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public abstract class WebBackForwardListClient {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.745 -0400", hash_original_method = "3EE15C74E8939A7E4FFBB261B684E6CA", hash_generated_method = "3EE15C74E8939A7E4FFBB261B684E6CA")
    public WebBackForwardListClient ()
    {
        
    }


    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.745 -0400", hash_original_method = "1F6D8177500DFC3D1F576E07196A0774", hash_generated_method = "7C0B18AA8E10573E65AF5537966325F2")
    public void onNewHistoryItem(WebHistoryItem item) {
        
        addTaint(item.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.745 -0400", hash_original_method = "DA8164C67D7B3779FDED447EEF1649BA", hash_generated_method = "E9120E4D6CA62A38BD20BE90B48DB91D")
    public void onIndexChanged(WebHistoryItem item, int index) {
        
        addTaint(item.getTaint());
        addTaint(index);
        
    }

    
}

