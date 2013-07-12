package org.apache.http;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public interface Header {

    String getName();
    
    String getValue();

    HeaderElement[] getElements() throws ParseException;
    
}
