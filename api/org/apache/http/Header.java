package org.apache.http;

// Droidsafe Imports

public interface Header {

    String getName();
    
    String getValue();

    HeaderElement[] getElements() throws ParseException;
    
}
