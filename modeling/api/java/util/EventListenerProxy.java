package java.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public abstract class EventListenerProxy implements EventListener {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:41.383 -0500", hash_original_field = "349D93182B74FDD05AC630535DA0F781", hash_generated_field = "63216795243EEE41ECEC8F741B6ECA5B")

    private  EventListener listener;

    /**
     * Creates a new {@code EventListener} proxy instance.
     *
     * @param listener
     *            the listener wrapped by this proxy.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:41.386 -0500", hash_original_method = "0B02F9CA1E264165C6D771C4F9CE717F", hash_generated_method = "EDB2EDBADCEFDEC3BF6E35D0979AB9F2")
    
public EventListenerProxy(EventListener listener) {
        this.listener = listener;
    }

    /**
     * Returns the wrapped {@code EventListener}.
     *
     * @return the wrapped {@code EventListener}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:41.388 -0500", hash_original_method = "544CEBD256D91351395433E8E1959E7F", hash_generated_method = "26437651E60C6E6FE53A6F9741417A1A")
    
public EventListener getListener() {
        return listener;
    }
    
}

