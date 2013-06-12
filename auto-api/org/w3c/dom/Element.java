package org.w3c.dom;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public interface Element extends Node {
    
    public String getTagName();

    
    public String getAttribute(String name);

    
    public void setAttribute(String name,
                             String value)
                             throws DOMException;

    
    public void removeAttribute(String name)
                                throws DOMException;

    
    public Attr getAttributeNode(String name);

    
    public Attr setAttributeNode(Attr newAttr)
                                 throws DOMException;

    
    public Attr removeAttributeNode(Attr oldAttr)
                                    throws DOMException;

    
    public NodeList getElementsByTagName(String name);

    
    public String getAttributeNS(String namespaceURI,
                                 String localName)
                                 throws DOMException;

    
    public void setAttributeNS(String namespaceURI,
                               String qualifiedName,
                               String value)
                               throws DOMException;

    
    public void removeAttributeNS(String namespaceURI,
                                  String localName)
                                  throws DOMException;

    
    public Attr getAttributeNodeNS(String namespaceURI,
                                   String localName)
                                   throws DOMException;

    
    public Attr setAttributeNodeNS(Attr newAttr)
                                   throws DOMException;

    
    public NodeList getElementsByTagNameNS(String namespaceURI,
                                           String localName)
                                           throws DOMException;

    
    public boolean hasAttribute(String name);

    
    public boolean hasAttributeNS(String namespaceURI,
                                  String localName)
                                  throws DOMException;

    
    public TypeInfo getSchemaTypeInfo();

    
    public void setIdAttribute(String name,
                               boolean isId)
                               throws DOMException;

    
    public void setIdAttributeNS(String namespaceURI,
                                 String localName,
                                 boolean isId)
                                 throws DOMException;

    
    public void setIdAttributeNode(Attr idAttr,
                                   boolean isId)
                                   throws DOMException;

}

