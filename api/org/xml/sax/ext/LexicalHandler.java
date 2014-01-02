package org.xml.sax.ext;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import org.xml.sax.SAXException;

public interface LexicalHandler
{

    
    public abstract void startDTD (String name, String publicId,
                   String systemId)
    throws SAXException;


    
    public abstract void endDTD ()
    throws SAXException;


    
    public abstract void startEntity (String name)
    throws SAXException;


    
    public abstract void endEntity (String name)
    throws SAXException;


    
    public abstract void startCDATA ()
    throws SAXException;


    
    public abstract void endCDATA ()
    throws SAXException;


    
    public abstract void comment (char ch[], int start, int length)
    throws SAXException;

}
