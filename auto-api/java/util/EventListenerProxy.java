package java.util;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public abstract class EventListenerProxy implements EventListener {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.255 -0400", hash_original_field = "D0B62CF0CD270BB58374F321620931FF", hash_generated_field = "63216795243EEE41ECEC8F741B6ECA5B")

    private EventListener listener;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.256 -0400", hash_original_method = "0B02F9CA1E264165C6D771C4F9CE717F", hash_generated_method = "ACE6F3593A5CA063F5D8E2853B083D46")
    public  EventListenerProxy(EventListener listener) {
        this.listener = listener;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.257 -0400", hash_original_method = "544CEBD256D91351395433E8E1959E7F", hash_generated_method = "B60EBCE8EFC5813D670E09177C76AE0F")
    public EventListener getListener() {
        EventListener varB4EAC82CA7396A68D541C85D26508E83_1127403205 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1127403205 = listener;
        varB4EAC82CA7396A68D541C85D26508E83_1127403205.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1127403205;
        
        
    }

    
}

