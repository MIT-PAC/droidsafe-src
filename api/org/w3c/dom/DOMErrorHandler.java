package org.w3c.dom;

// Droidsafe Imports
import droidsafe.annotations.*;

public interface DOMErrorHandler {
    
    public boolean handleError(DOMError error);

}
