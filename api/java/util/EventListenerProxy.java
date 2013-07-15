package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public abstract class EventListenerProxy implements EventListener {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:09.660 -0400", hash_original_field = "D0B62CF0CD270BB58374F321620931FF", hash_generated_field = "63216795243EEE41ECEC8F741B6ECA5B")

    private EventListener listener;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:09.661 -0400", hash_original_method = "0B02F9CA1E264165C6D771C4F9CE717F", hash_generated_method = "ACE6F3593A5CA063F5D8E2853B083D46")
    public  EventListenerProxy(EventListener listener) {
        this.listener = listener;
        // ---------- Original Method ----------
        //this.listener = listener;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:09.661 -0400", hash_original_method = "544CEBD256D91351395433E8E1959E7F", hash_generated_method = "2E20F67D52C9228164741BEA996341F9")
    public EventListener getListener() {
EventListener var0FE74908611E65D97373734F5DECF5DC_2064837132 =         listener;
        var0FE74908611E65D97373734F5DECF5DC_2064837132.addTaint(taint);
        return var0FE74908611E65D97373734F5DECF5DC_2064837132;
        // ---------- Original Method ----------
        //return listener;
    }

    
}

