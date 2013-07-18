package android.view.accessibility;

// Droidsafe Imports

public interface AccessibilityEventSource {

    
    public void sendAccessibilityEvent(int eventType);

    
    public void sendAccessibilityEventUnchecked(AccessibilityEvent event);
}
