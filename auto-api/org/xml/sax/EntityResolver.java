package org.xml.sax;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.io.IOException;

public interface EntityResolver {


    
    public abstract InputSource resolveEntity (String publicId,
                           String systemId)
    throws SAXException, IOException;

}

