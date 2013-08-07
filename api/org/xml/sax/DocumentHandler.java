package org.xml.sax;

// Droidsafe Imports
import droidsafe.annotations.*;

@Deprecated public interface DocumentHandler {


    
    public abstract void setDocumentLocator (Locator locator);


    
    public abstract void startDocument ()
    throws SAXException;


    
    public abstract void endDocument ()
    throws SAXException;


    
    public abstract void startElement (String name, AttributeList atts)
    throws SAXException;


    
    public abstract void endElement (String name)
    throws SAXException;


    
    public abstract void characters (char ch[], int start, int length)
    throws SAXException;


    
    public abstract void ignorableWhitespace (char ch[], int start, int length)
    throws SAXException;


    
    public abstract void processingInstruction (String target, String data)
    throws SAXException;

}
