package org.w3c.dom;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public interface NodeList {
    
    public Node item(int index);

    
    public int getLength();

}
