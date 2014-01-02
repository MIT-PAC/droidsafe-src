package org.xml.sax;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;

public interface EntityResolver {


    
    public abstract InputSource resolveEntity (String publicId,
                           String systemId)
    throws SAXException, IOException;

}
