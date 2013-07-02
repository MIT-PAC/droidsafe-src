package org.xml.sax;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public interface ErrorHandler {


    
    public abstract void warning (SAXParseException exception)
    throws SAXException;


    
    public abstract void error (SAXParseException exception)
    throws SAXException;


    
    public abstract void fatalError (SAXParseException exception)
    throws SAXException;

}
