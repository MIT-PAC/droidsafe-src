package org.xml.sax;

// Droidsafe Imports
import droidsafe.annotations.*;

public interface DTDHandler {


    
    public abstract void notationDecl (String name,
                       String publicId,
                       String systemId)
    throws SAXException;


    
    public abstract void unparsedEntityDecl (String name,
                         String publicId,
                         String systemId,
                         String notationName)
    throws SAXException;

}
