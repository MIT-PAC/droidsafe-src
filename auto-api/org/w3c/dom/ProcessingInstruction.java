package org.w3c.dom;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public interface ProcessingInstruction extends Node {
    
    public String getTarget();

    
    public String getData();
    
    public void setData(String data)
                                   throws DOMException;

}
