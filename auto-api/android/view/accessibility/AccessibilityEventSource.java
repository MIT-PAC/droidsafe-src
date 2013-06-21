package android.view.accessibility;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public interface AccessibilityEventSource {

    
    public void sendAccessibilityEvent(int eventType);

    
    public void sendAccessibilityEventUnchecked(AccessibilityEvent event);
}
