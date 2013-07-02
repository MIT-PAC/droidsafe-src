package android.view.accessibility;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public interface AccessibilityEventSource {

    
    public void sendAccessibilityEvent(int eventType);

    
    public void sendAccessibilityEventUnchecked(AccessibilityEvent event);
}
