package org.w3c.dom;

// Droidsafe Imports

public interface Attr extends Node {
    
    public String getName();

    
    public boolean getSpecified();

    
    public String getValue();
    
    public void setValue(String value)
                            throws DOMException;

    
    public Element getOwnerElement();

    
    public TypeInfo getSchemaTypeInfo();

    
    public boolean isId();

}
