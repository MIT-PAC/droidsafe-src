package org.apache.http;

// Droidsafe Imports
import droidsafe.annotations.*;

public interface Header {

    String getName();
    
    String getValue();

    HeaderElement[] getElements() throws ParseException;
    
}
