package org.xml.sax;

// Droidsafe Imports

public interface ErrorHandler {


    
    public abstract void warning (SAXParseException exception)
    throws SAXException;


    
    public abstract void error (SAXParseException exception)
    throws SAXException;


    
    public abstract void fatalError (SAXParseException exception)
    throws SAXException;

}
