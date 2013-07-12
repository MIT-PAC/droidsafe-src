package java.beans;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.EventListener;

public interface PropertyChangeListener extends EventListener {

    
    public void propertyChange(PropertyChangeEvent event);
}
