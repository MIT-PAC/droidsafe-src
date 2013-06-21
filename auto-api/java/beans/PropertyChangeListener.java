package java.beans;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.EventListener;

public interface PropertyChangeListener extends EventListener {

    
    public void propertyChange(PropertyChangeEvent event);
}
