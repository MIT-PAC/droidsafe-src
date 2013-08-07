package android.view.accessibility;

// Droidsafe Imports
import droidsafe.annotations.*;

public interface AccessibilityEventSource {

    
    public void sendAccessibilityEvent(int eventType);

    
    public void sendAccessibilityEventUnchecked(AccessibilityEvent event);
}
