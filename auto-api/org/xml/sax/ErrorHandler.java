package org.xml.sax;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public interface ErrorHandler {


    
    public abstract void warning (SAXParseException exception)
    throws SAXException;


    
    public abstract void error (SAXParseException exception)
    throws SAXException;


    
    public abstract void fatalError (SAXParseException exception)
    throws SAXException;

}
