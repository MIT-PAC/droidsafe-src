package java.beans;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.util.EventListener;

public interface PropertyChangeListener extends EventListener {

    
    public void propertyChange(PropertyChangeEvent event);
}

