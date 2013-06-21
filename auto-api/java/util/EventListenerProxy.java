package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public abstract class EventListenerProxy implements EventListener {
    private EventListener listener;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.998 -0400", hash_original_method = "0B02F9CA1E264165C6D771C4F9CE717F", hash_generated_method = "DF769CFB4FDFAD64AF1D63940220A091")
    @DSModeled(DSC.SAFE)
    public EventListenerProxy(EventListener listener) {
        dsTaint.addTaint(listener.dsTaint);
        // ---------- Original Method ----------
        //this.listener = listener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.998 -0400", hash_original_method = "544CEBD256D91351395433E8E1959E7F", hash_generated_method = "4424674BE04CB57AC593BC03C0D65DD5")
    @DSModeled(DSC.SAFE)
    public EventListener getListener() {
        return (EventListener)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return listener;
    }

    
}

