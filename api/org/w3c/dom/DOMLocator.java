package org.w3c.dom;

// Droidsafe Imports

public interface DOMLocator {
    
    public int getLineNumber();

    
    public int getColumnNumber();

    
    public int getByteOffset();

    
    public int getUtf16Offset();

    
    public Node getRelatedNode();

    
    public String getUri();

}
