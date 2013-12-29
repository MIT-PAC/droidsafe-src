package org.xml.sax;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;

public interface XMLReader
{


    
    
    


    
    public boolean getFeature (String name)
        throws SAXNotRecognizedException, SAXNotSupportedException;


    
    public void setFeature (String name, boolean value)
    throws SAXNotRecognizedException, SAXNotSupportedException;


    
    public Object getProperty (String name)
    throws SAXNotRecognizedException, SAXNotSupportedException;


    
    public void setProperty (String name, Object value)
    throws SAXNotRecognizedException, SAXNotSupportedException;



    
    
    


    
    public void setEntityResolver (EntityResolver resolver);


    
    public EntityResolver getEntityResolver ();


    
    public void setDTDHandler (DTDHandler handler);


    
    public DTDHandler getDTDHandler ();


    
    public void setContentHandler (ContentHandler handler);


    
    public ContentHandler getContentHandler ();


    
    public void setErrorHandler (ErrorHandler handler);


    
    public ErrorHandler getErrorHandler ();



    
    
    

    
    public void parse (InputSource input)
    throws IOException, SAXException;


    
    public void parse (String systemId)
    throws IOException, SAXException;

}
