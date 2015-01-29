package org.w3c.dom;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface Node {
    
    public static final short ELEMENT_NODE              = 1;
    
    public static final short ATTRIBUTE_NODE            = 2;
    
    public static final short TEXT_NODE                 = 3;
    
    public static final short CDATA_SECTION_NODE        = 4;
    
    public static final short ENTITY_REFERENCE_NODE     = 5;
    
    public static final short ENTITY_NODE               = 6;
    
    public static final short PROCESSING_INSTRUCTION_NODE = 7;
    
    public static final short COMMENT_NODE              = 8;
    
    public static final short DOCUMENT_NODE             = 9;
    
    public static final short DOCUMENT_TYPE_NODE        = 10;
    
    public static final short DOCUMENT_FRAGMENT_NODE    = 11;
    
    public static final short NOTATION_NODE             = 12;
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public String getNodeName();
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public String getNodeValue()
                              throws DOMException;
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public void setNodeValue(String nodeValue)
                              throws DOMException;
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public short getNodeType();
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public Node getParentNode();
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public NodeList getChildNodes();
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public Node getFirstChild();
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public Node getLastChild();
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public Node getPreviousSibling();
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public Node getNextSibling();
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public NamedNodeMap getAttributes();
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public Document getOwnerDocument();
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public Node insertBefore(Node newChild,
                             Node refChild)
                             throws DOMException;
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public Node replaceChild(Node newChild,
                             Node oldChild)
                             throws DOMException;
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public Node removeChild(Node oldChild)
                            throws DOMException;
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public Node appendChild(Node newChild)
                            throws DOMException;
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public boolean hasChildNodes();
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public Node cloneNode(boolean deep);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public void normalize();
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public boolean isSupported(String feature,
                               String version);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public String getNamespaceURI();
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public String getPrefix();
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public void setPrefix(String prefix)
                               throws DOMException;
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public String getLocalName();
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public boolean hasAttributes();
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public String getBaseURI();
    
    public static final short DOCUMENT_POSITION_DISCONNECTED = 0x01;
    
    public static final short DOCUMENT_POSITION_PRECEDING = 0x02;
    
    public static final short DOCUMENT_POSITION_FOLLOWING = 0x04;
    
    public static final short DOCUMENT_POSITION_CONTAINS = 0x08;
    
    public static final short DOCUMENT_POSITION_CONTAINED_BY = 0x10;
    
    public static final short DOCUMENT_POSITION_IMPLEMENTATION_SPECIFIC = 0x20;
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public short compareDocumentPosition(Node other)
                                         throws DOMException;
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public String getTextContent()
                                         throws DOMException;
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public void setTextContent(String textContent)
                                         throws DOMException;
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public boolean isSameNode(Node other);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public String lookupPrefix(String namespaceURI);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public boolean isDefaultNamespace(String namespaceURI);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public String lookupNamespaceURI(String prefix);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public boolean isEqualNode(Node arg);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public Object getFeature(String feature,
                             String version);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public Object setUserData(String key,
                              Object data,
                              UserDataHandler handler);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public Object getUserData(String key);

}
