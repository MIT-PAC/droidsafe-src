package org.w3c.dom;

// Droidsafe Imports

public interface NamedNodeMap {
    
    public Node getNamedItem(String name);

    
    public Node setNamedItem(Node arg)
                             throws DOMException;

    
    public Node removeNamedItem(String name)
                                throws DOMException;

    
    public Node item(int index);

    
    public int getLength();

    
    public Node getNamedItemNS(String namespaceURI,
                               String localName)
                               throws DOMException;

    
    public Node setNamedItemNS(Node arg)
                               throws DOMException;

    
    public Node removeNamedItemNS(String namespaceURI,
                                  String localName)
                                  throws DOMException;

}
