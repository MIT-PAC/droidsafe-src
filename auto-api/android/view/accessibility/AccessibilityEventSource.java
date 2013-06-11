package android.view.accessibility;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public interface AccessibilityEventSource {

    
    public void sendAccessibilityEvent(int eventType);

    
    public void sendAccessibilityEventUnchecked(AccessibilityEvent event);
}

