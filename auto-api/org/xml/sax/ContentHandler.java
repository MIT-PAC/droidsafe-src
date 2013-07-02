package org.xml.sax;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public interface ContentHandler
{

    
    public void setDocumentLocator (Locator locator);


    
    public void startDocument ()
    throws SAXException;


    
    public void endDocument()
    throws SAXException;


    
    public void startPrefixMapping (String prefix, String uri)
    throws SAXException;


    
    public void endPrefixMapping (String prefix)
    throws SAXException;


    
    public void startElement (String uri, String localName,
                  String qName, Attributes atts)
    throws SAXException;


    
    public void endElement (String uri, String localName,
                String qName)
    throws SAXException;


    
    public void characters (char ch[], int start, int length)
    throws SAXException;


    
    public void ignorableWhitespace (char ch[], int start, int length)
    throws SAXException;


    
    public void processingInstruction (String target, String data)
    throws SAXException;


    
    public void skippedEntity (String name)
    throws SAXException;
}
