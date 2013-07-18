package java.beans;

// Droidsafe Imports
import java.util.EventListener;

public interface PropertyChangeListener extends EventListener {

    
    public void propertyChange(PropertyChangeEvent event);
}
