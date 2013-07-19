package org.w3c.dom;

// Droidsafe Imports

public interface ProcessingInstruction extends Node {
    
    public String getTarget();

    
    public String getData();
    
    public void setData(String data)
                                   throws DOMException;

}
