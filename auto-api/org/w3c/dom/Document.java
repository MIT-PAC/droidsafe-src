package org.w3c.dom;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public interface Document extends Node {
    
    public DocumentType getDoctype();

    
    public DOMImplementation getImplementation();

    
    public Element getDocumentElement();

    
    public Element createElement(String tagName)
                                 throws DOMException;

    
    public DocumentFragment createDocumentFragment();

    
    public Text createTextNode(String data);

    
    public Comment createComment(String data);

    
    public CDATASection createCDATASection(String data)
                                           throws DOMException;

    
    public ProcessingInstruction createProcessingInstruction(String target,
                                                             String data)
                                                             throws DOMException;

    
    public Attr createAttribute(String name)
                                throws DOMException;

    
    public EntityReference createEntityReference(String name)
                                                 throws DOMException;

    
    public NodeList getElementsByTagName(String tagname);

    
    public Node importNode(Node importedNode,
                           boolean deep)
                           throws DOMException;

    
    public Element createElementNS(String namespaceURI,
                                   String qualifiedName)
                                   throws DOMException;

    
    public Attr createAttributeNS(String namespaceURI,
                                  String qualifiedName)
                                  throws DOMException;

    
    public NodeList getElementsByTagNameNS(String namespaceURI,
                                           String localName);

    
    public Element getElementById(String elementId);

    
    public String getInputEncoding();

    
    public String getXmlEncoding();

    
    public boolean getXmlStandalone();
    
    public void setXmlStandalone(boolean xmlStandalone)
                                  throws DOMException;

    
    public String getXmlVersion();
    
    public void setXmlVersion(String xmlVersion)
                                  throws DOMException;

    
    public boolean getStrictErrorChecking();
    
    public void setStrictErrorChecking(boolean strictErrorChecking);

    
    public String getDocumentURI();
    
    public void setDocumentURI(String documentURI);

    
    public Node adoptNode(Node source)
                          throws DOMException;

    
    public DOMConfiguration getDomConfig();

    
    public void normalizeDocument();

    
    public Node renameNode(Node n,
                           String namespaceURI,
                           String qualifiedName)
                           throws DOMException;

}

