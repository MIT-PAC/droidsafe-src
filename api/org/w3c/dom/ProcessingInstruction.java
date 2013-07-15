package org.w3c.dom;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public interface ProcessingInstruction extends Node {
    
    public String getTarget();

    
    public String getData();
    
    public void setData(String data)
                                   throws DOMException;

}
