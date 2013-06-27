package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public abstract class EventListenerProxy implements EventListener {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.615 -0400", hash_original_field = "D0B62CF0CD270BB58374F321620931FF", hash_generated_field = "63216795243EEE41ECEC8F741B6ECA5B")

    private EventListener listener;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.616 -0400", hash_original_method = "0B02F9CA1E264165C6D771C4F9CE717F", hash_generated_method = "ACE6F3593A5CA063F5D8E2853B083D46")
    public  EventListenerProxy(EventListener listener) {
        this.listener = listener;
        // ---------- Original Method ----------
        //this.listener = listener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:50.616 -0400", hash_original_method = "544CEBD256D91351395433E8E1959E7F", hash_generated_method = "36A158B005FF825CC578BC32AA66B1C6")
    public EventListener getListener() {
        EventListener varB4EAC82CA7396A68D541C85D26508E83_39461542 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_39461542 = listener;
        varB4EAC82CA7396A68D541C85D26508E83_39461542.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_39461542;
        // ---------- Original Method ----------
        //return listener;
    }

    
}

