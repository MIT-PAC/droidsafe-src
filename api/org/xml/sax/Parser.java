package org.xml.sax;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.IOException;
import java.util.Locale;

@Deprecated public interface Parser
{

    
    public abstract void setLocale (Locale locale)
    throws SAXException;


    
    public abstract void setEntityResolver (EntityResolver resolver);


    
    public abstract void setDTDHandler (DTDHandler handler);


    
    public abstract void setDocumentHandler (DocumentHandler handler);


    
    public abstract void setErrorHandler (ErrorHandler handler);


    
    public abstract void parse (InputSource source)
    throws SAXException, IOException;


    
    public abstract void parse (String systemId)
    throws SAXException, IOException;

}
