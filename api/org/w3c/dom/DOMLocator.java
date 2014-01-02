package org.w3c.dom;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface DOMLocator {
    
    public int getLineNumber();

    
    public int getColumnNumber();

    
    public int getByteOffset();

    
    public int getUtf16Offset();

    
    public Node getRelatedNode();

    
    public String getUri();

}
